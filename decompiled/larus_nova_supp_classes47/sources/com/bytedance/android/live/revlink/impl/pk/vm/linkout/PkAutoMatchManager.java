package com.bytedance.android.live.revlink.impl.pk.vm.linkout;

import android.content.Context;
import androidx.lifecycle.LiveData;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revenue.common.x0;
import com.bytedance.android.live.revenue.platform.hybrid.impl.ui.HybridDialogImpl;
import com.bytedance.android.live.revlink.impl.control.s;
import com.bytedance.android.live.revlink.impl.multianchor.utils.q;
import com.bytedance.android.live.revlink.impl.pk.randompkcheck.RandomCheckDataContext;
import com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService;
import com.bytedance.android.live.revlink.impl.pk.utils.AutoMatchSource;
import com.bytedance.android.livesdk.chatroom.interact.model.h0;
import com.bytedance.android.livesdk.link.model.b0;
import com.bytedance.android.livesdk.revenue.service.broadcast.IRevBroadcastService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class PkAutoMatchManager implements com.bytedance.android.live.revlink.impl.pk.service.a {
    public static final /* synthetic */ int p = 0;
    public boolean a;
    public boolean b;
    public final CompositeDisposable c;
    public final PkAutoMatchDataContext d;
    public RandomCheckDataContext e;
    public final String f;
    public zy0.d g;
    public final l h;
    public final m i;
    public final k j;
    public final com.bytedance.android.live.revlink.impl.pk.vm.linkout.a k;
    public final ld.a l;
    public final com.bytedance.android.livesdk.revenue.service.room.c m;
    public final com.bytedance.android.live.revlink.impl.global.c n;
    public final yz0.f o;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/vm/linkout/PkAutoMatchManager$AutoMatchRequestSource;", "", "FromPkList", "FromRecordList", "FromJsb", "FromSeasonRank", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum AutoMatchRequestSource extends Enum<AutoMatchRequestSource> {
        public static final AutoMatchRequestSource FromJsb = null;
        public static final AutoMatchRequestSource FromPkList = null;
        public static final AutoMatchRequestSource FromRecordList = null;
        public static final AutoMatchRequestSource FromSeasonRank = null;
        public static final /* synthetic */ AutoMatchRequestSource[] a = null;

        static {
            AutoMatchRequestSource r1 = new AutoMatchRequestSource("FromPkList", 0);
            FromPkList = r1;
            AutoMatchRequestSource r2 = new AutoMatchRequestSource("FromRecordList", 1);
            FromRecordList = r2;
            AutoMatchRequestSource r3 = new AutoMatchRequestSource("FromJsb", 2);
            FromJsb = r3;
            AutoMatchRequestSource r4 = new AutoMatchRequestSource("FromSeasonRank", 3);
            FromSeasonRank = r4;
            a = new AutoMatchRequestSource[]{r1, r2, r3, r4};
        }

        public static AutoMatchRequestSource valueOf(String r1) {
            return (AutoMatchRequestSource) r27.a.a(AutoMatchRequestSource.class, r1);
        }

        public static AutoMatchRequestSource[] values() {
            return (AutoMatchRequestSource[]) a.clone();
        }

        public AutoMatchRequestSource(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public static final class b implements s {
        public final /* synthetic */ PkAutoMatchManager a;
        public final /* synthetic */ s b;

        @Override // com.bytedance.android.live.revlink.impl.control.s
        public final void onDismiss() {
            this.a.a = false;
            s r0 = this.b;
            if (r0 == null) goto L6;
            r0.onDismiss();
            return;
        }

        public b(PkAutoMatchManager r1, s r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.a
    public final NextLiveData<y31.k> b() {
        PkAutoMatchDataContext r0 = this.d;
        if (r0 == null) goto L7;
        NextLiveData<y31.k> r1 = r0.getMInvitingUserData();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new NextLiveData();
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.a
    public final h0 d() {
        PkAutoMatchDataContext r0 = this.d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.pkAutoMatchLogInfo();
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.a
    public final void dismissDialog() {
        this.k.f();
        this.a = false;
        zy0.d r0 = this.g;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.g = null;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.a
    public final List<i41.p> getListeners() {
        PkAutoMatchDataContext r0 = this.d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getListeners();
    }

    public final void h() {
        Pair r0 = com.bytedance.live.datacontext.d.a(PkAutoMatchManager$addRandomCheckDataContext$pair$1.INSTANCE);
        RandomCheckDataContext r1 = (RandomCheckDataContext) r0.getFirst();
        this.e = r1;
        if (r1 == null) goto L7;
        com.bytedance.live.datacontext.m<Boolean> r2 = r1.getRandomChecked();
        if (r2 == null) goto L7;
        r2.setValue(Boolean.valueOf(l51.a.d()));
    L7:
        RandomCheckDataContext r3 = this.e;
        if (r3 == null) goto L10;
        com.bytedance.live.datacontext.b.a(r3, RandomCheckDataContext.TAG);
    L10:
        this.c.add((Disposable) r0.getSecond());
    }

    public final d31.d i() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.n;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getRevLinkLogHelper();
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.a
    public final boolean isInviting() {
        PkAutoMatchDataContext r0 = this.d;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isInviting();
    }

    public final void j() {
        this.c.dispose();
        PkAutoMatchDataContext r0 = this.d;
        if (r0 == null) goto L7;
        LiveData<Long> r1 = r0.getLeftTime();
        if (r1 == null) goto L7;
        r1.removeObserver(this.h);
    L7:
        PkAutoMatchDataContext r2 = this.d;
        if (r2 == null) goto L12;
        LiveData<Long> r3 = r2.getWaitedTime();
        if (r3 == null) goto L12;
        r3.removeObserver(this.i);
    L12:
        PkAutoMatchDataContext r4 = this.d;
        if (r4 == null) goto L17;
        LiveData<l41.a> r5 = r4.getPkMatchState();
        if (r5 == null) goto L17;
        r5.removeObserver(this.j);
    L17:
        PkAutoMatchDataContext r6 = this.d;
        if (r6 == null) goto L21;
        r6.clearIt();
        return;
    }

    public static final com.bytedance.android.live.revlink.impl.pk.service.i g(PkAutoMatchManager r0) {
        com.bytedance.android.live.revlink.impl.global.c r1 = r0.n;
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.Hg();
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.a
    public final void a(final com.bytedance.android.live.revlink.impl.pk.service.j r19) {
        Intrinsics.checkNotNullParameter(r19, "autoMatchParams");
        com.bytedance.android.live.revlink.impl.global.c r3 = this.n;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r4 = null;
        if (r3 == null) goto L5;
        ox0.a r5 = r3.getModeMerge();
    L7:
        if (r5 == null) goto L9;
        int r6 = r5.a();
    L11:
        if (com.bytedance.android.live.utils.c.a(r6, 32) == false) goto L15;
        if (e51.b.d.a() == true) goto L15;
    L16:
        int r7 = ToastUtil.a;
        int r8 = w11.a.a;
        ToastUtil.a(2131917956, 0);
        if (r19.a != 12) goto L90;
        com.bytedance.android.live.revlink.impl.global.c r9 = this.n;
        if (r9 == null) goto L21;
        q r10 = r9.getMultiAnchorLinkLogUtils();
    L22:
        if (r10 == null) goto L90;
        r10.w(r19, "fail_for_audience_connection");
        goto L90
    L21:
        r10 = null;
    L90:
        boolean r12 = false;
    L91:
        if (r12 == true) goto L94;
        r19.f.b();
        return;
    L94:
        com.bytedance.android.livesdk.revenue.service.room.c r13 = this.m;
        if (r13 == null) goto L101;
        com.bytedance.android.livesdk.revenue.room.a r14 = r13.getRoomContext();
        if (r14 == null) goto L101;
        IRoom r15 = r14.getCommonRoom();
        if (r15 == null) goto L101;
        IRoom r16 = r15;
    L102:
        if (r16 == null) goto L104;
        long r17 = IRoomKtKt.getId((IRoomBase) r16);
    L105:
        long r18 = r17;
        Intrinsics.checkNotNullParameter(r19, "autoMatchParams");
        this.b = false;
        PkAutoMatchDataContext r2 = this.d;
        if (r2 == null) goto L108;
        r2.setJsbInvitePkCallback(r19.f);
    L108:
        b51.b r20 = b51.b.c0;
        r20.getClass();
        b51.a r22 = (b51.a) b51.b.z.getValue(r20, b51.b.a[24]);
        PkAutoMatchDataContext r23 = this.d;
        if (r23 == null) goto L111;
        r23.startMatch(r18, false, r19.e, r19.a, r19.d, r19.b, r19.g, new PkAutoMatchManager$startAutoMatchWithJsb$1(this, r19));
    L111:
        com.bytedance.android.live.revlink.impl.global.c r24 = this.n;
        if (r24 == null) goto L114;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r25 = r24.getLinkOptLogContext();
    L116:
        if (r25 == null) goto L118;
        String r26 = r19.c;
        Intrinsics.checkNotNullParameter(r26, "<set-?>");
        r25.c = r26;
    L118:
        com.bytedance.android.live.revlink.impl.global.c r27 = this.n;
        if (r27 == null) goto L121;
        r4 = r27.getLinkOptLogContext();
    L121:
        if (r4 == null) goto L124;
        String r1 = r19.b;
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r4.d = r1;
        return;
    L124:
        return;
    L114:
        r25 = null;
        goto L116
    L104:
        r17 = 0;
    L101:
        r16 = null;
    L15:
        if (com.bytedance.android.live.utils.c.a(r6, 8) == true) goto L16;
        if (com.bytedance.android.live.utils.c.a(r6, 4) == false) goto L27;
    L89:
        int r28 = ToastUtil.a;
        int r29 = w11.a.a;
        ToastUtil.a(2131917956, 0);
        goto L90
    L27:
        if (com.bytedance.android.live.utils.c.a(r6, 64) == true) goto L89;
        cy0.e.a.getClass();
        cy0.j r30 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r32 = com.bytedance.android.scope.m.b(r30).b(IRevBroadcastService.class);
        Intrinsics.checkNotNull(r32);
        if (((com.bytedance.live.kmp.core.c) r32).isPlayingGame() == false) goto L32;
        int r33 = ToastUtil.a;
        int r34 = w11.a.a;
        ToastUtil.a(2131921437, 0);
        goto L90
    L32:
        com.bytedance.android.live.revlink.impl.global.c r35 = this.n;
        if (r35 == null) goto L35;
        IPKLinkBizDataService r36 = r35.mk();
    L36:
        if (r36 == null) goto L38;
        q11.c r37 = r36.mo747getPkLinkState();
    L40:
        if (Intrinsics.areEqual(r37, q11.c.C0296c.b) == true) goto L82;
        com.bytedance.android.live.revlink.impl.global.c r38 = this.n;
        if (r38 == null) goto L44;
        IPKLinkBizDataService r39 = r38.mk();
    L45:
        if (r39 == null) goto L47;
        q11.c r40 = r39.mo747getPkLinkState();
    L49:
        if (Intrinsics.areEqual(r40, q11.c.a.b) == true) goto L82;
        RandomCheckDataContext.a r42 = RandomCheckDataContext.Companion;
        if (r42.getContext() != null) goto L54;
        h();
    L54:
        RandomCheckDataContext r43 = this.e;
        if (r43 == null) goto L59;
        com.bytedance.live.datacontext.m<Boolean> r44 = r43.getRandomChecked();
        if (r44 == null) goto L59;
        r44.setValue(Boolean.valueOf(r42.b()));
    L59:
        RandomCheckDataContext r45 = this.e;
        if (r45 == null) goto L73;
        com.bytedance.live.datacontext.m<Boolean> r46 = r45.getRandomChecked();
        if (r46 == null) goto L73;
        if (((Boolean) r46.getValue()).booleanValue() == true) goto L73;
        com.bytedance.android.live.revlink.impl.global.c r47 = this.n;
        if (r47 == null) goto L68;
        com.bytedance.android.live.revlink.impl.service.internal.a r48 = r47.Do();
    L69:
        if (r48 == null) goto L71;
        r48.m();
    L71:
        h();
        this.k.k(r19);
        goto L90
    L68:
        r48 = null;
    L73:
        if (r19.a != 12) goto L80;
        com.bytedance.android.live.revlink.impl.global.c r49 = this.n;
        if (r49 == null) goto L77;
        q r50 = r49.getMultiAnchorLinkLogUtils();
    L78:
        if (r50 == null) goto L80;
        r50.w(r19, "start_matching");
        goto L80
    L77:
        r50 = null;
    L80:
        r12 = true;
        goto L91
    L47:
        r40 = null;
        goto L49
    L44:
        r39 = null;
    L82:
        if (r19.a != 12) goto L90;
        com.bytedance.android.live.revlink.impl.global.c r52 = this.n;
        if (r52 == null) goto L86;
        q r53 = r52.getMultiAnchorLinkLogUtils();
    L87:
        if (r53 == null) goto L90;
        r53.w(r19, "fail_for_inviting");
        goto L90
    L86:
        r53 = null;
        goto L87
    L38:
        r37 = null;
        goto L40
    L35:
        r36 = null;
        goto L36
    L9:
        r6 = 0;
        goto L11
    L5:
        r5 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.a
    public final void c(s r8) {
        PkAutoMatchDataContext r0 = this.d;
        Long r1 = null;
        if (r0 == null) goto L5;
        af2.e r2 = r0.getAutoMatchModel();
    L7:
        if (r2 == null) goto L9;
    L12:
        b51.b r3 = b51.b.c0;
        r3.getClass();
        ReadOnlyProperty r4 = b51.b.D;
        KProperty[] r5 = b51.b.a;
        if (((Boolean) r4.getValue(r3, r5[28])).booleanValue() == false) goto L54;
        String r6 = (String) b51.b.E.getValue(r3, r5[29]);
        if (r6.length() <= 0) goto L17;
        boolean r7 = true;
    L18:
        if (r7 == false) goto L54;
        final x0 r9 = new x0(r6);
        x0 r10 = r9.d("url");
        com.bytedance.android.livesdk.revenue.service.room.c r12 = this.m;
        if (r12 == null) goto L26;
        com.bytedance.android.livesdk.revenue.room.a r13 = r12.getRoomContext();
        if (r13 == null) goto L26;
        IRoom r14 = r13.getCommonRoom();
        if (r14 == null) goto L26;
        IRoom r15 = r14;
    L27:
        if (r15 == null) goto L29;
        Long r16 = Long.valueOf(IRoomKtKt.getId((IRoomBase) r15));
    L30:
        r10.b("room_id", String.valueOf(r16));
        cy0.e.a.getClass();     // Catch: Exception -> L75
        cy0.j r17 = cy0.e.a.a;     // Catch: Exception -> L75
        com.bytedance.android.scope.m.e.getClass();     // Catch: Exception -> L75
        Object r18 = com.bytedance.android.scope.m.b(r17).b(com.bytedance.android.livesdk.revenue.service.user.a.class);     // Catch: Exception -> L75
        Intrinsics.checkNotNull(r18);     // Catch: Exception -> L75
        IBaseUser r19 = ((com.bytedance.live.kmp.core.c) r18).b();     // Catch: Exception -> L75
        if (r19 == null) goto L39;
        py.k r20 = r19.getAvatarThumbKt();     // Catch: Exception -> L75
        if (r20 == null) goto L39;
        List r22 = r20.getUrls();     // Catch: Exception -> L75
        if (r22 == null) goto L39;
        String r23 = (String) ListProtector.get(r22, 0);     // Catch: Exception -> L75
        if (r23 == null) goto L39;
    L40:
        r10.b("business_type", r41.b.a());
        r10.b("group", r41.b.a());
        r10.b("anchor_avatar", r23);
        PkAutoMatchDataContext r24 = this.d;
        if (r24 == null) goto L45;
        LiveData<Long> r25 = r24.getLeftTime();
        if (r25 == null) goto L45;
        Long r26 = (Long) r25.getValue();
    L46:
        r10.b("init_left_time", String.valueOf(r26));
        r10.b("match_type", String.valueOf(1));
        yz0.g r27 = (yz0.g) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.g.class);
        if (r27 == null) goto L78;
        Context r28 = r27.getContext();
        if (r28 == null) goto L79;
        cy0.e.a.getClass();
        cy0.j r29 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r30 = com.bytedance.android.scope.m.b(r29).a(Reflection.getOrCreateKotlinClass(vy0.b.class));
        Intrinsics.checkNotNull(r30);
        HybridDialogImpl r32 = ((vy0.b) ((f80.a) r30)).U0(r28, r9.c(), null);
        this.g = r32;
        if (r32 == null) goto L80;
        r32.j0(new PkAutoMatchManager$handleToolbarPkClick$$inlined$let$lambda$1(this, r9));
        return;
    L80:
        return;
    L79:
        return;
    L78:
        return;
    L45:
        r26 = null;
    L39:
        r23 = "";
        goto L40
    L29:
        r16 = null;
    L26:
        r15 = null;
        goto L27
    L17:
        r7 = false;
    L54:
        PkAutoMatchDataContext r33 = this.d;
        if (r33 == null) goto L59;
        LiveData<Long> r34 = r33.getLeftTime();
        if (r34 == null) goto L59;
        r1 = (Long) r34.getValue();
    L59:
        if (r1 != null) goto L62;
    L72:
        com.bytedance.android.live.revlink.impl.pk.vm.linkout.a r35 = this.k;
        PkAutoMatchDataContext r36 = this.d;
        Intrinsics.checkNotNull(r36);
        r35.e(r36);
    L73:
        this.k.h(new b(this, r8));
        this.a = true;
        return;
    L62:
        if (r1.longValue() != 0) goto L72;
        PkAutoMatchDataContext r37 = this.d;
        if (r37 == null) goto L72;
        if (r37.isSpeedUp() == true) goto L72;
        if (this.b == true) goto L72;
        d51.c r38 = d51.c.A0;
        r38.getClass();
        if (((Boolean) d51.c.h.getValue(r38, d51.c.a[6])).booleanValue() == true) goto L72;
        this.k.b();
        this.b = true;
        goto L73
    L9:
        if (r41.b.a == true) goto L12;
        int r39 = ToastUtil.a;
        int r40 = w11.a.a;
        ToastUtil.a(2131919520, 0);
        return;
    L5:
        r2 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.a
    public final void f(AutoMatchSource r2) {
        Intrinsics.checkNotNullParameter(r2, "source");
        PkAutoMatchDataContext r0 = this.d;
        if (r0 == null) goto L5;
        r0.endMatch(r2);
    L5:
        this.k.d();
        this.a = false;
        this.b = false;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.a
    public final void e(long r14, b0 r16, AutoMatchRequestSource r17, Function1 r18) {
        Intrinsics.checkNotNullParameter(r17, "rqs");
        this.b = false;
        if (j.a[r17.ordinal()] == 1) goto L5;
        int r6 = 1;
    L6:
        PkAutoMatchDataContext r1 = this.d;
        if (r1 == null) goto L9;
        PkAutoMatchDataContext.startMatch$default(r1, r14, false, r16, r6, 0, null, null, r18, 96, null);
    L9:
        jy0.b.d("PkAutoMatchManager", "startMatch");
        return;
    L5:
        r6 = 13;
        goto L6
    }

    public PkAutoMatchManager(com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.a r5, ld.a r6, com.bytedance.android.livesdk.revenue.service.room.c r7, com.bytedance.android.live.revlink.impl.global.c r8, yz0.f r9) {
        Intrinsics.checkNotNullParameter(r5, "host");
        this.k = r5;
        this.l = r6;
        this.m = r7;
        this.n = r8;
        this.o = r9;
        AutoMatchRequestSource r10 = AutoMatchRequestSource.FromPkList;
        CompositeDisposable r12 = new CompositeDisposable();
        this.c = r12;
        int r0 = r41.c.a;
        this.f = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_anim_pk_random_point.webp";
        l r1 = new l(this);
        this.h = r1;
        m r2 = new m(this);
        this.i = r2;
        k r3 = new k(this);
        this.j = r3;
        PkAutoMatchDataContext r4 = new PkAutoMatchDataContext(r6, r7, r8, r9);
        this.d = r4;
        com.bytedance.live.datacontext.k<String> r13 = r4.getShowPopupEvent();
        if (r13 == null) goto L9;
        PublishSubject r14 = r13.onEvent();
        if (r14 == null) goto L9;
        Disposable r15 = r14.subscribe(new d(this));
        if (r15 == null) goto L9;
        com.bytedance.revenue.platform.api.core.rx.f.a(r15, r12);
    L9:
        com.bytedance.live.datacontext.k<Boolean> r16 = r4.getDismissDialogEvent();
        if (r16 == null) goto L16;
        PublishSubject r17 = r16.onEvent();
        if (r17 == null) goto L16;
        Disposable r18 = r17.subscribe(new e(this));
        if (r18 == null) goto L16;
        com.bytedance.revenue.platform.api.core.rx.f.a(r18, r12);
    L16:
        com.bytedance.live.datacontext.k<com.bytedance.android.livesdk.link.model.bridge.s> r19 = r4.getShowMatchInviteDialogEvent();
        if (r19 == null) goto L23;
        PublishSubject r20 = r19.onEvent();
        if (r20 == null) goto L23;
        Disposable r22 = r20.subscribe(new h(this));
        if (r22 == null) goto L23;
        com.bytedance.revenue.platform.api.core.rx.f.a(r22, r12);
    L23:
        com.bytedance.live.datacontext.k<Boolean> r23 = r4.getDismissMatchInviteDialogEvent();
        if (r23 == null) goto L30;
        PublishSubject r24 = r23.onEvent();
        if (r24 == null) goto L30;
        Disposable r25 = r24.subscribe(new i(this));
        if (r25 == null) goto L30;
        com.bytedance.revenue.platform.api.core.rx.f.a(r25, r12);
    L30:
        LiveData<Long> r26 = r4.getLeftTime();
        if (r26 == null) goto L33;
        r26.observeForever(r1);
    L33:
        LiveData<Long> r27 = r4.getWaitedTime();
        if (r27 == null) goto L36;
        r27.observeForever(r2);
    L36:
        LiveData<l41.a> r28 = r4.getPkMatchState();
        if (r28 == null) goto L39;
        r28.observeForever(r3);
    L39:
        Pair r29 = com.bytedance.live.datacontext.d.a(PkAutoMatchManager$pair$1.INSTANCE);
        ((PKAutoMatchServiceContext) r29.getFirst()).getService().d(this);
        com.bytedance.android.live.revlink.impl.global.d.a((DataContext) r29.getFirst(), "IPKAutoMatchService", r8);
        h();
        r12.add((Disposable) r29.getSecond());
    }
}
