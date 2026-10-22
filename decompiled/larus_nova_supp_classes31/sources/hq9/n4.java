package hq9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\bB\b\u0086\b\u0018\u00002\u00020\u0001B\u0085\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\u0012\b\u0002\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000e\u0012\u0012\b\u0002\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000e\u0012\u0012\b\u0002\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0005¢\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010>\u001a\u00020\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u0005HÆ\u0003J\t\u0010@\u001a\u00020\u0005HÆ\u0003J\t\u0010A\u001a\u00020\u0005HÆ\u0003J\t\u0010B\u001a\u00020\u0005HÆ\u0003J\t\u0010C\u001a\u00020\u0005HÆ\u0003J\t\u0010D\u001a\u00020\u0005HÆ\u0003J\t\u0010E\u001a\u00020\u0005HÆ\u0003J\t\u0010F\u001a\u00020\u0005HÆ\u0003J\u0013\u0010G\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000eHÆ\u0003J\u0013\u0010H\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000eHÆ\u0003J\u0013\u0010I\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000eHÆ\u0003J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\t\u0010K\u001a\u00020\u0005HÆ\u0003J\t\u0010L\u001a\u00020\u0005HÆ\u0003J\t\u0010M\u001a\u00020\u0005HÆ\u0003J\t\u0010N\u001a\u00020\u0005HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\u0010\u0010P\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u00107J\t\u0010Q\u001a\u00020\u0005HÆ\u0003J\t\u0010R\u001a\u00020\u0005HÆ\u0003J\t\u0010S\u001a\u00020\u0005HÆ\u0003J\u008c\u0002\u0010T\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\u0012\b\u0002\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000e2\u0012\b\u0002\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000e2\u0012\b\u0002\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u00052\b\b\u0002\u0010\u001b\u001a\u00020\u00052\b\b\u0002\u0010\u001c\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010UJ\u0013\u0010V\u001a\u00020\u00052\b\u0010W\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010X\u001a\u00020\u0003HÖ\u0001J\t\u0010Y\u001a\u00020\u0010HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\"R\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\"R\u0016\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\"R\u0016\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\"R\u0016\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\"R\u0016\u0010\f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\"R \u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R \u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010*R \u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010*R\u0016\u0010\u0012\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010 R\u0016\u0010\u0013\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\"R\u0016\u0010\u0014\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\"R\u0016\u0010\u0015\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\"R\u0016\u0010\u0016\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\"R \u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\"\u0010\u0019\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010:\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0016\u0010\u001a\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\"R\u0016\u0010\u001b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\"R\u0016\u0010\u001c\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010\"¨\u0006Z"}, d2 = {"Lcom/larus/platform/model/ShareConfig;", "", "shareSelectMessageMaxNum", "", "enableMenuMessageShare", "", "enableMessageShareAutoSelect", "enableGenerateTitle", "enableAnswerActionShare", "isAllowSeo", "disableSelectOneRoundMessage", "disableSelectOneSectionMessage", "disableSeoFeature", "enableSelectMessageType", "", "enableSelectBizMessageType", "", "douyinShareHashTags", "selectRefreshRange", "onSaveInstanceStateOptimize", "enableSharePanel", "enableShareMessageImage", "enableShareChatImage", "customSharePanelConfig", "Lcom/larus/platform/model/share/SharePanelConfigs;", "enableShareMessageOneGroupStyle", "enableScreenshotShareMessage", "enableOptImageSave", "enableShareSdkVideo", "<init>", "(IZZZZZZZZLjava/util/List;Ljava/util/List;Ljava/util/List;IZZZZLcom/larus/platform/model/share/SharePanelConfigs;Ljava/lang/Boolean;ZZZ)V", "getShareSelectMessageMaxNum", "()I", "getEnableMenuMessageShare", "()Z", "getEnableMessageShareAutoSelect", "getEnableGenerateTitle", "getEnableAnswerActionShare", "getDisableSelectOneRoundMessage", "getDisableSelectOneSectionMessage", "getDisableSeoFeature", "getEnableSelectMessageType", "()Ljava/util/List;", "getEnableSelectBizMessageType", "getDouyinShareHashTags", "getSelectRefreshRange", "getOnSaveInstanceStateOptimize", "getEnableSharePanel", "getEnableShareMessageImage", "getEnableShareChatImage", "getCustomSharePanelConfig", "()Lcom/larus/platform/model/share/SharePanelConfigs;", "setCustomSharePanelConfig", "(Lcom/larus/platform/model/share/SharePanelConfigs;)V", "getEnableShareMessageOneGroupStyle", "()Ljava/lang/Boolean;", "setEnableShareMessageOneGroupStyle", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getEnableScreenshotShareMessage", "getEnableOptImageSave", "getEnableShareSdkVideo", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "copy", "(IZZZZZZZZLjava/util/List;Ljava/util/List;Ljava/util/List;IZZZZLcom/larus/platform/model/share/SharePanelConfigs;Ljava/lang/Boolean;ZZZ)Lcom/larus/platform/model/ShareConfig;", "equals", "other", "hashCode", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class n4 {

    @SerializedName("custom_share_panel_config")
    private jr9.d customSharePanelConfig;

    @SerializedName("disable_select_one_round_message")
    private final boolean disableSelectOneRoundMessage;

    @SerializedName("disable_select_one_section_message")
    private final boolean disableSelectOneSectionMessage;

    @SerializedName("disable_seo_feature")
    private final boolean disableSeoFeature;

    @SerializedName("douyin_share_hash_tags")
    private final List<String> douyinShareHashTags;

    @SerializedName("enable_answer_action_share")
    private final boolean enableAnswerActionShare;

    @SerializedName("enable_generate_title")
    private final boolean enableGenerateTitle;

    @SerializedName("enable_menu_message_share")
    private final boolean enableMenuMessageShare;

    @SerializedName("enable_message_share_auto_select")
    private final boolean enableMessageShareAutoSelect;

    @SerializedName("enable_opt_image_save")
    private final boolean enableOptImageSave;

    @SerializedName("enable_screenshot_share_message")
    private final boolean enableScreenshotShareMessage;

    @SerializedName("enable_select_message_biz_type")
    private final List<String> enableSelectBizMessageType;

    @SerializedName("enable_select_message_type")
    private final List<Integer> enableSelectMessageType;

    @SerializedName("enable_share_save_chat_image")
    private final boolean enableShareChatImage;

    @SerializedName("enable_share_message_image")
    private final boolean enableShareMessageImage;

    @SerializedName("enable_share_message_one_group_style")
    private Boolean enableShareMessageOneGroupStyle;

    @SerializedName("enable_custom_share_panel")
    private final boolean enableSharePanel;

    @SerializedName("enable_share_sdk_video")
    private final boolean enableShareSdkVideo;

    @SerializedName("is_allow_seo")
    private final boolean isAllowSeo;

    @SerializedName("android_on_save_instance_state_optimize")
    private final boolean onSaveInstanceStateOptimize;

    @SerializedName("android_select_refresh_range")
    private final int selectRefreshRange;

    @SerializedName("share_select_message_max_num")
    private final int shareSelectMessageMaxNum;

    public n4() {
        this(null);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof n4) == true) goto L8;
        return false;
    L8:
        n4 r6 = (n4) r5;
        if (this.shareSelectMessageMaxNum == r6.shareSelectMessageMaxNum) goto L12;
        return false;
    L12:
        if (this.enableMenuMessageShare == r6.enableMenuMessageShare) goto L15;
        return false;
    L15:
        if (this.enableMessageShareAutoSelect == r6.enableMessageShareAutoSelect) goto L18;
        return false;
    L18:
        if (this.enableGenerateTitle == r6.enableGenerateTitle) goto L21;
        return false;
    L21:
        if (this.enableAnswerActionShare == r6.enableAnswerActionShare) goto L24;
        return false;
    L24:
        if (this.isAllowSeo == r6.isAllowSeo) goto L27;
        return false;
    L27:
        if (this.disableSelectOneRoundMessage == r6.disableSelectOneRoundMessage) goto L30;
        return false;
    L30:
        if (this.disableSelectOneSectionMessage == r6.disableSelectOneSectionMessage) goto L33;
        return false;
    L33:
        if (this.disableSeoFeature == r6.disableSeoFeature) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.enableSelectMessageType, r6.enableSelectMessageType) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.enableSelectBizMessageType, r6.enableSelectBizMessageType) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.douyinShareHashTags, r6.douyinShareHashTags) == true) goto L45;
        return false;
    L45:
        if (this.selectRefreshRange == r6.selectRefreshRange) goto L48;
        return false;
    L48:
        if (this.onSaveInstanceStateOptimize == r6.onSaveInstanceStateOptimize) goto L51;
        return false;
    L51:
        if (this.enableSharePanel == r6.enableSharePanel) goto L54;
        return false;
    L54:
        if (this.enableShareMessageImage == r6.enableShareMessageImage) goto L57;
        return false;
    L57:
        if (this.enableShareChatImage == r6.enableShareChatImage) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.customSharePanelConfig, r6.customSharePanelConfig) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.enableShareMessageOneGroupStyle, r6.enableShareMessageOneGroupStyle) == true) goto L66;
        return false;
    L66:
        if (this.enableScreenshotShareMessage == r6.enableScreenshotShareMessage) goto L69;
        return false;
    L69:
        if (this.enableOptImageSave == r6.enableOptImageSave) goto L72;
        return false;
    L72:
        if (this.enableShareSdkVideo == r6.enableShareSdkVideo) goto L74;
        return false;
    L74:
        return true;
    }

    public final int hashCode() {
        int r0 = this.shareSelectMessageMaxNum * 31;
        int r2 = 1231;
        if (this.enableMenuMessageShare == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.enableMessageShareAutoSelect == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (r3 + r4) * 31;
        if (this.enableGenerateTitle == false) goto L13;
        int r6 = 1231;
    L14:
        int r7 = (r5 + r6) * 31;
        if (this.enableAnswerActionShare == false) goto L17;
        int r8 = 1231;
    L18:
        int r9 = (r7 + r8) * 31;
        if (this.isAllowSeo == false) goto L21;
        int r10 = 1231;
    L22:
        int r11 = (r9 + r10) * 31;
        if (this.disableSelectOneRoundMessage == false) goto L25;
        int r12 = 1231;
    L26:
        int r13 = (r11 + r12) * 31;
        if (this.disableSelectOneSectionMessage == false) goto L29;
        int r14 = 1231;
    L30:
        int r15 = (r13 + r14) * 31;
        if (this.disableSeoFeature == false) goto L33;
        int r16 = 1231;
    L34:
        int r17 = (r15 + r16) * 31;
        List<Integer> r18 = this.enableSelectMessageType;
        int r19 = 0;
        if (r18 != null) goto L37;
        int r20 = 0;
    L38:
        int r21 = (r17 + r20) * 31;
        List<String> r22 = this.enableSelectBizMessageType;
        if (r22 != null) goto L41;
        int r23 = 0;
    L42:
        int r24 = (r21 + r23) * 31;
        List<String> r25 = this.douyinShareHashTags;
        if (r25 != null) goto L45;
        int r26 = 0;
    L46:
        int r27 = (((r24 + r26) * 31) + this.selectRefreshRange) * 31;
        if (this.onSaveInstanceStateOptimize == false) goto L49;
        int r28 = 1231;
    L50:
        int r29 = (r27 + r28) * 31;
        if (this.enableSharePanel == false) goto L53;
        int r30 = 1231;
    L54:
        int r31 = (r29 + r30) * 31;
        if (this.enableShareMessageImage == false) goto L57;
        int r32 = 1231;
    L58:
        int r33 = (r31 + r32) * 31;
        if (this.enableShareChatImage == false) goto L61;
        int r34 = 1231;
    L62:
        int r35 = (r33 + r34) * 31;
        jr9.d r36 = this.customSharePanelConfig;
        if (r36 != null) goto L65;
        int r37 = 0;
    L66:
        int r38 = (r35 + r37) * 31;
        Boolean r39 = this.enableShareMessageOneGroupStyle;
        if (r39 == null) goto L70;
        r19 = r39.hashCode();
    L70:
        int r40 = (r38 + r19) * 31;
        if (this.enableScreenshotShareMessage == false) goto L73;
        int r41 = 1231;
    L74:
        int r42 = (r40 + r41) * 31;
        if (this.enableOptImageSave == false) goto L77;
        int r43 = 1231;
    L78:
        int r44 = (r42 + r43) * 31;
        if (this.enableShareSdkVideo == true) goto L83;
        r2 = 1237;
    L83:
        return r44 + r2;
    L77:
        r43 = 1237;
        goto L78
    L73:
        r41 = 1237;
        goto L74
    L65:
        r37 = r36.hashCode();
        goto L66
    L61:
        r34 = 1237;
        goto L62
    L57:
        r32 = 1237;
        goto L58
    L53:
        r30 = 1237;
        goto L54
    L49:
        r28 = 1237;
        goto L50
    L45:
        r26 = r25.hashCode();
        goto L46
    L41:
        r23 = r22.hashCode();
        goto L42
    L37:
        r20 = r18.hashCode();
        goto L38
    L33:
        r16 = 1237;
        goto L34
    L29:
        r14 = 1237;
        goto L30
    L25:
        r12 = 1237;
        goto L26
    L21:
        r10 = 1237;
        goto L22
    L17:
        r8 = 1237;
        goto L18
    L13:
        r6 = 1237;
        goto L14
    L9:
        r4 = 1237;
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "ShareConfig(shareSelectMessageMaxNum=" + this.shareSelectMessageMaxNum + ", enableMenuMessageShare=" + this.enableMenuMessageShare + ", enableMessageShareAutoSelect=" + this.enableMessageShareAutoSelect + ", enableGenerateTitle=" + this.enableGenerateTitle + ", enableAnswerActionShare=" + this.enableAnswerActionShare + ", isAllowSeo=" + this.isAllowSeo + ", disableSelectOneRoundMessage=" + this.disableSelectOneRoundMessage + ", disableSelectOneSectionMessage=" + this.disableSelectOneSectionMessage + ", disableSeoFeature=" + this.disableSeoFeature + ", enableSelectMessageType=" + this.enableSelectMessageType + ", enableSelectBizMessageType=" + this.enableSelectBizMessageType + ", douyinShareHashTags=" + this.douyinShareHashTags + ", selectRefreshRange=" + this.selectRefreshRange + ", onSaveInstanceStateOptimize=" + this.onSaveInstanceStateOptimize + ", enableSharePanel=" + this.enableSharePanel + ", enableShareMessageImage=" + this.enableShareMessageImage + ", enableShareChatImage=" + this.enableShareChatImage + ", customSharePanelConfig=" + this.customSharePanelConfig + ", enableShareMessageOneGroupStyle=" + this.enableShareMessageOneGroupStyle + ", enableScreenshotShareMessage=" + this.enableScreenshotShareMessage + ", enableOptImageSave=" + this.enableOptImageSave + ", enableShareSdkVideo=" + this.enableShareSdkVideo + ')';
    }

    public final jr9.d a() {
        return this.customSharePanelConfig;
    }

    public final boolean b() {
        return this.disableSelectOneRoundMessage;
    }

    public final boolean c() {
        return this.disableSelectOneSectionMessage;
    }

    public final boolean d() {
        return this.disableSeoFeature;
    }

    public final List<String> e() {
        return this.douyinShareHashTags;
    }

    public final boolean f() {
        return this.enableAnswerActionShare;
    }

    public final boolean g() {
        return this.enableGenerateTitle;
    }

    public final boolean h() {
        return this.enableMenuMessageShare;
    }

    public final boolean i() {
        return this.enableMessageShareAutoSelect;
    }

    public final boolean j() {
        return this.enableScreenshotShareMessage;
    }

    public final List<String> k() {
        return this.enableSelectBizMessageType;
    }

    public final List<Integer> l() {
        return this.enableSelectMessageType;
    }

    public final boolean m() {
        return this.enableShareChatImage;
    }

    public final boolean n() {
        return this.enableShareMessageImage;
    }

    public final Boolean o() {
        return this.enableShareMessageOneGroupStyle;
    }

    public final boolean p() {
        return this.enableSharePanel;
    }

    public final boolean q() {
        return this.enableShareSdkVideo;
    }

    public final boolean r() {
        return this.onSaveInstanceStateOptimize;
    }

    public final int s() {
        return this.selectRefreshRange;
    }

    public final int t() {
        return this.shareSelectMessageMaxNum;
    }

    public final boolean u() {
        return this.isAllowSeo;
    }

    public n4(Object r6) {
        ArrayList r7 = new ArrayList();
        ArrayList r0 = new ArrayList();
        ArrayList r1 = new ArrayList();
        Boolean r2 = Boolean.TRUE;
        this.shareSelectMessageMaxNum = 500;
        this.enableMenuMessageShare = true;
        this.enableMessageShareAutoSelect = true;
        this.enableGenerateTitle = true;
        this.enableAnswerActionShare = false;
        this.isAllowSeo = false;
        this.disableSelectOneRoundMessage = true;
        this.disableSelectOneSectionMessage = false;
        this.disableSeoFeature = true;
        this.enableSelectMessageType = r7;
        this.enableSelectBizMessageType = r0;
        this.douyinShareHashTags = r1;
        this.selectRefreshRange = 5;
        this.onSaveInstanceStateOptimize = false;
        this.enableSharePanel = true;
        this.enableShareMessageImage = true;
        this.enableShareChatImage = true;
        this.customSharePanelConfig = null;
        this.enableShareMessageOneGroupStyle = r2;
        this.enableScreenshotShareMessage = false;
        this.enableOptImageSave = false;
        this.enableShareSdkVideo = true;
    }

    public final void v(jr9.d r1) {
        this.customSharePanelConfig = r1;
    }
}
