package com.larus.canvas.service.bean;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b.\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B¹\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\t\u00102\u001a\u00020\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0005HÆ\u0003J»\u0001\u0010A\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010B\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010E\u001a\u00020FHÖ\u0001J\t\u0010G\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001eR\u0018\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010-R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001eR\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001eR\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001e¨\u0006H"}, d2 = {"Lcom/larus/canvas/service/bean/OptionItem;", "", "id", "", "displayText", "", "messageText", "icon", "Lcom/larus/canvas/service/bean/Icon;", "darkModeIcon", "extra", "Lcom/larus/canvas/service/bean/OptionExtra;", "redirectSchema", "maskUri", "Lcom/larus/canvas/service/bean/MaskUri;", "paramFilterConf", "Lcom/larus/canvas/service/bean/ParamFilterConf;", "msgPromptConf", "Lcom/larus/canvas/service/bean/MsgPromptConf;", "iconOri", "Lcom/larus/canvas/service/bean/ImageInfo;", "previewIcon", "language", "sourceMessageText", "targetMessageText", "<init>", "(JLjava/lang/String;Ljava/lang/String;Lcom/larus/canvas/service/bean/Icon;Lcom/larus/canvas/service/bean/Icon;Lcom/larus/canvas/service/bean/OptionExtra;Ljava/lang/String;Lcom/larus/canvas/service/bean/MaskUri;Lcom/larus/canvas/service/bean/ParamFilterConf;Lcom/larus/canvas/service/bean/MsgPromptConf;Lcom/larus/canvas/service/bean/ImageInfo;Lcom/larus/canvas/service/bean/ImageInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()J", "getDisplayText", "()Ljava/lang/String;", "getMessageText", "getIcon", "()Lcom/larus/canvas/service/bean/Icon;", "getDarkModeIcon", "getExtra", "()Lcom/larus/canvas/service/bean/OptionExtra;", "getRedirectSchema", "getMaskUri", "()Lcom/larus/canvas/service/bean/MaskUri;", "getParamFilterConf", "()Lcom/larus/canvas/service/bean/ParamFilterConf;", "getMsgPromptConf", "()Lcom/larus/canvas/service/bean/MsgPromptConf;", "getIconOri", "()Lcom/larus/canvas/service/bean/ImageInfo;", "getPreviewIcon", "getLanguage", "getSourceMessageText", "getTargetMessageText", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "equals", "", "other", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OptionItem {

    @SerializedName("dark_mode_icon")
    private final Icon darkModeIcon;

    @SerializedName("display_text")
    private final String displayText;

    @SerializedName("extra")
    private final OptionExtra extra;

    @SerializedName("icon")
    private final Icon icon;

    @SerializedName("icon_ori")
    private final ImageInfo iconOri;

    @SerializedName("id")
    private final long id;

    @SerializedName("language")
    private final String language;

    @SerializedName("mask_uri")
    private final MaskUri maskUri;

    @SerializedName("message_text")
    private final String messageText;

    @SerializedName("msg_prompt_conf")
    private final MsgPromptConf msgPromptConf;

    @SerializedName("param_filter_conf")
    private final ParamFilterConf paramFilterConf;

    @SerializedName("preview_icon")
    private final ImageInfo previewIcon;

    @SerializedName("redirect_schema")
    private final String redirectSchema;

    @SerializedName("source_message_text")
    private final String sourceMessageText;

    @SerializedName("target_message_text")
    private final String targetMessageText;

    public OptionItem() {
        this(0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32767, null);
    }

    public static /* synthetic */ OptionItem copy$default(OptionItem r16, long r17, String r19, String r20, Icon r21, Icon r22, OptionExtra r23, String r24, MaskUri r25, ParamFilterConf r26, MsgPromptConf r27, ImageInfo r28, ImageInfo r29, String r30, String r31, String r32, int r33, Object r34) {
        if ((r33 & 1) == 0) goto L5;
        long r2 = r16.id;
    L7:
        if ((r33 & 2) == 0) goto L9;
        String r4 = r16.displayText;
    L11:
        if ((r33 & 4) == 0) goto L13;
        String r5 = r16.messageText;
    L15:
        if ((r33 & 8) == 0) goto L17;
        Icon r6 = r16.icon;
    L19:
        if ((r33 & 16) == 0) goto L21;
        Icon r7 = r16.darkModeIcon;
    L23:
        if ((r33 & 32) == 0) goto L25;
        OptionExtra r8 = r16.extra;
    L27:
        if ((r33 & 64) == 0) goto L29;
        String r9 = r16.redirectSchema;
    L31:
        if ((r33 & 128) == 0) goto L33;
        MaskUri r10 = r16.maskUri;
    L35:
        if ((r33 & 256) == 0) goto L37;
        ParamFilterConf r11 = r16.paramFilterConf;
    L39:
        if ((r33 & 512) == 0) goto L41;
        MsgPromptConf r12 = r16.msgPromptConf;
    L43:
        if ((r33 & 1024) == 0) goto L45;
        ImageInfo r13 = r16.iconOri;
    L47:
        if ((r33 & 2048) == 0) goto L49;
        ImageInfo r14 = r16.previewIcon;
    L51:
        if ((r33 & 4096) == 0) goto L53;
        String r15 = r16.language;
    L54:
        String r35 = r15;
        if ((r33 & 8192) == 0) goto L57;
        String r18 = r16.sourceMessageText;
    L59:
        if ((r33 & 16384) == 0) goto L61;
        String r1 = r16.targetMessageText;
    L63:
        return r16.copy(r2, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r35, r18, r1);
    L61:
        r1 = r32;
        goto L63
    L57:
        r18 = r31;
        goto L59
    L53:
        r15 = r30;
        goto L54
    L49:
        r14 = r29;
        goto L51
    L45:
        r13 = r28;
        goto L47
    L41:
        r12 = r27;
        goto L43
    L37:
        r11 = r26;
        goto L39
    L33:
        r10 = r25;
        goto L35
    L29:
        r9 = r24;
        goto L31
    L25:
        r8 = r23;
        goto L27
    L21:
        r7 = r22;
        goto L23
    L17:
        r6 = r21;
        goto L19
    L13:
        r5 = r20;
        goto L15
    L9:
        r4 = r19;
        goto L11
    L5:
        r2 = r17;
        goto L7
    }

    public final long component1() {
        return this.id;
    }

    public final MsgPromptConf component10() {
        return this.msgPromptConf;
    }

    public final ImageInfo component11() {
        return this.iconOri;
    }

    public final ImageInfo component12() {
        return this.previewIcon;
    }

    public final String component13() {
        return this.language;
    }

    public final String component14() {
        return this.sourceMessageText;
    }

    public final String component15() {
        return this.targetMessageText;
    }

    public final String component2() {
        return this.displayText;
    }

    public final String component3() {
        return this.messageText;
    }

    public final Icon component4() {
        return this.icon;
    }

    public final Icon component5() {
        return this.darkModeIcon;
    }

    public final OptionExtra component6() {
        return this.extra;
    }

    public final String component7() {
        return this.redirectSchema;
    }

    public final MaskUri component8() {
        return this.maskUri;
    }

    public final ParamFilterConf component9() {
        return this.paramFilterConf;
    }

    public final OptionItem copy(long r19, String r21, String r22, Icon r23, Icon r24, OptionExtra r25, String r26, MaskUri r27, ParamFilterConf r28, MsgPromptConf r29, ImageInfo r30, ImageInfo r31, String r32, String r33, String r34) {
        return new OptionItem(r19, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof OptionItem) == true) goto L8;
        return false;
    L8:
        OptionItem r9 = (OptionItem) r8;
        if (this.id == r9.id) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.displayText, r9.displayText) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.messageText, r9.messageText) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.icon, r9.icon) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.darkModeIcon, r9.darkModeIcon) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.extra, r9.extra) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.redirectSchema, r9.redirectSchema) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.maskUri, r9.maskUri) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.paramFilterConf, r9.paramFilterConf) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.msgPromptConf, r9.msgPromptConf) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.iconOri, r9.iconOri) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.previewIcon, r9.previewIcon) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.language, r9.language) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.sourceMessageText, r9.sourceMessageText) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.targetMessageText, r9.targetMessageText) == true) goto L53;
        return false;
    L53:
        return true;
    }

    public int hashCode() {
        long r0 = this.id;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        String r2 = this.displayText;
        int r3 = 0;
        if (r2 != null) goto L5;
        int r4 = 0;
    L6:
        int r5 = (r1 + r4) * 31;
        String r6 = this.messageText;
        if (r6 != null) goto L9;
        int r7 = 0;
    L10:
        int r8 = (r5 + r7) * 31;
        Icon r9 = this.icon;
        if (r9 != null) goto L13;
        int r10 = 0;
    L14:
        int r11 = (r8 + r10) * 31;
        Icon r12 = this.darkModeIcon;
        if (r12 != null) goto L17;
        int r13 = 0;
    L18:
        int r14 = (r11 + r13) * 31;
        OptionExtra r15 = this.extra;
        if (r15 != null) goto L21;
        int r16 = 0;
    L22:
        int r17 = (r14 + r16) * 31;
        String r18 = this.redirectSchema;
        if (r18 != null) goto L25;
        int r19 = 0;
    L26:
        int r20 = (r17 + r19) * 31;
        MaskUri r21 = this.maskUri;
        if (r21 != null) goto L29;
        int r22 = 0;
    L30:
        int r23 = (r20 + r22) * 31;
        ParamFilterConf r24 = this.paramFilterConf;
        if (r24 != null) goto L33;
        int r25 = 0;
    L34:
        int r26 = (r23 + r25) * 31;
        MsgPromptConf r27 = this.msgPromptConf;
        if (r27 != null) goto L37;
        int r28 = 0;
    L38:
        int r29 = (r26 + r28) * 31;
        ImageInfo r30 = this.iconOri;
        if (r30 != null) goto L41;
        int r31 = 0;
    L42:
        int r32 = (r29 + r31) * 31;
        ImageInfo r33 = this.previewIcon;
        if (r33 != null) goto L45;
        int r34 = 0;
    L46:
        int r35 = (r32 + r34) * 31;
        String r36 = this.language;
        if (r36 != null) goto L49;
        int r37 = 0;
    L50:
        int r38 = (r35 + r37) * 31;
        String r39 = this.sourceMessageText;
        if (r39 != null) goto L53;
        int r40 = 0;
    L54:
        int r41 = (r38 + r40) * 31;
        String r42 = this.targetMessageText;
        if (r42 == null) goto L59;
        r3 = r42.hashCode();
    L59:
        return r41 + r3;
    L53:
        r40 = r39.hashCode();
        goto L54
    L49:
        r37 = r36.hashCode();
        goto L50
    L45:
        r34 = r33.hashCode();
        goto L46
    L41:
        r31 = r30.hashCode();
        goto L42
    L37:
        r28 = r27.hashCode();
        goto L38
    L33:
        r25 = r24.hashCode();
        goto L34
    L29:
        r22 = r21.hashCode();
        goto L30
    L25:
        r19 = r18.hashCode();
        goto L26
    L21:
        r16 = r15.hashCode();
        goto L22
    L17:
        r13 = r12.hashCode();
        goto L18
    L13:
        r10 = r9.hashCode();
        goto L14
    L9:
        r7 = r6.hashCode();
        goto L10
    L5:
        r4 = r2.hashCode();
        goto L6
    }

    public String toString() {
        return "OptionItem(id=" + this.id + ", displayText=" + this.displayText + ", messageText=" + this.messageText + ", icon=" + this.icon + ", darkModeIcon=" + this.darkModeIcon + ", extra=" + this.extra + ", redirectSchema=" + this.redirectSchema + ", maskUri=" + this.maskUri + ", paramFilterConf=" + this.paramFilterConf + ", msgPromptConf=" + this.msgPromptConf + ", iconOri=" + this.iconOri + ", previewIcon=" + this.previewIcon + ", language=" + this.language + ", sourceMessageText=" + this.sourceMessageText + ", targetMessageText=" + this.targetMessageText + ')';
    }

    public final Icon getDarkModeIcon() {
        return this.darkModeIcon;
    }

    public final String getDisplayText() {
        return this.displayText;
    }

    public final OptionExtra getExtra() {
        return this.extra;
    }

    public final Icon getIcon() {
        return this.icon;
    }

    public final ImageInfo getIconOri() {
        return this.iconOri;
    }

    public final long getId() {
        return this.id;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final MaskUri getMaskUri() {
        return this.maskUri;
    }

    public final String getMessageText() {
        return this.messageText;
    }

    public final MsgPromptConf getMsgPromptConf() {
        return this.msgPromptConf;
    }

    public final ParamFilterConf getParamFilterConf() {
        return this.paramFilterConf;
    }

    public final ImageInfo getPreviewIcon() {
        return this.previewIcon;
    }

    public final String getRedirectSchema() {
        return this.redirectSchema;
    }

    public final String getSourceMessageText() {
        return this.sourceMessageText;
    }

    public final String getTargetMessageText() {
        return this.targetMessageText;
    }

    public OptionItem(long r4, String r6, String r7, Icon r8, Icon r9, OptionExtra r10, String r11, MaskUri r12, ParamFilterConf r13, MsgPromptConf r14, ImageInfo r15, ImageInfo r16, String r17, String r18, String r19) {
        this.id = r4;
        this.displayText = r6;
        this.messageText = r7;
        this.icon = r8;
        this.darkModeIcon = r9;
        this.extra = r10;
        this.redirectSchema = r11;
        this.maskUri = r12;
        this.paramFilterConf = r13;
        this.msgPromptConf = r14;
        this.iconOri = r15;
        this.previewIcon = r16;
        this.language = r17;
        this.sourceMessageText = r18;
        this.targetMessageText = r19;
    }

    public /* synthetic */ OptionItem(long r17, String r19, String r20, Icon r21, Icon r22, OptionExtra r23, String r24, MaskUri r25, ParamFilterConf r26, MsgPromptConf r27, ImageInfo r28, ImageInfo r29, String r30, String r31, String r32, int r33, DefaultConstructorMarker r34) {
        if ((r33 & 1) == 0) goto L5;
        long r1 = 0;
    L7:
        if ((r33 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r33 & 4) == 0) goto L13;
        String r5 = null;
    L15:
        if ((r33 & 8) == 0) goto L17;
        Icon r6 = null;
    L19:
        if ((r33 & 16) == 0) goto L21;
        Icon r7 = null;
    L23:
        if ((r33 & 32) == 0) goto L25;
        OptionExtra r8 = null;
    L27:
        if ((r33 & 64) == 0) goto L29;
        String r9 = null;
    L31:
        if ((r33 & 128) == 0) goto L33;
        MaskUri r10 = null;
    L35:
        if ((r33 & 256) == 0) goto L37;
        ParamFilterConf r11 = null;
    L39:
        if ((r33 & 512) == 0) goto L41;
        MsgPromptConf r12 = null;
    L43:
        if ((r33 & 1024) == 0) goto L45;
        ImageInfo r13 = null;
    L47:
        if ((r33 & 2048) == 0) goto L49;
        ImageInfo r14 = null;
    L51:
        if ((r33 & 4096) == 0) goto L53;
        String r15 = null;
    L55:
        if ((r33 & 8192) == 0) goto L57;
        String r4 = null;
    L59:
        if ((r33 & 16384) == 0) goto L61;
        String r0 = null;
    L62:
        this(r1, r3, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r4, r0);
        return;
    L61:
        r0 = r32;
        goto L62
    L57:
        r4 = r31;
        goto L59
    L53:
        r15 = r30;
        goto L55
    L49:
        r14 = r29;
        goto L51
    L45:
        r13 = r28;
        goto L47
    L41:
        r12 = r27;
        goto L43
    L37:
        r11 = r26;
        goto L39
    L33:
        r10 = r25;
        goto L35
    L29:
        r9 = r24;
        goto L31
    L25:
        r8 = r23;
        goto L27
    L21:
        r7 = r22;
        goto L23
    L17:
        r6 = r21;
        goto L19
    L13:
        r5 = r20;
        goto L15
    L9:
        r3 = r19;
        goto L11
    L5:
        r1 = r17;
        goto L7
    }
}
