package com.bytedance.apm.util;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static float f1489a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f1490b;
    private static int c;
    private static boolean d;
    private static int e;
    private static int f;

    static {
        f();
    }

    public static float a() {
        return f1489a;
    }

    private static int a(float r2) {
        if (Math.abs(r2 - 60.0f) >= 5.1f) goto L7;
        return 60;
    L7:
        if (Math.abs(r2 - 90.0f) >= 5.1f) goto L11;
        return 90;
    L11:
        if (Math.abs(r2 - 120.0f) >= 5.1f) goto L15;
        return 120;
    L15:
        return (int) r2;
    }

    static /* synthetic */ void a(Activity r2) {
        b((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin"));
    }

    public static int b() {
        return f1490b;
    }

    private static void b(Activity r2) {
        Activity r3 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return;
    L5:
        float r4 = r3.getWindowManager().getDefaultDisplay().getRefreshRate();
        e = a(r4);
        if (com.bytedance.apm.b.x() == true) goto L8;
        return;
    L8:
        int r5 = a(r4);
        f1490b = r5;
        if (r5 != c) goto L11;
        boolean r0 = true;
    L12:
        d = r0;
        f1489a = 1000.0f / r5;
        return;
    L11:
        r0 = false;
        goto L12
    }

    public static int c() {
        return c;
    }

    public static boolean d() {
        return d;
    }

    public static int e() {
        return f;
    }

    private static void f() {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        ActivityLifeObserver.getInstance().register(new AnonymousClass1());
        float r3 = 0.0f;
        int r7 = 0;
        boolean r8 = false;
        if (com.bytedance.apm.b.x() == true) goto L5;
    L19:
        c = 60;
        f1490b = 60;
        d = true;
        f1489a = 1000.0f / 60;
        f = 60;
        e = 60;
        if (Build.VERSION.SDK_INT < 23) goto L36;
        if (r0 == null) goto L37;
        Display r1 = ((WindowManager) ZeusTransformUtils.preCheckCast(r0.getSystemService("window"), WindowManager.class, "com.obric.memorydata.plugin")).getDefaultDisplay();
        e = a(r1.getRefreshRate());
        Display.Mode[] r2 = r1.getSupportedModes();
        int r4 = r2.length;
    L23:
        if (r7 >= r4) goto L28;
        float r5 = r2[r7].getRefreshRate();
        if (r5 <= r3) goto L27;
        r3 = r5;
    L27:
        r7 = r7 + 1;
        goto L23
    L28:
        f = a(r3);
        return;
    L37:
        return;
    L36:
        return;
    L5:
        if (Build.VERSION.SDK_INT < 23) goto L19;
        if (r0 == null) goto L19;
        Display r6 = ((WindowManager) ZeusTransformUtils.preCheckCast(r0.getSystemService("window"), WindowManager.class, "com.obric.memorydata.plugin")).getDefaultDisplay();
        float r9 = r6.getRefreshRate();
        Display.Mode[] r10 = r6.getSupportedModes();
        int r11 = r10.length;
        int r12 = 0;
    L9:
        if (r12 >= r11) goto L14;
        float r13 = r10[r12].getRefreshRate();
        if (r13 <= r3) goto L13;
        r3 = r13;
    L13:
        r12 = r12 + 1;
        goto L9
    L14:
        int r14 = a(r9);
        f1490b = r14;
        e = r14;
        int r15 = a(r3);
        c = r15;
        int r16 = f1490b;
        if (r16 != r15) goto L17;
        r8 = true;
    L17:
        d = r8;
        f1489a = 1000.0f / r16;
    }
}
