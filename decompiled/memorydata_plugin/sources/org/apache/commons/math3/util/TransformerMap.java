package org.apache.commons.math3.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public class TransformerMap implements Serializable, NumberTransformer {
    private static final long serialVersionUID = 4605318041528645258L;
    private NumberTransformer defaultTransformer;
    private Map<Class<?>, NumberTransformer> map;

    public TransformerMap() {
        this.defaultTransformer = null;
        this.map = null;
        this.map = new HashMap();
        this.defaultTransformer = new DefaultTransformer();
    }

    public Set<Class<?>> classes() {
        return this.map.keySet();
    }

    public void clear() {
        this.map.clear();
    }

    public boolean containsClass(Class<?> r1) {
        return this.map.containsKey(r1);
    }

    public boolean containsTransformer(NumberTransformer r3) {
        NumberTransformer r4 = (NumberTransformer) ZeusTransformUtils.wrapperContextForParams(r3, NumberTransformer.class, "com.obric.memorydata.plugin");
        return this.map.containsValue(r4);
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, TransformerMap.class) == false) goto L20;
        TransformerMap r8 = (TransformerMap) ZeusTransformUtils.preCheckCast(r7, TransformerMap.class, "com.obric.memorydata.plugin");
        if (this.defaultTransformer.equals(r8.defaultTransformer) == true) goto L11;
        return false;
    L11:
        if (this.map.size() == r8.map.size()) goto L13;
        return false;
    L13:
        Iterator<Map.Entry<Class<?>, NumberTransformer>> r6 = this.map.entrySet().iterator();
    L15:
        if (r6.hasNext() == false) goto L19;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (((NumberTransformer) ZeusTransformUtils.preCheckCast(r0.getValue(), NumberTransformer.class, "com.obric.memorydata.plugin")).equals(r8.map.get(r0.getKey())) == true) goto L15;
        return false;
    L19:
        return true;
    L20:
        return false;
    }

    public NumberTransformer getTransformer(Class<?> r2) {
        return (NumberTransformer) ZeusTransformUtils.preCheckCast(this.map.get(r2), NumberTransformer.class, "com.obric.memorydata.plugin");
    }

    public int hashCode() {
        int r0 = this.defaultTransformer.hashCode();
        Iterator<NumberTransformer> r4 = this.map.values().iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r0 = (r0 * 31) + ((NumberTransformer) ZeusTransformUtils.preCheckCast(r4.next(), NumberTransformer.class, "com.obric.memorydata.plugin")).hashCode();
        goto L4
    L6:
        return r0;
    }

    public NumberTransformer putTransformer(Class<?> r3, NumberTransformer r4) {
        NumberTransformer r5 = (NumberTransformer) ZeusTransformUtils.wrapperContextForParams(r4, NumberTransformer.class, "com.obric.memorydata.plugin");
        return (NumberTransformer) ZeusTransformUtils.preCheckCast(this.map.put(r3, r5), NumberTransformer.class, "com.obric.memorydata.plugin");
    }

    public NumberTransformer removeTransformer(Class<?> r2) {
        return (NumberTransformer) ZeusTransformUtils.preCheckCast(this.map.remove(r2), NumberTransformer.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.commons.math3.util.NumberTransformer
    public double transform(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, Number.class) == false) goto L5;
    L11:
        NumberTransformer r1 = this.defaultTransformer;
    L13:
        return r1.transform(r2);
    L5:
        if (ZeusTransformUtils.instanceOf(r2, String.class) == true) goto L11;
        r1 = getTransformer(r2.getClass());
        if (r1 != null) goto L13;
        return Double.NaN;
    }

    public Collection<NumberTransformer> transformers() {
        return this.map.values();
    }
}
