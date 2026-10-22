package com.larksuite.component.openplatform.plugins.config;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.lark.plugin_annotation.bean.LKOpenApiBizDomain;
import com.bytedance.ee.lark.plugin_annotation.bean.LKOpenApiBizType;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class LKOpenApiAccessConfig implements Parcelable, Serializable {
    public static final Parcelable.Creator<LKOpenApiAccessConfig> CREATOR = null;
    private LKOpenApiBizType mBizType;
    private LKOpenApiBizDomain mDomain;
    private boolean mPublicToJS;
    private String mScene;

    public class a implements Parcelable.Creator<LKOpenApiAccessConfig> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final LKOpenApiAccessConfig createFromParcel(Parcel r2) {
            return new LKOpenApiAccessConfig(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final LKOpenApiAccessConfig[] newArray(int r1) {
            return new LKOpenApiAccessConfig[r1];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public String toString() {
        return "LKOpenApiAccessConfig{mDomain=" + this.mDomain + ", mBizType=" + this.mBizType + ", mScene='" + this.mScene + "', mPublicToJS=" + this.mPublicToJS + '}';
    }

    private LKOpenApiAccessConfig() {
    }

    public LKOpenApiBizType getBizType() {
        return this.mBizType;
    }

    public LKOpenApiBizDomain getDomain() {
        return this.mDomain;
    }

    public String getScene() {
        return this.mScene;
    }

    public boolean isPublicToJS() {
        return this.mPublicToJS;
    }

    public LKOpenApiAccessConfig(Parcel r2) {
        this.mScene = r2.readString();
        if (r2.readByte() == 0) goto L5;
        boolean r0 = true;
    L6:
        this.mPublicToJS = r0;
        LKOpenApiBizDomain r1 = r2.readSerializable();
        if (r1 == null) goto L9;
        this.mDomain = r1;
    L9:
        LKOpenApiBizType r3 = r2.readSerializable();
        if (r3 == null) goto L13;
        this.mBizType = r3;
        return;
    L13:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public void updateDomain(LKOpenApiBizDomain r1) {
        this.mDomain = r1;
    }

    public /* synthetic */ LKOpenApiAccessConfig(a r1) {
        this();
    }

    public static /* synthetic */ LKOpenApiBizDomain access$102(LKOpenApiAccessConfig r0, LKOpenApiBizDomain r1) {
        r0.mDomain = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$202(LKOpenApiAccessConfig r0, boolean r1) {
        r0.mPublicToJS = r1;
        return r1;
    }

    public static /* synthetic */ String access$302(LKOpenApiAccessConfig r0, String r1) {
        r0.mScene = r1;
        return r1;
    }

    public static /* synthetic */ LKOpenApiBizType access$402(LKOpenApiAccessConfig r0, LKOpenApiBizType r1) {
        r0.mBizType = r1;
        return r1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeString(this.mScene);
        r1.writeByte(this.mPublicToJS ? 1 : 0);
        r1.writeSerializable(this.mDomain);
        r1.writeSerializable(this.mBizType);
    }

    public static LKOpenApiAccessConfig createOpenApiConfig(LKOpenApiBizDomain r2, LKOpenApiBizType r3, String r4, boolean r5) {
        LKOpenApiBizDomain r0 = LKOpenApiBizDomain.ALL;
        LKOpenApiAccessConfig r1 = new LKOpenApiAccessConfig(null);
        access$102(r1, r2);
        access$202(r1, r5);
        access$302(r1, r4);
        access$402(r1, r3);
        return r1;
    }
}
