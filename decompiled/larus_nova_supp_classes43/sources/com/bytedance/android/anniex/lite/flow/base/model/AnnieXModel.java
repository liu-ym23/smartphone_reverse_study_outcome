package com.bytedance.android.anniex.lite.flow.base.model;

import java.io.Closeable;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class AnnieXModel {
    public final Lazy a;

    public static final class a {
    }

    static {
    }

    public final void a() {
        ConcurrentHashMap r0 = (ConcurrentHashMap) this.a.getValue();
        if (r0 == null) goto L16;
        Iterator r1 = r0.entrySet().iterator();
    L6:
        if (r1.hasNext() == false) goto L16;
        Object r10 = ((Map.Entry) r1.next()).getValue();
        if (r10 == null) goto L6;
        if ((r10 instanceof Closeable) == false) goto L6;
        ((Closeable) r10).close();     // Catch: IOException -> L13
    L13:
        e = move-exception;
        throw new RuntimeException(e);
    L16:
        ConcurrentHashMap r11 = (ConcurrentHashMap) this.a.getValue();
        if (r11 == null) goto L28;
        r11.clear();
        return;
    }

    public AnnieXModel() {
        this.a = LazyKt.lazy(AnnieXModel$mBagOfTags$2.INSTANCE);
    }
}
