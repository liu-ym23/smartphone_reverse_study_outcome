package org.bouncycastle.math.ec.endo;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.PreCompInfo;

/* JADX INFO: loaded from: classes7.dex */
public class EndoPreCompInfo implements PreCompInfo {
    protected ECEndomorphism endomorphism;
    protected ECPoint mappedPoint;

    public EndoPreCompInfo() {
    }

    public ECEndomorphism getEndomorphism() {
        return this.endomorphism;
    }

    public ECPoint getMappedPoint() {
        return this.mappedPoint;
    }

    public void setEndomorphism(ECEndomorphism r3) {
        this.endomorphism = (ECEndomorphism) ZeusTransformUtils.wrapperContextForParams(r3, ECEndomorphism.class, "com.obric.memorydata.plugin");
    }

    public void setMappedPoint(ECPoint r1) {
        this.mappedPoint = r1;
    }
}
