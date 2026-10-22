package com.bytedance.android.livesdk.gecko.offline;

import java.io.File;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e extends a<Pair<? extends String, ? extends String>> {
    public e(List<? extends d> r2) {
        Intrinsics.checkNotNullParameter(r2, "iOfflineController");
        super(r2);
    }

    public final Object b(String r3) {
        Intrinsics.checkNotNullParameter(r3, "key");
        File r4 = a(r3);
        if (r4 != null) goto L5;
    L7:
        return null;
    L5:
        if (r4.exists() == false) goto L7;
        return new Pair(r4.getParent(), r4.getName());
    }
}
