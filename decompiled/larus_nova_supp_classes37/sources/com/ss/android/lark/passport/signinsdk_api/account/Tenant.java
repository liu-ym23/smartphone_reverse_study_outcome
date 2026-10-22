package com.ss.android.lark.passport.signinsdk_api.account;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class Tenant implements Serializable, Parcelable {
    public static final Parcelable.Creator<Tenant> CREATOR = null;
    public static final int FROM_SOURCE_DOUBAO = 12;

    @JSONField(name = "from_source")
    public int fromSource;

    @JSONField(name = "i18n_names")
    public I18Name i18Name;

    @JSONField(name = "icon_url")
    public String iconUrl;

    @JSONField(name = "is_certificated")
    public boolean isCertificated;
    public String name;

    @JSONField(name = "tenant_full_domain")
    public String suiteFullDomain;

    @JSONField(name = "tenant_tag")
    public int tag;

    @JSONField(name = "tenant_biz_type")
    public int tenantBizType;

    @JSONField(name = "tenant_brand")
    private String tenantBrand;

    @JSONField(name = "tenant_domain")
    public String tenantDomain;

    @JSONField(name = "geo")
    private String tenantGeo;

    @JSONField(alternateNames = {"id"}, name = "tenant_id")
    public String tenantId;

    public class a implements Parcelable.Creator<Tenant> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final Tenant createFromParcel(Parcel r2) {
            return new Tenant(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final Tenant[] newArray(int r1) {
            return new Tenant[r1];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public Tenant() {
        this.tag = 0;
    }

    public String getTenantBrand() {
        return this.tenantBrand;
    }

    public String getTenantGeo() {
        return this.tenantGeo;
    }

    public Tenant(Parcel r3) {
        boolean r0 = false;
        this.tag = 0;
        this.tenantId = r3.readString();
        this.name = r3.readString();
        this.iconUrl = r3.readString();
        this.tag = r3.readInt();
        this.tenantDomain = r3.readString();
        this.suiteFullDomain = r3.readString();
        this.tenantBrand = r3.readString();
        if (r3.readByte() == 0) goto L5;
        r0 = true;
    L5:
        this.isCertificated = r0;
        this.tenantGeo = r3.readString();
    }

    public String localizedName(Locale r4) {
        if (r4 == null) goto L4;
        String r0 = this.name;
        if (this.i18Name != null) goto L8;
        return r0;
    L8:
        if (r4.getLanguage().equals(Locale.CHINESE.getLanguage()) == false) goto L13;
        if (TextUtils.isEmpty(this.i18Name.zhCn) == false) goto L23;
        return r0;
    L23:
        return this.i18Name.zhCn;
    L13:
        if (r4.getLanguage().equals(Locale.JAPANESE.getLanguage()) == false) goto L18;
        if (TextUtils.isEmpty(this.i18Name.jaJp) == true) goto L18;
        return this.i18Name.jaJp;
    L18:
        if (TextUtils.isEmpty(this.i18Name.enUs) == false) goto L20;
        return r0;
    L20:
        return this.i18Name.enUs;
    L4:
        return this.name;
    }

    public void setTenantBrand(String r1) {
        this.tenantBrand = r1;
    }

    public void setTenantGeo(String r1) {
        this.tenantGeo = r1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeString(this.tenantId);
        r1.writeString(this.name);
        r1.writeString(this.iconUrl);
        r1.writeInt(this.tag);
        r1.writeString(this.tenantDomain);
        r1.writeString(this.suiteFullDomain);
        r1.writeString(this.tenantBrand);
        r1.writeByte(this.isCertificated ? 1 : 0);
        r1.writeString(this.tenantGeo);
    }
}
