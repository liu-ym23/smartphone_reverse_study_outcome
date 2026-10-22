package com.obric.aiproactive.impl.aidb;

import com.obric.memorydata.awareness.api.AwarenessManager;
import com.obric.memorydata.middleware.api.bdtracker.Tracker;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/aiproactive/impl/aidb/DefaultAiProactivePreferenceMutationEffects;", "Lcom/obric/aiproactive/impl/aidb/AiProactivePreferenceMutationEffects;", "<init>", "()V", "TAG", "", "notifyPreferencesUpdated", "", "reportManualPreferenceChanged", "change", "Lcom/obric/aiproactive/impl/aidb/ManualPreferenceChange;", "reportPreferenceAction", "preferenceId", "", "actionType", "preferenceType", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class o implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f6368a = null;

    static {
        f6368a = new o();
    }

    private o() {
    }

    @Override // com.obric.aiproactive.impl.aidb.j
    public void a() {
        b.f6306a.a((Collection) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf("ProactivePreference"), Collection.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.aiproactive.impl.aidb.j
    public void a(long r4, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "actionType");
        Intrinsics.checkNotNullParameter(r7, "preferenceType");
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L9
        o r3 = (o) ZeusTransformUtils.preCheckCast(this, o.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        Map<String, String> r5 = e.a(r4, r6, r7);     // Catch: Throwable -> L9
        JSONObject r8 = new JSONObject();     // Catch: Throwable -> L9
        Iterator<Map.Entry<String, String>> r9 = r5.entrySet().iterator();     // Catch: Throwable -> L9
    L5:
        if (r9.hasNext() == false) goto L7;
        Map.Entry r10 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        r8.put((String) ZeusTransformUtils.preCheckCast(r10.getKey(), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r10.getValue(), String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L9
        goto L5
    L7:
        RunLog.INSTANCE.debug("AiProactiveDbRepository", "[Tracker] event=preference_action params=" + r8);     // Catch: Throwable -> L9
        Tracker.INSTANCE.reportEvent("preference_action", r8);     // Catch: Throwable -> L9
        Object r11 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        Throwable r12 = Result.m1424exceptionOrNullimpl(r11);
        if (r12 == null) goto L18;
        RunLog.INSTANCE.warn("AiProactiveDbRepository", "[Tracker] report preference_action failed", r12);
        return;
    L18:
        return;
    L9:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r11 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    @Override // com.obric.aiproactive.impl.aidb.j
    public void a(s r8) {
        Intrinsics.checkNotNullParameter(r8, "change");
        AwarenessManager.INSTANCE.dispatchAwarenessEvent("ai_proactive_manual_preference_changed", i.a(r8.a(), "ProactivePreference", r8.b(), r8.c(), r8.d(), r8.e()));
    }
}
