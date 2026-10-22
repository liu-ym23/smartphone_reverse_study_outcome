package com.bytedance.android.live.revlink.impl.multianchor.pk;

import android.net.Uri;
import androidx.lifecycle.LiveData;
import com.bytedance.android.live.revenue.common.p0;
import com.bytedance.android.live.revenue.platform.hybrid.api.HybridType;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.PkBaseDataContext;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.live.revlink.link.biz.component.BreakThroughBarUIOperation;
import com.bytedance.android.live.revlink.link.biz.component.f;
import com.bytedance.android.livesdk.link.model.h3;
import com.bytedance.android.livesdk.link.model.m3;
import com.bytedance.android.livesdk.link.model.n3;
import com.bytedance.android.scope.m;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import cy0.j;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class MultiBreakThroughBarImpl {
    public static final /* synthetic */ int t = 0;
    public boolean a;
    public final String b;
    public zy0.b c;
    public final ArrayList<String> d;
    public final ArrayList<String> e;
    public boolean f;
    public boolean g;
    public final CompositeDisposable h;
    public boolean i;
    public final MultiBreakThroughBarImpl$timeLeftObserver$1 j;
    public final MultiBreakThroughBarImpl$scoreUpdateDataObserver$1 k;
    public final MultiBreakThroughBarImpl$playStateObserver$1 l;
    public final com.bytedance.android.live.revlink.impl.mergepk.pkbase.subplaymode.a m;
    public final com.bytedance.android.live.revlink.impl.mergepk.pkbase.e n;
    public final com.bytedance.android.livesdk.revenue.service.room.c o;
    public final com.bytedance.android.live.revlink.impl.global.c p;
    public final ld.a q;
    public final Function3<vy0.a<Object>, Uri, Function1<? super yy0.c, Unit>, zy0.b> r;
    public final f s;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ MultiBreakThroughBarImpl a;

        public b(MultiBreakThroughBarImpl r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            sh6.b r5 = (sh6.b) r4;
            cy0.e.a.getClass();
            j r0 = cy0.e.a.a;
            m.e.getClass();
            Object r6 = m.b(r0).b(vr2.a.class);
            Intrinsics.checkNotNull(r6);
            if (((com.bytedance.live.kmp.core.c) r6).S8(Boolean.valueOf(this.a.a)) == false) goto L25;
            Object r7 = m.b(r0).b(com.bytedance.android.livesdk.revenue.service.interact.d.class);
            Intrinsics.checkNotNull(r7);
            if (((com.bytedance.live.kmp.core.c) r7).Sl() == true) goto L26;
            MultiBreakThroughBarImpl r8 = this.a;
            com.bytedance.android.live.revlink.impl.global.c r1 = r8.p;
            if (r1 == null) goto L10;
            com.bytedance.android.live.revlink.impl.utils.b r2 = r1.getClearScreenLinkUtils();
        L11:
            boolean r3 = false;
            if (r2 != null) goto L14;
        L16:
            boolean r9 = false;
        L17:
            if (r9 == false) goto L23;
            PkBaseStateMachine.c r10 = r8.n.getCurPKBaseState();
            r10.getClass();
            if ((r10 instanceof PkBaseStateMachine.c.C0130c) == true) goto L23;
            PkBaseStateMachine.c r12 = r8.n.getCurPKBaseState();
            r12.getClass();
            if ((r12 instanceof PkBaseStateMachine.c.d) == true) goto L23;
            r3 = true;
        L23:
            r8.s.c(r3);
            return;
        L14:
            if (r2.b() != true) goto L16;
            r9 = true;
            goto L17
        L10:
            r2 = null;
            goto L11
        L26:
            return;
        }
    }

    static {
    }

    public final void d() {
        this.a = this.o.getRoomContext().getCommonIsAnchor();
        this.n.getBaseTimeLeft().observeForever(this.j);
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.subplaymode.a r0 = this.n.getBreakThroughService();
        if (r0 == null) goto L7;
        LiveData<n3> r1 = r0.getBreakthroughInfo();
        if (r1 == null) goto L7;
        r1.observeForever(this.k);
    L7:
        this.m.getPlayState().observeForever(this.l);
        if (d51.b.m.a() == false) goto L10;
        p0.a(0, false, true, new MultiBreakThroughBarImpl$attach$1(this), 3);
    L11:
        ld.a r2 = this.q;
        if (r2 == null) goto L21;
        NextLiveData r3 = r2.getCleanMode();
        if (r3 == null) goto L22;
        Observable r4 = ld.c.a(r3);
        if (r4 == null) goto L23;
        Disposable r5 = r4.subscribe(new b(this));
        if (r5 == null) goto L24;
        com.bytedance.revenue.platform.api.core.rx.f.a(r5, this.h);
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    L21:
        return;
    L10:
        e("onCreate");
        goto L11
    }

    public static final void c(MultiBreakThroughBarImpl r1) {
        if (r1.g == true) goto L5;
        r1.e("reload");
    L5:
        r1.s.b();
        r1.f = false;
        zy0.b r2 = r1.c;
        if (r2 == null) goto L11;
        xy0.a<?> r3 = r2.g();
        if (r3 == null) goto L12;
        r3.load();
        return;
    L12:
        return;
    }

    private final HybridType getType(zy0.b r1) {
        if (r1 == null) goto L6;
        xy0.a<?> r2 = r1.g();
        if (r2 == null) goto L6;
        return r2.o();
    L6:
        return null;
    }

    public final void e(String r4) {
        if (this.g == false) goto L5;
        return;
    L5:
        this.s.f(this.b, r4);
        this.g = true;
        this.c = (zy0.b) this.r.invoke(new vy0.a.b(), null, new MultiBreakThroughBarImpl$initLynx$1(this));
    }

    public final void f(JSONObject r3) {
        zy0.b r0 = this.c;
        if (r0 == null) goto L8;
        xy0.a<?> r1 = r0.g();
        if (r1 == null) goto L9;
        r1.sendJsEvent("H5_webcastNotification", r3.toString());
        return;
    L9:
        return;
    }

    public static final /* synthetic */ HybridType a(MultiBreakThroughBarImpl r0, zy0.b r1) {
        return r0.getType(r1);
    }

    public static final String b(MultiBreakThroughBarImpl r1, m3 r2, n3 r3, h3 r4) {
        r1.getClass();
        JSONObject r5 = new JSONObject();
        r5.put("config", GsonProtectorUtils.toJson(l97.a.a, r2));
        r5.put("info", GsonProtectorUtils.toJson(l97.a.a, r3));
        r5.put("title", GsonProtectorUtils.toJson(l97.a.a, r4));
        return r5.toString();
    }

    /* JADX WARN: Type inference failed for: r2v6, types: [com.bytedance.android.live.revlink.impl.multianchor.pk.MultiBreakThroughBarImpl$timeLeftObserver$1] */
    /* JADX WARN: Type inference failed for: r2v7, types: [com.bytedance.android.live.revlink.impl.multianchor.pk.MultiBreakThroughBarImpl$scoreUpdateDataObserver$1] */
    /* JADX WARN: Type inference failed for: r2v8, types: [com.bytedance.android.live.revlink.impl.multianchor.pk.MultiBreakThroughBarImpl$playStateObserver$1] */
    public MultiBreakThroughBarImpl(com.bytedance.android.live.revlink.impl.mergepk.pkbase.subplaymode.a r2, PkBaseDataContext r3, com.bytedance.android.livesdk.revenue.service.room.c r4, com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d r5, ld.a r6, Function3 r7, BreakThroughBarUIOperation r8) {
        Intrinsics.checkNotNullParameter(r2, "breakThroughViewModel");
        Intrinsics.checkNotNullParameter(r3, "pkBaseDataContext");
        Intrinsics.checkNotNullParameter(r4, "roomService");
        Intrinsics.checkNotNullParameter(r7, "createCardFunc");
        Intrinsics.checkNotNullParameter(r8, "uiOperation");
        this.m = r2;
        this.n = r3;
        this.o = r4;
        this.p = r5;
        this.q = r6;
        this.r = r7;
        this.s = r8;
        this.b = d51.a.g.a();
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.h = new CompositeDisposable();
        this.j = new MultiBreakThroughBarImpl$timeLeftObserver$1(this);
        this.k = new MultiBreakThroughBarImpl$scoreUpdateDataObserver$1(this);
        this.l = new MultiBreakThroughBarImpl$playStateObserver$1(this);
    }
}
