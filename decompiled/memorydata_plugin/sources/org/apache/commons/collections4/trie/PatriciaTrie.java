package org.apache.commons.collections4.trie;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.trie.analyzer.StringKeyAnalyzer;

/* JADX INFO: loaded from: classes6.dex */
public class PatriciaTrie<E> extends AbstractPatriciaTrie<String, E> {
    private static final long serialVersionUID = 4446367780901817838L;

    public PatriciaTrie() {
        super(new StringKeyAnalyzer());
    }

    public PatriciaTrie(Map<? extends String, ? extends E> r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        super(new StringKeyAnalyzer(), r4);
    }

    @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie, java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie, java.util.SortedMap
    public /* bridge */ /* synthetic */ Comparator comparator() {
        return super.comparator();
    }

    @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie, java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ boolean containsKey(Object r1) {
        return super.containsKey(r1);
    }

    @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie, java.util.AbstractMap, java.util.Map, java.util.SortedMap
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie, java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ Object get(Object r1) {
        return super.get(r1);
    }

    @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie, java.util.AbstractMap, java.util.Map, java.util.SortedMap
    public /* bridge */ /* synthetic */ Set keySet() {
        return super.keySet();
    }

    @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie, org.apache.commons.collections4.OrderedMap, org.apache.commons.collections4.IterableGet
    public /* bridge */ /* synthetic */ OrderedMapIterator mapIterator() {
        return super.mapIterator();
    }

    @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie, java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ Object remove(Object r1) {
        return super.remove(r1);
    }

    @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie, java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie, java.util.AbstractMap, java.util.Map, java.util.SortedMap
    public /* bridge */ /* synthetic */ Collection values() {
        return super.values();
    }
}
