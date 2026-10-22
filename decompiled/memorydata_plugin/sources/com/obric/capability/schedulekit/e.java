package com.obric.capability.schedulekit;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.common.IMAppAction;
import com.obric.capabilitykit.common.IMAppActionExt;
import com.obric.capabilitykit.common.UtilsKt;
import com.obric.capabilitykit.common.execution.eca.ECAInputParam;
import com.obric.capabilitykit.common.execution.eca.inputparam.ECAInputParamPrimitive;
import com.obric.capabilitykit.common.execution.eca.inputparam.ECAInputParamRawJson;
import com.obric.capabilitykit.common.intent.IntentParams;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J!\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\rH\u0000¢\u0006\u0002\b\u000fJ@\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u000e2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\rH\u0002JD\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000e2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\rJD\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000e2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\rR#\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001a"}, d2 = {"Lcom/obric/capability/schedulekit/IntentPayloadHelper;", "", "()V", "ecaGson", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "getEcaGson", "()Lcom/google/gson/Gson;", "ecaGson$delegate", "Lkotlin/Lazy;", "buildActionExt", "Lcom/obric/capabilitykit/common/IMAppActionExt;", "actionExt", "", "", "buildActionExt$capabilityschedulekit_release", "buildPayload", "intentName", "paramsObject", "Lcom/google/gson/JsonObject;", "questionId", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "getPayload", TrackerImpl.PARAMS, "Lcom/obric/capabilitykit/common/intent/IntentParams;", "capabilityschedulekit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f7388a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f7389b = null;

    static {
        f7388a = new e();
        f7389b = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(IntentPayloadHelper$ecaGson$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
    }

    private e() {
    }

    private final Gson a() {
        return (Gson) ZeusTransformUtils.preCheckCast(f7389b.getValue(), Gson.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ String a(e r6, String r7, IntentParams r8, long r9, String r11, Map r12, int r13, Object r14) {
        IntentParams r0 = (IntentParams) ZeusTransformUtils.wrapperContextForParams(r8, IntentParams.class, "com.obric.memorydata.plugin");
        Map<String, String> r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.memorydata.plugin");
        if ((r13 & 4) == 0) goto L5;
        long r2 = 0;
    L7:
        if ((r13 & 8) == 0) goto L9;
        String r4 = null;
    L11:
        if ((r13 & 16) == 0) goto L14;
        r1 = MapsKt.emptyMap();
    L14:
        return r6.a(r7, r0, r2, r4, r1);
    L9:
        r4 = r11;
        goto L11
    L5:
        r2 = r9;
        goto L7
    }

    private final String a(String r23, JsonObject r24, long r25, String r27, Map<String, String> r28) {
        Map<String, String> r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r28, Map.class, "com.obric.memorydata.plugin");
        com.obric.capability.schedulekit.eca.v3.c r4 = com.obric.capability.schedulekit.eca.v3.c.a(new com.obric.capability.schedulekit.eca.v3.c().a(), r23, null, 2, null);
        if (r27 == null) goto L5;
        r4.a(r27);
    L5:
        if (r24 == null) goto L27;
        Iterator<String> r1 = r24.keySet().iterator();
    L8:
        if (r1.hasNext() == false) goto L27;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");
        JsonElement r6 = r24.get(r5);
        if (ZeusTransformUtils.instanceOf(r6, JsonObject.class) == true) goto L25;
        if (ZeusTransformUtils.instanceOf(r6, JsonArray.class) == true) goto L25;
        if (ZeusTransformUtils.instanceOf(r6, JsonPrimitive.class) == false) goto L8;
        if (((JsonPrimitive) ZeusTransformUtils.preCheckCast(r6, JsonPrimitive.class, "com.obric.memorydata.plugin")).isBoolean() == true) goto L18;
        if (((JsonPrimitive) ZeusTransformUtils.preCheckCast(r6, JsonPrimitive.class, "com.obric.memorydata.plugin")).isNumber() == true) goto L21;
        if (((JsonPrimitive) ZeusTransformUtils.preCheckCast(r6, JsonPrimitive.class, "com.obric.memorydata.plugin")).isString() == false) goto L8;
        Intrinsics.checkNotNullExpressionValue(r5, "key");
        Object r7 = new ECAInputParamPrimitive(((JsonPrimitive) ZeusTransformUtils.preCheckCast(r6, JsonPrimitive.class, "com.obric.memorydata.plugin")).getAsString());
    L26:
        r4.a(r5, (ECAInputParam) ZeusTransformUtils.preCheckCast(r7, ECAInputParam.class, "com.obric.memorydata.plugin"));
        goto L8
    L21:
        Intrinsics.checkNotNullExpressionValue(r5, "key");
        r7 = new ECAInputParamPrimitive(((JsonPrimitive) ZeusTransformUtils.preCheckCast(r6, JsonPrimitive.class, "com.obric.memorydata.plugin")).getAsNumber());
        goto L26
    L18:
        Intrinsics.checkNotNullExpressionValue(r5, "key");
        r7 = new ECAInputParamPrimitive(Boolean.valueOf(((JsonPrimitive) ZeusTransformUtils.preCheckCast(r6, JsonPrimitive.class, "com.obric.memorydata.plugin")).getAsBoolean()));
    L25:
        Intrinsics.checkNotNullExpressionValue(r5, "key");
        r7 = new ECAInputParamRawJson(r6);
    L27:
        JSONObject r0 = new JSONObject();
        r0.put("Version", 3);
        String r3 = r0.put("Content", r4.b().b().toString()).toString();
        Intrinsics.checkNotNullExpressionValue(r3, "JSONObject().let {\n     …g())\n        }.toString()");
        long r8 = 0;
        String r9 = UtilsKt.getGson().toJson(new IMAppAction(r8, Long.valueOf(r25), null, 0, Long.valueOf(r25), null, r3, null, 0, 0, 0, a(r2), 1965, null));
        Intrinsics.checkNotNullExpressionValue(r9, "gson.toJson(\n           …,\n            )\n        )");
        return r9;
    }

    public final IMAppActionExt a(Map<String, String> r2) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "actionExt");
        IMAppActionExt r3 = new IMAppActionExt();
        r3.putAll(r1);
        r3.put("to_server", "false");
        return r3;
    }

    public final String a(String r8, IntentParams r9, long r10, String r12, Map<String, String> r13) {
        IntentParams r11 = (IntentParams) ZeusTransformUtils.wrapperContextForParams(r9, IntentParams.class, "com.obric.memorydata.plugin");
        Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r13, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "intentName");
        Intrinsics.checkNotNullParameter(r6, "actionExt");
        if (r11 == null) goto L5;
        JsonObject r14 = new JsonParser().parse(f7388a.a().toJson(r11)).getAsJsonObject();
    L7:
        return a(r8, r14, r10, r12, r6);
    L5:
        r14 = null;
        goto L7
    }
}
