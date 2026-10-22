package nuc;

import java.util.Collection;
import java.util.Iterator;
import juc.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class w<E, C extends Collection<? extends E>, B> extends v<E, C, B> {
    public w(d<E> r2) {
        Intrinsics.checkNotNullParameter(r2, "element");
        super(r2);
    }

    @Override // nuc.a
    public final Iterator d(Object r2) {
        Collection r3 = (Collection) r2;
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return r3.iterator();
    }

    @Override // nuc.a
    public final int e(Object r2) {
        Collection r3 = (Collection) r2;
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return r3.size();
    }
}
