package org.apache.logging.log4j;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public interface Marker extends Serializable {
    Marker addParents(Marker... r1);

    boolean equals(Object r1);

    String getName();

    Marker[] getParents();

    boolean hasParents();

    int hashCode();

    boolean isInstanceOf(String r1);

    boolean isInstanceOf(Marker r1);

    boolean remove(Marker r1);

    Marker setParents(Marker... r1);
}
