package com.bytedance.android.livesdk.gecko.offline;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public abstract class a<T> {
    public final List<d> a;

    /* JADX WARN: Multi-variable type inference failed */
    public a(List<? extends d> r2) {
        Intrinsics.checkNotNullParameter(r2, "iOfflineController");
        this.a = r2;
    }

    public final File a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "key");
        ArrayList r0 = new ArrayList();
        r0.addAll(this.a);
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L10;
        PolarisFileWrapper r2 = ((d) r1.next()).a(r4);
        if (r2 == null) goto L4;
        if (r2.exists() == false) goto L4;
        return r2;
    L10:
        return null;
    }
}
