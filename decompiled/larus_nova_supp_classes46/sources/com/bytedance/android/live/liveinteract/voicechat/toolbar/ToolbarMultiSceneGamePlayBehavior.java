package com.bytedance.android.live.liveinteract.voicechat.toolbar;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.liveinteract.animator.LiveAnimator;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.i0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdk.config.dg1;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.live.datacontext.j;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import pp1.m;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/liveinteract/voicechat/toolbar/ToolbarMultiSceneGamePlayBehavior;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/c0$b;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lvlc/l;", "<init>", "()V", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ToolbarMultiSceneGamePlayBehavior implements c0.b, Observer<KVData>, l {
    public View a;
    public Context b;
    public IRoom c;
    public DataCenter d;
    public View e;
    public final CompositeDisposable f;
    public Map<Long, Boolean> g;
    public ImageView h;
    public LiveAnimator i;
    public Function0<Unit> j;
    public vlc.d k;

    public static final class a {
    }

    static {
    }

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

    public final /* synthetic */ void setAlpha(float r1) {
    }

    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    public ToolbarMultiSceneGamePlayBehavior() {
        this.f = new CompositeDisposable();
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
        if (this.i != null) goto L57;
        ALogger.e("ToolbarMultiSceneGamePlayBehavior", "playRingAnimation.星球播放等待动画");
        ImageView r11 = this.h;
        if (r11 == null) goto L29;
        UtilityKotlinExtentionsKt.w(r11);
    L29:
        fd0.f r4 = LiveAnimator.a(new View[]{this.h});
        r4.a.b = 1000;
        r4.c("rotation", new float[]{0.0f, 360.0f});
        LiveAnimator r5 = r4.a;
        r5.f = 1;
        r5.e = -1;
        this.i = r5;
        r5.d = new PathInterpolator(0.53f, 0.15f, 0.48f, 0.81f);
        LiveAnimator r12 = this.i;
        if (r12 == null) goto L32;
        r12.c();
    L32:
        this.j = new AnonymousClass1(this, r3);
        return;
    L57:
        return;
    L34:
        if (this.i == null) goto L59;
        this.j = null;
        ALogger.e("ToolbarMultiSceneGamePlayBehavior", "cancelRingAnimation.星球结束等待动画");
        ImageView r13 = this.h;
        if (r13 == null) goto L38;
        UtilityKotlinExtentionsKt.t(r13);
    L38:
        LiveAnimator r14 = this.i;
        if (r14 == null) goto L41;
        r14.b();
    L41:
        this.i = null;
        this.j = null;
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
        if (Intrinsics.areEqual(r6, "cmd_show_self_bubble_on_scene_game") == false) goto L61;
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
        r0.addBubbleLocal(r15, r18, r0.createToolbarBubble(r19, r20, r16), new ToolbarMultiSceneGamePlayBehavior$showBubbleBindClickOpenSelf$$inlined$let$lambda$1(r16, this, r15));
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

    public final void onClick(View r7) {
        if (((dg1) vm2.d.H1.getValue(null, vm2.d.a[135(0x87, float:1.89E-43)])).a() == false) goto L8;
        Function0<Unit> r8 = this.j;
        if (r8 == null) goto L8;
        Unit r9 = (Unit) r8.invoke();
        return;
    L8:
        k.n(IBaseLiveActionHandler.class).handle(this.b, UriProtector.parse(vm2.d.Q().a()).buildUpon().appendQueryParameter("url", vm2.d.Q().b()).build().toString());
        if (((Boolean) b6.l0.getValue()).booleanValue() == false) goto L19;
        Map<Long, Boolean> r10 = this.g;
        if (r10 == null) goto L16;
        Iterator<Map.Entry<Long, Boolean>> r11 = r10.entrySet().iterator();
    L14:
        if (r11.hasNext() == false) goto L16;
        Map.Entry<Long, Boolean> r0 = r11.next();
        com.bytedance.android.livesdk.sharedpref.e r2 = b6.m0;
        SparseArray r3 = (SparseArray) r2.getValue();
        r3.put((int) r0.getKey().longValue(), Boolean.FALSE);
        com.bytedance.android.livesdk.sharedpref.f.d(r2, r3);
    L16:
        com.bytedance.android.livesdk.sharedpref.e r12 = b6.l0;
        Boolean r1 = Boolean.FALSE;
        r12.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r12, r1);
        View r13 = this.e;
        if (r13 == null) goto L19;
        r13.setVisibility(8);
    L19:
        ALogger.w("ToolbarMultiSceneGamePlayBehavior", "ToolbarMultiSceneGamePlayBehavior onClick");
        i0 r14 = TalkRoomLogUtils.a;
        LinkedHashMap r15 = new LinkedHashMap();
        com.bytedance.live.datacontext.m r4 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r4 == null) goto L24;
        IRoom r5 = (IRoom) r4.getValue();
        if (r5 == null) goto L24;
        long r6 = r5.getRoomId();
    L25:
        com.bytedance.live.datacontext.m r16 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r16 == null) goto L31;
        IRoom r17 = (IRoom) r16.getValue();
        if (r17 == null) goto L31;
        Object r18 = r17.getOwnerUserIdString();
        if (r18 == null) goto L31;
    L32:
        TalkRoomLogUtils.J0(r15);
        TalkRoomLogUtils.B0(r15, null, null, 6);
        r15.put("room_id", String.valueOf(r6));
        r15.put("anchor_id", r18.toString());
        j0.l().sendLog("livesdk_anchor_connection_playmode_entry_click", r15, new Object[]{IRoom.class});
        return;
    L31:
        r18 = 0L;
    L24:
        r6 = 0;
        goto L25
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
        ImageView r5 = this.h;
        if (r5 == null) goto L18;
        UtilityKotlinExtentionsKt.t(r5);
    L18:
        LiveAnimator r6 = this.i;
        if (r6 == null) goto L21;
        r6.b();
    L21:
        this.i = null;
        this.j = null;
        return;
    L25:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void R9(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        vlc.d r4 = this.k;
        if (r4 == null) goto L5;
        r4.removeMessageListener(this);
    L5:
        this.f.clear();
        r3.removeObserver("cmd_show_self_waiting_behavior", this);
        r3.removeObserver("cmd_show_self_bubble_on_scene_game", this);
        r3.put("cmd_multi_scene_game_behavior_shown", Boolean.FALSE);
        ALogger.e("ToolbarMultiSceneGamePlayBehavior", "onUnload.星球icon卸载");
    }

    public final void p4(View r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        this.a = r3;
        this.h = (ImageView) r3.findViewById(2131375547);
        this.b = r3.getContext();
        com.bytedance.android.live.core.utils.a0.m(r4);
        this.c = com.bytedance.android.live.core.utils.a0.n(r4);
        this.d = r4;
        r4.observe("cmd_show_self_waiting_behavior", this);
        r4.observe("cmd_show_self_bubble_on_scene_game", this);
        r4.put("cmd_multi_scene_game_behavior_shown", Boolean.TRUE);
        r4.observe("cmd_show_self_bubble_on_openplatform_behavior", this);
        vlc.d r5 = (vlc.d) r4.get("data_message_manager", null);
        this.k = r5;
        if (r5 == null) goto L5;
        r5.addMessageListener(MessageType.LINKER.getKey(), this);
    L5:
        this.e = r3.findViewById(2131392581);
        if (((Boolean) b6.l0.getValue()).booleanValue() == false) goto L10;
        View r6 = this.e;
        if (r6 == null) goto L13;
        r6.setVisibility(0);
    L13:
        ALogger.e("ToolbarMultiSceneGamePlayBehavior", "onLoad.星球icon可见");
        return;
    L10:
        View r7 = this.e;
        if (r7 == null) goto L13;
        r7.setVisibility(8);
        goto L13
    }
}
