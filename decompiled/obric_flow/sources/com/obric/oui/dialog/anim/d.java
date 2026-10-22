package com.obric.oui.dialog.anim;

import android.util.Log;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.lynx.tasm.utils.j;
import com.obric.common.oui.R$id;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes3.dex */
public final class d {
    static {
    }

    public static DialogAnimStyle$HeightLevel a(int r5, View r10) {
        if (r5 <= 0) goto L4;
        float r11 = r10.getHeight() / r5;
        DialogAnimStyle$HeightLevel r12 = DialogAnimStyle$HeightLevel.SMALL;
        if (r11 < r12.getMaxRatio()) goto L13;
        DialogAnimStyle$HeightLevel r13 = DialogAnimStyle$HeightLevel.MEDIUM;
        if (r11 >= r13.getMaxRatio()) goto L12;
        return r13;
    L12:
        return DialogAnimStyle$HeightLevel.LARGE;
    L13:
        return r12;
    L4:
        return DialogAnimStyle$HeightLevel.MEDIUM;
    }

    public static Pair b(boolean r5, DialogAnimStyle$HeightLevel r10, boolean r11) {
        Float r12 = Float.valueOf(1.0f);
        if (r5 == true) goto L7;
        return new Pair(r12, Float.valueOf(480.0f));
    L7:
        if (r11 == false) goto L18;
        int r13 = c.f13095a[r10.ordinal()];
        if (r13 == 1) goto L31;
        if (r13 == 2) goto L30;
        if (r13 != 3) goto L15;
        return new Pair(r12, Float.valueOf(247.0f));
    L15:
        throw new NoWhenBranchMatchedException();
    L30:
        return new Pair(Float.valueOf(0.85f), Float.valueOf(247.0f));
    L31:
        return new Pair(Float.valueOf(0.85f), Float.valueOf(439.0f));
    L18:
        int r14 = c.f13095a[r10.ordinal()];
        if (r14 == 1) goto L28;
        if (r14 == 2) goto L33;
        if (r14 != 3) goto L25;
        return new Pair(r12, Float.valueOf(322.0f));
    L25:
        throw new NoWhenBranchMatchedException();
    L33:
        return new Pair(Float.valueOf(0.85f), Float.valueOf(322.0f));
    L28:
        return new Pair(Float.valueOf(0.85f), Float.valueOf(632.0f));
    }

    public static com.obric.oui.animation.easy.d c(View r11, final Window r12, boolean r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r11, "<this>");
        Size r5 = j.n(r11.getContext());
        int r10 = r11.getHeight();
        ViewGroup.LayoutParams r15 = r11.getLayoutParams();
        Object r16 = null;
        if ((r15 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r15 = null;
    L5:
        ViewGroup.MarginLayoutParams r17 = (ViewGroup.MarginLayoutParams) r15;
        if (r17 == null) goto L8;
        int r18 = r17.bottomMargin;
    L9:
        int r19 = r10 + r18;
        int r20 = com.lynx.tasm.utils.a.B(24, r11) + r19;
        Pair r110 = b(r14, a(r5.getHeight(), r11), false);
        final float r21 = ((Number) r110.component1()).floatValue();
        final float r111 = ((Number) r110.component2()).floatValue();
        int r22 = R$id.o_dialog_anim_out;
        Object r23 = r11.getTag(r22);
        if (r23 != null) goto L13;
    L15:
        com.obric.oui.animation.easy.d r24 = (com.obric.oui.animation.easy.d) r16;
        if (r24 != null) goto L18;
        r24 = new com.obric.oui.animation.easy.d(r11);
        r11.setTag(r22, r24);
    L18:
        Function1<com.obric.oui.animation.easy.a, Unit> r25 = new DialogAnimStyle$dialogBottomHide$spring$1(r21, r111);
        Intrinsics.checkNotNullParameter(r25, "config");
        r24.a(uq.d.f22429o, r20, r25);
        if (r12 == null) goto L26;
        if (r13 == false) goto L26;
        r12.addFlags(2);     // Catch: Exception -> L24
        final float r26 = r19;
        final float r27 = r12.getAttributes().dimAmount;     // Catch: Exception -> L24
        final Ref.BooleanRef r28 = new Ref.BooleanRef();     // Catch: Exception -> L24
        final com.obric.oui.animation.easy.d r112 = r24;
        uq.c r113 = new a(r12, r26, r27, r28, r112);     // Catch: Exception -> L24
        Intrinsics.checkNotNullParameter(r113, "listener");     // Catch: Exception -> L24
        r24.g = r113;     // Catch: Exception -> L24
    L24:
        e = move-exception;
        Log.w("DialogAnimStyle", Intrinsics.stringPlus("dialogBottomHide, can't show dim anim: ", e.getMessage()));
    L26:
        xq.b.p(r11);
        return r24;
    L13:
        if ((r23 instanceof com.obric.oui.animation.easy.d) == false) goto L15;
        r16 = r23;
        goto L15
    L8:
        r18 = 0;
        goto L9
    }

    public static com.obric.oui.animation.easy.d d(View r5, final Window r10, boolean r11, final float r12, boolean r13, int r14) {
        if ((r14 & 4) == 0) goto L6;
        r12 = 0.6f;
    L6:
        if ((r14 & 8) == 0) goto L8;
        r13 = true;
    L8:
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Size r15 = j.n(r5.getContext());
        int r16 = r5.getHeight();
        ViewGroup.LayoutParams r17 = r5.getLayoutParams();
        Object r18 = null;
        if ((r17 instanceof ViewGroup.MarginLayoutParams) == true) goto L11;
        r17 = null;
    L11:
        ViewGroup.MarginLayoutParams r19 = (ViewGroup.MarginLayoutParams) r17;
        if (r19 == null) goto L14;
        int r20 = r19.bottomMargin;
    L15:
        final int r21 = com.lynx.tasm.utils.a.B(24, r5) + (r16 + r20);
        r5.setAlpha(1.0f);
        Pair r22 = b(r13, a(r15.getHeight(), r5), true);
        final float r110 = ((Number) r22.component1()).floatValue();
        final float r23 = ((Number) r22.component2()).floatValue();
        int r24 = R$id.o_dialog_anim_in;
        Object r25 = r5.getTag(r24);
        if (r25 != null) goto L19;
    L21:
        com.obric.oui.animation.easy.d r26 = (com.obric.oui.animation.easy.d) r18;
        if (r26 != null) goto L24;
        r26 = new com.obric.oui.animation.easy.d(r5);
        r5.setTag(r24, r26);
    L24:
        Function1<com.obric.oui.animation.easy.a, Unit> r27 = new DialogAnimStyle$dialogBottomShow$1(r110, r23, r21);
        Intrinsics.checkNotNullParameter(r27, "config");
        r26.a(uq.d.f22429o, 0.0f, r27);
        if (r10 == null) goto L32;
        if (r11 == false) goto L32;
        r10.addFlags(2);     // Catch: Exception -> L30
        final float r28 = r21;
        uq.c r29 = new b(r10, r28, r12);     // Catch: Exception -> L30
        Intrinsics.checkNotNullParameter(r29, "listener");     // Catch: Exception -> L30
        r26.g = r29;     // Catch: Exception -> L30
    L30:
        e = move-exception;
        Log.w("DialogAnimStyle", Intrinsics.stringPlus("dialogBottomShow, can't show dim anim: ", e.getMessage()));
    L32:
        return r26;
    L19:
        if ((r25 instanceof com.obric.oui.animation.easy.d) == false) goto L21;
        r18 = r25;
        goto L21
    L14:
        r20 = 0;
        goto L15
    }
}
