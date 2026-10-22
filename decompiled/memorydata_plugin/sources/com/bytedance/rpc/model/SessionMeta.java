package com.bytedance.rpc.model;

import com.bytedance.crash.entity.Header;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class SessionMeta implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("agent_id")
    public long agentId;

    @SerializedName("app_id")
    public long appId;

    @SerializedName("biz_id")
    public long bizId;

    @SerializedName("bot_id")
    public long botId;

    @SerializedName("bot_version")
    public String botVersion;

    @SerializedName("device_id")
    public long deviceId;

    @SerializedName("device_info")
    public DeviceInfo deviceInfo;

    @SerializedName("first_install_time")
    public long firstInstallTime;

    @SerializedName("is_ai_playground")
    public boolean isAiPlayground;

    @SerializedName("is_HKMO")
    public boolean isHKMO;

    @SerializedName("is_minor")
    public boolean isMinor;

    @SerializedName("is_new_user")
    public boolean isNewUser;

    @SerializedName("is_tour")
    public boolean isTour;
    public String lang;
    public LocationInfo location;

    @SerializedName("registration_time")
    public long registrationTime;

    @SerializedName("scene_type")
    public SceneType sceneType;

    @SerializedName("tea_uuid")
    public String teaUuid;

    @SerializedName("tenant_id")
    public long tenantId;

    @SerializedName(Header.KEY_USER_ID)
    public long userId;

    @SerializedName("voice_info")
    public VoiceInfo voiceInfo;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public SessionMeta() {
    }
}
