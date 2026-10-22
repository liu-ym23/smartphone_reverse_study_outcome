package com.larus.bmhome.chat.component.bottom.core;

import androidx.fragment.app.Fragment;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import s1a.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class k9 {
    public final op8.k a;
    public final ICoreInputAbility b;
    public final Function0<String> c;
    public final ICoreInputAbility d;
    public boolean e;
    public final j9 f;
    public final i9 g;

    public final void a(String r10) {
        if (Intrinsics.areEqual(this.c.invoke(), r10) == false) goto L5;
        return;
    L5:
        this.e = true;
        ICoreInputAbility.b.d(this.b, r10, false, false, null, null, false, 56);     // Catch: Throwable -> L9
        this.e = false;
        return;
    L9:
        th = move-exception;
        this.e = false;
        throw th;
    }

    public k9(op8.k r2, ICoreInputAbility r3, com.larus.bmhome.chat.component.bottom.attachment.v r4) {
        Intrinsics.checkNotNullParameter(r2, "connection");
        Intrinsics.checkNotNullParameter(r3, "child");
        Intrinsics.checkNotNullParameter(r4, "childText");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        Fragment r5 = r2.a();
        if (r5 == null) goto L5;
        ICoreInputAbility r6 = (ICoreInputAbility) a.g(r5).getAbility(ICoreInputAbility.class);
    L6:
        this.d = r6;
        this.f = new j9(this);
        this.g = new i9(this);
        return;
    L5:
        r6 = null;
        goto L6
    }
}
