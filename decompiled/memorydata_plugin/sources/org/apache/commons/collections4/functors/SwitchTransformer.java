package org.apache.commons.collections4.functors;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: loaded from: classes6.dex */
public class SwitchTransformer<I, O> implements Serializable, Transformer<I, O> {
    private static final long serialVersionUID = -6404460890903469332L;
    private final Transformer<? super I, ? extends O> iDefault;
    private final Predicate<? super I>[] iPredicates;
    private final Transformer<? super I, ? extends O>[] iTransformers;

    private SwitchTransformer(boolean r3, Predicate<? super I>[] r4, Transformer<? super I, ? extends O>[] r5, Transformer<? super I, ? extends O> r6) {
        Transformer<? super I, ? extends O> r7 = (Transformer) ZeusTransformUtils.wrapperContextForParams(r6, Transformer.class, "com.obric.memorydata.plugin");
        if (r3 == false) goto L5;
        r4 = FunctorUtils.copy(r4);
    L5:
        this.iPredicates = r4;
        if (r3 == false) goto L8;
        r5 = FunctorUtils.copy(r5);
    L8:
        this.iTransformers = r5;
        if (r7 != null) goto L11;
        r7 = ConstantTransformer.nullTransformer();
    L11:
        this.iDefault = r7;
    }

    public SwitchTransformer(Predicate<? super I>[] r3, Transformer<? super I, ? extends O>[] r4, Transformer<? super I, ? extends O> r5) {
        this(true, r3, r4, (Transformer) ZeusTransformUtils.wrapperContextForParams(r5, Transformer.class, "com.obric.memorydata.plugin"));
    }

    public static <I, O> Transformer<I, O> switchTransformer(Map<? extends Predicate<? super I>, ? extends Transformer<? super I, ? extends O>> r9) {
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r10, "The predicate and transformer map must not be null");
        if (r10.size() == 0) goto L5;
        Transformer<I, O> r0 = (Transformer) ZeusTransformUtils.preCheckCast(r10.remove(null), Transformer.class, "com.obric.memorydata.plugin");
        int r2 = r10.size();
        if (r2 != 0) goto L11;
        if (r0 == null) goto L10;
        return r0;
    L10:
        return ConstantTransformer.nullTransformer();
    L11:
        Transformer[] r3 = new Transformer[r2];
        Predicate[] r4 = new Predicate[r2];
        Iterator r11 = r10.entrySet().iterator();
        int r5 = 0;
    L13:
        if (r11.hasNext() == false) goto L16;
        Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r11.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r4[r5] = (Predicate) ZeusTransformUtils.preCheckCast(r6.getKey(), Predicate.class, "com.obric.memorydata.plugin");
        r3[r5] = (Transformer) ZeusTransformUtils.preCheckCast(r6.getValue(), Transformer.class, "com.obric.memorydata.plugin");
        r5 = r5 + 1;
        goto L13
    L16:
        return new SwitchTransformer(false, r4, r3, r0);
    L5:
        return ConstantTransformer.nullTransformer();
    }

    public static <I, O> Transformer<I, O> switchTransformer(Predicate<? super I>[] r2, Transformer<? super I, ? extends O>[] r3, Transformer<? super I, ? extends O> r4) {
        Transformer<I, O> r5 = (Transformer) ZeusTransformUtils.wrapperContextForParams(r4, Transformer.class, "com.obric.memorydata.plugin");
        FunctorUtils.validate(r2);
        FunctorUtils.validate(r3);
        if (r2.length != r3.length) goto L12;
        if (r2.length != 0) goto L10;
        if (r5 == null) goto L8;
        return r5;
    L8:
        return ConstantTransformer.nullTransformer();
    L10:
        return new SwitchTransformer(r2, r3, r5);
    L12:
        throw new IllegalArgumentException("The predicate and transformer arrays must be the same size");
    }

    public Transformer<? super I, ? extends O> getDefaultTransformer() {
        return this.iDefault;
    }

    public Predicate<? super I>[] getPredicates() {
        return FunctorUtils.copy(this.iPredicates);
    }

    public Transformer<? super I, ? extends O>[] getTransformers() {
        return FunctorUtils.copy(this.iTransformers);
    }

    @Override // org.apache.commons.collections4.Transformer
    public O transform(I r4) {
        int r0 = 0;
    L3:
        Predicate<? super I>[] r1 = this.iPredicates;
        if (r0 >= r1.length) goto L11;
        if (r1[r0].evaluate(r4) == true) goto L7;
        r0 = r0 + 1;
        goto L3
    L7:
        Transformer<? super I, ? extends O> r3 = this.iTransformers[r0];
    L9:
        return r3.transform(r4);
    L11:
        r3 = this.iDefault;
        goto L9
    }
}
