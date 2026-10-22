package com.obric.memorydata.awareness.persistent;

import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.obric.memorydata.sdk.awareness.AwarenessConditionConfig;
import com.obric.memorydata.sdk.awareness.AwarenessConditionRule;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u0005¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/awareness/persistent/PersistentAwarenessConditionCodec;", "", "<init>", "()V", "toJson", "", "config", "Lcom/obric/memorydata/sdk/awareness/AwarenessConditionConfig;", "fromJsonOrNull", "json", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f8771a = null;

    static {
        f8771a = new f();
    }

    private f() {
    }

    public final AwarenessConditionConfig a(String r14) {
        Intrinsics.checkNotNullParameter(r14, "json");
        String r15 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (Intrinsics.areEqual(r15, "{}") == true) goto L5;
        Object r2 = null;
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L49;
        return null;
    L49:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L41
        f r13 = (f) ZeusTransformUtils.preCheckCast(this, f.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L41
        JSONObject r16 = new JSONObject(r15);     // Catch: Throwable -> L41
        JSONArray r17 = r16.optJSONArray("rules");     // Catch: Throwable -> L41
        if (r17 != null) goto L12;
        r17 = new JSONArray();     // Catch: Throwable -> L41
    L12:
        ArrayList r1 = new ArrayList();     // Catch: Throwable -> L41
        int r3 = r17.length();     // Catch: Throwable -> L41
        int r5 = 0;
    L15:
        if (r5 >= r3) goto L27;
        JSONObject r7 = r17.optJSONObject(r5);     // Catch: Throwable -> L41
        if (r7 == null) goto L26;
        JSONArray r8 = r7.optJSONArray("values");     // Catch: Throwable -> L41
        if (r8 != null) goto L22;
        r8 = new JSONArray();     // Catch: Throwable -> L41
    L22:
        ArrayList r9 = new ArrayList();     // Catch: Throwable -> L41
        int r10 = r8.length();     // Catch: Throwable -> L41
        int r11 = 0;
    L23:
        if (r11 >= r10) goto L25;
        r9.add(r8.optString(r11));     // Catch: Throwable -> L41
        r11 = r11 + 1;     // Catch: Throwable -> L41
        goto L23
    L25:
        String r12 = r7.optString("operator");     // Catch: Throwable -> L41
        Intrinsics.checkNotNullExpressionValue(r12, "optString(...)");     // Catch: Throwable -> L41
        r1.add(new AwarenessConditionRule(r12, r9));     // Catch: Throwable -> L41
    L26:
        r5 = r5 + 1;     // Catch: Throwable -> L41
        goto L15
    L27:
        String r18 = r16.optString("valueType");     // Catch: Throwable -> L41
        Intrinsics.checkNotNull(r18);     // Catch: Throwable -> L41
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L31;
        r18 = null;
    L31:
        String r4 = r16.optString("matchMode", LocationAnnotation.LightLocationType.LIGHT_LOCATION_ALL);     // Catch: Throwable -> L41
        Intrinsics.checkNotNullExpressionValue(r4, "optString(...)");     // Catch: Throwable -> L41
        String r19 = r16.optString("extraKey");     // Catch: Throwable -> L41
        Intrinsics.checkNotNull(r19);     // Catch: Throwable -> L41
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r19, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L35;
        r19 = null;
    L35:
        AwarenessConditionConfig r6 = new AwarenessConditionConfig(r18, r4, r1, r19);     // Catch: Throwable -> L41
        if (r6.isAlways() == false) goto L39;
        r6 = null;
    L39:
        Object r110 = Result.m1421constructorimpl(r6);     // Catch: Throwable -> L41
    L44:
        if (Result.m1427isFailureimpl(r110) == true) goto L48;
        r2 = r110;
    L48:
        return (AwarenessConditionConfig) ZeusTransformUtils.preCheckCast(r2, AwarenessConditionConfig.class, "com.obric.memorydata.plugin");
    L41:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r110 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L44
    L5:
        return AwarenessConditionConfig.Companion.a();
    }

    public final String a(AwarenessConditionConfig r8) {
        Intrinsics.checkNotNullParameter(r8, "config");
        if (r8.isAlways() == false) goto L6;
        return "{}";
    L6:
        JSONObject r7 = new JSONObject();
        r7.put("valueType", r8.getValueType());
        r7.put("matchMode", r8.getMatchMode());
        Object r0 = r8.getExtraKey();
        if (r0 != null) goto L9;
    L14:
        JSONArray r1 = new JSONArray();
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r8.getRules(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L16:
        if (r9.hasNext() == false) goto L22;
        AwarenessConditionRule r2 = (AwarenessConditionRule) ZeusTransformUtils.preCheckCast(r9.next(), AwarenessConditionRule.class, "com.obric.memorydata.plugin");
        JSONObject r3 = new JSONObject();
        r3.put("operator", r2.getOperator());
        JSONArray r4 = new JSONArray();
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r2.getValues(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L19:
        if (r5.hasNext() == false) goto L21;
        r4.put((String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.memorydata.plugin"));
        goto L19
    L21:
        Unit r6 = Unit.INSTANCE;
        r3.put("values", r4);
        r1.put(r3);
        goto L16
    L22:
        Unit r10 = Unit.INSTANCE;
        r7.put("rules", r1);
        String r11 = r7.toString();
        Intrinsics.checkNotNullExpressionValue(r11, "toString(...)");
        return r11;
    L9:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L12;
        r0 = null;
    L12:
        if (r0 == null) goto L14;
        r7.put("extraKey", r0);
        goto L14
    }
}
