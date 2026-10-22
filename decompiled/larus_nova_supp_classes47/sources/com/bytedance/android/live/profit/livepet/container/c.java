package com.bytedance.android.live.profit.livepet.container;

import android.view.View;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.profit.livepet.instance.LivePetInstance;
import com.bytedance.android.scope.o;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements o {
    public static final /* synthetic */ int j = 0;
    public final CompositeDisposable a;
    public zy0.b b;
    public LivePetInstance c;
    public LivePetContainerWidget d;
    public final yz0.k e;
    public final com.bytedance.android.live.profit.livepet.d f;
    public final ru0.a g;
    public final com.bytedance.android.live.profit.livepet.instance.b h;
    public final e i;

    public static final class a {
    }

    public static final class b<T> implements com.bytedance.android.live.revenue.common.reactive.f {
        public final /* synthetic */ c a;

        public b(c r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.revenue.common.reactive.f
        public final void a(Object r3) {
            c r0 = this.a;
            r0.a((LivePetInstance) r3, r0.d);
        }
    }

    static {
    }

    public final void onStart() {
        com.bytedance.android.live.profit.livepet.d r0 = this.f;
        DataCenter r1 = this.e.getDataCenter();
        ru0.a r2 = this.g;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "roomKey");
        Intrinsics.checkNotNullParameter(r2, "scope");
        r0.a.put(Integer.valueOf(r1.hashCode()), r2);
        RxUtilKt.c(this.h.b.a(new b(this)), this.a);
    }

    public final void onStop() {
        com.bytedance.android.live.profit.livepet.d r0 = this.f;
        DataCenter r1 = this.e.getDataCenter();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "roomKey");
        r0.a.remove(Integer.valueOf(r1.hashCode()));
        this.a.dispose();
        zy0.b r2 = this.b;
        if (r2 == null) goto L5;
        r2.dispose();
    L5:
        this.b = null;
    }

    public final void a(LivePetInstance r6, LivePetContainerWidget r7) {
        jy0.b.a("LivePet/ContainerService", "updateState: instance = " + r6 + ", widget = " + r7);
        if (r7 != null) goto L5;
    L34:
        this.c = r6;
        this.d = r7;
        return;
    L5:
        if (r6 == null) goto L30;
        View r1 = r7.d;
        if (r1 == null) goto L14;
        zy0.b r2 = this.b;
        if (r2 == null) goto L11;
        View r3 = r2.c();
    L13:
        if ((!Intrinsics.areEqual(r1, r3)) == false) goto L34;
    L11:
        r3 = null;
    L14:
        zy0.b r4 = this.b;
        if (r4 == null) goto L18;
        r4.dispose();
    L18:
        if (r6.a() != LivePetInstance.State.Created) goto L21;
        r6.a.setValue(LivePetInstance.State.Loading);
        jy0.b.a("LivePet/Instance", "instance loading");
    L21:
        com.bytedance.android.live.revenue.platform.hybrid.impl.ui.a r5 = ((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).q8(this.e.getContext(), r6.b(), new LivePetContainerService$loadPetHybridCard$hybridCard$1(r6));
        if (r5 == null) goto L29;
        this.b = r5;
        r5.x();
        com.bytedance.android.live.revenue.platform.hybrid.impl.ui.a.b r8 = r5.d;
        if (r8 == null) goto L27;
        r8.load(null, null);
        this.b = r5;
        r7.wq(r5.c);
        goto L34
    L27:
        throw new IllegalArgumentException("Required value was null.".toString());
    L29:
        throw new IllegalArgumentException("Required value was null.".toString());
    L30:
        zy0.b r9 = this.b;
        if (r9 == null) goto L33;
        r9.dispose();
    L33:
        this.b = null;
        r7.wq(null);
        goto L34
    }

    public c(yz0.k r2, com.bytedance.android.live.profit.livepet.d r3, ru0.a r4, com.bytedance.android.live.profit.livepet.instance.b r5, e r6) {
        Intrinsics.checkNotNullParameter(r2, "roomDataService");
        Intrinsics.checkNotNullParameter(r3, "livePetGlobalService");
        Intrinsics.checkNotNullParameter(r4, "livePetRoomScope");
        Intrinsics.checkNotNullParameter(r5, "instanceManager");
        Intrinsics.checkNotNullParameter(r6, "layoutManager");
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.h = r5;
        this.i = r6;
        this.a = new CompositeDisposable();
    }
}
