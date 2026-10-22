package com.bytedance.crash.runtime.assembly;

import android.content.Context;
import androidx.annotation.Nullable;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.ICommonParams;
import com.bytedance.crash.entity.CrashBody;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class BaseAssembly {
    public static final String INTERFACE_ERR_INFO = "Code err:\n";
    protected ICommonParams iCommonParams;
    protected ActivityDataManager mActivityDataManager;
    protected BatteryWatcher mBatteryWatcher;
    protected Context mContext;
    protected CrashType mCrashType;

    public interface AssemblyCallback {
        CrashBody afterAssembly(int r10, CrashBody r11, boolean r12);

        CrashBody beforeAssembly(int r10, CrashBody r11);

        void onException(Throwable r10);
    }

    BaseAssembly(CrashType r10, Context r11, ActivityDataManager r12, BatteryWatcher r13) {
    }

    CrashBody assemblyCrashBody(CrashBody r10) {
        return r10;
    }

    public CrashBody assemblyCrashBody(@Nullable CrashBody r10, @Nullable AssemblyCallback r11, boolean r12) {
        if (r10 == null) goto L4;
        return r10;
    L4:
        return new CrashBody();
    }

    CrashBody assemblyCrashBodyInner(int r10, CrashBody r11) {
        return r11;
    }
}
