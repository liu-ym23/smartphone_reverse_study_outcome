package com.bytedance.android.live.multilink.voicechat.impl.widget;

import android.opengl.GLSurfaceView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.audio.wm.VoiceCommonMultiLinkWindowManager;
import com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui.MultiLinkLinkRoomFightWindowManager;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\t\u001a\u0004\u0018\u00010\u00012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Ljava/lang/Class;", "Ltf0/o;", "p1", "Lzj0/c;", "p2", "Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/i;", "p3", "invoke", "(Ljava/lang/Class;Lzj0/c;Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/i;)Ltf0/o;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final /* synthetic */ class MultiLinkVoiceChatRoomGuestWidget$registerWindowManagers$1 extends FunctionReferenceImpl implements Function3<Class<? extends tf0.o>, zj0.c, com.bytedance.android.live.liveinteract.plantform.commonwindow.i, tf0.o> {
    public MultiLinkVoiceChatRoomGuestWidget$registerWindowManagers$1(MultiLinkVoiceChatRoomGuestWidget r8) {
        super(3, r8, MultiLinkVoiceChatRoomGuestWidget.class, "createBaseCommonWindowManager", "createBaseCommonWindowManager(Ljava/lang/Class;Lcom/bytedance/android/live/liveinteract/videotalk/switcher/SwitchLayoutType;Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/GetLayoutConfigResponse;)Lcom/bytedance/android/live/liveinteract/linkbase/api/IWindowManager;", 0);
    }

    public final tf0.o invoke(Class<? extends tf0.o> r19, zj0.c r20, com.bytedance.android.live.liveinteract.plantform.commonwindow.i r21) {
        Intrinsics.checkNotNullParameter(r19, "p1");
        Intrinsics.checkNotNullParameter(r21, "p3");
        MultiLinkVoiceChatRoomGuestWidget r2 = (MultiLinkVoiceChatRoomGuestWidget) ((CallableReference) this).receiver;
        int r3 = MultiLinkVoiceChatRoomGuestWidget.e3;
        r2.getClass();
        ln0.a r4 = yg0.h.a;
        Pair r5 = yg0.h.c(r20);
        ((Number) r5.getFirst()).intValue();
        int r6 = ((Number) r5.getSecond()).intValue();
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r7 = r21.a;
        ConstraintLayout r0 = ((Widget) r2).contentView.findViewById(2131363980);
        if (r0 == null) goto L10;
        ConstraintLayout r8 = r0;
        r8.setVisibility(0);
        if (aj0.b.c(r6) == false) goto L8;
        return new MultiLinkLinkRoomFightWindowManager(((Widget) r2).context, r8, r7, r20, r2.md(), r2.p5(), ((Widget) r2).dataCenter, r2, r2, ((Widget) r2).containerView.findViewById(2131392689), (GLSurfaceView) ((Widget) r2).containerView.findViewById(2131375529), r2.s, true, r2);
    L8:
        return new VoiceCommonMultiLinkWindowManager(((Widget) r2).context, r8, r7, r20, r2.md(), ((Widget) r2).dataCenter, r2, r2, ((Widget) r2).containerView.findViewById(2131392689), (GLSurfaceView) ((Widget) r2).containerView.findViewById(2131375529), r2.s, r2);
    L10:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        return invoke((Class) r1, (zj0.c) r2, (com.bytedance.android.live.liveinteract.plantform.commonwindow.i) r3);
    }
}
