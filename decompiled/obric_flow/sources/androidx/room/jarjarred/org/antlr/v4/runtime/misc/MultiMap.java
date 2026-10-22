package androidx.room.jarjarred.org.antlr.v4.runtime.misc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MultiMap<K, V> extends LinkedHashMap<K, List<V>> {
    public MultiMap() {
    }

    public List<Pair<K, V>> getPairs() {
        ArrayList r5 = new ArrayList();
        Iterator<K> r10 = keySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L9;
        K r11 = r10.next();
        Iterator r12 = ((List) get(r11)).iterator();
    L7:
        if (r12.hasNext() == false) goto L4;
        r5.add(new Pair(r11, r12.next()));
        goto L7
    L9:
        return r5;
    }

    public void map(K r5, V r10) {
        List r11 = (List) get(r5);
        if (r11 != null) goto L5;
        r11 = new ArrayList();
        super.put(r5, r11);
    L5:
        r11.add(r10);
    }
}
