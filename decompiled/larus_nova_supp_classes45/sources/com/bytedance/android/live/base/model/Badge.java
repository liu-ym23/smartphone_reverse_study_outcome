package com.bytedance.android.live.base.model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class Badge {

    @SerializedName("icon")
    private ImageModel icon;

    @SerializedName("small_icon")
    private ImageModel smallIcon;

    @SerializedName("title")
    private String title;

    public Badge() {
    }

    public ImageModel getIcon() {
        return this.icon;
    }

    public ImageModel getSmallIcon() {
        return this.smallIcon;
    }

    public String getTitle() {
        return this.title;
    }

    public void setIcon(ImageModel r1) {
        this.icon = r1;
    }

    public void setSmallIcon(ImageModel r1) {
        this.smallIcon = r1;
    }

    public void setTitle(String r1) {
        this.title = r1;
    }
}
