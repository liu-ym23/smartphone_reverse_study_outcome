package com.google.common.base;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
final class FunctionalEquivalence<F, T> extends Equivalence<F> implements Serializable {
    private static final long serialVersionUID = 0;
    private final g<? super F, ? extends T> function;
    private final Equivalence<T> resultEquivalence;

    FunctionalEquivalence(g<? super F, ? extends T> r3, Equivalence<T> r4) {
        this.function = (g) ZeusTransformUtils.preCheckCast(n.a((g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.memorydata.plugin")), g.class, "com.obric.memorydata.plugin");
        this.resultEquivalence = (Equivalence) ZeusTransformUtils.preCheckCast(n.a(r4), Equivalence.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.common.base.Equivalence
    public boolean doEquivalent(F r3, F r4) {
        return this.resultEquivalence.equivalent(this.function.apply(r3), this.function.apply(r4));
    }

    @Override // com.google.common.base.Equivalence
    public int doHash(F r2) {
        return this.resultEquivalence.hash(this.function.apply(r2));
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, FunctionalEquivalence.class) == false) goto L14;
        FunctionalEquivalence r6 = (FunctionalEquivalence) ZeusTransformUtils.preCheckCast(r5, FunctionalEquivalence.class, "com.obric.memorydata.plugin");
        if (this.function.equals(r6.function) == false) goto L13;
        if (this.resultEquivalence.equals(r6.resultEquivalence) == false) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }

    public int hashCode() {
        return k.a(new Object[]{this.function, this.resultEquivalence});
    }

    public String toString() {
        return this.resultEquivalence + ".onResultOf(" + this.function + ")";
    }
}
