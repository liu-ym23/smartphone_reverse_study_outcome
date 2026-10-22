package com.bytedance.android.live.liveinteract.model;

import com.bytedance.android.livesdk.link.model.bridge.Linkmic2DAvatar;
import com.bytedance.android.livesdk.link.model.bridge.l1;
import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u0010^\u001a\u00020\u0002¢\u0006\u0004\b_\u0010`J.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tR\u001c\u0010\u0010\u001a\u00020\u000b8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0016\u001a\u00020\u00118\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0019\u001a\u00020\u00118\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001c\u0010\u001c\u001a\u00020\u00118\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001c\u0010\u001f\u001a\u00020\u00118\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015R\u001e\u0010%\u001a\u0004\u0018\u00010 8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010(\u001a\u00020\u00118\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b&\u0010\u0013\"\u0004\b'\u0010\u0015R\u001c\u0010+\u001a\u00020\u00118\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b)\u0010\u0013\"\u0004\b*\u0010\u0015R\u001c\u0010.\u001a\u00020 8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b,\u0010\"\"\u0004\b-\u0010$R\u001c\u00101\u001a\u00020 8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b/\u0010\"\"\u0004\b0\u0010$R\u0014\u00103\u001a\u0002028\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b3\u00104R\u0014\u00105\u001a\u0002028\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b5\u00104R\u001c\u00106\u001a\u0002028\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b6\u00104\"\u0004\b7\u00108R\u001c\u00109\u001a\u0002028\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b9\u00104\"\u0004\b:\u00108R\u001c\u0010=\u001a\u00020\u00118\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b;\u0010\u0013\"\u0004\b<\u0010\u0015R\u001e\u0010C\u001a\u0004\u0018\u00010>8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001c\u0010F\u001a\u00020\u000b8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\bD\u0010\r\"\u0004\bE\u0010\u000fR \u0010M\u001a\u00060Gj\u0002`H8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u001c\u0010P\u001a\u00020\u00118\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\bN\u0010\u0013\"\u0004\bO\u0010\u0015R\u0014\u0010R\u001a\u00020\u00118\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\bQ\u0010\u0013R\u001c\u0010U\u001a\u00020\u00118\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\bS\u0010\u0013\"\u0004\bT\u0010\u0015R\u0014\u0010W\u001a\u00020\u00118\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\bV\u0010\u0013R\u001c\u0010Z\u001a\u00020\u00118\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\bX\u0010\u0013\"\u0004\bY\u0010\u0015R\u001c\u0010]\u001a\u00020\u000b8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b[\u0010\r\"\u0004\b\\\u0010\u000f¨\u0006a"}, d2 = {"Lcom/bytedance/android/live/liveinteract/model/IListUserLinkMicAudienceContentExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/livesdk/link/model/bridge/l1;", "Lcom/bytedance/android/live/liveinteract/model/c;", "Lvh7/e;", "R", "Ljava/lang/Class;", "type", "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "", "getAiGuestType", "()I", "setAiGuestType", "(I)V", "aiGuestType", "", "getAppId", "()J", "setAppId", "(J)V", "appId", "getChorusGuestStatus", "setChorusGuestStatus", "chorusGuestStatus", "getClientVersion", "setClientVersion", "clientVersion", "getCurrentTime", "setCurrentTime", "currentTime", "", "getDevicePlatform", "()Ljava/lang/String;", "setDevicePlatform", "(Ljava/lang/String;)V", "devicePlatform", "getExpectLeaveTime", "setExpectLeaveTime", "expectLeaveTime", "getFanTicket", "setFanTicket", "fanTicket", "getFanTicketFuzzyStr", "setFanTicketFuzzyStr", "fanTicketFuzzyStr", "getFanTicketRealStr", "setFanTicketRealStr", "fanTicketRealStr", "", "isAnonymous", "()Z", "isEnlarged", "isHost", "setHost", "(Z)V", "isMicHidden", "setMicHidden", "getJoinChannelTime", "setJoinChannelTime", "joinChannelTime", "Lcom/bytedance/android/livesdk/link/model/bridge/Linkmic2DAvatar;", "getLinkmic2DAvatar", "()Lcom/bytedance/android/livesdk/link/model/bridge/Linkmic2DAvatar;", "setLinkmic2DAvatar", "(Lcom/bytedance/android/livesdk/link/model/bridge/Linkmic2DAvatar;)V", "linkmic2DAvatar", "getListUserRole", "setListUserRole", "listUserRole", "Lkd1/b;", "Lcom/bytedance/android/livesdk/link/model/bridge/IMicDress;", "getMicDress", "()Lkd1/b;", "setMicDress", "(Lkd1/b;)V", "micDress", "getOriginLinkType", "setOriginLinkType", "originLinkType", "getPaidCount", "paidCount", "getSelfDisciplineDurationTime", "setSelfDisciplineDurationTime", "selfDisciplineDurationTime", "getSelfDisciplineStartTime", "selfDisciplineStartTime", "getSelfDisciplineTargetDuration", "setSelfDisciplineTargetDuration", "selfDisciplineTargetDuration", "getThemedCompetitionRole", "setThemedCompetitionRole", "themedCompetitionRole", "base", "<init>", "(Lcom/bytedance/android/livesdk/link/model/bridge/l1;)V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public class IListUserLinkMicAudienceContentExtensionImpl extends ModelExtensionBase<l1, c> implements c, l1 {
    private final /* synthetic */ l1 $$delegate_0;

    @Override // com.bytedance.android.live.liveinteract.model.c
    public <R extends vh7.e<l1>> R castTo(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return (R) this.$$delegate_0.castTo(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.model.c
    public <R extends vh7.e<l1>> R castToOrNull(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return (R) this.$$delegate_0.castToOrNull(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.model.c
    public int getAiGuestType() {
        return this.$$delegate_0.getAiGuestType();
    }

    @Override // com.bytedance.android.live.liveinteract.model.c
    public long getAppId() {
        return this.$$delegate_0.getAppId();
    }

    @Override // com.bytedance.android.live.liveinteract.model.c
    public long getChorusGuestStatus() {
        return this.$$delegate_0.getChorusGuestStatus();
    }

    @Override // com.bytedance.android.live.liveinteract.model.c
    public long getClientVersion() {
        return this.$$delegate_0.getClientVersion();
    }

    @Override // com.bytedance.android.live.liveinteract.model.c
    public long getCurrentTime() {
        return this.$$delegate_0.getCurrentTime();
    }

    @Override // com.bytedance.android.live.liveinteract.model.c
    public String getDevicePlatform() {
        return this.$$delegate_0.getDevicePlatform();
    }

    @Override // com.bytedance.android.live.liveinteract.model.c
    public long getExpectLeaveTime() {
        return this.$$delegate_0.getExpectLeaveTime();
    }

    @Override // com.bytedance.android.live.liveinteract.model.c
    public long getFanTicket() {
        return this.$$delegate_0.getFanTicket();
    }

    @Override // com.bytedance.android.live.liveinteract.model.c
    public String getFanTicketFuzzyStr() {
        return this.$$delegate_0.getFanTicketFuzzyStr();
    }

    @Override // com.bytedance.android.live.liveinteract.model.c
    public String getFanTicketRealStr() {
        return this.$$delegate_0.getFanTicketRealStr();
    }

    @Override // com.bytedance.android.live.liveinteract.model.c
    public long getJoinChannelTime() {
        return this.$$delegate_0.getJoinChannelTime();
    }

    @Override // com.bytedance.android.live.liveinteract.model.c
    public Linkmic2DAvatar getLinkmic2DAvatar() {
        return this.$$delegate_0.getLinkmic2DAvatar();
    }

    @Override // com.bytedance.android.live.liveinteract.model.c
    public int getListUserRole() {
        return this.$$delegate_0.getListUserRole();
    }

    @Override // com.bytedance.android.live.liveinteract.model.c
    public kd1.b getMicDress() {
        return this.$$delegate_0.getMicDress();
    }

    @Override // com.bytedance.android.live.liveinteract.model.c
    public long getOriginLinkType() {
        return this.$$delegate_0.getOriginLinkType();
    }

    @Override // com.bytedance.android.live.liveinteract.model.c
    public long getPaidCount() {
        return this.$$delegate_0.getPaidCount();
    }

    @Override // com.bytedance.android.live.liveinteract.model.c
    public long getSelfDisciplineDurationTime() {
        return this.$$delegate_0.getSelfDisciplineDurationTime();
    }

    @Override // com.bytedance.android.live.liveinteract.model.c
    public long getSelfDisciplineStartTime() {
        return this.$$delegate_0.getSelfDisciplineStartTime();
    }

    @Override // com.bytedance.android.live.liveinteract.model.c
    public long getSelfDisciplineTargetDuration() {
        return this.$$delegate_0.getSelfDisciplineTargetDuration();
    }

    @Override // com.bytedance.android.live.liveinteract.model.c
    public int getThemedCompetitionRole() {
        return this.$$delegate_0.getThemedCompetitionRole();
    }

    @Override // com.bytedance.android.live.liveinteract.model.c
    public boolean isAnonymous() {
        return this.$$delegate_0.isAnonymous();
    }

    @Override // com.bytedance.android.live.liveinteract.model.c
    public boolean isEnlarged() {
        return this.$$delegate_0.isEnlarged();
    }

    @Override // com.bytedance.android.live.liveinteract.model.c
    public boolean isHost() {
        return this.$$delegate_0.isHost();
    }

    @Override // com.bytedance.android.live.liveinteract.model.c
    public boolean isMicHidden() {
        return this.$$delegate_0.isMicHidden();
    }

    @Override // com.bytedance.android.live.liveinteract.model.c
    public void setAiGuestType(int r2) {
        this.$$delegate_0.setAiGuestType(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.model.c
    public void setAppId(long r2) {
        this.$$delegate_0.setAppId(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.model.c
    public void setChorusGuestStatus(long r2) {
        this.$$delegate_0.setChorusGuestStatus(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.model.c
    public void setClientVersion(long r2) {
        this.$$delegate_0.setClientVersion(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.model.c
    public void setCurrentTime(long r2) {
        this.$$delegate_0.setCurrentTime(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.model.c
    public void setDevicePlatform(String r2) {
        this.$$delegate_0.setDevicePlatform(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.model.c
    public void setExpectLeaveTime(long r2) {
        this.$$delegate_0.setExpectLeaveTime(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.model.c
    public void setFanTicket(long r2) {
        this.$$delegate_0.setFanTicket(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.model.c
    public void setFanTicketFuzzyStr(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.$$delegate_0.setFanTicketFuzzyStr(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.model.c
    public void setFanTicketRealStr(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.$$delegate_0.setFanTicketRealStr(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.model.c
    public void setHost(boolean r2) {
        this.$$delegate_0.setHost(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.model.c
    public void setJoinChannelTime(long r2) {
        this.$$delegate_0.setJoinChannelTime(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.model.c
    public void setLinkmic2DAvatar(Linkmic2DAvatar r2) {
        this.$$delegate_0.setLinkmic2DAvatar(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.model.c
    public void setListUserRole(int r2) {
        this.$$delegate_0.setListUserRole(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.model.c
    public void setMicDress(kd1.b r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.$$delegate_0.setMicDress(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.model.c
    public void setMicHidden(boolean r2) {
        this.$$delegate_0.setMicHidden(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.model.c
    public void setOriginLinkType(long r2) {
        this.$$delegate_0.setOriginLinkType(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.model.c
    public void setSelfDisciplineDurationTime(long r2) {
        this.$$delegate_0.setSelfDisciplineDurationTime(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.model.c
    public void setSelfDisciplineTargetDuration(long r2) {
        this.$$delegate_0.setSelfDisciplineTargetDuration(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.model.c
    public void setThemedCompetitionRole(int r2) {
        this.$$delegate_0.setThemedCompetitionRole(r2);
    }

    public IListUserLinkMicAudienceContentExtensionImpl(l1 r2) {
        Intrinsics.checkNotNullParameter(r2, "base");
        super(r2);
        this.$$delegate_0 = r2;
    }
}
