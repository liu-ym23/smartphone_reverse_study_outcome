package com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog;

import android.os.Bundle;
import android.view.View;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkApplyType;
import com.bytedance.android.livesdk.chatroom.model.LinkmicAudienceRecommendItem;
import com.bytedance.android.livesdkapi.eventbus.JumpToOtherRoomEvent;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a0 implements View.OnClickListener {
    public final /* synthetic */ LinkResultDialogFragmentV2 a;

    public a0(LinkResultDialogFragmentV2 r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r10) {
        LinkResultDialogFragmentV2 r11 = this.a;
        LinkmicAudienceRecommendItem r0 = r11.m;
        if (r0 == null) goto L45;
        Long r1 = r0.getRoomId();
        IBaseUser r2 = r0.getAnchor();
        if (r1 == null) goto L19;
        r1.longValue();
        if (r2 == null) goto L19;
        r11.dismiss();     // Catch: Exception -> L11
    L15:
        Bundle r12 = new Bundle();
        r12.putString("enter_from", "live_detail");
        r12.putString("source", "link_result");
        r12.putLong("from_room_id", je0.d.a0());
        r12.putString("superior_page_from", "live_detail");
        r12.putString("anchor_id", r2.getIdString());
        r12.putString("enter_method", "link_result_page");
        r12.putString("enter_from_merge", "live_detail");
        if (((Boolean) vm2.h.H5.getValue(null, vm2.h.a[344(0x158, float:4.82E-43)])).booleanValue() == false) goto L18;
        r12.putString("auto_link_mic", "true");
        r12.putString("action", "apply");
        r12.putInt("apply_type", LinkApplyType.LINK_FROM_LINK_RESULT.getValue());
    L18:
        xs2.b.a().post(new JumpToOtherRoomEvent(r1.longValue(), "live_detail", r12));
    L11:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r13 = DialogFragmentLancet.sLastShowStack;
        if (r13 == null) goto L15;
        com.bytedance.crash.d.d(r13, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
    L19:
        int r14 = d0.a;
        LinkmicAudienceRecommendItem r15 = this.a.m;
        if (r15 == null) goto L24;
        Long r16 = r15.getRoomId();
        if (r16 == null) goto L24;
        long r3 = r16.longValue();
    L25:
        long r4 = r3;
        LinkmicAudienceRecommendItem r17 = this.a.m;
        if (r17 == null) goto L33;
        IBaseUser r18 = r17.getAnchor();
        if (r18 == null) goto L33;
        String r19 = r18.getIdString();
        if (r19 == null) goto L33;
        String r5 = r19;
    L34:
        LinkmicAudienceRecommendItem r110 = this.a.m;
        if (r110 == null) goto L40;
        String r111 = r110.getText();
        if (r111 == null) goto L40;
        String r6 = r111;
    L41:
        LinkResultDialogFragmentV2 r112 = this.a;
        d0.d(r4, r5, r6, "golink", r112.j, r112.l);
        return;
    L40:
        r6 = "";
    L33:
        r5 = "";
    L24:
        r3 = 0;
        goto L25
    }
}
