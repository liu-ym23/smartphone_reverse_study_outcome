package com.obric.capabilitykit.common;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004R(\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/obric/capabilitykit/common/BaseResultExt;", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Ljava/io/Serializable;", "()V", EventBody.KEY_VALUE, "resultDetailExtras", "getResultDetailExtras", "()Ljava/lang/String;", "setResultDetailExtras", "(Ljava/lang/String;)V", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BaseResultExt extends ConcurrentHashMap<String, String> implements Serializable {
    public BaseResultExt() {
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L7;
        return false;
    L7:
        return containsKey((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
    }

    public /* bridge */ boolean containsKey(String r1) {
        return super.containsKey(r1);
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public final boolean containsValue(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L7;
        return false;
    L7:
        return containsValue((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
    }

    public /* bridge */ boolean containsValue(String r1) {
        return super.containsValue(r1);
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<String, String>> entrySet() {
        return getEntries();
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public final /* synthetic */ Object get(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L7;
        return null;
    L7:
        return get((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public final String get(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L7;
        return null;
    L7:
        return get((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
    }

    public String get(String r2) {
        return (String) ZeusTransformUtils.preCheckCast(super.get(r2), String.class, "com.obric.memorydata.plugin");
    }

    public Set<Map.Entry<String, String>> getEntries() {
        return super.entrySet();
    }

    public Set<String> getKeys() {
        return super.keySet();
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.Map, java.util.concurrent.ConcurrentMap
    public final /* synthetic */ Object getOrDefault(Object r3, Object r4) {
        if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L6;
        return r4;
    L6:
        return getOrDefault((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin"));
    }

    public final String getOrDefault(Object r3, String r4) {
        if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L6;
        return r4;
    L6:
        return getOrDefault((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"), r4);
    }

    public String getOrDefault(String r1, String r2) {
        return (String) ZeusTransformUtils.preCheckCast(super.getOrDefault(r1, r2), String.class, "com.obric.memorydata.plugin");
    }

    public final String getResultDetailExtras() {
        return (String) ZeusTransformUtils.preCheckCast(get("result_detail_extras"), String.class, "com.obric.memorydata.plugin");
    }

    public int getSize() {
        return super.size();
    }

    public Collection<String> getValues() {
        return super.values();
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public final Set<String> keySet() {
        return getKeys();
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public final /* synthetic */ Object remove(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L7;
        return null;
    L7:
        return remove((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public final String remove(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L7;
        return null;
    L7:
        return remove((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
    }

    public String remove(String r2) {
        return (String) ZeusTransformUtils.preCheckCast(super.remove(r2), String.class, "com.obric.memorydata.plugin");
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.Map, java.util.concurrent.ConcurrentMap
    public final boolean remove(Object r3, Object r4) {
        if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L6;
        return false;
    L6:
        if (ZeusTransformUtils.instanceOf(r4, String.class) == true) goto L9;
        return false;
    L9:
        return remove((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin"));
    }

    public /* bridge */ boolean remove(String r1, String r2) {
        return super.remove(r1, r2);
    }

    public final void setResultDetailExtras(String r2) {
        if (r2 != null) goto L5;
        remove("result_detail_extras");
        return;
    L5:
        put("result_detail_extras", r2);
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public final int size() {
        return getSize();
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public final Collection<String> values() {
        return getValues();
    }
}
