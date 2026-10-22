package com.obric.miniapp.lynx;

import android.app.Dialog;
import com.larus.utils.logger.FLogger;
import java.lang.reflect.Method;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class h1 implements xla.b {
    public final /* synthetic */ LynxMiniAppSheetUI a;
    public final /* synthetic */ f6 b;
    public final /* synthetic */ a6 c;

    public final void onShowAnimEnd(Dialog r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
        LynxMiniAppSheetUI r3 = this.a;
        if (r3.o == false) goto L6;
        r3.o = false;
        r3.Q("show");
        return;
    }

    public final void onShowAnimStart(Dialog r10) {
        Intrinsics.checkNotNullParameter(r10, "dialog");
        LynxMiniAppSheetUI r0 = this.a;
        int r1 = LynxMiniAppSheetUI.p;
        r0.getClass();
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L30
        Method[] r3 = r10.getClass().getMethods();     // Catch: Throwable -> L30
        int r4 = r3.length;     // Catch: Throwable -> L30
        int r5 = 0;
    L4:
        Integer r6 = null;
        if (r5 >= r4) goto L18;
        Method r7 = r3[r5];     // Catch: Throwable -> L30
        if (Intrinsics.areEqual(r7.getName(), "getMaxBodyHeight") == false) goto L14;
        boolean r8 = true;
        if (r7.getParameterTypes().length != 0) goto L11;
        boolean r9 = true;
    L12:
        if (r9 == false) goto L14;
    L15:
        if (r8 == true) goto L19;
        r5 = r5 + 1;     // Catch: Throwable -> L30
    L19:
        if (r7 == null) goto L21;
        Object r11 = r7.invoke(r10, new Object[0]);     // Catch: Throwable -> L30
    L23:
        if ((r11 instanceof Integer) == false) goto L25;
        r6 = (Integer) r11;     // Catch: Throwable -> L30
    L25:
        if (r6 == null) goto L27;
        int r12 = r6.intValue();     // Catch: Throwable -> L30
    L28:
        Object r13 = Result.constructor-impl(Integer.valueOf(r12));     // Catch: Throwable -> L30
    L32:
        Throwable r14 = Result.exceptionOrNull-impl(r13);
        if (r14 == null) goto L36;
        FLogger.a.w("LynxMiniAppSheetUI", "resolveMaxBodyHeight failed: " + r14.getMessage());
        r13 = 0;
    L36:
        r0.m = ((Number) r13).intValue();
        final f6 r15 = this.b;
        final LynxMiniAppSheetUI r16 = this.a;
        final a6 r17 = this.c;
        r15.post(new e1(r16, r15, r17));
        return;
    L27:
        r12 = 0;
        goto L28
    L21:
        r11 = null;
        goto L23
    L11:
        r9 = false;
    L14:
        r8 = false;
        goto L15
    L18:
        r7 = null;
    L30:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L32
    }

    public h1(LynxMiniAppSheetUI r1, f6 r2, a6 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
