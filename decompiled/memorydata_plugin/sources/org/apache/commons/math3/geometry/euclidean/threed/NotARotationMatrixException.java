package org.apache.commons.math3.geometry.euclidean.threed;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.Localizable;

/* JADX INFO: loaded from: classes6.dex */
public class NotARotationMatrixException extends MathIllegalArgumentException {
    private static final long serialVersionUID = 5647178478658937642L;

    public NotARotationMatrixException(Localizable r3, Object... r4) {
        super((Localizable) ZeusTransformUtils.wrapperContextForParams(r3, Localizable.class, "com.obric.memorydata.plugin"), r4);
    }
}
