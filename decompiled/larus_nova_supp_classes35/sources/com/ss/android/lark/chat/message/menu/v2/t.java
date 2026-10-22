package com.ss.android.lark.chat.message.menu.v2;

import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import com.ss.android.lark.chat.utils.ChatParamUtils;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.statistics.message_menu.MessageMenuHitPoint;
import com.ss.android.lark.utils.UIHelper;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import z5c.h3;
import z5c.n2;
import z5c.t0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class t implements com.ss.android.lark.chat.message.menu.b {
    public final /* synthetic */ MessageActionPanelManager<y6b.a<?>> a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ Map<String, Object> c;
    public final /* synthetic */ long d;

    @Override // com.ss.android.lark.chat.message.menu.b
    public final void a(yya.i r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r12, Keys.API_PARAM_KEY_ACTION);
        if (r13 == true) goto L5;
        return;
    L5:
        MessageActionPanelManager<y6b.a<?>> r14 = this.a;
        boolean r0 = this.b;
        Map<String, Object> r1 = this.c;
        long r2 = this.d;
        r14.getClass();
        Map r4 = r12.R4();
        s5c.d r5 = r12.g();
        boolean r6 = true;
        if (r4 != null) goto L8;
    L11:
        boolean r8 = true;
    L12:
        if (r8 == false) goto L15;
        if (r5 != null) goto L15;
    L44:
        MessageActionPanelManager<y6b.a<?>> r15 = this.a;
        r15.getClass();
        MessageActionType r3 = r12.getType();
        switch(MessageActionPanelManager.b.a[r3.ordinal()]) {
            case 1: goto L60;
            case 2: goto L59;
            case 3: goto L58;
            case 4: goto L57;
            case 5: goto L56;
            case 6: goto L55;
            case 7: goto L50;
            case 8: goto L49;
            case 9: goto L48;
            case 10: goto L47;
            default: goto L71;
        };
    L47:
        MessageMenuHitPoint.a.a().sendEvent("message_menu_delete_click", null);
        return;
    L48:
        MessageMenuHitPoint.a.a().sendEvent("message_menu_translate_click", null);
        return;
    L49:
        MessageMenuHitPoint.a.a().sendEvent("message_menu_recall_click", null);
        return;
    L50:
        boolean r16 = Intrinsics.areEqual(r12.getLabel(r15.a.getContext()), UIHelper.getString(2131892514));
        o5c.b r17 = MessageMenuHitPoint.a.a();
        JSONObject r7 = new JSONObject();
        if (r16 == false) goto L53;
        String r18 = "pin";
    L54:
        r17.sendEvent("message_menu_pin_click", r7.put("interaction", r18));
        return;
    L53:
        r18 = "unpin";
        goto L54
    L55:
        MessageMenuHitPoint.a.a().sendEvent("message_menu_multi-select_click", null);
        return;
    L56:
        MessageMenuHitPoint.a.a().sendEvent("message_menu_favorite_click", null);
        return;
    L57:
        MessageMenuHitPoint.a.a().sendEvent("message_menu_forward_click", null);
        return;
    L58:
        MessageMenuHitPoint.a.a().sendEvent("message_menu_copy_click", null);
        return;
    L59:
        MessageMenuHitPoint.a.a().sendEvent("message_menu_reply_click", null);
        return;
    L60:
        MessageMenuHitPoint.a.a().sendEvent("message_menu_buzz_click", null);
        return;
    L71:
        return;
    L15:
        s5c.a r9 = n2.c;
        long r10 = (System.currentTimeMillis() - r2) / ((long) 1000);
        s5c.a r11 = h3.c.a(String.valueOf(r10));
        r9.getClass();
        s5c.d r19 = s5c.d.b.b(r9, r11).plus(r1);
        if (r4 != null) goto L18;
    L21:
        if (r6 == true) goto L23;
        r19 = r19.plus(r4);
    L23:
        if (r5 == null) goto L25;
        r19 = r19.plus(r5);
    L25:
        s5c.d r20 = r19.plus(ChatParamUtils.f(r14.a.getChatId()));
        if (r12.getType() == MessageActionType.FORWARD) goto L30;
        if (r12.getType() == MessageActionType.FORWARD_REPLY_IN_THREAD) goto L30;
    L35:
        if (r0 == false) goto L37;
        String r21 = "im_msg_select_text_menu_click";
    L39:
        if (Intrinsics.areEqual(r21, "im_msg_select_text_menu_click") == false) goto L43;
        String r110 = r14.k;
        if (r110 == null) goto L43;
        r20 = r20.plus(MapsKt.mapOf(TuplesKt.to("menu_open_action", r110)));
    L43:
        Statistics.sendEvent(r21, r20.toJson());
        goto L44
    L37:
        r21 = "im_msg_menu_click";
    L30:
        if (r14.a.e0() == false) goto L32;
        s5c.a r22 = t0.c;
    L33:
        r20 = r20.plus(r22);
        goto L35
    L32:
        r22 = t0.d;
        goto L33
    L18:
        if (r4.isEmpty() == true) goto L21;
        r6 = false;
        goto L21
    L8:
        if (r4.isEmpty() == true) goto L11;
        r8 = false;
        goto L12
    }

    public t(MessageActionPanelManager<y6b.a<?>> r1, boolean r2, Map<String, ? extends Object> r3, long r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
