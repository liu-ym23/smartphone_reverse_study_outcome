package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class f9 extends o7 {
    public final /* synthetic */ int d;
    public final Object e;

    public /* synthetic */ f9(StandardTable r5, int r10) {
        this.d = r10;
        this.e = r5;
    }

    @Override // com.google.common.collect.o7
    public final Set a() {
        switch(this.d) {
            case 0: goto L9;
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return new l(4, this);
    L7:
        return new d9(this, (byte) 0);
    L9:
        return new d9(this);
    }

    @Override // com.google.common.collect.o7
    public Collection c() {
        switch(this.d) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return super.c();
    L7:
        return new y1(this, 2);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        switch(this.d) {
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        super.clear();
        return;
    L6:
        ((g0) this.e).clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object r5) {
        switch(this.d) {
            case 0: goto L9;
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return ((g0) this.e).containsKey(r5);
    L7:
        return ((StandardTable) this.e).containsRow(r5);
    L9:
        return ((StandardTable) this.e).containsColumn(r5);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object r5) {
        switch(this.d) {
            case 0: goto L14;
            case 1: goto L9;
            default: goto L4;
        };
    L4:
        g0 r10 = (g0) this.e;
        if (r10.containsKey(r5) == true) goto L19;
        return null;
    L19:
        return r10.get(r5);
    L9:
        StandardTable r11 = (StandardTable) this.e;
        if (r11.containsRow(r5) == false) goto L12;
        Objects.requireNonNull(r5);
        return r11.row(r5);
    L12:
        return null;
    L14:
        StandardTable r12 = (StandardTable) this.e;
        if (r12.containsColumn(r5) == false) goto L17;
        Objects.requireNonNull(r5);
        return r12.column(r5);
    L17:
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        switch(this.d) {
            case 2: goto L7;
            default: goto L5;
        };
    L5:
        return super.isEmpty();
    L7:
        return ((g0) this.e).isEmpty();
    }

    @Override // com.google.common.collect.o7, java.util.AbstractMap, java.util.Map
    public Set keySet() {
        switch(this.d) {
            case 0: goto L9;
            case 1: goto L5;
            case 2: goto L7;
            default: goto L5;
        };
    L5:
        return super.keySet();
    L7:
        return ((g0) this.e).keySet();
    L9:
        return ((StandardTable) this.e).columnKeySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object r5) {
        switch(this.d) {
            case 0: goto L13;
            case 1: goto L9;
            default: goto L4;
        };
    L4:
        g0 r10 = (g0) this.e;
        if (r10.containsKey(r5) == true) goto L18;
        return null;
    L18:
        return r10.removeAll(r5);
    L9:
        if (r5 != null) goto L12;
        return null;
    L12:
        return (Map) ((StandardTable) this.e).backingMap.remove(r5);
    L13:
        StandardTable r11 = (StandardTable) this.e;
        if (r11.containsColumn(r5) == true) goto L20;
        return null;
    L20:
        return StandardTable.access$900(r11, r5);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        switch(this.d) {
            case 2: goto L7;
            default: goto L5;
        };
    L5:
        return super.size();
    L7:
        return ((g0) this.e).keySet().size();
    }

    public f9(g0 r5) {
        this.d = 2;
        this.e = r5;
    }
}
