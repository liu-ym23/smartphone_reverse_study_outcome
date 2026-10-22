package com.ss.android.lark.im.sdk.service;

import com.bytedance.lark.pb.im.v1.GetMessageIdsByPositionResponse;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.parser.internal.ModelParserMessage;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class q<T, R> implements Function {
    public static final q<T, R> a = null;

    static {
        a = new q();
    }

    public q() {
    }

    public final Object apply(Object r8) {
        com.bytedance.lark.rustclient.api.x r9 = (com.bytedance.lark.rustclient.api.x) r8;
        Intrinsics.checkNotNullParameter(r9, "it");
        GetMessageIdsByPositionResponse r10 = (GetMessageIdsByPositionResponse) r9.c;
        okb.h r0 = ModelParserMessage.a;
        Map r1 = r10.message_ids;
        Map r11 = r10.message_id_types;
        ccb.c r2 = new ccb.c(new ArrayList());
        Iterator r3 = r1.entrySet().iterator();
    L4:
        if (r3.hasNext() == false) goto L10;
        Map.Entry r4 = (Map.Entry) r3.next();
        Integer r5 = (Integer) r4.getKey();
        String r6 = (String) r4.getValue();
        if (r11.get(r6) == null) goto L8;
        Message.Type r7 = Message.Type.forNumber(((com.bytedance.lark.pb.basic.v1.Message.Type) r11.get(r6)).getValue());
    L9:
        List r12 = r2.a;
        r5.intValue();
        r12.add(new ccb.c.a(r6, r7));
        goto L4
    L8:
        r7 = Message.Type.UNKNOWN;
        goto L9
    L10:
        return r2;
    }
}
