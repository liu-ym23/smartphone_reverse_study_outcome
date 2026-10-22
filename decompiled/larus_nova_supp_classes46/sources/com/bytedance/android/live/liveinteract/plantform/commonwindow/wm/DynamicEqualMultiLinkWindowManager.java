package com.bytedance.android.live.liveinteract.plantform.commonwindow.wm;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget;
import com.bytedance.android.livesdk.chatroom.model.interact.i2;
import com.bytedance.android.livesdk.link.model.bridge.l2;
import com.bytedance.android.livesdk.link.model.bridge.u1;
import com.bytedance.android.livesdk.link.model.bridge.v1;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/wm/DynamicEqualMultiLinkWindowManager;", "Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/wm/CommonMultiLinkWindowManager;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class DynamicEqualMultiLinkWindowManager extends CommonMultiLinkWindowManager {
    public int X;

    public static final class a implements com.bytedance.android.live.liveinteract.plantform.commonwindow.k {
        public final /* synthetic */ DynamicEqualMultiLinkWindowManager a;

        @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.k
        public final void onFailed() {
        }

        public a(DynamicEqualMultiLinkWindowManager r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.k
        public final void a(com.bytedance.android.live.liveinteract.plantform.commonwindow.m r3) {
            Intrinsics.checkNotNullParameter(r3, "layoutConfigV1");
            this.a.W0(r3, false);
            if (this.a.n == true) goto L8;
            rj0.l.n2.getClass();
            rj0.l r4 = rj0.l.a.a();
            if (r4 != null) goto L7;
            return;
        L7:
            if (r4.isEngineOn() == true) goto L8;
            return;
        L8:
            this.a.q1();
        }
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.CommonMultiLinkWindowManager, com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager
    public final zj0.d g0() {
        return new zj0.d.b(this.z.j(), this.z.getUiLayout(), this.z.m(), -2, 0, 16);
    }

    public final void q1() {
        tc0.c r1 = tc0.c.h();
        int r13 = 2;
        String r14 = null;
        if (r1 == null) goto L22;
        u1 r2 = r1.r;
        if (r2 == null) goto L22;
        l2 r3 = r2.getVideoEqualRoomLiveCoreInfo();
        if (r3 == null) goto L22;
        Map r4 = r3.getLiveCoreInfoMap();
        if (r4 == null) goto L22;
        if (this.n == false) goto L13;
        int r15 = 3;
    L14:
        int r12 = this.X;
        if (r12 > r15) goto L17;
        String r5 = (String) r4.get(2L);
    L23:
        tc0.c r16 = tc0.c.h();
        if (r16 == null) goto L43;
        v1 r17 = r16.n;
        if (r17 == null) goto L43;
        i2 r18 = r17.getVideoEqualRoomRtcInfo();
        if (r18 == null) goto L43;
        Map r19 = r18.getRtcInfoMap();
        if (r19 == null) goto L43;
        ALogger.i("BaseMultiLinkWindowManager", "getCurrentRtcInfo return " + r19);
        if (this.n == false) goto L34;
        r13 = 3;
    L34:
        int r110 = this.X;
        if (r110 > r13) goto L38;
        String r6 = (String) r19.get(2L);
    L37:
        r14 = r6;
        goto L43
    L38:
        if (r110 > 4) goto L40;
        r6 = (String) r19.get(4L);
        goto L37
    L40:
        if (r110 > 6) goto L42;
        r6 = (String) r19.get(6L);
        goto L37
    L42:
        r6 = (String) r19.get(9L);
    L43:
        this.D.ca(r14, r5);
        return;
    L17:
        if (r12 > 4) goto L19;
        r5 = (String) r4.get(4L);
        goto L23
    L19:
        if (r12 > 6) goto L21;
        r5 = (String) r4.get(6L);
        goto L23
    L21:
        r5 = (String) r4.get(9L);
        goto L23
    L13:
        r15 = 2;
    L22:
        r5 = null;
        goto L23
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.CommonMultiLinkWindowManager, com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager
    public final void H0(List<? extends tf0.e> r3) {
        Intrinsics.checkNotNullParameter(r3, "windowList");
        if (this.n == true) goto L8;
        rj0.l.n2.getClass();
        rj0.l r0 = rj0.l.a.a();
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.isEngineOn() == true) goto L8;
        return;
    L8:
        r1(r3.size());
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager, tf0.o
    public final void onSeiUpdated(SeiAppData r1) {
        super.onSeiUpdated(r1);
        if (r1 == null) goto L6;
        r1(r1.getStyle());
        return;
    }

    public final void r1(int r12) {
        if (this.X != r12) goto L5;
        return;
    L5:
        if (r12 >= 0) goto L7;
        return;
    L7:
        if (r12 > 9) goto L39;
        this.X = r12;
        DataCenter r0 = this.C;
        if (r0 == null) goto L14;
        Boolean r1 = (Boolean) r0.get("status_bar_is_visible", Boolean.TRUE);
        if (r1 == null) goto L14;
        boolean r4 = r1.booleanValue();
    L15:
        Pair<Integer, Integer> r2 = i0(d0(), c0());
        com.bytedance.live.datacontext.m r3 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r3 == null) goto L28;
        IRoom r5 = (IRoom) r3.getValue();
        if (r5 == null) goto L28;
        if (r5.isLiveTypeAudio() != true) goto L28;
        com.bytedance.live.datacontext.j r6 = com.bytedance.android.live.liveinteract.api.utils.m.d().s();
        if (r6 == null) goto L35;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r7 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r6.getValue();
        if (r7 == null) goto L35;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r8 = r7.t();
        if (r8 == null) goto L35;
        ClientUIInfo r9 = r8.a();
    L36:
        ClientUIInfo r10 = r9;
        ln0.a r11 = yg0.h.a;
        yg0.h.g(this.X, new a(this), r4, null, new Triple(r2.getFirst(), r2.getSecond(), "DynamicEqualMultiLinkWindowManager#updateLayoutConfigIfNeed, with windowCount = " + r12), this.s, r10, this.C, 136);
        return;
    L35:
        r9 = null;
    L28:
        com.bytedance.live.datacontext.j r13 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
        if (r13 == null) goto L35;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r14 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r13.getValue();
        if (r14 == null) goto L35;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r15 = r14.t();
        if (r15 == null) goto L35;
        r9 = r15.e;
    L14:
        r4 = true;
        goto L15
    }

    public DynamicEqualMultiLinkWindowManager(Context r2, ConstraintLayout r3, com.bytedance.android.live.liveinteract.plantform.commonwindow.m r4, zj0.c r5, com.bytedance.android.live.liveinteract.plantform.datamerge.d r6, DataCenter r7, tf0.o.a r8, PlatformMultiLinkWidget r9, View r10, GLSurfaceView r11, com.bytedance.android.live.pushstream.d r12, PlatformMultiLinkWidget r13) {
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
    }
}
