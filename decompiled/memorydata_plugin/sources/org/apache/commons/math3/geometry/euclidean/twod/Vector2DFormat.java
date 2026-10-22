package org.apache.commons.math3.geometry.euclidean.twod;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.util.Locale;
import org.apache.commons.math3.geometry.Vector;
import org.apache.commons.math3.geometry.VectorFormat;
import org.apache.commons.math3.util.CompositeFormat;

/* JADX INFO: loaded from: classes6.dex */
public class Vector2DFormat extends VectorFormat<Euclidean2D> {
    public Vector2DFormat() {
        super("{", "}", "; ", CompositeFormat.getDefaultNumberFormat());
    }

    public Vector2DFormat(NumberFormat r4) {
        super("{", "}", "; ", r4);
    }

    public static Vector2DFormat getInstance() {
        return getInstance(Locale.getDefault());
    }

    public static Vector2DFormat getInstance(Locale r1) {
        return new Vector2DFormat(CompositeFormat.getDefaultNumberFormat(r1));
    }

    @Override // org.apache.commons.math3.geometry.VectorFormat
    public StringBuffer format(Vector<Euclidean2D> r5, StringBuffer r6, FieldPosition r7) {
        Vector2D r8 = (Vector2D) ZeusTransformUtils.preCheckCast((Vector) ZeusTransformUtils.wrapperContextForParams(r5, Vector.class, "com.obric.memorydata.plugin"), Vector2D.class, "com.obric.memorydata.plugin");
        return format(r6, r7, new double[]{r8.getX(), r8.getY()});
    }
}
