package com.larus.contextwindow.impl.service;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.larus.contextwindow.api.ContextWindowContainer;
import com.larus.contextwindow.api.ContextWindowEnterFrom;
import com.larus.contextwindow.api.ContextWindowEntryRequest;
import com.larus.contextwindow.api.ContextWindowSnapshot;
import com.larus.contextwindow.api.ContextWindowUsageParts;
import com.larus.contextwindow.impl.ui.ContextWindowUsageSheetFragment;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v29.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    public static Activity a(Context r2) {
    L3:
        if ((r2 instanceof ContextWrapper) == false) goto L13;
        if ((r2 instanceof Activity) == true) goto L7;
        Context r0 = ((ContextWrapper) r2).getBaseContext();
        if (r0 == r2) goto L10;
        r2 = r0;
        goto L3
    L10:
        return null;
    L7:
        return (Activity) r2;
    L13:
        if ((r2 instanceof Activity) == true) goto L15;
        return null;
    L15:
        return (Activity) r2;
    }

    public static boolean b(ContextWindowEntryRequest r1) {
        Intrinsics.checkNotNullParameter(r1, "request");
        if (b.a(r1) == null) goto L9;
        ContextWindowContainer r2 = r1.e;
        if (r2 != ContextWindowContainer.DEFAULT_CHAT) goto L7;
    L8:
        return true;
    L7:
        if (r2 == ContextWindowContainer.NATIVE_ROUTE) goto L8;
    L9:
        return false;
    }

    public static boolean c(ContextWindowEntryRequest r13, ContextWindowSnapshot r14) {
        Intrinsics.checkNotNullParameter(r13, "request");
        Intrinsics.checkNotNullParameter(r14, "snapshot");
        if (Intrinsics.areEqual(r14.a, r13.a) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r14.b, r13.b) == true) goto L9;
        return false;
    L9:
        if (StringsKt.isBlank(r14.c) == false) goto L12;
        return false;
    L12:
        if (r14.e > 0) goto L14;
        return false;
    L14:
        if (r14.f <= 0) goto L75;
        int r15 = r14.g;
        if (r15 >= 0) goto L19;
    L21:
        boolean r16 = false;
    L22:
        if (r16 == true) goto L24;
        return false;
    L24:
        ContextWindowUsageParts r17 = r14.d;
        long[] r3 = {r17.a, r17.b, r17.c, r17.d};
        int r18 = 0;
    L25:
        if (r18 >= 4) goto L33;
        if (r3[r18] >= 0) goto L29;
        boolean r6 = true;
    L30:
        if (r6 == true) goto L31;
        r18 = r18 + 1;
        goto L25
    L31:
        boolean r110 = true;
    L34:
        if (r110 == false) goto L67;
        return false;
    L67:
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L53
        long r7 = 0;
        int r112 = 0;
    L37:
        if (r112 >= 4) goto L51;
        long r8 = r3[r112];     // Catch: Throwable -> L53
        long r10 = r7 + r8;     // Catch: Throwable -> L53
        if ((r8 ^ r7) >= 0) goto L41;
        boolean r9 = true;
    L43:
        if ((r7 ^ r10) < 0) goto L45;
        boolean r11 = true;
    L47:
        if ((r11 | r9) == false) goto L50;
        r112 = r112 + 1;     // Catch: Throwable -> L53
        r7 = r10;
        goto L37
    L50:
        throw new ArithmeticException();     // Catch: Throwable -> L53
    L45:
        r11 = false;
        goto L47
    L41:
        r9 = false;
        goto L43
    L51:
        Object r113 = Result.constructor-impl(Long.valueOf(r7));     // Catch: Throwable -> L53
    L56:
        if (Result.isFailure-impl(r113) == false) goto L58;
        r113 = null;
    L58:
        Long r114 = (Long) r113;
        if (r114 == null) goto L73;
        long r2 = r114.longValue();
        long r4 = r14.e;
        if (r2 == r4) goto L63;
        return false;
    L63:
        int r115 = x29.a.a;
        if (x29.a.b(r4, r14.f) != r14.g) goto L74;
        return true;
    L74:
        return false;
    L73:
        return false;
    L53:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r113 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L56
    L29:
        r6 = false;
        goto L30
    L33:
        r110 = false;
        goto L34
    L19:
        if (r15 >= 1001) goto L21;
        r16 = true;
        goto L22
    L75:
        return false;
    }

    public static boolean d(FragmentActivity r4, ContextWindowEntryRequest r5, ContextWindowSnapshot r6) {
        Intrinsics.checkNotNullParameter(r4, "activity");
        Intrinsics.checkNotNullParameter(r5, "request");
        Intrinsics.checkNotNullParameter(r6, "snapshot");
        if (b(r5) == true) goto L5;
    L34:
        return false;
    L5:
        if (c(r5, r6) == false) goto L34;
        if (r4.isFinishing() == true) goto L34;
        if (r4.isDestroyed() == true) goto L34;
        FragmentManager r7 = r4.getSupportFragmentManager();
        if (r7.findFragmentByTag("ContextWindowUsageSheet") == null) goto L17;
        return true;
    L17:
        if (r7.isStateSaved() == false) goto L38;
        return false;
    L38:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L26
        int r3 = ContextWindowUsageSheetFragment.q;     // Catch: Throwable -> L26
        ContextWindowEnterFrom r8 = r5.d;     // Catch: Throwable -> L26
        Intrinsics.checkNotNullParameter(r6, "snapshot");     // Catch: Throwable -> L26
        Intrinsics.checkNotNullParameter(r8, "enterFrom");     // Catch: Throwable -> L26
        ContextWindowUsageSheetFragment r0 = new ContextWindowUsageSheetFragment();     // Catch: Throwable -> L26
        Bundle r9 = new Bundle();     // Catch: Throwable -> L26
        r9.putParcelable("arg_context_snapshot", r6);     // Catch: Throwable -> L26
        r9.putString("arg_enter_from", r8.getWireValue());     // Catch: Throwable -> L26
        r0.setArguments(r9);     // Catch: Throwable -> L26
        LandscapeRestrictionOperation r10 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: Throwable -> L26
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, "ContextWindowUsageSheet", r10);     // Catch: Throwable -> L26
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r7, r0, r10) == false) goto L36;
    L24:
        Object r11 = Result.constructor-impl(Boolean.TRUE);     // Catch: Throwable -> L26
    L28:
        Throwable r12 = Result.exceptionOrNull-impl(r11);
        if (r12 == null) goto L33;
        FLogger.a.e("ContextWindowLauncher", "show panel failed", r12);
        r11 = Boolean.FALSE;
    L33:
        return ((Boolean) r11).booleanValue();
    L36:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L35 Throwable -> L26
    L23:
        r0.show(r7, "ContextWindowUsageSheet");     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L28
    }
}
