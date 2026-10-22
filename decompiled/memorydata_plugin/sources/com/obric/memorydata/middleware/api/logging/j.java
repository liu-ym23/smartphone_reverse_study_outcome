package com.obric.memorydata.middleware.api.logging;

import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.obric.memorydata.middleware.api.bdtracker.Tracker;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JB\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/middleware/api/logging/MainTraceReporter;", "", "<init>", "()V", "EVENT_NAME", "", "report", "", AILabCheckPermissionTask.KEY_SOURCE, MemoryInfoSectionEditActivity.EXTRA_KIND, "message", "event", "code", "context", "Lcom/obric/memorydata/middleware/api/logging/NormalizedLogContext;", "fields", "Lcom/obric/memorydata/middleware/api/logging/LogFields;", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f11623a = null;

    static {
        f11623a = new j();
    }

    private j() {
    }

    private static final void a(Function2 r2, Object r3, Object r4) {
        ((Function2) ZeusTransformUtils.wrapperContextForParams(r2, Function2.class, "com.obric.memorydata.plugin")).invoke(r3, r4);
    }

    public static /* synthetic */ void lambda$NJCukg953oN6YEl7XqGN62V2C3Y(Function2 r0, Object r1, Object r2) {
        a(r0, r1, r2);
    }

    public final boolean a(String r17, String r18, String r19, String r20, String r21, p r22, f r23) {
        Intrinsics.checkNotNullParameter(r17, AILabCheckPermissionTask.KEY_SOURCE);
        Intrinsics.checkNotNullParameter(r18, MemoryInfoSectionEditActivity.EXTRA_KIND);
        Intrinsics.checkNotNullParameter(r19, "message");
        Intrinsics.checkNotNullParameter(r20, "event");
        Intrinsics.checkNotNullParameter(r22, "context");
        Intrinsics.checkNotNullParameter(r23, "fields");
        if (i.f11621a.a() == true) goto L23;
        return false;
    L23:
        JSONObject r11 = new JSONObject();     // Catch: Exception -> L21
        JSONObject r13 = new JSONObject();     // Catch: Exception -> L21
        Map<String, String> r10 = r23.a();     // Catch: Exception -> L21
        final Function2 r12 = (Function2) ZeusTransformUtils.preCheckCast(new MainTraceReporter$report$1(r13), Function2.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L21
        r10.forEach(new $$Lambda$j$NJCukg953oN6YEl7XqGN62V2C3Y(r12));     // Catch: Exception -> L21
        r11.put("fields", r13.toString());     // Catch: Exception -> L21
        r11.put(MemoryInfoSectionEditActivity.EXTRA_KIND, r18);     // Catch: Exception -> L21
        r11.put(AILabCheckPermissionTask.KEY_SOURCE, r17);     // Catch: Exception -> L21
        String r1 = r22.a();     // Catch: Exception -> L21
        String r4 = "";
        if (r1 != null) goto L9;
        r1 = "";
    L9:
        r11.put("biz", r1);     // Catch: Exception -> L21
        String r2 = r22.b();     // Catch: Exception -> L21
        if (r2 != null) goto L12;
        r2 = "";
    L12:
        r11.put("trace", r2);     // Catch: Exception -> L21
        String r3 = r22.c();     // Catch: Exception -> L21
        if (r3 != null) goto L15;
        r3 = "";
    L15:
        r11.put("stage", r3);     // Catch: Exception -> L21
        r11.put("event", r20);     // Catch: Exception -> L21
        if (r21 == null) goto L19;
        r4 = r21;
    L19:
        r11.put("code", r4);     // Catch: Exception -> L21
        r11.put("message", r19);     // Catch: Exception -> L21
        Tracker.INSTANCE.reportEvent("memory_main_trace_event", r11);     // Catch: Exception -> L21
        return true;
    L21:
        return false;
    }
}
