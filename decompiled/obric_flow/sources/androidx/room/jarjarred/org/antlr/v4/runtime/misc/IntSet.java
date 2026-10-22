package androidx.room.jarjarred.org.antlr.v4.runtime.misc;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface IntSet {
    void add(int r5);

    IntSet addAll(IntSet r5);

    IntSet and(IntSet r5);

    IntSet complement(IntSet r5);

    boolean contains(int r5);

    boolean equals(Object r5);

    boolean isNil();

    IntSet or(IntSet r5);

    void remove(int r5);

    int size();

    IntSet subtract(IntSet r5);

    List<Integer> toList();

    String toString();
}
