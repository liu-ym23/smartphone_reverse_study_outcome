package wn0;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.animation.InteractAnimationController;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.g;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.h;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.i;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.u;
import com.bytedance.android.live.liveinteract.plantform.multiroom.e;
import com.bytedance.android.live.liveinteract.plantform.utils.x;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.live.liveinteract.utils.MultiSceneEnterRoomStatisticsUtils;
import com.bytedance.android.livesdk.config.h30;
import com.bytedance.android.livesdkapi.util.IMultiSceneCommonStatistics;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.j;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import tf0.o;
import vm2.d;
import zj0.c;
import zj0.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements g {
    public final /* synthetic */ a a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ c c;
    public final /* synthetic */ long d;
    public final /* synthetic */ int e;
    public final /* synthetic */ List f;

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.g
    public final void b(h r10) {
        Intrinsics.checkNotNullParameter(r10, "request");
        f2.g();
        Map r0 = d.M0().c();
        if (r0 != null) goto L5;
    L9:
        int r1 = 27;
    L11:
        if (d.T0() == false) goto L17;
        int r2 = r10.a;
        if (r2 == 0) goto L18;
        if (r2 == r1) goto L19;
        ALogger.i("ttlive_link_audio_layout", "loadLayoutConfigFailed try to load 1v8, uiLayout=" + r10.a + ", traceInfo=" + r10.c.a + ", targetUiLayout=" + r1);
        a.d(this.a, new c.f(r1), this.f, null, true, null, 20);
        return;
    L19:
        return;
    L18:
        return;
    L17:
        return;
    L5:
        if (r0.containsKey(Integer.valueOf(r10.a)) != true) goto L9;
        Integer r3 = (Integer) r0.get(Integer.valueOf(r10.a));
        if (r3 == null) goto L9;
        r1 = r3.intValue();
        goto L11
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.g
    public final void a(h r23, i r24) {
        Intrinsics.checkNotNullParameter(r23, "request");
        Intrinsics.checkNotNullParameter(r24, "response");
        r24.a.c = this.b;
        Lazy r2 = MultiLinkLoadWidgetUtils.a;
        MultiLinkLoadWidgetUtils.m(this.a.i, "VoiceLayoutSwitcher", "load layoutConfig success, switchType = " + this.c + ", spend time = " + (System.currentTimeMillis() - this.d));
        int r3 = MultiSceneEnterRoomStatisticsUtils.u;
        MultiSceneEnterRoomStatisticsUtils r4 = MultiSceneEnterRoomStatisticsUtils.a.a(this.a.i, 0L);
        if (r4 == null) goto L5;
        IMultiSceneCommonStatistics.DefaultImpls.recordSubElementShow$default(r4, "native_receive_layout_config", 0, 2, null);
    L5:
        f.b r5 = new f.b(this.e, r24.a.getUiLayout(), r24.a.m(), this.f, 8);
        a r9 = this.a;
        c r10 = this.c;
        List r11 = this.f;
        r9.getClass();
        boolean r6 = gh0.b.a;
        gh0.b.a("SceneOrUiLayoutChange", "do switchLayout from: " + r9.c + ", to: " + r5 + " by " + r10, false);
        TalkRoomBusinessFullLinkMonitor r7 = TalkRoomBusinessFullLinkMonitor.a;
        String r8 = String.valueOf(r5);
        f r12 = r9.c;
        o r13 = null;
        if (r12 == null) goto L8;
        String r14 = r12.toString();
    L9:
        String r15 = r10.toString();
        r7.getClass();
        TalkRoomBusinessFullLinkMonitor.B0(r8, r14, r15);
        f r16 = r9.c;
        Class<? extends o> r17 = r5.f;
        if (r16 == null) goto L12;
        Class<? extends o> r18 = r16.f;
    L13:
        Intrinsics.areEqual(r17, r18);
        f r19 = r9.c;
        List<Integer> r20 = r24.a.e;
        if ((r19 instanceof f.b) == true) goto L16;
    L52:
        boolean r21 = false;
    L54:
        if (r21 == false) goto L58;
        ALogger.e("ttlive_link_audio_layout", "switchLayout failed: already same layout, " + r10 + " current:" + r9.c);
        if (r9.c != null) goto L111;
        ALogger.e("ttlive_link_audio_layout", "ensure EmptyWindowManager " + a.c() + ", " + r10);
        int r1 = x.a;
        x.F0(String.valueOf(a.c()), "null", r10.toString());
        r9.c = f.a.i;
        r9.j.h4(new zj0.a());
        return;
    L111:
        return;
    L58:
        ALogger.e("ttlive_link_audio_layout", "do switchLayout from:" + r9.c + " to:" + r5 + " by " + r10);
        j r22 = m.d().s();
        if (r22 == null) goto L70;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r25 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r22.getValue();
        if (r25 == null) goto L70;
        f r26 = r9.c;
        if (r26 == null) goto L65;
        int r110 = r26.a;
    L66:
        if (r26 == null) goto L68;
        int r111 = r26.b;
    L69:
        r25.c(new com.bytedance.android.livesdk.chatroom.viewmodel.i(r110, r111, r9.g, false, false, null, 56));
        goto L70
    L68:
        r111 = 0;
        goto L69
    L65:
        r110 = 0;
    L70:
        r9.j.Ef(r9.c, r5, r9.g, r11, r10);
        InteractAnimationController r27 = r9.k;
        if (r27 == null) goto L73;
        r27.m();
    L73:
        o r28 = r9.h;
        if (r28 == null) goto L76;
        r28.end();
    L76:
        r9.j.h5();
        r9.e = r9.c;
        r9.c = r5;
        r9.d = r24.a.e;
        if (r11 != null) goto L79;
    L81:
        int r29 = r5.a;
        int r30 = r5.b;
        LinkedHashMap r31 = new LinkedHashMap();
        r31.put("reason", "try_switch_layout");
        Unit r32 = Unit.INSTANCE;
        com.bytedance.android.live.liveinteract.plantform.utils.i.c(r29, r30, r31);
        if (MultiLinkLoadWidgetUtils.g() == false) goto L88;
        DataCenter r33 = r9.i;
        if (r33 == null) goto L88;
        com.bytedance.android.live.liveinteract.plantform.multiroom.a r34 = e.a(r33);
        if (r34 == null) goto L88;
        r34.qd(r24.a);
    L88:
        Function3<Class<? extends o>, c, i, o> r35 = r9.b.get(r5.f);
        if (r35 == null) goto L91;
        r13 = (o) r35.invoke(r5.f, r10, r24);
    L91:
        if (r13 != null) goto L93;
        ALogger.e("ttlive_link_video_layout", "createEmptyWindowManager " + r5);
        int r36 = x.a;
        x.F0(String.valueOf(a.c()), String.valueOf(r9.c), r5.toString());
        r13 = new zj0.a();
    L93:
        a.c r37 = r9.j;
        Intrinsics.checkNotNull(r13);
        r37.h4(r13);
        r9.h = r13;
        if ((r13 instanceof InteractAnimationController.d) == false) goto L98;
        InteractAnimationController r38 = r9.k;
        if (r38 == null) goto L98;
        r38.g((InteractAnimationController.d) r13);
    L98:
        o r39 = r9.h;
        if (r39 == null) goto L101;
        r39.l(r10 instanceof c.C0300c, r9.j.D3(), r9.j.x3());
    L101:
        r9.j.Lk(r9.e, r5, r9.f, r9.g, r10);
        if (r11 != null) goto L104;
        return;
    L104:
        if (r11.contains(7) == true) goto L114;
        j r40 = m.d().s();
        if (r40 == null) goto L115;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r41 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r40.getValue();
        if (r41 == null) goto L116;
        r41.d(new com.bytedance.android.livesdk.chatroom.viewmodel.i(r5.a, r5.b, r9.g, false, false, r41.t().a(), 24));
        return;
    L116:
        return;
    L115:
        return;
    L114:
        return;
    L79:
        if ((!Intrinsics.areEqual(r9.g, r11)) == false) goto L81;
        ((ArrayList) r9.f).clear();
        ((ArrayList) r9.f).addAll(r9.g);
        ((ArrayList) r9.g).clear();
        ((ArrayList) r9.g).addAll(r11);
        goto L81
    L16:
        if (((Boolean) h30.a.getValue()).booleanValue() == false) goto L40;
        if (r5.b != r19.b) goto L52;
        List<Integer> r42 = r5.h;
        if (r42 == null) goto L22;
        List r43 = CollectionsKt.sorted(r42);
    L23:
        List<Integer> r44 = r19.h;
        if (r44 == null) goto L26;
        List r45 = CollectionsKt.sorted(r44);
    L28:
        if (Intrinsics.areEqual(r43, r45) == false) goto L52;
        if (r20 == null) goto L31;
        List r46 = CollectionsKt.sorted(r20);
    L32:
        List<Integer> r47 = r9.d;
        if (r47 == null) goto L35;
        List r48 = CollectionsKt.sorted(r47);
    L37:
        if (Intrinsics.areEqual(r46, r48) == false) goto L52;
    L51:
        r21 = true;
        goto L54
    L35:
        r48 = null;
        goto L37
    L31:
        r46 = null;
        goto L32
    L26:
        r45 = null;
        goto L28
    L22:
        r43 = null;
        goto L23
    L40:
        if (r5.b != r19.b) goto L52;
        List<Integer> r49 = r5.h;
        if (r49 == null) goto L44;
        List r50 = CollectionsKt.sorted(r49);
    L45:
        List<Integer> r51 = r19.h;
        if (r51 == null) goto L48;
        List r52 = CollectionsKt.sorted(r51);
    L50:
        if (Intrinsics.areEqual(r50, r52) == false) goto L52;
    L48:
        r52 = null;
        goto L50
    L44:
        r50 = null;
        goto L45
    L12:
        r18 = null;
        goto L13
    L8:
        r14 = null;
        goto L9
    }

    public b(a r1, boolean r2, c r3, long r4, u r6, int r7, List r8) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r7;
        this.f = r8;
    }
}
