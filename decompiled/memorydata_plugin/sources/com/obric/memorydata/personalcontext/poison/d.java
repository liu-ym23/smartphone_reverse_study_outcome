package com.obric.memorydata.personalcontext.poison;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0014\u0010\u000f\u001a\u00020\u0007*\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\tH\u0002J\u0014\u0010\u0011\u001a\u00020\t*\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\tH\u0002¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/personalcontext/poison/EntityPoisonLabelPayloadParser;", "", "<init>", "()V", "parse", "Lcom/obric/memorydata/personalcontext/poison/EntityPoisonLabelBatch;", "labelVersion", "", "operateList", "", "(Ljava/lang/Integer;Ljava/lang/String;)Lcom/obric/memorydata/personalcontext/poison/EntityPoisonLabelBatch;", "parseOperation", "Lcom/obric/memorydata/personalcontext/poison/EntityPoisonLabelOperation;", "json", "Lcom/google/gson/JsonObject;", "requiredInt", ActivityLifecycle.NAME, "requiredString", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f12250a = null;

    static {
        f12250a = new d();
    }

    private d() {
    }

    private final int a(JsonObject r4, String r5) {
        JsonElement r3 = r4.get(r5);
        if (r3 != null) goto L5;
    L9:
        boolean r6 = false;
    L10:
        if (r6 == false) goto L26;
        if (r3.getAsJsonPrimitive().isNumber() == false) goto L24;
        String r7 = r3.getAsString();
        Intrinsics.checkNotNull(r7);
        if (new Regex("-?(0|[1-9][0-9]*)").matches((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L22;
        Integer r8 = StringsKt.toIntOrNull(r7);
        if (r8 == null) goto L20;
        return r8.intValue();
    L20:
        throw new IllegalArgumentException(r5 + " must be an integer");
    L22:
        throw new IllegalArgumentException((r5 + " must be an integer").toString());
    L24:
        throw new IllegalArgumentException((r5 + " must be an integer").toString());
    L26:
        throw new IllegalArgumentException((r5 + " is required").toString());
    L5:
        if (r3.isJsonNull() == true) goto L9;
        if (r3.isJsonPrimitive() == false) goto L9;
        r6 = true;
        goto L10
    }

    private final c a(JsonObject r7) {
        int r0 = a(r7, "entityType");
        int r1 = a(r7, "poisonLabel");
        String r2 = b(r7, "contentHash");
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin");
        if (new Regex("[0-9a-fA-F]{64}").matches(r3) == false) goto L7;
        String r6 = b(r7, "entityId");
        String r8 = r2.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r8, "toLowerCase(...)");
        return new c(r0, r6, r8, r1);
    L7:
        throw new IllegalArgumentException("contentHash must be a SHA-256 hex string".toString());
    }

    private final String b(JsonObject r3, String r4) {
        JsonElement r2 = r3.get(r4);
        if (r2 != null) goto L5;
    L9:
        boolean r0 = false;
    L10:
        if (r0 == false) goto L17;
        String r5 = r2.getAsString();
        Intrinsics.checkNotNull(r5);
        if ((true ^ StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L15;
        return r5;
    L15:
        throw new IllegalArgumentException((r4 + " must not be blank").toString());
    L17:
        throw new IllegalArgumentException((r4 + " is required").toString());
    L5:
        if (r2.isJsonNull() == true) goto L9;
        if (r2.isJsonPrimitive() == false) goto L9;
        r0 = true;
        goto L10
    }

    public final b a(Integer r6, String r7) {
        Intrinsics.checkNotNullParameter(r7, "operateList");
        JsonArray r8 = new JsonParser().parse(r7).getAsJsonArray();     // Catch: Exception -> L15
        int r0 = 0;
        Intrinsics.checkNotNull(r8);
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r9.iterator();
    L6:
        if (r10.hasNext() == false) goto L14;
        JsonElement r2 = (JsonElement) ZeusTransformUtils.preCheckCast(r10.next(), JsonElement.class, "com.obric.memorydata.plugin");
        d r3 = f12250a;     // Catch: Exception -> L10
        JsonObject r4 = r2.getAsJsonObject();     // Catch: Exception -> L10
        Intrinsics.checkNotNullExpressionValue(r4, "getAsJsonObject(...)");     // Catch: Exception -> L10
        c r5 = r3.a(r4);     // Catch: Exception -> L10
    L11:
        if (r5 == null) goto L6;
        r1.add(r5);
    L10:
        r0 = r0 + 1;
        r5 = null;
        goto L11
    L14:
        return new b(r6, (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin"), r0);
    L15:
        e = move-exception;
        throw new IllegalArgumentException("operateList must be a JSON array", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }
}
