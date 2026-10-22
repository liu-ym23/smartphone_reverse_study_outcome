package com.bytedance.android.live.liveinteract.voicechat.util;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.TalkRoomFeedbackDialog;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongContext;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.s0;
import com.bytedance.android.live.liveinteract.revenue.adventure.AdventureContext;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService;
import com.bytedance.android.live.liveinteract.voicechat.interactacting.InteractActingContext;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.ktvapi.KtvConflictScene;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdk.widget.z0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class VoiceInteractSceneUtil {
    public static final VoiceInteractSceneUtil a = null;

    public static final class a implements u {
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ Function0 d;

        @Override // com.bytedance.android.live.liveinteract.voicechat.util.u
        public final void a() {
            if (this.b == 9) goto L5;
            return;
        L5:
            if (this.c != 61) goto L9;
            VoiceInteractSceneUtil.a("reject");
            return;
        }

        @Override // com.bytedance.android.live.liveinteract.voicechat.util.u
        public final void b() {
            if (this.b == 9) goto L5;
            return;
        L5:
            if (this.c != 61) goto L9;
            VoiceInteractSceneUtil.a("accept");
            return;
        }

        @Override // com.bytedance.android.live.liveinteract.voicechat.util.u
        public final void c() {
            Function0 r0 = this.d;
            if (r0 == null) goto L6;
            Unit r1 = (Unit) r0.invoke();
            return;
        }

        public final void d() {
            int r0 = this.a;
            if (r0 == 5) goto L6;
            if (r0 == 9) goto L6;
        L11:
            if (this.a != 9) goto L16;
            Function0 r1 = this.d;
            if (r1 == null) goto L17;
            Unit r2 = (Unit) r1.invoke();
            return;
        L17:
            return;
        L16:
            return;
        L6:
            if (this.b != 9) goto L11;
            if (this.c != 61) goto L11;
            VoiceInteractSceneUtil r3 = VoiceInteractSceneUtil.a;
            HashMap r4 = new HashMap();
            VoiceInteractSceneUtil.c(r4);
            j0.l().sendLog("livesdk_anchor_audience_connection_end_show", r4, new Object[]{IRoom.class});
            goto L11
        }

        public a(int r1, int r2, int r3, Function0 r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public VoiceInteractSceneUtil() {
    }

    static {
        a = new VoiceInteractSceneUtil();
    }

    public static boolean b() {
        if (jc1.k.n(IKtvService.class).isKtvChallengeOpened() == false) goto L6;
        f2.b(2131918934, 0);
        return true;
    L6:
        return false;
    }

    public static Pair d() {
        com.bytedance.android.livesdk.chatroom.u r0 = com.bytedance.android.live.liveinteract.api.utils.m.d();
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
        com.bytedance.android.livesdk.chatroom.u r6 = com.bytedance.android.live.liveinteract.api.utils.m.d();
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

    public static final void a(String r4) {
        HashMap r0 = new HashMap();
        c(r0);
        r0.put("act_type", r4);
        j0.l().sendLog("livesdk_anchor_audience_connection_end_click", r0, new Object[]{IRoom.class});
    }

    public static void c(HashMap r2) {
        Intrinsics.checkNotNullParameter(r2, "map");
        r2.put("function_type", ((IInteractService) jc1.k.n(IInteractService.class)).getFunctionType2());
        r2.put("function_type2", ((IInteractService) jc1.k.n(IInteractService.class)).getFunctionType2());
        if (je0.d.r() == false) goto L5;
        String r0 = "anchor";
    L6:
        r2.put("user_type", r0);
        return;
    L5:
        r0 = "user";
        goto L6
    }

    public static void e(String r4) {
        Intrinsics.checkNotNullParameter(r4, "button");
        LinkedHashMap r1 = new LinkedHashMap();
        com.bytedance.android.live.liveinteract.linkpanel.util.m.G(r1);
        r1.put("button", r4);
        j0.l().sendLog("livesdk_anchor_audience_connection_open", r1, new Object[]{IRoom.class});
    }

    public static void f(String r4) {
        HashMap r0 = new HashMap();
        r0.put("room_type", "radio");
        r0.put("live_type", "voice_live");
        r0.put("function_type", r4);
        r0.put("function_type2", r4);
        j0 r5 = j0.l();
        am2.x r2 = new am2.x();
        r2.b = "live_detail";
        r2.a = "live";
        r2.e = "click";
        r5.sendLog("anchor_audience_connection_open", r0, new Object[]{r2, IRoom.class});
    }

    public static void g(boolean r7, int r8) {
        if (gd0.v.a(((IInteractService) jc1.k.n(IInteractService.class)).getLinkMode(), 8) == true) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor(), Boolean.TRUE) == false) goto L10;
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r9 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r9 == null) goto L9;
        com.bytedance.android.live.liveinteract.voicechat.d.b.a(r9);
    L9:
        jc1.k.n(IKtvService.class).finishAudioTalk();
        return;
    L10:
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r1 = IVoiceChatGuestService.a.a();
        if (r1 == null) goto L13;
        IVoiceChatGuestService.b.b(r1, r8, false, !r7, false, 24);
    L13:
        IKtvService.b.a(jc1.k.n(IKtvService.class), r8, false, !r7, false, 24);
    }

    public final void i(int r19, FragmentManager r20, Context r21, Function0<Unit> r22) {
        Intrinsics.checkNotNullParameter(r21, "context");
        if (r22 != null) goto L5;
        final Function0<Unit> r5 = VoiceInteractSceneUtil$selectMultiLinkMode$1.INSTANCE;
    L7:
        if (r19 != 1) goto L9;
        IInteractService r0 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r0 == null) goto L137;
        if (r5 == null) goto L136;
        r5 = new t(r5);
    L136:
        r0.initAndTurnOnRadioLinkmicRoom((Runnable) r5, null);
    L137:
        com.bytedance.android.livesdk.sharedpref.d.e0.setValue(null, com.bytedance.android.livesdk.sharedpref.d.a[55], Boolean.FALSE);
        e("audio_audience");
        return;
    L9:
        if (r19 != 2) goto L11;
        f("radio");
        Pair r1 = d();
        int r2 = ((Number) r1.component1()).intValue();
        int r3 = ((Number) r1.component2()).intValue();
        if (b() == false) goto L124;
        if (r5 == null) goto L131;
        Unit r4 = (Unit) r5.invoke();
    L131:
        e("chatroom");
        return;
    L124:
        if (r2 == 0) goto L126;
        h(r2, 5, r3, 0, r21, r5);
        goto L131
    L126:
        IInteractService r6 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r6 == null) goto L129;
        r6.initAndTurnOnVoiceChatRoom();
    L129:
        if (r5 == null) goto L131;
        Unit r7 = (Unit) r5.invoke();
        goto L131
    L11:
        if (r19 != 3) goto L13;
        f("ktv");
        j0.l().sendLog("anchor_ktv_open", null, new Object[]{IRoom.class, am2.x.class});
        if (b() == false) goto L109;
        if (r5 == null) goto L164;
        Unit r8 = (Unit) r5.invoke();
        return;
    L164:
        return;
    L109:
        if (jc1.k.n(IKtvService.class).requestConflictCheck(KtvConflictScene.SCENE_KTV) == true) goto L112;
        if (r5 == null) goto L166;
        Unit r9 = (Unit) r5.invoke();
        return;
    L166:
        return;
    L112:
        Pair r10 = d();
        int r11 = ((Number) r10.component1()).intValue();
        int r12 = ((Number) r10.component2()).intValue();
        if (r11 == 0) goto L115;
        h(r11, 9, r12, 0, r21, r5);
        return;
    L115:
        IInteractService r13 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r13 == null) goto L118;
        r13.initAndTurnOnKTV();
    L118:
        if (r5 == null) goto L169;
        Unit r14 = (Unit) r5.invoke();
        return;
    L169:
        return;
    L13:
        if (r19 != 4) goto L15;
        f("chorus");
        if (b() == false) goto L93;
        if (r5 == null) goto L157;
        Unit r15 = (Unit) r5.invoke();
        return;
    L157:
        return;
    L93:
        if (jc1.k.n(IKtvService.class).requestConflictCheck(KtvConflictScene.SCENE_KTV) == true) goto L96;
        if (r5 == null) goto L159;
        Unit r16 = (Unit) r5.invoke();
        return;
    L159:
        return;
    L96:
        Pair r17 = d();
        int r18 = ((Number) r17.component1()).intValue();
        int r23 = ((Number) r17.component2()).intValue();
        if (r18 == 0) goto L99;
        h(r18, 9, r23, 61, r21, r5);
        return;
    L99:
        IInteractService r24 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r24 == null) goto L102;
        r24.initAndTurnOnChorusKTV();
    L102:
        if (r5 == null) goto L162;
        Unit r25 = (Unit) r5.invoke();
        return;
    L162:
        return;
    L15:
        if (r19 != 5) goto L172;
        j0.l().sendLog("livesdk_anchor_voice_live_open", null, new Object[]{IRoom.class});
        com.bytedance.live.datacontext.j r26 = com.bytedance.android.live.liveinteract.api.utils.m.d().s();
        if (r26 == null) goto L24;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r27 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r26.getValue();
        if (r27 == null) goto L24;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r28 = r27.t();
        if (r28 == null) goto L24;
        int r29 = r28.a;
    L25:
        com.bytedance.android.livesdk.chatroom.u r30 = com.bytedance.android.live.liveinteract.api.utils.m.d();
        if (r30 == null) goto L34;
        com.bytedance.live.datacontext.j r31 = r30.s();
        if (r31 == null) goto L34;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r32 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r31.getValue();
        if (r32 == null) goto L34;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r33 = r32.t();
        if (r33 == null) goto L34;
        int r34 = r33.b;
    L36:
        if (s0.c(true) == false) goto L76;
        AdventureContext.Companion.getClass();
        if (AdventureContext.a.a() == true) goto L41;
        if (r5 == null) goto L41;
        Unit r35 = (Unit) r5.invoke();
    L41:
        if (r29 == 9) goto L43;
        if (r29 == 5) goto L56;
    L58:
        if (r29 != 5) goto L63;
        if (InteractActingContext.Companion.a() == false) goto L63;
        f2.b(2131919176, 0);
        return;
    L63:
        if (je0.d.s() == false) goto L68;
        if (r5 == null) goto L66;
        Unit r36 = (Unit) r5.invoke();
    L66:
        z0.a().getClass();
        x0.b r37 = z0.b(r21);
        r37.m(2131919510);
        r37.l(2131918747);
        r37.setCornerRadius(2.0f);
        r37.j(0, s1.B(2131918745), r.a);
        r37.j(1, s1.B(2131918744), s.a);
        r37.n();
        return;
    L68:
        if (AdventureContext.a.a() == false) goto L70;
        f2.b(2131914605, 0);
        return;
    L70:
        if (r20 == null) goto L154;
        int r38 = TalkRoomFeedbackDialog.r;
        TalkRoomFeedbackDialog r39 = TalkRoomFeedbackDialog.a.a(r29, true, "scene_panel", null, false, null, null, null, 1016);
        LandscapeRestrictionOperation r40 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r39, "TalkRoomFeedbackDialog", r40);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r20, r39, r40) == true) goto L174;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L140
    L75:
        r39.show(r20, "TalkRoomFeedbackDialog");
        return;
    L174:
        return;
    L154:
        return;
    L56:
        if (InteractiveSongContext.Companion.f() == false) goto L58;
        f2.b(2131919177, 0);
        return;
    L43:
        if (r34 != 61) goto L45;
        g(false, 200);
        return;
    L45:
        if (r34 != 0) goto L146;
        if (r20 == null) goto L147;
        LiveDialogFragment r41 = jc1.k.n(IKtvService.class).getKtvFeedbackDialog("scene_panel", new o(), false);
        if (r41 == null) goto L148;
        LandscapeRestrictionOperation r42 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r41, "KtvFeedbackDialog", r42);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r20, r41, r42) == true) goto L173;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L139
    L53:
        r41.show(r20, "KtvFeedbackDialog");
        return;
    L173:
        return;
    L148:
        return;
    L147:
        return;
    L146:
        return;
    L76:
        HashMap r43 = new HashMap();
        if (r29 == 9) goto L79;
        String r44 = "chat_room";
    L80:
        r43.put("before_function", r44);
        r43.put("interact_function", "live_room");
        r43.put("request_page", "link_icon");
        j0.l().sendLog("anchor_switch_room_type", r43, new Object[]{IRoom.class, am2.x.class});
        if (r29 != 9) goto L83;
        String r45 = s1.B(2131919499);
    L87:
        com.bytedance.android.livesdk.widget.j0.a r46 = new com.bytedance.android.livesdk.widget.j0.a(r21);
        r46.a = r45;
        r46.b(s1.B(2131918116), new p(r5));
        r46.a(s1.B(2131915442), q.a);
        r46.c();
        return;
    L83:
        if (r34 != 29) goto L85;
        r45 = s1.B(2131922747);
        goto L87
    L85:
        r45 = s1.B(2131920103);
        goto L87
    L79:
        r44 = "sing_room";
    L34:
        r34 = 0;
    L24:
        r29 = 0;
        goto L25
    L172:
        return;
    L5:
        r5 = r22;
        goto L7
    }

    public static void h(final int r8, final int r9, int r10, final int r11, Context r12, Function0 r13) {
        TalkRoomLogUtils.e = "link_icon";
        int r0 = y.a;
        y.a(r12, new VoiceInteractSceneUtil$sceneSwitchWithConfirmDialog$1(r8, r9, r11), new v(r8, r9, r10, r11, ""), new a(r8, r9, r11, r13));
    }
}
