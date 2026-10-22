package com.bytedance.apm.util;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;
import androidx.fragment.app.Fragment;
import com.bytedance.apm.core.ActivityLifeObserver;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static float f1131a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f1132b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f1133c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f1134d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f1135e;

    static class a implements t4.d {
        a() {
        }

        @Override // t4.d
        public void onActivityCreated(Activity r10, Bundle r11) {
        }

        @Override // t4.d
        public void onActivityPause(Activity r10) {
        }

        @Override // t4.d
        public void onActivityResume(Activity r10) {
        }

        @Override // t4.d
        public void onActivityStarted(Activity r10) {
        }

        @Override // t4.d
        public void onBackground(Activity r10) {
        }

        @Override // t4.d
        public void onChange(Activity r10, Fragment r11) {
        }

        @Override // t4.d
        public void onFront(Activity r10) {
            g.a(r10);
        }
    }

    static {
        g();
    }

    static /* synthetic */ void a(Activity r10) {
        i(r10);
    }

    public static int b() {
        return f1133c;
    }

    public static float c() {
        return f1131a;
    }

    public static int d() {
        return f1135e;
    }

    public static int e() {
        return f1132b;
    }

    private static int f(float r10) {
        if (Math.abs(r10 - 60.0f) >= 5.1f) goto L7;
        return 60;
    L7:
        if (Math.abs(r10 - 90.0f) >= 5.1f) goto L11;
        return 90;
    L11:
        if (Math.abs(r10 - 120.0f) >= 5.1f) goto L15;
        return 120;
    L15:
        return (int) r10;
    }

    private static void g() {
        Context r10 = com.bytedance.apm.d.g();
        ActivityLifeObserver.getInstance().register(new a());
        float r11 = 0.0f;
        int r12 = 0;
        boolean r13 = false;
        if (com.bytedance.apm.d.m0() == true) goto L5;
    L19:
        f1133c = 60;
        f1132b = 60;
        f1134d = true;
        f1131a = 1000.0f / 60;
        f1135e = 60;
        if (Build.VERSION.SDK_INT < 23) goto L36;
        if (r10 == null) goto L37;
        Display r14 = ((WindowManager) r10.getSystemService("window")).getDefaultDisplay();
        f(r14.getRefreshRate());
        Display.Mode[] r15 = r14.getSupportedModes();
        int r16 = r15.length;
    L23:
        if (r12 >= r16) goto L28;
        float r17 = r15[r12].getRefreshRate();
        if (r17 <= r11) goto L27;
        r11 = r17;
    L27:
        r12 = r12 + 1;
        goto L23
    L28:
        f1135e = f(r11);
        return;
    L37:
        return;
    L36:
        return;
    L5:
        if (Build.VERSION.SDK_INT < 23) goto L19;
        if (r10 == null) goto L19;
        Display r18 = ((WindowManager) r10.getSystemService("window")).getDefaultDisplay();
        float r19 = r18.getRefreshRate();
        Display.Mode[] r20 = r18.getSupportedModes();
        int r21 = r20.length;
        int r22 = 0;
    L9:
        if (r22 >= r21) goto L14;
        float r23 = r20[r22].getRefreshRate();
        if (r23 <= r11) goto L13;
        r11 = r23;
    L13:
        r22 = r22 + 1;
        goto L9
    L14:
        f1132b = f(r19);
        int r24 = f(r11);
        f1133c = r24;
        int r25 = f1132b;
        if (r25 != r24) goto L17;
        r13 = true;
    L17:
        f1134d = r13;
        f1131a = 1000.0f / r25;
    }

    public static boolean h() {
        return f1134d;
    }

    private static void i(Activity r10) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return;
    L5:
        float r11 = r10.getWindowManager().getDefaultDisplay().getRefreshRate();
        f(r11);
        if (com.bytedance.apm.d.m0() == true) goto L8;
        return;
    L8:
        int r12 = f(r11);
        f1132b = r12;
        if (r12 != f1133c) goto L11;
        boolean r13 = true;
    L12:
        f1134d = r13;
        f1131a = 1000.0f / r12;
        return;
    L11:
        r13 = false;
        goto L12
    }
}
