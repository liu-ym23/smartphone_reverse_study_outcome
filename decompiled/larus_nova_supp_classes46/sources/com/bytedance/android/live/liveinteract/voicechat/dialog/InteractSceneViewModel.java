package com.bytedance.android.live.liveinteract.voicechat.dialog;

import am2.x;
import android.content.Context;
import android.content.DialogInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.ordersong.feedback.KtvFeedbackDialog;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.TalkRoomFeedbackDialog;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongContext;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.i0;
import com.bytedance.android.live.liveinteract.plantform.utils.s0;
import com.bytedance.android.live.liveinteract.revenue.adventure.AdventureContext;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService;
import com.bytedance.android.live.liveinteract.voicechat.interactacting.InteractActingContext;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.u;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.ktvapi.KtvConflictScene;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdk.widget.z0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.DataContext;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import gd0.v;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0002J\u0012\u0010\u0010\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\u0012\u0010\u0013\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0012\u0010\u0015\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\u0018\u0010\u0016\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0017\u001a\u00020\u000b¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/live/liveinteract/voicechat/dialog/InteractSceneViewModel;", "Lcom/bytedance/live/datacontext/DataContext;", "()V", "getVoiceTalkRoomSceneAndUILayout", "Lkotlin/Pair;", "", "logAnchorSwitchToRadio", "", "oldScene", "logVoiceChatRoomOpenClick", "functionType", "", "onFinishKtv", "containFeedback", "", "disconnectSource", "switchChorusWithCheck", "context", "Landroid/content/Context;", "switchKtvWithCheck", "switchRadioWithCheck", "switchRoomChatWithCheck", "switchVoiceSceneWithCheck", "toScene", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class InteractSceneViewModel extends DataContext {

    public static final class a implements fd2.c {
        public final /* synthetic */ InteractSceneViewModel a;

        public final void onCancelClick() {
        }

        public a(InteractSceneViewModel r1) {
            this.a = r1;
        }

        public final void a(KtvFeedbackDialog r2, boolean r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "dialog");
            InteractSceneViewModel.access$onFinishKtv(this.a, r3, r4);
        }
    }

    public static final class b implements DialogInterface.OnClickListener {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r2, int r3) {
            IInteractService r4 = (IInteractService) jc1.k.f(IInteractService.class);
            if (r4 == null) goto L5;
            r4.updateSwitchSceneSource("link_setting_panel");
        L5:
            com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
            com.bytedance.android.live.liveinteract.voicechat.d r5 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
            if (r5 == null) goto L8;
            com.bytedance.android.live.liveinteract.voicechat.d.b.a(r5);
        L8:
            r2.dismiss();
        }
    }

    public static final class c implements DialogInterface.OnClickListener {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            r1.dismiss();
        }
    }

    public static final class d implements DialogInterface.OnClickListener {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            r1.dismiss();
            IInteractService r3 = (IInteractService) jc1.k.f(IInteractService.class);
            if (r3 == null) goto L5;
            r3.updateSwitchSceneSource("link_setting_panel");
        L5:
            com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
            com.bytedance.android.live.liveinteract.voicechat.d r4 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
            if (r4 == null) goto L9;
            r4.finishAudioTalk("link_setting_panel");
            return;
        }
    }

    public static final class e implements DialogInterface.OnClickListener {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            r1.dismiss();
        }
    }

    private final Pair<Integer, Integer> getVoiceTalkRoomSceneAndUILayout() {
        u r0 = com.bytedance.android.live.liveinteract.api.utils.m.d();
        int r1 = 0;
        if (r0 == null) goto L11;
        com.bytedance.live.datacontext.j r2 = r0.s();
        if (r2 == null) goto L11;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r3 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r2.getValue();
        if (r3 == null) goto L11;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r4 = r3.t();
        if (r4 == null) goto L11;
        int r5 = r4.a;
    L12:
        u r6 = com.bytedance.android.live.liveinteract.api.utils.m.d();
        if (r6 == null) goto L22;
        com.bytedance.live.datacontext.j r7 = r6.s();
        if (r7 == null) goto L22;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r8 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r7.getValue();
        if (r8 == null) goto L22;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r9 = r8.t();
        if (r9 == null) goto L22;
        r1 = r9.b;
    L22:
        return new Pair(Integer.valueOf(r5), Integer.valueOf(r1));
    L11:
        r5 = 0;
        goto L12
    }

    public InteractSceneViewModel() {
    }

    private final void logAnchorSwitchToRadio(int r5) {
        HashMap r0 = new HashMap();
        if (r5 == 9) goto L5;
        String r6 = "chat_room";
    L6:
        r0.put("before_function", r6);
        r0.put("interact_function", "live_room");
        i0 r7 = TalkRoomLogUtils.a;
        if (r2.a(TalkRoomLogUtils.e) == false) goto L9;
        String r8 = TalkRoomLogUtils.e;
        Intrinsics.checkNotNull(r8);
        r0.put("request_page", r8);
    L10:
        j0.l().sendLog("anchor_switch_room_type", r0, new Object[]{IRoom.class, x.class});
        TalkRoomLogUtils.e = null;
        return;
    L9:
        r0.put("request_page", "link_setting_panel");
        goto L10
    L5:
        r6 = "sing_room";
        goto L6
    }

    private final void logVoiceChatRoomOpenClick(String r5) {
        HashMap r0 = new HashMap();
        r0.put("room_type", "radio");
        r0.put("live_type", "voice_live");
        r0.put("function_type", r5);
        r0.put("function_type2", r5);
        j0 r6 = j0.l();
        x r2 = new x();
        r2.b = "live_detail";
        r2.a = "live";
        r2.e = "click";
        r6.sendLog("anchor_audience_connection_open", r0, new Object[]{r2, IRoom.class});
    }

    private final void switchChorusWithCheck(Context r9) {
        logVoiceChatRoomOpenClick("chorus");
        if (jc1.k.n(IKtvService.class).requestConflictCheck(KtvConflictScene.SCENE_KTV) == true) goto L6;
        return;
    L6:
        if (((Number) getVoiceTalkRoomSceneAndUILayout().component1()).intValue() == 0) goto L16;
        IInteractService r1 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r1 == null) goto L20;
        if (r9 != null) goto L11;
        r9 = com.bytedance.android.live.core.utils.a.d();
    L11:
        Context r2 = r9;
        IInteractService r10 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r10 == null) goto L14;
        int r3 = r10.getCurrentScene();
    L15:
        r1.switchSceneWithConfirmCheck(r2, r3, 9, "", 61, 0);
        return;
    L14:
        r3 = 0;
        goto L15
    L20:
        return;
    L16:
        IInteractService r11 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r11 == null) goto L22;
        r11.initAndTurnOnChorusKTV();
        return;
    }

    private final void switchKtvWithCheck(Context r12) {
        logVoiceChatRoomOpenClick("ktv");
        j0.l().sendLog("anchor_ktv_open", null, new Object[]{IRoom.class, x.class});
        if (jc1.k.n(IKtvService.class).requestConflictCheck(KtvConflictScene.SCENE_KTV) == true) goto L5;
        return;
    L5:
        Pair<Integer, Integer> r0 = getVoiceTalkRoomSceneAndUILayout();
        int r1 = ((Number) r0.component1()).intValue();
        ((Number) r0.component2()).intValue();
        if (r1 == 0) goto L16;
        IInteractService r4 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r4 == null) goto L20;
        if (r12 != null) goto L11;
        r12 = com.bytedance.android.live.core.utils.a.d();
    L11:
        Context r5 = r12;
        IInteractService r13 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r13 == null) goto L14;
        int r6 = r13.getCurrentScene();
    L15:
        r4.switchSceneWithConfirmCheck(r5, r6, 9, "", 0, 0);
        return;
    L14:
        r6 = 0;
        goto L15
    L20:
        return;
    L16:
        IInteractService r14 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r14 == null) goto L22;
        r14.initAndTurnOnKTV();
        return;
    }

    private final void switchRadioWithCheck(Context r17) {
        j0.l().sendLog("livesdk_anchor_voice_live_open", MapsKt.emptyMap(), new Object[]{IRoom.class});
        com.bytedance.live.datacontext.j r1 = com.bytedance.android.live.liveinteract.api.utils.m.d().s();
        if (r1 == null) goto L9;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r2 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r1.getValue();
        if (r2 == null) goto L9;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r3 = r2.t();
        if (r3 == null) goto L9;
        int r7 = r3.a;
    L10:
        u r4 = com.bytedance.android.live.liveinteract.api.utils.m.d();
        if (r4 == null) goto L19;
        com.bytedance.live.datacontext.j r5 = r4.s();
        if (r5 == null) goto L19;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r6 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r5.getValue();
        if (r6 == null) goto L19;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r8 = r6.t();
        if (r8 == null) goto L19;
        int r9 = r8.b;
    L21:
        if (s0.c(true) == false) goto L54;
        if (r7 != 9) goto L35;
        if (r9 != 61) goto L26;
        onFinishKtv(false, 200);
        return;
    L26:
        if (r9 != 0) goto L64;
        FragmentActivity r10 = ContextUtil.contextToFragmentActivity(r17);
        if (r10 == null) goto L65;
        FragmentManager r11 = r10.getSupportFragmentManager();
        if (r11 == null) goto L66;
        LiveDialogFragment r12 = jc1.k.n(IKtvService.class).getKtvFeedbackDialog("scene_panel", new a(this), false);
        if (r12 == null) goto L67;
        INVOKEVIRTUAL_com_bytedance_android_live_liveinteract_voicechat_dialog_InteractSceneViewModel_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(r12, r11, "KtvFeedbackDialog");
        return;
    L67:
        return;
    L66:
        return;
    L65:
        return;
    L64:
        return;
    L35:
        if (r7 == 5) goto L37;
    L39:
        if (r7 != 5) goto L44;
        if (InteractActingContext.Companion.a() == false) goto L44;
        f2.b(2131919176, 0);
        return;
    L44:
        if (je0.d.s() == false) goto L46;
        z0.a().getClass();
        x0.b r13 = z0.b(r17);
        r13.m(2131919510);
        r13.l(2131918747);
        r13.setCornerRadius(2.0f);
        r13.j(0, s1.B(2131918745), d.a);
        r13.j(1, s1.B(2131918744), e.a);
        r13.n();
        return;
    L46:
        AdventureContext.Companion.getClass();
        if (AdventureContext.a.a() == false) goto L49;
        f2.b(2131914605, 0);
        return;
    L49:
        FragmentActivity r14 = ContextUtil.contextToFragmentActivity(r17);
        if (r14 == null) goto L73;
        FragmentManager r15 = r14.getSupportFragmentManager();
        if (r15 == null) goto L74;
        int r16 = TalkRoomFeedbackDialog.r;
        INVOKEVIRTUAL_com_bytedance_android_live_liveinteract_voicechat_dialog_InteractSceneViewModel_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(TalkRoomFeedbackDialog.a.a(r7, true, "link_setting_panel", null, false, null, null, null, 1016), r15, "TalkRoomFeedbackDialog");
        return;
    L74:
        return;
    L73:
        return;
    L37:
        if (InteractiveSongContext.Companion.f() == false) goto L39;
        f2.b(2131919177, 0);
        return;
    L54:
        logAnchorSwitchToRadio(r7);
        if (r7 != 9) goto L57;
        String r18 = s1.B(2131919499);
    L61:
        com.bytedance.android.livesdk.widget.j0.a r19 = new com.bytedance.android.livesdk.widget.j0.a(r17);
        r19.a = r18;
        r19.b(s1.B(2131918116), b.a);
        r19.a(s1.B(2131915442), c.a);
        r19.c();
        return;
    L57:
        if (r9 != 29) goto L59;
        r18 = s1.B(2131922747);
        goto L61
    L59:
        r18 = s1.B(2131920103);
    L19:
        r9 = 0;
    L9:
        r7 = 0;
        goto L10
    }

    private final void switchRoomChatWithCheck(Context r10) {
        logVoiceChatRoomOpenClick("radio");
        Pair<Integer, Integer> r0 = getVoiceTalkRoomSceneAndUILayout();
        int r1 = ((Number) r0.component1()).intValue();
        int r2 = ((Number) r0.component2()).intValue();
        if (r1 == 0) goto L13;
        IInteractService r3 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r3 == null) goto L17;
        if (r10 != null) goto L8;
        r10 = com.bytedance.android.live.core.utils.a.d();
    L8:
        Context r4 = r10;
        IInteractService r11 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r11 == null) goto L11;
        int r5 = r11.getCurrentScene();
    L12:
        r3.switchSceneWithConfirmCheck(r4, r5, 5, "", Integer.valueOf(r2), 0);
        return;
    L11:
        r5 = 0;
        goto L12
    L17:
        return;
    L13:
        IInteractService r12 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r12 == null) goto L19;
        r12.initAndTurnOnVoiceChatRoom();
        return;
    }

    private final void onFinishKtv(boolean r8, int r9) {
        if (v.a(((IInteractService) jc1.k.n(IInteractService.class)).getLinkMode(), 8) == true) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor(), Boolean.TRUE) == false) goto L10;
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r10 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r10 == null) goto L9;
        com.bytedance.android.live.liveinteract.voicechat.d.b.a(r10);
    L9:
        jc1.k.n(IKtvService.class).finishAudioTalk();
        return;
    L10:
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r1 = IVoiceChatGuestService.a.a();
        if (r1 == null) goto L13;
        IVoiceChatGuestService.b.b(r1, r9, false, !r8, false, 24);
    L13:
        IKtvService.b.a(jc1.k.n(IKtvService.class), r9, false, !r8, false, 24);
    }

    public final void switchVoiceSceneWithCheck(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "toScene");
        switch(r3.hashCode()) {
            case -1361215066: goto L16;
            case 106541: goto L13;
            case 3506395: goto L10;
            case 108270587: goto L6;
            default: goto L27;
        };
    L27:
        return;
    L6:
        if (r3.equals("radio") == false) goto L19;
        if (r2 == null) goto L20;
        switchRadioWithCheck(r2);
        return;
    L20:
        return;
    L19:
        return;
    L10:
        if (r3.equals(PbRequest.SwitchType.ROOM) == false) goto L22;
        switchRoomChatWithCheck(r2);
        return;
    L22:
        return;
    L13:
        if (r3.equals("ktv") == false) goto L24;
        switchKtvWithCheck(r2);
        return;
    L24:
        return;
    L16:
        if (r3.equals("chorus") == false) goto L26;
        switchChorusWithCheck(r2);
        return;
    }

    public static void INVOKEVIRTUAL_com_bytedance_android_live_liveinteract_voicechat_dialog_InteractSceneViewModel_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(TalkRoomFeedbackDialog r2, FragmentManager r3, String r4) {
        if ((r2 instanceof Fragment) == false) goto L5;
        TalkRoomFeedbackDialog r0 = r2;
    L6:
        LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, r4, r1);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r0, r1) == false) goto L13;
        return;
    L13:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        r2.show(r3, r4);
        return;
    L5:
        r0 = null;
        goto L6
    }

    public static final /* synthetic */ void access$onFinishKtv(InteractSceneViewModel r0, boolean r1, int r2) {
        r0.onFinishKtv(r1, r2);
    }

    public static void INVOKEVIRTUAL_com_bytedance_android_live_liveinteract_voicechat_dialog_InteractSceneViewModel_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(LiveDialogFragment r2, FragmentManager r3, String r4) {
        if ((r2 instanceof Fragment) == false) goto L5;
        LiveDialogFragment r0 = r2;
    L6:
        LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, r4, r1);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r0, r1) == false) goto L13;
        return;
    L13:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        r2.show(r3, r4);
        return;
    L5:
        r0 = null;
        goto L6
    }
}
