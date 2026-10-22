package qf;

import android.animation.AnimatorSet;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import cf.p;
import cf.t;
import cf.u;
import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import com.bytedance.android.btm.api.model.l;
import com.bytedance.android.ec.common.api.IECCommonService;
import com.bytedance.android.ec.common.api.image.IECImageOptService;
import com.bytedance.android.ec.common.api.image.IECImageService;
import com.bytedance.android.ec.common.api.marketing.IMarketingLiveLynxViewService;
import com.bytedance.android.ec.common.api.marketing.IMarketingRouterUtilsService;
import com.bytedance.android.ec.common.impl.hybrid.EShoppingBridgeProvider;
import com.bytedance.android.ec.common.impl.image.ECImageOptService;
import com.bytedance.android.ec.common.impl.image.ECImageService;
import com.bytedance.android.ec.common.impl.marketing.ECMarketingHybridLiveLynxViewService;
import com.bytedance.android.ec.common.impl.marketing.ECMarketingRouterUtilsService;
import com.bytedance.android.ec.common.impl.order.OpenOrderSchemaHelper;
import com.bytedance.android.ec.common.impl.order.OrderSchema;
import com.bytedance.android.ec.common.impl.sku.AddCartDirectlyHelper;
import com.bytedance.android.ec.common.impl.sku.SkuFragment;
import com.bytedance.android.ec.common.impl.sku.SkuPanelActivity;
import com.bytedance.android.ec.common.impl.sku.SkuPanelFragment;
import com.bytedance.android.ec.common.impl.sku.SkuPanelOptimizeFragment;
import com.bytedance.android.ec.common.impl.sku.utils.i;
import com.bytedance.android.ec.core.hybrid.ECBridgeProviderInjector;
import com.bytedance.android.ec.core.imagex.k0;
import com.bytedance.android.ec.core.imagex.l0;
import com.bytedance.android.ec.core.imagex.m0;
import com.bytedance.android.ec.core.monitor.ECProcessMonitor;
import com.bytedance.android.ec.core.utils.UrlBuilderV2;
import com.bytedance.android.ec.model.ECAdLogExtra;
import com.bytedance.android.ec.model.entranceinfo.EntranceInfoScene;
import com.bytedance.android.ec.model.order.IOrderSchema;
import com.bytedance.android.ec.model.promotion.ECResultDialogContentVO;
import com.bytedance.android.ec.model.promotion.ECUICampaign;
import com.bytedance.android.ec.model.response.ECPromotionCampaign;
import com.bytedance.android.ec.model.sku.SkuCartResult;
import com.bytedance.android.ec.model.sku.SkuCheckResult;
import com.bytedance.android.ec.model.sku.SkuExtraData;
import com.bytedance.android.ec.model.sku.SkuParams;
import com.bytedance.android.ec.model.sku.SkuProductDetailInfo;
import com.bytedance.android.ec.model.sku.SkuShowAndDismissState;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.api.IEShoppingService;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.optimize.statistics.FrescoMonitor;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.aweme.framework.services.ServiceProvider;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import jg.g;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements IECCommonService {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: qf.a$a, reason: collision with other inner class name */
    public static final class C0186a<T> implements ServiceProvider {
        public static final C0186a a = null;

        static {
            a = new C0186a();
        }

        public C0186a() {
        }

        public final Object get() {
            return new ECImageService();
        }
    }

    public static final class b<T> implements ServiceProvider {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final Object get() {
            return ECImageOptService.INSTANCE;
        }
    }

    public static final class c<T> implements ServiceProvider {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final Object get() {
            return new ECMarketingHybridLiveLynxViewService();
        }
    }

    public static final class d<T> implements ServiceProvider {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final Object get() {
            return new ECMarketingRouterUtilsService();
        }
    }

    public static final class e {
        public static boolean a(SkuParams r10) {
            Intrinsics.checkNotNullParameter(r10, "skuParams");
            if (rf.a.a() == 2) goto L7;
            if (rf.a.a() == 3) goto L7;
        L11:
            return false;
        L7:
            if (r10.getUsePrerenderSku() == false) goto L11;
            if (g.a(r10.getSkuPrerenderId()) == false) goto L11;
            return true;
        }
    }

    static {
    }

    @Override // com.bytedance.android.ec.common.api.IECCommonService
    public Map<String, String> getExplainReplayCommonParams() {
        return new HashMap();
    }

    public a() {
        EShoppingBridgeProvider r0 = EShoppingBridgeProvider.a;
        Lazy r1 = ECBridgeProviderInjector.b;
        ((CopyOnWriteArrayList) ECBridgeProviderInjector.a.a().a).add(r0);
        int r10 = l0.a;
        m0.c("ImageMonitorHook.injectMonitorHook");
        if (m0.a() == false) goto L9;
        com.bytedance.android.ec.core.imagex.c r11 = new com.bytedance.android.ec.core.imagex.c(new k0());
        Intrinsics.checkNotNullParameter(r11, "monitorHook");
        m0.c("ImageMonitorHook.registerMonitorHook");
        if (m0.a() == false) goto L9;
        FrescoMonitor.addMonitorHookV2(r11);
    L9:
        ServiceManager.get().bind(IECImageService.class, C0186a.a).asSingleton();
        ServiceManager.get().bind(IECImageOptService.class, b.a).asSingleton();
        ServiceManager.get().bind(IMarketingLiveLynxViewService.class, c.a).asSingleton();
        ServiceManager.get().bind(IMarketingRouterUtilsService.class, d.a).asSingleton();
    }

    @Override // com.bytedance.android.ec.common.api.IECCommonService
    public ECUICampaign convertCampaign(ECPromotionCampaign r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, "campaign");
        return ECUICampaign.convertCampaign(r10, r11);
    }

    @Override // com.bytedance.android.ec.common.api.IECCommonService
    public IOrderSchema convertToOrderSchema(Uri r10, EntranceInfoScene r11) {
        Intrinsics.checkNotNullParameter(r10, "uri");
        Intrinsics.checkNotNullParameter(r11, "entranceInfoScene");
        Intrinsics.checkNotNullParameter(r10, "originUri");
        Intrinsics.checkNotNullParameter(r11, "entranceInfoScene");
        return new OrderSchema(new UrlBuilderV2(r10), r11);
    }

    @Override // com.bytedance.android.ec.common.api.IECCommonService
    public p createPageStateListenerHelper(String r10, String r11) {
        return new zf.a(r10, r11);
    }

    @Override // com.bytedance.android.ec.common.api.IECCommonService
    public mf.a getOpenOrderSchemaHelper(Class<? extends mf.b> r10, Function0<? extends mf.b> r11) {
        Intrinsics.checkNotNullParameter(r10, "clazz");
        OpenOrderSchemaHelper.c.getClass();
        Intrinsics.checkNotNullParameter(r10, "clazz");
        Lazy r0 = OpenOrderSchemaHelper.b;
        if (((Map) r0.getValue()).get(r10) != null) goto L10;
        Map r1 = (Map) r0.getValue();
        if (r11 == null) goto L8;
        mf.b r12 = (mf.b) r11.invoke();
        if (r12 == null) goto L8;
    L9:
        r1.put(r10, new OpenOrderSchemaHelper(r12));
    L8:
        r12 = r10.newInstance();
    L10:
        Object r13 = ((Map) r0.getValue()).get(r10);
        Intrinsics.checkNotNull(r13);
        return (mf.a) r13;
    }

    @Override // com.bytedance.android.ec.common.api.IECCommonService
    public IOrderSchema convertToOrderSchema(String r10, EntranceInfoScene r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r11, "entranceInfoScene");
        return new OrderSchema(r10, r11);
    }

    @Override // com.bytedance.android.ec.common.api.IECCommonService
    public void buyNowDirectly(Context r33, SkuParams r34, String r35, long r36, String r38) {
        Intrinsics.checkNotNullParameter(r33, "context");
        Intrinsics.checkNotNullParameter(r34, "skuParams");
        Intrinsics.checkNotNullParameter(r35, "selectSkuId");
        int r10 = com.bytedance.android.ec.common.impl.sku.d.a;
        Intrinsics.checkNotNullParameter(r33, "context");
        Intrinsics.checkNotNullParameter(r34, "skuParams");
        Intrinsics.checkNotNullParameter(r35, "selectSkuId");
        JSONObject r0 = new JSONObject();
        r0.put("is_multi", false);
        ECAdLogExtra r1 = r34.getAdLogExtra();
        String r11 = null;
        if (r1 == null) goto L5;
        String r12 = r1.getCreativeId();
    L6:
        r0.putOpt(com.bytedance.android.ec.core.event.a.KEY_CREATIVE_ID, r12);
        r0.putOpt("cps_track", r34.getCpsTrack());
        String r25 = r0.toString();
        String r13 = r34.getPromotionId();
        String r14 = r34.getProductId();
        String r15 = r34.getAuthorId();
        String r16 = r34.getAuthorOpenId();
        String r17 = r34.getSecAuthorId();
        String r18 = r34.getRoomId();
        if (r34.isGroupingBuy() == false) goto L9;
        long r19 = 1;
    L10:
        long r110 = r19;
        int r111 = r34.getSceneType();
        int r112 = r34.getActionType();
        SkuExtraData r20 = r34.getSkuExtraData();
        if (r20 == null) goto L13;
        r11 = r20.getMarketChannel();
    L13:
        String r21 = r34.getEntranceInfo();
        String r22 = r34.getCombinationId();
        String r23 = String.valueOf(r34.getDefaultSelect());
        String r24 = r34.getItemId();
        String r26 = r34.getEnterFrom();
        bg4.b.b(eg.a.d(r13, r14, r15, r16, r17, r18, r110, r111, r112, null, r34.getReceiveAddressId(), r11, r21, r22, r23, r24, r26, r25, null, null, r34.getBizCampaignType(), r34.getTouTiaoAppId(), r34.getNGroupBuyToken(), 133726208)).subscribe(new com.bytedance.android.ec.common.impl.sku.c(r38, r33, r34, r35, r36));
        return;
    L9:
        r19 = 0;
        goto L10
    L5:
        r12 = null;
        goto L6
    }

    @Override // com.bytedance.android.ec.common.api.IECCommonService
    public void openBuyNowSchemaWidthRouterHelper(String r10, Activity r11, String r12, String r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r10, "orderUrl");
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        Intrinsics.checkNotNullParameter(r12, "packLogId");
        Intrinsics.checkNotNullParameter(r13, "skuLogId");
        int r0 = i.a;
        i.a(r10, r11, r12, r13, r14);
    }

    @Override // com.bytedance.android.ec.common.api.IECCommonService
    public void showResultDialog(Context r10, ECResultDialogContentVO r11, int r12, Function0<Unit> r13, Function0<Unit> r14, Function0<Unit> r15, Function0<Unit> r16) {
        Intrinsics.checkNotNullParameter(r10, "context");
        com.bytedance.android.ec.common.impl.view.a r0 = new com.bytedance.android.ec.common.impl.view.a(r10, r11, r12, r13, r14, r15, r16);
        if (DialogLancet.shouldBlockDialogShow(r0) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(r0);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(r0);
        r0.show();
        DialogLancet.afterDialogShow(r0);
    }

    @Override // com.bytedance.android.ec.common.api.IECCommonService
    public void addCartMotion(View r13, View r14, long r15, Integer r17, Boolean r18, View r19, Float r20, Float r21, AnimatorSet r22, Function0<Unit> r23) {
        Intrinsics.checkNotNullParameter(r13, "sourceView");
        Intrinsics.checkNotNullParameter(r14, "destinationView");
        ag.a.b(r13, r14, r15, r19, r20, r21, r17, r22, r18, r23);
    }

    @Override // com.bytedance.android.ec.common.api.IECCommonService
    public void addCartMotion(Context r10, float[] r11, float[] r12, long r13, View r14, Float r15, Float r16, Integer r17, AnimatorSet r18, Boolean r19, Function0<Unit> r110) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "sourceLocation");
        Intrinsics.checkNotNullParameter(r12, "destinationLocation");
        ag.a.a(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110);
    }

    @Override // com.bytedance.android.ec.common.api.IECCommonService
    public u showSkuPanel(FragmentManager r16, SkuParams r17, t r18, l r19, Function0<String> r20, Function2<? super SkuParams, ? super Long, Unit> r21, Function1<? super String, Unit> r22, Function1<? super SkuShowAndDismissState, Unit> r23, Function1<? super SkuProductDetailInfo, Unit> r24, Function1<? super SkuCartResult, Unit> r25, Function1<? super SkuCheckResult, Unit> r26, int r27, ul.i r28, Function0<Unit> r29, Context r30) {
        Intrinsics.checkNotNullParameter(r17, "skuParams");
        Intrinsics.checkNotNullParameter(r17, "skuParams");
        int r1 = ECSdk.a;
        IEShoppingService r10 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r10 == null) goto L5;
        sc3.i r11 = r10.getSkuYataService();
    L6:
        boolean r12 = true;
        if (r11 == null) goto L12;
        if (r11.c(r27, r17.getSceneType(), r17.getActionType()) != true) goto L12;
        boolean r13 = true;
    L13:
        Integer r14 = r17.getForceYataSku();
        if (r14 != null) goto L17;
    L19:
        boolean r15 = false;
    L20:
        String r31 = r17.getBizIdentifier();
        if (r31 != null) goto L23;
    L26:
        boolean r32 = true;
    L27:
        if (r32 == true) goto L34;
        if (r11 == null) goto L34;
        if (r11.l(r31) == false) goto L33;
        if (r15 == false) goto L33;
        r15 = true;
    L33:
        r15 = false;
    L34:
        if (r13 == false) goto L45;
        IEShoppingService r0 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r0 == null) goto L40;
        sc3.i r33 = r0.getSkuYataService();
        if (r33 == null) goto L40;
        com.bytedance.android.shopping.sku.inner.ultimate.c r34 = r33.k(r16, r17, r19, r18, r22, r23, r24, r27);
    L42:
        if ((r34 instanceof u) == true) goto L82;
        return null;
    L82:
        return r34;
    L40:
        r34 = null;
        goto L42
    L45:
        if (r11 == null) goto L47;
        boolean r35 = r11.b(r17.getSceneType());
    L48:
        if (r35 == true) goto L74;
        if (r15 == true) goto L74;
        if (r16 != null) goto L54;
        return null;
    L54:
        if (Intrinsics.areEqual(r17.getCreateNewActivity(), Boolean.TRUE) == false) goto L58;
        int r36 = SkuPanelActivity.a;
        Activity r37 = ECAppInfoService.e.getCurrentActivity();
        Intrinsics.checkNotNullParameter(r17, "skuParams");
        Intent r38 = new Intent(r37, SkuPanelActivity.class);
        Bundle r39 = new Bundle();
        r39.putSerializable("sku_param", r17);
        Unit r40 = Unit.INSTANCE;
        r38.putExtras(r39);
        if (r37 == null) goto L83;
        r37.startActivity(r38);
        return null;
    L83:
        return null;
    L58:
        Intrinsics.checkNotNullParameter(r17, "skuParams");
        if (rf.a.a() == 1) goto L63;
        if (rf.a.a() == 2) goto L63;
    L67:
        r12 = false;
    L68:
        if (r12 == false) goto L70;
        Map<String, SkuFragment> r41 = SkuFragment.w;
        r34 = SkuFragment.Companion.a(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
        goto L82
    L70:
        if (com.bytedance.android.ec.core.abtest.d.F() == 0) goto L72;
        SkuPanelOptimizeFragment.r.getClass();
        r34 = SkuPanelOptimizeFragment.b.a(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
        goto L82
    L72:
        SkuPanelFragment.r.getClass();
        r34 = SkuPanelFragment.b.a(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
    L63:
        if (r17.getUsePrerenderSku() == false) goto L67;
        if (g.a(r17.getSkuPrerenderId()) == false) goto L67;
    L74:
        IEShoppingService r42 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r42 == null) goto L79;
        sc3.i r43 = r42.getSkuYataService();
        if (r43 == null) goto L79;
        r34 = r43.i(r16, r17, r19, r18, r21, r22, r23, r24, r25, r26, r28, r29, r30);
    L81:
        if ((r34 instanceof u) == true) goto L82;
        return null;
    L79:
        r34 = null;
        goto L81
    L47:
        r35 = false;
        goto L48
    L23:
        if (r31.length() == 0) goto L26;
        r32 = false;
        goto L27
    L17:
        if (r14.intValue() != 1) goto L19;
        r15 = true;
    L12:
        r13 = false;
        goto L13
    L5:
        r11 = null;
        goto L6
    }

    @Override // com.bytedance.android.ec.common.api.IECCommonService
    public void addCartDirectly(Context r36, int r37, int r38, String r39, String r40, String r41, String r42, String r43, String r44, String r45, String r46, String r47, boolean r48, String r49, String r50, boolean r51, String r52, String r53, boolean r54, String r55, l r56, boolean r57, String r58, String r59, Integer r60, String r61, Integer r62, String r63, com.bytedance.android.ec.model.e r64, cf.a r65, Map<String, ? extends Object> r66, String r67, String r68, Function1<? super Integer, Unit> r69) {
        Intrinsics.checkNotNullParameter(r36, "context");
        Intrinsics.checkNotNullParameter(r39, "originType");
        Intrinsics.checkNotNullParameter(r40, "originId");
        Intrinsics.checkNotNullParameter(r41, "promotionId");
        Intrinsics.checkNotNullParameter(r42, "productId");
        Intrinsics.checkNotNullParameter(r43, "authorId");
        Intrinsics.checkNotNullParameter(r45, BdpAwemeConstant.KEY_ROOM_ID);
        Intrinsics.checkNotNullParameter(r46, "shopId");
        Intrinsics.checkNotNullParameter(r47, "trackExtra");
        int r18 = AddCartDirectlyHelper.a;
        Intrinsics.checkNotNullParameter(r36, "context");
        Intrinsics.checkNotNullParameter(r39, "originType");
        Intrinsics.checkNotNullParameter(r40, "originId");
        Intrinsics.checkNotNullParameter(r41, "promotionId");
        Intrinsics.checkNotNullParameter(r42, "productId");
        Intrinsics.checkNotNullParameter(r43, "authorId");
        Intrinsics.checkNotNullParameter(r45, BdpAwemeConstant.KEY_ROOM_ID);
        Intrinsics.checkNotNullParameter(r46, "shopId");
        Intrinsics.checkNotNullParameter(r47, "trackExtra");
        if (AddCartDirectlyHelper.c(r37) == false) goto L5;
        Set<String> r0 = ECProcessMonitor.a;
        int r10 = r37;
        boolean r11 = r57;
        ECProcessMonitor.d("ec_product_detail").j(r11, r10);
    L7:
        if (AddCartDirectlyHelper.b(r37) == false) goto L9;
        Set<String> r1 = ECProcessMonitor.a;
        ECProcessMonitor.d("ec_product_flow_page").j(r11, r10);
    L9:
        eg.a r12 = new eg.a();
        if (r53 != null) goto L12;
    L25:
        if (r48 == false) goto L27;
        long r13 = 1;
    L28:
        bg4.b.b(eg.a.d(r41, r42, r43, r61, r44, r45, r13, r37, 2, 1, r49, r50, null, null, null, null, null, null, r59, r60, r63, null, null, 936370176)).subscribe(new com.bytedance.android.ec.common.impl.sku.a(r38, r37, r12, r36, r39, r40, r41, r42, r43, r44, r45, r46, r62, r47, r51, r52, r54, r55, r56, r57, r58, r65, r69, r59, r60, r66, r67, r68, r63, r64));
        return;
    L27:
        r13 = 0;
        goto L28
    L12:
        if ((!StringsKt.isBlank(r53)) == false) goto L14;
        String r14 = r53;
    L15:
        if (r14 == null) goto L25;
        if (r44 != null) goto L19;
        String r16 = "";
    L20:
        if (r62 == null) goto L23;
        String r15 = String.valueOf(r62.intValue());
        if (r15 == null) goto L23;
    L24:
        AddCartDirectlyHelper.d(r38, r37, r12, null, r36, r39, r40, r41, r42, r43, r16, r45, r46, r53, r15, new String[0], r47, r51, r52, r54, r55, r56, r57, r58, r65, r69, r59, r60, r66, r67, r68, r63, r64);
        return;
    L23:
        r15 = "1";
        goto L24
    L19:
        r16 = r44;
        goto L20
    L14:
        r14 = null;
        goto L15
    L5:
        r10 = r37;
        r11 = r57;
        goto L7
    }
}
