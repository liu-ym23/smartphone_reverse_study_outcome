package com.larus.drive.sdk.impl.view.chat.fileselect;

import com.larus.drive.sdk.impl.view.chat.fileselect.adapter.ChatFileSelectedAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class o implements ChatFileSelectedAdapter.a {
    public final /* synthetic */ ChatFileSelectedListDialog a;

    public o(ChatFileSelectedListDialog r1) {
        this.a = r1;
    }

    @Override // com.larus.drive.sdk.impl.view.chat.fileselect.adapter.ChatFileSelectedAdapter.a
    public final void a(x79.a r7) {
        Intrinsics.checkNotNullParameter(r7, "item");
        Iterator<T> r0 = this.a.f.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (Intrinsics.areEqual(((com.larus.platform.api.u) r1).a, r7.a) == false) goto L4;
    L9:
        com.larus.platform.api.u r2 = (com.larus.platform.api.u) r1;
        if (r2 != null) goto L12;
        return;
    L12:
        aq9.c r3 = this.a.h;
        if (r3 == null) goto L15;
        r3.a(r2);
    L15:
        ChatFileSelectedListDialog r4 = this.a;
        List<com.larus.platform.api.u> r5 = r4.f;
        ArrayList r6 = new ArrayList();
        Iterator<T> r8 = r5.iterator();
    L17:
        if (r8.hasNext() == false) goto L21;
        Object r9 = r8.next();
        if (Intrinsics.areEqual(((com.larus.platform.api.u) r9).a, r7.a) == true) goto L17;
        r6.add(r9);
        goto L17
    L21:
        r4.f = r6;
        return;
    L8:
        r1 = null;
        goto L9
    }
}
