package com.bytedance.android.live.liveinteract.multianchor.model;

import com.bytedance.android.live.base.model.message.guestlink.ILinkmicGuestLinkReplyContent;
import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u0010H\u001a\u00020\u0002¢\u0006\u0004\bI\u0010JJ.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tR(\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00128\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u00188\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010#\u001a\u0004\u0018\u00010\u001e8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010)\u001a\u0004\u0018\u00010$8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001e\u0010/\u001a\u0004\u0018\u00010*8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001c\u00105\u001a\u0002008\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001e\u0010;\u001a\u0004\u0018\u0001068\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001e\u0010A\u001a\u0004\u0018\u00010<8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001e\u0010G\u001a\u0004\u0018\u00010B8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\bC\u0010D\"\u0004\bE\u0010F¨\u0006K"}, d2 = {"Lcom/bytedance/android/live/liveinteract/multianchor/model/IMultiLinkmicGuestLinkMessageExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/live/base/model/message/guestlink/i;", "Lcom/bytedance/android/live/liveinteract/multianchor/model/g;", "Lvh7/e;", "R", "Ljava/lang/Class;", "type", "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "Lcom/bytedance/android/live/base/model/message/m0;", "value", "getCommonData", "()Lcom/bytedance/android/live/base/model/message/m0;", "setCommonData", "(Lcom/bytedance/android/live/base/model/message/m0;)V", "commonData", "Lcom/bytedance/android/live/base/model/message/guestlink/d;", "getFinishChannelContent", "()Lcom/bytedance/android/live/base/model/message/guestlink/d;", "setFinishChannelContent", "(Lcom/bytedance/android/live/base/model/message/guestlink/d;)V", "finishChannelContent", "Lcom/bytedance/android/live/base/model/message/guestlink/e;", "getInvitationGuideContent", "()Lcom/bytedance/android/live/base/model/message/guestlink/e;", "setInvitationGuideContent", "(Lcom/bytedance/android/live/base/model/message/guestlink/e;)V", "invitationGuideContent", "Lcom/bytedance/android/live/base/model/message/guestlink/f;", "getInviteContent", "()Lcom/bytedance/android/live/base/model/message/guestlink/f;", "setInviteContent", "(Lcom/bytedance/android/live/base/model/message/guestlink/f;)V", "inviteContent", "Lcom/bytedance/android/live/base/model/message/guestlink/g;", "getJoinChannelContent", "()Lcom/bytedance/android/live/base/model/message/guestlink/g;", "setJoinChannelContent", "(Lcom/bytedance/android/live/base/model/message/guestlink/g;)V", "joinChannelContent", "Lcom/bytedance/android/live/base/model/message/guestlink/h;", "getMatchmakingContent", "()Lcom/bytedance/android/live/base/model/message/guestlink/h;", "setMatchmakingContent", "(Lcom/bytedance/android/live/base/model/message/guestlink/h;)V", "matchmakingContent", "", "getMsgType", "()I", "setMsgType", "(I)V", "msgType", "Lcom/bytedance/android/live/base/model/message/guestlink/ILinkmicGuestLinkReplyContent;", "getReplyContent", "()Lcom/bytedance/android/live/base/model/message/guestlink/ILinkmicGuestLinkReplyContent;", "setReplyContent", "(Lcom/bytedance/android/live/base/model/message/guestlink/ILinkmicGuestLinkReplyContent;)V", "replyContent", "Lcom/bytedance/android/live/base/model/message/guestlink/j;", "getReplyMatchmakingContent", "()Lcom/bytedance/android/live/base/model/message/guestlink/j;", "setReplyMatchmakingContent", "(Lcom/bytedance/android/live/base/model/message/guestlink/j;)V", "replyMatchmakingContent", "Lcom/bytedance/android/live/base/model/message/guestlink/b;", "getUpdateChannelContent", "()Lcom/bytedance/android/live/base/model/message/guestlink/b;", "setUpdateChannelContent", "(Lcom/bytedance/android/live/base/model/message/guestlink/b;)V", "updateChannelContent", "base", "<init>", "(Lcom/bytedance/android/live/base/model/message/guestlink/i;)V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public class IMultiLinkmicGuestLinkMessageExtensionImpl extends ModelExtensionBase<com.bytedance.android.live.base.model.message.guestlink.i, g> implements g, com.bytedance.android.live.base.model.message.guestlink.i {
    private final /* synthetic */ com.bytedance.android.live.base.model.message.guestlink.i $$delegate_0;

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.g
    public <R extends vh7.e<com.bytedance.android.live.base.model.message.guestlink.i>> R castTo(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return (R) this.$$delegate_0.castTo(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.g
    public <R extends vh7.e<com.bytedance.android.live.base.model.message.guestlink.i>> R castToOrNull(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return (R) this.$$delegate_0.castToOrNull(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.g
    public m0 getCommonData() {
        return (m0) get(1, g.class);
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.g
    public com.bytedance.android.live.base.model.message.guestlink.d getFinishChannelContent() {
        return this.$$delegate_0.getFinishChannelContent();
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.g
    public com.bytedance.android.live.base.model.message.guestlink.e getInvitationGuideContent() {
        return this.$$delegate_0.getInvitationGuideContent();
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.g
    public com.bytedance.android.live.base.model.message.guestlink.f getInviteContent() {
        return this.$$delegate_0.getInviteContent();
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.g
    public com.bytedance.android.live.base.model.message.guestlink.g getJoinChannelContent() {
        return this.$$delegate_0.getJoinChannelContent();
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.g
    public com.bytedance.android.live.base.model.message.guestlink.h getMatchmakingContent() {
        return this.$$delegate_0.getMatchmakingContent();
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.g
    public int getMsgType() {
        return this.$$delegate_0.getMsgType();
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.g
    public ILinkmicGuestLinkReplyContent getReplyContent() {
        return this.$$delegate_0.getReplyContent();
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.g
    public com.bytedance.android.live.base.model.message.guestlink.j getReplyMatchmakingContent() {
        return this.$$delegate_0.getReplyMatchmakingContent();
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.g
    public com.bytedance.android.live.base.model.message.guestlink.b getUpdateChannelContent() {
        return this.$$delegate_0.getUpdateChannelContent();
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.g
    public void setFinishChannelContent(com.bytedance.android.live.base.model.message.guestlink.d r2) {
        this.$$delegate_0.setFinishChannelContent(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.g
    public void setInvitationGuideContent(com.bytedance.android.live.base.model.message.guestlink.e r2) {
        this.$$delegate_0.setInvitationGuideContent(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.g
    public void setInviteContent(com.bytedance.android.live.base.model.message.guestlink.f r2) {
        this.$$delegate_0.setInviteContent(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.g
    public void setJoinChannelContent(com.bytedance.android.live.base.model.message.guestlink.g r2) {
        this.$$delegate_0.setJoinChannelContent(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.g
    public void setMatchmakingContent(com.bytedance.android.live.base.model.message.guestlink.h r2) {
        this.$$delegate_0.setMatchmakingContent(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.g
    public void setMsgType(int r2) {
        this.$$delegate_0.setMsgType(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.g
    public void setReplyContent(ILinkmicGuestLinkReplyContent r2) {
        this.$$delegate_0.setReplyContent(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.g
    public void setReplyMatchmakingContent(com.bytedance.android.live.base.model.message.guestlink.j r2) {
        this.$$delegate_0.setReplyMatchmakingContent(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.g
    public void setUpdateChannelContent(com.bytedance.android.live.base.model.message.guestlink.b r2) {
        this.$$delegate_0.setUpdateChannelContent(r2);
    }

    public IMultiLinkmicGuestLinkMessageExtensionImpl(com.bytedance.android.live.base.model.message.guestlink.i r2) {
        Intrinsics.checkNotNullParameter(r2, "base");
        super(r2);
        this.$$delegate_0 = r2;
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.g
    public void setCommonData(m0 r4) {
        set(1, "common", g.class, r4);
    }
}
