package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class VideocutUserInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public int gender;

    @SerializedName("is_trail")
    public int isTrail;

    @SerializedName("is_vip")
    public int isVip;

    @SerializedName("last_30d_loc")
    public String last30dLoc;

    @SerializedName("last_loc")
    public String lastLoc;
    public String loc;

    @SerializedName("user_age_level")
    public String userAgeLevel;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public VideocutUserInfo() {
    }
}
