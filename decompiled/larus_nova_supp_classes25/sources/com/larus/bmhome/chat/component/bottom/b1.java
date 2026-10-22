package com.larus.bmhome.chat.component.bottom;

import android.os.Bundle;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.model.n;
import com.larus.bmhome.utils.i;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import de8.c;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import s1a.d;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b1 implements com.larus.bmhome.chat.component.cvs.y.a<e> {
    public final /* synthetic */ ChatBottomComponent a;

    public b1(ChatBottomComponent r1) {
        this.a = r1;
    }

    public final void c(Object r12) {
        e r13 = (e) r12;
        Intrinsics.checkNotNullParameter(r13, "new");
        FLogger.a.d("ChatBottomComponent", "observeConversationChanged, onChange, new=" + r13);
        ChatBottomComponent r0 = this.a;
        int r1 = ChatBottomComponent.L0;
        c r2 = r0.f1();
        if (r2 != null) goto L5;
    L7:
        boolean r6 = false;
    L8:
        ChatBottomComponent r3 = this.a;
        n r4 = r3.D;
        String r5 = null;
        if (r4 == null) goto L56;
        String r7 = r13.a;
        ChatPageContext r8 = (ChatPageContext) d.a(r3).a(ChatPageContext.class);
        if (r8 == null) goto L13;
        String r9 = r8.getConversationMode();
    L15:
        if (i.f(r13) == false) goto L54;
        va8.f0 r10 = d.a(this.a).getAbility(va8.f0.class);
        if (r10 != null) goto L19;
    L21:
        boolean r11 = false;
    L22:
        if (r11 == true) goto L54;
        c r14 = this.a.f1();
        if (r14 != null) goto L26;
    L28:
        boolean r15 = false;
    L29:
        if (r15 == true) goto L54;
        c r16 = this.a.f1();
        if (r16 == null) goto L33;
        String r17 = r16.o();
    L34:
        if (r17 != null) goto L36;
    L39:
        boolean r18 = true;
    L40:
        if (r18 == false) goto L54;
        c r19 = this.a.f1();
        if (r19 == null) goto L46;
        Bundle r20 = r19.b;
        if (r20 == null) goto L46;
        r5 = r20.getString("human_merge_forward_info");
    L46:
        if (r5 != null) goto L48;
    L51:
        boolean r21 = true;
    L52:
        if (r21 == false) goto L54;
        boolean r22 = true;
    L55:
        ChatBottomComponent r23 = this.a;
        r5 = r4.C(r7, "onConversationChanged", r6, r9, r22, r23.Q, r23.R);
        goto L56
    L48:
        if (StringsKt.isBlank(r5) == true) goto L51;
        r21 = false;
        goto L52
    L36:
        if (StringsKt.isBlank(r17) == true) goto L39;
        r18 = false;
        goto L40
    L33:
        r17 = null;
        goto L34
    L26:
        if (r14.n() != true) goto L28;
        r15 = true;
        goto L29
    L19:
        if (r10.R() != true) goto L21;
        r11 = true;
    L54:
        r22 = false;
        goto L55
    L13:
        r9 = null;
    L56:
        z2 r24 = z2.a;
        if (z2.c4() == false) goto L63;
        c r25 = this.a.f1();
        if (r25 == null) goto L63;
        Bundle r26 = r25.b;
        if (r26 == null) goto L63;
        r26.putString("entry_draft_replacement_token", r5);
    L63:
        ChatBottomComponent r27 = this.a;
        String r28 = r27.S;
        if (r28 == null) goto L66;
        r27.Q3(r28);
    L66:
        com.larus.bmhome.chat.model.b0 r29 = this.a.E;
        if (r29 == null) goto L69;
        r29.c(r13.a);
    L69:
        p1$a.a(this.a);
        this.a.W3();
        return;
    L5:
        if (r2.A() != true) goto L7;
        r6 = true;
        goto L8
    }
}
