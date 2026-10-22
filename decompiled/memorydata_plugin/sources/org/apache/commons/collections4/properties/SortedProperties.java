package org.apache.commons.collections4.properties;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import org.apache.commons.collections4.iterators.IteratorEnumeration;

/* JADX INFO: loaded from: classes6.dex */
public class SortedProperties extends Properties {
    private static final long serialVersionUID = 1;

    public SortedProperties() {
    }

    @Override // java.util.Hashtable, java.util.Dictionary
    public synchronized Enumeration<Object> keys() {
        monitor-enter(this);
        Set r0 = keySet();     // Catch: Throwable -> L10
        ArrayList r1 = new ArrayList(r0.size());     // Catch: Throwable -> L10
        Iterator r2 = r0.iterator();     // Catch: Throwable -> L10
    L5:
        if (r2.hasNext() == false) goto L7;
        r1.add(r2.next().toString());     // Catch: Throwable -> L10
        goto L5
    L7:
        Collections.sort(r1);     // Catch: Throwable -> L10
        IteratorEnumeration r3 = new IteratorEnumeration(r1.iterator());     // Catch: Throwable -> L10
        monitor-exit(this);
        return r3;
    L10:
        th = move-exception;
        throw th;
    }
}
