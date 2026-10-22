package com.larus.disk.impl.handler;

import java.io.File;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class i implements Function1 {
    public final /* synthetic */ long a;

    public /* synthetic */ i(long r1) {
        this.a = r1;
    }

    public final Object invoke(Object r9) {
        long r0 = this.a;
        File r10 = (File) r9;
        Intrinsics.checkNotNullParameter(r10, "file");
        boolean r3 = false;
        if (r10.isFile() == false) goto L15;
        if (StringsKt.startsWith$default(r10.getName(), "journal", false, 2, null) == true) goto L15;
        long r4 = r10.lastModified();
        if (1 <= r4) goto L9;
    L11:
        boolean r1 = false;
    L12:
        if (r1 == false) goto L15;
        r3 = true;
        goto L15
    L9:
        if (r4 >= r0) goto L11;
        r1 = true;
    L15:
        return Boolean.valueOf(r3);
    }
}
