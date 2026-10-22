package com.facebook.common.statfs;

import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import com.facebook.common.internal.Throwables;
import com.facebook.common.logging.FLog;
import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes2.dex */
public class StatFsHelper {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static StatFsHelper f7679h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final long f7680i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile StatFs f7681a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile File f7682b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile StatFs f7683c;
    public volatile File d;
    public long e;
    public final ReentrantLock f;
    public volatile boolean g;

    public static final enum StorageType extends Enum<StorageType> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final StorageType f7684a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final StorageType f7685b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ StorageType[] f7686c = null;

        static {
            StorageType r5 = new StorageType("INTERNAL", 0);
            f7684a = r5;
            StorageType r10 = new StorageType("EXTERNAL", 1);
            f7685b = r10;
            f7686c = new StorageType[]{r5, r10};
        }

        public StorageType(String r5, int r10) {
            super(r5, r10);
        }

        public static StorageType valueOf(String r5) {
            return (StorageType) Enum.valueOf(StorageType.class, r5);
        }

        public static StorageType[] values() {
            return (StorageType[]) f7686c.clone();
        }
    }

    static {
        f7680i = TimeUnit.MINUTES.toMillis(2);
    }

    public StatFsHelper() {
        this.f7681a = null;
        this.f7683c = null;
        this.g = false;
        this.f = new ReentrantLock();
    }

    public final void a() {
        if (this.g == true) goto L5;
    L6:
        this.f.lock();
    L12:
        th = move-exception;
        this.f.unlock();
        throw th;
    L8:
        if (this.g == true) goto L10;
    L14:
        this.f7682b = Environment.getDataDirectory();     // Catch: Throwable -> L12
        this.d = Environment.getExternalStorageDirectory();     // Catch: Throwable -> L12 ArrayIndexOutOfBoundsException -> L17
    L18:
        this.f7681a = a(this.f7681a, this.f7682b);     // Catch: Throwable -> L12
        this.f7683c = a(this.f7683c, this.d);     // Catch: Throwable -> L12
        this.e = SystemClock.uptimeMillis();     // Catch: Throwable -> L12
        this.g = true;     // Catch: Throwable -> L12
    L19:
        this.f.unlock();
        return;
    L17:
        FLog.b("StatFsHelper", "getExternalStorageDirectory return null");     // Catch: Throwable -> L12
        goto L18
    L10:
        if (this.d != null) goto L19;
    L5:
        if (this.d == null) goto L6;
    }

    public final boolean a(StorageType r5, long r10) {
        a();
        a();
        if (this.f.tryLock() == false) goto L14;
    L8:
        th = move-exception;
        this.f.unlock();
        throw th;
    L5:
        if ((SystemClock.uptimeMillis() - this.e) <= f7680i) goto L10;
        this.f7681a = a(this.f7681a, this.f7682b);     // Catch: Throwable -> L8
        this.f7683c = a(this.f7683c, this.d);     // Catch: Throwable -> L8
        this.e = SystemClock.uptimeMillis();     // Catch: Throwable -> L8
    L10:
        this.f.unlock();
    L14:
        if (r5 != StorageType.f7684a) goto L16;
        StatFs r11 = this.f7681a;
    L18:
        if (r11 == null) goto L20;
        long r12 = r11.getAvailableBlocksLong() * r11.getBlockSizeLong();
    L22:
        if (r12 > 0) goto L24;
        return true;
    L24:
        if (r12 >= r10) goto L26;
        return true;
    L26:
        return false;
    L20:
        r12 = 0;
        goto L22
    L16:
        r11 = this.f7683c;
        goto L18
    }

    public static StatFs a(StatFs r5, File r10) {
        if (r10 != null) goto L5;
    L16:
        return null;
    L5:
        if (r10.exists() == false) goto L16;
        if (r5 == null) goto L9;
        r5.restat(r10.getAbsolutePath());     // Catch: Throwable -> L10 IllegalArgumentException -> L17
        return r5;
    L9:
        return new StatFs(r10.getAbsolutePath());
    L10:
        th = move-exception;
        Throwables.a(th, Error.class);
        Throwables.a(th, RuntimeException.class);
        throw new RuntimeException(th);
    }
}
