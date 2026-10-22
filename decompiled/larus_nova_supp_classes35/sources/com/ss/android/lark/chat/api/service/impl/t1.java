package com.ss.android.lark.chat.api.service.impl;

import com.bytedance.lark.pb.basic.v1.ChatOptionInfo;
import com.bytedance.lark.pb.basic.v1.Entity;
import com.bytedance.lark.pb.im.v1.GetTopicGroupsResponse;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.thread.TopicGroup;
import com.ss.android.lark.sdk.SdkSender;
import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class t1 implements SdkSender.IParser<TopicGroup> {
    public final /* synthetic */ String a;
    public final /* synthetic */ boolean b;

    public t1(String r1) {
        this.a = r1;
        this.b = false;
    }

    public final Object parse(byte[] r5) throws IOException {
        GetTopicGroupsResponse r6 = (GetTopicGroupsResponse) GetTopicGroupsResponse.ADAPTER.decode(r5);
        Entity r0 = r6.entity;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (CollectionUtils.isNotEmpty(r0.topic_groups) == false) goto L25;
        com.bytedance.lark.pb.basic.v1.TopicGroup r1 = (com.bytedance.lark.pb.basic.v1.TopicGroup) r6.entity.topic_groups.get(this.a);
        if (r1 != null) goto L9;
        return null;
    L9:
        if (this.b == false) goto L23;
        if (CollectionUtils.isNotEmpty(r6.entity.chats) == false) goto L23;
        Chat r2 = com.ss.android.lark.parser.internal.h.a((com.bytedance.lark.pb.basic.v1.Chat) r6.entity.chats.get(this.a), null);
        if (r2 == null) goto L27;
        if (CollectionUtils.isNotEmpty(r6.group_option_info) == false) goto L27;
        if (r6.group_option_info.get(this.a) == null) goto L27;
        ChatOptionInfo r7 = (ChatOptionInfo) r6.group_option_info.get(this.a);
        if (r7 == null) goto L27;
        com.ss.android.lark.chat.entity.chat.ChatOptionInfo r3 = new com.ss.android.lark.chat.entity.chat.ChatOptionInfo();
        r3.setAnnounceIsUnread(r7.announce.booleanValue());
        r3.setId(r7.id);
        r2.setChatOptionInfo(r3);
    L27:
        return com.ss.android.lark.parser.internal.c0.a(r1, r2);
    L23:
        return com.ss.android.lark.parser.internal.c0.a(r1, null);
    L25:
        return null;
    }
}
