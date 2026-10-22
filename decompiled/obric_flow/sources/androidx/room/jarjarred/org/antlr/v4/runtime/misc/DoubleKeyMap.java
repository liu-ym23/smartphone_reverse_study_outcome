package androidx.room.jarjarred.org.antlr.v4.runtime.misc;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class DoubleKeyMap<Key1, Key2, Value> {
    Map<Key1, Map<Key2, Value>> data;

    public DoubleKeyMap() {
        this.data = new LinkedHashMap();
    }

    public Value get(Key1 r5, Key2 r10) {
        Map<Key2, Value> r11 = this.data.get(r5);
        if (r11 != null) goto L7;
        return null;
    L7:
        return r11.get(r10);
    }

    public Set<Key1> keySet() {
        return this.data.keySet();
    }

    public Value put(Key1 r5, Key2 r10, Value r11) {
        Map<Key2, Value> r12 = this.data.get(r5);
        if (r12 != null) goto L5;
        r12 = new LinkedHashMap();
        this.data.put(r5, r12);
        Value r13 = null;
    L6:
        r12.put(r10, r11);
        return r13;
    L5:
        r13 = r12.get(r10);
        goto L6
    }

    public Collection<Value> values(Key1 r5) {
        Map<Key2, Value> r10 = this.data.get(r5);
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.values();
    }

    public Set<Key2> keySet(Key1 r5) {
        Map<Key2, Value> r10 = this.data.get(r5);
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.keySet();
    }

    public Map<Key2, Value> get(Key1 r5) {
        return this.data.get(r5);
    }
}
