package com.bytedance.apm.util;

import java.lang.Comparable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/* JADX INFO: loaded from: classes.dex */
public class y<E extends Comparable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private PriorityQueue<E> f1156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1157b;

    class a implements Comparator<E> {
        a(y r10) {
        }

        public int a(E r10, E r11) {
            return r10.compareTo(r11);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Object r10, Object r11) {
            return a((Comparable) r10, (Comparable) r11);
        }
    }

    public y(int r10) {
        if (r10 <= 0) goto L7;
        this.f1157b = r10;
        this.f1156a = new PriorityQueue(r10, new a(this));
        return;
    L7:
        throw new IllegalStateException();
    }

    public void a(E r10) {
        if (this.f1156a.size() >= this.f1157b) goto L6;
    L4:
        this.f1156a.add(r10);
        return;
    L6:
        if (r10.compareTo(this.f1156a.peek()) <= 0) goto L9;
        this.f1156a.poll();
        goto L4
    }

    public void b() {
        this.f1156a.clear();
    }

    public int c() {
        return this.f1156a.size();
    }

    public List<E> d() {
        ArrayList r10 = new ArrayList(this.f1156a);
        Collections.sort(r10);
        return r10;
    }
}
