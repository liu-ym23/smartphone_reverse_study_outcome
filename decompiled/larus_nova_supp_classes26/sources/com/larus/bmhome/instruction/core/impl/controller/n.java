package com.larus.bmhome.instruction.core.impl.controller;

import cq8.a0;
import cq8.c0;
import cq8.d0;
import cq8.e0;
import cq8.k0;
import cq8.y;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class n extends com.larus.bmhome.instruction.core.impl.base.b {
    public boolean p;

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final boolean a() {
        return true;
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final String g() {
        return null;
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public int getType() {
        return 15;
    }

    public n() {
        super("MultiMediaSelectorController");
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b
    public final a0 d() {
        com.larus.bmhome.instruction.core.impl.base.c r0 = this.c;
        if (r0 == null) goto L9;
        aq8.d r1 = r0.a;
        if (r1 == null) goto L9;
        dq8.f r2 = r1.c;
        if (r2 == null) goto L9;
        List r3 = r2.a();
    L10:
        if (r3 != null) goto L12;
        r3 = CollectionsKt.emptyList();
    L12:
        List r5 = r3;
        String r4 = getWidgetId();
        com.larus.bmhome.instruction.core.impl.base.b.C0015b r6 = this.o;
        com.larus.bmhome.actionbar.model.u r7 = this.b;
        if (r7 == null) goto L19;
        String r8 = r7.c;
        if (r8 == null) goto L19;
        if ((!StringsKt.isBlank(r8)) == false) goto L19;
        String r9 = r8;
    L20:
        com.larus.bmhome.actionbar.model.u r10 = this.b;
        if (r10 == null) goto L27;
        String r11 = r10.c;
        if (r11 == null) goto L27;
        if ((!StringsKt.isBlank(r11)) == false) goto L27;
        String r12 = r11;
    L28:
        com.larus.bmhome.actionbar.model.u r13 = this.b;
        if (r13 == null) goto L31;
        boolean r14 = Intrinsics.areEqual(r13.f, Boolean.TRUE);
    L33:
        return new k0(r4, r6, r5, r9, r12, r14);
    L31:
        r14 = false;
    L27:
        r12 = null;
    L19:
        r9 = null;
    L9:
        r3 = null;
        goto L10
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void m(y r3) {
        Intrinsics.checkNotNullParameter(r3, "action");
        if (Intrinsics.areEqual(r3.a(), getWidgetId()) == true) goto L6;
        return;
    L6:
        if ((r3 instanceof c0) == false) goto L9;
        o(new com.larus.bmhome.instruction.core.impl.base.k.j(((c0) r3).c));
        return;
    L9:
        if ((r3 instanceof e0) == false) goto L12;
        o(new com.larus.bmhome.instruction.core.impl.base.k.l(((e0) r3).getIdentifier()));
        return;
    L12:
        if ((r3 instanceof d0) == false) goto L17;
        d0 r4 = (d0) r3;
        o(new com.larus.bmhome.instruction.core.impl.base.k.C0016k(r4.c, r4.d));
        return;
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final wa8.a0 n(String r8) {
        if (this.p == true) goto L14;
        com.larus.bmhome.instruction.core.impl.base.c r9 = this.c;
        if (r9 == null) goto L14;
        aq8.d r10 = r9.a;
        if (r10 == null) goto L14;
        dq8.f r11 = r10.c;
        if (r11 == null) goto L14;
        this.p = true;
        BuildersKt.launch$default(this.g, null, null, new MultiMediaSelectorController$startObserveAttachments$1(r11, this, null), 3, null);
    L14:
        return new wa8.a0(Boolean.TRUE, "");
    }
}
