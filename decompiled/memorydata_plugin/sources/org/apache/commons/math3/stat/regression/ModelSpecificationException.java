package org.apache.commons.math3.stat.regression;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.Localizable;

/* JADX INFO: loaded from: classes6.dex */
public class ModelSpecificationException extends MathIllegalArgumentException {
    private static final long serialVersionUID = 4206514456095401070L;

    public ModelSpecificationException(Localizable r3, Object... r4) {
        super((Localizable) ZeusTransformUtils.wrapperContextForParams(r3, Localizable.class, "com.obric.memorydata.plugin"), r4);
    }
}
