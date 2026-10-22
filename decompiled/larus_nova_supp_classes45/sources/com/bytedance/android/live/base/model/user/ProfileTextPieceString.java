package com.bytedance.android.live.base.model.user;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class ProfileTextPieceString {

    @SerializedName("format")
    ProfileTextFormat format;

    @SerializedName("string_value")
    String value;

    public ProfileTextPieceString() {
    }

    public ProfileTextFormat getFormat() {
        return this.format;
    }

    public String getValue() {
        return this.value;
    }

    public void setFormat(ProfileTextFormat r1) {
        this.format = r1;
    }

    public void setValue(String r1) {
        this.value = r1;
    }
}
