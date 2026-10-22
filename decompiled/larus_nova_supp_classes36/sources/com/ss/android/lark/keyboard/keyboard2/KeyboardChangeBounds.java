package com.ss.android.lark.keyboard.keyboard2;

import android.graphics.Rect;
import android.view.View;
import androidx.transition.ChangeBounds;
import androidx.transition.TransitionValues;
import com.ss.android.lark.KeyboardBaseModule;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0014\u0010\u0016\u001a\u00020\u0011*\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0005H\u0002J\u0014\u0010\u0018\u001a\u00020\u0011*\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0005H\u0002JS\u0010\u0019\u001a\u00020\u00112K\u0010\u001a\u001aG\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000RU\u0010\t\u001aI\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/keyboard/keyboard2/KeyboardChangeBounds;", "Landroidx/transition/ChangeBounds;", "<init>", "()V", "reusableStartBounds", "Landroid/graphics/Rect;", "reusableEndBounds", "shouldClearStartValuesTag", "", "prepareAnimationHandler", "Lkotlin/Function3;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "startBounds", "endBounds", "", "captureStartValues", "transitionValues", "Landroidx/transition/TransitionValues;", "captureEndValues", "copyBounds", "bounds", "resetBounds", "onPrepareAnimation", "handleAction", "Companion", "keyboard-base_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class KeyboardChangeBounds extends ChangeBounds {
    public final Rect a;
    public final Rect b;
    public final boolean c;
    public Function3<? super View, ? super Rect, ? super Rect, Unit> d;

    public static final class a {
    }

    static {
    }

    public KeyboardChangeBounds() {
        this.a = new Rect();
        this.b = new Rect();
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        if (KeyboardBaseModule.a().isFeatureGatingEnable("messenger.im.disable_keyboard_change_bounds_leak_fix") == true) goto L6;
        boolean r1 = true;
    L7:
        Object r2 = Result.constructor-impl(Boolean.valueOf(r1));     // Catch: Throwable -> L9
    L11:
        Boolean r3 = Boolean.TRUE;
        if (Result.isFailure-impl(r2) == false) goto L14;
        r2 = r3;
    L14:
        this.c = ((Boolean) r2).booleanValue();
        return;
    L6:
        r1 = false;
    L9:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    public final void captureEndValues(TransitionValues r9) {
        Intrinsics.checkNotNullParameter(r9, "transitionValues");
        super.captureEndValues(r9);
        View r0 = r9.view;
        Object r2 = r0.getTag(2131376757);
        Rect r4 = null;
        if ((r2 instanceof TransitionValues) == false) goto L5;
        TransitionValues r3 = (TransitionValues) r2;
    L7:
        if (this.c == false) goto L9;
        r0.setTag(2131376757, null);
    L9:
        Function3<? super View, ? super Rect, ? super Rect, Unit> r1 = this.d;
        if (r3 == null) goto L36;
        if (r1 == null) goto L37;
        Rect r5 = this.a;
        Object r6 = r3.values.get("android:changeBounds:bounds");
        if ((r6 instanceof Rect) == false) goto L15;
        Rect r7 = (Rect) r6;
    L16:
        if (r7 == null) goto L18;
        r5.set(r7);
    L18:
        Rect r8 = this.b;
        Object r10 = r9.values.get("android:changeBounds:bounds");
        if ((r10 instanceof Rect) == false) goto L21;
        Rect r11 = (Rect) r10;
    L22:
        if (r11 == null) goto L24;
        r8.set(r11);
    L24:
        Intrinsics.checkNotNull(r0);
        r1.invoke(r0, this.a, this.b);
        Rect r12 = this.a;
        Object r13 = r3.values.get("android:changeBounds:bounds");
        if ((r13 instanceof Rect) == false) goto L27;
        Rect r14 = (Rect) r13;
    L28:
        if (r14 == null) goto L30;
        r14.set(r12);
    L30:
        Rect r15 = this.b;
        Object r16 = r9.values.get("android:changeBounds:bounds");
        if ((r16 instanceof Rect) == false) goto L33;
        r4 = (Rect) r16;
    L33:
        if (r4 == null) goto L38;
        r4.set(r15);
        return;
    L38:
        return;
    L27:
        r14 = null;
        goto L28
    L21:
        r11 = null;
        goto L22
    L15:
        r7 = null;
        goto L16
    L37:
        return;
    L36:
        return;
    L5:
        r3 = null;
        goto L7
    }

    public final void captureStartValues(TransitionValues r3) {
        Intrinsics.checkNotNullParameter(r3, "transitionValues");
        super.captureStartValues(r3);
        r3.view.setTag(2131376757, r3);
    }
}
