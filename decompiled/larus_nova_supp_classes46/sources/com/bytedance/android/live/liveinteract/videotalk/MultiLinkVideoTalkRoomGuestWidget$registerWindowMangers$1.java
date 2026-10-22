package com.bytedance.android.live.liveinteract.videotalk;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.CommonMultiLinkWindowManager;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.ConcertMultiLinkWindowManager;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.DynamicEqualMultiLinkWindowManager;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.KtvSingChallengeMultiLinkWindowManager;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.MultiLinkEnlargeWindowManager;
import com.bytedance.android.live.liveinteract.revenue.fight.wm.MultiLinkVideoTeamFightWindowManager;
import com.bytedance.android.live.liveinteract.revenue.game.wm.MultiLinkGameWindowManager;
import com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui.MultiLinkLinkRoomFightWindowManager;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\t\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Ljava/lang/Class;", "Ltf0/o;", "p1", "Lzj0/c;", "p2", "Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/i;", "p3", "invoke", "(Ljava/lang/Class;Lzj0/c;Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/i;)Ltf0/o;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final /* synthetic */ class MultiLinkVideoTalkRoomGuestWidget$registerWindowMangers$1 extends FunctionReferenceImpl implements Function3<Class<? extends tf0.o>, zj0.c, com.bytedance.android.live.liveinteract.plantform.commonwindow.i, tf0.o> {
    public MultiLinkVideoTalkRoomGuestWidget$registerWindowMangers$1(MultiLinkVideoTalkRoomGuestWidget r8) {
        super(3, r8, MultiLinkVideoTalkRoomGuestWidget.class, "createBaseCommonWindowManager", "createBaseCommonWindowManager(Ljava/lang/Class;Lcom/bytedance/android/live/liveinteract/videotalk/switcher/SwitchLayoutType;Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/GetLayoutConfigResponse;)Lcom/bytedance/android/live/liveinteract/linkbase/api/IWindowManager;", 0);
    }

    public final tf0.o invoke(Class<? extends tf0.o> r20, zj0.c r21, com.bytedance.android.live.liveinteract.plantform.commonwindow.i r22) {
        Intrinsics.checkNotNullParameter(r20, "p1");
        Intrinsics.checkNotNullParameter(r22, "p3");
        MultiLinkVideoTalkRoomGuestWidget r2 = (MultiLinkVideoTalkRoomGuestWidget) ((CallableReference) this).receiver;
        int r3 = MultiLinkVideoTalkRoomGuestWidget.i3;
        View r4 = ((Widget) r2).contentView;
        if (r4 == null) goto L5;
        View r5 = r4.findViewById(2131363980);
    L7:
        if (r5 == null) goto L9;
        r5.setVisibility(0);
    L9:
        ln0.a r6 = yg0.h.a;
        Pair r7 = yg0.h.c(r21);
        ((Number) r7.getFirst()).intValue();
        int r8 = ((Number) r7.getSecond()).intValue();
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r0 = r22.a;
        TalkRoomBusinessFullLinkMonitor r9 = TalkRoomBusinessFullLinkMonitor.a;
        String r10 = String.valueOf(r21);
        String r11 = r0.toString();
        r9.getClass();
        Intrinsics.checkNotNullParameter(r10, "switchType");
        Intrinsics.checkNotNullParameter(r11, "windowLayoutString");
        if (nd0.e.b() != true) goto L12;
    L15:
        JSONObject r14 = new JSONObject();
        r14.put("switch_type", r10);
        r14.put("window_layout", r11);
        nd0.c.o(nd0.c.a, LinkMonitorData.CommonWindowReadLayoutConfig, r14, 0, null, false, 28);
    L16:
        boolean r12 = gh0.b.a;
        gh0.b.a("SceneOrUiLayoutChange", "getLinkWindowLayoutConfig, switchType = " + r21 + ", layoutConfig = " + r0.toString(), false);
        if (r8 == 2) goto L69;
        if (r8 != 4) goto L20;
        Context r13 = ((Widget) r2).context;
        ConstraintLayout r15 = ((Widget) r2).contentView.findViewById(2131363980);
        if (r15 == null) goto L68;
        tf0.o r18 = new MultiLinkVideoTeamFightWindowManager(r13, r15, r0, r21, r2.md(), ((Widget) r2).dataCenter, r2, r2, ((Widget) r2).containerView.findViewById(2131392689), (GLSurfaceView) ((Widget) r2).containerView.findViewById(2131375528), r2.getLiveStream(), r2);
    L72:
        return r18;
    L68:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
    L20:
        if (r8 != 9) goto L22;
        Context r16 = ((Widget) r2).context;
        ConstraintLayout r17 = ((Widget) r2).contentView.findViewById(2131363980);
        if (r17 == null) goto L63;
        r18 = new KtvSingChallengeMultiLinkWindowManager(r16, r17, r0, r21, r2.md(), ((Widget) r2).dataCenter, r2, r2, ((Widget) r2).containerView.findViewById(2131392689), (GLSurfaceView) ((Widget) r2).containerView.findViewById(2131375528), r2.getLiveStream(), r2);
        goto L72
    L63:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
    L22:
        if (r8 != 15) goto L24;
        Context r19 = ((Widget) r2).context;
        ConstraintLayout r23 = ((Widget) r2).contentView.findViewById(2131363980);
        if (r23 == null) goto L58;
        ConstraintLayout r24 = r23;
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r110 = r2.md();
        eh0.b r111 = r2.g;
        if (r111 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("linkCrossRoomGameDataMergeCenter");
    L56:
        r18 = new MultiLinkGameWindowManager(r19, r24, r0, r21, r110, r111, ((Widget) r2).dataCenter, r2, r2, ((Widget) r2).containerView.findViewById(2131392689), (GLSurfaceView) ((Widget) r2).containerView.findViewById(2131375528), r2.getLiveStream(), r2);
        goto L72
    L58:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
    L24:
        if (r8 != 43) goto L26;
        Context r25 = ((Widget) r2).context;
        ConstraintLayout r26 = ((Widget) r2).contentView.findViewById(2131363980);
        if (r26 == null) goto L50;
        r18 = new MultiLinkEnlargeWindowManager(r25, r26, r0, r21, r2.md(), ((Widget) r2).dataCenter, r2, r2, ((Widget) r2).containerView.findViewById(2131392689), (GLSurfaceView) ((Widget) r2).containerView.findViewById(2131375528), r2.getLiveStream(), r2);
        goto L72
    L50:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
    L26:
        if (r8 != 62) goto L28;
    L41:
        Context r27 = ((Widget) r2).context;
        ConstraintLayout r28 = ((Widget) r2).contentView.findViewById(2131363980);
        if (r28 == null) goto L45;
        r18 = new ConcertMultiLinkWindowManager(r27, r28, r0, r21, r2.md(), ((Widget) r2).dataCenter, r2, r2, ((Widget) r2).containerView.findViewById(2131392689), (GLSurfaceView) ((Widget) r2).containerView.findViewById(2131375528), r2.getLiveStream(), r2);
        goto L72
    L45:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
    L28:
        if (r8 == 63) goto L41;
        if (aj0.b.c(r8) == false) goto L36;
        Context r29 = ((Widget) r2).context;
        ConstraintLayout r30 = ((Widget) r2).contentView.findViewById(2131363980);
        if (r30 == null) goto L35;
        r18 = new MultiLinkLinkRoomFightWindowManager(r29, r30, r0, r21, r2.md(), r2.p5(), ((Widget) r2).dataCenter, r2, r2, ((Widget) r2).containerView.findViewById(2131392689), (GLSurfaceView) ((Widget) r2).containerView.findViewById(2131375528), r2.getLiveStream(), false, r2);
        goto L72
    L35:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
    L36:
        Context r31 = ((Widget) r2).context;
        ConstraintLayout r32 = ((Widget) r2).contentView.findViewById(2131363980);
        if (r32 == null) goto L40;
        r18 = new CommonMultiLinkWindowManager(r31, r32, r0, r21, r2.md(), ((Widget) r2).dataCenter, r2, r2, ((Widget) r2).containerView.findViewById(2131392689), (GLSurfaceView) ((Widget) r2).containerView.findViewById(2131375528), r2.getLiveStream(), r2);
        goto L72
    L40:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
    L69:
        Context r33 = ((Widget) r2).context;
        ConstraintLayout r34 = ((Widget) r2).contentView.findViewById(2131363980);
        if (r34 == null) goto L74;
        r18 = new DynamicEqualMultiLinkWindowManager(r33, r34, r0, r21, r2.md(), ((Widget) r2).dataCenter, r2, r2, ((Widget) r2).containerView.findViewById(2131392689), (GLSurfaceView) ((Widget) r2).containerView.findViewById(2131375528), r2.getLiveStream(), r2);
        goto L72
    L74:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
    L12:
        if (nd0.e.c() == true) goto L15;
        jy0.b.c("ttlive_link", "read commonWindowLayoutConfig, switch_type = " + r10 + ", window_layout = " + r11, null, 4);
        goto L16
    L5:
        r5 = null;
        goto L7
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        return invoke((Class) r1, (zj0.c) r2, (com.bytedance.android.live.liveinteract.plantform.commonwindow.i) r3);
    }
}
