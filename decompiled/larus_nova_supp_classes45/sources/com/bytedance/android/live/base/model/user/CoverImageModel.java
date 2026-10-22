package com.bytedance.android.live.base.model.user;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class CoverImageModel {
    private String mPath;

    @SerializedName("uri")
    String uri;

    @SerializedName("url_list")
    List<String> urlList;

    public CoverImageModel() {
    }

    public String getPath() {
        return this.mPath;
    }

    public String getUri() {
        return this.uri;
    }

    public List<String> getUrlList() {
        return this.urlList;
    }

    public void setPath(String r1) {
        this.mPath = r1;
    }

    public void setUri(String r1) {
        this.uri = r1;
    }

    public void setUrlList(List<String> r1) {
        this.urlList = r1;
    }
}
