package com.bytedance.crash.runtime.assembly;

import android.content.Context;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.entity.CrashBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
class JavaCrashAssembly extends BaseAssembly {
    JavaCrashAssembly(Context r3, ActivityDataManager r4, BatteryWatcher r5, boolean r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (r6 == false) goto L5;
        CrashType r8 = CrashType.LAUNCH;
    L6:
        super(r8, r7, r4, r5);
        return;
    L5:
        r8 = CrashType.JAVA;
        goto L6
    }

    @Override // com.bytedance.crash.runtime.assembly.BaseAssembly
    public CrashBody assemblyCrashBodyInner(int r1, CrashBody r2) {
        return super.assemblyCrashBodyInner(r1, r2);
    }
}
