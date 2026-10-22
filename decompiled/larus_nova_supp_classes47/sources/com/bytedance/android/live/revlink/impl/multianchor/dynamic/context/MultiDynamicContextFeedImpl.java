package com.bytedance.android.live.revlink.impl.multianchor.dynamic.context;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.revlink.impl.multianchor.feed.wm.FeedMultiWindowManager;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class MultiDynamicContextFeedImpl implements com.bytedance.android.live.revlink.impl.multianchor.feed.machine.presenter.i, c, com.bytedance.android.live.revlink.impl.multianchor.dynamic.g, a {
    public final CompositeDisposable a;
    public int b;
    public final HashMap<String, com.bytedance.ies.web.jsbridge2.f.b> c;
    public com.bytedance.android.live.revlink.impl.lynxcontainer.a d;
    public final a1 e;
    public final o0 f;
    public final com.bytedance.android.live.revlink.impl.multianchor.dynamic.l g;
    public final Lazy h;
    public final com.bytedance.android.live.revlink.impl.multianchor.feed.bridge.c i;
    public final FeedMultiWindowManager j;
    public final com.bytedance.android.live.revlink.impl.pk.scopeservice.a k;
    public final Function0<Pair<Integer, Integer>> l;

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.a
    public final void b(final zy0.b r2) {
        if (r2 == null) goto L5;
        r2.l1(new MultiDynamicContextFeedImpl$onHybridLoad$1(this, r2));
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.feed.machine.presenter.i
    public final void c(List<? extends com.bytedance.android.livesdk.link.model.p> r6) {
        StringBuilder r0 = new StringBuilder("onOnlineListRefresh list = ");
        ArrayList r1 = null;
        if (r6 == null) goto L5;
        String r2 = r6.toString();
    L6:
        r0.append(r2);
        r0.append(", wrappedList = ");
        if (r6 == null) goto L12;
        r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator<T> r3 = r6.iterator();
    L10:
        if (r3.hasNext() == false) goto L12;
        r1.add(new com.bytedance.android.live.revlink.impl.multianchor.dynamic.f((com.bytedance.android.livesdk.link.model.p) r3.next()));
    L12:
        r0.append(String.valueOf(r1));
        jy0.b.d("multi_lynx", r0.toString());
        this.e.c(r6);
        this.f.c(r6);
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.g
    public final boolean d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        return this.g.d(r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.c
    public final void j(int r4) {
        if (((Boolean) this.h.getValue()).booleanValue() == false) goto L5;
        return;
    L5:
        this.b = r4;
        com.bytedance.android.live.revlink.impl.multianchor.feed.bridge.c r5 = this.i;
        k31.n r0 = new k31.n(com.bytedance.android.live.revlink.impl.settings.dynamic.b.m.a().s6(), UtilityKotlinExtentionsKt.i(this.b));
        r5.getClass();
        Intrinsics.checkNotNullParameter(r0, "topOpt");
        r5.F.getClass();
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        r5.F.d();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.g
    public final void a(List<String> r2, int r3) {
        this.g.a(r2, r3);
    }

    public MultiDynamicContextFeedImpl(com.bytedance.android.live.revlink.impl.multianchor.feed.bridge.c r8, FeedMultiWindowManager r9, com.bytedance.android.live.revlink.impl.pk.scopeservice.a r10, FeedMultiWindowManager r12, Function0 r13) {
        Intrinsics.checkNotNullParameter(r8, "bridge");
        Intrinsics.checkNotNullParameter(r9, "windowManager");
        Intrinsics.checkNotNullParameter(r12, "dynamicWindowManager");
        Intrinsics.checkNotNullParameter(r13, "getPlayerWH");
        this.i = r8;
        this.j = r9;
        this.k = r10;
        this.l = r13;
        this.a = new CompositeDisposable();
        this.c = new HashMap();
        this.e = new a1(r8, r9, r10, r12, r13);
        this.f = new o0(r8, r9, r10, r12, r13);
        this.g = new com.bytedance.android.live.revlink.impl.multianchor.dynamic.l(new MultiDynamicContextFeedImpl$localComponentManager$1(this));
        this.h = LazyKt.lazy(MultiDynamicContextFeedImpl$isRelayoutOpt$2.INSTANCE);
    }
}
