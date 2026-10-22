package androidx.room.jarjarred.org.stringtemplate.v4.compiler;

import java.util.Iterator;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes.dex */
public class StringTable {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected int f680i;
    protected LinkedHashMap<String, Integer> table;

    public StringTable() {
        this.table = new LinkedHashMap();
        this.f680i = -1;
    }

    public int add(String r5) {
        Integer r10 = this.table.get(r5);
        if (r10 != null) goto L5;
        int r11 = this.f680i + 1;
        this.f680i = r11;
        this.table.put(r5, Integer.valueOf(r11));
        return this.f680i;
    L5:
        return r10.intValue();
    }

    public String[] toArray() {
        String[] r5 = new String[this.table.size()];
        Iterator<String> r10 = this.table.keySet().iterator();
        int r11 = 0;
    L4:
        if (r10.hasNext() == false) goto L6;
        r5[r11] = r10.next();
        r11 = r11 + 1;
        goto L4
    L6:
        return r5;
    }
}
