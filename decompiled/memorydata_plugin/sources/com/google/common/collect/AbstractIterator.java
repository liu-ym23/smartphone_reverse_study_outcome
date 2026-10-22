package com.google.common.collect;

import com.obric.memorydata.database.entity.RawObservationEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractIterator<T> extends bj<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private State f4367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private T f4368b;

    /* JADX INFO: renamed from: com.google.common.collect.AbstractIterator$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4369a = null;

        static {
            int[] r0 = new int[State.values().length];
            f4369a = r0;
            r0[State.DONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f4369a[State.READY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    private static final enum State extends Enum<State> {
        private static final /* synthetic */ State[] $VALUES = null;
        public static final State DONE = null;
        public static final State FAILED = null;
        public static final State NOT_READY = null;
        public static final State READY = null;

        private static /* synthetic */ State[] $values() {
            return new State[]{READY, NOT_READY, DONE, FAILED};
        }

        static {
            READY = new State("READY", 0);
            NOT_READY = new State("NOT_READY", 1);
            DONE = new State("DONE", 2);
            FAILED = new State(RawObservationEntity.STATE_FAILED, 3);
            $VALUES = $values();
        }

        private State(String r1, int r2) {
            super(r1, r2);
        }

        public static State valueOf(String r2) {
            return (State) ZeusTransformUtils.preCheckCast(Enum.valueOf(State.class, r2), State.class, "com.obric.memorydata.plugin");
        }

        public static State[] values() {
            return (State[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), State[].class, "com.obric.memorydata.plugin");
        }
    }

    public AbstractIterator() {
        this.f4367a = State.NOT_READY;
    }

    private boolean c() {
        this.f4367a = State.FAILED;
        this.f4368b = a();
        if (this.f4367a == State.DONE) goto L6;
        this.f4367a = State.READY;
        return true;
    L6:
        return false;
    }

    public abstract T a();

    public final T b() {
        this.f4367a = State.DONE;
        return null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f4367a == State.FAILED) goto L5;
        boolean r0 = true;
    L6:
        com.google.common.base.n.b(r0);
        int r1 = AnonymousClass1.f4369a[this.f4367a.ordinal()];
        if (r1 != 1) goto L9;
        return false;
    L9:
        if (r1 != 2) goto L11;
        return true;
    L11:
        return c();
    L5:
        r0 = false;
        goto L6
    }

    @Override // java.util.Iterator
    public final T next() {
        if (hasNext() == false) goto L7;
        this.f4367a = State.NOT_READY;
        T r0 = (T) ao.a(this.f4368b);
        this.f4368b = null;
        return r0;
    L7:
        throw new NoSuchElementException();
    }
}
