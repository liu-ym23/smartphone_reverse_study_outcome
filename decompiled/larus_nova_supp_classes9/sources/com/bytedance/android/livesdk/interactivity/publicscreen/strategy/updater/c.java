package com.bytedance.android.livesdk.interactivity.publicscreen.strategy.updater;

import am2.x;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.dynamicstrategy.api.IDynamicStrategyContext;
import com.bytedance.android.livesdk.gift.model.CardLockInfo;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.model.e;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.TextMessageTracer;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.q;
import com.bytedance.android.livesdk.interactivity.api.settings.config.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IPublicScreenSpeedConfig;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.live.datacontext.j;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import ec2.d1;
import f32.f;
import f32.h;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import ju1.g;
import ju1.n;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c extends com.bytedance.android.livesdk.interactivity.publicscreen.strategy.updater.a {
    public final int c;
    public d d;
    public final o e;
    public final PropertyOwner<n> f;
    public Disposable g;
    public final IPublicScreenSpeedConfig h;
    public e i;
    public e j;
    public e k;
    public final o72.e l;
    public long m;
    public final Boolean n;
    public Disposable o;
    public h p;
    public final b q;
    public int r;
    public int s;
    public int t;
    public int u;
    public final j0 v;
    public final boolean w;

    public static final class a {
    }

    public static final class b implements h32.d<h> {
        public final /* synthetic */ c a;

        public b(c r1) {
            this.a = r1;
        }

        @Override // h32.d
        public final void a(f r9) {
            h r10 = (h) r9;
            Intrinsics.checkNotNullParameter(r10, "newConfig");
            c r0 = this.a;
            r0.p = r10;
            if (r10.a <= 0) goto L11;
            boolean r11 = TextMessageTracer.a;
            TextMessageTracer.A("trigger degrade, use degrade speed config");
            c r13 = this.a;
            c r7 = this.a;
            int r4 = r7.p.a;
            r13.j = new e(1000, r4, r4, 750);
            if (r7.n.booleanValue() == false) goto L9;
            e r14 = r7.j;
            if (r14 != null) goto L10;
            r14 = r7.i;
        L10:
            c.k(r7, r14);
            return;
        L9:
            r14 = r7.i;
            goto L10
        L11:
            r0.j = null;
            if (r0.n.booleanValue() == false) goto L16;
            e r15 = r0.j;
            if (r15 != null) goto L17;
            r15 = r0.i;
        L17:
            c.k(r0, r15);
            return;
        L16:
            r15 = r0.i;
            goto L17
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.publicscreen.strategy.updater.c$c, reason: collision with other inner class name */
    public static final class C0193c<T> implements Consumer {
        public final /* synthetic */ c a;

        public C0193c(c r1) {
            this.a = r1;
        }

        public final void accept(Object r13) {
            g r14 = (n) r13;
            c r0 = this.a;
            int r1 = q.a;
            r0.i = q.h(r0.v, r14.b(r0.c), this.a.h);
            c r2 = this.a;
            c.k(r2, r2.i);
            boolean r3 = this.a.w;
            List<String> r4 = wa2.a.a;
            Intrinsics.checkNotNullParameter(r14, "speed");
            Object r5 = r14.c();
            if (Intrinsics.areEqual(r5, 0) == false) goto L6;
            String r6 = "lowest";
        L18:
            boolean r7 = r14 instanceof g;
            String r8 = BuildConfig.FLAVOR;
            if (r7 == false) goto L36;
            LinkedHashMap r9 = new LinkedHashMap();
            g r15 = r14;
            Iterator<T> r10 = r15.d.iterator();
        L23:
            if (r10.hasNext() == false) goto L30;
            String r11 = (String) r10.next();
            Object r16 = r15.c.get(r11);
            if (r16 == null) goto L28;
            String r17 = r16.toString();
            if (r17 == null) goto L28;
        L29:
            r9.put(r11, r17);
        L28:
            r17 = BuildConfig.FLAVOR;
            goto L29
        L30:
            Gson r18 = GsonHelper.get();
            if (r18 == null) goto L36;
            String r19 = GsonProtectorUtils.toJson(r18, r9);
            if (r19 == null) goto L36;
            r8 = r19;
        L36:
            Pair[] r110 = new Pair[4];
            r110[0] = TuplesKt.to("comment_show_speed", r6);
            r110[1] = TuplesKt.to("speed_change_reason", r8);
            if (r3 == false) goto L39;
            String r20 = "1";
        L40:
            r110[2] = TuplesKt.to("is_anchor", r20);
            r110[3] = TuplesKt.to("strategy_type", "speed_formula");
            Map r111 = MapsKt.mapOf(r110);
            com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_comment_show_speed", r111, new Object[]{IRoom.class, x.class});
            return;
        L39:
            r20 = "0";
            goto L40
        L6:
            if (Intrinsics.areEqual(r5, 1) == false) goto L9;
            r6 = "low";
            goto L18
        L9:
            if (Intrinsics.areEqual(r5, 2) == false) goto L12;
            r6 = "normal";
            goto L18
        L12:
            if (Intrinsics.areEqual(r5, 3) == false) goto L15;
            r6 = "high";
            goto L18
        L15:
            if (Intrinsics.areEqual(r5, 4) == false) goto L17;
            r6 = "highest";
            goto L18
        L17:
            r6 = CardLockInfo.sUNKNOWN;
            goto L18
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.BaseTimingUpdater
    public final void c() {
        boolean r0 = this.w;
        int r3 = 0;
        if (r0 == true) goto L7;
        int r4 = this.t;
        if (r4 <= 0) goto L7;
        this.u = 2;
        this.t = 0;
        ka2.a r1 = new ka2.a(r4, r4, 0);
        r1.a = true;
    L20:
        e(r1);
        return;
    L7:
        if (r0 == true) goto L11;
        int r5 = this.r;
        if (r5 >= this.s) goto L11;
        this.u = 2;
        this.r = r5 + 1;
        r1 = new ka2.a(this.l.c(), this.l.c(), 0);
    L11:
        if (r0 == true) goto L15;
        int r2 = this.u;
        if (r2 >= 2) goto L15;
        this.u = r2 + 1;
        int r6 = this.k.b;
        r1 = new ka2.a(r6, r6, 0);
    L15:
        int r7 = this.k.b;
        int r8 = r7 + r7;
        if (System.currentTimeMillis() >= this.m) goto L18;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.n.b(DynamicSpeedMessageUpdaterV2$getUpdateInfo$2.INSTANCE);
    L19:
        r1 = new ka2.a(r8, r7, r3);
        goto L20
    L18:
        r3 = this.k.c;
        goto L19
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.BaseTimingUpdater
    public final long d() {
        if (this.w == true) goto L9;
        if (this.r >= this.s) goto L9;
        return this.l.d();
    L9:
        return this.k.a;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.BaseTimingUpdater
    public final void g() {
        super.g();
        Disposable r0 = this.g;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        PropertyOwner<n> r1 = this.f;
        Disposable r2 = null;
        if (r1 == null) goto L12;
        Observable r3 = com.bytedance.android.live.core.arch.mvvm.f.b(r1);
        if (r3 == null) goto L12;
        Observable r4 = RxUtilKt.h(r3);
        if (r4 == null) goto L12;
        Disposable r5 = r4.subscribe(new C0193c(this));
    L13:
        this.g = r5;
        if (this.n.booleanValue() == false) goto L37;
        Disposable r6 = this.o;
        if (r6 == null) goto L18;
        r6.dispose();
    L18:
        o r7 = this.e;
        if (r7 == null) goto L23;
        j r8 = r7.M1();
        if (r8 == null) goto L23;
        ViewModel r9 = (ViewModel) r8.getValue();
    L25:
        if ((r9 instanceof com.bytedance.android.livesdk.interactivity.api.h) == true) goto L27;
        r9 = null;
    L27:
        com.bytedance.android.livesdk.interactivity.api.h r10 = (com.bytedance.android.livesdk.interactivity.api.h) r9;
        if (r10 == null) goto L36;
        j<h32.a> r11 = r10.getDegradeManager();
        if (r11 == null) goto L36;
        h32.a r13 = (h32.a) r11.getValue();
        if (r13 == null) goto L36;
        h32.c<h> r14 = r13.h();
        if (r14 == null) goto L36;
        r2 = g32.b.a(r14, this.q);
    L36:
        this.o = r2;
    L23:
        r9 = null;
    L37:
        d r15 = this.d;
        if (r15 == null) goto L41;
        e r16 = this.k;
        r15.update(r16.d, r16.a);
        return;
    L41:
        return;
    L12:
        r5 = null;
        goto L13
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.BaseTimingUpdater
    public final void i() {
        super.i();
        Disposable r0 = this.g;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        Disposable r1 = this.o;
        if (r1 == null) goto L9;
        r1.dispose();
        return;
    }

    public static final void k(c r3, e r4) {
        r3.k = r4;
        boolean r5 = TextMessageTracer.a;
        TextMessageTracer.A("speed updateInterval:" + r3.k.a + ",scrollSpeed:" + r3.k.d);
        d r6 = r3.d;
        if (r6 == null) goto L6;
        e r7 = r3.k;
        r6.update(r7.d, r7.a);
        return;
    }

    public c(IRoom r7, j0 r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r8, "config");
        this.v = r8;
        this.w = r9;
        this.c = 2;
        IRoomContextService r10 = k.f(IRoomContextService.class);
        long r1 = 0;
        PropertyOwner<n> r3 = null;
        if (r10 == null) goto L8;
        if (r7 == null) goto L6;
        long r4 = r7.getRoomId();
    L7:
        o r11 = IRoomContextService.a.a(r10, null, r4, 1);
    L9:
        this.e = r11;
        IRoomContextService r13 = k.f(IRoomContextService.class);
        if (r13 == null) goto L20;
        if (r7 == null) goto L13;
        r1 = r7.getRoomId();
    L13:
        o r14 = IRoomContextService.a.a(r13, null, r1, 1);
        if (r14 == null) goto L20;
        j r15 = r14.r2();
        if (r15 == null) goto L20;
        IDynamicStrategyContext r16 = (IDynamicStrategyContext) r15.getValue();
        if (r16 == null) goto L20;
        r3 = r16.getStrategy("public_screen_speed_strategy");
    L20:
        this.f = r3;
        IPublicScreenSpeedConfig r17 = q.g(r7);
        this.h = r17;
        e r18 = q.h(r8, -1, r17);
        this.i = r18;
        this.k = r18;
        this.l = (o72.e) d1.a.getValue();
        this.n = (Boolean) com.bytedance.android.livesdk.interactivity.service.settings.b.a.getValue();
        this.p = new h(0);
        this.q = new b(this);
        return;
    L6:
        r4 = 0;
        goto L7
    L8:
        r11 = null;
        goto L9
    }
}
