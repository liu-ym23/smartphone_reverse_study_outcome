package com.larus.bmhome.chat.list.cell.text;

import bd8.b;
import com.larus.bmhome.chat.layout.item.p;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class BaseCompositeTextCell$b implements p {
    public final /* synthetic */ BaseCompositeTextCell<STATE> a;

    public BaseCompositeTextCell$b(BaseCompositeTextCell<STATE> r1) {
        this.a = r1;
    }

    @Override // com.larus.bmhome.chat.layout.item.p
    public final void b(boolean r3) {
        Iterator r0 = this.a.f.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((b) r0.next()).F(r3);
        goto L4
    }

    @Override // com.larus.bmhome.chat.layout.item.p
    public final void c(Integer r2) {
        Iterator r3 = ((ArrayList) this.a.f).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((b) r3.next()).D();
        goto L4
    }

    @Override // com.larus.bmhome.chat.layout.item.p
    public final void a(boolean r1, boolean r2) {
        Iterator r3 = ((ArrayList) this.a.f).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((b) r3.next()).E();
        goto L4
    }
}
