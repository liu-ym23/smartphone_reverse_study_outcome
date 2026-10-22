package com.obric.memorydata.middleware.impl.playground;

import androidx.core.app.NotificationCompat;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentParams;
import com.obric.capabilitykit.common.intent.SystemSkillParams;
import com.obric.memorydata.middleware.api.bridge.Response;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0016\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bH\u0002J\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u0011*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bH\u0002J\u000e\u0010\u0012\u001a\u0004\u0018\u00010\u000e*\u00020\bH\u0002¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/middleware/impl/playground/SkillAdapter;", "", "<init>", "()V", "getSkillList", "Lcom/obric/memorydata/middleware/api/bridge/Response;", "loadSkill", "skillId", "", "parseSkillList", "result", "Lcom/obric/memorydata/middleware/impl/playground/DispatchIntentResult;", "parseLoadedSkill", "optJSONObjectFromString", "Lorg/json/JSONObject;", ActivityLifecycle.NAME, "optJSONArrayFromValue", "Lorg/json/JSONArray;", "toJsonObjectOrNull", "Companion", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f11840a = null;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\b\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0018X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0018X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0018X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/obric/memorydata/middleware/impl/playground/SkillAdapter$Companion;", "", "<init>", "()V", "INTENT_COMPLEX_TASK_CONTEXT", "", "INTENT_SYSTEM_SKILL", "ACTION_LOAD_SKILL", "EXT", "SKIP_AUTHENTICATION", "ENABLE_SKILL", "MSG", "SKILL_LIST", "SKILL_LIST_RESPONSE", "SKILLS", "SKILL_ID", "DISPLAY_NAME", "DESCRIPTION", "RESULTS", "IS_SUCCESS", "CONTENT", "ERROR_CODE", "ERROR_MSG", "CODE_SUCCESS", "", "CODE_BAD_REQUEST", "CODE_DISPATCH_ERROR", "CODE_PROTOCOL_ERROR", "CODE_INTENT_ERROR", "TAG", "LOG_CODE_PAYLOAD_BUILD_FAILED", "LOG_CODE_RESULT_PARSE_FAILED", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f11840a = new a(null);
    }

    public n() {
    }

    private final Response a(b r20) {
        String r1 = r20.c();
        if (r1 == null) goto L33;
        JSONObject r2 = b(r1);
        if (r2 == null) goto L33;
        JSONArray r3 = b(r2, "o_skill_list");
        if (r3 != null) goto L16;
        JSONObject r4 = a(r2, NotificationCompat.CATEGORY_MESSAGE);
        if (r4 == null) goto L12;
        r3 = b(r4, "o_skill_list");
    L13:
        if (r3 != null) goto L16;
        return new Response(-4, "skill list result is missing o_skill_list", null, null, 12, null);
    L12:
        r3 = null;
    L16:
        JSONArray r0 = new JSONArray();
        int r5 = 0;
        int r6 = r3.length();
    L17:
        if (r5 >= r6) goto L31;
        JSONObject r7 = r3.optJSONObject(r5);
        if (r7 == null) goto L21;
        String r8 = r7.optString("skill_id");
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L26;
        r8 = null;
    L26:
        if (r8 == null) goto L28;
        r0.put(new JSONObject().put("skill_id", r8).put(Api.KEY_DISPLAY_NAME, r7.optString(Api.KEY_DISPLAY_NAME)).put("description", r7.optString("description")));
        r5 = r5 + 1;
        goto L17
    L28:
        return new Response(-4, "skill list item is missing skill_id", null, null, 12, null);
    L21:
        return new Response(-4, "skill list contains a non-object item", null, null, 12, null);
    L31:
        return new Response(0, "success", new JSONObject().put("skill_list", r0), null, 8, null);
    L33:
        return new Response(-4, "skill list result is not a JSON object", null, null, 12, null);
    }

    private final Response a(String r20, b r21) {
        String r1 = r21.c();
        if (r1 == null) goto L61;
        JSONObject r2 = b(r1);
        if (r2 == null) goto L61;
        JSONArray r3 = r2.optJSONArray("results");
        if (r3 == null) goto L10;
        boolean r4 = false;
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(RangesKt.until(0, r3.length()), Iterable.class, "com.obric.memorydata.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r7 = r5.iterator();
    L13:
        if (r7.hasNext() == false) goto L17;
        JSONObject r8 = r3.optJSONObject(((IntIterator) ZeusTransformUtils.preCheckCast(r7, IntIterator.class, "com.obric.memorydata.plugin")).nextInt());
        if (r8 == null) goto L13;
        r6.add(r8);
        goto L13
    L17:
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L18:
        String r10 = null;
        if (r9.hasNext() == false) goto L23;
        Object r11 = r9.next();
        if (Intrinsics.areEqual(((JSONObject) ZeusTransformUtils.preCheckCast(r11, JSONObject.class, "com.obric.memorydata.plugin")).optString("skill_id"), r20) == false) goto L18;
    L24:
        JSONObject r12 = (JSONObject) ZeusTransformUtils.preCheckCast(r11, JSONObject.class, "com.obric.memorydata.plugin");
        if (r12 != null) goto L29;
        return new Response(-4, "load skill result does not contain the requested skill", null, null, 12, null);
    L29:
        if (r12.optBoolean(LocationMonitorConst.IS_SUCCESS, false) == true) goto L52;
        int r13 = -7;
        Integer r0 = Integer.valueOf(r12.optInt("error_code", -7));
        if (((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.memorydata.plugin")).intValue() == 0) goto L33;
        r4 = true;
    L33:
        if (r4 == true) goto L36;
        r0 = null;
    L36:
        if (r0 == null) goto L38;
        r13 = r0.intValue();
    L38:
        int r14 = r13;
        Object r15 = r12.opt("error_msg");
        if (ZeusTransformUtils.instanceOf(r15, String.class) == false) goto L41;
        String r16 = (String) ZeusTransformUtils.preCheckCast(r15, String.class, "com.obric.memorydata.plugin");
    L42:
        if (r16 != null) goto L44;
    L48:
        String r17 = "load skill failed";
    L50:
        return new Response(r14, r17, null, null, 12, null);
    L44:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r16, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L46;
        r10 = r16;
    L46:
        if (r10 == null) goto L48;
        r17 = r10;
        goto L50
    L41:
        r16 = null;
        goto L42
    L52:
        if (r12.has(Params.CONTENT) == false) goto L59;
        if (r12.isNull(Params.CONTENT) == true) goto L59;
        return new Response(0, "success", new JSONObject().put("skill_id", r20).put(Params.CONTENT, r12.getString(Params.CONTENT)), null, 8, null);
    L59:
        return new Response(-4, "load skill result is missing content", null, null, 12, null);
    L23:
        r11 = null;
        goto L24
    L10:
        return new Response(-4, "load skill result is missing results", null, null, 12, null);
    L61:
        return new Response(-4, "load skill result is not a JSON object", null, null, 12, null);
    }

    private final JSONObject a(JSONObject r3, String r4) {
        Object r5 = r3.opt(r4);
        if (ZeusTransformUtils.instanceOf(r5, JSONObject.class) == false) goto L7;
        return (JSONObject) ZeusTransformUtils.preCheckCast(r5, JSONObject.class, "com.obric.memorydata.plugin");
    L7:
        if (ZeusTransformUtils.instanceOf(r5, String.class) == false) goto L9;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.memorydata.plugin");
    L10:
        if (r6 != null) goto L12;
        return null;
    L12:
        return b(r6);
    L9:
        r6 = null;
        goto L10
    }

    private final JSONArray b(JSONObject r3, String r4) {
        Object r2 = r3.opt(r4);
        if (ZeusTransformUtils.instanceOf(r2, JSONArray.class) == false) goto L7;
        return (JSONArray) ZeusTransformUtils.preCheckCast(r2, JSONArray.class, "com.obric.memorydata.plugin");
    L7:
        if (ZeusTransformUtils.instanceOf(r2, String.class) == true) goto L9;
        return null;
    L9:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L18;
        return new JSONArray((String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin"));
    L19:
        return null;
    L18:
        return null;
    }

    private final JSONObject b(String r2) {
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L9;
        return null;
    L9:
        return new JSONObject(r2);
    L11:
        return null;
    }

    public final Response a() {
        long r13 = h.f11824a.a();
        JSONObject r3 = new JSONObject(com.obric.capability.schedulekit.e.a(com.obric.capability.schedulekit.e.f7388a, "RC_ComplexTaskContext", (IntentParams) ZeusTransformUtils.preCheckCast(new Empty(), IntentParams.class, "com.obric.memorydata.plugin"), r13, null, null, 24, null));     // Catch: RuntimeException -> L18
        JSONObject r4 = r3.optJSONObject("ext");     // Catch: RuntimeException -> L18
        if (r4 != null) goto L6;
        r4 = new JSONObject();     // Catch: RuntimeException -> L18
        r3.put("ext", r4);     // Catch: RuntimeException -> L18
    L6:
        r4.put("o_omni_enable_skill", "1");     // Catch: RuntimeException -> L18
        r4.put("o_skip_authentication", "1");     // Catch: RuntimeException -> L18
        m r5 = m.f11838a;
        String r7 = r3.toString();
        Intrinsics.checkNotNullExpressionValue(r7, "toString(...)");
        b r0 = m.a(r5, r13, r7, 0, null, 0, 28, null);
        if (r0.b() == 0) goto L20;
        int r6 = r0.b();
        String r1 = r0.e();
        if (r1 != null) goto L13;
        r1 = "intent execution failed";
    L13:
        return new Response(r6, r1, null, null, 12, null);
    L20:
        return a(r0);
    L16:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "SkillAdapter", "[code=playground_skill_result_parse_failed] skill list result parse failed", null, 4, null);
        return new Response(-3, "intent dispatch failed", null, null, 12, null);
    L18:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "SkillAdapter", "[code=playground_skill_payload_build_failed] skill list payload build failed", null, 4, null);
        return new Response(-3, "intent dispatch failed", null, null, 12, null);
    }

    public final Response a(String r15) {
        Intrinsics.checkNotNullParameter(r15, "skillId");
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L5;
        long r12 = h.f11824a.a();
        JSONObject r3 = new JSONObject(com.obric.capability.schedulekit.e.a(com.obric.capability.schedulekit.e.f7388a, "System_Skill", (IntentParams) ZeusTransformUtils.preCheckCast(new SystemSkillParams(UUID.randomUUID().toString(), "load_skill", new JSONObject().put("skills", new JSONArray().put(new JSONObject().put("skill_id", r15))).toString()), IntentParams.class, "com.obric.memorydata.plugin"), r12, null, null, 24, null));     // Catch: RuntimeException -> L22
        JSONObject r1 = r3.optJSONObject("ext");     // Catch: RuntimeException -> L22
        if (r1 != null) goto L10;
        r1 = new JSONObject();     // Catch: RuntimeException -> L22
        r3.put("ext", r1);     // Catch: RuntimeException -> L22
    L10:
        r1.put("o_skip_authentication", "1");     // Catch: RuntimeException -> L22
        String r6 = r3.toString();     // Catch: RuntimeException -> L22
        Intrinsics.checkNotNull(r6);
        b r0 = m.a(m.f11838a, r12, r6, 0, null, 0, 28, null);
        if (r0.b() == 0) goto L26;
        int r4 = r0.b();
        String r16 = r0.e();
        if (r16 != null) goto L17;
        r16 = "intent execution failed";
    L17:
        return new Response(r4, r16, null, null, 12, null);
    L26:
        return a(r15, r0);
    L20:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "SkillAdapter", "[code=playground_skill_result_parse_failed] load skill result parse failed", null, 4, null);
        return new Response(-3, "intent dispatch failed", null, null, 12, null);
    L22:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "SkillAdapter", "[code=playground_skill_payload_build_failed] load skill payload build failed", null, 4, null);
        return new Response(-3, "intent dispatch failed", null, null, 12, null);
    L5:
        return new Response(-2, "skillId must not be blank", null, null, 12, null);
    }
}
