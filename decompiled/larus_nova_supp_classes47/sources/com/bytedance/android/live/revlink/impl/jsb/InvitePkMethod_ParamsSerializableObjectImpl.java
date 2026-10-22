package com.bytedance.android.live.revlink.impl.jsb;

import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b \u0010!R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001a\u0010\u0010\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001a\u0010\u0013\u001a\u00020\u00128\u0006X\u0087D¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/jsb/InvitePkMethod_ParamsSerializableObjectImpl;", "Lcom/bytedance/android/live/revlink/impl/jsb/n$a;", "", "toUserId", "Ljava/lang/String;", "getToUserId", "()Ljava/lang/String;", "", "toRoomId", "J", "getToRoomId", "()J", "secToUid", "L2", "signExtra", "getSignExtra", "battleConfigSetting", "getBattleConfigSetting", "", Constants.Keys.duration, "I", "getDuration", "()I", "inviteType", "Ljava/lang/Integer;", "getInviteType", "()Ljava/lang/Integer;", "Lcom/google/gson/JsonObject;", "extra", "Lcom/google/gson/JsonObject;", "getExtra", "()Lcom/google/gson/JsonObject;", "<init>", "()V", "Adapter", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class InvitePkMethod_ParamsSerializableObjectImpl implements n.a {

    @SerializedName("battle_config_setting")
    private final String battleConfigSetting;

    @SerializedName(Constants.Keys.duration)
    private final int duration;

    @SerializedName("extra")
    private final JsonObject extra;

    @SerializedName("invite_type")
    private final Integer inviteType;

    @SerializedName("sec_to_user_id")
    private final String secToUid;

    @SerializedName("sign_extra")
    private final String signExtra;

    @SerializedName("to_room_id")
    private final long toRoomId;

    @SerializedName("to_user_id")
    private final String toUserId;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/jsb/InvitePkMethod_ParamsSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(InvitePkMethod_ParamsSerializableObjectImpl.class);
        }
    }

    public InvitePkMethod_ParamsSerializableObjectImpl() {
        this.toUserId = "";
        this.secToUid = "";
        this.signExtra = "";
        this.battleConfigSetting = "";
    }

    @Override // com.bytedance.android.live.revlink.impl.jsb.n.a
    public final String L2() {
        return this.secToUid;
    }

    @Override // com.bytedance.android.live.revlink.impl.jsb.n.a
    public final String getBattleConfigSetting() {
        return this.battleConfigSetting;
    }

    @Override // com.bytedance.android.live.revlink.impl.jsb.n.a
    public final int getDuration() {
        return this.duration;
    }

    @Override // com.bytedance.android.live.revlink.impl.jsb.n.a
    public final JsonObject getExtra() {
        return this.extra;
    }

    @Override // com.bytedance.android.live.revlink.impl.jsb.n.a
    public final Integer getInviteType() {
        return this.inviteType;
    }

    @Override // com.bytedance.android.live.revlink.impl.jsb.n.a
    public final String getSignExtra() {
        return this.signExtra;
    }

    @Override // com.bytedance.android.live.revlink.impl.jsb.n.a
    public final long getToRoomId() {
        return this.toRoomId;
    }

    @Override // com.bytedance.android.live.revlink.impl.jsb.n.a
    public final String getToUserId() {
        return this.toUserId;
    }
}
