package com.bytedance.crash.runtime.assembly;

import android.content.Context;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.entity.CrashBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
class NativeCrashAssembly extends BaseAssembly {
    NativeCrashAssembly(Context r3, ActivityDataManager r4, BatteryWatcher r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        super(CrashType.NATIVE, r6, r4, r5);
    }

    @Override // com.bytedance.crash.runtime.assembly.BaseAssembly
    public CrashBody assemblyCrashBodyInner(int r1, CrashBody r2) {
        return super.assemblyCrashBodyInner(r1, r2);
    }
}
