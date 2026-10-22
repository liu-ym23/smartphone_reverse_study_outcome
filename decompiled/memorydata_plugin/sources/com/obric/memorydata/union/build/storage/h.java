package com.obric.memorydata.union.build.storage;

import androidx.exifinterface.media.ExifInterface;
import androidx.room.RoomDatabase;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.google.gson.reflect.TypeToken;
import com.obric.capabilitykit.common.Ext;
import com.obric.memorydata.BuildConfig;
import com.obric.memorydata.database.dao.SemanticDeleteLifecycle;
import com.obric.memorydata.database.dao.SemanticMemoryDao;
import com.obric.memorydata.database.dao.SemanticStateDao;
import com.obric.memorydata.database.dao.UserKeywordDao;
import com.obric.memorydata.database.entity.ie;
import com.obric.memorydata.database.entity.ij;
import com.obric.memorydata.database.entity.ik;
import com.obric.memorydata.database.entity.ip;
import com.obric.memorydata.database.entity.jc;
import com.obric.memorydata.database.entity.jd;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.database.manager.PersonalMemoryFrameDb;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.GsonUtil;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0003\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005J\u000e\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005J\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J.\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u00172\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u0017J\u0018\u0010\u0019\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0012H\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\f\u001a\u00020\u0005H\u0002J\u0018\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J,\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\"2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020%0$H\u0002J0\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020'0$2\u0012\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u00170\u00172\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u001a\u0010)\u001a\u0004\u0018\u00010'2\u0006\u0010*\u001a\u00020\u001f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010+\u001a\u00020%H\u0002J\u0018\u0010,\u001a\u00020-2\u0006\u0010*\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020%H\u0002J\u0018\u0010/\u001a\u00020-2\u0006\u0010*\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020%H\u0002J\u0018\u00100\u001a\u00020-2\u0006\u0010*\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020%H\u0002J\u0018\u00101\u001a\u00020-2\u0006\u0010*\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020%H\u0002J0\u00102\u001a\u00020\u001c2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00150\u00172\u0006\u0010.\u001a\u00020%2\b\u00104\u001a\u0004\u0018\u00010\u00052\u0006\u00105\u001a\u00020\u0012H\u0002J&\u00106\u001a\u00020\u001c2\u0006\u00107\u001a\u00020\u00052\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u00172\u0006\u00108\u001a\u00020\u0012H\u0002J\u0018\u00109\u001a\u00020\u001c2\u0006\u00107\u001a\u00020\u00052\u0006\u0010:\u001a\u00020\u0005H\u0002J*\u0010;\u001a\u00020\u000b2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00172\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020'0$H\u0002J0\u0010=\u001a\b\u0012\u0004\u0012\u00020'0\u00172\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00172\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020'0$H\u0002J\u001e\u0010>\u001a\u00020\u001c2\u0006\u0010?\u001a\u00020\u00052\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00150\u0017H\u0002J\u0018\u0010A\u001a\u00020'2\u0006\u0010B\u001a\u00020\u00052\u0006\u0010C\u001a\u00020\u0005H\u0002J\u0010\u0010D\u001a\u00020\u00122\u0006\u0010A\u001a\u00020EH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006F"}, d2 = {"Lcom/obric/memorydata/union/build/storage/SemanticBatchCommitManager;", "", "<init>", "()V", "CHANGE_SEQ_KEY", "", "MAX_OPERATIONS", "", "retryDelaysMs", "", "commit", "Lcom/obric/memorydata/union/build/storage/SemanticBatchCommitResult;", "payload", "commitMigration", "commitWithRetry", Ext.KEY_REQUEST, "Lcom/obric/memorydata/union/build/storage/SemanticBatchCommitRequest;", "allowProactiveWrite", "", "commitEntity", "entity", "Lcom/obric/memorydata/database/entity/UnionSemanticMemoryEntity;", "targetEntityIds", "", "hotWords", "parseAndValidate", "allowMigrationControls", "rejectExplicitDatabaseIds", "", "commitOnce", "resolveOperation", "Lcom/obric/memorydata/union/build/storage/ResolvedSemanticOperation;", "index", "operation", "Lcom/obric/memorydata/union/build/storage/SemanticBatchOperation;", "batchExpectedChangeSeqs", "", "", "validateComponents", "Lcom/obric/memorydata/union/build/storage/SemanticBatchFailure;", "components", "validateOperation", "resolved", "nextChangeSeq", "applyOperation", "Lcom/obric/memorydata/union/build/storage/SemanticBatchOperationResult;", "changeSeq", "applyUpsert", "applyMigrationUpsert", "applyDelete", "deleteEntities", "entities", InfoRequestQPSOptTraceLogger.REASON, "forceSystemRetraction", "syncHotWords", "entityId", "preserveExisting", "addHotWordRef", "word", "resultWithoutWrites", "failures", "buildFailures", "moveHotWordRefsToKeeper", "keeperEntityId", "removed", "failure", "code", "message", "isBusyFailure", "", "memory_build_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f13122a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final long[] f13123b = null;

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonUtil$fromJsonArray$2$1", "Lcom/google/gson/reflect/TypeToken;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends TypeToken<List<? extends String>> {
        public a() {
        }
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonUtil$fromJsonArray$2$1", "Lcom/google/gson/reflect/TypeToken;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends TypeToken<List<? extends String>> {
        public b() {
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class c<T> implements Comparator {
        public c() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast((Integer) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r2, Map.Entry.class, "com.obric.memorydata.plugin")).getKey(), Integer.class, "com.obric.memorydata.plugin"), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast((Integer) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.memorydata.plugin")).getKey(), Integer.class, "com.obric.memorydata.plugin"), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        f13122a = new h();
        f13123b = new long[]{50, 200, 800};
    }

    private h() {
    }

    private final long a() {
        SemanticStateDao r8 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getSemanticStateDao();
        r8.insertIfAbsent(new ik("change_seq", 0, null, 6, null));
        boolean r2 = true;
        if (r8.increment("change_seq") == 1) goto L6;
        r2 = false;
    L6:
        if (r2 == false) goto L14;
        Long r9 = r8.queryNum("change_seq");
        if (r9 == null) goto L12;
        return ((Number) ZeusTransformUtils.preCheckCast(r9, Number.class, "com.obric.memorydata.plugin")).longValue();
    L12:
        throw new IllegalStateException("change_seq value is unavailable".toString());
    L14:
        throw new IllegalStateException("change_seq state row is unavailable".toString());
    }

    private final SemanticBatchCommitRequest a(String r10, boolean r11) {
        boolean r2 = true;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L58;
        c(r10);
        if (r11 == true) goto L59;
        i.a(r10);
    L59:
        Object r9 = GsonUtil.INSTANCE.getGSON().fromJson(r10, SemanticBatchCommitRequest.class);     // Catch: Exception -> L10
    L12:
        if (r9 == null) goto L56;
        SemanticBatchCommitRequest r12 = (SemanticBatchCommitRequest) ZeusTransformUtils.preCheckCast(r9, SemanticBatchCommitRequest.class, "com.obric.memorydata.plugin");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r12.getOperations(), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L54;
        if (r12.getOperations().size() > 500) goto L18;
        boolean r13 = true;
    L19:
        if (r13 == false) goto L52;
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r12.getOperations(), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r14, Collection.class) == true) goto L23;
    L25:
        Iterator r15 = r14.iterator();
    L27:
        if (r15.hasNext() == false) goto L24;
        if (Intrinsics.areEqual(((SemanticBatchOperation) ZeusTransformUtils.preCheckCast(r15.next(), SemanticBatchOperation.class, "com.obric.memorydata.plugin")).getWritePurpose(), "conflict_resolution") == false) goto L27;
        boolean r16 = false;
    L31:
        if (r16 == false) goto L33;
    L36:
        boolean r17 = true;
    L37:
        if (r17 == false) goto L50;
        Iterator r18 = ((Iterable) ZeusTransformUtils.preCheckCast(r12.getOperations(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r3 = 0;
    L40:
        if (r18.hasNext() == false) goto L42;
        r3 = r3 + Math.max(1, ((SemanticBatchOperation) ZeusTransformUtils.preCheckCast(r18.next(), SemanticBatchOperation.class, "com.obric.memorydata.plugin")).getEntityIds().size());
        goto L40
    L42:
        if (r3 <= 500) goto L45;
        r2 = false;
    L45:
        if (r2 == false) goto L48;
        return r12;
    L48:
        throw new IllegalArgumentException("affected rows exceeds transaction limit 500".toString());
    L50:
        throw new IllegalArgumentException("resolved operations require atomic batch".toString());
    L33:
        if (r12.getAtomic() == true) goto L36;
        r17 = false;
    L24:
        r16 = true;
        goto L31
    L23:
        if (((Collection) ZeusTransformUtils.preCheckCast(r14, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L25;
    L52:
        throw new IllegalArgumentException("operations exceeds transaction limit 500".toString());
    L18:
        r13 = false;
        goto L19
    L54:
        throw new IllegalArgumentException("operations must not be empty".toString());
    L56:
        throw new IllegalArgumentException("semantic batch payload cannot be parsed".toString());
    L10:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), GsonUtil.TAG, "json error ：" + e, null, 4, null);
        r9 = null;
        goto L12
    L58:
        throw new IllegalArgumentException("semantic batch payload is blank".toString());
    }

    private final SemanticBatchCommitResult a(SemanticBatchCommitRequest r16, boolean r17) {
        String r0 = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(r0, "toString(...)");
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r16.getOperations(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L3:
        String r5 = null;
        if (r2.hasNext() == false) goto L11;
        SemanticBatchEntityPayload r3 = ((SemanticBatchOperation) ZeusTransformUtils.preCheckCast(r2.next(), SemanticBatchOperation.class, "com.obric.memorydata.plugin")).getEntity();
        if (r3 == null) goto L8;
        String r4 = r3.getLogId();
    L9:
        if (r4 == null) goto L3;
    L12:
        if (r4 != null) goto L14;
    L16:
        if (r5 != null) goto L18;
        r5 = "";
    L18:
        String r6 = "batch_id=" + r0 + " source_log_id=" + r5 + " atomic=" + r16.getAtomic() + " operation_count=" + r16.getOperations().size();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "SemanticBatchCommit", "批量提交开始 " + r6 + " read_count=" + r16.getExpectedChangeSeqs().size(), false, 4, null);
        int r7 = 0;
    L19:
        long r8 = System.nanoTime();
        SemanticBatchCommitResult r1 = b(r16, r17);     // Catch: Throwable -> L33
        long r9 = (System.nanoTime() - r8) / ((long) 1000000);     // Catch: Throwable -> L33
        if (r1.getFailedOperations().isEmpty() == false) goto L24;
        String r10 = "committed";
    L27:
        IRunLog r11 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L33
        StringBuilder r12 = new StringBuilder().append("批量提交结束 ").append(r6).append(" attempt=").append(r7).append(" outcome=").append(r10).append(" applied_count=").append(r1.getAppliedCount()).append(" failed_count=").append(r1.getFailedOperations().size()).append(" codes=");     // Catch: Throwable -> L33
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r1.getFailedOperations(), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L33
        Collection r14 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10)), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L33
        Iterator r15 = r13.iterator();     // Catch: Throwable -> L33
    L29:
        if (r15.hasNext() == false) goto L31;
        r14.add(((SemanticBatchFailure) ZeusTransformUtils.preCheckCast(r15.next(), SemanticBatchFailure.class, "com.obric.memorydata.plugin")).getError());     // Catch: Throwable -> L33
        goto L29
    L31:
        IRunLog.a.a(r11, "SemanticBatchCommit", r12.append(CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"))).append(" elapsed_ms=").append(r9).toString(), false, 4, null);     // Catch: Throwable -> L33
        return r1;
    L24:
        if (r1.getAppliedCount() != 0) goto L26;
        r10 = "rejected";
        goto L27
    L26:
        r10 = "partial";
    L33:
        th = move-exception;
        if (a(th) == false) goto L39;
        long[] r18 = f13123b;
        if (r7 >= r18.length) goto L39;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "SemanticBatchCommit", "批量事务重试 code=DB_BUSY " + r6 + " attempt=" + r7, null, 4, null);
        Thread.sleep(r18[r7]);
        r7 = r7 + 1;
    L39:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "SemanticBatchCommit", "批量事务失败 code=BATCH_FAILED " + r6 + " attempt=" + r7 + " error_class=" + th.getClass().getSimpleName(), null, 4, null);
        throw th;
    L14:
        if (new Regex("[A-Za-z0-9_-]{1,128}").matches((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L16;
        r5 = r4;
        goto L16
    L8:
        r4 = null;
        goto L9
    L11:
        r4 = null;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private static final SemanticBatchCommitResult a(SemanticBatchCommitRequest r12, boolean r13, PersonalMemoryFrameDb r14) {
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r12.getOperations(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r2 = r0.iterator();
        boolean r4 = false;
        int r5 = 0;
    L4:
        if (r2.hasNext() == false) goto L9;
        Object r6 = r2.next();
        int r7 = r5 + 1;
        if (r5 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        r1.add(f13122a.a(r5, (SemanticBatchOperation) ZeusTransformUtils.preCheckCast(r6, SemanticBatchOperation.class, "com.obric.memorydata.plugin"), r12.getExpectedChangeSeqs()));
        r5 = r7;
        goto L4
    L9:
        List<g> r3 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin");
        if (r12.getAtomic() == true) goto L33;
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r12.getOperations(), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r8, Collection.class) == true) goto L14;
    L16:
        Iterator r9 = r8.iterator();
    L18:
        if (r9.hasNext() == false) goto L25;
        if (((SemanticBatchOperation) ZeusTransformUtils.preCheckCast(r9.next(), SemanticBatchOperation.class, "com.obric.memorydata.plugin")).getRequeueKeeperId() == null) goto L22;
        boolean r10 = true;
    L23:
        if (r10 == false) goto L18;
        r4 = true;
        goto L25
    L22:
        r10 = false;
    L25:
        if (r4 == false) goto L33;
        h r15 = f13122a;
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin");
        Map r17 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r16, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
        Iterator r18 = r16.iterator();
    L28:
        if (r18.hasNext() == false) goto L31;
        Pair r11 = TuplesKt.to(Integer.valueOf(((g) ZeusTransformUtils.preCheckCast(r18.next(), g.class, "com.obric.memorydata.plugin")).a()), f13122a.b("ATOMIC_BATCH_REQUIRED", "conflict requeue requires an atomic batch"));
        r17.put(r11.getFirst(), r11.getSecond());
        goto L28
    L31:
        return r15.a(r3, r17);
    L14:
        if (((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L16;
    L33:
        if (r12.getAtomic() == false) goto L58;
        Map<String, Long> r19 = r12.getExpectedChangeSeqs();
        Iterable r20 = (Iterable) ZeusTransformUtils.preCheckCast(r12.getOperations(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r21 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r22 = r20.iterator();
    L36:
        if (r22.hasNext() == false) goto L42;
        Iterable r23 = (Iterable) ZeusTransformUtils.preCheckCast(((SemanticBatchOperation) ZeusTransformUtils.preCheckCast(r22.next(), SemanticBatchOperation.class, "com.obric.memorydata.plugin")).getExpectedChangeSeqs().entrySet(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r24 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r23, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r25 = r23.iterator();
    L39:
        if (r25.hasNext() == false) goto L41;
        Map.Entry r110 = (Map.Entry) ZeusTransformUtils.preCheckCast(r25.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r24.add(TuplesKt.to(r110.getKey(), r110.getValue()));
        goto L39
    L41:
        CollectionsKt.addAll(r21, (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r24, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
        goto L36
    L42:
        Map r26 = MapsKt.plus(r19, MapsKt.toMap((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r21, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")));
        Iterable r27 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.chunked((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r26.keySet(), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"), 500), Iterable.class, "com.obric.memorydata.plugin");
        Collection r28 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r29 = r27.iterator();
    L44:
        if (r29.hasNext() == false) goto L46;
        CollectionsKt.addAll(r28, (Iterable) ZeusTransformUtils.preCheckCast(r14.getSemanticMemoryDao().queryByEntityIds((List) ZeusTransformUtils.preCheckCast(r29.next(), List.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"));
        goto L44
    L46:
        Iterable r111 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r28, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Map r30 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r111, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
        Iterator r112 = r111.iterator();
    L48:
        if (r112.hasNext() == false) goto L50;
        ip r31 = (ip) ZeusTransformUtils.preCheckCast(r112.next(), ip.class, "com.obric.memorydata.plugin");
        Pair r32 = TuplesKt.to(r31.getEntityId(), Long.valueOf(r31.r()));
        r30.put(r32.getFirst(), r32.getSecond());
        goto L48
    L50:
        String r113 = i.a(r26, r30);
        if (r113 == null) goto L58;
        h r114 = f13122a;
        Iterable r115 = (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin");
        Map r33 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r115, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
        Iterator r116 = r115.iterator();
    L54:
        if (r116.hasNext() == false) goto L57;
        Pair r34 = TuplesKt.to(Integer.valueOf(((g) ZeusTransformUtils.preCheckCast(r116.next(), g.class, "com.obric.memorydata.plugin")).a()), f13122a.b(r113, "batch dependency changed or disappeared"));
        r33.put(r34.getFirst(), r34.getSecond());
        goto L54
    L57:
        return r114.a(r3, r33);
    L58:
        List<List<g>> r117 = p.f13134a.a(r3);
        h r35 = f13122a;
        Map<Integer, SemanticBatchFailure> r118 = r35.a(r117, r13);
        if (r12.getAtomic() == true) goto L61;
    L71:
        Iterable r119 = (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin");
        Collection r120 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r121 = r119.iterator();
    L73:
        if (r121.hasNext() == false) goto L77;
        Object r36 = r121.next();
        if (r118.containsKey(Integer.valueOf(((g) ZeusTransformUtils.preCheckCast(r36, g.class, "com.obric.memorydata.plugin")).a())) == true) goto L73;
        r120.add(r36);
        goto L73
    L77:
        List r122 = (List) ZeusTransformUtils.preCheckCast(r120, List.class, "com.obric.memorydata.plugin");
        if (r122.isEmpty() == true) goto L80;
        long r37 = f13122a.a();
        Iterable r123 = (Iterable) ZeusTransformUtils.preCheckCast(r122, Iterable.class, "com.obric.memorydata.plugin");
        Collection r124 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r123, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r125 = r123.iterator();
    L83:
        if (r125.hasNext() == false) goto L85;
        r124.add(f13122a.a((g) ZeusTransformUtils.preCheckCast(r125.next(), g.class, "com.obric.memorydata.plugin"), r37));
        goto L83
    L85:
        List r126 = (List) ZeusTransformUtils.preCheckCast(r124, List.class, "com.obric.memorydata.plugin");
        return new SemanticBatchCommitResult(r126.size(), f13122a.b(r3, r118), Long.valueOf(r37), r126);
    L80:
        return f13122a.a(r3, r118);
    L61:
        if ((!r118.isEmpty()) == false) goto L71;
        Iterable r127 = (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin");
        Map r128 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r127, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
        Iterator r129 = r127.iterator();
    L64:
        if (r129.hasNext() == false) goto L70;
        g r38 = (g) ZeusTransformUtils.preCheckCast(r129.next(), g.class, "com.obric.memorydata.plugin");
        Integer r39 = Integer.valueOf(r38.a());
        SemanticBatchFailure r40 = (SemanticBatchFailure) ZeusTransformUtils.preCheckCast(r118.get(Integer.valueOf(r38.a())), SemanticBatchFailure.class, "com.obric.memorydata.plugin");
        if (r40 != null) goto L68;
        r40 = f13122a.b("ATOMIC_BATCH_ABORTED", "batch was not committed");
    L68:
        Pair r41 = TuplesKt.to(r39, r40);
        r128.put(r41.getFirst(), r41.getSecond());
        goto L64
    L70:
        return r35.a(r3, r128);
    }

    private final SemanticBatchCommitResult a(List<g> r3, Map<Integer, SemanticBatchFailure> r4) {
        return new SemanticBatchCommitResult(0, b((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin")), null, CollectionsKt.emptyList());
    }

    private final SemanticBatchFailure a(g r12, boolean r13) {
        SemanticBatchOperation r0 = r12.b();
        if (SetsKt.setOf(new String[]{"insert", BuildConfig.CHANNEL, "delete"}).contains(r0.getOperateType()) == true) goto L7;
        return b("INVALID_OPERATION", "operate_type must be insert, update, or delete");
    L7:
        if (SetsKt.setOf(new String[]{"insert", BuildConfig.CHANNEL}).contains(r0.getOperateType()) == true) goto L9;
    L12:
        SemanticBatchEntityPayload r3 = r0.getEntity();
        if (r3 == null) goto L17;
        Float r4 = r3.getConfidence();
        if (r4 == null) goto L17;
        float r5 = r4.floatValue();
    L21:
        SemanticBatchEntityPayload r6 = r0.getEntity();
        if (r6 == null) goto L25;
        String r7 = r6.getConfirmationState();
        if (r7 == null) goto L25;
    L30:
        if (l.a(r5, r7) == true) goto L34;
        return b("INVALID_CONFIRMATION_STATE", "pending confirmation requires C3");
    L34:
        if (Intrinsics.areEqual(r0.getOperateType(), "insert") == false) goto L44;
        SemanticBatchEntityPayload r1 = r0.getEntity();
        if (r1 != null) goto L38;
    L40:
        boolean r2 = false;
    L41:
        if (r2 == true) goto L44;
        return b("INVALID_ENTITY", "insert entity is missing required fields");
    L38:
        if (r1.hasInsertFields() != true) goto L40;
        r2 = true;
    L44:
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r12.c(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r8.iterator();
    L46:
        if (r10.hasNext() == false) goto L48;
        ip r11 = (ip) ZeusTransformUtils.preCheckCast(r10.next(), ip.class, "com.obric.memorydata.plugin");
        r9.add(new q(r11.getEntityId(), r11.l(), r11.i()));
        goto L46
    L48:
        String r14 = i.a(r0, (List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin"), r12.e(), r13);
        if (r14 == null) goto L53;
        return b(r14, "semantic operation violates the guarded write policy");
    L53:
        if (Intrinsics.areEqual(r0.getOperateType(), BuildConfig.CHANNEL) == true) goto L55;
    L58:
        Iterator r15 = ((Iterable) ZeusTransformUtils.preCheckCast(r12.c(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L60:
        if (r15.hasNext() == false) goto L72;
        Object r16 = r15.next();
        ip r17 = (ip) ZeusTransformUtils.preCheckCast(r16, ip.class, "com.obric.memorydata.plugin");
        if (r12.e().containsKey(r17.getEntityId()) == false) goto L69;
        Long r18 = (Long) ZeusTransformUtils.preCheckCast(r12.e().get(r17.getEntityId()), Long.class, "com.obric.memorydata.plugin");
        long r19 = r17.r();
        if (r18 != null) goto L67;
    L68:
        boolean r20 = true;
    L70:
        if (r20 == false) goto L60;
    L74:
        if (((ip) ZeusTransformUtils.preCheckCast(r16, ip.class, "com.obric.memorydata.plugin")) != null) goto L76;
        return null;
    L76:
        return f13122a.b("SEMANTIC_VERSION_CHANGED", "semantic snapshot changed before commit");
    L67:
        if (r18.longValue() != r19) goto L68;
    L69:
        r20 = false;
        goto L70
    L72:
        r16 = null;
        goto L74
    L55:
        if (r12.c().isEmpty() == false) goto L58;
        return b("TARGET_NOT_FOUND", "semantic target does not exist");
    L25:
        ip r21 = (ip) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r12.c()), ip.class, "com.obric.memorydata.plugin");
        if (r21 == null) goto L28;
        r7 = r21.s();
        goto L30
    L28:
        r7 = "none";
    L17:
        ip r22 = (ip) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r12.c()), ip.class, "com.obric.memorydata.plugin");
        if (r22 == null) goto L20;
        r5 = r22.l();
        goto L21
    L20:
        r5 = 0.0f;
        goto L21
    L9:
        if (r0.getEntity() != null) goto L12;
        return b("MISSING_ENTITY", "entity is required");
    }

    private final SemanticBatchOperationResult a(g r12, long r13) {
        g r0 = g.a(r12, 0, null, i.a(r12.c(), r12.b().getMigrationOperation(), $$Lambda$h$dRgTlkVNvsFqOdn3oQR_9Yca23I.INSTANCE), null, null, 27, null);
        if (Intrinsics.areEqual(r12.b().getOperateType(), "delete") == false) goto L6;
        return d(r0, r13);
    L6:
        return b(r0, r13);
    }

    private final g a(int r10, SemanticBatchOperation r11, Map<String, Long> r12) {
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.memorydata.plugin");
        SemanticMemoryDao r1 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getSemanticMemoryDao();
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.plus((Collection) ZeusTransformUtils.preCheckCast(r11.getEntityIds(), Collection.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOfNotNull(r11.getRequeueKeeperId()), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r14 = r13.iterator();
    L3:
        boolean r7 = true;
        if (r14.hasNext() == false) goto L8;
        Object r3 = r14.next();
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L3;
        r2.add(r3);
        goto L3
    L8:
        List<String> r4 = CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(r1.queryByEntityIds(r4), Iterable.class, "com.obric.memorydata.plugin");
        Map r5 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r15, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
        Iterator r16 = r15.iterator();
    L10:
        if (r16.hasNext() == false) goto L12;
        Object r6 = r16.next();
        r5.put(((ip) ZeusTransformUtils.preCheckCast(r6, ip.class, "com.obric.memorydata.plugin")).getEntityId(), r6);
        goto L10
    L12:
        Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r18 = r17.iterator();
    L14:
        if (r18.hasNext() == false) goto L18;
        ip r19 = (ip) ZeusTransformUtils.preCheckCast(r5.get((String) ZeusTransformUtils.preCheckCast(r18.next(), String.class, "com.obric.memorydata.plugin")), ip.class, "com.obric.memorydata.plugin");
        if (r19 == null) goto L14;
        r8.add(r19);
        goto L14
    L18:
        List r110 = (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin");
        String r20 = null;
        if (r11.getAllowDuplicateMerge() == false) goto L30;
        SemanticBatchEntityPayload r21 = r11.getEntity();
        if (r21 == null) goto L30;
        String r22 = r21.getKeyPhrase();
        if (r22 == null) goto L30;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r22, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L28;
        r22 = null;
    L28:
        if (r22 == null) goto L30;
        ip r23 = SemanticMemoryDao.DefaultImpls.queryDuplicateCandidate$default(r1, r4, r22, false, 4, null);
    L31:
        Iterable r111 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.plus((Collection) ZeusTransformUtils.preCheckCast(r110, Collection.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOfNotNull(r23), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin");
        HashSet r24 = new HashSet();
        ArrayList r25 = new ArrayList();
        Iterator r112 = r111.iterator();
    L33:
        if (r112.hasNext() == false) goto L37;
        Object r26 = r112.next();
        if (r24.add(((ip) ZeusTransformUtils.preCheckCast(r26, ip.class, "com.obric.memorydata.plugin")).getEntityId()) == false) goto L33;
        r25.add(r26);
        goto L33
    L37:
        List<ip> r113 = (List) ZeusTransformUtils.preCheckCast(r25, List.class, "com.obric.memorydata.plugin");
        if (r11.getMigrationOperation() == false) goto L40;
        r113 = i.a(r113);
    L40:
        List<ip> r27 = r113;
        Iterable r114 = (Iterable) ZeusTransformUtils.preCheckCast(r27, Iterable.class, "com.obric.memorydata.plugin");
        Collection r28 = (Collection) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r115 = r114.iterator();
    L42:
        if (r115.hasNext() == false) goto L44;
        r28.add("id:" + ((ip) ZeusTransformUtils.preCheckCast(r115.next(), ip.class, "com.obric.memorydata.plugin")).getEntityId());
        goto L42
    L44:
        LinkedHashSet r116 = (LinkedHashSet) ZeusTransformUtils.preCheckCast(r28, LinkedHashSet.class, "com.obric.memorydata.plugin");
        SemanticBatchEntityPayload r29 = r11.getEntity();
        if (r29 == null) goto L61;
        String r30 = r29.getKeyPhrase();
        if (r30 == null) goto L61;
        String r31 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r30, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (r31 == null) goto L61;
        Locale r32 = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(r32, "ROOT");
        String r33 = r31.toLowerCase(r32);
        Intrinsics.checkNotNullExpressionValue(r33, "toLowerCase(...)");
        if (r33 == null) goto L61;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r33, CharSequence.class, "com.obric.memorydata.plugin")).length() > 0) goto L56;
        r7 = false;
    L56:
        if (r7 == false) goto L58;
        r20 = r33;
    L58:
        if (r20 == null) goto L61;
        ((Collection) ZeusTransformUtils.preCheckCast(r116, Collection.class, "com.obric.memorydata.plugin")).add("key:" + r20);
    L61:
        if (r116.isEmpty() == false) goto L64;
        ((Collection) ZeusTransformUtils.preCheckCast(r116, Collection.class, "com.obric.memorydata.plugin")).add("new:" + r10);
    L64:
        return new g(r10, r11, r27, (Set) ZeusTransformUtils.preCheckCast(r116, Set.class, "com.obric.memorydata.plugin"), MapsKt.plus(r9, r11.getExpectedChangeSeqs()));
    L30:
        r23 = null;
        goto L31
    }

    private static final List a(List r2) {
        List<String> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "it");
        return MemoryDbEngine.INSTANCE.getPersonalDbEngine().getSemanticMemoryDao().queryByEntityIds(r3);
    }

    private final Map<Integer, SemanticBatchFailure> a(List<? extends List<g>> r6, boolean r7) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Map<Integer, SemanticBatchFailure> r8 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r9.hasNext() == false) goto L17;
        List r1 = (List) ZeusTransformUtils.preCheckCast(r9.next(), List.class, "com.obric.memorydata.plugin");
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L7:
        if (r2.hasNext() == false) goto L11;
        g r3 = (g) ZeusTransformUtils.preCheckCast(r2.next(), g.class, "com.obric.memorydata.plugin");
        SemanticBatchFailure r4 = f13122a.a(r3, r7);
        if (r4 == null) goto L7;
    L12:
        if (r4 == null) goto L4;
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L15:
        if (r10.hasNext() == false) goto L4;
        r8.put(Integer.valueOf(((g) ZeusTransformUtils.preCheckCast(r10.next(), g.class, "com.obric.memorydata.plugin")).a()), r4);
        goto L15
    L11:
        r4 = null;
        goto L12
    L17:
        return r8;
    }

    private final void a(String r18, String r19) {
        PersonalMemoryFrameDb r14 = MemoryDbEngine.INSTANCE.getPersonalDbEngine();
        jc r0 = r14.getUserKeywordDao().queryByName(r19);
        if (r0 == null) goto L6;
        long r1 = r0.a();
    L21:
        r14.getUserKeywordRefDao().insertIfAbsent(new jd(0, r1, r18, 1, null));
        return;
    L6:
        Long r2 = Long.valueOf(r14.getUserKeywordDao().insertIfAbsent(new jc(0, r19, "", CollectionsKt.emptyList(), false, 0, 0, 113, null)));
        if (((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L9;
        boolean r3 = true;
    L10:
        Long r4 = null;
        if (r3 == true) goto L14;
        r2 = null;
    L14:
        if (r2 == null) goto L16;
        r1 = r2.longValue();
        goto L21
    L16:
        jc r5 = r14.getUserKeywordDao().queryByName(r19);
        if (r5 == null) goto L19;
        r4 = Long.valueOf(r5.a());
    L19:
        if (r4 == null) goto L24;
        r1 = ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).longValue();
        goto L21
    L24:
        throw new IllegalStateException("Required value was null.".toString());
    L9:
        r3 = false;
        goto L10
    }

    private final void a(String r4, List<ip> r5) {
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r7 = r3.iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        r6.add(((ip) ZeusTransformUtils.preCheckCast(r7.next(), ip.class, "com.obric.memorydata.plugin")).getEntityId());
        goto L4
    L6:
        List<String> r8 = (List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin");
        if (r8.isEmpty() == false) goto L9;
        return;
    L9:
        MemoryDbEngine.INSTANCE.getPersonalDbEngine().getUserKeywordRefDao().moveToKeeper(r8, r4);
    }

    private final void a(String r8, List<String> r9, boolean r10) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        PersonalMemoryFrameDb r11 = MemoryDbEngine.INSTANCE.getPersonalDbEngine();
        List<jd> r1 = r11.getUserKeywordRefDao().queryBySemanticEntityId(r8);
        if (r1.isEmpty() == false) goto L5;
        List<jc> r2 = CollectionsKt.emptyList();
    L10:
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin");
        Map r4 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r3, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
        Iterator r5 = r3.iterator();
    L12:
        if (r5.hasNext() == false) goto L14;
        jc r6 = (jc) ZeusTransformUtils.preCheckCast(r5.next(), jc.class, "com.obric.memorydata.plugin");
        Pair r12 = TuplesKt.to(Long.valueOf(r6.a()), r6.b());
        r4.put(r12.getFirst(), r12.getSecond());
        goto L12
    L14:
        com.obric.memorydata.union.build.storage.a r13 = i.a(r4, r7, r10);
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r13.a(), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L17;
        r11.getUserKeywordRefDao().deleteBySemanticEntityIdAndKeywordIds(r8, r13.a());
    L17:
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(r13.b(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L19:
        if (r14.hasNext() == false) goto L21;
        f13122a.a(r8, (String) ZeusTransformUtils.preCheckCast(r14.next(), String.class, "com.obric.memorydata.plugin"));
        goto L19
    L21:
        return;
    L5:
        UserKeywordDao r15 = r11.getUserKeywordDao();
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin");
        Collection r17 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r18 = r16.iterator();
    L7:
        if (r18.hasNext() == false) goto L9;
        r17.add(Long.valueOf(((jd) ZeusTransformUtils.preCheckCast(r18.next(), jd.class, "com.obric.memorydata.plugin")).b()));
        goto L7
    L9:
        r2 = r15.queryByIds((List) ZeusTransformUtils.preCheckCast(r17, List.class, "com.obric.memorydata.plugin"));
        goto L10
    }

    private final void a(List<ip> r9, long r10, String r12, boolean r13) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        if (r1.isEmpty() == false) goto L5;
        return;
    L5:
        SemanticDeleteLifecycle.deleteResolved$default(SemanticDeleteLifecycle.INSTANCE, r1, 0, r12, r13, Long.valueOf(r10), 2, null);
    }

    public static /* synthetic */ boolean a(h r1, ip r2, List r3, List r4, int r5, Object r6) {
        List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        List<String> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r7 = CollectionsKt.emptyList();
    L6:
        if ((r5 & 4) == 0) goto L9;
        r8 = CollectionsKt.emptyList();
    L9:
        return r1.a(r2, r7, r8);
    }

    private final boolean a(Throwable r8) {
    L3:
        if (r8 == null) goto L21;
        String r0 = r8.getClass().getSimpleName();
        String r1 = r8.getMessage();
        if (r1 != null) goto L7;
        r1 = "";
    L7:
        Locale r2 = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(r2, "ROOT");
        String r3 = r1.toLowerCase(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "toLowerCase(...)");
        Intrinsics.checkNotNull(r0);
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("Locked", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == true) goto L15;
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("sqlite_busy", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == true) goto L15;
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("database is locked", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == true) goto L15;
        r8 = r8.getCause();
    L15:
        return true;
    L21:
        return false;
    }

    private final SemanticBatchCommitResult b(final SemanticBatchCommitRequest r4, final boolean r5) {
        final PersonalMemoryFrameDb r3 = MemoryDbEngine.INSTANCE.getPersonalDbEngine();
        return (SemanticBatchCommitResult) ZeusTransformUtils.preCheckCast(ie.a((RoomDatabase) ZeusTransformUtils.preCheckCast(r3, RoomDatabase.class, "com.obric.memorydata.plugin"), new $$Lambda$h$3uT49xN_k5k1nTpHodJWAGFXgRA(r4, r5, r3)), SemanticBatchCommitResult.class, "com.obric.memorydata.plugin");
    }

    private final SemanticBatchFailure b(String r2, String r3) {
        return new SemanticBatchFailure("", r2, r3);
    }

    /* JADX WARN: Failed to calculate best type for var: r11v6 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r11v6 ??, new type: boolean
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r1v14 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r1v14 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r1v14 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r1v14 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r40v0 'this'  ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r40v0 'this'  ??, new type: com.obric.memorydata.union.build.storage.h
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to set immutable type for var: r40v0 'this'  ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r40v0 'this'  ??, new type: com.obric.memorydata.union.build.storage.h
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderIgnSame(TypeUpdate.java:73)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setImmutableType(TypeInferenceVisitor.java:111)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$0(TypeInferenceVisitor.java:102)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:102)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r1v14 ??, new type: int
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:186)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:245)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException
        */
    private final com.obric.memorydata.union.build.storage.SemanticBatchOperationResult b(com.obric.memorydata.union.build.storage.g r41, long r42) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00c7: INVOKE (r1v14 ?? I:int) = (r1v13 java.util.List<com.obric.memorydata.database.entity.ip>) INTERFACE call: java.util.List.size():int A[DECLARE_VAR, MD:():int (c)] in method: com.obric.memorydata.union.build.storage.h.b(com.obric.memorydata.union.build.storage.g, long):com.obric.memorydata.union.build.storage.SemanticBatchOperationResult, file: classes5.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
            	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
            	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
            	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
            	... 31 more
            */
        /*
            Method dump skipped, instruction units count: 648
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.obric.memorydata.union.build.storage.h.b(com.obric.memorydata.union.build.storage.g, long):com.obric.memorydata.union.build.storage.SemanticBatchOperationResult");
    }

    private final List<SemanticBatchFailure> b(List<g> r10, Map<Integer, SemanticBatchFailure> r11) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast(((Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.memorydata.plugin")).entrySet(), Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new c(), Comparator.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin");
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r14 = r12.iterator();
    L4:
        if (r14.hasNext() == false) goto L7;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r14.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        int r2 = ((Number) ZeusTransformUtils.preCheckCast(r1.getKey(), Number.class, "com.obric.memorydata.plugin")).intValue();
        r13.add(SemanticBatchFailure.copy$default((SemanticBatchFailure) ZeusTransformUtils.preCheckCast(r1.getValue(), SemanticBatchFailure.class, "com.obric.memorydata.plugin"), ((g) ZeusTransformUtils.preCheckCast(r9.get(r2), g.class, "com.obric.memorydata.plugin")).b().stableId(r2), null, null, 6, null));
        goto L4
    L7:
        return (List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.memorydata.plugin");
    }

    private final SemanticBatchOperationResult c(g r50, long r51) {
        SemanticBatchOperation r6 = r50.b();
        SemanticBatchEntityPayload r1 = r6.getEntity();
        if (r1 == null) goto L30;
        ip r8 = (ip) ZeusTransformUtils.preCheckCast(CollectionsKt.first(r50.c()), ip.class, "com.obric.memorydata.plugin");
        if (r6.getReuseSource() == false) goto L7;
        ip r2 = r1.toEntity(r8, r51);
    L8:
        ip r9 = r2;
        if (r6.getReuseSource() == true) goto L11;
    L13:
        r9.m(i.a(r50.c(), r9));
        if (ij.a(r9, Long.valueOf(r51), false, 2, null) == false) goto L28;
        if (r6.getReuseSource() == false) goto L24;
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r50.c(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r4 = r3.iterator();
    L19:
        if (r4.hasNext() == false) goto L23;
        Object r10 = r4.next();
        if ((!Intrinsics.areEqual(((ip) ZeusTransformUtils.preCheckCast(r10, ip.class, "com.obric.memorydata.plugin")).getEntityId(), r9.getEntityId())) == false) goto L19;
        r5.add(r10);
        goto L19
    L23:
        List<ip> r7 = (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin");
    L25:
        a(r9.getEntityId(), r7);
        a(r9.getEntityId(), r6.getHotWords(), true);
        a(r7, r51, null, false);
        return new SemanticBatchOperationResult(r6.stableId(r50.a()), r9.getEntityId());
    L24:
        r7 = CollectionsKt.emptyList();
        goto L25
    L28:
        throw new IllegalStateException("semantic migration write failed".toString());
    L11:
        if (r50.c().size() <= 1) goto L13;
        i.a(r9, r50.c());
        goto L13
    L7:
        r2 = r1.toEntity(ip.a(r8, 0, com.obric.memorydata.union.build.a.f13066a.a(String.valueOf(r8.i())), 0, 0, 0, 0, null, 0, UUID.randomUUID().toString(), null, null, null, null, null, null, false, 0, 0, false, false, 0.0f, null, null, null, null, null, 0, null, 0, null, null, 0, -260, null), r51);
        goto L8
    L30:
        throw new IllegalStateException("Required value was null.".toString());
    }

    private final void c(String r4) {
        JSONArray r3 = new JSONObject(r4).optJSONArray("operations");
        if (r3 != null) goto L5;
        r3 = new JSONArray();
    L5:
        int r5 = 0;
        int r0 = r3.length();
    L6:
        if (r5 >= r0) goto L18;
        JSONObject r1 = r3.optJSONObject(r5);
        if (r1 == null) goto L17;
        JSONObject r2 = r1.optJSONObject("entity");
        if (r2 == null) goto L17;
        if ((!r2.has(OaidModel.KEY_ID)) == true) goto L17;
        throw new IllegalArgumentException(("operation[" + r5 + "].entity.id is forbidden").toString());
    L17:
        r5 = r5 + 1;
        goto L6
    }

    private final SemanticBatchOperationResult d(g r13, long r14) {
        String r0 = r13.b().getRequeueKeeperId();
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r13.c(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r3 = r1.iterator();
    L3:
        boolean r5 = true;
        if (r3.hasNext() == false) goto L8;
        Object r4 = r3.next();
        if ((true ^ Intrinsics.areEqual(((ip) ZeusTransformUtils.preCheckCast(r4, ip.class, "com.obric.memorydata.plugin")).getEntityId(), r0)) == false) goto L3;
        r2.add(r4);
        goto L3
    L8:
        List<ip> r6 = (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin");
        String r10 = r13.b().getRetractionReason();
        if (r13.b().getWriteRetraction() == true) goto L11;
    L13:
        boolean r11 = false;
    L14:
        a(r6, r14, r10, r11);
        if (r0 == null) goto L25;
        if (MemoryDbEngine.INSTANCE.getPersonalDbEngine().getSemanticMemoryDao().requeueConflictKeeper(r0, r14) == 1) goto L20;
        r5 = false;
    L20:
        if (r5 == true) goto L25;
        throw new IllegalStateException("conflict keeper disappeared before requeue".toString());
    L25:
        if (r13.b().getMigrationOperation() == true) goto L28;
        j.f13127a.delete(r13.b().getBusinessId(), r6);
    L28:
        return new SemanticBatchOperationResult(r13.b().stableId(r13.a()), null);
    L11:
        if (Intrinsics.areEqual(r13.b().getWritePurpose(), "conflict_resolution") == true) goto L13;
        r11 = true;
        goto L14
    }

    public static /* synthetic */ SemanticBatchCommitResult lambda$3uT49xN_k5k1nTpHodJWAGFXgRA(SemanticBatchCommitRequest r0, boolean r1, PersonalMemoryFrameDb r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ List lambda$dRgTlkVNvsFqOdn3oQR_9Yca23I(List r0) {
        return a(r0);
    }

    public final SemanticBatchCommitResult a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "payload");
        return a(a(r2, false), false);
    }

    public final boolean a(ip r23, List<String> r24, List<String> r25) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r24, List.class, "com.obric.memorydata.plugin");
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r25, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r23, "entity");
        Intrinsics.checkNotNullParameter(r1, "targetEntityIds");
        Intrinsics.checkNotNullParameter(r13, "hotWords");
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        Object r5 = r4.next();
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L4;
        r3.add(r5);
        goto L4
    L8:
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")), Collection.class, "com.obric.memorydata.plugin");
        if (r6.isEmpty() == true) goto L11;
    L14:
        List<String> r10 = (List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin");
        SemanticMemoryDao r14 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getSemanticMemoryDao();
        if (r10.isEmpty() == false) goto L17;
        List<ip> r7 = CollectionsKt.emptyList();
    L18:
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.plus((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOfNotNull(SemanticMemoryDao.DefaultImpls.queryDuplicateCandidate$default(r14, r10, r23.c(), false, 4, null)), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin");
        HashSet r9 = new HashSet();
        ArrayList r11 = new ArrayList();
        Iterator r12 = r8.iterator();
    L20:
        if (r12.hasNext() == false) goto L24;
        Object r15 = r12.next();
        if (r9.add(((ip) ZeusTransformUtils.preCheckCast(r15, ip.class, "com.obric.memorydata.plugin")).getEntityId()) == false) goto L20;
        r11.add(r15);
        goto L20
    L24:
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Map r17 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r16, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
        Iterator r18 = r16.iterator();
    L26:
        if (r18.hasNext() == false) goto L29;
        ip r19 = (ip) ZeusTransformUtils.preCheckCast(r18.next(), ip.class, "com.obric.memorydata.plugin");
        Pair r20 = TuplesKt.to(r19.getEntityId(), Long.valueOf(r19.r()));
        r17.put(r20.getFirst(), r20.getSecond());
        goto L26
    L29:
        if (r23.getId() <= 0) goto L31;
    L34:
        String r21 = BuildConfig.CHANNEL;
    L35:
        SemanticBatchOperationResult r22 = (SemanticBatchOperationResult) ZeusTransformUtils.preCheckCast(CollectionsKt.singleOrNull(a(new SemanticBatchCommitRequest(CollectionsKt.listOf(new SemanticBatchOperation("legacy_android_producer", null, null, null, r21, r10, r17, SemanticBatchEntityPayload.Companion.a(r23), r13, null, false, false, false, false, 15886, null)), null, false, 6, null), true).getResults()), SemanticBatchOperationResult.class, "com.obric.memorydata.plugin");
        if (r22 == null) goto L45;
        String r26 = r22.getEntityId();
        if (r26 == null) goto L45;
        ip r27 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getSemanticMemoryDao().queryByEntityId(r26);
        if (r27 != null) goto L43;
        return false;
    L43:
        r23.setId(r27.getId());
        r23.b(r27.r());
        return true;
    L45:
        return false;
    L31:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L34;
        r21 = "insert";
        goto L35
    L17:
        r7 = r14.queryByEntityIds(r10);
        goto L18
    L11:
        if (r23.getId() <= 0) goto L13;
        r6 = CollectionsKt.listOf(r23.getEntityId());
        goto L14
    L13:
        r6 = CollectionsKt.emptyList();
        goto L14
    }

    public final SemanticBatchCommitResult b(String r7) {
        Intrinsics.checkNotNullParameter(r7, "payload");
        boolean r0 = true;
        SemanticBatchCommitRequest r8 = a(r7, true);
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r8.getOperations(), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, Collection.class) == true) goto L5;
    L7:
        Iterator r2 = r1.iterator();
    L9:
        if (r2.hasNext() == false) goto L13;
        if (((SemanticBatchOperation) ZeusTransformUtils.preCheckCast(r2.next(), SemanticBatchOperation.class, "com.obric.memorydata.plugin")).getMigrationOperation() == true) goto L9;
        r0 = false;
    L13:
        if (r0 == false) goto L17;
        return a(r8, false);
    L17:
        throw new IllegalArgumentException("migration commit only accepts migration operations".toString());
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
        goto L7
    }
}
