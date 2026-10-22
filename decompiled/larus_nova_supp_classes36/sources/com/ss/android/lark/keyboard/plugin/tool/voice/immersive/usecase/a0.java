package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase;

import android.view.View;
import android.view.ViewTreeObserver;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintSet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a0 implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ VoiceBubbleAreaUseCase a;

    public static final class a implements View.OnLayoutChangeListener {
        public final /* synthetic */ com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.a a;

        public a(com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.a r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            r1.removeOnLayoutChangeListener(this);
            ((AppCompatTextView) this.a.l.getValue()).setAlpha(1.0f);
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        this.a.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        VoiceBubbleAreaUseCase r0 = this.a;
        com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.a r1 = r0.d;
        ((AppCompatTextView) r1.l.getValue()).addOnLayoutChangeListener(new a(r1));
        int r2 = ((AppCompatTextView) r1.l.getValue()).getWidth();
        int r3 = r1.o().getRight();
        int r4 = r1.b().getLeft() + (r1.b().getWidth() / 2);
        ConstraintSet r5 = new ConstraintSet();
        r5.clone(r0.a);
        if ((r3 - r4) > r2) goto L5;
        r5.connect(2131388751, 7, 2131392654, 7);
    L6:
        r5.applyTo(r0.a);
        return;
    L5:
        r5.clear(2131388751, 7);
        goto L6
    }

    public a0(VoiceBubbleAreaUseCase r1) {
        this.a = r1;
    }
}
