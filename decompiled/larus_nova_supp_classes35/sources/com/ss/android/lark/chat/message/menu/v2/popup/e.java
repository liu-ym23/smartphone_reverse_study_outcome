package com.ss.android.lark.chat.message.menu.v2.popup;

import android.animation.ValueAnimator;
import com.ss.android.lark.chat.message.menu.v2.DragPanelLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ PopupMenuEmojiPanelContent a;

    public e(PopupMenuEmojiPanelContent r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        DragPanelLayout r0 = this.a.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dragPanelLayout");
        r0 = null;
    L5:
        Object r4 = r3.getAnimatedValue();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.Float");
        r0.setTranslationY(((Float) r4).floatValue());
    }
}
