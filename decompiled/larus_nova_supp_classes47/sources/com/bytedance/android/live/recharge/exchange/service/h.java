package com.bytedance.android.live.recharge.exchange.service;

import am2.x;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.android.live.recharge.core.RechargeServices;
import com.bytedance.android.live.recharge.exchange.dialog.CashExchangeDialogNew;
import com.bytedance.android.live.recharge.exchange.model.AutoExchangeStatus;
import com.bytedance.android.live.recharge.exchange.model.ReqFrom;
import com.bytedance.android.live.recharge.model.ExchangeType;
import com.bytedance.android.live.recharge.platform.business.IExchangeStatusService;
import com.bytedance.android.live.recharge.platform.core.config.TaskGoldRewardReqFrom;
import com.bytedance.android.live.recharge.trace.ExchangeTraceEvent;
import com.bytedance.android.live.recharge.utils.RechargeFacadeUtilsKt;
import com.bytedance.android.live.recharge.utils.r;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h implements com.bytedance.android.scope.o, ww0.a {
    public final String a;
    public final CompositeDisposable b;
    public gw0.a.C0246a c;
    public com.bytedance.android.live.recharge.exchange.dialog.e d;
    public final IExchangeStatusService e;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ xw0.a a;
        public final /* synthetic */ long b;
        public final /* synthetic */ zv0.e c;

        public a(xw0.a r1, long r2, zv0.e r4) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
        }

        public final void accept(Object r8) {
            com.bytedance.android.live.recharge.platform.business.model.income.e r9 = (com.bytedance.android.live.recharge.platform.business.model.income.e) ((ExtraResponse) r8).data;
            final int r5 = r9.cashAmount;
            final int r6 = r9.goldAmount;
            int r10 = com.bytedance.android.live.recharge.trace.a.a;
            com.bytedance.android.live.recharge.trace.a.a(ExchangeTraceEvent.DIAMOND_AUTO_EXCHANGE.getEventType(), "auto_exchange", new ExchangeInternalService$buyDiamondDirectly$2$1(r5, r6));
            xw0.a r0 = this.a;
            if (r0 == null) goto L6;
            r0.C1(this.b, this.c, true, r5, r6);
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ h a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ ExchangeType c;
        public final /* synthetic */ py.k d;
        public final /* synthetic */ long e;
        public final /* synthetic */ boolean f;
        public final /* synthetic */ Map g;
        public final /* synthetic */ zv0.e h;

        public c(h r1, Context r2, ExchangeType r3, py.k r4, long r5, boolean r7, Map r8, zv0.e r9) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r7;
            this.g = r8;
            this.h = r9;
        }

        public final void accept(Object r10) {
            String r5 = (String) r10;
            h r12 = this.a;
            gw0.a.C0246a r1 = r12.c;
            if (r1 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("mExchangeDialogFactory");
        L5:
            Context r2 = this.b;
            r1.getClass();
            Intrinsics.checkNotNullParameter(r2, "outerContext");
            r12.d = new com.bytedance.android.live.recharge.exchange.dialog.e(new CashExchangeDialogNew(r2));
            com.bytedance.android.live.recharge.exchange.dialog.e r0 = this.a.d;
            if (r0 == null) goto L8;
            r0.a(this.c, this.d, this.e, r5, this.f, this.g, this.h);
        L8:
            com.bytedance.android.live.recharge.exchange.dialog.e r13 = this.a.d;
            if (r13 == null) goto L12;
            r13.b();
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ h a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ ExchangeType c;
        public final /* synthetic */ py.k d;
        public final /* synthetic */ long e;
        public final /* synthetic */ boolean f;
        public final /* synthetic */ Map g;
        public final /* synthetic */ zv0.e h;

        public d(h r1, Context r2, ExchangeType r3, py.k r4, long r5, boolean r7, Map r8, zv0.e r9) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r7;
            this.g = r8;
            this.h = r9;
        }

        public final void accept(Object r12) {
            Throwable r13 = (Throwable) r12;
            h r0 = this.a;
            gw0.a.C0246a r2 = r0.c;
            if (r2 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("mExchangeDialogFactory");
        L5:
            Context r3 = this.b;
            r2.getClass();
            Intrinsics.checkNotNullParameter(r3, "outerContext");
            r0.d = new com.bytedance.android.live.recharge.exchange.dialog.e(new CashExchangeDialogNew(r3));
            com.bytedance.android.live.recharge.exchange.dialog.e r1 = this.a.d;
            if (r1 == null) goto L8;
            r1.a(this.c, this.d, this.e, "", this.f, this.g, this.h);
        L8:
            com.bytedance.android.live.recharge.exchange.dialog.e r4 = this.a.d;
            if (r4 == null) goto L11;
            r4.b();
        L11:
            jy0.b.c("ExchangeInternalService", "fail to get gold reward: " + r13.getMessage(), null, 4);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ h a;
        public final /* synthetic */ long b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ zv0.e d;
        public final /* synthetic */ ExchangeType e;
        public final /* synthetic */ py.k f;
        public final /* synthetic */ Map g;

        public e(h r1, long r2, Context r4, zv0.e r5, ExchangeType r6, py.k r7, Map r8) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
        }

        public final void accept(Object r13) {
            Integer r14 = (Integer) r13;
            if (this.b > 0) goto L5;
        L66:
            this.d.b();
            return;
        L5:
            if (com.bytedance.android.live.incentive.exchange.j.a() == false) goto L66;
            if (this.c == null) goto L66;
            com.bytedance.android.live.recharge.exchange.dialog.e r15 = this.a.d;
            if (r15 == null) goto L39;
            AppCompatDialog r2 = r15.a;
            if (r2 == null) goto L14;
            boolean r3 = r2.isShowing();
        L15:
            if (r3 == true) goto L18;
            r15 = null;
        L18:
            if (r15 == null) goto L39;
            AppCompatDialog r16 = r15.a;
            if (r16 == null) goto L39;
            Handler r4 = DialogLancet.resolveDialogHandler(r16);
            if (r4 != null) goto L24;
        L26:
            DialogLancet.beforeDialogDismiss(r16);
            r16.dismiss();     // Catch: Throwable -> L29 Exception -> L31
        L35:
            DialogLancet.afterDialogDismiss(r16);
            goto L39
        L29:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r16);
            throw th;
        L31:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L29
            Throwable r5 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L29
            if (r5 == null) goto L35;
            com.bytedance.crash.d.d(r5, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L29
            goto L35
        L24:
            if (Looper.myLooper() == r4.getLooper()) goto L26;
            r4.post(DialogLancet.createDismissRunnable(r16));
            goto L39
        L14:
            r3 = false;
        L39:
            if (((com.bytedance.android.live.recharge.utils.d) com.bytedance.android.live.recharge.utils.j.b.getValue(null, com.bytedance.android.live.recharge.utils.j.a[0])).b() == false) goto L61;
            if (lw0.b.a() == true) goto L43;
            boolean r8 = com.bytedance.android.live.recharge.util.d.a();
        L59:
            h.a(this.a, this.c, this.e, this.f, this.b, r8, this.g, this.d);
            return;
        L43:
            if (this.a.e.getAutoExchangeStatus() != AutoExchangeStatus.UnKnown.getValue()) goto L52;
            h r17 = this.a;
            Context r6 = this.c;
            ExchangeType r7 = this.e;
            py.k r9 = this.f;
            long r10 = this.b;
            zv0.e r12 = this.d;
            Observable<Integer> r0 = r17.e.fetchExchangeStatus(ReqFrom.UnKnown.getValue());
            if (r0 == null) goto L71;
            Observable r1 = r0.map(f.a);
            if (r1 == null) goto L72;
            Disposable r18 = r1.subscribe(new g(r17, r6, r7, r9, r10, r12));
            if (r18 == null) goto L73;
            RxUtilKt.c(r18, r17.b);
            return;
        L73:
            return;
        L72:
            return;
        L71:
            return;
        L52:
            if (this.a.e.getAutoExchangeStatus() != AutoExchangeStatus.UnSync.getValue()) goto L55;
            this.d.b();
            return;
        L55:
            if (this.a.e.getAutoExchangeStatus() != AutoExchangeStatus.Open.getValue()) goto L57;
            r8 = true;
            goto L59
        L57:
            r8 = false;
            goto L59
        L61:
            if (r.a() > 2) goto L63;
        L65:
            this.a.d(this.c, this.e, this.f, this.b, com.bytedance.android.live.recharge.util.d.a(), this.g, this.d);
            return;
        L63:
            if (com.bytedance.android.live.recharge.util.d.a() == false) goto L65;
            this.a.c(this.b, this.d);
        }
    }

    public final void onStart() {
        this.c = gw0.a.C0246a.a;
    }

    public final void onStop() {
        this.b.clear();
    }

    @Override // ww0.a
    public final boolean a6() {
        return lw0.b.a();
    }

    @Override // ww0.a
    public final void E7() {
        iw0.a r0 = iw0.a.a;
    }

    public h(IExchangeStatusService r2) {
        Intrinsics.checkNotNullParameter(r2, "exchangeStatusService");
        this.e = r2;
        this.a = "ExchangeInternalService";
        this.b = new CompositeDisposable();
    }

    public final void c(long r12, zv0.e r14) {
        RechargeFacadeUtilsKt.a().getClass();
        xw0.a r0 = (xw0.a) ((dy0.d) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), xw0.a.class));
        boolean r1 = ((IRechargeService) jc1.k.n(IRechargeService.class)).rechargeCenter().getExchangeInfo().getHideCombineExchange();
        if (com.bytedance.android.live.recharge.util.e.a() == 0) goto L15;
        if (r1 == true) goto L15;
        tz0.b r2 = tz0.b.a;
        uz0.c r3 = new uz0.c();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "$this$beforeConfigureRequest");
        Map<String, String> r4 = r3.b;
        Intrinsics.checkNotNullParameter(r4, "queriesMap");
        String r5 = Long.valueOf(r12).toString();
        Intrinsics.checkNotNullParameter("diamond_count", "$this$setTo");
        if (r5 == null) goto L8;
        r4.put("diamond_count", r5);
    L8:
        Integer r6 = 0;
        String r7 = r6.toString();
        Intrinsics.checkNotNullParameter("source", "$this$setTo");
        if (r7 == null) goto L11;
        r4.put("source", r7);
    L11:
        Integer r8 = 1;
        String r9 = r8.toString();
        Intrinsics.checkNotNullParameter("exchange_type", "$this$setTo");
        if (r9 == null) goto L14;
        r4.put("exchange_type", r9);
    L14:
        Intrinsics.checkNotNullParameter(r3, "$this$afterConfigureRequest");
        RxUtilKt.c(((INetworkService) com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/wallet_api/trial_exchange_income/", TypesJVMKt.getJavaType(Reflection.typeOf(com.bytedance.android.live.recharge.platform.business.model.income.e.class)), Extra.class, r3.d, r3.a, r3.b, r3.c).singleOrError().compose(RxUtil.rxSchedulerHelper()).subscribe(new a(r0, r12, r14), b.a), this.b);
        return;
    L15:
        if (r0 == null) goto L19;
        xw0.a.C0346a.a(r0, r12, r14);
        return;
    }

    @Override // ww0.a
    public final nw0.a Ge(View r9, List r10, TextView r12, int r13, Context r14, Function1 r15) {
        Intrinsics.checkNotNullParameter(r10, "actionView");
        Intrinsics.checkNotNullParameter(r12, "updateView");
        Intrinsics.checkNotNullParameter(r14, "context");
        return new nw0.a(r9, r10, r12, r15, r13, r14);
    }

    @Override // ww0.a
    public final void fo(Context r12, ExchangeType r13, py.k r14, long r15, Map<String, String> r17, zv0.e r18) {
        Intrinsics.checkNotNullParameter(r13, "type");
        Intrinsics.checkNotNullParameter(r17, "extraMap");
        Intrinsics.checkNotNullParameter(r18, "listener");
        RxUtilKt.c(Observable.just(1).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(this, r15, r12, r18, r13, r14, r17)), this.b);
    }

    public final void d(Context r14, ExchangeType r15, py.k r16, long r17, boolean r19, Map<String, String> r20, zv0.e r22) {
        tz0.b r0 = tz0.b.a;
        uz0.c r1 = new uz0.c();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "$this$beforeConfigureRequest");
        Map<String, String> r2 = r1.b;
        Intrinsics.checkNotNullParameter(r2, "queriesMap");
        String r3 = Integer.valueOf(TaskGoldRewardReqFrom.ExchangePopup.getValue()).toString();
        Intrinsics.checkNotNullParameter("req_from", "$this$setTo");
        if (r3 == null) goto L5;
        r2.put("req_from", r3);
    L5:
        String r4 = Long.valueOf(r17).toString();
        Intrinsics.checkNotNullParameter("exchange_diamond", "$this$setTo");
        if (r4 == null) goto L8;
        r2.put("exchange_diamond", r4);
    L8:
        Intrinsics.checkNotNullParameter(r1, "$this$afterConfigureRequest");
        RxUtilKt.c(RxUtilKt.h(((INetworkService) com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/growth/task_center/get_gold_reward/", TypesJVMKt.getJavaType(Reflection.typeOf(com.bytedance.android.live.recharge.platform.business.model.b.class)), Extra.class, r1.d, r1.a, r1.b, r1.c).map(i.a).subscribeOn(Schedulers.io())).singleOrError().subscribe(new c(this, r14, r15, r16, r17, r19, r20, r22), new d(this, r14, r15, r16, r17, r19, r20, r22)), this.b);
    }

    public static final void a(h r13, Context r14, ExchangeType r15, py.k r16, final long r17, final boolean r19, Map r20, zv0.e r22) {
        r13.getClass();
        if (r14 == null) goto L30;
        final bx0.d r4 = (bx0.d) com.bytedance.android.live.recharge.core.f.k(RechargeServices.b()).p1(bx0.d.class);
        int r5 = gx0.b.a;
        Pair[] r6 = new Pair[4];
        r6[0] = TuplesKt.to("money", String.valueOf(r17));
        String r7 = DataType.TRUE;
        if (r19 == false) goto L8;
        Object r9 = DataType.TRUE;
    L9:
        r6[1] = TuplesKt.to("is_auto_exchange", r9);
        if (r4.c() == false) goto L13;
        if (r19 == true) goto L13;
    L14:
        r6[2] = TuplesKt.to("is_toast_show", r7);
        r6[3] = TuplesKt.to("user_id", ((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).getCurrentUserId());
        Map r8 = MapsKt.mapOf(r6);
        Intrinsics.checkNotNullParameter("livesdk_diamond_automatic_exchange", "eventName");
        HashMap r10 = new HashMap();
        r10.put("request_page", "gift_sendgift");
        r10.put("charge_reason", "exchange_diamond");
        if (r8 == null) goto L17;
        r10.putAll(r8);
    L17:
        HashMap<Class<?>, com.bytedance.android.livesdk.revenue.log.d<?>> r12 = com.bytedance.android.live.recharge.utils.f.a;
        com.bytedance.android.live.recharge.utils.f.d("livesdk_diamond_automatic_exchange", r10, new Class[]{IRoom.class, x.class});
        int r18 = com.bytedance.android.live.recharge.trace.a.a;
        com.bytedance.android.live.recharge.trace.a.a(ExchangeTraceEvent.DIAMOND_AUTO_EXCHANGE.getEventType(), "pre_check", new ExchangeInternalService$reportAutoExchange$1(r17, r4, r19));
        jy0.b.d(r13.a, "try to exchange diamond by income, is auto exchange: " + r19);
        if (r19 == false) goto L21;
        Map<String, String> r3 = com.bytedance.android.live.recharge.exchange.trace.a.a;
        com.bytedance.android.live.recharge.exchange.trace.a.c(r20);
        r13.c(r17, r22);
        return;
    L21:
        if ((!r4.g()) == true) goto L24;
        r4 = null;
    L24:
        if (r4 == null) goto L26;
        r22.b();
        return;
    L26:
        r13.d(r14, r15, r16, r17, r19, r20, r22);
        return;
    L13:
        r7 = DataType.FALSE;
        goto L14
    L8:
        r9 = DataType.FALSE;
        goto L9
    }
}
