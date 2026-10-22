package com.bytedance.crash.runtime.assembly;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.NpthBus;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.entity.CrashBody;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class CrashContextAssembly {

    @SuppressLint({"StaticFieldLeak"})
    private static volatile CrashContextAssembly sIns;
    private ActivityDataManager mActivityDataManager;
    private BatteryWatcher mBatteryWatcher;
    private final Context mContext;
    private final Map<CrashType, BaseAssembly> mCrashAssemblyMap;

    /* JADX INFO: renamed from: com.bytedance.crash.runtime.assembly.CrashContextAssembly$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$crash$CrashType = null;

        static {
            int[] r10 = new int[CrashType.values().length];
            $SwitchMap$com$bytedance$crash$CrashType = r10;
            r10[CrashType.JAVA.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
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

    private CrashContextAssembly(@NonNull Context r10) {
        this.mCrashAssemblyMap = new HashMap();
        this.mContext = r10;
        this.mActivityDataManager = ActivityDataManager.getInstance();     // Catch: Throwable -> L5
        this.mBatteryWatcher = new BatteryWatcher(r10);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        NpthMonitor.reportInnerException(th);
    }

    @Nullable
    private BaseAssembly getAssembly(CrashType r10) {
        BaseAssembly r11 = this.mCrashAssemblyMap.get(r10);
        if (r11 == null) goto L6;
        return r11;
    L6:
        switch(AnonymousClass2.$SwitchMap$com$bytedance$crash$CrashType[r10.ordinal()]) {
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
        final CrashType r12 = CrashType.ENSURE;
        final Context r13 = this.mContext;
        final ActivityDataManager r14 = this.mActivityDataManager;
        final BatteryWatcher r15 = this.mBatteryWatcher;
        r11 = new AnonymousClass1(this, r12, r13, r14, r15);
        goto L15
    L9:
        r11 = new BaseCrashAssembly(CrashType.GAME, this.mContext, this.mActivityDataManager, this.mBatteryWatcher);
        goto L15
    L10:
        r11 = new BaseCrashAssembly(CrashType.DART, this.mContext, this.mActivityDataManager, this.mBatteryWatcher);
        goto L15
    L11:
        r11 = new BaseCrashAssembly(CrashType.ANR, this.mContext, this.mActivityDataManager, this.mBatteryWatcher);
        goto L15
    L12:
        r11 = new NativeCrashAssembly(this.mContext, this.mActivityDataManager, this.mBatteryWatcher);
        goto L15
    L13:
        r11 = new JavaCrashAssembly(this.mContext, this.mActivityDataManager, this.mBatteryWatcher, true);
        goto L15
    L14:
        r11 = new JavaCrashAssembly(this.mContext, this.mActivityDataManager, this.mBatteryWatcher, false);
    L15:
        if (r11 == null) goto L17;
        this.mCrashAssemblyMap.put(r10, r11);
    L17:
        return r11;
    }

    public static CrashContextAssembly getInstance() {
        if (sIns != null) goto L10;
        Context r10 = NpthBus.getApplicationContext();
        if (r10 == null) goto L8;
        sIns = new CrashContextAssembly(r10);
        goto L10
    L8:
        throw new IllegalArgumentException("NpthBus not init");
    L10:
        return sIns;
    }

    public CrashBody assemblyCrash(CrashType r10, CrashBody r11) {
        return assemblyCrash(r10, r11, null, false);
    }

    public CrashBody assemblyCrash(CrashType r10, CrashBody r11, @Nullable BaseAssembly.AssemblyCallback r12, boolean r13) {
        if (r10 != null) goto L4;
        return r11;
    L4:
        BaseAssembly r14 = getAssembly(r10);
        if (r14 != null) goto L7;
        return r11;
    L7:
        return r14.assemblyCrashBody(r11, r12, r13);
    }
}
