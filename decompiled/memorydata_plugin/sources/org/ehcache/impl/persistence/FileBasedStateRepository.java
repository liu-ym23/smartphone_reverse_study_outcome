package org.ehcache.impl.persistence;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import org.ehcache.spi.b.b;

/* JADX INFO: loaded from: classes7.dex */
class FileBasedStateRepository implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final File f18097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConcurrentMap<String, Tuple> f18098b;

    static class Tuple implements Serializable {
        private static final long serialVersionUID = 664492058736170101L;
        final b<?, ?> holder;
        final int index;

        Tuple(int r3, b<?, ?> r4) {
            b<?, ?> r5 = (b) ZeusTransformUtils.wrapperContextForParams(r4, b.class, "com.obric.memorydata.plugin");
            this.index = r3;
            this.holder = r5;
        }
    }

    private String a(Map.Entry<String, Tuple> r4) {
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r4, Map.Entry.class, "com.obric.memorydata.plugin");
        return "holder-" + ((Tuple) ZeusTransformUtils.preCheckCast(r3.getValue(), Tuple.class, "com.obric.memorydata.plugin")).index + "-" + a.a((String) ZeusTransformUtils.preCheckCast(r3.getKey(), String.class, "com.obric.memorydata.plugin"), false) + ".bin";
    }

    private void a() {
        Iterator<Map.Entry<String, Tuple>> r0 = this.f18098b.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L26;
        Map.Entry<String, Tuple> r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        FileOutputStream r3 = new FileOutputStream(new File(this.f18097a, a(r1)));
        ObjectOutputStream r2 = new ObjectOutputStream(r3);     // Catch: Throwable -> L18
        r2.writeObject(r1.getKey());     // Catch: Throwable -> L10
        r2.writeObject(r1.getValue());     // Catch: Throwable -> L10
        r2.close();     // Catch: Throwable -> L18
        r3.close();
        goto L4
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        r2.close();     // Catch: Throwable -> L15
    L17:
        throw th;     // Catch: Throwable -> L18
    L15:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        r3.close();     // Catch: Throwable -> L23
    L25:
        throw th;
    L23:
        th = move-exception;
        th.addSuppressed(th);
        goto L25
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a();
    }
}
