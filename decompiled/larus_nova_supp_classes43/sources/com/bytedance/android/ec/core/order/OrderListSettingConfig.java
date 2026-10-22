package com.bytedance.android.ec.core.order;

import com.bytedance.android.ec.core.utils.FontWeight;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0002\b\u001e\b\u0086\b\u0018\u0000 C2\u00020\u0001:\u0001DB\u009d\u0001\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001a\u001a\u00020\t\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0006\u0012\b\b\u0002\u0010 \u001a\u00020\u000e\u0012\b\b\u0002\u0010!\u001a\u00020\u0006\u0012\b\b\u0002\u0010\"\u001a\u00020\u0006\u0012\b\b\u0002\u0010#\u001a\u00020\u0006¢\u0006\u0004\bA\u0010BJ\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0007\u001a\u00020\u0006HÆ\u0003J\t\u0010\b\u001a\u00020\u0006HÆ\u0003J\t\u0010\n\u001a\u00020\tHÆ\u0003J\t\u0010\u000b\u001a\u00020\u0006HÆ\u0003J\t\u0010\f\u001a\u00020\u0006HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J\t\u0010\u000f\u001a\u00020\u000eHÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0011\u001a\u00020\u000eHÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\u009f\u0001\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u00062\b\b\u0002\u0010\u001a\u001a\u00020\t2\b\b\u0002\u0010\u001b\u001a\u00020\u00062\b\b\u0002\u0010\u001c\u001a\u00020\u00062\b\b\u0002\u0010\u001d\u001a\u00020\u00062\b\b\u0002\u0010\u001e\u001a\u00020\u000e2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010 \u001a\u00020\u000e2\b\b\u0002\u0010!\u001a\u00020\u00062\b\b\u0002\u0010\"\u001a\u00020\u00062\b\b\u0002\u0010#\u001a\u00020\u0006HÆ\u0001J\t\u0010%\u001a\u00020\u0002HÖ\u0001J\t\u0010&\u001a\u00020\tHÖ\u0001J\u0013\u0010)\u001a\u00020\u00062\b\u0010(\u001a\u0004\u0018\u00010'HÖ\u0003R\u001a\u0010\u0015\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010*\u001a\u0004\b+\u0010,R\u001a\u0010\u0016\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010*\u001a\u0004\b-\u0010,R\u001a\u0010\u0017\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010*\u001a\u0004\b.\u0010,R\u001a\u0010\u0018\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010/\u001a\u0004\b0\u00101R\u001a\u0010\u0019\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010/\u001a\u0004\b2\u00101R\u001a\u0010\u001a\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u00103\u001a\u0004\b4\u00105R\u001a\u0010\u001b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010/\u001a\u0004\b6\u00101R\u001a\u0010\u001c\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010/\u001a\u0004\b7\u00101R\u001a\u0010\u001d\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010/\u001a\u0004\b8\u00101R\u001a\u0010\u001e\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u00109\u001a\u0004\b:\u0010;R\u001a\u0010\u001f\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010/\u001a\u0004\b<\u00101R\u001a\u0010 \u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u00109\u001a\u0004\b=\u0010;R\u001a\u0010!\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010/\u001a\u0004\b>\u00101R\u001a\u0010\"\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010/\u001a\u0004\b?\u00101R\u001a\u0010#\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010/\u001a\u0004\b@\u00101¨\u0006E"}, d2 = {"Lcom/bytedance/android/ec/core/order/OrderListSettingConfig;", "Ljava/io/Serializable;", "", "component1", "component2", "component3", "", "component4", "component5", "", "component6", "component7", "component8", "component9", "", "component10", "component11", "component12", "component13", "component14", "component15", "orderListGULUrl", "orderSearchGULUrl", "lynxBridgeUrl", "bigFontSwitch", "clickDebounceSwitch", "clickDebounceDuration", "enableNewEventChainLogic", "disableIncrementalFacade", "enableFirstEnterQuickDispatch", "yataRenderMaxDuration", "optCartTrack", "hideSkeletonDelayDuration", "enableContainerClipChildren", "drawableResetPreFetch", "enableOverflowClick", "copy", "toString", "hashCode", "", "other", "equals", "Ljava/lang/String;", "getOrderListGULUrl", "()Ljava/lang/String;", "getOrderSearchGULUrl", "getLynxBridgeUrl", "Z", "getBigFontSwitch", "()Z", "getClickDebounceSwitch", "I", "getClickDebounceDuration", "()I", "getEnableNewEventChainLogic", "getDisableIncrementalFacade", "getEnableFirstEnterQuickDispatch", "J", "getYataRenderMaxDuration", "()J", "getOptCartTrack", "getHideSkeletonDelayDuration", "getEnableContainerClipChildren", "getDrawableResetPreFetch", "getEnableOverflowClick", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZIZZZJZJZZZ)V", "Companion", "a", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OrderListSettingConfig implements Serializable {
    public static final a Companion = null;
    public static final String ORDER_SEARCH_RESULT_GUL_URL = "sslocal://webcast_webview?type=fullscreen&url=https%3A%2F%2Fffh.jinritemai.com%2Fforest%2Frender%2Ffe%2Ftemplate%2Fchannel%2Fecommerce_orders_yata%2Fhtml%2Fsearch_gyl.html%3F__pia_manifest__%3D%257B%2522page_name%2522%253A%2522search_gyl%2522%252C%2522public_path%2522%253A%2522https%253A%252F%252Flf-webcast-sourcecdn-tos.bytegecko.com%252Fobj%252Fbyte-gurd-source%252F10181%252Fgecko%252Fresource%252Fecommerce_orders_yata%252F%2522%257D&disable_host_jsb_method=1&disable_thread_spread=1&warmup_pia_worker=1&loader_name=forest&hide_nav_bar=1&status_bar_color=black&trans_status_bar=1&web_bg_color=%23FFFFFF&disable_input_scroll=1&use_pia=1&use_wk_falcon=1";

    @SerializedName("big_font_switch")
    private final boolean bigFontSwitch;

    @SerializedName("click_debounce_duration")
    private final int clickDebounceDuration;

    @SerializedName("click_debounce_switch")
    private final boolean clickDebounceSwitch;

    @SerializedName("disable_incremental_facade")
    private final boolean disableIncrementalFacade;

    @SerializedName("drawable_reset_pre_fetch")
    private final boolean drawableResetPreFetch;

    @SerializedName("enable_container_clip_children")
    private final boolean enableContainerClipChildren;

    @SerializedName("enable_first_enter_quick_dispatch")
    private final boolean enableFirstEnterQuickDispatch;

    @SerializedName("enableNewEventChainLogic")
    private final boolean enableNewEventChainLogic;

    @SerializedName("enable_overflow_click")
    private final boolean enableOverflowClick;

    @SerializedName("opt_search_skeleton_delay_hide_duration")
    private final long hideSkeletonDelayDuration;

    @SerializedName("bridge_lynx_url")
    private final String lynxBridgeUrl;

    @SerializedName("opt_cart_track")
    private final boolean optCartTrack;

    @SerializedName("order_list_recommend_lynx_url")
    private final String orderListGULUrl;

    @SerializedName("order_search_result_recommend_h5_url")
    private final String orderSearchGULUrl;

    @SerializedName("yata_render_max_duration")
    private final long yataRenderMaxDuration;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public OrderListSettingConfig() {
        this(null, null, null, false, false, 0, false, false, false, 0, false, 0, false, false, false, 32767, null);
    }

    public static /* synthetic */ OrderListSettingConfig copy$default(OrderListSettingConfig r16, String r17, String r18, String r19, boolean r20, boolean r21, int r22, boolean r23, boolean r24, boolean r25, long r26, boolean r28, long r29, boolean r31, boolean r32, boolean r33, int r34, Object r35) {
        if ((r34 & 1) == 0) goto L5;
        String r10 = r16.orderListGULUrl;
    L7:
        if ((r34 & 2) == 0) goto L9;
        String r11 = r16.orderSearchGULUrl;
    L11:
        if ((r34 & 4) == 0) goto L13;
        String r12 = r16.lynxBridgeUrl;
    L15:
        if ((r34 & 8) == 0) goto L17;
        boolean r13 = r16.bigFontSwitch;
    L19:
        if ((r34 & 16) == 0) goto L21;
        boolean r14 = r16.clickDebounceSwitch;
    L23:
        if ((r34 & 32) == 0) goto L25;
        int r15 = r16.clickDebounceDuration;
    L27:
        if ((r34 & 64) == 0) goto L29;
        boolean r27 = r16.enableNewEventChainLogic;
    L31:
        if ((r34 & 128) == 0) goto L33;
        boolean r30 = r16.disableIncrementalFacade;
    L35:
        if ((r34 & 256) == 0) goto L37;
        boolean r110 = r16.enableFirstEnterQuickDispatch;
    L39:
        if ((r34 & 512) == 0) goto L41;
        long r111 = r16.yataRenderMaxDuration;
    L43:
        if ((r34 & 1024) == 0) goto L45;
        boolean r112 = r16.optCartTrack;
    L47:
        if ((r34 & 2048) == 0) goto L49;
        long r113 = r16.hideSkeletonDelayDuration;
    L50:
        long r210 = r113;
        if ((r34 & 4096) == 0) goto L53;
        boolean r114 = r16.enableContainerClipChildren;
    L55:
        if ((r34 & 8192) == 0) goto L57;
        boolean r115 = r16.drawableResetPreFetch;
    L59:
        if ((r34 & 16384) == 0) goto L61;
        boolean r1 = r16.enableOverflowClick;
    L63:
        return r16.copy(r10, r11, r12, r13, r14, r15, r27, r30, r110, r111, r112, r210, r114, r115, r1);
    L61:
        r1 = r33;
        goto L63
    L57:
        r115 = r32;
        goto L59
    L53:
        r114 = r31;
        goto L55
    L49:
        r113 = r29;
        goto L50
    L45:
        r112 = r28;
        goto L47
    L41:
        r111 = r26;
        goto L43
    L37:
        r110 = r25;
        goto L39
    L33:
        r30 = r24;
        goto L35
    L29:
        r27 = r23;
        goto L31
    L25:
        r15 = r22;
        goto L27
    L21:
        r14 = r21;
        goto L23
    L17:
        r13 = r20;
        goto L19
    L13:
        r12 = r19;
        goto L15
    L9:
        r11 = r18;
        goto L11
    L5:
        r10 = r17;
        goto L7
    }

    public final String component1() {
        return this.orderListGULUrl;
    }

    public final long component10() {
        return this.yataRenderMaxDuration;
    }

    public final boolean component11() {
        return this.optCartTrack;
    }

    public final long component12() {
        return this.hideSkeletonDelayDuration;
    }

    public final boolean component13() {
        return this.enableContainerClipChildren;
    }

    public final boolean component14() {
        return this.drawableResetPreFetch;
    }

    public final boolean component15() {
        return this.enableOverflowClick;
    }

    public final String component2() {
        return this.orderSearchGULUrl;
    }

    public final String component3() {
        return this.lynxBridgeUrl;
    }

    public final boolean component4() {
        return this.bigFontSwitch;
    }

    public final boolean component5() {
        return this.clickDebounceSwitch;
    }

    public final int component6() {
        return this.clickDebounceDuration;
    }

    public final boolean component7() {
        return this.enableNewEventChainLogic;
    }

    public final boolean component8() {
        return this.disableIncrementalFacade;
    }

    public final boolean component9() {
        return this.enableFirstEnterQuickDispatch;
    }

    public final OrderListSettingConfig copy(String r21, String r22, String r23, boolean r24, boolean r25, int r26, boolean r27, boolean r28, boolean r29, long r30, boolean r32, long r33, boolean r35, boolean r36, boolean r37) {
        Intrinsics.checkNotNullParameter(r21, "orderListGULUrl");
        Intrinsics.checkNotNullParameter(r22, "orderSearchGULUrl");
        Intrinsics.checkNotNullParameter(r23, "lynxBridgeUrl");
        return new OrderListSettingConfig(r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r32, r33, r35, r36, r37);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof OrderListSettingConfig) == false) goto L36;
        OrderListSettingConfig r11 = (OrderListSettingConfig) r10;
        if (Intrinsics.areEqual(this.orderListGULUrl, r11.orderListGULUrl) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.orderSearchGULUrl, r11.orderSearchGULUrl) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.lynxBridgeUrl, r11.lynxBridgeUrl) == true) goto L12;
        return false;
    L12:
        if (this.bigFontSwitch == r11.bigFontSwitch) goto L14;
        return false;
    L14:
        if (this.clickDebounceSwitch == r11.clickDebounceSwitch) goto L16;
        return false;
    L16:
        if (this.clickDebounceDuration == r11.clickDebounceDuration) goto L18;
        return false;
    L18:
        if (this.enableNewEventChainLogic == r11.enableNewEventChainLogic) goto L20;
        return false;
    L20:
        if (this.disableIncrementalFacade == r11.disableIncrementalFacade) goto L22;
        return false;
    L22:
        if (this.enableFirstEnterQuickDispatch == r11.enableFirstEnterQuickDispatch) goto L24;
        return false;
    L24:
        if (this.yataRenderMaxDuration == r11.yataRenderMaxDuration) goto L26;
        return false;
    L26:
        if (this.optCartTrack == r11.optCartTrack) goto L28;
        return false;
    L28:
        if (this.hideSkeletonDelayDuration == r11.hideSkeletonDelayDuration) goto L30;
        return false;
    L30:
        if (this.enableContainerClipChildren == r11.enableContainerClipChildren) goto L32;
        return false;
    L32:
        if (this.drawableResetPreFetch == r11.drawableResetPreFetch) goto L34;
        return false;
    L34:
        if (this.enableOverflowClick == r11.enableOverflowClick) goto L55;
        return false;
    L55:
        return true;
    L36:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r0v18, types: [int] */
    /* JADX WARN: Type inference failed for: r0v22, types: [int] */
    /* JADX WARN: Type inference failed for: r0v26, types: [int] */
    /* JADX WARN: Type inference failed for: r0v28, types: [int] */
    /* JADX WARN: Type inference failed for: r0v30, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v16, types: [int] */
    /* JADX WARN: Type inference failed for: r1v18, types: [int] */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r3v3, types: [int] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    public int hashCode() {
        String r0 = this.orderListGULUrl;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r10 = r0.hashCode();
    L6:
        int r11 = r10 * 31;
        String r12 = this.orderSearchGULUrl;
        if (r12 == null) goto L9;
        int r13 = r12.hashCode();
    L10:
        int r14 = (r11 + r13) * 31;
        String r15 = this.lynxBridgeUrl;
        if (r15 == null) goto L13;
        r1 = r15.hashCode();
    L13:
        int r16 = (r14 + r1) * 31;
        boolean r17 = this.bigFontSwitch;
        ?? r18 = 1;
        ?? r19 = r17;
        if (r17 == false) goto L16;
        r19 = 1;
    L16:
        int r20 = (r16 + r19) * 31;
        boolean r21 = this.clickDebounceSwitch;
        ?? r22 = r21;
        if (r21 == false) goto L19;
        r22 = 1;
    L19:
        int r23 = (((r20 + r22) * 31) + this.clickDebounceDuration) * 31;
        boolean r24 = this.enableNewEventChainLogic;
        ?? r25 = r24;
        if (r24 == false) goto L22;
        r25 = 1;
    L22:
        int r26 = (r23 + r25) * 31;
        boolean r27 = this.disableIncrementalFacade;
        ?? r28 = r27;
        if (r27 == false) goto L25;
        r28 = 1;
    L25:
        int r29 = (r26 + r28) * 31;
        boolean r30 = this.enableFirstEnterQuickDispatch;
        ?? r31 = r30;
        if (r30 == false) goto L28;
        r31 = 1;
    L28:
        long r32 = this.yataRenderMaxDuration;
        int r33 = (((r29 + r31) * 31) + ((int) (r32 ^ (r32 >>> 32)))) * 31;
        boolean r34 = this.optCartTrack;
        ?? r35 = r34;
        if (r34 == false) goto L31;
        r35 = 1;
    L31:
        int r36 = (r33 + r35) * 31;
        long r37 = this.hideSkeletonDelayDuration;
        int r38 = (r36 + ((int) (r37 ^ (r37 >>> 32)))) * 31;
        boolean r39 = this.enableContainerClipChildren;
        ?? r40 = r39;
        if (r39 == false) goto L34;
        r40 = 1;
    L34:
        int r41 = (r38 + r40) * 31;
        boolean r42 = this.drawableResetPreFetch;
        ?? r43 = r42;
        if (r42 == false) goto L37;
        r43 = 1;
    L37:
        int r44 = (r41 + r43) * 31;
        boolean r45 = this.enableOverflowClick;
        if (r45 == true) goto L42;
        r18 = r45;
    L42:
        return r44 + r18;
    L9:
        r13 = 0;
        goto L10
    L5:
        r10 = 0;
        goto L6
    }

    public String toString() {
        return "OrderListSettingConfig(orderListGULUrl=" + this.orderListGULUrl + ", orderSearchGULUrl=" + this.orderSearchGULUrl + ", lynxBridgeUrl=" + this.lynxBridgeUrl + ", bigFontSwitch=" + this.bigFontSwitch + ", clickDebounceSwitch=" + this.clickDebounceSwitch + ", clickDebounceDuration=" + this.clickDebounceDuration + ", enableNewEventChainLogic=" + this.enableNewEventChainLogic + ", disableIncrementalFacade=" + this.disableIncrementalFacade + ", enableFirstEnterQuickDispatch=" + this.enableFirstEnterQuickDispatch + ", yataRenderMaxDuration=" + this.yataRenderMaxDuration + ", optCartTrack=" + this.optCartTrack + ", hideSkeletonDelayDuration=" + this.hideSkeletonDelayDuration + ", enableContainerClipChildren=" + this.enableContainerClipChildren + ", drawableResetPreFetch=" + this.drawableResetPreFetch + ", enableOverflowClick=" + this.enableOverflowClick + ")";
    }

    public final boolean getBigFontSwitch() {
        return this.bigFontSwitch;
    }

    public final int getClickDebounceDuration() {
        return this.clickDebounceDuration;
    }

    public final boolean getClickDebounceSwitch() {
        return this.clickDebounceSwitch;
    }

    public final boolean getDisableIncrementalFacade() {
        return this.disableIncrementalFacade;
    }

    public final boolean getDrawableResetPreFetch() {
        return this.drawableResetPreFetch;
    }

    public final boolean getEnableContainerClipChildren() {
        return this.enableContainerClipChildren;
    }

    public final boolean getEnableFirstEnterQuickDispatch() {
        return this.enableFirstEnterQuickDispatch;
    }

    public final boolean getEnableNewEventChainLogic() {
        return this.enableNewEventChainLogic;
    }

    public final boolean getEnableOverflowClick() {
        return this.enableOverflowClick;
    }

    public final long getHideSkeletonDelayDuration() {
        return this.hideSkeletonDelayDuration;
    }

    public final String getLynxBridgeUrl() {
        return this.lynxBridgeUrl;
    }

    public final boolean getOptCartTrack() {
        return this.optCartTrack;
    }

    public final String getOrderListGULUrl() {
        return this.orderListGULUrl;
    }

    public final String getOrderSearchGULUrl() {
        return this.orderSearchGULUrl;
    }

    public final long getYataRenderMaxDuration() {
        return this.yataRenderMaxDuration;
    }

    public OrderListSettingConfig(String r10, String r11, String r12, boolean r13, boolean r14, int r15, boolean r16, boolean r17, boolean r18, long r19, boolean r110, long r111, boolean r20, boolean r21, boolean r22) {
        Intrinsics.checkNotNullParameter(r10, "orderListGULUrl");
        Intrinsics.checkNotNullParameter(r11, "orderSearchGULUrl");
        Intrinsics.checkNotNullParameter(r12, "lynxBridgeUrl");
        this.orderListGULUrl = r10;
        this.orderSearchGULUrl = r11;
        this.lynxBridgeUrl = r12;
        this.bigFontSwitch = r13;
        this.clickDebounceSwitch = r14;
        this.clickDebounceDuration = r15;
        this.enableNewEventChainLogic = r16;
        this.disableIncrementalFacade = r17;
        this.enableFirstEnterQuickDispatch = r18;
        this.yataRenderMaxDuration = r19;
        this.optCartTrack = r110;
        this.hideSkeletonDelayDuration = r111;
        this.enableContainerClipChildren = r20;
        this.drawableResetPreFetch = r21;
        this.enableOverflowClick = r22;
    }

    public /* synthetic */ OrderListSettingConfig(String r18, String r19, String r20, boolean r21, boolean r22, int r23, boolean r24, boolean r25, boolean r26, long r27, boolean r29, long r30, boolean r32, boolean r33, boolean r34, int r35, DefaultConstructorMarker r36) {
        if ((r35 & 1) == 0) goto L5;
        String r1 = "https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10181/gecko/resource/yata_gul_container/app/template.js";
    L7:
        if ((r35 & 2) == 0) goto L9;
        String r10 = ORDER_SEARCH_RESULT_GUL_URL;
    L11:
        if ((r35 & 4) == 0) goto L13;
        String r11 = "https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10181/gecko/resource/ecommerce_lynx_event_page/lynx/views/app/template.js";
    L15:
        if ((r35 & 8) == 0) goto L17;
        boolean r12 = false;
    L19:
        if ((r35 & 16) == 0) goto L21;
        boolean r13 = true;
    L23:
        if ((r35 & 32) == 0) goto L25;
        int r14 = FontWeight.WEIGHT_300;
    L27:
        if ((r35 & 64) == 0) goto L29;
        boolean r15 = false;
    L31:
        if ((r35 & 128) == 0) goto L33;
        boolean r16 = false;
    L35:
        if ((r35 & 256) == 0) goto L37;
        boolean r17 = false;
    L39:
        if ((r35 & 512) == 0) goto L41;
        long r110 = 1000;
    L43:
        if ((r35 & 1024) == 0) goto L45;
        boolean r111 = false;
    L47:
        if ((r35 & 2048) == 0) goto L49;
        long r112 = 2000;
    L51:
        if ((r35 & 4096) == 0) goto L53;
        boolean r28 = false;
    L55:
        if ((r35 & 8192) == 0) goto L57;
        boolean r31 = true;
    L59:
        if ((r35 & 16384) == 0) goto L61;
        boolean r0 = true;
    L62:
        this(r1, r10, r11, r12, r13, r14, r15, r16, r17, r110, r111, r112, r28, r31, r0);
        return;
    L61:
        r0 = r34;
        goto L62
    L57:
        r31 = r33;
        goto L59
    L53:
        r28 = r32;
        goto L55
    L49:
        r112 = r30;
        goto L51
    L45:
        r111 = r29;
        goto L47
    L41:
        r110 = r27;
        goto L43
    L37:
        r17 = r26;
        goto L39
    L33:
        r16 = r25;
        goto L35
    L29:
        r15 = r24;
        goto L31
    L25:
        r14 = r23;
        goto L27
    L21:
        r13 = r22;
        goto L23
    L17:
        r12 = r21;
        goto L19
    L13:
        r11 = r20;
        goto L15
    L9:
        r10 = r19;
        goto L11
    L5:
        r1 = r18;
        goto L7
    }
}
