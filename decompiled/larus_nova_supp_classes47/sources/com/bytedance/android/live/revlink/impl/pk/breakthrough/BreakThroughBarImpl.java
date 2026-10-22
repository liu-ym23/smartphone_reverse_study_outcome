package com.bytedance.android.live.revlink.impl.pk.breakthrough;

import android.net.Uri;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revenue.common.p0;
import com.bytedance.android.live.revenue.platform.hybrid.api.HybridType;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.e;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c;
import com.bytedance.android.live.revlink.link.biz.doublecomponent.BreakThroughUIOperationImpl;
import com.bytedance.android.live.revlink.link.biz.service.i;
import com.bytedance.android.live.revlink.link.biz.service.k;
import com.bytedance.android.live.revlink.link.utils.UtilsKt;
import com.bytedance.android.livesdk.link.model.h3;
import com.bytedance.android.livesdk.link.model.m3;
import com.bytedance.android.livesdk.link.model.n3;
import com.bytedance.android.livesdk.revenue.service.interact.d;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.scope.m;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.revenue.platform.api.core.rx.f;
import cy0.j;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class BreakThroughBarImpl implements k {
    public static final /* synthetic */ int v = 0;
    public final String a;
    public zy0.b b;
    public final ArrayDeque<String> c;
    public final ArrayDeque<String> d;
    public boolean e;
    public boolean f;
    public final CompositeDisposable g;
    public boolean h;
    public final BreakThroughBarImpl$timeLeftObserver$1 i;
    public final BreakThroughBarImpl$battleScoreDataObserver$1 j;
    public final BreakThroughBarImpl$playStateObserver$1 k;
    public final com.bytedance.android.live.revlink.impl.mergepk.pkbase.subplaymode.a l;
    public final e m;
    public final c n;
    public final g41.a o;
    public final com.bytedance.android.live.revlink.impl.pk.breakthrough.a p;
    public final com.bytedance.android.live.revlink.impl.global.c q;
    public final com.bytedance.android.livesdk.revenue.service.room.c r;
    public final Function3<vy0.a<Object>, Uri, Function1<? super yy0.c, Unit>, zy0.b> s;
    public final boolean t;
    public final ld.a u;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.pk.breakthrough.BreakThroughBarImpl$attach$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lb03/b;", "p1", "", "invoke", "(Lb03/b;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<b03.b, Unit> {
        public AnonymousClass3(BreakThroughBarImpl r8) {
            super(1, r8, BreakThroughBarImpl.class, "onPlatformConfigChanged", "onPlatformConfigChanged(Lcom/bytedance/android/platform/PlatformConfig;)V", 0);
        }

        public final void invoke(b03.b r2) {
            BreakThroughBarImpl r3 = (BreakThroughBarImpl) ((CallableReference) this).receiver;
            int r0 = BreakThroughBarImpl.v;
            if (r3.o.a() == false) goto L7;
            com.bytedance.android.live.revlink.impl.pk.breakthrough.a r1 = r3.p;
            r3.o.isPortrait();
            r1.h();
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((b03.b) r1);
            return Unit.INSTANCE;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ BreakThroughBarImpl a;

        public b(BreakThroughBarImpl r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            sh6.b r4 = (sh6.b) r3;
            cy0.e.a.getClass();
            j r0 = cy0.e.a.a;
            m.e.getClass();
            Object r5 = m.b(r0).b(vr2.a.class);
            Intrinsics.checkNotNull(r5);
            if (((com.bytedance.live.kmp.core.c) r5).S8(Boolean.valueOf(this.a.t)) == false) goto L17;
            Object r6 = m.b(r0).b(d.class);
            Intrinsics.checkNotNull(r6);
            if (((com.bytedance.live.kmp.core.c) r6).Sl() == true) goto L18;
            BreakThroughBarImpl r7 = this.a;
            Intrinsics.checkNotNullParameter(r7, "$this$clearScreenLinkUtils");
            if (i.getContext(r7).getClearScreenLinkUtils().b() == false) goto L14;
            PkBaseStateMachine.c r1 = r7.m.getCurPKBaseState();
            r1.getClass();
            if ((r1 instanceof PkBaseStateMachine.c.C0130c) == true) goto L14;
            PkBaseStateMachine.c r2 = r7.m.getCurPKBaseState();
            r2.getClass();
            if ((r2 instanceof PkBaseStateMachine.c.d) == true) goto L14;
            boolean r8 = true;
        L15:
            r7.p.c(r8);
            return;
        L14:
            r8 = false;
            goto L15
        L18:
            return;
        }
    }

    static {
    }

    public final void attach() {
        this.m.getBaseTimeLeft().observeForever(this.i);
        this.m.getBattleScoreData().observeForever(this.j);
        this.l.getPlayState().observeForever(this.k);
        this.k.a((com.bytedance.android.live.revlink.impl.pk.vm.pk.d) this.l.getPlayState().getValue());
        this.j.a((com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a) this.m.getBattleScoreData().getValue());
        if (d51.b.m.a() == false) goto L5;
        p0.a(0, false, true, new AnonymousClass1(this), 3);
    L7:
        if (this.o.a() == false) goto L10;
        com.bytedance.android.live.revlink.impl.pk.breakthrough.a r0 = this.p;
        this.o.isPortrait();
        r0.h();
    L10:
        f.a(ld.c.a(this.u.getCleanMode()).subscribe(new b(this)), this.g);
        f.a(UtilsKt.d(this.p.b(), new AnonymousClass3(this)), this.g);
        return;
    L5:
        d("onCreate");
        goto L7
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.k
    public final com.bytedance.android.live.revlink.impl.global.c getLinkInstanceService() {
        return this.q;
    }

    public static final void c(BreakThroughBarImpl r1) {
        if (r1.f == true) goto L5;
        r1.d("reload");
    L5:
        r1.p.i();
        r1.e = false;
        zy0.b r2 = r1.b;
        if (r2 == null) goto L11;
        xy0.a<?> r3 = r2.g();
        if (r3 == null) goto L12;
        r3.load(null, null);
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

    public final void d(String r5) {
        if (this.f == false) goto L5;
        return;
    L5:
        zy0.b r0 = this.b;
        if (r0 == null) goto L8;
        r0.dispose();
    L8:
        zy0.b r1 = (zy0.b) this.s.invoke(new vy0.a.b(), null, new BreakThroughBarImpl$initLynx$1(this));
        this.b = r1;
        if (r1 == null) goto L14;
        xy0.a<?> r2 = r1.g();
        if (r2 == null) goto L14;
        r2.load();
    L14:
        if (this.b == null) goto L16;
        this.f = true;
    L16:
        this.p.g(r5);
        if (this.p.e() == false) goto L20;
        i.R(this).b("BreakThroughBarService");
        return;
    }

    public final void e(JSONObject r3) {
        zy0.b r0 = this.b;
        if (r0 == null) goto L8;
        xy0.a<?> r1 = r0.g();
        if (r1 == null) goto L9;
        r1.sendJsEvent("H5_webcastNotification", r3.toString());
        return;
    L9:
        return;
    }

    public static final /* synthetic */ HybridType a(BreakThroughBarImpl r0, zy0.b r1) {
        return r0.getType(r1);
    }

    public static final String b(BreakThroughBarImpl r2, m3 r3, n3 r4, List r5, h3 r6) {
        r2.getClass();
        JSONObject r0 = new JSONObject();
        r0.put("config", GsonProtectorUtils.toJson(l97.a.a, r3));
        r0.put("info", GsonProtectorUtils.toJson(l97.a.a, r4));
        r0.put("score", GsonProtectorUtils.toJson(l97.a.a, r5));
        r0.put("title", GsonProtectorUtils.toJson(l97.a.a, r6));
        JSONObject r7 = new JSONObject();
        IRoom r8 = r2.r.getRoomContext().getCommonRoom();
        r7.put("channel_id", String.valueOf(i.m(r2).c()));
        r7.put("oppo_anchor_id", String.valueOf(i.T(r2).c()));
        String r9 = "";
        if (r8 == null) goto L8;
        IBaseUser r10 = r8.getOwnerKt();
        if (r10 == null) goto L8;
        String r12 = r10.getNickName();
        if (r12 == null) goto L8;
    L9:
        r7.put("self_anchor_name", r12);
        IBaseUser r13 = (IBaseUser) r2.n.getGuestUser().getValue();
        if (r13 == null) goto L15;
        String r14 = r13.getNickName();
        if (r14 == null) goto L15;
        r9 = r14;
    L15:
        r7.put("oppo_anchor_name", r9);
        r0.put("pkInfo", r7.toString());
        return r0.toString();
    L8:
        r12 = "";
        goto L9
    }

    /* JADX WARN: Type inference failed for: r2v6, types: [com.bytedance.android.live.revlink.impl.pk.breakthrough.BreakThroughBarImpl$timeLeftObserver$1] */
    public BreakThroughBarImpl(com.bytedance.android.live.revlink.impl.mergepk.pkbase.subplaymode.a r2, e r3, c r4, com.bytedance.android.live.revlink.link.biz.doublecomponent.d r5, BreakThroughUIOperationImpl r6, com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d r7, com.bytedance.android.livesdk.revenue.service.room.c r8, Function3 r9, boolean r10, ld.a r12) {
        Intrinsics.checkNotNullParameter(r2, "breakThroughViewModel");
        Intrinsics.checkNotNullParameter(r3, "pkBaseDataContext");
        Intrinsics.checkNotNullParameter(r4, "pkDataContext");
        Intrinsics.checkNotNullParameter(r5, "layoutManager");
        Intrinsics.checkNotNullParameter(r6, "uiOperation");
        Intrinsics.checkNotNullParameter(r7, "linkInstanceService");
        Intrinsics.checkNotNullParameter(r8, "revRoomService");
        Intrinsics.checkNotNullParameter(r9, "createCardFunc");
        Intrinsics.checkNotNullParameter(r12, "linkDataSet");
        this.l = r2;
        this.m = r3;
        this.n = r4;
        this.o = r5;
        this.p = r6;
        this.q = r7;
        this.r = r8;
        this.s = r9;
        this.t = r10;
        this.u = r12;
        this.a = d51.a.g.a();
        this.c = new ArrayDeque();
        this.d = new ArrayDeque();
        this.g = new CompositeDisposable();
        this.i = new BreakThroughBarImpl$timeLeftObserver$1(this);
        this.j = new BreakThroughBarImpl$battleScoreDataObserver$1(this);
        this.k = new BreakThroughBarImpl$playStateObserver$1(this);
    }
}
