package com.bytedance.android.live.revenuelink.connect.params;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import d11.l;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b$\u0018\u00002\u00020\u0001:\u0001?B\u0007¢\u0006\u0004\b=\u0010>R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR\"\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b\u0004\u0010!R\"\u0010\"\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u001e\u001a\u0004\b#\u0010 \"\u0004\b$\u0010!R\"\u0010%\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0006\"\u0004\b'\u0010\bR\"\u0010(\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010\u0014\u001a\u0004\b)\u0010\u0016\"\u0004\b*\u0010\u0018R\"\u0010+\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010\u0014\u001a\u0004\b,\u0010\u0016\"\u0004\b-\u0010\u0018R\"\u0010.\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010\u001e\u001a\u0004\b/\u0010 \"\u0004\b0\u0010!R\"\u00101\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b1\u0010\u0004\u001a\u0004\b2\u0010\u0006\"\u0004\b3\u0010\bR\"\u00104\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b4\u0010\u0004\u001a\u0004\b5\u0010\u0006\"\u0004\b6\u0010\bR\"\u00107\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b7\u0010\u0004\u001a\u0004\b8\u0010\u0006\"\u0004\b9\u0010\bR\"\u0010:\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b:\u0010\u0014\u001a\u0004\b;\u0010\u0016\"\u0004\b<\u0010\u0018¨\u0006@"}, d2 = {"Lcom/bytedance/android/live/revenuelink/connect/params/ServerReplyParamsSerializableObjectImpl;", "Ld11/l;", "", "channelId", "J", "getChannelId", "()J", "setChannelId", "(J)V", "replyStatus", "getReplyStatus", "F8", "roomId", "getRoomId", "setRoomId", "inviteUserId", "getInviteUserId", "setInviteUserId", "", "secInviteUserId", "Ljava/lang/String;", "N8", "()Ljava/lang/String;", "k7", "(Ljava/lang/String;)V", "scene", "getScene", "setScene", "", "multiPkMode", "I", "getMultiPkMode", "()I", "(I)V", "switchPlayMode", "getSwitchPlayMode", "p4", "matchType", "getMatchType", "setMatchType", "clientAttachedInfo", "getClientAttachedInfo", "h", "openGameAppId", "s", "n", "bizType", "getBizType", "setBizType", "bitrateKbps", "j", "F", "resolutionWidth", "K", "E", "resolutionHeight", "x", "B", "inviteOpenId", "V5", "R7", "<init>", "()V", "Adapter", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ServerReplyParamsSerializableObjectImpl implements l {

    @SerializedName("bitrate_kbps")
    private long bitrateKbps;

    @SerializedName("biz_type")
    private int bizType;

    @SerializedName("channel_id")
    private long channelId;

    @SerializedName("client_attached_info")
    private String clientAttachedInfo;

    @SerializedName("invite_open_id")
    private String inviteOpenId;

    @SerializedName("invite_user_id")
    private long inviteUserId;

    @SerializedName("match_type")
    private long matchType;

    @SerializedName("multi_pk_mode")
    private int multiPkMode;

    @SerializedName("open_game_app_id")
    private String openGameAppId;

    @SerializedName("reply_status")
    private long replyStatus;

    @SerializedName("resolution_height")
    private long resolutionHeight;

    @SerializedName("resolution_width")
    private long resolutionWidth;

    @SerializedName("room_id")
    private long roomId;

    @SerializedName("scene")
    private long scene;

    @SerializedName("sec_invite_user_id")
    private String secInviteUserId;

    @SerializedName("switch_play_mode")
    private int switchPlayMode;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revenuelink/connect/params/ServerReplyParamsSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(ServerReplyParamsSerializableObjectImpl.class);
        }
    }

    public ServerReplyParamsSerializableObjectImpl() {
        this.secInviteUserId = "";
        this.clientAttachedInfo = "";
        this.openGameAppId = "";
        this.inviteOpenId = "";
    }

    @Override // d11.l
    public final long K() {
        return this.resolutionWidth;
    }

    @Override // d11.l
    public final String N8() {
        return this.secInviteUserId;
    }

    @Override // d11.l
    public final String V5() {
        return this.inviteOpenId;
    }

    @Override // d11.l
    public final int getBizType() {
        return this.bizType;
    }

    @Override // d11.l
    public final long getChannelId() {
        return this.channelId;
    }

    @Override // d11.l
    public final String getClientAttachedInfo() {
        return this.clientAttachedInfo;
    }

    @Override // d11.l
    public final long getMatchType() {
        return this.matchType;
    }

    @Override // d11.l
    public final int getMultiPkMode() {
        return this.multiPkMode;
    }

    @Override // d11.l
    public final long getReplyStatus() {
        return this.replyStatus;
    }

    @Override // d11.l
    public final long getRoomId() {
        return this.roomId;
    }

    @Override // d11.l
    public final long getScene() {
        return this.scene;
    }

    @Override // d11.l
    public final int getSwitchPlayMode() {
        return this.switchPlayMode;
    }

    @Override // d11.l
    public final long j() {
        return this.bitrateKbps;
    }

    @Override // d11.l
    public final String s() {
        return this.openGameAppId;
    }

    @Override // d11.l
    public final long x() {
        return this.resolutionHeight;
    }

    @Override // d11.l
    public final void B(long r1) {
        this.resolutionHeight = r1;
    }

    @Override // d11.l
    public final void E(long r1) {
        this.resolutionWidth = r1;
    }

    @Override // d11.l
    public final void F(long r1) {
        this.bitrateKbps = r1;
    }

    @Override // d11.l
    public final void F8(long r1) {
        this.replyStatus = r1;
    }

    @Override // d11.l
    public final void J(int r1) {
        this.multiPkMode = r1;
    }

    @Override // d11.l
    public final void R7(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.inviteOpenId = r2;
    }

    @Override // d11.l
    public final void h(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.clientAttachedInfo = r2;
    }

    @Override // d11.l
    public final void k7(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.secInviteUserId = r2;
    }

    @Override // d11.l
    public final void n(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.openGameAppId = r2;
    }

    @Override // d11.l
    public final void p4(int r1) {
        this.switchPlayMode = r1;
    }

    @Override // d11.l
    public final void setBizType(int r1) {
        this.bizType = r1;
    }

    @Override // d11.l
    public final void setChannelId(long r1) {
        this.channelId = r1;
    }

    @Override // d11.l
    public final void setMatchType(long r1) {
        this.matchType = r1;
    }

    @Override // d11.l
    public final void setRoomId(long r1) {
        this.roomId = r1;
    }

    @Override // d11.l
    public final void setScene(long r1) {
        this.scene = r1;
    }
}
