package com.ss.android.lark.chat.base.view.vo.message;

import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.MergeForwardContent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c extends f<MergeForwardContent> {
    public Message h;
    public pxa.a i;

    public c(MergeForwardContent r2) {
        Intrinsics.checkNotNullParameter(r2, "content");
        super(r2);
    }

    @Override // com.ss.android.lark.chat.base.view.vo.message.f, v5b.a
    public final boolean d(v5b.a<?> r3) {
        if (super.d(r3) == true) goto L5;
        return false;
    L5:
        if (r3 != null) goto L7;
        return false;
    L7:
        if ((r3 instanceof c) == true) goto L9;
        return false;
    L9:
        if (y28.a.a(this.i, ((c) r3).i) == false) goto L14;
        return true;
    L14:
        return false;
    }
}
