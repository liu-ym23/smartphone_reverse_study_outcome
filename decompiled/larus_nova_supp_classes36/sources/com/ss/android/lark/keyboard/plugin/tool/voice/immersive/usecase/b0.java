package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b0<T> implements Observer {
    public final /* synthetic */ VoiceBubbleAreaUseCase a;

    public b0(VoiceBubbleAreaUseCase r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        Boolean r5 = (Boolean) r4;
        if (r5.booleanValue() == false) goto L5;
        ((AppCompatTextView) this.a.d.l.getValue()).setAlpha(0.0f);
        this.a.a.getViewTreeObserver().addOnGlobalLayoutListener(new a0(this.a));
    L5:
        AppCompatTextView r0 = (AppCompatTextView) this.a.d.l.getValue();
        Intrinsics.checkNotNull(r5);
        if (r5.booleanValue() == false) goto L8;
        int r6 = 0;
    L9:
        r0.setVisibility(r6);
        return;
    L8:
        r6 = 8;
        goto L9
    }
}
