package com.bumptech.glide.load.resource.bitmap;

import android.os.Build;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public final class r {
    public static final File e = null;
    public static volatile r f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f1628a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1629b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1630c;
    public boolean d;

    static {
        e = new File("/proc/self/fd");
    }

    public r() {
        this.d = true;
        String r5 = Build.MODEL;
        if (r5 != null) goto L5;
    L8:
        this.f1628a = true;
        this.f1629b = AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH;
        return;
    L5:
        if (r5.length() < 7) goto L8;
        r5.substring(0, 7).getClass();
        goto L8
    }

    public static r a() {
        if (f != null) goto L16;
        monitor-enter(r.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f != null) goto L11;
        f = new r();     // Catch: Throwable -> L9
    L11:
        monitor-exit(r.class);     // Catch: Throwable -> L9
    L16:
        return f;
    }
}
