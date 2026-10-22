package com.bytedance.android.live.recharge.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.annie.api.container.HybridDialog;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.ai.api.model.RechargeFeatureData;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.recharge.CustomRechargeDialogFragment;
import com.bytedance.android.live.recharge.RechargeDialogContext;
import com.bytedance.android.live.recharge.RechargeDialogFragmentV2;
import com.bytedance.android.live.recharge.adapter.RechargePagerAdapter;
import com.bytedance.android.live.recharge.core.RechargeServices;
import com.bytedance.android.live.recharge.model.ExchangeInfo;
import com.bytedance.android.live.recharge.panel.aio.CustomPanelMode;
import com.bytedance.android.live.recharge.panel.aio.IPanelProperties;
import com.bytedance.android.live.recharge.panel.aio.OneStepPayInfo;
import com.bytedance.android.live.recharge.platform.business.viewholder.RechargeItem;
import com.bytedance.android.live.recharge.trace.RechargeTraceStep;
import com.bytedance.android.livesdk.config.bi1;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdk.utils.u6;
import com.bytedance.android.livesdkapi.depend.model.IPrePayCashierInfo;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/recharge/widget/RechargeDealsWidget;", "Lcom/bytedance/android/live/recharge/widget/AbsRechargeWidget;", "Landroid/view/View$OnClickListener;", "Lax0/a;", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RechargeDealsWidget extends AbsRechargeWidget implements View.OnClickListener, ax0.a {
    public ViewPager i;
    public RechargePagerAdapter j;
    public boolean k;
    public boolean l;
    public boolean m;
    public com.bytedance.android.live.recharge.deal.f n;
    public int o;

    public static final class a implements DialogInterface.OnDismissListener {
        public final /* synthetic */ RechargeDealsWidget a;

        public a(RechargeDealsWidget r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r2) {
            this.a.h.getPopUpOrHideRechargePageEvent().onNext(Boolean.FALSE);
            this.a.h.getCustomRechargePageHideEvent().onNext(Unit.INSTANCE);
        }
    }

    public final int getLayoutId() {
        return 2131567261;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
    }

    public final void onUnload() {
    }

    public final void Aq() {
        if (this.k == true) goto L5;
        return;
    L5:
        if (this.l == false) goto L49;
        com.bytedance.android.live.revenue.core.a r0 = com.bytedance.android.live.revenue.core.util.k.a();
        if (r0 == null) goto L13;
        n01.a r3 = (n01.a) com.bytedance.android.live.revenue.core.util.f.c(r0, n01.a.class);
        if (r3 == null) goto L13;
        if (r3.a1() != true) goto L13;
        int r2 = com.bytedance.android.live.recharge.utils.m.a;
        com.bytedance.android.live.recharge.utils.m.p(r0, "recharge_show", "official", Integer.valueOf(wq()), this.g);
        return;
    L13:
        Pair[] r1 = new Pair[5];
        r1[0] = TuplesKt.to("is_first_recharge", String.valueOf(wq()));
        Gson r4 = new Gson();
        long r5 = ((Number) this.e.o.a).longValue();
        Iterable r7 = (Iterable) this.e.k.a;
        ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r9 = r7.iterator();
    L15:
        if (r9.hasNext() == false) goto L17;
        r8.add(Long.valueOf(((com.bytedance.android.live.recharge.deal.f) r9.next()).g()));
        goto L15
    L17:
        r1[1] = TuplesKt.to("recharge_feats", GsonProtectorUtils.toJson(r4, new RechargeFeatureData(r5, r8)));
        boolean r6 = this.e.d();
        String r10 = DataType.TRUE;
        if (r6 == false) goto L20;
        Object r12 = DataType.TRUE;
    L21:
        r1[2] = TuplesKt.to("is_include_discount_package", r12);
        if (com.bytedance.android.live.recharge.core.f.f(RechargeServices.b()).h() != true) goto L24;
        String r13 = "first_recharge";
    L25:
        r1[3] = TuplesKt.to("panel_type", r13);
        if (((Boolean) this.h.getRepository().u.a).booleanValue() == false) goto L28;
        Object r14 = DataType.TRUE;
    L29:
        r1[4] = TuplesKt.to("is_integration_recharge", r14);
        Map r15 = MapsKt.mutableMapOf(r1);
        HashMap r16 = new HashMap();
        int r17 = com.bytedance.android.live.recharge.utils.m.a;
        com.bytedance.android.live.recharge.utils.m.b(r16, this.h.getMDialogEntranceParams(), new Object[]{rw0.b.class, rw0.c.class});
        JsonObject r18 = new JsonObject();
        Iterator r19 = ((Iterable) this.h.getRepository().k.a).iterator();
    L31:
        if (r19.hasNext() == false) goto L38;
        com.bytedance.android.live.recharge.deal.f r20 = (com.bytedance.android.live.recharge.deal.f) r19.next();
        String r22 = String.valueOf(r20.g());
        com.bytedance.android.live.recharge.platform.business.model.diamond.g r23 = com.bytedance.android.live.recharge.deal.g.c(r20);
        if (r23 == null) goto L36;
        String r24 = r23.getDiamondDesc();
        if (r24 == null) goto L36;
    L37:
        r18.addProperty(r22, r24);
    L36:
        r24 = r20.d();
        goto L37
    L38:
        r15.put("badge_map", r18.toString());
        r15.putAll(r16);
        r15.putAll(this.h.getReportExtraInfo("livesdk_recharge_show"));
        if (((Boolean) this.h.getRepository().A.a).booleanValue() == true) goto L42;
        r10 = DataType.FALSE;
    L42:
        r15.put("is_diamond_cache", r10);
        int r25 = com.bytedance.android.live.recharge.utils.m.a;
        com.bytedance.android.live.recharge.utils.m.g("livesdk_recharge_show", "", "official", r15, this.g);
        com.bytedance.android.live.recharge.trace.g r26 = com.bytedance.android.live.recharge.trace.f.a;
        com.bytedance.android.live.recharge.trace.f.a(RechargeTraceStep.STEP_DEALS_LOADED, r15);
        return;
    L28:
        r14 = DataType.FALSE;
        goto L29
    L24:
        r13 = DataType.Normal;
        goto L25
    L20:
        r12 = DataType.FALSE;
        goto L21
    }

    @Override // com.bytedance.android.live.recharge.widget.AbsRechargeWidget
    public final void onDestroy() {
        super.onDestroy();
        this.k = false;
        this.l = false;
        this.m = false;
    }

    public RechargeDealsWidget(RechargeDialogContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.o = -1;
    }

    @Override // ax0.a
    public final void F7(RechargeItem r12) {
        Intrinsics.checkNotNullParameter(r12, "item");
        if ((r12 instanceof RechargeItem.a) == false) goto L5;
        return;
    L5:
        Context r13 = ((Widget) this).context;
        if (r13 != null) goto L8;
        return;
    L8:
        if (com.bytedance.android.live.recharge.panel.d.a == true) goto L10;
    L12:
        boolean r0 = false;
    L14:
        if (r0 == false) goto L29;
        Context r14 = ((Widget) this).context;
        RechargeDialogContext r1 = this.h;
        Intrinsics.checkNotNullParameter(r14, "context");
        Intrinsics.checkNotNullParameter(r1, "dialogContext");
        com.bytedance.android.live.recharge.a0 r3 = r1.getRepository();
        vw0.c r4 = new vw0.c();
        r4.l(((Boolean) r3.q.a).booleanValue());
        r4.k(((Boolean) r3.e.a).booleanValue());
        r4.j((List) r3.i.a);
        List r5 = (List) r3.g.a;
        r4.d(com.bytedance.android.live.recharge.deal.e.c(r5));
        r4.c(com.bytedance.android.live.recharge.deal.e.b(r5));
        IPanelProperties r6 = vw0.f.a();
        vw0.e.a(r6, r1.getPanelPropertiesProvider());
        Unit r7 = Unit.INSTANCE;
        r4.i(r6);
        ExchangeInfo r8 = (ExchangeInfo) r3.m.a;
        com.bytedance.android.live.recharge.h r9 = new com.bytedance.android.live.recharge.h();
        r9.a(r8.getExchangeBalance());
        r9.c(r8.getRebateLimit());
        r9.b(r8.getGiftAmount());
        r4.b(r9);
        boolean r10 = com.bytedance.android.live.recharge.panel.d.c;
        Object r15 = bi1.a(Boolean.valueOf(r10), Integer.valueOf(CustomPanelMode.INPUT.getMode()));
        Integer r16 = Integer.valueOf(CustomPanelMode.RECHARGE.getMode());
        if (r15 != null) goto L18;
        r15 = r16;
    L18:
        r4.h(((Number) r15).intValue());
        OneStepPayInfo r17 = new OneStepPayInfo();
        r17.b(((Boolean) r3.u.a).booleanValue());
        IPrePayCashierInfo r18 = ((com.bytedance.android.live.recharge.deal.i) r3.C.a).n();
        if (r18 == null) goto L21;
        int r19 = r18.getCustomOneStepPay();
    L22:
        r17.a(r19);
        r4.f(r17);
        r4.a(vw0.h.a(r1.getMDialogEntranceParams()));
        r4.g(GsonProtectorUtils.toJson(GsonHelper.get(), ((Map) r3.N.a).get(0L)));
        r4.e(((Boolean) r3.L.a).booleanValue());
        u6 r20 = new u6(com.bytedance.android.live.recharge.panel.d.b);
        if (r10 == false) goto L25;
        r20.b("show_mask", DataType.TRUE);
        r20.b("mask_bg_color", "00000080");
    L25:
        r20.d("url").b("initial_data", GsonProtectorUtils.toJson(GsonHelper.get(), r4));
        HybridDialog r110 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.hybrid.d.class).pn(r14, r20.c(), new b7.a(), null);
        if ((r110 instanceof HybridDialog) == false) goto L43;
        r110.T90(new com.bytedance.android.live.recharge.panel.c(new WeakReference(r1)));
    L43:
        zq(null, false);
        ex0.a r111 = (ex0.a) this.h.getRechargePanelScope().getValue();
        if (r111 == null) goto L48;
        com.bytedance.android.live.recharge.service.f r112 = (com.bytedance.android.live.recharge.service.f) com.bytedance.android.scope.m.e.d(r111, com.bytedance.android.live.recharge.service.f.class);
        if (r112 == null) goto L48;
        r112.d = System.currentTimeMillis();
    L48:
        com.bytedance.android.live.recharge.trace.session.a r113 = (com.bytedance.android.live.recharge.trace.session.a) this.h.getSession().getValue();
        if (r113 == null) goto L57;
        r113.c(com.bytedance.android.live.recharge.trace.session.d.i);
        return;
    L57:
        return;
    L21:
        r19 = OneStepPayInfo.OneStepPayType.UNKNOWN.getType();
        goto L22
    L29:
        int r2 = CustomRechargeDialogFragment.G;
        RechargeDialogContext r22 = this.h;
        a r23 = new a(this);
        boolean r24 = ((Boolean) r22.getRepository().q.a).booleanValue();
        int r25 = ((ExchangeInfo) this.e.m.a).getExchangeBalance();
        com.bytedance.android.live.recharge.model.d r26 = this.g;
        Intrinsics.checkNotNullParameter(r13, "context");
        Intrinsics.checkNotNullParameter(r22, "dialogContext");
        Intrinsics.checkNotNullParameter(r26, "rechargeDialogEntranceParams");
        CustomRechargeDialogFragment r114 = new CustomRechargeDialogFragment();
        r114.f = r22;
        r114.h = r23;
        r114.D = r24;
        r114.E = r25;
        r114.g = r26;
        FragmentActivity r27 = ((Widget) this).context;
        if (r27 == null) goto L52;
        if (r27.getSupportFragmentManager().findFragmentByTag("CustomRechargeDialogFragment") != null) goto L43;
        FragmentActivity r28 = ((Widget) this).context;
        if (r28 == null) goto L42;
        FragmentManager r29 = r28.getSupportFragmentManager();
        LandscapeRestrictionOperation r30 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r114, "CustomRechargeDialogFragment", r30);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r29, r114, r30) == false) goto L55;
    L40:
        this.h.getPopUpOrHideRechargePageEvent().onNext(Boolean.TRUE);
        goto L43
    L55:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L54
    L39:
        r114.show(r29, "CustomRechargeDialogFragment");
        goto L40
    L42:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L52:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L10:
        if (r2.a(com.bytedance.android.live.recharge.panel.d.b) == false) goto L12;
        r0 = true;
        goto L14
    }

    @Override // com.bytedance.android.live.recharge.widget.AbsRechargeWidget
    public final void onInit(Object[] r3) {
        this.i = findViewById(2131368569);
        RechargePagerAdapter r4 = new RechargePagerAdapter(this.h, this.i, this);
        this.j = r4;
        ViewPager r0 = this.i;
        if (r0 == null) goto L6;
        r0.setAdapter(r4);
        return;
    }

    @Override // com.bytedance.android.live.recharge.widget.AbsRechargeWidget
    public final void xq(com.bytedance.android.live.recharge.deal.i r18) {
        Intrinsics.checkNotNullParameter(r18, "dealSet");
        List r1 = CollectionsKt.toMutableList(r18.c());
        List r2 = r1;
        if (r2 != null) goto L5;
    L8:
        boolean r5 = true;
    L10:
        if (r5 == false) goto L12;
        this.h.getRepository().R.onNext(3);
        return;
    L12:
        this.m = false;
        if (this.n != null) goto L15;
    L20:
        long r7 = ((Number) this.e.c.a).longValue();
    L21:
        int r3 = r2.size();
        int r6 = 0;
    L22:
        ViewGroup.LayoutParams r9 = null;
        if (r6 >= r3) goto L29;
        if (r7 == ((com.bytedance.android.live.recharge.deal.f) ListProtector.get(r1, r6)).b()) goto L26;
        r6 = r6 + 1;
        goto L22
    L26:
        this.h.setDefaultSelectPrize(((com.bytedance.android.live.recharge.deal.f) ListProtector.get(r1, r6)).g());
    L45:
        boolean r4 = true;
    L47:
        if (r4 == true) goto L49;
        r7 = ((com.bytedance.android.live.recharge.deal.f) ListProtector.get(r1, 0)).b();
    L49:
        RechargePagerAdapter r8 = this.j;
        if (r8 == null) goto L95;
        Intrinsics.checkNotNullParameter(r1, "deals");
        Iterator r10 = ((Iterable) r8.e.getRepository().g.a).iterator();
        if (r10.hasNext() == true) goto L54;
        Object r12 = null;
    L63:
        com.bytedance.android.live.recharge.deal.d r13 = (com.bytedance.android.live.recharge.deal.d) r12;
        if (r13 == null) goto L66;
        Long r14 = Long.valueOf(r13.g);
    L67:
        if (r14 == null) goto L69;
        RechargeItem.CustomItem r15 = new RechargeItem.CustomItem(0);
        r8.b = r15;
        r15.b = r14.longValue();
    L69:
        ArrayList r16 = new ArrayList();
        List r17 = r1;
        ArrayList r19 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10));
        Iterator r20 = r17.iterator();
    L71:
        if (r20.hasNext() == false) goto L73;
        r19.add(new RechargeItem.a((com.bytedance.android.live.recharge.deal.f) r20.next()));
        goto L71
    L73:
        r16.addAll(r19);
        RechargeItem.CustomItem r22 = r8.b;
        if (r22 == null) goto L77;
        r16.add(r22);
    L77:
        if (r16.size() <= 9) goto L79;
        List<? extends List<? extends RechargeItem>> r23 = CollectionsKt.chunked(r16, 6);
    L80:
        r8.a = r23;
        r8.c = r7;
        List r24 = (List) CollectionsKt.firstOrNull(r23);
        if (r24 == null) goto L94;
        int r25 = (((r24.size() + 3) - 1) / 3) * RechargeDialogFragmentV2.n;
        ViewPager r26 = r8.f;
        if (r26 != null) goto L85;
    L86:
        ViewPager r27 = r8.f;
        if (r27 == null) goto L89;
        r9 = r27.getLayoutParams();
    L89:
        if (r9 == null) goto L91;
        r9.height = r25;
    L91:
        ViewPager r28 = r8.f;
        if (r28 == null) goto L94;
        r28.setLayoutParams(r9);
        goto L94
    L85:
        if (r26.getHeight() != r25) goto L86;
    L94:
        r8.notifyDataSetChanged();
        goto L95
    L79:
        r23 = CollectionsKt.chunked(r16, 9);
        goto L80
    L66:
        r14 = null;
        goto L67
    L54:
        r12 = r10.next();
        if (r10.hasNext() == false) goto L63;
        long r110 = ((com.bytedance.android.live.recharge.deal.d) r12).g;
    L58:
        Object r111 = r10.next();
        long r112 = ((com.bytedance.android.live.recharge.deal.d) r111).g;
        if (r110 <= r112) goto L62;
        r12 = r111;
        r110 = r112;
    L62:
        if (r10.hasNext() == true) goto L58;
    L95:
        this.k = true;
        Aq();
        return;
    L29:
        if (com.bytedance.android.live.recharge.utils.j.d().enableCacheWithStrategy() == true) goto L31;
    L46:
        this.h.setDefaultSelectPrize(((com.bytedance.android.live.recharge.deal.f) ListProtector.get(r1, 0)).g());
        r4 = false;
        goto L47
    L31:
        if (com.bytedance.android.live.recharge.utils.j.d().getEnableCacheDiamondReplace() == false) goto L46;
        com.bytedance.android.live.recharge.deal.f r29 = this.n;
        if (r29 == null) goto L46;
        if (this.o >= 0) goto L37;
    L39:
        boolean r30 = false;
    L40:
        if (r30 == true) goto L43;
        r29 = null;
    L43:
        if (r29 == null) goto L46;
        ListProtector.set(r1, this.o, r29);
        this.h.setDefaultSelectPrize(r29.g());
        goto L45
    L37:
        if (r1.size() <= this.o) goto L39;
        r30 = true;
        goto L40
    L15:
        if (com.bytedance.android.live.recharge.utils.j.d().enableCacheWithStrategy() == false) goto L20;
        com.bytedance.android.live.recharge.deal.f r32 = this.n;
        if (r32 == null) goto L19;
        r7 = r32.b();
        goto L21
    L19:
        r7 = ((Number) this.e.c.a).longValue();
        goto L21
    L5:
        if (r2.isEmpty() == true) goto L8;
        r5 = false;
        goto L10
    }

    @Override // com.bytedance.android.live.recharge.widget.AbsRechargeWidget
    public final void yq(long r1) {
        this.l = true;
        Aq();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zq(com.bytedance.android.live.recharge.deal.f r13, boolean r14) {
        if (r14 == true) goto L4;
    L6:
        this.m = true;
        Object r1 = null;
        if (r13 == null) goto L9;
        Integer r2 = Integer.valueOf(r13.e() + r13.h());
    L10:
        if (r13 == null) goto L12;
        String r3 = "official";
    L13:
        n01.a r4 = (n01.a) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), n01.a.class);
        if (r4 != null) goto L16;
    L36:
        long r6 = ((Number) this.e.c.a).longValue();
        if (r14 == false) goto L43;
        if (r13 != null) goto L40;
    L42:
        int r15 = 2;
    L44:
        Pair[] r7 = new Pair[8];
        r7[0] = TuplesKt.to("is_first_recharge", String.valueOf(wq()));
        if (r13 == null) goto L48;
        String r8 = String.valueOf(r13.h());
        if (r8 == null) goto L48;
    L49:
        r7[1] = TuplesKt.to("given_scores", r8);
        r7[2] = TuplesKt.to("is_default", String.valueOf(r15));
        if (com.bytedance.android.live.recharge.core.f.f(RechargeServices.b()).h() != true) goto L52;
        String r16 = "first_recharge";
    L53:
        r7[3] = TuplesKt.to("panel_type", r16);
        if (r13 == null) goto L56;
        Long r17 = Long.valueOf(r13.b());
    L57:
        if (r13 == null) goto L61;
        com.bytedance.android.live.recharge.deal.i r9 = r13.c();
        if (r9 == null) goto L61;
        Long r10 = Long.valueOf(r9.l());
    L62:
        boolean r18 = Intrinsics.areEqual(r17, r10);
        String r12 = DataType.TRUE;
        if (r18 == false) goto L65;
        Object r19 = DataType.TRUE;
    L66:
        r7[4] = TuplesKt.to("is_recommend_package", r19);
        if (this.e.d() == false) goto L69;
        Object r110 = DataType.TRUE;
    L70:
        r7[5] = TuplesKt.to("is_include_discount_package", r110);
        if (((Boolean) this.h.getRepository().u.a).booleanValue() == false) goto L73;
        Object r111 = DataType.TRUE;
    L74:
        r7[6] = TuplesKt.to("is_integration_recharge", r111);
        if (r13 == null) goto L78;
        String r112 = this.h.getDescription(r13);
        if (r112 == null) goto L78;
    L79:
        r7[7] = TuplesKt.to("deal_badge", r112);
        Map r113 = MapsKt.mutableMapOf(r7);
        HashMap r20 = new HashMap();
        int r114 = com.bytedance.android.live.recharge.utils.m.a;
        com.bytedance.android.live.recharge.utils.m.b(r20, this.h.getMDialogEntranceParams(), new Object[]{rw0.b.class, rw0.c.class});
        r113.putAll(r20);
        r113.putAll(this.h.getReportExtraInfo("livesdk_recharge_click"));
        if (((Boolean) this.h.getRepository().A.a).booleanValue() == true) goto L83;
        r12 = DataType.FALSE;
    L83:
        r113.put("is_diamond_cache", r12);
        if (r2 == null) goto L87;
        String r0 = String.valueOf(r2.intValue());
        if (r0 == null) goto L87;
    L88:
        if (r13 == null) goto L93;
        String r5 = String.valueOf(r13.g());
        if (r5 == null) goto L93;
        String r22 = r5;
    L94:
        com.bytedance.android.live.recharge.utils.m.f("livesdk_recharge_click", r0, r3, r22, r113, this.g);
        com.bytedance.android.live.recharge.trace.g r23 = com.bytedance.android.live.recharge.trace.f.a;
        Intrinsics.checkNotNullParameter(r3, "eventModule");
        Intrinsics.checkNotNullParameter(r113, "extra");
        Map r115 = MapsKt.toMutableMap(r113);
        r115.put("event_module", r3);
        if (r13 == null) goto L97;
        Long r24 = Long.valueOf(r13.b());
    L98:
        r115.put("diamond_id", String.valueOf(r24));
        if (r13 == null) goto L101;
        Integer r25 = Integer.valueOf(r13.e());
    L102:
        r115.put("diamond", String.valueOf(r25));
        if (r13 == null) goto L105;
        r1 = Integer.valueOf(r13.h());
    L105:
        r115.put("giving_count", String.valueOf(r1));
        com.bytedance.android.live.recharge.trace.f.a(RechargeTraceStep.STEP_CLICK_DEAL, r115);
        return;
    L101:
        r25 = null;
        goto L102
    L97:
        r24 = null;
    L93:
        r22 = "";
    L87:
        r0 = "";
    L78:
        r112 = "";
        goto L79
    L73:
        r111 = DataType.FALSE;
        goto L74
    L69:
        r110 = DataType.FALSE;
        goto L70
    L65:
        r19 = DataType.FALSE;
    L61:
        r10 = null;
        goto L62
    L56:
        r17 = null;
        goto L57
    L52:
        r16 = DataType.Normal;
    L48:
        r8 = "";
        goto L49
    L40:
        if (r6 != r13.b()) goto L42;
        r15 = 1;
        goto L44
    L43:
        r15 = 0;
        goto L44
    L16:
        if (r4.a1() != true) goto L36;
        com.bytedance.android.live.revenue.core.a r26 = com.bytedance.android.live.revenue.core.util.k.a();
        if (r26 == null) goto L107;
        int r116 = com.bytedance.android.live.recharge.utils.m.a;
        if (r2 == null) goto L25;
        String r27 = String.valueOf(r2.intValue());
        if (r27 == null) goto L25;
        String r28 = r27;
    L26:
        if (r13 == null) goto L31;
        String r29 = String.valueOf(r13.g());
        if (r29 == null) goto L31;
        String r30 = r29;
    L32:
        Integer r32 = Integer.valueOf(wq());
        if (r13 == null) goto L35;
        r1 = Long.valueOf(r13.h());
    L35:
        com.bytedance.android.live.recharge.utils.m.o(r26, "recharge_click", r28, r3, r30, r32, r1, this.g);
        return;
    L31:
        r30 = "";
    L25:
        r28 = "";
        goto L26
    L107:
        return;
    L12:
        r3 = "customized";
        goto L13
    L9:
        r2 = null;
        goto L10
    L4:
        if (this.m == false) goto L6;
    }

    @Override // ax0.a
    public final void bc(RechargeItem r6, boolean r7, int r8) {
        Intrinsics.checkNotNullParameter(r6, "item");
        boolean r0 = r6 instanceof RechargeItem.a;
        if (r0 == false) goto L6;
        com.bytedance.android.live.recharge.deal.f r9 = ((RechargeItem.a) r6).a;
    L8:
        if (r9 != null) goto L11;
        return;
    L11:
        if (((Boolean) this.h.isBatchQueryLoading().a).booleanValue() == false) goto L14;
        this.h.getRepository().R.onNext(12);
        return;
    L14:
        if (r7 == false) goto L16;
    L22:
        this.h.setSelectedDeal(r9);
        this.h.getDealsSelectedEvent().onNext(Unit.INSTANCE);
        qw0.a r10 = (qw0.a) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), qw0.a.class);
        if (r10 == null) goto L25;
        r10.Ue(rw0.g.class, new rw0.h(new rw0.g(r9)));
    L25:
        if (r0 == false) goto L30;
        zq(r9, r7);
        return;
    L30:
        return;
    L16:
        if (com.bytedance.android.live.recharge.utils.j.d().enableCacheWithStrategy() == false) goto L22;
        this.n = r9;
        this.o = r8;
        if (((Boolean) this.h.getRepository().u.a).booleanValue() == true) goto L22;
        if (com.bytedance.android.live.recharge.utils.j.d().getEnableRechargeBtnClick() == true) goto L22;
        RechargeDialogContext r12 = this.h;
        r12.setDiamondDataAvailable(true);
        r12.isPreQueryInfo().a(Boolean.FALSE);
        goto L22
    L6:
        if ((r6 instanceof RechargeItem.CustomItem) == false) goto L29;
        r9 = com.bytedance.android.live.recharge.deal.j.a((com.bytedance.android.live.recharge.deal.i) this.e.C.a, ((RechargeItem.CustomItem) r6).a, true, 4);
        goto L8
    L29:
        throw new NoWhenBranchMatchedException();
    }
}
