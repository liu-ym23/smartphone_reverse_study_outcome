package com.bytedance.awemeopen.infra.plugs.settings.dao;

import android.content.Context;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.awemeopen.infra.base.npth.AoExceptionReporter;
import com.bytedance.awemeopen.infra.base.npth.ErrorPriority;
import com.bytedance.awemeopen.infra.plugs.settings.SettingsModel;
import com.bytedance.awemeopen.infra.util.f;
import com.bytedance.awemeopen.servicesapi.npth.AoNpthService;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\t\b\u0017\u0018\u0000 %2\u00020\u0001:\u0001&B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0002¢\u0006\u0004\b#\u0010$J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\fH\u0016J\u0006\u0010\u0010\u001a\u00020\u0005J\b\u0010\u0011\u001a\u00020\fH\u0014R\u001a\u0010\b\u001a\u00020\u00078\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\b\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u00028\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001d\u001a\u00020\n8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u001f\u001a\u00020\u001e8\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"¨\u0006'"}, d2 = {"Lcom/bytedance/awemeopen/infra/plugs/settings/dao/AoSettingsDao;", "", "", "readFileString", "content", "", "writeFileString", "Landroid/content/Context;", "context", "bdpAppId", "Ljava/io/File;", "createSettingFile", "Lcom/bytedance/awemeopen/infra/plugs/settings/SettingsModel;", "loadSettingsModel", "model", "saveSettingsModel", "clear", "emptyModel", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "mBdpAppId", "Ljava/lang/String;", "getMBdpAppId", "()Ljava/lang/String;", "mFile$delegate", "Lkotlin/Lazy;", "getMFile", "()Ljava/io/File;", "mFile", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "rwLock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "getRwLock", "()Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "Companion", "a", "ao_plugin_settings_release"}, k = 1, mv = {1, 7, 1})
public class AoSettingsDao {
    private static final String BASE_DIR_PATH = "awemeopen/settings";
    public static final a Companion = null;
    private static final String TAG = "AoSettingsDao";
    private static final long TIME_OUT = 500;
    private final Context context;
    private final String mBdpAppId;
    private final Lazy mFile$delegate;
    private final ReentrantReadWriteLock rwLock;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    private final synchronized String readFileString() {
        monitor-enter(this);
    L22:
        th = move-exception;
        throw th;
    L25:
        if (this.rwLock.readLock().tryLock(TIME_OUT, TimeUnit.MILLISECONDS) == true) goto L26;
        AoLogger.c(TAG, new Object[]{"read lock failed: " + this.mBdpAppId});     // Catch: Throwable -> L22
        AoNpthService r0 = AoExceptionReporter.a;     // Catch: Throwable -> L22
        AoExceptionReporter.b(ErrorPriority.p2, TAG, "readFileString_lock", "wait_timeout", 16);     // Catch: Throwable -> L22
        monitor-exit(this);
        return null;
    L26:
        String r1 = f.b(new PolarisFileInputStreamWrapper(getMFile()));     // Catch: Throwable -> L13 Exception -> L15
        this.rwLock.readLock().unlock();     // Catch: Throwable -> L22
        monitor-exit(this);
        return r1;
    L15:
        e = move-exception;
        AoLogger.c(TAG, new Object[]{"read", e});     // Catch: Throwable -> L13
        this.rwLock.readLock().unlock();     // Catch: Throwable -> L22
        return null;
    L13:
        th = move-exception;
        this.rwLock.readLock().unlock();     // Catch: Throwable -> L22
        throw th;     // Catch: Throwable -> L22
    }

    public final boolean clear() {
        return writeFileString("");
    }

    public SettingsModel emptyModel() {
        return new SettingsModel(0, new JSONObject());
    }

    public final File getMFile() {
        return (File) this.mFile$delegate.getValue();
    }

    public SettingsModel loadSettingsModel() {
        String r0 = readFileString();
        if (r0 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == false) goto L12;
        AoLogger.g(TAG, new Object[]{"read empty"});
        return emptyModel();
    L12:
        SettingsModel.Companion.getClass();
        SettingsModel r1 = SettingsModel.a.a(r0);
        if (r1 == null) goto L15;
        return r1;
    L15:
        return emptyModel();
    L5:
        if (r0.length() == 0) goto L8;
        r3 = false;
        goto L9
    }

    public final Context getContext() {
        return this.context;
    }

    public final String getMBdpAppId() {
        return this.mBdpAppId;
    }

    public final ReentrantReadWriteLock getRwLock() {
        return this.rwLock;
    }

    private final boolean writeFileString(String r6) {
        if (this.rwLock.writeLock().tryLock(TIME_OUT, TimeUnit.MILLISECONDS) == true) goto L18;
        AoLogger.c(TAG, new Object[]{"loadSettingsModel lock failed", this.mBdpAppId});
        AoNpthService r7 = AoExceptionReporter.a;
        AoExceptionReporter.b(ErrorPriority.p2, TAG, "writeFileString_lock", "wait_timeout", 16);
        return false;
    L18:
        boolean r8 = f.d(getMFile().getAbsolutePath(), r6);     // Catch: Throwable -> L9 Exception -> L11
        this.rwLock.writeLock().unlock();
        return r8;
    L11:
        e = move-exception;
        AoLogger.c(TAG, new Object[]{"write", e});     // Catch: Throwable -> L9
        this.rwLock.writeLock().unlock();
        return false;
    L9:
        th = move-exception;
        this.rwLock.writeLock().unlock();
        throw th;
    }

    public boolean saveSettingsModel(SettingsModel r2) {
        Intrinsics.checkNotNullParameter(r2, "model");
        return writeFileString(r2.toJson().toString());
    }

    public AoSettingsDao(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "mBdpAppId");
        this.context = r2;
        this.mBdpAppId = r3;
        this.mFile$delegate = LazyKt.lazy(new AoSettingsDao$mFile$2(this));
        this.rwLock = new ReentrantReadWriteLock();
    }

    private final File createSettingFile(Context r4, String r5) {
        PolarisFileWrapper r0 = new PolarisFileWrapper(r4.getFilesDir(), "awemeopen/settings/" + r5 + ".settings");
        if (r0.exists() == false) goto L13;
        return r0;
    L13:
        File r6 = r0.getParentFile();     // Catch: Exception -> L10
        if (r6 == null) goto L8;
        r6.mkdirs();     // Catch: Exception -> L10
    L8:
        r0.createNewFile();     // Catch: Exception -> L10
    L12:
        return r0;
    L10:
        e = move-exception;
        AoLogger.c(TAG, new Object[]{"newFile", e});
        goto L12
    }

    public static final /* synthetic */ File access$createSettingFile(AoSettingsDao r0, Context r1, String r2) {
        return r0.createSettingFile(r1, r2);
    }
}
