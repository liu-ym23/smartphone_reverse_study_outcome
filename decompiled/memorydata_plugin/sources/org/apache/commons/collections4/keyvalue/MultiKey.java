package org.apache.commons.collections4.keyvalue;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes6.dex */
public class MultiKey<K> implements Serializable {
    private static final long serialVersionUID = 4465448607415788805L;
    private transient int hashCode;
    private final K[] keys;

    public MultiKey(K r3, K r4) {
        this((Object[]) ZeusTransformUtils.preCheckCast(new Object[]{r3, r4}, Object[].class, "com.obric.memorydata.plugin"), false);
    }

    public MultiKey(K r3, K r4, K r5) {
        this((Object[]) ZeusTransformUtils.preCheckCast(new Object[]{r3, r4, r5}, Object[].class, "com.obric.memorydata.plugin"), false);
    }

    public MultiKey(K r3, K r4, K r5, K r6) {
        this((Object[]) ZeusTransformUtils.preCheckCast(new Object[]{r3, r4, r5, r6}, Object[].class, "com.obric.memorydata.plugin"), false);
    }

    public MultiKey(K r3, K r4, K r5, K r6, K r7) {
        this((Object[]) ZeusTransformUtils.preCheckCast(new Object[]{r3, r4, r5, r6, r7}, Object[].class, "com.obric.memorydata.plugin"), false);
    }

    public MultiKey(K[] r2) {
        this(r2, true);
    }

    public MultiKey(K[] r3, boolean r4) {
        if (r3 == null) goto L10;
        if (r4 == false) goto L6;
        this.keys = (K[]) ((Object[]) ZeusTransformUtils.preCheckCast(r3.clone(), Object[].class, "com.obric.memorydata.plugin"));
    L7:
        calculateHashCode(r3);
        return;
    L6:
        this.keys = r3;
        goto L7
    L10:
        throw new IllegalArgumentException("The array of keys must not be null");
    }

    private void calculateHashCode(Object[] r5) {
        int r0 = r5.length;
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r0) goto L8;
        Object r3 = r5[r1];
        if (r3 == null) goto L7;
        r2 = r2 ^ r3.hashCode();
    L7:
        r1 = r1 + 1;
        goto L3
    L8:
        this.hashCode = r2;
    }

    public boolean equals(Object r3) {
        if (r3 != this) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, MultiKey.class) == false) goto L10;
        MultiKey r4 = (MultiKey) ZeusTransformUtils.preCheckCast(r3, MultiKey.class, "com.obric.memorydata.plugin");
        return Arrays.equals(this.keys, r4.keys);
    L10:
        return false;
    }

    public K getKey(int r1) {
        return this.keys[r1];
    }

    public K[] getKeys() {
        return (K[]) ((Object[]) ZeusTransformUtils.preCheckCast(this.keys.clone(), Object[].class, "com.obric.memorydata.plugin"));
    }

    public int hashCode() {
        return this.hashCode;
    }

    public Object readResolve() {
        calculateHashCode(this.keys);
        return this;
    }

    public int size() {
        return this.keys.length;
    }

    public String toString() {
        return "MultiKey" + Arrays.toString(this.keys);
    }
}
