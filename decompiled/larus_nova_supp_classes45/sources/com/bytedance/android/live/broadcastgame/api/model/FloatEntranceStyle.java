package com.bytedance.android.live.broadcastgame.api.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\u0018\u00002\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/model/FloatEntranceStyle;", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "()V", "getStyle", "statusCode", "", "livebroadcastgame-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FloatEntranceStyle extends HashMap<String, String> {
    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<String, String>> entrySet() {
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
    public final /* bridge */ Collection<String> values() {
        return getValues();
    }

    public FloatEntranceStyle() {
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
        if ((r2 instanceof String) == true) goto L7;
        return false;
    L7:
        return containsValue((String) r2);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Object get(Object r2) {
        if ((r2 instanceof String) == true) goto L7;
        return null;
    L7:
        return get((String) r2);
    }

    public final String getStyle(int r3) {
        return (String) get("float_entrance_style_" + r3);
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

    public /* bridge */ boolean containsValue(String r1) {
        return super.containsValue(r1);
    }

    public /* bridge */ String get(String r1) {
        return (String) super.get(r1);
    }

    public /* bridge */ String remove(String r1) {
        return (String) super.remove(r1);
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ Object getOrDefault(Object r2, Object r3) {
        if ((r2 instanceof String) == true) goto L6;
        return r3;
    L6:
        return getOrDefault((String) r2, (String) r3);
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ boolean remove(Object r2, Object r3) {
        if ((r2 instanceof String) == true) goto L5;
        return false;
    L5:
        if ((r3 instanceof String) == true) goto L8;
        return false;
    L8:
        return remove((String) r2, (String) r3);
    }

    public /* bridge */ String getOrDefault(String r1, String r2) {
        return (String) super.getOrDefault(r1, r2);
    }

    public /* bridge */ boolean remove(String r1, String r2) {
        return super.remove(r1, r2);
    }
}
