package com.obric.aikernel.middleware.impl.npth;

import com.bytedance.crash.ICommonParams;
import com.bytedance.crash.Npth;
import com.obric.aikernel.middleware.api.appcontext.AppContext;
import com.obric.aikernel.middleware.api.log.AIKLog;
import com.obric.aikernel.middleware.api.npth.INpthInit;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes2.dex */
public final class NpthInit implements INpthInit {
    public static final NpthInit INSTANCE = null;
    public static final String TAG = "BdTrackerInitTask";
    private static volatile boolean inited;

    public static final class a implements ICommonParams {
        a() {
        }

        @Override // com.bytedance.crash.ICommonParams
        public Map<String, Object> getCommonParams() {
            HashMap r10 = new HashMap();
            AppContext r11 = AppContext.INSTANCE;
            r10.put("aid", Integer.valueOf(r11.getAid()));
            r10.put("channel", r11.getChannel());
            r10.put("app_version", r11.getVersionName());
            r10.put("version_code", String.valueOf(r11.getVersionCode()));
            r10.put("update_version_code", String.valueOf(r11.getUpdateVersionCode()));
            r10.put("release_build", r11.getBuildInfo());
            return r10;
        }

        @Override // com.bytedance.crash.ICommonParams
        public String getDeviceId() {
            return AppContext.INSTANCE.getServerDeviceId();
        }

        @Override // com.bytedance.crash.ICommonParams
        public List<String> getPatchInfo() {
            return CollectionsKt.emptyList();
        }

        @Override // com.bytedance.crash.ICommonParams
        public Map<String, Integer> getPluginInfo() {
            return MapsKt.emptyMap();
        }

        @Override // com.bytedance.crash.ICommonParams
        public String getSessionId() {
            return "";
        }

        @Override // com.bytedance.crash.ICommonParams
        public long getUserId() {
            return 0;
        }
    }

    static {
        INSTANCE = new NpthInit();
    }

    private NpthInit() {
    }

    private final void clearNpthCrashFileIfTooLarge() {
        File r10 = new File(AppContext.INSTANCE.getContext().getFilesDir().getAbsolutePath() + "/npth/crash");
        if (r10.exists() == true) goto L5;
        return;
    L5:
        if (r10.isDirectory() == true) goto L7;
        return;
    L7:
        if (SequencesKt.sumOfLong(SequencesKt.map(SequencesKt.filter(FilesKt.walkTopDown(r10), NpthInit$clearNpthCrashFileIfTooLarge$totalSize$1.INSTANCE), NpthInit$clearNpthCrashFileIfTooLarge$totalSize$2.INSTANCE)) <= 104857600) goto L16;
        File[] r11 = r10.listFiles();
        if (r11 == null) goto L17;
        int r12 = 0;
        int r13 = r11.length;
    L11:
        if (r12 >= r13) goto L18;
        File r14 = r11[r12];
        Intrinsics.checkNotNullExpressionValue(r14, "it");
        FilesKt.deleteRecursively(r14);
        r12 = r12 + 1;
        goto L11
    L18:
        return;
    L17:
        return;
    }

    @JvmStatic
    public static final NpthInit getInst() {
        return INSTANCE;
    }

    @Override // com.obric.aikernel.middleware.api.npth.INpthInit
    public synchronized void init() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (inited == false) goto L9;
        AIKLog.INSTANCE.w("BdTrackerInitTask", "npth already inited, ignore this request.");     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L9:
        Npth.setOpenNewAnrMonitor(true);     // Catch: Throwable -> L12
        AppContext r10 = AppContext.INSTANCE;     // Catch: Throwable -> L12
        Npth.init(r10.getApplication(), new a(), true, true, true);     // Catch: Throwable -> L12
        Npth.getConfigManager().setDebugMode(r10.isDebug());     // Catch: Throwable -> L12
        inited = true;     // Catch: Throwable -> L12
        clearNpthCrashFileIfTooLarge();     // Catch: Throwable -> L12
        monitor-exit(this);
    }
}
