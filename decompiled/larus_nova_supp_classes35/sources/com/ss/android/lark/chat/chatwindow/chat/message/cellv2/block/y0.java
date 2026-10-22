package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.view.View;
import com.ss.android.lark.chat.base.view.vo.message.BaseTextContentVO;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class y0 implements View.OnLongClickListener {
    public final /* synthetic */ UrlPreviewBlock a;
    public final /* synthetic */ com.ss.android.lark.blueprint.m<y6b.a<BaseTextContentVO<?>>> b;
    public final /* synthetic */ y6b.a<BaseTextContentVO<?>> c;

    public y0(UrlPreviewBlock r1, com.ss.android.lark.blueprint.m<y6b.a<BaseTextContentVO<?>>> r2, y6b.a<BaseTextContentVO<?>> r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r3) {
        return UrlPreviewBlock.d(this.a, this.b, this.c);
    }
}
