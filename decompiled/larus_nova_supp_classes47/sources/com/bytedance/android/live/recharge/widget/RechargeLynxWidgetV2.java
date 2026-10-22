package com.bytedance.android.live.recharge.widget;

import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.recharge.RechargeDialogContext;
import com.bytedance.android.live.recharge.jsbridge.LiveCloseRechargeBannerResultModel;
import com.bytedance.android.live.recharge.platform.model.DiamondExtraInfo;
import com.bytedance.android.live.recharge.platform.model.DiamondExtraListResult;
import com.bytedance.android.live.recharge.platform.model.RechargeBannerInfo;
import com.bytedance.android.live.recharge.r0;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/recharge/widget/RechargeLynxWidgetV2;", "Lcom/bytedance/android/live/recharge/widget/AbsRechargeWidget;", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RechargeLynxWidgetV2 extends AbsRechargeWidget {
    public final CompositeDisposable i;
    public boolean j;
    public boolean k;
    public String l;
    public DiamondExtraListResult m;
    public zy0.b n;

    public static final class a implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ RechargeLynxWidgetV2 a;

        /* JADX INFO: renamed from: com.bytedance.android.live.recharge.widget.RechargeLynxWidgetV2$a$a, reason: collision with other inner class name */
        public static final class C0077a extends pw0.a<pw0.c, LiveCloseRechargeBannerResultModel> {
            public final /* synthetic */ a a;

            public C0077a(a r1) {
                this.a = r1;
            }

            public final void invoke(Object r5, CallContext r6) {
                pw0.c r7 = (pw0.c) r5;
                Intrinsics.checkNotNullParameter(r7, "params");
                Intrinsics.checkNotNullParameter(r6, "context");
                int r8 = com.bytedance.android.live.revenue.common.v.a;
                com.bytedance.android.live.revenue.common.v.b("ttlive_recharge", "dismiss from Lynx, reason=" + r7.a(), null);
                int r9 = com.bytedance.android.live.recharge.viewmodel.a.a;
                com.bytedance.tools.kcp.spongepreference.runtime.a r10 = r0.f;
                KProperty[] r12 = r0.a;
                r10.setValue(null, r12[4], 0L);
                r0.g.setValue(null, r12[5], 0);
                this.a.a.zq();
            }
        }

        public a(RechargeLynxWidgetV2 r1) {
            this.a = r1;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new C0077a(this);
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ RechargeLynxWidgetV2 a;

        public b(RechargeLynxWidgetV2 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            this.a.m = (DiamondExtraListResult) r2;
            int r3 = com.bytedance.android.live.revenue.common.v.a;
            com.bytedance.android.live.revenue.common.v.e("ttlive_recharge", "load diamond extra data");
            RechargeLynxWidgetV2 r4 = this.a;
            r4.k = true;
            r4.Aq();
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ RechargeLynxWidgetV2 a;

        public c(RechargeLynxWidgetV2 r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            int r0 = com.bytedance.android.live.revenue.common.v.a;
            StringBuilder r1 = new StringBuilder("diamond extra error:");
            if (r4 == null) goto L5;
            String r5 = r4.getMessage();
        L6:
            r1.append(r5);
            com.bytedance.android.live.revenue.common.v.b("ttlive_recharge", r1.toString(), null);
            this.a.zq();
            return;
        L5:
            r5 = null;
            goto L6
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ RechargeLynxWidgetV2 a;

        public d(RechargeLynxWidgetV2 r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            RechargeDialogContext r0 = this.a.h;
            Map r5 = ((cq2.d) r4).getParams();
            Object r1 = null;
            if (r5 == null) goto L5;
            Object r6 = r5.get("promotionId");
        L7:
            if ((r6 instanceof String) == false) goto L10;
            r1 = r6;
        L10:
            String r2 = (String) r1;
            if (r2 != null) goto L13;
            r2 = "";
        L13:
            r0.setPromotionId(r2);
            return;
        L5:
            r6 = null;
            goto L7
        }
    }

    public final int getLayoutId() {
        return 2131567264;
    }

    @Override // com.bytedance.android.live.recharge.widget.AbsRechargeWidget
    public final void yq(long r1) {
    }

    public final void Aq() {
        if (((Widget) this).context != null) goto L5;
        return;
    L5:
        int r1 = com.bytedance.android.live.revenue.common.v.a;
        com.bytedance.android.live.revenue.common.v.e("ttlive_recharge", "bannerUrlReady=" + this.j + ", bannerDataReady=" + this.k);
        if (this.j == true) goto L8;
        return;
    L8:
        if (this.k == false) goto L125;
        String r2 = this.l;
        boolean r3 = true;
        int r4 = 0;
        if (r2 != null) goto L13;
    L16:
        boolean r5 = true;
    L17:
        long r6 = 0;
        ViewGroup.LayoutParams r9 = null;
        if (r5 == true) goto L114;
        DiamondExtraListResult r7 = this.m;
        if (r7 == null) goto L114;
        List<DiamondExtraInfo> r8 = r7.getDiamondExtraList();
        if (r8 == null) goto L114;
        if (r8.isEmpty() == true) goto L114;
        zy0.b r10 = this.n;
        if (r10 == null) goto L33;
        DiamondExtraListResult r12 = this.m;
        xy0.a<?> r13 = r10.g();
        if (r13 == null) goto L31;
        r13.sendJsEvent("updateRechargeBannerData", MapsKt.mapOf(TuplesKt.to("banner_data", GsonProtectorUtils.toJson(GsonHelper.get(), r12))));
    L31:
        com.bytedance.android.live.revenue.common.v.e("ttlive_recharge", "hybrid card exists, card=" + this.n);
        return;
    L33:
        String r14 = this.l;
        HashMap r15 = new HashMap();
        r15.put("type", DataType.TRUE);
        r15.put("entrance", "2");
        r15.put("banner_data", GsonProtectorUtils.toJson(GsonHelper.get(), this.m));
        r15.put("live_recharge_banner_opt_enable", "true");
        Unit r16 = Unit.INSTANCE;
        String r17 = "";
        if (r14 == null) goto L47;
        Uri r18 = UriProtector.parse(r14);
        ArrayList r19 = new ArrayList();
        r19.add("url");
        r19.add("fallback_url");
        Uri.Builder r110 = com.bytedance.android.live.recharge.util.c.b(r18, r19).buildUpon();
        if (TextUtils.isEmpty(UriProtector.getQueryParameter(r18, "url")) == true) goto L39;
        String r111 = UriProtector.getQueryParameter(r18, "url");
    L40:
        r110.appendQueryParameter("url", com.bytedance.android.live.recharge.util.c.a(r111, r15));
        String r20 = UriProtector.getQueryParameter(r18, "fallback_url");
        if (TextUtils.isEmpty(r20) == true) goto L46;
        Uri r22 = UriProtector.parse(r20);
        ArrayList r112 = new ArrayList();
        r112.add("url");
        Uri.Builder r113 = com.bytedance.android.live.recharge.util.c.b(r22, r112).buildUpon();
        if (TextUtils.isEmpty(UriProtector.getQueryParameter(r22, "url")) == true) goto L45;
        r17 = UriProtector.getQueryParameter(r22, "url");
    L45:
        r113.appendQueryParameter("url", com.bytedance.android.live.recharge.util.c.a(r17, r15));
        r110.appendQueryParameter("fallback_url", r113.toString());
    L46:
        r17 = r110.toString();
        goto L47
    L39:
        r111 = "";
    L47:
        Uri r23 = UriProtector.parse(r17);
        String r114 = UriProtector.getQueryParameter(r23, "url");
        if (r114 != null) goto L50;
    L53:
        if (r3 == false) goto L56;
        com.bytedance.android.live.revenue.common.v.b("ttlive_recharge", "dismiss banner, url is empty", null);
        zq();
        return;
    L56:
        long r24 = System.currentTimeMillis();
        if (((Boolean) com.bytedance.android.live.recharge.utils.j.v.getValue(null, com.bytedance.android.live.recharge.utils.j.a[19])).booleanValue() == false) goto L59;
        this.n = ((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).q8(((Widget) this).context, r23, new RechargeLynxWidgetV2$handleLynxBanner$1(r24));
    L60:
        zy0.b r25 = this.n;
        if (r25 == null) goto L65;
        xy0.a<?> r26 = r25.g();
        if (r26 == null) goto L65;
        r26.registerMethod("live.closeRechargeBanner", new a(this));
    L65:
        zy0.b r27 = this.n;
        if (r27 == null) goto L73;
        xy0.a<?> r28 = r27.g();
        if (r28 == null) goto L72;
        View r29 = r28.getHybridView();
        if (r29 == null) goto L72;
        r29.setFocusable(false);
    L72:
        r27.c().setFocusable(false);
    L73:
        ViewGroup r30 = ((Widget) this).containerView;
        if (r30 == null) goto L108;
        zy0.b r32 = this.n;
        if (r32 == null) goto L78;
        View r33 = r32.c();
    L79:
        r30.addView(r33);
        r30.setFocusable(false);
        UtilityKotlinExtentionsKt.w(r30);
        ViewGroup r34 = ((Widget) this).containerView;
        if (r34 == null) goto L107;
        ViewGroup.LayoutParams r35 = r34.getLayoutParams();
        if (r35 == null) goto L107;
        String r36 = UriProtector.getQueryParameter(r23, "height");
        if (r36 == null) goto L88;
        Integer r37 = StringsKt.toIntOrNull(r36);
        if (r37 == null) goto L88;
        r4 = r37.intValue();
    L88:
        r35.height = s1.f(r4);
        int r38 = com.bytedance.android.live.recharge.viewmodel.a.a;
        DiamondExtraListResult r39 = this.m;
        if (r39 == null) goto L106;
        Intrinsics.checkNotNullParameter(r39, "$this$getValidTime");
        List<DiamondExtraInfo> r40 = r39.getDiamondExtraList();
        if (r40 == null) goto L106;
        Iterator<T> r42 = r40.iterator();
    L93:
        long r115 = 0;
    L95:
        if (r42.hasNext() == false) goto L105;
        DiamondExtraInfo r116 = (DiamondExtraInfo) r42.next();
        RechargeBannerInfo r117 = r116.getRechargeBannerInfo();
        if (r117 == null) goto L99;
        long r118 = r117.getValidEndTime();
    L101:
        if (r118 <= r115) goto L95;
        RechargeBannerInfo r119 = r116.getRechargeBannerInfo();
        if (r119 == null) goto L93;
        r115 = r119.getValidEndTime();
        goto L95
    L99:
        r118 = 0;
        goto L101
    L105:
        r6 = r115;
    L106:
        com.bytedance.tools.kcp.spongepreference.runtime.a r43 = r0.g;
        KProperty[] r120 = r0.a;
        r43.setValue(null, r120[5], Integer.valueOf(r4));
        r0.f.setValue(null, r120[4], Long.valueOf(r6));
        Unit r44 = Unit.INSTANCE;
        r9 = r35;
    L107:
        r30.setLayoutParams(r9);
        goto L108
    L78:
        r33 = null;
    L108:
        zy0.b r45 = this.n;
        if (r45 == null) goto L122;
        xy0.a<?> r46 = r45.g();
        if (r46 == null) goto L123;
        r46.load();
        return;
    L123:
        return;
    L122:
        return;
    L59:
        this.n = ((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).J8(((Widget) this).context, r23, new RechargeLynxWidgetV2$handleLynxBanner$2(r24));
        goto L60
    L50:
        if (StringsKt.isBlank(r114) == true) goto L53;
        r3 = false;
    L114:
        zq();
        int r47 = com.bytedance.android.live.recharge.viewmodel.a.a;
        com.bytedance.tools.kcp.spongepreference.runtime.a r48 = r0.f;
        KProperty[] r49 = r0.a;
        r48.setValue(null, r49[4], 0L);
        r0.g.setValue(null, r49[5], 0);
        com.bytedance.android.live.revenue.common.v.b("ttlive_recharge", "dismiss banner, bannerLynxUrl=" + this.l + ", diamondExtraList=" + this.m + ", bannerLynxUrl=" + this.l, null);
        return;
    L13:
        if (r2.length() == 0) goto L16;
        r5 = false;
        goto L17
    }

    public final void onUnload() {
        this.i.clear();
        this.j = false;
        this.k = false;
        zq();
    }

    public final void zq() {
        ((Widget) this).containerView.removeAllViews();
        UtilityKotlinExtentionsKt.t(((Widget) this).containerView);
        zy0.b r0 = this.n;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.n = null;
    }

    public RechargeLynxWidgetV2(RechargeDialogContext r2) {
        Intrinsics.checkNotNullParameter(r2, "dialogContext");
        super(r2);
        this.i = new CompositeDisposable();
    }

    @Override // com.bytedance.android.live.recharge.widget.AbsRechargeWidget
    public final void onLoad(Object[] r12) {
        super.onLoad(r12);
        int r13 = com.bytedance.android.live.revenue.common.v.a;
        com.bytedance.android.live.revenue.common.v.e("ttlive_recharge", "load recharge lynx widget v2");
        this.h.getRepository().b();
        RxUtilKt.c(this.h.getRepository().I.subscribe(new b(this), new c(this)), this.i);
        int r0 = com.bytedance.android.live.recharge.viewmodel.a.a;
        if (((Boolean) com.bytedance.android.live.recharge.utils.j.w.getValue(null, com.bytedance.android.live.recharge.utils.j.a[20])).booleanValue() == false) goto L9;
        long r5 = System.currentTimeMillis() / ((long) WebcastRedirectException.UNKNOWN);
        com.bytedance.tools.kcp.spongepreference.runtime.a r1 = r0.f;
        KProperty[] r7 = r0.a;
        if (r5 >= ((Number) r1.getValue(null, r7[4])).longValue()) goto L9;
        if (((Number) r0.g.getValue(null, r7[5])).intValue() <= 0) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == false) goto L14;
        com.bytedance.android.live.revenue.common.v.b("ttlive_recharge", "load banner container with cache", null);
        ViewGroup r14 = ((Widget) this).containerView;
        if (r14 == null) goto L17;
        UtilityKotlinExtentionsKt.w(r14);
        ViewGroup.LayoutParams r3 = r14.getLayoutParams();
        r3.height = s1.f(((Number) r0.g.getValue(null, r0.a[5])).intValue());
        Unit r4 = Unit.INSTANCE;
        r14.setLayoutParams(r3);
    L17:
        RxUtilKt.c(vh6.c.b(com.bytedance.android.livesdk.revenue.service.hybrid.d.class).registerJsEventSubscriber("dou_pay_banner_show").observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this)), this.i);
        return;
    L14:
        com.bytedance.tools.kcp.spongepreference.runtime.a r15 = r0.f;
        KProperty[] r6 = r0.a;
        r15.setValue(null, r6[4], 0L);
        r0.g.setValue(null, r6[5], 0);
        ViewGroup r16 = ((Widget) this).containerView;
        if (r16 == null) goto L17;
        UtilityKotlinExtentionsKt.t(r16);
    L9:
        r2 = false;
        goto L10
    }

    @Override // com.bytedance.android.live.recharge.widget.AbsRechargeWidget
    public final void xq(com.bytedance.android.live.recharge.deal.i r2) {
        Intrinsics.checkNotNullParameter(r2, "dealSet");
        this.l = r2.g();
        this.j = true;
        Aq();
    }
}
