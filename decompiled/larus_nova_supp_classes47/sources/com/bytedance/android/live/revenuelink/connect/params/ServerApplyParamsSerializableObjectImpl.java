package com.bytedance.android.live.revenuelink.connect.params;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import d11.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0019\u0018\u00002\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b%\u0010&R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR\"\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR\"\u0010\u001f\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0011\u001a\u0004\b \u0010\u0013\"\u0004\b!\u0010\u0015R\"\u0010\"\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0011\u001a\u0004\b#\u0010\u0013\"\u0004\b$\u0010\u0015¨\u0006("}, d2 = {"Lcom/bytedance/android/live/revenuelink/connect/params/ServerApplyParamsSerializableObjectImpl;", "Ld11/h;", "", "roomId", "J", "getRoomId", "()J", "setRoomId", "(J)V", "toRoomId", "getToRoomId", "f", "toUserId", "getToUserId", "setToUserId", "", "secToUserId", "Ljava/lang/String;", "l", "()Ljava/lang/String;", "g", "(Ljava/lang/String;)V", "applyType", "getApplyType", "X3", "scene", "getScene", "setScene", "channelId", "getChannelId", "setChannelId", "clientAttachedInfo", "getClientAttachedInfo", "h", "toOpenId", "getToOpenId", "setToOpenId", "<init>", "()V", "Adapter", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ServerApplyParamsSerializableObjectImpl implements h {

    @SerializedName("apply_type")
    private long applyType;

    @SerializedName("channel_id")
    private long channelId;

    @SerializedName("client_attached_info")
    private String clientAttachedInfo;

    @SerializedName("room_id")
    private long roomId;

    @SerializedName("scene")
    private long scene;

    @SerializedName("sec_to_user_id")
    private String secToUserId;

    @SerializedName("to_open_id")
    private String toOpenId;

    @SerializedName("to_room_id")
    private long toRoomId;

    @SerializedName("to_user_id")
    private long toUserId;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revenuelink/connect/params/ServerApplyParamsSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(ServerApplyParamsSerializableObjectImpl.class);
        }
    }

    public ServerApplyParamsSerializableObjectImpl() {
        this.secToUserId = "";
        this.clientAttachedInfo = "";
        this.toOpenId = "";
    }

    @Override // d11.h
    public final long getApplyType() {
        return this.applyType;
    }

    @Override // d11.h
    public final long getChannelId() {
        return this.channelId;
    }

    @Override // d11.h
    public final String getClientAttachedInfo() {
        return this.clientAttachedInfo;
    }

    @Override // d11.h
    public final long getRoomId() {
        return this.roomId;
    }

    @Override // d11.h
    public final long getScene() {
        return this.scene;
    }

    @Override // d11.h
    public final String getToOpenId() {
        return this.toOpenId;
    }

    @Override // d11.h
    public final long getToRoomId() {
        return this.toRoomId;
    }

    @Override // d11.h
    public final String l() {
        return this.secToUserId;
    }

    @Override // d11.h
    public final void X3(long r1) {
        this.applyType = r1;
    }

    @Override // d11.h
    public final void f(long r1) {
        this.toRoomId = r1;
    }

    @Override // d11.h
    public final void g(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.secToUserId = r2;
    }

    @Override // d11.h
    public final void h(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.clientAttachedInfo = r2;
    }

    @Override // d11.h
    public final void setChannelId(long r1) {
        this.channelId = r1;
    }

    @Override // d11.h
    public final void setRoomId(long r1) {
        this.roomId = r1;
    }

    @Override // d11.h
    public final void setScene(long r1) {
        this.scene = r1;
    }

    @Override // d11.h
    public final void setToOpenId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.toOpenId = r2;
    }
}
