package com.bytedance.crash.runtime.assembly;

import android.content.Context;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.entity.CrashBody;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
class NativeCrashAssembly extends BaseAssembly {
    NativeCrashAssembly(Context r10, ActivityDataManager r11, BatteryWatcher r12) {
        super(CrashType.NATIVE, r10, r11, r12);
    }

    @Override // com.bytedance.crash.runtime.assembly.BaseAssembly
    public CrashBody assemblyCrashBodyInner(int r10, CrashBody r11) {
        return super.assemblyCrashBodyInner(r10, r11);
    }
}
