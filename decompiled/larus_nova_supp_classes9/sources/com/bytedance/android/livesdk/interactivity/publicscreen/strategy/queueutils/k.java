package com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class k {
    public final PriorityQueue<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> a;
    public final com.bytedance.android.livesdk.interactivity.api.settings.config.m b;

    public static final class a<T> implements Comparator {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r3, Object r4) {
            return (int) (((com.bytedance.android.livesdk.interactivity.api.entity.f) r3).p().longValue() - ((com.bytedance.android.livesdk.interactivity.api.entity.f) r4).p().longValue());
        }
    }

    public abstract void a(Queue<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r1, Queue<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r2, Queue<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r3, Queue<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r4);

    public k(com.bytedance.android.livesdk.interactivity.api.settings.config.m r3) {
        Intrinsics.checkNotNullParameter(r3, "config");
        this.b = r3;
        this.a = new PriorityQueue(5, a.a);
    }
}
