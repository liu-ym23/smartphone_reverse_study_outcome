package org.apache.commons.collections4.functors;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: loaded from: classes6.dex */
public class ConstantTransformer<I, O> implements Serializable, Transformer<I, O> {
    public static final Transformer NULL_INSTANCE = null;
    private static final long serialVersionUID = 6374440726369055124L;
    private final O iConstant;

    static {
        NULL_INSTANCE = new ConstantTransformer(null);
    }

    public ConstantTransformer(O r1) {
        this.iConstant = r1;
    }

    public static <I, O> Transformer<I, O> constantTransformer(O r1) {
        if (r1 != null) goto L6;
        return nullTransformer();
    L6:
        return new ConstantTransformer(r1);
    }

    public static <I, O> Transformer<I, O> nullTransformer() {
        return NULL_INSTANCE;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ConstantTransformer.class) == true) goto L8;
        return false;
    L8:
        Object r6 = ((ConstantTransformer) ZeusTransformUtils.preCheckCast(r5, ConstantTransformer.class, "com.obric.memorydata.plugin")).getConstant();
        if (r6 == getConstant()) goto L16;
        if (r6 == null) goto L15;
        if (r6.equals(getConstant()) == false) goto L15;
        return true;
    L15:
        return false;
    L16:
        return true;
    }

    public O getConstant() {
        return this.iConstant;
    }

    public int hashCode() {
        if (getConstant() != null) goto L5;
        return -144463148;
    L5:
        return (-144463148) | getConstant().hashCode();
    }

    @Override // org.apache.commons.collections4.Transformer
    public O transform(I r1) {
        return this.iConstant;
    }
}
