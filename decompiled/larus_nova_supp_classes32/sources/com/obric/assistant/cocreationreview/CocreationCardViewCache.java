package com.obric.assistant.cocreationreview;

import com.obric.aivoice.core.data.NameKeys;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class CocreationCardViewCache<V> {
    public final LinkedHashMap<String, a<V>> a;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010'\n\u0000\b\u0002\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022*\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00050\u0003j\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0005`\u0006B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\"\u0010\u000b\u001a\u00020\f2\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00050\u000eH\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/assistant/cocreationreview/CocreationCardViewCache$LruMap;", "V", NameKeys.UnloadStrategy_No_Strategy, "Ljava/util/LinkedHashMap;", NameKeys.UnloadStrategy_No_Strategy, "Lcom/obric/assistant/cocreationreview/CocreationCardViewCache$CacheEntry;", "Lkotlin/collections/LinkedHashMap;", "maxSize", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(I)V", "removeEldestEntry", NameKeys.UnloadStrategy_No_Strategy, "eldest", NameKeys.UnloadStrategy_No_Strategy, "cocreationreview_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LruMap<V> extends LinkedHashMap<String, a<V>> {
        private final int maxSize;

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<Map.Entry<String, a<V>>> entrySet() {
            return (Set<Map.Entry<String, a<V>>>) getEntries();
        }

        public /* bridge */ Set<Map.Entry<String, a<Object>>> getEntries() {
            return super.entrySet();
        }

        public /* bridge */ Set<String> getKeys() {
            return super.keySet();
        }

        public /* bridge */ int getSize() {
            return super.size();
        }

        public /* bridge */ Collection<a<Object>> getValues() {
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
        public final /* bridge */ Collection<a<V>> values() {
            return (Collection<a<V>>) getValues();
        }

        public LruMap(int r4) {
            super(16, 0.75f, true);
            this.maxSize = r4;
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
            if ((r2 instanceof a) == true) goto L7;
            return false;
        L7:
            return containsValue((a) r2);
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ a<V> get(Object r2) {
            if ((r2 instanceof String) == true) goto L7;
            return null;
        L7:
            return (a<V>) get((String) r2);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ a<V> remove(Object r2) {
            if ((r2 instanceof String) == true) goto L7;
            return null;
        L7:
            return (a<V>) remove((String) r2);
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<String, a<V>> r2) {
            Intrinsics.checkNotNullParameter(r2, "eldest");
            if (size() <= this.maxSize) goto L5;
            return true;
        L5:
            return false;
        }

        public /* bridge */ boolean containsKey(String r1) {
            return super.containsKey(r1);
        }

        public /* bridge */ boolean containsValue(a<Object> r1) {
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

        public /* bridge */ a<Object> get(String r1) {
            return (a) super.get(r1);
        }

        public /* bridge */ a<Object> remove(String r1) {
            return (a) super.remove(r1);
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object getOrDefault(Object r2, Object r3) {
            if ((r2 instanceof String) == true) goto L6;
            return r3;
        L6:
            return getOrDefault((String) r2, (a) r3);
        }

        @Override // java.util.HashMap, java.util.Map
        public final /* bridge */ boolean remove(Object r3, Object r4) {
            if ((r3 instanceof String) == true) goto L6;
            return false;
        L6:
            if ((r4 instanceof a) == true) goto L9;
            return false;
        L9:
            return remove((String) r3, (a) r4);
        }

        public final /* bridge */ a<V> getOrDefault(Object r2, a<V> r3) {
            if ((r2 instanceof String) == true) goto L6;
            return r3;
        L6:
            return (a<V>) getOrDefault((String) r2, r3);
        }

        public /* bridge */ boolean remove(String r1, a<Object> r2) {
            return super.remove(r1, r2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public /* bridge */ a<Object> getOrDefault(String r1, a<Object> r2) {
            return (a) super.getOrDefault(r1, r2);
        }
    }

    public static final class a<V> {
        public final q5 a;
        public final V b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "CacheEntry(item=" + this.a + ", view=" + this.b + ')';
        }

        public a(q5 r2, V r3) {
            Intrinsics.checkNotNullParameter(r2, "item");
            Intrinsics.checkNotNullParameter(r3, "view");
            this.a = r2;
            this.b = r3;
        }
    }

    public CocreationCardViewCache() {
        this.a = new LruMap(24);
    }
}
