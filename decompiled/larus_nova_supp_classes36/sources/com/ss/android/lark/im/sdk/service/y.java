package com.ss.android.lark.im.sdk.service;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.Entity;
import com.bytedance.lark.pb.im.v1.GetTopicGroupsRequest;
import com.bytedance.lark.pb.im.v1.GetTopicGroupsResponse;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.entity.thread.TopicGroup;
import com.ss.android.lark.parser.internal.c0;
import com.ss.android.lark.passportc.dwarf.UserScope;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@UserScope
public final class y implements x {
    public final com.bytedance.lark.rustclient.api.l a;

    @Inject
    public y(com.bytedance.lark.rustclient.api.l r2) {
        Intrinsics.checkNotNullParameter(r2, "userClient");
        this.a = r2;
    }

    @Override // com.ss.android.lark.im.sdk.service.x
    public final TopicGroup fc(String r13) {
        if (TextUtils.isEmpty(r13) == false) goto L5;
        return null;
    L5:
        if (r13 != null) goto L7;
        return null;
    L7:
        GetTopicGroupsRequest.Builder r0 = new GetTopicGroupsRequest.Builder().group_ids(CollectionsKt.listOf(r13));
        Boolean r2 = Boolean.FALSE;
        GetTopicGroupsRequest.Builder r4 = r0.sync_data(r2).need_sync_unsubscribe_groups(r2);
        Intrinsics.checkNotNull(r4);
        com.bytedance.lark.rustclient.api.d r1 = new com.bytedance.lark.rustclient.api.d(r4, GetTopicGroupsResponse.ADAPTER, Command.GET_TOPIC_GROUPS, null, null, null, null, 248);
        GetTopicGroupsResponse r3 = (GetTopicGroupsResponse) com.bytedance.lark.rustclient.api.t.c(this.a.h(r1).execute(), null);
        if (r3 == null) goto L17;
        Entity r5 = r3.entity;
        if (r5 == null) goto L17;
        if (CollectionUtils.isNotEmpty(r5.topic_groups) == false) goto L17;
        com.bytedance.lark.pb.basic.v1.TopicGroup r14 = (com.bytedance.lark.pb.basic.v1.TopicGroup) r3.entity.topic_groups.get(r13);
        if (r14 == null) goto L17;
        return c0.a(r14, null);
    L17:
        return null;
    }
}
