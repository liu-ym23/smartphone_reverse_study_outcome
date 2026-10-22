package com.ss.android.lark.inline.ai.asr;

import android.view.View;
import com.ss.android.lark.inline.ai.api.ui.Operate;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ Operate a;
    public final /* synthetic */ c b;

    public g(Operate r1, c r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        Log.i("InlineAIAsrView", "click operate, operate = " + this.a);
        this.b.b.k(this.a);
    }
}
