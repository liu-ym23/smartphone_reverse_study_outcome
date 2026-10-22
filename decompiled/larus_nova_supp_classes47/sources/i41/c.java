package i41;

import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revlink.impl.monitor.LiveFullLinkPKMonitor;
import com.bytedance.android.live.revlink.impl.pk.utils.AutoMatchSource;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livesdk.link.model.RandomMatchStrategy;
import com.bytedance.android.livesdk.link.model.g0;
import com.bytedance.android.livesdk.link.model.r4;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ a a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Function1 c;
    public final /* synthetic */ int d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ boolean f;
    public final /* synthetic */ long g;
    public final /* synthetic */ String h;
    public final /* synthetic */ long i;

    public c(a r1, int r2, Function1 r3, int r4, boolean r5, boolean r6, long r7, String r9, long r10) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r9;
        this.i = r10;
    }

    public final void accept(Object r15) {
        ExtraResponse r16 = (ExtraResponse) r15;
        r4 r0 = (r4) r16.data;
        LiveFullLinkPKMonitor r2 = null;
        String r6 = "";
        if (this.b != 1) goto L36;
        com.bytedance.android.livesdk.link.model.a r1 = r16.extra;
        if (r1 == null) goto L27;
        if (r1.a() == null) goto L27;
        com.bytedance.android.live.revlink.impl.global.c r3 = this.a.k;
        if (r3 == null) goto L11;
        com.bytedance.android.live.revlink.impl.control.d r4 = r3.Rc();
    L12:
        if (r4 == null) goto L19;
        g0 r9 = r16.extra.a();
        if (r9 == null) goto L17;
        String r10 = r9.getImprId();
        if (r10 == null) goto L17;
    L18:
        r4.setRequestId(r10);
    L17:
        r10 = "";
    L19:
        this.a.d = r0.getBattleAttachedInfo();
        Function1 r5 = this.c;
        if (r5 == null) goto L27;
        String r12 = this.a.d;
        long r13 = r0.getMatchStrategy();
        if (this.d != 13) goto L24;
        boolean r14 = true;
    L25:
        Unit r7 = (Unit) r5.invoke(new com.bytedance.android.live.revlink.impl.pk.vm.linkout.p(r12, r13, r14));
        goto L27
    L24:
        r14 = false;
        goto L25
    L11:
        r4 = null;
    L27:
        if (this.e == true) goto L36;
        if (this.f == true) goto L36;
        if (r0.getMaxWaitTime() <= 0) goto L33;
        long r17 = r0.getMaxWaitTime();
    L34:
        long r18 = (r17 + 1) * ((long) WebcastRedirectException.UNKNOWN);
        a r8 = this.a;
        com.bytedance.revenue.platform.api.core.rx.l r19 = com.bytedance.revenue.platform.api.core.rx.l.a;
        int r110 = com.bytedance.revenue.platform.api.core.rx.p.a;
        r8.i = Observable.timer(r18, TimeUnit.MILLISECONDS, Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this));
        goto L36
    L33:
        r17 = 180;
    L36:
        if (r0.getRivalRoom() == null) goto L38;
        a r20 = this.a;
        r20.f = false;
        Disposable r22 = r20.e;
        if (r22 == null) goto L55;
        r22.dispose();
        this.a.e = null;
    L55:
        Disposable r23 = this.a.i;
        if (r23 == null) goto L58;
        r23.dispose();
        this.a.i = null;
    L58:
        com.bytedance.android.livesdk.link.model.a r24 = r16.extra;
        if (r24 != null) goto L61;
    L74:
        Iterator r111 = ((ArrayList) this.a.a).iterator();
    L76:
        if (r111.hasNext() == false) goto L82;
        p r25 = (p) r111.next();
        String r26 = this.h;
        String r27 = this.a.d;
        long r28 = RandomMatchStrategy.Normal.ordinal();
        if (this.d != 13) goto L80;
        boolean r112 = true;
    L81:
        r25.Nh(r0, r26, new com.bytedance.android.live.revlink.impl.pk.vm.linkout.p(r27, r28, r112));
        goto L76
    L80:
        r112 = false;
    L82:
        com.bytedance.android.live.revlink.impl.global.c r113 = this.a.k;
        if (r113 == null) goto L85;
        r2 = r113.getLiveFullLinkPKMonitor();
    L85:
        LiveFullLinkPKMonitor r29 = r2;
        if (r29 == null) goto L96;
        i97.a r114 = i97.a.a;
        LiveFullLinkPKMonitor.s(r29, "linkmic/battle/auto_match", System.currentTimeMillis() - this.i, 0, 0, null, 28);
        return;
    L96:
        return;
    L61:
        if (r24.a() == null) goto L74;
        com.bytedance.android.live.revlink.impl.global.c r30 = this.a.k;
        if (r30 == null) goto L65;
        com.bytedance.android.live.revlink.impl.control.d r32 = r30.Rc();
    L66:
        if (r32 == null) goto L74;
        g0 r115 = r16.extra.a();
        if (r115 == null) goto L73;
        String r116 = r115.getImprId();
        if (r116 == null) goto L73;
        r6 = r116;
    L73:
        r32.setRequestId(r6);
        goto L74
    L65:
        r32 = null;
        goto L66
    L38:
        if (this.g != 0) goto L44;
        this.a.getClass();
        Iterator r117 = ((ArrayList) this.a.a).iterator();
    L41:
        if (r117.hasNext() == false) goto L43;
        ((p) r117.next()).qn(this.e, true, AutoMatchSource.PollingEnd);
        goto L41
    L43:
        this.a.f = false;
        goto L82
    L44:
        Iterator r118 = ((ArrayList) this.a.a).iterator();
    L46:
        if (r118.hasNext() == false) goto L82;
        p r33 = (p) r118.next();
        if (this.b != 1) goto L50;
        boolean r34 = true;
    L51:
        r33.Ug(r0, r34, this.h);
        goto L46
    L50:
        r34 = false;
        goto L51
    }
}
