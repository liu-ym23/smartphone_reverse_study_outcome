package com.larus.bmhome.chat.component.bottom.core;

import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.Intrinsics;
import s1a.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class i9 implements ICoreInputAbility.e {
    public final /* synthetic */ k9 a;

    public i9(k9 r1) {
        this.a = r1;
    }

    public final void h(String r2) {
        Intrinsics.checkNotNullParameter(r2, "content");
    }

    public final void i(String r3) {
        Intrinsics.checkNotNullParameter(r3, "content");
        k9 r0 = this.a;
        if (r0.e == true) goto L10;
        Fragment r1 = r0.a.a();
        if (r1 == null) goto L11;
        op8.d r2 = a.g(r1).getAbility(op8.d.class);
        if (r2 == null) goto L12;
        r2.w00(new op8.a.e(r3));
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void j(String r2) {
        Intrinsics.checkNotNullParameter(r2, "content");
    }
}
