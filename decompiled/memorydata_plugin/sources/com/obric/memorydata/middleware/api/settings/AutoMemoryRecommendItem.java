package com.obric.memorydata.middleware.api.settings;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.google.gson.annotations.SerializedName;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b,\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B¿\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010=\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010*J\u0010\u0010>\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010*J\u0010\u0010?\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0002\u0010.JÊ\u0001\u0010@\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÆ\u0001¢\u0006\u0002\u0010AJ\u0013\u0010B\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010E\u001a\u00020\u0013HÖ\u0001J\t\u0010F\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001aR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001aR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001aR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001aR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001aR\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010+\u001a\u0004\b)\u0010*R\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010+\u001a\u0004\b,\u0010*R\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010/\u001a\u0004\b-\u0010.¨\u0006G"}, d2 = {"Lcom/obric/memorydata/middleware/api/settings/AutoMemoryRecommendItem;", "", "title", "", Params.CONTENT, "subtitle", "icon", "iconColorKey", "memoryInfo", "Lcom/obric/memorydata/middleware/api/settings/AutoMemoryRecommendMemoryInfo;", MemoryInfoSectionEditActivity.KIND_SCENE, "info", "Lcom/obric/memorydata/middleware/api/settings/AutoMemoryRecommendSection;", "customRule", "updateRule", "titleFormat", "subtitleFormat", "contentFormat", "activeStartMinute", "", "activeEndMinute", OaidModel.KEY_ID, "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/obric/memorydata/middleware/api/settings/AutoMemoryRecommendMemoryInfo;Ljava/lang/String;Lcom/obric/memorydata/middleware/api/settings/AutoMemoryRecommendSection;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;)V", "getTitle", "()Ljava/lang/String;", "getContent", "getSubtitle", "getIcon", "getIconColorKey", "getMemoryInfo", "()Lcom/obric/memorydata/middleware/api/settings/AutoMemoryRecommendMemoryInfo;", "getScene", "getInfo", "()Lcom/obric/memorydata/middleware/api/settings/AutoMemoryRecommendSection;", "getCustomRule", "getUpdateRule", "getTitleFormat", "getSubtitleFormat", "getContentFormat", "getActiveStartMinute", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getActiveEndMinute", "getId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/obric/memorydata/middleware/api/settings/AutoMemoryRecommendMemoryInfo;Ljava/lang/String;Lcom/obric/memorydata/middleware/api/settings/AutoMemoryRecommendSection;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;)Lcom/obric/memorydata/middleware/api/settings/AutoMemoryRecommendItem;", "equals", "", "other", "hashCode", "toString", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AutoMemoryRecommendItem {

    @SerializedName(alternate = {"active_end_minute"}, value = "activeEndMinute")
    private final Integer activeEndMinute;

    @SerializedName(alternate = {"active_start_minute"}, value = "activeStartMinute")
    private final Integer activeStartMinute;

    @SerializedName(Params.CONTENT)
    private final String content;

    @SerializedName(alternate = {"content_format"}, value = "contentFormat")
    private final String contentFormat;

    @SerializedName(alternate = {"custom_rule"}, value = "customRule")
    private final String customRule;

    @SerializedName("icon")
    private final String icon;

    @SerializedName("iconColorKey")
    private final String iconColorKey;

    @SerializedName(OaidModel.KEY_ID)
    private final Long id;

    @SerializedName("info")
    private final AutoMemoryRecommendSection info;

    @SerializedName("memoryInfo")
    private final AutoMemoryRecommendMemoryInfo memoryInfo;

    @SerializedName(MemoryInfoSectionEditActivity.KIND_SCENE)
    private final String scene;

    @SerializedName("subtitle")
    private final String subtitle;

    @SerializedName(alternate = {"subtitle_format"}, value = "subtitleFormat")
    private final String subtitleFormat;

    @SerializedName("title")
    private final String title;

    @SerializedName(alternate = {"title_format"}, value = "titleFormat")
    private final String titleFormat;

    @SerializedName(alternate = {MemoryInfoSectionEditActivity.KIND_UPDATE_RULE}, value = "updateRule")
    private final String updateRule;

    public AutoMemoryRecommendItem(String r5, String r6, String r7, String r8, String r9, AutoMemoryRecommendMemoryInfo r10, String r11, AutoMemoryRecommendSection r12, String r13, String r14, String r15, String r16, String r17, Integer r18, Integer r19, Long r20) {
        Intrinsics.checkNotNullParameter(r5, "title");
        Intrinsics.checkNotNullParameter(r6, Params.CONTENT);
        this.title = r5;
        this.content = r6;
        this.subtitle = r7;
        this.icon = r8;
        this.iconColorKey = r9;
        this.memoryInfo = r10;
        this.scene = r11;
        this.info = r12;
        this.customRule = r13;
        this.updateRule = r14;
        this.titleFormat = r15;
        this.subtitleFormat = r16;
        this.contentFormat = r17;
        this.activeStartMinute = r18;
        this.activeEndMinute = r19;
        this.id = r20;
    }

    public /* synthetic */ AutoMemoryRecommendItem(String r21, String r22, String r23, String r24, String r25, AutoMemoryRecommendMemoryInfo r26, String r27, AutoMemoryRecommendSection r28, String r29, String r30, String r31, String r32, String r33, Integer r34, Integer r35, Long r36, int r37, DefaultConstructorMarker r38) {
        if ((r37 & 4) == 0) goto L5;
        String r6 = null;
    L7:
        if ((r37 & 8) == 0) goto L9;
        String r7 = null;
    L11:
        if ((r37 & 16) == 0) goto L13;
        String r8 = null;
    L15:
        if ((r37 & 32) == 0) goto L17;
        AutoMemoryRecommendMemoryInfo r9 = null;
    L19:
        if ((r37 & 64) == 0) goto L21;
        String r10 = null;
    L23:
        if ((r37 & 128) == 0) goto L25;
        AutoMemoryRecommendSection r11 = null;
    L27:
        if ((r37 & 256) == 0) goto L29;
        String r12 = null;
    L31:
        if ((r37 & 512) == 0) goto L33;
        String r13 = null;
    L35:
        if ((r37 & 1024) == 0) goto L37;
        String r14 = null;
    L39:
        if ((r37 & 2048) == 0) goto L41;
        String r15 = null;
    L43:
        if ((r37 & 4096) == 0) goto L45;
        String r16 = null;
    L47:
        if ((r37 & 8192) == 0) goto L49;
        Integer r17 = null;
    L51:
        if ((r37 & 16384) == 0) goto L53;
        Integer r18 = null;
    L55:
        if ((r37 & 32768) == 0) goto L57;
        Long r19 = null;
    L58:
        this(r21, r22, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19);
        return;
    L57:
        r19 = r36;
        goto L58
    L53:
        r18 = r35;
        goto L55
    L49:
        r17 = r34;
        goto L51
    L45:
        r16 = r33;
        goto L47
    L41:
        r15 = r32;
        goto L43
    L37:
        r14 = r31;
        goto L39
    L33:
        r13 = r30;
        goto L35
    L29:
        r12 = r29;
        goto L31
    L25:
        r11 = r28;
        goto L27
    L21:
        r10 = r27;
        goto L23
    L17:
        r9 = r26;
        goto L19
    L13:
        r8 = r25;
        goto L15
    L9:
        r7 = r24;
        goto L11
    L5:
        r6 = r23;
        goto L7
    }

    public static /* synthetic */ AutoMemoryRecommendItem copy$default(AutoMemoryRecommendItem r17, String r18, String r19, String r20, String r21, String r22, AutoMemoryRecommendMemoryInfo r23, String r24, AutoMemoryRecommendSection r25, String r26, String r27, String r28, String r29, String r30, Integer r31, Integer r32, Long r33, int r34, Object r35) {
        if ((r34 & 1) == 0) goto L5;
        String r2 = r17.title;
    L7:
        if ((r34 & 2) == 0) goto L9;
        String r3 = r17.content;
    L11:
        if ((r34 & 4) == 0) goto L13;
        String r4 = r17.subtitle;
    L15:
        if ((r34 & 8) == 0) goto L17;
        String r5 = r17.icon;
    L19:
        if ((r34 & 16) == 0) goto L21;
        String r6 = r17.iconColorKey;
    L23:
        if ((r34 & 32) == 0) goto L25;
        AutoMemoryRecommendMemoryInfo r7 = r17.memoryInfo;
    L27:
        if ((r34 & 64) == 0) goto L29;
        String r8 = r17.scene;
    L31:
        if ((r34 & 128) == 0) goto L33;
        AutoMemoryRecommendSection r9 = r17.info;
    L35:
        if ((r34 & 256) == 0) goto L37;
        String r10 = r17.customRule;
    L39:
        if ((r34 & 512) == 0) goto L41;
        String r11 = r17.updateRule;
    L43:
        if ((r34 & 1024) == 0) goto L45;
        String r12 = r17.titleFormat;
    L47:
        if ((r34 & 2048) == 0) goto L49;
        String r13 = r17.subtitleFormat;
    L51:
        if ((r34 & 4096) == 0) goto L53;
        String r14 = r17.contentFormat;
    L55:
        if ((r34 & 8192) == 0) goto L57;
        Integer r15 = r17.activeStartMinute;
    L58:
        Integer r36 = r15;
        if ((r34 & 16384) == 0) goto L61;
        Integer r16 = r17.activeEndMinute;
    L63:
        if ((r34 & 32768) == 0) goto L65;
        Long r1 = r17.id;
    L67:
        return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r36, r16, r1);
    L65:
        r1 = r33;
        goto L67
    L61:
        r16 = r32;
        goto L63
    L57:
        r15 = r31;
        goto L58
    L53:
        r14 = r30;
        goto L55
    L49:
        r13 = r29;
        goto L51
    L45:
        r12 = r28;
        goto L47
    L41:
        r11 = r27;
        goto L43
    L37:
        r10 = r26;
        goto L39
    L33:
        r9 = r25;
        goto L35
    L29:
        r8 = r24;
        goto L31
    L25:
        r7 = r23;
        goto L27
    L21:
        r6 = r22;
        goto L23
    L17:
        r5 = r21;
        goto L19
    L13:
        r4 = r20;
        goto L15
    L9:
        r3 = r19;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }

    public final String component1() {
        return this.title;
    }

    public final String component10() {
        return this.updateRule;
    }

    public final String component11() {
        return this.titleFormat;
    }

    public final String component12() {
        return this.subtitleFormat;
    }

    public final String component13() {
        return this.contentFormat;
    }

    public final Integer component14() {
        return this.activeStartMinute;
    }

    public final Integer component15() {
        return this.activeEndMinute;
    }

    public final Long component16() {
        return this.id;
    }

    public final String component2() {
        return this.content;
    }

    public final String component3() {
        return this.subtitle;
    }

    public final String component4() {
        return this.icon;
    }

    public final String component5() {
        return this.iconColorKey;
    }

    public final AutoMemoryRecommendMemoryInfo component6() {
        return this.memoryInfo;
    }

    public final String component7() {
        return this.scene;
    }

    public final AutoMemoryRecommendSection component8() {
        return this.info;
    }

    public final String component9() {
        return this.customRule;
    }

    public final AutoMemoryRecommendItem copy(String r19, String r20, String r21, String r22, String r23, AutoMemoryRecommendMemoryInfo r24, String r25, AutoMemoryRecommendSection r26, String r27, String r28, String r29, String r30, String r31, Integer r32, Integer r33, Long r34) {
        Intrinsics.checkNotNullParameter(r19, "title");
        Intrinsics.checkNotNullParameter(r20, Params.CONTENT);
        return new AutoMemoryRecommendItem(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, AutoMemoryRecommendItem.class) == true) goto L8;
        return false;
    L8:
        AutoMemoryRecommendItem r6 = (AutoMemoryRecommendItem) ZeusTransformUtils.preCheckCast(r5, AutoMemoryRecommendItem.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.title, r6.title) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.content, r6.content) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.subtitle, r6.subtitle) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.icon, r6.icon) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.iconColorKey, r6.iconColorKey) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.memoryInfo, r6.memoryInfo) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.scene, r6.scene) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.info, r6.info) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.customRule, r6.customRule) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.updateRule, r6.updateRule) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.titleFormat, r6.titleFormat) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.subtitleFormat, r6.subtitleFormat) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.contentFormat, r6.contentFormat) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.activeStartMinute, r6.activeStartMinute) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.activeEndMinute, r6.activeEndMinute) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.id, r6.id) == true) goto L56;
        return false;
    L56:
        return true;
    }

    public final Integer getActiveEndMinute() {
        return this.activeEndMinute;
    }

    public final Integer getActiveStartMinute() {
        return this.activeStartMinute;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getContentFormat() {
        return this.contentFormat;
    }

    public final String getCustomRule() {
        return this.customRule;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getIconColorKey() {
        return this.iconColorKey;
    }

    public final Long getId() {
        return this.id;
    }

    public final AutoMemoryRecommendSection getInfo() {
        return this.info;
    }

    public final AutoMemoryRecommendMemoryInfo getMemoryInfo() {
        return this.memoryInfo;
    }

    public final String getScene() {
        return this.scene;
    }

    public final String getSubtitle() {
        return this.subtitle;
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
        int r0 = ((this.title.hashCode() * 31) + this.content.hashCode()) * 31;
        String r1 = this.subtitle;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.icon;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.iconColorKey;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        AutoMemoryRecommendMemoryInfo r11 = this.memoryInfo;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        String r14 = this.scene;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        AutoMemoryRecommendSection r17 = this.info;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        String r20 = this.customRule;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (r19 + r21) * 31;
        String r23 = this.updateRule;
        if (r23 != null) goto L33;
        int r24 = 0;
    L34:
        int r25 = (r22 + r24) * 31;
        String r26 = this.titleFormat;
        if (r26 != null) goto L37;
        int r27 = 0;
    L38:
        int r28 = (r25 + r27) * 31;
        String r29 = this.subtitleFormat;
        if (r29 != null) goto L41;
        int r30 = 0;
    L42:
        int r31 = (r28 + r30) * 31;
        String r32 = this.contentFormat;
        if (r32 != null) goto L45;
        int r33 = 0;
    L46:
        int r34 = (r31 + r33) * 31;
        Integer r35 = this.activeStartMinute;
        if (r35 != null) goto L49;
        int r36 = 0;
    L50:
        int r37 = (r34 + r36) * 31;
        Integer r38 = this.activeEndMinute;
        if (r38 != null) goto L53;
        int r39 = 0;
    L54:
        int r40 = (r37 + r39) * 31;
        Long r41 = this.id;
        if (r41 == null) goto L59;
        r2 = r41.hashCode();
    L59:
        return r40 + r2;
    L53:
        r39 = r38.hashCode();
        goto L54
    L49:
        r36 = r35.hashCode();
        goto L50
    L45:
        r33 = r32.hashCode();
        goto L46
    L41:
        r30 = r29.hashCode();
        goto L42
    L37:
        r27 = r26.hashCode();
        goto L38
    L33:
        r24 = r23.hashCode();
        goto L34
    L29:
        r21 = r20.hashCode();
        goto L30
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

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("AutoMemoryRecommendItem(title=").append(this.title).append(", content=").append(this.content).append(", subtitle=").append(this.subtitle).append(", icon=").append(this.icon).append(", iconColorKey=").append(this.iconColorKey).append(", memoryInfo=").append(this.memoryInfo).append(", scene=").append(this.scene).append(", info=").append(this.info).append(", customRule=").append(this.customRule).append(", updateRule=").append(this.updateRule).append(", titleFormat=").append(this.titleFormat).append(", subtitleFormat=");
        r0.append(this.subtitleFormat).append(", contentFormat=").append(this.contentFormat).append(", activeStartMinute=").append(this.activeStartMinute).append(", activeEndMinute=").append(this.activeEndMinute).append(", id=").append(this.id).append(')');
        return r0.toString();
    }
}
