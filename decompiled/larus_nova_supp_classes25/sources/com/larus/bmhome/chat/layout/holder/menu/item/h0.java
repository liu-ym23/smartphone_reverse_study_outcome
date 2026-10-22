package com.larus.bmhome.chat.layout.holder.menu.item;

import androidx.core.content.ContextCompat;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.auth.TouristModeABParam;
import com.larus.bmhome.auth.h1;
import com.larus.bmhome.auth.i1;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.AnswerAction;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.i3;
import com.larus.platform.service.x1;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class h0 {

    public static final class a {
    }

    static {
    }

    public static com.larus.bmhome.view.screenmenu.l0 a(Message r49, com.larus.bmhome.chat.api.q0.a r50, AnswerAction r51) {
        Intrinsics.checkNotNullParameter(r49, "data");
        Integer r0 = null;
        if (r51 == null) goto L5;
        String r2 = r51.getKey();
    L6:
        String r3 = "fork_conv";
        boolean r4 = Intrinsics.areEqual(r2, "fork_conv");
        if (r50 == null) goto L11;
        com.larus.bmhome.chat.component.cvs.y r5 = r50.u0();
        if (r5 == null) goto L11;
        wc9.e r6 = r5.h();
    L12:
        boolean r7 = false;
        if (r4 == true) goto L15;
    L27:
        boolean r8 = false;
    L28:
        if (r8 == false) goto L30;
        return null;
    L30:
        int r9 = r49.getMessageStatusLocal();
        boolean r10 = ic8.n.v(r6);
        if (r10 == true) goto L37;
        if (r4 == true) goto L34;
    L36:
        boolean r11 = false;
    L38:
        if (r4 == false) goto L50;
        long r12 = 0;
        if (r49.getServerIndex() <= 0) goto L50;
        long r13 = r49.getServerIndex();
        if (r6 == null) goto L47;
        Long r14 = r6.w;
        if (r14 == null) goto L47;
        r12 = r14.longValue();
    L47:
        if (r13 >= r12) goto L50;
        boolean r15 = false;
    L51:
        boolean r1 = com.larus.bmhome.chat.bean.d.r0(r49);
        z2 r16 = z2.a;
        r16.w3();
        FLogger.a.d("NewCvsMenuItemCreator", "messageLocalStatus(" + r9 + "), isMainCvs(" + r10 + "), isLocal(" + r1 + "), enableLongPressCreateSubConversation(null)");
        if (r4 == false) goto L59;
        if (r9 != 21) goto L56;
    L62:
        boolean r17 = true;
    L64:
        if (r17 == false) goto L127;
        if (r11 == false) goto L128;
        if (r15 == false) goto L129;
        if (r1 == false) goto L69;
        return null;
    L69:
        if (i3.a.f() == false) goto L83;
        i1 r18 = h1.a();
        if (r18 == null) goto L80;
        TouristModeABParam r19 = r18.b;
        if (r19 == null) goto L80;
        Integer r20 = r19.getType();
        if (r20 == null) goto L80;
        if (r20.intValue() != 1) goto L80;
        boolean r21 = true;
    L81:
        if (r21 == false) goto L83;
        r7 = true;
    L80:
        r21 = false;
    L83:
        if (r7 == false) goto L85;
        return null;
    L85:
        if (x1.a.a() == true) goto L132;
        AppHost.Companion r22 = AppHost.a;
        if (r22.isPlugin() == false) goto L89;
        r16.w3();
        return null;
    L89:
        r16.w3();
        if (AccountService.a.isEnterpriseAccount() == false) goto L92;
        int r23 = 2131901134;
    L94:
        if (r4 == false) goto L96;
        int r24 = 2131909358;
    L97:
        if (r4 == false) goto L99;
        int r110 = 2131909358;
    L100:
        if (r51 == null) goto L106;
        String r25 = r51.getName();
        if (r25 == null) goto L106;
        if ((!StringsKt.isBlank(r25)) == false) goto L106;
        String r111 = r25;
    L107:
        if (r4 == false) goto L109;
        Integer r112 = 2131242741;
    L110:
        if (r4 == false) goto L112;
        Integer r26 = Integer.valueOf(v19.c.c(2130972080, r22.a().getCurrentActivity(), ContextCompat.getColor(r22.getApplication(), 2131103140)));
    L113:
        if (r4 == false) goto L115;
        int r27 = 2131242701;
    L116:
        if (r4 == false) goto L118;
        Integer r28 = Integer.valueOf(v19.c.c(2130972079, r22.a().getCurrentActivity(), ContextCompat.getColor(r22.getApplication(), 2131103136)));
    L119:
        if (r4 == false) goto L121;
        r0 = Integer.valueOf(i5.v());
    L121:
        Integer r44 = r0;
        if (r4 == true) goto L126;
        r3 = "create_new_chat";
    L126:
        return new com.larus.bmhome.view.screenmenu.l0(r24, r110, r111, null, null, null, null, r112, null, false, false, null, Integer.valueOf(r27), null, false, false, r28, r26, r3, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r44, null, false, -921736, DoraCallStateCode.DOUBAO_CMD_5);
    L118:
        r28 = null;
        goto L119
    L115:
        r27 = com.larus.bmhome.utils.t.a();
        goto L116
    L112:
        r26 = null;
        goto L113
    L109:
        r112 = null;
    L106:
        r111 = null;
        goto L107
    L99:
        r110 = r23;
        goto L100
    L96:
        r24 = 2131901131;
        goto L97
    L92:
        r23 = 2131901131;
        goto L94
    L132:
        return null;
    L129:
        return null;
    L128:
        return null;
    L127:
        return null;
    L56:
        if (r9 == 23) goto L62;
    L63:
        r17 = false;
        goto L64
    L59:
        if (r9 == 22) goto L63;
        if (r9 == 12) goto L63;
    L50:
        r15 = true;
        goto L51
    L34:
        if (ic8.n.D(r6) == false) goto L36;
    L37:
        r11 = true;
        goto L38
    L15:
        if (z2.a.J3() == true) goto L17;
    L26:
        r8 = true;
        goto L28
    L17:
        if (com.larus.bmhome.chat.bean.d.G0(r49) == true) goto L26;
        Map r29 = r49.getExt();
        if (r29 == null) goto L21;
        String r30 = (String) r29.get("disable_fork");
    L23:
        if (Intrinsics.areEqual(r30, "1") == true) goto L26;
        if (ic8.n.o(r6) == false) goto L27;
    L21:
        r30 = null;
    L11:
        r6 = null;
        goto L12
    L5:
        r2 = null;
        goto L6
    }
}
