package com.bytedance.android.live.liveinteract.plantform.commonwindow.utils;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.customizestream.CustomizeStreamContext;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongContext;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.m;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.CommonMultiLinkWindowManager;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.revenue.game.LinkMicGameContext;
import com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.LinkRoomFightContext;
import com.bytedance.android.live.liveinteract.revenuebase.MultiRevenueDataContext;
import com.bytedance.android.live.liveinteract.videotalk.utils.b0;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.ILiveLinkCameraBackUpConfigKt;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdkapi.model.MultiLinkFrequencyOptConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import tf0.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c {
    public static final /* synthetic */ int i = 0;
    public List<m.d> a;
    public eh0.b b;
    public eh0.b c;
    public final wh0.d d;
    public final DataCenter e;
    public final com.bytedance.android.live.liveinteract.plantform.datamerge.d f;
    public m g;
    public final j1 h;

    public static final class a {
        public static boolean a(int r5) {
            InteractiveSongContext.a r0 = InteractiveSongContext.Companion;
            if (r0.getContext() != null) goto L5;
            return false;
        L5:
            o r1 = b0.e();
            ch0.e r4 = null;
            if ((r1 instanceof BaseMultiLinkWindowManager) == true) goto L8;
            r1 = null;
        L8:
            BaseMultiLinkWindowManager r2 = (BaseMultiLinkWindowManager) r1;
            if (r2 == null) goto L17;
            com.bytedance.android.live.liveinteract.plantform.datamerge.a r3 = r2.h;
            if (r3 == null) goto L17;
            BehaviorSubject<List<tf0.e>> r6 = r3.b;
            if (r6 == null) goto L17;
            List r7 = (List) r6.getValue();
            if (r7 == null) goto L17;
            tf0.e r8 = (tf0.e) CollectionsKt.firstOrNull(r7);
        L19:
            if ((r8 instanceof MultiLinkGuestViewBinder.a) == true) goto L21;
            r8 = null;
        L21:
            MultiLinkGuestViewBinder.a r9 = (MultiLinkGuestViewBinder.a) r8;
            if (r9 == null) goto L25;
            r4 = r9.k;
        L25:
            if (r0.e(com.bytedance.android.live.liveinteract.api.utils.m.i().getCurrentRoom(), Integer.valueOf(r5)) == true) goto L27;
            return false;
        L27:
            if (InteractiveSongContext.a.d(r0, r4, r5, false, 4) == false) goto L31;
            return true;
        L31:
            return false;
        L17:
            r8 = null;
            goto L19
        }
    }

    public static final class b implements wh0.b {
        public final /* synthetic */ c a;

        @Override // wh0.b
        public final String B5() {
            com.bytedance.android.live.liveinteract.customizestream.b r0 = CustomizeStreamContext.Companion.a();
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.B5();
        }

        @Override // wh0.b
        public final boolean currentIsAudienceSingEnable() {
            return k.n(IKtvService.class).currentIsAudienceSingEnable();
        }

        @Override // wh0.b
        public final boolean currentIsMultipleKtvMode() {
            return k.n(IKtvService.class).currentIsMultipleKtvMode();
        }

        @Override // wh0.b
        public final boolean f() {
            CustomizeStreamContext r0 = CustomizeStreamContext.Companion.getContext();
            if (r0 == null) goto L9;
            com.bytedance.live.datacontext.m<Boolean> r1 = r0.getCustomizeStreamStarted();
            if (r1 == null) goto L9;
            Boolean r2 = (Boolean) r1.getValue();
            if (r2 == null) goto L9;
            return r2.booleanValue();
        L9:
            return false;
        }

        @Override // wh0.b
        public final int g() {
            CustomizeStreamContext r0 = CustomizeStreamContext.Companion.getContext();
            if (r0 == null) goto L9;
            com.bytedance.live.datacontext.m<Integer> r1 = r0.getCustomizeStreamType();
            if (r1 == null) goto L9;
            Integer r2 = (Integer) r1.getValue();
            if (r2 == null) goto L9;
            return r2.intValue();
        L9:
            return 0;
        }

        @Override // wh0.b
        public final String m() {
            CustomizeStreamContext r0 = CustomizeStreamContext.Companion.getContext();
            if (r0 == null) goto L8;
            com.bytedance.live.datacontext.m<String> r1 = r0.getCustomizeWTNStreamID();
            if (r1 == null) goto L8;
            String r2 = (String) r1.getValue();
            if (r2 == null) goto L8;
            return r2;
        L8:
            return "";
        }

        public b(c r1) {
            this.a = r1;
        }

        @Override // wh0.b
        public final void c(List r3) {
            Intrinsics.checkNotNullParameter(r3, "regionList");
            e.a r0 = e.c;
            Function0<cg6.a> r1 = new MultiLinkRegionUtils$multiLinkRegionMixHostService$1$startSRIfNeeded$1(this);
            r0.getClass();
            e.a.g(r3, r1);
            e.a.f(r3, this.a.h);
        }

        @Override // wh0.b
        public final void d(ti6.f r2) {
            Intrinsics.checkNotNullParameter(r2, "region");
            LinkMicGameContext.Companion.getClass();
            LinkMicGameContext.a.b(r2);
        }

        @Override // wh0.b
        public final boolean e(int r2) {
            int r0 = c.i;
            return a.a(r2);
        }

        @Override // wh0.b
        public final String i(String r2) {
            Intrinsics.checkNotNullParameter(r2, "interactId");
            ch0.e r3 = this.a.a(r2);
            if (r3 == null) goto L10;
            ILinkPlayerInfoBridge r4 = r3.a;
            if (r4 == null) goto L10;
            IBaseUser r5 = r4.getUser();
            if (r5 == null) goto L10;
            String r6 = r5.getIdString();
            if (r6 == null) goto L10;
            return r6;
        L10:
            return "";
        }

        @Override // wh0.b
        public final void j(ti6.f r2) {
            Intrinsics.checkNotNullParameter(r2, "region");
            int r0 = com.bytedance.android.live.liveinteract.linkcast.a.a;
            com.bytedance.android.live.liveinteract.linkcast.a.C0037a.a(r2);
        }

        @Override // wh0.b
        public final int l(String r2) {
            Intrinsics.checkNotNullParameter(r2, "interactId");
            ch0.e r3 = this.a.a(r2);
            if (r3 == null) goto L7;
            ILinkPlayerInfoBridge r4 = r3.a;
            if (r4 == null) goto L7;
            Integer r5 = Integer.valueOf(r4.getLinkType());
        L8:
            if (r5 != null) goto L12;
            return 0;
        L12:
            return r5.intValue();
        L7:
            r5 = null;
            goto L8
        }

        @Override // wh0.b
        public final boolean o(String r2) {
            Intrinsics.checkNotNullParameter(r2, "interactId");
            ch0.e r3 = this.a.a(r2);
            if (r3 == null) goto L5;
            ch0.h r4 = r3.b;
        L6:
            if (r4 != null) goto L10;
            return true;
        L10:
            return r4.c;
        L5:
            r4 = null;
            goto L6
        }

        @Override // wh0.b
        public final void p(ti6.f r3) {
            Intrinsics.checkNotNullParameter(r3, "region");
            MultiRevenueDataContext.Companion.getClass();
            com.bytedance.android.live.liveinteract.revenuebase.b r0 = MultiRevenueDataContext.a.b();
            if (r0 == null) goto L6;
            r0.d0(bj0.d.b, r3);
            return;
        }

        @Override // wh0.b
        public final void a(List<ti6.f> r2, ti6.f r3) {
            Intrinsics.checkNotNullParameter(r2, "list");
            Intrinsics.checkNotNullParameter(r3, "gameRegion");
            com.bytedance.android.live.liveinteract.revenue.game.servermixer.b.b(r2, r3);
        }

        @Override // wh0.b
        public final void b(List<ti6.f> r2, ti6.f r3) {
            Intrinsics.checkNotNullParameter(r2, "list");
            Intrinsics.checkNotNullParameter(r3, "gameRegion");
            com.bytedance.android.live.liveinteract.revenue.game.servermixer.b.a(r2, r3);
        }

        @Override // wh0.b
        public final void h(ti6.f r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "region");
            int r0 = pi0.a.a;
            pi0.a.a(this.a.e, r2, r3);
        }

        @Override // wh0.b
        public final void k(List<ti6.f> r2, ti6.f r3) {
            Intrinsics.checkNotNullParameter(r2, "list");
            Intrinsics.checkNotNullParameter(r3, "gameRegion");
            com.bytedance.android.live.liveinteract.revenue.game.servermixer.b.c(r2, r3);
        }

        @Override // wh0.b
        public final void n(ti6.f r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "region");
            Intrinsics.checkNotNullParameter("BaseMultiLinkWindowManager", "tag");
            List r0 = (List) this.a.f.f().getValue();
            if (r0 == null) goto L5;
            int r1 = r0.size();
        L6:
            com.bytedance.android.live.liveinteract.spatial.a.f(r3, r1, this.a.g.n(), r4);
            return;
        L5:
            r1 = 0;
            goto L6
        }
    }

    static {
    }

    public static List c(m r6) {
        List<m.d> r0 = r6.h();
        if (r0 == null) goto L8;
        List<m.d> r1 = r0;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator<T> r3 = r1.iterator();
    L6:
        if (r3.hasNext() == false) goto L10;
        r2.add(((m.d) r3.next()).a());
    L10:
        if (r6.getUiLayout() != 7) goto L12;
    L17:
        if (r2 == null) goto L24;
        Iterator r7 = r2.iterator();
    L20:
        if (r7.hasNext() == false) goto L24;
        m.d r4 = (m.d) r7.next();
        if (r4.c() <= 0) goto L20;
        r4.l(r4.f() - ((double) 41));
    L24:
        return r2;
    L12:
        if (r6.getUiLayout() == 110) goto L17;
        if (r6.getUiLayout() == 109) goto L17;
        if (r6.getUiLayout() != 111) goto L24;
    L8:
        r2 = null;
        goto L10
    }

    public final ch0.e a(String r5) {
        List r0 = (List) this.f.f().getValue();
        Object r1 = null;
        if (r0 == null) goto L12;
        Iterator r2 = r0.iterator();
    L6:
        if (r2.hasNext() == false) goto L10;
        Object r3 = r2.next();
        if (Intrinsics.areEqual(((ch0.e) r3).a.getInteractId(), r5) == false) goto L6;
    L11:
        ch0.e r4 = (ch0.e) r3;
    L13:
        if (r4 == null) goto L16;
        return r4;
    L16:
        if (aj0.b.c(this.g.getUiLayout()) == false) goto L32;
        eh0.b r6 = this.b;
        if (r6 == null) goto L57;
        BehaviorSubject<List<ch0.e>> r7 = r6.h();
        if (r7 == null) goto L58;
        List r8 = (List) r7.getValue();
        if (r8 == null) goto L59;
        Iterator r9 = r8.iterator();
    L25:
        if (r9.hasNext() == false) goto L30;
        Object r10 = r9.next();
        if (Intrinsics.areEqual(((ch0.e) r10).a.getInteractId(), r5) == false) goto L25;
        r1 = r10;
    L30:
        return (ch0.e) r1;
    L59:
        return null;
    L58:
        return null;
    L57:
        return null;
    L32:
        if (qi0.e.d() == false) goto L47;
        eh0.b r11 = this.c;
        if (r11 == null) goto L60;
        BehaviorSubject<List<ch0.e>> r12 = r11.h();
        if (r12 == null) goto L61;
        List r13 = (List) r12.getValue();
        if (r13 == null) goto L62;
        Iterator r14 = r13.iterator();
    L41:
        if (r14.hasNext() == false) goto L46;
        Object r15 = r14.next();
        if (Intrinsics.areEqual(((ch0.e) r15).a.getInteractId(), r5) == false) goto L41;
        r1 = r15;
    L46:
        return (ch0.e) r1;
    L62:
        return null;
    L61:
        return null;
    L60:
        return null;
    L47:
        return r4;
    L10:
        r3 = null;
        goto L11
    L12:
        r4 = null;
        goto L13
    }

    public final Pair<Double, Double> d(m.d r9) {
        m.c r0 = this.g.d();
        m.a r1 = this.g.c();
        if (r9 == null) goto L8;
        if (r0 == null) goto L8;
        if (r1 == null) goto L8;
        return new Pair(Double.valueOf(r9.e() / ((double) r1.f())), Double.valueOf((r9.f() + ((double) r0.e())) / ((double) r1.d())));
    L8:
        double r2 = 0.0f;
        return new Pair(Double.valueOf(r2), Double.valueOf(r2));
    }

    public final Pair<Double, Double> e(m.d r8) {
        m.a r0 = this.g.c();
        if (r0 == null) goto L7;
        if (r8 == null) goto L7;
        return new Pair(Double.valueOf(r8.d() / ((double) r0.f())), Double.valueOf(r8.b() / ((double) r0.d())));
    L7:
        double r1 = 0.0f;
        return new Pair(Double.valueOf(r1), Double.valueOf(r1));
    }

    public final void g(m r3) {
        Intrinsics.checkNotNullParameter(r3, "config");
        this.g = r3;
        this.a = c(r3);
        wh0.d r0 = this.d;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNullParameter(r3, "layoutConfig");
        r0.g = r3;
        r0.a = wh0.d.a(r3);
        return;
    }

    public final boolean h(String r2) {
        ch0.e r0 = a(r2);
        if (r0 == null) goto L11;
        ch0.h r1 = r0.b;
        if (r1 == null) goto L11;
        if (r1.c == true) goto L11;
        if (i(r2) == false) goto L11;
        return true;
    L11:
        return false;
    }

    public final boolean i(String r3) {
        if (ILiveLinkCameraBackUpConfigKt.supportMixStreamOpt(vm2.g.c()) == false) goto L5;
    L10:
        ch0.e r4 = a(r3);
        if (r4 == null) goto L15;
        ILinkPlayerInfoBridge r5 = r4.a;
        if (r5 == null) goto L15;
        Integer r6 = Integer.valueOf(r5.getLinkType());
    L16:
        if (r6 != null) goto L19;
    L20:
        if (r6 != null) goto L23;
    L25:
        return false;
    L23:
        if (r6.intValue() != 3) goto L25;
        return true;
    L19:
        if (r6.intValue() != 1) goto L20;
        return true;
    L15:
        r6 = null;
        goto L16
    L5:
        if (k.n(IKtvService.class).currentIsMultipleKtvMode() == true) goto L10;
        if (k.n(IKtvService.class).currentIsAudienceSingEnable() == true) goto L10;
        return true;
    }

    public static ti6.f f(pn0.f.c r9, h r10, h r11) {
        if (r9 == null) goto L15;
        if (r10 == null) goto L17;
        if (r11 == null) goto L18;
        ti6.f r0 = new ti6.f();
        double r1 = r11.a;
        double r3 = 0;
        if (r1 >= r3) goto L8;
        double r5 = r11.c + r1;
    L9:
        Pair r7 = new Pair(Double.valueOf(((double) r9.e) / r5), Double.valueOf(((double) r9.f) / r11.d));
        double r2 = r11.a;
        if (r2 >= r3) goto L12;
        double r4 = r11.c + r2;
    L13:
        Pair r12 = new Pair(Double.valueOf(((double) r9.c) / r4), Double.valueOf(((((double) r9.d) + r10.b) - r11.b) / r11.d));
        double r13 = ((Number) r7.getFirst()).doubleValue();
        double r6 = ((Number) r7.getSecond()).doubleValue();
        r0.f = r13;
        r0.g = r6;
        double r14 = ((Number) r12.getFirst()).doubleValue();
        double r8 = ((Number) r12.getSecond()).doubleValue();
        r0.d = r14;
        r0.e = r8;
        r0.o = -1;
        return r0;
    L12:
        r4 = r11.c;
        goto L13
    L8:
        r5 = r11.c;
        goto L9
    L18:
        return null;
    L17:
        return null;
    L15:
        return null;
    }

    public final void k(List<ti6.f> r17, Map<String, Integer> r18, wh0.a r19) {
        Iterator<ti6.f> r2 = r17.iterator();
    L4:
        if (r2.hasNext() == false) goto L62;
        ti6.f r3 = r2.next();
        if (je0.d.r() == true) goto L8;
    L10:
        boolean r7 = h(r3.b);
    L11:
        int r8 = r19.b(r3.b);
        r3.n = !r7;
        if (r8 >= 0) goto L13;
        r2.remove();
        goto L4
    L13:
        r18.put(r3.b, Integer.valueOf(r8));
        List<m.d> r10 = this.g.h();
        if (r10 == null) goto L26;
        Iterator<T> r11 = r10.iterator();
    L17:
        if (r11.hasNext() == false) goto L24;
        Object r12 = r11.next();
        if (((m.d) r12).c() != r8) goto L21;
        boolean r13 = true;
    L22:
        if (r13 == false) goto L17;
    L25:
        m.d r14 = (m.d) r12;
    L27:
        ch0.e r15 = a(r3.b);
        if (r15 == null) goto L35;
        ILinkPlayerInfoBridge r16 = r15.a;
        if (r16 == null) goto L35;
        IBaseUser r110 = r16.getUser();
        if (r110 == null) goto L35;
        String r111 = r110.getIdString();
        if (r111 == null) goto L35;
    L36:
        if (r14 == null) goto L56;
        Pair<Double, Double> r112 = e(r14);
        Pair<Double, Double> r113 = d(r14);
        double r114 = ((Number) r112.getFirst()).doubleValue();
        double r4 = ((Number) r112.getSecond()).doubleValue();
        r3.f = r114;
        r3.g = r4;
        double r5 = 1.0d;
        if (r7 == false) goto L40;
        double r115 = ((Number) r113.getFirst()).doubleValue();
    L41:
        if (r7 == false) goto L43;
        r5 = ((Number) r113.getSecond()).doubleValue();
    L43:
        r3.d = r115;
        r3.e = r5;
        if (r7 == false) goto L46;
        int r6 = 1;
    L47:
        r3.a = r6;
        r3.c(r111);
        r3.l = true;
        com.bytedance.live.datacontext.m r9 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r9 == null) goto L52;
        IRoom r20 = (IRoom) r9.getValue();
        if (r20 == null) goto L52;
        String r21 = r20.getOwnerUserIdString();
    L54:
        if (Intrinsics.areEqual(r21, r111) == false) goto L56;
        int r22 = com.bytedance.android.live.liveinteract.linkcast.a.a;
        com.bytedance.android.live.liveinteract.linkcast.a.C0037a.a(r3);
    L52:
        r21 = null;
        goto L54
    L46:
        r6 = 2;
        goto L47
    L40:
        r115 = 1.0d;
    L56:
        List r23 = (List) this.f.f().getValue();
        if (r23 == null) goto L59;
        int r24 = r23.size();
    L60:
        com.bytedance.android.live.liveinteract.spatial.a.f(r3, r24, this.g.n(), r8);
        goto L4
    L59:
        r24 = 0;
    L35:
        r111 = "";
        goto L36
    L21:
        r13 = false;
        goto L22
    L24:
        r12 = null;
        goto L25
    L26:
        r14 = null;
        goto L27
    L8:
        if (Intrinsics.areEqual(r3.b, tc0.c.h().f) == false) goto L10;
        r7 = i(r3.b);
        goto L11
    L62:
        Iterator<T> r25 = r17.iterator();
    L64:
        if (r25.hasNext() == false) goto L66;
        ti6.f r26 = (ti6.f) r25.next();
        LinkMicGameContext.Companion.getClass();
        LinkMicGameContext.a.b(r26);
        goto L64
    L66:
        int r27 = qi0.e.a;
        int r28 = qi0.e.a(this.g.getUiLayout());
        List<m.d> r29 = this.g.h();
        if (r29 == null) goto L79;
        Iterator<T> r30 = r29.iterator();
    L70:
        if (r30.hasNext() == false) goto L77;
        Object r31 = r30.next();
        if (((m.d) r31).c() != r28) goto L74;
        boolean r32 = true;
    L75:
        if (r32 == false) goto L70;
        Object r33 = r31;
    L78:
        m.d r34 = (m.d) r33;
    L80:
        Pair<Double, Double> r35 = e(r34);
        Pair<Double, Double> r36 = d(r34);
        ti6.f r37 = new ti6.f();
        r37.a = 1;
        double r38 = ((Number) r35.getFirst()).doubleValue();
        double r39 = ((Number) r35.getSecond()).doubleValue();
        r37.f = r38;
        r37.g = r39;
        double r40 = ((Number) r36.getFirst()).doubleValue();
        double r41 = ((Number) r36.getSecond()).doubleValue();
        r37.d = r40;
        r37.e = r41;
        r37.l = false;
        r37.o = 0;
        MultiLinkFrequencyOptConfig r42 = f.a;
        if (f.g(Integer.valueOf(this.g.m()), Integer.valueOf(this.g.getUiLayout())) == false) goto L84;
        com.bytedance.android.live.liveinteract.revenue.game.servermixer.b.a(r17, r37);
        return;
    L84:
        if (f.h(Integer.valueOf(this.g.m()), Integer.valueOf(this.g.getUiLayout())) == false) goto L87;
        com.bytedance.android.live.liveinteract.revenue.game.servermixer.b.b(r17, r37);
        return;
    L87:
        if (f.i(Integer.valueOf(this.g.m()), Integer.valueOf(this.g.getUiLayout())) == false) goto L109;
        com.bytedance.android.live.liveinteract.revenue.game.servermixer.b.c(r17, r37);
        return;
    L109:
        return;
    L74:
        r32 = false;
        goto L75
    L77:
        r33 = null;
        goto L78
    L79:
        r34 = null;
        goto L80
    }

    public c(DataCenter r2, com.bytedance.android.live.liveinteract.plantform.datamerge.d r3, m r4, j1 r5) {
        Intrinsics.checkNotNullParameter(r3, "dataMergeCenter");
        Intrinsics.checkNotNullParameter(r4, "layoutConfig");
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.h = r5;
        b r6 = new b(this);
        this.a = c(r4);
        if (r5 == null) goto L5;
        bn0.b r7 = r5.getMultiLinkRoomScope();
    L6:
        m r8 = this.g;
        Intrinsics.checkNotNullParameter(r6, "hostService");
        Intrinsics.checkNotNullParameter(r8, "layoutConfig");
        this.d = new wh0.d(r6, r7, r8);
        return;
    L5:
        r7 = null;
        goto L6
    }

    public static ti6.f b(pn0.f.c r9, List r10, h r11, h r12) {
        int r0 = ILinkPlayerInfoBridge.DEFAULT_ClIENT_UI_POSITION;
        if (r10 == null) goto L8;
        Iterator r13 = r10.iterator();
        int r1 = ILinkPlayerInfoBridge.DEFAULT_ClIENT_UI_POSITION;
        int r2 = Integer.MAX_VALUE;
        int r3 = Integer.MAX_VALUE;
    L6:
        if (r13.hasNext() == false) goto L9;
        pn0.f.c r4 = (pn0.f.c) r13.next();
        r2 = RangesKt.coerceAtMost(r2, r4.c);
        r3 = RangesKt.coerceAtMost(r3, r4.d);
        r0 = RangesKt.coerceAtLeast(r0, r4.c + r4.e);
        r1 = RangesKt.coerceAtLeast(r1, r4.d + r4.f);
    L9:
        Pair r14 = new Pair(Integer.valueOf(r2), Integer.valueOf(r3));
        Pair r5 = new Pair(Integer.valueOf(r0), Integer.valueOf(r1));
        if (r9 == null) goto L15;
        if (r11 == null) goto L18;
        if (r12 == null) goto L19;
        ti6.f r15 = new ti6.f();
        Intrinsics.checkNotNullParameter(r14, "leftTop");
        Intrinsics.checkNotNullParameter(r5, "rightBottom");
        double r6 = ((double) r9.e) / ((double) (((Number) r5.getFirst()).intValue() - ((Number) r14.getFirst()).intValue()));
        double r7 = ((double) r9.f) / ((double) (((Number) r5.getSecond()).intValue() - ((Number) r14.getSecond()).intValue()));
        Pair r8 = new Pair(Double.valueOf(r6), Double.valueOf(r7));
        Intrinsics.checkNotNullParameter(r14, "leftTop");
        Intrinsics.checkNotNullParameter(r5, "rightBottom");
        double r16 = ((double) r9.c) / ((double) (((Number) r5.getFirst()).intValue() - ((Number) r14.getFirst()).intValue()));
        double r17 = ((double) r9.d) / ((double) (((Number) r5.getSecond()).intValue() - ((Number) r14.getSecond()).intValue()));
        Pair r18 = new Pair(Double.valueOf(r16), Double.valueOf(r17));
        double r19 = ((Number) r8.getFirst()).doubleValue();
        double r20 = ((Number) r8.getSecond()).doubleValue();
        r15.f = r19;
        r15.g = r20;
        double r21 = ((Number) r18.getFirst()).doubleValue();
        double r22 = ((Number) r18.getSecond()).doubleValue();
        r15.d = r21;
        r15.e = r22;
        r15.o = -1;
        return r15;
    L19:
        return null;
    L18:
        return null;
    L15:
        return null;
    L8:
        r1 = ILinkPlayerInfoBridge.DEFAULT_ClIENT_UI_POSITION;
        r2 = Integer.MAX_VALUE;
        r3 = Integer.MAX_VALUE;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void j(List r20, Map r21, Map r22, CommonMultiLinkWindowManager.c r23) {
        Intrinsics.checkNotNullParameter(r20, "list");
        Intrinsics.checkNotNullParameter(r21, "posMap");
        Intrinsics.checkNotNullParameter(r23, "listener");
        String r10 = "";
        if (((Boolean) vm2.i.N.getValue(null, vm2.i.a[38])).booleanValue() == false) goto L267;
        wh0.d r7 = this.d;
        if (r7 == 0) goto L540;
        Intrinsics.checkNotNullParameter(r20, "list");
        Intrinsics.checkNotNullParameter(r21, "posMap");
        Intrinsics.checkNotNullParameter(r23, "listener");
        int r4 = wh0.e.a;
        Integer r5 = Integer.valueOf(r7.g.m());
        Integer r6 = Integer.valueOf(r7.g.getUiLayout());
        if (r6 != null) goto L10;
    L11:
        if (r6 != null) goto L14;
    L15:
        if (r6 != null) goto L18;
    L20:
        if (r5 != null) goto L23;
    L24:
        if (r5 != null) goto L27;
    L28:
        if (r5 != null) goto L31;
    L33:
        boolean r8 = false;
    L36:
        if (r8 == true) goto L60;
        if (r6 != null) goto L40;
    L41:
        if (r6 != null) goto L44;
    L45:
        if (r6 != null) goto L48;
    L50:
        if (r5 != null) goto L53;
    L55:
        boolean r9 = false;
    L57:
        if (r9 == true) goto L60;
        boolean r11 = false;
    L61:
        if (r11 == false) goto L109;
        Iterator r12 = r20.iterator();
    L64:
        if (r12.hasNext() == false) goto L108;
        ti6.f r13 = (ti6.f) r12.next();
        boolean r14 = r7.d(r13.b);
        boolean r15 = r23.a(r13.b);
        int r16 = r23.b(r13.b);
        r13.n = !r14;
        if (r16 < 0) goto L106;
        String r17 = r13.b;
        if (r16 != 0) goto L72;
        if (r15 == false) goto L71;
        int r18 = -1;
    L73:
        r21.put(r17, Integer.valueOf(r18));
        List<m.d> r19 = r7.a;
        if (r19 == null) goto L86;
        Iterator<T> r24 = r19.iterator();
    L77:
        if (r24.hasNext() == false) goto L84;
        Object r25 = r24.next();
        if (((m.d) r25).c() != r16) goto L81;
        boolean r110 = true;
    L82:
        if (r110 == false) goto L77;
    L85:
        m.d r26 = (m.d) r25;
    L87:
        String r27 = r7.e.i(r13.b);
        if (r27 != null) goto L90;
        r27 = "";
    L90:
        if (r26 == null) goto L105;
        Pair<Double, Double> r111 = r7.c(r26);
        Pair<Double, Double> r112 = r7.b(r26);
        double r113 = ((Number) r111.getFirst()).doubleValue();
        double r0 = ((Number) r111.getSecond()).doubleValue();
        r13.f = r113;
        r13.g = r0;
        if (r14 == false) goto L94;
        double r1 = ((Number) r112.getFirst()).doubleValue();
    L95:
        if (r14 == false) goto L97;
        double r114 = ((Number) r112.getSecond()).doubleValue();
    L98:
        r13.d = r1;
        r13.e = r114;
        if (r14 == false) goto L101;
        int r2 = 1;
    L102:
        r13.a = r2;
        r13.o = r26.g();
        r13.c(r27);
        r13.l = true;
        if (r15 == false) goto L105;
        r7.e.j(r13);
        r7.e.h(r13, r7.g.getUiLayout());
        goto L105
    L101:
        r2 = 2;
        goto L102
    L97:
        r114 = 1.0d;
        goto L98
    L94:
        r1 = 1.0d;
    L105:
        wh0.b r3 = r7.e;
        r7.g.getClass();
        r3.n(r13, r16);
        goto L64
    L81:
        r110 = false;
        goto L82
    L84:
        r25 = null;
        goto L85
    L86:
        r26 = null;
        goto L87
    L71:
        r18 = 6;
        goto L73
    L72:
        r18 = r16 - 1;
        goto L73
    L106:
        r13.f = 0.1d;
        r13.g = 0.1d;
        r13.d = 1.0d;
        r13.e = 1.0d;
        r13.l = false;
    L108:
        String r115 = r10;
        List r28 = r20;
    L261:
        r7.e.c(r28);
        Iterator r29 = r28.iterator();
    L263:
        if (r29.hasNext() == false) goto L265;
        ti6.f r30 = (ti6.f) r29.next();
        Intrinsics.checkNotNullParameter(r30, "$this$toStringExt");
        r30.toString();
        goto L263
    L265:
        jy0.b.c("ttlive_anchor_link_sei", r115, null, 4);
        return;
    L109:
        Integer r31 = Integer.valueOf(r7.g.m());
        Integer r32 = Integer.valueOf(r7.g.getUiLayout());
        if (r32 != null) goto L113;
    L114:
        if (r32 != null) goto L117;
    L118:
        if (r32 != null) goto L121;
    L122:
        if (r32 != null) goto L125;
    L127:
        if (r31 != null) goto L130;
    L131:
        if (r31 != null) goto L134;
    L135:
        if (r31 != null) goto L138;
    L139:
        if (r31 != null) goto L142;
    L144:
        boolean r33 = false;
    L146:
        if (r33 == false) goto L203;
        Iterator r34 = r20.iterator();
    L149:
        if (r34.hasNext() == false) goto L108;
        ti6.f r35 = (ti6.f) r34.next();
        boolean r36 = r7.d(r35.b);
        boolean r37 = r23.a(r35.b);
        int r38 = r23.b(r35.b);
        r35.n = !r36;
        if (r38 < 0) goto L200;
        String r39 = r35.b;
        if (r38 != 0) goto L165;
        if (r37 == false) goto L157;
        int r40 = -1;
    L166:
        r21.put(r39, Integer.valueOf(r40));
        List<m.d> r41 = r7.a;
        if (r41 == null) goto L179;
        Iterator<T> r42 = r41.iterator();
    L170:
        if (r42.hasNext() == false) goto L177;
        Object r43 = r42.next();
        if (((m.d) r43).c() != r38) goto L174;
        boolean r116 = true;
    L175:
        if (r116 == false) goto L170;
    L178:
        m.d r44 = (m.d) r43;
    L180:
        String r45 = r7.e.i(r35.b);
        if (r45 != null) goto L183;
        r45 = r10;
    L183:
        if (r44 == null) goto L198;
        Pair<Double, Double> r117 = r7.c(r44);
        Pair<Double, Double> r118 = r7.b(r44);
        double r119 = ((Number) r117.getFirst()).doubleValue();
        String r120 = r10;
        double r121 = ((Number) r117.getSecond()).doubleValue();
        r35.f = r119;
        r35.g = r121;
        if (r36 == false) goto L187;
        double r122 = ((Number) r118.getFirst()).doubleValue();
    L188:
        if (r36 == false) goto L190;
        double r123 = ((Number) r118.getSecond()).doubleValue();
    L191:
        r35.d = r122;
        r35.e = r123;
        if (r36 == false) goto L194;
        int r46 = 1;
    L195:
        r35.a = r46;
        r35.o = r44.g();
        r35.c(r45);
        r35.l = true;
        if (r37 == false) goto L199;
        r7.e.j(r35);
        r7.e.h(r35, r7.g.getUiLayout());
    L199:
        wh0.b r47 = r7.e;
        r7.g.getClass();
        r47.n(r35, r38);
    L201:
        r10 = r120;
        goto L149
    L194:
        r46 = 2;
        goto L195
    L190:
        r123 = 1.0d;
        goto L191
    L187:
        r122 = 1.0d;
        goto L188
    L198:
        r120 = r10;
        goto L199
    L174:
        r116 = false;
        goto L175
    L177:
        r43 = null;
        goto L178
    L179:
        r44 = null;
        goto L180
    L157:
        if (r7.g.getUiLayout() != 109) goto L159;
    L164:
        r40 = 8;
        goto L166
    L159:
        if (r7.g.getUiLayout() == 111) goto L164;
        if (r7.g.getUiLayout() == 112) goto L164;
        r40 = 6;
        goto L166
    L165:
        r40 = r38 - 1;
        goto L166
    L200:
        r120 = r10;
        r35.f = 0.1d;
        r35.g = 0.1d;
        r35.d = 1.0d;
        r35.e = 1.0d;
        r35.l = false;
        goto L201
    L203:
        r115 = "";
        Integer r48 = Integer.valueOf(r7.g.m());
        Integer r49 = Integer.valueOf(r7.g.getUiLayout());
        if (r49 == null) goto L206;
        int r50 = r49.intValue();
    L208:
        if (aj0.b.c(r50) == false) goto L211;
    L209:
        boolean r51 = true;
    L214:
        if (r51 == false) goto L216;
        r28 = r20;
        r7.g(r28, r21, r22, r23);
        goto L261
    L216:
        r28 = r20;
        if (wh0.e.a(Integer.valueOf(r7.g.m()), Integer.valueOf(r7.g.getUiLayout())) == false) goto L220;
        r7.f(r28, r21, r23);
        goto L261
    L220:
        if (wh0.e.b(Integer.valueOf(r7.g.m()), Integer.valueOf(r7.g.getUiLayout())) == false) goto L222;
        r7.f(r28, r21, r23);
        goto L261
    L222:
        Iterator r52 = r20.iterator();
    L224:
        if (r52.hasNext() == false) goto L261;
        ti6.f r53 = (ti6.f) r52.next();
        boolean r54 = r7.d(r53.b);
        int r55 = r23.b(r53.b);
        r53.n = !r54;
        if (r55 >= 0) goto L227;
        r53.f = 0.1d;
        r53.g = 0.1d;
        r53.d = 1.0d;
        r53.e = 1.0d;
        r53.l = false;
        goto L224
    L227:
        r21.put(r53.b, Integer.valueOf(r55));
        List<m.d> r56 = r7.a;
        if (r56 == null) goto L240;
        Iterator<T> r57 = r56.iterator();
    L231:
        if (r57.hasNext() == false) goto L238;
        Object r58 = r57.next();
        if (((m.d) r58).c() != r55) goto L235;
        boolean r124 = true;
    L236:
        if (r124 == false) goto L231;
    L239:
        m.d r59 = (m.d) r58;
    L241:
        String r60 = r7.e.i(r53.b);
        if (r60 != null) goto L244;
        r60 = r115;
    L244:
        if (r59 == null) goto L259;
        Pair<Double, Double> r125 = r7.c(r59);
        Pair<Double, Double> r61 = r7.b(r59);
        double r126 = ((Number) r125.getFirst()).doubleValue();
        double r127 = ((Number) r125.getSecond()).doubleValue();
        r53.f = r126;
        r53.g = r127;
        if (r54 == false) goto L248;
        double r128 = ((Number) r61.getFirst()).doubleValue();
    L249:
        if (r54 == false) goto L251;
        double r129 = ((Number) r61.getSecond()).doubleValue();
    L252:
        r53.d = r128;
        r53.e = r129;
        if (r54 == false) goto L255;
        int r62 = 1;
    L256:
        r53.a = r62;
        r53.c(r60);
        r53.l = true;
        if (r23.a(r53.b) == false) goto L259;
        r7.e.j(r53);
        goto L259
    L255:
        r62 = 2;
        goto L256
    L251:
        r129 = 1.0d;
        goto L252
    L248:
        r128 = 1.0d;
    L259:
        wh0.b r63 = r7.e;
        r7.g.getClass();
        r63.n(r53, r55);
        goto L224
    L235:
        r124 = false;
        goto L236
    L238:
        r58 = null;
        goto L239
    L240:
        r59 = null;
        goto L241
    L211:
        if (aj0.b.b(r48) == true) goto L209;
        r51 = false;
        goto L214
    L206:
        r50 = 0;
        goto L208
    L142:
        if (r31.intValue() != 28) goto L144;
    L145:
        r33 = true;
        goto L146
    L138:
        if (r31.intValue() == 27) goto L145;
    L134:
        if (r31.intValue() == 25) goto L145;
    L130:
        if (r31.intValue() == 26) goto L145;
    L125:
        if (r32.intValue() != 112) goto L127;
    L121:
        if (r32.intValue() == 111) goto L145;
    L117:
        if (r32.intValue() == 109) goto L145;
    L113:
        if (r32.intValue() == 110) goto L145;
    L53:
        if (r5.intValue() != 15) goto L55;
    L56:
        r9 = true;
        goto L57
    L48:
        if (r6.intValue() != 29) goto L50;
    L44:
        if (r6.intValue() == 25) goto L56;
    L40:
        if (r6.intValue() == 7) goto L56;
    L60:
        r11 = true;
        goto L61
    L31:
        if (r5.intValue() != 12) goto L33;
    L34:
        r8 = true;
        goto L36
    L27:
        if (r5.intValue() == 10) goto L34;
    L23:
        if (r5.intValue() == 8) goto L34;
    L18:
        if (r6.intValue() != 9) goto L20;
    L14:
        if (r6.intValue() == 6) goto L34;
    L10:
        if (r6.intValue() == 1) goto L34;
    L540:
        return;
    L267:
        String r65 = "";
        m.d r66 = null;
        MultiLinkFrequencyOptConfig r67 = f.a;
        if (f.f(Integer.valueOf(this.g.m()), Integer.valueOf(this.g.getUiLayout())) == false) goto L333;
        Iterator r68 = r20.iterator();
    L271:
        if (r68.hasNext() == false) goto L480;
        ti6.f r69 = (ti6.f) r68.next();
        boolean r70 = h(r69.b);
        int r71 = r23.b(r69.b);
        boolean r130 = r23.a(r69.b);
        r69.n = !r70;
        if (r71 < 0) goto L330;
        String r131 = r69.b;
        if (r71 != 0) goto L279;
        if (r130 == false) goto L278;
        int r132 = -1;
    L280:
        r21.put(r131, Integer.valueOf(r132));
        List<m.d> r133 = this.a;
        if (r133 == null) goto L293;
        Iterator<T> r134 = r133.iterator();
    L284:
        if (r134.hasNext() == false) goto L291;
        Object r135 = r134.next();
        if (((m.d) r135).c() != r71) goto L288;
        boolean r136 = true;
    L289:
        if (r136 == false) goto L284;
    L292:
        m.d r137 = (m.d) r135;
    L294:
        ch0.e r138 = a(r69.b);
        if (r138 == null) goto L302;
        ILinkPlayerInfoBridge r139 = r138.a;
        if (r139 == null) goto L302;
        IBaseUser r140 = r139.getUser();
        if (r140 == null) goto L302;
        String r141 = r140.getIdString();
        if (r141 == null) goto L302;
    L303:
        if (r137 == null) goto L324;
        Pair<Double, Double> r142 = e(r137);
        Pair<Double, Double> r143 = d(r137);
        double r144 = ((Number) r142.getFirst()).doubleValue();
        String r145 = r65;
        double r72 = ((Number) r142.getSecond()).doubleValue();
        r69.f = r144;
        r69.g = r72;
        if (r70 == false) goto L307;
        double r73 = ((Number) r143.getFirst()).doubleValue();
    L308:
        if (r70 == false) goto L310;
        double r146 = ((Number) r143.getSecond()).doubleValue();
    L311:
        r69.d = r73;
        r69.e = r146;
        if (r70 == false) goto L314;
        int r74 = 1;
    L315:
        r69.a = r74;
        r69.o = r137.g();
        r69.c(r141);
        r69.l = true;
        com.bytedance.live.datacontext.m r75 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r75 == null) goto L320;
        IRoom r76 = (IRoom) r75.getValue();
        if (r76 == null) goto L320;
        String r77 = r76.getOwnerUserIdString();
    L322:
        if (Intrinsics.areEqual(r77, r141) == false) goto L325;
        int r78 = com.bytedance.android.live.liveinteract.linkcast.a.a;
        com.bytedance.android.live.liveinteract.linkcast.a.C0037a.a(r69);
        int r79 = pi0.a.a;
        pi0.a.a(this.e, r69, this.g.getUiLayout());
    L325:
        List r80 = (List) this.f.f().getValue();
        if (r80 == null) goto L328;
        int r81 = r80.size();
    L329:
        com.bytedance.android.live.liveinteract.spatial.a.f(r69, r81, this.g.n(), r71);
    L331:
        r65 = r145;
        r66 = null;
        goto L271
    L328:
        r81 = 0;
    L320:
        r77 = null;
        goto L322
    L314:
        r74 = 2;
        goto L315
    L310:
        r146 = 1.0d;
        goto L311
    L307:
        r73 = 1.0d;
        goto L308
    L324:
        r145 = r65;
    L302:
        r141 = r65;
        goto L303
    L288:
        r136 = false;
        goto L289
    L291:
        r135 = r66;
        goto L292
    L293:
        r137 = r66;
        goto L294
    L278:
        r132 = 6;
        goto L280
    L279:
        r132 = r71 - 1;
        goto L280
    L330:
        r145 = r65;
        r69.f = 0.1d;
        r69.g = 0.1d;
        r69.d = 1.0d;
        r69.e = 1.0d;
        r69.l = false;
    L480:
        e.a r82 = e.c;
        Function0<cg6.a> r83 = new MultiLinkRegionUtils$mixStream$1(this);
        r82.getClass();
        e.a.g(r20, r83);
        e.a.f(r20, this.h);
        return;
    L333:
        if (f.m(Integer.valueOf(this.g.m()), Integer.valueOf(this.g.getUiLayout())) == false) goto L405;
        Iterator r84 = r20.iterator();
    L336:
        if (r84.hasNext() == false) goto L480;
        ti6.f r85 = (ti6.f) r84.next();
        boolean r86 = h(r85.b);
        int r87 = r23.b(r85.b);
        boolean r88 = r23.a(r85.b);
        r85.n = !r86;
        if (r87 >= 0) goto L339;
        r85.f = 0.1d;
        r85.g = 0.1d;
        r85.d = 1.0d;
        r85.e = 1.0d;
        r85.l = false;
        goto L336
    L339:
        String r89 = r85.b;
        if (r87 != 0) goto L354;
        if (r88 == false) goto L344;
        int r90 = -1;
    L355:
        r21.put(r89, Integer.valueOf(r90));
        List<m.d> r91 = this.a;
        if (r91 == null) goto L368;
        Iterator<T> r92 = r91.iterator();
    L359:
        if (r92.hasNext() == false) goto L366;
        Object r93 = r92.next();
        if (((m.d) r93).c() != r87) goto L363;
        boolean r147 = true;
    L364:
        if (r147 == false) goto L359;
    L367:
        m.d r94 = (m.d) r93;
    L369:
        ch0.e r95 = a(r85.b);
        if (r95 == null) goto L377;
        ILinkPlayerInfoBridge r96 = r95.a;
        if (r96 == null) goto L377;
        IBaseUser r97 = r96.getUser();
        if (r97 == null) goto L377;
        String r98 = r97.getIdString();
        if (r98 == null) goto L377;
    L378:
        if (r94 == null) goto L399;
        Pair<Double, Double> r148 = e(r94);
        Pair<Double, Double> r149 = d(r94);
        double r150 = ((Number) r148.getFirst()).doubleValue();
        double r151 = ((Number) r148.getSecond()).doubleValue();
        r85.f = r150;
        r85.g = r151;
        if (r86 == false) goto L382;
        double r152 = ((Number) r149.getFirst()).doubleValue();
    L383:
        if (r86 == false) goto L385;
        double r153 = ((Number) r149.getSecond()).doubleValue();
    L386:
        r85.d = r152;
        r85.e = r153;
        if (r86 == false) goto L389;
        int r99 = 1;
    L390:
        r85.a = r99;
        r85.o = r94.g();
        r85.c(r98);
        r85.l = true;
        com.bytedance.live.datacontext.m r100 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r100 == null) goto L395;
        IRoom r101 = (IRoom) r100.getValue();
        if (r101 == null) goto L395;
        String r102 = r101.getOwnerUserIdString();
    L397:
        if (Intrinsics.areEqual(r102, r98) == false) goto L399;
        int r103 = com.bytedance.android.live.liveinteract.linkcast.a.a;
        com.bytedance.android.live.liveinteract.linkcast.a.C0037a.a(r85);
        int r104 = pi0.a.a;
        pi0.a.a(this.e, r85, this.g.getUiLayout());
    L395:
        r102 = null;
        goto L397
    L389:
        r99 = 2;
        goto L390
    L385:
        r153 = 1.0d;
        goto L386
    L382:
        r152 = 1.0d;
    L399:
        List r105 = (List) this.f.f().getValue();
        if (r105 == null) goto L402;
        int r106 = r105.size();
    L403:
        com.bytedance.android.live.liveinteract.spatial.a.f(r85, r106, this.g.n(), r87);
        goto L336
    L402:
        r106 = 0;
    L377:
        r98 = r65;
        goto L378
    L363:
        r147 = false;
        goto L364
    L366:
        r93 = null;
        goto L367
    L368:
        r94 = null;
        goto L369
    L344:
        if (this.g.getUiLayout() == 109) goto L353;
        if (this.g.getUiLayout() == 111) goto L353;
        if (this.g.getUiLayout() == 112) goto L353;
        r90 = 6;
    L353:
        r90 = 8;
        goto L355
    L354:
        r90 = r87 - 1;
        goto L355
    L405:
        Integer r107 = Integer.valueOf(this.g.m());
        Integer r108 = Integer.valueOf(this.g.getUiLayout());
        if (r108 == null) goto L408;
        int r109 = r108.intValue();
    L410:
        if (aj0.b.c(r109) == false) goto L413;
    L411:
        boolean r154 = true;
    L416:
        if (r154 == false) goto L419;
        l(r20, r21, r22, r23);
        goto L480
    L419:
        if (f.g(Integer.valueOf(this.g.m()), Integer.valueOf(this.g.getUiLayout())) == false) goto L422;
        k(r20, r21, r23);
        goto L480
    L422:
        if (f.h(Integer.valueOf(this.g.m()), Integer.valueOf(this.g.getUiLayout())) == false) goto L424;
        k(r20, r21, r23);
        goto L480
    L424:
        Iterator r155 = r20.iterator();
    L426:
        if (r155.hasNext() == false) goto L480;
        ti6.f r156 = (ti6.f) r155.next();
        boolean r157 = h(r156.b);
        int r158 = r23.b(r156.b);
        r156.n = !r157;
        if (r158 >= 0) goto L429;
        r156.f = 0.1d;
        r156.g = 0.1d;
        r156.d = 1.0d;
        r156.e = 1.0d;
        r156.l = false;
        goto L426
    L429:
        r21.put(r156.b, Integer.valueOf(r158));
        List<m.d> r159 = this.a;
        if (r159 == null) goto L442;
        Iterator<T> r160 = r159.iterator();
    L433:
        if (r160.hasNext() == false) goto L440;
        Object r161 = r160.next();
        if (((m.d) r161).c() != r158) goto L437;
        boolean r162 = true;
    L438:
        if (r162 == false) goto L433;
    L441:
        m.d r163 = (m.d) r161;
    L443:
        ch0.e r164 = a(r156.b);
        if (r164 == null) goto L451;
        ILinkPlayerInfoBridge r165 = r164.a;
        if (r165 == null) goto L451;
        IBaseUser r166 = r165.getUser();
        if (r166 == null) goto L451;
        String r167 = r166.getIdString();
        if (r167 == null) goto L451;
    L452:
        if (r163 == null) goto L474;
        Pair<Double, Double> r168 = e(r163);
        Pair<Double, Double> r169 = d(r163);
        double r170 = ((Number) r168.getFirst()).doubleValue();
        double r171 = ((Number) r168.getSecond()).doubleValue();
        r156.f = r170;
        r156.g = r171;
        if (r157 == false) goto L456;
        double r172 = ((Number) r169.getFirst()).doubleValue();
    L457:
        if (r157 == false) goto L459;
        double r173 = ((Number) r169.getSecond()).doubleValue();
    L460:
        r156.d = r172;
        r156.e = r173;
        if (r157 == false) goto L463;
        int r174 = 1;
    L464:
        r156.a = r174;
        r156.c(r167);
        r156.l = true;
        com.bytedance.live.datacontext.m r175 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r175 == null) goto L469;
        IRoom r176 = (IRoom) r175.getValue();
        if (r176 == null) goto L469;
        String r177 = r176.getOwnerUserIdString();
    L471:
        if (Intrinsics.areEqual(r177, r167) == false) goto L474;
        int r178 = com.bytedance.android.live.liveinteract.linkcast.a.a;
        com.bytedance.android.live.liveinteract.linkcast.a.C0037a.a(r156);
    L469:
        r177 = null;
        goto L471
    L463:
        r174 = 2;
        goto L464
    L459:
        r173 = 1.0d;
        goto L460
    L456:
        r172 = 1.0d;
    L474:
        List r179 = (List) this.f.f().getValue();
        if (r179 == null) goto L477;
        int r180 = r179.size();
    L478:
        com.bytedance.android.live.liveinteract.spatial.a.f(r156, r180, this.g.n(), r158);
        goto L426
    L477:
        r180 = 0;
    L451:
        r167 = r65;
        goto L452
    L437:
        r162 = false;
        goto L438
    L440:
        r161 = null;
        goto L441
    L442:
        r163 = null;
        goto L443
    L413:
        if (aj0.b.b(r107) == true) goto L411;
        r154 = false;
        goto L416
    L408:
        r109 = 0;
        goto L410
    }

    public final void l(List<ti6.f> r18, Map<String, Integer> r19, Map<String, ? extends Object> r20, wh0.a r21) {
        Iterator<ti6.f> r3 = r18.iterator();
    L4:
        if (r3.hasNext() == false) goto L63;
        ti6.f r4 = r3.next();
        boolean r5 = h(r4.b);
        int r6 = r21.b(r4.b);
        r4.n = !r5;
        if (aj0.b.a(r21.b(r4.b), this.g.getUiLayout()) == false) goto L8;
        r4.A = true;
    L8:
        Object r11 = null;
        if (r6 < 0) goto L59;
        r19.put(r4.b, Integer.valueOf(r6));
        List<m.d> r12 = this.a;
        if (r12 == null) goto L23;
        Iterator<T> r13 = r12.iterator();
    L14:
        if (r13.hasNext() == false) goto L21;
        Object r14 = r13.next();
        if (((m.d) r14).c() != r6) goto L18;
        boolean r15 = true;
    L19:
        if (r15 == false) goto L14;
    L22:
        m.d r16 = (m.d) r14;
    L24:
        ch0.e r17 = a(r4.b);
        if (r17 == null) goto L32;
        ILinkPlayerInfoBridge r110 = r17.a;
        if (r110 == null) goto L32;
        IBaseUser r111 = r110.getUser();
        if (r111 == null) goto L32;
        String r112 = r111.getIdString();
        if (r112 == null) goto L32;
    L33:
        if (r16 == null) goto L54;
        Pair<Double, Double> r113 = e(r16);
        Pair<Double, Double> r114 = d(r16);
        double r9 = ((Number) r113.getFirst()).doubleValue();
        double r7 = ((Number) r113.getSecond()).doubleValue();
        r4.f = r9;
        r4.g = r7;
        if (r5 == false) goto L37;
        double r8 = ((Number) r114.getFirst()).doubleValue();
    L38:
        if (r5 == false) goto L40;
        double r10 = ((Number) r114.getSecond()).doubleValue();
    L41:
        r4.d = r8;
        r4.e = r10;
        if (r5 == false) goto L44;
        int r22 = 1;
    L45:
        r4.a = r22;
        r4.c(r112);
        r4.l = true;
        com.bytedance.live.datacontext.m r23 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r23 == null) goto L50;
        IRoom r24 = (IRoom) r23.getValue();
        if (r24 == null) goto L50;
        String r25 = r24.getOwnerUserIdString();
    L52:
        if (Intrinsics.areEqual(r25, r112) == false) goto L54;
        int r26 = com.bytedance.android.live.liveinteract.linkcast.a.a;
        com.bytedance.android.live.liveinteract.linkcast.a.C0037a.a(r4);
    L50:
        r25 = null;
        goto L52
    L44:
        r22 = 2;
        goto L45
    L40:
        r10 = 1.0d;
        goto L41
    L37:
        r8 = 1.0d;
    L54:
        List r27 = (List) this.f.f().getValue();
        if (r27 == null) goto L57;
        int r28 = r27.size();
    L58:
        com.bytedance.android.live.liveinteract.spatial.a.f(r4, r28, this.g.n(), r6);
    L60:
        if (r20 == null) goto L62;
        r11 = r20.get("mcu_client_mix");
    L62:
        boolean r29 = Intrinsics.areEqual(r11, Boolean.TRUE);
        LinkRoomFightContext.Companion.getClass();
        LinkRoomFightContext.a.b(r4, r29);
        goto L4
    L57:
        r28 = 0;
    L32:
        r112 = "";
        goto L33
    L18:
        r15 = false;
        goto L19
    L21:
        r14 = null;
        goto L22
    L23:
        r16 = null;
        goto L24
    L59:
        r4.f = 0.1d;
        r4.g = 0.1d;
        r4.d = 1.0d;
        r4.e = 1.0d;
        r4.l = false;
        goto L60
    }
}
