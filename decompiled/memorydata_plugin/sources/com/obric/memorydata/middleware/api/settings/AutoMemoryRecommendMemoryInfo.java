package com.obric.memorydata.middleware.api.settings;

import com.google.gson.annotations.SerializedName;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003Ji\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000f¨\u0006'"}, d2 = {"Lcom/obric/memorydata/middleware/api/settings/AutoMemoryRecommendMemoryInfo;", "", "title", "", MemoryInfoSectionEditActivity.KIND_SCENE, "info", "Lcom/obric/memorydata/middleware/api/settings/AutoMemoryRecommendSection;", "customRule", "updateRule", "titleFormat", "subtitleFormat", "contentFormat", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/obric/memorydata/middleware/api/settings/AutoMemoryRecommendSection;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getScene", "getInfo", "()Lcom/obric/memorydata/middleware/api/settings/AutoMemoryRecommendSection;", "getCustomRule", "getUpdateRule", "getTitleFormat", "getSubtitleFormat", "getContentFormat", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AutoMemoryRecommendMemoryInfo {

    @SerializedName(alternate = {"content_format"}, value = "contentFormat")
    private final String contentFormat;

    @SerializedName(alternate = {"custom_rule"}, value = "customRule")
    private final String customRule;

    @SerializedName("info")
    private final AutoMemoryRecommendSection info;

    @SerializedName(MemoryInfoSectionEditActivity.KIND_SCENE)
    private final String scene;

    @SerializedName(alternate = {"subtitle_format"}, value = "subtitleFormat")
    private final String subtitleFormat;

    @SerializedName("title")
    private final String title;

    @SerializedName(alternate = {"title_format"}, value = "titleFormat")
    private final String titleFormat;

    @SerializedName(alternate = {MemoryInfoSectionEditActivity.KIND_UPDATE_RULE}, value = "updateRule")
    private final String updateRule;

    public AutoMemoryRecommendMemoryInfo() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public AutoMemoryRecommendMemoryInfo(String r1, String r2, AutoMemoryRecommendSection r3, String r4, String r5, String r6, String r7, String r8) {
        this.title = r1;
        this.scene = r2;
        this.info = r3;
        this.customRule = r4;
        this.updateRule = r5;
        this.titleFormat = r6;
        this.subtitleFormat = r7;
        this.contentFormat = r8;
    }

    public /* synthetic */ AutoMemoryRecommendMemoryInfo(String r2, String r3, AutoMemoryRecommendSection r4, String r5, String r6, String r7, String r8, String r9, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r10 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r10 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r10 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r10 & 16) == 0) goto L18;
        r6 = null;
    L18:
        if ((r10 & 32) == 0) goto L21;
        r7 = null;
    L21:
        if ((r10 & 64) == 0) goto L24;
        r8 = null;
    L24:
        if ((r10 & 128) == 0) goto L26;
        r9 = null;
    L26:
        this(r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public static /* synthetic */ AutoMemoryRecommendMemoryInfo copy$default(AutoMemoryRecommendMemoryInfo r9, String r10, String r11, AutoMemoryRecommendSection r12, String r13, String r14, String r15, String r16, String r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        String r2 = r9.title;
    L7:
        if ((r18 & 2) == 0) goto L9;
        String r3 = r9.scene;
    L11:
        if ((r18 & 4) == 0) goto L13;
        AutoMemoryRecommendSection r4 = r9.info;
    L15:
        if ((r18 & 8) == 0) goto L17;
        String r5 = r9.customRule;
    L19:
        if ((r18 & 16) == 0) goto L21;
        String r6 = r9.updateRule;
    L23:
        if ((r18 & 32) == 0) goto L25;
        String r7 = r9.titleFormat;
    L27:
        if ((r18 & 64) == 0) goto L29;
        String r8 = r9.subtitleFormat;
    L31:
        if ((r18 & 128) == 0) goto L33;
        String r1 = r9.contentFormat;
    L35:
        return r9.copy(r2, r3, r4, r5, r6, r7, r8, r1);
    L33:
        r1 = r17;
        goto L35
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r2 = r10;
        goto L7
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.scene;
    }

    public final AutoMemoryRecommendSection component3() {
        return this.info;
    }

    public final String component4() {
        return this.customRule;
    }

    public final String component5() {
        return this.updateRule;
    }

    public final String component6() {
        return this.titleFormat;
    }

    public final String component7() {
        return this.subtitleFormat;
    }

    public final String component8() {
        return this.contentFormat;
    }

    public final AutoMemoryRecommendMemoryInfo copy(String r11, String r12, AutoMemoryRecommendSection r13, String r14, String r15, String r16, String r17, String r18) {
        return new AutoMemoryRecommendMemoryInfo(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, AutoMemoryRecommendMemoryInfo.class) == true) goto L8;
        return false;
    L8:
        AutoMemoryRecommendMemoryInfo r6 = (AutoMemoryRecommendMemoryInfo) ZeusTransformUtils.preCheckCast(r5, AutoMemoryRecommendMemoryInfo.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.title, r6.title) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.scene, r6.scene) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.info, r6.info) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.customRule, r6.customRule) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.updateRule, r6.updateRule) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.titleFormat, r6.titleFormat) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.subtitleFormat, r6.subtitleFormat) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.contentFormat, r6.contentFormat) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final String getContentFormat() {
        return this.contentFormat;
    }

    public final String getCustomRule() {
        return this.customRule;
    }

    public final AutoMemoryRecommendSection getInfo() {
        return this.info;
    }

    public final String getScene() {
        return this.scene;
    }

    public final String getSubtitleFormat() {
        return this.subtitleFormat;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getTitleFormat() {
        return this.titleFormat;
    }

    public final String getUpdateRule() {
        return this.updateRule;
    }

    public int hashCode() {
        String r0 = this.title;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.scene;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        AutoMemoryRecommendSection r7 = this.info;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.customRule;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.updateRule;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.titleFormat;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.subtitleFormat;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.contentFormat;
        if (r22 == null) goto L35;
        r1 = r22.hashCode();
    L35:
        return r21 + r1;
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

    public String toString() {
        return "AutoMemoryRecommendMemoryInfo(title=" + this.title + ", scene=" + this.scene + ", info=" + this.info + ", customRule=" + this.customRule + ", updateRule=" + this.updateRule + ", titleFormat=" + this.titleFormat + ", subtitleFormat=" + this.subtitleFormat + ", contentFormat=" + this.contentFormat + ')';
    }
}
