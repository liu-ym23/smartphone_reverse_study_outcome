package com.larus.common_ui.view;

import com.larus.common_res.common_ui.databinding.LarusChatContinuousTalkInputBinding;
import com.larus.utils.s0;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class j implements Runnable {
    public final /* synthetic */ LarusChatContinuousTalkInputBinding a;
    public final /* synthetic */ ChatInputInnerView b;

    public /* synthetic */ j(LarusChatContinuousTalkInputBinding r1, ChatInputInnerView r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LarusChatContinuousTalkInputBinding r0 = this.a;
        ChatInputInnerView r1 = this.b;
        int r2 = ChatInputInnerView.e;
        s0.a(r0.c, nda.d.a().ua(r1.getContext(), i5.q()), r0.c.getWidth());
    }
}
