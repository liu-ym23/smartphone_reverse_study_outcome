package org.apache.commons.collections4.functors;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import org.apache.commons.collections4.Closure;

/* JADX INFO: loaded from: classes6.dex */
public class ChainedClosure<E> implements Serializable, Closure<E> {
    private static final long serialVersionUID = -3520677225766901240L;
    private final Closure<? super E>[] iClosures;

    private ChainedClosure(boolean r1, Closure<? super E>... r2) {
        if (r1 == false) goto L5;
        r2 = FunctorUtils.copy(r2);
    L5:
        this.iClosures = r2;
    }

    public ChainedClosure(Closure<? super E>... r2) {
        this(true, r2);
    }

    public static <E> Closure<E> chainedClosure(Collection<? extends Closure<? super E>> r6) {
        Collection r7 = (Collection) ZeusTransformUtils.wrapperContextForParams(r6, Collection.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r7, "Closure collection must not be null");
        if (r7.size() == 0) goto L5;
        Closure[] r0 = new Closure[r7.size()];
        Iterator<E> r8 = r7.iterator();
        int r3 = 0;
    L8:
        if (r8.hasNext() == false) goto L10;
        r0[r3] = (Closure) ZeusTransformUtils.preCheckCast(r8.next(), Closure.class, "com.obric.memorydata.plugin");
        r3 = r3 + 1;
        goto L8
    L10:
        FunctorUtils.validate(r0);
        return new ChainedClosure(false, r0);
    L5:
        return NOPClosure.nopClosure();
    }

    public static <E> Closure<E> chainedClosure(Closure<? super E>... r1) {
        FunctorUtils.validate(r1);
        if (r1.length != 0) goto L7;
        return NOPClosure.nopClosure();
    L7:
        return new ChainedClosure(r1);
    }

    @Override // org.apache.commons.collections4.Closure
    public void execute(E r4) {
        Closure<? super E>[] r3 = this.iClosures;
        int r0 = r3.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r3[r1].execute(r4);
        r1 = r1 + 1;
        goto L3
    }

    public Closure<? super E>[] getClosures() {
        return FunctorUtils.copy(this.iClosures);
    }
}
