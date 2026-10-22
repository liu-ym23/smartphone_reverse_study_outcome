package com.larus.bmhome.instruction;

import android.os.Bundle;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.view.actionbar.custom.CustomActionBar;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class m1 implements vp8.j {
    public final /* synthetic */ InstructionInputComponent a;

    @Override // vp8.j
    public final void A1() {
        this.a.A1();
    }

    @Override // vp8.j
    public final void a() {
        CustomActionBar r0 = this.a.P0;
        if (r0 == null) goto L6;
        r0.J = true;
        return;
    }

    @Override // vp8.j
    public final List<com.larus.bmhome.actionbar.model.u> b() {
        com.larus.bmhome.view.actionbar.edit.b r0 = this.a.P1;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b();
    }

    @Override // vp8.j
    public final ChatParam c() {
        InstructionInputComponent r0 = this.a;
        String r1 = InstructionInputComponent.Z2;
        com.larus.bmhome.chat.component.cvs.y r2 = r0.u0();
        String r3 = null;
        if (r2 != null) goto L5;
        return null;
    L5:
        String r4 = r2.Y1();
        boolean r5 = false;
        if (r4.length() <= 0) goto L8;
        boolean r6 = true;
    L9:
        if (r6 == false) goto L11;
        String r7 = r4;
    L12:
        if (r7 != null) goto L14;
        return null;
    L14:
        String r8 = r2.getBotId();
        if (r8.length() <= 0) goto L17;
        r5 = true;
    L17:
        if (r5 == false) goto L19;
        String r9 = r8;
    L20:
        wc9.e r10 = r2.h();
        String r11 = this.a.f1().p();
        if (r10 == null) goto L26;
        String r12 = ic8.n.f(r10);
        if (r12 == null) goto L26;
        String r13 = r12;
    L31:
        return new ChatParam(r7, r9, r11, "chat", r13, 224);
    L26:
        Bundle r14 = this.a.f1().b;
        if (r14 == null) goto L29;
        r3 = r14.getString("chat_type");
    L29:
        r13 = r3;
        goto L31
    L19:
        r9 = null;
        goto L20
    L11:
        r7 = null;
        goto L12
    L8:
        r6 = false;
        goto L9
    }

    @Override // vp8.j
    public final de8.c f1() {
        InstructionInputComponent r0 = this.a;
        String r1 = InstructionInputComponent.Z2;
        return r0.f1();
    }

    public m1(InstructionInputComponent r1) {
        this.a = r1;
    }
}
