package com.bytedance.android.livesdk.interactivity.enteranim.utils;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j<E> {
    public final TreeMap<Long, Deque<E>> a;

    public static final class a<T> implements Comparator {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r4, Object r5) {
            return (((Long) r5).longValue() > ((Long) r4).longValue() ? 1 : (((Long) r5).longValue() == ((Long) r4).longValue() ? 0 : -1));
        }
    }

    public j() {
        this.a = new TreeMap(a.a);
    }

    public final List a(int r9) {
        LinkedList r0 = new LinkedList();
    L4:
        if (this.a.isEmpty() == true) goto L16;
        if (r9 <= 0) goto L16;
        Map.Entry<Long, Deque<E>> r1 = this.a.lastEntry();
        Long r2 = r1.getKey();
        if (r2.longValue() >= 90000) goto L16;
        Deque<E> r3 = r1.getValue();
        int r4 = Math.min(r3.size(), r9);
        int r5 = 0;
    L10:
        if (r5 >= r4) goto L13;
        r0.add(r3.pollFirst());
        r5 = r5 + 1;
        goto L10
    L13:
        if (r3.isEmpty() == false) goto L15;
        this.a.remove(r2);
    L15:
        r9 = r9 - r4;
    L16:
        return r0;
    }
}
