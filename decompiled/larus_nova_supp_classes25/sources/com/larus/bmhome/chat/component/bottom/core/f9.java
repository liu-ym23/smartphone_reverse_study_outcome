package com.larus.bmhome.chat.component.bottom.core;

import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.im.bean.conversation.InputLeftButtonStyle;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f9 {
    public static final Lazy a = null;

    public f9() {
    }

    static {
        a = LazyKt.lazy(new e9());
    }

    public static boolean a() {
        return ((com.larus.platform.model.chat.y) a.getValue()).a();
    }

    public static Integer b(wc9.e r8, String r9, Integer r10) {
        boolean r0 = false;
        Integer r2 = null;
        if (r8 == null) goto L15;
        String r3 = r8.a;
        if (r3 == null) goto L15;
        if (r3.length() <= 0) goto L9;
        boolean r4 = true;
    L10:
        if (r4 == true) goto L13;
        r3 = null;
    L13:
        if (r3 == null) goto L15;
        r9 = r3;
        goto L15
    L9:
        r4 = false;
    L15:
        if (r8 == null) goto L17;
        Integer r5 = r8.v;
    L18:
        if (r5 != null) goto L20;
    L28:
        boolean r6 = com.larus.im.j.f(r9);
        if (com.larus.platform.exp.o.a() == true) goto L38;
        if (r10 != null) goto L33;
    L36:
        return null;
    L33:
        if (r10.intValue() != 3) goto L36;
        if (r6 == false) goto L36;
        FLogger.a.i("InputLeftIconConfig", "[MainConversationInputFallback] reject=gate_disabled");
        goto L36
    L38:
        if (r10 != null) goto L41;
    L42:
        if (r6 == false) goto L47;
        FLogger r11 = FLogger.a;
        StringBuilder r7 = new StringBuilder("[MainConversationInputFallback] reject=conversation_type type=");
        r7.append(r10);
        r7.append(" conversationPresent=");
        if (r8 == null) goto L46;
        r0 = true;
    L46:
        r7.append(r0);
        r11.i("InputLeftIconConfig", r7.toString());
    L47:
        return null;
    L41:
        if (r10.intValue() != 3) goto L42;
        if (r6 == true) goto L60;
        FLogger r12 = FLogger.a;
        StringBuilder r13 = new StringBuilder("[MainConversationInputFallback] reject=non_local_conversation conversationPresent=");
        if (r8 == null) goto L52;
        boolean r14 = true;
    L53:
        r13.append(r14);
        r13.append(" conversationIdEmpty=");
        if (r9 != null) goto L56;
    L57:
        r0 = true;
    L58:
        r13.append(r0);
        r12.i("InputLeftIconConfig", r13.toString());
        return null;
    L56:
        if (r9.length() != 0) goto L58;
    L52:
        r14 = false;
        goto L53
    L60:
        String r15 = AccountService.a.getSecUserId();
        if (StringsKt.isBlank(r15) == false) goto L64;
        FLogger.a.i("InputLeftIconConfig", "[MainConversationInputFallback] reject=current_account_empty");
        return null;
    L64:
        AuthModelDelegate r16 = AuthModelDelegate.b;
        com.larus.bmhome.auth.h0 r17 = r16.v();
        if (r17 != null) goto L69;
        FLogger.a.i("InputLeftIconConfig", "[MainConversationInputFallback] reject=core_launch_missing");
        return null;
    L69:
        if (Intrinsics.areEqual(r17.h(), r15) == true) goto L72;
        FLogger.a.i("InputLeftIconConfig", "[MainConversationInputFallback] reject=launch_account_mismatch");
        return null;
    L72:
        String r18 = r17.b();
        if (r18 != null) goto L75;
    L82:
        r18 = null;
    L83:
        if (r18 != null) goto L86;
        FLogger.a.i("InputLeftIconConfig", "[MainConversationInputFallback] reject=assistant_bot_invalid");
        return null;
    L86:
        String r19 = com.larus.im.j.b(r9);
        if (Intrinsics.areEqual(r19, r18) == true) goto L95;
        FLogger r20 = FLogger.a;
        StringBuilder r110 = new StringBuilder("[MainConversationInputFallback] reject=bot_id_mismatch localBotPresent=");
        if (r19 != null) goto L91;
    L92:
        r0 = true;
    L93:
        r110.append(!r0);
        r20.i("InputLeftIconConfig", r110.toString());
        return null;
    L91:
        if (r19.length() != 0) goto L93;
    L95:
        if (r8 == null) goto L104;
        Integer r21 = r8.C;
        if (r21 == null) goto L104;
        if (r21.intValue() == InputLeftButtonStyle.ButtonStyle_None.getValue()) goto L101;
        boolean r111 = true;
    L102:
        if (r111 == false) goto L104;
    L105:
        wc9.e r112 = (wc9.e) r16.u().getValue();
        if (r112 == null) goto L108;
        r2 = r112.C;
    L108:
        if (r21 == null) goto L110;
        String r113 = "conversation";
    L113:
        if (r21 == null) goto L115;
        int r22 = r21.intValue();
    L118:
        FLogger r23 = FLogger.a;
        StringBuilder r24 = new StringBuilder("[MainConversationInputFallback] resolved source=");
        r24.append(r113);
        r24.append(" style=");
        r24.append(r22);
        r24.append(" conversationPresent=");
        if (r8 == null) goto L121;
        r0 = true;
    L121:
        r24.append(r0);
        r23.i("InputLeftIconConfig", r24.toString());
        return Integer.valueOf(r22);
    L115:
        if (r2 == null) goto L117;
        r22 = r2.intValue();
        goto L118
    L117:
        r22 = InputLeftButtonStyle.ButtonStyle_Camera.getValue();
        goto L118
    L110:
        if (r2 == null) goto L112;
        r113 = "main_bot_cache";
        goto L113
    L112:
        r113 = "camera_fallback";
        goto L113
    L101:
        r111 = false;
    L104:
        r21 = null;
        goto L105
    L75:
        if ((!StringsKt.isBlank(r18)) == true) goto L77;
    L79:
        boolean r25 = false;
    L80:
        if (r25 == false) goto L82;
    L77:
        if (Intrinsics.areEqual(r18, "0") == true) goto L79;
        r25 = true;
        goto L80
    L20:
        if (r5.intValue() == 0) goto L22;
        boolean r26 = true;
    L23:
        if (r26 == true) goto L26;
        r5 = null;
    L26:
        if (r5 == null) goto L28;
        r10 = r5;
        goto L28
    L22:
        r26 = false;
        goto L23
    L17:
        r5 = null;
        goto L18
    }
}
