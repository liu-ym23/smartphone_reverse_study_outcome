package com.obric.assistant.util;

import android.view.View;
import android.view.ViewGroup;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class m2 {
    public static final int a = 0;
    public static final int b = 0;
    public static final int c = 0;
    public static final int d = 0;
    public static final int e = 0;
    public static final int f = 0;

    static {
        a = ((Number) i5.Y1.getValue()).intValue() + i5.d0();
        int r0 = i5.r();
        b = r0;
        int r1 = i5.l0();
        c = r1;
        d = i5.i();
        e = r0 - r1;
        f = i5.b0() + i5.z();
    }

    public static Pair a(int r3, int r4) {
        FLogger.a.i("OrionPageStateTouchHelp", "getCurrentMsgCardHeight, currentPageHeight = " + r3 + ", cardHeight = " + r4);
        int r0 = com.larus.utils.m0.a;
        int r1 = (com.larus.utils.m0.a(AppHost.a.getApplication()) - r4) - r3;
        int r5 = b;
        if (r1 >= r5) goto L5;
        Integer r6 = Integer.valueOf(r5);
        Boolean r2 = Boolean.TRUE;
    L7:
        return new Pair(r6, r2);
    L5:
        r6 = Integer.valueOf(r1);
        r2 = Boolean.FALSE;
        goto L7
    }

    public static int b(View r6, View r7, View r8, View r9) {
        int r0 = com.larus.utils.m0.a;
        int r1 = com.larus.utils.m0.a(AppHost.a.getApplication());
        int r2 = i5.k0();
        int r3 = 0;
        if (r7 == null) goto L5;
        int r4 = r7.getHeight();
    L6:
        if (r7 == null) goto L13;
        ViewGroup.LayoutParams r10 = r7.getLayoutParams();
        if ((r10 instanceof ViewGroup.MarginLayoutParams) == false) goto L10;
        ViewGroup.MarginLayoutParams r11 = (ViewGroup.MarginLayoutParams) r10;
    L11:
        if (r11 == null) goto L13;
        int r12 = r11.bottomMargin;
    L14:
        int r5 = r4 + r12;
        if (r9 == null) goto L22;
        boolean r13 = true;
        if (r9.getVisibility() != 0) goto L19;
        boolean r14 = true;
    L20:
        if (r14 != true) goto L22;
    L23:
        if (r13 == true) goto L25;
    L27:
        int r15 = 0;
    L28:
        if (r8 == null) goto L30;
        int r16 = r8.getHeight();
    L32:
        if (Intrinsics.areEqual(t9a.b.a().d(), "Genesis-R") == true) goto L36;
        if (r6 == null) goto L36;
        r3 = r6.getPaddingBottom();
    L36:
        FLogger r17 = FLogger.a;
        StringBuilder r18 = new StringBuilder("getMaxTopEmptyHeight, fullScreenHeight = ");
        r18.append(r1);
        r18.append(", titleContainerHeight = ");
        r18.append(r2);
        r18.append(", inputHeight = ");
        r18.append(r5);
        r18.append(", bottomLayoutHeight = ");
        r18.append(r16);
        r18.append(", bottomPadding = ");
        r18.append(r3);
        r18.append(", actionBarHeight = ");
        r18.append(r15);
        r18.append(", extraTranslationY = ");
        int r19 = f;
        r18.append(r19);
        r18.append(", dp_2 = ");
        r18.append(i5.z());
        r18.append(", return ");
        int r20 = (((((r1 - r2) - r5) - r16) - r3) - r15) + r19;
        r18.append(r20 - i5.z());
        r17.i("OrionPageStateTouchHelp", r18.toString());
        return r20 - i5.z();
    L30:
        r16 = 0;
        goto L32
    L25:
        if (r9.getHeight() != 0) goto L27;
        r15 = i5.X();
        goto L28
    L19:
        r14 = false;
    L22:
        r13 = false;
        goto L23
    L10:
        r11 = null;
    L13:
        r12 = 0;
        goto L14
    L5:
        r4 = 0;
        goto L6
    }
}
