package com.bytedance.android.live.liveinteract.plantform.commonwindow.wm;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.SurfaceView;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.live.liveinteract.utils.n1;
import com.bytedance.android.live.liveinteract.videotalk.MultiLinkVideoTalkRoomGuestWidget;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import uf2.d0;
import zg1.a1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/wm/ConcertMultiLinkWindowManager;", "Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/wm/CommonMultiLinkWindowManager;", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ConcertMultiLinkWindowManager extends CommonMultiLinkWindowManager {
    public final Lazy X;
    public final Lazy Y;
    public final Lazy Z;
    public final t k0;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ ConcertMultiLinkWindowManager a;

        public b(ConcertMultiLinkWindowManager r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.m1();     // Catch: Throwable -> L4
            this.a.D.Y7().clear();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.CommonMultiLinkWindowManager, com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager, tf0.o
    public final void O() {
        ALogger.i("ConcertMultiLinkWindowManager", "[chorus_concert]  onStopRtcSuccess，delay: " + ((Long) this.X.getValue()));
        i0.c().postDelayed(new b(this), ((Long) this.X.getValue()).longValue());
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.CommonMultiLinkWindowManager, com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager, tf0.o
    public final void L() {
        l1();
        SurfaceView r0 = this.D.q1();
        if (r0 == null) goto L5;
        r0.setVisibility(8);
    L5:
        ALogger.i("ConcertMultiLinkWindowManager", "[chorus_concert]  onStartRtcSuccess");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.CommonMultiLinkWindowManager, com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager, tf0.o
    public final void end() {
        super.end();
        j1 r0 = this.G;
        if (r0 == null) goto L5;
        cg6.a r1 = (cg6.a) r0.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
    L6:
        if (r1 == null) goto L10;
        hg6.g r2 = r1.getRtcManager();
        if (r2 == null) goto L10;
        r2.Z(this.k0);
    L10:
        ALogger.i("ConcertMultiLinkWindowManager", "[chorus_concert] end");
        return;
    L5:
        r1 = null;
        goto L6
    }

    public static final void q1(ConcertMultiLinkWindowManager r2) {
        SurfaceView r0 = r2.D.q1();
        if (r0 == null) goto L6;
        r0.setVisibility(0);
    L6:
        if (je0.d.L() == true) goto L8;
        return;
    L8:
        if (((Boolean) r2.Z.getValue()).booleanValue() == false) goto L14;
        DataCenter r3 = r2.C;
        if (r3 == null) goto L15;
        r3.put("cmd_interact_state_change", new a1(3));
        return;
    L15:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager, tf0.o
    public final void g(d0 r2) {
        n1.f.getClass();
        n1.b.b(r2);
        ALogger.i("SingleView", "multi_link_service ConcertMultiLinkWindowManager  onRtcAdvanceStartSuccess ConcertMultiLinkWindowManager");
        l1();
        if (((Boolean) this.Z.getValue()).booleanValue() == true) goto L15;
        com.bytedance.live.datacontext.j r3 = o3.f().getVideoTalkRoomSubScene();
        if (r3 == null) goto L15;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r4 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r3.getValue();
        if (r4 == null) goto L15;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r5 = r4.t();
        if (r5 == null) goto L15;
        if (r5.c != 63) goto L15;
        SurfaceView r6 = this.D.q1();
        if (r6 == null) goto L18;
        r6.setVisibility(0);
    L18:
        ALogger.i("ConcertMultiLinkWindowManager", "[chorus_concert] onRtcAdvanceStartSuccess");
        return;
    L15:
        SurfaceView r7 = this.D.q1();
        if (r7 == null) goto L18;
        r7.setVisibility(8);
        goto L18
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.CommonMultiLinkWindowManager, com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager, tf0.o
    public final void l(boolean r2, Pair<Integer, Integer> r3, Pair<Integer, Integer> r4) {
        Intrinsics.checkNotNullParameter(r3, "livePlayerVideoSize");
        Intrinsics.checkNotNullParameter(r4, "livePlayerLayoutSize");
        super.l(r2, r3, r4);
        j1 r5 = this.G;
        if (r5 == null) goto L5;
        cg6.a r6 = (cg6.a) r5.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
    L6:
        if (r6 == null) goto L10;
        hg6.g r7 = r6.getRtcManager();
        if (r7 == null) goto L10;
        r7.p(this.k0);
    L10:
        ALogger.i("ConcertMultiLinkWindowManager", "[chorus_concert] start");
        return;
    L5:
        r6 = null;
        goto L6
    }

    public ConcertMultiLinkWindowManager(Context r2, ConstraintLayout r3, com.bytedance.android.live.liveinteract.plantform.commonwindow.m r4, zj0.c r5, com.bytedance.android.live.liveinteract.plantform.datamerge.d r6, DataCenter r7, MultiLinkVideoTalkRoomGuestWidget r8, MultiLinkVideoTalkRoomGuestWidget r9, View r10, GLSurfaceView r11, com.bytedance.android.live.pushstream.d r12, MultiLinkVideoTalkRoomGuestWidget r13) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "containerView");
        Intrinsics.checkNotNullParameter(r4, "layoutConfig");
        Intrinsics.checkNotNullParameter(r6, "dataMergeCenter");
        Intrinsics.checkNotNullParameter(r7, "dataCenter");
        Intrinsics.checkNotNullParameter(r8, "callBack");
        Intrinsics.checkNotNullParameter(r9, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r10, "interactEmojiLayout");
        Intrinsics.checkNotNullParameter(r11, "renderContainer");
        super(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
        this.X = LazyKt.lazy(ConcertMultiLinkWindowManager$mRemoveSurfaceViewDelayTime$2.INSTANCE);
        this.Y = LazyKt.lazy(ConcertMultiLinkWindowManager$mFirstFrameNotifyOpt$2.INSTANCE);
        this.Z = LazyKt.lazy(ConcertMultiLinkWindowManager$mEnableSwitchStreamOpt$2.INSTANCE);
        this.k0 = new t(this);
    }
}
