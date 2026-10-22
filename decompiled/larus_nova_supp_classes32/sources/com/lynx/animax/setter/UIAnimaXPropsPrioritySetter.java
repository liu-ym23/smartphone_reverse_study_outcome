package com.lynx.animax.setter;

import com.lynx.animax.AnimaXPlayer;
import java.lang.ref.WeakReference;
import java.util.PriorityQueue;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class UIAnimaXPropsPrioritySetter {
    public final PriorityQueue<b> a;
    public WeakReference<AnimaXPlayer> b;

    public static final enum ExecutionPriority extends Enum<ExecutionPriority> {
        public static final ExecutionPriority DEFAULT = null;
        public static final ExecutionPriority HIGH = null;
        public static final ExecutionPriority LOW = null;
        public static final /* synthetic */ ExecutionPriority[] a = null;
        private final int value;

        static {
            ExecutionPriority r0 = new ExecutionPriority("HIGH", 0, -100);
            HIGH = r0;
            ExecutionPriority r1 = new ExecutionPriority("DEFAULT", 1, 0);
            DEFAULT = r1;
            ExecutionPriority r2 = new ExecutionPriority("LOW", 2, 100);
            LOW = r2;
            a = new ExecutionPriority[]{r0, r1, r2};
        }

        public static ExecutionPriority[] values() {
            return (ExecutionPriority[]) a.clone();
        }

        public int getValue() {
            return this.value;
        }

        public static ExecutionPriority valueOf(String r1) {
            return (ExecutionPriority) r27.a.a(ExecutionPriority.class, r1);
        }

        public ExecutionPriority(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @FunctionalInterface
    public interface a {
        void a(AnimaXPlayer r1) throws Exception;
    }

    public static class b implements Comparable<b> {
        public final a a;
        public final ExecutionPriority b;

        @Override // java.lang.Comparable
        public final int compareTo(b r2) {
            return Integer.compare(this.b.getValue(), r2.b.getValue());
        }

        public b(a r1, ExecutionPriority r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public UIAnimaXPropsPrioritySetter() {
        this.a = new PriorityQueue();
    }

    public final void a(a r2) {
        b(r2, ExecutionPriority.DEFAULT);
    }

    public final void b(a r2, ExecutionPriority r3) {
        b r0 = new b(r2, r3);
        this.a.add(r0);
    }
}
