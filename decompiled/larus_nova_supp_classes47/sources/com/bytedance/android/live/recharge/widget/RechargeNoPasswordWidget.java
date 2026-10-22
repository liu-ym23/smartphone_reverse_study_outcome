package com.bytedance.android.live.recharge.widget;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.gift.IGiftService;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.recharge.RechargeDialogContext;
import com.bytedance.android.live.recharge.core.RechargeServices;
import com.bytedance.android.live.recharge.nopassword.NoPasswordScene;
import com.bytedance.android.live.recharge.platform.model.NoPasswordGuideSource;
import com.bytedance.android.live.recharge.platform.model.NoPasswordPayType;
import com.bytedance.android.live.recharge.trace.RechargeTraceStep;
import com.bytedance.android.live.recharge.utils.RechargeMonitorService;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.utils.e4;
import com.bytedance.android.livesdk.utils.r3;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/recharge/widget/RechargeNoPasswordWidget;", "Lcom/bytedance/android/live/recharge/widget/AbsRechargeWidget;", "a", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RechargeNoPasswordWidget extends AbsRechargeWidget {
    public static final /* synthetic */ int O = 0;
    public long A;
    public boolean B;
    public boolean C;
    public TextView D;
    public TextView E;
    public TextView F;
    public int G;
    public int H;
    public HSImageView I;
    public HSImageView J;
    public FrameLayout K;
    public boolean L;
    public ConstraintLayout M;
    public b N;
    public View i;
    public TextView j;
    public TextView k;
    public final String l;
    public TextView m;
    public TextView n;
    public ViewGroup o;
    public HSImageView p;
    public TextView q;
    public TextView r;
    public TextView s;
    public ViewGroup t;
    public ViewGroup u;
    public ViewGroup v;
    public HSImageView w;
    public HSImageView x;
    public HSImageView y;
    public View z;

    public static final class a {
    }

    public static final class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ RechargeNoPasswordWidget a;

        public b(RechargeNoPasswordWidget r1) {
            this.a = r1;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            RechargeNoPasswordWidget r0 = this.a;
            RechargeDialogContext r1 = r0.h;
            ConstraintLayout r2 = r0.M;
            if (r2 == null) goto L5;
            int r3 = r2.getHeight();
        L6:
            r1.setNoPasswordDialogHeight(r3);
            return;
        L5:
            r3 = 0;
            goto L6
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ RechargeNoPasswordWidget a;

        public c(RechargeNoPasswordWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            RechargeNoPasswordWidget.Fq(this.a, true);
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ RechargeNoPasswordWidget a;

        public d(RechargeNoPasswordWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            RechargeNoPasswordWidget r3 = this.a;
            int r0 = RechargeNoPasswordWidget.O;
            r3.Bq();
            RechargeNoPasswordWidget.Fq(this.a, true);
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ RechargeNoPasswordWidget a;

        public e(RechargeNoPasswordWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            RechargeNoPasswordWidget r3 = this.a;
            int r0 = RechargeNoPasswordWidget.O;
            r3.Cq();
            RechargeNoPasswordWidget.Fq(this.a, true);
        }
    }

    public static final class f implements View.OnClickListener {
        public final /* synthetic */ RechargeNoPasswordWidget a;

        public f(RechargeNoPasswordWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.h.getDismissEvent().onNext(Unit.INSTANCE);
        }
    }

    public static final class g implements View.OnClickListener {
        public final /* synthetic */ RechargeNoPasswordWidget a;

        public g(RechargeNoPasswordWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.h.getDismissEvent().onNext(Unit.INSTANCE);
        }
    }

    public static final class h implements View.OnClickListener {
        public final /* synthetic */ RechargeNoPasswordWidget a;

        public h(RechargeNoPasswordWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            RechargeNoPasswordWidget.Fq(this.a, true);
        }
    }

    public static final class i implements View.OnClickListener {
        public final /* synthetic */ RechargeNoPasswordWidget a;

        public i(RechargeNoPasswordWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            RechargeNoPasswordWidget.zq(this.a, true);
        }
    }

    public static final class j implements View.OnClickListener {
        public final /* synthetic */ RechargeNoPasswordWidget a;

        public j(RechargeNoPasswordWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            RechargeNoPasswordWidget.zq(this.a, false);
        }
    }

    public static final class k<T> implements Consumer {
        public final /* synthetic */ RechargeNoPasswordWidget a;

        public k(RechargeNoPasswordWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            if (((Boolean) r2).booleanValue() == false) goto L6;
            RechargeNoPasswordWidget.Fq(this.a, true);
            return;
        }
    }

    static {
    }

    public final int getLayoutId() {
        return 2131567265;
    }

    @Override // com.bytedance.android.live.recharge.widget.AbsRechargeWidget
    public final void xq(com.bytedance.android.live.recharge.deal.i r2) {
        Intrinsics.checkNotNullParameter(r2, "dealSet");
    }

    public final void Aq() {
        NoPasswordScene r0 = this.h.getNoPasswordScene();
        NoPasswordScene r1 = NoPasswordScene.SCENE_FANS_CLUB_JOIN;
        if (r0 != r1) goto L5;
    L14:
        TextView r2 = this.j;
        if (r2 == null) goto L17;
        r2.setText(s1.B(2131921899));
    L17:
        long r3 = com.bytedance.android.live.recharge.nopassword.d.a.b;
        long r4 = this.c;
        if (r4 < r3) goto L21;
        r3 = r4;
    L21:
        this.A = r3;
        TextView r5 = this.k;
        if (r5 == null) goto L24;
        r5.setText(String.valueOf(r3));
    L24:
        TextView r6 = this.m;
        if (r6 == null) goto L27;
        r6.setText(this.l);
    L27:
        long r7 = ((Number) this.e.o.a).longValue();
        long r8 = this.A;
        long r9 = r8 / 10;
        long r10 = r8 % 10;
        if (r10 != 0) goto L30;
        StringBuilder r12 = new StringBuilder();
        r12.append(r9);
        r12.append(20803);
        String r13 = r12.toString();
    L31:
        TextView r14 = this.n;
        if (r14 == null) goto L35;
        r14.setText(s1.C(2131921901, new Object[]{r7 + this.l, this.A + this.l, r13}));
    L35:
        if (this.h.getNoPasswordScene() != r1) goto L39;
        TextView r15 = this.q;
        if (r15 == null) goto L43;
        r15.setText(s1.C(2131921902, new Object[]{r13}));
        return;
    L43:
        return;
    L39:
        TextView r16 = this.q;
        if (r16 == null) goto L45;
        r16.setText(s1.C(2131921897, new Object[]{r13}));
        return;
    L45:
        return;
    L30:
        StringBuilder r17 = new StringBuilder();
        r17.append(r9);
        r17.append('.');
        r17.append(r10);
        r17.append(20803);
        r13 = r17.toString();
        goto L31
    L5:
        if (this.h.getNoPasswordScene() == NoPasswordScene.SCENE_FANS_CLUB_SEND_GIFT) goto L14;
        com.bytedance.android.live.recharge.model.b r18 = this.h.getMDialogEntranceParams().j;
        if (r18 == null) goto L17;
        h2 r19 = jc1.k.n(IGiftService.class).findLiteGiftById(r18.e);
        if (r19 == null) goto L17;
        TextView r20 = this.j;
        if (r20 == null) goto L17;
        r20.setText(r19.getName());
        goto L17
    }

    public final void Bq() {
        this.G = 206;
        TextView r0 = this.D;
        if (r0 == null) goto L5;
        r0.setText(s1.B(2131921898));
    L5:
        HSImageView r1 = this.p;
        if (r1 == null) goto L8;
        r1.setActualImageResource(2131252749);
    L8:
        HSImageView r2 = this.w;
        if (r2 == null) goto L11;
        r2.setActualImageResource(2131252752);
    L11:
        HSImageView r3 = this.x;
        if (r3 == null) goto L15;
        r3.setActualImageResource(2131252753);
        return;
    }

    public final void Cq() {
        this.G = 201;
        TextView r0 = this.D;
        if (r0 == null) goto L5;
        r0.setText(s1.B(2131921904));
    L5:
        HSImageView r1 = this.p;
        if (r1 == null) goto L8;
        r1.setActualImageResource(2131252754);
    L8:
        HSImageView r2 = this.x;
        if (r2 == null) goto L11;
        r2.setActualImageResource(2131252752);
    L11:
        HSImageView r3 = this.w;
        if (r3 == null) goto L15;
        r3.setActualImageResource(2131252753);
        return;
    }

    public final void onUnload() {
        ViewTreeObserver r0 = ((Widget) this).containerView.getViewTreeObserver();
        b r1 = this.N;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mLayoutListener");
    L5:
        r0.removeOnGlobalLayoutListener(r1);
    }

    public RechargeNoPasswordWidget(RechargeDialogContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.l = r3.b();
        this.G = 206;
        this.H = 206;
    }

    @Override // com.bytedance.android.live.recharge.widget.AbsRechargeWidget
    public final void onInit(Object[] r3) {
        this.j = (TextView) findViewById(2131388772);
        this.k = (TextView) findViewById(2131368995);
        this.n = (TextView) findViewById(2131368997);
        this.m = (TextView) findViewById(2131368316);
        ViewGroup r4 = (ViewGroup) findViewById(2131381999);
        this.o = r4;
        if (r4 == null) goto L5;
        r4.setVisibility(8);
    L5:
        TextView r0 = (TextView) findViewById(2131382005);
        this.p = findViewById(2131382004);
        this.q = (TextView) findViewById(2131391976);
        this.r = (TextView) findViewById(2131393309);
        this.s = (TextView) findViewById(2131383403);
        this.t = (ViewGroup) findViewById(2131381998);
        this.u = (ViewGroup) findViewById(2131382003);
        this.v = (ViewGroup) findViewById(2131382011);
        this.w = findViewById(2131385791);
        this.x = findViewById(2131385823);
        this.y = findViewById(2131382002);
        this.z = findViewById(2131387138);
        this.D = (TextView) findViewById(2131382005);
        this.i = findViewById(2131367009);
        this.F = (TextView) findViewById(2131383975);
        this.E = (TextView) findViewById(2131383935);
        this.I = findViewById(2131367003);
        this.J = findViewById(2131368998);
        this.K = (FrameLayout) findViewById(2131383888);
        this.M = findViewById(2131380937);
        this.N = new b(this);
        ViewTreeObserver r5 = ((Widget) this).containerView.getViewTreeObserver();
        b r1 = this.N;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mLayoutListener");
    L8:
        r5.addOnGlobalLayoutListener(r1);
        ImageUtil.loadImage(this.J, r3.a(), 0);
        HSImageView r6 = this.y;
        if (r6 == null) goto L11;
        r6.setOnClickListener(new c(this));
    L11:
        ViewGroup r7 = this.u;
        if (r7 == null) goto L14;
        r7.setOnClickListener(new d(this));
    L14:
        ViewGroup r8 = this.v;
        if (r8 == null) goto L17;
        r8.setOnClickListener(new e(this));
    L17:
        View r9 = this.i;
        if (r9 == null) goto L20;
        r9.setOnClickListener(new f(this));
    L20:
        HSImageView r10 = this.I;
        if (r10 == null) goto L23;
        r10.setOnClickListener(new g(this));
    L23:
        View r12 = this.z;
        if (r12 == null) goto L26;
        r12.setOnClickListener(new h(this));
    L26:
        TextView r13 = this.q;
        if (r13 == null) goto L29;
        r13.setOnClickListener(new i(this));
    L29:
        TextView r14 = this.r;
        if (r14 == null) goto L33;
        r14.setOnClickListener(new j(this));
        return;
    }

    @Override // com.bytedance.android.live.recharge.widget.AbsRechargeWidget
    public final void onLoad(Object[] r9) {
        super.onLoad(r9);
        String r0 = s1.C(2131915649, new Object[]{e4.a()});
        String r1 = s1.C(2131915652, new Object[]{e4.a()});
        SpannableStringBuilder r3 = SpannableStringBuilder.valueOf(r0 + r1);
        r3.setSpan(new ForegroundColorSpan(s1.h(2131107805)), r0.length(), r0.length() + r1.length(), 18);
        TextView r2 = this.s;
        if (r2 == null) goto L5;
        r2.setText(r3);
    L5:
        TextView r4 = this.s;
        if (r4 == null) goto L8;
        r4.setOnClickListener(new m(this));
    L8:
        RxUtilKt.c(this.e.H.compose(RxUtil.rxSchedulerHelper()).subscribe(new p(this)), this.d);
        RxUtilKt.c(this.h.getCloseNoPasswordPayMethodDialog().subscribe(new k(this)), this.d);
        Eq(true, 10);
        Aq();
        Pair[] r5 = new Pair[4];
        r5[0] = TuplesKt.to("is_first_recharge", String.valueOf(wq()));
        String r6 = DataType.FALSE;
        r5[1] = TuplesKt.to("is_include_discount_package", DataType.FALSE);
        r5[2] = TuplesKt.to("panel_type", DataType.Normal);
        if (((com.bytedance.android.live.recharge.platform.model.f) this.h.getRepository().Q.a).e() == false) goto L11;
        Object r7 = DataType.TRUE;
    L12:
        r5[3] = TuplesKt.to("is_integration_recharge", r7);
        Map r8 = MapsKt.toMutableMap(MapsKt.mapOf(r5));
        HashMap r10 = new HashMap();
        int r12 = com.bytedance.android.live.recharge.utils.m.a;
        com.bytedance.android.live.recharge.utils.m.b(r10, this.h.getMDialogEntranceParams(), new Object[]{rw0.b.class, rw0.c.class});
        r8.putAll(r10);
        if (((Boolean) this.h.getRepository().A.a).booleanValue() == false) goto L15;
        r6 = DataType.TRUE;
    L15:
        r8.put("is_diamond_cache", r6);
        r8.putAll(this.h.getReportExtraInfo("livesdk_recharge_show"));
        com.bytedance.android.live.recharge.utils.m.g("livesdk_recharge_show", String.valueOf(this.A), "password_free", r8, this.g);
        com.bytedance.android.live.recharge.trace.g r13 = com.bytedance.android.live.recharge.trace.f.a;
        com.bytedance.android.live.recharge.trace.f.a(RechargeTraceStep.STEP_NO_PASSWORD_PANEL_SHOW, r8);
        return;
    L11:
        r7 = DataType.FALSE;
        goto L12
    }

    @Override // com.bytedance.android.live.recharge.widget.AbsRechargeWidget
    public final void yq(long r1) {
        Aq();
    }

    public static /* synthetic */ void Fq(RechargeNoPasswordWidget r2, boolean r3) {
        r2.Eq(r3, 300);
    }

    public static final void zq(RechargeNoPasswordWidget r25, boolean r26) {
        r25.getClass();
        if (((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).isLogin() == true) goto L5;
        RxUtilKt.r(((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).z4(((Widget) r25).context, RechargeNoPasswordWidget$login$1.INSTANCE), "RechargeNoPasswordWidget");
        return;
    L5:
        Iterator r1 = ((Iterable) r25.h.getRepository().g.a).iterator();
        if (r1.hasNext() == false) goto L8;
        Object r2 = r1.next();
        com.bytedance.android.live.recharge.deal.d r3 = (com.bytedance.android.live.recharge.deal.d) r2;
    L9:
        com.bytedance.android.live.recharge.deal.d r4 = (com.bytedance.android.live.recharge.deal.d) r2;
        if (r4 == null) goto L81;
        com.bytedance.android.live.recharge.deal.d r5 = com.bytedance.android.live.recharge.deal.d.j(r4, r25.A * ((long) 10.0f), false, 1021);
        r25.h.getPopUpOrHideRechargePageEvent().onNext(Boolean.TRUE);
        com.bytedance.android.live.recharge.platform.model.f r6 = (com.bytedance.android.live.recharge.platform.model.f) r25.e.Q.a;
        HashMap r10 = new HashMap();
        int r7 = com.bytedance.android.live.recharge.utils.m.a;
        com.bytedance.android.live.recharge.utils.m.b(r10, r25.h.getMDialogEntranceParams(), new Object[]{rw0.b.class});
        r10.put("event_module", "customized");
        NoPasswordPayType r8 = NoPasswordPayType.NOT_USE_NO_PASSWORD;
        if (r26 == true) goto L14;
    L45:
        NoPasswordPayType r18 = r8;
        r10.putAll(r25.h.getReportExtraInfo("livesdk_recharge_page_pay_click"));
        com.bytedance.android.live.recharge.platform.business.model.diamond.g r9 = com.bytedance.android.live.recharge.deal.g.c(r5);
        if (r9 == null) goto L49;
        String r12 = r9.getDiamondDesc();
        if (r12 == null) goto L49;
    L50:
        r10.put("giving_diamond_badge", r12);
        String r13 = "";
        if (r9 == null) goto L56;
        com.bytedance.android.live.recharge.platform.business.model.diamond.a r14 = r9.getCouponBarInfo();
        if (r14 == null) goto L56;
        String r15 = r14.getDesc();
        if (r15 == null) goto L56;
    L57:
        r10.put("giving_diamond_bar", r15);
        if (r9 == null) goto L61;
        String r16 = r9.getPreCalcInfo();
        if (r16 == null) goto L61;
    L62:
        r10.put("pre_calc_info", r16);
        if (r26 == false) goto L65;
        Object r17 = DataType.TRUE;
    L66:
        r10.put("no_password_pay", r17);
        Context r19 = ((Widget) r25).context;
        com.bytedance.android.live.recharge.model.d r110 = r25.h.getMDialogEntranceParams();
        long r22 = ((Number) r25.h.getRepository().c.a).longValue();
        if (r25.L == false) goto L70;
        if (r26 == false) goto L70;
        r13 = "recharge_panel";
    L70:
        r25.h.getOrder().setValue(com.bytedance.android.live.recharge.service.e.b(r5, r19, r10, r110, false, 0, false, false, r22, r18, r13, 4608));
        HashMap r20 = new HashMap();
        r20.put("is_first_recharge", String.valueOf(r25.wq()));
        r20.put("given_scores", String.valueOf(r5.d));
        if (r25.L == false) goto L73;
        Object r111 = DataType.TRUE;
    L74:
        r20.put("is_integration_recharge", r111);
        if (r26 == false) goto L77;
        Object r112 = DataType.TRUE;
    L78:
        r20.put("no_password_pay", r112);
        r20.put("deal_badge", r25.h.getDescription(r5));
        com.bytedance.android.live.recharge.utils.m.b(r20, r25.h.getMDialogEntranceParams(), new Object[]{rw0.b.class, rw0.f.class});
        r20.putAll(r25.h.getReportExtraInfo("livesdk_recharge_page_pay_click"));
        com.bytedance.android.live.recharge.utils.m.m(String.valueOf(r25.A), "password_free", String.valueOf(r5.c), r20, r25.h.getMDialogEntranceParams());
        int r0 = com.bytedance.android.live.recharge.utils.o.a;
        com.bytedance.android.live.recharge.utils.o.b(true, RechargeMonitorService.TTLIVE_CHARGE_PAGE_CLICK, MapsKt.toMutableMap(MapsKt.mapOf(new Pair[]{TuplesKt.to("event_module", "password_free"), TuplesKt.to("request_page", "live_detail")})), null);
        return;
    L77:
        r112 = DataType.FALSE;
        goto L78
    L73:
        r111 = DataType.FALSE;
        goto L74
    L65:
        r17 = DataType.FALSE;
    L61:
        r16 = "";
    L56:
        r15 = "";
    L49:
        r12 = r5.e;
        goto L50
    L14:
        if (r25.L == false) goto L35;
        if (r6.e() == false) goto L35;
        ALogger.d("RechargeNoPasswordWidget", "财经免密支付方式");
        JSONObject r23 = com.bytedance.android.live.recharge.core.f.h(RechargeServices.b()).I("recharge_panel");
        if (r23 == null) goto L20;
        r10.put("caijing_pay_params", r23.toString());
    L20:
        String r24 = com.bytedance.android.live.recharge.core.f.b(RechargeServices.b()).Y0();
        if (r24 == null) goto L23;
        r10.put("sdk_version", r24);
    L23:
        r10.put("create_pay_type", DataType.TRUE);
        r10.put("guide_source", NoPasswordGuideSource.PK_ONE_STEP.getValue());
        r10.put("live_pk", DataType.TRUE);
        com.bytedance.android.livesdk.revenue.service.room.c r27 = (dy0.b) com.bytedance.android.live.revenue.core.util.e.c(com.bytedance.android.live.revenue.core.util.j.C0.a(), com.bytedance.android.livesdk.revenue.service.room.c.class);
        if (r27 == null) goto L32;
        com.bytedance.android.livesdk.revenue.room.a r28 = r27.getRoomContext();
        if (r28 == null) goto L32;
        com.bytedance.live.datacontext.m r29 = r28.getRoom();
        if (r29 == null) goto L32;
        IRoom r30 = (IRoom) r29.getValue();
        if (r30 == null) goto L32;
        Long r32 = Long.valueOf(r30.getRoomId());
    L33:
        r10.put("roomid", String.valueOf(r32));
        r8 = NoPasswordPayType.USE_ONE_STEP_PAY;
    L40:
        if (r25.h.getNoPasswordScene() != NoPasswordScene.SCENE_FANS_CLUB_JOIN) goto L43;
        r10.put("guide_source", NoPasswordGuideSource.FANS_CLUB_JOIN.getValue());
        goto L45
    L43:
        if (r25.h.getNoPasswordScene() != NoPasswordScene.SCENE_FANS_CLUB_SEND_GIFT) goto L45;
        r10.put("guide_source", NoPasswordGuideSource.FANS_CLUB_SEND_LIGHT_BOARD.getValue());
    L32:
        r32 = null;
    L35:
        if (r6.d() == false) goto L40;
        if ((!r6.c().isEmpty()) == false) goto L40;
        ALogger.d("RechargeNoPasswordWidget", "支付宝或抖音免密支付");
        r10.put("create_pay_type", "3");
        r10.put("guide_source", NoPasswordGuideSource.DOUYIN_OR_ZFB.getValue());
        r10.put("pk_pay_method", String.valueOf(r25.G));
        r8 = NoPasswordPayType.USE_DY_OR_ZFB_PAY;
        goto L40
    L81:
        return;
    L8:
        r2 = null;
        goto L9
    }

    public final void Eq(boolean r7, long r8) {
        if (r7 == false) goto L7;
        this.h.setAllowBack(true);
        View r3 = this.z;
        if (r3 == null) goto L10;
        r3.setVisibility(8);
    L10:
        ViewGroup r4 = this.t;
        if (r4 == null) goto L24;
        if (r7 == false) goto L14;
        r4.setVisibility(8);
    L15:
        r4.clearAnimation();
        float r0 = r4.getHeight();
        AnimationSet r2 = new AnimationSet(true);
        if (r7 == false) goto L18;
        float r5 = 0.0f;
    L19:
        if (r7 == true) goto L22;
        r0 = 0.0f;
    L22:
        TranslateAnimation r1 = new TranslateAnimation(0.0f, 0.0f, r5, r0);
        r1.setDuration(r8);
        r2.addAnimation(r1);
        r4.startAnimation(r2);
        return;
    L18:
        r5 = r0;
        goto L19
    L14:
        r4.setVisibility(0);
        goto L15
    L24:
        return;
    L7:
        this.h.setAllowBack(false);
        View r6 = this.z;
        if (r6 == null) goto L10;
        r6.setVisibility(0);
        goto L10
    }
}
