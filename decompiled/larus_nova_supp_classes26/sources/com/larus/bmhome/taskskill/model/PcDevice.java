package com.larus.bmhome.taskskill.model;

import android.os.Parcel;
import android.os.Parcelable;
import be8.d;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.music.applet.MusicAppletPage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B©\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010)\u001a\u00020*J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010.\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010/\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00104\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0011\u00105\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fHÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J°\u0001\u00108\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00109J\u0006\u0010:\u001a\u00020\u0010J\u0013\u0010;\u001a\u00020\u00072\b\u0010<\u001a\u0004\u0018\u00010=HÖ\u0003J\t\u0010>\u001a\u00020\u0010HÖ\u0001J\t\u0010?\u001a\u00020\u0003HÖ\u0001J\u0016\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\u0010R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\b\u0010\u001aR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u001a\u0010\r\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b \u0010\u001aR\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0016R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0016R\u001a\u0010%\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006E"}, d2 = {"Lcom/larus/bmhome/taskskill/model/PcDevice;", "Landroid/os/Parcelable;", "deviceId", "", "deviceName", "deviceType", "authorized", "", "isOnline", "appId", "osName", "osVersion", "pcVersion", "enableControl", "supportedReqCmds", "", "", "iconUrl", "iconUrlDark", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getDeviceId", "()Ljava/lang/String;", "getDeviceName", "getDeviceType", "getAuthorized", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getAppId", "getOsName", "getOsVersion", "getPcVersion", "getEnableControl", "getSupportedReqCmds", "()Ljava/util/List;", "getIconUrl", "getIconUrlDark", "isAuthorizing", "()Z", "setAuthorizing", "(Z)V", "toTaskDeviceInfo", "Lcom/larus/bmhome/chat/component/skill/TaskDeviceInfo;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/bmhome/taskskill/model/PcDevice;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PcDevice implements Parcelable {
    public static final Parcelable.Creator<PcDevice> CREATOR = null;
    public transient boolean a;

    @SerializedName(MusicAppletPage.QUERY_APP_ID)
    private final String appId;

    @SerializedName("authorized")
    private final Boolean authorized;

    @SerializedName("device_id")
    private final String deviceId;

    @SerializedName("device_name")
    private final String deviceName;

    @SerializedName("device_type")
    private final String deviceType;

    @SerializedName("enable_control")
    private final Boolean enableControl;

    @SerializedName("icon_url")
    private final String iconUrl;

    @SerializedName("icon_url_dark")
    private final String iconUrlDark;

    @SerializedName("is_online")
    private final Boolean isOnline;

    @SerializedName("os_name")
    private final String osName;

    @SerializedName("os_version")
    private final String osVersion;

    @SerializedName("pc_version")
    private final String pcVersion;

    @SerializedName("supported_req_cmds")
    private final List<Integer> supportedReqCmds;

    public static final class a implements Parcelable.Creator<PcDevice> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PcDevice createFromParcel(Parcel r19) {
            Intrinsics.checkNotNullParameter(r19, "parcel");
            String r2 = r19.readString();
            String r3 = r19.readString();
            String r4 = r19.readString();
            int r5 = 0;
            boolean r6 = true;
            ArrayList r7 = null;
            if (r19.readInt() != 0) goto L6;
            Boolean r0 = null;
        L11:
            if (r19.readInt() != 0) goto L14;
            Boolean r8 = null;
        L18:
            String r9 = r19.readString();
            String r10 = r19.readString();
            String r11 = r19.readString();
            String r12 = r19.readString();
            if (r19.readInt() != 0) goto L22;
            Boolean r13 = null;
        L27:
            if (r19.readInt() == 0) goto L33;
            int r14 = r19.readInt();
            r7 = new ArrayList(r14);
        L30:
            if (r5 == r14) goto L33;
            r7.add(Integer.valueOf(r19.readInt()));
            r5 = r5 + 1;
        L33:
            return new PcDevice(r2, r3, r4, r0, r8, r9, r10, r11, r12, r13, r7, r19.readString(), r19.readString());
        L22:
            if (r19.readInt() != 0) goto L25;
            r6 = false;
        L25:
            r13 = Boolean.valueOf(r6);
            goto L27
        L14:
            if (r19.readInt() == 0) goto L16;
            boolean r15 = true;
        L17:
            r8 = Boolean.valueOf(r15);
            goto L18
        L16:
            r15 = false;
            goto L17
        L6:
            if (r19.readInt() == 0) goto L8;
            boolean r1 = true;
        L9:
            r0 = Boolean.valueOf(r1);
            goto L11
        L8:
            r1 = false;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public final PcDevice[] newArray(int r1) {
            return new PcDevice[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public PcDevice() {
        Boolean r10 = Boolean.FALSE;
        this(null, null, null, r10, r10, null, null, null, null, r10, null, null, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof PcDevice) == true) goto L8;
        return false;
    L8:
        PcDevice r6 = (PcDevice) r5;
        if (Intrinsics.areEqual(this.deviceId, r6.deviceId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.deviceName, r6.deviceName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.deviceType, r6.deviceType) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.authorized, r6.authorized) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.isOnline, r6.isOnline) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.appId, r6.appId) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.osName, r6.osName) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.osVersion, r6.osVersion) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.pcVersion, r6.pcVersion) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.enableControl, r6.enableControl) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.supportedReqCmds, r6.supportedReqCmds) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.iconUrl, r6.iconUrl) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.iconUrlDark, r6.iconUrlDark) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        String r0 = this.deviceId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.deviceName;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.deviceType;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Boolean r10 = this.authorized;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Boolean r13 = this.isOnline;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.appId;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.osName;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.osVersion;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.pcVersion;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        Boolean r28 = this.enableControl;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        List<Integer> r31 = this.supportedReqCmds;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        String r34 = this.iconUrl;
        if (r34 != null) goto L49;
        int r35 = 0;
    L50:
        int r36 = (r33 + r35) * 31;
        String r37 = this.iconUrlDark;
        if (r37 == null) goto L55;
        r1 = r37.hashCode();
    L55:
        return r36 + r1;
    L49:
        r35 = r34.hashCode();
        goto L50
    L45:
        r32 = r31.hashCode();
        goto L46
    L41:
        r29 = r28.hashCode();
        goto L42
    L37:
        r26 = r25.hashCode();
        goto L38
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "PcDevice(deviceId=" + this.deviceId + ", deviceName=" + this.deviceName + ", deviceType=" + this.deviceType + ", authorized=" + this.authorized + ", isOnline=" + this.isOnline + ", appId=" + this.appId + ", osName=" + this.osName + ", osVersion=" + this.osVersion + ", pcVersion=" + this.pcVersion + ", enableControl=" + this.enableControl + ", supportedReqCmds=" + this.supportedReqCmds + ", iconUrl=" + this.iconUrl + ", iconUrlDark=" + this.iconUrlDark + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        r3.writeString(this.deviceId);
        r3.writeString(this.deviceName);
        r3.writeString(this.deviceType);
        Boolean r5 = this.authorized;
        if (r5 != null) goto L5;
        r3.writeInt(0);
    L6:
        Boolean r6 = this.isOnline;
        if (r6 != null) goto L9;
        r3.writeInt(0);
    L10:
        r3.writeString(this.appId);
        r3.writeString(this.osName);
        r3.writeString(this.osVersion);
        r3.writeString(this.pcVersion);
        Boolean r7 = this.enableControl;
        if (r7 != null) goto L13;
        r3.writeInt(0);
    L14:
        List<Integer> r8 = this.supportedReqCmds;
        if (r8 != null) goto L17;
        r3.writeInt(0);
    L21:
        r3.writeString(this.iconUrl);
        r3.writeString(this.iconUrlDark);
        return;
    L17:
        r3.writeInt(1);
        r3.writeInt(r8.size());
        Iterator<Integer> r9 = r8.iterator();
    L19:
        if (r9.hasNext() == false) goto L21;
        r3.writeInt(r9.next().intValue());
        goto L19
    L13:
        r3.writeInt(1);
        r3.writeInt(r7.booleanValue() ? 1 : 0);
        goto L14
    L9:
        r3.writeInt(1);
        r3.writeInt(r6.booleanValue() ? 1 : 0);
        goto L10
    L5:
        r3.writeInt(1);
        r3.writeInt(r5.booleanValue() ? 1 : 0);
        goto L6
    }

    public final d s() {
        return new d(this.deviceId, this.deviceName, this.deviceType, this.appId);
    }

    public final String b() {
        return this.appId;
    }

    public final Boolean c() {
        return this.authorized;
    }

    public final String d() {
        return this.deviceName;
    }

    public final String e() {
        return this.deviceType;
    }

    public final Boolean g() {
        return this.enableControl;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final String h() {
        return this.iconUrl;
    }

    public final String i() {
        return this.iconUrlDark;
    }

    public final String j() {
        return this.osName;
    }

    public final String k() {
        return this.osVersion;
    }

    public final String o() {
        return this.pcVersion;
    }

    public final List<Integer> q() {
        return this.supportedReqCmds;
    }

    public final Boolean r() {
        return this.isOnline;
    }

    public static PcDevice a(PcDevice r18, Boolean r19, Boolean r20, Boolean r21, int r22) {
        String r3 = null;
        if ((r22 & 1) == 0) goto L5;
        String r5 = r18.deviceId;
    L7:
        if ((r22 & 2) == 0) goto L9;
        String r6 = r18.deviceName;
    L11:
        if ((r22 & 4) == 0) goto L13;
        String r7 = r18.deviceType;
    L15:
        if ((r22 & 8) == 0) goto L17;
        Boolean r8 = r18.authorized;
    L19:
        if ((r22 & 16) == 0) goto L21;
        Boolean r9 = r18.isOnline;
    L23:
        if ((r22 & 32) == 0) goto L25;
        String r10 = r18.appId;
    L27:
        if ((r22 & 64) == 0) goto L29;
        String r11 = r18.osName;
    L31:
        if ((r22 & 128) == 0) goto L33;
        String r12 = r18.osVersion;
    L35:
        if ((r22 & 256) == 0) goto L37;
        String r13 = r18.pcVersion;
    L39:
        if ((r22 & 512) == 0) goto L41;
        Boolean r14 = r18.enableControl;
    L43:
        if ((r22 & 1024) == 0) goto L45;
        List<Integer> r15 = r18.supportedReqCmds;
    L47:
        if ((r22 & 2048) == 0) goto L49;
        String r16 = r18.iconUrl;
    L51:
        if ((r22 & 4096) == 0) goto L53;
        r3 = r18.iconUrlDark;
    L53:
        r18.getClass();
        return new PcDevice(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r3);
    L49:
        r16 = null;
        goto L51
    L45:
        r15 = null;
        goto L47
    L41:
        r14 = r21;
        goto L43
    L37:
        r13 = null;
        goto L39
    L33:
        r12 = null;
        goto L35
    L29:
        r11 = null;
        goto L31
    L25:
        r10 = null;
        goto L27
    L21:
        r9 = r20;
        goto L23
    L17:
        r8 = r19;
        goto L19
    L13:
        r7 = null;
        goto L15
    L9:
        r6 = null;
        goto L11
    L5:
        r5 = null;
        goto L7
    }

    public PcDevice(String r1, String r2, String r3, Boolean r4, Boolean r5, String r6, String r7, String r8, String r9, Boolean r10, List<Integer> r11, String r12, String r13) {
        this.deviceId = r1;
        this.deviceName = r2;
        this.deviceType = r3;
        this.authorized = r4;
        this.isOnline = r5;
        this.appId = r6;
        this.osName = r7;
        this.osVersion = r8;
        this.pcVersion = r9;
        this.enableControl = r10;
        this.supportedReqCmds = r11;
        this.iconUrl = r12;
        this.iconUrlDark = r13;
    }
}
