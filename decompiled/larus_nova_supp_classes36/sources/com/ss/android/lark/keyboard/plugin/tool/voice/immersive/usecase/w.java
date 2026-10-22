package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class w<T> implements Observer {
    public final /* synthetic */ VoiceBubbleAreaUseCase a;

    public w(VoiceBubbleAreaUseCase r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        Boolean r3 = (Boolean) r2;
        AppCompatTextView r0 = this.a.d.l();
        Intrinsics.checkNotNull(r3);
        if (r3.booleanValue() == false) goto L5;
        int r4 = 0;
    L6:
        r0.setVisibility(r4);
        return;
    L5:
        r4 = 8;
        goto L6
    }
}
