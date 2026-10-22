package com.ss.android.lark.coremd.ext;

import java.util.LinkedList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public final LinkedList<Object> a;

    public a(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "first");
        LinkedList<Object> r0 = new LinkedList();
        r0.add(r2);
        this.a = r0;
    }
}
