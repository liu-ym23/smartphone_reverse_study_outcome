package com.larus.bmhome.view.actionbar.edit.kmp;

import com.larus.bmhome.view.actionbar.edit.component.i2;
import cq8.z0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b implements com.larus.bmhome.view.actionbar.edit.component.d {
    public final /* synthetic */ a a;
    public final /* synthetic */ dq8.a b;

    @Override // com.larus.bmhome.view.actionbar.edit.component.d
    public final void a(i2 r44) {
        Intrinsics.checkNotNullParameter(r44, "selectedItem");
        a r2 = this.a;
        dq8.a r3 = this.b;
        r2.getClass();
        String r11 = r44.b;
        String r12 = r44.a;
        if (r12 != null) goto L5;
    L14:
        dq8.a r4 = this.b;
        r4.e.a(new cq8.d(r4.a, r44.a, r44.b, r44.c, r44.d));
        return;
    L5:
        if (r11 != null) goto L7;
    L10:
        boolean r5 = true;
    L11:
        if (r5 == true) goto L14;
        z0 r13 = r3.d;
        com.larus.bmhome.actionbar.model.a r6 = r3.b;
        String r7 = r13.a;
        String r8 = r13.c;
        String r9 = r13.d;
        Integer r15 = r44.c;
        String r10 = r13.f;
        String r14 = r13.g;
        String r16 = r13.j;
        String r17 = r6.b;
        Boolean r18 = r13.i;
        String r19 = r13.h;
        String r26 = r2.b();
        tx9.b.e(r7, r8, r9, r10, r14, r16, r17, r11, r12, 0, 0, r15, "select", null, null, null, r2.a(), "original", "chat", null, null, null, r26, r19, r18, null, null, null, null, null, null, null, null, null, null, null, null, -59580416, 127);
        goto L14
    L7:
        if (r11.length() == 0) goto L10;
        r5 = false;
        goto L11
    }

    public b(a r1, dq8.a r2) {
        this.a = r1;
        this.b = r2;
    }
}
