package androidx.room.jarjarred.org.stringtemplate.v4.misc;

import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class Aggregate {
    public HashMap<String, Object> properties;

    public Aggregate() {
        this.properties = new HashMap();
    }

    public Object get(String r5) {
        return this.properties.get(r5);
    }

    public void put(String r5, Object r10) {
        this.properties.put(r5, r10);
    }

    public String toString() {
        return this.properties.toString();
    }
}
