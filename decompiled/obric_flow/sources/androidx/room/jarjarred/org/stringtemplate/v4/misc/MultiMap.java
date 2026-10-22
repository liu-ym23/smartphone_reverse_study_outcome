package androidx.room.jarjarred.org.stringtemplate.v4.misc;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MultiMap<K, V> extends LinkedHashMap<K, List<V>> {
    public MultiMap() {
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
