package com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust;

import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.chatroom.InteractionWidgetsPosContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.InteractivityContext;
import com.bytedance.android.livesdk.interactivity.api.monitor.PublicScreenTraceMonitor;
import com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.adapter.LiveRoomEnvStateHolder;
import com.bytedance.android.livesdk.interactivity.common.adjuster.logical.CommentLpHelper;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.model.CommunityFoldFixConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import j40.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import r52.n0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class TextMessageAdjuster implements com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.h {
    public final a a;
    public final LiveRoomEnvStateHolder b;

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.h
    public final void M() {
        a r0 = this.a;
        r0.getClass();
        com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.j.c.b();
        Intrinsics.checkNotNullParameter("start process width change", "msg");
        int r1 = b.a;
        DataCenter r2 = r0.a;
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        if (PadConfigUtils.c() == false) goto L5;
        f r3 = new l();
    L6:
        LiveRoomEnvStateHolder r4 = r0.b;
        List r5 = r3.a(r4, r4);
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator r7 = r5.iterator();
    L8:
        if (r7.hasNext() == false) goto L10;
        i r8 = (i) r7.next();
        com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.j r9 = com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.j.c;
        r9.d("find proper width strategy " + r8.d());
        r0.e.getWidth();
        r0.e.e();
        com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.k r10 = r8.b(r0.c, r0.d, r0.b);
        r9.d("getwidth info " + r10);
        r6.add(new Pair(r10, r8));
        goto L8
    L10:
        Iterator r11 = r6.iterator();
        if (r11.hasNext() == true) goto L13;
        Object r13 = null;
    L22:
        Pair r14 = (Pair) r13;
        if (r14 == null) goto L51;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.k r15 = (com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.k) r14.getFirst();
        String r16 = ((i) r14.getSecond()).d();
        int r17 = r15.b;
        if (r17 == (-10086)) goto L27;
        r0.e.h(r17);
    L27:
        int r18 = r15.c;
        if (r18 == (-10086)) goto L30;
        r0.e.a(r18);
    L30:
        int r19 = r15.a;
        if (r19 == (-10086)) goto L33;
        r0.e.setWidth(r19);
        xs2.b.a().post(new o42.m());
    L33:
        r0.e.g();
        InteractionWidgetsPosContext.a r20 = InteractionWidgetsPosContext.Companion;
        boolean r21 = true;
        InteractionWidgetsPosContext r23 = InteractionWidgetsPosContext.a.c(r20, null, r0.d.getRoomId(), 1);
        if (r23 == null) goto L36;
        r23.getPublicScreenLeftMargin().setValue(Integer.valueOf(r0.e.b()));
        r23.getPublicScreenRightMargin().setValue(Integer.valueOf(r0.e.e()));
    L36:
        PublicScreenTraceMonitor.g(r16, Boolean.TRUE, Boolean.FALSE, PublicScreenTraceMonitor.AdjustStep.RESULT, "leftMargin:" + r15.b + ",rightMargin:" + r15.c);
        com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.j r24 = com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.j.c;
        Intrinsics.checkNotNullParameter(r15, "widthInfo");
        r24.a("right margin: " + r15.c + ", width: " + r15.a);
        int r25 = r0.e.e();
        InteractionWidgetsPosContext r26 = InteractionWidgetsPosContext.a.c(r20, null, r0.d.getRoomId(), 1);
        if (r26 != null) goto L39;
        return;
    L39:
        if (r26.isCleared() == true) goto L53;
        com.bytedance.live.datacontext.m r27 = r26.isPublicScreenWidthHalfMode();
        if (PadConfigUtils.c() == false) goto L43;
    L45:
        r21 = false;
    L46:
        r27.setValue(Boolean.valueOf(r21));
        return;
    L43:
        if (r25 < a.g) goto L45;
    L53:
        return;
    L51:
        return;
    L13:
        r13 = r11.next();
        if (r11.hasNext() == false) goto L22;
        int r28 = ((com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.k) ((Pair) r13).getFirst()).c;
    L17:
        Object r29 = r11.next();
        int r30 = ((com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.k) ((Pair) r29).getFirst()).c;
        if (r28 >= r30) goto L21;
        r13 = r29;
        r28 = r30;
    L21:
        if (r11.hasNext() == true) goto L17;
    L5:
        r3 = new m(r2);
        goto L6
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.h
    public final void P() {
        a r0 = this.a;
        r0.getClass();
        com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.j.c.b();
        Intrinsics.checkNotNullParameter("start process height intercept", "msg");
        g.a.getClass();
        Iterator r1 = ((HashMap) g.a.a).entrySet().iterator();
        Object r3 = null;
        Object r4 = null;
    L3:
        boolean r6 = false;
        if (r1.hasNext() == false) goto L12;
        Object r5 = r1.next();
        if (((g) ((Map.Entry) r5).getValue()).c(r0.b) == true) goto L8;
    L10:
        if (r6 == false) goto L3;
        r4 = r5;
        goto L3
    L8:
        if (r0.d.isCompoundScene() == true) goto L10;
        r6 = true;
        goto L10
    L12:
        Map.Entry r7 = (Map.Entry) r4;
        if (r7 == null) goto L20;
        InteractionWidgetsPosContext r2 = InteractionWidgetsPosContext.a.c(InteractionWidgetsPosContext.Companion, null, r0.d.getRoomId(), 1);
        if (r2 == null) goto L19;
        com.bytedance.live.datacontext.m r8 = r2.getGameGiftTrayPos();
        if (r8 == null) goto L19;
        r8.setValue(CommentLpHelper.f);
    L19:
        r0.a(a.b(((g) r7.getValue()).a(r0.e.getHeight(), r0.e.getBottomMargin(), r0.c, r0.d, r0.b), r7.getValue(), r0.c, r0.b), ((g) r7.getValue()).d(), true);
        com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.j.c.d("intercepted by " + ((g) r7.getValue()).d());
        return;
    L20:
        boolean r9 = com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.j.a;
        Intrinsics.checkNotNullParameter("start process height change", "msg");
        int r10 = b.a;
        DataCenter r11 = r0.a;
        Intrinsics.checkNotNullParameter(r11, "dataCenter");
        if (PadConfigUtils.c() == false) goto L23;
        f r13 = new l();
    L24:
        LiveRoomEnvStateHolder r14 = r0.b;
        List r15 = r13.b(r14, r14);
        ArrayList r16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
        Iterator r17 = r15.iterator();
    L26:
        if (r17.hasNext() == false) goto L28;
        c r18 = (c) r17.next();
        com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d r19 = r18.a(r0.e.getHeight(), r0.e.getBottomMargin(), r0.c, r0.d, r0.b);
        com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.j r20 = com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.j.c;
        r20.d("find proper height strategy " + r18.d());
        r20.d("getHeightInfo: " + r19);
        r16.add(new Pair(r19, r18));
        goto L26
    L28:
        ArrayList r21 = new ArrayList();
        Iterator r23 = r16.iterator();
    L30:
        if (r23.hasNext() == false) goto L51;
        Object r24 = r23.next();
        Pair r25 = (Pair) r24;
        if (((CommunityFoldFixConfig) n.a.getValue()).getEnableInteractivity() == true) goto L34;
    L36:
        boolean r26 = false;
    L37:
        if (r26 == true) goto L39;
    L48:
        boolean r27 = true;
    L49:
        if (r27 == false) goto L30;
        r21.add(r24);
        goto L30
    L39:
        if (((com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d) r25.getFirst()).a >= a.h) goto L41;
        boolean r28 = true;
    L42:
        if (r28 == false) goto L45;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.j.c.c((com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d) r25.getFirst(), r0.d, ((c) r25.getSecond()).d());
        PublicScreenTraceMonitor.g(((c) r25.getSecond()).d(), Boolean.FALSE, Boolean.TRUE, PublicScreenTraceMonitor.AdjustStep.DROP, ((com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d) r25.getFirst()).toString());
    L45:
        if ((!r28) == true) goto L48;
        r27 = false;
        goto L49
    L41:
        r28 = false;
        goto L42
    L34:
        if (((com.bytedance.android.livesdk.interactivity.api.settings.config.i) n0.a.getValue()).dropWrongHeight == false) goto L36;
        r26 = true;
        goto L37
    L51:
        Iterator r29 = r21.iterator();
        if (r29.hasNext() == false) goto L63;
        r3 = r29.next();
        if (r29.hasNext() == false) goto L63;
        int r30 = ((com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d) ((Pair) r3).getFirst()).a;
    L58:
        Object r31 = r29.next();
        int r33 = ((com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d) ((Pair) r31).getFirst()).a;
        if (r30 <= r33) goto L62;
        r3 = r31;
        r30 = r33;
    L62:
        if (r29.hasNext() == true) goto L58;
    L63:
        Pair r34 = (Pair) r3;
        if (r34 == null) goto L81;
        r0.a(a.b((com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d) r34.getFirst(), (c) r34.getSecond(), r0.c, r0.b), ((c) r34.getSecond()).d(), false);
        return;
    L81:
        return;
    L23:
        r13 = new m(r11);
        goto L24
    }

    @Override // s42.a
    public final void e() {
        this.b.e();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.h
    public final void h() {
        P();
        M();
    }

    @Override // s42.a
    public final void W(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        this.b.W(r2);
    }

    public TextMessageAdjuster(DataCenter r9, RoomContext r10, com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.e r11, com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.i r13) {
        Intrinsics.checkNotNullParameter(r9, "dataCenter");
        Intrinsics.checkNotNullParameter(r10, "roomDataContext");
        Intrinsics.checkNotNullParameter(r11, "iInteractUIContext");
        Intrinsics.checkNotNullParameter(r13, "publicScreenContainer");
        LiveRoomEnvStateHolder r3 = new LiveRoomEnvStateHolder(r9, r10, r11);
        this.b = r3;
        this.a = new a(r9, r3, r11, z.o(r9), r13, r10);
        Object r14 = r10.getInteractivityContext().getValue();
        if ((r14 instanceof InteractivityContext) == true) goto L5;
        r14 = null;
    L5:
        InteractivityContext r15 = (InteractivityContext) r14;
        if (r15 != null) goto L8;
        return;
    L8:
        if (r15.getLiveRoomEnvStateHolder().getValue() != null) goto L12;
        r15.getLiveRoomEnvStateHolder().e(new TextMessageAdjuster$$special$$inlined$let$lambda$1(this));
        return;
    }
}
