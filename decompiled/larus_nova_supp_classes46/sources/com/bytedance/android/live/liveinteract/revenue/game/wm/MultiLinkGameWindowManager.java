package com.bytedance.android.live.liveinteract.revenue.game.wm;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.data.i;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.broadcastgame.api.xplay.n;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.z0;
import com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.l;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.m;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.CommonMultiLinkWindowManager;
import com.bytedance.android.live.liveinteract.plantform.datamerge.LinkMicGameWindowHelper;
import com.bytedance.android.live.liveinteract.plantform.datamerge.k;
import com.bytedance.android.live.liveinteract.plantform.datamergev2.LinkMicGameWindowHelperV2;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.s0;
import com.bytedance.android.live.liveinteract.revenue.game.LinkMicGameContext;
import com.bytedance.android.live.liveinteract.revenue.game.LinkMicGameWidget;
import com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.LinkRoomFightContext;
import com.bytedance.android.live.liveinteract.utils.EPointF;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.link.model.bridge.g2;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdkapi.model.MultiLinkFrequencyOptConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import hg6.g;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.BehaviorSubject;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ri0.d;
import ri0.e;
import ri0.f;
import sh0.h0;
import sh0.i0;
import sh0.j0;
import tf0.j;
import tf0.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/game/wm/MultiLinkGameWindowManager;", "Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/wm/CommonMultiLinkWindowManager;", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiLinkGameWindowManager extends CommonMultiLinkWindowManager {
    public static final /* synthetic */ int b1 = 0;
    public final ri0.b H0;
    public final ri0.c L0;
    public long P0;
    public boolean V0;
    public final eh0.b X;
    public boolean Y;
    public String Z;
    public oi0.a k0;
    public final CompositeDisposable p0;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ MultiLinkGameWindowManager a;

        public b(MultiLinkGameWindowManager r1) {
            this.a = r1;
        }

        public final void onChanged(Object r6) {
            KVData r7 = (KVData) r6;
            if (r7 == null) goto L5;
            Object r0 = r7.getData();
        L6:
            if (r0 == null) goto L12;
            Object r8 = r7.getData();
            if (r8 == null) goto L11;
            boolean r9 = ((Boolean) r8).booleanValue();
        L13:
            ALogger.i("MultiLinkGameWindowManager", "TalkRoomStore#is_mic_seat_fold change from " + this.a.Y + " to " + r9);
            MultiLinkGameWindowManager r1 = this.a;
            if (r1.Y == r9) goto L17;
            ALogger.i("MultiLinkGameWindowManager", "updateLayoutConfigIfNeed, targetIsMicSeatStash: " + r9);
            r1.Y = r9;
            int r2 = qi0.b.a;
            qi0.b.a(r9, r1.d0(), r1.c0(), r1.C, new f(r1));
        L17:
            this.a.getClass();
            g r10 = BaseMultiLinkWindowManager.h0(true);
            if (r10 == null) goto L21;
            r10.f();
            return;
        L21:
            return;
        L11:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
        L12:
            r9 = false;
            goto L13
        L5:
            r0 = null;
            goto L6
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ MultiLinkGameWindowManager a;

        public c(MultiLinkGameWindowManager r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            KVData r4 = (KVData) r3;
            if (r4 == null) goto L5;
            Object r0 = r4.getData();
        L6:
            if (r0 == null) goto L12;
            Object r5 = r4.getData();
            if (r5 == null) goto L11;
            String r6 = (String) r5;
        L13:
            ALogger.i("MultiLinkGameWindowManager", "TalkRoomStore#visibleGuestUid change from " + this.a.Z + " to " + r6);
            this.a.Z = r6;
            g r7 = BaseMultiLinkWindowManager.h0(true);
            if (r7 == null) goto L17;
            r7.f();
            return;
        L17:
            return;
        L11:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        L12:
            r6 = "";
            goto L13
        L5:
            r0 = null;
            goto L6
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager
    public final boolean A0() {
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager
    public final void J0() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager
    public final com.bytedance.android.live.liveinteract.plantform.datamerge.a a1() {
        List<m.d> r0 = this.z.h();
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.size();
    L6:
        List<m.e> r3 = this.z.k();
        if (r3 == null) goto L9;
        r1 = r3.size();
    L9:
        k r7 = new k(r2 + r1);
        com.bytedance.live.datacontext.m r4 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r4 == null) goto L12;
        IRoom r5 = (IRoom) r4.getValue();
    L14:
        return new LinkMicGameWindowHelper(r5, this.C, this.n, this.z, r7, this.B, this.X);
    L12:
        r5 = null;
        goto L14
    L5:
        r2 = 0;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager
    public final com.bytedance.android.live.liveinteract.plantform.datamerge.a b1() {
        List<m.d> r0 = this.z.h();
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.size();
    L6:
        List<m.e> r3 = this.z.k();
        if (r3 == null) goto L9;
        r1 = r3.size();
    L9:
        k r7 = new k(r2 + r1);
        com.bytedance.live.datacontext.m r4 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r4 == null) goto L12;
        IRoom r5 = (IRoom) r4.getValue();
    L14:
        return new LinkMicGameWindowHelperV2(r5, this.C, this.n, this.z, r7, this.B, this.X, 0);
    L12:
        r5 = null;
        goto L14
    L5:
        r2 = 0;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager, tf0.o
    public final void w() {
        ALogger.i("MultiLinkGameWindowManager", "sendPlayViewActionAfterUpdateFullMode");
        LinkMicGameWidget r0 = LinkMicGameContext.Companion.a();
        if (r0 == null) goto L7;
        ne0.c r1 = r0.getStore();
        if (r1 == null) goto L7;
        r1.d(ti0.a.b, new e(this));
    L7:
        p0();
        ALogger.i("MultiLinkGameWindowManager", "registerCrossRoomSilence");
        RxUtilKt.c(this.X.h().subscribe(new d(this)), this.p0);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.CommonMultiLinkWindowManager, com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager, tf0.o
    public final void end() {
        super.end();
        LinkMicGameWidget r0 = LinkMicGameContext.Companion.a();
        if (r0 == null) goto L7;
        ne0.c r1 = r0.getStore();
        if (r1 == null) goto L7;
        r1.e(ti0.a.b);
    L7:
        this.p0.clear();
        oi0.a r2 = this.k0;
        if (r2 == null) goto L10;
        r2.onDestroy();
    L10:
        l r3 = this.d;
        if (r3 == null) goto L14;
        r3.setMFirstVHShadowViewChange(null);
    L14:
        if ((!Intrinsics.areEqual(com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor(), Boolean.TRUE)) == false) goto L16;
        hd0.c.f().e(this.H0);
    L16:
        eh0.b r4 = this.X;
        if (r4 == null) goto L19;
        r4.e();
    L19:
        p1(CollectionsKt.emptyList());
        n r5 = n.b;
        r5.l();
        r5.f(this.L0);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.CommonMultiLinkWindowManager, com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager, tf0.o
    public final List<s0> getHeadPointList() {
        return super.getHeadPointList();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.CommonMultiLinkWindowManager, com.bytedance.android.live.liveinteract.animation.e
    public final boolean Ed(int r2) {
        if (this.Y == false) goto L17;
        com.bytedance.android.live.liveinteract.plantform.datamerge.a r0 = this.h;
        if (r0 == null) goto L11;
        BehaviorSubject<List<tf0.e>> r1 = r0.b;
        if (r1 == null) goto L11;
        List r3 = (List) r1.getValue();
        if (r3 == null) goto L11;
        tf0.e r4 = (tf0.e) CollectionsKt.getOrNull(r3, r2);
    L12:
        if (r4 != null) goto L14;
        return false;
    L14:
        if (r4.j == true) goto L20;
        return false;
    L20:
        return true;
    L11:
        r4 = null;
        goto L12
    L17:
        return true;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.CommonMultiLinkWindowManager, com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager
    public final void H0(List<? extends tf0.e> r2) {
        Intrinsics.checkNotNullParameter(r2, "windowList");
        super.H0(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.CommonMultiLinkWindowManager, com.bytedance.android.live.liveinteract.animation.e
    public final EPointF Mj(String r6) {
        Intrinsics.checkNotNullParameter(r6, "userId");
        if (this.Y == false) goto L33;
        com.bytedance.android.live.liveinteract.plantform.datamerge.a r0 = this.h;
        if (r0 == null) goto L27;
        BehaviorSubject<List<tf0.e>> r1 = r0.b;
        if (r1 == null) goto L27;
        List r2 = (List) r1.getValue();
        if (r2 == null) goto L27;
        Iterator r3 = r2.iterator();
    L12:
        if (r3.hasNext() == false) goto L25;
        Object r4 = r3.next();
        tf0.e r5 = (tf0.e) r4;
        if ((r5 instanceof MultiLinkGuestViewBinder.a) == false) goto L22;
        IBaseUser r7 = ((MultiLinkGuestViewBinder.a) r5).k.a.getUser();
        if (r7 == null) goto L18;
        String r8 = r7.getIdString();
    L20:
        if (Intrinsics.areEqual(r8, r6) == false) goto L22;
        boolean r9 = true;
    L23:
        if (r9 == false) goto L12;
    L26:
        tf0.e r10 = (tf0.e) r4;
    L28:
        if (r10 != null) goto L30;
    L31:
        return null;
    L30:
        if (r10.j == true) goto L33;
    L18:
        r8 = null;
    L22:
        r9 = false;
        goto L23
    L25:
        r4 = null;
    L27:
        r10 = null;
    L33:
        return super.Mj(r6);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.CommonMultiLinkWindowManager, com.bytedance.android.live.liveinteract.animation.e
    public final boolean Pf(int r2) {
        if (this.Y == false) goto L17;
        com.bytedance.android.live.liveinteract.plantform.datamerge.a r0 = this.h;
        if (r0 == null) goto L11;
        BehaviorSubject<List<tf0.e>> r1 = r0.b;
        if (r1 == null) goto L11;
        List r3 = (List) r1.getValue();
        if (r3 == null) goto L11;
        tf0.e r4 = (tf0.e) CollectionsKt.getOrNull(r3, r2);
    L12:
        if (r4 != null) goto L14;
        return false;
    L14:
        if (r4.j == true) goto L20;
        return false;
    L20:
        return true;
    L11:
        r4 = null;
        goto L12
    L17:
        return true;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager, vg0.a
    public final void e4(MultiLinkGuestViewBinder.a r2) {
        Intrinsics.checkNotNullParameter(r2, "itemData");
        int r0 = com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui.a.a;
        if (com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui.a.C0094a.b(r2.k.a) == false) goto L6;
        super.e4(r2);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.CommonMultiLinkWindowManager
    public final void onMessage(tlc.d r12) {
        super.onMessage(r12);
        if ((r12 instanceof h1) == false) goto L37;
        h1 r13 = (h1) r12;
        if (r13.getMType() != 41) goto L38;
        i r14 = r13.getLinkerCrossRoomUpdateContentExt();
        if (r14 == null) goto L39;
        Map r0 = r14.getLinkerContentMap();
        Integer r2 = null;
        if (r0 == null) goto L22;
        LinkedHashMap r4 = new LinkedHashMap();
        Iterator r1 = r0.entrySet().iterator();
    L12:
        if (r1.hasNext() == false) goto L19;
        Map.Entry r5 = (Map.Entry) r1.next();
        if (((Number) r5.getKey()).longValue() != r14.getToRoomId()) goto L16;
        boolean r6 = true;
    L17:
        if (r6 == false) goto L12;
        r4.put(r5.getKey(), r5.getValue());
        goto L12
    L16:
        r6 = false;
        goto L17
    L19:
        Map.Entry r15 = z0.a(r4);
        if (r15 == null) goto L22;
        g2 r16 = (g2) r15.getValue();
    L23:
        if (r16 == null) goto L25;
        r2 = Integer.valueOf(r16.getRoomLinkSilenceStatus());
    L25:
        if (r2 != null) goto L28;
    L30:
        f2.b(2131917732, 0);
        return;
    L28:
        if (r2.intValue() != 1) goto L30;
        f2.b(2131917729, 0);
        return;
    L22:
        r16 = null;
        goto L23
    L39:
        return;
    L38:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager, tf0.o
    public final void onSeiUpdated(SeiAppData r2) {
        super.onSeiUpdated(r2);
        oi0.a r0 = this.k0;
        if (r0 == null) goto L6;
        r0.onSeiUpdated(r2);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.CommonMultiLinkWindowManager
    public final void p1(List<? extends tf0.e> r2) {
        Intrinsics.checkNotNullParameter(r2, "windowList");
        super.p1(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager, vg0.a
    public final void w0(boolean r6) {
        if ((System.currentTimeMillis() - this.P0) >= 1000) goto L5;
        return;
    L5:
        this.P0 = System.currentTimeMillis();
        oi0.a r0 = this.k0;
        if (r0 == null) goto L9;
        r0.w0(r6);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.CommonMultiLinkWindowManager, com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager, vg0.a
    public final void w1(MultiLinkGuestViewBinder.a r4) {
        Intrinsics.checkNotNullParameter(r4, "itemData");
        int r0 = com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui.a.a;
        if (com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui.a.C0094a.b(r4.k.a) == false) goto L5;
    L14:
        super.w1(r4);
        return;
    L5:
        if (jc1.k.n(IMiddlewareUserService.class).user().c() == false) goto L14;
        if (hd0.c.f().h() == true) goto L14;
        yi0.a r1 = new yi0.a(getContext(), r4.k.a, false);
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L17;
        DialogLancet.handleBlockedDialogShow(r1);
        return;
    L17:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L16
    L12:
        DialogLancet.beforeDialogShow(r1);
        r1.show();
        DialogLancet.afterDialogShow(r1);
    }

    public static final void q1(MultiLinkGameWindowManager r3, boolean r4) {
        r3.getClass();
        ALogger.i("MultiLinkGameWindowManager", "updateXplayRunningState: " + r4);
        if (je0.d.D() == true) goto L17;
        hg0.d r5 = r3.i;
        if (r5 == null) goto L15;
        ti0.b r0 = ti0.b.b;
        Boolean r6 = Boolean.valueOf(r4);
        Intrinsics.checkNotNullParameter(r0, "action");
        ALogger.i("EffectCollect", "do layer action action:" + r0 + " position:0");
        RecyclerView r7 = r5.a;
        if (r7 == null) goto L10;
        RecyclerView.ViewHolder r8 = r7.findViewHolderForAdapterPosition(0);
    L12:
        if ((r8 instanceof hg0.b) == false) goto L16;
        ((hg0.b) r8).l().e(0, r0, r6);
        return;
    L16:
        return;
    L10:
        r8 = null;
        goto L12
    L15:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager
    public final void W0(j r5, boolean r6) {
        StringBuilder r7 = new StringBuilder("布局配置化WM-update, VideoTalkLayoutConfig: ");
        r7.append(g0());
        r7.append(", LinkWindowLayoutConfig: ");
        if (r5 == null) goto L5;
        String r1 = ((m) r5).a();
    L6:
        r7.append(r1);
        ALogger.i("MultiLinkGameWindowManager", r7.toString());
        if (r5 != null) goto L9;
        return;
    L9:
        if ((r5 instanceof m) == false) goto L64;
        m r8 = (m) r5;
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        this.z = r8;
        List<m.d> r9 = r8.h();
        int r2 = 0;
        if (r9 == null) goto L14;
        int r10 = r9.size();
    L15:
        List<m.e> r3 = r8.k();
        if (r3 == null) goto L18;
        r2 = r3.size();
    L18:
        k r4 = new k(r10 + r2);
        com.bytedance.android.live.liveinteract.plantform.datamerge.a r11 = this.h;
        if (r11 == null) goto L21;
        r11.w(r4, r8);
    L21:
        boolean r12 = this.V0;
        int r13 = d0();
        int r14 = c0();
        V(r13, r14, true);
        if (r12 == false) goto L24;
        E0(true, r13, r14);
    L24:
        l r15 = this.d;
        if (r15 == null) goto L27;
        r15.U3(r8, d0(), c0());
    L27:
        k0();
        com.bytedance.android.live.liveinteract.plantform.datamerge.a r16 = this.h;
        if (r16 == null) goto L61;
        BehaviorSubject<List<tf0.e>> r17 = r16.b;
        if (r17 == null) goto L62;
        List r18 = (List) r17.getValue();
        if (r18 == null) goto L63;
        Iterator r19 = r18.iterator();
    L35:
        if (r19.hasNext() == false) goto L65;
        tf0.e r20 = (tf0.e) r19.next();
        if ((r20 instanceof MultiLinkGuestViewBinder.a) == false) goto L35;
        MultiLinkGuestViewBinder.a r21 = (MultiLinkGuestViewBinder.a) r20;
        ch0.e r22 = r21.k;
        if (r22 == null) goto L45;
        ILinkPlayerInfoBridge r23 = r22.a;
        if (r23 == null) goto L45;
        IBaseUser r24 = r23.getUser();
        if (r24 == null) goto L45;
        String r25 = r24.getIdString();
    L47:
        if (Intrinsics.areEqual(r25, gh0.a.c()) == false) goto L35;
        MultiLinkFrequencyOptConfig r26 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.a;
        boolean r27 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.a(r21.k, null);
        l r28 = this.d;
        if (r28 == null) goto L35;
        r28.m3(r21, r27);
    L45:
        r25 = null;
        goto L47
    L65:
        return;
    L63:
        return;
    L62:
        return;
    L61:
        return;
    L14:
        r10 = 0;
        goto L15
    L64:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager
    public final void n0(boolean r1, boolean r2) {
        super.n0(r1, r2);
        if (r1 == false) goto L7;
        if (r1 == true) goto L6;
        return;
    L6:
        if (LinkRoomFightContext.Companion.getContext() != null) goto L7;
        return;
    L7:
        ALogger.i("MultiLinkGameWindowManager", "registerCrossRoomSilence");
        RxUtilKt.c(this.X.h().subscribe(new d(this)), this.p0);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager, tf0.o
    public final /* bridge */ /* synthetic */ void r(m r1, Boolean r2) {
        W0(r1, r2.booleanValue());
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.CommonMultiLinkWindowManager, com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager, tf0.o
    public final void l(boolean r3, Pair<Integer, Integer> r4, Pair<Integer, Integer> r5) {
        Intrinsics.checkNotNullParameter(r4, "livePlayerVideoSize");
        Intrinsics.checkNotNullParameter(r5, "livePlayerLayoutSize");
        ALogger.i("MultiLinkGameWindowManager", "start isFromFastMode=" + r3);
        super.l(r3, r4, r5);
        i0 r6 = j0.a;
        DataCenter r7 = this.C;
        int r8 = h0.a;
        j0.f(r7, "is_mic_seat_fold", new b(this));
        j0.f(this.C, "visible_guest_uid", new c(this));
        if ((!Intrinsics.areEqual(com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor(), Boolean.TRUE)) == false) goto L5;
        hd0.c.f().c(this.H0);
    L5:
        if (r3 == false) goto L9;
        if (r3 == true) goto L8;
    L14:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.c r9 = this.P;
        eh0.b r10 = this.X;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r10, "linkMicGameDataMergeCenter");
        r9.c = r10;
        n.b.h(this.L0);
        return;
    L8:
        if (LinkMicGameContext.Companion.a() == null) goto L14;
    L9:
        LinkMicGameWidget r11 = LinkMicGameContext.Companion.a();
        if (r11 == null) goto L14;
        ne0.c r12 = r11.getStore();
        if (r12 == null) goto L14;
        r12.d(ti0.a.b, new e(this));
        goto L14
    }

    public MultiLinkGameWindowManager(Context r17, ConstraintLayout r18, m r19, zj0.c r20, com.bytedance.android.live.liveinteract.plantform.datamerge.d r21, eh0.b r22, DataCenter r23, o.a r24, PlatformMultiLinkWidget r25, View r26, GLSurfaceView r27, com.bytedance.android.live.pushstream.d r28, PlatformMultiLinkWidget r29) {
        Intrinsics.checkNotNullParameter(r17, "context");
        Intrinsics.checkNotNullParameter(r18, "containerView");
        Intrinsics.checkNotNullParameter(r19, "initLayoutConfig");
        Intrinsics.checkNotNullParameter(r21, "dataMergeCenter");
        Intrinsics.checkNotNullParameter(r22, "linkMicGameDataMergeCenter");
        Intrinsics.checkNotNullParameter(r23, "dataCenter");
        Intrinsics.checkNotNullParameter(r24, "callBack");
        Intrinsics.checkNotNullParameter(r25, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r26, "interactEmojiLayout");
        Intrinsics.checkNotNullParameter(r27, "renderContainer");
        super(r17, r18, r19, r20, r21, r23, r24, r25, r26, r27, r28, r29);
        this.Z = "";
        this.p0 = new CompositeDisposable();
        this.H0 = new ri0.b(this);
        this.L0 = new ri0.c(this);
        this.V0 = true;
        if (Intrinsics.areEqual(com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor(), Boolean.TRUE) == false) goto L6;
        this.k0 = new oi0.b(r17, r23);
    L9:
        oi0.a r1 = this.k0;
        if (r1 == null) goto L12;
        r1.onCreate();
    L12:
        i0 r2 = j0.a(r23);
        if (r2 != null) goto L15;
    L17:
        boolean r3 = false;
    L18:
        this.Y = r3;
        ALogger.i("MultiLinkGameWindowManager", "init, isCurrentMicSeatStash: " + this.Y);
        if (this.Y == false) goto L21;
        int r4 = qi0.b.a;
        qi0.b.a(true, d0(), c0(), r23, new ri0.a(this));
    L21:
        this.X = r22;
        return;
    L15:
        if (r2.h() != true) goto L17;
        r3 = true;
        goto L18
    L6:
        if (hd0.c.f().h() == false) goto L8;
        this.k0 = new oi0.d(r23);
        goto L9
    L8:
        this.k0 = new oi0.c(r23);
        goto L9
    }
}
