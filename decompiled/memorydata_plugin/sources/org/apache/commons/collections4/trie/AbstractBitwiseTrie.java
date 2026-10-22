package org.apache.commons.collections4.trie;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.collections4.Trie;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractBitwiseTrie<K, V> extends AbstractMap<K, V> implements Serializable, Trie<K, V> {
    private static final long serialVersionUID = 5826987063535505652L;
    private final KeyAnalyzer<? super K> keyAnalyzer;

    static abstract class BasicEntry<K, V> implements Serializable, Map.Entry<K, V> {
        private static final long serialVersionUID = -944364551314110330L;
        protected K key;
        protected V value;

        public BasicEntry(K r1) {
            this.key = r1;
        }

        public BasicEntry(K r1, V r2) {
            this.key = r1;
            this.value = r2;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object r5) {
            if (r5 != this) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, Map.Entry.class) == true) goto L8;
            return false;
        L8:
            Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5, Map.Entry.class, "com.obric.memorydata.plugin");
            if (AbstractBitwiseTrie.compare(this.key, r6.getKey()) == true) goto L11;
        L13:
            return false;
        L11:
            if (AbstractBitwiseTrie.compare(this.value, r6.getValue()) == false) goto L13;
            return true;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            int r1 = 0;
            if (getKey() != null) goto L5;
            int r0 = 0;
        L7:
            if (getValue() == null) goto L11;
            r1 = getValue().hashCode();
        L11:
            return r0 ^ r1;
        L5:
            r0 = getKey().hashCode();
            goto L7
        }

        public V setKeyValue(K r1, V r2) {
            this.key = r1;
            return setValue(r2);
        }

        @Override // java.util.Map.Entry
        public V setValue(V r2) {
            V r0 = this.value;
            this.value = r2;
            return r0;
        }

        public String toString() {
            return this.key + "=" + this.value;
        }
    }

    public AbstractBitwiseTrie(KeyAnalyzer<? super K> r2) {
        Objects.requireNonNull(r2, "keyAnalyzer");
        this.keyAnalyzer = r2;
    }

    static boolean compare(Object r0, Object r1) {
        if (r0 != null) goto L7;
        if (r1 != null) goto L5;
        return true;
    L5:
        return false;
    L7:
        return r0.equals(r1);
    }

    final int bitIndex(K r8, K r9) {
        return this.keyAnalyzer.bitIndex(r8, 0, lengthInBits(r8), r9, 0, lengthInBits(r9));
    }

    final int bitsPerElement() {
        return this.keyAnalyzer.bitsPerElement();
    }

    /* JADX WARN: Multi-variable type inference failed */
    final K castKey(Object r1) {
        return r1;
    }

    final boolean compareKeys(K r3, K r4) {
        if (r3 != null) goto L8;
        if (r4 != null) goto L7;
        return true;
    L7:
        return false;
    L8:
        if (r4 != null) goto L11;
        return false;
    L11:
        if (this.keyAnalyzer.compare(r3, r4) != 0) goto L14;
        return true;
    L14:
        return false;
    }

    public KeyAnalyzer<? super K> getKeyAnalyzer() {
        return this.keyAnalyzer;
    }

    final boolean isBitSet(K r1, int r2, int r3) {
        if (r1 != null) goto L6;
        return false;
    L6:
        return this.keyAnalyzer.isBitSet(r1, r2, r3);
    }

    final int lengthInBits(K r1) {
        if (r1 != null) goto L6;
        return 0;
    L6:
        return this.keyAnalyzer.lengthInBits(r1);
    }

    @Override // java.util.AbstractMap
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("Trie[").append(size()).append("]={\n");
        Iterator<Map.Entry<K, V>> r4 = entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r0.append("  ").append(r1).append("\n");
        goto L4
    L6:
        r0.append("}\n");
        return r0.toString();
    }
}
