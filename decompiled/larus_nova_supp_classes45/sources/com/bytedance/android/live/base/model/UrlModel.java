package com.bytedance.android.live.base.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class UrlModel {

    @SerializedName("uri")
    String uri;

    @SerializedName("url_list")
    List<String> urlList;

    public UrlModel() {
    }

    public py.k toImgModel() {
        py.k r0 = (py.k) vh7.f.c(py.k.class);
        r0.setUri(this.uri);
        r0.setUrls(this.urlList);
        return r0;
    }

    public String toString() {
        return "UrlStruct{uri='" + this.uri + "', urlList=" + this.urlList + '}';
    }

    public String getUri() {
        return this.uri;
    }

    public List<String> getUrlList() {
        return this.urlList;
    }

    public void setUri(String r1) {
        this.uri = r1;
    }

    public void setUrlList(List<String> r1) {
        this.urlList = r1;
    }
}
