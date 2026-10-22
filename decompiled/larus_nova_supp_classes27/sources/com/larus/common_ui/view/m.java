package com.larus.common_ui.view;

import com.larus.common_res.common_ui.databinding.LarusChatContinuousTalkInputBinding;
import com.larus.utils.s0;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class m implements Runnable {
    public final /* synthetic */ LarusChatContinuousTalkInputBinding a;

    public /* synthetic */ m(LarusChatContinuousTalkInputBinding r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LarusChatContinuousTalkInputBinding r0 = this.a;
        int r1 = ChatInputInnerView.e;
        s0.a(r0.b, i5.k(), r0.b.getWidth());
    }
}
