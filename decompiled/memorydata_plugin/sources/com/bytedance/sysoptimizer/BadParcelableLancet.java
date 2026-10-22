package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Bundle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import me.ele.lancet.base.Origin;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class BadParcelableLancet {
    public BadParcelableLancet() {
    }

    @Proxy("getBundleExtra")
    @TargetClass("android.content.Intent")
    public Bundle getBundleExtra(String r3) {
        Bundle r2 = (Bundle) ZeusTransformUtils.preCheckCast(Origin.call(), Bundle.class, "com.obric.memorydata.plugin");
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(BadParcelableCrashOptimizer.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L6;
        if (r4 == null) goto L6;
        r2.setClassLoader(r4.getClassLoader());
    L6:
        return r2;
    }
}
