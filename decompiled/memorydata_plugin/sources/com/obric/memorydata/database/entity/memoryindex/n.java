package com.obric.memorydata.database.entity.memoryindex;

import com.bytedance.crash.entity.EventBody;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.obric.memorydata.utils.u;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007J\u0018\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0005J\u0018\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\u0005H\u0002J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\u000b\u001a\u00020\u0005H\u0002J\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0002J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0002¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/database/entity/memoryindex/MemoryStringListCodec;", "", "<init>", "()V", "encode", "", "values", "", "decode", "rawValue", "parseJsonArray", EventBody.KEY_VALUE, "parseLegacyValue", "normalize", "normalizeToken", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f9283a = null;

    static {
        f9283a = new n();
    }

    private n() {
    }

    private final List<String> b(String r6) {
        JsonElement r7 = JsonParser.parseString(r6);     // Catch: RuntimeException -> L26
        if (r7.isJsonArray() == true) goto L7;
        r7 = null;
    L7:
        if (r7 == null) goto L10;
        JsonArray r8 = r7.getAsJsonArray();     // Catch: RuntimeException -> L26
    L11:
        if (r8 != null) goto L13;
        return null;
    L13:
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r9.iterator();
    L15:
        if (r10.hasNext() == false) goto L25;
        JsonElement r2 = (JsonElement) ZeusTransformUtils.preCheckCast(r10.next(), JsonElement.class, "com.obric.memorydata.plugin");
        if (r2.isJsonPrimitive() == true) goto L19;
    L21:
        String r3 = null;
    L22:
        if (r3 == null) goto L15;
        r0.add(r3);
        goto L15
    L19:
        if (r2.getAsJsonPrimitive().isString() == false) goto L21;
        n r4 = f9283a;
        String r5 = r2.getAsString();
        Intrinsics.checkNotNullExpressionValue(r5, "getAsString(...)");
        r3 = r4.d(r5);
        goto L22
    L25:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
    L10:
        r8 = null;
        goto L11
    }

    private final List<String> b(List<String> r5) {
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L9;
        String r2 = d((String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.memorydata.plugin"));
        if (r2 == null) goto L4;
        r0.add(r2);
        goto L4
    L9:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
    }

    private final List<String> c(String r9) {
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"), new char[]{','}, false, 0, 6, null), Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        String r2 = d((String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.memorydata.plugin"));
        if (r2 == null) goto L4;
        r0.add(r2);
        goto L4
    L9:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
    }

    private final String d(String r4) {
        String r3 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        boolean r1 = true;
        if (r3.length() < 2) goto L14;
        if (StringsKt.first((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")) != '\"') goto L9;
        if (StringsKt.last((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")) != '\"') goto L9;
    L12:
        String r5 = r3.substring(1, StringsKt.getLastIndex((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")));
        Intrinsics.checkNotNullExpressionValue(r5, "substring(...)");
        r3 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L9:
        if (StringsKt.first((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")) != '\'') goto L14;
        if (StringsKt.last((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")) == '\'') goto L12;
    L14:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")).length() > 0) goto L17;
        r1 = false;
    L17:
        if (r1 == true) goto L21;
        return null;
    L21:
        return r3;
    }

    public final String a(List<String> r2) {
        List<String> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L7;
        return null;
    L7:
        return u.a().toJson(f9283a.b(r1));
    }

    public final List<String> a(String r7) {
        if (r7 == null) goto L33;
        String r8 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (r8 == null) goto L33;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == true) goto L13;
        r8 = null;
    L13:
        if (r8 == null) goto L33;
        if (StringsKt.startsWith$default(r8, "{", false, 2, null) == false) goto L19;
        return null;
    L19:
        if (StringsKt.startsWith$default(r8, "[", false, 2, null) == false) goto L32;
        List<String> r5 = b(r8);
        if (r5 == null) goto L23;
        return r5;
    L23:
        String r9 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.removeSuffix(StringsKt.removePrefix(r8, (CharSequence) ZeusTransformUtils.preCheckCast("[", CharSequence.class, "com.obric.memorydata.plugin")), (CharSequence) ZeusTransformUtils.preCheckCast("]", CharSequence.class, "com.obric.memorydata.plugin")), CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (StringsKt.startsWith$default((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"), Typography.quote, false, 2, null) == false) goto L26;
    L30:
        return null;
    L26:
        if (StringsKt.startsWith$default((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"), '\'', false, 2, null) == true) goto L30;
        return c(r9);
    L32:
        return c(r8);
    L9:
        r1 = false;
    L33:
        return null;
    }
}
