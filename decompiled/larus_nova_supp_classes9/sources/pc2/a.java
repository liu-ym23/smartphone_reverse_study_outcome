package pc2;

import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeScene;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.config.CommentCarnivalFeatureLevel;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.config.EnterAnimFeatureLevel;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.config.EnterRoomDurationFeatureLevel;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.config.FlowLikeFeatureLevel;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.config.HotCommentFeatureLevel;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.config.PortraitDanmakuFeatureLevel;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.config.PublicScreenFeatureLevel;
import com.bytedance.android.livesdk.interactivity.api.degrade.model.config.TapLikeFeatureLevel;
import com.larus.apm.impl.protector.RunnableProtector;
import h32.c;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import oc2.e;
import oc2.m;
import qc2.d;
import qc2.f;
import qc2.h;
import qc2.j;
import qc2.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements h32.a {
    public final com.bytedance.android.livesdk.interactivity.b a;
    public final d b;
    public final h c;
    public final m d;
    public final f e;
    public final qc2.b f;
    public final l g;
    public final j h;
    public final e i;
    public final Map<DegradeScene, List<oc2.a<?, ?>>> j;
    public final Set<oc2.a<?, ?>> k;

    /* JADX INFO: renamed from: pc2.a$a, reason: collision with other inner class name */
    public static final class C0265a implements pc2.b {
        public final /* synthetic */ a a;

        public C0265a(a r1) {
            this.a = r1;
        }

        @Override // pc2.b
        public final void a(e32.a r2, Map<String, String> r3) {
            Intrinsics.checkNotNullParameter(r2, "request");
            Intrinsics.checkNotNullParameter(r3, "extraInfo");
            this.a.a(r2, r3);
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ a a;
        public final /* synthetic */ e32.a b;

        public b(a r1, e32.a r2) {
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
        com.bytedance.android.livesdk.interactivity.b r0 = new com.bytedance.android.livesdk.interactivity.b();
        this.a = r0;
        C0265a r1 = new C0265a(this);
        d r2 = new d(EnterAnimFeatureLevel.LEVEL_DEFAULT, r0, r1);
        this.b = r2;
        h r3 = new h(HotCommentFeatureLevel.LEVEL_DEFAULT, r0, r1);
        this.c = r3;
        m r4 = new m(TapLikeFeatureLevel.LEVEL_DEFAULT, r0);
        this.d = r4;
        f r5 = new f(FlowLikeFeatureLevel.LEVEL_DEFAULT, r0, r1);
        this.e = r5;
        qc2.b r6 = new qc2.b(CommentCarnivalFeatureLevel.LEVEL_DEFAULT, r0, r1);
        this.f = r6;
        l r7 = new l(PublicScreenFeatureLevel.LEVEL_DEFAULT, r0, r1);
        this.g = r7;
        j r8 = new j(PortraitDanmakuFeatureLevel.LEVEL_DEFAULT, r0, r1);
        this.h = r8;
        e r9 = new e(EnterRoomDurationFeatureLevel.OutEnterRoomDuration, r0);
        this.i = r9;
        Map<DegradeScene, List<oc2.a<?, ?>>> r10 = MapsKt.mapOf(new Pair[]{TuplesKt.to(DegradeScene.AUDIENCE_EXP_DISABLE_HIGH_LEVEL_ENTER, CollectionsKt.listOf(r2)), TuplesKt.to(DegradeScene.AUDIENCE_EXP_HIGH_LEVEL_ENTER_ANIM, CollectionsKt.listOf(r2)), TuplesKt.to(DegradeScene.AUDIENCE_EXP_HIGH_LEVEL_ECOM_ANIM, CollectionsKt.listOf(r2)), TuplesKt.to(DegradeScene.AUDIENCE_EXP_HOT_COMMENT_TRAY, CollectionsKt.listOf(r3)), TuplesKt.to(DegradeScene.AUDIENCE_EXP_PORTRAIT_DANMAKU, CollectionsKt.listOf(r8)), TuplesKt.to(DegradeScene.AUDIENCE_EXP_LIKE_FLOW, CollectionsKt.listOf(r5)), TuplesKt.to(DegradeScene.AUDIENCE_EXP_COMMENT_CARNIVAL, CollectionsKt.listOf(r6)), TuplesKt.to(DegradeScene.AUDIENCE_EXP_PUBLIC_SCREEN_ANIM, CollectionsKt.listOf(r7)), TuplesKt.to(DegradeScene.ENTER_ROOM_DURATION, CollectionsKt.listOf(r9)), TuplesKt.to(DegradeScene.PERFORMANCE_FRAME, CollectionsKt.listOf(new oc2.a[]{r4, r5})), TuplesKt.to(DegradeScene.ECOM, CollectionsKt.listOf(new oc2.a[]{r4, r5, r3, r2})), TuplesKt.to(DegradeScene.LOW_PERFORMANCE_PHONE, CollectionsKt.listOf(r5)), TuplesKt.to(DegradeScene.STRATEGY_PLATFORM_FLOW_LIKE_DEGRADE, CollectionsKt.listOf(r5)), TuplesKt.to(DegradeScene.STRATEGY_PLATFORM_TAP_LIKE_DEGRADE, CollectionsKt.listOf(r4)), TuplesKt.to(DegradeScene.GAME, CollectionsKt.listOf(new oc2.a[]{r4, r5, r2, r9, r3}))});
        this.j = r10;
        this.k = CollectionsKt.toSet(CollectionsKt.flatten(r10.values()));
    }

    @Override // h32.a
    public final c b() {
        return this.e;
    }

    @Override // h32.a
    public final c c() {
        return this.b;
    }

    @Override // h32.a
    public final e d() {
        return this.i;
    }

    @Override // h32.a
    public final c e() {
        return this.d;
    }

    @Override // h32.a
    public final c f() {
        return this.h;
    }

    @Override // h32.a
    public final c g() {
        return this.c;
    }

    @Override // h32.a
    public final c h() {
        return this.g;
    }

    @Override // h32.a
    public final c i() {
        return this.f;
    }

    @Override // h32.a
    public final void a(e32.a r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r2, "request");
        Intrinsics.checkNotNullParameter(r3, "extraInfo");
        g32.c.a(r2);
        g32.d.a(r2, r3);
        MainThreadPostUtils.b(new b(this, r2));
    }
}
