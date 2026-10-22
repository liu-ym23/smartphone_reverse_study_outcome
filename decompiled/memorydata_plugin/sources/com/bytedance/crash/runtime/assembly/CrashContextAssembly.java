package com.bytedance.crash.runtime.assembly;

import android.content.Context;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.NpthBus;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.entity.CrashBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class CrashContextAssembly {
    private static volatile CrashContextAssembly sIns;
    private ActivityDataManager mActivityDataManager;
    private BatteryWatcher mBatteryWatcher;
    private final Context mContext;
    private final Map<CrashType, BaseAssembly> mCrashAssemblyMap;

    /* JADX INFO: renamed from: com.bytedance.crash.runtime.assembly.CrashContextAssembly$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$crash$CrashType = null;

        static {
            int[] r0 = new int[CrashType.values().length];
            $SwitchMap$com$bytedance$crash$CrashType = r0;
            r0[CrashType.JAVA.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            $SwitchMap$com$bytedance$crash$CrashType[CrashType.LAUNCH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            $SwitchMap$com$bytedance$crash$CrashType[CrashType.NATIVE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            $SwitchMap$com$bytedance$crash$CrashType[CrashType.ANR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            $SwitchMap$com$bytedance$crash$CrashType[CrashType.DART.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            $SwitchMap$com$bytedance$crash$CrashType[CrashType.GAME.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            $SwitchMap$com$bytedance$crash$CrashType[CrashType.ENSURE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    private CrashContextAssembly(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        this.mCrashAssemblyMap = new HashMap();
        Context r5 = ZeusTransformUtils.wrapperContext(r4, "com.obric.memorydata.plugin");
        this.mContext = r5;
        this.mActivityDataManager = ActivityDataManager.getInstance();     // Catch: Throwable -> L5
        this.mBatteryWatcher = new BatteryWatcher(r5);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        NpthMonitor.reportInnerException(th);
    }

    private BaseAssembly getAssembly(CrashType r9) {
        BaseAssembly r0 = (BaseAssembly) ZeusTransformUtils.preCheckCast(this.mCrashAssemblyMap.get(r9), BaseAssembly.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L6;
        return r0;
    L6:
        switch(AnonymousClass2.$SwitchMap$com$bytedance$crash$CrashType[r9.ordinal()]) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            default: goto L15;
        };
    L8:
        final CrashType r4 = CrashType.ENSURE;
        final Context r5 = this.mContext;
        final ActivityDataManager r6 = this.mActivityDataManager;
        final BatteryWatcher r7 = this.mBatteryWatcher;
        r0 = new AnonymousClass1(this, r4, r5, r6, r7);
        goto L15
    L9:
        r0 = new BaseCrashAssembly(CrashType.GAME, this.mContext, this.mActivityDataManager, this.mBatteryWatcher);
        goto L15
    L10:
        r0 = new BaseCrashAssembly(CrashType.DART, this.mContext, this.mActivityDataManager, this.mBatteryWatcher);
        goto L15
    L11:
        r0 = new BaseCrashAssembly(CrashType.ANR, this.mContext, this.mActivityDataManager, this.mBatteryWatcher);
        goto L15
    L12:
        r0 = new NativeCrashAssembly(this.mContext, this.mActivityDataManager, this.mBatteryWatcher);
        goto L15
    L13:
        r0 = new JavaCrashAssembly(this.mContext, this.mActivityDataManager, this.mBatteryWatcher, true);
        goto L15
    L14:
        r0 = new JavaCrashAssembly(this.mContext, this.mActivityDataManager, this.mBatteryWatcher, false);
    L15:
        if (r0 == null) goto L17;
        this.mCrashAssemblyMap.put(r9, r0);
    L17:
        return r0;
    }

    public static CrashContextAssembly getInstance() {
        if (sIns != null) goto L10;
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(NpthBus.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L8;
        sIns = new CrashContextAssembly(r0);
        goto L10
    L8:
        throw new IllegalArgumentException("NpthBus not init");
    L10:
        return sIns;
    }

    public CrashBody assemblyCrash(CrashType r3, CrashBody r4) {
        return assemblyCrash(r3, r4, null, false);
    }

    public CrashBody assemblyCrash(CrashType r3, CrashBody r4, BaseAssembly.AssemblyCallback r5, boolean r6) {
        BaseAssembly.AssemblyCallback r7 = (BaseAssembly.AssemblyCallback) ZeusTransformUtils.wrapperContextForParams(r5, BaseAssembly.AssemblyCallback.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
        return r4;
    L5:
        BaseAssembly r2 = getAssembly(r3);
        if (r2 != null) goto L8;
        return r4;
    L8:
        return r2.assemblyCrashBody(r4, r7, r6);
    }
}
