package com.larus.settings.provider.creation;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 42\u00020\u0001:\u00014Be\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fB\u0011\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u000e\u0010\u0012J\u0018\u0010!\u001a\u00020\"2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u0003H\u0016J\b\u0010$\u001a\u00020\u0003H\u0016J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0019J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010,\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001eJl\u0010-\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010.J\u0013\u0010/\u001a\u00020\f2\b\u00100\u001a\u0004\u0018\u000101HÖ\u0003J\t\u00102\u001a\u00020\u0003HÖ\u0001J\t\u00103\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b \u0010\u001e¨\u00065"}, d2 = {"Lcom/larus/settings/provider/creation/MediaConfig;", "Landroid/os/Parcelable;", "type", "", "lightModeUrl", "", "darkModeUrl", "ratio", "", "lightVideoModel", "darkVideoModel", "showTrumpet", "", "videoDefaultMute", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getType", "()I", "getLightModeUrl", "()Ljava/lang/String;", "getDarkModeUrl", "getRatio", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getLightVideoModel", "getDarkVideoModel", "getShowTrumpet", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getVideoDefaultMute", "writeToParcel", "", "flags", "describeContents", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/larus/settings/provider/creation/MediaConfig;", "equals", "other", "", "hashCode", "toString", "CREATOR", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class MediaConfig implements Parcelable {
    public static final a CREATOR = null;

    @SerializedName("dark_mode_url")
    private final String darkModeUrl;

    @SerializedName("dark_video_model")
    private final String darkVideoModel;

    @SerializedName("light_mode_url")
    private final String lightModeUrl;

    @SerializedName("light_video_model")
    private final String lightVideoModel;

    @SerializedName("ratio")
    private final Float ratio;

    @SerializedName("show_trumpet")
    private final Boolean showTrumpet;

    @SerializedName("type")
    private final int type;

    @SerializedName("video_default_mute")
    private final Boolean videoDefaultMute;

    public static final class a implements Parcelable.Creator<MediaConfig> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final MediaConfig createFromParcel(Parcel r12) {
            Intrinsics.checkNotNullParameter(r12, "parcel");
            Intrinsics.checkNotNullParameter(r12, "parcel");
            int r2 = r12.readInt();
            String r3 = r12.readString();
            String r4 = r12.readString();
            Float r5 = Float.valueOf(r12.readFloat());
            String r6 = r12.readString();
            String r7 = r12.readString();
            Class r0 = Boolean.TYPE;
            Object r1 = r12.readValue(r0.getClassLoader());
            Boolean r9 = null;
            if ((r1 instanceof Boolean) == false) goto L5;
            Boolean r8 = (Boolean) r1;
        L6:
            Object r13 = r12.readValue(r0.getClassLoader());
            if ((r13 instanceof Boolean) == false) goto L10;
            r9 = (Boolean) r13;
        L10:
            return new MediaConfig(r2, r3, r4, r5, r6, r7, r8, r9);
        L5:
            r8 = null;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final MediaConfig[] newArray(int r1) {
            return new MediaConfig[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public MediaConfig() {
        this(0, null, null, null, null, null, Boolean.FALSE, Boolean.TRUE);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MediaConfig) == true) goto L8;
        return false;
    L8:
        MediaConfig r6 = (MediaConfig) r5;
        if (this.type == r6.type) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.lightModeUrl, r6.lightModeUrl) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.darkModeUrl, r6.darkModeUrl) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.ratio, r6.ratio) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.lightVideoModel, r6.lightVideoModel) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.darkVideoModel, r6.darkVideoModel) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.showTrumpet, r6.showTrumpet) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.videoDefaultMute, r6.videoDefaultMute) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r0 = this.type * 31;
        String r1 = this.lightModeUrl;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.darkModeUrl;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Float r8 = this.ratio;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.lightVideoModel;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        String r14 = this.darkVideoModel;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        Boolean r17 = this.showTrumpet;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        Boolean r20 = this.videoDefaultMute;
        if (r20 == null) goto L31;
        r2 = r20.hashCode();
    L31:
        return r19 + r2;
    L25:
        r18 = r17.hashCode();
        goto L26
    L21:
        r15 = r14.hashCode();
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "MediaConfig(type=" + this.type + ", lightModeUrl=" + this.lightModeUrl + ", darkModeUrl=" + this.darkModeUrl + ", ratio=" + this.ratio + ", lightVideoModel=" + this.lightVideoModel + ", darkVideoModel=" + this.darkVideoModel + ", showTrumpet=" + this.showTrumpet + ", videoDefaultMute=" + this.videoDefaultMute + ')';
    }

    public final String a() {
        return this.darkModeUrl;
    }

    public final String b() {
        return this.darkVideoModel;
    }

    public final String c() {
        return this.lightModeUrl;
    }

    public final String d() {
        return this.lightVideoModel;
    }

    public final Float e() {
        return this.ratio;
    }

    public final Boolean g() {
        return this.showTrumpet;
    }

    public final int getType() {
        return this.type;
    }

    public final Boolean h() {
        return this.videoDefaultMute;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeInt(this.type);
        r1.writeString(this.lightModeUrl);
        r1.writeString(this.darkModeUrl);
        Float r3 = this.ratio;
        if (r3 == null) goto L5;
        float r4 = r3.floatValue();
    L6:
        r1.writeFloat(r4);
        r1.writeString(this.lightVideoModel);
        r1.writeString(this.darkVideoModel);
        r1.writeValue(this.showTrumpet);
        r1.writeValue(this.videoDefaultMute);
        return;
    L5:
        r4 = 1.0f;
        goto L6
    }

    public MediaConfig(@MediaType int r1, String r2, String r3, Float r4, String r5, String r6, Boolean r7, Boolean r8) {
        this.type = r1;
        this.lightModeUrl = r2;
        this.darkModeUrl = r3;
        this.ratio = r4;
        this.lightVideoModel = r5;
        this.darkVideoModel = r6;
        this.showTrumpet = r7;
        this.videoDefaultMute = r8;
    }
}
