package com.bytedance.android.live.revlink.impl.multianchor.match;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revenue.common.v;
import com.bytedance.android.live.revlink.impl.multianchor.utils.x;
import com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService;
import com.bytedance.android.live.revlink.impl.pk.utils.AutoMatchSource;
import com.bytedance.android.live.revlink.impl.pk.vm.linkout.p;
import com.bytedance.android.live.revlink.impl.utils.a0;
import com.bytedance.android.live.revlink.impl.utils.r;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livesdk.link.model.BattleNotifyMessageType;
import com.bytedance.android.livesdk.link.model.RandomMatchStrategy;
import com.bytedance.android.livesdk.link.model.b0;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.link.model.bridge.i1;
import com.bytedance.android.livesdk.link.model.bridge.t;
import com.bytedance.android.livesdk.link.model.bridge.u;
import com.bytedance.android.livesdk.link.model.g0;
import com.bytedance.android.livesdk.link.model.h0;
import com.bytedance.android.livesdk.link.model.i6;
import com.bytedance.android.livesdk.link.model.j8;
import com.bytedance.android.livesdk.link.model.k8;
import com.bytedance.android.livesdk.link.model.o1;
import com.bytedance.android.livesdk.link.model.o9;
import com.bytedance.android.livesdk.link.model.p0;
import com.bytedance.android.livesdk.link.model.p1;
import com.bytedance.android.livesdk.link.model.q6;
import com.bytedance.android.livesdk.link.model.r4;
import com.bytedance.android.livesdk.link.model.s0;
import com.bytedance.android.livesdk.link.model.w1;
import com.bytedance.android.livesdk.link.model.z1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.badger.collect.impl.constants.Constants;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.ExceptionsKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g {
    public final IRoom a;
    public final CompositeDisposable b;
    public Disposable c;
    public Disposable d;
    public Disposable e;
    public final ArrayList<b> f;
    public long g;
    public long h;
    public boolean i;
    public final MultiPkMatchContext j;
    public final com.bytedance.android.livesdk.revenue.service.room.c k;
    public final com.bytedance.android.live.revlink.impl.global.c l;
    public final yz0.f m;
    public final x11.a n;

    public static final class a {
    }

    public interface b {
        void Ag(w1 r1);

        void Dc(af2.e r1, int r2, List<String> r3);

        void Eb();

        void Q9(r4 r1, boolean r2);

        void no(w1 r1);

        void r4(long r1, long r3, h0 r5);

        void rh(boolean r1);

        void z1(int r1, int r2);
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r2) {
            ExtraResponse r3 = (ExtraResponse) r2;
            Intrinsics.checkNotNullParameter(r3, "latestBanRecordResponse");
            int r0 = r.a;
            int r1 = w11.a.a;
            r.a(r3);
        }
    }

    public static final class d<T> implements Consumer {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void accept(Object r4) {
            jy0.b.c("ttlive_anchor_link_match", ((Throwable) r4).toString(), null, 4);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ g a;

        public e(g r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Long r5 = (Long) r4;
            jy0.b.c("ttlive_anchor_link_match", "max waiting time out, isMatching=" + this.a.l(), null, 4);
            if ((this.a.h() instanceof com.bytedance.android.live.revlink.impl.multianchor.match.c.e) == false) goto L6;
            this.a.e();
        L6:
            if (this.a.l() == false) goto L14;
            Iterator<b> r6 = this.a.f.iterator();
        L9:
            if (r6.hasNext() == false) goto L11;
            r6.next().rh(true);
            goto L9
        L11:
            g.p(this.a, 2, "timeout");
            return;
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ g a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ b0 e;
        public final /* synthetic */ boolean f;
        public final /* synthetic */ int g;
        public final /* synthetic */ Function1 h;

        public f(g r1, boolean r2, int r3, int r4, b0 r5, boolean r6, int r7, Function1 r8) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
        }

        public final void accept(Object r26) {
            ExtraResponse r1 = (ExtraResponse) r26;
            af2.e r2 = (r4) r1.data;
            g r3 = this.a;
            r3.j.getBattleAttachedInfo().setValue(r2.getBattleAttachedInfo());
            long r8 = 0;
            if (this.b == false) goto L44;
            jy0.b.d("ttlive_anchor_link_match", "onFirstMatching ".concat(ef2.a.c(r2)));
            k21.a r4 = this.a.i();
            if (r4 == null) goto L7;
            int r12 = this.c;
            int r13 = k21.a.e;
            LinkedHashMap r14 = new LinkedHashMap();
            r14.put("match_type", Integer.valueOf(r12));
            r4.f(r14);
            r4.n("start_multi_random_match", r14);
        L7:
            com.bytedance.android.live.revlink.impl.global.c r5 = this.a.l;
            if (r5 == null) goto L10;
            d31.f r6 = r5.y2();
        L11:
            if (r6 == null) goto L14;
            r6.e("linkmic/battle/auto_match/", new d31.a(this.c, 0, 0, 0, null, !this.b ? 1 : 0, this.d, null, null, null, null, 3998), 0);
        L14:
            if (this.e == null) goto L36;
            r4 r7 = (r4) r1.data;
            if (r7 == null) goto L18;
            Long r9 = Long.valueOf(r7.getExpectTime());
        L19:
            Long r10 = Long.valueOf(r9.longValue());
            if (r10.longValue() <= 0) goto L22;
            boolean r15 = true;
        L23:
            if (r15 == true) goto L26;
            r10 = null;
        L26:
            if (r10 == null) goto L28;
            long r16 = r10.longValue();
        L29:
            b0 r17 = (b0) this.a.j.getSelfAutoMatchInfo().getValue();
            if (r17 == null) goto L33;
            r17.setWaitSec(r16);
        L33:
            if (this.f == false) goto L35;
            this.a.d(this.e.getWaitSec() + this.e.getAccelerateLimit(), "startMatchSpeedUpOpt");
            goto L36
        L35:
            this.a.d(this.e.getWaitSec() + this.e.getDefaultWaitLimit(), "startMatchOpt");
            goto L36
        L28:
            r16 = 20;
            goto L29
        L22:
            r15 = false;
            goto L23
        L18:
            r9 = null;
        L36:
            g r18 = this.a;
            if (this.f == true) goto L39;
            com.bytedance.android.live.revlink.impl.multianchor.match.c r19 = new com.bytedance.android.live.revlink.impl.multianchor.match.c.a(this.c, this.g);
        L40:
            r18.o(r19);
            g r20 = this.a;
            i97.a r22 = i97.a.a;
            r20.g = System.currentTimeMillis();
            if (r2.getMatchStrategy() != RandomMatchStrategy.Normal.ordinal()) goto L44;
            g r23 = this.a;
            String r24 = r2.getBattleAttachedInfo();
            r23.getClass();
            g.n(false, r24, false);
            goto L44
        L39:
            i97.a r25 = i97.a.a;
            r18.h = System.currentTimeMillis();
            r19 = new com.bytedance.android.live.revlink.impl.multianchor.match.c.b(this.c, this.g);
            goto L40
        L10:
            r6 = null;
        L44:
            if (r2.getRivalRoom() != null) goto L49;
            jy0.b.d("ttlive_anchor_link_match", "onMatching timeLeft=" + ((Number) this.a.j.getCountDownTime().getValue()).longValue());
            Iterator<b> r27 = this.a.f.iterator();
        L47:
            if (r27.hasNext() == false) goto L119;
            r27.next().Q9(r2, this.b);
        L119:
            Function1 r28 = this.h;
            if (r28 == null) goto L136;
            Unit r29 = (Unit) r28.invoke(new p(r2.getBattleAttachedInfo(), RandomMatchStrategy.Normal.ordinal(), false));
            return;
        L136:
            return;
        L49:
            Disposable r30 = this.a.c;
            if (r30 == null) goto L52;
            r30.dispose();
        L52:
            Disposable r32 = this.a.d;
            if (r32 == null) goto L55;
            r32.dispose();
        L55:
            jy0.b.c("ttlive_anchor_link_match", "onMatchSuccess ".concat(ef2.a.c(r2)), null, 4);
            com.bytedance.android.livesdk.link.model.a r33 = r1.extra;
            if (r33 == null) goto L67;
            g0 r34 = r33.a();
            if (r34 == null) goto L67;
            String r35 = r34.getImprId();
            if (r35 == null) goto L67;
            com.bytedance.android.live.revlink.impl.global.c r36 = this.a.l;
            if (r36 == null) goto L64;
            com.bytedance.android.live.revlink.impl.control.d r37 = r36.Rc();
        L65:
            if (r37 == null) goto L67;
            r37.setRequestId(r35);
            goto L67
        L64:
            r37 = null;
        L67:
            k21.a r38 = this.a.i();
            if (r38 == null) goto L81;
            int r39 = this.c;
            long r110 = this.a.g;
            int r40 = k21.a.e;
            Intrinsics.checkNotNullParameter(r2, "matchModel");
            LinkedHashMap r42 = new LinkedHashMap();
            r42.put("match_type", Integer.valueOf(r39));
            r42.put("rival_user_id", String.valueOf(r2.getRivalUserId()));
            IRoomBase r43 = r2.getRivalRoom();
            if (r43 == null) goto L72;
            Object r44 = Long.valueOf(IRoomKtKt.getId(r43));
        L73:
            r42.put("rival_room_id", r44);
            Intrinsics.checkNotNullParameter(r2, "$this$rivalsEx");
            List r45 = r2.getRivals();
            if (r45 == null) goto L76;
            int r46 = r45.size();
        L77:
            r42.put("rival_user_size", Integer.valueOf(r46));
            r42.put("trigger_source", "api");
            if (r110 <= 0) goto L80;
            i97.a r47 = i97.a.a;
            r8 = System.currentTimeMillis() - r110;
        L80:
            r42.put(Constants.Keys.duration, Long.valueOf(r8));
            r38.f(r42);
            r38.b(r42);
            int r48 = v.a;
            v.e("ttlive_anchor_link_match", "multi_random_match_success: " + r42);
            r38.n("multi_random_match_success", r42);
            goto L81
        L76:
            r46 = 0;
            goto L77
        L72:
            r44 = "";
        L81:
            com.bytedance.android.live.revlink.impl.multianchor.match.f r49 = this.a.j();
            if (r49 == null) goto L84;
            com.bytedance.android.live.revlink.impl.multianchor.match.f.f(r49, this.c, "inviter", this.a.h().c, false, false, e21.c.c(p0.Companion, this.a.g()), 24);
        L84:
            Iterator<b> r50 = this.a.f.iterator();
        L86:
            if (r50.hasNext() == false) goto L118;
            b r52 = r50.next();
            int r53 = this.a.h().b;
            Intrinsics.checkNotNullParameter(r2, "$this$getInviteeUserIdStr");
            List r54 = r2.getRivals();
            if (r54 == null) goto L90;
            List r55 = CollectionsKt.toList(r54);
        L91:
            List r56 = r55;
            if (r56 != null) goto L94;
        L97:
            boolean r57 = true;
        L98:
            if (r57 == true) goto L116;
            List r58 = r2.getRivals();
            if (r58 == null) goto L116;
            List r59 = CollectionsKt.toList(r58);
            if (r59 == null) goto L116;
            ArrayList r60 = new ArrayList();
            Iterator<T> r62 = r59.iterator();
        L106:
            if (r62.hasNext() == false) goto L110;
            String r63 = ((r4.b) r62.next()).getUserId();
            if (r63 == null) goto L106;
            r60.add(r63);
            goto L106
        L110:
            ArrayList r64 = new ArrayList();
            Iterator r65 = r60.iterator();
        L112:
            if (r65.hasNext() == false) goto L117;
            Object r66 = r65.next();
            if ((!Intrinsics.areEqual(r2.getRivalUserId(), (String) r66)) == false) goto L112;
            r64.add(r66);
        L117:
            r52.Dc(r2, r53, r64);
        L116:
            r64 = null;
            goto L117
        L94:
            if (r56.isEmpty() == true) goto L97;
            r57 = false;
            goto L98
        L90:
            r55 = null;
            goto L91
        L118:
            g.p(this.a, 1, "matchSuccess");
            goto L119
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.multianchor.match.g$g, reason: collision with other inner class name */
    public static final class C0147g<T> implements Consumer {
        public final /* synthetic */ g a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ Function1 e;

        public C0147g(g r1, boolean r2, int r3, int r4, Function1 r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public final void accept(Object r23) {
            Throwable r7 = (Throwable) r23;
            jy0.b.c("ttlive_anchor_link_match", "autoMatch failed: " + r7, null, 4);
            if (this.b == false) goto L7;
            k21.a r1 = this.a.i();
            if (r1 == null) goto L7;
            int r2 = this.c;
            LinkedHashMap r3 = new LinkedHashMap();
            r3.put("match_type", Integer.valueOf(r2));
            r1.f(r3);
            r1.n("start_multi_random_match", r3);
        L7:
            com.bytedance.android.live.revlink.impl.global.c r4 = this.a.l;
            if (r4 == null) goto L10;
            d31.f r5 = r4.y2();
        L11:
            if (r5 == null) goto L13;
            r5.c("linkmic/battle/auto_match/", new d31.a(this.c, 0, 0, 0, null, !this.b ? 1 : 0, this.d, null, null, null, null, 3998), r7, 0);
        L13:
            k21.a r6 = this.a.i();
            if (r6 == null) goto L16;
            r6.o(this.c, r7);
        L16:
            this.a.b(r7);
            Function1 r8 = this.e;
            if (r8 == null) goto L20;
            Unit r9 = (Unit) r8.invoke(null);
            return;
        L20:
            return;
        L10:
            r5 = null;
            goto L11
        }
    }

    static {
    }

    public final String g() {
        String r0 = (String) this.j.getBattleAttachedInfo().getValue();
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public final com.bytedance.android.live.revlink.impl.multianchor.match.c h() {
        return (com.bytedance.android.live.revlink.impl.multianchor.match.c) this.j.getMatchStatus().getValue();
    }

    public final k21.a i() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.l;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.P7();
    }

    public final com.bytedance.android.live.revlink.impl.multianchor.match.f j() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.l;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.F8();
    }

    public final Pair<List<o>, Boolean> k() {
        ArrayList r0 = new ArrayList();
        com.bytedance.android.live.revlink.impl.global.c r1 = this.l;
        Long r2 = null;
        if (r1 == null) goto L5;
        a0 r3 = r1.fl();
    L6:
        boolean r4 = false;
        if (r3 == null) goto L17;
        x11.a r5 = r3.a;
        if (r5 == null) goto L13;
        y11.g r6 = r5.Dn();
        if (r6 == null) goto L13;
        int r7 = r6.a();
    L15:
        if (com.bytedance.android.live.utils.c.a(r7, 4) != true) goto L17;
        char r8 = 1;
    L18:
        if (r8 != 1) goto L54;
        x11.a r9 = this.n;
        if (r9 == null) goto L22;
        y11.d r10 = r9.getPkService();
    L23:
        if (r10 == null) goto L28;
        IBaseUser r12 = r10.c();
        if (r12 == null) goto L28;
        String r13 = r12.getIdString();
        if (r13 == null) goto L28;
    L35:
        if (r10 == null) goto L39;
        IRoomBase r14 = r10.b();
        if (r14 == null) goto L39;
        r2 = Long.valueOf(IRoomKtKt.getId(r14));
    L49:
        o r15 = new o(r13, r2);
        if (r13 == null) goto L53;
        if (r2 == null) goto L53;
        r4 = true;
    L53:
        r0.add(r15);
    L99:
        return new Pair(r0, Boolean.valueOf(r4));
    L39:
        com.bytedance.android.live.revlink.impl.global.c r16 = this.l;
        if (r16 == null) goto L42;
        IPKLinkBizDataService r17 = r16.mk();
    L43:
        if (r17 == null) goto L49;
        IPKLinkBizDataService.c r18 = r17.getGuestInfo();
        if (r18 == null) goto L49;
        IBaseUser r19 = r18.c;
        if (r19 == null) goto L49;
        r2 = Long.valueOf(com.bytedance.android.live.base.model.user.n.a(r19));
        goto L49
    L42:
        r17 = null;
    L28:
        com.bytedance.android.live.revlink.impl.global.c r20 = this.l;
        if (r20 == null) goto L31;
        w31.c r22 = r20.getPkLinkUtils();
    L32:
        if (r22 == null) goto L34;
        r13 = r22.c();
        goto L35
    L34:
        r13 = null;
        goto L35
    L31:
        r22 = null;
        goto L32
    L22:
        r10 = null;
        goto L23
    L54:
        cy0.e.a.getClass();
        cy0.j r23 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r24 = com.bytedance.android.scope.m.b(r23).b(com.bytedance.android.livesdk.revenue.service.user.a.class);
        Intrinsics.checkNotNull(r24);
        IBaseUser r25 = ((com.bytedance.live.kmp.core.c) r24).b();
        if (r25 == null) goto L58;
        String r26 = r25.getIdString();
        if (r26 == null) goto L58;
    L59:
        x11.a r27 = this.n;
        if (r27 == null) goto L62;
        y11.b r28 = r27.mo1159do();
    L63:
        if (r28 == null) goto L83;
        List<com.bytedance.android.livesdk.link.model.bridge.k> r29 = r28.d();
        if (r29 == null) goto L83;
        List<com.bytedance.android.livesdk.link.model.bridge.k> r30 = r29;
        ArrayList r32 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r30, 10));
        Iterator<T> r33 = r30.iterator();
    L68:
        if (r33.hasNext() == false) goto L70;
        r32.add(((com.bytedance.android.livesdk.link.model.bridge.k) r33.next()).castTo(com.bytedance.android.livesdk.link.model.p.class));
        goto L68
    L70:
        Iterator r34 = r32.iterator();
    L72:
        if (r34.hasNext() == false) goto L81;
        Object r35 = r34.next();
        com.bytedance.android.livesdk.link.model.p r36 = (com.bytedance.android.livesdk.link.model.p) r35;
        if (r36.getUser() == null) goto L78;
        IBaseUser r37 = r36.getUser();
        Intrinsics.checkNotNull(r37);
        if ((!Intrinsics.areEqual(r37.getIdString(), r26)) == false) goto L78;
        boolean r38 = true;
    L79:
        if (r38 == false) goto L72;
    L82:
        com.bytedance.android.livesdk.link.model.p r39 = (com.bytedance.android.livesdk.link.model.p) r35;
    L84:
        if (r39 == null) goto L88;
        IBaseUser r40 = r39.getUser();
        if (r40 == null) goto L88;
        String r42 = r40.getIdString();
    L89:
        if (r39 == null) goto L93;
        IBaseUser r43 = r39.getUser();
        if (r43 == null) goto L93;
        r2 = Long.valueOf(com.bytedance.android.live.base.model.user.n.a(r43));
    L93:
        o r44 = new o(r42, r2);
        if (r42 == null) goto L97;
        if (r2 == null) goto L97;
        r4 = true;
    L97:
        r0.add(r44);
    L88:
        r42 = null;
    L78:
        r38 = false;
        goto L79
    L81:
        r35 = null;
    L83:
        r39 = null;
        goto L84
    L62:
        r28 = null;
    L58:
        r26 = "";
    L13:
        r7 = 0;
    L17:
        r8 = 7;
        goto L18
    L5:
        r3 = null;
        goto L6
    }

    public final void e() {
        if ((h() instanceof com.bytedance.android.live.revlink.impl.multianchor.match.c.e) == true) goto L5;
        return;
    L5:
        Disposable r0 = this.d;
        if (r0 == null) goto L8;
        r0.dispose();
    L8:
        o(new com.bytedance.android.live.revlink.impl.multianchor.match.c.C0146c());
        Iterator<T> r1 = this.f.iterator();
    L10:
        if (r1.hasNext() == false) goto L12;
        ((b) r1.next()).Eb();
        goto L10
    }

    public final boolean l() {
        return h().a;
    }

    public static void m(z1 r8) {
        boolean r4 = false;
        if (r8.getType() != BattleNotifyMessageType.LargeMatchStart.ordinal()) goto L5;
        boolean r0 = true;
    L6:
        String r1 = r8.getBattleAttachedInfoStr();
        if (r8.getType() != BattleNotifyMessageType.LargeMatchEnd.ordinal()) goto L9;
        r4 = true;
    L9:
        n(r0, r1, r4);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void b(Throwable r5) {
        o(new com.bytedance.android.live.revlink.impl.multianchor.match.c.C0146c());
        Disposable r0 = this.c;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        Disposable r1 = this.d;
        if (r1 == null) goto L9;
        r1.dispose();
    L9:
        if ((r5 instanceof ApiServerException) == false) goto L38;
        ApiServerException r6 = (ApiServerException) r5;
        int r2 = r6.getErrorCode();
        if (r2 != 31012) goto L27;
        com.bytedance.android.live.revlink.impl.global.c r7 = this.l;
        if (r7 == null) goto L15;
        r31.a r8 = r7.getLinkNetwork();
    L16:
        if (r8 == null) goto L40;
        Observable<ExtraResponse<bf2.a, Extra>> r9 = r8.getLatestBanRecord(14);
        if (r9 == null) goto L40;
        int r3 = com.bytedance.revenue.platform.api.core.rx.p.a;
        Observable r10 = r9.subscribeOn(Schedulers.io());
        if (r10 == null) goto L40;
        Observable r12 = r10.observeOn(AndroidSchedulers.mainThread());
        if (r12 == null) goto L40;
        Disposable r13 = r12.subscribe(c.a, d.a);
        if (r13 == null) goto L40;
        c(r13);
    L40:
        Iterator<b> r14 = this.f.iterator();
    L42:
        if (r14.hasNext() == false) goto L44;
        r14.next().rh(false);
        goto L42
    L44:
        p(this, 2, "matchError");
        return;
    L15:
        r8 = null;
        goto L16
    L27:
        if (r2 != 4004045) goto L29;
        int r4 = ToastUtil.a;
        ToastUtil.b(r6.getPrompt(), 0);
        goto L40
    L29:
        String r15 = r6.getPrompt();
        if (r15 == null) goto L40;
        if (r15.length() <= 0) goto L34;
        boolean r16 = true;
    L35:
        if (r16 != true) goto L40;
        int r17 = ToastUtil.a;
        ToastUtil.b(r6.getPrompt(), 0);
        goto L40
    L34:
        r16 = false;
        goto L35
    L38:
        if ((r5 instanceof IllegalArgumentException) == false) goto L40;
        int r18 = ToastUtil.a;
        com.bytedance.live.kmp.util.c r19 = com.bytedance.live.kmp.util.c.a;
        int r20 = w11.a.a;
        ToastUtil.b(com.bytedance.live.kmp.util.c.a(2131919367, new Object[0]), 0);
        goto L40
    }

    public final void c(Disposable r2) {
        this.b.add(r2);
    }

    public final void o(com.bytedance.android.live.revlink.impl.multianchor.match.c r5) {
        Intrinsics.checkNotNullParameter(r5, "value");
        if (Intrinsics.areEqual(h(), r5) == false) goto L6;
        return;
    L6:
        if (r5.a == true) goto L9;
        this.g = 0;
    L9:
        if (r5.c == true) goto L11;
        this.h = 0;
    L11:
        jy0.b.f("ttlive_anchor_link_match", "matchStatus change from " + h() + " to " + r5 + ' ' + ExceptionsKt.stackTraceToString(new Error()), null, 4);
        this.j.getLastMatchStatus().setValue(h());
        this.j.getMatchStatus().setValue(r5);
    }

    public static final void a(g r20, yh6.c r22) {
        r20.getClass();
        boolean r3 = false;
        if ((r22 instanceof h1) == false) goto L14;
        i6 r0 = ((vh7.c) r22).castTo(i6.class);
        if (((int) i1.c(r0)) != 31) goto L217;
        q6 r1 = r0.getSwitchSceneContent();
        if (r1 == null) goto L203;
        o9 r2 = r1.getSwitchSceneData();
        if (r2 != null) goto L12;
        return;
    L12:
        if (r2.getToScene() != 1) goto L205;
        p(r20, 0, "switch_to_pk");
        return;
    L205:
        return;
    L203:
        return;
    L217:
        return;
    L14:
        String r5 = "";
        Object r8 = null;
        if ((r22 instanceof com.bytedance.android.livesdk.link.model.bridge.n) == false) goto L71;
        af2.e r4 = ((vh7.c) r22).castTo(s0.class).getData();
        if (r4 != null) goto L20;
        return;
    L20:
        if (r20.h().a == true) goto L22;
        return;
    L22:
        if (x.b((int) r4.getMatchType()) == true) goto L25;
        return;
    L25:
        if (r41.b.a == false) goto L28;
        return;
    L28:
        if (r4.getRivalRoom() == null) goto L208;
        Disposable r6 = r20.c;
        if (r6 == null) goto L32;
        r6.dispose();
    L32:
        Disposable r7 = r20.d;
        if (r7 == null) goto L35;
        r7.dispose();
    L35:
        jy0.b.c("ttlive_anchor_link_match", "on matchsuccess" + r4.toString(), null, 4);
        if (r4.getRivalUserId() == null) goto L221;
        String r9 = r4.getRivalUserId();
        if (r9 == null) goto L42;
        r5 = r9;
    L42:
        ArrayList r10 = new ArrayList();
        r10.add(r5);
        Iterator<b> r12 = r20.f.iterator();
    L44:
        if (r12.hasNext() == false) goto L47;
        r12.next().Dc(r4, (int) r4.getMatchType(), r10);
        goto L44
    L47:
        if (r4.getBattleAttachedInfo().length() != 0) goto L49;
        r3 = true;
    L49:
        if (r3 == false) goto L190;
        p0 r13 = e21.c.c(p0.Companion, r20.g());
    L51:
        p0 r14 = r13;
        com.bytedance.android.live.revlink.impl.multianchor.match.f r15 = r20.j();
        if (r15 == null) goto L209;
        com.bytedance.android.live.revlink.impl.multianchor.match.f.f(r15, (int) r4.getMatchType(), "inviter", false, true, false, r14, 16);
        return;
    L209:
        return;
    L190:
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L58
        String r17 = r4.getBattleAttachedInfo();     // Catch: Throwable -> L58
        if (r17 == null) goto L55;
        p0 r18 = (p0) l97.a.a.fromJson(r17, TypesJVMKt.getJavaType(Reflection.typeOf(p0.class)));     // Catch: Throwable -> L58
    L56:
        Object r19 = Result.constructor-impl(r18);     // Catch: Throwable -> L58
    L61:
        if (Result.isFailure-impl(r19) == true) goto L64;
        r8 = r19;
    L64:
        r13 = (p0) r8;
        if (r13 != null) goto L51;
        r13 = (p0) vh7.f.c(p0.class);
        goto L51
    L55:
        r18 = null;
    L58:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r19 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L61
    L221:
        return;
    L208:
        return;
    L71:
        if ((r22 instanceof t) == false) goto L129;
        w1 r24 = ((vh7.c) r22).castTo(w1.class);
        jy0.b.f("ttlive_anchor_link_match", "receive " + ef2.a.c(r24) + ", current=" + r20.h(), null, 4);
        if (r41.b.a == false) goto L76;
        return;
    L76:
        if (r24.getMatchStatus() == 0) goto L115;
        Disposable r25 = r20.e;
        if (r25 == null) goto L80;
        r25.dispose();
    L80:
        com.bytedance.android.live.revlink.impl.multianchor.match.c r26 = r20.h();
        r26.getClass();
        if ((r26 instanceof com.bytedance.android.live.revlink.impl.multianchor.match.c.C0146c) == true) goto L223;
        r20.j.getPassiveAutoMatchInfo().setValue(null);
        if (r24.getMatchStatus() != 1) goto L90;
        if (x.d((int) r24.getMatchType()) == false) goto L88;
        int r27 = ToastUtil.a;
        int r28 = w11.a.a;
        ToastUtil.a(2131920640, 0);
    L98:
        if (r24.getMatchStatus() != 2) goto L102;
        com.bytedance.android.live.revlink.impl.multianchor.match.f r110 = r20.j();
        if (r110 == null) goto L102;
        com.bytedance.android.live.revlink.impl.multianchor.match.f.f(r110, (int) r24.getMatchType(), "inviter", true, true, false, null, 16);
    L102:
        com.bytedance.android.live.revlink.impl.multianchor.match.c r29 = r20.h();
        if (r29.a == true) goto L105;
    L107:
        if (r3 == false) goto L109;
        p(r20, 1, "othersCancelMatch");
    L110:
        Iterator<b> r30 = r20.f.iterator();
    L112:
        if (r30.hasNext() == false) goto L226;
        r30.next().no(r24);
        goto L112
    L226:
        return;
    L109:
        r20.o(new com.bytedance.android.live.revlink.impl.multianchor.match.c.C0146c());
        goto L110
    L105:
        if (r29.d == true) goto L107;
        r3 = true;
        goto L107
    L88:
        int r32 = ToastUtil.a;
        int r33 = w11.a.a;
        ToastUtil.a(2131920603, 0);
        goto L98
    L90:
        if (r24.getMatchStatus() != 3) goto L98;
        int r34 = ToastUtil.a;
        int r35 = w11.a.a;
        ToastUtil.a(2131921528, 1);
        com.bytedance.android.live.revlink.impl.multianchor.match.f r36 = r20.j();
        if (r36 == null) goto L94;
        r36.g(r20.h().b, r20.h().c);
    L94:
        com.bytedance.android.live.revlink.impl.multianchor.match.f r37 = r20.j();
        if (r37 == null) goto L98;
        r37.h(r20.h().b, AutoMatchSource.NoneOfMyBusiness);
        goto L98
    L223:
        return;
    L115:
        if (x.d((int) r24.getMatchType()) == false) goto L118;
        int r38 = ToastUtil.a;
        int r39 = w11.a.a;
        ToastUtil.a(2131920641, 0);
    L120:
        j8 r40 = vh7.f.c(j8.class);
        r40.setWaitSec(r24.getExpectTime());
        r40.setDefaultWaitLimit(r24.getDefaultWaitLimit());
        k8 r42 = vh7.f.c(k8.class);
        r42.setInviteLimitSec(r24.getInviteLimitSec());
        Unit r43 = Unit.INSTANCE;
        r40.setConfig(r42);
        r20.j.getPassiveAutoMatchInfo().setValue(r40);
        r20.o(new com.bytedance.android.live.revlink.impl.multianchor.match.c.d((int) r24.getMatchType()));
        i97.a r44 = i97.a.a;
        r20.g = System.currentTimeMillis();
        Iterator<b> r45 = r20.f.iterator();
    L122:
        if (r45.hasNext() == false) goto L124;
        r45.next().Ag(r24);
        goto L122
    L124:
        long r46 = r40.getWaitSec() + r40.getDefaultWaitLimit();
        Disposable r47 = r20.e;
        if (r47 == null) goto L127;
        r47.dispose();
    L127:
        long r48 = (r46 + 1) * ((long) WebcastRedirectException.UNKNOWN);
        com.bytedance.revenue.platform.api.core.rx.l r49 = com.bytedance.revenue.platform.api.core.rx.l.a;
        int r50 = com.bytedance.revenue.platform.api.core.rx.p.a;
        r20.e = Observable.timer(r48, TimeUnit.MILLISECONDS, Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new h(r20, r24));
        return;
    L118:
        if (((int) r24.getMatchType()) == 11) goto L120;
        int r52 = ToastUtil.a;
        int r53 = w11.a.a;
        ToastUtil.a(2131920607, 0);
        goto L120
    L129:
        if ((r22 instanceof u) == true) goto L131;
        return;
    L131:
        if (r41.b.a == true) goto L224;
        z1 r54 = ((vh7.c) r22).castToOrNull(z1.class);
        if (r54 == null) goto L213;
        Intrinsics.checkNotNullParameter(r54, "$this$isMultiMsg");
        o1 r55 = e21.d.a(r54);
        if (r55 == null) goto L138;
        boolean r56 = CollectionsKt.listOf(new Integer[]{4, 6, 9, 10, 11}).contains(Integer.valueOf((int) r55.getMatchType()));
    L139:
        if (r56 == false) goto L225;
        long r57 = r54.getType();
        if (r57 != BattleNotifyMessageType.LargeMatchStart.ordinal()) goto L187;
        r20.i = true;
        m(r54);
        o1 r58 = e21.d.a(r54);
        if (r58 == null) goto L214;
        List r59 = r58.getInviteUsers();
        if (r59 == null) goto L215;
        ArrayList r60 = new ArrayList();
        Iterator r62 = r59.iterator();
    L149:
        if (r62.hasNext() == false) goto L168;
        Object r63 = r62.next();
        p1 r64 = (p1) r63;
        if (r64 != null) goto L153;
    L165:
        boolean r65 = false;
    L166:
        if (r65 == false) goto L149;
        r60.add(r63);
        goto L149
    L153:
        if (r64.getUserID() == null) goto L165;
        if (r64.getRoomID() == null) goto L165;
        Long r66 = r64.getUserID();
        if (r66 != null) goto L159;
    L160:
        Long r67 = r64.getRoomID();
        if (r67 != null) goto L163;
    L164:
        r65 = true;
        goto L166
    L163:
        if (r67.longValue() == 0) goto L165;
    L159:
        if (r66.longValue() == 0) goto L165;
    L168:
        Iterator r68 = r60.iterator();
    L170:
        if (r68.hasNext() == false) goto L227;
        p1 r69 = (p1) r68.next();
        mz0.n r70 = new mz0.n();
        mz0.o r72 = new mz0.o(r70.a);
        r72.a("invite_type", "anchor");
        r72.a("source", "pk_banner");
        r72.a("connection_type", "random_link");
        r72.a("anchor_connection_type", "invite");
        r72.a("if_strategy_invite", DataType.TRUE);
        r72.a("invited_mode", "routine_pk");
        r72.a("is_oncemore", DataType.FALSE);
        r72.a("anchor_connect_status", DataType.FALSE);
        r72.a("audience_connect_cnt", String.valueOf(n41.a.b()));
        r72.a("is_random_match", DataType.TRUE);
        r72.a("is_random_link_match", DataType.FALSE);
        if (r69 == null) goto L177;
        Long r73 = r69.getRoomID();
        if (r73 == null) goto L177;
        String r74 = String.valueOf(r73.longValue());
        if (r74 == null) goto L177;
    L178:
        r72.a("invitee_room_id", r74);
        r72.a("list_num", DataType.FALSE);
        if (r69 == null) goto L184;
        Long r75 = r69.getUserID();
        if (r75 == null) goto L184;
        String r76 = String.valueOf(r75.longValue());
        if (r76 == null) goto L184;
    L185:
        r72.a("invitee_id", r76);
        r72.a("invitee_list", "strategy_invite");
        r72.a("invitee_room_status", "live");
        r72.a("invitee_connect_cnt", DataType.FALSE);
        e21.c.e(r72, e21.c.c(p0.Companion, r54.getBattleAttachedInfoStr()));
        cy0.e.a.getClass();
        cy0.j r77 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r78 = com.bytedance.android.scope.m.b(r77).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r78);
        ((mz0.i) ((f80.a) r78)).w3("livesdk_connection_invite", r70.a, r70.b);
    L184:
        r76 = "";
    L177:
        r74 = "";
        goto L178
    L227:
        return;
    L215:
        return;
    L214:
        return;
    L187:
        if (r57 != BattleNotifyMessageType.LargeMatchEnd.ordinal()) goto L216;
        m(r54);
        return;
    L216:
        return;
    L225:
        return;
    L138:
        r56 = false;
        goto L139
    L213:
        return;
    }

    public final void d(long r4, String r6) {
        Intrinsics.checkNotNullParameter(r6, "reason");
        jy0.b.c("ttlive_anchor_link_match", "changeMaxWaitingTime to " + r4 + ", reason=" + r6, null, 4);
        Disposable r7 = this.d;
        if (r7 == null) goto L5;
        r7.dispose();
    L5:
        long r5 = (r4 + 1) * ((long) WebcastRedirectException.UNKNOWN);
        com.bytedance.revenue.platform.api.core.rx.l r8 = com.bytedance.revenue.platform.api.core.rx.l.a;
        int r9 = com.bytedance.revenue.platform.api.core.rx.p.a;
        this.d = Observable.timer(r5, TimeUnit.MILLISECONDS, Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(this));
    }

    public static void n(boolean r4, String r5, boolean r6) {
        mz0.n r0 = new mz0.n();
        mz0.o r1 = new mz0.o(r0.a);
        r1.a("match_type", "single_link");
        r1.a("room_status", "live");
        if (r4 == false) goto L5;
        String r7 = "strategy_invite";
    L6:
        r1.a("strategy_type", r7);
        if (r6 == false) goto L9;
        String r8 = DataType.TRUE;
    L10:
        r1.a("if_faild_to_switch", r8);
        e21.c.e(r1, e21.c.c(p0.Companion, r5));
        cy0.e.a.getClass();
        cy0.j r9 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r10 = com.bytedance.android.scope.m.b(r9).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r10);
        ((mz0.i) ((f80.a) r10)).w3("livesdk_random_match_strategy_result", r0.a, r0.b);
        return;
    L9:
        r8 = DataType.FALSE;
        goto L10
    L5:
        r7 = "in_poll";
        goto L6
    }

    public static void p(g r10, int r12, String r13) {
        r10.getClass();
        Intrinsics.checkNotNullParameter(r13, "reason");
        if (r41.b.a == false) goto L18;
        if (r10.h().b != 10) goto L14;
        if (Intrinsics.areEqual(r13, "matchSuccess") == false) goto L9;
    L12:
        r10.o(new com.bytedance.android.live.revlink.impl.multianchor.match.c.e(r10.h().e));
        return;
    L9:
        if (Intrinsics.areEqual(r13, "matchInvited") == true) goto L12;
        if (Intrinsics.areEqual(r13, "receiveInviteMsg") == true) goto L12;
    L14:
        if ((r10.h() instanceof com.bytedance.android.live.revlink.impl.multianchor.match.c.C0146c) == true) goto L110;
        JSONObject r14 = new JSONObject();
        cy0.e.a.getClass();
        cy0.j r15 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r16 = com.bytedance.android.scope.m.b(r15).a(Reflection.getOrCreateKotlinClass(vy0.b.class));
        Intrinsics.checkNotNull(r16);
        ((vy0.b) ((f80.a) r16)).sendEventToAllJsBridges("H5_stopAutoMatch", r14);
        return;
    L110:
        return;
    L18:
        if (r10.l() == false) goto L111;
        int r1 = r10.h().b;
        k21.a r6 = r10.i();
        if (r6 == null) goto L28;
        com.bytedance.android.live.revlink.impl.multianchor.match.c r7 = r10.h();
        Intrinsics.checkNotNullParameter(r7, "matchStatus");
        Intrinsics.checkNotNullParameter(r13, "reason");
        String r9 = r7.toString();
        int r8 = r7.b;
        Intrinsics.checkNotNullParameter(r9, "matchStatus");
        Intrinsics.checkNotNullParameter(r13, "reason");
        if (Intrinsics.areEqual(r13, "matchSuccess") == true) goto L28;
        if (Intrinsics.areEqual(r13, "othersCancelMatch") == true) goto L28;
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("match_status", r9);
        r0.put("match_type", Integer.valueOf(r8));
        r0.put("error_msg", r13);
        r0.put("error_code", Integer.valueOf(r12));
        r6.f(r0);
        r6.n("multi_random_match_failed", r0);
    L28:
        if (r1 == 10) goto L30;
    L34:
        r10.o(new com.bytedance.android.live.revlink.impl.multianchor.match.c.C0146c());
    L35:
        Intrinsics.checkNotNullParameter(r13, "source");
        switch(r13.hashCode()) {
            case -1990200299: goto L51;
            case -1313911455: goto L48;
            case -529439106: goto L45;
            case 580938810: goto L42;
            case 1841191747: goto L39;
            default: goto L53;
        };
    L53:
        AutoMatchSource r2 = AutoMatchSource.NoneOfMyBusiness;
    L55:
        if (r2 != AutoMatchSource.NoneOfMyBusiness) goto L57;
    L61:
        r10.j.getBattleAttachedInfo().setValue("");
        r31.a r17 = null;
        r10.j.getPassiveAutoMatchInfo().setValue(null);
        Disposable r3 = r10.c;
        if (r3 == null) goto L64;
        r3.dispose();
    L64:
        Disposable r4 = r10.e;
        if (r4 == null) goto L67;
        r4.dispose();
    L67:
        if (r1 == 10) goto L69;
    L75:
        Pair<List<o>, Boolean> r5 = r10.k();
        boolean r18 = ((Boolean) r5.getSecond()).booleanValue();
        List r19 = (List) r5.getFirst();
        jy0.b.c("ttlive_anchor_link_match", "stopRandomMatch, cancelType=" + r12 + ", reason=" + r13 + " matchType=" + r1 + " participantInfo=" + r19 + " isValid=" + r18, null, 4);
        com.bytedance.android.live.revlink.impl.global.c r20 = r10.l;
        if (r20 == null) goto L78;
        r17 = r20.getLinkNetwork();
    L78:
        if (r17 == null) goto L88;
        Observable r22 = r17.y(r19, r1, r12);
        if (r22 == null) goto L88;
        int r23 = com.bytedance.revenue.platform.api.core.rx.p.a;
        Observable r24 = r22.subscribeOn(Schedulers.io());
        if (r24 == null) goto L88;
        Observable r25 = r24.observeOn(AndroidSchedulers.mainThread());
        if (r25 == null) goto L88;
        Disposable r26 = r25.subscribe(new k(r12), new l(r12));
        if (r26 == null) goto L88;
        r10.c(r26);
    L88:
        if (r12 != 0) goto L112;
        int r110 = ToastUtil.a;
        if (x.d(r1) == false) goto L94;
        int r111 = w11.a.a;
        int r112 = 2131920622;
    L103:
        ToastUtil.a(r112, 0);
        Iterator<b> r113 = r10.f.iterator();
    L105:
        if (r113.hasNext() == false) goto L113;
        r113.next().Eb();
        goto L105
    L113:
        return;
    L94:
        if (x.b(r1) == true) goto L96;
        int r114 = w11.a.a;
        r112 = 2131920603;
        goto L103
    L96:
        if ((!Intrinsics.areEqual(r13, "receiveInviteMsg")) == true) goto L98;
        int r115 = w11.a.a;
        r112 = 2131920508;
        goto L103
    L98:
        if (r1 != 9) goto L100;
        int r116 = w11.a.a;
        r112 = 2131920507;
        goto L103
    L100:
        int r117 = w11.a.a;
        r112 = 2131920509;
        goto L103
    L112:
        return;
    L69:
        if (Intrinsics.areEqual(r13, "matchSuccess") == false) goto L71;
    L72:
        Disposable r27 = r10.d;
        if (r27 == null) goto L75;
        r27.dispose();
        goto L75
    L71:
        if (Intrinsics.areEqual(r13, "matchInvited") == false) goto L75;
    L57:
        if (r2 == AutoMatchSource.MaxWaitTimeOut) goto L61;
        com.bytedance.android.live.revlink.impl.multianchor.match.f r28 = r10.j();
        if (r28 == null) goto L61;
        r28.h(r1, r2);
        goto L61
    L39:
        if (r13.equals("matchError") == false) goto L53;
        r2 = AutoMatchSource.APIServerError;
        goto L55
    L42:
        if (r13.equals("passiveTimeout") == false) goto L53;
    L49:
        r2 = AutoMatchSource.MaxWaitTimeOut;
        goto L55
    L45:
        if (r13.equals("matchSuccess") == false) goto L53;
        r2 = AutoMatchSource.MatchSuccess;
        goto L55
    L48:
        if (r13.equals("timeout") == false) goto L53;
    L51:
        if (r13.equals("receiveInviteMsg") == false) goto L53;
        r2 = AutoMatchSource.ReceiveMultiInviteWhenMatching;
        goto L55
    L30:
        if (Intrinsics.areEqual(r13, "matchSuccess") == false) goto L32;
    L33:
        r10.o(new com.bytedance.android.live.revlink.impl.multianchor.match.c.e(r10.h().e));
        goto L35
    L32:
        if (Intrinsics.areEqual(r13, "matchInvited") == false) goto L34;
    }

    public g(MultiPkMatchContext r2, com.bytedance.android.livesdk.revenue.service.room.c r3, com.bytedance.android.live.revlink.impl.global.c r4, yz0.f r5, x11.a r6) {
        Intrinsics.checkNotNullParameter(r2, "matchContext");
        this.j = r2;
        this.k = r3;
        this.l = r4;
        this.m = r5;
        this.n = r6;
        if (r3 == null) goto L7;
        com.bytedance.android.livesdk.revenue.room.a r7 = r3.getRoomContext();
        if (r7 == null) goto L7;
        IRoomBase r8 = r7.getCommonRoom();
    L8:
        this.a = (IRoom) r8;
        this.b = new CompositeDisposable();
        this.f = new ArrayList();
        return;
    L7:
        r8 = null;
        goto L8
    }

    public final void f(long r25, int r27, boolean r28, int r29, boolean r30, b0 r32, Function1<? super p, Unit> r33) {
        boolean r0 = h().c;
        boolean r7 = h().c;
        Pair<List<o>, Boolean> r1 = k();
        boolean r2 = ((Boolean) r1.getSecond()).booleanValue();
        List<o> r3 = (List) r1.getFirst();
        if (x.b(r27) == false) goto L6;
        r2 = true;
    L6:
        if (r2 == true) goto L19;
        StringBuilder r4 = new StringBuilder("params is invalid mode=");
        com.bytedance.android.live.revlink.impl.global.c r5 = this.l;
        if (r5 == null) goto L10;
        com.bytedance.android.live.revlink.impl.service.internal.a r6 = r5.Do();
    L11:
        if (r6 == null) goto L13;
        int r8 = r6.getCurrentMode();
    L14:
        r4.append(r8);
        r4.append(" participantInfoStr=");
        r4.append(r3);
        IllegalArgumentException r9 = new IllegalArgumentException(r4.toString());
        jy0.b.c("ttlive_anchor_link_match", "autoMatch failed: " + r9, null, 4);
        k21.a r10 = i();
        if (r10 == null) goto L17;
        r10.o(r27, r9);
    L17:
        b(r9);
        return;
    L13:
        r8 = 0;
        goto L14
    L10:
        r6 = null;
        goto L11
    L19:
        jy0.b.d("ttlive_anchor_link_match", "autoMatch matchType:" + r27 + " isFirst:" + r28 + " isFlash=" + r0 + " speedUpLevel=" + (r7 ? 1 : 0) + " participants:" + r3);
        com.bytedance.android.live.revlink.impl.global.c r12 = this.l;
        if (r12 == null) goto L22;
        r31.a r13 = r12.getLinkNetwork();
    L23:
        if (r13 == null) goto L34;
        Observable<ExtraResponse<r4, com.bytedance.android.livesdk.link.model.a>> r14 = r13.t(r25, r28 ? 1 : 0, r27, 2, r0, "", r7 ? 1 : 0, r3, r29, g(), "", "");
        if (r14 == null) goto L35;
        int r15 = com.bytedance.revenue.platform.api.core.rx.p.a;
        Observable r16 = r14.subscribeOn(Schedulers.io());
        if (r16 == null) goto L36;
        Observable r17 = r16.observeOn(AndroidSchedulers.mainThread());
        if (r17 == null) goto L37;
        Disposable r18 = r17.subscribe(new f(this, r28, r27, r7 ? 1 : 0, r32, r30, r29, r33), new C0147g(this, r28, r27, r7 ? 1 : 0, r33));
        if (r18 == null) goto L38;
        c(r18);
        return;
    L38:
        return;
    L37:
        return;
    L36:
        return;
    L35:
        return;
    L34:
        return;
    L22:
        r13 = null;
        goto L23
    }
}
