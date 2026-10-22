package org.apache.commons.math3.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes6.dex */
public class DefaultTransformer implements Serializable, NumberTransformer {
    private static final long serialVersionUID = 4019938025047800455L;

    public DefaultTransformer() {
    }

    public boolean equals(Object r1) {
        if (this != r1) goto L6;
        return true;
    L6:
        return ZeusTransformUtils.instanceOf(r1, DefaultTransformer.class);
    }

    public int hashCode() {
        return 401993047;
    }

    @Override // org.apache.commons.math3.util.NumberTransformer
    public double transform(Object r4) {
        if (r4 == null) goto L13;
        if (ZeusTransformUtils.instanceOf(r4, Number.class) == true) goto L7;
        return Double.parseDouble(r4.toString());
    L11:
        throw new MathIllegalArgumentException(LocalizedFormats.CANNOT_TRANSFORM_TO_DOUBLE, new Object[]{r4.toString()});
    L7:
        return ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).doubleValue();
    L13:
        throw new NullArgumentException(LocalizedFormats.OBJECT_TRANSFORMATION, new Object[0]);
    }
}
