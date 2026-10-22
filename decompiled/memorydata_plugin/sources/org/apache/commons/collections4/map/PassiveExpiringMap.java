package org.apache.commons.collections4.map;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes6.dex */
public class PassiveExpiringMap<K, V> extends AbstractMapDecorator<K, V> implements Serializable {
    private static final long serialVersionUID = 1;
    private final Map<Object, Long> expirationMap;
    private final ExpirationPolicy<K, V> expiringPolicy;

    public static class ConstantTimeToLiveExpirationPolicy<K, V> implements ExpirationPolicy<K, V> {
        private static final long serialVersionUID = 1;
        private final long timeToLiveMillis;

        public ConstantTimeToLiveExpirationPolicy() {
            this(-1);
        }

        public ConstantTimeToLiveExpirationPolicy(long r1) {
            this.timeToLiveMillis = r1;
        }

        public ConstantTimeToLiveExpirationPolicy(long r1, TimeUnit r3) {
            this(PassiveExpiringMap.access$000(r1, r3));
        }

        @Override // org.apache.commons.collections4.map.PassiveExpiringMap.ExpirationPolicy
        public long expirationTime(K r7, V r8) {
            if (this.timeToLiveMillis < 0) goto L9;
            long r9 = System.currentTimeMillis();
            long r4 = this.timeToLiveMillis;
            if (r9 <= (Long.MAX_VALUE - r4)) goto L8;
            return -1;
        L8:
            return r9 + r4;
        L9:
            return -1;
        }
    }

    @FunctionalInterface
    public interface ExpirationPolicy<K, V> extends Serializable {
        long expirationTime(K r1, V r2);
    }

    public PassiveExpiringMap() {
        this(-1);
    }

    public PassiveExpiringMap(long r2) {
        this(new ConstantTimeToLiveExpirationPolicy(r2), new HashMap());
    }

    public PassiveExpiringMap(long r3, Map<K, V> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        this(new ConstantTimeToLiveExpirationPolicy(r3), r6);
    }

    public PassiveExpiringMap(long r1, TimeUnit r3) {
        this(validateAndConvertToMillis(r1, r3));
    }

    public PassiveExpiringMap(long r3, TimeUnit r5, Map<K, V> r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        this(validateAndConvertToMillis(r3, r5), r7);
    }

    public PassiveExpiringMap(Map<K, V> r3) {
        this(-1, (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin"));
    }

    public PassiveExpiringMap(ExpirationPolicy<K, V> r3) {
        this((ExpirationPolicy) ZeusTransformUtils.wrapperContextForParams(r3, ExpirationPolicy.class, "com.obric.memorydata.plugin"), new HashMap());
    }

    public PassiveExpiringMap(ExpirationPolicy<K, V> r3, Map<K, V> r4) {
        ExpirationPolicy<K, V> r5 = (ExpirationPolicy) ZeusTransformUtils.wrapperContextForParams(r3, ExpirationPolicy.class, "com.obric.memorydata.plugin");
        super((Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin"));
        this.expirationMap = new HashMap();
        Objects.requireNonNull(r5, "Policy must not be null.");
        this.expiringPolicy = r5;
    }

    static /* synthetic */ long access$000(long r0, TimeUnit r2) {
        return validateAndConvertToMillis(r0, r2);
    }

    private boolean isExpired(long r5, Long r7) {
        if (r7 == null) goto L10;
        long r0 = r7.longValue();
        if (r0 >= 0) goto L7;
        return false;
    L7:
        if (r5 < r0) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    private long now() {
        return System.currentTimeMillis();
    }

    private void readObject(ObjectInputStream r3) {
        r3.defaultReadObject();
        this.map = (Map) ZeusTransformUtils.preCheckCast(r3.readObject(), Map.class, "com.obric.memorydata.plugin");
    }

    private void removeAllExpired(long r6) {
        Iterator<Map.Entry<Object, Long>> r0 = this.expirationMap.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (isExpired(r6, (Long) ZeusTransformUtils.preCheckCast(r1.getValue(), Long.class, "com.obric.memorydata.plugin")) == false) goto L4;
        super.remove(r1.getKey());
        r0.remove();
        goto L4
    }

    private void removeIfExpired(Object r4, long r5) {
        if (isExpired(r5, (Long) ZeusTransformUtils.preCheckCast(this.expirationMap.get(r4), Long.class, "com.obric.memorydata.plugin")) == false) goto L6;
        remove(r4);
        return;
    }

    private static long validateAndConvertToMillis(long r1, TimeUnit r3) {
        Objects.requireNonNull(r3, "Time unit must not be null");
        return TimeUnit.MILLISECONDS.convert(r1, r3);
    }

    private void writeObject(ObjectOutputStream r1) {
        r1.defaultWriteObject();
        r1.writeObject(this.map);
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public void clear() {
        super.clear();
        this.expirationMap.clear();
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public boolean containsKey(Object r3) {
        removeIfExpired(r3, now());
        return super.containsKey(r3);
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public boolean containsValue(Object r3) {
        removeAllExpired(now());
        return super.containsValue(r3);
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        removeAllExpired(now());
        return super.entrySet();
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public V get(Object r3) {
        removeIfExpired(r3, now());
        return (V) super.get(r3);
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public boolean isEmpty() {
        removeAllExpired(now());
        return super.isEmpty();
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public Set<K> keySet() {
        removeAllExpired(now());
        return super.keySet();
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public V put(K r4, V r5) {
        removeIfExpired(r4, now());
        long r0 = this.expiringPolicy.expirationTime(r4, r5);
        this.expirationMap.put(r4, Long.valueOf(r0));
        return (V) super.put(r4, r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public void putAll(Map<? extends K, ? extends V> r4) {
        Iterator<Map.Entry<K, V>> r5 = ((Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        put(r0.getKey(), r0.getValue());
        goto L4
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public V remove(Object r2) {
        this.expirationMap.remove(r2);
        return (V) super.remove(r2);
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public int size() {
        removeAllExpired(now());
        return super.size();
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public Collection<V> values() {
        removeAllExpired(now());
        return super.values();
    }
}
