package com.ss.android.lark.chat.base.view.vo.message;

import com.ss.android.lark.chat.entity.message.content.SystemContent;
import com.ss.android.lark.chat.export.entity.message.content.SystemMessageType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d extends v5b.a<SystemContent> {
    public d(SystemContent r2) {
        Intrinsics.checkNotNullParameter(r2, "content");
        super(r2);
    }

    @Override // v5b.a
    public final String c(v5b.c<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "message");
        SystemContent r1 = (SystemContent) this.a;
        SystemMessageType r2 = null;
        if (r1 == null) goto L5;
        SystemMessageType r3 = r1.getType();
    L7:
        if (r3 == SystemMessageType.USER_CHECK_OTHERS_TELEPHONE) goto L15;
        SystemContent r4 = (SystemContent) this.a;
        if (r4 == null) goto L12;
        r2 = r4.getType();
    L12:
        if (r2 == SystemMessageType.SystemContent_CHECK_USER_PHONE_NUMBER) goto L15;
        Intrinsics.checkNotNullParameter(r5, "message");
        return r5.g();
    L15:
        String r6 = ((SystemContent) this.a).getContents().get("caller_id");
        if (r6 != null) goto L20;
        return "1";
    L20:
        return r6;
    L5:
        r3 = null;
        goto L7
    }
}
