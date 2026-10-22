package com.bytedance.android.ec.core.cart;

import com.google.gson.annotations.SerializedName;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010$\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\t\u001a\u0004\b\u0015\u0010\u000bR\u001a\u0010\u0016\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\t\u001a\u0004\b\u0017\u0010\u000bR\"\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0019\u0010\u0013R\"\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u001b\u0010\u0013R\"\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0011\u001a\u0004\b\u001d\u0010\u0013R\u001a\u0010\u001e\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\t\u001a\u0004\b\u001f\u0010\u000bR\u001a\u0010 \u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\"\u0010%\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010\u0011\u001a\u0004\b&\u0010\u0013R\"\u0010'\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010\u0011\u001a\u0004\b(\u0010\u0013R\u001a\u0010)\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010\t\u001a\u0004\b*\u0010\u000bR\u001a\u0010+\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010\t\u001a\u0004\b,\u0010\u000bR\u001a\u0010-\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010\t\u001a\u0004\b.\u0010\u000bR\u001a\u0010/\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b/\u0010\t\u001a\u0004\b0\u0010\u000bR\u001a\u00101\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b1\u0010\t\u001a\u0004\b2\u0010\u000bR\u001a\u00103\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b3\u0010\t\u001a\u0004\b4\u0010\u000bR\u001a\u00105\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b5\u0010\t\u001a\u0004\b6\u0010\u000bR\"\u00107\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b7\u0010\u0011\u001a\u0004\b8\u0010\u0013R\u001a\u00109\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b9\u0010!\u001a\u0004\b:\u0010#R&\u0010<\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u000f0;8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u001a\u0010@\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b@\u0010\t\u001a\u0004\bA\u0010\u000b¨\u0006B"}, d2 = {"Lcom/bytedance/android/ec/core/cart/c;", "", "Lcom/bytedance/android/ec/core/cart/d;", "loadMoreInfo", "Lcom/bytedance/android/ec/core/cart/d;", "l", "()Lcom/bytedance/android/ec/core/cart/d;", "", "enableUiAdapt", "Z", "getEnableUiAdapt", "()Z", "bigFontSwitch", "a", "", "", "tabListWidths", "Ljava/util/List;", "n", "()Ljava/util/List;", "enableLynxTypeface", "k", "enableHitSlop", "j", "counterNormalHitSlop", "i", "counterBtnDecreaseHitSlop", "g", "counterBtnIncreaseHitSlop", "h", "clickDebounceSwitch", "f", "clickDebounceDuration", "I", "e", "()I", "", "cartSkipExplicitLoadingTriggerList", "d", "bottomPlaceholderEnableScenes", "b", "enableEmptyAdjust", "getEnableEmptyAdjust", "enableForbiddenDataCompareCopy", "getEnableForbiddenDataCompareCopy", "enableNewPageViewLogic", "getEnableNewPageViewLogic", "enableAlignLoadingOpts", "getEnableAlignLoadingOpts", "enableQuestEventParallelExecute", "getEnableQuestEventParallelExecute", "enableNewEventChainLogic", "getEnableNewEventChainLogic", "disableIncrementalFacade", "getDisableIncrementalFacade", "uplinkCodesNeedReload", "p", "cacheValidDuration", "c", "", "templateList", "Ljava/util/Map;", "o", "()Ljava/util/Map;", "submitShowRadiusSwitch", "m", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("big_font_switch")
    private final boolean bigFontSwitch;

    @SerializedName("bottom_placeholder_enable_scenes")
    private final List<String> bottomPlaceholderEnableScenes;

    @SerializedName("cache_valid_timestamp")
    private final int cacheValidDuration;

    @SerializedName("cartSkipExplicitLoadingTriggerList")
    private final List<String> cartSkipExplicitLoadingTriggerList;

    @SerializedName("click_debounce_duration")
    private final int clickDebounceDuration;

    @SerializedName("click_debounce_switch")
    private final boolean clickDebounceSwitch;

    @SerializedName("counter_btn_decrease_hit_slop")
    private final List<Integer> counterBtnDecreaseHitSlop;

    @SerializedName("counter_btn_increase_hit_slop")
    private final List<Integer> counterBtnIncreaseHitSlop;

    @SerializedName("counter_normal_hit_slop")
    private final List<Integer> counterNormalHitSlop;

    @SerializedName("disable_incremental_facade")
    private final boolean disableIncrementalFacade;

    @SerializedName("enableAlignLoadingOpts")
    private final boolean enableAlignLoadingOpts;

    @SerializedName("enableEmptyAdjust")
    private final boolean enableEmptyAdjust;

    @SerializedName("enableForbiddenDataCompareCopy")
    private final boolean enableForbiddenDataCompareCopy;

    @SerializedName("enable_hit_slop")
    private final boolean enableHitSlop;

    @SerializedName("enable_lynx_typeface")
    private final boolean enableLynxTypeface;

    @SerializedName("enableNewEventChainLogic")
    private final boolean enableNewEventChainLogic;

    @SerializedName("enableNewPageViewLogic")
    private final boolean enableNewPageViewLogic;

    @SerializedName("enableQuestEventParallelExecute")
    private final boolean enableQuestEventParallelExecute;

    @SerializedName("enable_ui_adapt")
    private final boolean enableUiAdapt;

    @SerializedName("load_more")
    private final d loadMoreInfo;

    @SerializedName("submit_show_radius_switch")
    private final boolean submitShowRadiusSwitch;

    @SerializedName("tab_list_widths")
    private final List<Integer> tabListWidths;

    @SerializedName("cart_slice_templates")
    private final Map<String, Integer> templateList;

    @SerializedName("uplink_codes_need_reload")
    private final List<Integer> uplinkCodesNeedReload;

    public c() {
        this(null);
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof c) == false) goto L54;
        c r11 = (c) r10;
        if (Intrinsics.areEqual(this.loadMoreInfo, r11.loadMoreInfo) == true) goto L8;
        return false;
    L8:
        if (this.enableUiAdapt == r11.enableUiAdapt) goto L10;
        return false;
    L10:
        if (this.bigFontSwitch == r11.bigFontSwitch) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.tabListWidths, r11.tabListWidths) == true) goto L14;
        return false;
    L14:
        if (this.enableLynxTypeface == r11.enableLynxTypeface) goto L16;
        return false;
    L16:
        if (this.enableHitSlop == r11.enableHitSlop) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.counterNormalHitSlop, r11.counterNormalHitSlop) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.counterBtnDecreaseHitSlop, r11.counterBtnDecreaseHitSlop) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.counterBtnIncreaseHitSlop, r11.counterBtnIncreaseHitSlop) == true) goto L24;
        return false;
    L24:
        if (this.clickDebounceSwitch == r11.clickDebounceSwitch) goto L26;
        return false;
    L26:
        if (this.clickDebounceDuration == r11.clickDebounceDuration) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.cartSkipExplicitLoadingTriggerList, r11.cartSkipExplicitLoadingTriggerList) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.bottomPlaceholderEnableScenes, r11.bottomPlaceholderEnableScenes) == true) goto L32;
        return false;
    L32:
        if (this.enableEmptyAdjust == r11.enableEmptyAdjust) goto L34;
        return false;
    L34:
        if (this.enableForbiddenDataCompareCopy == r11.enableForbiddenDataCompareCopy) goto L36;
        return false;
    L36:
        if (this.enableNewPageViewLogic == r11.enableNewPageViewLogic) goto L38;
        return false;
    L38:
        if (this.enableAlignLoadingOpts == r11.enableAlignLoadingOpts) goto L40;
        return false;
    L40:
        if (this.enableQuestEventParallelExecute == r11.enableQuestEventParallelExecute) goto L42;
        return false;
    L42:
        if (this.enableNewEventChainLogic == r11.enableNewEventChainLogic) goto L44;
        return false;
    L44:
        if (this.disableIncrementalFacade == r11.disableIncrementalFacade) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.uplinkCodesNeedReload, r11.uplinkCodesNeedReload) == true) goto L48;
        return false;
    L48:
        if (this.cacheValidDuration == r11.cacheValidDuration) goto L50;
        return false;
    L50:
        if (Intrinsics.areEqual(this.templateList, r11.templateList) == true) goto L52;
        return false;
    L52:
        if (this.submitShowRadiusSwitch == r11.submitShowRadiusSwitch) goto L82;
        return false;
    L82:
        return true;
    L54:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v48, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v21, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v30, types: [int] */
    /* JADX WARN: Type inference failed for: r2v32, types: [int] */
    /* JADX WARN: Type inference failed for: r2v34, types: [int] */
    /* JADX WARN: Type inference failed for: r2v36, types: [int] */
    /* JADX WARN: Type inference failed for: r2v38, types: [int] */
    /* JADX WARN: Type inference failed for: r2v40, types: [int] */
    /* JADX WARN: Type inference failed for: r2v42, types: [int] */
    /* JADX WARN: Type inference failed for: r2v49 */
    /* JADX WARN: Type inference failed for: r2v50 */
    /* JADX WARN: Type inference failed for: r2v51 */
    /* JADX WARN: Type inference failed for: r2v52 */
    /* JADX WARN: Type inference failed for: r2v53 */
    /* JADX WARN: Type inference failed for: r2v54 */
    /* JADX WARN: Type inference failed for: r2v55 */
    /* JADX WARN: Type inference failed for: r2v58 */
    /* JADX WARN: Type inference failed for: r2v62 */
    /* JADX WARN: Type inference failed for: r2v63 */
    /* JADX WARN: Type inference failed for: r2v65 */
    /* JADX WARN: Type inference failed for: r2v66 */
    /* JADX WARN: Type inference failed for: r2v67 */
    /* JADX WARN: Type inference failed for: r2v68 */
    /* JADX WARN: Type inference failed for: r2v69 */
    /* JADX WARN: Type inference failed for: r2v70 */
    /* JADX WARN: Type inference failed for: r2v71 */
    /* JADX WARN: Type inference failed for: r2v72 */
    /* JADX WARN: Type inference failed for: r2v73 */
    /* JADX WARN: Type inference failed for: r2v74 */
    /* JADX WARN: Type inference failed for: r2v75 */
    /* JADX WARN: Type inference failed for: r2v76 */
    /* JADX WARN: Type inference failed for: r2v77 */
    /* JADX WARN: Type inference failed for: r2v78 */
    /* JADX WARN: Type inference failed for: r2v8, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        d r0 = this.loadMoreInfo;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r10 = r0.hashCode();
    L6:
        int r11 = r10 * 31;
        boolean r12 = this.enableUiAdapt;
        ?? r13 = 1;
        ?? r14 = r12;
        if (r12 == false) goto L9;
        r14 = 1;
    L9:
        int r15 = (r11 + r14) * 31;
        boolean r16 = this.bigFontSwitch;
        ?? r17 = r16;
        if (r16 == false) goto L12;
        r17 = 1;
    L12:
        int r18 = (r15 + r17) * 31;
        List<Integer> r19 = this.tabListWidths;
        if (r19 == null) goto L15;
        int r20 = r19.hashCode();
    L16:
        int r21 = (r18 + r20) * 31;
        boolean r22 = this.enableLynxTypeface;
        ?? r23 = r22;
        if (r22 == false) goto L19;
        r23 = 1;
    L19:
        int r24 = (r21 + r23) * 31;
        boolean r25 = this.enableHitSlop;
        ?? r26 = r25;
        if (r25 == false) goto L22;
        r26 = 1;
    L22:
        int r27 = (r24 + r26) * 31;
        List<Integer> r28 = this.counterNormalHitSlop;
        if (r28 == null) goto L25;
        int r29 = r28.hashCode();
    L26:
        int r30 = (r27 + r29) * 31;
        List<Integer> r31 = this.counterBtnDecreaseHitSlop;
        if (r31 == null) goto L29;
        int r32 = r31.hashCode();
    L30:
        int r33 = (r30 + r32) * 31;
        List<Integer> r34 = this.counterBtnIncreaseHitSlop;
        if (r34 == null) goto L33;
        int r35 = r34.hashCode();
    L34:
        int r36 = (r33 + r35) * 31;
        boolean r37 = this.clickDebounceSwitch;
        ?? r38 = r37;
        if (r37 == false) goto L37;
        r38 = 1;
    L37:
        int r39 = (((r36 + r38) * 31) + this.clickDebounceDuration) * 31;
        List<String> r40 = this.cartSkipExplicitLoadingTriggerList;
        if (r40 == null) goto L40;
        int r41 = r40.hashCode();
    L41:
        int r42 = (r39 + r41) * 31;
        List<String> r43 = this.bottomPlaceholderEnableScenes;
        if (r43 == null) goto L44;
        int r44 = r43.hashCode();
    L45:
        int r45 = (r42 + r44) * 31;
        boolean r46 = this.enableEmptyAdjust;
        ?? r47 = r46;
        if (r46 == false) goto L48;
        r47 = 1;
    L48:
        int r48 = (r45 + r47) * 31;
        boolean r49 = this.enableForbiddenDataCompareCopy;
        ?? r50 = r49;
        if (r49 == false) goto L51;
        r50 = 1;
    L51:
        int r51 = (r48 + r50) * 31;
        boolean r52 = this.enableNewPageViewLogic;
        ?? r53 = r52;
        if (r52 == false) goto L54;
        r53 = 1;
    L54:
        int r54 = (r51 + r53) * 31;
        boolean r55 = this.enableAlignLoadingOpts;
        ?? r56 = r55;
        if (r55 == false) goto L57;
        r56 = 1;
    L57:
        int r57 = (r54 + r56) * 31;
        boolean r58 = this.enableQuestEventParallelExecute;
        ?? r59 = r58;
        if (r58 == false) goto L60;
        r59 = 1;
    L60:
        int r60 = (r57 + r59) * 31;
        boolean r61 = this.enableNewEventChainLogic;
        ?? r62 = r61;
        if (r61 == false) goto L63;
        r62 = 1;
    L63:
        int r63 = (r60 + r62) * 31;
        boolean r64 = this.disableIncrementalFacade;
        ?? r65 = r64;
        if (r64 == false) goto L66;
        r65 = 1;
    L66:
        int r66 = (r63 + r65) * 31;
        List<Integer> r67 = this.uplinkCodesNeedReload;
        if (r67 == null) goto L69;
        int r68 = r67.hashCode();
    L70:
        int r69 = (((r66 + r68) * 31) + this.cacheValidDuration) * 31;
        Map<String, Integer> r70 = this.templateList;
        if (r70 == null) goto L73;
        r1 = r70.hashCode();
    L73:
        int r71 = (r69 + r1) * 31;
        boolean r72 = this.submitShowRadiusSwitch;
        if (r72 == true) goto L78;
        r13 = r72;
    L78:
        return r71 + r13;
    L69:
        r68 = 0;
        goto L70
    L44:
        r44 = 0;
        goto L45
    L40:
        r41 = 0;
        goto L41
    L33:
        r35 = 0;
        goto L34
    L29:
        r32 = 0;
        goto L30
    L25:
        r29 = 0;
        goto L26
    L15:
        r20 = 0;
        goto L16
    L5:
        r10 = 0;
        goto L6
    }

    public final String toString() {
        return "CartSettingConfig(loadMoreInfo=" + this.loadMoreInfo + ", enableUiAdapt=" + this.enableUiAdapt + ", bigFontSwitch=" + this.bigFontSwitch + ", tabListWidths=" + this.tabListWidths + ", enableLynxTypeface=" + this.enableLynxTypeface + ", enableHitSlop=" + this.enableHitSlop + ", counterNormalHitSlop=" + this.counterNormalHitSlop + ", counterBtnDecreaseHitSlop=" + this.counterBtnDecreaseHitSlop + ", counterBtnIncreaseHitSlop=" + this.counterBtnIncreaseHitSlop + ", clickDebounceSwitch=" + this.clickDebounceSwitch + ", clickDebounceDuration=" + this.clickDebounceDuration + ", cartSkipExplicitLoadingTriggerList=" + this.cartSkipExplicitLoadingTriggerList + ", bottomPlaceholderEnableScenes=" + this.bottomPlaceholderEnableScenes + ", enableEmptyAdjust=" + this.enableEmptyAdjust + ", enableForbiddenDataCompareCopy=" + this.enableForbiddenDataCompareCopy + ", enableNewPageViewLogic=" + this.enableNewPageViewLogic + ", enableAlignLoadingOpts=" + this.enableAlignLoadingOpts + ", enableQuestEventParallelExecute=" + this.enableQuestEventParallelExecute + ", enableNewEventChainLogic=" + this.enableNewEventChainLogic + ", disableIncrementalFacade=" + this.disableIncrementalFacade + ", uplinkCodesNeedReload=" + this.uplinkCodesNeedReload + ", cacheValidDuration=" + this.cacheValidDuration + ", templateList=" + this.templateList + ", submitShowRadiusSwitch=" + this.submitShowRadiusSwitch + ")";
    }

    public final boolean a() {
        return this.bigFontSwitch;
    }

    public final List<String> b() {
        return this.bottomPlaceholderEnableScenes;
    }

    public final int c() {
        return this.cacheValidDuration;
    }

    public final List<String> d() {
        return this.cartSkipExplicitLoadingTriggerList;
    }

    public final int e() {
        return this.clickDebounceDuration;
    }

    public final boolean f() {
        return this.clickDebounceSwitch;
    }

    public final List<Integer> g() {
        return this.counterBtnDecreaseHitSlop;
    }

    public final List<Integer> h() {
        return this.counterBtnIncreaseHitSlop;
    }

    public final List<Integer> i() {
        return this.counterNormalHitSlop;
    }

    public final boolean j() {
        return this.enableHitSlop;
    }

    public final boolean k() {
        return this.enableLynxTypeface;
    }

    public final d l() {
        return this.loadMoreInfo;
    }

    public final boolean m() {
        return this.submitShowRadiusSwitch;
    }

    public final List<Integer> n() {
        return this.tabListWidths;
    }

    public final Map<String, Integer> o() {
        return this.templateList;
    }

    public final List<Integer> p() {
        return this.uplinkCodesNeedReload;
    }

    public c(Object r12) {
        d r13 = new d(null);
        List<Integer> r10 = CollectionsKt.listOf(new Integer[]{12, 12, 12, 12});
        List<Integer> r11 = CollectionsKt.listOf(new Integer[]{12, 12, 0, 12});
        List<Integer> r1 = CollectionsKt.listOf(new Integer[]{0, 12, 12, 12});
        List<String> r14 = CollectionsKt.emptyList();
        List<String> r15 = CollectionsKt.emptyList();
        LinkedHashMap r16 = new LinkedHashMap();
        r16.put("cart_header_card", 1);
        r16.put("submit", 1);
        r16.put("shop_header", 5);
        r16.put("product_card", 7);
        r16.put("shop_activity_card", 1);
        Map<String, Integer> r17 = MapsKt.toMap(r16);
        Intrinsics.checkNotNullParameter(r17, "templateList");
        this.loadMoreInfo = r13;
        this.enableUiAdapt = true;
        this.bigFontSwitch = true;
        this.tabListWidths = null;
        this.enableLynxTypeface = true;
        this.enableHitSlop = true;
        this.counterNormalHitSlop = r10;
        this.counterBtnDecreaseHitSlop = r11;
        this.counterBtnIncreaseHitSlop = r1;
        this.clickDebounceSwitch = false;
        this.clickDebounceDuration = 350;
        this.cartSkipExplicitLoadingTriggerList = r14;
        this.bottomPlaceholderEnableScenes = r15;
        this.enableEmptyAdjust = true;
        this.enableForbiddenDataCompareCopy = true;
        this.enableNewPageViewLogic = true;
        this.enableAlignLoadingOpts = true;
        this.enableQuestEventParallelExecute = true;
        this.enableNewEventChainLogic = false;
        this.disableIncrementalFacade = false;
        this.uplinkCodesNeedReload = null;
        this.cacheValidDuration = 0;
        this.templateList = r17;
        this.submitShowRadiusSwitch = false;
    }
}
