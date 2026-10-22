package androidx.room.jarjarred.org.antlr.runtime.misc;

import ai.j0;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public class FastQueue<T> {
    protected List<T> data;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    protected int f631p;
    protected int range;

    public FastQueue() {
        this.data = new ArrayList();
        this.f631p = 0;
        this.range = -1;
    }

    public void add(T r5) {
        this.data.add(r5);
    }

    public void clear() {
        this.f631p = 0;
        this.data.clear();
    }

    public T elementAt(int r5) {
        int r10 = this.f631p + r5;
        if (r10 >= this.data.size()) goto L12;
        if (r10 < 0) goto L11;
        if (r10 <= this.range) goto L9;
        this.range = r10;
    L9:
        return this.data.get(r10);
    L11:
        throw new NoSuchElementException(j0.h(r10, "queue index ", " < 0"));
    L12:
        StringBuilder r11 = j0.s(r10, "queue index ", " > last index ");
        r11.append(this.data.size() - 1);
        throw new NoSuchElementException(r11.toString());
    }

    public T head() {
        return elementAt(0);
    }

    public int range() {
        return this.range;
    }

    public T remove() {
        T r5 = elementAt(0);
        int r10 = this.f631p + 1;
        this.f631p = r10;
        if (r10 != this.data.size()) goto L5;
        clear();
    L5:
        return r5;
    }

    public void reset() {
        clear();
    }

    public int size() {
        return this.data.size() - this.f631p;
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder();
        int r10 = size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L8;
        r5.append(elementAt(r11));
        r11 = r11 + 1;
        if (r11 >= r10) goto L3;
        r5.append(" ");
        goto L3
    L8:
        return r5.toString();
    }
}
