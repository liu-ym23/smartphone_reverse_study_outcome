package nc2;

import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.livesdk.config.l20;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeScene;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.config.EnterAnimFeatureLevel;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.config.EnterRoomDurationFeatureLevel;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.config.FlowLikeFeatureLevel;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.config.HotCommentFeatureLevel;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.config.TapLikeFeatureLevel;
import com.bytedance.android.livesdk.interactivity.b;
import com.larus.apm.impl.protector.RunnableProtector;
import f32.d;
import f32.i;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import oc2.c;
import oc2.e;
import oc2.g;
import oc2.h;
import oc2.k;
import oc2.m;
import oc2.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements h32.a {
    public final b a;
    public final c b;
    public final k c;
    public final oc2.a<i, TapLikeFeatureLevel> d;
    public final oc2.a<d, FlowLikeFeatureLevel> e;
    public final h32.b f;
    public final h32.b g;
    public final h32.b h;
    public final e i;
    public final Map<DegradeScene, List<oc2.a<?, ?>>> j;
    public final Set<oc2.a<?, ?>> k;

    /* JADX INFO: renamed from: nc2.a$a, reason: collision with other inner class name */
    public static final class RunnableC0257a implements Runnable {
        public final /* synthetic */ a a;
        public final /* synthetic */ e32.a b;

        public RunnableC0257a(a r1, e32.a r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            this.a.a.c(this.b);
            List<oc2.a<?, ?>> r0 = this.a.j.get(this.b.a);
            if (r0 != null) goto L5;
            return;
        L5:
            Iterator<oc2.a<?, ?>> r1 = r0.iterator();
        L7:
            if (r1.hasNext() == false) goto L9;
            r1.next().f(this.b);
            goto L7
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // h32.a
    public final void init() {
        Iterator<oc2.a<?, ?>> r0 = this.k.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().h();
        goto L4
    }

    @Override // h32.a
    public final void release() {
        Iterator<oc2.a<?, ?>> r0 = this.k.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().g();
        goto L4
    }

    public a() {
        b r0 = new b();
        this.a = r0;
        boolean r1 = ((ts1.a) l20.a.getValue()).useStrategyPlatform;
        c r2 = new c(EnterAnimFeatureLevel.LEVEL_DEFAULT, r0);
        this.b = r2;
        k r3 = new k(HotCommentFeatureLevel.LEVEL_DEFAULT, r0);
        this.c = r3;
        if (r1 == false) goto L5;
        oc2.a<i, TapLikeFeatureLevel> r4 = new n(TapLikeFeatureLevel.LEVEL_DEFAULT, r0);
    L6:
        this.d = r4;
        if (r1 == false) goto L9;
        oc2.a<d, FlowLikeFeatureLevel> r5 = new h(FlowLikeFeatureLevel.LEVEL_DEFAULT, r0);
    L10:
        this.e = r5;
        h32.c.a.getClass();
        this.f = new h32.b();
        this.g = new h32.b();
        this.h = new h32.b();
        e r6 = new e(EnterRoomDurationFeatureLevel.OutEnterRoomDuration, r0);
        this.i = r6;
        Map<DegradeScene, List<oc2.a<?, ?>>> r7 = MapsKt.mapOf(new Pair[]{TuplesKt.to(DegradeScene.PERFORMANCE_FRAME, CollectionsKt.listOf(new oc2.a[]{r4, r5})), TuplesKt.to(DegradeScene.ECOM, CollectionsKt.listOf(new oc2.a[]{r4, r5, r3, r2})), TuplesKt.to(DegradeScene.LOW_PERFORMANCE_PHONE, CollectionsKt.listOf(r5)), TuplesKt.to(DegradeScene.STRATEGY_PLATFORM_FLOW_LIKE_DEGRADE, CollectionsKt.listOf(r5)), TuplesKt.to(DegradeScene.STRATEGY_PLATFORM_TAP_LIKE_DEGRADE, CollectionsKt.listOf(r4)), TuplesKt.to(DegradeScene.ENTER_ROOM_DURATION, CollectionsKt.listOf(r6))});
        this.j = r7;
        this.k = CollectionsKt.toSet(CollectionsKt.flatten(r7.values()));
        return;
    L9:
        r5 = new g(FlowLikeFeatureLevel.LEVEL_DEFAULT, r0);
        goto L10
    L5:
        r4 = new m(TapLikeFeatureLevel.LEVEL_DEFAULT, r0);
        goto L6
    }

    @Override // h32.a
    public final h32.c b() {
        return this.e;
    }

    @Override // h32.a
    public final h32.c c() {
        return this.b;
    }

    @Override // h32.a
    public final e d() {
        return this.i;
    }

    @Override // h32.a
    public final h32.c e() {
        return this.d;
    }

    @Override // h32.a
    public final h32.c<f32.g> f() {
        return this.h;
    }

    @Override // h32.a
    public final h32.c g() {
        return this.c;
    }

    @Override // h32.a
    public final h32.c<f32.h> h() {
        return this.g;
    }

    @Override // h32.a
    public final h32.c<f32.a> i() {
        return this.f;
    }

    @Override // h32.a
    public final void a(e32.a r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r2, "request");
        Intrinsics.checkNotNullParameter(r3, "extraInfo");
        g32.c.a(r2);
        g32.d.a(r2, r3);
        MainThreadPostUtils.b(new RunnableC0257a(this, r2));
    }
}
