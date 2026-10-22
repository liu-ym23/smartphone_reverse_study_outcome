package com.obric.aiproactive.impl.spell;

import android.os.Bundle;
import com.obric.memorydata.task.impl.TaskRequest;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0015\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\u000bJ\u001d\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0000¢\u0006\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/obric/aiproactive/impl/spell/SpellProactiveRequestFactory;", "", "<init>", "()V", "build", "Lcom/obric/memorydata/task/impl/TaskRequest;", "operation", "", "extras", "Landroid/os/Bundle;", "resolvePackageName", "resolvePackageName$ai_proactive_impl_obricRelease", "buildInput", "Lorg/json/JSONObject;", "buildInput$ai_proactive_impl_obricRelease", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f6519a = null;

    static {
        f6519a = new c();
    }

    private c() {
    }

    public final TaskRequest a(String r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "operation");
        Intrinsics.checkNotNullParameter(r3, "extras");
        JSONObject r4 = b(r2, r3);
        return (TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder(a(r2)).setExecuteImmediately(true), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setPriority(10), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setInputParam(r4), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin");
    }

    public final String a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "operation");
        if (Intrinsics.areEqual(r1, "upsert_trigger") == false) goto L5;
        return "spell_proactive_eca_trigger";
    L5:
        return "spell_proactive_memory";
    }

    public final JSONObject b(String r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "operation");
        Intrinsics.checkNotNullParameter(r5, "extras");
        JSONObject r0 = new JSONObject();
        r0.put("operation", r4);
        switch(r4.hashCode()) {
            case -2131051939: goto L22;
            case -537343635: goto L19;
            case 198276776: goto L15;
            case 708472570: goto L12;
            case 965667071: goto L9;
            case 1195955312: goto L6;
            default: goto L28;
        };
    L6:
        if (r4.equals("query_events") == false) goto L28;
        r0.put("start_time_ms", r5.getLong("start_time_ms"));
        r0.put("end_time_ms", r5.getLong("end_time_ms"));
    L26:
        return r0;
    L9:
        if (r4.equals("invoke_tool") == false) goto L28;
        r0.put("tool_name", r5.getString("tool_name"));
        String r3 = "arguments_json";
    L17:
        r0.put(r3, r5.getString(r3));
        goto L26
    L12:
        if (r4.equals("list_tools") == false) goto L28;
    L15:
        if (r4.equals("upsert_trigger") == false) goto L28;
        r3 = "condition_json";
        goto L17
    L19:
        if (r4.equals("get_user_insight") == false) goto L28;
    L22:
        if (r4.equals("get_realtime_status") == false) goto L28;
        ArrayList<String> r6 = r5.getStringArrayList("keys");
        if (r6 == null) goto L26;
        r0.put("keys", new JSONArray((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin")));
    L28:
        throw new IllegalArgumentException("unsupported operation=" + r4);
    }
}
