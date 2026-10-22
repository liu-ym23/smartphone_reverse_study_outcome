package com.bytedance.android.livesdk.gecko.offline;

import java.io.File;
import java.util.ArrayList;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f {
    public static final ArrayList<d> a = null;
    public static final b b = null;
    public static final e c = null;

    static {
        ArrayList<d> r0 = new ArrayList();
        a = r0;
        b = new b(r0);
        c = new e(r0);
        r0.add(new c());
    }

    public static File a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        b r1 = b;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r2, "key");
        return r1.a(r2);
    }

    public static Pair b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        e r1 = c;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "key");
        return (Pair) r1.b(r2);
    }
}
