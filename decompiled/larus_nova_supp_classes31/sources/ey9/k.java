package ey9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\"\b\u0086\b\u0018\u00002\u00020\u0001By\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0007HÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010(\u001a\u00020\rHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J{\u0010*\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010+\u001a\u00020\r2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\u0007HÖ\u0001J\t\u0010.\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0012¨\u0006/"}, d2 = {"Lcom/larus/uaigc/avatar/api/PreGenImage;", "", "originImageUri", "", "faceUri", "faceMaskUri", "gender", "", "age", "originImageUrl", "faceUrl", "faceMaskUrl", "fromRefVideo", "", "originThumbnailUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getOriginImageUri", "()Ljava/lang/String;", "getFaceUri", "getFaceMaskUri", "getGender", "()I", "getAge", "getOriginImageUrl", "getFaceUrl", "getFaceMaskUrl", "getFromRefVideo", "()Z", "setFromRefVideo", "(Z)V", "getOriginThumbnailUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "other", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class k {

    @SerializedName("age")
    private final int age;

    @SerializedName("face_mask_uri")
    private final String faceMaskUri;

    @SerializedName("face_mask_url")
    private final String faceMaskUrl;

    @SerializedName("face_uri")
    private final String faceUri;

    @SerializedName("face_url")
    private final String faceUrl;

    @SerializedName("from_ref_video")
    private boolean fromRefVideo;

    @SerializedName("gender")
    private final int gender;

    @SerializedName("origin_image_uri")
    private final String originImageUri;

    @SerializedName("origin_image_url")
    private final String originImageUrl;

    @SerializedName("origin_thumbnail_url")
    private final String originThumbnailUrl;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof k) == true) goto L8;
        return false;
    L8:
        k r6 = (k) r5;
        if (Intrinsics.areEqual(this.originImageUri, r6.originImageUri) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.faceUri, r6.faceUri) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.faceMaskUri, r6.faceMaskUri) == true) goto L18;
        return false;
    L18:
        if (this.gender == r6.gender) goto L21;
        return false;
    L21:
        if (this.age == r6.age) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.originImageUrl, r6.originImageUrl) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.faceUrl, r6.faceUrl) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.faceMaskUrl, r6.faceMaskUrl) == true) goto L33;
        return false;
    L33:
        if (this.fromRefVideo == r6.fromRefVideo) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.originThumbnailUrl, r6.originThumbnailUrl) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final void f() {
        this.fromRefVideo = true;
    }

    public final int hashCode() {
        String r0 = this.originImageUri;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.faceUri;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.faceMaskUri;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (((((r6 + r8) * 31) + this.gender) * 31) + this.age) * 31;
        String r10 = this.originImageUrl;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.faceUrl;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.faceMaskUrl;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        if (this.fromRefVideo == false) goto L29;
        int r19 = 1231;
    L30:
        int r20 = (r18 + r19) * 31;
        String r21 = this.originThumbnailUrl;
        if (r21 == null) goto L35;
        r1 = r21.hashCode();
    L35:
        return r20 + r1;
    L29:
        r19 = 1237;
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
        return "PreGenImage(originImageUri=" + this.originImageUri + ", faceUri=" + this.faceUri + ", faceMaskUri=" + this.faceMaskUri + ", gender=" + this.gender + ", age=" + this.age + ", originImageUrl=" + this.originImageUrl + ", faceUrl=" + this.faceUrl + ", faceMaskUrl=" + this.faceMaskUrl + ", fromRefVideo=" + this.fromRefVideo + ", originThumbnailUrl=" + this.originThumbnailUrl + ')';
    }

    public k() {
        this.originImageUri = "";
        this.faceUri = "";
        this.faceMaskUri = "";
        this.gender = 0;
        this.age = -1;
        this.originImageUrl = "";
        this.faceUrl = "";
        this.faceMaskUrl = "";
        this.fromRefVideo = false;
        this.originThumbnailUrl = "";
    }

    public final boolean a() {
        return this.fromRefVideo;
    }

    public final int b() {
        return this.gender;
    }

    public final String c() {
        return this.originImageUri;
    }

    public final String d() {
        return this.originImageUrl;
    }

    public final String e() {
        return this.originThumbnailUrl;
    }
}
