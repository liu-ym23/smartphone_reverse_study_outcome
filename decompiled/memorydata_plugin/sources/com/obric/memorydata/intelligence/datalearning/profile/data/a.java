package com.obric.memorydata.intelligence.datalearning.profile.data;

import com.bytedance.crash.entity.EventBody;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u001c\u0010\r\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00122\u0006\u0010\u0013\u001a\u00020\u0014J \u0010\u0015\u001a\u0004\u0018\u00010\u00102\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/intelligence/datalearning/profile/data/LabelValue;", "", "<init>", "()V", "values", "Lcom/google/gson/JsonArray;", "getValues", "()Lcom/google/gson/JsonArray;", "setValues", "(Lcom/google/gson/JsonArray;)V", "toJsonString", "", "key", "addValue", "", "jsonObject", "Lcom/google/gson/JsonObject;", Params.CONTENT, "", "confidence", "", "assembleItem", "item", "intelligence_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JsonArray f9960a;

    public a() {
        this.f9960a = new JsonArray();
    }

    private final JsonObject b(List<String> r5, double r6) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if (r4.isEmpty() == false) goto L5;
        return null;
    L5:
        if (r6 >= 0.0d) goto L7;
        return null;
    L7:
        if (r6 > 1.0d) goto L19;
        JsonObject r7 = new JsonObject();
        JsonArray r1 = new JsonArray();
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L11:
        if (r8.hasNext() == false) goto L13;
        r1.add((String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.memorydata.plugin"));
        goto L11
    L13:
        r7.add(EventBody.KEY_VALUE, (JsonElement) ZeusTransformUtils.preCheckCast(r1, JsonElement.class, "com.obric.memorydata.plugin"));
        StringCompanionObject r9 = StringCompanionObject.INSTANCE;
        String r10 = String.format(Locale.ROOT, "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(r6)}, 1));
        Intrinsics.checkNotNullExpressionValue(r10, "format(...)");
        r7.addProperty("confidence", (Number) ZeusTransformUtils.preCheckCast(Double.valueOf(Double.parseDouble(r10)), Number.class, "com.obric.memorydata.plugin"));
        return r7;
    L19:
        return null;
    }

    public final String a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "key");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return "";
    L9:
        JsonObject r1 = new JsonObject();
        r1.add(r4, (JsonElement) ZeusTransformUtils.preCheckCast(this.f9960a, JsonElement.class, "com.obric.memorydata.plugin"));
        String r3 = r1.toString();
        Intrinsics.checkNotNullExpressionValue(r3, "toString(...)");
        return r3;
    L5:
        r0 = false;
        goto L6
    }

    public final void a(List<String> r5, double r6) {
        List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, Params.CONTENT);
        if (r7.isEmpty() == false) goto L5;
        return;
    L5:
        if (r6 >= 0.0d) goto L7;
        return;
    L7:
        if (r6 > 1.0d) goto L16;
        JsonObject r8 = b(r7, r6);
        if (r8 != null) goto L12;
        return;
    L12:
        this.f9960a.add((JsonElement) ZeusTransformUtils.preCheckCast(r8, JsonElement.class, "com.obric.memorydata.plugin"));
        return;
    }
}
