package com.bytedance.android.live.recharge.exchange.service;

import am2.x;
import android.content.Context;
import android.view.Window;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.recharge.RechargeCenter;
import com.bytedance.android.live.recharge.exchange.view.ExchangeConfirmDefaultView;
import com.bytedance.android.live.recharge.model.ExchangeInfo;
import com.bytedance.android.live.recharge.order.Order;
import com.bytedance.android.live.recharge.platform.service.IExchangeService;
import com.bytedance.android.live.recharge.platform.service.PayService;
import com.bytedance.android.livesdk.chatroom.ui.c9;
import com.bytedance.android.livesdk.utils.e4;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.HashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements com.bytedance.android.scope.o, com.bytedance.android.live.recharge.platform.service.n {
    public final a a;
    public final c b;
    public final PayService c;
    public final n d;

    public final class a implements com.bytedance.android.live.recharge.order.e {
        public final /* synthetic */ b a;

        @Override // com.bytedance.android.live.recharge.order.e
        public final void c(com.bytedance.android.live.recharge.order.f.b r2) {
            Intrinsics.checkNotNullParameter(r2, "order");
        }

        public a(b r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.recharge.order.e
        public final void a(Order r13, com.bytedance.android.live.recharge.order.f.b.a r14) {
            Intrinsics.checkNotNullParameter(r13, "order");
            Intrinsics.checkNotNullParameter(r14, "handle");
            this.a.getClass();
            int r0 = b.d();
            com.bytedance.android.live.recharge.utils.c r1 = (com.bytedance.android.live.recharge.utils.c) com.bytedance.android.live.recharge.utils.j.p.getValue(null, com.bytedance.android.live.recharge.utils.j.a[13]);
            if (r1.getType() == 0) goto L23;
            if (com.bytedance.android.live.incentive.exchange.i.a() == true) goto L23;
            if (r1.getType() != 1) goto L14;
            if (r0 < r13.o().g()) goto L12;
            b(r13, r14, 1);
            return;
        L12:
            b(r13, r14, 0);
            return;
        L14:
            if (r1.getType() == 2) goto L16;
            return;
        L16:
            if (r0 >= r13.o().g()) goto L18;
            b(r13, r14, 0);
            return;
        L18:
            if (r13.o().e() > r1.a()) goto L20;
            d(r13, r14);
            return;
        L20:
            b(r13, r14, 1);
            return;
        L23:
            if (r0 < r13.o().g()) goto L25;
            d(r13, r14);
            return;
        L25:
            b(r13, r14, 0);
        }

        public final void d(Order r8, com.bytedance.android.live.recharge.order.f.b.a r9) {
            com.bytedance.android.live.recharge.deal.f r1 = r8.o();
            int r0 = com.bytedance.android.live.recharge.utils.e.a;
            IExchangeService.ExchangeApiType r2 = com.bytedance.android.live.recharge.utils.e.b(r8.o());
            if (com.bytedance.android.live.incentive.exchange.i.a() == false) goto L5;
            String r3 = "v1";
        L6:
            IExchangeService.b r6 = new IExchangeService.b(r1, r2, r3, false, 14);
            this.a.d.t1(r6, r8.a(), new com.bytedance.android.live.recharge.utils.g(r9));
            return;
        L5:
            r3 = "";
            goto L6
        }

        public final void b(Order r6, com.bytedance.android.live.recharge.order.f.b.a r7, long r8) {
            this.a.getClass();
            int r0 = b.d();
            if (r8 <= 0) goto L5;
            com.bytedance.android.live.recharge.order.j r1 = r6.a().a;
            r1.getClass();
            Intrinsics.checkNotNullParameter(DataType.TRUE, "<set-?>");
            r1.f.b(r1, com.bytedance.android.live.recharge.order.j.i[5], DataType.TRUE);
            this.a.c.a(r6.o(), r6.a(), new com.bytedance.android.live.recharge.utils.h(r7), (int) (r6.o().g() - r8));
            return;
        L5:
            this.a.c.a(r6.o(), r6.a(), new com.bytedance.android.live.recharge.utils.h(r7), r0);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.recharge.exchange.service.b$b, reason: collision with other inner class name */
    public static final class C0064b {
        public static final /* synthetic */ int a = 0;

        static {
        }
    }

    public final class c implements com.bytedance.android.live.recharge.order.e {
        public final /* synthetic */ b a;

        @Override // com.bytedance.android.live.recharge.order.e
        public final void c(com.bytedance.android.live.recharge.order.f.b r2) {
            Intrinsics.checkNotNullParameter(r2, "order");
        }

        public c(b r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.recharge.order.e
        public final void a(Order r14, com.bytedance.android.live.recharge.order.f.b.a r15) {
            Intrinsics.checkNotNullParameter(r14, "order");
            Intrinsics.checkNotNullParameter(r15, "handle");
            com.bytedance.tools.kcp.spongepreference.runtime.a r16 = lw0.a.c;
            KProperty[] r0 = lw0.a.a;
            if (((Boolean) r16.getValue(null, r0[1])).booleanValue() == false) goto L49;
            int r17 = C0064b.a;
            long r4 = System.currentTimeMillis() / 1000;
            long r8 = ((Number) lw0.a.b.getValue(null, r0[0])).longValue();     // Catch: Throwable -> L7
        L56:
            if ((Math.abs(r8 - r4) / ((long) 86400)) >= 7) goto L15;
            boolean r1 = false;
        L16:
            if (r1 == false) goto L49;
            this.a.getClass();
            if (b.d() <= 0) goto L49;
            yz0.k r2 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
            if (r2 == null) goto L22;
            Context r3 = r2.getContext();
        L24:
            if (r3 == null) goto L48;
            int r5 = C0064b.a;
            lw0.a.b.setValue(null, lw0.a.a[0], Long.valueOf(System.currentTimeMillis() / 1000));
            this.a.getClass();
            int r6 = b.d();
            long r7 = r15.a.f.g();
            if (com.bytedance.android.live.incentive.exchange.i.a() == false) goto L28;
            int r9 = 2131915249;
        L29:
            String r10 = s1.B(r9);
            if (com.bytedance.android.live.incentive.exchange.i.a() == false) goto L32;
            int r12 = 2131915256;
        L33:
            long r13 = r6;
            if (r13 < r7) goto L36;
            String r18 = s1.C(2131915254, new Object[]{r10, com.bytedance.android.live.recharge.utils.q.b(r7), e4.a()});
        L39:
            Ref.BooleanRef r19 = new Ref.BooleanRef();
            r19.element = false;
            c9.b r20 = new c9.b();
            r20.a = r3;
            r20.b = 2;
            r20.c = 2131565714;
            r20.e = r3.getText(r12);
            r20.f = r18;
            r20.g = 17;
            r20.p = true;
            r20.q = true;
            d r22 = new d(this, r15, r19);
            r20.j = r20.a.getText(2131915257);
            r20.k = r22;
            e r23 = new e(this, r15, r19);
            r20.l = r20.a.getText(2131915258);
            r20.m = r23;
            c9 r24 = new c9(r20.a, r20);
            ((ExchangeConfirmDefaultView) r24.e.findViewById(2131371844)).setMOnSelectClickListner(new com.bytedance.android.live.recharge.exchange.service.c(r19));
            Window r25 = r24.getWindow();
            if (r25 == null) goto L43;
            r25.setWindowAnimations(2131954599);
        L43:
            if (DialogLancet.shouldBlockDialogShow(r24) == false) goto L52;
            DialogLancet.handleBlockedDialogShow(r24);
        L47:
            com.bytedance.android.live.recharge.order.k r110 = r15.a.g;
            Map r111 = MapsKt.mapOf(new Pair[]{TuplesKt.to("request_page", r110.a.b()), TuplesKt.to("charge_reason", r110.a.a())});
            HashMap<Class<?>, com.bytedance.android.livesdk.revenue.log.d<?>> r26 = com.bytedance.android.live.recharge.utils.f.a;
            com.bytedance.android.live.recharge.utils.f.d("livesdk_balance_deduction_popup_show", r111, new Class[]{IRoom.class, x.class});
            return;
        L52:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L51
        L46:
            DialogLancet.beforeDialogShow(r24);
            r24.show();
            DialogLancet.afterDialogShow(r24);
            goto L47
        L36:
            if (r6 <= 0) goto L38;
            r18 = s1.C(2131915253, new Object[]{r10, com.bytedance.android.live.recharge.utils.q.b(r13), com.bytedance.android.live.recharge.utils.q.b(r7 - r13), e4.a()});
            goto L39
        L38:
            r18 = "";
            goto L39
        L32:
            r12 = 2131915255;
            goto L33
        L28:
            r9 = 2131915250;
            goto L29
        L48:
            jy0.b.c("CombinedPayProcessor", "Context is not available, processor is skipped", null, 4);
            r15.f();
            return;
        L22:
            r3 = null;
        L15:
            r1 = true;
        L7:
            r8 = 0;
        L49:
            r15.f();
        }

        public static final void b(c r2, com.bytedance.android.live.recharge.order.k r3, boolean r4, boolean r5) {
            r2.getClass();
            Pair[] r6 = new Pair[4];
            r6[0] = TuplesKt.to("request_page", r3.a.b());
            r6[1] = TuplesKt.to("charge_reason", r3.a.a());
            if (r5 == false) goto L5;
            String r7 = DataType.TRUE;
        L6:
            r6[2] = TuplesKt.to("if_deduction_default", r7);
            if (r4 == false) goto L9;
            String r8 = "yes";
        L10:
            r6[3] = TuplesKt.to("button_type", r8);
            Map r9 = MapsKt.mapOf(r6);
            HashMap<Class<?>, com.bytedance.android.livesdk.revenue.log.d<?>> r10 = com.bytedance.android.live.recharge.utils.f.a;
            com.bytedance.android.live.recharge.utils.f.d("livesdk_balance_deduction_popup_click", r9, new Class[]{IRoom.class, x.class});
            return;
        L9:
            r8 = "no";
            goto L10
        L5:
            r7 = DataType.FALSE;
            goto L6
        }
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    public static int d() {
        ExchangeInfo r0 = RechargeCenter.getInstance().getExchangeInfo();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getExchangeBalance();
    }

    @Override // com.bytedance.android.live.recharge.order.e
    public final void c(com.bytedance.android.live.recharge.order.f.b r2) {
        Intrinsics.checkNotNullParameter(r2, "order");
        if (r2.f.c().b() == true) goto L5;
        return;
    L5:
        if (com.bytedance.android.live.recharge.utils.j.c() == false) goto L8;
        return;
    L8:
        if (r2.g.e == true) goto L10;
        return;
    L10:
        r2.b(this);
    }

    public b(PayService r2, n r3) {
        Intrinsics.checkNotNullParameter(r2, "payService");
        Intrinsics.checkNotNullParameter(r3, "exchangeService");
        this.c = r2;
        this.d = r3;
        this.a = new a(this);
        this.b = new c(this);
    }

    @Override // com.bytedance.android.live.recharge.order.e
    public final void a(Order r2, com.bytedance.android.live.recharge.order.f.b.a r3) {
        Intrinsics.checkNotNullParameter(r2, "order");
        Intrinsics.checkNotNullParameter(r3, "handle");
        if (r2.a().f == false) goto L5;
        r3.e(this.a);
        return;
    L5:
        r3.e(this.b);
    }
}
