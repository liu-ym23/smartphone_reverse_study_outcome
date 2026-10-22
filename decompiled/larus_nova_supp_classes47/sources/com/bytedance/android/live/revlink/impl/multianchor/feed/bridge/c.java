package com.bytedance.android.live.revlink.impl.multianchor.feed.bridge;

import android.os.CountDownTimer;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revlink.impl.multianchor.constants.PlayMode;
import com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.FeedMultiPlayMode;
import com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.g;
import com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.h;
import com.bytedance.android.live.revlink.impl.multianchor.pk.team.TeamStatus;
import com.bytedance.android.live.revlink.impl.pk.feedview.machine.t;
import com.bytedance.android.live.revlink.impl.pk.feedview.machine.w;
import com.bytedance.android.live.revlink.impl.pk.feedview.r;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.IBattleUserInfo;
import com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting;
import com.bytedance.android.livesdk.link.model.b8;
import com.bytedance.android.livesdk.link.model.c1;
import com.bytedance.android.livesdk.link.model.c3;
import com.bytedance.android.livesdk.link.model.d1;
import com.bytedance.android.livesdk.link.model.e1;
import com.bytedance.android.livesdk.link.model.f4;
import com.bytedance.android.livesdk.link.model.g5;
import com.bytedance.android.livesdk.link.model.h3;
import com.bytedance.android.livesdk.link.model.j;
import com.bytedance.android.livesdk.link.model.k5;
import com.bytedance.android.livesdk.link.model.m3;
import com.bytedance.android.livesdk.link.model.n3;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.reflect.TypeToken;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements w, t, e, y21.c, com.bytedance.android.live.revlink.impl.multianchor.feed.machine.d {
    public final LinkedList<f4> A;
    public f B;
    public final r C;
    public Map<String, ? extends b8> D;
    public final com.bytedance.android.live.revlink.impl.multianchor.feed.machine.c E;
    public final com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.b F;
    public final FeedMultiBridgePresenter a;
    public final u21.a b;
    public final u21.b c;
    public final u21.c d;
    public boolean e;
    public boolean f;
    public IBaseBattleSetting g;
    public final MutableLiveData<Integer> h;
    public final MutableLiveData<PlayMode> i;
    public final MutableLiveData<Long> j;
    public final MutableLiveData<Long> k;
    public final MutableLiveData<Long> l;
    public final MutableLiveData<com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a> m;
    public final MutableLiveData<Integer> n;
    public final MutableLiveData<String> o;
    public final MutableLiveData<String> p;
    public Disposable q;
    public com.bytedance.android.live.revlink.impl.mergepk.pkbase.b r;
    public Map<String, ? extends IBattleUserInfo> s;
    public IRoom t;
    public boolean u;
    public boolean v;
    public boolean w;
    public CountDownTimer x;
    public d y;
    public final ConcurrentLinkedQueue<f> z;

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001¨\u0006\u0003"}, d2 = {"com/bytedance/android/live/revlink/impl/multianchor/feed/bridge/c$a", "Lcom/google/gson/reflect/TypeToken;", "Lcom/bytedance/android/livesdk/link/model/e1;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class a extends TypeToken<e1> {
        public a() {
        }
    }

    public static final class b extends CountDownTimer {
        public final /* synthetic */ c a;

        @Override // android.os.CountDownTimer
        public final void onFinish() {
            c r0 = this.a;
            r r1 = r0.C;
            if (r1 == null) goto L5;
            r1.b = Boolean.FALSE;
        L5:
            if (r1 == null) goto L7;
            r1.a = null;
        L7:
            r0.v = false;
            r0.z.remove(r0.B);
            this.a.F.d();
            this.a.k();
        }

        @Override // android.os.CountDownTimer
        public final void onTick(long r1) {
            this.a.k();
        }

        public b(long r3, c r5) {
            this.a = r5;
            super(r3, 1000);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.multianchor.feed.bridge.c$c, reason: collision with other inner class name */
    public static final class CountDownTimerC0139c extends CountDownTimer {
        public final /* synthetic */ c a;

        @Override // android.os.CountDownTimer
        public final void onFinish() {
            c r0 = this.a;
            r r1 = r0.C;
            if (r1 == null) goto L5;
            r1.b = Boolean.FALSE;
        L5:
            if (r1 == null) goto L7;
            r1.a = null;
        L7:
            r0.u = false;
            r0.z.remove(r0.B);
            this.a.F.d();
            this.a.k();
        }

        @Override // android.os.CountDownTimer
        public final void onTick(long r1) {
            this.a.k();
        }

        public CountDownTimerC0139c(long r3, c r5) {
            this.a = r5;
            super(r3, 1000);
        }
    }

    public static final class d extends CountDownTimer {
        public final /* synthetic */ c a;

        @Override // android.os.CountDownTimer
        public final void onTick(long r1) {
        }

        @Override // android.os.CountDownTimer
        public final void onFinish() {
            c r0 = this.a;
            r r1 = r0.C;
            if (r1 == null) goto L5;
            r1.d = Boolean.FALSE;
        L5:
            if (r1 == null) goto L7;
            r1.c = null;
        L7:
            r0.w = false;
            if ((!r0.A.isEmpty()) == false) goto L10;
            this.a.A.remove();
        L10:
            this.a.F.d();
            this.a.l();
        }

        public d(c r3, long r4) {
            this.a = r3;
            super(r4, 1000);
        }
    }

    public final void i() {
        CountDownTimer r0 = this.x;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        d r1 = this.y;
        if (r1 == null) goto L8;
        r1.cancel();
    L8:
        this.B = null;
        this.u = false;
        this.v = false;
        ConcurrentLinkedQueue<f> r2 = this.z;
        if (r2 == null) goto L11;
        r2.clear();
    L11:
        this.w = false;
        LinkedList<f4> r3 = this.A;
        if (r3 == null) goto L14;
        r3.clear();
    L14:
        r r4 = this.C;
        if (r4 == null) goto L18;
        Boolean r5 = Boolean.FALSE;
        r4.b = r5;
        r4.a = null;
        r4.c = null;
        r4.d = r5;
        return;
    }

    public final void k() {
        if (this.z.isEmpty() == false) goto L5;
        return;
    L5:
        long r0 = com.bytedance.live.kmp.util.e.b();
        Iterator<f> r2 = this.z.iterator();
    L7:
        if (r2.hasNext() == false) goto L53;
        f r3 = r2.next();
        f4 r4 = r3.b;
        if (r0 > r4.getStartTime()) goto L11;
        long r5 = r4.getStartTime();
    L12:
        long r7 = r4.getEndTime() - r5;
        if (r7 < WebcastRedirectException.UNKNOWN) goto L14;
        if (r0 < r4.getStartTime()) goto L7;
        if (r0 < r4.getStartTime()) goto L7;
        if (r0 > r4.getEndTime()) goto L7;
        if (r3.a == true) goto L25;
        if (this.v == true) goto L7;
        boolean r6 = this.u;
        if (r6 == true) goto L7;
        if (r6 == true) goto L7;
        CountDownTimer r8 = this.x;
        if (r8 == null) goto L45;
        r8.cancel();
    L45:
        this.B = r3;
        CountDownTimerC0139c r9 = new CountDownTimerC0139c(r7, this);
        this.x = r9;
        r9.start();
        this.u = true;
        r r10 = this.C;
        if (r10 == null) goto L48;
        r10.b = Boolean.TRUE;
    L48:
        if (r10 == null) goto L50;
        r10.a = r4;
    L50:
        if (r10 == null) goto L52;
        r10.e = Boolean.FALSE;
    L52:
        this.F.getClass();
        goto L7
    L25:
        if (this.v == true) goto L7;
        CountDownTimer r12 = this.x;
        if (r12 == null) goto L29;
        r12.cancel();
    L29:
        this.B = r3;
        b r13 = new b(r7, this);
        this.x = r13;
        r13.start();
        this.v = true;
        this.u = false;
        r r14 = this.C;
        if (r14 == null) goto L32;
        r14.b = Boolean.TRUE;
    L32:
        if (r14 == null) goto L34;
        r14.a = r4;
    L34:
        if (r14 == null) goto L36;
        r14.e = Boolean.TRUE;
    L36:
        this.F.getClass();
        goto L7
    L14:
        this.z.remove(r3);
        k();
        goto L7
    L11:
        r5 = r0;
        goto L12
    }

    public final void l() {
        if (this.w == false) goto L5;
        return;
    L5:
        f4 r0 = this.A.peek();
        if (r0 != null) goto L8;
        return;
    L8:
        long r1 = com.bytedance.live.kmp.util.e.b();
        if (r1 > r0.getStartTime()) goto L11;
        r1 = r0.getStartTime();
    L11:
        long r3 = r0.getEndTime() - r1;
        if (r3 >= WebcastRedirectException.UNKNOWN) goto L15;
        this.A.remove();
        l();
        return;
    L15:
        r r2 = this.C;
        if (r2 == null) goto L18;
        r2.c = r0;
    L18:
        this.F.getClass();
        d r4 = new d(this, r3);
        this.y = r4;
        r4.start();
        this.w = true;
        r r5 = this.C;
        if (r5 == null) goto L22;
        r5.d = Boolean.TRUE;
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.feed.bridge.e
    public final void a(d1 r6) {
        Intrinsics.checkNotNullParameter(r6, "effectInfo");
        com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.b r0 = this.F;
        if ((r0.c instanceof x21.d.c) == false) goto L13;
        Long r1 = r0.m;
        long r2 = r6.getBattleId();
        if (r1 != null) goto L8;
        return;
    L8:
        if (r1.longValue() == r2) goto L10;
        return;
    L10:
        if (TextUtils.isEmpty(r6.getBattleEffectInfo()) == true) goto L15;
        j(r6.getBattleEffectInfo());
        return;
    L15:
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.feed.bridge.e
    public final void b(g5 r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        if ((((x21.d) this.E.a.b()) instanceof x21.d.c) == false) goto L6;
        this.o.setValue(r2.getTeamTaskJson());
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.feed.bridge.e
    public final void c(k5 r14) {
        Intrinsics.checkNotNullParameter(r14, "message");
        x21.d r0 = (x21.d) this.E.a.b();
        List<? extends af2.b> r1 = r14.getUserScores();
        if (r1 != null) goto L6;
        return;
    L6:
        if ((r0 instanceof x21.d.c) == false) goto L98;
        n3 r2 = r14.getBreakthroughInfo();
        if (r2 == null) goto L10;
        com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.b r3 = this.F;
        r3.k = r2;
        r3.l = r14.getUserScores();
        this.F.c(3);
    L10:
        u21.a r4 = this.b;
        com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.e r5 = this.F.e;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r1, "newScoreList");
        u41.c r6 = u41.c.f;
        r6.getClass();
        if (((Boolean) u41.c.b.getValue(r6, u41.c.a[0])).booleanValue() == false) goto L51;
        HashMap r7 = new HashMap();
        if ((r5 instanceof com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.d) == false) goto L27;
        Map<String, com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.c> r8 = ((com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.d) r5).a;
        if (r8 != null) goto L18;
        r8 = MapsKt.emptyMap();
    L18:
        Iterator<Map.Entry<String, com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.c>> r9 = r8.entrySet().iterator();
    L20:
        if (r9.hasNext() == false) goto L27;
        Map.Entry<String, com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.c> r10 = r9.next();
        String r12 = r10.getKey();
        Integer r13 = r10.getValue().a;
        if (r13 == null) goto L24;
        int r15 = r13.intValue();
    L25:
        r7.put(r12, Integer.valueOf(r15));
        goto L20
    L24:
        r15 = 0;
    L27:
        if ((r5 instanceof h) == false) goto L40;
        Map<String, g> r16 = ((h) r5).b;
        if (r16 != null) goto L31;
        r16 = MapsKt.emptyMap();
    L31:
        Iterator<Map.Entry<String, g>> r17 = r16.entrySet().iterator();
    L33:
        if (r17.hasNext() == false) goto L40;
        Map.Entry<String, g> r18 = r17.next();
        String r19 = r18.getKey();
        Integer r20 = r18.getValue().a;
        if (r20 == null) goto L37;
        int r22 = r20.intValue();
    L38:
        r7.put(r19, Integer.valueOf(r22));
        goto L33
    L37:
        r22 = 0;
    L40:
        if (r7.isEmpty() == true) goto L51;
        Iterator<? extends af2.b> r23 = r1.iterator();
    L44:
        if (r23.hasNext() == false) goto L52;
        af2.b r24 = r23.next();
        String r25 = af2.c.a(r24);
        long r26 = af2.c.b(r24);
        Integer r27 = (Integer) r7.get(r25);
        if (r27 == null) goto L48;
        int r28 = r27.intValue();
    L50:
        if (r26 <= r28) goto L44;
    L48:
        r28 = 0;
        goto L50
    L52:
        boolean r29 = false;
    L53:
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a r30 = null;
        if (r29 == false) goto L84;
        FeedMultiPlayMode r32 = this.F.d;
        if (r32 == null) goto L84;
        int r33 = com.bytedance.android.live.revlink.impl.multianchor.feed.bridge.a.c[r32.ordinal()];
        if (r33 != 1) goto L62;
    L76:
        com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.b r34 = this.F;
        u21.b r35 = this.c;
        com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.e r36 = r34.e;
        r35.getClass();
        Intrinsics.checkNotNullParameter(r1, "newScoreList");
        if ((r36 instanceof com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.d) == true) goto L79;
        r36 = null;
    L79:
        com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.d r37 = (com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.d) r36;
        if (r37 != null) goto L82;
        r37 = null;
    L83:
        r34.e = r37;
        goto L84
    L82:
        r37.a = u21.b.a(r1);
        goto L83
    L62:
        if (r33 == 2) goto L76;
        if (r33 != 3) goto L84;
        com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.b r38 = this.F;
        u21.c r39 = this.d;
        com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.e r40 = r38.e;
        r39.getClass();
        Intrinsics.checkNotNullParameter(r1, "newScoreList");
        if ((r40 instanceof h) == true) goto L68;
        r40 = null;
    L68:
        h r42 = (h) r40;
        if (r42 == null) goto L73;
        Map<String, Long> r43 = r42.a;
        if (r43 == null) goto L73;
        Map<String, g> r44 = r39.c(r43, r1);
        r42.c = r39.b(r43, r1);
        r42.b = r44;
    L75:
        r38.e = r42;
    L73:
        r42 = null;
    L84:
        this.F.d();
        MutableLiveData<com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a> r45 = this.m;
        List r110 = r14.getUserScores();
        if (r110 == null) goto L87;
        r30 = new com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a(r110, null, 0);
    L87:
        r45.setValue(r30);
        return;
    L51:
        r29 = true;
        goto L53
    }

    @Override // y21.c
    public final void d(int r4) {
        x21.d r0 = (x21.d) this.E.a.b();
        if ((r0 instanceof x21.d.a) == false) goto L6;
        this.F.c = r0;
        this.j.setValue(Long.valueOf(r4));
        this.F.d();
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.feed.machine.d
    public final void e(long r4) {
        this.l.setValue(Long.valueOf(r4));
        if (ArraysKt.contains(com.bytedance.android.live.revlink.impl.settings.dynamic.a.H.a(), "interact_timer_count") == false) goto L5;
        return;
    L5:
        this.p.setValue(String.valueOf((System.currentTimeMillis() - r4) / ((long) WebcastRedirectException.UNKNOWN)));
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.feed.machine.d
    public final void f(Map<String, ? extends b8> r1) {
        this.D = r1;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.feedview.machine.t
    public final void g(int r4) {
        x21.d r0 = (x21.d) this.E.a.b();
        if ((r0 instanceof x21.d.b) == false) goto L5;
        com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.b r1 = this.F;
        r1.c = r0;
        r1.g = Integer.valueOf(r4);
        this.F.d();
        this.k.setValue(Long.valueOf(r4));
    L5:
        com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.b r5 = this.F;
        if (r5.d != FeedMultiPlayMode.BREAK_THROUGH) goto L9;
        r5.c(2);
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.feedview.machine.w
    public final void h(int r4) {
        x21.d r0 = (x21.d) this.E.a.b();
        if ((r0 instanceof x21.d.c) == false) goto L5;
        com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.b r1 = this.F;
        r1.c = r0;
        r1.g = Integer.valueOf(r4);
        this.F.d();
        this.k.setValue(Long.valueOf(r4));
    L5:
        com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.b r5 = this.F;
        if (r5.d != FeedMultiPlayMode.BREAK_THROUGH) goto L9;
        r5.c(2);
        return;
    }

    public final void j(String r9) {
        if (this.F.d == FeedMultiPlayMode.TEAM_PK) goto L5;
        return;
    L5:
        e1 r10 = (e1) GsonProtectorUtils.fromJson(GsonHelper.get(), r9, new a().getType());
        IRoom r0 = this.t;
        if (r0 == null) goto L10;
        IBaseUser r1 = r0.getOwner();
        if (r1 == null) goto L10;
        String r2 = iz.a.a(r1);
    L11:
        this.z.clear();
        this.A.clear();
        if (r10 == null) goto L14;
        Map r3 = r10.getAnchorEffectMap();
    L15:
        if (r3 != null) goto L17;
        return;
    L17:
        Map r12 = r10.getAnchorEffectMap();
        Intrinsics.checkNotNull(r12);
        Iterator r13 = r12.entrySet().iterator();
    L19:
        if (r13.hasNext() == false) goto L55;
        Map.Entry r4 = (Map.Entry) r13.next();
        String r5 = (String) r4.getKey();
        j r6 = (j) r4.getValue();
        com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.e r7 = this.F.e;
        if ((r7 instanceof h) == true) goto L23;
        r7 = null;
    L23:
        h r8 = (h) r7;
        if (r8 == null) goto L28;
        Map<String, Long> r14 = r8.a;
        if (r14 == null) goto L28;
        u21.c r15 = this.d;
        String r16 = r5.toString();
        r15.getClass();
        TeamStatus r17 = u21.c.d(r2, r16, r14);
    L30:
        if (r17 == TeamStatus.LEFT) goto L31;
        if (r6 == null) goto L19;
        List r18 = r6.getEffectList();
        if (r18 == null) goto L19;
        Iterator r19 = r18.iterator();
    L51:
        if (r19.hasNext() == false) goto L19;
        f4 r20 = (f4) r19.next();
        if (r20.getEffectType() != 1) goto L51;
        this.A.add(r20);
        goto L51
    L31:
        if (r6 == null) goto L19;
        List r22 = r6.getEffectList();
        if (r22 == null) goto L19;
        if (TextUtils.equals(r5.toString(), r2) == true) goto L36;
        Iterator r23 = r22.iterator();
    L42:
        if (r23.hasNext() == false) goto L19;
        f4 r24 = (f4) r23.next();
        if (r24.getEffectType() != 1) goto L42;
        this.z.add(new f(false, r24));
        goto L42
    L36:
        Iterator r25 = r22.iterator();
    L38:
        if (r25.hasNext() == false) goto L19;
        this.z.add(new f(true, (f4) r25.next()));
    L28:
        r17 = null;
        goto L30
    L55:
        k();
        l();
        return;
    L14:
        r3 = null;
    L10:
        r2 = null;
        goto L11
    }

    public final void m(c3 r7) {
        c1 r0 = r7.getBattleSetting();
        if (r0 == null) goto L5;
        long r3 = r0.getFinished();
    L6:
        m3 r1 = null;
        if (r3 <= 0) goto L13;
        com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.b r2 = this.F;
        c1 r4 = r7.getBattleSetting();
        if (r4 == null) goto L11;
        h3 r5 = r4.getPunishConfig();
    L12:
        r2.i = r5;
    L18:
        com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.b r6 = this.F;
        c1 r8 = r7.getBattleSetting();
        if (r8 == null) goto L23;
        IBattleConfigSetting r9 = r8.getBattleConfigSetting();
        if (r9 == null) goto L23;
        r1 = r9.getBreakthroughConfig();
    L23:
        r6.j = r1;
        this.F.k = r7.getBreakthroughInfo();
        this.F.l = r7.getBattleScorePairList();
        return;
    L11:
        r5 = null;
        goto L12
    L13:
        com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.b r10 = this.F;
        c1 r12 = r7.getBattleSetting();
        if (r12 == null) goto L16;
        h3 r13 = r12.getTitleConfig();
    L17:
        r10.i = r13;
        goto L18
    L16:
        r13 = null;
        goto L17
    L5:
        r3 = 0;
        goto L6
    }

    public c(z21.a r2, com.bytedance.android.live.revlink.impl.multianchor.feed.machine.c r3, com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.b r4) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        Intrinsics.checkNotNullParameter(r3, "machine");
        Intrinsics.checkNotNullParameter(r4, "viewState");
        this.E = r3;
        this.F = r4;
        this.a = new FeedMultiBridgePresenter(r2);
        this.b = new u21.a(r2);
        this.c = new u21.b();
        this.d = new u21.c(r2);
        this.h = new MutableLiveData();
        this.i = new MutableLiveData();
        this.j = new MutableLiveData();
        this.k = new MutableLiveData();
        this.l = new MutableLiveData();
        this.m = new MutableLiveData();
        this.n = new MutableLiveData();
        this.o = new MutableLiveData();
        this.p = new MutableLiveData();
        this.z = new ConcurrentLinkedQueue();
        this.A = new LinkedList();
        this.C = new r(null, null, null);
    }
}
