package com.obric.memorydata.personalcontext;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.aikernel.sdk.data.PackageResource;
import com.obric.memorydata.aikernelcore.MemoryScriptEngineEnv;
import com.obric.memorydata.database.dao.AlarmRawDbDao;
import com.obric.memorydata.database.dao.IndexPendingDao;
import com.obric.memorydata.database.entity.cd;
import com.obric.memorydata.database.index.ao;
import com.obric.memorydata.database.index.bc;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStore;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\b\u000b\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007H\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010\u0017\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010\u0018J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0007H\u0082@¢\u0006\u0002\u0010\u0018J\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010\u001dJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0005*\u0004\u0018\u00010\u001fH\u0002J\u0018\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0007H\u0002J\u000e\u0010%\u001a\u00020!2\u0006\u0010&\u001a\u00020'J\u000e\u0010(\u001a\u00020!2\u0006\u0010&\u001a\u00020'J&\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070*2\u0010\b\u0002\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010,H\u0002J\b\u0010-\u001a\u00020.H\u0002J \u0010/\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020#2\u0006\u0010&\u001a\u00020'2\u0006\u00100\u001a\u00020\u0007H\u0002J\u0017\u00101\u001a\u0004\u0018\u00010\u00072\u0006\u0010\"\u001a\u00020#H\u0002¢\u0006\u0002\u00102J\u0010\u00103\u001a\u00020\u00132\u0006\u0010&\u001a\u00020'H\u0002J\u001e\u00104\u001a\b\u0012\u0004\u0012\u00020\u00050,2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0007H\u0002J2\u00105\u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00072\u0018\u00106\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000508\u0012\u0004\u0012\u00020\u001307H\u0002J&\u00109\u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00072\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00050,H\u0002J\u001d\u0010;\u001a\u00020\u00052\u0006\u0010<\u001a\u00020.2\u0006\u0010=\u001a\u00020\u0005H\u0000¢\u0006\u0002\b>J#\u0010?\u001a\u00020\u00132\u0006\u0010@\u001a\u00020.2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00050,H\u0000¢\u0006\u0002\bBJO\u0010C\u001a\b\u0012\u0004\u0012\u00020'0D2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020F0D2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020.0,2\f\u0010H\u001a\b\u0012\u0004\u0012\u00020.0,2\u0010\b\u0002\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010,H\u0000¢\u0006\u0002\bIR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lcom/obric/memorydata/personalcontext/AlarmRepeatFullContentMigrationManager;", "", "<init>", "()V", "TAG", "", "PAGE_SIZE", "", "FULL_CONTENT_COLUMN", "FULL_CONTENT_BUILD_TYPE", "BUILD_ENTITY_FULL_CONTENT_PACKAGE", "BUILD_META_FULL_CONTENT_PACKAGE", "KEY_MIGRATION_VERSION", "KEY_ACTIVE_MIGRATION_VERSION", "FORMAT_VERSION_EXTRA_KEY", "isScheduling", "Ljava/util/concurrent/atomic/AtomicBoolean;", "failureStoreLock", "shouldMigrate", "", "repeatType", "shouldMigrate$personal_context_obricRelease", "(Ljava/lang/Integer;)Z", "enqueueIfNeeded", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveDeclaredFormatVersion", "packageExtraConfig", "Lcom/google/gson/JsonObject;", ObricMemoryConstants.KEY_PACKAGE_NAME, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "primitiveStringOrNull", "Lcom/google/gson/JsonElement;", "completeMigration", "", "store", "Lcom/obric/memorydata/middleware/api/store/IStore;", "targetVersion", "recordTerminalFailure", "pendingEntity", "Lcom/obric/memorydata/database/entity/IndexPendingEntity;", "recordTaskSuccess", "enqueueMigrationTasks", "Lkotlin/Pair;", "targetTaskKeys", "", "queryMigrationPendingCount", "", "isActiveMigrationTask", "activeVersion", "activeMigrationVersion", "(Lcom/obric/memorydata/middleware/api/store/IStore;)Ljava/lang/Integer;", "isMigrationTask", "getTerminalFailureKeys", "updateTerminalFailureKeys", com.obric.memorydata.BuildConfig.CHANNEL, "Lkotlin/Function1;", "", "removeTerminalFailureKeys", "handledKeys", "migrationTaskKey", "rawDbId", "columnContent", "migrationTaskKey$personal_context_obricRelease", "shouldCompleteMigration", "pendingCount", "terminalFailureKeys", "shouldCompleteMigration$personal_context_obricRelease", "buildPendingTasks", "", "existingData", "Lcom/obric/memorydata/database/SimpleEntityData;", "existingFullContentRawDbIds", "existingMetaFullContentRawDbIds", "buildPendingTasks$personal_context_obricRelease", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f12038a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicBoolean f12039b = null;
    private static final Object c = null;

    static {
        f12038a = new b();
        f12039b = new AtomicBoolean(false);
        c = new Object();
    }

    private b() {
    }

    private final long a() {
        IndexPendingDao r5 = com.obric.memorydata.database.manager.c.f9561a.b(701);
        return r5.queryCountByEntityTypeAndColumn(701, "fullContent") + r5.queryCountByEntityTypeAndColumn(701, "meta_full_content");
    }

    private final Integer a(IStore r3) {
        boolean r1 = false;
        Integer r2 = Integer.valueOf(((IStore) ZeusTransformUtils.wrapperContextForParams(r3, IStore.class, "com.obric.memorydata.plugin")).getInt("alarm_repeat_full_content_active_version", 0));
        if (((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.memorydata.plugin")).intValue() <= 0) goto L5;
        r1 = true;
    L5:
        if (r1 == true) goto L9;
        return null;
    L9:
        return r2;
    }

    public static final /* synthetic */ Object a(b r2, String r3, Continuation r4) {
        return r2.a(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ Object a(b r2, Continuation r3) {
        return r2.b((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    private final Object a(String r7, Continuation<? super JsonObject> r8) {
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r9, AlarmRepeatFullContentMigrationManager$packageExtraConfig$1.class) == false) goto L7;
        AlarmRepeatFullContentMigrationManager$packageExtraConfig$1 r0 = (AlarmRepeatFullContentMigrationManager$packageExtraConfig$1) ZeusTransformUtils.preCheckCast(r9, AlarmRepeatFullContentMigrationManager$packageExtraConfig$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r6 = r0.result;
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L16;
        if (r2 == 1) goto L15;
        if (r2 != 2) goto L14;
        ResultKt.throwOnFailure(r6);
    L30:
        return (JsonObject) ZeusTransformUtils.preCheckCast(r6, JsonObject.class, "com.obric.memorydata.plugin");
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r7 = (String) ZeusTransformUtils.preCheckCast(r0.L$0, String.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r6);
    L19:
        PackageResource r11 = (PackageResource) ZeusTransformUtils.preCheckCast(r6, PackageResource.class, "com.obric.memorydata.plugin");
        if (r11 != null) goto L22;
        return null;
    L22:
        if (r11.isAvailable() == true) goto L25;
        r11 = null;
    L25:
        if (r11 == null) goto L32;
        MemoryScriptEngineEnv r12 = MemoryScriptEngineEnv.INSTANCE;
        r0.L$0 = null;
        r0.label = 2;
        r6 = r12.getPackageCustomConfig(r7, r0);
        if (r6 != r10) goto L30;
        return r10;
    L32:
        return null;
    L16:
        ResultKt.throwOnFailure(r6);
        MemoryScriptEngineEnv r13 = MemoryScriptEngineEnv.INSTANCE;
        r0.L$0 = r7;
        r0.label = 1;
        r6 = r13.getPackage(r7, r0);
        if (r6 != r10) goto L19;
        return r10;
    L7:
        r0 = new AlarmRepeatFullContentMigrationManager$packageExtraConfig$1(this, r9);
        goto L8
    }

    private final String a(JsonElement r3) {
        boolean r2 = true;
        if (r3 != null) goto L5;
    L7:
        r2 = false;
    L8:
        if (r2 == true) goto L12;
        return null;
    L12:
        return r3.getAsString();
    L5:
        if (r3.isJsonPrimitive() != true) goto L7;
        goto L7
    }

    static /* synthetic */ Pair a(b r1, Set r2, int r3, Object r4) {
        Set<String> r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.memorydata.plugin");
        if ((r3 & 1) == 0) goto L6;
        r5 = null;
    L6:
        return r1.a(r5);
    }

    private final Pair<Integer, Integer> a(Set<String> r21) {
        Set<String> r0 = (Set) ZeusTransformUtils.wrapperContextForParams(r21, Set.class, "com.obric.memorydata.plugin");
        AlarmRawDbDao r2 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getAlarmRawDbDao();
        IndexPendingDao r3 = com.obric.memorydata.database.manager.c.f9561a.b(701);
        int r5 = 0;
        long r7 = -1;
        int r6 = 0;
    L3:
        List<com.obric.memorydata.database.b> r8 = r2.queryRepeatTypeFullContentMigrationData(100, r7);
        if (r8.isEmpty() == true) goto L6;
        long r9 = ((com.obric.memorydata.database.b) ZeusTransformUtils.preCheckCast(CollectionsKt.last(r8), com.obric.memorydata.database.b.class, "com.obric.memorydata.plugin")).a();
        r5 = r5 + r8.size();
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r12 = r10.iterator();
    L9:
        if (r12.hasNext() == false) goto L11;
        r11.add(Long.valueOf(((com.obric.memorydata.database.b) ZeusTransformUtils.preCheckCast(r12.next(), com.obric.memorydata.database.b.class, "com.obric.memorydata.plugin")).a()));
        goto L9
    L11:
        List<Long> r13 = (List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.memorydata.plugin");
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r3.queryWithRawDbIdsAndColumn(r13, 701, "fullContent"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r15 = (Collection) ZeusTransformUtils.preCheckCast(new HashSet(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r16 = r14.iterator();
    L13:
        if (r16.hasNext() == false) goto L15;
        r15.add(Long.valueOf(((cd) ZeusTransformUtils.preCheckCast(r16.next(), cd.class, "com.obric.memorydata.plugin")).b()));
        goto L13
    L15:
        HashSet r17 = (HashSet) ZeusTransformUtils.preCheckCast(r15, HashSet.class, "com.obric.memorydata.plugin");
        Iterable r18 = (Iterable) ZeusTransformUtils.preCheckCast(r3.queryWithRawDbIdsAndColumn(r13, 701, "meta_full_content"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r19 = (Collection) ZeusTransformUtils.preCheckCast(new HashSet(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r110 = r18.iterator();
    L17:
        if (r110.hasNext() == false) goto L19;
        r19.add(Long.valueOf(((cd) ZeusTransformUtils.preCheckCast(r110.next(), cd.class, "com.obric.memorydata.plugin")).b()));
        goto L17
    L19:
        List<cd> r20 = a(r8, (Set) ZeusTransformUtils.preCheckCast(r17, Set.class, "com.obric.memorydata.plugin"), (Set) ZeusTransformUtils.preCheckCast((HashSet) ZeusTransformUtils.preCheckCast(r19, HashSet.class, "com.obric.memorydata.plugin"), Set.class, "com.obric.memorydata.plugin"), r0);
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r20, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L22;
        ao.a(ao.f9372a, "PUBLIC", r20, (bc) ZeusTransformUtils.preCheckCast(new bc.a(System.currentTimeMillis()), bc.class, "com.obric.memorydata.plugin"), null, 8, null);
        r6 = r6 + r20.size();
    L22:
        r7 = r9;
        goto L3
    L6:
        return TuplesKt.to(Integer.valueOf(r5), Integer.valueOf(r6));
    }

    private final void a(IStore r7, int r8) {
        IStore r6 = (IStore) ZeusTransformUtils.wrapperContextForParams(r7, IStore.class, "com.obric.memorydata.plugin");
        r6.save("alarm_repeat_full_content_index_version", r8);
        r6.remove(new String[]{"alarm_repeat_full_content_active_version"});
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AlarmRepeatFullContentMigration", "migration completed, version=" + r8, false, 4, null);
    }

    private final void a(IStore r3, int r4, Set<String> r5) {
        IStore r6 = (IStore) ZeusTransformUtils.wrapperContextForParams(r3, IStore.class, "com.obric.memorydata.plugin");
        final Set r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
        a(r6, r4, new $$Lambda$b$AwyIYJUGz79psfD2MMqV0gJY5FU(r7));
    }

    private final void a(IStore r4, int r5, Function1<? super Set<String>, Boolean> r6) {
        IStore r3 = (IStore) ZeusTransformUtils.wrapperContextForParams(r4, IStore.class, "com.obric.memorydata.plugin");
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
        Object r8 = c;
        monitor-enter(r8);
        Set<String> r0 = CollectionsKt.toMutableSet((Iterable) ZeusTransformUtils.preCheckCast(r3.getStringSet(a.f12029a.b(r5), SetsKt.emptySet()), Iterable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L10
        if (((Boolean) ZeusTransformUtils.preCheckCast(r7.invoke(r0), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L7;
        r3.saveStringSet(a.f12029a.b(r5), r0);     // Catch: Throwable -> L10
    L7:
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r8);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private static final boolean a(cd r3, Set r4) {
        Set r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "failureKeys");
        return r5.add(f12038a.a(r3.b(), r3.h()));
    }

    private final boolean a(IStore r3, cd r4, int r5) {
        IStore r6 = (IStore) ZeusTransformUtils.wrapperContextForParams(r3, IStore.class, "com.obric.memorydata.plugin");
        if (r6.getInt("alarm_repeat_full_content_index_version", 0) < r5) goto L5;
        return false;
    L5:
        if (r6.getBoolean(a.f12029a.a(r5), false) == true) goto L7;
        return false;
    L7:
        if (c(r4) == false) goto L12;
        return true;
    L12:
        return false;
    }

    private static final boolean a(Set r2, Set r3) {
        Set r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.memorydata.plugin");
        Set r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "failureKeys");
        return r5.removeAll((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin"));
    }

    private final Object b(Continuation<? super Integer> r9) {
        Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r10, AlarmRepeatFullContentMigrationManager$resolveDeclaredFormatVersion$1.class) == false) goto L7;
        AlarmRepeatFullContentMigrationManager$resolveDeclaredFormatVersion$1 r1 = (AlarmRepeatFullContentMigrationManager$resolveDeclaredFormatVersion$1) ZeusTransformUtils.preCheckCast(r10, AlarmRepeatFullContentMigrationManager$resolveDeclaredFormatVersion$1.class, "com.obric.memorydata.plugin");
        if ((r1.label & Integer.MIN_VALUE) == 0) goto L7;
        r1.label -= Integer.MIN_VALUE;
    L8:
        Object r11 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 == 0) goto L16;
        if (r4 == 1) goto L15;
        if (r4 != 2) goto L14;
        JsonObject r8 = (JsonObject) ZeusTransformUtils.preCheckCast(r1.L$1, JsonObject.class, "com.obric.memorydata.plugin");
        b r0 = (b) ZeusTransformUtils.preCheckCast(r1.L$0, b.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r11);
    L23:
        JsonObject r12 = (JsonObject) ZeusTransformUtils.preCheckCast(r11, JsonObject.class, "com.obric.memorydata.plugin");
        a r2 = a.f12029a;
        JsonElement r5 = null;
        if (r8 == null) goto L26;
        JsonElement r13 = r8.get("alarm_full_content_format_version");
    L27:
        String r14 = r0.a(r13);
        if (r12 == null) goto L31;
        r5 = r12.get("alarm_full_content_format_version");
    L31:
        return r2.a(r14, r0.a(r5));
    L26:
        r13 = null;
        goto L27
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        b this = (b) ZeusTransformUtils.preCheckCast(r1.L$0, b.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r11);
    L19:
        JsonObject r15 = (JsonObject) ZeusTransformUtils.preCheckCast(r11, JsonObject.class, "com.obric.memorydata.plugin");
        r1.L$0 = this;
        r1.L$1 = r15;
        r1.label = 2;
        Object r6 = this.a("build_meta_full_content", r1);
        if (r6 != r3) goto L22;
        return r3;
    L22:
        r0 = this;
        r8 = r15;
        r11 = r6;
        goto L23
    L16:
        ResultKt.throwOnFailure(r11);
        r1.L$0 = this;
        r1.label = 1;
        r11 = a("build_entity_full_content", r1);
        if (r11 != r3) goto L19;
        return r3;
    L7:
        r1 = new AlarmRepeatFullContentMigrationManager$resolveDeclaredFormatVersion$1(this, r10);
        goto L8
    }

    private final Set<String> b(IStore r2, int r3) {
        IStore r1 = (IStore) ZeusTransformUtils.wrapperContextForParams(r2, IStore.class, "com.obric.memorydata.plugin");
        Object r4 = c;
        monitor-enter(r4);
        Set<String> r5 = CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast(r1.getStringSet(a.f12029a.b(r3), SetsKt.emptySet()), Iterable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L7
        monitor-exit(r4);
        return r5;
    L7:
        th = move-exception;
        throw th;
    }

    private static final boolean b(cd r3, Set r4) {
        Set r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "failureKeys");
        return r5.remove(f12038a.a(r3.b(), r3.h()));
    }

    private final boolean c(cd r2) {
        if (r2.c() == 701) goto L5;
    L9:
        return false;
    L5:
        if (Intrinsics.areEqual(r2.h(), "fullContent") == false) goto L7;
    L8:
        return true;
    L7:
        if (Intrinsics.areEqual(r2.h(), "meta_full_content") == false) goto L9;
        goto L8
    }

    public static /* synthetic */ boolean lambda$7dKsCQaYbY_qmt_VRsNfZWWzrrU(cd r0, Set r1) {
        return b(r0, r1);
    }

    public static /* synthetic */ boolean lambda$AwyIYJUGz79psfD2MMqV0gJY5FU(Set r0, Set r1) {
        return a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$HI-sVKgoeYooWXLSVQIIjMUv0Is, reason: not valid java name */
    public static /* synthetic */ boolean m1055lambda$HIsVKgoeYooWXLSVQIIjMUv0Is(cd r0, Set r1) {
        return a(r0, r1);
    }

    public final Object a(Continuation<? super Boolean> r21) {
        b r0 = this;
        Continuation r1 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r21, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, AlarmRepeatFullContentMigrationManager$enqueueIfNeeded$1.class) == false) goto L7;
        AlarmRepeatFullContentMigrationManager$enqueueIfNeeded$1 r3 = (AlarmRepeatFullContentMigrationManager$enqueueIfNeeded$1) ZeusTransformUtils.preCheckCast(r1, AlarmRepeatFullContentMigrationManager$enqueueIfNeeded$1.class, "com.obric.memorydata.plugin");
        if ((r3.label & Integer.MIN_VALUE) == 0) goto L7;
        r3.label -= Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r3.label;
        boolean r8 = true;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        int r6 = r3.I$0;
        Integer r7 = (Integer) ZeusTransformUtils.preCheckCast(r3.L$2, Integer.class, "com.obric.memorydata.plugin");
        IStore r9 = (IStore) ZeusTransformUtils.preCheckCast(r3.L$1, IStore.class, "com.obric.memorydata.plugin");
        b r10 = (b) ZeusTransformUtils.preCheckCast(r3.L$0, b.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r2);
        int r11 = r6;
        r0 = r10;
        Object r12 = r2;
    L25:
        Integer r13 = (Integer) ZeusTransformUtils.preCheckCast(r12, Integer.class, "com.obric.memorydata.plugin");
        Integer r14 = a.f12029a.a(r7, r11, r13);
        if (r14 != null) goto L29;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AlarmRepeatFullContentMigration", "skip migration for versions: active=" + r7 + ", applied=" + r11 + ", declared=" + r13, false, 4, null);
        return Boxing.boxBoolean(false);
    L29:
        AtomicBoolean r15 = f12039b;
        if (r15.compareAndSet(false, true) == false) goto L32;
        r9.save("alarm_repeat_full_content_active_version", r14.intValue());     // Catch: Throwable -> L56
        String r16 = a.f12029a.a(r14.intValue());     // Catch: Throwable -> L56
        if (r9.getBoolean(r16, false) == false) goto L50;
    L35:
        long r17 = r0.a();     // Catch: Throwable -> L56
        if (r17 > 0) goto L37;
        Set<String> r18 = r0.b(r9, r14.intValue());     // Catch: Throwable -> L56
        if (r0.a(r17, r18) == true) goto L42;
        int r19 = ((Number) ZeusTransformUtils.preCheckCast(r0.a(r18).component2(), Number.class, "com.obric.memorydata.plugin")).intValue();     // Catch: Throwable -> L56
        r0.a(r9, r14.intValue(), r18);     // Catch: Throwable -> L56
        long r110 = r0.a();     // Catch: Throwable -> L56
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AlarmRepeatFullContentMigration", "retry terminal failure tasks complete, failureCount=" + r18.size() + ", retryCount=" + r19 + ", pendingCount=" + r110, false, 4, null);     // Catch: Throwable -> L56
        if (r110 <= 0) goto L35;
        Boolean r20 = Boxing.boxBoolean(true);     // Catch: Throwable -> L56
        f12039b.set(false);
        return r20;
    L42:
        r0.a(r9, r14.intValue());     // Catch: Throwable -> L56
        Boolean r22 = Boxing.boxBoolean(false);     // Catch: Throwable -> L56
        f12039b.set(false);
        return r22;
    L37:
        Boolean r23 = Boxing.boxBoolean(true);     // Catch: Throwable -> L56
        f12039b.set(false);
        return r23;
    L50:
        Pair r24 = a(r0, null, 1, null);     // Catch: Throwable -> L56
        int r25 = ((Number) ZeusTransformUtils.preCheckCast(r24.component1(), Number.class, "com.obric.memorydata.plugin")).intValue();     // Catch: Throwable -> L56
        int r26 = ((Number) ZeusTransformUtils.preCheckCast(r24.component2(), Number.class, "com.obric.memorydata.plugin")).intValue();     // Catch: Throwable -> L56
        r9.save(r16, true);     // Catch: Throwable -> L56
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AlarmRepeatFullContentMigration", "enqueue migration tasks complete, alarmCount=" + r25 + ", insertedCount=" + r26, false, 4, null);     // Catch: Throwable -> L56
        if (r25 != 0) goto L54;
        r0.a(r9, r14.intValue());     // Catch: Throwable -> L56
        r8 = false;
    L54:
        r15.set(false);
        return Boxing.boxBoolean(r8);
    L56:
        th = move-exception;
        f12039b.set(false);
        throw th;
    L32:
        return Boxing.boxBoolean(false);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r2);
        r9 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null);
        r11 = r9.getInt("alarm_repeat_full_content_index_version", 0);
        Integer r111 = Boxing.boxInt(r9.getInt("alarm_repeat_full_content_active_version", 0));
        if (((Number) ZeusTransformUtils.preCheckCast(r111, Number.class, "com.obric.memorydata.plugin")).intValue() <= 0) goto L17;
        boolean r112 = true;
    L18:
        if (r112 == true) goto L21;
        r111 = null;
    L21:
        r3.L$0 = r0;
        r3.L$1 = r9;
        r3.L$2 = r111;
        r3.I$0 = r11;
        r3.label = 1;
        r12 = r0.b(r3);
        if (r12 != r4) goto L24;
        return r4;
    L24:
        r7 = r111;
        goto L25
    L17:
        r112 = false;
    L7:
        r3 = new AlarmRepeatFullContentMigrationManager$enqueueIfNeeded$1(r0, r1);
        goto L8
    }

    public final String a(long r1, String r3) {
        Intrinsics.checkNotNullParameter(r3, "columnContent");
        return r1 + ':' + r3;
    }

    public final List<cd> a(List<com.obric.memorydata.database.b> r33, Set<Long> r34, Set<Long> r35, Set<String> r36) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r33, List.class, "com.obric.memorydata.plugin");
        Set r2 = (Set) ZeusTransformUtils.wrapperContextForParams(r34, Set.class, "com.obric.memorydata.plugin");
        Set r3 = (Set) ZeusTransformUtils.wrapperContextForParams(r35, Set.class, "com.obric.memorydata.plugin");
        Set r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r36, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r0, "existingData");
        Intrinsics.checkNotNullParameter(r2, "existingFullContentRawDbIds");
        Intrinsics.checkNotNullParameter(r3, "existingMetaFullContentRawDbIds");
        List r5 = CollectionsKt.createListBuilder();
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r1.hasNext() == false) goto L18;
        com.obric.memorydata.database.b r6 = (com.obric.memorydata.database.b) ZeusTransformUtils.preCheckCast(r1.next(), com.obric.memorydata.database.b.class, "com.obric.memorydata.plugin");
        b r7 = f12038a;
        String r8 = r7.a(r6.a(), "fullContent");
        if (r2.contains(Long.valueOf(r6.a())) == true) goto L11;
        if (r4 != null) goto L9;
    L10:
        r5.add(new cd(0, r6.a(), 701, r6.b(), r6.c(), 0, 0, "fullContent", "full_content", 0, 0, null, false, 0, 0, 32353, null));
        goto L11
    L9:
        if (r4.contains(r8) == true) goto L10;
    L11:
        String r9 = r7.a(r6.a(), "meta_full_content");
        if (r3.contains(Long.valueOf(r6.a())) == true) goto L4;
        if (r4 == null) goto L16;
        if (r4.contains(r9) == false) goto L4;
    L16:
        r5.add(new cd(0, r6.a(), 701, r6.b(), r6.c(), 0, 0, "meta_full_content", "meta_full_content", 0, 0, null, false, 0, 0, 32353, null));
        goto L4
    L18:
        return CollectionsKt.build(r5);
    }

    public final void a(final cd r6) {
        Intrinsics.checkNotNullParameter(r6, "pendingEntity");
        if (c(r6) == true) goto L5;
        return;
    L5:
        IStore r0 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null);
        Integer r1 = a(r0);
        if (r1 == null) goto L12;
        int r2 = r1.intValue();
        if (a(r0, r6, r2) == true) goto L10;
        return;
    L10:
        a(r0, r2, new $$Lambda$b$HIsVKgoeYooWXLSVQIIjMUv0Is(r6));
        return;
    }

    public final boolean a(long r3, Set<String> r5) {
        Set r2 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "terminalFailureKeys");
        if (r3 == 0) goto L5;
    L7:
        return false;
    L5:
        if (r2.isEmpty() == false) goto L7;
        return true;
    }

    public final void b(final cd r6) {
        Intrinsics.checkNotNullParameter(r6, "pendingEntity");
        if (c(r6) == true) goto L5;
        return;
    L5:
        IStore r0 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null);
        Integer r1 = a(r0);
        if (r1 == null) goto L12;
        int r2 = r1.intValue();
        if (a(r0, r6, r2) == true) goto L10;
        return;
    L10:
        a(r0, r2, new $$Lambda$b$7dKsCQaYbY_qmt_VRsNfZWWzrrU(r6));
        return;
    }
}
