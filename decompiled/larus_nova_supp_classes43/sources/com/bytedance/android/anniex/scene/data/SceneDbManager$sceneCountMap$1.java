package com.bytedance.android.anniex.scene.data;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010'\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0004J\u001c\u0010\b\u001a\u00020\u00072\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0005H\u0014¨\u0006\t"}, d2 = {"com/bytedance/android/anniex/scene/data/SceneDbManager$sceneCountMap$1", "Ljava/util/LinkedHashMap;", "", "Lcom/bytedance/android/anniex/scene/data/SceneDbManager$b;", "Lkotlin/collections/LinkedHashMap;", "", "eldest", "", "removeEldestEntry", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class SceneDbManager$sceneCountMap$1 extends LinkedHashMap<String, SceneDbManager.b> {
    final /* synthetic */ SceneDbManager this$0;

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<String, SceneDbManager.b>> entrySet() {
        return getEntries();
    }

    public /* bridge */ Set<Map.Entry<String, SceneDbManager.b>> getEntries() {
        return super.entrySet();
    }

    public /* bridge */ Set<String> getKeys() {
        return super.keySet();
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ Collection<SceneDbManager.b> getValues() {
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
    public final /* bridge */ Collection<SceneDbManager.b> values() {
        return getValues();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsKey(Object r10) {
        if ((r10 instanceof String) == true) goto L7;
        return false;
    L7:
        return containsKey((String) r10);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsValue(Object r10) {
        if ((r10 instanceof SceneDbManager.b) == true) goto L7;
        return false;
    L7:
        return containsValue((SceneDbManager.b) r10);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ SceneDbManager.b get(Object r10) {
        if ((r10 instanceof String) == true) goto L7;
        return null;
    L7:
        return get((String) r10);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ SceneDbManager.b remove(Object r10) {
        if ((r10 instanceof String) == true) goto L7;
        return null;
    L7:
        return remove((String) r10);
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<String, SceneDbManager.b> r10) {
        Intrinsics.checkNotNullParameter(r10, "eldest");
        if (size() <= this.this$0.k) goto L5;
        return true;
    L5:
        return false;
    }

    public /* bridge */ boolean containsKey(String r1) {
        return super.containsKey(r1);
    }

    public /* bridge */ boolean containsValue(SceneDbManager.b r1) {
        return super.containsValue(r1);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object get(Object r10) {
        if ((r10 instanceof String) == true) goto L7;
        return null;
    L7:
        return get((String) r10);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object remove(Object r10) {
        if ((r10 instanceof String) == true) goto L7;
        return null;
    L7:
        return remove((String) r10);
    }

    public /* bridge */ SceneDbManager.b get(String r1) {
        return (SceneDbManager.b) super.get(r1);
    }

    public /* bridge */ SceneDbManager.b remove(String r1) {
        return (SceneDbManager.b) super.remove(r1);
    }

    public SceneDbManager$sceneCountMap$1(SceneDbManager r10, int r11) {
        this.this$0 = r10;
        super(r11, 0.75f, true);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object getOrDefault(Object r10, Object r11) {
        if ((r10 instanceof String) == true) goto L6;
        return r11;
    L6:
        return getOrDefault((String) r10, (SceneDbManager.b) r11);
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ boolean remove(Object r10, Object r11) {
        if ((r10 instanceof String) == true) goto L6;
        return false;
    L6:
        if ((r11 instanceof SceneDbManager.b) == true) goto L9;
        return false;
    L9:
        return remove((String) r10, (SceneDbManager.b) r11);
    }

    public final /* bridge */ SceneDbManager.b getOrDefault(Object r10, SceneDbManager.b r11) {
        if ((r10 instanceof String) == true) goto L6;
        return r11;
    L6:
        return getOrDefault((String) r10, r11);
    }

    public /* bridge */ boolean remove(String r1, SceneDbManager.b r10) {
        return super.remove(r1, r10);
    }

    public /* bridge */ SceneDbManager.b getOrDefault(String r1, SceneDbManager.b r10) {
        return (SceneDbManager.b) super.getOrDefault(r1, r10);
    }
}
