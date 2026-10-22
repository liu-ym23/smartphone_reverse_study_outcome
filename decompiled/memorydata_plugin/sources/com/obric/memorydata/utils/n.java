package com.obric.memorydata.utils;

import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/utils/ContextAwarenessObservationSettings;", "", "<init>", "()V", "TAG", "", "snapshot", "Lcom/obric/memorydata/utils/ContextAwarenessObservationSwitches;", "readEnabled", "", "key", AILabCheckPermissionTask.KEY_SOURCE, "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f13250a = null;

    static {
        f13250a = new n();
    }

    private n() {
    }

    private final boolean a(String r8, String r9) {
        return IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getBoolean(r8, false);
    L5:
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ContextObservationSettings", "[code=raw_observation_context_switch_read_failed] source=" + r9 + "; omit context", null, 4, null);     // Catch: Throwable -> L7
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
        return false;
    L7:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        return false;
    }

    public final o a() {
        return new o(a("context_awareness_location_enabled", "location"), a("context_awareness_motion_state_enabled", "motion_state"));
    }
}
