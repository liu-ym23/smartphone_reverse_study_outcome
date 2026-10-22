package com.larus.bmhome.chat.list.cell.text.components.bottom.actionbar;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.utils.w2;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d0 implements tg8.b {
    public d0() {
    }

    public final boolean c(t1a.b r7, Message r8, com.larus.bmhome.chat.api.q0 r9) {
        Intrinsics.checkNotNullParameter(r8, "msg");
        Integer r2 = null;
        if (com.larus.bmhome.chat.bean.d.x0(r8) == false) goto L19;
        com.larus.bmhome.chat.helper.n0 r0 = com.larus.bmhome.chat.helper.n0.a;
        String r4 = r8.getMessageId();
        r0.getClass();
        int r1 = w2.a(r4);
        List r5 = r8.getSubList();
        if (r5 == null) goto L10;
        if (r1 < 0) goto L10;
        if (r1 >= r5.size()) goto L10;
        Object r3 = ListProtector.get(r5, r1);
    L11:
        Message r6 = (Message) r3;
        if (r6 != null) goto L14;
    L17:
        return false;
    L14:
        if (r6.getMessageStatusLocal() != 21) goto L17;
        if (com.larus.bmhome.chat.bean.d.Q0(r6) == false) goto L19;
    L10:
        r3 = null;
    L19:
        if (com.larus.bmhome.chat.bean.d.v(r8) == false) goto L22;
        return false;
    L22:
        if (com.larus.bmhome.chat.bean.d.V(r8) == false) goto L25;
        return false;
    L25:
        if (hc8.c.a.j(r8) == true) goto L87;
        Map r10 = r8.getExt();
        if (r10 == null) goto L29;
        String r11 = (String) r10.get("need_auth_identity");
    L31:
        if (Intrinsics.areEqual(r11, "1") == true) goto L87;
        if (r7 == null) goto L35;
        com.larus.bmhome.chat.component.cvs.y r12 = (com.larus.bmhome.chat.component.cvs.y) r7.getAbility(com.larus.bmhome.chat.component.cvs.y.class);
    L36:
        BotModel r13 = dg8.t.d(r12);
        if (r13 == null) goto L39;
        List r14 = r13.getStreamingAnswerActions();
    L41:
        if (z2.a.canShowAnswerActionBar() == false) goto L43;
    L46:
        if (r7 == null) goto L50;
        de8.c r15 = (de8.c) r7.a(de8.c.class);
        if (r15 == null) goto L50;
        r2 = r15.m();
    L50:
        if (r2 == null) goto L53;
        return false;
    L53:
        if (r7 == null) goto L59;
        com.larus.bmhome.chat.component.regen.a r16 = r7.getAbility(com.larus.bmhome.chat.component.regen.a.class);
        if (r16 == null) goto L59;
        if (r16.tL(r8) != true) goto L59;
        boolean r17 = true;
    L61:
        if (dg8.t.i(r14, r8) == false) goto L63;
    L86:
        return true;
    L63:
        if (dg8.t.g(r9, r8, r14) == true) goto L86;
        if (dg8.t.f(r9, r8) == true) goto L86;
        if (r17 == true) goto L68;
    L85:
        return false;
    L68:
        if (com.larus.bmhome.chat.bean.d.Q0(r8) == true) goto L85;
        if (com.larus.bmhome.chat.bean.d.P0(r8) == true) goto L85;
        if (com.larus.bmhome.chat.bean.d.r0(r8) == true) goto L85;
        if (r8.getMessageStatusLocal() != 21) goto L76;
    L77:
        if (r7 == null) goto L83;
        com.larus.bmhome.chat.component.cvs.y r18 = r7.getAbility(com.larus.bmhome.chat.component.cvs.y.class);
        if (r18 == null) goto L83;
        if (dg8.t.h(r18) != true) goto L83;
        boolean r19 = true;
    L84:
        if (r19 == false) goto L86;
    L83:
        r19 = false;
        goto L84
    L76:
        if (r8.getMessageStatusLocal() != 23) goto L85;
    L59:
        r17 = false;
        goto L61
    L43:
        if (dg8.t.b(r14) == true) goto L46;
        FLogger.a.i("MessagePluginAuthComponent", "canShowAnswerActionBar() result is false");
        return false;
    L39:
        r14 = null;
        goto L41
    L35:
        r12 = null;
        goto L36
    L29:
        r11 = null;
    L87:
        return false;
    }
}
