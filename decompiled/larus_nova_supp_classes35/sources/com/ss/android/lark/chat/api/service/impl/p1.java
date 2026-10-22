package com.ss.android.lark.chat.api.service.impl;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.Chat;
import com.bytedance.lark.pb.basic.v1.Entity;
import com.bytedance.lark.pb.basic.v1.QuasiMessage;
import com.bytedance.lark.pb.basic.v1.QuasiThread;
import com.bytedance.lark.pb.basic.v1.Thread;
import com.bytedance.lark.pb.im.v1.ChannelDataType;
import com.bytedance.lark.pb.im.v1.GetChannelThreadsResponse;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.chat.entity.Channel;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
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
public final class p1 implements Function1<GetChannelThreadsResponse, l5b.b> {
    public final /* synthetic */ String a;

    public final Object invoke(Object r24) {
        p1 r0 = this;
        GetChannelThreadsResponse r1 = (GetChannelThreadsResponse) r24;
        ArrayList r3 = new ArrayList();
        ArrayList r4 = new ArrayList();
        ArrayList r5 = new ArrayList();
        l5b.b r2 = new l5b.b(r3, r4, r5, new ArrayList());
        System.currentTimeMillis();
        long r6 = System.currentTimeMillis();
        r1.new_reply_count.intValue();
        r1.new_at_reply_count.intValue();
        System.currentTimeMillis();
        r1.show_expired_period.intValue();
        if (CollectionUtils.isNotEmpty(r1.invalid_positions) == false) goto L6;
        r4.addAll(r1.invalid_positions);
        Collections.sort(r4);
    L6:
        if (CollectionUtils.isNotEmpty(r1.missing_positions) == false) goto L8;
        r5.addAll(r1.missing_positions);
        Collections.sort(r5);
    L8:
        Entity r7 = r1.entity;
        if (r7 == null) goto L87;
        com.ss.android.lark.chat.entity.chatter.a r8 = com.ss.android.lark.parser.internal.b.d(r7, true);
        Map r9 = ModelParserMessage.h(r7);
        r2.d = q1.d(r7, r8, r9, r1.new_at_reply_ids);
        Map r10 = r7.messages;
        Map r11 = r7.threads;
        Map r12 = r7.quasi_threads;
        Map r13 = r7.chats;
        Iterator r14 = r1.thread_items.iterator();
    L13:
        if (r14.hasNext() == false) goto L86;
        GetChannelThreadsResponse.ThreadItem r15 = (GetChannelThreadsResponse.ThreadItem) r14.next();
        String r16 = r15.item_id;
        ChannelDataType r17 = r15.item_type;
        Iterator r18 = r14;
        String r19 = "message is null";
        long r110 = r6;
        if (r17 != ChannelDataType.NORMAL_DATA) goto L52;
        LinkedHashMap r111 = (LinkedHashMap) r9;
        Message r112 = (Message) r111.get(r16);
        Map r21 = r11;
        ThreadTopic r113 = com.ss.android.lark.parser.internal.b0.a((Thread) r11.get(r16));
        if (r112 == null) goto L47;
        if (r113 == null) goto L47;
        String r20 = r112.getChatId();
        ChatChatter r22 = r8.b(r20, r112.getFromId());
        if (r22 != null) goto L23;
        Log.e("ThreadService", "parse thread failed id is:" + r16 + ", chatter is:" + r22);
    L48:
        n5b.a r23 = null;
    L49:
        if (r23 == null) goto L83;
        r2.a.add(r23);
    L83:
        p1 r25 = this;
        Map r114 = r12;
    L84:
        Map r115 = r13;
    L85:
        r0 = r25;
        r12 = r114;
        r13 = r115;
        r14 = r18;
        r6 = r110;
        r11 = r21;
        r10 = r10;
        goto L13
    L23:
        r12 = r12;
        n5b.a r116 = new n5b.a(r22, r113, r112);
        r13 = r13;
        r116.l = com.ss.android.lark.parser.internal.h.a((Chat) r13.get(r112.getChatId()), null);
        r116.i = com.ss.android.lark.parser.internal.a.g(r112, r8);
        com.bytedance.lark.pb.basic.v1.Message r26 = (com.bytedance.lark.pb.basic.v1.Message) r10.get(r16);
        if (r26 == null) goto L30;
        r116.d = com.ss.android.lark.parser.internal.a.e(r8, r20, com.ss.android.lark.parser.internal.x.b(r26.reactions));
        r116.g = com.ss.android.lark.parser.internal.a.h(r26.pin, r20, r8);
        com.ss.android.lark.parser.internal.a.m(r26, r116, r8);
        String r27 = r112.getRecallerId();
        if (TextUtils.isEmpty(r27) == true) goto L28;
        r116.o = r8.b(r20, r27);
    L28:
        r116.h = com.ss.android.lark.parser.internal.d0.e(r112, r7, true);
    L30:
        if (CollectionUtils.isNotEmpty(r113.getLastReplyIds()) == false) goto L42;
        ArrayList r28 = new ArrayList();
        Iterator r117 = r113.getLastReplyIds().iterator();
    L33:
        if (r117.hasNext() == false) goto L41;
        Message r118 = (Message) r111.get((String) r117.next());
        if (r118 == null) goto L36;
        ChatChatter r119 = r8.b(r20, r118.getFromId());
        if (r119 == null) goto L39;
        String r120 = r20;
        MessageInfo r29 = new MessageInfo(r118, r119);
        r29.setTranslateInfo(com.ss.android.lark.parser.internal.d0.e(r118, r7, true));
        r29.setOriginalSender(com.ss.android.lark.parser.internal.a.g(r118, r8));
        r28.add(r29);
        r10 = r10;
        r20 = r120;
        goto L33
    L39:
        Log.e("ThreadService", "message sender is null");
        goto L33
    L36:
        Log.e("ThreadService", "message is null");
        goto L33
    L41:
        r10 = r10;
        r116.e = r28;
    L43:
        List<MessageInfo> r30 = q1.a(r7, r113, r8, r9);
        if (CollectionUtils.isEmpty(r30) == true) goto L46;
        r116.f = r30;
    L46:
        r23 = r116;
        goto L49
    L42:
        r10 = r10;
    L47:
        Log.e("ThreadService", "parse thread failed, id is:" + r16 + ", message is :" + r112 + ", thread is:" + r113);
        goto L48
    L52:
        r10 = r10;
        r21 = r11;
        r12 = r12;
        r13 = r13;
        if (r17 != ChannelDataType.QUASI_DATA) goto L83;
        QuasiMessage r31 = (QuasiMessage) r7.quasi_messages.get(r16);
        r114 = r12;
        QuasiThread r121 = (QuasiThread) r114.get(r16);
        if (r121 != null) goto L57;
        ThreadTopic r122 = null;
    L58:
        if (r31 == null) goto L82;
        if (r122 == null) goto L82;
        Message r32 = ModelParserMessage.d(r7, r31);
        r25 = this;
        ChatChatter r33 = r8.b(r25.a, r32.getFromId());
        if (r33 != null) goto L64;
        Log.e("ThreadService", "parse thread failed, chatter is null,  id is:" + r16);
        goto L84
    L64:
        n5b.a r123 = new n5b.a(r33, r122, r32);
        r115 = r13;
        r123.l = com.ss.android.lark.parser.internal.h.a((Chat) r115.get(r25.a), null);
        if (CollectionUtils.isNotEmpty(r122.getLastReplyIds()) == false) goto L78;
        ArrayList r34 = new ArrayList();
        Iterator r35 = r122.getLastReplyIds().iterator();
    L68:
        if (r35.hasNext() == false) goto L77;
        Message r124 = (Message) ((LinkedHashMap) r9).get((String) r35.next());
        if (r124 == null) goto L71;
        String r125 = r19;
        ChatChatter r36 = r8.b(r25.a, r124.getFromId());
        if (r36 != null) goto L75;
        Log.e("ThreadService", "message sender is null");
    L76:
        r19 = r125;
        goto L68
    L75:
        r34.add(new MessageInfo(r124, r36));
        goto L76
    L71:
        Log.e("ThreadService", r19);
        goto L68
    L77:
        r123.e = r34;
    L78:
        List<MessageInfo> r37 = q1.a(r7, r122, r8, r9);
        if (CollectionUtils.isEmpty(r37) == true) goto L81;
        r123.f = r37;
    L81:
        r2.a.add(r123);
    L82:
        r25 = this;
        r115 = r13;
        Log.e("ThreadService", "parse thread failed, id is:" + r16);
        goto L85
    L57:
        r122 = new ThreadTopic();
        r122.setId(r121.id);
        r122.setChannel(new Channel(r121.channel.type.getValue(), r121.channel.id));
        r122.setTopic(r121.topic);
        r122.setPosition(r121.position.intValue());
        goto L58
    L86:
        Collections.sort(r2.a, new o1());
        StringBuilder r38 = new StringBuilder("parse cost:");
        r38.append(System.currentTimeMillis() - r6);
        Log.d("ThreadWindow", r38.toString());
    L87:
        return r2;
    }

    public p1(long r1, String r3) {
        this.a = r3;
    }
}
