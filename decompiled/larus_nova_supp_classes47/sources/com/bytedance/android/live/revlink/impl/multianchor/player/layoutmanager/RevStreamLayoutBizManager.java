package com.bytedance.android.live.revlink.impl.multianchor.player.layoutmanager;

import android.graphics.RectF;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.monitor.LiveTracingMonitorKt;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.revlink.impl.multianchor.utils.MultiFeedUtils;
import com.bytedance.android.scope.m;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import kotlin.ExceptionsKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import oq2.e;
import org.json.JSONObject;
import rc0.h;
import y41.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class RevStreamLayoutBizManager implements h {
    public String a;
    public String b;
    public boolean c;
    public boolean d;
    public String e;
    public String f;
    public boolean g;
    public boolean h;
    public RectF i;
    public boolean j;
    public Integer k;
    public final CompositeDisposable l;
    public Function0<Unit> m;
    public final com.bytedance.android.live.revlink.impl.multianchor.player.layoutmanager.c n;
    public cy0.c o;
    public final Function0<FrameLayout> p;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ RevStreamLayoutBizManager a;

        public a(RevStreamLayoutBizManager r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            sh6.b r3 = (sh6.b) r2;
            this.a.b("customMultiBgUrl");
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ RevStreamLayoutBizManager a;

        public b(RevStreamLayoutBizManager r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            sh6.b r3 = (sh6.b) r2;
            this.a.b("customPkBgUrl");
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ RevStreamLayoutBizManager a;

        public c(RevStreamLayoutBizManager r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            sh6.b r5 = (sh6.b) r4;
            RevStreamLayoutBizManager r6 = this.a;
            ld.a r0 = r6.c();
            if (r0 == null) goto L9;
            NextLiveData r1 = r0.Rm();
            if (r1 == null) goto L9;
            e r2 = (e) r1.getValue();
            if (r2 == null) goto L9;
            Integer r3 = r2.c;
        L10:
            if (r0 == null) goto L18;
            NextLiveData r7 = r0.Rm();
            if (r7 == null) goto L18;
            e r8 = (e) r7.getValue();
            if (r8 == null) goto L18;
            boolean r9 = true;
            if (r8.d != true) goto L18;
        L19:
            if (r3 != null) goto L22;
        L28:
            this.a.b("revStreamRenderData");
            return;
        L22:
            if (r3.intValue() != 6) goto L28;
            if (r9 == false) goto L28;
            Function0<Unit> r10 = r6.m;
            if (r10 == null) goto L28;
            Unit r12 = (Unit) r10.invoke();
        L18:
            r9 = false;
        L9:
            r3 = null;
            goto L10
        }
    }

    public final ld.a c() {
        cy0.c r0 = this.o;
        if (r0 != null) goto L7;
        return null;
    L7:
        return (ld.a) m.e.d(r0, ld.a.class);
    }

    public final void detach() {
        this.l.clear();
        this.m = null;
        FrameLayout r0 = (FrameLayout) this.p.invoke();
        if (r0 == null) goto L6;
        int r1 = MultiFeedUtils.a;
        MultiFeedUtils.b(r0);
        return;
    }

    public RevStreamLayoutBizManager(Function0 r2) {
        Intrinsics.checkNotNullParameter(r2, "playerViewProducer");
        this.p = r2;
        d51.c r3 = d51.c.A0;
        this.a = r3.k();
        this.b = r3.j();
        this.e = "";
        this.f = "";
        this.l = new CompositeDisposable();
        this.n = new com.bytedance.android.live.revlink.impl.multianchor.player.layoutmanager.c();
    }

    public final void E(cy0.a r3) {
        if (r3 == null) goto L6;
        xq2.a r4 = (xq2.a) m.e.d(r3, xq2.a.class);
        if (r4 == null) goto L6;
        cy0.c r5 = r4.c0();
    L7:
        if (r5 == null) goto L10;
        this.o = r5;
        return;
    L10:
        return;
    L6:
        r5 = null;
        goto L7
    }

    public final void a(Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "checkOrientationFunc");
        this.m = r3;
        ld.a r4 = c();
        if (r4 == null) goto L11;
        NextLiveData r0 = r4.Ed();
        if (r0 == null) goto L11;
        Observable r1 = ld.c.a(r0);
        if (r1 == null) goto L11;
        Disposable r2 = r1.subscribe(new a(this));
        if (r2 == null) goto L11;
        RxUtilKt.c(r2, this.l);
    L11:
        if (r4 == null) goto L19;
        NextLiveData r5 = r4.zn();
        if (r5 == null) goto L19;
        Observable r6 = ld.c.a(r5);
        if (r6 == null) goto L19;
        Disposable r7 = r6.subscribe(new b(this));
        if (r7 == null) goto L19;
        RxUtilKt.c(r7, this.l);
    L19:
        if (r4 == null) goto L27;
        NextLiveData r8 = r4.Rm();
        if (r8 == null) goto L27;
        Observable r9 = ld.c.a(r8);
        if (r9 == null) goto L27;
        Disposable r10 = r9.subscribe(new c(this));
        if (r10 == null) goto L27;
        RxUtilKt.c(r10, this.l);
    L27:
        b("init");
    }

    public final void b(String r27) {
        final FrameLayout r1 = (FrameLayout) this.p.invoke();
        if (r1 != null) goto L5;
        return;
    L5:
        final ld.a r2 = c();
        if (r2 == null) goto L10;
        NextLiveData r4 = r2.Rm();
        if (r4 == null) goto L10;
        e r5 = (e) r4.getValue();
    L11:
        if (r5 == null) goto L13;
        final RectF r6 = r5.a;
    L14:
        boolean r7 = false;
        if (r5 != null) goto L17;
    L19:
        boolean r8 = false;
    L20:
        if (r5 == null) goto L22;
        Integer r9 = r5.c;
    L24:
        if (r9 != null) goto L27;
    L46:
        if (r2 == null) goto L52;
        NextLiveData r10 = r2.Ed();
        if (r10 == null) goto L52;
        oq2.a r12 = (oq2.a) r10.getValue();
        if (r12 == null) goto L52;
        r7 = r12.c;
    L52:
        this.c = r7;
        if (r2 == null) goto L60;
        NextLiveData r13 = r2.Ed();
        if (r13 == null) goto L60;
        oq2.a r14 = (oq2.a) r13.getValue();
        if (r14 == null) goto L60;
        String r15 = r14.a;
        if (r15 == null) goto L60;
    L61:
        this.a = r15;
        if (r2 == null) goto L69;
        NextLiveData r16 = r2.Ed();
        if (r16 == null) goto L69;
        oq2.a r17 = (oq2.a) r16.getValue();
        if (r17 == null) goto L69;
        String r18 = r17.b;
        if (r18 == null) goto L69;
    L70:
        this.b = r18;
    L72:
        if (Intrinsics.areEqual(this.e, this.a) == true) goto L74;
    L103:
        this.i = r6;
        this.j = r8;
        this.k = r9;
        com.bytedance.android.live.revlink.impl.multianchor.player.layoutmanager.c r19 = this.n;
        r19.getClass();
        Intrinsics.checkNotNullParameter(r27, "source");
        long r110 = System.currentTimeMillis();
        long r111 = r110 - r19.b;
        f r112 = f.N;
        r112.getClass();
        ReadOnlyProperty r113 = f.J;
        KProperty[] r114 = f.a;
        if (r111 <= ((com.bytedance.android.live.revlink.impl.multianchor.player.layoutmanager.a) r113.getValue(r112, r114[34])).Z()) goto L106;
        StringBuilder r115 = new StringBuilder("monitor reset with last count ");
        r115.append(r19.a);
        r115.append(", time: ");
        Integer r116 = r9;
        r115.append(r19.b);
        jy0.b.c("MultiBgMonitor", r115.toString(), null, 4);
        r19.a = 1;
        r19.b = r110;
    L114:
        if (r116 != null) goto L117;
    L121:
        if (r116 != null) goto L124;
    L128:
        if (r116 != null) goto L131;
    L135:
        UtilityKotlinExtentionsKt.s(0, false, r112.i(), new RevStreamLayoutBizManager$onReceiveBgUpdateEvent$4(this, r1), 3);
        return;
    L131:
        if (r116.intValue() != 2) goto L135;
        if (r8 == false) goto L135;
        if (r6 == null) goto L135;
        UtilityKotlinExtentionsKt.s(0, false, r112.i(), new RevStreamLayoutBizManager$onReceiveBgUpdateEvent$3(this, r2, r1, r6), 3);
        return;
    L124:
        if (r116.intValue() != 19) goto L128;
        if (r8 == false) goto L128;
        if (r6 == null) goto L128;
        UtilityKotlinExtentionsKt.s(0, false, r112.i(), new RevStreamLayoutBizManager$onReceiveBgUpdateEvent$2(this, r1, r6), 3);
        return;
    L117:
        if (r116.intValue() != 6) goto L121;
        if (r8 == false) goto L121;
        if (r6 == null) goto L121;
        UtilityKotlinExtentionsKt.s(0, false, r112.i(), new RevStreamLayoutBizManager$onReceiveBgUpdateEvent$1(this, r1, r6), 3);
        return;
    L106:
        r116 = r9;
        r19.a++;
        jy0.b.c("MultiBgMonitor", "monitor update with new count " + r19.a, null, 4);
        if (r19.a < ((com.bytedance.android.live.revlink.impl.multianchor.player.layoutmanager.a) r113.getValue(r112, r114[34])).K7()) goto L114;
        if (((com.bytedance.android.live.revlink.impl.multianchor.player.layoutmanager.a) r113.getValue(r112, r114[34])).l9() == false) goto L114;
        JSONObject r3 = new JSONObject();
        BaseMonitor.add(r3, "business_api_name", "multi_too_much_bg_update");
        BaseMonitor.add(r3, "stacktrace", ExceptionsKt.stackTraceToString(new Exception()));
        HashMap r20 = new HashMap();
        r20.put("business_api_name", "multi_too_much_bg_update");
        r20.put("android_event_key", "multi_too_much_bg_update");
        com.bytedance.android.live.revenuelink.f r22 = com.bytedance.android.live.revlink.impl.global.b.g0();
        if (r22 == null) goto L114;
        com.bytedance.android.live.revenuelink.f.a.a(r22, "ttlive_pk_business_api_call", LiveTracingMonitorKt.EventModule.MULTI_LINKER, r20, r3);
        goto L114
    L74:
        if (Intrinsics.areEqual(this.f, this.b) == false) goto L103;
        if (this.g != this.c) goto L103;
        if (this.h != this.d) goto L103;
        RectF r23 = this.i;
        if (r23 == null) goto L82;
        Float r24 = Float.valueOf(r23.top);
    L83:
        if (r6 == null) goto L85;
        Float r117 = Float.valueOf(r6.top);
    L87:
        if (Intrinsics.areEqual(r24, r117) == false) goto L103;
        RectF r25 = this.i;
        if (r25 == null) goto L91;
        Float r26 = Float.valueOf(r25.bottom);
    L92:
        if (r6 == null) goto L94;
        Float r118 = Float.valueOf(r6.bottom);
    L96:
        if (Intrinsics.areEqual(r26, r118) == false) goto L103;
        if (this.j != r8) goto L103;
        if (Intrinsics.areEqual(this.k, r9) == false) goto L103;
        jy0.b.d("RevStreamLayoutBizManager", "block background change for same url");
        return;
    L94:
        r118 = null;
        goto L96
    L91:
        r26 = null;
        goto L92
    L85:
        r117 = null;
        goto L87
    L82:
        r24 = null;
    L69:
        r18 = d51.c.A0.j();
    L60:
        r15 = d51.c.A0.k();
        goto L61
    L27:
        if (r9.intValue() != 2) goto L46;
        oq2.b r119 = (oq2.b) r2.zn().getValue();
        if (r119 == null) goto L31;
        boolean r120 = r119.c;
    L32:
        this.c = r120;
        oq2.b r121 = (oq2.b) r2.zn().getValue();
        if (r121 == null) goto L35;
        r7 = r121.d;
    L35:
        this.d = r7;
        oq2.b r28 = (oq2.b) r2.zn().getValue();
        if (r28 == null) goto L39;
        String r29 = r28.a;
        if (r29 == null) goto L39;
    L40:
        this.a = r29;
        oq2.b r30 = (oq2.b) r2.zn().getValue();
        if (r30 == null) goto L44;
        String r32 = r30.b;
        if (r32 == null) goto L44;
    L45:
        this.b = r32;
    L44:
        r32 = d51.c.A0.j();
    L39:
        r29 = d51.c.A0.k();
        goto L40
    L31:
        r120 = false;
        goto L32
    L22:
        r9 = null;
        goto L24
    L17:
        if (r5.b != true) goto L19;
        r8 = true;
        goto L20
    L13:
        r6 = null;
    L10:
        r5 = null;
        goto L11
    }
}
