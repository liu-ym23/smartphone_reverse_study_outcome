package com.ss.android.lark.chat.configurator;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f<I> implements com.ss.android.lark.chat.base.view.recycleview.b.InterfaceC0030b {
    public static final f<I> a = null;

    static {
        a = new f();
    }

    public f() {
    }

    @Override // com.ss.android.lark.chat.base.view.recycleview.b.InterfaceC0030b
    public final boolean a(Object r2, Object r3) {
        y6b.c r4 = (y6b.c) r2;
        y6b.c r5 = (y6b.c) r3;
        String r0 = null;
        if (r4 == null) goto L5;
        String r6 = r4.c;
    L6:
        if (r5 == null) goto L9;
        r0 = r5.c;
    L9:
        return Intrinsics.areEqual(r6, r0);
    L5:
        r6 = null;
        goto L6
    }
}
