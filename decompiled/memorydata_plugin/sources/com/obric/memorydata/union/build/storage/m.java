package com.obric.memorydata.union.build.storage;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.capabilitykit.common.Ext;
import com.obric.memorydata.database.dao.MemoryProcessUserInsightDao;
import com.obric.memorydata.database.dao.SemanticStateDao;
import com.obric.memorydata.database.dao.UnionSemanticTypeSummaryDao;
import com.obric.memorydata.database.entity.da;
import com.obric.memorydata.database.entity.ik;
import com.obric.memorydata.database.entity.iv;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.database.manager.PersonalMemoryFrameDb;
import com.obric.memorydata.database.manager.t;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rH\u0002J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b2\u0006\u0010\u0012\u001a\u00020\tH\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0007H\u0002J\u001c\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u0012\u001a\u00020\tH\u0002J\u001c\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000f0\u00172\u0006\u0010\u0012\u001a\u00020\tH\u0002J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J$\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\t2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00180\u0017H\u0002J\u0018\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\"H\u0002J,\u0010#\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\r2\u0006\u0010$\u001a\u00020%2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00180\u0017H\u0002¨\u0006'"}, d2 = {"Lcom/obric/memorydata/union/build/storage/SemanticConsumerCommitManager;", "", "<init>", "()V", "commit", "Lcom/obric/memorydata/union/build/storage/SemanticConsumerCommitResult;", "payload", "", "parse", "Lcom/obric/memorydata/union/build/storage/SemanticConsumerCommitRequest;", "parseExpectedGroups", "", "array", "Lorg/json/JSONArray;", "successfulRecordCount", "", "outputs", "replacementOutputGroups", Ext.KEY_REQUEST, "clearConsumerOutput", "", "consumerId", "captureInterestSummaryHistory", "", "Lcom/obric/memorydata/union/build/storage/InterestSummaryWriteValues;", "replacementInterestSummaryCounts", "reportSummaryCountShrink", "metrics", "Lcom/obric/memorydata/union/build/storage/SummaryCountShrink;", "applyOutputs", "interestSummaryHistory", "applyUserInsight", "items", "record", "Lorg/json/JSONObject;", "applyInterestSummary", "replaceExisting", "", "history", "memory_build_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f13129a = null;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13130a = null;

        static {
            int[] r0 = new int[ConsumerCommitState.values().length];
            r0[ConsumerCommitState.ALREADY_COMMITTED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[ConsumerCommitState.CURSOR_CHANGED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[ConsumerCommitState.APPLY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f13130a = r0;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class b<T> implements Comparator {
        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((iv) ZeusTransformUtils.preCheckCast(r2, iv.class, "com.obric.memorydata.plugin")).a()), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((iv) ZeusTransformUtils.preCheckCast(r3, iv.class, "com.obric.memorydata.plugin")).a()), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        f13129a = new m();
    }

    private m() {
    }

    private final int a(o r9, Map<String, com.obric.memorydata.union.build.storage.b> r10) {
        Map<String, com.obric.memorydata.union.build.storage.b> r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.memorydata.plugin");
        int r0 = r9.d().length();
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r0) goto L27;
        JSONObject r4 = r9.d().optJSONObject(r2);
        if (r4 == null) goto L26;
        if (Intrinsics.areEqual(r4.optString("status"), "SUCCESS") == false) goto L26;
        if (Intrinsics.areEqual(r4.optString("business_id"), r9.a()) == false) goto L25;
        JSONObject r5 = r4.optJSONObject("payload");
        if (r5 == null) goto L15;
        JSONArray r6 = r5.optJSONArray("items");
        if (r6 == null) goto L15;
    L16:
        String r7 = r9.a();
        if (Intrinsics.areEqual(r7, "user_insight") == false) goto L20;
        int r8 = a(r6, r4);
    L23:
        r3 = r3 + r8;
        goto L26
    L20:
        if (Intrinsics.areEqual(r7, "interest_summary") == false) goto L22;
        r8 = a(r6, r9.e(), r11);
        goto L23
    L22:
        r8 = 0;
    L15:
        r6 = new JSONArray();
        goto L16
    L25:
        throw new IllegalArgumentException("consumer output business mismatch".toString());
    L26:
        r2 = r2 + 1;
        goto L3
    L27:
        return r3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final int a(JSONArray r29, JSONObject r30) {
        MemoryProcessUserInsightDao r1 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getMemoryProcessUserInsightDao();
        long r13 = System.currentTimeMillis();
        JSONArray r2 = r30.optJSONArray("source_event_ids");
        if (r2 == null) goto L8;
        String r3 = r2.toString();
        if (r3 == null) goto L8;
        String r20 = r3;
    L9:
        int r15 = r29.length();
        int r10 = 0;
        int r22 = 0;
    L10:
        if (r10 >= r15) goto L48;
        JSONObject r4 = r29.optJSONObject(r10);
        if (r4 == null) goto L25;
        String r5 = r4.optString("summary");
        Intrinsics.checkNotNullExpressionValue(r5, "optString(...)");
        String r6 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        String r7 = r4.optString("description", r6);
        Intrinsics.checkNotNullExpressionValue(r7, "optString(...)");
        String r8 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        boolean r9 = true;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L17;
        boolean r11 = true;
    L18:
        if (r11 == true) goto L20;
    L26:
        String r12 = "consumer_" + r13 + '_' + r10 + '_' + UUID.randomUUID();
        CharSequence r14 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin");
        if (r14.length() != 0) goto L29;
        boolean r16 = true;
    L30:
        if (r16 == false) goto L32;
        r14 = r8;
    L32:
        String r17 = (String) ZeusTransformUtils.preCheckCast(r14, String.class, "com.obric.memorydata.plugin");
        CharSequence r18 = (CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin");
        if (r18.length() == 0) goto L36;
        r9 = false;
    L36:
        if (r9 == true) goto L39;
        r6 = r18;
    L39:
        String r19 = (String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.memorydata.plugin");
        JSONArray r21 = r4.optJSONArray("evidence_refs");
        if (r21 == null) goto L45;
        String r23 = r21.toString();
        if (r23 == null) goto L45;
        String r26 = r23;
    L46:
        String r24 = r30.optString("log_id");
        Intrinsics.checkNotNullExpressionValue(r24, "optString(...)");
        long r25 = r13;
        r1.insert(new da(0, r12, r17, r19, null, r26, r20, false, r24, r13, r25, 145, null));
        r22 = r22 + 1;
    L47:
        r10 = r10 + 1;
        r13 = r25;
        r15 = r15;
    L45:
        r26 = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        goto L46
    L29:
        r16 = false;
        goto L30
    L20:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L22;
        boolean r27 = true;
    L23:
        if (r27 == true) goto L25;
    L22:
        r27 = false;
        goto L23
    L17:
        r11 = false;
    L25:
        r25 = r13;
        goto L47
    L48:
        return r22;
    L8:
        r20 = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final int a(JSONArray r24, boolean r25, Map<String, com.obric.memorydata.union.build.storage.b> r26) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r26, Map.class, "com.obric.memorydata.plugin");
        UnionSemanticTypeSummaryDao r3 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getUnionSemanticTypeSummaryDao();
        int r4 = (int) (System.currentTimeMillis() / 1000);
        int r5 = r24.length();
        int r15 = 0;
        int r18 = 0;
    L3:
        if (r15 >= r5) goto L38;
        JSONObject r6 = r24.optJSONObject(r15);
        if (r6 == null) goto L37;
        String r7 = r6.optString("type");
        Intrinsics.checkNotNullExpressionValue(r7, "optString(...)");
        String r9 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        String r8 = r6.optString("tree_path", r6.optString("treePath"));
        Intrinsics.checkNotNullExpressionValue(r8, "optString(...)");
        String r10 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        String r11 = r6.optString("summary");
        Intrinsics.checkNotNullExpressionValue(r11, "optString(...)");
        String r12 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        String r13 = r6.optString("description", r12);
        Intrinsics.checkNotNullExpressionValue(r13, "optString(...)");
        String r14 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (n.a(r9, r10, r12, r14) == false) goto L37;
        if (r25 == false) goto L11;
        com.obric.memorydata.union.build.storage.b r16 = (com.obric.memorydata.union.build.storage.b) ZeusTransformUtils.preCheckCast(r1.get(n.a(r9, r10)), com.obric.memorydata.union.build.storage.b.class, "com.obric.memorydata.plugin");
    L15:
        int r17 = r6.optInt(CommonConsts.COUNT_TYPE, 1);
        if (r16 == null) goto L18;
        Integer r19 = Integer.valueOf(r16.a());
    L19:
        if (r16 == null) goto L21;
        Integer r110 = Integer.valueOf(r16.b());
    L22:
        com.obric.memorydata.union.build.storage.b r20 = n.a(r17, r19, r110, r4, r25);
        r3.deleteByTypeAndTreePath(r9, r10);
        CharSequence r111 = (CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin");
        if (r111.length() != 0) goto L25;
        boolean r112 = true;
    L26:
        if (r112 == false) goto L28;
        r111 = r14;
    L28:
        String r113 = (String) ZeusTransformUtils.preCheckCast(r111, String.class, "com.obric.memorydata.plugin");
        CharSequence r21 = (CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin");
        if (r21.length() != 0) goto L31;
        boolean r114 = true;
    L32:
        if (r114 == true) goto L35;
        r12 = r21;
    L35:
        r3.insert(new iv(0, r9, r10, r113, (String) ZeusTransformUtils.preCheckCast(r12, String.class, "com.obric.memorydata.plugin"), r20.a(), r20.b(), r4, 1, null));
        r18 = r18 + 1;
        goto L37
    L31:
        r114 = false;
        goto L32
    L25:
        r112 = false;
        goto L26
    L21:
        r110 = null;
        goto L22
    L18:
        r19 = null;
        goto L19
    L11:
        iv r115 = r3.getLatest(r9, r10);
        if (r115 == null) goto L14;
        r16 = new com.obric.memorydata.union.build.storage.b(r115.e(), r115.f());
        goto L15
    L14:
        r16 = null;
    L37:
        r15 = r15 + 1;
        goto L3
    L38:
        return r18;
    }

    /* JADX WARN: Type inference failed for: r1v16, types: [T, com.obric.memorydata.union.build.storage.s] */
    private static final SemanticConsumerCommitResult a(PersonalMemoryFrameDb r13, o r14, Ref.ObjectRef r15) {
        SemanticStateDao r0 = r13.getSemanticStateDao();
        String r16 = "cursor:" + r14.a();
        r0.insertIfAbsent(new ik(r16, 0, null, 6, null));
        Long r1 = r0.queryNum(r16);
        if (r1 == null) goto L50;
        long r2 = ((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.memorydata.plugin")).longValue();
        if (Intrinsics.areEqual(r0.queryText("restore_phase"), "running") == true) goto L7;
        String r6 = n.a(r14.e(), r0.queryText("migration_phase"), r0.queryNum("migration_rebuild_target"), r14.c());
        if (r6 == null) goto L13;
        return new SemanticConsumerCommitResult(false, r6, r2, 0, 8, null);
    L13:
        if (r14.e() == false) goto L18;
        String r5 = r14.a();
        Set<String> r7 = r14.f();
        m r4 = f13129a;
        String r8 = n.a(r5, r7, r4.a(r14), r4.b(r14.d()), r14.d().length(), r14.g());
        if (r8 == null) goto L18;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "SemanticConsumerCommitManager", "consumer commit rejected code=" + r8 + ", consumer=" + r14.a(), null, 4, null);
        return new SemanticConsumerCommitResult(false, r8, r2, 0, 8, null);
    L18:
        int r9 = a.f13130a[n.a(r2, r14.b(), r14.c()).ordinal()];
        boolean r10 = true;
        if (r9 == 1) goto L48;
        if (r9 == 2) goto L53;
        if (r9 != 3) goto L45;
        m r3 = f13129a;
        Map<String, com.obric.memorydata.union.build.storage.b> r11 = r3.b(r14);
        if (r14.e() == false) goto L27;
        r3.c(r14.a());
    L27:
        int r12 = r3.a(r14, r11);
        if (r14.e() == false) goto L37;
        if (Intrinsics.areEqual(r14.a(), "interest_summary") == false) goto L37;
        Map r17 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(MapsKt.mapCapacity(r11.size())), Map.class, "com.obric.memorydata.plugin");
        Iterator r18 = ((Iterable) ZeusTransformUtils.preCheckCast(r11.entrySet(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L33:
        if (r18.hasNext() == false) goto L35;
        Object r19 = r18.next();
        r17.put(((Map.Entry) ZeusTransformUtils.preCheckCast(r19, Map.Entry.class, "com.obric.memorydata.plugin")).getKey(), Integer.valueOf(((com.obric.memorydata.union.build.storage.b) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r19, Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), com.obric.memorydata.union.build.storage.b.class, "com.obric.memorydata.plugin")).a()));
        goto L33
    L35:
        r15.element = n.a(r17, f13129a.c(r14));
    L37:
        if (r0.updateNumIfExpected(r16, r14.b(), r14.c()) == 1) goto L40;
        r10 = false;
    L40:
        if (r10 == false) goto L43;
        return new SemanticConsumerCommitResult(true, "OK", r14.c(), r12);
    L43:
        throw new IllegalStateException("consumer cursor CAS failed".toString());
    L45:
        throw new NoWhenBranchMatchedException();
    L53:
        return new SemanticConsumerCommitResult(false, "CURSOR_CHANGED", r2, 0, 8, null);
    L48:
        return new SemanticConsumerCommitResult(true, "ALREADY_COMMITTED", r2, 0, 8, null);
    L7:
        return new SemanticConsumerCommitResult(false, "RESTORE_RUNNING", r2, 0, 8, null);
    L50:
        throw new IllegalStateException("consumer cursor unavailable".toString());
    }

    private final Set<String> a(o r15) {
        Set r14 = SetsKt.createSetBuilder();
        int r0 = r15.d().length();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L36;
        JSONObject r3 = r15.d().optJSONObject(r2);
        if (r3 == null) goto L34;
        if (Intrinsics.areEqual(r3.optString("status"), "SUCCESS") == false) goto L34;
        if (Intrinsics.areEqual(r3.optString("business_id"), r15.a()) == false) goto L34;
        JSONObject r4 = r3.optJSONObject("payload");
        if (r4 == null) goto L16;
        JSONArray r5 = r4.optJSONArray("items");
        if (r5 == null) goto L16;
    L17:
        int r6 = r5.length();
        int r7 = 0;
    L18:
        if (r7 >= r6) goto L34;
        JSONObject r8 = r5.optJSONObject(r7);
        if (r8 == null) goto L33;
        if (Intrinsics.areEqual(r15.a(), "user_insight") == false) goto L29;
        String r9 = r8.optString("summary");
        Intrinsics.checkNotNullExpressionValue(r9, "optString(...)");
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L28;
        String r10 = r8.optString("description");
        Intrinsics.checkNotNullExpressionValue(r10, "optString(...)");
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L33;
    L28:
        String r11 = n.a("userinfo", "");
    L32:
        r14.add(r11);
        goto L33
    L29:
        String r12 = r8.optString("type");
        Intrinsics.checkNotNullExpressionValue(r12, "optString(...)");
        String r13 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        String r16 = r8.optString("tree_path", r8.optString("treePath"));
        Intrinsics.checkNotNullExpressionValue(r16, "optString(...)");
        String r17 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r16, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        String r18 = r8.optString("summary");
        Intrinsics.checkNotNullExpressionValue(r18, "optString(...)");
        String r19 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        String r20 = r8.optString("description", r19);
        Intrinsics.checkNotNullExpressionValue(r20, "optString(...)");
        if (n.a(r13, r17, r19, StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r20, CharSequence.class, "com.obric.memorydata.plugin")).toString()) == false) goto L33;
        r11 = n.a(r13, r17);
    L33:
        r7 = r7 + 1;
    L16:
        r5 = new JSONArray();
    L34:
        r2 = r2 + 1;
        goto L3
    L36:
        return SetsKt.build(r14);
    }

    private final Set<String> a(JSONArray r10) {
        Set r9 = SetsKt.createSetBuilder();
        if (r10 == null) goto L17;
        int r0 = r10.length();
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L17;
        JSONObject r3 = r10.optJSONObject(r2);
        if (r3 == null) goto L15;
        String r4 = r3.optString("type");
        Intrinsics.checkNotNullExpressionValue(r4, "optString(...)");
        String r5 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        String r6 = r3.optString("tree_path", r3.optString("treePath"));
        Intrinsics.checkNotNullExpressionValue(r6, "optString(...)");
        String r7 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L12;
        boolean r8 = true;
    L13:
        if (r8 == false) goto L15;
        r9.add(n.a(r5, r7));
        goto L15
    L12:
        r8 = false;
    L15:
        r2 = r2 + 1;
    L17:
        return SetsKt.build(r9);
    }

    private final void a(s r4) {
        t r3 = t.f9598a;
        JSONObject r5 = new JSONObject().put("groups_total", r4.a()).put("groups_count_decreased", r4.b()).put("count_sum_before", r4.c()).put("count_sum_after", r4.d());
        Intrinsics.checkNotNullExpressionValue(r5, "put(...)");
        r3.a("l2_mig_summary_count_shrink", r5);
    }

    private final int b(JSONArray r5) {
        int r0 = 0;
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(RangesKt.until(0, r5.length()), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, Collection.class) == true) goto L5;
    L7:
        Iterator r6 = r4.iterator();
    L9:
        if (r6.hasNext() == false) goto L19;
        JSONObject r1 = r5.optJSONObject(((IntIterator) ZeusTransformUtils.preCheckCast(r6, IntIterator.class, "com.obric.memorydata.plugin")).nextInt());
        if (r1 == null) goto L13;
        String r2 = r1.optString("status");
    L15:
        if (Intrinsics.areEqual(r2, "SUCCESS") == false) goto L9;
        r0 = r0 + 1;
        if (r0 >= 0) goto L9;
        CollectionsKt.throwCountOverflow();
        goto L9
    L13:
        r2 = null;
    L19:
        return r0;
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
        goto L7
    }

    private final o b(String r13) {
        boolean r1 = true;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L23;
        JSONObject r0 = new JSONObject(r13);
        String r3 = r0.optString("consumer_id");
        if (n.a().contains(r3) == false) goto L21;
        long r6 = r0.optLong("expected_cursor", -1);
        long r8 = r0.optLong("group_seq", -1);
        if (r6 >= 0) goto L9;
    L11:
        r1 = false;
    L12:
        if (r1 == false) goto L19;
        JSONArray r14 = r0.optJSONArray("outputs");
        if (r14 != null) goto L16;
        r14 = new JSONArray();
    L16:
        Intrinsics.checkNotNull(r3);
        return new o(r3, r6, r8, r14, r0.optBoolean("replace_existing", false), a(r0.optJSONArray("expected_groups")), r0.optBoolean("full_snapshot_empty", false));
    L19:
        throw new IllegalArgumentException("invalid cursor range".toString());
    L9:
        if (r8 <= r6) goto L11;
    L21:
        throw new IllegalArgumentException("unsupported consumer".toString());
    L23:
        throw new IllegalArgumentException("consumer payload is blank".toString());
    }

    private final Map<String, com.obric.memorydata.union.build.storage.b> b(o r6) {
        if (r6.e() == false) goto L14;
        if (Intrinsics.areEqual(r6.a(), "interest_summary") == false) goto L14;
        UnionSemanticTypeSummaryDao r5 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getUnionSemanticTypeSummaryDao();
        Map r7 = MapsKt.createMapBuilder();
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast(r5.getAll(), Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new b(), Comparator.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L9:
        if (r8.hasNext() == false) goto L12;
        iv r0 = (iv) ZeusTransformUtils.preCheckCast(r8.next(), iv.class, "com.obric.memorydata.plugin");
        r7.put(n.a(r0.getType(), r0.b()), new com.obric.memorydata.union.build.storage.b(r0.e(), r0.f()));
        goto L9
    L12:
        return MapsKt.build(r7);
    L14:
        return MapsKt.emptyMap();
    }

    private final Map<String, Integer> c(o r14) {
        Map r13 = MapsKt.createMapBuilder();
        int r0 = r14.d().length();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L21;
        JSONObject r3 = r14.d().optJSONObject(r2);
        if (r3 == null) goto L19;
        JSONObject r4 = r3.optJSONObject("payload");
        if (r4 == null) goto L19;
        JSONArray r5 = r4.optJSONArray("items");
        if (r5 == null) goto L19;
        int r6 = r5.length();
        int r7 = 0;
    L11:
        if (r7 >= r6) goto L19;
        JSONObject r8 = r5.optJSONObject(r7);
        if (r8 == null) goto L18;
        String r9 = r8.optString("type");
        Intrinsics.checkNotNullExpressionValue(r9, "optString(...)");
        String r10 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        String r11 = r8.optString("tree_path", r8.optString("treePath"));
        Intrinsics.checkNotNullExpressionValue(r11, "optString(...)");
        String r12 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        String r15 = r8.optString("summary");
        Intrinsics.checkNotNullExpressionValue(r15, "optString(...)");
        String r16 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        String r17 = r8.optString("description", r16);
        Intrinsics.checkNotNullExpressionValue(r17, "optString(...)");
        if (n.a(r10, r12, r16, StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.memorydata.plugin")).toString()) == false) goto L18;
        r13.put(n.a(r10, r12), Integer.valueOf(r8.optInt(CommonConsts.COUNT_TYPE, 1)));
    L18:
        r7 = r7 + 1;
    L19:
        r2 = r2 + 1;
        goto L3
    L21:
        return MapsKt.build(r13);
    }

    private final void c(String r2) {
        PersonalMemoryFrameDb r1 = MemoryDbEngine.INSTANCE.getPersonalDbEngine();
        if (Intrinsics.areEqual(r2, "user_insight") == false) goto L6;
        r1.getMemoryProcessUserInsightDao().deleteAll();
        return;
    L6:
        if (Intrinsics.areEqual(r2, "interest_summary") == false) goto L10;
        r1.getUnionSemanticTypeSummaryDao().deleteAll();
        return;
    }

    public static /* synthetic */ SemanticConsumerCommitResult lambda$6qa2ubp1WsKS24SP5b8fWpfyJik(PersonalMemoryFrameDb r0, o r1, Ref.ObjectRef r2) {
        return a(r0, r1, r2);
    }

    public final SemanticConsumerCommitResult a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "payload");
        final o r5 = b(r4);
        final PersonalMemoryFrameDb r0 = MemoryDbEngine.INSTANCE.getPersonalDbEngine();
        final Ref.ObjectRef r1 = new Ref.ObjectRef();
        SemanticConsumerCommitResult r6 = (SemanticConsumerCommitResult) ZeusTransformUtils.preCheckCast(r0.runInTransaction(new $$Lambda$m$6qa2ubp1WsKS24SP5b8fWpfyJik(r0, r5, r1)), SemanticConsumerCommitResult.class, "com.obric.memorydata.plugin");
        s r2 = (s) ZeusTransformUtils.preCheckCast(r1.element, s.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L5;
        a(r2);
    L5:
        return r6;
    }
}
