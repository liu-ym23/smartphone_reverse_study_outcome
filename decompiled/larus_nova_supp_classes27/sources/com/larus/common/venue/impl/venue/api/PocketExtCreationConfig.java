package com.larus.common.venue.impl.venue.api;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\bHÆ\u0003Jb\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\bHÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0012\u0010\u000eR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0018\u0010\n\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014¨\u0006&"}, d2 = {"Lcom/larus/common/venue/impl/venue/api/PocketExtCreationConfig;", "", "selectedModel", "", "selectedRatio", "selectedResolution", "selectedDuration", "hiddenResourceUrl", "", "hiddenResourceUri", "hiddenResourceVid", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSelectedModel", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getSelectedRatio", "getSelectedResolution", "getSelectedDuration", "getHiddenResourceUrl", "()Ljava/lang/String;", "getHiddenResourceUri", "getHiddenResourceVid", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/common/venue/impl/venue/api/PocketExtCreationConfig;", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PocketExtCreationConfig {

    @SerializedName("hidden_resource_uri")
    private final String hiddenResourceUri;

    @SerializedName("hidden_resource_url")
    private final String hiddenResourceUrl;

    @SerializedName("hidden_resource_vid")
    private final String hiddenResourceVid;

    @SerializedName("selected_duration")
    private final Long selectedDuration;

    @SerializedName("selected_model")
    private final Long selectedModel;

    @SerializedName("selected_ratio")
    private final Long selectedRatio;

    @SerializedName("selected_resolution")
    private final Long selectedResolution;

    public PocketExtCreationConfig() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ PocketExtCreationConfig copy$default(PocketExtCreationConfig r5, Long r6, Long r7, Long r8, Long r9, String r10, String r11, String r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.selectedModel;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.selectedRatio;
    L8:
        Long r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.selectedResolution;
    L11:
        Long r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.selectedDuration;
    L14:
        Long r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.hiddenResourceUrl;
    L17:
        String r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.hiddenResourceUri;
    L20:
        String r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.hiddenResourceVid;
    L23:
        Long r16 = r6;
        return r5.copy(r16, r15, r0, r1, r2, r3, r12);
    }

    public final Long component1() {
        return this.selectedModel;
    }

    public final Long component2() {
        return this.selectedRatio;
    }

    public final Long component3() {
        return this.selectedResolution;
    }

    public final Long component4() {
        return this.selectedDuration;
    }

    public final String component5() {
        return this.hiddenResourceUrl;
    }

    public final String component6() {
        return this.hiddenResourceUri;
    }

    public final String component7() {
        return this.hiddenResourceVid;
    }

    public final PocketExtCreationConfig copy(Long r10, Long r11, Long r12, Long r13, String r14, String r15, String r16) {
        return new PocketExtCreationConfig(r10, r11, r12, r13, r14, r15, r16);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof PocketExtCreationConfig) == true) goto L8;
        return false;
    L8:
        PocketExtCreationConfig r6 = (PocketExtCreationConfig) r5;
        if (Intrinsics.areEqual(this.selectedModel, r6.selectedModel) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.selectedRatio, r6.selectedRatio) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.selectedResolution, r6.selectedResolution) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.selectedDuration, r6.selectedDuration) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.hiddenResourceUrl, r6.hiddenResourceUrl) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.hiddenResourceUri, r6.hiddenResourceUri) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.hiddenResourceVid, r6.hiddenResourceVid) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        Long r0 = this.selectedModel;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Long r4 = this.selectedRatio;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Long r7 = this.selectedResolution;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Long r10 = this.selectedDuration;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.hiddenResourceUrl;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.hiddenResourceUri;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r20 = this.hiddenResourceVid;
        if (r20 == null) goto L31;
        r1 = r20.hashCode();
    L31:
        return r18 + r1;
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

    public String toString() {
        return "PocketExtCreationConfig(selectedModel=" + this.selectedModel + ", selectedRatio=" + this.selectedRatio + ", selectedResolution=" + this.selectedResolution + ", selectedDuration=" + this.selectedDuration + ", hiddenResourceUrl=" + this.hiddenResourceUrl + ", hiddenResourceUri=" + this.hiddenResourceUri + ", hiddenResourceVid=" + this.hiddenResourceVid + ')';
    }

    public final String getHiddenResourceUri() {
        return this.hiddenResourceUri;
    }

    public final String getHiddenResourceUrl() {
        return this.hiddenResourceUrl;
    }

    public final String getHiddenResourceVid() {
        return this.hiddenResourceVid;
    }

    public final Long getSelectedDuration() {
        return this.selectedDuration;
    }

    public final Long getSelectedModel() {
        return this.selectedModel;
    }

    public final Long getSelectedRatio() {
        return this.selectedRatio;
    }

    public final Long getSelectedResolution() {
        return this.selectedResolution;
    }

    public PocketExtCreationConfig(Long r1, Long r2, Long r3, Long r4, String r5, String r6, String r7) {
        this.selectedModel = r1;
        this.selectedRatio = r2;
        this.selectedResolution = r3;
        this.selectedDuration = r4;
        this.hiddenResourceUrl = r5;
        this.hiddenResourceUri = r6;
        this.hiddenResourceVid = r7;
    }

    public /* synthetic */ PocketExtCreationConfig(Long r7, Long r8, Long r9, Long r10, String r11, String r12, String r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 1) == 0) goto L5;
        Long r16 = null;
    L7:
        if ((r14 & 2) == 0) goto L9;
        Long r1 = null;
    L11:
        if ((r14 & 4) == 0) goto L13;
        Long r2 = null;
    L15:
        if ((r14 & 8) == 0) goto L17;
        Long r3 = null;
    L19:
        if ((r14 & 16) == 0) goto L21;
        String r4 = null;
    L23:
        if ((r14 & 32) == 0) goto L25;
        String r5 = null;
    L27:
        if ((r14 & 64) == 0) goto L29;
        String r17 = null;
    L30:
        this(r16, r1, r2, r3, r4, r5, r17);
        return;
    L29:
        r17 = r13;
        goto L30
    L25:
        r5 = r12;
        goto L27
    L21:
        r4 = r11;
        goto L23
    L17:
        r3 = r10;
        goto L19
    L13:
        r2 = r9;
        goto L15
    L9:
        r1 = r8;
        goto L11
    L5:
        r16 = r7;
        goto L7
    }
}
