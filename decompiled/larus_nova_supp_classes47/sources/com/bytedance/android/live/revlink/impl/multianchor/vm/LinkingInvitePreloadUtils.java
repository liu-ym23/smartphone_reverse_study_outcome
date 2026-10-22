package com.bytedance.android.live.revlink.impl.multianchor.vm;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.revenuelink.rtc.i;
import com.bytedance.android.live.revenuelink.rtc.o;
import com.bytedance.android.live.revenuelink.rtc.p;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.live.revlink.impl.multianchor.utils.v;
import com.bytedance.android.live.revlink.impl.multianchor.utils.w;
import com.bytedance.android.live.revlink.impl.pk.utils.q;
import com.bytedance.android.live.revlink.impl.utils.s;
import com.bytedance.android.livesdk.link.model.IGroupRivals;
import com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse;
import com.bytedance.android.livesdk.link.model.m2;
import com.bytedance.android.livesdk.link.model.s2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.m;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import r11.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class LinkingInvitePreloadUtils {
    public int a;
    public int b;
    public long c;
    public boolean d;
    public int e;
    public h f;
    public Disposable g;
    public Disposable h;
    public boolean i;
    public final Lazy j;
    public final ld.a k;
    public final com.bytedance.android.live.revlink.impl.global.c l;

    public static final class a {
    }

    static {
    }

    public final f c() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.l;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.Fb();
    }

    public final v d() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.l;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getMultiLinkMonitor();
    }

    public final w e() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.l;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getMultiLinkUtil();
    }

    public final String f() {
        f r0 = c();
        if (r0 != null) goto L5;
        return "preload disabled";
    L5:
        if (r0.a() != true) goto L137;
        w r1 = e();
        if (r1 != null) goto L10;
    L13:
        com.bytedance.android.live.revlink.impl.global.c r2 = this.l;
        if (r2 == null) goto L16;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.f r3 = r2.getLinkPlayHelper();
    L17:
        if (r3 != null) goto L19;
    L22:
        w r4 = e();
        if (r4 != null) goto L25;
    L28:
        com.bytedance.android.live.revlink.impl.global.c r5 = this.l;
        if (r5 == null) goto L31;
        MultiLinkAnchorControlContext r6 = r5.ua();
    L32:
        boolean r7 = false;
        if (r6 == null) goto L52;
        m<Boolean> r8 = r6.getForbidInvite();
        if (r8 == null) goto L52;
        if (((Boolean) r8.getValue()).booleanValue() != true) goto L52;
        w r9 = e();
        if (r9 == null) goto L51;
        i11.b r10 = r9.a();
        if (r10 == null) goto L51;
        com.bytedance.android.live.revlink.impl.global.c r12 = this.l;
        if (r12 == null) goto L45;
        s r13 = r12.getRevLinkCommonUtil();
    L46:
        if (r13 == null) goto L48;
        String r14 = r13.e();
    L50:
        if (r10.N(r14) == true) goto L52;
    L48:
        r14 = null;
        goto L50
    L45:
        r13 = null;
    L51:
        boolean r15 = true;
    L53:
        if (r15 == false) goto L57;
        return "forbid invite";
    L57:
        if (c() == null) goto L59;
        b51.b r16 = b51.b.c0;
        r16.getClass();
        r11.d r17 = (r11.d) b51.b.j.getValue(r16, b51.b.a[8]);
    L61:
        if (r17 != null) goto L63;
    L65:
        if (r17 != null) goto L67;
    L77:
        if (r17 != null) goto L79;
    L105:
        com.bytedance.android.live.revlink.impl.global.c r18 = this.l;
        if (r18 == null) goto L108;
        com.bytedance.android.live.revenuelink.rtc.f r19 = r18.m0();
    L109:
        if (r19 == null) goto L127;
        i r20 = r19.getRtcManager();
        if (r20 == null) goto L127;
        p r22 = r20.L();
        if (r22 == null) goto L127;
        List<o> r23 = r22.l();
        if (r23 == null) goto L127;
        if (r17 == null) goto L127;
        if (r17.X() != true) goto L127;
        if (r23.size() != 1) goto L127;
        o r24 = (o) CollectionsKt.firstOrNull(r23);
        if (r24 == null) goto L127;
        if (r24.g != true) goto L127;
        return "guest muted";
    L127:
        if (r17 != null) goto L129;
    L134:
        return "";
    L129:
        if (r17.B2() != true) goto L134;
        if ((!((Boolean) l51.a.U.getValue(null, l51.a.a[49])).booleanValue()) == false) goto L134;
        return "never open invite panel";
    L108:
        r19 = null;
        goto L109
    L79:
        if (r17.J1() != true) goto L105;
        com.bytedance.android.live.revlink.impl.global.c r25 = this.l;
        if (r25 == null) goto L83;
        q r26 = r25.getPkUtils();
    L84:
        if (r26 == null) goto L86;
        q11.b r27 = r26.a();
    L88:
        if ((!Intrinsics.areEqual(r27, q11.b.d.b)) == true) goto L102;
        com.bytedance.android.live.revlink.impl.global.c r28 = this.l;
        if (r28 == null) goto L93;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r29 = r28.Ig();
    L94:
        if (r29 == null) goto L102;
        LiveData<Long> r30 = r29.getBaseTimeLeft();
        if (r30 == null) goto L102;
        Long r32 = (Long) r30.getValue();
        if (r32 == null) goto L102;
        if (r32.longValue() >= 30) goto L102;
        r7 = true;
        goto L102
    L93:
        r29 = null;
    L102:
        if (r7 == false) goto L105;
        return "couple pk time up";
    L86:
        r27 = null;
        goto L88
    L83:
        r26 = null;
        goto L84
    L67:
        if (r17.O5() != true) goto L77;
        if (((Boolean) l51.a.O.getValue(null, l51.a.a[41])).booleanValue() == false) goto L71;
    L74:
        boolean r33 = true;
    L75:
        if (r33 == false) goto L77;
        return "";
    L71:
        if (this.a > 3) goto L74;
        r33 = false;
        goto L75
    L63:
        if (r17.l4() != true) goto L65;
        return "";
    L59:
        r17 = null;
    L52:
        r15 = false;
        goto L53
    L31:
        r6 = null;
        goto L32
    L25:
        if (r4.g() != true) goto L28;
        return "pk with audience";
    L19:
        if (r3.g() != true) goto L22;
        return "in multi pk";
    L16:
        r3 = null;
        goto L17
    L10:
        if (r1.h() != r41.f.b) goto L13;
        return "linked user count limit";
    L137:
        return "preload disabled";
    }

    public final String h() {
        String r0 = f();
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("error_msg", r0);
        boolean r3 = false;
        if (r0.length() != 0) goto L5;
        int r2 = 1;
    L6:
        r1.put("error_code", Integer.valueOf(r2 ^ 1));
        com.bytedance.android.live.revlink.impl.global.c r4 = this.l;
        Disposable r5 = null;
        if (r4 == null) goto L9;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r6 = r4.Ig();
    L10:
        if (r6 == null) goto L14;
        LiveData<Long> r7 = r6.getBaseTimeLeft();
        if (r7 == null) goto L14;
        Long r8 = (Long) r7.getValue();
    L15:
        r1.put("couple_pk_time_left", String.valueOf(r8));
        com.bytedance.android.live.revlink.impl.global.c r9 = this.l;
        if (r9 == null) goto L18;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r10 = r9.Ig();
    L19:
        String r12 = "";
        if (r10 == null) goto L25;
        PkBaseStateMachine.c r13 = r10.getCurPKBaseState();
        if (r13 == null) goto L25;
        String r14 = r13.c;
        if (r14 == null) goto L25;
    L26:
        r1.put("couple_pk_stage", r14);
        w r15 = e();
        if (r15 == null) goto L29;
        int r16 = r15.h();
    L30:
        r1.put("link_anchor_cnt", Integer.valueOf(r16));
        r1.put("top_rev_linker", Boolean.valueOf(((Boolean) l51.a.O.getValue(null, l51.a.a[41])).booleanValue()));
        r1.put("invite_panel_open_cnt", Integer.valueOf(this.a));
        r1.put("team_pk_invite_panel_open_cnt", Integer.valueOf(this.b));
        if (c() == null) goto L38;
        int r17 = f.b;
        b51.b r18 = b51.b.c0;
        r18.getClass();
        r11.d r19 = (r11.d) b51.b.j.getValue(r18, b51.b.a[8]);
        if (r19 == null) goto L38;
        Intrinsics.checkNotNullParameter(r19, "$this$formatString");
        String r20 = "InvitePreloadStrategy{aggressive=" + r19.l4() + ",pk_time=" + r19.J1() + ",mute_state=" + r19.X() + ",never_open_invite=" + r19.B2() + ",active_user=" + r19.O5() + "}";
        if (r20 == null) goto L38;
        r12 = r20;
    L38:
        r1.put("strategy", r12);
        v r22 = d();
        if (r22 == null) goto L42;
        r22.H("preload_inviting_list", r1);
    L42:
        if (r0.length() != 0) goto L44;
        r3 = true;
    L44:
        if (r3 == false) goto L67;
        com.bytedance.android.live.revlink.impl.global.c r23 = this.l;
        if (r23 == null) goto L48;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.f r24 = r23.getLinkPlayHelper();
    L49:
        if (r24 != null) goto L51;
    L53:
        int r25 = 6;
    L54:
        jy0.b.f("ttlive_anchor_link_preload", "preload recommendList tabType=" + r25, null, 4);
        this.d = true;
        this.e = r25;
        i97.a r26 = i97.a.a;
        this.c = System.currentTimeMillis();
        long r27 = System.currentTimeMillis();
        com.bytedance.android.live.revlink.impl.global.c r28 = this.l;
        if (r28 == null) goto L57;
        r31.a r29 = r28.getLinkNetwork();
    L58:
        if (r29 == null) goto L66;
        Observable r30 = r29.c(3, false, r25, "", 3, IRivalRankRecommendResponse.LoadType.All.ordinal());
        if (r30 == null) goto L66;
        int r32 = com.bytedance.revenue.platform.api.core.rx.p.a;
        Observable r33 = r30.subscribeOn(Schedulers.io());
        if (r33 == null) goto L66;
        Observable r34 = r33.observeOn(AndroidSchedulers.mainThread());
        if (r34 == null) goto L66;
        r5 = r34.subscribe(new c(this, r25, r27), new d(this, r25, r27));
    L66:
        this.g = r5;
    L68:
        return r0;
    L57:
        r29 = null;
        goto L58
    L51:
        if (r24.c() != true) goto L53;
        r25 = 3;
        goto L54
    L48:
        r24 = null;
        goto L49
    L67:
        b("noPreload");
        goto L68
    L29:
        r16 = 0;
    L25:
        r14 = "";
        goto L26
    L18:
        r10 = null;
    L14:
        r8 = null;
        goto L15
    L9:
        r6 = null;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final Pair<String, IRivalRankRecommendResponse> a(int r10) {
        h r0 = this.f;
        if (r0 == null) goto L52;
        if (r0.b != r10) goto L7;
        i97.a r12 = i97.a.a;
        long r2 = System.currentTimeMillis() - r0.c;
        j r13 = b51.b.c0.d();
        Intrinsics.checkNotNullParameter(r13, "$this$getValidCacheInterval");
        if (r13.z() > 0) goto L11;
        long r4 = 6000;
    L13:
        if (r2 > r4) goto L15;
        IRivalRankRecommendResponse r14 = r0.a;
        f r3 = c();
        if (r3 == null) goto L50;
        if (r3.b() != true) goto L50;
        int r5 = IGroupRivals.GroupType.GroupFeedRecommend.ordinal();
        s2 r15 = r14.getTabRivals();
        if (r15 == null) goto L26;
        Map r16 = r15.getGroupRivals();
        if (r16 == null) goto L26;
        IGroupRivals r17 = (IGroupRivals) r16.get(Long.valueOf(r5));
    L27:
        if (r17 == null) goto L29;
        List r6 = r17.getRivals();
    L30:
        if (r6 == null) goto L50;
        if ((true ^ ((HashSet) this.j.getValue()).isEmpty()) == false) goto L50;
        ArrayList r7 = new ArrayList();
        Iterator r8 = CollectionsKt.toList(r6).iterator();
    L35:
        if (r8.hasNext() == false) goto L46;
        m2 r9 = (m2) r8.next();
        if (r9 == null) goto L35;
        HashSet r18 = (HashSet) this.j.getValue();
        IRoom r19 = r9.getRoom();
        if (r19 == null) goto L41;
        String r20 = r19.getIdStr();
    L43:
        if (r18.contains(r20) == true) goto L35;
        r7.add(r9);
        goto L35
    L41:
        r20 = null;
        goto L43
    L46:
        if (r7.size() < b51.b.c0.d().t()) goto L50;
        if (r17 == null) goto L50;
        r17.setRivals(r7);
        goto L50
    L29:
        r6 = null;
    L26:
        r17 = null;
    L50:
        return TuplesKt.to("", r0.a);
    L15:
        return TuplesKt.to("time expired", null);
    L11:
        r4 = r13.z();
        goto L13
    L7:
        return TuplesKt.to("tabType mismatch", null);
    L52:
        return TuplesKt.to("no cache", null);
    }

    public final void b(String r5) {
        Intrinsics.checkNotNullParameter(r5, "source");
        jy0.b.d("ttlive_anchor_link_preload", "clearCache from ".concat(r5));
        if ((!Intrinsics.areEqual(r5, "preloadFailed")) == false) goto L8;
        Disposable r1 = this.h;
        if (r1 == null) goto L7;
        r1.dispose();
    L7:
        this.i = true;
    L8:
        Disposable r2 = this.g;
        if (r2 == null) goto L11;
        r2.dispose();
    L11:
        this.g = null;
        f r3 = c();
        if (r3 != null) goto L14;
    L19:
        this.f = null;
        this.c = 0;
        ((HashSet) this.j.getValue()).clear();
    L20:
        this.d = false;
        this.e = 0;
        return;
    L14:
        if (r3.b() != true) goto L19;
        if ((!Intrinsics.areEqual(r5, "cacheConsumed")) == false) goto L20;
        if ((!Intrinsics.areEqual(r5, "preloadFailed")) == false) goto L20;
        goto L19
    }

    public LinkingInvitePreloadUtils(ld.a r1, com.bytedance.android.live.revlink.impl.global.c r2) {
        this.k = r1;
        this.l = r2;
        this.i = true;
        this.j = LazyKt.lazy(LinkingInvitePreloadUtils$exposeSet$2.INSTANCE);
    }

    public final void g(int r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, "statusMsg");
        jy0.b.c("ttlive_anchor_link_preload", "first refresh recommend list, status: " + r6, null, 4);
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("error_msg", r6);
        r0.put("error_code", Integer.valueOf(r5));
        w r7 = e();
        if (r7 == null) goto L5;
        int r8 = r7.h();
    L6:
        r0.put("link_anchor_cnt", Integer.valueOf(r8));
        v r9 = d();
        if (r9 == null) goto L10;
        r9.H("first_refresh_status", r0);
        return;
    L10:
        return;
    L5:
        r8 = 0;
        goto L6
    }
}
