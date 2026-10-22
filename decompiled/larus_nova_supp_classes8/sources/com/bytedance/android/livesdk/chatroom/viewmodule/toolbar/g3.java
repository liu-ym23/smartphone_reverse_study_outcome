package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g3 extends x3 {
    public final Map<ExtendedToolbarButton, e2> o;

    public g3() {
        super(false);
        this.o = new LinkedHashMap();
    }

    public final List<e2> I(Panel r5) {
        Intrinsics.checkNotNullParameter(r5, "panel");
        Collection r0 = ((LinkedHashMap) this.o).values();
        ArrayList r1 = new ArrayList();
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L11;
        Object r3 = r2.next();
        if (((e2) r3).a() != r5) goto L8;
        boolean r4 = true;
    L9:
        if (r4 == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        r4 = false;
        goto L9
    L11:
        return r1;
    }

    public final void J(e2 r4) {
        Intrinsics.checkNotNullParameter(r4, "config");
        this.o.put(r4.b.extended(), r4);
        ExtendedToolbarButton r0 = r4.b.extended();
        c0.b r1 = r4.a;
        if (r1 != null) goto L8;
        r1 = (c0.b) r4.c.invoke(r4.b.extended());
        if (r4.d == false) goto L8;
        r4.a = r1;
    L8:
        super.p(r0, r1);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3
    public final c0.b s(ExtendedToolbarButton r4) {
        Intrinsics.checkNotNullParameter(r4, "config");
        e2 r0 = (e2) ((LinkedHashMap) this.o).get(r4);
        if (r0 == null) goto L12;
        c0.b r1 = r0.a;
        if (r1 != null) goto L10;
        r1 = (c0.b) r0.c.invoke(r0.b.extended());
        if (r0.d == false) goto L10;
        r0.a = r1;
    L10:
        if (r1 == null) goto L12;
        return r1;
    L12:
        return super.s(r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0
    public final void p(ExtendedToolbarButton r2, c0.b r3) {
        Intrinsics.checkNotNullParameter(r2, "button");
        if ((r3 instanceof e2) == false) goto L6;
        J((e2) r3);
        return;
    L6:
        super.p(r2, r3);
    }
}
