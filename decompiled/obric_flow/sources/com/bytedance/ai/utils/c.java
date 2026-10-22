package com.bytedance.ai.utils;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import com.bytedance.ai.model.p;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.h0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c implements t0.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static t0.d f2846a;

    public static int a(double r5, Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        return (int) ((r5 / ((double) r10.getResources().getDisplayMetrics().density)) + ((double) 0.5f));
    }

    public static int b(Context r10) {
        Resources r5 = null;
        Class<?> r11 = Class.forName("android.os.SystemProperties");     // Catch: Exception -> L30
        Object r12 = r11.getMethod("get", new Class[]{String.class}).invoke(r11, new Object[]{"qemu.hw.mainkeys"});     // Catch: Exception -> L30
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.String");     // Catch: Exception -> L30
        String r13 = (String) r12;     // Catch: Exception -> L30
        if (Intrinsics.areEqual(IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST, r13) == true) goto L18;
        if (Intrinsics.areEqual("0", r13) == false) goto L9;
        boolean r14 = true;
    L19:
        if (r14 == true) goto L21;
        return 0;
    L21:
        if (r10 == null) goto L23;
        r5 = r10.getResources();
    L23:
        if (r5 == null) goto L25;
        int r15 = r5.getIdentifier("navigation_bar_height", "dimen", "android");
    L26:
        if (r15 <= 0) goto L33;
        if (r5 != null) goto L29;
        return 0;
    L29:
        return r5.getDimensionPixelSize(r15);
    L33:
        return 0;
    L25:
        r15 = 0;
    L18:
        r14 = false;
    L9:
        if (r10 == null) goto L11;
        Resources r16 = r10.getResources();
    L12:
        if (r16 == null) goto L14;
        int r17 = r16.getIdentifier("config_showNavigationBar", "bool", "android");
    L15:
        if (r17 <= 0) goto L18;
        if (r16 == null) goto L18;
        r14 = r16.getBoolean(r17);
        goto L19
    L14:
        r17 = 0;
        goto L15
    L11:
        r16 = null;
        goto L12
    }

    public static int c(Context r5, double r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        if (r5.getResources() != null) goto L5;
        return 0;
    L5:
        if (r5.getResources().getDisplayMetrics() != null) goto L7;
        return 0;
    L7:
        return (int) ((r10 * ((double) r5.getResources().getDisplayMetrics().density)) + ((double) 0.5f));
    }

    public static int d(Number r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return (int) ((r5.floatValue() * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static final long e(File r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        long r5 = 0;
        if (r10.exists() == false) goto L13;
        File[] r11 = r10.listFiles();
        if (r11 == null) goto L13;
        int r12 = r11.length;
        int r13 = 0;
    L7:
        if (r13 >= r12) goto L13;
        File r14 = r11[r13];
        if (r14.isDirectory() == false) goto L11;
        Intrinsics.checkNotNull(r14);
        long r15 = e(r14);
    L12:
        r5 = r5 + r15;
        r13 = r13 + 1;
        goto L7
    L11:
        r15 = r14.length();
    L13:
        return r5;
    }

    public static DisplayMetrics f(Window r5) {
        DisplayMetrics r10 = new DisplayMetrics();
        WindowManager r11 = r5.getWindowManager();
        if (r11 == null) goto L7;
        Display r12 = r11.getDefaultDisplay();
        if (r12 == null) goto L7;
        r12.getRealMetrics(r10);
    L7:
        return r10;
    }

    public static final void g(LifecycleRegistry r10, Lifecycle.Event r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "event");
        BuildersKt.launch$default(h0.a(t2.b.d), null, null, new LifecycleRegistryExtKt$changeTo$1(r11, r10, null), 3, null);
    }

    public static final void h(InputStream r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "inputStream");
        Intrinsics.checkNotNullParameter(r10, "destFile");
        FileOutputStream r11 = new FileOutputStream(r10);
        byte[] r12 = new byte[1024];     // Catch: Throwable -> L7
    L4:
        int r13 = r5.read(r12);     // Catch: Throwable -> L7
        if (r13 <= 0) goto L9;
        r11.write(r12, 0, r13);     // Catch: Throwable -> L7
        goto L4
    L9:
        r11.flush();     // Catch: Throwable -> L7
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L7
        CloseableKt.closeFinally(r11, null);
        return;
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        CloseableKt.closeFinally(r11, th);
        throw th;
    }

    public static final boolean i(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return false;
    L5:
        File r10 = new File(r5);
        if (r10.exists() == true) goto L8;
        return false;
    L8:
        return r10.delete();
    }

    public static final boolean j(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "fileName");
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return false;
    L5:
        File r11 = new File(r5);
        if (r11.exists() == true) goto L8;
        String r12 = r11 + " is invalid";
        Intrinsics.checkNotNullParameter("ExtentionFunc", "tag");
        t0.d r13 = f2846a;
        if (r13 == null) goto L12;
        r13.e("ExtentionFunc", r12);
    L12:
        return false;
    L8:
        return r11.renameTo(new File(r10));
    }

    public static final int k(Window r5) {
        if (r5 != null) goto L9;
        t0.b r10 = p.f2294c;
        if (r10 == null) goto L8;
        Activity r11 = r10.currentActivity();
        if (r11 == null) goto L8;
        r5 = r11.getWindow();
    L8:
        r5 = null;
    L9:
        if (r5 == null) goto L13;
        return f(r5).heightPixels;
    L13:
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    public static final boolean l(String r5) {
        if (r5 != null) goto L4;
        return false;
    L4:
        if (r5.length() <= 0) goto L9;
        return true;
    L9:
        return false;
    }

    public static final boolean m(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "dstFile");
        Intrinsics.checkNotNullParameter(r11, "assetsFolderName");
        Application r5 = s0.c.a();     // Catch: Exception -> L7
        String r12 = new File(r10).getName();     // Catch: Exception -> L7
        Intrinsics.checkNotNull(r12);     // Catch: Exception -> L7
        Intrinsics.checkNotNullParameter(r5, "context");     // Catch: Exception -> L7
        Intrinsics.checkNotNullParameter(r11, "folderName");     // Catch: Exception -> L7
        Intrinsics.checkNotNullParameter(r12, "fileName");     // Catch: Exception -> L7
        InputStream r13 = r5.getAssets().open(r11 + '/' + r12);     // Catch: Exception -> L7 IOException -> L9
    L10:
        if (r13 != null) goto L36;
        String r14 = "Resource " + r12 + " does not exist in the assets directory";     // Catch: Exception -> L7
        Intrinsics.checkNotNullParameter("ExtentionFunc", "tag");     // Catch: Exception -> L7
        t0.d r15 = f2846a;     // Catch: Exception -> L7
        if (r15 == null) goto L27;
        r15.d("ExtentionFunc", r14);     // Catch: Exception -> L7
    L27:
        return false;
    L36:
        String r16 = "The assets directory contains resource " + r12;     // Catch: Throwable -> L14
        Intrinsics.checkNotNullParameter("ExtentionFunc", "tag");     // Catch: Throwable -> L14
        t0.d r17 = f2846a;     // Catch: Throwable -> L14
        if (r17 == null) goto L16;
        r17.i("ExtentionFunc", r16);     // Catch: Throwable -> L14
    L16:
        h(r13, r10);     // Catch: Throwable -> L14
        CloseableKt.closeFinally(r13, null);     // Catch: Exception -> L7
        return true;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        CloseableKt.closeFinally(r13, th);     // Catch: Exception -> L7
        throw th;     // Catch: Exception -> L7
    L9:
        r13 = null;
    L7:
        e = move-exception;
        StringBuilder r18 = new StringBuilder("check assets exist error : ");
        e.printStackTrace();
        r18.append(Unit.INSTANCE);
        String r19 = r18.toString();
        Intrinsics.checkNotNullParameter("ExtentionFunc", "tag");
        t0.d r110 = f2846a;
        if (r110 == null) goto L31;
        r110.e("ExtentionFunc", r19);
    L31:
        return false;
    }

    public static final void n(String r5) {
        Intrinsics.checkNotNullParameter(r5, "msg");
        Intrinsics.checkNotNullParameter("applet_performance", "tag");
        t0.d r10 = f2846a;
        if (r10 == null) goto L6;
        r10.d("applet_performance", r5);
        return;
    }
}
