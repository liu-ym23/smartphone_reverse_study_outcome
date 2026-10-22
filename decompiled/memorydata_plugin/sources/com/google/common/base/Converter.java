package com.google.common.base;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Converter<A, B> implements g<A, B> {
    private final boolean handleNullAutomatically;
    private transient Converter<B, A> reverse;

    private static final class ConverterComposition<A, B, C> extends Converter<A, C> implements Serializable {
        private static final long serialVersionUID = 0;
        final Converter<A, B> first;
        final Converter<B, C> second;

        ConverterComposition(Converter<A, B> r1, Converter<B, C> r2) {
            this.first = r1;
            this.second = r2;
        }

        @Override // com.google.common.base.Converter
        A correctedDoBackward(C r2) {
            return (A) this.first.correctedDoBackward(this.second.correctedDoBackward(r2));
        }

        @Override // com.google.common.base.Converter
        C correctedDoForward(A r2) {
            return (C) this.second.correctedDoForward(this.first.correctedDoForward(r2));
        }

        @Override // com.google.common.base.Converter
        public A doBackward(C r1) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Converter
        public C doForward(A r1) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Converter, com.google.common.base.g
        public boolean equals(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, ConverterComposition.class) == false) goto L10;
            ConverterComposition r5 = (ConverterComposition) ZeusTransformUtils.preCheckCast(r4, ConverterComposition.class, "com.obric.memorydata.plugin");
            if (this.first.equals(r5.first) == true) goto L7;
            return false;
        L7:
            if (this.second.equals(r5.second) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        public int hashCode() {
            return (this.first.hashCode() * 31) + this.second.hashCode();
        }

        public String toString() {
            return this.first + ".andThen(" + this.second + ")";
        }
    }

    private static final class FunctionBasedConverter<A, B> extends Converter<A, B> implements Serializable {
        private final g<? super B, ? extends A> backwardFunction;
        private final g<? super A, ? extends B> forwardFunction;

        private FunctionBasedConverter(g<? super A, ? extends B> r3, g<? super B, ? extends A> r4) {
            g r5 = (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.memorydata.plugin");
            g r6 = (g) ZeusTransformUtils.wrapperContextForParams(r4, g.class, "com.obric.memorydata.plugin");
            this.forwardFunction = (g) ZeusTransformUtils.preCheckCast(n.a(r5), g.class, "com.obric.memorydata.plugin");
            this.backwardFunction = (g) ZeusTransformUtils.preCheckCast(n.a(r6), g.class, "com.obric.memorydata.plugin");
        }

        /* synthetic */ FunctionBasedConverter(g r2, g r3, AnonymousClass1 r4) {
            this((g) ZeusTransformUtils.wrapperContextForParams(r2, g.class, "com.obric.memorydata.plugin"), (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.common.base.Converter
        public A doBackward(B r1) {
            return this.backwardFunction.apply(r1);
        }

        @Override // com.google.common.base.Converter
        public B doForward(A r1) {
            return this.forwardFunction.apply(r1);
        }

        @Override // com.google.common.base.Converter, com.google.common.base.g
        public boolean equals(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, FunctionBasedConverter.class) == false) goto L10;
            FunctionBasedConverter r5 = (FunctionBasedConverter) ZeusTransformUtils.preCheckCast(r4, FunctionBasedConverter.class, "com.obric.memorydata.plugin");
            if (this.forwardFunction.equals(r5.forwardFunction) == true) goto L7;
            return false;
        L7:
            if (this.backwardFunction.equals(r5.backwardFunction) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        public int hashCode() {
            return (this.forwardFunction.hashCode() * 31) + this.backwardFunction.hashCode();
        }

        public String toString() {
            return "Converter.from(" + this.forwardFunction + ", " + this.backwardFunction + ")";
        }
    }

    private static final class IdentityConverter<T> extends Converter<T, T> implements Serializable {
        static final IdentityConverter<?> INSTANCE = null;
        private static final long serialVersionUID = 0;

        static {
            INSTANCE = new IdentityConverter();
        }

        private IdentityConverter() {
        }

        private Object readResolve() {
            return INSTANCE;
        }

        @Override // com.google.common.base.Converter
        <S> Converter<T, S> doAndThen(Converter<T, S> r2) {
            return (Converter) ZeusTransformUtils.preCheckCast(n.a(r2, "otherConverter"), Converter.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.base.Converter
        public T doBackward(T r1) {
            return r1;
        }

        @Override // com.google.common.base.Converter
        public T doForward(T r1) {
            return r1;
        }

        @Override // com.google.common.base.Converter
        public IdentityConverter<T> reverse() {
            return this;
        }

        @Override // com.google.common.base.Converter
        public /* bridge */ /* synthetic */ Converter reverse() {
            return reverse();
        }

        public String toString() {
            return "Converter.identity()";
        }
    }

    private static final class ReverseConverter<A, B> extends Converter<B, A> implements Serializable {
        private static final long serialVersionUID = 0;
        final Converter<A, B> original;

        ReverseConverter(Converter<A, B> r1) {
            this.original = r1;
        }

        @Override // com.google.common.base.Converter
        B correctedDoBackward(A r1) {
            return this.original.correctedDoForward(r1);
        }

        @Override // com.google.common.base.Converter
        A correctedDoForward(B r1) {
            return this.original.correctedDoBackward(r1);
        }

        @Override // com.google.common.base.Converter
        public B doBackward(A r1) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Converter
        public A doForward(B r1) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Converter, com.google.common.base.g
        public boolean equals(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, ReverseConverter.class) == false) goto L6;
            ReverseConverter r4 = (ReverseConverter) ZeusTransformUtils.preCheckCast(r3, ReverseConverter.class, "com.obric.memorydata.plugin");
            return this.original.equals(r4.original);
        L6:
            return false;
        }

        public int hashCode() {
            return ~this.original.hashCode();
        }

        @Override // com.google.common.base.Converter
        public Converter<A, B> reverse() {
            return this.original;
        }

        public String toString() {
            return this.original + ".reverse()";
        }
    }

    public Converter() {
        this(true);
    }

    Converter(boolean r1) {
        this.handleNullAutomatically = r1;
    }

    public static <A, B> Converter<A, B> from(g<? super A, ? extends B> r2, g<? super B, ? extends A> r3) {
        return new FunctionBasedConverter((g) ZeusTransformUtils.wrapperContextForParams(r2, g.class, "com.obric.memorydata.plugin"), (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.memorydata.plugin"), null);
    }

    public static <T> Converter<T, T> identity() {
        return IdentityConverter.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private A unsafeDoBackward(B r1) {
        return (A) doBackward(j.a(r1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private B unsafeDoForward(A r1) {
        return (B) doForward(j.a(r1));
    }

    public final <C> Converter<A, C> andThen(Converter<B, C> r1) {
        return doAndThen(r1);
    }

    @Override // com.google.common.base.g, java.util.function.Function
    @Deprecated
    public final B apply(A r1) {
        return convert(r1);
    }

    public final B convert(A r1) {
        return correctedDoForward(r1);
    }

    public Iterable<B> convertAll(Iterable<? extends A> r3) {
        final Iterable r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin");
        n.a(r4, "fromIterable");
        return new AnonymousClass1(this, r4);
    }

    A correctedDoBackward(B r2) {
        if (this.handleNullAutomatically == false) goto L9;
        if (r2 != null) goto L7;
        return null;
    L7:
        return (A) n.a(doBackward(r2));
    L9:
        return unsafeDoBackward(r2);
    }

    B correctedDoForward(A r2) {
        if (this.handleNullAutomatically == false) goto L9;
        if (r2 != null) goto L7;
        return null;
    L7:
        return (B) n.a(doForward(r2));
    L9:
        return unsafeDoForward(r2);
    }

    <C> Converter<A, C> doAndThen(Converter<B, C> r4) {
        return new ConverterComposition(this, (Converter) ZeusTransformUtils.preCheckCast(n.a(r4), Converter.class, "com.obric.memorydata.plugin"));
    }

    public abstract A doBackward(B r1);

    public abstract B doForward(A r1);

    @Override // com.google.common.base.g
    public boolean equals(Object r1) {
        return super.equals(r1);
    }

    public Converter<B, A> reverse() {
        Converter<B, A> r0 = this.reverse;
        if (r0 != null) goto L6;
        ReverseConverter r1 = new ReverseConverter(this);
        this.reverse = r1;
        return r1;
    L6:
        return r0;
    }
}
