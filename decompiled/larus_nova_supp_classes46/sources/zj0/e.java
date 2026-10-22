package zj0;

import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.animation.InteractAnimationController;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.g;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.h;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.i;
import com.bytedance.android.live.liveinteract.plantform.utils.x;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.live.liveinteract.utils.MultiSceneEnterRoomStatisticsUtils;
import com.bytedance.android.live.liveinteract.videotalk.utils.b0;
import com.bytedance.android.livesdk.chatroom.interact.model.d0;
import com.bytedance.android.livesdk.chatroom.interact.model.e0;
import com.bytedance.android.livesdk.chatroom.u;
import com.bytedance.android.livesdk.chatroom.viewmodel.k;
import com.bytedance.android.livesdk.config.h30;
import com.bytedance.android.livesdk.config.pb0;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.android.livesdkapi.util.IMultiSceneCommonStatistics;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import tf0.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e {
    public final HashSet<d> a;
    public final HashMap<Class<? extends o>, Function3<Class<? extends o>, zj0.c, i, o>> b;
    public final ArrayList<zj0.b> c;
    public d d;
    public List<Integer> e;
    public d f;
    public final List<Integer> g;
    public final List<Integer> h;
    public o i;
    public final DataCenter j;
    public final ViewGroup k;
    public final u l;
    public final b m;
    public final InteractAnimationController n;

    public static final class a {
    }

    public interface b extends zj0.b {
        void h4(o r1);

        void h5();
    }

    public static final class c implements g {
        public final /* synthetic */ e a;
        public final /* synthetic */ long b;
        public final /* synthetic */ zj0.c c;
        public final /* synthetic */ int d;
        public final /* synthetic */ List e;

        @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.g
        public final void b(h r2) {
            Intrinsics.checkNotNullParameter(r2, "request");
            f2.g();
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.g
        public final void a(h r19, i r20) {
            Intrinsics.checkNotNullParameter(r19, "request");
            Intrinsics.checkNotNullParameter(r20, "response");
            boolean r3 = gh0.b.a;
            gh0.b.a("SceneOrUiLayoutChange", "switch_layout spend time: " + (System.currentTimeMillis() - this.b), false);
            Lazy r4 = MultiLinkLoadWidgetUtils.a;
            MultiLinkLoadWidgetUtils.m(this.a.j, "LayoutSwitcher", "load LayoutConfig success, switchType = " + this.c + ", spend time = " + (System.currentTimeMillis() - this.b));
            int r5 = MultiSceneEnterRoomStatisticsUtils.u;
            MultiSceneEnterRoomStatisticsUtils r7 = MultiSceneEnterRoomStatisticsUtils.a.a(this.a.j, 0L);
            if (r7 == null) goto L5;
            IMultiSceneCommonStatistics.DefaultImpls.recordSubElementShow$default(r7, "native_receive_layout_config", 0, 2, null);
        L5:
            d.b r6 = new d.b(this.d, r20.a.getUiLayout(), r20.a.m(), 0, r20.a.f(), 8);
            e r12 = this.a;
            zj0.c r13 = this.c;
            List r14 = this.e;
            r12.getClass();
            Intrinsics.checkNotNullParameter(r13, "switchType");
            Intrinsics.checkNotNullParameter(r20, "response");
            gh0.b.a("SceneOrUiLayoutChange", "do switchLayout from: " + r12.d + ", to: " + r6 + " by " + r13, false);
            TalkRoomBusinessFullLinkMonitor r2 = TalkRoomBusinessFullLinkMonitor.a;
            String r8 = String.valueOf(r6);
            d r9 = r12.d;
            o r15 = null;
            if (r9 == null) goto L8;
            String r10 = r9.toString();
        L9:
            String r11 = r13.toString();
            r2.getClass();
            TalkRoomBusinessFullLinkMonitor.B0(r8, r10, r11);
            d r16 = r12.d;
            Class<? extends o> r17 = r6.f;
            if (r16 == null) goto L12;
            Class<? extends o> r18 = r16.f;
        L13:
            Intrinsics.areEqual(r17, r18);
            d r21 = r12.d;
            List<Integer> r22 = r20.a.e;
            if ((r21 instanceof d.b) == true) goto L16;
        L36:
            boolean r23 = false;
        L38:
            if (r23 == false) goto L42;
            ALogger.e("ttlive_link_video_layout", "switchLayout failed: already same layout, " + r13 + " current:" + r12.d);
            if (r12.d != null) goto L115;
            ALogger.e("ttlive_link_video_layout", "ensure EmptyWindowManager " + r12.b() + ", " + r13);
            int r1 = x.a;
            x.F0(String.valueOf(r12.b()), "null", r13.toString());
            r12.d = d.a.h;
            r12.m.h4(new zj0.a());
            return;
        L115:
            return;
        L42:
            d r24 = r12.d;
            List<Integer> r25 = r12.h;
            if ((r24 instanceof d.b) == true) goto L45;
        L53:
            boolean r26 = false;
        L55:
            if (r26 == false) goto L59;
            ALogger.e("ttlive_link_video_layout", "dynamicEqualUILayoutChange, from:" + r12.d + " to:" + r6 + " by " + r13);
            r12.f = r12.d;
            r12.d = r6;
            o r27 = r12.i;
            if (r27 == null) goto L119;
            r27.r(r20.a, Boolean.FALSE);
            return;
        L119:
            return;
        L59:
            ALogger.e("ttlive_link_video_layout", "do switchLayout from:" + r12.d + " to:" + r6 + " by " + r13);
            j r28 = m.d().getVideoTalkRoomSubScene();
            if (r28 == null) goto L71;
            com.bytedance.android.livesdk.chatroom.viewmodel.e r29 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r28.getValue();
            if (r29 == null) goto L71;
            d r30 = r12.d;
            if (r30 == null) goto L66;
            int r31 = r30.a;
        L67:
            if (r30 == null) goto L69;
            int r32 = r30.b;
        L70:
            r29.f(new k(r31, r32, false, 4));
            goto L71
        L69:
            r32 = 0;
            goto L70
        L66:
            r31 = 0;
        L71:
            r12.m.Ic(r12.d, r6, r12.h, r14, r13);
            Iterator<zj0.b> r110 = r12.c.iterator();
        L73:
            if (r110.hasNext() == false) goto L75;
            r110.next().Ic(r12.d, r6, r12.h, r14, r13);
            goto L73
        L75:
            r12.n.m();
            o r33 = r12.i;
            if (r33 == null) goto L78;
            r33.end();
        L78:
            r12.m.h5();
            r12.f = r12.d;
            r12.d = r6;
            r12.e = r20.a.e;
            if (r14 != null) goto L81;
        L83:
            int r34 = r6.a;
            int r35 = r6.b;
            LinkedHashMap r36 = new LinkedHashMap();
            r36.put("reason", "try_switch_layout");
            Unit r37 = Unit.INSTANCE;
            com.bytedance.android.live.liveinteract.plantform.utils.i.c(r34, r35, r36);
            if (MultiLinkLoadWidgetUtils.g() == false) goto L91;
            DataCenter r38 = r12.j;
            if (r38 == null) goto L91;
            com.bytedance.android.live.liveinteract.plantform.multiroom.a r39 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.a(r38);
            if (r39 == null) goto L91;
            r39.qd(r20.a);
        L91:
            if (MultiLinkLoadWidgetUtils.g() == false) goto L95;
            int r40 = vd0.a.g;
            vd0.a r41 = vd0.a.C0284a.a(r12.j);
            int r42 = r20.a.f();
            wd0.b r43 = r41.c;
            if (r43.h == r42) goto L95;
            r43.h = r42;
            r41.d.a(r43, r41.a, r41.b);
        L95:
            Function3<Class<? extends o>, zj0.c, i, o> r44 = r12.b.get(r6.f);
            if (r44 == null) goto L98;
            r15 = (o) r44.invoke(r6.f, r13, r20);
        L98:
            if (r15 != null) goto L100;
            ALogger.e("ttlive_link_video_layout", "createEmptyWindowManager " + r6);
            int r45 = x.a;
            x.F0(String.valueOf(r12.b()), String.valueOf(r12.d), r6.toString());
            r15 = new zj0.a();
        L100:
            b r46 = r12.m;
            Intrinsics.checkNotNull(r15);
            r46.h4(r15);
            r12.i = r15;
            if ((r15 instanceof InteractAnimationController.d) == false) goto L103;
            r12.n.g((InteractAnimationController.d) r15);
        L103:
            o r47 = r12.i;
            if (r47 == null) goto L106;
            r47.l(r13 instanceof zj0.c.C0300c, r12.m.D3(), r12.m.x3());
        L106:
            r12.m.Jm(r12.f, r6, r12.g, r12.h, r13);
            j r48 = m.d().getVideoTalkRoomSubScene();
            if (r48 == null) goto L111;
            com.bytedance.android.livesdk.chatroom.viewmodel.e r49 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r48.getValue();
            if (r49 == null) goto L111;
            r49.g(new k(r6.a, r6.b, false, 4));
        L111:
            Iterator<zj0.b> r50 = r12.c.iterator();
        L113:
            if (r50.hasNext() == false) goto L121;
            r50.next().Jm(r12.d, r6, r12.g, r12.h, r13);
            goto L113
        L121:
            return;
        L81:
            if ((!Intrinsics.areEqual(r12.h, r14)) == false) goto L83;
            ((ArrayList) r12.g).clear();
            ((ArrayList) r12.g).addAll(r12.h);
            ((ArrayList) r12.h).clear();
            ((ArrayList) r12.h).addAll(r14);
            goto L83
        L45:
            if (e0.a(r6.b) == false) goto L53;
            if (e0.a(r24.b) == false) goto L53;
            if (d0.e(r14) == false) goto L53;
            if (d0.e(r25) == false) goto L53;
            r26 = true;
            goto L55
        L16:
            if (((Boolean) h30.a.getValue()).booleanValue() == false) goto L32;
            if (r6.b != r21.b) goto L36;
            if (r6.g != r21.g) goto L36;
            if (r22 == null) goto L23;
            List r51 = CollectionsKt.sorted(r22);
        L24:
            List<Integer> r52 = r12.e;
            if (r52 == null) goto L27;
            List r53 = CollectionsKt.sorted(r52);
        L29:
            if (Intrinsics.areEqual(r51, r53) == false) goto L36;
        L35:
            r23 = true;
            goto L38
        L27:
            r53 = null;
            goto L29
        L23:
            r51 = null;
            goto L24
        L32:
            if (r6.b != r21.b) goto L36;
            if (r6.g != r21.g) goto L36;
        L12:
            r18 = null;
            goto L13
        L8:
            r10 = null;
            goto L9
        }

        public c(e r1, long r2, zj0.c r4, com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.u r5, int r6, List r7) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
            this.d = r6;
            this.e = r7;
        }
    }

    static {
    }

    public final int a() {
        d r0 = this.d;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.b;
    }

    public final com.bytedance.android.livesdk.chatroom.viewmodel.j b() {
        u r0 = this.l;
        if (r0 == null) goto L9;
        j r1 = r0.getVideoTalkRoomSubScene();
        if (r1 == null) goto L9;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r2 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r1.getValue();
        if (r2 == null) goto L9;
        return r2.t();
    L9:
        return null;
    }

    public final boolean e(SeiAppData r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "seiAppData");
        d r1 = this.d;
        if (r1 == null) goto L22;
        Intrinsics.checkNotNullParameter(r6, "seiAppData");
        if (r1.c == r6.getVersion()) goto L7;
        return false;
    L7:
        if (r1.d != r6.getStyle()) goto L18;
        if (r1.c != 12) goto L18;
        if (r7 == 9) goto L15;
        if (r1.b != 9) goto L18;
    L15:
        if (r7 != r1.b) goto L24;
    L16:
        return true;
    L24:
        return false;
    L18:
        if (r1.d == r6.getStyle()) goto L16;
        if (r1.d == (-2)) goto L16;
        return false;
    L22:
        return false;
    }

    public final boolean d(int r5, Integer r6, List<Integer> r7) {
        Intrinsics.checkNotNullParameter(r7, "playModes");
        if (r6 != null) goto L11;
        d r8 = this.d;
        if (r8 == null) goto L7;
        int r9 = r8.a;
    L8:
        if (r5 != r9) goto L34;
        return true;
    L34:
        return false;
    L7:
        r9 = 0;
        goto L8
    L11:
        int r10 = r6.intValue();
        Intrinsics.checkNotNullParameter(r7, "curPlayModes");
        d r2 = this.d;
        if (r2 != null) goto L14;
        return false;
    L14:
        if (r5 == r2.a) goto L16;
        return false;
    L16:
        if (r10 == r2.b) goto L18;
        return false;
    L18:
        if (r10 == 5) goto L21;
        if (r10 == 1) goto L21;
    L24:
        if (r10 == 7) goto L28;
        if (r10 == 2) goto L28;
    L30:
        boolean r11 = false;
    L31:
        if (r11 == false) goto L38;
        return true;
    L38:
        return false;
    L28:
        if (d0.e(r7) == false) goto L30;
    L29:
        r11 = true;
    L21:
        if (d0.e(r7) == true) goto L24;
        goto L29
    }

    public final void f(zj0.c r25, List<Integer> r26, ClientUIInfo r27) {
        Intrinsics.checkNotNullParameter(r25, "switchType");
        ln0.a r0 = yg0.h.a;
        Pair r1 = yg0.h.c(r25);
        int r6 = ((Number) r1.getFirst()).intValue();
        int r10 = ((Number) r1.getSecond()).intValue();
        if (((Boolean) pb0.a.getValue()).booleanValue() == true) goto L5;
    L10:
        DataCenter r2 = this.j;
        if (r2 == null) goto L15;
        Boolean r3 = (Boolean) r2.get("status_bar_is_visible", Boolean.TRUE);
        if (r3 == null) goto L15;
        boolean r13 = r3.booleanValue();
    L16:
        long r14 = System.currentTimeMillis();
        tf0.m r4 = b0.b();
        if ((r4 instanceof com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.u) == true) goto L19;
        r4 = null;
    L19:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.u r5 = (com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.u) r4;
        if (r5 == null) goto L22;
        r5.d = r14;
    L22:
        if (r5 == null) goto L24;
        r5.a = false;
    L24:
        int r11 = yg0.h.h(false, 0, r10);
        int r7 = this.m.Rm();
        boolean r8 = gh0.a.d();
        Triple r12 = new Triple(0, 0, "VideoTalkLayoutSwitcher#trySwitchLayout, with switchType = " + r25);
        if (r27 == null) goto L27;
        List r18 = r27.getUiFeatureList();
    L28:
        yg0.h.k(new h(r10, r11, null, r13, r7, r8, null, r12, r18, null, this.j, 580), new c(this, r14, r25, r5, r6, r26), null);
        return;
    L27:
        r18 = null;
    L15:
        r13 = true;
        goto L16
    L5:
        if (Intrinsics.areEqual(m.i().isAnchor(), Boolean.FALSE) == false) goto L10;
        if (StatusBarUtil.isStatusBarTransparent() == false) goto L15;
        r13 = false;
        goto L16
    }

    public final boolean c(int r4, int r5, List<Integer> r6, List<Integer> r7) {
        Intrinsics.checkNotNullParameter(r6, "oldPlayModes");
        Intrinsics.checkNotNullParameter(r7, "newPlayModes");
        d r0 = this.d;
        if (r0 == null) goto L17;
        if (r0 != null) goto L6;
        return false;
    L6:
        if (r4 != r0.a) goto L19;
        if (r0 != null) goto L9;
        return false;
    L9:
        if (r5 == r0.b) goto L11;
        return false;
    L11:
        if (d0.e(r6) != d0.e(r7)) goto L13;
        boolean r8 = true;
    L14:
        if (r8 == false) goto L22;
        return true;
    L22:
        return false;
    L13:
        r8 = false;
        goto L14
    L19:
        return false;
    L17:
        return false;
    }

    public e(DataCenter r2, ViewGroup r3, u r4, b r5, InteractAnimationController r6) {
        Intrinsics.checkNotNullParameter(r5, "callback");
        Intrinsics.checkNotNullParameter(r6, "mAnimationController");
        this.j = r2;
        this.k = r3;
        this.l = r4;
        this.m = r5;
        this.n = r6;
        this.a = new HashSet();
        this.b = new HashMap();
        this.c = new ArrayList();
        this.g = new ArrayList();
        this.h = new ArrayList();
    }
}
