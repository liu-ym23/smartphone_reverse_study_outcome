package com.google.common.base;

/* JADX INFO: loaded from: classes2.dex */
public abstract class m implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient m f8665a;
    private final boolean handleNullAutomatically;

    public m() {
        this.handleNullAutomatically = true;
    }

    public static <A, B> m from(q r5, q r10) {
        return new Converter$FunctionBasedConverter(r5, r10, null);
    }

    public static <T> m identity() {
        return Converter$IdentityConverter.INSTANCE;
    }

    public final <C> m andThen(m r5) {
        return doAndThen(r5);
    }

    @Override // java.util.function.Function
    @Deprecated
    public final Object apply(Object r5) {
        return convert(r5);
    }

    public final Object convert(Object r5) {
        return correctedDoForward(r5);
    }

    public Iterable<Object> convertAll(Iterable<Object> r5) {
        b0.n(r5, "fromIterable");
        return new l(this, r5);
    }

    public Object correctedDoBackward(Object r5) {
        if (this.handleNullAutomatically == false) goto L9;
        if (r5 != null) goto L6;
        return null;
    L6:
        Object r10 = doBackward(r5);
        r10.getClass();
        return r10;
    L9:
        return doBackward(r5);
    }

    public Object correctedDoForward(Object r5) {
        if (this.handleNullAutomatically == false) goto L9;
        if (r5 != null) goto L6;
        return null;
    L6:
        Object r10 = doForward(r5);
        r10.getClass();
        return r10;
    L9:
        return doForward(r5);
    }

    public <C> m doAndThen(m r5) {
        r5.getClass();
        return new Converter$ConverterComposition(this, r5);
    }

    public abstract Object doBackward(Object r5);

    public abstract Object doForward(Object r5);

    @Override // com.google.common.base.q
    public boolean equals(Object r5) {
        return super.equals(r5);
    }

    public m reverse() {
        m r5 = this.f8665a;
        if (r5 != null) goto L6;
        Converter$ReverseConverter r10 = new Converter$ReverseConverter(this);
        this.f8665a = r10;
        return r10;
    L6:
        return r5;
    }
}
