package com.bytedance.rpc.model;

import com.bytedance.bdinstall.Api;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class SearchCommon implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("ab_params")
    public String abParams;

    @SerializedName("app_id")
    public String appId;

    @SerializedName(Api.KEY_APP_NAME)
    public String appName;
    public UserInfo awemeUserInfo;

    @SerializedName("biz_id")
    public long bizId;

    @SerializedName("impression_archive_field")
    public String impressionArchiveField;

    @SerializedName("impression_id")
    public String impressionId;
    public LocaleInfo localeInfo;

    @SerializedName("req_id")
    public String reqId;

    @SerializedName("search_id")
    public String searchId;

    @SerializedName("tenant_id")
    public long tenantId;

    @SerializedName("tool_use_id")
    public String toolUseId;
    public UserInfo userInfo;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public SearchCommon() {
    }
}
