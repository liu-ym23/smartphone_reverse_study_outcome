package com.obric.aikernel.sdk.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class ExtraAppInfo implements Parcelable {
    public static final a CREATOR = null;
    private final String aid;
    private final String appVersionName;
    private final String bridgeVersion;
    private final String extraInfo;
    private final String foundationVersion;
    private final Map<String, String> libsVersion;
    private final String sdkVersion;
    private final String vmVersion;

    public static final class a implements Parcelable.Creator<ExtraAppInfo> {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public ExtraAppInfo a(Parcel r10) {
            Intrinsics.checkNotNullParameter(r10, "parcel");
            return new ExtraAppInfo(r10);
        }

        public ExtraAppInfo[] b(int r10) {
            return new ExtraAppInfo[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ExtraAppInfo createFromParcel(Parcel r10) {
            return a(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ExtraAppInfo[] newArray(int r10) {
            return b(r10);
        }
    }

    static {
        CREATOR = new a(null);
    }

    public ExtraAppInfo(Parcel r14) {
        Intrinsics.checkNotNullParameter(r14, "parcel");
        String r10 = r14.readString();
        if (r10 != null) goto L5;
        String r11 = "";
    L6:
        String r12 = r14.readString();
        if (r12 != null) goto L9;
        String r13 = "";
    L10:
        String r15 = r14.readString();
        if (r15 != null) goto L13;
        String r16 = "";
    L14:
        String r17 = r14.readString();
        if (r17 != null) goto L17;
        String r18 = "";
    L18:
        String r19 = r14.readString();
        if (r19 != null) goto L21;
        String r20 = "";
    L22:
        String r21 = r14.readString();
        if (r21 != null) goto L25;
        String r22 = "";
    L26:
        Bundle r23 = r14.readBundle();
        if (r23 == null) goto L36;
        LinkedHashMap r24 = new LinkedHashMap();
        Set<String> r25 = r23.keySet();
        Intrinsics.checkNotNullExpressionValue(r25, "bundle.keySet()");
        Iterator<T> r26 = r25.iterator();
    L30:
        if (r26.hasNext() == false) goto L35;
        String r110 = (String) r26.next();
        Intrinsics.checkNotNullExpressionValue(r110, "key");
        String r111 = r23.getString(r110);
        if (r111 != null) goto L34;
        r111 = "";
    L34:
        Intrinsics.checkNotNullExpressionValue(r111, "bundle.getString(key) ?: \"\"");
        r24.put(r110, r111);
        goto L30
    L35:
        Map r27 = r24;
    L37:
        String r112 = r14.readString();
        if (r112 != null) goto L40;
        String r113 = "";
    L41:
        this(r11, r13, r16, r18, r20, r22, r27, r113);
        return;
    L40:
        r113 = r112;
        goto L41
    L36:
        r27 = MapsKt.emptyMap();
        goto L37
    L25:
        r22 = r21;
        goto L26
    L21:
        r20 = r19;
        goto L22
    L17:
        r18 = r17;
        goto L18
    L13:
        r16 = r15;
        goto L14
    L9:
        r13 = r12;
        goto L10
    L5:
        r11 = r10;
        goto L6
    }

    public ExtraAppInfo(String r10, String r11, String r12, String r13, String r14, String r15, Map<String, String> r16, String r17) {
        Intrinsics.checkNotNullParameter(r10, "aid");
        Intrinsics.checkNotNullParameter(r11, "appVersionName");
        Intrinsics.checkNotNullParameter(r12, "sdkVersion");
        Intrinsics.checkNotNullParameter(r13, "bridgeVersion");
        Intrinsics.checkNotNullParameter(r14, "foundationVersion");
        Intrinsics.checkNotNullParameter(r15, "vmVersion");
        Intrinsics.checkNotNullParameter(r16, "libsVersion");
        Intrinsics.checkNotNullParameter(r17, "extraInfo");
        this.aid = r10;
        this.appVersionName = r11;
        this.sdkVersion = r12;
        this.bridgeVersion = r13;
        this.foundationVersion = r14;
        this.vmVersion = r15;
        this.libsVersion = r16;
        this.extraInfo = r17;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ExtraAppInfo copy$default(ExtraAppInfo r10, String r11, String r12, String r13, String r14, String r15, String r16, Map r17, String r18, int r19, Object r110) {
        if ((r19 & 1) == 0) goto L5;
        String r20 = r10.aid;
    L7:
        if ((r19 & 2) == 0) goto L9;
        String r21 = r10.appVersionName;
    L11:
        if ((r19 & 4) == 0) goto L13;
        String r22 = r10.sdkVersion;
    L15:
        if ((r19 & 8) == 0) goto L17;
        String r23 = r10.bridgeVersion;
    L19:
        if ((r19 & 16) == 0) goto L21;
        String r24 = r10.foundationVersion;
    L23:
        if ((r19 & 32) == 0) goto L25;
        String r25 = r10.vmVersion;
    L27:
        if ((r19 & 64) == 0) goto L29;
        Map r26 = r10.libsVersion;
    L31:
        if ((r19 & 128) == 0) goto L33;
        String r27 = r10.extraInfo;
    L35:
        return r10.copy(r20, r21, r22, r23, r24, r25, r26, r27);
    L33:
        r27 = r18;
        goto L35
    L29:
        r26 = r17;
        goto L31
    L25:
        r25 = r16;
        goto L27
    L21:
        r24 = r15;
        goto L23
    L17:
        r23 = r14;
        goto L19
    L13:
        r22 = r13;
        goto L15
    L9:
        r21 = r12;
        goto L11
    L5:
        r20 = r11;
        goto L7
    }

    public final String component1() {
        return this.aid;
    }

    public final String component2() {
        return this.appVersionName;
    }

    public final String component3() {
        return this.sdkVersion;
    }

    public final String component4() {
        return this.bridgeVersion;
    }

    public final String component5() {
        return this.foundationVersion;
    }

    public final String component6() {
        return this.vmVersion;
    }

    public final Map<String, String> component7() {
        return this.libsVersion;
    }

    public final String component8() {
        return this.extraInfo;
    }

    public final ExtraAppInfo copy(String r11, String r12, String r13, String r14, String r15, String r16, Map<String, String> r17, String r18) {
        Intrinsics.checkNotNullParameter(r11, "aid");
        Intrinsics.checkNotNullParameter(r12, "appVersionName");
        Intrinsics.checkNotNullParameter(r13, "sdkVersion");
        Intrinsics.checkNotNullParameter(r14, "bridgeVersion");
        Intrinsics.checkNotNullParameter(r15, "foundationVersion");
        Intrinsics.checkNotNullParameter(r16, "vmVersion");
        Intrinsics.checkNotNullParameter(r17, "libsVersion");
        Intrinsics.checkNotNullParameter(r18, "extraInfo");
        return new ExtraAppInfo(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if (r10 == null) goto L8;
        Class<?> r11 = r10.getClass();
    L10:
        if (Intrinsics.areEqual(ExtraAppInfo.class, r11) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.obric.aikernel.sdk.data.ExtraAppInfo");
        ExtraAppInfo r12 = (ExtraAppInfo) r10;
        if (Intrinsics.areEqual(this.aid, r12.aid) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.appVersionName, r12.appVersionName) == true) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(this.sdkVersion, r12.sdkVersion) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.bridgeVersion, r12.bridgeVersion) == true) goto L25;
        return false;
    L25:
        if (Intrinsics.areEqual(this.foundationVersion, r12.foundationVersion) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.vmVersion, r12.vmVersion) == true) goto L31;
        return false;
    L31:
        if (Intrinsics.areEqual(this.libsVersion, r12.libsVersion) == true) goto L33;
        return false;
    L33:
        return true;
    L8:
        r11 = null;
        goto L10
    }

    public final String getAid() {
        return this.aid;
    }

    public final String getAppVersionName() {
        return this.appVersionName;
    }

    public final String getBridgeVersion() {
        return this.bridgeVersion;
    }

    public final String getExtraInfo() {
        return this.extraInfo;
    }

    public final String getFoundationVersion() {
        return this.foundationVersion;
    }

    public final Map<String, String> getLibsVersion() {
        return this.libsVersion;
    }

    public final String getSdkVersion() {
        return this.sdkVersion;
    }

    public final String getVmVersion() {
        return this.vmVersion;
    }

    public int hashCode() {
        return (((((((((((this.aid.hashCode() * 31) + this.appVersionName.hashCode()) * 31) + this.sdkVersion.hashCode()) * 31) + this.bridgeVersion.hashCode()) * 31) + this.foundationVersion.hashCode()) * 31) + this.vmVersion.hashCode()) * 31) + this.libsVersion.hashCode();
    }

    public final JSONObject toJSONObject() {
        JSONObject r10 = new JSONObject();
        Iterator<Map.Entry<String, String>> r11 = this.libsVersion.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Map.Entry<String, String> r12 = r11.next();
        r10.put(r12.getKey(), r12.getValue());
        goto L4
    L6:
        JSONObject r13 = new JSONObject().put("aid", this.aid).put("app_version_name", this.appVersionName).put("sdk_version", this.sdkVersion).put("bridge_version", this.bridgeVersion).put("foundation_version", this.foundationVersion).put("vm_version", this.vmVersion).put("libs_version", r10);
        Intrinsics.checkNotNullExpressionValue(r13, "JSONObject()\n           …(\"libs_version\", libsVer)");
        return r13;
    }

    public String toString() {
        return "ExtraAppInfo(aid=" + this.aid + ", appVersionName=" + this.appVersionName + ", sdkVersion=" + this.sdkVersion + ", bridgeVersion=" + this.bridgeVersion + ", foundationVersion=" + this.foundationVersion + ", vmVersion=" + this.vmVersion + ", libsVersion=" + this.libsVersion + ", extraInfo=" + this.extraInfo + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "parcel");
        r10.writeString(this.aid);
        r10.writeString(this.appVersionName);
        r10.writeString(this.sdkVersion);
        r10.writeString(this.bridgeVersion);
        r10.writeString(this.foundationVersion);
        r10.writeString(this.vmVersion);
        Bundle r12 = new Bundle();
        Iterator<Map.Entry<String, String>> r13 = this.libsVersion.entrySet().iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        Map.Entry<String, String> r14 = r13.next();
        r12.putString(r14.getKey(), r14.getValue());
        goto L4
    L6:
        r10.writeBundle(r12);
        r10.writeString(this.extraInfo);
    }
}
