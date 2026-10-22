package com.bytedance.android.live.liveinteract.videotalk.emoji;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.TalkRoomFeedbackDialog;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.utils.s0;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.widget.j0;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class y {
    public static final /* synthetic */ int a = 0;

    public static boolean c() {
        IInteractService r0 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r0 == null) goto L7;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r1 = r0.getLinkUserInfoCenter();
        if (r1 == null) goto L7;
        ILinkPlayerInfoBridge r2 = (ILinkPlayerInfoBridge) r1.a5(je0.d.b0(), tc0.c.h().f);
    L9:
        if (r2 == null) goto L11;
        long r3 = r2.getPaidCount();
    L13:
        if (hd0.c.f().h() == true) goto L15;
    L17:
        return false;
    L15:
        if (r3 <= 0) goto L17;
        return true;
    L11:
        r3 = 0;
    L7:
        r2 = null;
        goto L9
    }

    static {
    }

    public static void d(String r6) {
        Intrinsics.checkNotNullParameter(r6, "requestPage");
        ALogger.i("DynamicEmojiDialogLinkContext", "leaveChannelAndShowLinkResult");
        int r0 = r6.hashCode();
        if (r0 == (-1383228885)) goto L11;
        if (r0 == 3526149) goto L8;
    L13:
        int r1 = 200;
    L14:
        com.bytedance.android.live.liveinteract.plantform.base.g r7 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r7 != null) goto L17;
    L21:
        com.bytedance.android.live.liveinteract.plantform.base.g r8 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r8 != null) goto L24;
        return;
    L24:
        if (r8.s8() == true) goto L26;
        return;
    L26:
        if (je0.d.y() == false) goto L30;
        IKtvService r2 = jc1.k.f(IKtvService.class);
        if (r2 == null) goto L38;
        IKtvService.b.a(r2, r1, false, false, true, 16);
        return;
    L38:
        return;
    L30:
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r3 = IVoiceChatGuestService.a.a();
        if (r3 == null) goto L40;
        IVoiceChatGuestService.b.b(r3, r1, false, true, true, 16);
        return;
    L40:
        return;
    L17:
        if (r7.nd() != true) goto L21;
        rj0.l.n2.getClass();
        rj0.l r9 = rj0.l.a.a();
        if (r9 == null) goto L34;
        rj0.l.b.d(r9, r1, true, true, 8);
        return;
    L34:
        return;
    L8:
        if (r6.equals("seat") == false) goto L13;
        r1 = 201;
        goto L14
    L11:
        if (r6.equals("bottom") == false) goto L13;
        r1 = com.bytedance.android.live.liveinteract.multianchor.model.b.TYPE_BATTLE_DATA;
        goto L14
    }

    public static void a(TalkRoomFeedbackDialog r2, FragmentManager r3) {
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r2, "TalkRoomFeedbackDialog", r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r2, r0) == false) goto L9;
        return;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r2.show(r3, "TalkRoomFeedbackDialog");
    }

    public static void b(LiveDialogFragment r2, FragmentManager r3) {
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r2, "KtvFeedbackDialog", r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r2, r0) == false) goto L9;
        return;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r2.show(r3, "KtvFeedbackDialog");
    }

    public static void e(DataCenter r14, Context r15, String r16) {
        Intrinsics.checkNotNullParameter(r14, "dataCenter");
        Intrinsics.checkNotNullParameter(r15, "context");
        Intrinsics.checkNotNullParameter(r16, "requestPage");
        com.bytedance.android.live.liveinteract.plantform.base.g r2 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        int r3 = com.bytedance.android.live.liveinteract.multianchor.model.b.TYPE_BATTLE_DATA;
        boolean r6 = false;
        int r7 = 201;
        if (r2 != null) goto L5;
    L27:
        com.bytedance.android.live.liveinteract.plantform.base.g r4 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r4 != null) goto L30;
        return;
    L30:
        if (r4.s8() == true) goto L32;
        return;
    L32:
        if (je0.d.y() == false) goto L54;
        int r5 = je0.d.f();
        if (s0.c(je0.d.r()) == false) goto L40;
        if (r5 != 9) goto L39;
        LiveDialogFragment r0 = jc1.k.n(IKtvService.class).getKtvFeedbackDialog(r16, new u(r14), false);
        if (r0 == null) goto L80;
        FragmentActivity r1 = ContextUtil.contextToFragmentActivity(r15);
        Intrinsics.checkNotNull(r1);
        b(r0, r1.getSupportFragmentManager());
        return;
    L80:
        return;
    L39:
        int r8 = TalkRoomFeedbackDialog.r;
        TalkRoomFeedbackDialog r9 = TalkRoomFeedbackDialog.a.a(r5, je0.d.r(), r16, null, false, null, null, null, 1016);
        FragmentActivity r10 = ContextUtil.contextToFragmentActivity(r15);
        Intrinsics.checkNotNull(r10);
        a(r9, r10.getSupportFragmentManager());
        return;
    L40:
        int r11 = r16.hashCode();
        if (r11 == (-1383228885)) goto L48;
        if (r11 == 3526149) goto L45;
    L50:
        r7 = 200;
    L51:
        IKtvService r12 = jc1.k.f(IKtvService.class);
        if (r12 == null) goto L83;
        IKtvService.b.a(r12, r7, true, true, false, 24);
        return;
    L83:
        return;
    L45:
        if (r16.equals("seat") == false) goto L50;
    L48:
        if (r16.equals("bottom") == false) goto L50;
        r7 = com.bytedance.android.live.liveinteract.multianchor.model.b.TYPE_BATTLE_DATA;
        goto L51
    L54:
        int r13 = je0.d.f();
        if (s0.c(je0.d.r()) == false) goto L61;
        if (r13 != 9) goto L60;
        LiveDialogFragment r17 = jc1.k.n(IKtvService.class).getKtvFeedbackDialog(r16, new x(r14), false);
        if (r17 == null) goto L85;
        FragmentActivity r18 = ContextUtil.contextToFragmentActivity(r15);
        Intrinsics.checkNotNull(r18);
        b(r17, r18.getSupportFragmentManager());
        return;
    L85:
        return;
    L60:
        int r19 = TalkRoomFeedbackDialog.r;
        TalkRoomFeedbackDialog r20 = TalkRoomFeedbackDialog.a.a(r13, je0.d.r(), r16, null, false, null, null, null, 1016);
        FragmentActivity r21 = ContextUtil.contextToFragmentActivity(r15);
        Intrinsics.checkNotNull(r21);
        a(r20, r21.getSupportFragmentManager());
        return;
    L61:
        int r22 = r16.hashCode();
        if (r22 == (-1383228885)) goto L69;
        if (r22 == 3526149) goto L66;
    L71:
        r7 = 200;
    L72:
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r23 = IVoiceChatGuestService.a.a();
        if (r23 == null) goto L88;
        IVoiceChatGuestService.b.b(r23, r7, true, true, false, 24);
        return;
    L88:
        return;
    L66:
        if (r16.equals("seat") == false) goto L71;
    L69:
        if (r16.equals("bottom") == false) goto L71;
        r7 = com.bytedance.android.live.liveinteract.multianchor.model.b.TYPE_BATTLE_DATA;
        goto L72
    L5:
        if (r2.nd() != true) goto L27;
        rj0.l.n2.getClass();
        rj0.l r24 = rj0.l.a.a();
        if (r24 == null) goto L12;
        if (r24.isCurrentLinkPaid() != true) goto L12;
        r6 = true;
    L12:
        if (s0.c(je0.d.r()) == false) goto L15;
        if (r6 == true) goto L15;
        int r25 = TalkRoomFeedbackDialog.r;
        TalkRoomFeedbackDialog r26 = TalkRoomFeedbackDialog.a.a(je0.d.f(), je0.d.r(), r16, null, false, null, null, null, 1016);
        FragmentActivity r27 = ContextUtil.contextToFragmentActivity(r15);
        Intrinsics.checkNotNull(r27);
        a(r26, r27.getSupportFragmentManager());
        return;
    L15:
        int r28 = r16.hashCode();
        if (r28 == (-1383228885)) goto L23;
        if (r28 == 3526149) goto L20;
    L25:
        r3 = 200;
    L26:
        j0.a r29 = new j0.a(r15);
        r29.a = s1.B(2131919817);
        r29.b(s1.B(2131919267), new v(r3));
        r29.a(s1.B(2131915442), w.a);
        r29.c();
        return;
    L20:
        if (r16.equals("seat") == false) goto L25;
        r3 = 201;
        goto L26
    L23:
        if (r16.equals("bottom") == false) goto L25;
        goto L25
    }
}
