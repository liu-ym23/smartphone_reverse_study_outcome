package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation;

import android.graphics.Rect;
import android.view.View;
import androidx.transition.ChangeBounds;
import androidx.transition.TransitionValues;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0014\u0010\u0014\u001a\u00020\u000f*\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0005H\u0002J\u0014\u0010\u0016\u001a\u00020\u000f*\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0005H\u0002JS\u0010\u0017\u001a\u00020\u000f2K\u0010\u0018\u001aG\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000RU\u0010\u0007\u001aI\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/animation/VoiceBubbleChangeBounds;", "Landroidx/transition/ChangeBounds;", "<init>", "()V", "reusableStartBounds", "Landroid/graphics/Rect;", "reusableEndBounds", "prepareAnimationHandler", "Lkotlin/Function3;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "startBounds", "endBounds", "", "captureStartValues", "transitionValues", "Landroidx/transition/TransitionValues;", "captureEndValues", "copyBounds", "bounds", "resetBounds", "onPrepareAnimation", "handleAction", "Companion", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class VoiceBubbleChangeBounds extends ChangeBounds {
    public final Rect a;
    public final Rect b;
    public Function3<? super View, ? super Rect, ? super Rect, Unit> c;

    public static final class a {
    }

    static {
    }

    public VoiceBubbleChangeBounds() {
        this.a = new Rect();
        this.b = new Rect();
    }

    public final void captureEndValues(TransitionValues r9) {
        Intrinsics.checkNotNullParameter(r9, "transitionValues");
        super.captureEndValues(r9);
        View r0 = r9.view;
        Object r1 = r0.getTag(2131376757);
        Rect r3 = null;
        if ((r1 instanceof TransitionValues) == false) goto L5;
        TransitionValues r2 = (TransitionValues) r1;
    L6:
        Function3<? super View, ? super Rect, ? super Rect, Unit> r4 = this.c;
        if (r2 == null) goto L32;
        if (r4 == null) goto L32;
        Rect r5 = this.a;
        Object r6 = r2.values.get("android:changeBounds:bounds");
        if ((r6 instanceof Rect) == false) goto L12;
        Rect r7 = (Rect) r6;
    L13:
        if (r7 == null) goto L15;
        r5.set(r7);
    L15:
        Rect r8 = this.b;
        Object r10 = r9.values.get("android:changeBounds:bounds");
        if ((r10 instanceof Rect) == false) goto L18;
        Rect r11 = (Rect) r10;
    L19:
        if (r11 == null) goto L21;
        r8.set(r11);
    L21:
        Intrinsics.checkNotNull(r0);
        r4.invoke(r0, this.a, this.b);
        Rect r12 = this.a;
        Object r13 = r2.values.get("android:changeBounds:bounds");
        if ((r13 instanceof Rect) == false) goto L24;
        Rect r14 = (Rect) r13;
    L25:
        if (r14 == null) goto L27;
        r14.set(r12);
    L27:
        Rect r15 = this.b;
        Object r16 = r9.values.get("android:changeBounds:bounds");
        if ((r16 instanceof Rect) == false) goto L30;
        r3 = (Rect) r16;
    L30:
        if (r3 == null) goto L32;
        r3.set(r15);
        goto L32
    L24:
        r14 = null;
        goto L25
    L18:
        r11 = null;
        goto L19
    L12:
        r7 = null;
    L32:
        Log.d("VoiceBubbleChangeBounds", "captureEndValues: " + r9);
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void captureStartValues(TransitionValues r3) {
        Intrinsics.checkNotNullParameter(r3, "transitionValues");
        super.captureStartValues(r3);
        r3.view.setTag(2131376757, r3);
        Log.d("VoiceBubbleChangeBounds", "captureStartValues: " + r3);
    }
}
