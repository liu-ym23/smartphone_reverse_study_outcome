package com.google.common.base;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.function.BiPredicate;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Equivalence<T> implements BiPredicate<T, T> {

    /* JADX INFO: renamed from: com.google.common.base.Equivalence$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    static final class Equals extends Equivalence<Object> implements Serializable {
        static final Equals INSTANCE = null;
        private static final long serialVersionUID = 1;

        static {
            INSTANCE = new Equals();
        }

        Equals() {
        }

        private Object readResolve() {
            return INSTANCE;
        }

        @Override // com.google.common.base.Equivalence
        public boolean doEquivalent(Object r1, Object r2) {
            return r1.equals(r2);
        }

        @Override // com.google.common.base.Equivalence
        public int doHash(Object r1) {
            return r1.hashCode();
        }
    }

    private static final class EquivalentToPredicate<T> implements o<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final Equivalence<T> equivalence;
        private final T target;

        EquivalentToPredicate(Equivalence<T> r3, T r4) {
            this.equivalence = (Equivalence) ZeusTransformUtils.preCheckCast(n.a(r3), Equivalence.class, "com.obric.memorydata.plugin");
            this.target = r4;
        }

        @Override // com.google.common.base.o
        public boolean apply(T r2) {
            return this.equivalence.equivalent(r2, this.target);
        }

        @Override // com.google.common.base.o
        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, EquivalentToPredicate.class) == false) goto L14;
            EquivalentToPredicate r6 = (EquivalentToPredicate) ZeusTransformUtils.preCheckCast(r5, EquivalentToPredicate.class, "com.obric.memorydata.plugin");
            if (this.equivalence.equals(r6.equivalence) == false) goto L13;
            if (k.a(this.target, r6.target) == false) goto L13;
            return true;
        L13:
            return false;
        L14:
            return false;
        }

        public int hashCode() {
            return k.a(new Object[]{this.equivalence, this.target});
        }

        public String toString() {
            return this.equivalence + ".equivalentTo(" + this.target + ")";
        }
    }

    static final class Identity extends Equivalence<Object> implements Serializable {
        static final Identity INSTANCE = null;
        private static final long serialVersionUID = 1;

        static {
            INSTANCE = new Identity();
        }

        Identity() {
        }

        private Object readResolve() {
            return INSTANCE;
        }

        @Override // com.google.common.base.Equivalence
        public boolean doEquivalent(Object r1, Object r2) {
            return false;
        }

        @Override // com.google.common.base.Equivalence
        public int doHash(Object r1) {
            return System.identityHashCode(r1);
        }
    }

    public static final class Wrapper<T> implements Serializable {
        private static final long serialVersionUID = 0;
        private final Equivalence<? super T> equivalence;
        private final T reference;

        private Wrapper(Equivalence<? super T> r3, T r4) {
            this.equivalence = (Equivalence) ZeusTransformUtils.preCheckCast(n.a(r3), Equivalence.class, "com.obric.memorydata.plugin");
            this.reference = r4;
        }

        /* synthetic */ Wrapper(Equivalence r1, Object r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        public boolean equals(Object r3) {
            if (r3 != this) goto L7;
            return true;
        L7:
            if (ZeusTransformUtils.instanceOf(r3, Wrapper.class) == false) goto L12;
            Wrapper r4 = (Wrapper) ZeusTransformUtils.preCheckCast(r3, Wrapper.class, "com.obric.memorydata.plugin");
            if (this.equivalence.equals(r4.equivalence) == true) goto L11;
            return false;
        L11:
            return this.equivalence.equivalent(this.reference, r4.reference);
        L12:
            return false;
        }

        public T get() {
            return this.reference;
        }

        public int hashCode() {
            return this.equivalence.hash(this.reference);
        }

        public String toString() {
            return this.equivalence + ".wrap(" + this.reference + ")";
        }
    }

    public Equivalence() {
    }

    public static Equivalence<Object> equals() {
        return Equals.INSTANCE;
    }

    public static Equivalence<Object> identity() {
        return Identity.INSTANCE;
    }

    public abstract boolean doEquivalent(T r1, T r2);

    public abstract int doHash(T r1);

    public final boolean equivalent(T r1, T r2) {
        if (r1 != r2) goto L5;
        return true;
    L5:
        if (r1 == null) goto L10;
        if (r2 != null) goto L9;
        return false;
    L9:
        return doEquivalent(r1, r2);
    L10:
        return false;
    }

    public final o<T> equivalentTo(T r2) {
        return new EquivalentToPredicate(this, r2);
    }

    public final int hash(T r1) {
        if (r1 != null) goto L6;
        return 0;
    L6:
        return doHash(r1);
    }

    public final <F> Equivalence<F> onResultOf(g<? super F, ? extends T> r3) {
        return new FunctionalEquivalence((g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.memorydata.plugin"), this);
    }

    public final <S extends T> Equivalence<Iterable<S>> pairwise() {
        return new PairwiseEquivalence(this);
    }

    @Override // java.util.function.BiPredicate
    @Deprecated
    public final boolean test(T r1, T r2) {
        return equivalent(r1, r2);
    }

    public final <S extends T> Wrapper<S> wrap(S r3) {
        return new Wrapper(this, r3, null);
    }
}
