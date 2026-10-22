package com.bytedance.android.live.recharge.service;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.android.live.revenue.common.u;
import com.bytedance.android.livesdk.event.v;
import com.bytedance.android.livesdkapi.eventbus.ReOpenRechargeEvent;
import com.bytedance.android.scope.o;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import yz0.m;
import zg1.x2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements o, m {
    public final CompositeDisposable a;
    public final yz0.k b;

    /* JADX INFO: renamed from: com.bytedance.android.live.recharge.service.a$a, reason: collision with other inner class name */
    public static final class C0074a<T> implements Consumer {
        public final /* synthetic */ a a;

        public C0074a(a r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Object r3 = ((ReOpenRechargeEvent) r2).getExtra();
            if ((r3 instanceof x2) == false) goto L9;
            x2 r4 = (x2) r3;
            if (r4.n == false) goto L7;
            this.a.d(r4);
            return;
        L7:
            this.a.c(r4);
            return;
        }
    }

    public final void onStart() {
    }

    @Override // yz0.m
    public final void onViewReady() {
    }

    @Override // yz0.m
    public final void onWidgetLoaded() {
    }

    @Override // yz0.m
    public final void x() {
    }

    private final Context getContext() {
        return this.b.getContext();
    }

    @Override // yz0.m
    public final void i() {
        this.a.add(xs2.b.a().b(ReOpenRechargeEvent.class).subscribe(new C0074a(this)));
        CompositeDisposable r1 = this.a;
        Observable r0 = xs2.b.a().b(x2.class);
        b r2 = new b(this);
        c r3 = c.a;
        r1.add(r0.subscribe(r2, r3));
        this.a.add(xs2.b.a().b(v.class).subscribe(new b(this), r3));
    }

    public final void onStop() {
        this.a.clear();
    }

    public a(yz0.k r2) {
        Intrinsics.checkNotNullParameter(r2, "roomDataService");
        this.b = r2;
        this.a = new CompositeDisposable();
    }

    public final void c(x2 r35) {
        String r1 = r35.o;
        if (r1 != null) goto L5;
    L12:
        r1 = "live_detail";
    L13:
        String r8 = r1;
        String r7 = r35.d;
        if (TextUtils.equals(r35.c, "gift_guide") == false) goto L16;
        String r14 = "guide";
    L18:
        if (TextUtils.equals(r35.c, "gift_guide") == false) goto L20;
        String r15 = "call";
    L21:
        long r9 = r35.g;
        if (r9 <= 0) goto L24;
        boolean r12 = true;
    L25:
        int r13 = r35.f;
        long r3 = r35.h;
        int r2 = r35.j;
        long r5 = r35.i;
        long r4 = r35.k;
        if (TextUtils.isEmpty(r35.l) == true) goto L28;
        String r24 = r35.l;
    L29:
        Map r16 = r35.q;
        if (r16 == null) goto L33;
        Map r17 = MapsKt.toMutableMap(r16);
        if (r17 == null) goto L33;
    L34:
        com.bytedance.android.live.recharge.model.d r6 = new com.bytedance.android.live.recharge.model.d(true, r7, r8, r9, r12, r13, 0, r14, r15, new com.bytedance.android.live.recharge.model.b(null, r24, r4, r5, r3, r2, new com.bytedance.android.live.recharge.model.a(r17), 129), null, r35.p, null, 29760);
        IRechargeService r10 = (IRechargeService) jc1.k.n(IRechargeService.class);
        FragmentActivity r18 = getContext();
        if (r18 == null) goto L63;
        r10.showRechargeDialogFragment(r18, r6, null);
        int r19 = com.bytedance.android.live.recharge.utils.m.a;
        String r20 = r35.r;
        if (r20 != null) goto L39;
        String r22 = "";
    L40:
        String r23 = r35.o;
        if (r23 != null) goto L43;
        String r25 = "";
    L44:
        String r26 = r35.b;
        if (r26 != null) goto L47;
        String r27 = "";
    L48:
        String r28 = r35.d;
        if (r28 != null) goto L51;
        String r29 = "";
    L52:
        long r30 = r35.g;
        long r32 = r35.h;
        long r110 = r35.i;
        int r111 = r35.f;
        String r33 = r35.p;
        if (r33 != null) goto L55;
        String r112 = "";
    L56:
        String r0 = r35.s;
        if (r0 != null) goto L59;
        String r113 = "";
    L60:
        com.bytedance.android.live.recharge.utils.m.n(r22, r25, r27, r29, r30, r32, r110, r111, r112, r113, null, 3072);
        return;
    L59:
        r113 = r0;
        goto L60
    L55:
        r112 = r33;
        goto L56
    L51:
        r29 = r28;
        goto L52
    L47:
        r27 = r26;
        goto L48
    L43:
        r25 = r23;
        goto L44
    L39:
        r22 = r20;
        goto L40
    L63:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L33:
        r17 = new LinkedHashMap();
        goto L34
    L28:
        r24 = "";
        goto L29
    L24:
        r12 = false;
        goto L25
    L20:
        r15 = "";
        goto L21
    L16:
        r14 = "";
        goto L18
    L5:
        if (r1.length() <= 0) goto L7;
        boolean r34 = true;
    L8:
        if (r34 == true) goto L11;
        r1 = null;
    L11:
        if (r1 != null) goto L13;
    L7:
        r34 = false;
        goto L8
    }

    public final void d(x2 r5) {
        String r0 = (String) com.bytedance.android.live.recharge.util.g.c.getValue(null, com.bytedance.android.live.recharge.util.g.a[1]);
        if (TextUtils.isEmpty(r0) == true) goto L6;
        HashMap r1 = new HashMap();
        r1.put("previous_gift_id", String.valueOf(r5.h));
        r1.put("previous_gift_money", String.valueOf(r5.i));
        r1.put("previous_pay_money", String.valueOf(r5.k));
        r1.put("money_diff", String.valueOf(r5.g));
        r1.put("previous_gift_type", r5.l.toString());
        r1.put("diamond", String.valueOf(r5.m));
        r1.put("is_protrait", String.valueOf(this.b.isPortraitInteraction()));
        String r6 = u.a(r0, r1);
        ((zz0.g) com.bytedance.android.live.revenue.core.util.f.a(zz0.g.class)).S2(getContext(), r6);
        return;
    }

    public static final void a(a r2, x2 r3) {
        r2.getClass();
        if (r3 == null) goto L21;
        int r0 = r3.getType();
        if (r0 == 0) goto L17;
        if (r0 == 1) goto L17;
        if (r0 != 2) goto L24;
        wh6.a r4 = vh6.c.b(wh6.a.class);
        Context r5 = r2.getContext();
        if (r5 == null) goto L15;
        r4.openWallet((Activity) r5);
        return;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    L24:
        return;
    L17:
        if (r3.n == false) goto L19;
        r2.d(r3);
        return;
    L19:
        r2.c(r3);
        return;
    }
}
