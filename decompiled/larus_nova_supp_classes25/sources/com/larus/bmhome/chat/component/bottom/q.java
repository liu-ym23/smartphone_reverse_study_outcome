package com.larus.bmhome.chat.component.bottom;

import android.os.Bundle;
import com.larus.bmhome.chat.model.strategy.ChatSendUtils;
import com.larus.im.bean.message.MessageStatus;
import com.larus.platform.service.z2;
import de8.c;
import gd8.g;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class q implements Function0 {
    public final /* synthetic */ ChatBottomComponent a;

    public /* synthetic */ q(ChatBottomComponent r1) {
        this.a = r1;
    }

    public final Object invoke() {
        ChatBottomComponent r1 = this.a;
        if (r1.J == true) goto L82;
        r1.J = true;
        c r3 = r1.f1();
        String r5 = "";
        String r6 = null;
        if (r3 == null) goto L11;
        Bundle r4 = r3.b;
        if (r4 == null) goto L10;
        String r7 = r4.getString("push_question");
        if (r7 == null) goto L10;
    L13:
        if (r7 != null) goto L15;
    L18:
        boolean r8 = true;
    L19:
        if (r8 == false) goto L28;
        c r9 = r1.f1();
        String r10 = "qst3";
        if (r9 == null) goto L27;
        Bundle r11 = r9.b;
        if (r11 == null) goto L26;
        r7 = r11.getString("qst3");
        if (r7 == null) goto L26;
    L30:
        if (com.larus.utils.o0.d(r7) == false) goto L82;
        if (r1.X3(r10) == false) goto L34;
    L37:
        boolean r12 = true;
    L38:
        if (r12 == false) goto L43;
        if (r7 == null) goto L42;
        r5 = r7;
    L42:
        r1.Q3(r5);
        return Unit.INSTANCE;
    L43:
        c r13 = r1.f1();
        if (r13 == null) goto L48;
        Bundle r14 = r13.b;
        if (r14 == null) goto L48;
        String r15 = r14.getString("sq");
    L50:
        if (r15 == null) goto L52;
        boolean r16 = Intrinsics.areEqual(r15, "1");
    L53:
        if (r16 == false) goto L55;
        MessageStatus r17 = MessageStatus.MessageStatus_AVAILABLE;
    L56:
        MessageStatus r18 = r17;
        g r19 = (g) r1.y.getValue();
        if (r19 == null) goto L82;
        String r110 = r1.D3();
        if (r7 != null) goto L61;
        String r111 = "";
    L62:
        ChatSendUtils r20 = ChatSendUtils.a;
        Pair[] r21 = new Pair[4];
        c r112 = r1.f1();
        if (r112 == null) goto L69;
        Bundle r113 = r112.b;
        if (r113 == null) goto L68;
        String r114 = r113.getString("fs");
        if (r114 == null) goto L68;
    L71:
        if (Intrinsics.areEqual(r114, "1") == false) goto L73;
        String r115 = "1";
    L74:
        r21[0] = TuplesKt.to("search_intend", r115);
        r21[1] = TuplesKt.to("from_push", "1");
        r21[2] = TuplesKt.to("source", "push_question");
        c r2 = r1.f1();
        if (r2 == null) goto L77;
        r6 = r2.r();
    L77:
        if (r6 == null) goto L80;
        r5 = r6;
    L80:
        r21[3] = TuplesKt.to("push_open_url", r5);
        r20.getClass();
        g.a.b(r19, r110, r111, "push_hot_question", ChatSendUtils.p(r21), false, r18, null, null, null, null, 2000);
        goto L82
    L73:
        r115 = "0";
    L68:
        r114 = "";
        goto L71
    L69:
        r114 = null;
        goto L71
    L61:
        r111 = r7;
        goto L62
    L55:
        r17 = MessageStatus.MessageStatus_INVISIBLE;
        goto L56
    L52:
        r16 = z2.a.pushHotShowQuestion();
    L48:
        r15 = null;
        goto L50
    L34:
        if (r1.X3("push_question") == true) goto L37;
        r12 = false;
    L26:
        r7 = "";
        goto L30
    L27:
        r7 = null;
        goto L30
    L28:
        r10 = "question";
        goto L30
    L15:
        if (r7.length() == 0) goto L18;
        r8 = false;
    L10:
        r7 = "";
        goto L13
    L11:
        r7 = null;
    L82:
        return Unit.INSTANCE;
    }
}
