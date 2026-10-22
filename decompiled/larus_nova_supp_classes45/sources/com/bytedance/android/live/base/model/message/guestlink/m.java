package com.bytedance.android.live.base.model.message.guestlink;

import com.bytedance.android.livesdk.message.model.o0;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message.BaseMessage;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.tools.kcp.modelx.runtime.internal.FlexModelDelegate;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00020\u0003B\u0007¢\u0006\u0004\bO\u0010PJ/\u0010\b\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ-\u0010\n\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0016¢\u0006\u0004\b\n\u0010\tR\"\u0010\f\u001a\u00020\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010!\u001a\u0004\u0018\u00010 8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010(\u001a\u0004\u0018\u00010'8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u0010/\u001a\u0004\u0018\u00010.8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R$\u00106\u001a\u0004\u0018\u0001058\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R$\u0010=\u001a\u0004\u0018\u00010<8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR$\u0010D\u001a\u0004\u0018\u00010C8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR \u0010K\u001a\b\u0012\u0004\u0012\u00020\u00020J8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N¨\u0006Q"}, d2 = {"Lcom/bytedance/android/live/base/model/message/guestlink/m;", "Lcom/bytedance/android/livesdk/message/model/o0;", "Lcom/bytedance/android/live/base/model/message/guestlink/i;", "Lvh7/c$a;", "Lvh7/e;", "R", "Ljava/lang/Class;", "type", "castToOrNull", "(Ljava/lang/Class;)Lvh7/e;", "castTo", "", "msgType", "I", "getMsgType", "()I", "setMsgType", "(I)V", "Lcom/bytedance/android/live/base/model/message/guestlink/e;", "invitationGuideContent", "Lcom/bytedance/android/live/base/model/message/guestlink/e;", "getInvitationGuideContent", "()Lcom/bytedance/android/live/base/model/message/guestlink/e;", "setInvitationGuideContent", "(Lcom/bytedance/android/live/base/model/message/guestlink/e;)V", "Lcom/bytedance/android/live/base/model/message/guestlink/f;", "inviteContent", "Lcom/bytedance/android/live/base/model/message/guestlink/f;", "getInviteContent", "()Lcom/bytedance/android/live/base/model/message/guestlink/f;", "setInviteContent", "(Lcom/bytedance/android/live/base/model/message/guestlink/f;)V", "Lcom/bytedance/android/live/base/model/message/guestlink/ILinkmicGuestLinkReplyContent;", "replyContent", "Lcom/bytedance/android/live/base/model/message/guestlink/ILinkmicGuestLinkReplyContent;", "getReplyContent", "()Lcom/bytedance/android/live/base/model/message/guestlink/ILinkmicGuestLinkReplyContent;", "setReplyContent", "(Lcom/bytedance/android/live/base/model/message/guestlink/ILinkmicGuestLinkReplyContent;)V", "Lcom/bytedance/android/live/base/model/message/guestlink/h;", "matchmakingContent", "Lcom/bytedance/android/live/base/model/message/guestlink/h;", "getMatchmakingContent", "()Lcom/bytedance/android/live/base/model/message/guestlink/h;", "setMatchmakingContent", "(Lcom/bytedance/android/live/base/model/message/guestlink/h;)V", "Lcom/bytedance/android/live/base/model/message/guestlink/j;", "replyMatchmakingContent", "Lcom/bytedance/android/live/base/model/message/guestlink/j;", "getReplyMatchmakingContent", "()Lcom/bytedance/android/live/base/model/message/guestlink/j;", "setReplyMatchmakingContent", "(Lcom/bytedance/android/live/base/model/message/guestlink/j;)V", "Lcom/bytedance/android/live/base/model/message/guestlink/g;", "joinChannelContent", "Lcom/bytedance/android/live/base/model/message/guestlink/g;", "getJoinChannelContent", "()Lcom/bytedance/android/live/base/model/message/guestlink/g;", "setJoinChannelContent", "(Lcom/bytedance/android/live/base/model/message/guestlink/g;)V", "Lcom/bytedance/android/live/base/model/message/guestlink/d;", "finishChannelContent", "Lcom/bytedance/android/live/base/model/message/guestlink/d;", "getFinishChannelContent", "()Lcom/bytedance/android/live/base/model/message/guestlink/d;", "setFinishChannelContent", "(Lcom/bytedance/android/live/base/model/message/guestlink/d;)V", "Lcom/bytedance/android/live/base/model/message/guestlink/b;", "updateChannelContent", "Lcom/bytedance/android/live/base/model/message/guestlink/b;", "getUpdateChannelContent", "()Lcom/bytedance/android/live/base/model/message/guestlink/b;", "setUpdateChannelContent", "(Lcom/bytedance/android/live/base/model/message/guestlink/b;)V", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/FlexModelDelegate;", "delegate", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/FlexModelDelegate;", "getDelegate", "()Lcom/bytedance/tools/kcp/modelx/runtime/internal/FlexModelDelegate;", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class m extends o0 implements i, vh7.c.a<i>, vh7.h {
    private final transient FlexModelDelegate<i> delegate;

    @SerializedName("finish_channel_content")
    protected d finishChannelContent;

    @SerializedName("invitation_guide_content")
    protected e invitationGuideContent;

    @SerializedName("invite_content")
    protected f inviteContent;

    @SerializedName("join_linked_channel_content")
    protected g joinChannelContent;

    @SerializedName("matchmaking_content")
    protected h matchmakingContent;

    @SerializedName("msg_type")
    protected int msgType;

    @SerializedName("reply_content")
    protected ILinkmicGuestLinkReplyContent replyContent;

    @SerializedName("reply_matchmaking_content")
    protected j replyMatchmakingContent;

    @SerializedName("channel_update_content")
    protected b updateChannelContent;

    public m() {
        this.delegate = new FlexModelDelegate(i.class, this);
        ((o0) this).type = MessageType.LINK_MIC_GUEST_LINK_MESSAGE;
    }

    public FlexModelDelegate<i> getDelegate() {
        return this.delegate;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.i
    public d getFinishChannelContent() {
        return this.finishChannelContent;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.i
    public e getInvitationGuideContent() {
        return this.invitationGuideContent;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.i
    public f getInviteContent() {
        return this.inviteContent;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.i
    public g getJoinChannelContent() {
        return this.joinChannelContent;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.i
    public h getMatchmakingContent() {
        return this.matchmakingContent;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.i
    public int getMsgType() {
        return this.msgType;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.i
    public ILinkmicGuestLinkReplyContent getReplyContent() {
        return this.replyContent;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.i
    public j getReplyMatchmakingContent() {
        return this.replyMatchmakingContent;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.i
    public b getUpdateChannelContent() {
        return this.updateChannelContent;
    }

    /* JADX WARN: Type inference failed for: r2v10, types: [com.bytedance.android.live.base.model.message.guestlink.b, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v12, types: [com.bytedance.android.live.base.model.message.guestlink.j, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v14, types: [com.bytedance.android.live.base.model.message.guestlink.g, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v16, types: [com.bytedance.android.live.base.model.message.guestlink.d, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.android.live.base.model.message.guestlink.e, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.bytedance.android.live.base.model.message.guestlink.f, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v6, types: [com.bytedance.android.live.base.model.message.guestlink.ILinkmicGuestLinkReplyContent, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v8, types: [com.bytedance.android.live.base.model.message.guestlink.h, java.lang.Object] */
    public m(am3.g r6) {
        this.delegate = new FlexModelDelegate(i.class, this);
        getDelegate().setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L21;
        am3.g.a r3 = getDelegate().decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        ((BaseMessage) this).baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r6);
        goto L3
    L8:
        if (r2 != 2) goto L9;
        this.msgType = r6.i();
        goto L3
    L9:
        switch(r2) {
            case 50: goto L18;
            case 51: goto L17;
            case 52: goto L16;
            case 53: goto L15;
            case 54: goto L14;
            case 55: goto L13;
            case 56: goto L12;
            case 57: goto L11;
            default: goto L10;
        };
    L11:
        this.finishChannelContent = vh7.f.a(r6, d.class);
        goto L3
    L12:
        this.joinChannelContent = vh7.f.a(r6, g.class);
        goto L3
    L13:
        this.replyMatchmakingContent = vh7.f.a(r6, j.class);
        goto L3
    L14:
        this.updateChannelContent = vh7.f.a(r6, b.class);
        goto L3
    L15:
        this.matchmakingContent = vh7.f.a(r6, h.class);
        goto L3
    L16:
        this.replyContent = vh7.f.a(r6, ILinkmicGuestLinkReplyContent.class);
        goto L3
    L17:
        this.inviteContent = vh7.f.a(r6, f.class);
        goto L3
    L18:
        this.invitationGuideContent = vh7.f.a(r6, e.class);
        goto L3
    L10:
        am3.h.d(r3, r6);
        goto L3
    L21:
        r6.d(r0);
        getDelegate().setThreadSafe(true);
        ((o0) this).type = MessageType.LINK_MIC_GUEST_LINK_MESSAGE;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.i
    public <R extends vh7.e<i>> R castTo(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return (R) getDelegate().castTo(r2);
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.i
    public <R extends vh7.e<i>> R castToOrNull(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return (R) getDelegate().castToOrNull(r2);
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.i
    public void setFinishChannelContent(d r1) {
        this.finishChannelContent = r1;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.i
    public void setInvitationGuideContent(e r1) {
        this.invitationGuideContent = r1;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.i
    public void setInviteContent(f r1) {
        this.inviteContent = r1;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.i
    public void setJoinChannelContent(g r1) {
        this.joinChannelContent = r1;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.i
    public void setMatchmakingContent(h r1) {
        this.matchmakingContent = r1;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.i
    public void setMsgType(int r1) {
        this.msgType = r1;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.i
    public void setReplyContent(ILinkmicGuestLinkReplyContent r1) {
        this.replyContent = r1;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.i
    public void setReplyMatchmakingContent(j r1) {
        this.replyMatchmakingContent = r1;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.i
    public void setUpdateChannelContent(b r1) {
        this.updateChannelContent = r1;
    }
}
