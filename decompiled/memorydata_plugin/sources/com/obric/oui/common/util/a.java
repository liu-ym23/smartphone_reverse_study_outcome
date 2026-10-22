package com.obric.oui.common.util;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a \u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¨\u0006\u0004"}, d2 = {"withSpringAccuracy", "Lcom/obric/common/oea/foundation/animation/spec/AnimationSpec;", "", LocationMonitorConst.ACCURACY, "OUI_standardRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class a {
    public static final com.obric.common.oea.foundation.animation.spec.a<Float> a(com.obric.common.oea.foundation.animation.spec.a<Float> r2, float r3) {
        com.obric.common.oea.foundation.animation.spec.a<Float> r4 = (com.obric.common.oea.foundation.animation.spec.a) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.common.oea.foundation.animation.spec.a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        if (ZeusTransformUtils.instanceOf(r4, com.obric.common.oea.foundation.animation.spec.spring.b.class) == false) goto L5;
        ((com.obric.common.oea.foundation.animation.spec.spring.b) ZeusTransformUtils.preCheckCast(r4, com.obric.common.oea.foundation.animation.spec.spring.b.class, "com.obric.memorydata.plugin")).a(r3);
    L5:
        return r4;
    }
}
