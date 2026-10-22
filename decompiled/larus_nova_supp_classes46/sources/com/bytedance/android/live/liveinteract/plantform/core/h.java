package com.bytedance.android.live.liveinteract.plantform.core;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h {
    public final Lazy a;
    public WeakReference<ei6.a> b;
    public WeakReference<uf2.d0> c;
    public Integer d;
    public Integer e;
    public List<ILinkPlayerInfoBridge> f;
    public final AtomicBoolean g;
    public final Lazy h;
    public final j i;
    public final i j;
    public final IRoom k;
    public final DataCenter l;
    public com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> m;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ h a;

        public b(h r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Long r2 = (Long) r1;
            this.a.e();
        }
    }

    static {
    }

    public final com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> c() {
        if (this.m != null) goto L8;
        ALogger.i("BlackFrameManager", "getLinkUserCenter ;; mLinkUserCenter == " + this.m);
        IRoom r0 = this.k;
        DataCenter r1 = this.l;
        if (r0 == null) goto L8;
        if (r1 == null) goto L8;
        this.m = new y(r0, r1);
    L8:
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r2 = this.m;
        if (r2 == null) goto L12;
        return r2;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.base.ILinkUserInfoCenter<com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge>");
    }

    public final void e() {
        Integer r0 = this.d;
        WeakReference<uf2.d0> r1 = this.c;
        ei6.a r2 = null;
        if (r1 == null) goto L9;
        uf2.d0 r3 = r1.get();
        if (r3 == null) goto L9;
        uf2.d0.a r4 = r3.getBuilder();
        if (r4 == null) goto L9;
        Integer r5 = Integer.valueOf(r4.g());
    L11:
        if ((!Intrinsics.areEqual(r0, r5)) == false) goto L16;
        Integer r6 = this.e;
        WeakReference<ei6.a> r7 = this.b;
        if (r7 == null) goto L15;
        r2 = r7.get();
    L15:
        f(r6, r2, "video_capture_device_change");
    L16:
        Disposable r8 = Observable.timer(((Number) this.a.getValue()).longValue(), TimeUnit.SECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(this));
        if (r8 == null) goto L20;
        RxUtilKt.c(r8, (CompositeDisposable) this.h.getValue());
        return;
    L20:
        return;
    L9:
        r5 = null;
        goto L11
    }

    public final void a() {
        c().Q4(this.i);
        hd0.c.f().c(this.j);
    }

    public final void b() {
        c().T4(this.i);
        hd0.c.f().e(this.j);
        this.e = null;
        this.f = null;
        this.d = null;
        this.b = null;
        this.c = null;
        ((CompositeDisposable) this.h.getValue()).clear();
    }

    public final void d(WeakReference<ei6.a> r1, WeakReference<uf2.d0> r2) {
        this.b = r1;
        this.c = r2;
        this.i.onOnlineListChanged(this.f);
        e();
    }

    public h(IRoom r1, DataCenter r2, y r3) {
        this.k = r1;
        this.l = r2;
        this.m = r3;
        this.a = LazyKt.lazy(BlackFrameManager$pollingTime$2.INSTANCE);
        this.g = new AtomicBoolean(false);
        this.h = LazyKt.lazy(BlackFrameManager$compositeDisposable$2.INSTANCE);
        this.i = new j(this);
        this.j = new i(this);
    }

    public final void f(Integer r5, ei6.a r6, String r7) {
        if (je0.d.O() == false) goto L8;
        if (((Boolean) vm2.d.G3.getValue(null, vm2.d.a[238(0xee, float:3.34E-43)])).booleanValue() == true) goto L10;
        return;
    L10:
        WeakReference<uf2.d0> r0 = this.c;
        if (r0 == null) goto L17;
        uf2.d0 r1 = r0.get();
        if (r1 == null) goto L17;
        uf2.d0.a r2 = r1.getBuilder();
        if (r2 == null) goto L17;
        Integer r3 = Integer.valueOf(r2.g());
    L18:
        this.d = r3;
        StringBuilder r4 = new StringBuilder("source == ");
        r4.append(r7);
        r4.append(" ;; switchVideoSourceType ;; currentLinktype == ");
        r4.append(r5);
        r4.append(" ;; client == ");
        r4.append(r6);
        r4.append(" ;; rtcEngine == ");
        if (r6 == null) goto L23;
        ui6.d r8 = r6.l();
        if (r8 == null) goto L23;
        mi6.a r9 = r8.b();
    L24:
        r4.append(r9);
        ALogger.i("BlackFrameManager", r4.toString());
        if (r5 != null) goto L28;
    L59:
        if (r6 == null) goto L61;
        ALogger.i("BlackFrameManager", "switchVideoSourceType ;; stop rtc internal ;; reason is not meet start rtc interval conditions");
    L61:
        if (r6 == null) goto L67;
        xi6.c r10 = r6.t();
        if (r10 == null) goto L67;
        com.bytedance.live.livelink.kmp.impl.core.video.b r11 = r10.f();
        if (r11 == null) goto L67;
        r11.j(false);
    L67:
        this.g.set(false);
        return;
    L28:
        if (r5.intValue() != 2) goto L59;
        WeakReference<uf2.d0> r12 = this.c;
        if (r12 == null) goto L59;
        uf2.d0 r13 = r12.get();
        if (r13 == null) goto L59;
        uf2.d0.a r14 = r13.getBuilder();
        if (r14 == null) goto L59;
        if (r14.g() != 5) goto L59;
        if (((Boolean) vm2.d.F3.getValue(null, vm2.d.a[237(0xed, float:3.32E-43)])).booleanValue() == true) goto L40;
    L49:
        if (r6 == null) goto L52;
        ALogger.i("BlackFrameManager", "switchVideoSourceType ;; start rtc internal");
    L52:
        if (r6 == null) goto L58;
        xi6.c r15 = r6.t();
        if (r15 == null) goto L58;
        com.bytedance.live.livelink.kmp.impl.core.video.b r16 = r15.f();
        if (r16 == null) goto L58;
        r16.j(true);
    L58:
        this.g.set(true);
        return;
    L40:
        if (jc1.k.n(IKtvService.class).isMultiChorusEnable() == false) goto L49;
        if (r6 == null) goto L43;
        ALogger.i("BlackFrameManager", "switchVideoSourceType ;; stop rtc internal ;; reason is business intercept");
    L43:
        if (r6 == null) goto L69;
        xi6.c r17 = r6.t();
        if (r17 == null) goto L70;
        com.bytedance.live.livelink.kmp.impl.core.video.b r18 = r17.f();
        if (r18 == null) goto L71;
        r18.j(false);
        return;
    L71:
        return;
    L70:
        return;
    L69:
        return;
    L23:
        r9 = null;
    L17:
        r3 = null;
        goto L18
    L8:
        if (((Boolean) vm2.d.H3.getValue(null, vm2.d.a[239(0xef, float:3.35E-43)])).booleanValue() == true) goto L10;
    }
}
