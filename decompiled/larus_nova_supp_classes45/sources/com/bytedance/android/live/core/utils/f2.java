package com.bytedance.android.live.core.utils;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp;
import com.bytedance.android.livesdk.utils.LiveLoggerUtil;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import java.util.Arrays;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f2 {
    public static String a = "";
    public static long b;

    public static void a() {
        Context r0 = s1.getContext();
        if (r0 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty("已完成加载,下滑切换直播间。") == true) goto L13;
        TextView r2 = (TextView) ((LayoutInflater) r0.getSystemService("layout_inflater")).inflate(2131567761, null);
        if (r2 != null) goto L10;
        return;
    L10:
        Toast r3 = new Toast(r0);
        r3.setView(r2);
        r3.setDuration(1000);
        r2.setText("已完成加载,下滑切换直播间。");
        r3.show();
        LiveLoggerUtil.b.getClass();
        LiveLoggerUtil.a("已完成加载,下滑切换直播间。");
        return;
    }

    public static void g() {
        jc1.a.b();
        if (v.a() == false) goto L6;
        LocalTestManager.a(new Class[]{wy.a.class});
        return;
    }

    public static void f(String r2) {
        Context r0 = s1.getContext();
        if (r0 != null) goto L5;
        return;
    L5:
        Toast.makeText(r0, r2, 0).show();
        LiveLoggerUtil.b.getClass();
        LiveLoggerUtil.a(r2);
    }

    public static void b(int r1, int r2) {
        Context r0 = s1.getContext();
        if (r0 != null) goto L5;
        return;
    L5:
        c(r0.getString(r1), r2);
    }

    public static void c(final String r8, final int r9) {
        if (Looper.getMainLooper() == Looper.myLooper()) goto L6;
        UtilityKotlinExtentionsKt.s(0, false, false, new e2(r8, r9), 7);
        return;
    L6:
        Context r0 = s1.getContext();
        if (r0 != null) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty(r8) == false) goto L12;
        return;
    L12:
        if (jc1.k.f(IMiddlewareHostApp.class) == null) goto L14;
        jc1.k.f(IMiddlewareHostApp.class).centerToast(r0, r8, r9);
        return;
    L14:
        Toast r11 = Toast.makeText(r0, r8, r9);
        r11.setGravity(17, 0, 0);
        r11.show();
        LiveLoggerUtil.b.getClass();
        LiveLoggerUtil.a(r8);
    }

    public static void d(String r4, int r5) {
        Context r0 = s1.getContext();
        if (r0 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r4) == true) goto L19;
        TextView r1 = (TextView) ((LayoutInflater) r0.getSystemService("layout_inflater")).inflate(2131567761, null);
        if (r1 == null) goto L20;
        Toast r2 = new Toast(r0);
        r2.setGravity(17, 0, 0);
        r2.setView(r1);
        r2.setDuration(r5);
        r1.setText(r4);
        r2.show();     // Catch: NullPointerException -> L13
        LiveLoggerUtil.b.getClass();     // Catch: NullPointerException -> L13
        LiveLoggerUtil.a(r4);     // Catch: NullPointerException -> L13
        return;
    L13:
        e = move-exception;
        ALogger.e("ToastUtil", "toastBySdk" + e.getMessage());
        return;
    L20:
        return;
    }

    public static void j(String r2, int r3) {
        Context r0 = s1.getContext();
        if (r0 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r2) == true) goto L13;
        Toast r1 = Toast.makeText(r0, r2, 0);
        if (r1 == null) goto L12;
        r1.setGravity(r3, 0, 0);
        r1.show();
        LiveLoggerUtil.b.getClass();
        LiveLoggerUtil.a(r2);
        return;
    L12:
        return;
    }

    public static void h(Context r0, int r1, int r2) {
        if (r0 != null) goto L4;
        r0 = s1.getContext();
    L4:
        i(r0, r0.getString(r1), r2);
    }

    public static void i(Context r1, String r2, int r3) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r2) == false) goto L7;
        return;
    L7:
        if (jc1.k.f(IMiddlewareHostApp.class) == null) goto L9;
        jc1.k.f(IMiddlewareHostApp.class).systemToast(r1, r2, r3);
        return;
    L9:
        Toast.makeText(r1, r2, r3).show();
        LiveLoggerUtil.b.getClass();
        LiveLoggerUtil.a(r2);
    }

    public static void e(Context r6, String r7, String r8, String r9) {
        if (TextUtils.isEmpty(r8) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r9) == true) goto L24;
        String r0 = r8.concat(r9);
        if (r0.equals(a) == true) goto L10;
    L11:
        a = r0;
        b = System.currentTimeMillis();
        if (TextUtils.isEmpty(r7) == false) goto L14;
        View r11 = LayoutInflater.from(r6).inflate(2131567405, null);
    L18:
        if (r11 != null) goto L20;
        return;
    L20:
        TextView r1 = (TextView) r11.findViewById(2131388953);
        TextView r3 = (TextView) r11.findViewById(2131388951);
        r1.setText(r8);
        r3.setText(r9);
        Toast r12 = new Toast(r6);
        r12.setView(r11);
        r12.setGravity(17, 0, 0);
        r12.setDuration(0);
        r12.show();
        LiveLoggerUtil.b.getClass();
        LiveLoggerUtil.a(r0);
        return;
    L14:
        View r2 = LayoutInflater.from(r6).inflate(2131567404, null);
        if (r2 == null) goto L17;
        HSImageView r4 = (HSImageView) r2.findViewById(2131388948);
        py.k r5 = (py.k) vh7.f.c(py.k.class);
        r5.setUrls(Arrays.asList(new String[]{r7}));
        ImageLoader.bindImage(r4, r5);
    L17:
        r11 = r2;
        goto L18
    L10:
        if ((System.currentTimeMillis() - b) > 2500) goto L11;
        return;
    }
}
