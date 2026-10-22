package com.ss.android.lark.message.lynxcard.message;

import android.view.View;
import com.ss.android.lark.message.lynxcard.entity.LynxCardContentVO;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class j implements View.OnLongClickListener {
    public final /* synthetic */ LynxCardMessageCell a;
    public final /* synthetic */ LynxCardViewHolder b;
    public final /* synthetic */ v5b.c<LynxCardContentVO> c;

    public j(LynxCardMessageCell r1, LynxCardViewHolder r2, v5b.c<LynxCardContentVO> r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r3) {
        return LynxCardMessageCell.l(this.a, this.b, this.c);
    }
}
