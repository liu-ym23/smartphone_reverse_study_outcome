package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f866a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f867b = false;
    private static final File c = null;
    private static volatile n d;
    private final int e;
    private int f;
    private boolean g;
    private final AtomicBoolean h;

    static {
        boolean r1 = true;
        if (Build.VERSION.SDK_INT >= 29) goto L5;
        boolean r0 = true;
    L6:
        f866a = r0;
        if (Build.VERSION.SDK_INT >= 28) goto L10;
        r1 = false;
    L10:
        f867b = r1;
        c = new File("/proc/self/fd");
        return;
    L5:
        r0 = false;
        goto L6
    }

    n() {
        this.g = true;
        this.h = new AtomicBoolean(false);
        this.e = AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH;
    }

    public static n a() {
        if (d != null) goto L15;
        monitor-enter(n.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (d != null) goto L9;
        d = new n();     // Catch: Throwable -> L11
    L9:
        monitor-exit(n.class);     // Catch: Throwable -> L11
    L15:
        return d;
    }

    private boolean c() {
        if (f866a == true) goto L5;
    L7:
        return false;
    L5:
        if (this.h.get() == true) goto L7;
        return true;
    }

    private static boolean d() {
        if (Build.VERSION.SDK_INT == 28) goto L5;
        return false;
    L5:
        Iterator r0 = Arrays.asList(new String[]{"GM1900", "GM1901", "GM1903", "GM1911", "GM1915", "ONEPLUS A3000", "ONEPLUS A3010", "ONEPLUS A5010", "ONEPLUS A5000", "ONEPLUS A3003", "ONEPLUS A6000", "ONEPLUS A6003", "ONEPLUS A6010", "ONEPLUS A6013"}).iterator();
    L7:
        if (r0.hasNext() == false) goto L12;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");
        if (Build.MODEL.startsWith(r2) == false) goto L7;
        return true;
    L12:
        return false;
    }

    private int e() {
        if (d() == false) goto L7;
        return 500;
    L7:
        return this.e;
    }

    private synchronized boolean f() {
        monitor-enter(this);
        boolean r1 = true;
        int r0 = this.f + 1;     // Catch: Throwable -> L17
        this.f = r0;     // Catch: Throwable -> L17
        if (r0 < 50) goto L14;
        this.f = 0;     // Catch: Throwable -> L17
        int r2 = c.list().length;     // Catch: Throwable -> L17
        long r3 = e();     // Catch: Throwable -> L17
        if (r2 < r3) goto L9;
        r1 = false;
    L9:
        this.g = r1;     // Catch: Throwable -> L17
        if (r1 == true) goto L14;
        if (Log.isLoggable("Downsampler", 5) == false) goto L14;
        Log.w("Downsampler", "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + r2 + ", limit " + r3);     // Catch: Throwable -> L17
    L14:
        boolean r4 = this.g;     // Catch: Throwable -> L17
        monitor-exit(this);
        return r4;
    L17:
        th = move-exception;
        throw th;
    }

    boolean a(int r1, int r2, BitmapFactory.Options r3, boolean r4, boolean r5) {
        boolean r0 = a(r1, r2, r4, r5);
        if (r0 == false) goto L5;
        r3.inPreferredConfig = Bitmap.Config.HARDWARE;
        r3.inMutable = false;
    L5:
        return r0;
    }

    public boolean a(int r4, int r5, boolean r6, boolean r7) {
        if (r6 == true) goto L9;
        if (Log.isLoggable("HardwareConfig", 2) == false) goto L7;
        Log.v("HardwareConfig", "Hardware config disallowed by caller");
    L7:
        return false;
    L9:
        if (f867b == true) goto L15;
        if (Log.isLoggable("HardwareConfig", 2) == false) goto L13;
        Log.v("HardwareConfig", "Hardware config disallowed by sdk");
    L13:
        return false;
    L15:
        if (c() == true) goto L17;
        if (r7 == true) goto L22;
        if (r4 < 0) goto L37;
        if (r5 < 0) goto L37;
        if (f() == false) goto L31;
        return true;
    L31:
        if (Log.isLoggable("HardwareConfig", 2) == false) goto L33;
        Log.v("HardwareConfig", "Hardware config disallowed because there are insufficient FDs");
    L33:
        return false;
    L37:
        if (Log.isLoggable("HardwareConfig", 2) == false) goto L39;
        Log.v("HardwareConfig", "Hardware config disallowed because of invalid dimensions");
    L39:
        return false;
    L22:
        if (Log.isLoggable("HardwareConfig", 2) == false) goto L24;
        Log.v("HardwareConfig", "Hardware config disallowed because exif orientation is required");
    L24:
        return false;
    L17:
        if (Log.isLoggable("HardwareConfig", 2) == false) goto L19;
        Log.v("HardwareConfig", "Hardware config disallowed by app state");
    L19:
        return false;
    }

    public void b() {
        com.bumptech.glide.util.k.a();
        this.h.set(true);
    }
}
