package com.ss.android.lark.passport.signinsdk_api.account;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.fastjson.annotation.JSONField;
import com.ss.android.lark.pb.entities.I18nInfo;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class I18Name implements Serializable, Parcelable {
    public static final Parcelable.Creator<I18Name> CREATOR = null;

    @JSONField(name = "en_us")
    public String enUs;

    @JSONField(name = "ja_jp")
    public String jaJp;

    @JSONField(name = I18nInfo.DEFAULT_LOCALE)
    public String zhCn;

    public class a implements Parcelable.Creator<I18Name> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final I18Name createFromParcel(Parcel r2) {
            return new I18Name(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final I18Name[] newArray(int r1) {
            return new I18Name[r1];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public I18Name() {
    }

    public I18Name(Parcel r2) {
        this.zhCn = r2.readString();
        this.enUs = r2.readString();
        this.jaJp = r2.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeString(this.zhCn);
        r1.writeString(this.enUs);
        r1.writeString(this.jaJp);
    }
}
