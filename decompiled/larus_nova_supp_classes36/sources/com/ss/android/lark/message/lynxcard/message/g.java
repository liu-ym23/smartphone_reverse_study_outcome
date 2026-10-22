package com.ss.android.lark.message.lynxcard.message;

import android.view.View;
import com.ss.android.lark.message.lynxcard.entity.LynxCardContentVO;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ LynxCardMessageCell a;
    public final /* synthetic */ v5b.c<LynxCardContentVO> b;

    public g(LynxCardMessageCell r1, v5b.c<LynxCardContentVO> r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        this.a.b.l(this.b.getId());
    }
}
