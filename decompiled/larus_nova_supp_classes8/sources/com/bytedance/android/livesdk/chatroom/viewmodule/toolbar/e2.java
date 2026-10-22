package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public abstract class e2 {
    public c0.b a;
    public final ToolbarButton b;
    public final Function1<ExtendedToolbarButton, c0.b> c;
    public final boolean d;

    public e2() {
        throw null;
    }

    public abstract Panel a();

    public abstract boolean b();

    public final int hashCode() {
        return this.b.hashCode();
    }

    public final boolean equals(Object r3) {
        ToolbarButton r1 = null;
        if ((r3 instanceof e2) == true) goto L5;
        r3 = null;
    L5:
        e2 r4 = (e2) r3;
        if (r4 == null) goto L9;
        r1 = r4.b;
    L9:
        if (r1 != this.b) goto L11;
        return true;
    L11:
        return false;
    }

    public e2(ToolbarButton r2, r r3) {
        Intrinsics.checkNotNullParameter(r2, "button");
        Intrinsics.checkNotNullParameter(r3, "behaviorFactory");
        this.b = r2;
        this.c = r3;
        this.d = true;
    }
}
