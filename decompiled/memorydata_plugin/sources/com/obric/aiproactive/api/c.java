package com.obric.aiproactive.api;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0016\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u001a\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\u001a\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002*\b\u0012\u0004\u0012\u00020\u00020\u0001\u001a\u0010\u0010\b\u001a\u00020\t*\b\u0012\u0004\u0012\u00020\u00020\u0001\u001a\u0012\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\t\u001a\u0012\u0010\f\u001a\u0004\u0018\u00010\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u001a\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00020\u0001\u001a\u001e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0010\u001a \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004\u001a\u0010\u0010\u0013\u001a\u00020\u0014*\b\u0012\u0004\u0012\u00020\u00020\u0001\u001a\u0018\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0004H\u0002\u001a\f\u0010\u001a\u001a\u00020\u0004*\u00020\u0004H\u0002\u001a\f\u0010\u001b\u001a\u00020\u0004*\u00020\u0004H\u0002\"\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"parseAiProactiveActionExecuteList", "", "Lcom/obric/aiproactive/api/AiProactiveActionExecuteItem;", "raw", "", "serializeAiProactiveActionExecuteList", "items", "currentPendingOrLatest", "toCompatActionPayload", "Lcom/obric/aiproactive/api/AiProactiveCompatActionPayload;", "serializeAiProactiveCompatActionPayload", "payload", "parseAiProactiveCompatActionPayload", "markCurrentActionExecuted", "markActionExecutedAt", "actionIndex", "", "updateCurrentActionInstruction", "newInstruction", "areAllExecuted", "", "ACTION_EXECUTE_GSON", "Lcom/google/gson/Gson;", "parseActionListWithGson", "extractJsonStringField", "key", "toJsonStringLiteral", "fromJsonEscapedString", "ai_proactive_api_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Gson f6244a = null;

    static {
        f6244a = new Gson();
    }

    public static final String a(n r7) {
        if (r7 != null) goto L5;
        return null;
    L5:
        String r1 = r7.a();
        if (r1 == null) goto L8;
        String r2 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L9:
        String r3 = r7.b();
        if (r3 == null) goto L12;
        String r4 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L13:
        String r8 = r7.c();
        if (r8 == null) goto L16;
        String r9 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L17:
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin");
        boolean r6 = false;
        if (r5 != null) goto L20;
    L23:
        boolean r10 = true;
    L24:
        if (r10 == false) goto L40;
        CharSequence r11 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin");
        if (r11 != null) goto L28;
    L31:
        boolean r12 = true;
    L32:
        if (r12 == false) goto L40;
        CharSequence r13 = (CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin");
        if (r13 != null) goto L36;
    L37:
        r6 = true;
    L38:
        if (r6 == false) goto L40;
        return null;
    L36:
        if (StringsKt.isBlank(r13) == false) goto L38;
    L28:
        if (StringsKt.isBlank(r11) == true) goto L31;
        r12 = false;
    L40:
        StringBuilder r0 = new StringBuilder();
        r0.append('{');
        r0.append("\"raw_action_list\":");
        String r14 = "null";
        if (r2 == null) goto L44;
        String r15 = d(r2);
        if (r15 == null) goto L44;
    L45:
        r0.append(r15);
        r0.append(",\"current_title\":");
        if (r4 == null) goto L49;
        String r16 = d(r4);
        if (r16 == null) goto L49;
    L50:
        r0.append(r16);
        r0.append(",\"current_instruction\":");
        if (r9 == null) goto L56;
        String r17 = d(r9);
        if (r17 == null) goto L56;
        r14 = r17;
    L56:
        r0.append(r14);
        r0.append('}');
        String r18 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r18, "toString(...)");
        return r18;
    L49:
        r16 = "null";
    L44:
        r15 = "null";
        goto L45
    L20:
        if (StringsKt.isBlank(r5) == true) goto L23;
        r10 = false;
        goto L24
    L16:
        r9 = null;
        goto L17
    L12:
        r4 = null;
        goto L13
    L8:
        r2 = null;
        goto L9
    }

    private static final String a(String r4, String r5) {
        CharSequence r3 = null;
        MatchResult r6 = Regex.find$default(new Regex("\\\"" + r5 + "\\\"\\s*:\\s*(null|\\\"((?:\\\\.|[^\"\\\\])*)\\\")"), (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"), 0, 2, null);
        if (r6 != null) goto L6;
        return null;
    L6:
        if (Intrinsics.areEqual(r6.getGroupValues().get(1), "null") == false) goto L8;
        return null;
    L8:
        CharSequence r7 = (CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(e((String) ZeusTransformUtils.preCheckCast(r6.getGroupValues().get(2), String.class, "com.obric.memorydata.plugin")), CharSequence.class, "com.obric.memorydata.plugin")).toString(), CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r7) == true) goto L13;
        r3 = r7;
    L13:
        return (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin");
    }

    public static final String a(List<b> r13) {
        List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r14, "items");
        if (r14.isEmpty() == false) goto L5;
        return null;
    L5:
        Gson r0 = f6244a;
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r16 = r15.iterator();
    L7:
        if (r16.hasNext() == false) goto L26;
        b r4 = (b) ZeusTransformUtils.preCheckCast(r16.next(), b.class, "com.obric.memorydata.plugin");
        String r5 = r4.a();
        if (r4.f() == false) goto L11;
        String r8 = r5;
    L12:
        String r6 = r4.b();
        if (Intrinsics.areEqual(r4.e(), Params.CONTENT) == false) goto L15;
        String r9 = r6;
    L16:
        String r7 = r4.b();
        if (Intrinsics.areEqual(r4.e(), "execute_instruction") == false) goto L19;
        String r10 = r7;
    L20:
        Integer r11 = Integer.valueOf(r4.c());
        String r12 = r4.d();
        if (r4.g() == false) goto L23;
        String r17 = r12;
    L24:
        r3.add(new a(r8, r9, r10, r11, r17));
        goto L7
    L23:
        r17 = null;
        goto L24
    L19:
        r10 = null;
        goto L20
    L15:
        r9 = null;
        goto L16
    L11:
        r8 = null;
        goto L12
    L26:
        return r0.toJson((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin"));
    }

    public static final List<b> a(String r11) {
        if (r11 == null) goto L5;
        String r12 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L6:
        if (r12 != null) goto L8;
        r12 = "";
    L8:
        String r3 = r12;
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L11;
        List<b> r13 = c(r3);
        if (r13 == null) goto L16;
        return r13;
    L16:
        return CollectionsKt.listOf(new b(r3, r3, 0, null, null, false, false, 120, null));
    L11:
        return CollectionsKt.emptyList();
    L5:
        r12 = null;
        goto L6
    }

    public static final List<b> a(List<b> r17, int r18) {
        List<b> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.isEmpty() == true) goto L24;
        int r3 = 0;
        if (r18 >= 0) goto L7;
    L9:
        boolean r4 = false;
    L10:
        if (r4 == false) goto L24;
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r6 = r2.iterator();
    L14:
        if (r6.hasNext() == false) goto L23;
        Object r7 = r6.next();
        int r8 = r3 + 1;
        if (r3 >= 0) goto L18;
        CollectionsKt.throwIndexOverflow();
    L18:
        b r9 = (b) ZeusTransformUtils.preCheckCast(r7, b.class, "com.obric.memorydata.plugin");
        if (r3 != r18) goto L21;
        r9 = b.a(r9, null, null, 1, null, null, false, false, 123, null);
    L21:
        r5.add(r9);
        r3 = r8;
        goto L14
    L23:
        return (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin");
    L7:
        if (r18 >= ((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.memorydata.plugin")).size()) goto L9;
        r4 = true;
    L24:
        return r1;
    }

    public static final List<b> a(List<b> r18, String r19) {
        List<b> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.isEmpty() == false) goto L5;
        return r1;
    L5:
        Iterator<b> r3 = r1.iterator();
        int r4 = 0;
        int r5 = 0;
    L7:
        if (r3.hasNext() == false) goto L12;
        if (((b) ZeusTransformUtils.preCheckCast(r3.next(), b.class, "com.obric.memorydata.plugin")).h() == true) goto L13;
        r5 = r5 + 1;
    L13:
        Integer r6 = Integer.valueOf(r5);
        if (((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.memorydata.plugin")).intValue() < 0) goto L16;
        boolean r7 = true;
    L17:
        String r8 = null;
        if (r7 == true) goto L21;
        r6 = null;
    L21:
        if (r6 == null) goto L23;
        int r9 = r6.intValue();
    L24:
        if (r19 == null) goto L26;
        r8 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r19, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L26:
        if (r8 != null) goto L28;
        r8 = "";
    L28:
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r0.iterator();
    L30:
        if (r10.hasNext() == false) goto L39;
        Object r11 = r10.next();
        int r17 = r4 + 1;
        if (r4 >= 0) goto L34;
        CollectionsKt.throwIndexOverflow();
    L34:
        b r12 = (b) ZeusTransformUtils.preCheckCast(r11, b.class, "com.obric.memorydata.plugin");
        if (r4 != r9) goto L37;
        r12 = b.a(r12, null, r8, 0, null, null, false, false, 121, null);
    L37:
        r2.add(r12);
        r4 = r17;
        goto L30
    L39:
        return (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin");
    L23:
        r9 = CollectionsKt.getLastIndex(r1);
        goto L24
    L16:
        r7 = false;
        goto L17
    L12:
        r5 = -1;
        goto L13
    }

    public static final b b(List<b> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r2 = r0.next();
        if (((b) ZeusTransformUtils.preCheckCast(r2, b.class, "com.obric.memorydata.plugin")).h() == false) goto L4;
    L9:
        b r1 = (b) ZeusTransformUtils.preCheckCast(r2, b.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L12;
        return r1;
    L12:
        return (b) ZeusTransformUtils.preCheckCast(CollectionsKt.lastOrNull(r5), b.class, "com.obric.memorydata.plugin");
    L8:
        r2 = null;
        goto L9
    }

    public static final n b(String r6) {
        if (r6 == null) goto L5;
        String r7 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L6:
        if (r7 != null) goto L9;
        r7 = "";
    L9:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L11;
        return null;
    L11:
        n r2 = new n(a(r7, "raw_action_list"), a(r7, "current_title"), a(r7, "current_instruction"));
        CharSequence r8 = (CharSequence) ZeusTransformUtils.preCheckCast(r2.a(), CharSequence.class, "com.obric.memorydata.plugin");
        boolean r3 = false;
        if (r8 != null) goto L14;
    L17:
        boolean r9 = true;
    L18:
        if (r9 == false) goto L35;
        CharSequence r10 = (CharSequence) ZeusTransformUtils.preCheckCast(r2.b(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r10 != null) goto L22;
    L25:
        boolean r11 = true;
    L26:
        if (r11 == false) goto L35;
        CharSequence r12 = (CharSequence) ZeusTransformUtils.preCheckCast(r2.c(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r12 != null) goto L30;
    L33:
        boolean r13 = true;
    L34:
        if (r13 == false) goto L35;
    L36:
        if (r3 == true) goto L38;
        return null;
    L38:
        return r2;
    L30:
        if (StringsKt.isBlank(r12) == true) goto L33;
        r13 = false;
        goto L34
    L22:
        if (StringsKt.isBlank(r10) == true) goto L25;
        r11 = false;
    L35:
        r3 = true;
        goto L36
    L14:
        if (StringsKt.isBlank(r8) == true) goto L17;
        r9 = false;
        goto L18
    L5:
        r7 = null;
        goto L6
    }

    public static final n c(List<b> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        b r0 = b(r6);
        String r7 = a(r6);
        String r2 = null;
        if (r0 == null) goto L11;
        String r3 = r0.a();
        if (r3 == null) goto L11;
        String r4 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (r4 == null) goto L11;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L11;
    L12:
        if (r0 == null) goto L21;
        String r1 = r0.b();
        if (r1 == null) goto L21;
        String r8 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (r8 == null) goto L21;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L21;
        r2 = r8;
    L21:
        return new n(r7, r4, r2);
    L11:
        r4 = null;
        goto L12
    }

    private static final List<b> c(String r18) {
        String r0 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        Object r5 = null;
        if (StringsKt.startsWith$default(r0, "[", false, 2, null) == true) goto L5;
    L129:
        return null;
    L5:
        if (StringsKt.endsWith$default(r0, "]", false, 2, null) == false) goto L129;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L121
        JsonArray r1 = JsonParser.parseString(r0).getAsJsonArray();     // Catch: Throwable -> L121
        Intrinsics.checkNotNull(r1);     // Catch: Throwable -> L121
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L121
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L121
        Iterator r6 = r3.iterator();     // Catch: Throwable -> L121
    L9:
        if (r6.hasNext() == false) goto L119;
        JsonElement r7 = (JsonElement) ZeusTransformUtils.preCheckCast(r6.next(), JsonElement.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L121
        String r8 = "";
        if (r7.isJsonObject() == false) goto L102;
        a r9 = (a) ZeusTransformUtils.preCheckCast(f6244a.fromJson(r7, a.class), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L121
        String r10 = r9.a();     // Catch: Throwable -> L121
        if (r10 == null) goto L16;
        CharSequence r11 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin")).toString();     // Catch: Throwable -> L121
    L17:
        if (r11 != null) goto L19;
        r11 = "";
    L19:
        String r12 = r9.b();     // Catch: Throwable -> L121
        if (r12 == null) goto L22;
        CharSequence r13 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin")).toString();     // Catch: Throwable -> L121
    L23:
        if (r13 != null) goto L25;
        r13 = "";
    L25:
        String r14 = r9.c();     // Catch: Throwable -> L121
        if (r14 == null) goto L28;
        String r15 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin")).toString();     // Catch: Throwable -> L121
    L29:
        if (r15 != null) goto L31;
        r15 = "";
    L31:
        CharSequence r16 = (CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L121
        if (StringsKt.isBlank(r16) == true) goto L35;
        r13 = r16;
    L35:
        String r17 = (String) ZeusTransformUtils.preCheckCast(r13, String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L121
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L38;
    L40:
        CharSequence r19 = (CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L121
        if (StringsKt.isBlank(r19) == false) goto L43;
        r19 = r17;
    L43:
        String r110 = (String) ZeusTransformUtils.preCheckCast(r19, String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L121
        CharSequence r20 = (CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L121
        if (StringsKt.isBlank(r20) == true) goto L47;
        r11 = r20;
    L47:
        String r111 = (String) ZeusTransformUtils.preCheckCast(r11, String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L121
        Integer r21 = r9.d();     // Catch: Throwable -> L121
        if (r21 == null) goto L50;
        int r112 = r21.intValue();     // Catch: Throwable -> L121
    L51:
        String r22 = r9.e();     // Catch: Throwable -> L121
        if (r22 == null) goto L54;
        String r23 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r22, CharSequence.class, "com.obric.memorydata.plugin")).toString();     // Catch: Throwable -> L121
    L55:
        if (r23 == null) goto L58;
        r8 = r23;
    L58:
        CharSequence r24 = (CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L121
        if (StringsKt.isBlank(r24) == false) goto L61;
        r24 = "execute";
    L61:
        String r113 = (String) ZeusTransformUtils.preCheckCast(r24, String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L121
        CharSequence r25 = (CharSequence) ZeusTransformUtils.preCheckCast(r9.c(), CharSequence.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L121
        if (r25 != null) goto L64;
    L67:
        boolean r26 = true;
    L69:
        if (r26 == true) goto L71;
    L70:
        String r114 = "execute_instruction";
    L80:
        CharSequence r27 = (CharSequence) ZeusTransformUtils.preCheckCast(r9.a(), CharSequence.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L121
        if (r27 != null) goto L83;
    L86:
        boolean r28 = true;
    L87:
        if (r28 == true) goto L89;
        boolean r115 = true;
    L90:
        CharSequence r29 = (CharSequence) ZeusTransformUtils.preCheckCast(r9.e(), CharSequence.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L121
        if (r29 != null) goto L93;
    L96:
        boolean r30 = true;
    L97:
        if (r30 == true) goto L99;
        boolean r116 = true;
    L100:
        b r31 = new b(r110, r111, r112, r113, r114, r115, r116);     // Catch: Throwable -> L121
    L117:
        if (r31 == null) goto L9;
        r4.add(r31);     // Catch: Throwable -> L121
        goto L9
    L99:
        r116 = false;
        goto L100
    L93:
        if (StringsKt.isBlank(r29) == true) goto L96;
        r30 = false;
        goto L97
    L89:
        r115 = false;
        goto L90
    L83:
        if (StringsKt.isBlank(r27) == true) goto L86;
        r28 = false;
        goto L87
    L71:
        CharSequence r32 = (CharSequence) ZeusTransformUtils.preCheckCast(r9.b(), CharSequence.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L121
        if (r32 != null) goto L74;
    L77:
        boolean r33 = true;
    L78:
        if (r33 == true) goto L70;
        r114 = Params.CONTENT;
        goto L80
    L74:
        if (StringsKt.isBlank(r32) == true) goto L77;
        r33 = false;
        goto L78
    L64:
        if (StringsKt.isBlank(r25) == true) goto L67;
        r26 = false;
        goto L69
    L54:
        r23 = null;
        goto L55
    L50:
        r112 = 0;
        goto L51
    L38:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L40;
    L116:
        r31 = null;
        goto L117
    L28:
        r15 = null;
        goto L29
    L22:
        r13 = null;
        goto L23
    L16:
        r11 = null;
        goto L17
    L102:
        if (r7.isJsonPrimitive() == false) goto L116;
        if (r7.getAsJsonPrimitive().isString() == false) goto L116;
        String r34 = r7.getAsString();     // Catch: Throwable -> L121
        if (r34 == null) goto L108;
        String r35 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r34, CharSequence.class, "com.obric.memorydata.plugin")).toString();     // Catch: Throwable -> L121
    L109:
        if (r35 != null) goto L111;
        String r117 = "";
    L113:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r117, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L116;
        r31 = new b(r117, r117, 0, "execute", null, false, false, 112, null);     // Catch: Throwable -> L121
        goto L117
    L111:
        r117 = r35;
        goto L113
    L108:
        r35 = null;
        goto L109
    L119:
        Object r36 = Result.m1421constructorimpl((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L121
    L124:
        if (Result.m1427isFailureimpl(r36) == true) goto L128;
        r5 = r36;
    L128:
        return (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin");
    L121:
        th = move-exception;
        Result.Companion r37 = Result.Companion;
        r36 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L124
    }

    private static final String d(String r5) {
        StringBuilder r1 = new StringBuilder(r5.length() + 2);
        r1.append(Typography.quote);
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin");
        int r2 = 0;
    L4:
        if (r2 >= r6.length()) goto L22;
        char r3 = r6.charAt(r2);
        if (r3 != '\t') goto L8;
        String r4 = "\\t";
    L20:
        r1.append(r4);
    L21:
        r2 = r2 + 1;
        goto L4
    L8:
        if (r3 != '\n') goto L10;
        r4 = "\\n";
        goto L20
    L10:
        if (r3 == '\r') goto L17;
        if (r3 != '\"') goto L13;
        r4 = "\\\"";
        goto L20
    L13:
        if (r3 == '\\') goto L15;
        r1.append(r3);
        goto L21
    L15:
        r4 = "\\\\";
        goto L20
    L17:
        r4 = "\\r";
        goto L20
    L22:
        r1.append(Typography.quote);
        String r7 = r1.toString();
        Intrinsics.checkNotNullExpressionValue(r7, "toString(...)");
        return r7;
    }

    public static final List<b> d(List<b> r6) {
        List<b> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "<this>");
        if (r7.isEmpty() == false) goto L5;
        return r7;
    L5:
        Iterator<b> r0 = r7.iterator();
        boolean r2 = false;
        int r3 = 0;
    L7:
        if (r0.hasNext() == false) goto L12;
        if (((b) ZeusTransformUtils.preCheckCast(r0.next(), b.class, "com.obric.memorydata.plugin")).h() == true) goto L13;
        r3 = r3 + 1;
    L13:
        Integer r1 = Integer.valueOf(r3);
        if (((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.memorydata.plugin")).intValue() < 0) goto L16;
        r2 = true;
    L16:
        if (r2 == true) goto L19;
        r1 = null;
    L19:
        if (r1 == null) goto L21;
        int r4 = r1.intValue();
    L23:
        return a(r7, r4);
    L21:
        r4 = CollectionsKt.getLastIndex(r7);
        goto L23
    L12:
        r3 = -1;
        goto L13
    }

    private static final String e(String r6) {
        StringBuilder r1 = new StringBuilder(r6.length());
        int r0 = 0;
    L4:
        if (r0 >= r6.length()) goto L27;
        char r2 = r6.charAt(r0);
        if (r2 != '\\') goto L26;
        int r4 = r0 + 1;
        if (r4 >= r6.length()) goto L26;
        char r3 = r6.charAt(r4);
        if (r3 == '\"') goto L24;
        if (r3 != '\\') goto L13;
        r1.append('\\');
    L25:
        r0 = r0 + 2;
        goto L4
    L13:
        if (r3 != 'n') goto L15;
        r3 = '\n';
    L22:
        r1.append(r3);
        goto L25
    L15:
        if (r3 != 'r') goto L17;
        r3 = '\r';
        goto L22
    L17:
        if (r3 != 't') goto L22;
        r3 = '\t';
        goto L22
    L24:
        r1.append(Typography.quote);
    L26:
        r1.append(r2);
        r0 = r0 + 1;
        goto L4
    L27:
        String r7 = r1.toString();
        Intrinsics.checkNotNullExpressionValue(r7, "toString(...)");
        return r7;
    }

    public static final boolean e(List<b> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L18;
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, Collection.class) == true) goto L7;
    L9:
        Iterator r8 = r7.iterator();
    L11:
        if (r8.hasNext() == false) goto L8;
        if ((!((b) ZeusTransformUtils.preCheckCast(r8.next(), b.class, "com.obric.memorydata.plugin")).h()) == true) goto L11;
        boolean r9 = false;
    L15:
        if (r9 == false) goto L18;
        return true;
    L8:
        r9 = true;
        goto L15
    L7:
        if (((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L9;
    L18:
        return false;
    }
}
