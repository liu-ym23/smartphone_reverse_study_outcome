package com.ss.android.lark.doc.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class ThumbnailDetail implements Serializable, Parcelable {
    public static final Parcelable.Creator<ThumbnailDetail> CREATOR = null;

    @SerializedName("cipher_type")
    public String cipherType;

    @SerializedName("decrypt_key_mobile")
    public String decryptKeyMobile;

    @SerializedName("decrypt_nonce_mobile")
    public String decryptNonceMobile;

    @SerializedName("thumbnail_url_mobile")
    public String thumbnailUrlMobile;

    public class a implements Parcelable.Creator<ThumbnailDetail> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ThumbnailDetail createFromParcel(Parcel r2) {
            return new ThumbnailDetail(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final ThumbnailDetail[] newArray(int r1) {
            return new ThumbnailDetail[r1];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public ThumbnailDetail() {
    }

    public ThumbnailDetail(Parcel r2) {
        this.cipherType = r2.readString();
        this.decryptNonceMobile = r2.readString();
        this.thumbnailUrlMobile = r2.readString();
        this.decryptKeyMobile = r2.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeString(this.cipherType);
        r1.writeString(this.decryptNonceMobile);
        r1.writeString(this.thumbnailUrlMobile);
        r1.writeString(this.decryptKeyMobile);
    }
}
