package com.larus.platform.model.camera;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b!\b\u0087\b\u0018\u00002\u00020\u0001Bc\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005¢\u0006\u0004\b\u000f\u0010\u0010J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u000bHÆ\u0003J\t\u0010$\u001a\u00020\u000bHÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003Je\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u0005HÆ\u0001J\u0013\u0010(\u001a\u00020\u000b2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\u0005HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0016\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\f\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0016\u0010\r\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0016\u0010\u000e\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014¨\u0006,"}, d2 = {"Lcom/larus/platform/model/camera/ImageUploadProfile;", "", "scene", "", "maxShortSize", "", "maxBytes", "", "minQuality", "maxQuality", "enablePreUpload", "", "enableWeakNetworkCompress", "weakNetworkQualityLevel", "weakNetworkCompressQuality", "<init>", "(Ljava/lang/String;IJIIZZII)V", "getScene", "()Ljava/lang/String;", "getMaxShortSize", "()I", "getMaxBytes", "()J", "getMinQuality", "getMaxQuality", "getEnablePreUpload", "()Z", "getEnableWeakNetworkCompress", "getWeakNetworkQualityLevel", "getWeakNetworkCompressQuality", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ImageUploadProfile {

    @SerializedName("enable_pre_upload")
    private final boolean enablePreUpload;

    @SerializedName("enable_weak_network_compress")
    private final boolean enableWeakNetworkCompress;

    @SerializedName("max_long_size")
    private final long maxBytes;

    @SerializedName("max_quality")
    private final int maxQuality;

    @SerializedName("max_short_size")
    private final int maxShortSize;

    @SerializedName("min_quality")
    private final int minQuality;

    @SerializedName("scene")
    private final String scene;

    @SerializedName("weak_network_quality")
    private final int weakNetworkCompressQuality;

    @SerializedName("weak_network_quality_level")
    private final int weakNetworkQualityLevel;

    public ImageUploadProfile() {
        this(null, 0, 0, 0, 0, false, false, 0, 0, 511, null);
    }

    public static /* synthetic */ ImageUploadProfile copy$default(ImageUploadProfile r11, String r12, int r13, long r14, int r16, int r17, boolean r18, boolean r19, int r20, int r21, int r22, Object r23) {
        if ((r22 & 1) == 0) goto L5;
        String r2 = r11.scene;
    L7:
        if ((r22 & 2) == 0) goto L9;
        int r3 = r11.maxShortSize;
    L11:
        if ((r22 & 4) == 0) goto L13;
        long r4 = r11.maxBytes;
    L15:
        if ((r22 & 8) == 0) goto L17;
        int r6 = r11.minQuality;
    L19:
        if ((r22 & 16) == 0) goto L21;
        int r7 = r11.maxQuality;
    L23:
        if ((r22 & 32) == 0) goto L25;
        boolean r8 = r11.enablePreUpload;
    L27:
        if ((r22 & 64) == 0) goto L29;
        boolean r9 = r11.enableWeakNetworkCompress;
    L31:
        if ((r22 & 128) == 0) goto L33;
        int r10 = r11.weakNetworkQualityLevel;
    L35:
        if ((r22 & 256) == 0) goto L37;
        int r1 = r11.weakNetworkCompressQuality;
    L39:
        return r11.copy(r2, r3, r4, r6, r7, r8, r9, r10, r1);
    L37:
        r1 = r21;
        goto L39
    L33:
        r10 = r20;
        goto L35
    L29:
        r9 = r19;
        goto L31
    L25:
        r8 = r18;
        goto L27
    L21:
        r7 = r17;
        goto L23
    L17:
        r6 = r16;
        goto L19
    L13:
        r4 = r14;
        goto L15
    L9:
        r3 = r13;
        goto L11
    L5:
        r2 = r12;
        goto L7
    }

    public final String component1() {
        return this.scene;
    }

    public final int component2() {
        return this.maxShortSize;
    }

    public final long component3() {
        return this.maxBytes;
    }

    public final int component4() {
        return this.minQuality;
    }

    public final int component5() {
        return this.maxQuality;
    }

    public final boolean component6() {
        return this.enablePreUpload;
    }

    public final boolean component7() {
        return this.enableWeakNetworkCompress;
    }

    public final int component8() {
        return this.weakNetworkQualityLevel;
    }

    public final int component9() {
        return this.weakNetworkCompressQuality;
    }

    public final ImageUploadProfile copy(String r13, int r14, long r15, int r17, int r18, boolean r19, boolean r20, int r21, int r22) {
        return new ImageUploadProfile(r13, r14, r15, r17, r18, r19, r20, r21, r22);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof ImageUploadProfile) == true) goto L8;
        return false;
    L8:
        ImageUploadProfile r9 = (ImageUploadProfile) r8;
        if (Intrinsics.areEqual(this.scene, r9.scene) == true) goto L12;
        return false;
    L12:
        if (this.maxShortSize == r9.maxShortSize) goto L15;
        return false;
    L15:
        if (this.maxBytes == r9.maxBytes) goto L18;
        return false;
    L18:
        if (this.minQuality == r9.minQuality) goto L21;
        return false;
    L21:
        if (this.maxQuality == r9.maxQuality) goto L24;
        return false;
    L24:
        if (this.enablePreUpload == r9.enablePreUpload) goto L27;
        return false;
    L27:
        if (this.enableWeakNetworkCompress == r9.enableWeakNetworkCompress) goto L30;
        return false;
    L30:
        if (this.weakNetworkQualityLevel == r9.weakNetworkQualityLevel) goto L33;
        return false;
    L33:
        if (this.weakNetworkCompressQuality == r9.weakNetworkCompressQuality) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        String r0 = this.scene;
        if (r0 != null) goto L5;
        int r1 = 0;
    L6:
        int r2 = ((r1 * 31) + this.maxShortSize) * 31;
        long r3 = this.maxBytes;
        int r4 = (((((r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.minQuality) * 31) + this.maxQuality) * 31;
        int r5 = 1231;
        if (this.enablePreUpload == false) goto L9;
        int r6 = 1231;
    L10:
        int r7 = (r4 + r6) * 31;
        if (this.enableWeakNetworkCompress == true) goto L15;
        r5 = 1237;
    L15:
        return ((((r7 + r5) * 31) + this.weakNetworkQualityLevel) * 31) + this.weakNetworkCompressQuality;
    L9:
        r6 = 1237;
        goto L10
    L5:
        r1 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ImageUploadProfile(scene=" + this.scene + ", maxShortSize=" + this.maxShortSize + ", maxBytes=" + this.maxBytes + ", minQuality=" + this.minQuality + ", maxQuality=" + this.maxQuality + ", enablePreUpload=" + this.enablePreUpload + ", enableWeakNetworkCompress=" + this.enableWeakNetworkCompress + ", weakNetworkQualityLevel=" + this.weakNetworkQualityLevel + ", weakNetworkCompressQuality=" + this.weakNetworkCompressQuality + ')';
    }

    public final boolean getEnablePreUpload() {
        return this.enablePreUpload;
    }

    public final boolean getEnableWeakNetworkCompress() {
        return this.enableWeakNetworkCompress;
    }

    public final long getMaxBytes() {
        return this.maxBytes;
    }

    public final int getMaxQuality() {
        return this.maxQuality;
    }

    public final int getMaxShortSize() {
        return this.maxShortSize;
    }

    public final int getMinQuality() {
        return this.minQuality;
    }

    public final String getScene() {
        return this.scene;
    }

    public final int getWeakNetworkCompressQuality() {
        return this.weakNetworkCompressQuality;
    }

    public final int getWeakNetworkQualityLevel() {
        return this.weakNetworkQualityLevel;
    }

    public ImageUploadProfile(String r1, int r2, long r3, int r5, int r6, boolean r7, boolean r8, int r9, int r10) {
        this.scene = r1;
        this.maxShortSize = r2;
        this.maxBytes = r3;
        this.minQuality = r5;
        this.maxQuality = r6;
        this.enablePreUpload = r7;
        this.enableWeakNetworkCompress = r8;
        this.weakNetworkQualityLevel = r9;
        this.weakNetworkCompressQuality = r10;
    }

    public /* synthetic */ ImageUploadProfile(String r11, int r12, long r13, int r15, int r16, boolean r17, boolean r18, int r19, int r20, int r21, DefaultConstructorMarker r22) {
        if ((r21 & 1) == 0) goto L5;
        String r1 = null;
    L6:
        boolean r3 = false;
        if ((r21 & 2) == 0) goto L9;
        int r2 = 0;
    L11:
        if ((r21 & 4) == 0) goto L13;
        long r4 = 0;
    L15:
        if ((r21 & 8) == 0) goto L17;
        int r6 = 95;
    L19:
        if ((r21 & 16) == 0) goto L21;
        int r7 = 100;
    L23:
        if ((r21 & 32) == 0) goto L25;
        boolean r8 = false;
    L27:
        if ((r21 & 64) != 0) goto L31;
        r3 = r18;
    L31:
        if ((r21 & 128) == 0) goto L33;
        int r9 = 3;
    L35:
        if ((r21 & 256) == 0) goto L37;
        int r0 = 50;
    L38:
        this(r1, r2, r4, r6, r7, r8, r3, r9, r0);
        return;
    L37:
        r0 = r20;
        goto L38
    L33:
        r9 = r19;
        goto L35
    L25:
        r8 = r17;
        goto L27
    L21:
        r7 = r16;
        goto L23
    L17:
        r6 = r15;
        goto L19
    L13:
        r4 = r13;
        goto L15
    L9:
        r2 = r12;
        goto L11
    L5:
        r1 = r11;
        goto L6
    }
}
