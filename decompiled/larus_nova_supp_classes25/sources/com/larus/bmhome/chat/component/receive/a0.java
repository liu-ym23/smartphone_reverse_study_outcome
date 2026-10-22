package com.larus.bmhome.chat.component.receive;

import com.larus.bmhome.chat.component.bottom.p1;
import com.larus.bmhome.chat.model.j1;
import com.larus.bmhome.chat.model.n;
import com.larus.platform.service.z2;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class a0 implements Function1 {
    public final /* synthetic */ ChatReceiveServiceComponent a;
    public final /* synthetic */ List b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ String d;

    public /* synthetic */ a0(ChatReceiveServiceComponent r1, List r2, boolean r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final Object invoke(Object r10) {
        ChatReceiveServiceComponent r0 = this.a;
        List r1 = this.b;
        boolean r2 = this.c;
        String r3 = this.d;
        boolean r11 = ((Boolean) r10).booleanValue();
        int r4 = ChatReceiveServiceComponent.x;
        n r8 = null;
        if (s1a.a.c(r0).isAdded() == false) goto L26;
        Intrinsics.checkNotNullParameter(r0, "<this>");
        if (com.larus.ui.arch.component.internal.attach.a.b(r0, r0).isDetached() == true) goto L26;
        if (r11 == false) goto L26;
        if (l0.a(r1) == false) goto L10;
        r0.U2(r1, r2, r3);
    L46:
        return Unit.INSTANCE;
    L10:
        t19.s.a.g(r0.getContext(), 2131905677, false);
        if (r2 == false) goto L46;
        z2 r12 = z2.a;
        if (z2.c4() == false) goto L46;
        p1 r13 = r0.cr();
        if (r13 == null) goto L17;
        j1 r14 = r13.Y3();
    L19:
        if ((r14 instanceof n) == false) goto L21;
        r8 = (n) r14;
    L21:
        if (r8 == null) goto L23;
        r8.d = true;
    L23:
        p1 r15 = r0.cr();
        if (r15 == null) goto L46;
        r15.cb(false);
        goto L46
    L17:
        r14 = null;
    L26:
        Intrinsics.checkNotNullParameter(r0, "<this>");
        if (com.larus.ui.arch.component.internal.attach.a.b(r0, r0).isAdded() == false) goto L46;
        Intrinsics.checkNotNullParameter(r0, "<this>");
        if (com.larus.ui.arch.component.internal.attach.a.b(r0, r0).isDetached() == true) goto L46;
        if (r2 == false) goto L46;
        z2 r16 = z2.a;
        if (z2.c4() == false) goto L46;
        p1 r17 = r0.cr();
        if (r17 == null) goto L36;
        j1 r18 = r17.Y3();
    L38:
        if ((r18 instanceof n) == false) goto L40;
        r8 = (n) r18;
    L40:
        if (r8 == null) goto L42;
        r8.d = true;
    L42:
        p1 r19 = r0.cr();
        if (r19 == null) goto L46;
        r19.cb(false);
        goto L46
    L36:
        r18 = null;
        goto L38
    }
}
