package com.bytedance.android.live.revlink.impl.pk.feedview.bridge;

import android.os.CountDownTimer;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.PkBaseDataContext;
import com.bytedance.android.live.revlink.impl.pk.feedview.frame.ModeType;
import com.bytedance.android.live.revlink.impl.pk.feedview.machine.FeedPkStateMachine;
import com.bytedance.android.live.revlink.impl.pk.feedview.machine.l;
import com.bytedance.android.live.revlink.impl.pk.feedview.machine.q;
import com.bytedance.android.live.revlink.impl.pk.feedview.machine.t;
import com.bytedance.android.live.revlink.impl.pk.feedview.machine.w;
import com.bytedance.android.live.revlink.impl.pk.feedview.r;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livesdk.link.model.IBattleBarConfig;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.IBattleUserInfo;
import com.bytedance.android.livesdk.link.model.a1;
import com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting;
import com.bytedance.android.livesdk.link.model.c1;
import com.bytedance.android.livesdk.link.model.c3;
import com.bytedance.android.livesdk.link.model.d1;
import com.bytedance.android.livesdk.link.model.e1;
import com.bytedance.android.livesdk.link.model.e3;
import com.bytedance.android.livesdk.link.model.f4;
import com.bytedance.android.livesdk.link.model.g5;
import com.bytedance.android.livesdk.link.model.h3;
import com.bytedance.android.livesdk.link.model.j;
import com.bytedance.android.livesdk.link.model.k5;
import com.bytedance.android.livesdk.link.model.m3;
import com.bytedance.android.livesdk.link.model.n3;
import com.bytedance.android.livesdk.link.model.t1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.kmp.util.e;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements w, t, d, q {
    public final FeedPkBridgePresenter a;
    public IRoom b;
    public boolean c;
    public final MutableLiveData<Integer> d;
    public final MutableLiveData<l> e;
    public final MutableLiveData<com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a> f;
    public final MutableLiveData<String> g;
    public final MutableLiveData<q11.a> h;
    public final MutableLiveData<String> i;
    public final MutableLiveData<String> j;
    public boolean k;
    public boolean l;
    public b m;
    public CountDownTimerC0162c n;
    public final LinkedList<f4> o;
    public final LinkedList<f4> p;
    public final r q;
    public final com.bytedance.android.live.revlink.impl.pk.feedview.viewstate.b r;
    public final FeedPkStateMachine s;

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001¨\u0006\u0003"}, d2 = {"com/bytedance/android/live/revlink/impl/pk/feedview/bridge/c$a", "Lcom/google/gson/reflect/TypeToken;", "Lcom/bytedance/android/livesdk/link/model/e1;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class a extends TypeToken<e1> {
        public a() {
        }
    }

    public static final class b extends CountDownTimer {
        public final /* synthetic */ c a;

        @Override // android.os.CountDownTimer
        public final void onTick(long r1) {
        }

        @Override // android.os.CountDownTimer
        public final void onFinish() {
            c r0 = this.a;
            r r1 = r0.q;
            if (r1 == null) goto L5;
            r1.b = Boolean.FALSE;
        L5:
            if (r1 == null) goto L7;
            r1.a = null;
        L7:
            r0.k = false;
            r0.o.remove();
            this.a.r.g();
            this.a.n();
        }

        public b(c r3, long r4) {
            this.a = r3;
            super(r4, 1000);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.pk.feedview.bridge.c$c, reason: collision with other inner class name */
    public static final class CountDownTimerC0162c extends CountDownTimer {
        public final /* synthetic */ c a;

        @Override // android.os.CountDownTimer
        public final void onTick(long r1) {
        }

        @Override // android.os.CountDownTimer
        public final void onFinish() {
            c r0 = this.a;
            r r1 = r0.q;
            if (r1 == null) goto L5;
            r1.d = Boolean.FALSE;
        L5:
            if (r1 == null) goto L7;
            r1.c = null;
        L7:
            r0.l = false;
            r0.p.remove();
            this.a.r.g();
            this.a.o();
        }

        public CountDownTimerC0162c(c r3, long r4) {
            this.a = r3;
            super(r4, 1000);
        }
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.feedview.bridge.d
    public final void e() {
    }

    public final void f() {
        b r0 = this.m;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        CountDownTimerC0162c r1 = this.n;
        if (r1 == null) goto L8;
        r1.cancel();
    L8:
        this.k = false;
        LinkedList<f4> r2 = this.o;
        if (r2 == null) goto L11;
        r2.clear();
    L11:
        this.l = false;
        LinkedList<f4> r3 = this.p;
        if (r3 == null) goto L14;
        r3.clear();
    L14:
        r r4 = this.q;
        if (r4 == null) goto L18;
        Boolean r5 = Boolean.FALSE;
        r4.b = r5;
        r4.a = null;
        r4.c = null;
        r4.d = r5;
        return;
    }

    public final void n() {
        if (this.k == false) goto L5;
        return;
    L5:
        f4 r0 = this.o.peek();
        if (r0 != null) goto L8;
        return;
    L8:
        long r1 = e.b();
        if (r1 > r0.getStartTime()) goto L11;
        r1 = r0.getStartTime();
    L11:
        long r3 = r0.getEndTime() - r1;
        if (r3 >= WebcastRedirectException.UNKNOWN) goto L15;
        this.o.remove();
        n();
        return;
    L15:
        r r2 = this.q;
        if (r2 == null) goto L18;
        r2.a = r0;
    L18:
        this.r.q = r2;
        b r4 = new b(this, r3);
        this.m = r4;
        r4.start();
        this.k = true;
        r r5 = this.q;
        if (r5 == null) goto L22;
        r5.b = Boolean.TRUE;
        return;
    }

    public final void o() {
        if (this.l == false) goto L5;
        return;
    L5:
        f4 r0 = this.p.peek();
        if (r0 != null) goto L8;
        return;
    L8:
        long r1 = e.b();
        if (r1 > r0.getStartTime()) goto L11;
        r1 = r0.getStartTime();
    L11:
        long r3 = r0.getEndTime() - r1;
        if (r3 >= WebcastRedirectException.UNKNOWN) goto L15;
        this.p.remove();
        o();
        return;
    L15:
        r r2 = this.q;
        if (r2 == null) goto L18;
        r2.c = r0;
    L18:
        this.r.q = r2;
        CountDownTimerC0162c r4 = new CountDownTimerC0162c(this, r3);
        this.n = r4;
        r4.start();
        this.l = true;
        r r5 = this.q;
        if (r5 == null) goto L22;
        r5.d = Boolean.TRUE;
        return;
    }

    public static ModeType i(IBaseBattleSetting r2) {
        IBattleConfigSetting r3 = r2.getBattleConfigSetting();
        if (r3 == null) goto L5;
        Integer r4 = Integer.valueOf(r3.getModType());
    L6:
        int r0 = PkBaseDataContext.PKModType.BreakThrough.ordinal();
        if (r4 != null) goto L10;
    L12:
        int r1 = PkBaseDataContext.PKModType.Vote.ordinal();
        if (r4 == null) goto L19;
        if (r4.intValue() != r1) goto L19;
        return ModeType.Vote;
    L19:
        return ModeType.PK;
    L10:
        if (r4.intValue() != r0) goto L12;
        return ModeType.BreakThough;
    L5:
        r4 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.feedview.bridge.d
    public final void a(d1 r6) {
        Intrinsics.checkNotNullParameter(r6, "effectInfo");
        com.bytedance.android.live.revlink.impl.pk.feedview.viewstate.b r0 = this.r;
        if ((r0.e instanceof l.c) == false) goto L13;
        Long r1 = r0.s;
        long r2 = r6.getBattleId();
        if (r1 != null) goto L8;
        return;
    L8:
        if (r1.longValue() == r2) goto L10;
        return;
    L10:
        if (TextUtils.isEmpty(r6.getBattleEffectInfo()) == true) goto L15;
        k(r6.getBattleEffectInfo());
        return;
    L15:
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.feedview.bridge.d
    public final void b(g5 r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        com.bytedance.android.live.revlink.impl.pk.feedview.viewstate.b r0 = this.r;
        r0.m = r2.getTeamTaskJson();
        this.g.setValue(this.r.m);
        this.r.g();
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.feedview.bridge.d
    public final void c(k5 r6) {
        Intrinsics.checkNotNullParameter(r6, "message");
        ArrayList r0 = new ArrayList();
        List r1 = r6.getUserScores();
        if (r1 == null) goto L8;
        Iterator r2 = r1.iterator();
    L6:
        if (r2.hasNext() == false) goto L8;
        r0.add((t1) r2.next());
    L8:
        t41.a r3 = t41.a.m;
        r3.getClass();
        if (((Boolean) t41.a.e.getValue(r3, t41.a.a[3])).booleanValue() == true) goto L11;
        return;
    L11:
        List r4 = r6.getUserScores();
        if (r4 == null) goto L14;
        IBattleBarConfig r5 = r6.getBattleBarConfig();
        IBaseUser r7 = r6.getFromUser();
        Intrinsics.checkNotNullParameter(r6, "$this$fromUserId");
        r6.get_fromUserId();
        s(r4, r5, r7);
    L14:
        n3 r8 = r6.getBreakthroughInfo();
        if (r8 == null) goto L17;
        com.bytedance.android.live.revlink.impl.pk.feedview.viewstate.b r9 = this.r;
        r9.o = r8;
        r9.p = r6.getUserScores();
        this.r.f(3);
    L17:
        this.r.g();
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.feedview.machine.q
    public final void d(int r3) {
        l r0 = this.s.a();
        if ((r0 instanceof l.a) == false) goto L6;
        com.bytedance.android.live.revlink.impl.pk.feedview.viewstate.b r1 = this.r;
        r1.e = r0;
        r1.h = Integer.valueOf(r3);
        this.r.g();
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.feedview.machine.t
    public final void g(int r3) {
        this.d.setValue(Integer.valueOf(r3));
        l r0 = this.s.a();
        if ((r0 instanceof l.b) == false) goto L5;
        com.bytedance.android.live.revlink.impl.pk.feedview.viewstate.b r1 = this.r;
        r1.e = r0;
        r1.g = Integer.valueOf(r3);
        this.r.g();
    L5:
        com.bytedance.android.live.revlink.impl.pk.feedview.viewstate.b r4 = this.r;
        if (r4.d != ModeType.BreakThough) goto L9;
        r4.f(2);
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.feedview.machine.w
    public final void h(int r3) {
        this.d.setValue(Integer.valueOf(r3));
        l r0 = this.s.a();
        if ((r0 instanceof l.c) == false) goto L5;
        com.bytedance.android.live.revlink.impl.pk.feedview.viewstate.b r1 = this.r;
        r1.e = r0;
        r1.g = Integer.valueOf(r3);
        this.r.g();
    L5:
        com.bytedance.android.live.revlink.impl.pk.feedview.viewstate.b r4 = this.r;
        if (r4.d != ModeType.BreakThough) goto L9;
        r4.f(2);
        return;
    }

    public final void k(String r5) {
        this.i.setValue(r5);
        e1 r6 = (e1) GsonProtectorUtils.fromJson(GsonHelper.get(), r5, new a().getType());
        IRoom r0 = this.b;
        if (r0 == null) goto L7;
        IBaseUser r1 = r0.getOwner();
        if (r1 == null) goto L7;
        String r2 = iz.a.a(r1);
    L8:
        if (r6 == null) goto L28;
        Map r7 = r6.getAnchorEffectMap();
        if (r7 == null) goto L47;
        Iterator r8 = r7.entrySet().iterator();
    L13:
        if (r8.hasNext() == false) goto L48;
        Map.Entry r3 = (Map.Entry) r8.next();
        String r4 = (String) r3.getKey();
        j r9 = (j) r3.getValue();
        if (TextUtils.equals(r4.toString(), r2) == true) goto L16;
        if (r9 == null) goto L13;
        List r10 = r9.getEffectList();
        if (r10 == null) goto L13;
        if (r10.size() < this.p.size()) goto L13;
        this.p.clear();
        this.p.addAll(r10);
        o();
        goto L13
    L16:
        if (r9 == null) goto L13;
        List r12 = r9.getEffectList();
        if (r12 == null) goto L13;
        if (r12.size() < this.o.size()) goto L13;
        this.o.clear();
        this.o.addAll(r12);
        n();
        goto L13
    L48:
        return;
    L47:
        return;
    L28:
        return;
    L7:
        r2 = null;
        goto L8
    }

    public final void l(c3 r4) {
        long r0 = r4.getSkinType();
        this.r.c = Long.valueOf(r0);
        q(r4.getBattleUserInfoMap());
        r(r4.getBattleUserInfoMap());
        List r1 = r4.getBattleScorePairList();
        c1 r2 = r4.getBattleSetting();
        if (r2 == null) goto L5;
        IBattleBarConfig r3 = r2.getBarConfig();
    L6:
        s(r1, r3, null);
        String r5 = r4.getTeamTaskJson();
        this.r.m = r5;
        this.g.setValue(r5);
        p(r4.getBattleSetting(), r4.getBreakthroughInfo(), r4.getBattleScorePairList());
        String r6 = r4.getBattleEffectInfo();
        if (TextUtils.isEmpty(r6) == true) goto L10;
        Intrinsics.checkNotNull(r6);
        k(r6);
        return;
    L10:
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final void m(e3 r4) {
        long r0 = r4.getSkinType();
        this.r.c = Long.valueOf(r0);
        q(r4.getBattleUserInfoMap());
        r(r4.getBattleUserInfoMap());
        List r1 = r4.getBattleScorePairList();
        c1 r2 = r4.getBattleSetting();
        if (r2 == null) goto L5;
        IBattleBarConfig r3 = r2.getBarConfig();
    L6:
        s(r1, r3, null);
        String r5 = r4.getTeamTaskJson();
        this.r.m = r5;
        this.g.setValue(r5);
        p(r4.getBattleSetting(), r4.getBreakthroughInfo(), r4.getBattleScorePairList());
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final void q(Map<String, ? extends IBattleUserInfo> r5) {
        IRoom r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r5 == null) goto L16;
        Iterator<Map.Entry<String, ? extends IBattleUserInfo>> r6 = r5.entrySet().iterator();
    L8:
        if (r6.hasNext() == false) goto L22;
        Map.Entry<String, ? extends IBattleUserInfo> r1 = r6.next();
        String r2 = r1.getKey();
        IBaseUser r3 = r0.getOwner();
        if (r3 == null) goto L12;
        String r4 = iz.a.a(r3);
    L14:
        if ((!Intrinsics.areEqual(r2, r4)) == false) goto L8;
        this.r.f = r1.getValue();
        goto L8
    L12:
        r4 = null;
        goto L14
    L22:
        return;
    }

    public final void r(Map<String, ? extends IBattleUserInfo> r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        IRoom r0 = this.b;
        if (r0 == null) goto L44;
        IBaseUser r1 = r0.getOwner();
        if (r1 == null) goto L45;
        String r2 = iz.a.a(r1);
        if (r2 != null) goto L12;
        return;
    L12:
        if (r3.containsKey(r2) == false) goto L46;
        IBattleUserInfo r4 = r3.get(r2);
        if (r4 == null) goto L16;
        Integer r5 = Integer.valueOf(r4.getPkResult());
    L17:
        int r6 = IBattleUserInfo.PKResult.PKUnCompute.ordinal();
        if (r5 != null) goto L21;
    L23:
        int r7 = IBattleUserInfo.PKResult.PKVictory.ordinal();
        if (r5 != null) goto L27;
    L29:
        int r8 = IBattleUserInfo.PKResult.PKFail.ordinal();
        if (r5 != null) goto L33;
    L35:
        int r9 = IBattleUserInfo.PKResult.PKTie.ordinal();
        if (r5 != null) goto L39;
    L41:
        q11.a r10 = q11.a.d.a;
    L42:
        this.r.l = r10;
        this.h.setValue(r10);
        return;
    L39:
        if (r5.intValue() != r9) goto L41;
        r10 = q11.a.C0294a.a;
        goto L42
    L33:
        if (r5.intValue() != r8) goto L35;
        r10 = q11.a.c.a;
        goto L42
    L27:
        if (r5.intValue() != r7) goto L29;
        r10 = q11.a.b.a;
        goto L42
    L21:
        if (r5.intValue() != r6) goto L23;
        r10 = q11.a.d.a;
        goto L42
    L16:
        r5 = null;
        goto L17
    L46:
        return;
    L45:
        return;
    }

    public c(com.bytedance.android.live.revlink.impl.pk.feedview.viewstate.b r2, FeedPkStateMachine r3) {
        Intrinsics.checkNotNullParameter(r2, "viewState");
        Intrinsics.checkNotNullParameter(r3, "machine");
        this.r = r2;
        this.s = r3;
        this.a = new FeedPkBridgePresenter();
        this.d = new MutableLiveData();
        this.e = new MutableLiveData();
        this.f = new MutableLiveData();
        this.g = new MutableLiveData();
        this.h = new MutableLiveData();
        this.i = new MutableLiveData();
        this.j = new MutableLiveData();
        this.o = new LinkedList();
        this.p = new LinkedList();
        this.q = new r(null, null, null);
    }

    public final z31.d j(List r7, IBattleBarConfig r8, IBaseUser r9) {
        if (r7 != null) goto L5;
        return null;
    L5:
        IRoom r1 = this.b;
        if (r1 != null) goto L8;
        return null;
    L8:
        z31.d r2 = new z31.d();
        Iterator r10 = r7.iterator();
    L10:
        if (r10.hasNext() == false) goto L22;
        t1 r3 = (af2.b) r10.next();
        String r4 = af2.c.a(r3);
        IBaseUser r5 = r1.getOwner();
        if (r5 == null) goto L14;
        String r6 = iz.a.a(r5);
    L16:
        if (Intrinsics.areEqual(r4, r6) == true) goto L17;
        r2.d = Integer.valueOf((int) af2.c.b(r3));
        r3.getScoreText();
        goto L10
    L17:
        r3.getScoreRelativeText();
        r2.a = Integer.valueOf((int) af2.c.b(r3));
        r2.b = r8;
        if ((r3 instanceof t1) == false) goto L20;
        t1 r12 = r3;
        r12.getCurAddScoreText();
        r2.c = r9;
        r12.getBuffScoreRatio();
    L20:
        r3.getScoreText();
        goto L10
    L14:
        r6 = null;
        goto L16
    L22:
        return r2;
    }

    public final void p(c1 r7, n3 r8, List<? extends a1> r9) {
        if (r7 == null) goto L5;
        long r2 = r7.getFinished();
    L6:
        m3 r4 = null;
        if (r2 <= 0) goto L13;
        com.bytedance.android.live.revlink.impl.pk.feedview.viewstate.b r0 = this.r;
        if (r7 == null) goto L11;
        h3 r1 = r7.getPunishConfig();
    L12:
        r0.i = r1;
    L18:
        com.bytedance.android.live.revlink.impl.pk.feedview.viewstate.b r3 = this.r;
        if (r7 == null) goto L23;
        IBattleConfigSetting r10 = r7.getBattleConfigSetting();
        if (r10 == null) goto L23;
        r4 = r10.getBreakthroughConfig();
    L23:
        r3.n = r4;
        com.bytedance.android.live.revlink.impl.pk.feedview.viewstate.b r12 = this.r;
        r12.o = r8;
        r12.p = r9;
        return;
    L11:
        r1 = null;
        goto L12
    L13:
        com.bytedance.android.live.revlink.impl.pk.feedview.viewstate.b r5 = this.r;
        if (r7 == null) goto L16;
        h3 r6 = r7.getTitleConfig();
    L17:
        r5.i = r6;
        goto L18
    L16:
        r6 = null;
        goto L17
    L5:
        r2 = 0;
        goto L6
    }

    public final void s(List r3, IBattleBarConfig r4, IBaseUser r5) {
        if (this.b != null) goto L5;
        return;
    L5:
        if (r3 != null) goto L7;
        return;
    L7:
        com.bytedance.android.live.revlink.impl.pk.feedview.viewstate.b r0 = this.r;
        r0.j = j(r3, r4, r5);
        this.f.setValue(new com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a(r3, this.r.o, 0));
    }
}
