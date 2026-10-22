package com.bytedance.android.livesdk.chatroom.ui.setting;

import android.content.Context;
import android.view.View;
import com.bytedance.android.livesdk.chatroom.ui.ReplayDetailSettingDialog;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.HashMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h implements View.OnClickListener {
    public final /* synthetic */ j a;
    public final /* synthetic */ Context b;

    public h(j r1, Context r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r18) {
        Function0<Boolean> r1 = this.a.q;
        if (r1 != null) goto L5;
    L8:
        j r2 = this.a;
        ReplayDetailSettingDialog r3 = r2.o;
        r2.p.dismissDialog();
        Boolean r4 = (Boolean) com.bytedance.android.livesdk.sharedpref.b.I0.getValue();
        Boolean r5 = Boolean.TRUE;
        String r9 = "on";
        if (Intrinsics.areEqual(r4, r5) == false) goto L24;
        HashMap r6 = new HashMap();
        Room r15 = this.a.m;
        if (r15 == null) goto L13;
        String r16 = r15.getOwnerUserIdString();
    L14:
        r6.put("anchor_id", String.valueOf(r16));
        Room r17 = this.a.m;
        if (r17 == null) goto L17;
        String r19 = r17.getIdStr();
    L18:
        r6.put("room_id", String.valueOf(r19));
        r6.put("live_status_type", "live_on");
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.L0.getValue()).booleanValue() == false) goto L21;
        Object r110 = "on";
    L22:
        r6.put("to_status", r110);
        r6.put("_param_live_platform", "live");
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_record_status_show", r6, new Object[]{Room.class});
        goto L24
    L21:
        r110 = "off";
        goto L22
    L17:
        r19 = null;
        goto L18
    L13:
        r16 = null;
    L24:
        if (Intrinsics.areEqual((Boolean) com.bytedance.android.livesdk.sharedpref.b.S0.getValue(), r5) == false) goto L45;
        HashMap r7 = new HashMap();
        r7.put("request_page", "live_room");
        Room r8 = this.a.m;
        if (r8 != null) goto L28;
    L30:
        String r10 = "0";
    L31:
        r7.put("is_ecom", r10);
        Room r11 = this.a.m;
        if (r11 == null) goto L34;
        String r12 = r11.getOwnerUserIdString();
    L35:
        r7.put("anchor_id", String.valueOf(r12));
        r7.put("live_status_type", "live_on");
        Room r13 = this.a.m;
        if (r13 == null) goto L38;
        String r14 = r13.getIdStr();
    L39:
        r7.put("room_id", String.valueOf(r14));
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.T0.getValue()).booleanValue() == true) goto L43;
        r9 = "off";
    L43:
        r7.put("status", r9);
        r7.put("_param_live_platform", "live");
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_show_explain_replay_toggle_button", r7, new Object[]{Room.class});
        goto L45
    L38:
        r14 = null;
        goto L39
    L34:
        r12 = null;
        goto L35
    L28:
        if (r8.isHasCommerceGoods() != true) goto L30;
        r10 = "1";
    L45:
        if (DialogLancet.shouldBlockDialogShow(r3) == false) goto L52;
        DialogLancet.handleBlockedDialogShow(r3);
    L49:
        this.a.a();
        return;
    L52:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L51
    L48:
        DialogLancet.beforeDialogShow(r3);
        r3.show();
        DialogLancet.afterDialogShow(r3);
        goto L49
    L5:
        if (((Boolean) r1.invoke()).booleanValue() != true) goto L8;
        String r20 = rm3.c.a;
        rm3.c.f(this.b, 2131914851, true, 20);
    }
}
