package com.larus.community.impl.share;

import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.CloseableImage;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class m {
    public final ConcurrentHashMap<String, CloseableReference<CloseableImage>> a;

    public final void b() {
        Iterator<T> r0 = this.a.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        String r1 = (String) r0.next();
        CloseableReference<CloseableImage> r2 = this.a.get(r1);
        if (r2 == null) goto L4;
        CloseableReference.closeSafely(r2);
        goto L4
    L8:
        this.a.clear();
    }

    public m() {
        this.a = new ConcurrentHashMap();
    }

    public final void a(String r2, CloseableReference<CloseableImage> r3) {
        Intrinsics.checkNotNullParameter(r2, "path");
        this.a.put(r2, r3);
    }
}
