package com.obric.memorydata.personalcontext;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010'\n\u0000*\u0001\u0000\b\n\u0018\u00002\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0004J\u001e\u0010\u0005\u001a\u00020\u00062\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bH\u0014¨\u0006\t"}, d2 = {"com/obric/memorydata/personalcontext/NotificationIngestFilter$cache$1", "Ljava/util/LinkedHashMap;", "", "Lcom/obric/memorydata/personalcontext/NotificationIngestFilter$Fingerprint;", "Lkotlin/collections/LinkedHashMap;", "removeEldestEntry", "", "eldest", "", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class NotificationIngestFilter$cache$1 extends LinkedHashMap<String, p.a> {
    NotificationIngestFilter$cache$1() {
        super(16, 0.75f, true);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L7;
        return false;
    L7:
        return containsKey((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
    }

    public /* bridge */ boolean containsKey(String r1) {
        return super.containsKey(r1);
    }

    public /* bridge */ boolean containsValue(p.a r1) {
        return super.containsValue(r1);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final boolean containsValue(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, p.a.class) == true) goto L7;
        return false;
    L7:
        return containsValue((p.a) ZeusTransformUtils.preCheckCast(r3, p.a.class, "com.obric.memorydata.plugin"));
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<String, p.a>> entrySet() {
        return getEntries();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final p.a get(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L7;
        return null;
    L7:
        return get((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
    }

    public p.a get(String r2) {
        return (p.a) ZeusTransformUtils.preCheckCast(super.get(r2), p.a.class, "com.obric.memorydata.plugin");
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* synthetic */ Object get(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L7;
        return null;
    L7:
        return get((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
    }

    public Set<Map.Entry<String, p.a>> getEntries() {
        return super.entrySet();
    }

    public Set<String> getKeys() {
        return super.keySet();
    }

    public final p.a getOrDefault(Object r3, p.a r4) {
        if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L6;
        return r4;
    L6:
        return getOrDefault((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"), r4);
    }

    public p.a getOrDefault(String r1, p.a r2) {
        return (p.a) ZeusTransformUtils.preCheckCast(super.getOrDefault(r1, r2), p.a.class, "com.obric.memorydata.plugin");
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
    public final /* synthetic */ Object getOrDefault(Object r3, Object r4) {
        if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L6;
        return r4;
    L6:
        return getOrDefault((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"), (p.a) ZeusTransformUtils.preCheckCast(r4, p.a.class, "com.obric.memorydata.plugin"));
    }

    public int getSize() {
        return super.size();
    }

    public Collection<p.a> getValues() {
        return super.values();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Set<String> keySet() {
        return getKeys();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final p.a remove(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L7;
        return null;
    L7:
        return remove((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
    }

    public p.a remove(String r2) {
        return (p.a) ZeusTransformUtils.preCheckCast(super.remove(r2), p.a.class, "com.obric.memorydata.plugin");
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* synthetic */ Object remove(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L7;
        return null;
    L7:
        return remove((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
    }

    @Override // java.util.HashMap, java.util.Map
    public final boolean remove(Object r3, Object r4) {
        if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L6;
        return false;
    L6:
        if (ZeusTransformUtils.instanceOf(r4, p.a.class) == true) goto L9;
        return false;
    L9:
        return remove((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"), (p.a) ZeusTransformUtils.preCheckCast(r4, p.a.class, "com.obric.memorydata.plugin"));
    }

    public /* bridge */ boolean remove(String r1, p.a r2) {
        return super.remove(r1, r2);
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<String, p.a> r3) {
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r3, Map.Entry.class, "com.obric.memorydata.plugin");
        if (size() <= 64) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final int size() {
        return getSize();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Collection<p.a> values() {
        return getValues();
    }
}
