package com.ss.android.lark.chat.api.service.impl;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.Entity;
import com.bytedance.lark.pb.im.v1.GetThreadMessagesByPositionsResponse;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.parser.internal.ModelParserMessage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class s1 implements Function1<GetThreadMessagesByPositionsResponse, l5b.a> {
    public final /* synthetic */ List a;
    public final /* synthetic */ String b;

    public final Object invoke(Object r11) {
        GetThreadMessagesByPositionsResponse r12 = (GetThreadMessagesByPositionsResponse) r11;
        l5b.a r0 = new l5b.a();
        Entity r1 = r12.entity;
        if (r1 == null) goto L23;
        Map r2 = r1.messages;
        if (CollectionUtils.isEmpty(r2) == true) goto L23;
        Map r3 = ModelParserMessage.h(r1);
        com.ss.android.lark.chat.entity.chatter.a r4 = com.ss.android.lark.parser.internal.b.d(r1, true);
        ArrayList r5 = new ArrayList();
        Iterator r6 = ((LinkedHashMap) r3).entrySet().iterator();
    L10:
        if (r6.hasNext() == false) goto L20;
        Map.Entry r7 = (Map.Entry) r6.next();
        String r8 = (String) r7.getKey();
        Message r9 = (Message) r7.getValue();
        if (this.a.contains(Integer.valueOf(r9.getThreadPosition())) == false) goto L10;
        if (r9.getThreadId() == null) goto L19;
        if (TextUtils.equals(r9.getThreadId(), this.b) == true) goto L19;
        Log.i("ThreadService", "ThreadService::GetThreadMessagesByPositionsRequest skip message id: " + r9.getId() + " position: " + r9.getPosition() + " chatId: " + r9.getChatId() + " threadId: " + r9.getThreadId());
    L19:
        r5.add(com.ss.android.lark.parser.internal.a.k(r9, (com.bytedance.lark.pb.basic.v1.Message) r2.get(r8), r1, r4, null));
        goto L10
    L20:
        Collections.sort(r5, new r1());
        r0.a.addAll(r5);
        if (CollectionUtils.isNotEmpty(r12.invalid_positions) == false) goto L23;
        r0.c.addAll(r12.invalid_positions);
    L23:
        return r0;
    }

    public s1(List r1, String r2) {
        this.a = r1;
        this.b = r2;
    }
}
