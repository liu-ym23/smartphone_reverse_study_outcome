package kotlinx.coroutines;

import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a0 extends AbstractCoroutineContextElement {
    public static final a b = null;
    public final String a;

    public static final class a implements CoroutineContext.Key<a0> {
        public a() {
        }
    }

    static {
        b = new a();
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof a0) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((a0) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "CoroutineName(" + this.a + ')';
    }

    public a0(String r2) {
        super(b);
        this.a = r2;
    }
}
