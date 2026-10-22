package com.ss.android.lark.inline.ai.asr;

import android.view.View;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f implements View.OnClickListener {
    public final /* synthetic */ c a;

    public f(c r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        Log.i("InlineAIAsrView", "click input_stop_icon");
        this.a.b.e();
    }
}
