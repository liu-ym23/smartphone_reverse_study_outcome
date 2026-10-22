package com.larus.audio.flow.client.mob;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010'\n\u0000*\u0001\u0000\b\n\u0018\u00002\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0004J\u001e\u0010\u0005\u001a\u00020\u00062\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bH\u0014¨\u0006\t"}, d2 = {"com/larus/audio/flow/client/mob/FlowAudioAsrAndTTSCostMobHelper$asrMap$2$1", "Ljava/util/LinkedHashMap;", "", "Lorg/json/JSONObject;", "Lkotlin/collections/LinkedHashMap;", "removeEldestEntry", "", "eldest", "", "audiosdk_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class FlowAudioAsrAndTTSCostMobHelper$asrMap$2$1 extends LinkedHashMap<String, JSONObject> {
    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<String, JSONObject>> entrySet() {
        return getEntries();
    }

    public /* bridge */ Set<Map.Entry<String, JSONObject>> getEntries() {
        return super.entrySet();
    }

    public /* bridge */ Set<String> getKeys() {
        return super.keySet();
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ Collection<JSONObject> getValues() {
        return super.values();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<String> keySet() {
        return getKeys();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Collection<JSONObject> values() {
        return getValues();
    }

    public FlowAudioAsrAndTTSCostMobHelper$asrMap$2$1() {
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsKey(Object r2) {
        if ((r2 instanceof String) == true) goto L7;
        return false;
    L7:
        return containsKey((String) r2);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsValue(Object r2) {
        if ((r2 instanceof JSONObject) == true) goto L7;
        return false;
    L7:
        return containsValue((JSONObject) r2);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object get(Object r2) {
        if ((r2 instanceof String) == true) goto L7;
        return null;
    L7:
        return get((String) r2);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object remove(Object r2) {
        if ((r2 instanceof String) == true) goto L7;
        return null;
    L7:
        return remove((String) r2);
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<String, JSONObject> r2) {
        if (size() <= 10) goto L5;
        return true;
    L5:
        return false;
    }

    public /* bridge */ boolean containsKey(String r1) {
        return super.containsKey(r1);
    }

    public /* bridge */ boolean containsValue(JSONObject r1) {
        return super.containsValue(r1);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ JSONObject get(Object r2) {
        if ((r2 instanceof String) == true) goto L7;
        return null;
    L7:
        return get((String) r2);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ JSONObject remove(Object r2) {
        if ((r2 instanceof String) == true) goto L7;
        return null;
    L7:
        return remove((String) r2);
    }

    public /* bridge */ JSONObject get(String r1) {
        return (JSONObject) super.get(r1);
    }

    public /* bridge */ JSONObject remove(String r1) {
        return (JSONObject) super.remove(r1);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object getOrDefault(Object r2, Object r3) {
        if ((r2 instanceof String) == true) goto L6;
        return r3;
    L6:
        return getOrDefault((String) r2, (JSONObject) r3);
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ boolean remove(Object r3, Object r4) {
        if ((r3 instanceof String) == true) goto L6;
        return false;
    L6:
        if ((r4 instanceof JSONObject) == true) goto L9;
        return false;
    L9:
        return remove((String) r3, (JSONObject) r4);
    }

    public final /* bridge */ JSONObject getOrDefault(Object r2, JSONObject r3) {
        if ((r2 instanceof String) == true) goto L6;
        return r3;
    L6:
        return getOrDefault((String) r2, r3);
    }

    public /* bridge */ boolean remove(String r1, JSONObject r2) {
        return super.remove(r1, r2);
    }

    public /* bridge */ JSONObject getOrDefault(String r1, JSONObject r2) {
        return (JSONObject) super.getOrDefault(r1, r2);
    }
}
