package com.larus.bot.impl.feature.edit;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.larus.bot.impl.databinding.LarusPageBotEditBinding;
import com.larus.bot.impl.feature.edit.view.BotEditScrollView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class x1 implements View.OnAttachStateChangeListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ BotUpdateFragment b;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r1) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r7) {
        this.a.removeOnAttachStateChangeListener(this);
        WindowInsetsCompat r8 = ViewCompat.getRootWindowInsets(r7);
        if (r8 == null) goto L35;
        Insets r9 = r8.getInsets(WindowInsetsCompat.Type.navigationBars());
        if (r9 == null) goto L36;
        LarusPageBotEditBinding r0 = this.b.f;
        ViewGroup.MarginLayoutParams r1 = null;
        if (r0 == null) goto L21;
        BotEditScrollView r2 = r0.J;
        if (r2 == null) goto L21;
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        if (r3 == null) goto L20;
        if ((r3 instanceof ViewGroup.MarginLayoutParams) == false) goto L15;
        ViewGroup.MarginLayoutParams r4 = (ViewGroup.MarginLayoutParams) r3;
    L16:
        if (r4 == null) goto L18;
        r4.bottomMargin = r9.bottom;
    L18:
        r2.setLayoutParams(r3);
        goto L21
    L15:
        r4 = null;
        goto L16
    L20:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L21:
        LarusPageBotEditBinding r5 = this.b.f;
        if (r5 == null) goto L37;
        ConstraintLayout r6 = r5.h;
        if (r6 == null) goto L38;
        ViewGroup.LayoutParams r10 = r6.getLayoutParams();
        if (r10 == null) goto L34;
        if ((r10 instanceof ViewGroup.MarginLayoutParams) == false) goto L30;
        r1 = (ViewGroup.MarginLayoutParams) r10;
    L30:
        if (r1 == null) goto L32;
        r1.bottomMargin = r9.bottom;
    L32:
        r6.setLayoutParams(r10);
        return;
    L34:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L38:
        return;
    L37:
        return;
    L36:
        return;
    }

    public x1(ConstraintLayout r1, BotUpdateFragment r2) {
        this.a = r1;
        this.b = r2;
    }
}
