package org.apache.commons.math3.geometry.euclidean.oned;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.util.Locale;
import org.apache.commons.math3.geometry.Vector;
import org.apache.commons.math3.geometry.VectorFormat;
import org.apache.commons.math3.util.CompositeFormat;

/* JADX INFO: loaded from: classes6.dex */
public class Vector1DFormat extends VectorFormat<Euclidean1D> {
    public Vector1DFormat() {
        super("{", "}", "; ", CompositeFormat.getDefaultNumberFormat());
    }

    public Vector1DFormat(NumberFormat r4) {
        super("{", "}", "; ", r4);
    }

    public static Vector1DFormat getInstance() {
        return getInstance(Locale.getDefault());
    }

    public static Vector1DFormat getInstance(Locale r1) {
        return new Vector1DFormat(CompositeFormat.getDefaultNumberFormat(r1));
    }

    @Override // org.apache.commons.math3.geometry.VectorFormat
    public StringBuffer format(Vector<Euclidean1D> r4, StringBuffer r5, FieldPosition r6) {
        return format(r5, r6, new double[]{((Vector1D) ZeusTransformUtils.preCheckCast((Vector) ZeusTransformUtils.wrapperContextForParams(r4, Vector.class, "com.obric.memorydata.plugin"), Vector1D.class, "com.obric.memorydata.plugin")).getX()});
    }
}
