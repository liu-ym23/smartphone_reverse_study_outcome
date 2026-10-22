package androidx.room.jarjarred.org.antlr.v4.misc;

import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class FrequencySet<T> extends HashMap<T, MutableInt> {
    public FrequencySet() {
    }

    public void add(T r5) {
        MutableInt r10 = get(r5);
        if (r10 != null) goto L5;
        put(r5, new MutableInt(1));
        return;
    L5:
        r10.f645v++;
    }

    public int count(T r5) {
        MutableInt r10 = get(r5);
        if (r10 != null) goto L7;
        return 0;
    L7:
        return r10.f645v;
    }
}
