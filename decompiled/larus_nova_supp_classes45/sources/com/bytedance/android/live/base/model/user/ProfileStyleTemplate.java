package com.bytedance.android.live.base.model.user;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class ProfileStyleTemplate {
    public static long TEMPLATE_ECOM = 1;
    public static long TEMPLATE_HONOUR = 0;
    public static long TEMPLATE_LOCAL_LIFE = 3;

    @SerializedName("template_description")
    String templateDescription;

    @SerializedName("template_id")
    long templateId;

    @SerializedName("template_name")
    String templateName;

    @SerializedName("template_url")
    py.k templateUrl;

    public ProfileStyleTemplate() {
    }

    public String getTemplateDescription() {
        return this.templateDescription;
    }

    public long getTemplateId() {
        return this.templateId;
    }

    public String getTemplateName() {
        return this.templateName;
    }

    public py.k getTemplateUrl() {
        return this.templateUrl;
    }
}
