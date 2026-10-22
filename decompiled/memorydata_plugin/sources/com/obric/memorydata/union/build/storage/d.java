package com.obric.memorydata.union.build.storage;

import android.security.obric.guard.ObricSecurityGuardStub;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.room.RoomDatabase;
import com.google.gson.reflect.TypeToken;
import com.obric.capabilitykit.common.Ext;
import com.obric.memorydata.database.dao.SemanticConflictSnapshot;
import com.obric.memorydata.database.dao.SemanticDeleteLifecycle;
import com.obric.memorydata.database.dao.SemanticDeleteResult;
import com.obric.memorydata.database.dao.SemanticMemoryDao;
import com.obric.memorydata.database.dao.SemanticRetractionReason;
import com.obric.memorydata.database.entity.ie;
import com.obric.memorydata.database.entity.ij;
import com.obric.memorydata.database.entity.ip;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.database.manager.PersonalMemoryFrameDb;
import com.obric.memorydata.personalcontext.api.EntityManager;
import com.obric.memorydata.utils.GsonUtil;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\b\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ&\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\u0006\u0010\u0017\u001a\u00020\u0006H\u0002J\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0006H\u0002¨\u0006\u001a"}, d2 = {"Lcom/obric/memorydata/union/build/storage/PendingSemanticReviewManager;", "", "<init>", "()V", "directConflicts", "", "", "", "targetId", "rows", "", "Lcom/obric/memorydata/database/dao/SemanticConflictSnapshot;", "review", "Lcom/obric/memorydata/union/build/storage/SemanticConfirmationResult;", Ext.KEY_REQUEST, "Lcom/obric/memorydata/union/build/storage/PendingSemanticReviewRequest;", "applyReview", TypedValues.AttributesType.S_TARGET, "Lcom/obric/memorydata/database/entity/UnionSemanticMemoryEntity;", "conflictIds", ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CONFIRM, "", "decodeIds", "encoded", "failure", "code", "memory_build_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f13117a = null;

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonUtil$fromJsonArray$2$1", "Lcom/google/gson/reflect/TypeToken;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends TypeToken<List<? extends String>> {
        public a() {
        }
    }

    static {
        f13117a = new d();
    }

    private d() {
    }

    private final SemanticConfirmationResult a(ip r17, List<String> r18, boolean r19) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.memorydata.plugin");
        SemanticMemoryDao r2 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getSemanticMemoryDao();
        if (r19 == false) goto L9;
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.chunked((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin"), 400), Iterable.class, "com.obric.memorydata.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r3 = r1.iterator();
    L6:
        if (r3.hasNext() == false) goto L8;
        CollectionsKt.addAll(r4, (Iterable) ZeusTransformUtils.preCheckCast(r2.queryByEntityIds((List) ZeusTransformUtils.preCheckCast(r3.next(), List.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"));
        goto L6
    L8:
        List r5 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin");
    L10:
        long r6 = ij.a();
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.chunked((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin"), 400), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L11:
        boolean r8 = false;
        if (r7.hasNext() == false) goto L27;
        List r9 = (List) ZeusTransformUtils.preCheckCast(r7.next(), List.class, "com.obric.memorydata.plugin");
        SemanticDeleteResult r10 = SemanticDeleteLifecycle.deleteResolved$default(SemanticDeleteLifecycle.INSTANCE, r9, 0, SemanticRetractionReason.USER_DELETE, false, Long.valueOf(r6), 2, null);
        if (r10.getDeleted() != r9.size()) goto L16;
        boolean r11 = true;
    L17:
        if (r11 == false) goto L26;
        if (r10.getRetractions() != r9.size()) goto L21;
        r8 = true;
    L21:
        if (r8 == true) goto L11;
        throw new IllegalStateException("pending review retraction count mismatch".toString());
    L26:
        throw new IllegalStateException("pending review delete count mismatch".toString());
    L16:
        r11 = false;
        goto L17
    L27:
        if (r19 == false) goto L38;
        ip r12 = r2.queryByEntityId(r17.getEntityId());
        if (r12 == null) goto L36;
        r12.a(4.0f);
        r12.l("confirmed");
        r12.a(System.currentTimeMillis());
        if (ij.a(r12, Long.valueOf(r6), false, 2, null) == true) goto L38;
        throw new IllegalStateException("pending review promotion failed".toString());
    L36:
        throw new IllegalStateException("Required value was null.".toString());
    L38:
        return new SemanticConfirmationResult(true, "OK", r17.getEntityId(), Long.valueOf(r6));
    L9:
        r5 = CollectionsKt.listOf(r17);
        goto L10
    }

    private static final SemanticConfirmationResult a(PersonalMemoryFrameDb r5, f r6) {
        if (com.obric.memorydata.database.manager.q.f9592a.a(r5.getSemanticStateDao().queryText("migration_phase")) == false) goto L7;
        return f13117a.b("MIGRATION_IN_PROGRESS");
    L7:
        if (Intrinsics.areEqual(r5.getSemanticStateDao().queryText("restore_phase"), "running") == true) goto L9;
        ip r0 = r5.getSemanticMemoryDao().queryByEntityId(r6.a());
        if (r0 != null) goto L15;
        return f13117a.b("TARGET_NOT_FOUND");
    L15:
        if (r0.r() == r6.b()) goto L19;
        return f13117a.b("SEMANTIC_VERSION_CHANGED");
    L19:
        if (r0.l() != 3.0f) goto L21;
        boolean r1 = true;
    L22:
        if (r1 == false) goto L37;
        if (Intrinsics.areEqual(r0.s(), "pending") == false) goto L37;
        d r2 = f13117a;
        Map<String, Long> r3 = r2.a(r0.getEntityId(), r5.getSemanticMemoryDao().queryReviewConflictSnapshots());
        String r4 = e.a(r6, r3);
        if (r4 == null) goto L31;
        return r2.b(r4);
    L31:
        if (r6.d() == false) goto L33;
        List<String> r7 = e.b(r6, r3);
    L35:
        return r2.a(r0, r7, r6.d());
    L33:
        r7 = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r2.a(r0.getEntityId(), r5.getSemanticMemoryDao().queryC3ConflictSnapshots()).keySet(), Iterable.class, "com.obric.memorydata.plugin"));
    L37:
        return f13117a.b("TARGET_NOT_PENDING_C3");
    L21:
        r1 = false;
        goto L22
    L9:
        return f13117a.b("RESTORE_IN_PROGRESS");
    }

    private final List<String> a(String r6) {
        GsonUtil r5 = GsonUtil.INSTANCE;
        List r0 = null;
        if (r6 != null) goto L5;
    L13:
        if (r0 != null) goto L15;
        r0 = CollectionsKt.emptyList();
    L15:
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r8 = r7.iterator();
    L17:
        if (r8.hasNext() == false) goto L22;
        Object r2 = r8.next();
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L17;
        r1.add(r2);
        goto L17
    L22:
        return CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
    L5:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == true) goto L11;
        r6 = null;
    L11:
        if (r6 == null) goto L13;
        r0 = (List) ZeusTransformUtils.preCheckCast(GsonUtil.INSTANCE.getGSON().fromJson(r6, new a().getType()), List.class, "com.obric.memorydata.plugin");
        goto L13
    L7:
        r3 = false;
        goto L8
    }

    private final SemanticConfirmationResult b(String r8) {
        return new SemanticConfirmationResult(false, r8, null, null, 12, null);
    }

    /* JADX INFO: renamed from: lambda$4XRJOsrpVuUrVoRyVLxLF-E8Z68, reason: not valid java name */
    public static /* synthetic */ SemanticConfirmationResult m1236lambda$4XRJOsrpVuUrVoRyVLxLFE8Z68(PersonalMemoryFrameDb r0, f r1) {
        return a(r0, r1);
    }

    public final SemanticConfirmationResult a(final f r4) {
        Intrinsics.checkNotNullParameter(r4, Ext.KEY_REQUEST);
        final PersonalMemoryFrameDb r3 = MemoryDbEngine.INSTANCE.getPersonalDbEngine();
        SemanticConfirmationResult r5 = (SemanticConfirmationResult) ZeusTransformUtils.preCheckCast(ie.a((RoomDatabase) ZeusTransformUtils.preCheckCast(r3, RoomDatabase.class, "com.obric.memorydata.plugin"), new $$Lambda$d$4XRJOsrpVuUrVoRyVLxLFE8Z68(r3, r4)), SemanticConfirmationResult.class, "com.obric.memorydata.plugin");
        if (r5.getSuccess() == false) goto L5;
        EntityManager.INSTANCE.launchIndexTask();
    L5:
        return r5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Map<String, Long> a(String r9, List<SemanticConflictSnapshot> r10) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "targetId");
        Intrinsics.checkNotNullParameter(r8, "rows");
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");
        Map r2 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r11, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
        Iterator r12 = r11.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        SemanticConflictSnapshot r4 = (SemanticConflictSnapshot) ZeusTransformUtils.preCheckCast(r12.next(), SemanticConflictSnapshot.class, "com.obric.memorydata.plugin");
        Pair r5 = TuplesKt.to(r4.getEntityId(), CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast(f13117a.a(r4.getConflictEntityIds()), Iterable.class, "com.obric.memorydata.plugin")));
        r2.put(r5.getFirst(), r5.getSecond());
        goto L4
    L6:
        Set r13 = (Set) ZeusTransformUtils.preCheckCast(r2.get(r9), Set.class, "com.obric.memorydata.plugin");
        if (r13 != null) goto L9;
        r13 = SetsKt.emptySet();
    L9:
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r15 = r14.iterator();
    L11:
        if (r15.hasNext() == false) goto L25;
        Object r7 = r15.next();
        SemanticConflictSnapshot r16 = (SemanticConflictSnapshot) ZeusTransformUtils.preCheckCast(r7, SemanticConflictSnapshot.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r16.getEntityId(), r9) == false) goto L15;
    L22:
        boolean r17 = false;
    L23:
        if (r17 == false) goto L11;
        r6.add(r7);
        goto L11
    L15:
        if (r13.contains(r16.getEntityId()) == true) goto L21;
        Set r18 = (Set) ZeusTransformUtils.preCheckCast(r2.get(r16.getEntityId()), Set.class, "com.obric.memorydata.plugin");
        if (r18 != null) goto L20;
        r18 = SetsKt.emptySet();
    L20:
        if (r18.contains(r9) == false) goto L22;
    L21:
        r17 = true;
        goto L23
    L25:
        Iterable r19 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Map<String, Long> r20 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r19, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
        Iterator r21 = r19.iterator();
    L27:
        if (r21.hasNext() == false) goto L29;
        SemanticConflictSnapshot r110 = (SemanticConflictSnapshot) ZeusTransformUtils.preCheckCast(r21.next(), SemanticConflictSnapshot.class, "com.obric.memorydata.plugin");
        Pair r111 = TuplesKt.to(r110.getEntityId(), Long.valueOf(r110.getChangeSeq()));
        r20.put(r111.getFirst(), r111.getSecond());
        goto L27
    L29:
        return r20;
    }
}
