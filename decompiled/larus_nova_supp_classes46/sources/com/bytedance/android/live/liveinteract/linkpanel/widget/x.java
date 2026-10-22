package com.bytedance.android.live.liveinteract.linkpanel.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class x implements View.OnClickListener {
    public final /* synthetic */ LinkPanelTopBarWidget a;
    public final /* synthetic */ Ref.IntRef b;

    public x(LinkPanelTopBarWidget r1, Ref.IntRef r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r10) {
        Object r0 = null;
        if (((IInteractService) jc1.k.n(IInteractService.class)).getLinkPanelTransitService() == null) goto L13;
        Context r2 = this.a.e;
        int r4 = this.b.element;
        Intrinsics.checkNotNullParameter(r2, "context");
        boolean r3 = gh0.a.d();
        com.bytedance.live.datacontext.m r1 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r1 == null) goto L7;
        IRoom r5 = (IRoom) r1.getValue();
    L8:
        com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.m r11 = new com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.m(r2, r3, r4, r5, false, null, 112);
        if (DialogLancet.shouldBlockDialogShow(r11) == false) goto L38;
        DialogLancet.handleBlockedDialogShow(r11);
        goto L13
    L38:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L37
    L12:
        DialogLancet.beforeDialogShow(r11);
        r11.show();
        DialogLancet.afterDialogShow(r11);
        goto L13
    L7:
        r5 = null;
    L13:
        yf0.g r12 = this.a.i;
        if (r12 == null) goto L16;
        r12.dismiss();
    L16:
        int r13 = this.b.element;
        SimpleDateFormat r6 = com.bytedance.android.live.liveinteract.linkpanel.util.o.a;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r7 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkUserInfoCenter();
        if (r7 == null) goto L31;
        Iterator<T> r8 = r7.d().iterator();
    L20:
        if (r8.hasNext() == false) goto L27;
        Object r9 = r8.next();
        if (((int) ((LinkmicPositionItem) r9).getPosition()) != r13) goto L24;
        boolean r14 = true;
    L25:
        if (r14 == false) goto L20;
        r0 = r9;
        goto L27
    L24:
        r14 = false;
    L27:
        LinkmicPositionItem r15 = (LinkmicPositionItem) r0;
        if (r15 == null) goto L31;
        String r16 = r15.getActiveName();
        if (r16 == null) goto L31;
    L32:
        boolean r17 = TextUtils.isEmpty(r16);
        HashMap r18 = new HashMap();
        com.bytedance.android.live.liveinteract.linkpanel.util.m.B(r18, Integer.valueOf(com.bytedance.android.live.liveinteract.linkpanel.util.o.c()), 4);
        r18.put("seat_num", String.valueOf(r13));
        String r19 = "0";
        r18.put("is_guest", "0");
        if (r17 == false) goto L35;
        r19 = "1";
    L35:
        r18.put("is_first_edit", r19);
        r18.put("user_type", "anchor");
        j0.l().sendLog("livesdk_anchor_audience_connection_seat_name_setting_click", r18, new Object[]{IRoom.class, am2.x.class});
        return;
    L31:
        r16 = "";
        goto L32
    }
}
