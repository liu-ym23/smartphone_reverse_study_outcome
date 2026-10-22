package androidx.lifecycle;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class ViewModel {
    private final Map<String, Object> mBagOfTags;
    private volatile boolean mCleared;
    private final Set<Closeable> mCloseables;

    public ViewModel() {
        this.mBagOfTags = new HashMap();
        this.mCloseables = new LinkedHashSet();
        this.mCleared = false;
    }

    public ViewModel(Closeable... r3) {
        this.mBagOfTags = new HashMap();
        LinkedHashSet r0 = new LinkedHashSet();
        this.mCloseables = r0;
        this.mCleared = false;
        r0.addAll(Arrays.asList(r3));
    }

    private static void closeWithRuntimeException(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, Closeable.class) == true) goto L10;
        return;
    L10:
        ((Closeable) ZeusTransformUtils.preCheckCast(r2, Closeable.class, "com.obric.memorydata.plugin")).close();     // Catch: IOException -> L6
        return;
    L6:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public void addCloseable(Closeable r3) {
        Closeable r4 = (Closeable) ZeusTransformUtils.wrapperContextForParams(r3, Closeable.class, "com.obric.memorydata.plugin");
        Set<Closeable> r0 = this.mCloseables;
        if (r0 == null) goto L11;
        monitor-enter(r0);
        this.mCloseables.add(r4);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    final void clear() {
        this.mCleared = true;
        Map<String, Object> r0 = this.mBagOfTags;
        if (r0 == null) goto L14;
        monitor-enter(r0);
        Iterator<Object> r1 = this.mBagOfTags.values().iterator();     // Catch: Throwable -> L11
    L7:
        if (r1.hasNext() == false) goto L9;
        closeWithRuntimeException(r1.next());     // Catch: Throwable -> L11
        goto L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    L14:
        Set<Closeable> r2 = this.mCloseables;
        if (r2 == null) goto L26;
        monitor-enter(r2);
        Iterator<Closeable> r3 = this.mCloseables.iterator();     // Catch: Throwable -> L23
    L19:
        if (r3.hasNext() == false) goto L21;
        closeWithRuntimeException((Closeable) ZeusTransformUtils.preCheckCast(r3.next(), Closeable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L23
        goto L19
    L21:
        monitor-exit(r2);     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    L26:
        onCleared();
    }

    <T> T getTag(String r2) {
        Map<String, Object> r0 = this.mBagOfTags;
        if (r0 != null) goto L6;
        return null;
    L6:
        monitor-enter(r0);
        T r1 = (T) this.mBagOfTags.get(r2);
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L10:
        th = move-exception;
        throw th;
    }

    public void onCleared() {
    }

    <T> T setTagIfAbsent(String r4, T r5) {
        Map<String, Object> r0 = this.mBagOfTags;
        monitor-enter(r0);
        Object r1 = this.mBagOfTags.get(r4);     // Catch: Throwable -> L15
        if (r1 != null) goto L7;
        this.mBagOfTags.put(r4, r5);     // Catch: Throwable -> L15
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L15
        if (r1 == null) goto L12;
        r5 = (T) r1;
    L12:
        if (this.mCleared == false) goto L14;
        closeWithRuntimeException(r5);
    L14:
        return r5;
    L15:
        th = move-exception;
        throw th;
    }
}
