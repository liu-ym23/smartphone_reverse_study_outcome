package com.bytedance.android.livesdk.interactivity.comment;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a1 implements Consumer<u22.m> {
    public final /* synthetic */ CommentWidget a;

    public a1(CommentWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r4) throws Exception {
        u22.m r5 = (u22.m) r4;
        CommentWidget r0 = this.a;
        Boolean r1 = Boolean.TRUE;
        int r2 = CommentWidget.V1;
        if (r0.br(r5, r1).booleanValue() == true) goto L7;
        this.a.onEvent(r5);
        return;
    }
}
