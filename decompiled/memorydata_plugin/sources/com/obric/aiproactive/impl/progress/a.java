package com.obric.aiproactive.impl.progress;

import androidx.exifinterface.media.ExifInterface;
import com.obric.aiproactive.api.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000bJ\"\u0010\u0010\u001a\u00020\u00112\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\u00122\u0006\u0010\u000e\u001a\u00020\nJ&\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\n2\u0016\u0010\u0016\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0017J<\u0010\u0019\u001a\u00020\n2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\r0\u001b2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\u00122\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00180\u0017J6\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001f2\u0016\u0010\u0016\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00172\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\r0!H\u0002J$\u0010\"\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001f2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/obric/aiproactive/impl/progress/AgentRunCancellationReceiptLedger;", "", "<init>", "()V", "MAX_RECEIPTS", "", "trim", "", "receipts", "", "", "", "minimalCancelledRun", "Lcom/obric/aiproactive/api/AiProactiveAgentRunDto;", "executionId", "cancelledAtMillis", "isCancellationRecorded", "", "", "decode", "Lcom/obric/aiproactive/impl/progress/PersistedAgentRunState;", "raw", "parseRun", "Lkotlin/Function1;", "Lorg/json/JSONObject;", "encode", "runs", "", "encodeRun", "restoreRuns", "array", "Lorg/json/JSONArray;", "destination", "", "restoreReceipts", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6494a = null;

    /* JADX INFO: renamed from: com.obric.aiproactive.impl.progress.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class C0286a<T> implements Comparator {
        public C0286a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast((Long) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), Long.class, "com.obric.memorydata.plugin"), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast((Long) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r2, Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), Long.class, "com.obric.memorydata.plugin"), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class b<T> implements Comparator {
        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(T r4, T r5) {
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.memorydata.plugin")).e()), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((g) ZeusTransformUtils.preCheckCast(r4, g.class, "com.obric.memorydata.plugin")).e()), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class c<T> implements Comparator {
        public c() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast((Long) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), Long.class, "com.obric.memorydata.plugin"), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast((Long) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r2, Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), Long.class, "com.obric.memorydata.plugin"), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        f6494a = new a();
    }

    private a() {
    }

    private final void a(JSONArray r9, Map<String, Long> r10) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.memorydata.plugin");
        int r11 = r9.length();
        int r1 = 0;
    L3:
        if (r1 >= r11) goto L13;
        JSONObject r2 = r9.optJSONObject(r1);
        if (r2 == null) goto L12;
        String r3 = r2.optString("execution_id");
        Intrinsics.checkNotNullExpressionValue(r3, "optString(...)");
        String r4 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        long r5 = RangesKt.coerceAtLeast(r2.optLong("cancelled_at"), 0);
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L12;
        if (r5 <= 0) goto L12;
        r8.put(r4, Long.valueOf(r5));
    L12:
        r1 = r1 + 1;
        goto L3
    }

    private final void a(JSONArray r5, Function1<? super JSONObject, g> r6, List<g> r7) {
        Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        int r9 = r5.length();
        int r1 = 0;
    L3:
        if (r1 >= r9) goto L8;
        g r2 = (g) ZeusTransformUtils.preCheckCast(r4.invoke(r5.optJSONObject(r1)), g.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L7;
        r8.add(r2);
    L7:
        r1 = r1 + 1;
        goto L3
    }

    public final g a(String r11, long r12) {
        Intrinsics.checkNotNullParameter(r11, "executionId");
        return new g(r11, "", "cancelled", r12, r12, 0, CollectionsKt.emptyList());
    }

    public final d a(String r8, Function1<? super JSONObject, g> r9) {
        Function1<? super JSONObject, g> r10 = (Function1) ZeusTransformUtils.wrapperContextForParams(r9, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "raw");
        Intrinsics.checkNotNullParameter(r10, "parseRun");
        List<g> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        LinkedHashMap r2 = new LinkedHashMap();
        Object r11 = new JSONTokener(r8).nextValue();
        if (ZeusTransformUtils.instanceOf(r11, JSONArray.class) == false) goto L6;
        a((JSONArray) ZeusTransformUtils.preCheckCast(r11, JSONArray.class, "com.obric.memorydata.plugin"), r10, r0);
    L14:
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r14 = r12.iterator();
    L16:
        if (r14.hasNext() == false) goto L20;
        Object r3 = r14.next();
        if (Intrinsics.areEqual(((g) ZeusTransformUtils.preCheckCast(r3, g.class, "com.obric.memorydata.plugin")).c(), "cancelled") == false) goto L16;
        r13.add(r3);
        goto L16
    L20:
        Iterator r15 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L22:
        if (r15.hasNext() == false) goto L26;
        g r16 = (g) ZeusTransformUtils.preCheckCast(r15.next(), g.class, "com.obric.memorydata.plugin");
        if (((Map) ZeusTransformUtils.preCheckCast(r2, Map.class, "com.obric.memorydata.plugin")).containsKey(r16.a()) == true) goto L22;
        ((Map) ZeusTransformUtils.preCheckCast(r2, Map.class, "com.obric.memorydata.plugin")).put(r16.a(), Long.valueOf(r16.e()));
        goto L22
    L26:
        a((Map) ZeusTransformUtils.preCheckCast(r2, Map.class, "com.obric.memorydata.plugin"));
        return new d(r0, (Map) ZeusTransformUtils.preCheckCast(r2, Map.class, "com.obric.memorydata.plugin"));
    L6:
        if (ZeusTransformUtils.instanceOf(r11, JSONObject.class) == false) goto L14;
        JSONArray r4 = ((JSONObject) ZeusTransformUtils.preCheckCast(r11, JSONObject.class, "com.obric.memorydata.plugin")).optJSONArray("runs");
        if (r4 != null) goto L10;
        r4 = new JSONArray();
    L10:
        a(r4, r10, r0);
        JSONArray r17 = ((JSONObject) ZeusTransformUtils.preCheckCast(r11, JSONObject.class, "com.obric.memorydata.plugin")).optJSONArray("cancelled_receipts");
        if (r17 != null) goto L13;
        r17 = new JSONArray();
    L13:
        a(r17, (Map) ZeusTransformUtils.preCheckCast(r2, Map.class, "com.obric.memorydata.plugin"));
        goto L14
    }

    public final String a(Collection<g> r6, Map<String, Long> r7, Function1<? super g, ? extends JSONObject> r8) {
        Collection r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r6, Collection.class, "com.obric.memorydata.plugin");
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
        Function1 r10 = (Function1) ZeusTransformUtils.wrapperContextForParams(r8, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "runs");
        Intrinsics.checkNotNullParameter(r9, "receipts");
        Intrinsics.checkNotNullParameter(r10, "encodeRun");
        JSONObject r1 = new JSONObject();
        JSONArray r2 = new JSONArray();
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new b(), Comparator.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r2.put(r10.invoke((g) ZeusTransformUtils.preCheckCast(r11.next(), g.class, "com.obric.memorydata.plugin")));
        goto L4
    L6:
        Unit r12 = Unit.INSTANCE;
        r1.put("runs", r2);
        JSONArray r13 = new JSONArray();
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast(r9.entrySet(), Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new C0286a(), Comparator.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L8:
        if (r14.hasNext() == false) goto L10;
        Map.Entry r15 = (Map.Entry) ZeusTransformUtils.preCheckCast(r14.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r16 = (String) ZeusTransformUtils.preCheckCast(r15.getKey(), String.class, "com.obric.memorydata.plugin");
        long r3 = ((Number) ZeusTransformUtils.preCheckCast(r15.getValue(), Number.class, "com.obric.memorydata.plugin")).longValue();
        JSONObject r17 = new JSONObject();
        r17.put("execution_id", r16);
        r17.put("cancelled_at", r3);
        r13.put(r17);
        goto L8
    L10:
        Unit r18 = Unit.INSTANCE;
        r1.put("cancelled_receipts", r13);
        String r19 = r1.toString();
        Intrinsics.checkNotNullExpressionValue(r19, "toString(...)");
        return r19;
    }

    public final void a(Map<String, Long> r5) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "receipts");
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast(r4.entrySet(), Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new c(), Comparator.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"), 64), Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new HashSet(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        r1.add((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getKey(), String.class, "com.obric.memorydata.plugin"));
        goto L4
    L6:
        HashSet r8 = (HashSet) ZeusTransformUtils.preCheckCast(r1, HashSet.class, "com.obric.memorydata.plugin");
        r4.keySet().retainAll((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.memorydata.plugin"));
    }

    public final boolean a(Map<String, Long> r2, String r3) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "receipts");
        Intrinsics.checkNotNullParameter(r3, "executionId");
        return r1.containsKey(r3);
    }
}
