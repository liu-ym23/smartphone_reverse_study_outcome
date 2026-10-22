package com.larus.platform.model.camera;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BW\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003JY\u0010\u0018\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR \u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR \u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u001f"}, d2 = {"Lcom/larus/platform/model/camera/AppImageUploadPerfOptConf;", "", "lowQualityProfiles", "", "Lcom/larus/platform/model/camera/ImageUploadProfile;", "normalQualityProfiles", "highQualityProfiles", "enableCameraOpt", "", "enableAlbumOpt", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;ZZ)V", "getLowQualityProfiles", "()Ljava/util/List;", "getNormalQualityProfiles", "getHighQualityProfiles", "getEnableCameraOpt", "()Z", "getEnableAlbumOpt", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class AppImageUploadPerfOptConf {

    @SerializedName("enable_album_opt")
    private final boolean enableAlbumOpt;

    @SerializedName("enable_camera_opt")
    private final boolean enableCameraOpt;

    @SerializedName("high_profiles")
    private final List<ImageUploadProfile> highQualityProfiles;

    @SerializedName("low_profiles")
    private final List<ImageUploadProfile> lowQualityProfiles;

    @SerializedName("normal_profiles")
    private final List<ImageUploadProfile> normalQualityProfiles;

    public AppImageUploadPerfOptConf() {
        this(null, null, null, false, false, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AppImageUploadPerfOptConf copy$default(AppImageUploadPerfOptConf r3, List r4, List r5, List r6, boolean r7, boolean r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.lowQualityProfiles;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.normalQualityProfiles;
    L8:
        List r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.highQualityProfiles;
    L11:
        List r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.enableCameraOpt;
    L14:
        boolean r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.enableAlbumOpt;
    L17:
        List r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final List<ImageUploadProfile> component1() {
        return this.lowQualityProfiles;
    }

    public final List<ImageUploadProfile> component2() {
        return this.normalQualityProfiles;
    }

    public final List<ImageUploadProfile> component3() {
        return this.highQualityProfiles;
    }

    public final boolean component4() {
        return this.enableCameraOpt;
    }

    public final boolean component5() {
        return this.enableAlbumOpt;
    }

    public final AppImageUploadPerfOptConf copy(List<ImageUploadProfile> r8, List<ImageUploadProfile> r9, List<ImageUploadProfile> r10, boolean r11, boolean r12) {
        return new AppImageUploadPerfOptConf(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AppImageUploadPerfOptConf) == true) goto L8;
        return false;
    L8:
        AppImageUploadPerfOptConf r6 = (AppImageUploadPerfOptConf) r5;
        if (Intrinsics.areEqual(this.lowQualityProfiles, r6.lowQualityProfiles) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.normalQualityProfiles, r6.normalQualityProfiles) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.highQualityProfiles, r6.highQualityProfiles) == true) goto L18;
        return false;
    L18:
        if (this.enableCameraOpt == r6.enableCameraOpt) goto L21;
        return false;
    L21:
        if (this.enableAlbumOpt == r6.enableAlbumOpt) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        List<ImageUploadProfile> r0 = this.lowQualityProfiles;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<ImageUploadProfile> r4 = this.normalQualityProfiles;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        List<ImageUploadProfile> r7 = this.highQualityProfiles;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        int r8 = (r6 + r1) * 31;
        int r9 = 1231;
        if (this.enableCameraOpt == false) goto L17;
        int r10 = 1231;
    L18:
        int r11 = (r8 + r10) * 31;
        if (this.enableAlbumOpt == true) goto L23;
        r9 = 1237;
    L23:
        return r11 + r9;
    L17:
        r10 = 1237;
        goto L18
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "AppImageUploadPerfOptConf(lowQualityProfiles=" + this.lowQualityProfiles + ", normalQualityProfiles=" + this.normalQualityProfiles + ", highQualityProfiles=" + this.highQualityProfiles + ", enableCameraOpt=" + this.enableCameraOpt + ", enableAlbumOpt=" + this.enableAlbumOpt + ')';
    }

    public final boolean getEnableAlbumOpt() {
        return this.enableAlbumOpt;
    }

    public final boolean getEnableCameraOpt() {
        return this.enableCameraOpt;
    }

    public final List<ImageUploadProfile> getHighQualityProfiles() {
        return this.highQualityProfiles;
    }

    public final List<ImageUploadProfile> getLowQualityProfiles() {
        return this.lowQualityProfiles;
    }

    public final List<ImageUploadProfile> getNormalQualityProfiles() {
        return this.normalQualityProfiles;
    }

    public AppImageUploadPerfOptConf(List<ImageUploadProfile> r1, List<ImageUploadProfile> r2, List<ImageUploadProfile> r3, boolean r4, boolean r5) {
        this.lowQualityProfiles = r1;
        this.normalQualityProfiles = r2;
        this.highQualityProfiles = r3;
        this.enableCameraOpt = r4;
        this.enableAlbumOpt = r5;
    }

    public /* synthetic */ AppImageUploadPerfOptConf(List r4, List r5, List r6, boolean r7, boolean r8, int r9, DefaultConstructorMarker r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = CollectionsKt.emptyList();
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = CollectionsKt.emptyList();
    L8:
        List r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = CollectionsKt.emptyList();
    L11:
        List r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        boolean r1 = false;
    L16:
        if ((r9 & 16) == 0) goto L18;
        boolean r2 = false;
    L19:
        this(r4, r11, r0, r1, r2);
        return;
    L18:
        r2 = r8;
        goto L19
    L14:
        r1 = r7;
        goto L16
    }
}
