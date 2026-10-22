package com.ss.android.lark.chat.base.view.vo.message;

import com.ss.android.lark.chat.entity.message.content.TextContent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e extends BaseTextContentVO<TextContent> {
    public e(TextContent r2) {
        Intrinsics.checkNotNullParameter(r2, "content");
        super(r2);
    }

    @Override // com.ss.android.lark.chat.base.view.vo.message.BaseTextContentVO, com.ss.android.lark.chat.base.view.vo.message.f, v5b.a
    public final boolean d(v5b.a<?> r3) {
        if (super.d(r3) == true) goto L5;
    L13:
        return false;
    L5:
        if ((r3 instanceof e) == false) goto L13;
        e r4 = (e) r3;
        if (y28.a.a(this.h, r4.h) == false) goto L13;
        if (y28.a.a(this.i, r4.i) == false) goto L13;
        if (y28.a.a(this.j, r4.j) == false) goto L13;
        return true;
    }
}
