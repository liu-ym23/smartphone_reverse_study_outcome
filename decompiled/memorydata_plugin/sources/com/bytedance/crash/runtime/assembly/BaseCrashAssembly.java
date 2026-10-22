package com.bytedance.crash.runtime.assembly;

import android.content.Context;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.entity.CrashBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class BaseCrashAssembly extends BaseAssembly {
    BaseCrashAssembly(CrashType r3, Context r4, ActivityDataManager r5, BatteryWatcher r6) {
        super(r3, (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin"), r5, r6);
    }

    @Override // com.bytedance.crash.runtime.assembly.BaseAssembly
    public CrashBody assemblyCrashBody(CrashBody r1) {
        return super.assemblyCrashBody(r1);
    }
}
