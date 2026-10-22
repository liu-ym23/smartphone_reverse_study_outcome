package com.bytedance.crash.runtime.assembly;

import android.content.Context;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.entity.CrashBody;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
class JavaCrashAssembly extends BaseAssembly {
    JavaCrashAssembly(Context r10, ActivityDataManager r11, BatteryWatcher r12, boolean r13) {
        if (r13 == false) goto L4;
        CrashType r14 = CrashType.LAUNCH;
    L5:
        super(r14, r10, r11, r12);
        return;
    L4:
        r14 = CrashType.JAVA;
        goto L5
    }

    @Override // com.bytedance.crash.runtime.assembly.BaseAssembly
    public CrashBody assemblyCrashBodyInner(int r10, CrashBody r11) {
        return super.assemblyCrashBodyInner(r10, r11);
    }
}
