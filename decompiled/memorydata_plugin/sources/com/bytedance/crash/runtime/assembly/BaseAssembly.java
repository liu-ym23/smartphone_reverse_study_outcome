package com.bytedance.crash.runtime.assembly;

import android.content.Context;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.ICommonParams;
import com.bytedance.crash.entity.CrashBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public abstract class BaseAssembly {
    public static final String INTERFACE_ERR_INFO = "Code err:\n";
    protected ICommonParams iCommonParams;
    protected ActivityDataManager mActivityDataManager;
    protected BatteryWatcher mBatteryWatcher;
    protected Context mContext;
    protected CrashType mCrashType;

    public interface AssemblyCallback {
        CrashBody afterAssembly(int r1, CrashBody r2, boolean r3);

        CrashBody beforeAssembly(int r1, CrashBody r2);

        void onException(Throwable r1);
    }

    BaseAssembly(CrashType r1, Context r2, ActivityDataManager r3, BatteryWatcher r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
    }

    CrashBody assemblyCrashBody(CrashBody r1) {
        return r1;
    }

    public CrashBody assemblyCrashBody(CrashBody r1, AssemblyCallback r2, boolean r3) {
        AssemblyCallback r0 = (AssemblyCallback) ZeusTransformUtils.wrapperContextForParams(r2, AssemblyCallback.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L5;
        return r1;
    L5:
        return new CrashBody();
    }

    CrashBody assemblyCrashBodyInner(int r1, CrashBody r2) {
        return r2;
    }
}
