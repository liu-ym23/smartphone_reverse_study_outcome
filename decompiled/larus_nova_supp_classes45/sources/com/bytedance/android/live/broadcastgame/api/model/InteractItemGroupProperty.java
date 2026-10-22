package com.bytedance.android.live.broadcastgame.api.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\u0018\u0000 \u000b2\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0004:\u0001\fB\u0007¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\b\u0010\b\u001a\u00020\u0000H\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/model/InteractItemGroupProperty;", "Ljava/util/HashMap;", "", "Lcom/bytedance/android/live/broadcastgame/api/model/o0;", "Lkotlin/collections/HashMap;", "", "groupType", "getGroupCapacity", "clone", "<init>", "()V", "Companion", "a", "livebroadcastgame-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InteractItemGroupProperty extends HashMap<String, o0> {
    public static final a Companion = null;
    public static final long RECENT_USED_INTERACT_ITEM_GROUP_TYPE = 3;
    public static final long UNLIMITED_CAPACITY = -1;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    @Override // java.util.HashMap, java.util.AbstractMap
    public InteractItemGroupProperty clone() {
        Map r0 = MapsKt.toMap(this);
        InteractItemGroupProperty r1 = new InteractItemGroupProperty();
        Iterator r2 = r0.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        Map.Entry r3 = (Map.Entry) r2.next();
        r1.put(r3.getKey(), r3.getValue());
        goto L4
    L6:
        return r1;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<String, o0>> entrySet() {
        return getEntries();
    }

    public /* bridge */ Set getEntries() {
        return super.entrySet();
    }

    public /* bridge */ Set getKeys() {
        return super.keySet();
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ Collection getValues() {
        return super.values();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<String> keySet() {
        return getKeys();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Collection<o0> values() {
        return getValues();
    }

    public InteractItemGroupProperty() {
    }

    @Override // java.util.HashMap, java.util.AbstractMap
    public /* bridge */ /* synthetic */ Object clone() {
        return clone();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsKey(Object r2) {
        if ((r2 instanceof String) == true) goto L7;
        return false;
    L7:
        return containsKey((String) r2);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsValue(Object r2) {
        if ((r2 instanceof o0) == true) goto L7;
        return false;
    L7:
        return containsValue((o0) r2);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Object get(Object r2) {
        if ((r2 instanceof String) == true) goto L7;
        return null;
    L7:
        return get((String) r2);
    }

    public final long getGroupCapacity(long r4) {
        o0 r5 = (o0) get(String.valueOf(r4));
        if (r5 == null) goto L5;
        long r6 = r5.capacity;
    L7:
        if (r6 != (-1)) goto L10;
        return Long.MAX_VALUE;
    L10:
        return r6;
    L5:
        r6 = 0;
        goto L7
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Object remove(Object r2) {
        if ((r2 instanceof String) == true) goto L7;
        return null;
    L7:
        return remove((String) r2);
    }

    public /* bridge */ boolean containsKey(String r1) {
        return super.containsKey(r1);
    }

    public /* bridge */ boolean containsValue(o0 r1) {
        return super.containsValue(r1);
    }

    public /* bridge */ o0 get(String r1) {
        return (o0) super.get(r1);
    }

    public /* bridge */ o0 remove(String r1) {
        return (o0) super.remove(r1);
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ Object getOrDefault(Object r2, Object r3) {
        if ((r2 instanceof String) == true) goto L6;
        return r3;
    L6:
        return getOrDefault((String) r2, (o0) r3);
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ boolean remove(Object r2, Object r3) {
        if ((r2 instanceof String) == true) goto L5;
        return false;
    L5:
        if ((r3 instanceof o0) == true) goto L8;
        return false;
    L8:
        return remove((String) r2, (o0) r3);
    }

    public /* bridge */ o0 getOrDefault(String r1, o0 r2) {
        return (o0) super.getOrDefault(r1, r2);
    }

    public /* bridge */ boolean remove(String r1, o0 r2) {
        return super.remove(r1, r2);
    }
}
