package com.bytedance.android.live.liveinteract.voicechat.toolbar;

import android.content.Context;
import android.view.View;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.liveinteract.animator.LiveAnimator;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdk.config.dg1;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.live.datacontext.j;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import pp1.m;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/liveinteract/voicechat/toolbar/ToolbarRoomBattleBehavior;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/c0$b;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lvlc/l;", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ToolbarRoomBattleBehavior implements c0.b, Observer<KVData>, l {
    public View a;
    public Context b;
    public IRoom c;
    public DataCenter d;
    public View e;
    public final CompositeDisposable f;
    public ImageView g;
    public LiveAnimator h;
    public Function0<Unit> i;
    public vlc.d j;

    public final /* synthetic */ void Bh(ToolbarButton r1) {
    }

    public final /* synthetic */ void Mr(s r1) {
    }

    public final /* synthetic */ void SY(s r1) {
    }

    public final /* synthetic */ void Y6() {
    }

    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    public final /* synthetic */ void onHide(boolean r1) {
    }

    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    public ToolbarRoomBattleBehavior() {
        this.f = new CompositeDisposable();
    }

    public static void a(String r4) {
        LinkedHashMap r0 = new LinkedHashMap();
        TalkRoomLogUtils.J0(r0);
        TalkRoomLogUtils.B0(r0, null, null, 6);
        TalkRoomLogUtils.V0(r0);
        r0.put("request_page", "interact_panel");
        r0.put("function_type", ((IInteractService) k.n(IInteractService.class)).getCurrentFunctionType());
        r0.put("action_type", r4);
        j0.l().sendLog("livesdk_anchor_chatroom_link_room_icon", r0, new Object[]{IRoom.class});
    }

    public final void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r2) {
        Intrinsics.checkNotNullParameter(r2, "command");
        if ((r2 instanceof m) == true) goto L5;
        return;
    L5:
        if (((m) r2).a != 0) goto L9;
        ALogger.w("ToolbarMultiSceneGamePlayBehavior", "ToolbarMultiSceneGamePlayBehavior VISIBLE");
        TalkRoomLogUtils.F();
        return;
    }

    public final void onChanged(Object r7) {
        KVData r8 = (KVData) r7;
        a0 r0 = null;
        if (r8 == null) goto L5;
        String r1 = r8.getKey();
    L7:
        if (Intrinsics.areEqual(r1, "cmd_show_self_waiting_behavior") == false) goto L42;
        Map r9 = (Map) r8.getData();
        if (r9 == null) goto L11;
        Object r2 = r9.get("play_mode");
    L13:
        if ((r2 instanceof String) == true) goto L15;
        r2 = null;
    L15:
        final String r3 = (String) r2;
        if (r9 == null) goto L18;
        Object r10 = r9.get("ringing");
    L20:
        if ((r10 instanceof Boolean) == true) goto L23;
        r10 = null;
    L23:
        if (Intrinsics.areEqual((Boolean) r10, Boolean.TRUE) == false) goto L34;
        if (this.h != null) goto L57;
        ALogger.e("ToolbarMultiSceneGamePlayBehavior", "playRingAnimation.星球播放等待动画");
        ImageView r11 = this.g;
        if (r11 == null) goto L29;
        UtilityKotlinExtentionsKt.w(r11);
    L29:
        fd0.f r4 = LiveAnimator.a(new View[]{this.g});
        r4.a.b = 1000;
        r4.c("rotation", new float[]{0.0f, 360.0f});
        LiveAnimator r5 = r4.a;
        r5.f = 1;
        r5.e = -1;
        this.h = r5;
        r5.d = new PathInterpolator(0.53f, 0.15f, 0.48f, 0.81f);
        LiveAnimator r12 = this.h;
        if (r12 == null) goto L32;
        r12.c();
    L32:
        this.i = new AnonymousClass1(this, r3);
        return;
    L57:
        return;
    L34:
        if (this.h == null) goto L59;
        this.i = null;
        ALogger.e("ToolbarMultiSceneGamePlayBehavior", "cancelRingAnimation.星球结束等待动画");
        ImageView r13 = this.g;
        if (r13 == null) goto L38;
        UtilityKotlinExtentionsKt.t(r13);
    L38:
        LiveAnimator r14 = this.h;
        if (r14 == null) goto L41;
        r14.b();
    L41:
        this.h = null;
        this.i = null;
        return;
    L59:
        return;
    L18:
        r10 = null;
        goto L20
    L11:
        r2 = null;
        goto L13
    L42:
        if (r8 == null) goto L44;
        String r6 = r8.getKey();
    L46:
        if (Intrinsics.areEqual(r6, "cmd_show_self_bubble_on_room_link") == false) goto L61;
        final pp1.c r15 = (pp1.c) r8.getData();
        if (r15 == null) goto L62;
        final View r16 = this.a;
        if (r16 == null) goto L63;
        j r17 = com.bytedance.android.live.liveinteract.api.utils.m.o(this.d).c();
        if (r17 == null) goto L54;
        r0 = (a0) r17.getValue();
    L54:
        if (r0 == null) goto L64;
        int r18 = r15.k;
        DataCenter r19 = this.d;
        Context r20 = this.b;
        Intrinsics.checkNotNull(r20);
        r0.addBubbleLocal(r15, r18, r0.createToolbarBubble(r19, r20, r16), new ToolbarRoomBattleBehavior$showBubbleBindClickOpenSelf$$inlined$let$lambda$1(r16, this, r15));
        return;
    L64:
        return;
    L63:
        return;
    L62:
        return;
    L61:
        return;
    L44:
        r6 = null;
        goto L46
    L5:
        r1 = null;
        goto L7
    }

    public final void onClick(View r3) {
        if (((dg1) vm2.d.H1.getValue(null, vm2.d.a[135(0x87, float:1.89E-43)])).a() == false) goto L8;
        Function0<Unit> r4 = this.i;
        if (r4 == null) goto L8;
        Unit r5 = (Unit) r4.invoke();
        return;
    L8:
        Map<String, String> r6 = MapsKt.mapOf(TuplesKt.to("request_page", "link_room_icon"));
        ((IInteractService) k.n(IInteractService.class)).clickLinkRoomFightIcon(r6);
        a("click");
    }

    public final void onMessage(tlc.d r4) {
        if (r4 == null) goto L5;
        Integer r1 = Integer.valueOf(r4.getIntType());
    L6:
        int r2 = MessageType.LINKER.getIntType();
        if (r1 != null) goto L10;
        return;
    L10:
        if (r1.intValue() == r2) goto L12;
        return;
    L12:
        if ((r4 instanceof h1) == true) goto L14;
        return;
    L14:
        if (((h1) r4).getMType() != 2) goto L25;
        ALogger.e("ToolbarMultiSceneGamePlayBehavior", "cancelRingAnimation.星球结束等待动画");
        ImageView r5 = this.g;
        if (r5 == null) goto L18;
        UtilityKotlinExtentionsKt.t(r5);
    L18:
        LiveAnimator r6 = this.h;
        if (r6 == null) goto L21;
        r6.b();
    L21:
        this.h = null;
        this.i = null;
        return;
    L25:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void setAlpha(float r2) {
        View r0 = this.a;
        if (r0 == null) goto L6;
        r0.setAlpha(r2);
        return;
    }

    public final void R9(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        vlc.d r4 = this.j;
        if (r4 == null) goto L5;
        r4.removeMessageListener(this);
    L5:
        this.f.clear();
        r3.removeObserver("cmd_show_self_waiting_behavior", this);
        r3.removeObserver("cmd_show_self_bubble_on_room_link", this);
        r3.put("cmd_multi_room_link_behavior_shown", Boolean.FALSE);
    }

    public final void p4(View r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        this.a = r3;
        this.g = (ImageView) r3.findViewById(2131375547);
        this.b = r3.getContext();
        com.bytedance.android.live.core.utils.a0.m(r4);
        this.c = com.bytedance.android.live.core.utils.a0.n(r4);
        this.d = r4;
        r4.observe("cmd_show_self_waiting_behavior", this);
        r4.observe("cmd_show_self_bubble_on_room_link", this);
        r4.put("cmd_multi_room_link_behavior_shown", Boolean.TRUE);
        vlc.d r5 = (vlc.d) r4.get("data_message_manager", null);
        this.j = r5;
        if (r5 == null) goto L5;
        r5.addMessageListener(MessageType.LINKER.getKey(), this);
    L5:
        this.e = r3.findViewById(2131392581);
        a("show");
    }
}
