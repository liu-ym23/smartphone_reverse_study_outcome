package com.bytedance.android.live.base.model.message.guestlink;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R$\u0010\u0010\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0017\u001a\u0004\u0018\u00010\u00118&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0016\u0010\b\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u001e\u001a\u0004\u0018\u00010\u00188&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001d\u0010\b\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010%\u001a\u0004\u0018\u00010\u001f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b$\u0010\b\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010,\u001a\u0004\u0018\u00010&8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b+\u0010\b\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R$\u00103\u001a\u0004\u0018\u00010-8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b2\u0010\b\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R$\u0010:\u001a\u0004\u0018\u0001048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b9\u0010\b\u001a\u0004\b5\u00106\"\u0004\b7\u00108R$\u0010A\u001a\u0004\u0018\u00010;8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b@\u0010\b\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?¨\u0006B"}, d2 = {"Lcom/bytedance/android/live/base/model/message/guestlink/i;", "Lvh7/c;", "", "getMsgType", "()I", "setMsgType", "(I)V", "getMsgType$annotations", "()V", "msgType", "Lcom/bytedance/android/live/base/model/message/guestlink/e;", "getInvitationGuideContent", "()Lcom/bytedance/android/live/base/model/message/guestlink/e;", "setInvitationGuideContent", "(Lcom/bytedance/android/live/base/model/message/guestlink/e;)V", "getInvitationGuideContent$annotations", "invitationGuideContent", "Lcom/bytedance/android/live/base/model/message/guestlink/f;", "getInviteContent", "()Lcom/bytedance/android/live/base/model/message/guestlink/f;", "setInviteContent", "(Lcom/bytedance/android/live/base/model/message/guestlink/f;)V", "getInviteContent$annotations", "inviteContent", "Lcom/bytedance/android/live/base/model/message/guestlink/ILinkmicGuestLinkReplyContent;", "getReplyContent", "()Lcom/bytedance/android/live/base/model/message/guestlink/ILinkmicGuestLinkReplyContent;", "setReplyContent", "(Lcom/bytedance/android/live/base/model/message/guestlink/ILinkmicGuestLinkReplyContent;)V", "getReplyContent$annotations", "replyContent", "Lcom/bytedance/android/live/base/model/message/guestlink/h;", "getMatchmakingContent", "()Lcom/bytedance/android/live/base/model/message/guestlink/h;", "setMatchmakingContent", "(Lcom/bytedance/android/live/base/model/message/guestlink/h;)V", "getMatchmakingContent$annotations", "matchmakingContent", "Lcom/bytedance/android/live/base/model/message/guestlink/j;", "getReplyMatchmakingContent", "()Lcom/bytedance/android/live/base/model/message/guestlink/j;", "setReplyMatchmakingContent", "(Lcom/bytedance/android/live/base/model/message/guestlink/j;)V", "getReplyMatchmakingContent$annotations", "replyMatchmakingContent", "Lcom/bytedance/android/live/base/model/message/guestlink/g;", "getJoinChannelContent", "()Lcom/bytedance/android/live/base/model/message/guestlink/g;", "setJoinChannelContent", "(Lcom/bytedance/android/live/base/model/message/guestlink/g;)V", "getJoinChannelContent$annotations", "joinChannelContent", "Lcom/bytedance/android/live/base/model/message/guestlink/d;", "getFinishChannelContent", "()Lcom/bytedance/android/live/base/model/message/guestlink/d;", "setFinishChannelContent", "(Lcom/bytedance/android/live/base/model/message/guestlink/d;)V", "getFinishChannelContent$annotations", "finishChannelContent", "Lcom/bytedance/android/live/base/model/message/guestlink/b;", "getUpdateChannelContent", "()Lcom/bytedance/android/live/base/model/message/guestlink/b;", "setUpdateChannelContent", "(Lcom/bytedance/android/live/base/model/message/guestlink/b;)V", "getUpdateChannelContent$annotations", "updateChannelContent", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface i extends vh7.c<i> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "finish_channel_content")
    d getFinishChannelContent();

    @FieldName(name = "invitation_guide_content")
    e getInvitationGuideContent();

    @FieldName(name = "invite_content")
    f getInviteContent();

    @FieldName(name = "join_linked_channel_content")
    g getJoinChannelContent();

    @FieldName(name = "matchmaking_content")
    h getMatchmakingContent();

    @FieldName(name = "msg_type")
    int getMsgType();

    @FieldName(name = "reply_content")
    ILinkmicGuestLinkReplyContent getReplyContent();

    @FieldName(name = "reply_matchmaking_content")
    j getReplyMatchmakingContent();

    @FieldName(name = "channel_update_content")
    b getUpdateChannelContent();

    @FieldName(name = "finish_channel_content#setter")
    void setFinishChannelContent(d r1);

    @FieldName(name = "invitation_guide_content#setter")
    void setInvitationGuideContent(e r1);

    @FieldName(name = "invite_content#setter")
    void setInviteContent(f r1);

    @FieldName(name = "join_linked_channel_content#setter")
    void setJoinChannelContent(g r1);

    @FieldName(name = "matchmaking_content#setter")
    void setMatchmakingContent(h r1);

    @FieldName(name = "msg_type#setter")
    void setMsgType(int r1);

    @FieldName(name = "reply_content#setter")
    void setReplyContent(ILinkmicGuestLinkReplyContent r1);

    @FieldName(name = "reply_matchmaking_content#setter")
    void setReplyMatchmakingContent(j r1);

    @FieldName(name = "channel_update_content#setter")
    void setUpdateChannelContent(b r1);
}
