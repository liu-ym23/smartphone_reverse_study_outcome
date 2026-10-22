package com.larus.bmhome.double_post.drag_panel;

import com.larus.bmhome.chat.component.cvs.y;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e0 implements y.a<e> {
    public final /* synthetic */ kotlinx.coroutines.i<Boolean> a;

    public e0(kotlinx.coroutines.j r1) {
        this.a = r1;
    }

    public final void c(Object r3) {
        e r4 = (e) r3;
        Intrinsics.checkNotNullParameter(r4, "new");
        if (this.a.isActive() == false) goto L6;
        kotlinx.coroutines.i<Boolean> r0 = this.a;
        Result.Companion r1 = Result.Companion;
        r0.resumeWith(Result.constructor-impl(Boolean.valueOf(ic8.n.u(r4))));
        return;
    }
}
