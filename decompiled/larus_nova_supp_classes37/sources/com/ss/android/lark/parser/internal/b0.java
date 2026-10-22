package com.ss.android.lark.parser.internal;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.Entity;
import com.bytedance.lark.pb.basic.v1.Thread;
import com.bytedance.lark.pb.basic.v1.ThreadStateInfo;
import com.ss.android.lark.biz.im.api.SceneInfo;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.chat.entity.Channel;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b0 {
    public static ThreadTopic a(Thread r6) {
        SceneInfo r0 = null;
        if (r6 != null) goto L5;
        return null;
    L5:
        ThreadTopic r1 = new ThreadTopic();
        r1.setId(r6.id);
        r1.setChannel(new Channel(r6.channel.type.getValue(), r6.channel.id));
        r1.setTopic(r6.topic);
        r1.setPosition(r6.position.intValue());
        r1.setRootMsgId(r6.root_message_id);
        r1.setLastMsgId(r6.last_message_id);
        r1.setLastMsgPos(r6.last_message_position.intValue());
        r1.setUpdateTime(r6.update_time.longValue());
        r1.setReplyCount(r6.reply_count.intValue());
        r1.setOwnerId(r6.owner_id);
        r1.setLastMsgPosBadgeCount(r6.last_message_position_badge_count.intValue());
        r1.setReadPos(r6.read_position.intValue());
        r1.setReadPosBadgeCount(r6.read_position_badge_count.intValue());
        r1.setLastVisibleMsgPos(r6.last_visible_message_position.intValue());
        r1.setLastVisibleMsgId(r6.last_visible_message_id);
        r1.setBadgeCount(r6.badge_count.intValue());
        r1.setVisible(r6.is_visible.booleanValue());
        r1.setBadged(r6.is_badged.booleanValue());
        r1.setFollow(r6.is_follow.booleanValue());
        r1.setAvatarKey(r6.avatar_key);
        r1.setSubTitle(r6.subtitle);
        r1.setLastReplyIds(r6.last_reply_ids);
        r1.setNoTraceDelete(r6.is_no_trace_deleted.booleanValue());
        r1.setOriginBadgeCount(r6.origin_badge_count.intValue());
        r1.setLatestAtMessageIds(r6.latest_at_message_id);
        r1.setFilterRankTime(r6.rank_time.longValue());
        ThreadStateInfo r2 = r6.state_info;
        if (r2 == null) goto L8;
        r1.setStateInfo(new com.ss.android.lark.biz.im.api.ThreadStateInfo(com.ss.android.lark.biz.im.api.ThreadStateInfo.ThreadState.valueOf(r2.state.getValue()), r2.operator_id, r2.update_time_ms));
    L8:
        String r3 = r6.anonymous_id;
        if (r3 == null) goto L11;
        r1.setAnonymousId(r3);
    L11:
        Boolean r4 = r6.anonymous_enable;
        if (r4 == null) goto L14;
        r1.setAnonymousEnable(r4.booleanValue());
    L14:
        r1.setRemind(r6.is_remind.booleanValue());
        r1.setMock(r6.is_mock);
        r1.setAIChatModeId(r6.ai_chat_mode_id);
        Thread.SceneInfo r7 = r6.scene_info;
        if (r7 == null) goto L21;
        Long r5 = r7.scene_id;
        if (r5 == null) goto L21;
        String r8 = r7.scene_name;
        r0 = new SceneInfo(r5.longValue(), r8);
    L21:
        r1.setSceneInfo(r0);
        return r1;
    }

    public static void b(Message r1, Entity r2, MessageInfo r3) {
        if (TextUtils.isEmpty(r1.getThreadId()) == false) goto L5;
        return;
    L5:
        if (r1.getThreadMessageType() == null) goto L16;
        Map r4 = r2.threads;
        if (r4 != null) goto L10;
        return;
    L10:
        Thread r5 = (Thread) r4.get(r1.getThreadId());
        if (r5 != null) goto L13;
        return;
    L13:
        r3.setReplyInThreadCount(r5.reply_count.intValue());
        r3.setLastReplyInThreadTime(r5.latest_reply_time.longValue());
        return;
    }
}
