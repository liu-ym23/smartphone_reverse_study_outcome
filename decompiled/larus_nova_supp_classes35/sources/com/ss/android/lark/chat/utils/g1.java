package com.ss.android.lark.chat.utils;

import com.ss.android.lark.chat.entity.chat.Chat;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g1 implements h7b.i.b {
    public final /* synthetic */ SystemContentUtil.a a;
    public final /* synthetic */ Chat b;
    public final /* synthetic */ List c;

    @Override // h7b.i.b
    public final void onCancel() {
    }

    @Override // h7b.i.b
    public final void onConfirm() {
        SystemContentUtil.a r0 = this.a;
        if (r0 == null) goto L6;
        r0.B(this.b.getId(), this.c);
        return;
    }

    public g1(SystemContentUtil.a r1, Chat r2, List r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
