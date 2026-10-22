package com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView;

import am2.x;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.videotalk.quickinteract.QuickInteractTask;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class m extends AnimatorListenerAdapter {
    public final /* synthetic */ n a;
    public final /* synthetic */ QuickInteractTask b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r8) {
        Intrinsics.checkNotNullParameter(r8, "p0");
        n r9 = this.a;
        r9.e = this.b;
        if (r9.a.getCurrentView().getId() == 2131375504) goto L5;
        this.a.a.showNext();
    L5:
        QuickInteractTask r10 = this.b;
        int r0 = com.bytedance.android.live.liveinteract.videotalk.quickinteract.c.a;
        Intrinsics.checkNotNullParameter(r10, "task");
        HashMap r1 = new HashMap();
        Object r3 = null;
        TalkRoomLogUtils.B0(r1, Integer.valueOf(je0.d.f()), null, 4);
        r1.put("to_user_id", r10.d.toString());
        String r2 = je0.d.b0();
        com.bytedance.live.datacontext.m r4 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r4 == null) goto L10;
        IRoom r5 = (IRoom) r4.getValue();
        if (r5 == null) goto L10;
        String r6 = r5.getOwnerUserIdString();
    L11:
        boolean r7 = Intrinsics.areEqual(r2, r6);
        String r11 = "anchor";
        if (r7 == false) goto L14;
        Object r12 = "anchor";
    L15:
        r1.put("user_type", r12);
        String r13 = r10.d;
        Intrinsics.checkNotNullParameter(r13, "toUserID");
        o r14 = com.bytedance.android.live.liveinteract.api.utils.m.l(null, 0L);
        if (r14 == null) goto L22;
        com.bytedance.live.datacontext.m r15 = r14.getRoom();
        if (r15 == null) goto L22;
        IRoom r16 = (IRoom) r15.getValue();
        if (r16 == null) goto L22;
        String r17 = r16.getOwnerUserIdString();
    L24:
        if (Intrinsics.areEqual(r13, r17) == true) goto L114;
        rj0.k.m2.getClass();
        rj0.k r18 = rj0.k.a.a();
        if (r18 == null) goto L48;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r19 = r18.getLinkUserInfoCenter();
        if (r19 == null) goto L48;
        Iterable r20 = r19.getOnlineUserList();
        if (r20 == null) goto L48;
        Iterator r21 = r20.iterator();
    L34:
        if (r21.hasNext() == false) goto L44;
        Object r22 = r21.next();
        ILinkPlayerInfoBridge r23 = (ILinkPlayerInfoBridge) r22;
        if (r23 == null) goto L40;
        IBaseUser r24 = r23.getUser();
        if (r24 == null) goto L40;
        String r25 = r24.getIdString();
    L42:
        if (Intrinsics.areEqual(r25, r13) == false) goto L34;
    L46:
        if (((ILinkPlayerInfoBridge) r22) == null) goto L48;
    L112:
        r11 = "guest";
    L40:
        r25 = null;
        goto L42
    L44:
        r22 = null;
    L48:
        rj0.l.n2.getClass();
        rj0.l r26 = rj0.l.a.a();
        if (r26 == null) goto L70;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r27 = r26.getLinkUserInfoCenter();
        if (r27 == null) goto L70;
        Iterable r28 = r27.getOnlineUserList();
        if (r28 == null) goto L70;
        Iterator r29 = r28.iterator();
    L56:
        if (r29.hasNext() == false) goto L66;
        Object r30 = r29.next();
        ILinkPlayerInfoBridge r31 = (ILinkPlayerInfoBridge) r30;
        if (r31 == null) goto L62;
        IBaseUser r32 = r31.getUser();
        if (r32 == null) goto L62;
        String r33 = r32.getIdString();
    L64:
        if (Intrinsics.areEqual(r33, r13) == false) goto L56;
    L68:
        if (((ILinkPlayerInfoBridge) r30) == null) goto L70;
    L62:
        r33 = null;
        goto L64
    L66:
        r30 = null;
    L70:
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r34 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r34 == null) goto L92;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r35 = r34.getLinkUserInfoCenter();
        if (r35 == null) goto L92;
        Iterable r36 = r35.getOnlineUserList();
        if (r36 == null) goto L92;
        Iterator r37 = r36.iterator();
    L78:
        if (r37.hasNext() == false) goto L88;
        Object r38 = r37.next();
        ILinkPlayerInfoBridge r39 = (ILinkPlayerInfoBridge) r38;
        if (r39 == null) goto L84;
        IBaseUser r40 = r39.getUser();
        if (r40 == null) goto L84;
        String r41 = r40.getIdString();
    L86:
        if (Intrinsics.areEqual(r41, r13) == false) goto L78;
    L90:
        if (((ILinkPlayerInfoBridge) r38) == null) goto L92;
    L84:
        r41 = null;
        goto L86
    L88:
        r38 = null;
    L92:
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r42 = IVoiceChatGuestService.a.a();
        if (r42 == null) goto L113;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r43 = r42.getLinkUserInfoCenter();
        if (r43 == null) goto L113;
        Iterable r44 = r43.getOnlineUserList();
        if (r44 == null) goto L113;
        Iterator r45 = r44.iterator();
    L100:
        if (r45.hasNext() == false) goto L111;
        Object r46 = r45.next();
        ILinkPlayerInfoBridge r47 = (ILinkPlayerInfoBridge) r46;
        if (r47 == null) goto L106;
        IBaseUser r48 = r47.getUser();
        if (r48 == null) goto L106;
        String r49 = r48.getIdString();
    L108:
        if (Intrinsics.areEqual(r49, r13) == false) goto L100;
        r3 = r46;
    L106:
        r49 = null;
    L111:
        if (((ILinkPlayerInfoBridge) r3) != null) goto L112;
    L113:
        r11 = "user";
    L114:
        r1.put("to_user_type", r11);
        j0.l().sendLog("livesdk_chat_thank_seat_icon_show", r1, new Object[]{x.class, IRoom.class});
        return;
    L22:
        r17 = null;
        goto L24
    L14:
        r12 = "guest";
    L10:
        r6 = null;
        goto L11
    }

    public m(n r1, QuickInteractTask r2) {
        this.a = r1;
        this.b = r2;
    }
}
