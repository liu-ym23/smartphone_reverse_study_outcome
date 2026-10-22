package com.bytedance.android.livesdk.chatroom.ui.setting;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.interactivity.api.anchorsetting.CommentSettingDialog;
import com.bytedance.android.livesdkapi.interfaces.ListDialogAbility;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class p implements View.OnClickListener {
    public final /* synthetic */ q a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ DataCenter d;
    public final /* synthetic */ ListDialogAbility e;
    public final /* synthetic */ boolean f;
    public final /* synthetic */ long g;
    public final /* synthetic */ String h;

    public p(q r1, boolean r2, DataCenter r3, ListDialogAbility r4, boolean r5, long r6, String r8) {
        this.a = r1;
        this.b = false;
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.g = r6;
        this.h = r8;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r16) {
        FragmentActivity r1 = ContextUtil.contextToFragmentActivity(r16.getContext());
        if (r1 == null) goto L55;
        LinkedHashMap r2 = new LinkedHashMap();
        IInteractService r3 = jc1.k.f(IInteractService.class);
        String r4 = "";
        if (r3 == null) goto L8;
        String r5 = r3.getLiveTypeForLog();
        if (r5 == null) goto L8;
    L9:
        r2.put("live_type", r5);
        IInteractService r6 = jc1.k.f(IInteractService.class);
        if (r6 == null) goto L15;
        String r7 = r6.getFunctionTypeForLog();
        if (r7 == null) goto L15;
        r4 = r7;
    L15:
        r2.put("function_type", r4);
        int r8 = CommentSettingDialog.t;
        boolean r9 = this.b;
        boolean r10 = this.c;
        DataCenter r11 = this.d;
        ListDialogAbility r12 = this.e;
        boolean r13 = this.f;
        long r14 = this.g;
        String r15 = this.h;
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r12, "dialogAbility");
        Intrinsics.checkNotNullParameter(r15, "ticketName");
        Intrinsics.checkNotNullParameter(r2, "logParams");
        FragmentManager r17 = r1.getSupportFragmentManager();
        if ((r17.findFragmentByTag("CommentSettingDialog") instanceof CommentSettingDialog) == false) goto L31;
        CommentSettingDialog r18 = r17.findFragmentByTag("CommentSettingDialog");
        if (r18 == null) goto L30;
        CommentSettingDialog r19 = r18;
        r19.setAnimationType("right");
        r19.setShouldUseNewPanel(true);
        r19.e = r10;
        r19.i = r12;
        r19.f = r9;
        r19.g = r11;
        if (r9 == true) goto L24;
        if (r11 == null) goto L24;
        long r110 = z.o(r11).id;
    L25:
        r19.h = r110;
        r19.j = r13;
        r19.k = r14;
        r19.l = r15;
        if (r19.isAdded() == true) goto L55;
        CommentSettingDialog.a.a(r19, r17);
        ((LinkedHashMap) r19.m).clear();
        r19.m.putAll(r2);
    L38:
        com.bytedance.android.livesdk.log.g r20 = com.bytedance.android.livesdk.log.u.l();
        HashMap r21 = new HashMap();
        IUserService r22 = jc1.k.f(IUserService.class);
        String r23 = "0";
        if (r22 == null) goto L44;
        com.bytedance.android.livesdk.user.f r24 = r22.user();
        if (r24 == null) goto L44;
        String r25 = r24.n();
        if (r25 == null) goto L44;
    L45:
        r21.put("anchor_id", r25);
        Unit r26 = Unit.INSTANCE;
        r20.sendLog("livesdk_anchor_setting_revenue_function_page_show", r21, new Object[0]);
        com.bytedance.android.livesdk.log.g r27 = com.bytedance.android.livesdk.log.u.l();
        HashMap r28 = new HashMap();
        r28.put("enter_from_merge", "direct_shoot");
        r28.put("anchor_id", jc1.k.n(IUserService.class).user().n());
        if (r9 == true) goto L50;
        if (r11 == null) goto L50;
        long r111 = z.o(r11).id;
    L51:
        r28.put("room_id", String.valueOf(r111));
        if (r13 == false) goto L54;
        r23 = "1";
    L54:
        r28.put("is_paidlive", r23);
        r28.put("ticket_id", String.valueOf(r14));
        r28.put("ticket_name", r15);
        r27.sendLog("livesdk_anchor_interact_right_click", r28, new Object[0]);
    L50:
        r111 = 0;
    L44:
        r25 = "0";
    L24:
        r110 = 0;
        goto L25
    L30:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.interactivity.api.anchorsetting.CommentSettingDialog");
    L31:
        CommentSettingDialog r112 = new CommentSettingDialog();
        r112.e = r10;
        r112.i = r12;
        r112.f = r9;
        r112.g = r11;
        if (r9 == true) goto L36;
        if (r11 == null) goto L36;
        long r113 = z.o(r11).id;
    L37:
        r112.h = r113;
        r112.j = r13;
        r112.k = r14;
        r112.l = r15;
        r112.m.putAll(r2);
        CommentSettingDialog.a.a(r112, r17);
    L36:
        r113 = 0;
    L8:
        r5 = "";
    L55:
        this.e.dismissDialog();
        this.a.a();
    }
}
