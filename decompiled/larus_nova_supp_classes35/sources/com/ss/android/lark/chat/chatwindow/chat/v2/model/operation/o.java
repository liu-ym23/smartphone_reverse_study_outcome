package com.ss.android.lark.chat.chatwindow.chat.v2.model.operation;

import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.MessageUniversalPinExtra;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class o implements Function1<f5b.b, f5b.b> {
    public final Map<Long, MessageUniversalPinExtra> a;

    public o(Map<Long, MessageUniversalPinExtra> r2) {
        Intrinsics.checkNotNullParameter(r2, "extraInfoMap");
        this.a = r2;
    }

    public final Object invoke(Object r5) {
        f5b.b r6 = (f5b.b) r5;
        String r0 = null;
        if (r6 != null) goto L6;
        return null;
    L6:
        if ((r6 instanceof MessageInfo) == false) goto L25;
        f5b.b r1 = ((MessageInfo) r6).clone();
        if ((r1 instanceof MessageInfo) == false) goto L11;
        MessageInfo r2 = (MessageInfo) r1;
    L12:
        if (r2 == null) goto L26;
        Message r3 = r6.getMessage();
        if (r3 == null) goto L17;
        r0 = r3.getId();
    L17:
        if (r0 == null) goto L23;
        Long r4 = StringsKt.toLongOrNull(r0);
        if (r4 == null) goto L24;
        r2.setUniversalPinExtra(this.a.get(Long.valueOf(r4.longValue())));
        return r2;
    L24:
        return r6;
    L23:
        return r6;
    L26:
        return r6;
    L11:
        r2 = null;
        goto L12
    L25:
        return r6;
    }
}
