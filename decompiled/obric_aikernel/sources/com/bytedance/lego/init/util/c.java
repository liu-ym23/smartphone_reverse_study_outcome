package com.bytedance.lego.init.util;

import android.util.Log;
import com.bytedance.lego.init.InitScheduler;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f2121a = null;

    static {
        f2121a = new c();
    }

    private c() {
    }

    @JvmOverloads
    public static /* synthetic */ void b(c r10, String r11, String r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L5;
        r11 = "";
    L5:
        r10.a(r11, r12);
    }

    @JvmOverloads
    public static /* synthetic */ void d(c r10, String r11, String r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L5;
        r11 = "";
    L5:
        r10.c(r11, r12);
    }

    @JvmOverloads
    public static /* synthetic */ void g(c r10, String r11, String r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L5;
        r11 = "";
    L5:
        r10.f(r11, r12);
    }

    @JvmOverloads
    public final void a(String r10, String r11) {
        Intrinsics.checkParameterIsNotNull(r10, "classname");
        Intrinsics.checkParameterIsNotNull(r11, "message");
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == true) goto L5;
        return;
    L5:
        String r12 = r10 + ' ' + r11;
        int r13 = r12.length();
        int r14 = 0;
        int r15 = 3072;
        int r16 = 1;
    L6:
        if (r16 > 100) goto L14;
        if (r13 <= r15) goto L10;
        String r17 = r12.substring(r14, r15);
        Intrinsics.checkExpressionValueIsNotNull(r17, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        Log.d("#inittask#" + r16, r17);
        r16 = r16 + 1;
        r14 = r15;
        r15 = r15 + 3072;
        goto L6
    L10:
        String r18 = r12.substring(r14, r13);
        Intrinsics.checkExpressionValueIsNotNull(r18, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        Log.d("#inittask#" + r16, r18);
        return;
    }

    @JvmOverloads
    public final void c(String r10, String r11) {
        Intrinsics.checkParameterIsNotNull(r10, "classname");
        Intrinsics.checkParameterIsNotNull(r11, "message");
        Log.e("#inittask#", r10 + ' ' + r11);
    }

    public final boolean e() {
        return InitScheduler.INSTANCE.isDebug$initscheduler_release();
    }

    @JvmOverloads
    public final void f(String r10, String r11) {
        Intrinsics.checkParameterIsNotNull(r10, "classname");
        Intrinsics.checkParameterIsNotNull(r11, "message");
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == true) goto L5;
        return;
    L5:
        String r12 = r10 + ' ' + r11;
        int r13 = r12.length();
        int r14 = 0;
        int r15 = 3072;
        int r16 = 1;
    L6:
        if (r16 > 100) goto L14;
        if (r13 <= r15) goto L10;
        String r17 = r12.substring(r14, r15);
        Intrinsics.checkExpressionValueIsNotNull(r17, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        Log.v("#inittask#" + r16, r17);
        r16 = r16 + 1;
        r14 = r15;
        r15 = r15 + 3072;
        goto L6
    L10:
        String r18 = r12.substring(r14, r13);
        Intrinsics.checkExpressionValueIsNotNull(r18, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        Log.v("#inittask#" + r16, r18);
        return;
    }
}
