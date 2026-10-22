package com.larus.bmhome.chat.list.cell.prompt;

import android.view.ViewTreeObserver;
import com.bytedance.keva.Keva;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class f0 implements ViewTreeObserver.OnScrollChangedListener {
    public final /* synthetic */ PromptCell a;

    public /* synthetic */ f0(PromptCell r1) {
        this.a = r1;
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        PromptCell r0 = this.a;
        Keva r1 = PromptCell.Y;
        r0.u(false);
    }
}
