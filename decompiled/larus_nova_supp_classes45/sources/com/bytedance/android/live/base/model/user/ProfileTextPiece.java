package com.bytedance.android.live.base.model.user;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class ProfileTextPiece {
    public static int ALIGNMENT_BOTTOM = 0;
    public static int ALIGNMENT_CENTER = 1;
    public static int ALIGNMENT_TOP = 2;
    public static int PIECE_TYPE_IMAGE = 2;
    public static int PIECE_TYPE_STRING = 1;

    @SerializedName("alignment")
    int alignment;

    @SerializedName("image_value")
    ProfileTextPieceImage imageValue;

    @SerializedName("string_value")
    ProfileTextPieceString stringValue;

    @SerializedName("type")
    int type;

    public ProfileTextPiece() {
    }

    public int getAlignment() {
        return this.alignment;
    }

    public ProfileTextPieceImage getImageValue() {
        return this.imageValue;
    }

    public ProfileTextPieceString getStringValue() {
        return this.stringValue;
    }

    public int getType() {
        return this.type;
    }

    public void setAlignment(int r1) {
        this.alignment = r1;
    }

    public void setImageValue(ProfileTextPieceImage r1) {
        this.imageValue = r1;
    }

    public void setStringValue(ProfileTextPieceString r1) {
        this.stringValue = r1;
    }

    public void setType(int r1) {
        this.type = r1;
    }
}
