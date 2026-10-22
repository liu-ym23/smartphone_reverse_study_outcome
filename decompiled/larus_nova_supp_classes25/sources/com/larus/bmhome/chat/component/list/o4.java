package com.larus.bmhome.chat.component.list;

import com.larus.bmhome.chat.ChatFragment;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.ui.arch.component.internal.attach.a;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import va8.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class o4 implements Function0 {
    public final /* synthetic */ ChatListComponent a;

    public /* synthetic */ o4(ChatListComponent r1) {
        this.a = r1;
    }

    public final Object invoke() {
        ChatListComponent r0 = this.a;
        int r1 = ChatListComponent.W3;
        com.larus.bmhome.instruction.g r2 = r0.vc();
        boolean r3 = false;
        if (r2 != null) goto L5;
    L7:
        boolean r4 = false;
    L8:
        if (r4 == true) goto L37;
        o r5 = r0.q4();
        if (r5 != null) goto L12;
    L14:
        boolean r6 = false;
    L15:
        if (r6 == true) goto L37;
        ICoreInputAbility r7 = r0.T4();
        if (r7 != null) goto L19;
    L21:
        boolean r8 = false;
    L22:
        if (r8 == true) goto L37;
        Intrinsics.checkNotNullParameter(r0, "<this>");
        ChatFragment r9 = a.b(r0, r0);
        if ((r9 instanceof ChatFragment) == false) goto L26;
        ChatFragment r10 = r9;
    L27:
        if (r10 != null) goto L29;
    L31:
        boolean r11 = false;
    L32:
        if (r11 == true) goto L37;
        if (r0.w6() == true) goto L37;
        if (r0.r6() == true) goto L37;
    L39:
        return Boolean.valueOf(r3);
    L29:
        if (r10.w() != true) goto L31;
        r11 = true;
        goto L32
    L26:
        r10 = null;
        goto L27
    L19:
        if (r7.c1() != true) goto L21;
        r8 = true;
        goto L22
    L12:
        if (r5.w() != true) goto L14;
        r6 = true;
    L37:
        r3 = true;
        goto L39
    L5:
        if (r2.z0() != true) goto L7;
        r4 = true;
        goto L8
    }
}
