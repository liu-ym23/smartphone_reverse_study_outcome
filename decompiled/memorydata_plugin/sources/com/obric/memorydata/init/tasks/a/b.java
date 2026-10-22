package com.obric.memorydata.init.tasks.a;

import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.settings.SettingsManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/init/tasks/platform/CloudConfigImpl;", "Lcom/obric/aiagent/platform/depend/ICloudConfig;", "<init>", "()V", "TAG", "", "getSettingsConfig", "Lorg/json/JSONObject;", "key", "init_task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b implements com.obric.aiagent.platform.a.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f9914b = null;

    static {
        f9914b = new b();
    }

    private b() {
    }

    @Override // com.obric.aiagent.platform.a.c
    public JSONObject a(String r7) {
        Intrinsics.checkNotNullParameter(r7, "key");
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L5
        b r6 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        JSONObject r8 = SettingsManager.INSTANCE.getJson(r7);     // Catch: Throwable -> L5
        RunLog.INSTANCE.debug("Memory_CloudConfigImpl", "key is " + r7 + ",jsonObject is " + r8);     // Catch: Throwable -> L5
        return r8;
    L5:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        Object r9 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        Throwable r4 = Result.m1424exceptionOrNullimpl(r9);
        if (r4 == null) goto L10;
        RunLog.INSTANCE.error("Memory_CloudConfigImpl", "getSettingsConfig failed, key=" + r7, r4);
    L10:
        if (Result.m1427isFailureimpl(r9) == false) goto L13;
        r9 = null;
    L13:
        return (JSONObject) ZeusTransformUtils.preCheckCast(r9, JSONObject.class, "com.obric.memorydata.plugin");
    }
}
