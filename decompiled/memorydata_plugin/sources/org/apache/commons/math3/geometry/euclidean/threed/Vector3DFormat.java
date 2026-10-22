package org.apache.commons.math3.geometry.euclidean.threed;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.util.Locale;
import org.apache.commons.math3.geometry.Vector;
import org.apache.commons.math3.geometry.VectorFormat;
import org.apache.commons.math3.util.CompositeFormat;

/* JADX INFO: loaded from: classes6.dex */
public class Vector3DFormat extends VectorFormat<Euclidean3D> {
    public Vector3DFormat() {
        super("{", "}", "; ", CompositeFormat.getDefaultNumberFormat());
    }

    public Vector3DFormat(NumberFormat r4) {
        super("{", "}", "; ", r4);
    }

    public static Vector3DFormat getInstance() {
        return getInstance(Locale.getDefault());
    }

    public static Vector3DFormat getInstance(Locale r1) {
        return new Vector3DFormat(CompositeFormat.getDefaultNumberFormat(r1));
    }

    @Override // org.apache.commons.math3.geometry.VectorFormat
    public StringBuffer format(Vector<Euclidean3D> r5, StringBuffer r6, FieldPosition r7) {
        Vector3D r8 = (Vector3D) ZeusTransformUtils.preCheckCast((Vector) ZeusTransformUtils.wrapperContextForParams(r5, Vector.class, "com.obric.memorydata.plugin"), Vector3D.class, "com.obric.memorydata.plugin");
        return format(r6, r7, new double[]{r8.getX(), r8.getY(), r8.getZ()});
    }
}
