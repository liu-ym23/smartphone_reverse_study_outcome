package com.obric.cae.location.zpp;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends ConcurrentHashMap<String, Float> {
    public a() {
        Iterator<String> r0 = b.f7315a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        put((String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin"), Float.valueOf(Float.NaN));
        goto L4
    }
}
