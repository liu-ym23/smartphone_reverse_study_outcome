package com.obric.aiagent.messenger;

import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010'\n\u0000*\u0001\u0000\b\n\u0018\u00002\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0004J\u001e\u0010\u0005\u001a\u00020\u00062\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bH\u0014¨\u0006\t"}, d2 = {"com/obric/aiagent/messenger/AppIntentScreenshotCacheUtils$cache$1", "Ljava/util/LinkedHashMap;", NameKeys.UnloadStrategy_No_Strategy, "Lcom/obric/aiagent/messenger/AppIntentScreenshotCacheUtils$Entry;", "Lkotlin/collections/LinkedHashMap;", "removeEldestEntry", NameKeys.UnloadStrategy_No_Strategy, "eldest", NameKeys.UnloadStrategy_No_Strategy, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppIntentScreenshotCacheUtils$cache$1 extends LinkedHashMap<String, AppIntentScreenshotCacheUtils.c> {
    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<String, AppIntentScreenshotCacheUtils.c>> entrySet() {
        return getEntries();
    }

    public /* bridge */ Set<Map.Entry<String, AppIntentScreenshotCacheUtils.c>> getEntries() {
        return super.entrySet();
    }

    public /* bridge */ Set<String> getKeys() {
        return super.keySet();
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ Collection<AppIntentScreenshotCacheUtils.c> getValues() {
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
    public final /* bridge */ Collection<AppIntentScreenshotCacheUtils.c> values() {
        return getValues();
    }

    public AppIntentScreenshotCacheUtils$cache$1(int r3) {
        super(r3, 0.75f, true);
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
        if ((r2 instanceof AppIntentScreenshotCacheUtils.c) == true) goto L7;
        return false;
    L7:
        return containsValue((AppIntentScreenshotCacheUtils.c) r2);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ AppIntentScreenshotCacheUtils.c get(Object r2) {
        if ((r2 instanceof String) == true) goto L7;
        return null;
    L7:
        return get((String) r2);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ AppIntentScreenshotCacheUtils.c remove(Object r2) {
        if ((r2 instanceof String) == true) goto L7;
        return null;
    L7:
        return remove((String) r2);
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<String, AppIntentScreenshotCacheUtils.c> r6) {
        boolean r1 = false;
        if (r6 == null) goto L9;
        AppIntentScreenshotCacheUtils.c r2 = r6.getValue();
        if (r2 == null) goto L9;
        if (r2.a() != true) goto L9;
        boolean r3 = true;
    L11:
        if (r3 == false) goto L14;
        FLogger.a.w("AppIntentScreenshotCacheUtils", "remove by invalid " + r6.getKey());
        r1 = true;
    L14:
        if (size() <= AppIntentScreenshotCacheUtils.e) goto L21;
        FLogger r4 = FLogger.a;
        StringBuilder r5 = new StringBuilder("remove by size ");
        if (r6 == null) goto L18;
        String r7 = r6.getKey();
    L19:
        r5.append(r7);
        r4.w("AppIntentScreenshotCacheUtils", r5.toString());
        return true;
    L18:
        r7 = null;
        goto L19
    L21:
        return r1;
    L9:
        r3 = false;
        goto L11
    }

    public /* bridge */ boolean containsKey(String r1) {
        return super.containsKey(r1);
    }

    public /* bridge */ boolean containsValue(AppIntentScreenshotCacheUtils.c r1) {
        return super.containsValue(r1);
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

    public /* bridge */ AppIntentScreenshotCacheUtils.c get(String r1) {
        return (AppIntentScreenshotCacheUtils.c) super.get(r1);
    }

    public /* bridge */ AppIntentScreenshotCacheUtils.c remove(String r1) {
        return (AppIntentScreenshotCacheUtils.c) super.remove(r1);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object getOrDefault(Object r2, Object r3) {
        if ((r2 instanceof String) == true) goto L6;
        return r3;
    L6:
        return getOrDefault((String) r2, (AppIntentScreenshotCacheUtils.c) r3);
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ boolean remove(Object r3, Object r4) {
        if ((r3 instanceof String) == true) goto L6;
        return false;
    L6:
        if ((r4 instanceof AppIntentScreenshotCacheUtils.c) == true) goto L9;
        return false;
    L9:
        return remove((String) r3, (AppIntentScreenshotCacheUtils.c) r4);
    }

    public final /* bridge */ AppIntentScreenshotCacheUtils.c getOrDefault(Object r2, AppIntentScreenshotCacheUtils.c r3) {
        if ((r2 instanceof String) == true) goto L6;
        return r3;
    L6:
        return getOrDefault((String) r2, r3);
    }

    public /* bridge */ boolean remove(String r1, AppIntentScreenshotCacheUtils.c r2) {
        return super.remove(r1, r2);
    }

    public /* bridge */ AppIntentScreenshotCacheUtils.c getOrDefault(String r1, AppIntentScreenshotCacheUtils.c r2) {
        return (AppIntentScreenshotCacheUtils.c) super.getOrDefault(r1, r2);
    }
}
