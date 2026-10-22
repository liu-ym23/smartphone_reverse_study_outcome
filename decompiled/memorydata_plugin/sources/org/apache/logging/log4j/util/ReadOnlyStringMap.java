package org.apache.logging.log4j.util;

import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public interface ReadOnlyStringMap extends Serializable {
    boolean containsKey(String r1);

    <V> void forEach(a<String, ? super V> r1);

    <V, S> void forEach(u<String, ? super V, S> r1, S r2);

    <V> V getValue(String r1);

    boolean isEmpty();

    int size();

    Map<String, String> toMap();
}
