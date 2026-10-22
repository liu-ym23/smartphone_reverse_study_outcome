package com.bytedance.android.live.revlink.impl.pk.scopeservice;

import android.net.Uri;
import android.os.SystemClock;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.o;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenue.common.p0;
import com.bytedance.android.live.revenue.platform.hybrid.api.HybridType;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.e;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.PkBaseResult;
import com.bytedance.android.live.revlink.link.biz.doublecomponent.LynxUIOperationImpl;
import com.bytedance.android.live.revlink.link.biz.service.i;
import com.bytedance.android.live.revlink.link.biz.service.k;
import com.bytedance.android.live.revlink.link.utils.UtilsKt;
import com.bytedance.android.livesdk.link.model.w2;
import com.bytedance.android.scope.m;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.revenue.platform.api.core.rx.f;
import cy0.j;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class PkLynxInfoImpl implements k {
    public static final /* synthetic */ int E = 0;
    public final boolean A;
    public final ld.a B;
    public final com.bytedance.android.livesdk.revenue.service.room.c C;
    public final Function3<vy0.a<Object>, Uri, Function1<? super yy0.c, Unit>, zy0.b> D;
    public final String a;
    public zy0.b b;
    public final ArrayDeque<String> c;
    public final ArrayDeque<ArrayList<String>> d;
    public boolean e;
    public boolean f;
    public LynxPkState g;
    public PkBaseResult h;
    public final CompositeDisposable i;
    public boolean j;
    public boolean k;
    public final PkLynxInfoImpl$pkStateObserver$1 l;
    public final PkLynxInfoImpl$timeLeftObserver$1 m;
    public final PkLynxInfoImpl$pkTeamTaskLynxDataObserver$1 n;
    public final PkLynxInfoImpl$pkResultObserver$1 o;
    public boolean p;
    public final PkLynxInfoImpl$pkTeamTaskObserver$1 q;
    public final PkLynxInfoImpl$pkConsecutiveWinObserver$1 r;
    public final PkLynxInfoImpl$firstUpdateObserver$1 s;
    public final d t;
    public final e u;
    public final com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c v;
    public final com.bytedance.android.live.revlink.impl.pk.vm.pk.e w;
    public final g41.a x;
    public final com.bytedance.android.live.revlink.impl.global.c y;
    public final com.bytedance.android.live.revlink.impl.pk.scopeservice.b z;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/scopeservice/PkLynxInfoImpl$LynxPkResult;", "", "", Constants.OperatorKey.CODE, "I", "getCode", "()I", "UNDEFINE", "SUCCESS", "FAILURE", "TIE", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum LynxPkResult extends Enum<LynxPkResult> {
        public static final LynxPkResult FAILURE = null;
        public static final LynxPkResult SUCCESS = null;
        public static final LynxPkResult TIE = null;
        public static final LynxPkResult UNDEFINE = null;
        public static final /* synthetic */ LynxPkResult[] a = null;
        private final int code;

        static {
            LynxPkResult r1 = new LynxPkResult("UNDEFINE", 0, -1);
            UNDEFINE = r1;
            LynxPkResult r2 = new LynxPkResult("SUCCESS", 1, 1);
            SUCCESS = r2;
            LynxPkResult r3 = new LynxPkResult("FAILURE", 2, 2);
            FAILURE = r3;
            LynxPkResult r4 = new LynxPkResult("TIE", 3, 3);
            TIE = r4;
            a = new LynxPkResult[]{r1, r2, r3, r4};
        }

        public static LynxPkResult valueOf(String r1) {
            return (LynxPkResult) r27.a.a(LynxPkResult.class, r1);
        }

        public static LynxPkResult[] values() {
            return (LynxPkResult[]) a.clone();
        }

        public final int getCode() {
            return this.code;
        }

        public LynxPkResult(String r1, int r2, int r3) {
            super(r1, r2);
            this.code = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/scopeservice/PkLynxInfoImpl$LynxPkState;", "", "", Constants.OperatorKey.CODE, "I", "getCode", "()I", "NONE", "PK", "PK_SETTLE", "PUNISH", "LINKING", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum LynxPkState extends Enum<LynxPkState> {
        public static final LynxPkState LINKING = null;
        public static final LynxPkState NONE = null;
        public static final LynxPkState PK = null;
        public static final LynxPkState PK_SETTLE = null;
        public static final LynxPkState PUNISH = null;
        public static final /* synthetic */ LynxPkState[] a = null;
        private final int code;

        static {
            LynxPkState r1 = new LynxPkState("NONE", 0, 0);
            NONE = r1;
            LynxPkState r2 = new LynxPkState("PK", 1, 1);
            PK = r2;
            LynxPkState r3 = new LynxPkState("PK_SETTLE", 2, 2);
            PK_SETTLE = r3;
            LynxPkState r4 = new LynxPkState("PUNISH", 3, 3);
            PUNISH = r4;
            LynxPkState r5 = new LynxPkState("LINKING", 4, 4);
            LINKING = r5;
            a = new LynxPkState[]{r1, r2, r3, r4, r5};
        }

        public static LynxPkState valueOf(String r1) {
            return (LynxPkState) r27.a.a(LynxPkState.class, r1);
        }

        public static LynxPkState[] values() {
            return (LynxPkState[]) a.clone();
        }

        public final int getCode() {
            return this.code;
        }

        public LynxPkState(String r1, int r2, int r3) {
            super(r1, r2);
            this.code = r3;
        }
    }

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.pk.scopeservice.PkLynxInfoImpl$attach$7, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lb03/b;", "p1", "", "invoke", "(Lb03/b;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass7 extends FunctionReferenceImpl implements Function1<b03.b, Unit> {
        public AnonymousClass7(PkLynxInfoImpl r8) {
            super(1, r8, PkLynxInfoImpl.class, "onPlatformConfigChanged", "onPlatformConfigChanged(Lcom/bytedance/android/platform/PlatformConfig;)V", 0);
        }

        public final void invoke(b03.b r2) {
            PkLynxInfoImpl r3 = (PkLynxInfoImpl) ((CallableReference) this).receiver;
            if (r3.x.a() == false) goto L7;
            com.bytedance.android.live.revlink.impl.pk.scopeservice.b r0 = r3.z;
            r3.x.isPortrait();
            r0.d();
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((b03.b) r1);
            return Unit.INSTANCE;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ PkLynxInfoImpl a;

        public b(PkLynxInfoImpl r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            Boolean r6 = (Boolean) r5;
            PkLynxInfoImpl r7 = this.a;
            r7.getClass();
            JSONObject r0 = new JSONObject();
            r0.put("type", "remain_time");
            r0.put(Constants.Keys.DATA, 0);
            r7.f(r0);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ PkLynxInfoImpl a;

        public c(PkLynxInfoImpl r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            sh6.b r5 = (sh6.b) r4;
            cy0.e.a.getClass();
            j r0 = cy0.e.a.a;
            m.e.getClass();
            Object r6 = m.b(r0).b(vr2.a.class);
            Intrinsics.checkNotNull(r6);
            if (((com.bytedance.live.kmp.core.c) r6).S8(Boolean.valueOf(this.a.A)) == false) goto L16;
            Object r7 = m.b(r0).b(com.bytedance.android.livesdk.revenue.service.interact.d.class);
            Intrinsics.checkNotNull(r7);
            if (((com.bytedance.live.kmp.core.c) r7).Sl() == true) goto L17;
            PkLynxInfoImpl r8 = this.a;
            Intrinsics.checkNotNullParameter(r8, "$this$clearScreenLinkUtils");
            if (i.getContext(r8).getClearScreenLinkUtils().b() == true) goto L13;
            PkLynxInfoImpl r1 = this.a;
            Intrinsics.checkNotNullParameter(r1, "$this$clearScreenLinkUtils");
            if (i.getContext(r1).getClearScreenLinkUtils().a() == true) goto L13;
            boolean r2 = false;
        L14:
            r8.z.g(!r2);
            return;
        L13:
            r2 = true;
            goto L14
        L17:
            return;
        }
    }

    static {
    }

    public final void attach() {
        this.u.getPkBaseState().observeForever(this.l);
        this.u.getBaseTimeLeft().observeForever(this.m);
        this.u.getPkBaseResult().observeForever(this.o);
        this.v.getTeamTaskOptAddition().observeForever(this.q);
        String r0 = (String) this.w.getPkTeamTaskLynxData().getValue();
        if (r0 == null) goto L5;
        c(r0);
    L5:
        this.w.getPkTeamTaskLynxData().observeForever(this.n);
        ArrayList<String> r1 = (ArrayList) this.w.getHandlePkConsecutiveWin().getValue();
        if (r1 != null) goto L8;
    L17:
        this.w.getHandlePkConsecutiveWin().observeForever(this.r);
        this.w.getHandleTeamTaskOverLine().observeForever(this.t);
        this.w.getHandleFirstUpdateMessage().observeForever(this.s);
        this.i.add(this.v.getInstallKillMsgEvent().subscribe(new b(this)));
        if (d51.b.m.a() == false) goto L20;
        p0.a(0, false, true, new AnonymousClass5(this), 3);
    L21:
        StringBuilder r2 = new StringBuilder("load start time = ");
        Intrinsics.checkNotNullParameter(i97.a.a, "$this$elapsedRealtime");
        r2.append(SystemClock.elapsedRealtime());
        jy0.b.d("PkLynxInfoWidget", r2.toString());
        if (this.x.a() == false) goto L25;
        com.bytedance.android.live.revlink.impl.pk.scopeservice.b r3 = this.z;
        this.x.isPortrait();
        r3.d();
    L25:
        f.a(ld.c.a(this.B.getCleanMode()).subscribe(new c(this)), this.i);
        z41.b.d.getClass();
        if (z41.b.c.P0() == false) goto L28;
        this.z.h();
    L28:
        f.a(UtilsKt.d(this.z.b(), new AnonymousClass7(this)), this.i);
        return;
    L20:
        b("onCreate");
        goto L21
    L8:
        if (i.o(this).d() == true) goto L17;
        if (i.o(this).i() == true) goto L17;
        Intrinsics.checkNotNullParameter(r1, "message");
        if (this.e == false) goto L15;
        d(r1);
        goto L17
    L15:
        if ((!r1.isEmpty()) == false) goto L17;
        this.d.addLast(r1);
        goto L17
    }

    public final void g() {
        if (this.g != LynxPkState.PUNISH) goto L28;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.f r0 = i.o(this);
        if (r0 != null) goto L7;
    L8:
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.f r1 = i.o(this);
        if (r1 != null) goto L11;
    L13:
        PkBaseResult r2 = this.h;
        int r3 = com.bytedance.android.live.revlink.impl.pk.scopeservice.c.a[r2.ordinal()];
        if (r3 != 1) goto L16;
        LynxPkResult r4 = LynxPkResult.SUCCESS;
    L24:
        if (r4 == LynxPkResult.UNDEFINE) goto L31;
        JSONObject r5 = new JSONObject();
        r5.put("type", "pk_result");
        r5.put(Constants.Keys.DATA, r4.getCode());
        e(r5);
        return;
    L31:
        return;
    L16:
        if (r3 != 2) goto L18;
        r4 = LynxPkResult.FAILURE;
        goto L24
    L18:
        if (r3 == 3) goto L20;
        r4 = LynxPkResult.UNDEFINE;
        goto L24
    L20:
        r4 = LynxPkResult.TIE;
        goto L24
    L11:
        if (r1.i() != true) goto L13;
        return;
    L7:
        if (r0.d() != true) goto L8;
        return;
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.k
    public final com.bytedance.android.live.revlink.impl.global.c getLinkInstanceService() {
        return this.y;
    }

    private final HybridType getType(zy0.b r1) {
        if (r1 == null) goto L6;
        xy0.a<?> r2 = r1.g();
        if (r2 == null) goto L6;
        return r2.o();
    L6:
        return null;
    }

    public final void b(String r10) {
        if (this.z.e() == false) goto L7;
        i.R(this).b("PkLynxInfoWidget");
        return;
    L7:
        if (this.f == false) goto L9;
        return;
    L9:
        jy0.b.d("PkLynxInfoWidget", "init lynx from onCreate");
        int r12 = com.bytedance.revenue.platform.api.core.e.a;
        Intrinsics.checkNotNullParameter("sslocal://webcast_lynxview?hybrid_type=lynx", "schemeString");
        Uri.Builder r13 = UriProtector.parse("sslocal://webcast_lynxview?hybrid_type=lynx").buildUpon();
        Uri r1 = com.bytedance.revenue.platform.api.core.e.a(this.a);
        Uri.Builder r2 = r1.buildUpon();
        if (UriProtector.getQueryParameterNames(r1).contains("team_task_type") == true) goto L12;
        h51.a r3 = h51.a.e;
        r3.getClass();
        r2.appendQueryParameter("team_task_type", String.valueOf(((Number) h51.a.c.getValue(r3, h51.a.a[1])).intValue()));
    L12:
        r2.appendQueryParameter("mode_type", String.valueOf(this.u.modType().getType()));
        IBaseUser r4 = this.C.getRoomContext().getCommonRoom().getOwnerKt();
        IBaseUser r5 = null;
        if (r4 == null) goto L15;
        String r6 = r4.getIdString();
    L16:
        r2.appendQueryParameter("anchor_id", r6);
        IBaseUser r7 = this.C.getRoomContext().getCommonRoom().getOwnerKt();
        if (r7 == null) goto L19;
        Intrinsics.checkNotNullParameter(r7, "$this$secUidExt");
        String r8 = r7.getCastSecUid();
    L20:
        r2.appendQueryParameter("sec_anchor_id", r8);
        r2.appendQueryParameter("user_id", this.C.getRoomContext().getCommonUser().getIdString());
        r2.appendQueryParameter("sec_user_id", o.a(this.C.getRoomContext().getCommonUser()));
        com.bytedance.android.livesdk.revenue.service.user.a r9 = i.Y(this).c;
        if (r9 == null) goto L23;
        r5 = r9.b();
    L23:
        if (r5 == null) goto L40;
        String r14 = iz.a.a(r5);
        boolean r15 = false;
        if (r14 != null) goto L27;
    L30:
        boolean r16 = true;
    L31:
        if (r16 == true) goto L33;
        r2.appendQueryParameter("user_id", iz.a.a(r5));
    L33:
        Intrinsics.checkNotNullParameter(r5, "$this$secUidExt");
        String r17 = r5.getCastSecUid();
        if (r17 != null) goto L36;
    L37:
        r15 = true;
    L38:
        if (r15 == true) goto L40;
        Intrinsics.checkNotNullParameter(r5, "$this$secUidExt");
        r2.appendQueryParameter("sec_user_id", r5.getCastSecUid());
        goto L40
    L36:
        if (r17.length() != 0) goto L38;
    L27:
        if (r14.length() == 0) goto L30;
        r16 = false;
    L40:
        r2.appendQueryParameter("room_id", this.C.getRoomContext().getCommonRoom().getIdStr());
        r2.appendQueryParameter("live_pk_enable_contribute_list", DataType.TRUE);
        cy0.e.a.getClass();
        j r18 = cy0.e.a.a;
        m.e.getClass();
        Object r19 = m.b(r18).a(Reflection.getOrCreateKotlinClass(vy0.b.class));
        Intrinsics.checkNotNull(r19);
        Uri r110 = r13.appendQueryParameter("url", ((vy0.b) ((f80.a) r19)).appendCommonParams(r2.build().toString())).build();
        zy0.b r20 = this.b;
        if (r20 == null) goto L43;
        r20.dispose();
    L43:
        zy0.b r111 = (zy0.b) this.D.invoke(new vy0.a.b(), r110, new PkLynxInfoImpl$createLynxCard$1(this));
        this.b = r111;
        if (r111 == null) goto L49;
        xy0.a<?> r112 = r111.g();
        if (r112 == null) goto L49;
        r112.load();
    L49:
        if (this.b == null) goto L51;
        this.f = true;
    L51:
        this.z.f();
        if (this.z.e() == false) goto L55;
        i.R(this).b("PkLynxInfoWidget");
        return;
    L55:
        return;
    L19:
        r8 = null;
        goto L20
    L15:
        r6 = null;
        goto L16
    }

    public final void c(String r4) {
        Intrinsics.checkNotNullParameter(r4, "message");
        if (this.u.getCurPKBaseState().b() == false) goto L6;
        return;
    L6:
        if (this.e == false) goto L8;
        JSONObject r0 = new JSONObject();
        r0.put("type", "refresh");
        r0.put(Constants.Keys.DATA, r4);
        r0.put("show_like_reword", false);
        f(r0);
        return;
    L8:
        this.c.addLast(r4);
    }

    public final void d(ArrayList<String> r4) {
        if (r4.isEmpty() == false) goto L5;
        return;
    L5:
        JSONObject r0 = new JSONObject();
        r0.put("type", "consecutive_win");
        r0.put(Constants.Keys.DATA, new JSONArray(r4));
        f(r0);
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

    public final void f(JSONObject r2) {
        PkBaseStateMachine.c r0 = this.u.getCurPKBaseState();
        r0.getClass();
        if ((r0 instanceof PkBaseStateMachine.c.d) == false) goto L5;
        return;
    L5:
        e(r2);
    }

    public final void h(w2 r4) {
        JSONObject r0 = new JSONObject();
        r0.put("type", "shell_config");
        if (r4 == null) goto L5;
        r0.put(Constants.Keys.DATA, GsonProtectorUtils.toJson(l97.a.a, r4));
    L5:
        e(r0);
    }

    public static final /* synthetic */ HybridType a(PkLynxInfoImpl r0, zy0.b r1) {
        return r0.getType(r1);
    }

    /* JADX WARN: Type inference failed for: r2v10, types: [com.bytedance.android.live.revlink.impl.pk.scopeservice.PkLynxInfoImpl$timeLeftObserver$1] */
    /* JADX WARN: Type inference failed for: r2v11, types: [com.bytedance.android.live.revlink.impl.pk.scopeservice.PkLynxInfoImpl$pkTeamTaskLynxDataObserver$1] */
    /* JADX WARN: Type inference failed for: r2v12, types: [com.bytedance.android.live.revlink.impl.pk.scopeservice.PkLynxInfoImpl$pkResultObserver$1] */
    /* JADX WARN: Type inference failed for: r2v13, types: [com.bytedance.android.live.revlink.impl.pk.scopeservice.PkLynxInfoImpl$pkTeamTaskObserver$1] */
    /* JADX WARN: Type inference failed for: r2v14, types: [com.bytedance.android.live.revlink.impl.pk.scopeservice.PkLynxInfoImpl$pkConsecutiveWinObserver$1] */
    /* JADX WARN: Type inference failed for: r2v15, types: [com.bytedance.android.live.revlink.impl.pk.scopeservice.PkLynxInfoImpl$firstUpdateObserver$1] */
    /* JADX WARN: Type inference failed for: r2v9, types: [com.bytedance.android.live.revlink.impl.pk.scopeservice.PkLynxInfoImpl$pkStateObserver$1] */
    public PkLynxInfoImpl(e r2, com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c r3, com.bytedance.android.live.revlink.impl.pk.vm.pk.e r4, com.bytedance.android.live.revlink.link.biz.doublecomponent.d r5, com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d r6, LynxUIOperationImpl r7, boolean r8, ld.a r9, com.bytedance.android.livesdk.revenue.service.room.c r10, Function3 r12) {
        Intrinsics.checkNotNullParameter(r2, "pkBaseDataContext");
        Intrinsics.checkNotNullParameter(r3, "pkDataContext");
        Intrinsics.checkNotNullParameter(r4, "pkLynxInfoViewModel");
        Intrinsics.checkNotNullParameter(r5, "layoutManager");
        Intrinsics.checkNotNullParameter(r6, "linkInstanceService");
        Intrinsics.checkNotNullParameter(r7, "uiOperation");
        Intrinsics.checkNotNullParameter(r9, "linkDataSet");
        Intrinsics.checkNotNullParameter(r10, "revRoomService");
        Intrinsics.checkNotNullParameter(r12, "createCardFunc");
        this.u = r2;
        this.v = r3;
        this.w = r4;
        this.x = r5;
        this.y = r6;
        this.z = r7;
        this.A = r8;
        this.B = r9;
        this.C = r10;
        this.D = r12;
        d51.a r13 = d51.a.g;
        r13.getClass();
        this.a = (String) d51.a.b.getValue(r13, d51.a.a[0]);
        this.c = new ArrayDeque();
        this.d = new ArrayDeque();
        this.g = LynxPkState.NONE;
        this.h = PkBaseResult.NOT_FINISH;
        this.i = new CompositeDisposable();
        this.l = new PkLynxInfoImpl$pkStateObserver$1(this);
        this.m = new PkLynxInfoImpl$timeLeftObserver$1(this);
        this.n = new PkLynxInfoImpl$pkTeamTaskLynxDataObserver$1(this);
        this.o = new PkLynxInfoImpl$pkResultObserver$1(this);
        this.q = new PkLynxInfoImpl$pkTeamTaskObserver$1(this);
        this.r = new PkLynxInfoImpl$pkConsecutiveWinObserver$1(this);
        this.s = new PkLynxInfoImpl$firstUpdateObserver$1(this);
        this.t = new d(this);
    }
}
