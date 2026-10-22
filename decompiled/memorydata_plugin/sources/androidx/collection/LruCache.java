package androidx.collection;

import androidx.collection.internal.Lock;
import androidx.collection.internal.LruHashMap;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010%\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0002B\u000f\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0017\u0010\u0011\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0012\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0013J\u0006\u0010\u0007\u001a\u00020\u0005J/\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00028\u00012\b\u0010\u0019\u001a\u0004\u0018\u00018\u0001H\u0014¢\u0006\u0002\u0010\u001aJ\u0006\u0010\u001b\u001a\u00020\u0015J\u0006\u0010\b\u001a\u00020\u0005J\u0018\u0010\u001c\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0012\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\u0013J\u0006\u0010\t\u001a\u00020\u0005J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u000e\u001a\u00020\u0005J\u001d\u0010\u001d\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u001e\u001a\u00028\u0001¢\u0006\u0002\u0010\u001fJ\u0006\u0010\u000f\u001a\u00020\u0005J\u0015\u0010 \u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0012\u001a\u00028\u0000¢\u0006\u0002\u0010\u0013J\u0012\u0010!\u001a\u00020\u00152\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010\"\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u001e\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010#J\u0006\u0010\u0010\u001a\u00020\u0005J\u001d\u0010$\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u001e\u001a\u00028\u0001H\u0014¢\u0006\u0002\u0010#J\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010&J\b\u0010'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u0005H\u0016R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Landroidx/collection/LruCache;", "K", "", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "maxSize", "", "(I)V", "createCount", "evictionCount", "hitCount", "lock", "Landroidx/collection/internal/Lock;", "map", "Landroidx/collection/internal/LruHashMap;", "missCount", "putCount", "size", "create", "key", "(Ljava/lang/Object;)Ljava/lang/Object;", "entryRemoved", "", "evicted", "", "oldValue", "newValue", "(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "evictAll", "get", "put", EventBody.KEY_VALUE, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove", "resize", "safeSizeOf", "(Ljava/lang/Object;Ljava/lang/Object;)I", "sizeOf", "snapshot", "", "toString", "", "trimToSize", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class LruCache<K, V> {
    private int createCount;
    private int evictionCount;
    private int hitCount;
    private final Lock lock;
    private final LruHashMap<K, V> map;
    private int maxSize;
    private int missCount;
    private int putCount;
    private int size;

    public LruCache(int r3) {
        this.maxSize = r3;
        if (r3 <= 0) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == false) goto L10;
        this.map = new LruHashMap(0, 0.75f);
        this.lock = new Lock();
        return;
    L10:
        throw new IllegalArgumentException("maxSize <= 0".toString());
    L5:
        r4 = false;
        goto L6
    }

    private final int safeSizeOf(K r2, V r3) {
        int r1 = sizeOf(r2, r3);
        if (r1 < 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return r1;
    L9:
        throw new IllegalStateException(("Negative size: " + r2 + '=' + r3).toString());
    L5:
        r0 = false;
        goto L6
    }

    public V create(K r1) {
        Intrinsics.checkNotNullParameter(r1, "key");
        return null;
    }

    public final int createCount() {
        Lock r0 = this.lock;
        monitor-enter(r0);
        int r1 = this.createCount;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void entryRemoved(boolean r1, K r2, V r3, V r4) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "oldValue");
    }

    public final void evictAll() {
        trimToSize(-1);
    }

    public final int evictionCount() {
        Lock r0 = this.lock;
        monitor-enter(r0);
        int r1 = this.evictionCount;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final V get(K r6) {
        Intrinsics.checkNotNullParameter(r6, "key");
        Lock r0 = this.lock;
        monitor-enter(r0);
        V r1 = this.map.get(r6);     // Catch: Throwable -> L29
        if (r1 == null) goto L9;
        this.hitCount++;     // Catch: Throwable -> L29
        monitor-exit(r0);
        return r1;
    L9:
        this.missCount++;     // Catch: Throwable -> L29
        monitor-exit(r0);
        V r2 = create(r6);
        if (r2 != null) goto L15;
        return null;
    L15:
        Lock r3 = this.lock;
        monitor-enter(r3);
        this.createCount++;     // Catch: Throwable -> L26
        V r4 = (V) this.map.put(r6, r2);
        if (r4 == null) goto L20;
        this.map.put(r6, r4);     // Catch: Throwable -> L26
    L21:
        monitor-exit(r3);
        if (r4 == null) goto L24;
        entryRemoved(false, r6, r2, r4);
        return r4;
    L24:
        trimToSize(this.maxSize);
        return r2;
    L20:
        this.size += safeSizeOf(r6, r2);     // Catch: Throwable -> L26
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    L29:
        th = move-exception;
        throw th;
    }

    public final int hitCount() {
        Lock r0 = this.lock;
        monitor-enter(r0);
        int r1 = this.hitCount;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public final int maxSize() {
        Lock r0 = this.lock;
        monitor-enter(r0);
        int r1 = this.maxSize;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public final int missCount() {
        Lock r0 = this.lock;
        monitor-enter(r0);
        int r1 = this.missCount;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public final V put(K r5, V r6) {
        Intrinsics.checkNotNullParameter(r5, "key");
        Intrinsics.checkNotNullParameter(r6, EventBody.KEY_VALUE);
        Lock r0 = this.lock;
        monitor-enter(r0);
        this.putCount++;     // Catch: Throwable -> L13
        this.size += safeSizeOf(r5, r6);     // Catch: Throwable -> L13
        V r1 = this.map.put(r5, r6);     // Catch: Throwable -> L13
        if (r1 == null) goto L7;
        this.size -= safeSizeOf(r5, r1);     // Catch: Throwable -> L13
    L7:
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r0);
        if (r1 == null) goto L11;
        entryRemoved(false, r5, r1, r6);
    L11:
        trimToSize(this.maxSize);
        return r1;
    L13:
        th = move-exception;
        throw th;
    }

    public final int putCount() {
        Lock r0 = this.lock;
        monitor-enter(r0);
        int r1 = this.putCount;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public final V remove(K r5) {
        Intrinsics.checkNotNullParameter(r5, "key");
        Lock r0 = this.lock;
        monitor-enter(r0);
        V r1 = this.map.remove(r5);     // Catch: Throwable -> L12
        if (r1 == null) goto L7;
        this.size -= safeSizeOf(r5, r1);     // Catch: Throwable -> L12
    L7:
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r0);
        if (r1 == null) goto L11;
        entryRemoved(false, r5, r1, null);
    L11:
        return r1;
    L12:
        th = move-exception;
        throw th;
    }

    public void resize(int r3) {
        if (r3 <= 0) goto L4;
        boolean r0 = true;
    L5:
        if (r0 == false) goto L16;
        Lock r1 = this.lock;
        monitor-enter(r1);
        this.maxSize = r3;     // Catch: Throwable -> L12
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r1);
        trimToSize(r3);
        return;
    L12:
        th = move-exception;
        throw th;
    L16:
        throw new IllegalArgumentException("maxSize <= 0".toString());
    L4:
        r0 = false;
        goto L5
    }

    public final int size() {
        Lock r0 = this.lock;
        monitor-enter(r0);
        int r1 = this.size;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public int sizeOf(K r1, V r2) {
        Intrinsics.checkNotNullParameter(r1, "key");
        Intrinsics.checkNotNullParameter(r2, EventBody.KEY_VALUE);
        return 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Map<K, V> snapshot() {
        LinkedHashMap r0 = new LinkedHashMap();
        Lock r1 = this.lock;
        monitor-enter(r1);
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(this.map.getEntries(), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L12
    L6:
        if (r6.hasNext() == false) goto L8;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        Object r3 = r2.getKey();     // Catch: Throwable -> L12
        Object r4 = r2.getValue();     // Catch: Throwable -> L12
        ((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.memorydata.plugin")).put(r3, r4);     // Catch: Throwable -> L12
        goto L6
    L8:
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r1);
        return (Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.memorydata.plugin");
    L12:
        th = move-exception;
        throw th;
    }

    public String toString() {
        Lock r0 = this.lock;
        monitor-enter(r0);
        int r1 = this.hitCount;     // Catch: Throwable -> L11
        int r2 = this.missCount + r1;     // Catch: Throwable -> L11
        if (r2 == 0) goto L7;
        int r3 = (r1 * 100) / r2;     // Catch: Throwable -> L11
    L8:
        String r4 = "LruCache[maxSize=" + this.maxSize + ",hits=" + this.hitCount + ",misses=" + this.missCount + ",hitRate=" + r3 + "%]";     // Catch: Throwable -> L11
        monitor-exit(r0);
        return r4;
    L7:
        r3 = 0;
    L11:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void trimToSize(int r7) {
    L2:
        Lock r0 = this.lock;
        monitor-enter(r0);
    L29:
        th = move-exception;
        throw th;
    L5:
        if (this.size >= 0) goto L7;
    L11:
        boolean r1 = false;
    L12:
        if (r1 == false) goto L28;
        if (this.size <= r7) goto L25;
        if (this.map.isEmpty() == true) goto L25;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull((Iterable) ZeusTransformUtils.preCheckCast(this.map.getEntries(), Iterable.class, "com.obric.memorydata.plugin")), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29
        if (r2 == null) goto L20;
        Object r3 = r2.getKey();     // Catch: Throwable -> L29
        Object r4 = r2.getValue();     // Catch: Throwable -> L29
        this.map.remove((K) r3);     // Catch: Throwable -> L29
        this.size -= safeSizeOf(r3, r4);     // Catch: Throwable -> L29
        this.evictionCount++;     // Catch: Throwable -> L29
        monitor-exit(r0);
        entryRemoved(true, r3, r4, null);
        goto L2
    L20:
        monitor-exit(r0);
        return;
    L25:
        monitor-exit(r0);
        return;
    L28:
        throw new IllegalStateException("LruCache.sizeOf() is reporting inconsistent results!".toString());     // Catch: Throwable -> L29
    L7:
        if (this.map.isEmpty() == true) goto L9;
    L10:
        r1 = true;
        goto L12
    L9:
        if (this.size != 0) goto L11;
        goto L10
    }
}
