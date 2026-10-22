package com.ss.android.lark.chat.utils;

import android.view.View;
import com.larksuite.framework.utils.UIUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class s0 implements com.ss.android.lark.chat.drawable.a.InterfaceC0092a {
    public final /* synthetic */ View a;
    public final /* synthetic */ View b;

    @Override // com.ss.android.lark.chat.drawable.a.InterfaceC0092a
    public final float a() {
        View r0 = this.a;
        if (r0 == null) goto L5;
        int r1 = MsgBubbleUtil.a;
        int r2 = MsgBubbleUtil.b(r0, this.b) + this.a.getHeight();
    L7:
        return r2;
    L5:
        r2 = UIUtils.dp2px(this.b.getContext(), 20.0f);
        goto L7
    }

    public s0(View r1, View r2) {
        this.a = r1;
        this.b = r2;
    }
}
