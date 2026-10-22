package com.bumptech.glide.load.engine.a;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f728a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f729b;
    private final Context c;
    private final int d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final int f730a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Context f731b;
        ActivityManager c;
        c d;
        float e;
        float f;
        float g;
        float h;
        int i;

        static {
            if (Build.VERSION.SDK_INT >= 26) goto L5;
            int r0 = 4;
        L6:
            f730a = r0;
            return;
        L5:
            r0 = 1;
            goto L6
        }

        public a(Context r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
            this.e = 2.0f;
            this.f = f730a;
            this.g = 0.4f;
            this.h = 0.33f;
            this.i = 4194304;
            this.f731b = ZeusTransformUtils.wrapperContext(r5, "com.obric.memorydata.plugin");
            this.c = (ActivityManager) ZeusTransformUtils.preCheckCast(r5.getSystemService("activity"), ActivityManager.class, "com.obric.memorydata.plugin");
            this.d = new b(ZeusTransformUtils.getResources(r5, "com.obric.memorydata.plugin").getDisplayMetrics());
            if (Build.VERSION.SDK_INT >= 26) goto L5;
            return;
        L5:
            if (i.a(this.c) == false) goto L9;
            this.f = 0.0f;
            return;
        }

        public i a() {
            return new i(this);
        }
    }

    private static final class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final DisplayMetrics f732a;

        b(DisplayMetrics r1) {
            this.f732a = r1;
        }

        @Override // com.bumptech.glide.load.engine.a.i.c
        public int a() {
            return this.f732a.widthPixels;
        }

        @Override // com.bumptech.glide.load.engine.a.i.c
        public int b() {
            return this.f732a.heightPixels;
        }
    }

    interface c {
        int a();

        int b();
    }

    i(a r7) {
        this.c = ZeusTransformUtils.wrapperContext(r7.f731b, "com.obric.memorydata.plugin");
        if (a(r7.c) == false) goto L5;
        int r0 = r7.i / 2;
    L6:
        this.d = r0;
        int r1 = a(r7.c, r7.g, r7.h);
        float r2 = (r7.d.a() * r7.d.b()) * 4;
        int r3 = Math.round(r7.f * r2);
        int r4 = Math.round(r2 * r7.e);
        int r5 = r1 - r0;
        int r6 = r4 + r3;
        if (r6 > r5) goto L9;
        this.f729b = r4;
        this.f728a = r3;
    L11:
        if (Log.isLoggable("MemorySizeCalculator", 3) == false) goto L18;
        StringBuilder r8 = new StringBuilder().append("Calculation complete, Calculated memory cache size: ").append(a(this.f729b)).append(", pool size: ").append(a(this.f728a)).append(", byte array size: ").append(a(r0)).append(", memory class limited? ");
        if (r6 <= r1) goto L15;
        boolean r9 = true;
    L16:
        Log.d("MemorySizeCalculator", r8.append(r9).append(", max size: ").append(a(r1)).append(", memoryClass: ").append(r7.c.getMemoryClass()).append(", isLowMemoryDevice: ").append(a(r7.c)).toString());
        return;
    L15:
        r9 = false;
        goto L16
    L18:
        return;
    L9:
        float r10 = r5 / (r7.f + r7.e);
        this.f729b = Math.round(r7.e * r10);
        this.f728a = Math.round(r10 * r7.f);
        goto L11
    L5:
        r0 = r7.i;
        goto L6
    }

    private static int a(ActivityManager r1, float r2, float r3) {
        float r0 = (r1.getMemoryClass() * 1024) * 1024;
        if (a(r1) == false) goto L6;
        r2 = r3;
    L6:
        return Math.round(r0 * r2);
    }

    private String a(int r3) {
        return Formatter.formatFileSize(this.c, r3);
    }

    static boolean a(ActivityManager r2) {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return true;
    L5:
        return r2.isLowRamDevice();
    }

    public int a() {
        return this.f729b;
    }

    public int b() {
        return this.f728a;
    }

    public int c() {
        return this.d;
    }
}
