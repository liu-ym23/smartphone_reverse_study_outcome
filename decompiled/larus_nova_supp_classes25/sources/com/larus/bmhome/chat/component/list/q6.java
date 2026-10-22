package com.larus.bmhome.chat.component.list;

import com.larus.bmhome.chat.adapter.MessageAdapter;
import com.larus.bmhome.chat.api.b0$a;
import com.larus.bmhome.chat.bean.d;
import com.larus.bmhome.databinding.LarusPageChatBinding;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.im.bean.message.Message;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import xc8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class q6 implements ChatConstraintLayout.b {
    public boolean a;
    public final /* synthetic */ LarusPageChatBinding b;
    public final /* synthetic */ ChatListComponent c;

    public final void b() {
        this.a = false;
    }

    public final void a() {
        this.a = this.b.n.P();
    }

    public final void onUpdate(int r8) {
        ChatListComponent r9 = this.c;
        int r0 = ChatListComponent.W3;
        com.larus.bmhome.instruction.g r10 = r9.vc();
        boolean r1 = false;
        if (r10 != null) goto L5;
    L7:
        boolean r11 = false;
    L8:
        if (r11 == false) goto L17;
        com.larus.bmhome.instruction.g r12 = this.c.vc();
        if (r12 != null) goto L12;
    L14:
        boolean r13 = false;
    L15:
        if (r13 == true) goto L17;
        boolean r14 = true;
    L19:
        if (this.a == true) goto L21;
        return;
    L21:
        if (this.b.n.getFirstLayoutCompleted() == false) goto L56;
        MessageAdapter r2 = this.c.O;
        if (r2 != null) goto L25;
    L27:
        boolean r3 = false;
    L28:
        if (r3 == true) goto L57;
        if (r14 == true) goto L58;
        MessageAdapter r15 = this.c.O;
        if (r15 == null) goto L43;
        List<b> r16 = r15.z2();
        if (r16 == null) goto L43;
        b r17 = (b) CollectionsKt.firstOrNull(r16);
        if (r17 == null) goto L43;
        Message r18 = r17.getMessage();
        if (r18 == null) goto L43;
        List<String> r19 = d.K(r18);
        if (r19 == null) goto L43;
        if (((ArrayList) r19).contains("exchange_rate") != true) goto L43;
        boolean r20 = true;
    L44:
        if (r20 == true) goto L59;
        va8.g0 r21 = (va8.g0) this.c.i3.getValue();
        if (r21 != null) goto L48;
    L50:
        if (r1 == false) goto L52;
        return;
    L52:
        if (this.c.Q6() == true) goto L61;
        b0$a.a(this.b.n, false, 0, null, null, 0, 31);
        return;
    L61:
        return;
    L48:
        if (r21.Pu() != true) goto L50;
        r1 = true;
        goto L50
    L59:
        return;
    L43:
        r20 = false;
        goto L44
    L58:
        return;
    L57:
        return;
    L25:
        if (r2.s0() != true) goto L27;
        r3 = true;
        goto L28
    L56:
        return;
    L12:
        if (r12.Q1() != 21) goto L14;
        r13 = true;
    L17:
        r14 = false;
        goto L19
    L5:
        if (r10.z0() != true) goto L7;
        r11 = true;
        goto L8
    }

    public q6(LarusPageChatBinding r1, ChatListComponent r2) {
        this.b = r1;
        this.c = r2;
    }
}
