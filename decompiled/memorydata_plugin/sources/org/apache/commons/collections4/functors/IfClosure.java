package org.apache.commons.collections4.functors;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Objects;
import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.Predicate;

/* JADX INFO: loaded from: classes6.dex */
public class IfClosure<E> implements Serializable, Closure<E> {
    private static final long serialVersionUID = 3518477308466486130L;
    private final Closure<? super E> iFalseClosure;
    private final Predicate<? super E> iPredicate;
    private final Closure<? super E> iTrueClosure;

    public IfClosure(Predicate<? super E> r3, Closure<? super E> r4) {
        this((Predicate) ZeusTransformUtils.wrapperContextForParams(r3, Predicate.class, "com.obric.memorydata.plugin"), (Closure) ZeusTransformUtils.wrapperContextForParams(r4, Closure.class, "com.obric.memorydata.plugin"), NOPClosure.nopClosure());
    }

    public IfClosure(Predicate<? super E> r3, Closure<? super E> r4, Closure<? super E> r5) {
        Predicate<? super E> r6 = (Predicate) ZeusTransformUtils.wrapperContextForParams(r3, Predicate.class, "com.obric.memorydata.plugin");
        Closure<? super E> r7 = (Closure) ZeusTransformUtils.wrapperContextForParams(r4, Closure.class, "com.obric.memorydata.plugin");
        Closure<? super E> r8 = (Closure) ZeusTransformUtils.wrapperContextForParams(r5, Closure.class, "com.obric.memorydata.plugin");
        this.iPredicate = r6;
        this.iTrueClosure = r7;
        this.iFalseClosure = r8;
    }

    public static <E> Closure<E> ifClosure(Predicate<? super E> r2, Closure<? super E> r3) {
        return ifClosure((Predicate) ZeusTransformUtils.wrapperContextForParams(r2, Predicate.class, "com.obric.memorydata.plugin"), (Closure) ZeusTransformUtils.wrapperContextForParams(r3, Closure.class, "com.obric.memorydata.plugin"), NOPClosure.nopClosure());
    }

    public static <E> Closure<E> ifClosure(Predicate<? super E> r2, Closure<? super E> r3, Closure<? super E> r4) {
        Predicate r5 = (Predicate) ZeusTransformUtils.wrapperContextForParams(r2, Predicate.class, "com.obric.memorydata.plugin");
        Closure r6 = (Closure) ZeusTransformUtils.wrapperContextForParams(r3, Closure.class, "com.obric.memorydata.plugin");
        Closure r7 = (Closure) ZeusTransformUtils.wrapperContextForParams(r4, Closure.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r5, "Predicate must not be null");
        if (r6 == null) goto L8;
        if (r7 == null) goto L8;
        return new IfClosure(r5, r6, r7);
    L8:
        throw new NullPointerException("Closures must not be null");
    }

    @Override // org.apache.commons.collections4.Closure
    public void execute(E r2) {
        if (this.iPredicate.evaluate(r2) == false) goto L5;
        Closure<? super E> r1 = this.iTrueClosure;
    L6:
        r1.execute(r2);
        return;
    L5:
        r1 = this.iFalseClosure;
        goto L6
    }

    public Closure<? super E> getFalseClosure() {
        return this.iFalseClosure;
    }

    public Predicate<? super E> getPredicate() {
        return this.iPredicate;
    }

    public Closure<? super E> getTrueClosure() {
        return this.iTrueClosure;
    }
}
