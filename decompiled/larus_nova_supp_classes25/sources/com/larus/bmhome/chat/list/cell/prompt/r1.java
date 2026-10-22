package com.larus.bmhome.chat.list.cell.prompt;

import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class r1 implements ICoreInputAbility.e {
    public final /* synthetic */ s1 a;

    public r1(s1 r1) {
        this.a = r1;
    }

    public final void h(String r2) {
        Intrinsics.checkNotNullParameter(r2, "content");
    }

    public final void i(String r5) {
        Intrinsics.checkNotNullParameter(r5, "content");
        s1 r0 = this.a;
        if (r0.g == true) goto L6;
        return;
    L6:
        if (r0.e() == true) goto L10;
        if (this.a.i == true) goto L10;
    L12:
        boolean r6 = false;
    L13:
        s1 r1 = this.a;
        if (r6 == r1.f) goto L16;
        r1.c(r6, true);
    L16:
        if (r6 == true) goto L19;
        this.a.i = false;
        return;
    L19:
        return;
    L10:
        if ((!StringsKt.isBlank(r5)) == false) goto L12;
        r6 = true;
        goto L13
    }

    public final void j(String r2) {
        Intrinsics.checkNotNullParameter(r2, "content");
    }
}
