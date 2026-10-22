package com.obric.aiproactive.impl.bridge;

import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0002J\u0018\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\nH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/aiproactive/impl/bridge/ArtifactResourceBridge;", "", "store", "Lcom/obric/aiproactive/impl/bridge/ArtifactResourceStore;", "<init>", "(Lcom/obric/aiproactive/impl/bridge/ArtifactResourceStore;)V", "handle", "", "requestJson", "handleMaterialize", "Lcom/obric/aiproactive/impl/bridge/ArtifactStoreResult;", "runId", "payload", "Lorg/json/JSONObject;", "parseCommittedLocators", "", ChatMessage.TYPE_RESPONSE, "result", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f6397a;

    public c(d r2) {
        Intrinsics.checkNotNullParameter(r2, "store");
        this.f6397a = r2;
    }

    private final f a(String r22, JSONObject r23) {
        JSONObject r2 = r23.optJSONObject(AILabCheckPermissionTask.KEY_SOURCE);
        if (r2 == null) goto L5;
        JSONObject r3 = r23.optJSONObject("metadata");
        if (r3 == null) goto L9;
        String r4 = r2.optString(MemoryInfoSectionEditActivity.EXTRA_KIND);
        if (Intrinsics.areEqual(r4, "shell_exported_file") == false) goto L18;
        d r0 = this.f6397a;
        String r13 = r23.optString("artifact_id");
        Intrinsics.checkNotNullExpressionValue(r13, "optString(...)");
        String r14 = r2.optString("locator");
        Intrinsics.checkNotNullExpressionValue(r14, "optString(...)");
        String r15 = r2.optString("shell_task_id");
        Intrinsics.checkNotNullExpressionValue(r15, "optString(...)");
        String r1 = r3.optString(Api.KEY_DISPLAY_NAME);
        Intrinsics.checkNotNullExpressionValue(r1, "optString(...)");
        String r5 = r3.optString("declared_mime_type");
        Intrinsics.checkNotNullExpressionValue(r5, "optString(...)");
        Long r18 = e.a(r3, "declared_size_bytes");
        String r6 = r3.optString("artifact_type_hint");
        Intrinsics.checkNotNull(r6);
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L22;
        r6 = null;
    L22:
        return r0.a(new b(r22, r13, r14, r15, r1, r5, r18, r6, e.a(r3, "duration_ms")));
    L18:
        if (Intrinsics.areEqual(r4, "remote_https") == false) goto L21;
        d r7 = this.f6397a;
        String r16 = r23.optString("artifact_id");
        Intrinsics.checkNotNullExpressionValue(r16, "optString(...)");
        String r17 = r2.optString("locator");
        Intrinsics.checkNotNullExpressionValue(r17, "optString(...)");
        String r19 = r2.optString("source_policy_key");
        Intrinsics.checkNotNullExpressionValue(r19, "optString(...)");
        String r8 = r3.optString("artifact_type_hint");
        Intrinsics.checkNotNullExpressionValue(r8, "optString(...)");
        return r7.a(new i(r22, r16, r17, r19, r8, e.a(r3, "duration_ms")));
    L21:
        return new f(false, "unsupported_source_kind", null, 0, 12, null);
    L9:
        return new f(false, "invalid_request", null, 0, 12, null);
    L5:
        return new f(false, "invalid_request", null, 0, 12, null);
    }

    private final String a(f r4) {
        JSONObject r3 = new JSONObject();
        r3.put("protocol_version", 1);
        r3.put("ok", r4.a());
        r3.put("error_code", r4.b());
        if (r4.a() == false) goto L8;
        JSONObject r0 = new JSONObject();
        JSONObject r1 = r4.c();
        if (r1 == null) goto L7;
        r0.put("artifact", r1);
    L7:
        r0.put("affected_count", r4.d());
        Unit r5 = Unit.INSTANCE;
        r3.put("data", r0);
    L8:
        String r6 = r3.toString();
        Intrinsics.checkNotNullExpressionValue(r6, "toString(...)");
        return r6;
    }

    private final Set<String> a(JSONObject r7) {
        JSONArray r6 = r7.optJSONArray("committed_locators");
        if (r6 != null) goto L6;
        return null;
    L6:
        if (r6.length() <= 100) goto L8;
        return null;
    L8:
        LinkedHashSet r0 = new LinkedHashSet();
        int r1 = r6.length();
        int r2 = 0;
    L10:
        if (r2 >= r1) goto L16;
        Object r4 = r6.opt(r2);
        if (ZeusTransformUtils.instanceOf(r4, String.class) == false) goto L13;
        ((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).add(r4);
        r2 = r2 + 1;
        goto L10
    L13:
        return null;
    L16:
        return (Set) ZeusTransformUtils.preCheckCast(r0, Set.class, "com.obric.memorydata.plugin");
    }

    public final String a(String r15) {
        Intrinsics.checkNotNullParameter(r15, "requestJson");
        if (r15.length() <= 65536) goto L42;
        f r16 = new f(false, "request_too_large", null, 0, 12, null);
    L6:
        return a(r16);
    L42:
        JSONObject r0 = new JSONObject(r15);     // Catch: JSONException -> L41
        if (r0.optInt("protocol_version", 0) == 1) goto L11;
        r16 = new f(false, "unsupported_protocol", null, 0, 12, null);
        goto L6
    L11:
        String r17 = r0.optString("run_id");
        JSONObject r1 = r0.optJSONObject("payload");
        if (r1 != null) goto L14;
        r1 = new JSONObject();
    L14:
        String r2 = r0.optString("operation");
        if (r2 == null) goto L38;
        int r3 = r2.hashCode();
        if (r3 == (-1553299734)) goto L31;
        if (r3 == (-86287720)) goto L27;
        if (r3 != 1732890317) goto L38;
        if (r2.equals("materialize") == false) goto L38;
        this.f6397a.a();
        Intrinsics.checkNotNull(r17);
        f r18 = a(r17, r1);
    L40:
        return a(r18);
    L27:
        if (r2.equals("sweep_orphans") == false) goto L38;
        r18 = this.f6397a.b();
        goto L40
    L31:
        if (r2.equals("finalize_run") == false) goto L38;
        Set<String> r4 = a(r1);
        if (r4 == null) goto L37;
        d r5 = this.f6397a;
        Intrinsics.checkNotNull(r17);
        r18 = r5.a(r17, r4);
        if (r18 != null) goto L40;
    L37:
        r18 = new f(false, "invalid_request", null, 0, 12, null);
    L38:
        r18 = new f(false, "unsupported_operation", null, 0, 12, null);
    L41:
        r16 = new f(false, "invalid_request", null, 0, 12, null);
        goto L6
    }
}
