package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.view.View;
import com.ss.android.lark.chat.base.view.vo.message.AudioContentVO;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements View.OnLongClickListener {
    public final /* synthetic */ AudioContentBlock a;
    public final /* synthetic */ com.ss.android.lark.blueprint.m<y6b.a<AudioContentVO>> b;
    public final /* synthetic */ y6b.a<AudioContentVO> c;

    public a(AudioContentBlock r1, com.ss.android.lark.blueprint.m<y6b.a<AudioContentVO>> r2, y6b.a<AudioContentVO> r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r4) {
        AudioContentBlock r5 = this.a;
        e6b.b r0 = this.b;
        y6b.a<AudioContentVO> r1 = this.c;
        r5.getClass();
        if ((r0 instanceof e6b.b) == false) goto L5;
        e6b.b r2 = r0;
    L6:
        if (r2 != null) goto L10;
        return false;
    L10:
        return r2.e(r5, r1);
    L5:
        r2 = null;
        goto L6
    }
}
