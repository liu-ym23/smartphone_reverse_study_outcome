package com.bytedance.crash.runtime.assembly;

import android.content.Context;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.entity.CrashBody;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class BaseCrashAssembly extends BaseAssembly {
    BaseCrashAssembly(CrashType r10, Context r11, ActivityDataManager r12, BatteryWatcher r13) {
        super(r10, r11, r12, r13);
    }

    @Override // com.bytedance.crash.runtime.assembly.BaseAssembly
    public CrashBody assemblyCrashBody(CrashBody r10) {
        return super.assemblyCrashBody(r10);
    }
}
