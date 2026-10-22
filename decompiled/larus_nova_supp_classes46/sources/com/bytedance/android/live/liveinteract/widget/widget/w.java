package com.bytedance.android.live.liveinteract.widget.widget;

import android.view.View;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.h0;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class w implements View.OnClickListener {
    public final /* synthetic */ PairUserAdapter.PairUserViewHolder a;
    public final /* synthetic */ h0 b;

    public w(PairUserAdapter.PairUserViewHolder r1, h0 r2) {
        this.a = r1;
        this.b = r2;
    }

    /* JADX WARN: Type inference failed for: r7v3, types: [android.app.Dialog, com.bytedance.android.live.liveinteract.widget.widget.VideoFriendPairDialog, java.lang.Object] */
    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        PairUserAdapter.PairUserViewHolder.a r8 = this.a.a;
        h0 r0 = this.b;
        ?? r9 = (VideoFriendPairDialog) r8;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r0, "pairUser");
        VideoFriendSelectPairDialog r1 = new VideoFriendSelectPairDialog(r9.getContext(), r0, r9);
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L39;
        DialogLancet.handleBlockedDialogShow(r1);
    L7:
        com.bytedance.live.datacontext.m r10 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        Long r2 = null;
        if (r10 == null) goto L10;
        IRoom r11 = (IRoom) r10.getValue();
    L11:
        HashMap r3 = new HashMap();
        String r4 = "";
        if (r11 == null) goto L17;
        IBaseUser r5 = r11.getOwner();
        if (r5 == null) goto L17;
        String r6 = r5.getIdString();
        if (r6 == null) goto L17;
    L18:
        r3.put("anchor_id", r6);
        if (r11 == null) goto L21;
        r2 = Long.valueOf(r11.getId());
    L21:
        r3.put("room_id", String.valueOf(r2));
        r3.put("live_type", "video_live");
        r3.put("function_type", "party");
        ILinkPlayerInfoBridge r12 = r0.getGuest();
        if (r12 == null) goto L27;
        IBaseUser r13 = r12.getUser();
        if (r13 == null) goto L27;
        String r14 = r13.getIdString();
        if (r14 == null) goto L27;
    L28:
        r3.put("first_user_id", r14);
        ILinkPlayerInfoBridge r15 = r0.getInvestor();
        if (r15 == null) goto L36;
        IBaseUser r16 = r15.getUser();
        if (r16 == null) goto L36;
        String r17 = r16.getIdString();
        if (r17 == null) goto L36;
        r4 = r17;
    L36:
        r3.put("second_user_id", r4);
        TalkRoomLogUtils.Q0(r3);
        j0.l().sendLog("livesdk_date_pairing_replace_icon_click", r3, new Object[0]);
        return;
    L27:
        r14 = "";
    L17:
        r6 = "";
        goto L18
    L10:
        r11 = null;
        goto L11
    L39:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L38
    L6:
        DialogLancet.beforeDialogShow(r1);
        r1.show();
        DialogLancet.afterDialogShow(r1);
        goto L7
    }
}
