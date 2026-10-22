package com.bytedance.android.annie.business.container;

import com.bytedance.android.anniex.container.AnnieXContainer;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b extends com.bytedance.android.anniex.base.lifecycle.a {
    public final /* synthetic */ AnnieXLiveDialog a;

    public b(AnnieXLiveDialog r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.anniex.base.lifecycle.a
    public final void a(String r10, ia.c r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r11, "container");
        super.a(r10, r11);
    }

    @Override // com.bytedance.android.anniex.base.lifecycle.a
    public final void e(String r10, ia.c r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r11, "container");
        super.e(r10, r11);
        i r0 = this.a.d;
        if (r0 == null) goto L8;
        j r1 = r0.q;
        if (r1 == null) goto L9;
        r1.e(r10, r11);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.anniex.base.lifecycle.a
    public final void h(String r10, ia.c r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r11, "container");
        super.h(r10, r11);
        i r0 = this.a.d;
        if (r0 == null) goto L8;
        j r1 = r0.q;
        if (r1 == null) goto L9;
        r1.h(r10, r11);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.anniex.base.lifecycle.a
    public final void i(String r10, ia.c r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r11, "container");
        super.i(r10, r11);
        i r0 = this.a.d;
        if (r0 == null) goto L7;
        j r1 = r0.q;
        if (r1 == null) goto L7;
        r1.i(r10, r11);
    L7:
        AnnieXLiveDialog r12 = this.a;
        r12.getClass();
        com.bytedance.android.anniex.assemble.a r13 = com.bytedance.android.anniex.assemble.a.a;
        Iterator r14 = com.bytedance.android.anniex.assemble.a.e().entrySet().iterator();
    L9:
        if (r14.hasNext() == false) goto L19;
        ia.c r15 = (ia.c) ((WeakReference) ((Map.Entry) r14.next()).getValue()).get();
        if (r15 == null) goto L13;
        String r16 = r15.getViewType();
    L15:
        if (Intrinsics.areEqual(r16, com.bytedance.android.ec.core.event.a.VALUE_SHOW_POPUP) == false) goto L9;
        if (Intrinsics.areEqual(r15, r12.g) == true) goto L9;
        ia.c.a.a(r15, false);
        goto L9
    L13:
        r16 = null;
        goto L15
    }

    @Override // com.bytedance.android.anniex.base.lifecycle.a
    public final void c(String r10, AnnieXContainer r11, Throwable r12) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r11, "container");
        Intrinsics.checkNotNullParameter(r12, "throwable");
        super.c(r10, r11, r12);
        i r0 = this.a.d;
        if (r0 == null) goto L8;
        j r1 = r0.q;
        if (r1 == null) goto L9;
        r1.c(r10, r11, r12);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.anniex.base.lifecycle.a
    public final void g(String r10, ia.c r11, Throwable r12) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r11, "container");
        Intrinsics.checkNotNullParameter(r12, "throwable");
        super.g(r10, r11, r12);
        i r0 = this.a.d;
        if (r0 == null) goto L8;
        j r1 = r0.q;
        if (r1 == null) goto L9;
        r1.g(r10, r11, r12);
        return;
    L9:
        return;
    }
}
