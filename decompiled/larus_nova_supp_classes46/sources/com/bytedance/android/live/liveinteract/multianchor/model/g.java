package com.bytedance.android.live.liveinteract.multianchor.model;

import com.bytedance.android.live.base.model.message.guestlink.ILinkmicGuestLinkReplyContent;
import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00022\u00060\u0003j\u0002`\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/multianchor/model/g;", "Lvh7/e;", "Lcom/bytedance/android/live/base/model/message/guestlink/i;", "Lyh6/c;", "Lcom/bytedance/android/live/multilink/common/message/MultiLinkImMessage;", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface g extends vh7.e<com.bytedance.android.live.base.model.message.guestlink.i>, com.bytedance.android.live.base.model.message.guestlink.i, yh6.c {
    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    /* synthetic */ m0 getCommonData();

    @FieldName(name = "finish_channel_content")
    /* synthetic */ com.bytedance.android.live.base.model.message.guestlink.d getFinishChannelContent();

    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "invitation_guide_content")
    /* synthetic */ com.bytedance.android.live.base.model.message.guestlink.e getInvitationGuideContent();

    @FieldName(name = "invite_content")
    /* synthetic */ com.bytedance.android.live.base.model.message.guestlink.f getInviteContent();

    @FieldName(name = "join_linked_channel_content")
    /* synthetic */ com.bytedance.android.live.base.model.message.guestlink.g getJoinChannelContent();

    @FieldName(name = "matchmaking_content")
    /* synthetic */ com.bytedance.android.live.base.model.message.guestlink.h getMatchmakingContent();

    @FieldName(name = "msg_type")
    /* synthetic */ int getMsgType();

    @FieldName(name = "reply_content")
    /* synthetic */ ILinkmicGuestLinkReplyContent getReplyContent();

    @FieldName(name = "reply_matchmaking_content")
    /* synthetic */ com.bytedance.android.live.base.model.message.guestlink.j getReplyMatchmakingContent();

    @FieldName(name = "channel_update_content")
    /* synthetic */ com.bytedance.android.live.base.model.message.guestlink.b getUpdateChannelContent();

    /* synthetic */ void setCommonData(m0 r1);

    @FieldName(name = "finish_channel_content#setter")
    /* synthetic */ void setFinishChannelContent(com.bytedance.android.live.base.model.message.guestlink.d r1);

    @FieldName(name = "invitation_guide_content#setter")
    /* synthetic */ void setInvitationGuideContent(com.bytedance.android.live.base.model.message.guestlink.e r1);

    @FieldName(name = "invite_content#setter")
    /* synthetic */ void setInviteContent(com.bytedance.android.live.base.model.message.guestlink.f r1);

    @FieldName(name = "join_linked_channel_content#setter")
    /* synthetic */ void setJoinChannelContent(com.bytedance.android.live.base.model.message.guestlink.g r1);

    @FieldName(name = "matchmaking_content#setter")
    /* synthetic */ void setMatchmakingContent(com.bytedance.android.live.base.model.message.guestlink.h r1);

    @FieldName(name = "msg_type#setter")
    /* synthetic */ void setMsgType(int r1);

    @FieldName(name = "reply_content#setter")
    /* synthetic */ void setReplyContent(ILinkmicGuestLinkReplyContent r1);

    @FieldName(name = "reply_matchmaking_content#setter")
    /* synthetic */ void setReplyMatchmakingContent(com.bytedance.android.live.base.model.message.guestlink.j r1);

    @FieldName(name = "channel_update_content#setter")
    /* synthetic */ void setUpdateChannelContent(com.bytedance.android.live.base.model.message.guestlink.b r1);
}
