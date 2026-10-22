package com.bytedance.android.live.liveinteract.videotalk;

import android.view.ViewGroup;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.tetris.layer.core.event.LayerEventDispatcher;
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.n0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.ILiveLinkCameraBackUpConfig;
import com.bytedance.android.livesdkapi.model.ILiveLinkCameraBackUpConfigKt;
import com.bytedance.common.utility.Lists;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h extends com.bytedance.android.live.liveinteract.plantform.base.i.d {
    public final /* synthetic */ MultiLinkVideoTalkRoomAnchorWidget a;

    public static final class a implements Runnable {
        public final /* synthetic */ h a;

        public a(h r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            hg6.g r0 = this.a.a.R1();     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.f();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public h(MultiLinkVideoTalkRoomAnchorWidget r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.i.d, com.bytedance.android.live.liveinteract.plantform.base.i.b
    public final void l(List<ILinkPlayerInfoBridge> r1) {
        onOnlineListChanged(r1);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.i.d, com.bytedance.android.live.liveinteract.plantform.base.i.b
    public final void onOnlineListChanged(List<ILinkPlayerInfoBridge> r9) {
        if (r9 == null) goto L16;
        com.bytedance.android.live.liveinteract.plantform.utils.s r2 = this.a.x1;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r9, "list");
        if (r9.size() <= 1) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == true) goto L10;
    L12:
        if (r3 == true) goto L16;
        if (r2.e == true) goto L16;
        r2.c();
        goto L16
    L10:
        if (r2.e == false) goto L12;
        r2.a();
        goto L16
    L7:
        r3 = false;
    L16:
        ArrayList r4 = new ArrayList();
        if (r9 == null) goto L45;
        int r5 = r9.size();
        MultiLinkVideoTalkRoomAnchorWidget r6 = this.a;
        if (r5 <= r6.D) goto L21;
        r6.D = r9.size();
    L21:
        List<ILinkPlayerInfoBridge> r7 = r9;
        r4.addAll(r7);
        this.a.Y.clear();
        this.a.Y.addAll(r7);
        com.bytedance.android.live.liveinteract.plantform.utils.t.a(r9);
        Iterator<T> r8 = r9.iterator();
    L23:
        if (r8.hasNext() == false) goto L33;
        Object r10 = r8.next();
        MultiLinkVideoTalkRoomAnchorWidget r11 = this.a;
        IBaseUser r12 = ((ILinkPlayerInfoBridge) r10).getUser();
        Intrinsics.checkNotNull(r12);
        String r13 = r12.getIdString();
        r11.getClass();
        com.bytedance.live.datacontext.m r14 = com.bytedance.android.live.liveinteract.api.utils.m.j(r11).getRoom();
        if (r14 == null) goto L29;
        IRoom r15 = (IRoom) r14.getValue();
        if (r15 == null) goto L29;
        String r16 = r15.getOwnerUserIdString();
    L31:
        if (Intrinsics.areEqual(r13, r16) == false) goto L23;
    L34:
        ILinkPlayerInfoBridge r17 = (ILinkPlayerInfoBridge) r10;
        if (r17 == null) goto L45;
        MultiLinkVideoTalkRoomAnchorWidget r18 = this.a;
        if (r17.getSilenceStatus() == 0) goto L39;
        boolean r19 = true;
    L40:
        r18.getClass();
        if (vm2.d.A() == false) goto L45;
        LayerEventDispatcher r20 = o70.c.a(Integer.valueOf(((Widget) r18).dataCenter.hashCode()));
        if (r20 == null) goto L45;
        r20.b(new zg1.e(r19));
        goto L45
    L39:
        r19 = false;
    L29:
        r16 = null;
        goto L31
    L33:
        r10 = null;
    L45:
        ViewGroup r21 = ((Widget) this.a).containerView;
        if (r21 == null) goto L48;
        r21.post(new a(this));
    L48:
        ((Widget) this.a).dataCenter.put("data_online_changed_list", r4);
        bn0.b r22 = this.a.getMultiLinkRoomScope();
        if (r22 == null) goto L55;
        jn0.b r23 = jn0.c.a(r22);
        if (r23 == null) goto L55;
        BehaviorSubject<List<ILinkPlayerInfoBridge>> r24 = r23.Xh();
        if (r24 == null) goto L55;
        r24.onNext(r4);
    L55:
        MultiLinkVideoTalkRoomAnchorWidget r25 = this.a;
        int r26 = MultiLinkVideoTalkRoomAnchorWidget.h2;
        if (r25.Nq() == 16) goto L58;
        com.bytedance.android.livesdk.chatroom.utils.g0.e(r4.size());
    L58:
        this.a.S.k(r4);
        if (r9 == null) goto L115;
        Iterator<T> r27 = r9.iterator();
    L62:
        if (r27.hasNext() == false) goto L70;
        Object r28 = r27.next();
        IBaseUser r29 = ((ILinkPlayerInfoBridge) r28).getUser();
        if (r29 == null) goto L66;
        String r30 = r29.getIdString();
    L68:
        if (Intrinsics.areEqual(r30, je0.d.b0()) == false) goto L62;
    L71:
        ILinkPlayerInfoBridge r31 = (ILinkPlayerInfoBridge) r28;
        if (r31 == null) goto L116;
        MultiLinkVideoTalkRoomAnchorWidget r32 = this.a;
        r32.getClass();
        if (r31.getUser() == null) goto L121;
        ILiveLinkCameraBackUpConfig r33 = vm2.g.c();
        if (ILiveLinkCameraBackUpConfigKt.supportMsgUpdateForAnchor(r33) == false) goto L122;
        IBaseUser r34 = r31.getUser();
        if (r34 == null) goto L82;
        String r35 = r34.getIdString();
    L84:
        if ((!Intrinsics.areEqual(r35, je0.d.b0())) == false) goto L87;
        return;
    L87:
        if (r31.isBackground() == false) goto L89;
        return;
    L89:
        if (r32.I == true) goto L124;
        com.bytedance.android.live.pushstream.d r36 = r32.v;
        if (r36 == null) goto L94;
        Boolean r37 = Boolean.valueOf(r36.u1());
    L95:
        boolean r38 = r37.booleanValue();
        if (r31.getSilenceStatus() == 0) goto L107;
        if (r38 == true) goto L106;
        int r39 = r32.J + 1;
        r32.J = r39;
        Set<Long> r1 = InteractLinkFullLinkMonitor.a;
        InteractLinkFullLinkMonitor.y(r39, null, Boolean.valueOf(r38), r31.getSilenceStatus(), r31.getLinkType());
        if (r32.J < ILiveLinkCameraBackUpConfigKt.getSafeMaxDiffCount(r33)) goto L118;
        jg6.a r40 = r32.Bq();
        if (r40 == null) goto L105;
        kg6.e r41 = r40.b();
        if (r41 == null) goto L105;
        r41.t(new kg6.b(false, false, "link security", 8));
    L105:
        r32.J = 0;
        return;
    L118:
        return;
    L106:
        r32.J = 0;
        return;
    L107:
        r32.J = 0;
        return;
    L94:
        r37 = null;
        goto L95
    L124:
        return;
    L82:
        r35 = null;
        goto L84
    L122:
        return;
    L121:
        return;
    L116:
        return;
    L66:
        r30 = null;
        goto L68
    L70:
        r28 = null;
        goto L71
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.i.d, com.bytedance.android.live.liveinteract.plantform.base.i.b
    public final void d(List<ILinkPlayerInfoBridge> r3, List<ILinkPlayerInfoBridge> r4) {
        if (r4 == null) goto L4;
        this.a.Z.clear();
        this.a.Z.addAll(r4);
    L4:
        int r0 = 0;
        if (r3 == null) goto L7;
        int r5 = r3.size();
    L8:
        if (r4 == null) goto L10;
        r0 = r4.size();
    L10:
        com.bytedance.android.livesdk.chatroom.utils.g0.e(r5 + r0);
        hg6.g r6 = this.a.R1();
        if (r6 == null) goto L14;
        r6.f();
        return;
    L14:
        return;
    L7:
        r5 = 0;
        goto L8
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.i.d, com.bytedance.android.live.liveinteract.plantform.base.i.b
    public final void n(List<ILinkPlayerInfoBridge> r3, long r4, n0 r6) {
        Intrinsics.checkNotNullParameter(r3, "list");
        String r5 = "";
        if (Lists.isEmpty(r3) == false) goto L7;
        DataCenter r7 = ((Widget) this.a).dataCenter;
        if (r7 == null) goto L34;
        r7.put("data_video_talk_dot_with_number_show", "");
        return;
    L34:
        return;
    L7:
        rj0.k.m2.getClass();
        rj0.k r8 = rj0.k.a.a();
        String r9 = null;
        if (r8 == null) goto L14;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r10 = r8.getLinkUserInfoCenter();
        if (r10 == null) goto L14;
        List<T> r11 = r10.V4();
        if (r11 == 0) goto L14;
        Integer r12 = Integer.valueOf(r11.size());
    L16:
        if (r12 != null) goto L18;
    L20:
        if (r12 == null) goto L22;
        r9 = String.valueOf(r12.intValue());
    L22:
        if (r12 != null) goto L24;
    L29:
        r5 = r9;
    L30:
        DataCenter r13 = ((Widget) this.a).dataCenter;
        if (r13 == null) goto L36;
        r13.put("data_video_talk_dot_with_number_show", r5);
        return;
    L36:
        return;
    L24:
        if (r12.intValue() <= 99) goto L27;
        r9 = "99+";
    L27:
        if (r12.intValue() > 0) goto L29;
    L18:
        if (r12.intValue() > 99) goto L20;
        r12 = Integer.valueOf(r12.intValue() + fj0.e.a());
    L14:
        r12 = null;
        goto L16
    }
}
