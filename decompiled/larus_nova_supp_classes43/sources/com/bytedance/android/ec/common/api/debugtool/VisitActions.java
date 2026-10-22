package com.bytedance.android.ec.common.api.debugtool;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u001c\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001d¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/ec/common/api/debugtool/VisitActions;", "", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "key", "getKey", "PDP_PRELOAD", "PDP_IN", "PDP_IN_URL", "PDP_IN_NEW_URL", "PDP_IN_MOCK_NEW_URL", "PDP_REQ_PACK", "PDP_OUT_IM", "PDP_OUT_CART", "PDP_OUT_SHOP", "PDP_OUT_ADD_CART", "PDP_OUT_ORDER", "PDP_OUT_SKU", "PDP_REQ_GUL", "PDP_GUL_TO_PDP", "SKU_REQ_COMMON_SKU", "SKU_REQ_CHECK_LIVE", "SKU_REQ_CHECK_ANCHOR", "SKU_REQ_ADD_CART", "BUY_NOW_REQUEST_BUY_RENDER", "BUY_NOW_REQUEST_BUY_RENDER_EDIT", "BUY_NOW_REQUEST_ORDER_CREATE", "ec-common-api_release"}, k = 1, mv = {1, 4, 3})
public final enum VisitActions extends Enum<VisitActions> {
    public static final VisitActions BUY_NOW_REQUEST_BUY_RENDER = null;
    public static final VisitActions BUY_NOW_REQUEST_BUY_RENDER_EDIT = null;
    public static final VisitActions BUY_NOW_REQUEST_ORDER_CREATE = null;
    public static final VisitActions PDP_GUL_TO_PDP = null;
    public static final VisitActions PDP_IN = null;
    public static final VisitActions PDP_IN_MOCK_NEW_URL = null;
    public static final VisitActions PDP_IN_NEW_URL = null;
    public static final VisitActions PDP_IN_URL = null;
    public static final VisitActions PDP_OUT_ADD_CART = null;
    public static final VisitActions PDP_OUT_CART = null;
    public static final VisitActions PDP_OUT_IM = null;
    public static final VisitActions PDP_OUT_ORDER = null;
    public static final VisitActions PDP_OUT_SHOP = null;
    public static final VisitActions PDP_OUT_SKU = null;
    public static final VisitActions PDP_PRELOAD = null;
    public static final VisitActions PDP_REQ_GUL = null;
    public static final VisitActions PDP_REQ_PACK = null;
    public static final VisitActions SKU_REQ_ADD_CART = null;
    public static final VisitActions SKU_REQ_CHECK_ANCHOR = null;
    public static final VisitActions SKU_REQ_CHECK_LIVE = null;
    public static final VisitActions SKU_REQ_COMMON_SKU = null;
    public static final /* synthetic */ VisitActions[] a = null;
    private final String key;
    private final String title;

    public static VisitActions valueOf(String r1) {
        return (VisitActions) a.a(VisitActions.class, r1);
    }

    public static VisitActions[] values() {
        return (VisitActions[]) a.clone();
    }

    static {
        VisitActions r1 = new VisitActions("PDP_PRELOAD", 0, "预加载商详", "action_pdp_preload");
        PDP_PRELOAD = r1;
        VisitActions r10 = new VisitActions("PDP_IN", 1, "进入商详", "action_pdp_in");
        PDP_IN = r10;
        VisitActions r11 = new VisitActions("PDP_IN_URL", 2, "商详URL", "action_pdp_in_url");
        PDP_IN_URL = r11;
        VisitActions r12 = new VisitActions("PDP_IN_NEW_URL", 3, "商详新Schema", "action_pdp_new_schema");
        PDP_IN_NEW_URL = r12;
        VisitActions r13 = new VisitActions("PDP_IN_MOCK_NEW_URL", 4, "商详新Schema桥接", "action_mock_pdp_new_schema");
        PDP_IN_MOCK_NEW_URL = r13;
        VisitActions r14 = new VisitActions("PDP_REQ_PACK", 5, "Pack请求", "request_pdp_pack");
        PDP_REQ_PACK = r14;
        VisitActions r15 = new VisitActions("PDP_OUT_IM", 6, "商详跳IM", "action_pdp_out_im");
        PDP_OUT_IM = r15;
        VisitActions r16 = new VisitActions("PDP_OUT_CART", 7, "商详跳购物车", "action_pdp_out_cart");
        PDP_OUT_CART = r16;
        VisitActions r17 = new VisitActions("PDP_OUT_SHOP", 8, "商详跳橱窗", "action_pdp_out_store");
        PDP_OUT_SHOP = r17;
        VisitActions r18 = new VisitActions("PDP_OUT_ADD_CART", 9, "商详一步加购", "action_pdp_out_add_cart");
        PDP_OUT_ADD_CART = r18;
        VisitActions r19 = new VisitActions("PDP_OUT_ORDER", 10, "商详一步提单", "action_pdp_out_order");
        PDP_OUT_ORDER = r19;
        VisitActions r20 = new VisitActions("PDP_OUT_SKU", 11, "商详跳SKU", "action_pdp_out_sku");
        PDP_OUT_SKU = r20;
        VisitActions r21 = new VisitActions("PDP_REQ_GUL", 12, "请求猜你喜欢", "request_pdp_gul");
        PDP_REQ_GUL = r21;
        VisitActions r22 = new VisitActions("PDP_GUL_TO_PDP", 13, "猜喜跳转商详", "pdp_gul_to_pdp");
        PDP_GUL_TO_PDP = r22;
        VisitActions r23 = new VisitActions("SKU_REQ_COMMON_SKU", 14, "SKU信息请求", "request_sku_common");
        SKU_REQ_COMMON_SKU = r23;
        VisitActions r24 = new VisitActions("SKU_REQ_CHECK_LIVE", 15, "SKU直播check请求", "request_sku_check_live");
        SKU_REQ_CHECK_LIVE = r24;
        VisitActions r25 = new VisitActions("SKU_REQ_CHECK_ANCHOR", 16, "SKUAnchorCheck请求", "request_sku_check_anchor");
        SKU_REQ_CHECK_ANCHOR = r25;
        VisitActions r26 = new VisitActions("SKU_REQ_ADD_CART", 17, "SKU加购", "request_sku_add_cart");
        SKU_REQ_ADD_CART = r26;
        VisitActions r27 = new VisitActions("BUY_NOW_REQUEST_BUY_RENDER", 18, "提单页 BuyRender", "request_buy_now_buy_render");
        BUY_NOW_REQUEST_BUY_RENDER = r27;
        VisitActions r28 = new VisitActions("BUY_NOW_REQUEST_BUY_RENDER_EDIT", 19, "提单页 BuyRenderEdit", "request_buy_now_buy_render_edit");
        BUY_NOW_REQUEST_BUY_RENDER_EDIT = r28;
        VisitActions r29 = new VisitActions("BUY_NOW_REQUEST_ORDER_CREATE", 20, "提单页创建订单接口", "requst_buy_now_order_create");
        BUY_NOW_REQUEST_ORDER_CREATE = r29;
        a = new VisitActions[]{r1, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29};
    }

    public final String getKey() {
        return this.key;
    }

    public final String getTitle() {
        return this.title;
    }

    public VisitActions(String r1, int r10, String r11, String r12) {
        super(r1, r10);
        this.title = r11;
        this.key = r12;
    }
}
