package com.bytedance.android.live.recharge.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.gift.IGiftService;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.android.live.recharge.RechargeDialogContext;
import com.bytedance.android.live.recharge.core.RechargeServices;
import com.bytedance.android.live.recharge.nopassword.NoPasswordScene;
import com.bytedance.android.live.recharge.order.Order;
import com.bytedance.android.live.recharge.platform.core.config.RechargeConfigKey;
import com.bytedance.android.live.recharge.trace.RechargeTraceStep;
import com.bytedance.android.live.recharge.view.ClickInterceptorFrameLayout;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revenue.model.extension.main.IMainGiftRoom;
import com.bytedance.android.live.uikit.recyclerview.LoadingStatusView;
import com.bytedance.android.livesdk.chatroom.ui.DouyinLoadingLayout;
import com.bytedance.android.livesdk.chatroom.ui.c9;
import com.bytedance.android.livesdk.gift.platform.core.model.SendGiftSource;
import com.bytedance.android.livesdk.gift.platform.core.model.b0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.kmp.core.KmpEnv;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/recharge/widget/RechargePanelWidgetComposite;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Landroid/view/View$OnClickListener;", "a", "Mode", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RechargePanelWidgetComposite extends LiveRecyclableWidget implements View.OnClickListener {
    public static final /* synthetic */ int y = 0;
    public View a;
    public FrameLayout b;
    public FrameLayout c;
    public FrameLayout d;
    public FrameLayout e;
    public View f;
    public final boolean g;
    public final int h;
    public LoadingStatusView i;
    public final CompositeDisposable j;
    public String k;
    public int l;
    public boolean m;
    public View n;
    public float o;
    public FrameLayout p;
    public h q;
    public RechargeNoPasswordWidget r;
    public RechargeBottomWidget s;
    public final com.bytedance.android.live.recharge.service.f t;
    public long u;
    public Mode v;
    public final RechargeDialogContext w;
    public final ex0.a x;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/recharge/widget/RechargePanelWidgetComposite$Mode;", "", "NORMAL", "NO_PASSWORD", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum Mode extends Enum<Mode> {
        public static final Mode NORMAL = null;
        public static final Mode NO_PASSWORD = null;
        public static final /* synthetic */ Mode[] a = null;

        static {
            Mode r1 = new Mode("NORMAL", 0);
            NORMAL = r1;
            Mode r2 = new Mode("NO_PASSWORD", 1);
            NO_PASSWORD = r2;
            a = new Mode[]{r1, r2};
        }

        public static Mode valueOf(String r1) {
            return (Mode) r27.a.a(Mode.class, r1);
        }

        public static Mode[] values() {
            return (Mode[]) a.clone();
        }

        public Mode(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ RechargePanelWidgetComposite a;

        public b(RechargePanelWidgetComposite r1) {
            this.a = r1;
        }

        public final void accept(Object r63) {
            Long r1 = (Long) r63;
            ALogger.d("RechargePanelWidgetComposite", "onPaySuccessful: balance=" + r1 + "  lackMoney=" + this.a.w.getMDialogEntranceParams().d);
            if (r1.longValue() < this.a.w.getMDialogEntranceParams().d) goto L23;
            int r2 = ToastUtil.a;
            ToastUtil.b(s1.B(2131921903), 0);
            com.bytedance.android.livesdk.gift.platform.core.model.v r4 = null;
            if (((Boolean) com.bytedance.android.live.recharge.utils.t.i.getValue(null, com.bytedance.android.live.recharge.utils.t.a[7])).booleanValue() == false) goto L19;
            com.bytedance.android.live.recharge.model.b r3 = this.a.w.getMDialogEntranceParams().j;
            if (r3 == null) goto L9;
            int r5 = r3.f;
        L10:
            if (r5 > 0) goto L12;
            int r6 = 1;
        L13:
            com.bytedance.android.live.recharge.model.b r7 = this.a.w.getMDialogEntranceParams().j;
            if (r7 == null) goto L17;
            r4 = r7.h;
        L17:
            if ((r4 instanceof b0) == false) goto L22;
            ALogger.d("RechargePanelWidgetComposite", "pay successful, auto send gift with origin params, params=" + r4 + ", count=" + r6);
            jc1.k.n(IGiftService.class).sendGift((b0) r4, r6);
        L22:
            this.a.w.getDismissEvent().onNext(Unit.INSTANCE);
            return;
        L12:
            r6 = r5;
            goto L13
        L9:
            r5 = 1;
            goto L10
        L19:
            com.bytedance.android.live.recharge.model.b r8 = this.a.w.getMDialogEntranceParams().j;
            if (r8 == null) goto L22;
            long r14 = r8.e;
            b0 r9 = new b0(r14, SendGiftSource.GiftDialog, null, null, 0, 0, null, null, null, null, 0, null, null, false, null, 0, false, null, 0, null, false, null, false, 0, null, null, null, null, null, null, null, null, 0, 0, null, null, false, null, null, null, null, null, null, false, null, null, null, null, 0, null, null, -4, 8388607);
            ALogger.d("RechargePanelWidgetComposite", "pay successful, auto send gift, giftId=" + r14);
            jc1.k.n(IGiftService.class).sendGift(r9, 1);
            goto L22
        L23:
            this.a.w.getDismissEvent().onNext(Unit.INSTANCE);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ RechargePanelWidgetComposite a;

        public c(RechargePanelWidgetComposite r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            this.a.w.getDismissEvent().onNext(Unit.INSTANCE);
        }
    }

    public static final class d implements DialogInterface.OnClickListener {
        public final /* synthetic */ RechargePanelWidgetComposite a;
        public final /* synthetic */ JSONObject b;

        public d(RechargePanelWidgetComposite r1, JSONObject r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r2, int r3) {
            RechargePanelWidgetComposite.wq(this.a, this.b, r2);
        }
    }

    public static final class e implements DialogInterface.OnClickListener {
        public final /* synthetic */ RechargePanelWidgetComposite a;
        public final /* synthetic */ JSONObject b;

        public e(RechargePanelWidgetComposite r1, JSONObject r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r2, int r3) {
            RechargePanelWidgetComposite.wq(this.a, this.b, r2);
        }
    }

    public static final class f implements DialogInterface.OnClickListener {
        public final /* synthetic */ RechargePanelWidgetComposite a;
        public final /* synthetic */ JSONObject b;

        public f(RechargePanelWidgetComposite r1, JSONObject r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r2, int r3) {
            RechargePanelWidgetComposite.wq(this.a, this.b, r2);
        }
    }

    public static final class g implements View.OnClickListener {
        public final /* synthetic */ RechargePanelWidgetComposite a;

        public g(RechargePanelWidgetComposite r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.w.getDismissEvent().onNext(Unit.INSTANCE);
        }
    }

    public static final class h implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ RechargePanelWidgetComposite a;

        public h(RechargePanelWidgetComposite r1) {
            this.a = r1;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            RechargePanelWidgetComposite r0 = this.a;
            RechargeDialogContext r1 = r0.w;
            View r2 = r0.f;
            if (r2 == null) goto L5;
            int r3 = r2.getHeight();
        L6:
            r1.setDialogHeight(r3);
            return;
        L5:
            r3 = 0;
            goto L6
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ RechargePanelWidgetComposite a;

        public i(RechargePanelWidgetComposite r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            ApiServerException r4 = (Throwable) r3;
            this.a.w.getRepository().R.onNext(4);
            if ((r4 instanceof ApiServerException) == false) goto L6;
            int r0 = ToastUtil.a;
            ToastUtil.b(r4.getPrompt(), 0);
            return;
        }
    }

    public static final class j<T> implements Consumer {
        public final /* synthetic */ RechargePanelWidgetComposite a;

        public j(RechargePanelWidgetComposite r1) {
            this.a = r1;
        }

        public final void accept(Object r8) {
            Integer r9 = (Integer) r8;
            RechargePanelWidgetComposite r0 = this.a;
            int r1 = RechargePanelWidgetComposite.y;
            r0.getClass();
            if (r9 != null) goto L6;
        L10:
            if (r9 != null) goto L13;
        L19:
            if (r9 == null) goto L29;
            if (r9.intValue() != 2) goto L29;
            if (r0.g == true) goto L125;
            LoadingStatusView r10 = r0.i;
            if (r10 == null) goto L126;
            r10.reset();
            return;
        L126:
            return;
        L125:
            return;
        L29:
            if (r9 == null) goto L35;
            if (r9.intValue() != 8) goto L35;
            RechargeDialogContext r12 = r0.w;
            r12.setDiamondDataAvailable(true);
            r12.isPreQueryInfo().a(Boolean.FALSE);
            return;
        L35:
            if (r9 != null) goto L38;
        L64:
            if (r9 != null) goto L67;
        L73:
            if (r9 != null) goto L76;
        L78:
            FrameLayout r4 = null;
            if (r9 != null) goto L82;
        L99:
            if (r9 != null) goto L102;
            return;
        L102:
            if (r9.intValue() != 12) goto L137;
            FrameLayout r13 = r0.e;
            if ((r13 instanceof ClickInterceptorFrameLayout) == true) goto L106;
            r13 = null;
        L106:
            ClickInterceptorFrameLayout r14 = (ClickInterceptorFrameLayout) r13;
            if (r14 == null) goto L109;
            r14.setIntercept(false);
        L109:
            FrameLayout r15 = r0.d;
            if ((r15 instanceof ClickInterceptorFrameLayout) == false) goto L113;
            r4 = r15;
        L113:
            ClickInterceptorFrameLayout r5 = (ClickInterceptorFrameLayout) r4;
            if (r5 == null) goto L116;
            r5.setIntercept(false);
        L116:
            FrameLayout r16 = r0.p;
            if (r16 == null) goto L138;
            r16.setVisibility(8);
            return;
        L138:
            return;
        L137:
            return;
        L82:
            if (r9.intValue() != 11) goto L99;
            FrameLayout r17 = r0.e;
            if ((r17 instanceof ClickInterceptorFrameLayout) == true) goto L86;
            r17 = null;
        L86:
            ClickInterceptorFrameLayout r18 = (ClickInterceptorFrameLayout) r17;
            if (r18 == null) goto L89;
            r18.setIntercept(true);
        L89:
            FrameLayout r19 = r0.d;
            if ((r19 instanceof ClickInterceptorFrameLayout) == false) goto L93;
            r4 = r19;
        L93:
            ClickInterceptorFrameLayout r6 = (ClickInterceptorFrameLayout) r4;
            if (r6 == null) goto L96;
            r6.setIntercept(true);
        L96:
            FrameLayout r20 = r0.p;
            if (r20 == null) goto L135;
            r20.setVisibility(0);
            return;
        L135:
            return;
        L76:
            if (r9.intValue() != 5) goto L78;
            r0.w.getDismissEvent().onNext(Unit.INSTANCE);
            return;
        L67:
            if (r9.intValue() != 4) goto L73;
            if (r0.yq() == true) goto L131;
            LoadingStatusView r22 = r0.i;
            if (r22 == null) goto L132;
            r22.showError();
            return;
        L132:
            return;
        L131:
            return;
        L38:
            if (r9.intValue() != 6) goto L64;
            if (r0.w.isDiamondDataAvailable() == false) goto L42;
        L46:
            com.bytedance.android.live.recharge.service.f r23 = r0.t;
            if (r23 == null) goto L50;
            r23.c = System.currentTimeMillis();
        L50:
            if (r0.g == false) goto L58;
            View r24 = r0.f;
            if (r24 == null) goto L58;
            ViewGroup.LayoutParams r25 = r24.getLayoutParams();
            if (r25 == null) goto L58;
            r25.height = 0;
            View r2 = r0.f;
            if (r2 == null) goto L58;
            r2.setLayoutParams(r25);
        L58:
            LoadingStatusView r26 = r0.i;
            if (r26 == null) goto L61;
            r26.reset();
        L61:
            com.bytedance.android.live.recharge.trace.session.a r27 = (com.bytedance.android.live.recharge.trace.session.a) r0.w.getSession().getValue();
            if (r27 == null) goto L129;
            r27.c(com.bytedance.android.live.recharge.trace.session.d.c);
            return;
        L129:
            return;
        L42:
            if (com.bytedance.android.live.recharge.utils.j.d().enableCacheWithStrategy() == false) goto L46;
            com.bytedance.android.live.recharge.service.f r28 = r0.t;
            if (r28 == null) goto L50;
            r28.b = System.currentTimeMillis();
            goto L50
        L13:
            if (r9.intValue() != 3) goto L19;
            if (r0.yq() == true) goto L122;
            LoadingStatusView r29 = r0.i;
            if (r29 == null) goto L123;
            r29.showEmpty();
            return;
        L123:
            return;
        L122:
            return;
        L6:
            if (r9.intValue() != 1) goto L10;
            LoadingStatusView r30 = r0.i;
            if (r30 == null) goto L120;
            r30.showLoading();
            return;
        }
    }

    public static final class k<T> implements Consumer {
        public final /* synthetic */ RechargePanelWidgetComposite a;

        public k(RechargePanelWidgetComposite r1) {
            this.a = r1;
        }

        public final void accept(Object r8) {
            com.bytedance.android.live.recharge.platform.model.f r9 = (com.bytedance.android.live.recharge.platform.model.f) r8;
            if (r9.g() == false) goto L5;
            Mode r0 = Mode.NO_PASSWORD;
        L6:
            NoPasswordScene r1 = com.bytedance.android.live.recharge.core.f.g(RechargeServices.b()).B1(this.a.w.getMDialogEntranceParams());
            this.a.w.setNoPasswordScene(r1);
            int r2 = com.bytedance.android.live.recharge.utils.m.a;
            String r3 = r1.getValue();
            boolean r10 = r9.g();
            com.bytedance.android.live.recharge.model.d r4 = this.a.w.getMDialogEntranceParams();
            Intrinsics.checkNotNullParameter(r3, "scene");
            Intrinsics.checkNotNullParameter(r4, "params");
            Pair[] r5 = new Pair[2];
            r5[0] = TuplesKt.to("no_password_scene", r3);
            if (r10 == false) goto L9;
            String r12 = DataType.TRUE;
        L10:
            r5[1] = TuplesKt.to("sign_result", r12);
            HashMap r13 = MapsKt.hashMapOf(r5);
            com.bytedance.android.live.recharge.utils.m.b(r13, r4, new Object[]{rw0.b.class});
            HashMap<Class<?>, com.bytedance.android.livesdk.revenue.log.d<?>> r6 = com.bytedance.android.live.recharge.utils.f.a;
            com.bytedance.android.live.recharge.utils.f.d("livesdk_no_password_sign_result", r13, new Class[]{IRoom.class, am2.x.class});
            com.bytedance.android.live.recharge.trace.g r7 = com.bytedance.android.live.recharge.trace.f.a;
            com.bytedance.android.live.recharge.trace.f.a(RechargeTraceStep.STEP_NO_PASSWORD_SIGN_RESULT, r13);
            this.a.Eq(r0);
            return;
        L9:
            r12 = DataType.FALSE;
            goto L10
        L5:
            r0 = Mode.NORMAL;
            goto L6
        }
    }

    public static final class l<T> implements Consumer {
        public final /* synthetic */ RechargePanelWidgetComposite a;

        public l(RechargePanelWidgetComposite r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            Object r6 = sh6.c.b((sh6.b) r5);
            if (r6 == null) goto L6;
            Order r7 = (Order) r6;
            RxUtilKt.c(com.bytedance.android.live.revenue.common.reactive.j.a(r7.getState(), false).subscribe(new s(r7, this)), this.a.j);
            RxUtilKt.c(com.bytedance.android.live.revenue.common.reactive.j.a(r7.getState(), true).filter(com.bytedance.android.live.recharge.order.d.a).take(1).subscribe(new t(r7, this)), this.a.j);
            RxUtilKt.c(com.bytedance.android.live.revenue.common.reactive.j.a(r7.getProgress(), true).subscribe(new u(r7, this)), this.a.j);
            return;
        }
    }

    public static final class m<T> implements Consumer {
        public final /* synthetic */ RechargePanelWidgetComposite a;

        public m(RechargePanelWidgetComposite r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            RechargePanelWidgetComposite r0 = this.a;
            boolean r6 = ((Boolean) r5).booleanValue();
            boolean r2 = !r6;
            if (r0.m == r2) goto L19;
            r0.m = r2;
            View r1 = r0.n;
            if (r1 == null) goto L14;
            boolean r3 = r0.w.isVertical();
            if (r6 == false) goto L13;
            if (r3 == false) goto L11;
            int r4 = r1.getHeight();
        L12:
            r0.o = r4;
            goto L13
        L11:
            r4 = r1.getWidth();
        L13:
            r1.post(new x(r0, r3, r6, r1));
        L14:
            FrameLayout r7 = r0.b;
            if (r7 == null) goto L18;
            r7.setVisibility(8);
            return;
        L18:
            return;
        }
    }

    public static final class n<T> implements Consumer {
        public final /* synthetic */ RechargePanelWidgetComposite a;

        public n(RechargePanelWidgetComposite r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Unit r3 = (Unit) r2;
            FrameLayout r4 = this.a.c;
            if (r4 == null) goto L6;
            r4.setVisibility(8);
            return;
        }
    }

    public static final class o<T> implements Consumer {
        public final /* synthetic */ com.bytedance.android.live.recharge.model.d a;
        public final /* synthetic */ com.bytedance.android.live.recharge.a0 b;

        public o(com.bytedance.android.live.recharge.model.d r1, com.bytedance.android.live.recharge.a0 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r9) {
            yv0.a r0 = com.bytedance.android.live.recharge.core.f.j(RechargeServices.b());
            com.bytedance.android.live.recharge.model.d r2 = this.a;
            long r3 = ((Number) this.b.o.a).longValue();
            List<com.bytedance.android.live.recharge.deal.u> r10 = ((com.bytedance.android.live.recharge.deal.i) r9).c();
            ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
            Iterator<T> r12 = r10.iterator();
        L4:
            if (r12.hasNext() == false) goto L6;
            r5.add(Long.valueOf(((com.bytedance.android.live.recharge.deal.u) r12.next()).c));
            goto L4
        L6:
            r0.S0(new yv0.b(r2, r3, r5, false));
        }
    }

    static {
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
    }

    public final void Bq() {
        FrameLayout r0 = this.b;
        if (r0 == null) goto L5;
        r0.setVisibility(8);
    L5:
        ToastUtil.a(2131921211, 0);
        this.w.getPopUpOrHideRechargePageEvent().onNext(Boolean.FALSE);
    }

    public final int getLayoutId() {
        if (vh6.c.b(com.bytedance.android.livesdk.revenue.service.room.b.class).Ch() == false) goto L6;
        return 2131567269;
    L6:
        if (this.g == false) goto L8;
        return 2131567268;
    L8:
        return 2131567267;
    }

    public final void onUnload() {
        View r0 = this.f;
        if (r0 == null) goto L14;
        Integer r1 = Integer.valueOf(r0.getHeight());
        if (r1.intValue() <= 0) goto L7;
        boolean r2 = true;
    L9:
        if (r2 == true) goto L12;
        r1 = null;
    L12:
        if (r1 == null) goto L14;
        com.bytedance.android.live.recharge.utils.r.e.setValue(null, com.bytedance.android.live.recharge.utils.r.a[4], Integer.valueOf(r1.intValue()));
        goto L14
    L7:
        r2 = false;
    L14:
        ViewTreeObserver r3 = ((Widget) this).containerView.getViewTreeObserver();
        h r4 = this.q;
        if (r4 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mLayoutListener");
    L17:
        r3.removeOnGlobalLayoutListener(r4);
        this.j.clear();
    }

    public final void xq() {
        RxUtilKt.c(((IRechargeService) jc1.k.n(IRechargeService.class)).rechargeCenter().observeWallet().subscribe(new b(this), new c(this)), this.j);
        ((IRechargeService) jc1.k.n(IRechargeService.class)).rechargeCenter().sync("recharge");
    }

    public final boolean yq() {
        findViewById(2131379267).setVisibility(8);
        if (this.w.getRepository().S == true) goto L5;
    L7:
        return false;
    L5:
        if (((Boolean) this.w.getRepository().u.a).booleanValue() == true) goto L7;
        return true;
    }

    public static View Aq(Context r2) {
        KmpEnv r0 = KmpEnv.a;
        if (KmpEnv.a() == false) goto L6;
        DouyinLoadingLayout r1 = new DouyinLoadingLayout(r2);
        r1.setBackgroundResource(2131249809);
        return r1;
    L6:
        return LayoutInflater.from(r2).inflate(2131566712, null);
    }

    public final void Eq(Mode r4) {
        enableSubWidgetManager();
        if (q.a[r4.ordinal()] == 1) goto L28;
        this.v = Mode.NORMAL;
        Fq(false);
        RechargeNoPasswordWidget r5 = this.r;
        if (r5 == null) goto L7;
        ((Widget) this).subWidgetManager.unload(r5);
    L7:
        RechargeBottomWidget r6 = this.s;
        if (r6 == null) goto L10;
        ((Widget) this).subWidgetManager.unload(r6);
    L10:
        this.s = new RechargeBottomWidget(this.w);
        ((Widget) this).subWidgetManager.load(2131383898, new RechargeTopWidget(this.w));
        ((Widget) this).subWidgetManager.load(2131383883, new RechargeDealsWidget(this.w));
        ((Widget) this).subWidgetManager.load(2131379267, new RechargeLynxWidgetV2(this.w));
        yz0.k r7 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r7 == null) goto L19;
        IRoom r8 = r7.getRoom();
        if (r8 == null) goto L19;
        IMainGiftRoom r9 = (IMainGiftRoom) r8.castToOrNull(IMainGiftRoom.class);
        if (r9 == null) goto L19;
        com.bytedance.android.live.revenue.model.extension.main.c r10 = r9.getOthers();
        if (r10 == null) goto L19;
        com.bytedance.android.live.revenue.model.extension.main.b r12 = r10.getGiftPanelTopperTray();
    L20:
        if (r12 == null) goto L26;
        String r1 = r12.getPanelSchema();
        if (r1 == null) goto L26;
        if ((!StringsKt.isBlank(r1)) != true) goto L26;
        ((Widget) this).subWidgetManager.load(2131389182, new RechargeNoticeLynxWidget(this.w, r12));
    L27:
        ((Widget) this).subWidgetManager.load(2131383882, new RechargeCouponBarWidget(this.w));
        ((Widget) this).subWidgetManager.load(2131383879, new RechargeCjComponentWidget(this.w));
        ((Widget) this).subWidgetManager.load(2131383877, this.s);
        return;
    L26:
        ((Widget) this).subWidgetManager.load(2131383890, new RechargeNoticeWidget(this.w));
    L19:
        r12 = null;
        goto L20
    L28:
        this.v = Mode.NO_PASSWORD;
        Fq(true);
        RechargeNoPasswordWidget r13 = new RechargeNoPasswordWidget(this.w);
        this.r = r13;
        ((Widget) this).subWidgetManager.load(2131383889, r13);
        View r14 = this.a;
        if (r14 == null) goto L33;
        r14.setVisibility(8);
        return;
    }

    public final void Fq(boolean r5) {
        View r0 = findViewById(2131383898);
        int r1 = 8;
        if (r5 == false) goto L5;
        int r3 = 8;
    L6:
        r0.setVisibility(r3);
        View r2 = findViewById(2131383883);
        if (r5 == false) goto L9;
        int r4 = 8;
    L10:
        r2.setVisibility(r4);
        View r6 = findViewById(2131379267);
        if (r5 == false) goto L13;
        int r7 = 8;
    L14:
        r6.setVisibility(r7);
        View r8 = findViewById(2131383879);
        if (r5 == false) goto L17;
        int r9 = 8;
    L18:
        r8.setVisibility(r9);
        View r10 = findViewById(2131383877);
        if (r5 == false) goto L21;
        int r12 = 8;
    L22:
        r10.setVisibility(r12);
        View r13 = findViewById(2131389182);
        if (r5 == false) goto L25;
        int r14 = 8;
    L26:
        r13.setVisibility(r14);
        View r15 = findViewById(2131383890);
        if (r5 == false) goto L29;
        int r16 = 8;
    L30:
        r15.setVisibility(r16);
        View r17 = findViewById(2131383889);
        if (r5 == false) goto L33;
        r1 = 0;
    L33:
        r17.setVisibility(r1);
        return;
    L29:
        r16 = 0;
        goto L30
    L25:
        r14 = 0;
        goto L26
    L21:
        r12 = 0;
        goto L22
    L17:
        r9 = 0;
        goto L18
    L13:
        r7 = 0;
        goto L14
    L9:
        r4 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    public final void onInit(Object[] r8) {
        View r9 = findViewById(2131367009);
        this.a = r9;
        if (r9 == null) goto L5;
        r9.setOnClickListener(new g(this));
    L5:
        this.b = (FrameLayout) findViewById(2131387137);
        this.c = (FrameLayout) findViewById(2131383890);
        this.f = findViewById(2131364152);
        if (this.g == true) goto L8;
    L18:
        this.i = findViewById(2131387318);
        this.n = findViewById(2131383881);
        this.p = (FrameLayout) findViewById(2131381473);
        this.d = (FrameLayout) findViewById(2131383883);
        this.e = (FrameLayout) findViewById(2131383879);
        Context r10 = ((Widget) this).context;
        String r0 = "";
        if (r10 == null) goto L51;
        View r1 = Aq(r10);
        View r2 = Aq(r10);
        View r3 = LayoutInflater.from(r10).inflate(2131566711, null);
        r3.setOnClickListener(new r(this));
        View r4 = LayoutInflater.from(s1.getContext()).inflate(2131563562, null);
        if (r4 == null) goto L50;
        TextView r5 = (TextView) r4;
        r5.setText((String) com.bytedance.android.live.recharge.core.f.k(RechargeServices.b()).E1(RechargeConfigKey.KEY_RECHARGE_EMPTY_TEXT, ""));
        LoadingStatusView r6 = this.i;
        if (r6 == null) goto L25;
        r6.setBuilder(LoadingStatusView.Builder.createDefaultBuilder(((Widget) this).context).setLoadingView(r1).setErrorView(r3).setEmptyView(r5));
    L25:
        r2.setVisibility(0);
        Drawable r7 = r2.getBackground();
        if (r7 == null) goto L30;
        Drawable r12 = r7.mutate();
        if (r12 == null) goto L30;
        r12.setAlpha(0);
    L30:
        r2.setBackgroundResource(0);
        FrameLayout r13 = this.b;
        if (r13 == null) goto L33;
        r13.setBackgroundColor(((Widget) this).context.getResources().getColor(2131106784));
    L33:
        FrameLayout r14 = this.b;
        if (r14 == null) goto L36;
        r14.addView(r2);
    L36:
        View r15 = Aq(r10);
        r15.setVisibility(0);
        r15.setBackgroundResource(0);
        FrameLayout r16 = this.p;
        if (r16 == null) goto L43;
        Drawable r17 = r16.getBackground();
        if (r17 == null) goto L43;
        Drawable r18 = r17.mutate();
        if (r18 == null) goto L43;
        r18.setAlpha(0);
    L43:
        FrameLayout r19 = this.p;
        if (r19 == null) goto L46;
        r19.setBackgroundColor(((Widget) this).context.getResources().getColor(2131106784));
    L46:
        FrameLayout r20 = this.p;
        if (r20 == null) goto L51;
        r20.addView(r15);
        goto L51
    L50:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L51:
        this.q = new h(this);
        ViewTreeObserver r22 = ((Widget) this).containerView.getViewTreeObserver();
        h r23 = this.q;
        if (r23 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("mLayoutListener");
    L54:
        r22.addOnGlobalLayoutListener(r23);
        com.bytedance.android.live.recharge.model.f r24 = this.w.getMDialogEntranceParams().k;
        if (r24 == null) goto L57;
        int r25 = r24.a;
    L58:
        this.l = r25;
        com.bytedance.android.live.recharge.model.f r26 = this.w.getMDialogEntranceParams().k;
        if (r26 == null) goto L64;
        String r27 = r26.b;
        if (r27 == null) goto L64;
        r0 = r27;
    L64:
        this.k = r0;
        com.bytedance.android.live.recharge.model.f r28 = this.w.getMDialogEntranceParams().k;
        return;
    L57:
        r25 = -1;
        goto L58
    L8:
        if (this.h <= 0) goto L18;
        if (this.w.getSupportNoPassword() == true) goto L18;
        View r29 = this.f;
        if (r29 == null) goto L18;
        ViewGroup.LayoutParams r30 = r29.getLayoutParams();
        if (r30 == null) goto L18;
        r30.height = this.h;
        View r32 = this.f;
        if (r32 == null) goto L18;
        r32.setLayoutParams(r30);
        goto L18
    }

    public final void onLoad(Object[] r4) {
        if (this.w.getSupportNoPassword() == true) goto L5;
        Eq(Mode.NORMAL);
    L5:
        RxUtilKt.c(this.w.getRepository().D.subscribe(new i(this)), this.w.getCd());
        RxUtilKt.c(this.w.getRepository().R.subscribe(new j(this)), this.w.getCd());
        RxUtilKt.c(this.w.getRepository().H.compose(RxUtil.rxSchedulerHelper()).subscribe(new k(this)), this.w.getCd());
        RxUtilKt.c(this.w.getOrder().a().subscribe(new l(this)), this.j);
        RxUtilKt.c(this.w.getPopUpOrHideRechargePageEvent().subscribe(new m(this)), this.j);
        RxUtilKt.c(this.w.getCloseNoticeEvent().subscribe(new n(this)), this.j);
        com.bytedance.android.live.recharge.a0 r5 = this.w.getRepository();
        com.bytedance.android.live.recharge.model.d r0 = this.w.getMDialogEntranceParams();
        RxUtilKt.c(r5.E.subscribe(new o(r0, r5)), this.j);
    }

    public final void zq(String r7) {
        JSONObject r8 = JSONObjectProtectorUtils.getJSONObject(new JSONObject(r7), "prompt");
        String r0 = JSONObjectProtectorUtils.getString(r8, "Prompt");
        JSONArray r9 = JSONObjectProtectorUtils.getJSONArray(r8, "ButtonList");
        if (r9.length() != 0) goto L6;
        ToastUtil.b(r0, 0);
        return;
    L6:
        if (r9.length() != 1) goto L8;
        int r1 = 1;
    L9:
        Context r4 = ((Widget) this).context;
        c9.b r5 = new c9.b();
        r5.a = r4;
        r5.b = r1;
        r5.f = r0;
        r5.g = 17;
        r5.q = false;
        r5.c = 2131565740;
        JSONObject r2 = JSONArrayProtectorUtils.getJSONObject(r9, 0);
        if (r9.length() != 1) goto L12;
        String r10 = JSONObjectProtectorUtils.getString(r2, "Text");
        d r3 = new d(this, r2);
        r5.h = r10;
        r5.i = r3;
    L13:
        c9 r12 = new c9(r5.a, r5);
        if (DialogLancet.shouldBlockDialogShow(r12) == false) goto L20;
        DialogLancet.handleBlockedDialogShow(r12);
        return;
    L20:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L19
    L17:
        DialogLancet.beforeDialogShow(r12);
        r12.show();
        DialogLancet.afterDialogShow(r12);
        return;
    L12:
        String r6 = JSONObjectProtectorUtils.getString(r2, "Text");
        e r13 = new e(this, r2);
        r5.j = r6;
        r5.k = r13;
        JSONObject r14 = JSONArrayProtectorUtils.getJSONObject(r9, 1);
        String r15 = JSONObjectProtectorUtils.getString(r14, "Text");
        f r16 = new f(this, r14);
        r5.l = r15;
        r5.m = r16;
        goto L13
    L8:
        r1 = 2;
        goto L9
    }

    public RechargePanelWidgetComposite(RechargeDialogContext r3, ex0.b r4) {
        Intrinsics.checkNotNullParameter(r3, "dialogContext");
        this.w = r3;
        this.x = r4;
        this.g = com.bytedance.android.live.recharge.utils.j.d().getPanelHeightAdjust();
        com.bytedance.android.live.recharge.service.f r1 = null;
        this.h = ((Number) com.bytedance.android.live.recharge.utils.r.e.getValue(null, com.bytedance.android.live.recharge.utils.r.a[4])).intValue();
        this.j = new CompositeDisposable();
        this.m = true;
        if (r4 == null) goto L5;
        r1 = (com.bytedance.android.live.recharge.service.f) com.bytedance.android.scope.m.e.d(r4, com.bytedance.android.live.recharge.service.f.class);
    L5:
        this.t = r1;
        this.v = Mode.NORMAL;
    }

    public final void Cq(Order r3, String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
        ToastUtil.a(2131921215, 0);
    L6:
        int r5 = com.bytedance.android.live.recharge.utils.m.a;
        com.bytedance.android.live.recharge.utils.m.k(r3, this.w.getMDialogEntranceParams());
        this.w.getPopUpOrHideRechargePageEvent().onNext(Boolean.FALSE);
        FrameLayout r6 = this.b;
        if (r6 == null) goto L10;
        r6.setVisibility(8);
        return;
    L10:
        return;
    L5:
        ToastUtil.b(r4, 0);
        goto L6
    }

    public static final void wq(RechargePanelWidgetComposite r2, JSONObject r3, DialogInterface r4) {
        r2.getClass();
        String r0 = JSONObjectProtectorUtils.getString(r3, "Type");
        if (Intrinsics.areEqual(r0, "cancel") == false) goto L6;
        r4.dismiss();
        return;
    L6:
        if (Intrinsics.areEqual(r0, "link") == false) goto L10;
        ((zz0.g) com.bytedance.android.live.revenue.core.util.f.a(zz0.g.class)).S2(((Widget) r2).context, JSONObjectProtectorUtils.getString(r3, "LynxSchema"));
        r4.dismiss();
        return;
    }
}
