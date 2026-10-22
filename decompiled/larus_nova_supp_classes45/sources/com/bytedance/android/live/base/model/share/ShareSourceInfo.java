package com.bytedance.android.live.base.model.share;

import com.google.gson.annotations.SerializedName;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class ShareSourceInfo {

    @SerializedName("app_name")
    private String appName;

    @SerializedName("img_title")
    private String imgTitle;

    @SerializedName("img_url")
    private k imgUrl;

    @SerializedName("pkg_name")
    private String pkgName;

    @SerializedName("schema_url")
    private String schemaUrl;

    @SerializedName("title")
    private String title;

    public ShareSourceInfo() {
    }

    public String getAppName() {
        return this.appName;
    }

    public String getImgTitle() {
        return this.imgTitle;
    }

    public k getImgUrl() {
        return this.imgUrl;
    }

    public String getPkgName() {
        return this.pkgName;
    }

    public String getSchemaUrl() {
        return this.schemaUrl;
    }

    public String getTitle() {
        return this.title;
    }

    public void setAppName(String r1) {
        this.appName = r1;
    }

    public void setImgTitle(String r1) {
        this.imgTitle = r1;
    }

    public void setImgUrl(k r1) {
        this.imgUrl = r1;
    }

    public void setPkgName(String r1) {
        this.pkgName = r1;
    }

    public void setSchemaUrl(String r1) {
        this.schemaUrl = r1;
    }

    public void setTitle(String r1) {
        this.title = r1;
    }
}
