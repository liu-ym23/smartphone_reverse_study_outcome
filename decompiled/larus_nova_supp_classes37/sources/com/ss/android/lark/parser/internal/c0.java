package com.ss.android.lark.parser.internal;

import com.bytedance.lark.pb.basic.v1.TopicGroupRole;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.thread.TopicGroup;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c0 {
    public static TopicGroup a(com.bytedance.lark.pb.basic.v1.TopicGroup r4, Chat r5) {
        TopicGroup r0 = new TopicGroup();
        r0.setId(r4.id);
        r0.setType(TopicGroup.Type.fromValue(r4.type.getValue()));
        if (r4.user_setting == null) goto L8;
        TopicGroup.UserSetting r1 = new TopicGroup.UserSetting();
        r1.setFavorite(r4.user_setting.is_favorite.booleanValue());
        r1.setUpdateTime(r4.user_setting.update_time.longValue());
        TopicGroupRole r6 = r4.user_setting.topic_group_role;
        if (r6 == null) goto L7;
        r1.setTopicGroupRole(TopicGroup.TopicGroupRole.fromValue(r6.getValue()));
    L7:
        r0.setUserSetting(r1);
    L8:
        if (r5 == null) goto L10;
        r0.setChat(r5);
    L10:
        return r0;
    }
}
