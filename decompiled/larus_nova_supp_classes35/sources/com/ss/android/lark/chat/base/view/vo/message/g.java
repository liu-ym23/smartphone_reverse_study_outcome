package com.ss.android.lark.chat.base.view.vo.message;

import com.ss.android.lark.chat.entity.message.content.TextContent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g extends v5b.a<TextContent> {
    public String b;

    public g() {
        super(new TextContent());
    }

    @Override // v5b.a
    public final boolean d(v5b.a<?> r4) {
        if (super.d(r4) == false) goto L13;
        String r0 = this.b;
        String r2 = null;
        if ((r4 instanceof g) == false) goto L7;
        g r5 = (g) r4;
    L8:
        if (r5 == null) goto L11;
        r2 = r5.b;
    L11:
        if (Intrinsics.areEqual(r0, r2) == false) goto L13;
        return true;
    L7:
        r5 = null;
    L13:
        return false;
    }
}
