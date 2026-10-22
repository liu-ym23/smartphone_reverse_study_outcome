package org.apache.logging.log4j.spi;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import org.apache.logging.log4j.util.PropertiesUtil;
import org.apache.logging.log4j.util.ReadOnlyStringMap;
import org.apache.logging.log4j.util.u;

/* JADX INFO: loaded from: classes6.dex */
public class DefaultThreadContextMap implements n, ReadOnlyStringMap {
    public static final String INHERITABLE_MAP = "isThreadContextMapInheritable";
    private static boolean inheritableMap = false;
    private static final long serialVersionUID = 8218007901108944053L;
    private final ThreadLocal<Map<String, String>> localMap;
    private final boolean useMap;

    static {
        init();
    }

    public DefaultThreadContextMap() {
        this(true);
    }

    public DefaultThreadContextMap(boolean r1) {
        this.useMap = r1;
        this.localMap = createThreadLocalMap(r1);
    }

    static ThreadLocal<Map<String, String>> createThreadLocalMap(final boolean r1) {
        if (inheritableMap == false) goto L7;
        return new AnonymousClass1(r1);
    L7:
        return new ThreadLocal();
    }

    static void init() {
        inheritableMap = PropertiesUtil.a().a(INHERITABLE_MAP);
    }

    public void clear() {
        this.localMap.remove();
    }

    @Override // org.apache.logging.log4j.util.ReadOnlyStringMap
    public boolean containsKey(String r3) {
        Map r2 = (Map) ZeusTransformUtils.preCheckCast(this.localMap.get(), Map.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (r2.containsKey(r3) == false) goto L7;
        return true;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L7;
        return true;
    L7:
        if (r5 != null) goto L10;
        return false;
    L10:
        if (ZeusTransformUtils.instanceOf(r5, DefaultThreadContextMap.class) == false) goto L15;
        DefaultThreadContextMap r0 = (DefaultThreadContextMap) ZeusTransformUtils.preCheckCast(r5, DefaultThreadContextMap.class, "com.obric.memorydata.plugin");
        if (this.useMap == r0.useMap) goto L15;
        return false;
    L15:
        if (ZeusTransformUtils.instanceOf(r5, n.class) == true) goto L17;
        return false;
    L17:
        n r6 = (n) ZeusTransformUtils.preCheckCast(r5, n.class, "com.obric.memorydata.plugin");
        return Objects.equals((Map) ZeusTransformUtils.preCheckCast(this.localMap.get(), Map.class, "com.obric.memorydata.plugin"), r6.getImmutableMapOrNull());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.logging.log4j.util.ReadOnlyStringMap
    public <V> void forEach(org.apache.logging.log4j.util.a<String, ? super V> r4) {
        org.apache.logging.log4j.util.a r5 = (org.apache.logging.log4j.util.a) ZeusTransformUtils.wrapperContextForParams(r4, org.apache.logging.log4j.util.a.class, "com.obric.memorydata.plugin");
        Map r3 = (Map) ZeusTransformUtils.preCheckCast(this.localMap.get(), Map.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
        return;
    L5:
        Iterator r6 = r3.entrySet().iterator();
    L7:
        if (r6.hasNext() == false) goto L9;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Object r2 = r0.getValue();
        r5.accept(r0.getKey(), r2);
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.logging.log4j.util.ReadOnlyStringMap
    public <V, S> void forEach(u<String, ? super V, S> r4, S r5) {
        u r6 = (u) ZeusTransformUtils.wrapperContextForParams(r4, u.class, "com.obric.memorydata.plugin");
        Map r3 = (Map) ZeusTransformUtils.preCheckCast(this.localMap.get(), Map.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
        return;
    L5:
        Iterator r7 = r3.entrySet().iterator();
    L7:
        if (r7.hasNext() == false) goto L9;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Object r2 = r0.getValue();
        r6.accept(r0.getKey(), r2, r5);
        goto L7
    }

    public String get(String r3) {
        Map r2 = (Map) ZeusTransformUtils.preCheckCast(this.localMap.get(), Map.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L6;
        return null;
    L6:
        return (String) ZeusTransformUtils.preCheckCast(r2.get(r3), String.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.logging.log4j.spi.n
    public Map<String, String> getCopy() {
        Map r2 = (Map) ZeusTransformUtils.preCheckCast(this.localMap.get(), Map.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L6;
        return new HashMap();
    L6:
        return new HashMap(r2);
    }

    @Override // org.apache.logging.log4j.spi.n
    public Map<String, String> getImmutableMapOrNull() {
        return (Map) ZeusTransformUtils.preCheckCast(this.localMap.get(), Map.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.logging.log4j.util.ReadOnlyStringMap
    public <V> V getValue(String r3) {
        Map r2 = (Map) ZeusTransformUtils.preCheckCast(this.localMap.get(), Map.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L6;
        return null;
    L6:
        return (V) ((String) ZeusTransformUtils.preCheckCast(r2.get(r3), String.class, "com.obric.memorydata.plugin"));
    }

    public int hashCode() {
        Map r0 = (Map) ZeusTransformUtils.preCheckCast(this.localMap.get(), Map.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        int r1 = 0;
    L7:
        return ((r1 + 31) * 31) + Boolean.valueOf(this.useMap).hashCode();
    L5:
        r1 = r0.hashCode();
        goto L7
    }

    @Override // org.apache.logging.log4j.util.ReadOnlyStringMap
    public boolean isEmpty() {
        Map r2 = (Map) ZeusTransformUtils.preCheckCast(this.localMap.get(), Map.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L5;
    L8:
        return true;
    L5:
        if (r2.isEmpty() == true) goto L8;
        return false;
    }

    public void put(String r4, String r5) {
        if (this.useMap == true) goto L5;
        return;
    L5:
        Map r0 = (Map) ZeusTransformUtils.preCheckCast(this.localMap.get(), Map.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L8;
        HashMap r1 = new HashMap(1);
    L9:
        r1.put(r4, r5);
        this.localMap.set(Collections.unmodifiableMap(r1));
        return;
    L8:
        r1 = new HashMap(r0);
        goto L9
    }

    public void putAll(Map<String, String> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        if (this.useMap == true) goto L5;
        return;
    L5:
        Map r0 = (Map) ZeusTransformUtils.preCheckCast(this.localMap.get(), Map.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L8;
        HashMap r1 = new HashMap(r6.size());
    L9:
        Iterator r7 = r6.entrySet().iterator();
    L11:
        if (r7.hasNext() == false) goto L13;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r1.put(r2.getKey(), r2.getValue());
        goto L11
    L13:
        this.localMap.set(Collections.unmodifiableMap(r1));
        return;
    L8:
        r1 = new HashMap(r0);
        goto L9
    }

    public void remove(String r4) {
        Map r0 = (Map) ZeusTransformUtils.preCheckCast(this.localMap.get(), Map.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L6;
        HashMap r1 = new HashMap(r0);
        r1.remove(r4);
        this.localMap.set(Collections.unmodifiableMap(r1));
        return;
    }

    public void removeAll(Iterable<String> r5) {
        Iterable r6 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r5, Iterable.class, "com.obric.memorydata.plugin");
        Map r0 = (Map) ZeusTransformUtils.preCheckCast(this.localMap.get(), Map.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L11;
        HashMap r2 = new HashMap(r0);
        Iterator r7 = r6.iterator();
    L6:
        if (r7.hasNext() == false) goto L8;
        r2.remove((String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.memorydata.plugin"));
        goto L6
    L8:
        this.localMap.set(Collections.unmodifiableMap(r2));
        return;
    }

    @Override // org.apache.logging.log4j.util.ReadOnlyStringMap
    public int size() {
        Map r2 = (Map) ZeusTransformUtils.preCheckCast(this.localMap.get(), Map.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L6;
        return 0;
    L6:
        return r2.size();
    }

    @Override // org.apache.logging.log4j.util.ReadOnlyStringMap
    public Map<String, String> toMap() {
        return getCopy();
    }

    public String toString() {
        Map r2 = (Map) ZeusTransformUtils.preCheckCast(this.localMap.get(), Map.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L6;
        return "{}";
    L6:
        return r2.toString();
    }
}
