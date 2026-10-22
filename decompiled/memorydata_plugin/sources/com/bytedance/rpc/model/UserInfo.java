package com.bytedance.rpc.model;

import com.bytedance.bdinstall.Api;
import com.bytedance.crash.entity.Header;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class UserInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("device_id")
    public long deviceId;

    @SerializedName("doubao_uid")
    public long doubaoUid;

    @SerializedName("doubao_uid_type")
    public int doubaoUidType;

    @SerializedName("ecom_personalized_info")
    public EcomPersonalizedInfo ecomPersonalizedInfo;

    @SerializedName("is_doubao_senior_user")
    public boolean isDoubaoSeniorUser;

    @SerializedName("is_new_user")
    public boolean isNewUser;

    @SerializedName("odin_uid")
    public long odinUid;

    @SerializedName(Api.KEY_REGISTER_TIME)
    public int registerTime;

    @SerializedName("test_user_type")
    public int testUserType;

    @SerializedName("toutiao_aweme_uid")
    public long toutiaoAwemeUid;
    public long uid;

    @SerializedName("uid_type")
    public int uidType;

    @SerializedName("user_age_level")
    public int userAgeLevel;

    @SerializedName(Header.KEY_USER_ID)
    public long userId;

    @SerializedName("user_is_auth")
    public int userIsAuth;

    @SerializedName("user_name")
    public String userName;

    @SerializedName("user_tag")
    public List<String> userTag;

    @SerializedName("vc_user_info")
    public VideocutUserInfo vcUserInfo;

    @SerializedName("xigua_user_info")
    public XiguaUserInfo xiguaUserInfo;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public UserInfo() {
    }
}
