package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.view.View;
import com.ss.android.lark.chat.base.view.vo.message.AudioContentVO;
import com.ss.android.lark.widget.listener.OnSingleClickListener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g extends OnSingleClickListener {
    public final /* synthetic */ AudioContentBlock a;
    public final /* synthetic */ com.ss.android.lark.blueprint.m<y6b.a<AudioContentVO>> b;
    public final /* synthetic */ y6b.a<AudioContentVO> c;
    public final /* synthetic */ n2b.d d;

    public final void onSingleClick(View r4) {
        if (this.a.c.s8() == false) goto L10;
        AudioContentBlock r5 = this.a;
        e6b.b r0 = this.b;
        y6b.a<AudioContentVO> r1 = this.c;
        r5.getClass();
        if ((r0 instanceof e6b.b) == false) goto L7;
        e6b.b r2 = r0;
    L8:
        if (r2 == null) goto L12;
        r2.j(r5, r1);
        return;
    L12:
        return;
    L7:
        r2 = null;
        goto L8
    L10:
        this.d.a.n.c();
    }

    public g(AudioContentBlock r1, com.ss.android.lark.blueprint.m<y6b.a<AudioContentVO>> r2, y6b.a<AudioContentVO> r3, n2b.d r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
