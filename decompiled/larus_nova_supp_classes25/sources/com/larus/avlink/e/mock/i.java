package com.larus.avlink.e.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class i {
    public final List<Integer> a;

    public static final class a {
    }

    static {
    }

    public i(c r2) {
        Intrinsics.checkNotNullParameter(r2, "fileManager");
        this.a = new ArrayList();
        new AtomicInteger(0);
        new AtomicBoolean(false);
    }
}
