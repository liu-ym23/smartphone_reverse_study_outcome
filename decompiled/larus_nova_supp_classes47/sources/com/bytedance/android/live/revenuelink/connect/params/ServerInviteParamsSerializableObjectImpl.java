package com.bytedance.android.live.revenuelink.connect.params;

import com.bytedance.android.live.saas.middleware.store.FileUtils;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import d11.j;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b9\u0018\u00002\u00020\u0001:\u0001`B\u0007¢\u0006\u0004\b^\u0010_R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\"\u0010\u0019\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\"\u0010\u001c\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0011\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015R\"\u0010\u001f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR\"\u0010\"\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0004\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\bR\"\u0010%\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0011\u001a\u0004\b&\u0010\u0013\"\u0004\b'\u0010\u0015R\"\u0010)\u001a\u00020(8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u0010/\u001a\u00020(8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u0010*\u001a\u0004\b0\u0010,\"\u0004\b1\u0010.R\"\u00102\u001a\u00020(8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u0010*\u001a\u0004\b3\u0010,\"\u0004\b\u0004\u0010.R\"\u00104\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b4\u0010\u0004\u001a\u0004\b5\u0010\u0006\"\u0004\b6\u0010\bR\"\u00107\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b7\u0010\u0011\u001a\u0004\b8\u0010\u0013\"\u0004\b9\u0010\u0015R\"\u0010:\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b:\u0010\u0011\u001a\u0004\b;\u0010\u0013\"\u0004\b<\u0010\u0015R\"\u0010=\u001a\u00020(8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b=\u0010*\u001a\u0004\b>\u0010,\"\u0004\b?\u0010.R\"\u0010@\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b@\u0010\u0011\u001a\u0004\bA\u0010\u0013\"\u0004\bB\u0010\u0015R\"\u0010C\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bC\u0010\u0011\u001a\u0004\bD\u0010\u0013\"\u0004\bE\u0010\u0015R\"\u0010F\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bF\u0010\u0011\u001a\u0004\bG\u0010\u0013\"\u0004\bH\u0010\u0015R\"\u0010I\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bI\u0010\u0004\u001a\u0004\bJ\u0010\u0006\"\u0004\bK\u0010\bR\"\u0010L\u001a\u00020(8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bL\u0010*\u001a\u0004\bM\u0010,\"\u0004\bN\u0010.R\"\u0010O\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bO\u0010\u0004\u001a\u0004\bP\u0010\u0006\"\u0004\bQ\u0010\bR\"\u0010R\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bR\u0010\u0004\u001a\u0004\bS\u0010\u0006\"\u0004\bT\u0010\bR\"\u0010U\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bU\u0010\u0004\u001a\u0004\bV\u0010\u0006\"\u0004\bW\u0010\bR\"\u0010X\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bX\u0010\u0011\u001a\u0004\bY\u0010\u0013\"\u0004\bZ\u0010\u0015R\"\u0010[\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b[\u0010\u0011\u001a\u0004\b\\\u0010\u0013\"\u0004\b]\u0010\u0015¨\u0006a"}, d2 = {"Lcom/bytedance/android/live/revenuelink/connect/params/ServerInviteParamsSerializableObjectImpl;", "Ld11/j;", "", "roomId", "J", "getRoomId", "()J", "setRoomId", "(J)V", "toRoomId", "getToRoomId", "f", "toUserId", "getToUserId", "setToUserId", "", "matchType", "Ljava/lang/String;", "getMatchType", "()Ljava/lang/String;", "s8", "(Ljava/lang/String;)V", Constants.Keys.duration, "getDuration", "setDuration", FileUtils.PICTURE_THEME, "getTheme", "setTheme", "secToUserId", "l", "g", "inviteType", "getInviteType", "A7", "scene", "getScene", "setScene", "activityName", "getActivityName", "e1", "", "matchSubType", "I", "p1", "()I", "d9", "(I)V", "inviteSource", "getInviteSource", "k3", "multiPkMode", "getMultiPkMode", "inviteeScene", "y5", "m7", "inviteeFollowedUserIds", "getInviteeFollowedUserIds", "setInviteeFollowedUserIds", "battleConfigSetting", "getBattleConfigSetting", "d8", "inviteStatus", "getInviteStatus", "p9", "battleAttachedInfo", "getBattleAttachedInfo", "setBattleAttachedInfo", "clientAttachedInfo", "getClientAttachedInfo", "h", "openGameAppId", "s", "n", "channelId", "getChannelId", "setChannelId", "bizType", "getBizType", "setBizType", "bitrateKbps", "j", "F", "resolutionWidth", "K", "E", "resolutionHeight", "x", "B", "toOpenId", "getToOpenId", "setToOpenId", "inviteeFollowedUserOpenIds", "Q6", "G4", "<init>", "()V", "Adapter", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ServerInviteParamsSerializableObjectImpl implements j {

    @SerializedName("activity_name")
    private String activityName;

    @SerializedName("battle_attached_info")
    private String battleAttachedInfo;

    @SerializedName("battle_config_setting")
    private String battleConfigSetting;

    @SerializedName("bitrate_kbps")
    private long bitrateKbps;

    @SerializedName("biz_type")
    private int bizType;

    @SerializedName("channel_id")
    private long channelId;

    @SerializedName("client_attached_info")
    private String clientAttachedInfo;

    @SerializedName(Constants.Keys.duration)
    private long duration;

    @SerializedName("invite_source")
    private int inviteSource;

    @SerializedName("invite_status")
    private int inviteStatus;

    @SerializedName("invite_type")
    private long inviteType;

    @SerializedName("invitee_followed_user_ids")
    private String inviteeFollowedUserIds;

    @SerializedName("invitee_followed_user_open_ids")
    private String inviteeFollowedUserOpenIds;

    @SerializedName("invitee_scene")
    private long inviteeScene;

    @SerializedName("match_sub_type")
    private int matchSubType;

    @SerializedName("match_type")
    private String matchType;

    @SerializedName("multi_pk_mode")
    private int multiPkMode;

    @SerializedName("open_game_app_id")
    private String openGameAppId;

    @SerializedName("resolution_height")
    private long resolutionHeight;

    @SerializedName("resolution_width")
    private long resolutionWidth;

    @SerializedName("room_id")
    private long roomId;

    @SerializedName("scene")
    private long scene;

    @SerializedName("sec_to_user_id")
    private String secToUserId;

    @SerializedName(FileUtils.PICTURE_THEME)
    private String theme;

    @SerializedName("to_open_id")
    private String toOpenId;

    @SerializedName("to_room_id")
    private long toRoomId;

    @SerializedName("to_user_id")
    private long toUserId;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revenuelink/connect/params/ServerInviteParamsSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(ServerInviteParamsSerializableObjectImpl.class);
        }
    }

    public ServerInviteParamsSerializableObjectImpl() {
        this.matchType = "";
        this.theme = "";
        this.secToUserId = "";
        this.activityName = "";
        this.inviteeFollowedUserIds = "";
        this.battleConfigSetting = "";
        this.battleAttachedInfo = "";
        this.clientAttachedInfo = "";
        this.openGameAppId = "";
        this.toOpenId = "";
        this.inviteeFollowedUserOpenIds = "";
    }

    @Override // d11.j
    public final long K() {
        return this.resolutionWidth;
    }

    @Override // d11.j
    public final String Q6() {
        return this.inviteeFollowedUserOpenIds;
    }

    @Override // d11.j
    public final String getActivityName() {
        return this.activityName;
    }

    @Override // d11.j
    public final String getBattleAttachedInfo() {
        return this.battleAttachedInfo;
    }

    @Override // d11.j
    public final String getBattleConfigSetting() {
        return this.battleConfigSetting;
    }

    @Override // d11.j
    public final int getBizType() {
        return this.bizType;
    }

    @Override // d11.j
    public final long getChannelId() {
        return this.channelId;
    }

    @Override // d11.j
    public final String getClientAttachedInfo() {
        return this.clientAttachedInfo;
    }

    @Override // d11.j
    public final long getDuration() {
        return this.duration;
    }

    @Override // d11.j
    public final int getInviteSource() {
        return this.inviteSource;
    }

    @Override // d11.j
    public final int getInviteStatus() {
        return this.inviteStatus;
    }

    @Override // d11.j
    public final long getInviteType() {
        return this.inviteType;
    }

    @Override // d11.j
    public final String getMatchType() {
        return this.matchType;
    }

    @Override // d11.j
    public final int getMultiPkMode() {
        return this.multiPkMode;
    }

    @Override // d11.j
    public final long getRoomId() {
        return this.roomId;
    }

    @Override // d11.j
    public final long getScene() {
        return this.scene;
    }

    @Override // d11.j
    public final String getTheme() {
        return this.theme;
    }

    @Override // d11.j
    public final String getToOpenId() {
        return this.toOpenId;
    }

    @Override // d11.j
    public final long getToRoomId() {
        return this.toRoomId;
    }

    @Override // d11.j
    public final long j() {
        return this.bitrateKbps;
    }

    @Override // d11.j
    public final String l() {
        return this.secToUserId;
    }

    @Override // d11.j
    public final int p1() {
        return this.matchSubType;
    }

    @Override // d11.j
    public final String s() {
        return this.openGameAppId;
    }

    @Override // d11.j
    public final long x() {
        return this.resolutionHeight;
    }

    @Override // d11.j
    public final long y5() {
        return this.inviteeScene;
    }

    @Override // d11.j
    public final void A7(long r1) {
        this.inviteType = r1;
    }

    @Override // d11.j
    public final void B(long r1) {
        this.resolutionHeight = r1;
    }

    @Override // d11.j
    public final void E(long r1) {
        this.resolutionWidth = r1;
    }

    @Override // d11.j
    public final void F(long r1) {
        this.bitrateKbps = r1;
    }

    @Override // d11.j
    public final void G4(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.inviteeFollowedUserOpenIds = r2;
    }

    @Override // d11.j
    public final void J(int r1) {
        this.multiPkMode = r1;
    }

    @Override // d11.j
    public final void d8(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.battleConfigSetting = r2;
    }

    @Override // d11.j
    public final void d9(int r1) {
        this.matchSubType = r1;
    }

    @Override // d11.j
    public final void e1(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.activityName = r2;
    }

    @Override // d11.j
    public final void f(long r1) {
        this.toRoomId = r1;
    }

    @Override // d11.j
    public final void g(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.secToUserId = r2;
    }

    @Override // d11.j
    public final void h(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.clientAttachedInfo = r2;
    }

    @Override // d11.j
    public final void k3(int r1) {
        this.inviteSource = r1;
    }

    @Override // d11.j
    public final void m7(long r1) {
        this.inviteeScene = r1;
    }

    @Override // d11.j
    public final void n(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.openGameAppId = r2;
    }

    @Override // d11.j
    public final void p9(int r1) {
        this.inviteStatus = r1;
    }

    @Override // d11.j
    public final void s8(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.matchType = r2;
    }

    @Override // d11.j
    public final void setBattleAttachedInfo(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.battleAttachedInfo = r2;
    }

    @Override // d11.j
    public final void setBizType(int r1) {
        this.bizType = r1;
    }

    @Override // d11.j
    public final void setChannelId(long r1) {
        this.channelId = r1;
    }

    @Override // d11.j
    public final void setDuration(long r1) {
        this.duration = r1;
    }

    @Override // d11.j
    public final void setRoomId(long r1) {
        this.roomId = r1;
    }

    @Override // d11.j
    public final void setScene(long r1) {
        this.scene = r1;
    }

    @Override // d11.j
    public final void setTheme(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.theme = r2;
    }

    @Override // d11.j
    public final void setToOpenId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.toOpenId = r2;
    }

    @Override // d11.j
    public final void setToUserId(long r1) {
        this.toUserId = r1;
    }
}
