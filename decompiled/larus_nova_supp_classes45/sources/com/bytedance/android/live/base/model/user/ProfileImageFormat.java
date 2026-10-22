package com.bytedance.android.live.base.model.user;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class ProfileImageFormat {

    @SerializedName("image_fillet")
    float imageRadius;

    @SerializedName("is_image_fillet")
    boolean isImageFillet;

    public ProfileImageFormat() {
    }

    public float getImageRadius() {
        return this.imageRadius;
    }

    public boolean isImageCircle() {
        return this.isImageFillet;
    }
}
