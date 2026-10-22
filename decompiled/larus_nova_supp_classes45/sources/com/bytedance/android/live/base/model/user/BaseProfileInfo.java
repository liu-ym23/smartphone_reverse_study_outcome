package com.bytedance.android.live.base.model.user;

import android.text.TextUtils;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public class BaseProfileInfo extends FlexModelBase<k> implements k {

    @SerializedName("age")
    public int age;

    @SerializedName("avatar_large")
    public py.k avatarLarge;

    @SerializedName("avatar_medium")
    public py.k avatarMedium;

    @SerializedName("avatar_thumb")
    public py.k avatarThumb;

    @SerializedName("city")
    public String city;

    @SerializedName("display_id")
    public String displayId;

    @SerializedName("gender")
    public int gender;

    @SerializedName("id_str")
    String idStr;

    @SerializedName("location_city")
    public String locationCity;

    @IgnoreProtoFieldCheck
    @SerializedName("mystery_man")
    public int mysteryMan;

    @IgnoreProtoFieldCheck
    @SerializedName("mystery_man_version")
    public int mysteryManVersion;

    @SerializedName("nickname")
    public String nickName;

    @SerializedName("poi_info")
    public ProfilePoiInfo poiInfo;

    @IgnoreProtoFieldCheck
    @SerializedName("remark_name")
    public String remarkName;

    @SerializedName("saas_base_info")
    public k0 saasBaseInfo;

    @SerializedName("school")
    public String school;

    @SerializedName("sec_uid")
    public String secUid;

    @SerializedName("secret")
    public int secret;

    @SerializedName("signature")
    public String signature;

    public BaseProfileInfo() {
        super(k.class);
    }

    @Override // com.bytedance.android.live.base.model.user.k
    public String getIdStr() {
        if (TextUtils.isEmpty(this.idStr) == false) goto L6;
        return "";
    L6:
        return this.idStr;
    }

    public boolean isMysteryMan() {
        if (this.mysteryMan != 2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.live.base.model.user.k
    public String getNickname() {
        return this.nickName;
    }

    @Override // com.bytedance.android.live.base.model.user.k
    public String getSecUid() {
        return this.secUid;
    }

    @Override // com.bytedance.android.live.base.model.user.k
    public void setIdStr(String r1) {
        this.idStr = r1;
    }

    @Override // com.bytedance.android.live.base.model.user.k
    public void setNickname(String r1) {
        this.nickName = r1;
    }

    @Override // com.bytedance.android.live.base.model.user.k
    public void setSecUid(String r1) {
        this.secUid = r1;
    }
}
