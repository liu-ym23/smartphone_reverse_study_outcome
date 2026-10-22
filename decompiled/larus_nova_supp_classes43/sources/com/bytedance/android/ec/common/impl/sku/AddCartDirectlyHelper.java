package com.bytedance.android.ec.common.impl.sku;

import android.content.Context;
import android.text.TextUtils;
import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.common.impl.sku.model.SpecInfo;
import com.bytedance.android.ec.common.impl.sku.model.SpecInfoItem;
import com.bytedance.android.ec.common.impl.sku.repository.dto.AddCartResponse;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.monitor.ECProcessMonitor;
import com.bytedance.android.ec.core.monitor.param.ECParamTracker;
import com.bytedance.android.ec.core.monitor.param.ECParamTrackerCenter;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.model.sku.CartNumWithBusinessLine;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ecom.bcm.track.api.EcomBcmTracker;
import com.bytedance.common.utility.UIUtils;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AddCartDirectlyHelper {
    public static final /* synthetic */ int a = 0;

    public static final class a implements Observer<AddCartResponse> {
        public final /* synthetic */ com.bytedance.android.ec.core.monitor.param.a a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ cf.a f;
        public final /* synthetic */ String g;
        public final /* synthetic */ Map h;
        public final /* synthetic */ boolean i;
        public final /* synthetic */ Function1 j;
        public final /* synthetic */ Context k;
        public final /* synthetic */ int l;
        public final /* synthetic */ String m;

        public final void onComplete() {
        }

        public final void onSubscribe(Disposable r10) {
            Intrinsics.checkNotNullParameter(r10, "d");
        }

        public final void onError(Throwable r10) {
            Intrinsics.checkNotNullParameter(r10, "e");
            int r11 = AddCartDirectlyHelper.a;
            AddCartDirectlyHelper.g(this.c, this.g, null, Integer.valueOf(this.b), this.h);
            cf.a r12 = this.f;
            if (r12 != null) goto L5;
        L6:
            Context r13 = this.k;
            UIUtils.displayToast(r13, th.a.g(r13, 2131913776));
        L7:
            cf.a r14 = this.f;
            if (r14 == null) goto L11;
            r14.onFailed();
        L11:
            if (AddCartDirectlyHelper.c(this.b) == false) goto L14;
            Set<String> r15 = ECProcessMonitor.a;
            com.bytedance.android.ec.core.monitor.listener.a.k(ECProcessMonitor.d("ec_product_detail"), -5, null, null, null, 14);
        L14:
            if (AddCartDirectlyHelper.b(this.b) == false) goto L17;
            Set<String> r16 = ECProcessMonitor.a;
            com.bytedance.android.ec.core.monitor.listener.a.k(ECProcessMonitor.d("ec_product_flow_page"), -5, null, null, null, 14);
            return;
        L17:
            return;
        L5:
            if (r12.c() == false) goto L7;
            goto L6
        }

        public final void onNext(Object r29) {
            final AddCartResponse r1 = (AddCartResponse) r29;
            Intrinsics.checkNotNullParameter(r1, "t");
            com.bytedance.android.ec.core.monitor.param.a r10 = this.a;
            if (r10 == null) goto L6;
            r10.l("/cart/cartAdd", new AddCartDirectlyHelper$onClickAddShopCartImpl$2$onNext$1(r1));
        L6:
            if (r1.getStatusCode() != 0) goto L56;
            EventBus r11 = EventBus.getDefault();
            int r12 = r1.getCount();
            Integer r13 = Integer.valueOf(this.b);
            String r14 = this.c;
            List<CartNumWithBusinessLine> r15 = r1.getCartNumWithBusinessLine();
            String r16 = this.d;
            String r17 = this.e;
            cf.a r18 = this.f;
            if (r18 == null) goto L12;
            jf.e r19 = r18.a();
            if (r19 == null) goto L12;
            Integer r110 = Integer.valueOf(r19.a);
        L13:
            r11.post(new hl.b(r12, null, r13, r14, r15, r16, r17, null, null, r110, null, null, r1.getSchema(), null, false, r1.getCartId(), com.bytedance.android.shopping.extensions.k.v(r1.getToastBar()), null, 638336));
            EventBus.getDefault().post(new hl.d(r1.getCount()));
            EventBus.getDefault().post(new hl.g(r1.getCount(), true));
            int r20 = AddCartDirectlyHelper.a;
            AddCartDirectlyHelper.h(this.c, this.g, r1.getCartId(), Integer.valueOf(this.b), this.h);
            if (this.i == false) goto L27;
            Function1 r21 = this.j;
            if (r21 == null) goto L19;
            Unit r22 = (Unit) r21.invoke(Integer.valueOf(r1.getCount()));
        L19:
            if (this.b != 201) goto L21;
            boolean r23 = true;
        L22:
            if (r23 == false) goto L48;
            if (a2.b(r1.getToastMsg()) == false) goto L48;
            UIUtils.displayToast(this.k, r1.getToastMsg());
        L48:
            if (AddCartDirectlyHelper.c(this.b) == false) goto L51;
            Set<String> r24 = ECProcessMonitor.a;
            ECProcessMonitor.d("ec_product_detail").g();
        L51:
            if (AddCartDirectlyHelper.b(this.b) == false) goto L53;
            Set<String> r25 = ECProcessMonitor.a;
            ECProcessMonitor.d("ec_product_flow_page").g();
        L53:
            cf.a r26 = this.f;
            if (r26 == null) goto L81;
            cf.a.C0011a.a(r26, r1.getCount(), this.c, this.g, r1.getCartId(), Integer.valueOf(this.b), this.m, this.d, StringsKt.toIntOrNull(this.e));
            return;
        L81:
            return;
        L21:
            r23 = false;
            goto L22
        L27:
            if (this.b != 201) goto L29;
            boolean r27 = true;
        L30:
            if (r27 == false) goto L35;
            if (a2.b(r1.getToastMsg()) == false) goto L35;
            UIUtils.displayToast(this.k, r1.getToastMsg());
        L35:
            if (a2.b(r1.getToastMsg()) == false) goto L37;
            UIUtils.displayToast(this.k, r1.getToastMsg());
            goto L48
        L37:
            int r28 = this.l;
            if (r28 == (-1)) goto L44;
            if (r28 == 0) goto L43;
            if (r28 != 1) goto L48;
            Context r30 = this.k;
            UIUtils.displayToast(r30, th.a.g(r30, 2131913879));
            goto L48
        L43:
            Context r31 = this.k;
            UIUtils.displayToast(r31, th.a.g(r31, 2131913777));
            goto L48
        L44:
            Function1 r32 = this.j;
            if (r32 == null) goto L48;
            Unit r33 = (Unit) r32.invoke(Integer.valueOf(r1.getCount()));
            goto L48
        L29:
            r27 = false;
        L12:
            r110 = null;
            goto L13
        L56:
            cf.a r34 = this.f;
            if (r34 != null) goto L59;
        L60:
            String r35 = r1.getStatusMsg();
            if (r35 != null) goto L63;
        L66:
            boolean r36 = true;
        L67:
            if (r36 == false) goto L69;
            Context r37 = this.k;
            UIUtils.displayToast(r37, th.a.g(r37, 2131913776));
        L70:
            int r38 = AddCartDirectlyHelper.a;
            if (AddCartDirectlyHelper.c(this.b) == false) goto L74;
            Set<String> r39 = ECProcessMonitor.a;
            com.bytedance.android.ec.core.monitor.listener.a.k(ECProcessMonitor.d("ec_product_detail"), r1.getStatusCode(), r1.getStatusMsg(), null, null, 12);
        L74:
            if (AddCartDirectlyHelper.b(this.b) == false) goto L76;
            Set<String> r40 = ECProcessMonitor.a;
            com.bytedance.android.ec.core.monitor.listener.a.k(ECProcessMonitor.d("ec_product_flow_page"), r1.getStatusCode(), r1.getStatusMsg(), null, null, 12);
        L76:
            cf.a r41 = this.f;
            if (r41 == null) goto L79;
            r41.onFailed();
        L79:
            AddCartDirectlyHelper.g(this.c, this.g, r1.getCartId(), Integer.valueOf(this.b), this.h);
            return;
        L69:
            UIUtils.displayToast(this.k, r1.getStatusMsg());
            goto L70
        L63:
            if (r35.length() == 0) goto L66;
            r36 = false;
            goto L67
        L59:
            if (r34.c() == false) goto L70;
            goto L60
        }

        public a(com.bytedance.android.ec.core.monitor.param.a r1, int r10, String r11, String r12, String r13, cf.a r14, String r15, Map r16, boolean r17, Function1 r18, Context r19, int r110, String r111) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
            this.e = r13;
            this.f = r14;
            this.g = r15;
            this.h = r16;
            this.i = r17;
            this.j = r18;
            this.k = r19;
            this.l = r110;
            this.m = r111;
        }
    }

    public static final class b implements Observer<String> {
        public final /* synthetic */ com.bytedance.android.ec.core.monitor.param.a a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ int d;
        public final /* synthetic */ Map e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;

        public final void onComplete() {
        }

        public final void onSubscribe(Disposable r10) {
            Intrinsics.checkNotNullParameter(r10, "d");
        }

        public final void onError(Throwable r10) {
            Intrinsics.checkNotNullParameter(r10, "e");
            if (jg.g.a(this.f) == false) goto L5;
            int r11 = AddCartDirectlyHelper.a;
            AddCartDirectlyHelper.f(null, this.f);
        L6:
            int r12 = AddCartDirectlyHelper.a;
            if (AddCartDirectlyHelper.c(this.d) == false) goto L10;
            Set<String> r13 = ECProcessMonitor.a;
            com.bytedance.android.ec.core.monitor.listener.a.k(ECProcessMonitor.d("ec_product_detail"), -5, null, null, null, 14);
        L10:
            if (AddCartDirectlyHelper.b(this.d) == false) goto L12;
            Set<String> r14 = ECProcessMonitor.a;
            com.bytedance.android.ec.core.monitor.listener.a.k(ECProcessMonitor.d("ec_product_flow_page"), -5, null, null, null, 14);
        L12:
            AddCartDirectlyHelper.g(this.b, this.c, null, Integer.valueOf(this.d), this.e);
            return;
        L5:
            int r15 = AddCartDirectlyHelper.a;
            AddCartDirectlyHelper.e(null, Integer.valueOf(this.d), this.b, this.g);
            goto L6
        }

        public final void onNext(Object r13) {
            String r14 = (String) r13;
            Intrinsics.checkNotNullParameter(r14, "t");
            JSONObject r10 = new JSONObject(r14);     // Catch: Exception -> L34
            JSONObject r15 = r10.optJSONObject("data");     // Catch: Exception -> L34
            if (r15 == null) goto L6;
            String r16 = r15.optString("cart_id");     // Catch: Exception -> L34
        L7:
            final int r11 = r10.optInt("status_code");     // Catch: Exception -> L34
            String r12 = r10.optString(MessageIndication.MESSAGE_TYPE_MSG);     // Catch: Exception -> L34
            com.bytedance.android.ec.core.monitor.param.a r17 = this.a;     // Catch: Exception -> L34
            if (r17 == null) goto L10;
            r17.l("/cart/cartAdd_new", new AddCartDirectlyHelper$onClickAddShopCartImpl$4$onNext$1(r11));     // Catch: Exception -> L34
        L10:
            int r18 = AddCartDirectlyHelper.a;     // Catch: Exception -> L34
            AddCartDirectlyHelper.h(this.b, this.c, r16, Integer.valueOf(this.d), this.e);     // Catch: Exception -> L34
            if (r11 != 0) goto L23;
            if (jg.g.a(this.f) == false) goto L15;
            AddCartDirectlyHelper.f(r10, this.f);     // Catch: Exception -> L34
        L17:
            if (AddCartDirectlyHelper.c(this.d) == false) goto L20;
            Set<String> r19 = ECProcessMonitor.a;     // Catch: Exception -> L34
            ECProcessMonitor.d("ec_product_detail").g();     // Catch: Exception -> L34
        L20:
            if (AddCartDirectlyHelper.b(this.d) == false) goto L46;
            Set<String> r110 = ECProcessMonitor.a;     // Catch: Exception -> L34
            ECProcessMonitor.d("ec_product_flow_page").g();     // Catch: Exception -> L34
            return;
        L46:
            return;
        L15:
            AddCartDirectlyHelper.e(r10, Integer.valueOf(this.d), this.b, this.g);     // Catch: Exception -> L34
            goto L17
        L23:
            if (jg.g.a(this.f) == false) goto L25;
            AddCartDirectlyHelper.f(r10, this.f);     // Catch: Exception -> L34
        L27:
            if (AddCartDirectlyHelper.c(this.d) == false) goto L30;
            Set<String> r20 = ECProcessMonitor.a;     // Catch: Exception -> L34
            com.bytedance.android.ec.core.monitor.listener.a.k(ECProcessMonitor.d("ec_product_detail"), r11, r12, null, null, 12);     // Catch: Exception -> L34
        L30:
            if (AddCartDirectlyHelper.b(this.d) == false) goto L32;
            Set<String> r21 = ECProcessMonitor.a;     // Catch: Exception -> L34
            com.bytedance.android.ec.core.monitor.listener.a.k(ECProcessMonitor.d("ec_product_flow_page"), r11, r12, null, null, 12);     // Catch: Exception -> L34
        L32:
            AddCartDirectlyHelper.g(this.b, this.c, r16, Integer.valueOf(this.d), this.e);     // Catch: Exception -> L34
            return;
        L25:
            AddCartDirectlyHelper.e(r10, Integer.valueOf(this.d), this.b, this.g);     // Catch: Exception -> L34
            goto L27
        L6:
            r16 = null;
            goto L7
        L35:
            if (jg.g.a(this.f) == false) goto L37;
            int r111 = AddCartDirectlyHelper.a;
            AddCartDirectlyHelper.f(null, this.f);
        L38:
            int r112 = AddCartDirectlyHelper.a;
            if (AddCartDirectlyHelper.c(this.d) == false) goto L42;
            Set<String> r113 = ECProcessMonitor.a;
            com.bytedance.android.ec.core.monitor.listener.a.k(ECProcessMonitor.d("ec_product_detail"), -5, null, null, null, 14);
        L42:
            if (AddCartDirectlyHelper.b(this.d) == false) goto L48;
            Set<String> r114 = ECProcessMonitor.a;
            com.bytedance.android.ec.core.monitor.listener.a.k(ECProcessMonitor.d("ec_product_flow_page"), -5, null, null, null, 14);
            return;
        L48:
            return;
        L37:
            int r115 = AddCartDirectlyHelper.a;
            AddCartDirectlyHelper.e(null, Integer.valueOf(this.d), this.b, this.g);
            goto L38
        }

        public b(com.bytedance.android.ec.core.monitor.param.a r1, String r10, String r11, int r12, Map r13, String r14, String r15) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
            this.e = r13;
            this.f = r14;
            this.g = r15;
        }
    }

    public AddCartDirectlyHelper() {
    }

    public static boolean b(int r1) {
        if (r1 != 301) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean c(int r1) {
        if (r1 != 101) goto L5;
        return true;
    L5:
        return false;
    }

    static {
    }

    public static void a(String r1) {
        EcomBcmTracker.j(PageFinder.via(r1), new BcmParams());
    }

    public static void f(JSONObject r10, String r11) {
        if (r10 != null) goto L5;
        JSONObject r12 = new JSONObject();
        r12.put("sku_session_id", r11);
        JSONObject r13 = new JSONObject();
        r13.put("status_code", 2);
        Unit r1 = Unit.INSTANCE;
        r12.put("response", r13);
        ECLiveHybridUtil.f("ecom.sku.add.cart", r12);
        return;
    L5:
        r10.put("status_msg", r10.optString(MessageIndication.MESSAGE_TYPE_MSG));
        JSONObject r14 = new JSONObject();
        r14.put("sku_session_id", r11);
        r14.put("response", r10);
        Unit r15 = Unit.INSTANCE;
        ECLiveHybridUtil.f("ecom.sku.add.cart", r14);
    }

    public static void e(JSONObject r10, Integer r11, String r12, String r13) {
        if (r10 != null) goto L5;
        JSONObject r14 = new JSONObject();
        r14.put("status_code", 2);
        r14.put("scene_type", r11);
        r14.put(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_ID, r13);
        r14.put(com.bytedance.android.ec.core.event.a.KEY_PROMOTION_ID, r12);
        Unit r15 = Unit.INSTANCE;
        ECLiveHybridUtil.f("ecom.sku.add.cart", r14);
        return;
    L5:
        String r16 = r10.optString(MessageIndication.MESSAGE_TYPE_MSG);
        r10.put("scene_type", r11);
        r10.put(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_ID, r13);
        r10.put(com.bytedance.android.ec.core.event.a.KEY_PROMOTION_ID, r12);
        r10.put("status_msg", r16);
        Unit r17 = Unit.INSTANCE;
        ECLiveHybridUtil.f("ecom.sku.add.cart", r10);
    }

    public static void g(String r10, String r11, String r12, Integer r13, Map r14) {
        Intrinsics.checkNotNullParameter(r11, "btmShowId");
        JSONObject r0 = new JSONObject();
        r0.put("btm_show_id", r11);     // Catch: Throwable -> L18
        r0.put("cart_id", r12);     // Catch: Throwable -> L18
        r0.put(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_ID, r10);     // Catch: Throwable -> L18
        r0.put("scene_type", r13);     // Catch: Throwable -> L18
        if (r14 == null) goto L16;
        Iterator r15 = r14.entrySet().iterator();     // Catch: Throwable -> L18
    L6:
        if (r15.hasNext() == false) goto L16;
        Map.Entry r16 = (Map.Entry) r15.next();     // Catch: Throwable -> L18
        if (r16.getValue() == null) goto L6;
        String r17 = (String) r16.getKey();     // Catch: Throwable -> L18
        Object r18 = r16.getValue();     // Catch: Throwable -> L18
        if (r18 == null) goto L13;
        String r19 = r18.toString();     // Catch: Throwable -> L18
    L14:
        r0.put(r17, r19);     // Catch: Throwable -> L18
        goto L6
    L13:
        r19 = null;
    L16:
        com.bytedance.android.ec.sdk.helper.g.a.logV3("add_cart_fail", r0);
    }

    public static void h(String r10, String r11, String r12, Integer r13, Map r14) {
        Intrinsics.checkNotNullParameter(r11, "btmShowId");
        JSONObject r0 = new JSONObject();
        r0.put("btm_show_id", r11);     // Catch: Throwable -> L18
        r0.put("cart_id", r12);     // Catch: Throwable -> L18
        r0.put(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_ID, r10);     // Catch: Throwable -> L18
        r0.put("scene_type", r13);     // Catch: Throwable -> L18
        if (r14 == null) goto L16;
        Iterator r15 = r14.entrySet().iterator();     // Catch: Throwable -> L18
    L6:
        if (r15.hasNext() == false) goto L16;
        Map.Entry r16 = (Map.Entry) r15.next();     // Catch: Throwable -> L18
        if (r16.getValue() == null) goto L6;
        String r17 = (String) r16.getKey();     // Catch: Throwable -> L18
        Object r18 = r16.getValue();     // Catch: Throwable -> L18
        if (r18 == null) goto L13;
        String r19 = r18.toString();     // Catch: Throwable -> L18
    L14:
        r0.put(r17, r19);     // Catch: Throwable -> L18
        goto L6
    L13:
        r19 = null;
    L16:
        com.bytedance.android.ec.sdk.helper.g.a.logV3("add_cart_success", r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v9, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r18v1 */
    /* JADX WARN: Type inference failed for: r18v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r18v3 */
    /* JADX WARN: Type inference failed for: r19v3 */
    /* JADX WARN: Type inference failed for: r19v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r19v5 */
    /* JADX WARN: Type inference failed for: r23v0 */
    /* JADX WARN: Type inference failed for: r23v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r23v2 */
    /* JADX WARN: Type inference failed for: r47v1 */
    /* JADX WARN: Type inference failed for: r47v10 */
    /* JADX WARN: Type inference failed for: r47v11 */
    /* JADX WARN: Type inference failed for: r47v12 */
    /* JADX WARN: Type inference failed for: r47v13 */
    /* JADX WARN: Type inference failed for: r47v14 */
    /* JADX WARN: Type inference failed for: r47v15 */
    /* JADX WARN: Type inference failed for: r47v16 */
    /* JADX WARN: Type inference failed for: r47v17 */
    /* JADX WARN: Type inference failed for: r47v18 */
    /* JADX WARN: Type inference failed for: r47v2 */
    /* JADX WARN: Type inference failed for: r47v3 */
    /* JADX WARN: Type inference failed for: r47v4 */
    /* JADX WARN: Type inference failed for: r47v6 */
    /* JADX WARN: Type inference failed for: r47v7 */
    /* JADX WARN: Type inference failed for: r47v8 */
    /* JADX WARN: Type inference failed for: r47v9 */
    /* JADX WARN: Type inference failed for: r9v26, types: [java.lang.Object] */
    public static void d(int r32, int r33, eg.a r34, List r35, Context r36, final String r37, final String r38, final String r39, final String r40, final String r41, final String r42, String r43, String r44, final String r45, final String r46, String[] r47, String r48, boolean r49, String r50, boolean r51, String r52, com.bytedance.android.btm.api.model.l r53, boolean r54, String r55, cf.a r56, Function1 r57, final String r58, final Integer r59, Map r60, final String r61, final String r62, String r63, com.bytedance.android.ec.model.e r64) {
        com.bytedance.android.btm.api.model.l r10 = r53;
        Intrinsics.checkNotNullParameter(r34, "dataSource");
        Intrinsics.checkNotNullParameter(r36, "context");
        Intrinsics.checkNotNullParameter(r37, "originType");
        Intrinsics.checkNotNullParameter(r38, "originId");
        Intrinsics.checkNotNullParameter(r39, "promotionId");
        Intrinsics.checkNotNullParameter(r40, "productId");
        Intrinsics.checkNotNullParameter(r41, "authorId");
        Intrinsics.checkNotNullParameter(r42, "secAuthorId");
        Intrinsics.checkNotNullParameter(r43, BdpAwemeConstant.KEY_ROOM_ID);
        Intrinsics.checkNotNullParameter(r44, "shopId");
        Intrinsics.checkNotNullParameter(r45, "comboId");
        Intrinsics.checkNotNullParameter(r46, "comboNum");
        Intrinsics.checkNotNullParameter(r47, "selectedKeys");
        Intrinsics.checkNotNullParameter(r48, "trackExtra");
        if (r60 == null) goto L6;
        Map r11 = MapsKt.toMutableMap(r60);
        if (r11 == null) goto L6;
    L8:
        if (TextUtils.isEmpty(r45) == false) goto L10;
    L198:
        if (r56 != null) goto L200;
    L201:
        UIUtils.displayToast(r36, th.a.g(r36, 2131913776));
    L202:
        if (r56 == null) goto L205;
        r56.onFailed();
        Unit r0 = Unit.INSTANCE;
    L205:
        if (c(r33) == false) goto L208;
        Set<String> r1 = ECProcessMonitor.a;
        com.bytedance.android.ec.core.monitor.listener.a.k(ECProcessMonitor.d("ec_product_detail"), -2, null, null, null, 14);
    L208:
        if (b(r33) == false) goto L236;
        Set<String> r12 = ECProcessMonitor.a;
        com.bytedance.android.ec.core.monitor.listener.a.k(ECProcessMonitor.d("ec_product_flow_page"), -2, null, null, null, 14);
        return;
    L236:
        return;
    L200:
        if (r56.c() == false) goto L202;
    L10:
        if (TextUtils.isEmpty(r39) == false) goto L13;
        if (r51 == false) goto L198;
    L13:
        if (TextUtils.isEmpty(r40) == true) goto L198;
        String r16 = null;
        if (r35 == null) goto L36;
        List r13 = r35;
        ArrayList r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator r15 = r13.iterator();
        int r17 = 0;
    L19:
        if (r15.hasNext() == false) goto L35;
        Object r18 = r15.next();
        int r19 = r17 + 1;
        if (r17 >= 0) goto L23;
        CollectionsKt.throwIndexOverflow();
    L23:
        SpecInfo r110 = (SpecInfo) r18;
        StringBuilder r111 = new StringBuilder();
        Iterator r510 = r15;
        r111.append(r110.getName());
        r111.append(":");
        List<SpecInfoItem> r112 = r110.getSpecItems();
        ArrayList r113 = new ArrayList();
        Iterator r114 = r112.iterator();
    L25:
        if (r114.hasNext() == false) goto L30;
        Object r115 = r114.next();
        Iterator r65 = r114;
        Map r30 = r11;
        if (Intrinsics.areEqual(((SpecInfoItem) r115).getId(), r47[r17]) == false) goto L29;
        r113.add(r115);
    L29:
        r114 = r65;
        r11 = r30;
        goto L25
    L30:
        Map r31 = r11;
        ArrayList r20 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r113, 10));
        Iterator r116 = r113.iterator();
    L32:
        if (r116.hasNext() == false) goto L34;
        r20.add(((SpecInfoItem) r116.next()).getName());
        goto L32
    L34:
        r111.append(CollectionsKt.joinToString$default(r20, null, null, null, 0, null, null, 63, null));
        r14.add(r111.toString());
        r15 = r510;
        r17 = r19;
        r11 = r31;
        goto L19
    L35:
        Map r310 = r11;
        String r21 = CollectionsKt.joinToString$default(r14, " ", null, null, 0, null, null, 62, null);
    L37:
        final String r22 = ECAppInfoService.e.getServerDeviceId();
        BtmSDK r117 = BtmSDK.INSTANCE;
        if ((r10 instanceof com.bytedance.android.btm.api.model.d) == true) goto L40;
        com.bytedance.android.btm.api.model.l r118 = null;
    L41:
        com.bytedance.android.btm.api.model.d r119 = (com.bytedance.android.btm.api.model.d) r118;
        if (r119 == null) goto L45;
        PageFinder r120 = r119.b;
        if (r120 == null) goto L45;
    L46:
        com.bytedance.android.btm.api.model.e r121 = r117.getBtmPageInfo(r120);
        r47 = "";
        if (r121 == null) goto L50;
        String r122 = r121.a;
        if (r122 == null) goto L50;
    L51:
        final String r311 = EcomBcmTracker.g(r53);
        JSONObject r123 = new JSONObject(r48);     // Catch: Exception -> L165
        if ((!StringsKt.isBlank(r43)) == false) goto L56;
        String r124 = r43;
    L58:
        if (r124 == null) goto L64;
        r123.put(com.bytedance.android.ec.core.event.a.KEY_ROOM_ID, r124);     // Catch: Exception -> L61
    L88:
        ?? r410 = "";
    L154:
        Map r125 = r310;
        ?? r411 = r410;
    L166:
        String r312 = r48;
        ?? r412 = r411;
    L167:
        Map<String, ECParamTracker> r23 = ECParamTrackerCenter.a;
        if (r64 == null) goto L170;
        r16 = r64.b;
    L170:
        com.bytedance.android.ec.core.monitor.param.a r24 = ECParamTrackerCenter.c(r16);
        if (r54 == true) goto L187;
        if (r24 == null) goto L174;
        final String r126 = r21;
        final String r25 = r312;
        r24.l("/cart/cartAdd", new AddCartDirectlyHelper$onClickAddShopCartImpl$1(r39, r40, r37, r38, r45, r46, r126, r22, r25, r41, r42, r58, r59, r311, r61, r62));
        Unit r26 = Unit.INSTANCE;
    L174:
        if (r21 != null) goto L176;
        ?? r127 = r412;
    L177:
        if (r22 != null) goto L179;
        ?? r128 = r412;
    L180:
        if (r58 != null) goto L182;
        ?? r27 = r412;
    L183:
        if (r59 == null) goto L185;
        int r28 = r59.intValue();
    L186:
        r34.getClass();
        eg.a.a(r39, r40, r37, r38, r45, r46, r127, r128, r312, r41, r42, r27, r28, r311, r61, r62).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new a(r24, r33, r40, r45, r46, r56, r122, r125, r49, r57, r36, r32, r50));
        return;
    L185:
        r28 = 0;
        goto L186
    L182:
        r27 = r58;
        goto L183
    L179:
        r128 = r22;
        goto L180
    L176:
        r127 = r21;
        goto L177
    L187:
        if (r24 == null) goto L189;
        final String r29 = r312;
        com.bytedance.android.ec.core.monitor.param.a r129 = r24;
        r129.l("/cart/cartAdd_new", new AddCartDirectlyHelper$onClickAddShopCartImpl$3(r40, r45, r46, r29, r58, r59, r61, r62));
        Unit r66 = Unit.INSTANCE;
    L190:
        if (r58 != null) goto L192;
        ?? r130 = r412;
    L193:
        if (r59 == null) goto L195;
        int r67 = r59.intValue();
    L196:
        r34.getClass();
        eg.a.b(r40, r45, r46, r312, r130, r67, r311, r61, r62).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new b(r129, r40, r122, r33, r125, r55, r39));
        return;
    L195:
        r67 = 0;
        goto L196
    L192:
        r130 = r58;
        goto L193
    L189:
        r129 = r24;
    L64:
        if ((!StringsKt.isBlank(r44)) == false) goto L66;
        String r131 = r44;
    L67:
        if (r131 == null) goto L71;
        r123.put("shop_user_id", r131);     // Catch: Exception -> L61
    L71:
        if ((!StringsKt.isBlank(r41)) == false) goto L73;
        String r132 = r41;
    L75:
        if (r132 == null) goto L77;
        r123.put(com.bytedance.android.ec.core.event.a.KEY_AUTHOR_ID, r132);     // Catch: Exception -> L61
    L77:
        if (r63 == null) goto L81;
        String r133 = a2.d(r63);     // Catch: Exception -> L61
        if (r133 == null) goto L81;
        r123.put("biz_campaign_type", r133);     // Catch: Exception -> L61
    L81:
        if (r64 == null) goto L89;
        String r68 = r64.a;     // Catch: Exception -> L61
        if (r68 == null) goto L89;
        String r69 = a2.d(r68);     // Catch: Exception -> L61
        if (r69 == null) goto L89;
        r123.put("cps_track", r69);     // Catch: Exception -> L61
    L89:
        String r70 = r123.optString(com.bytedance.android.ec.core.event.a.KEY_ECOM_SCENE_ID);     // Catch: Exception -> L165
        String r134 = r123.optString("cart_track");     // Catch: Exception -> L165
        if (r134.length() <= 0) goto L93;
        boolean r135 = true;
    L225:
        if (r135 == true) goto L96;
        JSONObject r136 = new JSONObject();     // Catch: Exception -> L212
    L224:
    L103:
        if ((!Intrinsics.areEqual(r70, "1003")) == false) goto L109;
        r123.put(com.bytedance.android.ec.core.event.a.KEY_PROMOTION_ID, r39);     // Catch: Exception -> L106
        r136.put(com.bytedance.android.ec.core.event.a.KEY_PROMOTION_ID, r39);     // Catch: Exception -> L106
    L106:
        r410 = r47;
    L109:
        if ((!StringsKt.isBlank(r41)) == false) goto L111;
        String r71 = r41;
    L112:
        if (r71 == null) goto L116;
        r136.put(com.bytedance.android.ec.core.event.a.KEY_AUTHOR_ID, r71);     // Catch: Exception -> L106
    L116:
        if ((!StringsKt.isBlank(r43)) == false) goto L118;
        String r72 = r43;
    L119:
        if (r72 == null) goto L123;
        r136.put(com.bytedance.android.ec.core.event.a.KEY_ROOM_ID, r72);     // Catch: Exception -> L106
    L123:
        if ((!StringsKt.isBlank(r70)) == true) goto L126;
        r70 = null;
    L126:
        if (r70 == null) goto L128;
        r136.put(com.bytedance.android.ec.core.event.a.KEY_ECOM_SCENE_ID, r70);     // Catch: Exception -> L106
    L128:
        String r73 = r123.optString(com.bytedance.android.ec.core.event.a.KEY_GROUP_ID);     // Catch: Exception -> L213
        if ((!StringsKt.isBlank(r73)) == true) goto L133;
        r73 = null;
    L133:
        if (r73 != null) goto L137;
        r73 = r136.optString(com.bytedance.android.ec.core.event.a.KEY_GROUP_ID);     // Catch: Exception -> L106
    L137:
        if ((!StringsKt.isBlank(r73)) == true) goto L140;
        r73 = null;
    L140:
        if (r73 == null) goto L142;
        r123.put(com.bytedance.android.ec.core.event.a.KEY_GROUP_ID, r73);     // Catch: Exception -> L106
        r136.put(com.bytedance.android.ec.core.event.a.KEY_GROUP_ID, r73);     // Catch: Exception -> L106
    L142:
        if (r50 == null) goto L150;
        JSONObject r74 = jg.g.f(r50);     // Catch: Exception -> L106
        if (r74 == null) goto L150;
        Iterator<String> r75 = r74.keys();     // Catch: Exception -> L106
    L147:
        if (r75.hasNext() == false) goto L149;
        String r76 = r75.next();     // Catch: Exception -> L106
        r136.put(r76, r74.optString(r76));     // Catch: Exception -> L106
        goto L147
    L149:
        Unit r77 = Unit.INSTANCE;     // Catch: Exception -> L106
    L150:
        String r78 = r136.toString();     // Catch: Exception -> L213
        com.bytedance.android.btm.api.model.l r79 = r10;
        if (r10 != null) goto L155;
        com.bytedance.android.btm.api.model.d r80 = new com.bytedance.android.btm.api.model.d();     // Catch: Exception -> L106
        r80.b = PageFinder.via(r52);     // Catch: Exception -> L106
        r79 = r80;
    L155:
        String r81 = EcomBcmTracker.d(r79, r78);     // Catch: Exception -> L213
        if (r81 == null) goto L159;
        r78 = r81;
    L159:
        r123.put("cart_track", r78);     // Catch: Exception -> L213
        r123.put("btm_show_id", r122);     // Catch: Exception -> L213
        a(r52);     // Catch: Exception -> L213
        r125 = r310;
        r125.put(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, r78);     // Catch: Exception -> L211
        r312 = r123.toString();     // Catch: Exception -> L211
        r412 = r47;
    L164:
        r411 = r47;
    L163:
        r125 = r310;
        goto L164
    L118:
        r72 = null;
        goto L119
    L111:
        r71 = null;
        goto L112
    L96:
        r136 = new JSONObject(r134);     // Catch: Exception -> L212
    L227:
        r136 = new JSONObject();     // Catch: Exception -> L213
        goto L103
    L93:
        r135 = false;
    L99:
        r47 = "";
        goto L227
    L73:
        r132 = null;
        goto L75
    L66:
        r131 = null;
        goto L67
    L56:
        r124 = null;
    L165:
        r47 = "";
    L50:
        r122 = "";
    L45:
        r120 = PageFinder.via(r52);
        goto L46
    L40:
        r118 = r10;
        goto L41
    L36:
        r310 = r11;
        r21 = null;
    L6:
        r11 = new LinkedHashMap();
        goto L8
    }
}
