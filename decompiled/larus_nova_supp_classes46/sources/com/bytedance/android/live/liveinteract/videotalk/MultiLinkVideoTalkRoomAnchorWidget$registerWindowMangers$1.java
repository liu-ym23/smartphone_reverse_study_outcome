package com.bytedance.android.live.liveinteract.videotalk;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.CommonMultiLinkWindowManager;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.DynamicEqualMultiLinkWindowManager;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.KtvSingChallengeMultiLinkWindowManager;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.MultiLinkEnlargeWindowManager;
import com.bytedance.android.live.liveinteract.revenue.fight.wm.MultiLinkVideoTeamFightWindowManager;
import com.bytedance.android.live.liveinteract.revenue.game.wm.MultiLinkGameWindowManager;
import com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui.MultiLinkLinkRoomFightWindowManager;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\t\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Ljava/lang/Class;", "Ltf0/o;", "p1", "Lzj0/c;", "p2", "Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/i;", "p3", "invoke", "(Ljava/lang/Class;Lzj0/c;Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/i;)Ltf0/o;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final /* synthetic */ class MultiLinkVideoTalkRoomAnchorWidget$registerWindowMangers$1 extends FunctionReferenceImpl implements Function3<Class<? extends tf0.o>, zj0.c, com.bytedance.android.live.liveinteract.plantform.commonwindow.i, tf0.o> {
    public MultiLinkVideoTalkRoomAnchorWidget$registerWindowMangers$1(MultiLinkVideoTalkRoomAnchorWidget r8) {
        super(3, r8, MultiLinkVideoTalkRoomAnchorWidget.class, "createBaseCommonWindowManager", "createBaseCommonWindowManager(Ljava/lang/Class;Lcom/bytedance/android/live/liveinteract/videotalk/switcher/SwitchLayoutType;Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/GetLayoutConfigResponse;)Lcom/bytedance/android/live/liveinteract/linkbase/api/IWindowManager;", 0);
    }

    public final tf0.o invoke(Class<? extends tf0.o> r19, zj0.c r20, com.bytedance.android.live.liveinteract.plantform.commonwindow.i r21) {
        Intrinsics.checkNotNullParameter(r19, "p1");
        Intrinsics.checkNotNullParameter(r21, "p3");
        MultiLinkVideoTalkRoomAnchorWidget r2 = (MultiLinkVideoTalkRoomAnchorWidget) ((CallableReference) this).receiver;
        int r3 = MultiLinkVideoTalkRoomAnchorWidget.h2;
        r2.getClass();
        ln0.a r4 = yg0.h.a;
        Pair r5 = yg0.h.c(r20);
        int r6 = ((Number) r5.getFirst()).intValue();
        int r7 = ((Number) r5.getSecond()).intValue();
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r8 = r21.a;
        if (r6 != 8) goto L5;
        if (r7 != 7) goto L5;
    L19:
        ConstraintLayout r9 = ((Widget) r2).contentView.findViewById(2131370474);
        if (r9 == null) goto L24;
        ConstraintLayout r10 = r9;
    L22:
        ConstraintLayout r11 = r10;
        if (MultiLinkLoadWidgetUtils.g() == false) goto L35;
        int r12 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.a;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r13 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.d(((Widget) r2).dataCenter);
        if (r13 == null) goto L35;
        ConstraintLayout r14 = r13.getLinkSeatWindowView();
        if (r14 == null) goto L35;
        UtilityKotlinExtentionsKt.q(r14);
        ((FrameLayout) r11.findViewById(2131378012)).addView(r14);
    L35:
        r11.setVisibility(0);
        if (r7 != 2) goto L38;
        Context r15 = ((Widget) r2).context;
        ConstraintLayout r0 = ((Widget) r2).contentView.findViewById(2131363980);
        if (r0 == null) goto L63;
        return new DynamicEqualMultiLinkWindowManager(r15, r0, r8, r20, r2.md(), ((Widget) r2).dataCenter, r2, r2, ((Widget) r2).containerView.findViewById(2131392689), (GLSurfaceView) ((Widget) r2).containerView.findViewById(2131375528), r2.v, r2);
    L63:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
    L38:
        if (r7 == 4) goto L71;
        if (r7 == 9) goto L70;
        if (r7 != 15) goto L43;
        Context r16 = ((Widget) r2).context;
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r17 = r2.md();
        eh0.b r18 = r2.f;
        if (r18 != null) goto L69;
        Intrinsics.throwUninitializedPropertyAccessException("linkCrossRoomGameDataMergeCenter");
    L69:
        return new MultiLinkGameWindowManager(r16, r11, r8, r20, r17, r18, ((Widget) r2).dataCenter, r2, r2, ((Widget) r2).containerView.findViewById(2131392689), (GLSurfaceView) ((Widget) r2).containerView.findViewById(2131375528), r2.v, r2);
    L43:
        if (r7 == 43) goto L68;
        if (aj0.b.c(r7) == false) goto L67;
        Context r22 = ((Widget) r2).context;
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r23 = r2.md();
        eh0.b r110 = r2.e;
        if (r110 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("linkRoomFightDataMergeCenter");
    L66:
        return new MultiLinkLinkRoomFightWindowManager(r22, r11, r8, r20, r23, r110, ((Widget) r2).dataCenter, r2, r2, ((Widget) r2).containerView.findViewById(2131392689), (GLSurfaceView) ((Widget) r2).containerView.findViewById(2131375528), r2.v, false, r2);
    L67:
        return new CommonMultiLinkWindowManager(((Widget) r2).context, r11, r8, r20, r2.md(), ((Widget) r2).dataCenter, r2, r2, ((Widget) r2).containerView.findViewById(2131392689), (GLSurfaceView) ((Widget) r2).containerView.findViewById(2131375528), r2.v, r2);
    L68:
        return new MultiLinkEnlargeWindowManager(((Widget) r2).context, r11, r8, r20, r2.md(), ((Widget) r2).dataCenter, r2, r2, ((Widget) r2).containerView.findViewById(2131392689), (GLSurfaceView) ((Widget) r2).containerView.findViewById(2131375528), r2.v, r2);
    L70:
        return new KtvSingChallengeMultiLinkWindowManager(((Widget) r2).context, r11, r8, r20, r2.md(), ((Widget) r2).dataCenter, r2, r2, ((Widget) r2).containerView.findViewById(2131392689), (GLSurfaceView) ((Widget) r2).containerView.findViewById(2131375528), r2.v, r2);
    L71:
        return new MultiLinkVideoTeamFightWindowManager(((Widget) r2).context, r11, r8, r20, r2.md(), ((Widget) r2).dataCenter, r2, r2, ((Widget) r2).containerView.findViewById(2131392689), (GLSurfaceView) ((Widget) r2).containerView.findViewById(2131375528), r2.v, r2);
    L24:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
    L5:
        if (r6 != 8) goto L8;
        if (r7 == 15) goto L19;
    L8:
        if (r6 != 12) goto L10;
        if (r7 == 7) goto L19;
    L10:
        if (r6 == 12) goto L12;
    L13:
        if (r6 == 12) goto L15;
    L16:
        if (r6 == 12) goto L18;
    L25:
        ConstraintLayout r24 = ((Widget) r2).contentView.findViewById(2131363980);
        if (r24 == null) goto L65;
        r10 = r24;
        goto L22
    L65:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
    L18:
        if (r7 != 111) goto L25;
    L15:
        if (r7 == 109) goto L19;
    L12:
        if (r7 == 110) goto L19;
        goto L13
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        return invoke((Class) r1, (zj0.c) r2, (com.bytedance.android.live.liveinteract.plantform.commonwindow.i) r3);
    }
}
