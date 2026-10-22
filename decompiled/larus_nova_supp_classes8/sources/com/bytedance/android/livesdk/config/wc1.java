package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u001f\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0011\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0017\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\u001a\u0010\u0019\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006R\u001a\u0010\u001b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006R\u001a\u0010\u001d\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006R\u001a\u0010\u001f\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u0012\u001a\u0004\b \u0010\u0014R\u001a\u0010!\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006R\u001a\u0010#\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010\u0004\u001a\u0004\b$\u0010\u0006R\u001a\u0010%\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010\u0012\u001a\u0004\b&\u0010\u0014R\u001a\u0010'\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010\u0012\u001a\u0004\b(\u0010\u0014R\u001a\u0010)\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010\u0012\u001a\u0004\b*\u0010\u0014R\u001a\u0010+\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010\u0012\u001a\u0004\b,\u0010\u0014R\u001a\u0010-\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010\u0012\u001a\u0004\b.\u0010\u0014¨\u0006/"}, d2 = {"Lcom/bytedance/android/livesdk/config/wc1;", "", "", "componentInitOpt", "I", "b", "()I", "", "cardAnimDowngradeLowDevice", "F", "a", "()F", "spreadFlowersAnimDowngradeLowDevice", "r", "smallCardAnimDowngradeLowDevice", "p", "", "preloadShelfInfo", "Z", "o", "()Z", "incComponentPriority", "n", "enableToolbarPostOpt", "m", "enableBackendPostOpt", "c", "enablePreloadImage", "k", "enableNewSmallCardUrl", "i", "enableNewSmallCardUrlOnlyOnEnter", "j", "smallCardAnimTimeoutDuration", "q", "enablePreloadImageV2", "l", "enableExplainCardDecouplingOpt", "e", "enableExplainCardAnimDecouplingOpt", "d", "enableExplainCardRemovePostOpt", "g", "enableExplainCardLayoutPreloadOpt", "f", "enableNewExplainCardAnim", "h", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class wc1 {

    @SerializedName("card_anim_downgrade_android_low_device")
    private final float cardAnimDowngradeLowDevice;

    @SerializedName("component_init_opt")
    private final int componentInitOpt;

    @SerializedName("enable_backend_post_opt")
    private final int enableBackendPostOpt;

    @SerializedName("enable_explain_card_anim_decoupling_opt")
    private final boolean enableExplainCardAnimDecouplingOpt;

    @SerializedName("enable_explain_card_decoupling_opt")
    private final boolean enableExplainCardDecouplingOpt;

    @SerializedName("enable_explain_card_layout_preload_opt")
    private final boolean enableExplainCardLayoutPreloadOpt;

    @SerializedName("enable_explain_card_remove_post_opt")
    private final boolean enableExplainCardRemovePostOpt;

    @SerializedName("enable_new_explain_card_anim")
    private final boolean enableNewExplainCardAnim;

    @SerializedName("enable_new_small_card_url")
    private final int enableNewSmallCardUrl;

    @SerializedName("enable_new_small_card_url_only_on_enter")
    private final boolean enableNewSmallCardUrlOnlyOnEnter;

    @SerializedName("enable_preload_image")
    private final int enablePreloadImage;

    @SerializedName("enable_preload_image_v2")
    private final int enablePreloadImageV2;

    @SerializedName("enable_toolbar_post_opt")
    private final int enableToolbarPostOpt;

    @SerializedName("live_mini_app_inc_component_priority")
    private final boolean incComponentPriority;

    @SerializedName("live_mini_app_preload_shelf_info")
    private final boolean preloadShelfInfo;

    @SerializedName("small_card_anim_downgrade_android_low_device")
    private final float smallCardAnimDowngradeLowDevice;

    @SerializedName("small_card_anim_timeout_duration")
    private final int smallCardAnimTimeoutDuration;

    @SerializedName("spread_flowers_anim_downgrade_android_low_device")
    private final float spreadFlowersAnimDowngradeLowDevice;

    public wc1() {
        this(0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof wc1) == false) goto L42;
        wc1 r4 = (wc1) r3;
        if (this.componentInitOpt == r4.componentInitOpt) goto L8;
        return false;
    L8:
        if (Float.compare(this.cardAnimDowngradeLowDevice, r4.cardAnimDowngradeLowDevice) == 0) goto L10;
        return false;
    L10:
        if (Float.compare(this.spreadFlowersAnimDowngradeLowDevice, r4.spreadFlowersAnimDowngradeLowDevice) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.smallCardAnimDowngradeLowDevice, r4.smallCardAnimDowngradeLowDevice) == 0) goto L14;
        return false;
    L14:
        if (this.preloadShelfInfo == r4.preloadShelfInfo) goto L16;
        return false;
    L16:
        if (this.incComponentPriority == r4.incComponentPriority) goto L18;
        return false;
    L18:
        if (this.enableToolbarPostOpt == r4.enableToolbarPostOpt) goto L20;
        return false;
    L20:
        if (this.enableBackendPostOpt == r4.enableBackendPostOpt) goto L22;
        return false;
    L22:
        if (this.enablePreloadImage == r4.enablePreloadImage) goto L24;
        return false;
    L24:
        if (this.enableNewSmallCardUrl == r4.enableNewSmallCardUrl) goto L26;
        return false;
    L26:
        if (this.enableNewSmallCardUrlOnlyOnEnter == r4.enableNewSmallCardUrlOnlyOnEnter) goto L28;
        return false;
    L28:
        if (this.smallCardAnimTimeoutDuration == r4.smallCardAnimTimeoutDuration) goto L30;
        return false;
    L30:
        if (this.enablePreloadImageV2 == r4.enablePreloadImageV2) goto L32;
        return false;
    L32:
        if (this.enableExplainCardDecouplingOpt == r4.enableExplainCardDecouplingOpt) goto L34;
        return false;
    L34:
        if (this.enableExplainCardAnimDecouplingOpt == r4.enableExplainCardAnimDecouplingOpt) goto L36;
        return false;
    L36:
        if (this.enableExplainCardRemovePostOpt == r4.enableExplainCardRemovePostOpt) goto L38;
        return false;
    L38:
        if (this.enableExplainCardLayoutPreloadOpt == r4.enableExplainCardLayoutPreloadOpt) goto L40;
        return false;
    L40:
        if (this.enableNewExplainCardAnim == r4.enableNewExplainCardAnim) goto L64;
        return false;
    L64:
        return true;
    L42:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v20, types: [int] */
    /* JADX WARN: Type inference failed for: r0v26, types: [int] */
    /* JADX WARN: Type inference failed for: r0v28, types: [int] */
    /* JADX WARN: Type inference failed for: r0v30, types: [int] */
    /* JADX WARN: Type inference failed for: r0v32, types: [int] */
    /* JADX WARN: Type inference failed for: r0v34, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v15, types: [int] */
    /* JADX WARN: Type inference failed for: r1v19, types: [int] */
    /* JADX WARN: Type inference failed for: r1v21, types: [int] */
    /* JADX WARN: Type inference failed for: r1v23, types: [int] */
    /* JADX WARN: Type inference failed for: r1v25, types: [int] */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v36 */
    /* JADX WARN: Type inference failed for: r1v37 */
    /* JADX WARN: Type inference failed for: r1v38 */
    /* JADX WARN: Type inference failed for: r1v39 */
    /* JADX WARN: Type inference failed for: r1v40 */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public final int hashCode() {
        int r0 = ((((((this.componentInitOpt * 31) + Float.floatToIntBits(this.cardAnimDowngradeLowDevice)) * 31) + Float.floatToIntBits(this.spreadFlowersAnimDowngradeLowDevice)) * 31) + Float.floatToIntBits(this.smallCardAnimDowngradeLowDevice)) * 31;
        boolean r1 = this.preloadShelfInfo;
        ?? r2 = 1;
        ?? r3 = r1;
        if (r1 == false) goto L5;
        r3 = 1;
    L5:
        int r4 = (r0 + r3) * 31;
        boolean r5 = this.incComponentPriority;
        ?? r6 = r5;
        if (r5 == false) goto L8;
        r6 = 1;
    L8:
        int r7 = (((((((((r4 + r6) * 31) + this.enableToolbarPostOpt) * 31) + this.enableBackendPostOpt) * 31) + this.enablePreloadImage) * 31) + this.enableNewSmallCardUrl) * 31;
        boolean r8 = this.enableNewSmallCardUrlOnlyOnEnter;
        ?? r9 = r8;
        if (r8 == false) goto L11;
        r9 = 1;
    L11:
        int r10 = (((((r7 + r9) * 31) + this.smallCardAnimTimeoutDuration) * 31) + this.enablePreloadImageV2) * 31;
        boolean r11 = this.enableExplainCardDecouplingOpt;
        ?? r12 = r11;
        if (r11 == false) goto L14;
        r12 = 1;
    L14:
        int r13 = (r10 + r12) * 31;
        boolean r14 = this.enableExplainCardAnimDecouplingOpt;
        ?? r15 = r14;
        if (r14 == false) goto L17;
        r15 = 1;
    L17:
        int r16 = (r13 + r15) * 31;
        boolean r17 = this.enableExplainCardRemovePostOpt;
        ?? r18 = r17;
        if (r17 == false) goto L20;
        r18 = 1;
    L20:
        int r19 = (r16 + r18) * 31;
        boolean r20 = this.enableExplainCardLayoutPreloadOpt;
        ?? r21 = r20;
        if (r20 == false) goto L23;
        r21 = 1;
    L23:
        int r22 = (r19 + r21) * 31;
        boolean r23 = this.enableNewExplainCardAnim;
        if (r23 == true) goto L28;
        r2 = r23;
    L28:
        return r22 + r2;
    }

    public final String toString() {
        return "OpenPlatformMicroAppPerfConfig(componentInitOpt=" + this.componentInitOpt + ", cardAnimDowngradeLowDevice=" + this.cardAnimDowngradeLowDevice + ", spreadFlowersAnimDowngradeLowDevice=" + this.spreadFlowersAnimDowngradeLowDevice + ", smallCardAnimDowngradeLowDevice=" + this.smallCardAnimDowngradeLowDevice + ", preloadShelfInfo=" + this.preloadShelfInfo + ", incComponentPriority=" + this.incComponentPriority + ", enableToolbarPostOpt=" + this.enableToolbarPostOpt + ", enableBackendPostOpt=" + this.enableBackendPostOpt + ", enablePreloadImage=" + this.enablePreloadImage + ", enableNewSmallCardUrl=" + this.enableNewSmallCardUrl + ", enableNewSmallCardUrlOnlyOnEnter=" + this.enableNewSmallCardUrlOnlyOnEnter + ", smallCardAnimTimeoutDuration=" + this.smallCardAnimTimeoutDuration + ", enablePreloadImageV2=" + this.enablePreloadImageV2 + ", enableExplainCardDecouplingOpt=" + this.enableExplainCardDecouplingOpt + ", enableExplainCardAnimDecouplingOpt=" + this.enableExplainCardAnimDecouplingOpt + ", enableExplainCardRemovePostOpt=" + this.enableExplainCardRemovePostOpt + ", enableExplainCardLayoutPreloadOpt=" + this.enableExplainCardLayoutPreloadOpt + ", enableNewExplainCardAnim=" + this.enableNewExplainCardAnim + ")";
    }

    public final float a() {
        return this.cardAnimDowngradeLowDevice;
    }

    public final int b() {
        return this.componentInitOpt;
    }

    public final int c() {
        return this.enableBackendPostOpt;
    }

    public final boolean d() {
        return this.enableExplainCardAnimDecouplingOpt;
    }

    public final boolean e() {
        return this.enableExplainCardDecouplingOpt;
    }

    public final boolean f() {
        return this.enableExplainCardLayoutPreloadOpt;
    }

    public final boolean g() {
        return this.enableExplainCardRemovePostOpt;
    }

    public final boolean h() {
        return this.enableNewExplainCardAnim;
    }

    public final int i() {
        return this.enableNewSmallCardUrl;
    }

    public final boolean j() {
        return this.enableNewSmallCardUrlOnlyOnEnter;
    }

    public final int k() {
        return this.enablePreloadImage;
    }

    public final int l() {
        return this.enablePreloadImageV2;
    }

    public final int m() {
        return this.enableToolbarPostOpt;
    }

    public final boolean n() {
        return this.incComponentPriority;
    }

    public final boolean o() {
        return this.preloadShelfInfo;
    }

    public final float p() {
        return this.smallCardAnimDowngradeLowDevice;
    }

    public final int q() {
        return this.smallCardAnimTimeoutDuration;
    }

    public final float r() {
        return this.spreadFlowersAnimDowngradeLowDevice;
    }

    public wc1(int r2) {
        this.componentInitOpt = 0;
        this.cardAnimDowngradeLowDevice = 0.0f;
        this.spreadFlowersAnimDowngradeLowDevice = 0.0f;
        this.smallCardAnimDowngradeLowDevice = 0.0f;
        this.preloadShelfInfo = false;
        this.incComponentPriority = false;
        this.enableToolbarPostOpt = 0;
        this.enableBackendPostOpt = 0;
        this.enablePreloadImage = 0;
        this.enableNewSmallCardUrl = 0;
        this.enableNewSmallCardUrlOnlyOnEnter = false;
        this.smallCardAnimTimeoutDuration = 0;
        this.enablePreloadImageV2 = 0;
        this.enableExplainCardDecouplingOpt = false;
        this.enableExplainCardAnimDecouplingOpt = false;
        this.enableExplainCardRemovePostOpt = false;
        this.enableExplainCardLayoutPreloadOpt = false;
        this.enableNewExplainCardAnim = false;
    }
}
