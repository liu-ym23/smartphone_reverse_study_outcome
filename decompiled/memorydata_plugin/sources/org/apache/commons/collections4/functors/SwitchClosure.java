package org.apache.commons.collections4.functors;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.Predicate;

/* JADX INFO: loaded from: classes6.dex */
public class SwitchClosure<E> implements Serializable, Closure<E> {
    private static final long serialVersionUID = 3518477308466486130L;
    private final Closure<? super E>[] iClosures;
    private final Closure<? super E> iDefault;
    private final Predicate<? super E>[] iPredicates;

    private SwitchClosure(boolean r3, Predicate<? super E>[] r4, Closure<? super E>[] r5, Closure<? super E> r6) {
        Closure<? super E> r7 = (Closure) ZeusTransformUtils.wrapperContextForParams(r6, Closure.class, "com.obric.memorydata.plugin");
        if (r3 == false) goto L5;
        r4 = FunctorUtils.copy(r4);
    L5:
        this.iPredicates = r4;
        if (r3 == false) goto L8;
        r5 = FunctorUtils.copy(r5);
    L8:
        this.iClosures = r5;
        if (r7 != null) goto L11;
        r7 = NOPClosure.nopClosure();
    L11:
        this.iDefault = r7;
    }

    public SwitchClosure(Predicate<? super E>[] r3, Closure<? super E>[] r4, Closure<? super E> r5) {
        this(true, r3, r4, (Closure) ZeusTransformUtils.wrapperContextForParams(r5, Closure.class, "com.obric.memorydata.plugin"));
    }

    public static <E> Closure<E> switchClosure(Map<Predicate<E>, Closure<E>> r9) {
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r10, "The predicate and closure map must not be null");
        Closure<E> r0 = (Closure) ZeusTransformUtils.preCheckCast(r10.remove(null), Closure.class, "com.obric.memorydata.plugin");
        int r2 = r10.size();
        if (r2 != 0) goto L7;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return NOPClosure.nopClosure();
    L7:
        Closure[] r3 = new Closure[r2];
        Predicate[] r4 = new Predicate[r2];
        Iterator<E> r11 = r10.entrySet().iterator();
        int r5 = 0;
    L9:
        if (r11.hasNext() == false) goto L12;
        Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r11.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r4[r5] = (Predicate) ZeusTransformUtils.preCheckCast(r6.getKey(), Predicate.class, "com.obric.memorydata.plugin");
        r3[r5] = (Closure) ZeusTransformUtils.preCheckCast(r6.getValue(), Closure.class, "com.obric.memorydata.plugin");
        r5 = r5 + 1;
        goto L9
    L12:
        return new SwitchClosure(false, r4, r3, r0);
    }

    public static <E> Closure<E> switchClosure(Predicate<? super E>[] r2, Closure<? super E>[] r3, Closure<? super E> r4) {
        Closure<E> r5 = (Closure) ZeusTransformUtils.wrapperContextForParams(r4, Closure.class, "com.obric.memorydata.plugin");
        FunctorUtils.validate(r2);
        FunctorUtils.validate(r3);
        if (r2.length != r3.length) goto L12;
        if (r2.length != 0) goto L10;
        if (r5 == null) goto L8;
        return r5;
    L8:
        return NOPClosure.nopClosure();
    L10:
        return new SwitchClosure(r2, r3, r5);
    L12:
        throw new IllegalArgumentException("The predicate and closure arrays must be the same size");
    }

    @Override // org.apache.commons.collections4.Closure
    public void execute(E r4) {
        int r0 = 0;
    L3:
        Predicate<? super E>[] r1 = this.iPredicates;
        if (r0 >= r1.length) goto L11;
        if (r1[r0].evaluate(r4) == true) goto L7;
        r0 = r0 + 1;
        goto L3
    L7:
        Closure<? super E> r3 = this.iClosures[r0];
    L8:
        r3.execute(r4);
        return;
    L11:
        r3 = this.iDefault;
        goto L8
    }

    public Closure<? super E>[] getClosures() {
        return FunctorUtils.copy(this.iClosures);
    }

    public Closure<? super E> getDefaultClosure() {
        return this.iDefault;
    }

    public Predicate<? super E>[] getPredicates() {
        return FunctorUtils.copy(this.iPredicates);
    }
}
