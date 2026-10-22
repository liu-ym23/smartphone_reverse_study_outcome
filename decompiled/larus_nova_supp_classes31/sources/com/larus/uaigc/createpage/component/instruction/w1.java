package com.larus.uaigc.createpage.component.instruction;

import com.larus.bmhome.chat.ChatParam;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class w1 implements vp8.j {
    public final /* synthetic */ CreationEditorComponent a;

    public final void a() {
    }

    public final de8.c f1() {
        return null;
    }

    public final void A1() {
        this.a.A1();
    }

    public final List<com.larus.bmhome.actionbar.model.u> b() {
        uz9.a r0 = this.a.r;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b();
    }

    public final ChatParam c() {
        ny9.s r0 = this.a.W3();
        if (r0 == null) goto L6;
        ChatParam r1 = r0.c();
        if (r1 == null) goto L6;
        return r1;
    L6:
        ny9.u r2 = this.a.d4();
        String r3 = null;
        if (r2 == null) goto L9;
        String r4 = r2.Y1();
    L11:
        if (r4 != null) goto L13;
        String r5 = "";
    L14:
        ny9.u r6 = this.a.d4();
        if (r6 == null) goto L17;
        String r7 = r6.getBotId();
    L18:
        if (r7 != null) goto L20;
        String r8 = "";
    L21:
        ny9.u r9 = this.a.d4();
        if (r9 == null) goto L24;
        String r10 = r9.getChatType();
    L25:
        if (r10 != null) goto L27;
        String r11 = "";
    L28:
        ny9.u r12 = this.a.d4();
        if (r12 == null) goto L31;
        r3 = r12.b();
    L31:
        if (r3 != null) goto L33;
        String r13 = "";
    L35:
        return new ChatParam(r5, r8, r13, null, r11, 232);
    L33:
        r13 = r3;
        goto L35
    L27:
        r11 = r10;
        goto L28
    L24:
        r10 = null;
        goto L25
    L20:
        r8 = r7;
        goto L21
    L17:
        r7 = null;
        goto L18
    L13:
        r5 = r4;
        goto L14
    L9:
        r4 = null;
        goto L11
    }

    public w1(CreationEditorComponent r1) {
        this.a = r1;
    }
}
