package com.obric.memorydata.migration.sdk;

import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
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
import kotlin.collections.IntIterator;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u001a\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\u0007H\u0002\u001a\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\u0007H\u0002\u001a\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0002\u001a\u001e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0002\u001a\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007H\u0002\u001a\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u000b\u001a\u00020\u0007H\u0002\u001a(\u0010\u0011\u001a\u00020\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u00152\u0006\u0010\u0016\u001a\u00020\u0001H\u0002\u001aB\u0010\u0017\u001a\u00020\u0018*\u00020\u001826\u0010\u0019\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u001f0\u001a\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"AUTO_URI_MAX_PER_VALUE", "", "AUTO_JSON_MAX_DEPTH", "URI_RE", "Lkotlin/text/Regex;", "extractUrisFromMaybeJson", "", "", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "extractUrisFromText", "parseJsonToList", "json", "key", "parseJsonStringFieldFallback", "unescapeJsonString", EventBody.KEY_VALUE, "parseJsonDeepForUris", "scanJsonAny", "", "", "out", "", "depth", "filterRestoreTables", "Lcom/obric/memorydata/migration/sdk/BackupConfig;", "keep", "Lkotlin/Function2;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "dbName", "tableName", "", "migration_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Regex f11892a = null;

    static {
        f11892a = new Regex("(content://[^\\s\\\"']+|file://[^\\s\\\"']+)");
    }

    public static final b a(b r12, Function2<? super String, ? super String, Boolean> r13) {
        Function2 r14 = (Function2) ZeusTransformUtils.wrapperContextForParams(r13, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "<this>");
        Intrinsics.checkNotNullParameter(r14, "keep");
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r12.a(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L18;
        g r4 = (g) ZeusTransformUtils.preCheckCast(r1.next(), g.class, "com.obric.memorydata.plugin");
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r4.c(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r5 = r3.iterator();
    L7:
        if (r5.hasNext() == false) goto L16;
        Object r8 = r5.next();
        ai r9 = (ai) ZeusTransformUtils.preCheckCast(r8, ai.class, "com.obric.memorydata.plugin");
        boolean r11 = true;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r9.a(), CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L11;
    L13:
        r11 = false;
    L14:
        if (r11 == false) goto L7;
        r7.add(r8);
        goto L7
    L11:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r14.invoke(r4.a(), r9.a()), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L13;
    L16:
        r2.add(g.a(r4, null, null, (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin"), null, 11, null));
        goto L4
    L18:
        return b.a(r12, (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"), null, null, 6, null);
    }

    private static final String a(MatchResult r2) {
        MatchResult r3 = (MatchResult) ZeusTransformUtils.wrapperContextForParams(r2, MatchResult.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "it");
        return StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r3.getValue(), CharSequence.class, "com.obric.memorydata.plugin")).toString();
    }

    public static final /* synthetic */ List a(String r0) {
        return b(r0);
    }

    public static final /* synthetic */ List a(String r0, String r1) {
        return b(r0, r1);
    }

    private static final void a(Object r6, Set<String> r7, int r8) {
        Set r9 = (Set) ZeusTransformUtils.wrapperContextForParams(r7, Set.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
        return;
    L5:
        if (r9.size() < 16) goto L7;
        return;
    L7:
        if (r8 < 10) goto L10;
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r6, JSONObject.class) == false) goto L18;
        Iterator<String> r0 = ((JSONObject) ZeusTransformUtils.preCheckCast(r6, JSONObject.class, "com.obric.memorydata.plugin")).keys();
    L13:
        if (r0.hasNext() == false) goto L47;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");
        a(((JSONObject) ZeusTransformUtils.preCheckCast(r6, JSONObject.class, "com.obric.memorydata.plugin")).opt(r3), r9, r8 + 1);
        if (r9.size() < 16) goto L13;
        return;
    L47:
        return;
    L18:
        if (ZeusTransformUtils.instanceOf(r6, JSONArray.class) == false) goto L26;
        int r1 = 0;
        int r4 = ((JSONArray) ZeusTransformUtils.preCheckCast(r6, JSONArray.class, "com.obric.memorydata.plugin")).length();
    L20:
        if (r1 >= r4) goto L48;
        a(((JSONArray) ZeusTransformUtils.preCheckCast(r6, JSONArray.class, "com.obric.memorydata.plugin")).opt(r1), r9, r8 + 1);
        if (r9.size() >= 16) goto L23;
        r1 = r1 + 1;
        goto L20
    L23:
        return;
    L48:
        return;
    L26:
        if (ZeusTransformUtils.instanceOf(r6, String.class) == false) goto L45;
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(c((String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L29:
        if (r10.hasNext() == false) goto L49;
        String r11 = (String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.memorydata.plugin");
        if (r9.size() >= 16) goto L29;
        r9.add(r11);
        goto L29
    L49:
        return;
    }

    private static final String b(MatchResult r2) {
        MatchResult r3 = (MatchResult) ZeusTransformUtils.wrapperContextForParams(r2, MatchResult.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "it");
        return d((String) ZeusTransformUtils.preCheckCast(r3.getGroupValues().get(1), String.class, "com.obric.memorydata.plugin"));
    }

    private static final List<String> b(String r6) {
        String r7 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        LinkedHashSet r1 = new LinkedHashSet();
        if (StringsKt.startsWith$default(r7, "{", false, 2, null) == false) goto L12;
    L13:
        r1.addAll((Collection) ZeusTransformUtils.preCheckCast(e(r7), Collection.class, "com.obric.memorydata.plugin"));
    L15:
        if (r1.isEmpty() == false) goto L18;
        r1.addAll((Collection) ZeusTransformUtils.preCheckCast(c(r7), Collection.class, "com.obric.memorydata.plugin"));
    L18:
        return CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin"), 16), Iterable.class, "com.obric.memorydata.plugin"));
    L12:
        if (StringsKt.startsWith$default(r7, "[", false, 2, null) == false) goto L15;
    L8:
        return CollectionsKt.emptyList();
    L5:
        r0 = false;
        goto L6
    }

    private static final List<String> b(String r7, String r8) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L18
        Object r2 = new JSONObject(r7).opt(r8);     // Catch: Throwable -> L18
        if (ZeusTransformUtils.instanceOf(r2, JSONArray.class) == false) goto L13;
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(RangesKt.until(0, ((JSONArray) ZeusTransformUtils.preCheckCast(r2, JSONArray.class, "com.obric.memorydata.plugin")).length()), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        Iterator r5 = r3.iterator();     // Catch: Throwable -> L18
    L7:
        if (r5.hasNext() == false) goto L11;
        String r6 = ((JSONArray) ZeusTransformUtils.preCheckCast(r2, JSONArray.class, "com.obric.memorydata.plugin")).optString(((IntIterator) ZeusTransformUtils.preCheckCast(r5, IntIterator.class, "com.obric.memorydata.plugin")).nextInt(), null);     // Catch: Throwable -> L18
        if (r6 == null) goto L7;
        r4.add(r6);     // Catch: Throwable -> L18
        goto L7
    L11:
        List r9 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
    L16:
        Object r10 = Result.m1421constructorimpl(r9);     // Catch: Throwable -> L18
    L20:
        List r11 = CollectionsKt.emptyList();
        if (Result.m1427isFailureimpl(r10) == false) goto L23;
        r10 = r11;
    L23:
        List<String> r12 = (List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.memorydata.plugin");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L27;
        return r12;
    L27:
        return c(r7, r8);
    L13:
        if (ZeusTransformUtils.instanceOf(r2, String.class) == false) goto L15;
        r9 = CollectionsKt.listOf(r2);     // Catch: Throwable -> L18
        goto L16
    L15:
        r9 = CollectionsKt.emptyList();     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r10 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L20
    }

    private static final List<String> c(String r5) {
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L7;
        return CollectionsKt.emptyList();
    L7:
        return CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast(SequencesKt.toList(SequencesKt.filter(SequencesKt.map(Regex.findAll$default(f11892a, (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"), 0, 2, null), $$Lambda$c$vGyMA2DUmtzrNHgScTjeXIa0nE.INSTANCE), (Function1) ZeusTransformUtils.preCheckCast(BackupConfigKt$extractUrisFromText$matches$2.INSTANCE, Function1.class, "com.obric.memorydata.plugin"))), Iterable.class, "com.obric.memorydata.plugin"), 16);
    }

    private static final List<String> c(String r6, String r7) {
        MatchResult r8 = Regex.find$default(new Regex(Typography.quote + Regex.Companion.escape(r7) + "\"\\s*:\\s*(\"(?:\\\\.|[^\"\\\\])*\"|\\[(.*?)\\])", SetsKt.setOf(RegexOption.DOT_MATCHES_ALL)), (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin"), 0, 2, null);
        if (r8 == null) goto L5;
        String r9 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r8.getGroupValues().get(1), String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (StringsKt.startsWith$default(r9, "\"", false, 2, null) == false) goto L10;
        return CollectionsKt.listOf(d(StringsKt.trim(r9, new char[]{Typography.quote})));
    L10:
        return SequencesKt.toList(SequencesKt.map(Regex.findAll$default(new Regex("\"((?:\\\\.|[^\"\\\\])*)\""), (CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"), 0, 2, null), $$Lambda$c$hBKzg0EUx3yf7jdKoWZBN_vZlE.INSTANCE));
    L5:
        return CollectionsKt.emptyList();
    }

    private static final String d(String r12) {
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(r12, "\\/", "/", false, 4, null), "\\\"", "\"", false, 4, null), "\\\\", "\\", false, 4, null);
    }

    private static final List<String> e(String r6) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        if (StringsKt.startsWith$default(StringsKt.trimStart((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")).toString(), "[", false, 2, null) == false) goto L6;
        Object r2 = new JSONArray(r6);     // Catch: Throwable -> L9
    L7:
        LinkedHashSet r7 = new LinkedHashSet();     // Catch: Throwable -> L9
        a(r2, (Set) ZeusTransformUtils.preCheckCast(r7, Set.class, "com.obric.memorydata.plugin"), 0);     // Catch: Throwable -> L9
        Object r8 = Result.m1421constructorimpl(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L9
    L11:
        List r3 = CollectionsKt.emptyList();
        if (Result.m1427isFailureimpl(r8) == false) goto L15;
        r8 = r3;
    L15:
        return (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin");
    L6:
        r2 = new JSONObject(r6);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r8 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    /* JADX INFO: renamed from: lambda$hBKz-g0EUx3yf7jdKoWZBN_vZlE, reason: not valid java name */
    public static /* synthetic */ String m1038lambda$hBKzg0EUx3yf7jdKoWZBN_vZlE(MatchResult r0) {
        return b(r0);
    }

    /* JADX INFO: renamed from: lambda$vGyMA2DUmtzrNHgScTjeXI-a0nE, reason: not valid java name */
    public static /* synthetic */ String m1039lambda$vGyMA2DUmtzrNHgScTjeXIa0nE(MatchResult r0) {
        return a(r0);
    }
}
