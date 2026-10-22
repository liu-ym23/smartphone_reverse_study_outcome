package com.obric.memorydata.middleware.impl.playground;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.entity.EventBody;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.awareness.impl.AwarenessManagerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u001f\n\u0002\u0010\"\n\u0002\b\u0010\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\f\u001a\u0004\u0018\u00010\u0007*\u00020\rH\u0002J\f\u0010\u000e\u001a\u00020\u000f*\u00020\rH\u0002J \u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u0014H\u0002J\u000e\u0010\u0015\u001a\u00020\u000f*\u0004\u0018\u00010\u0007H\u0002J\f\u0010\u0016\u001a\u00020\u000f*\u00020\u0007H\u0002J\f\u0010\u0017\u001a\u00020\u000f*\u00020\u0007H\u0002J\f\u0010\u0018\u001a\u00020\u000f*\u00020\u0007H\u0002J\u000e\u0010\u0019\u001a\u0004\u0018\u00010\r*\u00020\rH\u0002J\u000e\u0010\u001a\u001a\u0004\u0018\u00010\r*\u00020\rH\u0002J\f\u0010\u001b\u001a\u00020\n*\u00020\rH\u0002J\u0019\u0010\u001c\u001a\u0004\u0018\u00010\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0002\u0010\u001dJ\u000e\u0010\u001e\u001a\u00020\u000f*\u0004\u0018\u00010\u0001H\u0002J\u000e\u0010\u001f\u001a\u0004\u0018\u00010\r*\u00020\u0007H\u0002J\u000e\u0010 \u001a\u0004\u0018\u00010\u0001*\u00020\u0007H\u0002J\u0016\u0010!\u001a\u0004\u0018\u00010\r*\u00020\r2\u0006\u0010\"\u001a\u00020\u0007H\u0002R\u000e\u0010#\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0014\u00103\u001a\b\u0012\u0004\u0012\u00020\u000704X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010>\u001a\b\u0012\u0004\u0012\u00020\u000704X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010?\u001a\b\u0012\u0004\u0012\u00020\u000704X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010@\u001a\b\u0012\u0004\u0012\u00020\u000704X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010A\u001a\b\u0012\u0004\u0012\u00020\u000704X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010B\u001a\b\u0012\u0004\u0012\u00020\u000704X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010C\u001a\b\u0012\u0004\u0012\u00020\u000704X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/obric/memorydata/middleware/impl/playground/ResultModeResolver;", "", "<init>", "()V", "resolve", "Lcom/obric/memorydata/middleware/impl/playground/AppIntentResultMode;", "payload", "", "sourceIntent", "resolveTimeoutMillis", "", "extractSourceIntent", "firstSourceIntent", "Lorg/json/JSONObject;", "declaresMobileUseCallback", "", "collectActionNames", "", EventBody.KEY_VALUE, "names", "", "isMobileUseSource", "isAsyncAppIntent", "isJobResultIntent", "isPcGlobalSearchIntent", "extractSystemShellActionArgs", "extractActionArgsIfSystemShell", "resolveShellHardTimeoutMillis", "positiveLongOrNull", "(Ljava/lang/Object;)Ljava/lang/Long;", "containsCallUserAction", "toJsonObjectOrNull", "toJsonValueOrNull", "optJSONObjectOrString", "key", "EXT", "EXTRA", "CONTENT", "ECA_CONTENT", "JOBS", "ACTIONS", "MOBILE_USE", "MOBILE_USE_CALLBACK", "ACTION", "ACTION_TYPE", "ACTION_NAME", "INPUT_PARAMS", "ACTION_ARGS", "VALUE", "TIMEOUT_MS", "CALL_USER_ACTION", "CALL_USER_ACTION_KEYS", "", "SYSTEM_SHELL_ACTION", "PHONE_PROXY_CALL", "PC_GLOBAL_SEARCH_INTENT", "APP_INTENT_FINAL_TIMEOUT_MILLIS", "PC_GLOBAL_SEARCH_FINAL_TIMEOUT_MILLIS", "CALL_USER_FINAL_TIMEOUT_MILLIS", "PHONE_PROXY_CALL_FINAL_TIMEOUT_MILLIS", "SHELL_DEFAULT_SOFT_TIMEOUT_MILLIS", "SHELL_HARD_TIMEOUT_GRACE_MILLIS", "MOBILE_USE_TOOLS", "MOBILE_USE_SOURCE_KEYS", "RESULT_MODE_KEYS", "ACTION_NAME_KEYS", "ASYNC_APP_INTENTS", "JOB_RESULT_INTENTS", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f11826a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<String> f11827b = null;
    private static final Set<String> c = null;
    private static final Set<String> d = null;
    private static final Set<String> e = null;
    private static final Set<String> f = null;
    private static final Set<String> g = null;
    private static final Set<String> h = null;

    static {
        f11826a = new i();
        f11827b = SetsKt.setOf(new String[]{"action", AwarenessManagerImpl.KEY_ACTION_TYPE});
        c = SetsKt.setOf(new String[]{"mobile_use__init", "mobile_use__do_action", "mobile_use__destroy"});
        d = SetsKt.setOf(new String[]{"o_source_intent", "source_intent", "origin_function_name", "origin_tool_name", "tool_name"});
        e = SetsKt.setOf(new String[]{"result_mode", "o_result_mode", "callback_mode"});
        f = SetsKt.setOf(new String[]{"actionName", "operation_id", "api_name"});
        g = SetsKt.setOf(new String[]{"GUI_Action", "GUI_INIT", "System_AutoAction"});
        h = SetsKt.setOf(new String[]{"PC_GlobalSearchIntent", "PC_AppFcEntitySearch", "PC_SearchAppEntity", "PC_CommonGlobalSearch"});
    }

    private i() {
    }

    private final Long a(Object r6) {
        if (ZeusTransformUtils.instanceOf(r6, Number.class) == false) goto L6;
        Long r5 = Long.valueOf(((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.memorydata.plugin")).longValue());
    L9:
        if (r5 != null) goto L11;
        return null;
    L11:
        if (((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L13;
        boolean r7 = true;
    L14:
        if (r7 == true) goto L16;
        return null;
    L16:
        return r5;
    L13:
        r7 = false;
        goto L14
    L6:
        if (ZeusTransformUtils.instanceOf(r6, String.class) == false) goto L8;
        r5 = StringsKt.toLongOrNull((String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.memorydata.plugin"));
        goto L9
    L8:
        r5 = null;
        goto L9
    }

    private final String a(JSONObject r7) {
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(d, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L3:
        String r2 = null;
        if (r6.hasNext() == false) goto L10;
        String r0 = r7.optString((String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.memorydata.plugin"));
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L8;
        r2 = r0;
    L8:
        if (r2 == null) goto L3;
        return r2;
    L10:
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(new String[]{"ext", WsConstants.KEY_EXTRA}), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L12:
        if (r8.hasNext() == false) goto L24;
        JSONObject r1 = f11826a.a(r7, (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.memorydata.plugin"));
        if (r1 == null) goto L12;
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(d, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L17:
        if (r3.hasNext() == false) goto L12;
        String r4 = r1.optString((String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin"));
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L22;
        r4 = null;
    L22:
        if (r4 == null) goto L17;
        return r4;
    L24:
        return null;
    }

    private final JSONObject a(JSONObject r3, String r4) {
        Object r2 = r3.opt(r4);
        Object r5 = null;
        if (ZeusTransformUtils.instanceOf(r2, JSONObject.class) == false) goto L7;
        Object r6 = ZeusTransformUtils.preCheckCast(r2, JSONObject.class, "com.obric.memorydata.plugin");
    L17:
        return (JSONObject) r6;
    L7:
        if (ZeusTransformUtils.instanceOf(r2, String.class) == false) goto L20;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L10
        Object r8 = Result.m1421constructorimpl(new JSONObject((String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L10
    L13:
        if (Result.m1427isFailureimpl(r8) == true) goto L16;
        r5 = r8;
    L16:
        r6 = ZeusTransformUtils.preCheckCast(r5, JSONObject.class, "com.obric.memorydata.plugin");
    L10:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r8 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L13
    L20:
        return null;
    }

    private final void a(Object r6, Set<String> r7) {
        Set<String> r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r7, Set.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, JSONObject.class) == false) goto L18;
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(f, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L6:
        if (r0.hasNext() == false) goto L13;
        String r2 = ((JSONObject) ZeusTransformUtils.preCheckCast(r6, JSONObject.class, "com.obric.memorydata.plugin")).optString((String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin"));
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L11;
        r2 = null;
    L11:
        if (r2 == null) goto L6;
        r8.add(r2);
        goto L6
    L13:
        Iterator<String> r1 = ((JSONObject) ZeusTransformUtils.preCheckCast(r6, JSONObject.class, "com.obric.memorydata.plugin")).keys();
    L15:
        if (r1.hasNext() == false) goto L37;
        a(((JSONObject) ZeusTransformUtils.preCheckCast(r6, JSONObject.class, "com.obric.memorydata.plugin")).opt((String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin")), r8);
        goto L15
    L37:
        return;
    L18:
        if (ZeusTransformUtils.instanceOf(r6, JSONArray.class) == false) goto L23;
        int r3 = 0;
        int r4 = ((JSONArray) ZeusTransformUtils.preCheckCast(r6, JSONArray.class, "com.obric.memorydata.plugin")).length();
    L20:
        if (r3 >= r4) goto L38;
        a(((JSONArray) ZeusTransformUtils.preCheckCast(r6, JSONArray.class, "com.obric.memorydata.plugin")).opt(r3), r8);
        r3 = r3 + 1;
        goto L20
    L38:
        return;
    L23:
        if (ZeusTransformUtils.instanceOf(r6, String.class) == false) goto L35;
        Object r5 = g((String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.memorydata.plugin"));
        if (r5 == null) goto L36;
        f11826a.a(r5, r8);
        return;
    L36:
        return;
    }

    private final boolean b(Object r8) {
        if (ZeusTransformUtils.instanceOf(r8, JSONObject.class) == false) goto L24;
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(f11827b, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, Collection.class) == true) goto L7;
    L9:
        Iterator r1 = r0.iterator();
    L11:
        if (r1.hasNext() == false) goto L8;
        if (StringsKt.equals(((JSONObject) ZeusTransformUtils.preCheckCast(r8, JSONObject.class, "com.obric.memorydata.plugin")).optString((String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin")), "call_user", true) == false) goto L11;
        boolean r2 = true;
    L15:
        if (r2 == false) goto L17;
        return true;
    L17:
        Iterator<String> r3 = ((JSONObject) ZeusTransformUtils.preCheckCast(r8, JSONObject.class, "com.obric.memorydata.plugin")).keys();
    L19:
        if (r3.hasNext() == false) goto L44;
        if (b(((JSONObject) ZeusTransformUtils.preCheckCast(r8, JSONObject.class, "com.obric.memorydata.plugin")).opt((String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin"))) == false) goto L19;
        return true;
    L44:
        return false;
    L8:
        r2 = false;
        goto L15
    L7:
        if (((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L9;
    L24:
        if (ZeusTransformUtils.instanceOf(r8, JSONArray.class) == false) goto L32;
        int r4 = ((JSONArray) ZeusTransformUtils.preCheckCast(r8, JSONArray.class, "com.obric.memorydata.plugin")).length();
        int r5 = 0;
    L26:
        if (r5 >= r4) goto L45;
        if (b(((JSONArray) ZeusTransformUtils.preCheckCast(r8, JSONArray.class, "com.obric.memorydata.plugin")).opt(r5)) == true) goto L29;
        r5 = r5 + 1;
        goto L26
    L29:
        return true;
    L45:
        return false;
    L32:
        if (ZeusTransformUtils.instanceOf(r8, String.class) == true) goto L34;
        return false;
    L34:
        return b(g((String) ZeusTransformUtils.preCheckCast(r8, String.class, "com.obric.memorydata.plugin")));
    }

    private final boolean b(String r6) {
        if (r6 != null) goto L5;
        return false;
    L5:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L8;
        r6 = null;
    L8:
        if (r6 == null) goto L31;
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(c, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, Collection.class) == true) goto L13;
    L15:
        Iterator r1 = r0.iterator();
    L17:
        if (r1.hasNext() == false) goto L14;
        if (StringsKt.equals(r6, (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin"), true) == false) goto L17;
        boolean r2 = true;
    L21:
        if (r2 == true) goto L25;
        if (StringsKt.startsWith(r6, "mobile_use__", true) == true) goto L25;
        return false;
    L25:
        return true;
    L14:
        r2 = false;
        goto L21
    L13:
        if (((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L15;
    L31:
        return false;
    }

    private final boolean b(JSONObject r9) {
        List r8 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(d, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L3:
        String r3 = null;
        if (r0.hasNext() == false) goto L10;
        String r2 = r9.optString((String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin"));
        if ((true ^ StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L8;
        r3 = r2;
    L8:
        if (r3 == null) goto L3;
        r8.add(r3);
        goto L3
    L10:
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(e, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L12:
        if (r1.hasNext() == false) goto L19;
        String r4 = r9.optString((String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin"));
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L17;
        r4 = null;
    L17:
        if (r4 == null) goto L12;
        r8.add(r4);
        goto L12
    L19:
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(new String[]{"ext", WsConstants.KEY_EXTRA}), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L21:
        if (r5.hasNext() == false) goto L42;
        JSONObject r6 = f11826a.a(r9, (String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.memorydata.plugin"));
        if (r6 == null) goto L21;
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(d, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L26:
        if (r7.hasNext() == false) goto L33;
        String r10 = r6.optString((String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.memorydata.plugin"));
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L31;
        r10 = null;
    L31:
        if (r10 == null) goto L26;
        r8.add(r10);
        goto L26
    L33:
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(e, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L35:
        if (r11.hasNext() == false) goto L21;
        String r12 = r6.optString((String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.memorydata.plugin"));
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L40;
        r12 = null;
    L40:
        if (r12 == null) goto L35;
        r8.add(r12);
        goto L35
    L42:
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r13, Collection.class) == true) goto L45;
    L47:
        Iterator r14 = r13.iterator();
    L49:
        if (r14.hasNext() == false) goto L60;
        String r15 = (String) ZeusTransformUtils.preCheckCast(r14.next(), String.class, "com.obric.memorydata.plugin");
        if (f11826a.b(r15) == false) goto L53;
    L58:
        boolean r16 = true;
    L59:
        if (r16 == false) goto L49;
        return true;
    L53:
        if (StringsKt.equals(r15, "MOBILE_USE_CALLBACK", true) == true) goto L58;
        if (StringsKt.equals(r15, "mobile_use", true) == true) goto L58;
        r16 = false;
    L60:
        return false;
    L45:
        if (((Collection) ZeusTransformUtils.preCheckCast(r13, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L47;
        goto L47
    }

    private final JSONObject c(JSONObject r9) {
        JSONObject r10 = a(r9, Params.CONTENT);
        if (r10 == null) goto L28;
        String r11 = r10.optString("Content");
        if (r11 == null) goto L28;
        JSONObject r12 = f(r11);
        if (r12 == null) goto L28;
        JSONArray r13 = r12.optJSONArray("jobs");
        if (r13 != null) goto L11;
        return null;
    L11:
        int r1 = r13.length();
        int r3 = 0;
    L12:
        if (r3 >= r1) goto L28;
        JSONObject r4 = r13.optJSONObject(r3);
        if (r4 == null) goto L27;
        JSONArray r5 = r4.optJSONArray("actions");
        if (r5 == null) goto L27;
        int r6 = r5.length();
        int r7 = 0;
    L19:
        if (r7 >= r6) goto L27;
        JSONObject r8 = r5.optJSONObject(r7);
        if (r8 == null) goto L26;
        JSONObject r14 = d(r8);
        if (r14 == null) goto L26;
        return r14;
    L26:
        r7 = r7 + 1;
    L27:
        r3 = r3 + 1;
    L28:
        return null;
    }

    private final boolean c(String r6) {
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(g, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, Collection.class) == true) goto L5;
    L7:
        Iterator r7 = r5.iterator();
    L9:
        if (r7.hasNext() == false) goto L12;
        if (StringsKt.equals(r6, (String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.memorydata.plugin"), true) == false) goto L9;
        return true;
    L12:
        return false;
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
        goto L7
    }

    private final JSONObject d(JSONObject r4) {
        if (StringsKt.equals(r4.optString("actionName"), "System_Shell", true) == true) goto L5;
        return null;
    L5:
        JSONObject r5 = r4.optJSONObject("inputParams");
        if (r5 != null) goto L8;
        return null;
    L8:
        JSONObject r6 = r5.optJSONObject("actionArgs");
        if (r6 == null) goto L16;
        String r7 = r6.optString(EventBody.KEY_VALUE);
        if (r7 == null) goto L16;
        JSONObject r3 = f(r7);
        if (r3 == null) goto L16;
        return r3;
    L16:
        return new JSONObject();
    }

    private final boolean d(String r6) {
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(h, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, Collection.class) == true) goto L5;
    L7:
        Iterator r7 = r5.iterator();
    L9:
        if (r7.hasNext() == false) goto L6;
        if (StringsKt.equals(r6, (String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.memorydata.plugin"), true) == false) goto L9;
        boolean r8 = true;
    L13:
        if (r8 == true) goto L21;
        if (StringsKt.startsWith(r6, "PC_", true) == true) goto L17;
        return false;
    L17:
        if (StringsKt.contains((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("Search", CharSequence.class, "com.obric.memorydata.plugin"), true) == true) goto L21;
        if (StringsKt.contains((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("Entity", CharSequence.class, "com.obric.memorydata.plugin"), true) == true) goto L21;
        return false;
    L21:
        return true;
    L6:
        r8 = false;
        goto L13
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
        goto L6
    }

    private final long e(JSONObject r3) {
        Long r2 = a(r3.opt("timeout_ms"));
        if (r2 == null) goto L5;
        long r4 = r2.longValue();
    L7:
        return r4 + 60000;
    L5:
        r4 = 600000;
        goto L7
    }

    private final boolean e(String r2) {
        return StringsKt.equals(r2, "PC_GlobalSearchIntent", true);
    }

    private final JSONObject f(String r1) {
        return new JSONObject(r1);
    L4:
        return null;
    }

    private final Object g(String r4) {
        String r3 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        Character r5 = StringsKt.firstOrNull((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"));
        if (r5 == null) goto L16;
        if (r5.charValue() != '{') goto L16;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L9
        Object r7 = Result.m1421constructorimpl(new JSONObject(r3));     // Catch: Throwable -> L9
    L12:
        if (Result.m1427isFailureimpl(r7) == false) goto L26;
        return null;
    L26:
        return r7;
    L9:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r7 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L16:
        if (r5 != null) goto L19;
        return null;
    L19:
        if (r5.charValue() != '[') goto L31;
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L22
        r7 = Result.m1421constructorimpl(new JSONArray(r3));     // Catch: Throwable -> L22
    L25:
        if (Result.m1427isFailureimpl(r7) == false) goto L26;
        return null;
    L22:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r7 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L25
    L31:
        return null;
    }

    public final AppIntentResultMode a(String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "payload");
        if (b(r6) == true) goto L5;
        JSONObject r7 = f(r5);
        if (r7 != null) goto L9;
    L11:
        boolean r4 = false;
    L12:
        if (r4 == true) goto L14;
        LinkedHashSet r8 = new LinkedHashSet();
        if (r7 == null) goto L18;
        f11826a.a(r7, (Set) ZeusTransformUtils.preCheckCast(r8, Set.class, "com.obric.memorydata.plugin"));
    L18:
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r9, Collection.class) == true) goto L21;
    L23:
        Iterator r10 = r9.iterator();
    L25:
        if (r10.hasNext() == false) goto L22;
        if (f11826a.c((String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.memorydata.plugin")) == false) goto L25;
        boolean r11 = true;
    L29:
        if (r11 == true) goto L31;
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r12, Collection.class) == true) goto L35;
    L37:
        Iterator r13 = r12.iterator();
    L39:
        if (r13.hasNext() == false) goto L43;
        if (f11826a.d((String) ZeusTransformUtils.preCheckCast(r13.next(), String.class, "com.obric.memorydata.plugin")) == false) goto L39;
    L43:
        return AppIntentResultMode.JOB_RESULT;
    L35:
        if (((Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L37;
    L31:
        return AppIntentResultMode.ASYNC_APP_INTENT;
    L22:
        r11 = false;
        goto L29
    L21:
        if (((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L23;
    L14:
        return AppIntentResultMode.MOBILE_USE_CALLBACK;
    L9:
        if (b(r7) != true) goto L11;
        r4 = true;
        goto L12
    L5:
        return AppIntentResultMode.MOBILE_USE_CALLBACK;
    }

    public final String a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "payload");
        JSONObject r3 = f(r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return a(r3);
    }

    public final long b(String r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "payload");
        JSONObject r9 = f(r7);
        if (r9 == null) goto L5;
        JSONObject r1 = c(r9);
    L6:
        LinkedHashSet r2 = new LinkedHashSet();
        if (r9 == null) goto L9;
        f11826a.a(r9, (Set) ZeusTransformUtils.preCheckCast(r2, Set.class, "com.obric.memorydata.plugin"));
    L9:
        boolean r4 = true;
        if (r8 != null) goto L12;
    L17:
        if (r1 != null) goto L59;
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r10, Collection.class) == true) goto L22;
    L24:
        Iterator r11 = r10.iterator();
    L26:
        if (r11.hasNext() == false) goto L23;
        if (StringsKt.equals((String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.memorydata.plugin"), "Phone_ProxyCall", true) == false) goto L26;
        boolean r12 = true;
    L30:
        if (r12 == false) goto L32;
        return 0;
    L32:
        if (r9 != null) goto L34;
    L36:
        boolean r6 = false;
    L37:
        if (r6 == false) goto L39;
        return 300000;
    L39:
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r13, Collection.class) == true) goto L42;
    L44:
        Iterator r14 = r13.iterator();
    L46:
        if (r14.hasNext() == false) goto L43;
        if (f11826a.e((String) ZeusTransformUtils.preCheckCast(r14.next(), String.class, "com.obric.memorydata.plugin")) == false) goto L46;
    L49:
        if (r4 == false) goto L51;
        return 181000;
    L51:
        return 30000;
    L43:
        r4 = false;
        goto L49
    L42:
        if (((Collection) ZeusTransformUtils.preCheckCast(r13, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L44;
    L34:
        if (b(r9) != true) goto L36;
        r6 = true;
    L23:
        r12 = false;
        goto L30
    L22:
        if (((Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L24;
    L59:
        return e(r1);
    L12:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L15;
        r8 = null;
    L15:
        if (r8 == null) goto L17;
        r2.add(r8);
        goto L17
    L5:
        r1 = null;
        goto L6
    }
}
