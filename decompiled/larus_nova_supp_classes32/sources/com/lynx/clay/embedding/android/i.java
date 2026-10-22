package com.lynx.clay.embedding.android;

import android.util.LongSparseArray;
import android.view.MotionEvent;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class i {
    public static i c;
    public final LongSparseArray<MotionEvent> a;
    public final PriorityQueue<Long> b;

    public static class a {
        public static final AtomicLong a = null;

        static {
            a = new AtomicLong(0);
        }
    }

    public i() {
        this.a = new LongSparseArray();
        this.b = new PriorityQueue();
    }
}
