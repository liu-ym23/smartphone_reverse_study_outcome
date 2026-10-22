package com.bytedance.android.live.revlink.impl.multianchor.feed.widget;

import androidx.lifecycle.Observer;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.revlink.impl.LynxCentralManager;
import com.bytedance.android.live.revlink.impl.multianchor.dynamic.MultiDynamicManager;
import com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.MultiDynamicContextFeedImpl;
import com.bytedance.android.live.revlink.impl.multianchor.dynamic.h;
import com.bytedance.android.live.revlink.impl.multianchor.feed.breakthrough.FeedMultiBreakThroughBarManager;
import com.bytedance.android.live.revlink.impl.multianchor.feed.bridge.FeedMultiBridgePresenter;
import com.bytedance.android.live.revlink.impl.multianchor.feed.machine.presenter.i;
import com.bytedance.android.live.revlink.impl.multianchor.feed.wm.FeedMultiWindowManager;
import com.bytedance.android.livesdk.link.model.p;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.web.jsbridge2.f;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import w20.v9;
import z41.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class FeedMultiWidget implements qc0.b, com.bytedance.android.live.revlink.impl.pk.scopeservice.a, i {
    public e41.a a;
    public final com.bytedance.android.live.revlink.impl.multianchor.feed.machine.c b;
    public final com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.b c;
    public final com.bytedance.android.live.revlink.impl.multianchor.feed.bridge.c d;
    public final FeedMultiWindowManager e;
    public final FeedMultiBreakThroughBarManager f;
    public MultiDynamicContextFeedImpl g;
    public MultiDynamicManager h;
    public final HashMap<String, f.b> i;
    public boolean j;
    public boolean k;
    public IRoom l;
    public final Lazy m;
    public final d n;
    public final c o;
    public final com.bytedance.android.live.revlink.impl.multianchor.feed.player.b p;
    public final boolean q;
    public final kc0.d r;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ FeedMultiWidget a;

        public b(FeedMultiWidget r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.d();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ FeedMultiWidget a;

        public c(FeedMultiWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            Integer r2 = (Integer) r1;
            this.a.e.a();
        }
    }

    public static final class d<T> implements com.ss.android.ugc.aweme.compat.nullable.Observer {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void onChanged(Object r4) {
            rc0.c r5 = (rc0.c) r4;
            if (r5 == null) goto L6;
            jy0.b.c("xuzr", r5.toString(), null, 4);
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.scopeservice.a
    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "tag");
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.scopeservice.a
    public final void b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "tag");
    }

    public final void d() {
        if (this.j == true) goto L5;
        return;
    L5:
        if (this.k == true) goto L8;
        return;
    L8:
        if (((Boolean) this.m.getValue()).booleanValue() == true) goto L11;
        g();
        this.h = f();
    L13:
        MultiDynamicContextFeedImpl r0 = this.g;
        if (r0 == null) goto L16;
        r0.d = this.h;
    L16:
        MultiDynamicManager r1 = this.h;
        if (r1 == null) goto L19;
        r1.o();
    L19:
        IRoom r2 = this.l;
        if (r2 == null) goto L26;
        MultiDynamicManager r3 = this.h;
        if (r3 == null) goto L27;
        Intrinsics.checkNotNullParameter(r2, "room");
        r3.k = r2;
        r3.p();
        return;
    L27:
        return;
    L26:
        return;
    L11:
        if (this.h != null) goto L13;
        this.h = f();
        goto L13
    }

    public final void e() {
        if (this.j == true) goto L5;
        return;
    L5:
        if (this.k == true) goto L8;
        return;
    L8:
        if (this.a != null) goto L10;
    L16:
        d();
        return;
    L10:
        if (com.bytedance.android.live.revlink.impl.settings.dynamic.a.H.d() <= 0) goto L16;
        e41.a r0 = this.a;
        if (r0 == null) goto L18;
        r0.b(new b(this));
        return;
    }

    public final MultiDynamicManager f() {
        if (this.q == false) goto L5;
    L7:
        boolean r0 = false;
    L8:
        com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d r1 = null;
        if (r0 == true) goto L11;
        return null;
    L11:
        LynxCentralManager r4 = new LynxCentralManager(this.p.h, (vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class));
        FeedMultiWidget$createDynamicManager$1 r3 = FeedMultiWidget$createDynamicManager$1.INSTANCE;
        MultiDynamicContextFeedImpl r2 = this.g;
        if (r2 == null) goto L18;
        if (com.bytedance.android.live.revlink.impl.settings.dynamic.a.H.g() == false) goto L16;
        r1 = r2.f;
        goto L18
    L16:
        r1 = r2.e;
    L18:
        return new MultiDynamicManager(r3, r4, null, r1, h.a.b);
    L5:
        if (com.bytedance.android.live.revlink.impl.settings.dynamic.b.m.a().R8() == false) goto L7;
        r0 = true;
        goto L8
    }

    public final void g() {
        MultiDynamicManager r0 = this.h;
        if (r0 == null) goto L5;
        r0.q();
    L5:
        this.h = null;
        MultiDynamicContextFeedImpl r1 = this.g;
        if (r1 == null) goto L9;
        r1.a.clear();
        return;
    }

    public final void h() {
        com.bytedance.android.live.revlink.impl.multianchor.feed.machine.presenter.a r0 = this.b.b;
        r0.q.b.observeForever(r0.k);
        r0.q.d.observeForever(r0.l);
        com.bytedance.android.live.revlink.impl.multianchor.feed.bridge.c r1 = this.d;
        com.bytedance.android.live.revlink.impl.multianchor.feed.machine.c r2 = r1.E;
        y21.a r3 = r2.d;
        r3.f = r1;
        r3.g = r1;
        r3.h = r1;
        r2.b.j = r1;
        FeedMultiBridgePresenter r4 = r1.a;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r1, "host");
        r4.b = r1;
        boolean r5 = true;
        r4.a = true;
        mx0.a r6 = r4.f.c;
        if (r6 == null) goto L5;
        r4.b(r6);
    L5:
        r4.f.d.observeForever(r4.e);
        com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.b r7 = this.c;
        FeedMultiWindowManager r8 = this.e;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r8, "wm");
        r7.a = r8;
        com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.b r9 = this.c;
        FeedMultiBreakThroughBarManager r10 = this.f;
        r9.b = r10;
        this.e.o = r10;
        if (this.q == false) goto L8;
    L10:
        r5 = false;
    L12:
        if (r5 == false) goto L14;
        com.bytedance.android.live.revlink.impl.multianchor.feed.bridge.c r12 = this.d;
        FeedMultiWindowManager r13 = this.e;
        MultiDynamicContextFeedImpl r14 = new MultiDynamicContextFeedImpl(r12, r13, this, r13, new FeedMultiWidget$onCreate$1(this));
    L15:
        this.g = r14;
        this.e.m = r14;
        if (r14 == null) goto L19;
        r14.e.f = r14;
        r14.f.e = r14;
    L19:
        if (g.o.a() == false) goto L21;
        this.d.h.observeForever(this.o);
    L21:
        jy0.b.c("FeedMultiWidget", "onCreate", null, 4);
        return;
    L14:
        r14 = null;
        goto L15
    L8:
        if (com.bytedance.android.live.revlink.impl.settings.dynamic.b.m.a().R8() == false) goto L10;
        goto L10
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.feed.machine.presenter.i
    public final void c(List<? extends p> r2) {
        MultiDynamicContextFeedImpl r0 = this.g;
        if (r0 == null) goto L6;
        r0.c(r2);
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.scopeservice.a
    public final void handleBattleBgImage(v9 r6) {
        Intrinsics.checkNotNullParameter(r6, "params");
        FeedMultiWindowManager r0 = this.e;
        String r1 = r6.a;
        String r7 = r6.b;
        com.bytedance.android.live.revlink.impl.multianchor.feed.frame.widget.a r2 = r0.d;
        r2.getClass();
        if (t41.a.m.a() == true) goto L5;
    L9:
        HSImageView r3 = r2.g.findViewById(2131389668);
        HSImageView r4 = r2.g.findViewById(2131389666);
        ImageLoader.bindImage(r3, r1);
        ImageLoader.bindImage(r4, r7);
        r2.c = r1;
        r2.d = r7;
    L10:
        r2.a = r1;
        r2.b = r7;
        return;
    L5:
        if (Intrinsics.areEqual(r1, r2.c) == false) goto L9;
        if (Intrinsics.areEqual(r7, r2.d) == false) goto L9;
        goto L9
    }

    public FeedMultiWidget(z21.a r3, com.bytedance.android.live.revlink.impl.multianchor.feed.player.b r4, boolean r5, kc0.d r6) {
        Intrinsics.checkNotNullParameter(r3, "scope");
        Intrinsics.checkNotNullParameter(r4, "feedMultiLayout");
        this.p = r4;
        this.q = r5;
        this.r = r6;
        com.bytedance.android.live.revlink.impl.multianchor.feed.machine.c r7 = new com.bytedance.android.live.revlink.impl.multianchor.feed.machine.c(r3, new FeedMultiWidget$machine$1(this), this);
        this.b = r7;
        com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.b r0 = new com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.b(new FeedMultiWidget$viewState$1(this));
        this.c = r0;
        this.d = new com.bytedance.android.live.revlink.impl.multianchor.feed.bridge.c(r3, r7, r0);
        this.e = new FeedMultiWindowManager(r3.f, r4, r7, r5);
        this.f = new FeedMultiBreakThroughBarManager(s1.getContext(), r3);
        this.i = new HashMap();
        this.k = true;
        this.m = LazyKt.lazy(FeedMultiWidget$isFeedOpt$2.INSTANCE);
        this.n = d.a;
        this.o = new c(this);
    }
}
