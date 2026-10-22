package com.obric.memorydata.memory.ui.feedback;

import com.obric.memorydata.middleware.api.settings.SettingsManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007J\u0017\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0000¢\u0006\u0002\b\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/memory/ui/feedback/MemoryFeedbackOdpSetting;", "", "<init>", "()V", "KEY_IS_REPORT_ODP", "", "isEnabled", "", "settings", "Lorg/json/JSONObject;", "isEnabled$memory_obricRelease", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f10958a = null;

    static {
        f10958a = new l();
    }

    private l() {
    }

    public final boolean a() {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        Object r3 = Result.m1421constructorimpl(Boolean.valueOf(((l) ZeusTransformUtils.preCheckCast(this, l.class, "com.obric.memorydata.plugin")).a(SettingsManager.INSTANCE.getJson(SettingsManager.KEY_MEMORY_FEEDBACK_SETTINGS))));     // Catch: Throwable -> L5
    L8:
        if (Result.m1427isFailureimpl(r3) == false) goto L11;
        r3 = false;
    L11:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L5:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r3 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public final boolean a(JSONObject r2) {
        if (r2 != null) goto L5;
        return false;
    L5:
        return r2.optBoolean("isReportOdp", false);
    }
}
