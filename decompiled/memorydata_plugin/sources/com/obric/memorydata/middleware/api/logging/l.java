package com.obric.memorydata.middleware.api.logging;

import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u0005*\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0005H\u0002J\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u0005*\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/middleware/api/logging/MemoryLogBridgeDispatcher;", "", "<init>", "()V", "OPERATION", "", "SCHEMA_VERSION", "", "report", "", "payload", "parseFields", "Lcom/obric/memorydata/middleware/api/logging/LogFields;", "fields", "Lorg/json/JSONObject;", "optionalCode", "key", "optionalToken", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f11625a = null;

    static {
        f11625a = new l();
    }

    private l() {
    }

    private final f a(JSONObject r5) {
        if (r5 == null) goto L4;
        g r4 = new g();
        Iterator<String> r0 = r5.keys();
    L7:
        if (r0.hasNext() == false) goto L16;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");
        Object r2 = r5.opt(r1);
        if (ZeusTransformUtils.instanceOf(r2, Boolean.class) == true) goto L14;
        if (ZeusTransformUtils.instanceOf(r2, Number.class) == true) goto L14;
        if (ZeusTransformUtils.instanceOf(r2, String.class) == false) goto L7;
    L14:
        Intrinsics.checkNotNull(r1);
        r4.a(r1, r2);
        goto L7
    L16:
        return r4.a();
    L4:
        return f.f11616a.a();
    }

    private final String a(JSONObject r1, String r2) {
        String r0 = r1.optString(r2);
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L6;
        r0 = null;
    L6:
        if (r0 != null) goto L8;
        return null;
    L8:
        return m.f11626a.c(r0);
    }

    private final String b(JSONObject r1, String r2) {
        String r0 = r1.optString(r2);
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L6;
        r0 = null;
    L6:
        if (r0 != null) goto L8;
        return null;
    L8:
        return m.f11626a.b(r0);
    }

    public final boolean a(String r13) {
        Intrinsics.checkNotNullParameter(r13, "payload");
        if (i.f11621a.a() == true) goto L33;
        return false;
    L33:
        JSONObject r0 = new JSONObject(r13);     // Catch: JSONException -> L32
        if (r0.optInt("schema_version") == 1) goto L8;
        return false;
    L8:
        String r14 = r0.optString(MemoryInfoSectionEditActivity.EXTRA_KIND);     // Catch: JSONException -> L32
        String r3 = null;
        if (v.f11637a.a(r14) == false) goto L11;
        String r6 = r14;
    L12:
        if (r6 != null) goto L14;
        return false;
    L14:
        String r9 = a(r0, "code");     // Catch: JSONException -> L32
        if (Intrinsics.areEqual(r6, "error_trace") == false) goto L18;
        if (r9 != null) goto L18;
        return false;
    L18:
        String r8 = a(r0, "event");     // Catch: JSONException -> L32
        if (r8 != null) goto L21;
        return false;
    L21:
        m r15 = m.f11626a;     // Catch: JSONException -> L32
        String r2 = r0.optString("message");     // Catch: JSONException -> L32
        Intrinsics.checkNotNullExpressionValue(r2, "optString(...)");     // Catch: JSONException -> L32
        String r7 = r15.a(r2);     // Catch: JSONException -> L32
        JSONObject r16 = r0.optJSONObject("context");     // Catch: JSONException -> L32
        j r4 = j.f11623a;     // Catch: JSONException -> L32
        if (r16 == null) goto L24;
        String r5 = a(r16, "biz");     // Catch: JSONException -> L32
    L25:
        if (r16 == null) goto L27;
        String r11 = b(r16, "trace_id");     // Catch: JSONException -> L32
    L28:
        if (r16 == null) goto L30;
        r3 = a(r16, "stage");     // Catch: JSONException -> L32
    L30:
        return r4.a("python", r6, r7, r8, r9, new p(r5, r11, r3), a(r0.optJSONObject("fields")));
    L27:
        r11 = null;
        goto L28
    L24:
        r5 = null;
        goto L25
    L11:
        r6 = null;
    L35:
        return false;
    }
}
