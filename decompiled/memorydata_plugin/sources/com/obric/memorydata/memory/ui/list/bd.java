package com.obric.memorydata.memory.ui.list;

import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingData;
import androidx.paging.PagingSource;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.database.entity.EpisodicMemoryEntity;
import com.obric.memorydata.database.entity.bp;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.recommend.RecommendApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000b\u001a\u00020\fJ\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000eJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u0005J\u001a\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u000e2\u0006\u0010\u0016\u001a\u00020\u0017J\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00100\u00142\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014J\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000e2\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\fH\u0082@¢\u0006\u0002\u0010\u001dJ\u0018\u0010\u001e\u001a\u00020\u00172\b\b\u0002\u0010\u001f\u001a\u00020 H\u0086@¢\u0006\u0002\u0010!J\u0016\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020 H\u0086@¢\u0006\u0002\u0010!J\f\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u0014J\u001e\u0010&\u001a\u00020 2\u0006\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020)H\u0086@¢\u0006\u0002\u0010*J\b\u0010+\u001a\u00020\fH\u0002J\n\u0010,\u001a\u0004\u0018\u00010\u001bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/RecommendMemoryRepository;", "", "<init>", "()V", "TAG", "", "MEMORY_STORAGE_KEY_SCREEN_MEMORY_VALIDATE_DAY", "LAST_OPEN_SCREEN__MEMORY_SWITCH_TIME_STAMP", "VALIDATE_SCREEN_MEMORY_OPEN_STATUS_KEY", "IS_REFRESH_SCREEN_MEMORY_VALIDATE_DAY_OTA", "MEMORY_STORAGE_KEY_SHOWN_MIN_TIMESTAMP", "initScreenMemoryValidateDayListener", "", "getList", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingData;", "Lcom/obric/memorydata/database/entity/EpisodicMemoryEntity;", "getEntityById", "entityId", "getEpisodicTopicMemoryEntity", "", "Lcom/obric/memorydata/database/entity/EpisodicTopicMemoryEntity;", "memoryDbId", "", "getEntityByEpisodicTopicEntity", "topicEntity", "date", "Ljava/time/LocalDate;", "refreshScreenMemoryValidateDay", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getScreenMemoryValidateDay", "isForceEnable", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onScreenMemoryOpenStatusChange", "isEnable", "getScreenMemoryDateList", "Lcom/obric/memorydata/memory/ui/list/MemoryCalendarWeek;", "deleteMemory", OaidModel.KEY_ID, EventBody.KEY_CATEGORY, "", "(JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshShownMinTimestamp", "getShownMinDate", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class bd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final bd f11226a = null;

    static {
        f11226a = new bd();
    }

    private bd() {
    }

    private static final PagingSource a(long r1, long r3) {
        return MemoryDbEngine.INSTANCE.getPersonalDbEngine().getEpisodicMemoryDao().getAllRecommendMemoryByTimeRange(r1, r3);
    }

    private static final n a(Set r2, LocalDate r3) {
        Set r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "it");
        return new n(r3, !r4.contains(r3));
    }

    public static /* synthetic */ Object a(bd r1, boolean r2, Continuation r3, int r4, Object r5) {
        Continuation<? super Long> r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        if ((r4 & 1) == 0) goto L6;
        r2 = false;
    L6:
        return r1.a(r2, r6);
    }

    private final Object a(Continuation<? super Unit> r22) {
        Continuation r0 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r22, Continuation.class, "com.obric.memorydata.plugin");
        boolean r1 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getBoolean("is_refresh_screen_memory_validate_day_ota", false);
        long r7 = System.currentTimeMillis();
        long r13 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getLong("last_open_screen_memory_switch_time_stamp", 0);
        if (r1 == true) goto L5;
    L6:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "RecommendMemoryRepository", "refreshScreenMemoryValidateDay, isRefreshValidateDay = " + r1 + ", lastOpenScreenMemorySwitchTimeStamp = " + r13 + ", now = " + r7, false, 4, null);
        long r8 = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
        Long r2 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getEpisodicMemoryDao().getScreenMemoryValidateDay(r8);
        if (r2 == null) goto L9;
        long r11 = r2.longValue();
    L10:
        long r9 = r8 - 1;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "RecommendMemoryRepository", "refreshScreenMemoryValidateDay, screenMemoryValidateDayFromHistory = " + r11 + "， timeStamp = " + r9, false, 4, null);
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).save("is_refresh_screen_memory_validate_day_ota", true);
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).save("screen_memory_validate_day", r11);
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).save("last_open_screen_memory_switch_time_stamp", r9);
    L12:
        return Unit.INSTANCE;
    L9:
        r11 = 0;
        goto L10
    L5:
        if (r13 <= r7) goto L12;
        goto L6
    }

    private static final boolean a(LocalDate r2, LocalDate r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        return r3.isBefore((ChronoLocalDate) ZeusTransformUtils.preCheckCast(r2.plusDays(1), ChronoLocalDate.class, "com.obric.memorydata.plugin"));
    }

    private static final p b(List r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "days");
        return new p(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin")), "");
    }

    private static final LocalDate b(LocalDate r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return r2.plusDays(1);
    }

    private static final boolean b(LocalDate r2, LocalDate r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        return r3.isBefore((ChronoLocalDate) ZeusTransformUtils.preCheckCast(r2.plusDays(1), ChronoLocalDate.class, "com.obric.memorydata.plugin"));
    }

    private static final n c(LocalDate r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return new n(r2, true);
    }

    private static final p c(List r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "days");
        return new p(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin")), "");
    }

    private final void c() {
        if (((Boolean) ZeusTransformUtils.preCheckCast(RecommendApi.INSTANCE.screenObservationEnabled().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L5;
        return;
    L5:
        long r2 = System.currentTimeMillis();
        long r10 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getLong("screen_memory_shown_min_timestamp", 0);
        if (r10 < r2) goto L8;
    L9:
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).save("screen_memory_shown_min_timestamp", r2);
        return;
    L8:
        if (r10 == 0) goto L9;
    }

    private final LocalDate d() {
        long r4 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getLong("screen_memory_shown_min_timestamp", 0);
        if (r4 != 0) goto L5;
        return null;
    L5:
        return Instant.ofEpochMilli(r4).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    private static final LocalDate d(LocalDate r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return r2.plusDays(1);
    }

    public static /* synthetic */ LocalDate lambda$7gHDEQCCqYXBU1BCCSEKpZY_Gw4(LocalDate r0) {
        return d(r0);
    }

    /* JADX INFO: renamed from: lambda$BOLcp-0MBvLPjB9KMCzjZWe_3lU, reason: not valid java name */
    public static /* synthetic */ p m935lambda$BOLcp0MBvLPjB9KMCzjZWe_3lU(List r0) {
        return b(r0);
    }

    public static /* synthetic */ p lambda$Jowx9iifzq505CXKeyC8k0CsNes(List r0) {
        return c(r0);
    }

    /* JADX INFO: renamed from: lambda$L6u1UYxWE60RcvG4-i_2Ku0MElU, reason: not valid java name */
    public static /* synthetic */ PagingSource m936lambda$L6u1UYxWE60RcvG4i_2Ku0MElU(long r0, long r2) {
        return a(r0, r2);
    }

    /* JADX INFO: renamed from: lambda$_8z7I_Q-k42TDGNz9VbzqyvcbKo, reason: not valid java name */
    public static /* synthetic */ boolean m937lambda$_8z7I_Qk42TDGNz9VbzqyvcbKo(LocalDate r0, LocalDate r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ LocalDate lambda$cCndQ1xZBPvQvr4ZDhmmD4z5SDw(LocalDate r0) {
        return b(r0);
    }

    public static /* synthetic */ n lambda$eXx6ISHC1HYE4zRv0A70z5QQQNc(Set r0, LocalDate r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ n lambda$kzj1D4myactvXwtuLlbLB_IF27s(LocalDate r0) {
        return c(r0);
    }

    public static /* synthetic */ boolean lambda$mvnjtlYMIxMgi_1wzafpCWczhLU(LocalDate r0, LocalDate r1) {
        return b(r0, r1);
    }

    public final EpisodicMemoryEntity a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "entityId");
        return (EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getEpisodicMemoryDao().getEpisodicMemoryEntity(r2)), EpisodicMemoryEntity.class, "com.obric.memorydata.plugin");
    }

    public final Object a(boolean r11, Continuation<? super Long> r12) {
        Continuation r13 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r13, RecommendMemoryRepository$getScreenMemoryValidateDay$1.class) == false) goto L7;
        RecommendMemoryRepository$getScreenMemoryValidateDay$1 r0 = (RecommendMemoryRepository$getScreenMemoryValidateDay$1) ZeusTransformUtils.preCheckCast(r13, RecommendMemoryRepository$getScreenMemoryValidateDay$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = true;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r11 = r0.Z$0;
        ResultKt.throwOnFailure(r14);
    L17:
        long r8 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getLong("last_open_screen_memory_switch_time_stamp", 0);
        long r5 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getLong("screen_memory_validate_day", 0);
        if (((Boolean) ZeusTransformUtils.preCheckCast(RecommendApi.INSTANCE.screenObservationEnabled().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L23;
        if (r11 == true) goto L23;
        r4 = false;
    L23:
        if (r4 == false) goto L28;
        if (r8 <= 0) goto L28;
        LocalDate r15 = LocalDate.now();
        LocalDate r1 = Instant.ofEpochMilli(r8).atZone(ZoneId.systemDefault()).toLocalDate();
        long r6 = r15.toEpochDay() - r1.toEpochDay();
        RunLog.INSTANCE.debug("RecommendMemoryRepository", "getScreenMemoryValidateDay, gapDay = " + r6 + ", screenMemoryValidateDay = " + r5 + ", lastOpenScreenMemorySwitchTimeStamp = " + r8 + ", currentDate = " + r15 + ", lastSwitchDate = " + r1);
        r5 = r5 + r6;
    L28:
        return Boxing.boxLong(RangesKt.coerceAtLeast(r5, 1));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        r0.Z$0 = r11;
        r0.label = 1;
        if (a(r0) != r2) goto L17;
        return r2;
    L7:
        r0 = new RecommendMemoryRepository$getScreenMemoryValidateDay$1(this, r13);
        goto L8
    }

    public final List<EpisodicMemoryEntity> a(List<bp> r11) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "topicEntity");
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin");
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r14 = r12.iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        CollectionsKt.addAll(r13, (Iterable) ZeusTransformUtils.preCheckCast(StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(((bp) ZeusTransformUtils.preCheckCast(r14.next(), bp.class, "com.obric.memorydata.plugin")).b(), CharSequence.class, "com.obric.memorydata.plugin"), new char[]{','}, false, 0, 6, null), Iterable.class, "com.obric.memorydata.plugin"));
        goto L4
    L6:
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r16 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r17 = r15.iterator();
    L8:
        if (r17.hasNext() == false) goto L16;
        Object r1 = r17.next();
        if (((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L12;
        boolean r4 = true;
    L13:
        if (r4 == false) goto L8;
        r16.add(r1);
        goto L8
    L12:
        r4 = false;
        goto L13
    L16:
        return MemoryDbEngine.INSTANCE.getPersonalDbEngine().getEpisodicMemoryDao().getEpisodicMemoryEntityByEntities(CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r16, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")));
    }

    public final kotlinx.coroutines.flow.i<List<bp>> a(long r1) {
        return MemoryDbEngine.INSTANCE.getPersonalDbEngine().getEpisodicTopicMemoryDao().getEpisodicTopicMemoryEntity(String.valueOf(r1));
    }

    public final kotlinx.coroutines.flow.i<PagingData<EpisodicMemoryEntity>> a(LocalDate r21) {
        Intrinsics.checkNotNullParameter(r21, "date");
        ZoneId r1 = ZoneId.systemDefault();
        final long r2 = r21.atStartOfDay(r1).toInstant().toEpochMilli();
        final long r0 = r21.plusDays(1).atStartOfDay(r1).toInstant().toEpochMilli();
        Object r6 = null;
        return new Pager(new PagingConfig(20, 20, false, 20, 0, 0, 52, null), r6, new $$Lambda$bd$L6u1UYxWE60RcvG4i_2Ku0MElU(r2, r0), 2, null).getFlow();
    }

    public final void a() {
        kotlinx.coroutines.i.a(kotlinx.coroutines.am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new RecommendMemoryRepository$initScreenMemoryValidateDayListener$1(null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    public final Object b(boolean r22, Continuation<? super Unit> r23) {
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r23, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, RecommendMemoryRepository$onScreenMemoryOpenStatusChange$1.class) == false) goto L7;
        RecommendMemoryRepository$onScreenMemoryOpenStatusChange$1 r4 = (RecommendMemoryRepository$onScreenMemoryOpenStatusChange$1) ZeusTransformUtils.preCheckCast(r2, RecommendMemoryRepository$onScreenMemoryOpenStatusChange$1.class, "com.obric.memorydata.plugin");
        if ((r4.label & Integer.MIN_VALUE) == 0) goto L7;
        r4.label -= Integer.MIN_VALUE;
    L8:
        Object r3 = r4.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r4.label;
        if (r6 == 0) goto L14;
        if (r6 != 1) goto L13;
        boolean r0 = r4.Z$0;
        ResultKt.throwOnFailure(r3);
    L27:
        long r1 = ((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).longValue();
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).save("screen_memory_validate_day", r1);
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).save("last_open_screen_memory_switch_time_stamp", System.currentTimeMillis());
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "RecommendMemoryRepository", "onScreenMemoryOpenStatusChange, isEnable = false, validateDay = " + r1, false, 4, null);
    L28:
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).save("validate_screen_memory_open_status", r0);
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r3);
        if (IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getBoolean("validate_screen_memory_open_status", false) == r22) goto L17;
        if (r22 == false) goto L23;
        long r7 = System.currentTimeMillis();
        if (Instant.ofEpochMilli(IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getLong("last_open_screen_memory_switch_time_stamp", 0)).atZone(ZoneId.systemDefault()).toLocalDate().compareTo((ChronoLocalDate) ZeusTransformUtils.preCheckCast(Instant.ofEpochMilli(r7).atZone(ZoneId.systemDefault()).toLocalDate(), ChronoLocalDate.class, "com.obric.memorydata.plugin")) >= 0) goto L22;
        long r10 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getLong("screen_memory_validate_day", 0) + 1;
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).save("screen_memory_validate_day", r10);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "RecommendMemoryRepository", "onScreenMemoryOpenStatusChange, isEnable = true, update validateDay = " + r10, false, 4, null);
    L22:
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).save("last_open_screen_memory_switch_time_stamp", r7);
        r0 = r22;
        goto L28
    L23:
        r4.Z$0 = r22;
        r4.label = 1;
        r3 = a(true, r4);
        if (r3 != r5) goto L26;
        return r5;
    L26:
        r0 = r22;
        goto L27
    L17:
        return Unit.INSTANCE;
    L7:
        r4 = new RecommendMemoryRepository$onScreenMemoryOpenStatusChange$1(this, r2);
        goto L8
    }

    public final List<p> b() {
        c();
        LocalDate r7 = d();
        List<String> r0 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getEpisodicMemoryDao().getScreenMemoryDateList();
        SimpleDateFormat r1 = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L16;
        Date r5 = r1.parse((String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.memorydata.plugin"));
        if (r5 == null) goto L14;
        Instant r6 = r5.toInstant();
        if (r6 == null) goto L14;
        ZonedDateTime r8 = r6.atZone(ZoneId.systemDefault());
        if (r8 == null) goto L14;
        LocalDate r9 = r8.toLocalDate();
        if (r9 == null) goto L14;
    L15:
        r3.add(r9);
    L14:
        r9 = LocalDate.now();
        goto L15
    L16:
        final Set r10 = CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
        if (r10.isEmpty() == false) goto L25;
        LocalDate r11 = LocalDate.now();
        LocalDate r12 = r11.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        final LocalDate r13 = r11.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
        if (r7 != null) goto L21;
    L23:
        Sequence r14 = SequencesKt.map(SequencesKt.takeWhile(SequencesKt.generateSequence(r12, $$Lambda$bd$cCndQ1xZBPvQvr4ZDhmmD4z5SDw.INSTANCE), new $$Lambda$bd$_8z7I_Qk42TDGNz9VbzqyvcbKo(r13)), $$Lambda$bd$kzj1D4myactvXwtuLlbLB_IF27s.INSTANCE);
        Function1 r15 = $$Lambda$bd$BOLcp0MBvLPjB9KMCzjZWe_3lU.INSTANCE;
    L47:
        return SequencesKt.toList(SequencesKt.chunked(r14, 7, r15));
    L21:
        if (r7.isBefore((ChronoLocalDate) ZeusTransformUtils.preCheckCast(r12, ChronoLocalDate.class, "com.obric.memorydata.plugin")) == false) goto L23;
        r12 = r7.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        goto L23
    L25:
        LocalDate r16 = LocalDate.now();
        LocalDate r17 = (LocalDate) ZeusTransformUtils.preCheckCast(CollectionsKt.minOrNull((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin")), LocalDate.class, "com.obric.memorydata.plugin");
        if (r17 != null) goto L28;
        r17 = r16;
    L28:
        LocalDate r18 = (LocalDate) ZeusTransformUtils.preCheckCast(CollectionsKt.maxOrNull((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin")), LocalDate.class, "com.obric.memorydata.plugin");
        if (r18 != null) goto L32;
        r18 = r16;
    L32:
        if (r17.isAfter((ChronoLocalDate) ZeusTransformUtils.preCheckCast(r16, ChronoLocalDate.class, "com.obric.memorydata.plugin")) == false) goto L34;
        r17 = r16;
    L34:
        if (r7 != null) goto L36;
    L38:
        r7 = r17;
    L40:
        if (r18.isBefore((ChronoLocalDate) ZeusTransformUtils.preCheckCast(r16, ChronoLocalDate.class, "com.obric.memorydata.plugin")) == true) goto L44;
        r16 = r18;
    L44:
        if (r16.isBefore((ChronoLocalDate) ZeusTransformUtils.preCheckCast(r7, ChronoLocalDate.class, "com.obric.memorydata.plugin")) == false) goto L46;
        r16 = r7;
    L46:
        LocalDate r19 = r7.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        final LocalDate r20 = r16.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
        r14 = SequencesKt.map(SequencesKt.takeWhile(SequencesKt.generateSequence(r19, $$Lambda$bd$7gHDEQCCqYXBU1BCCSEKpZY_Gw4.INSTANCE), new $$Lambda$bd$mvnjtlYMIxMgi_1wzafpCWczhLU(r20)), new $$Lambda$bd$eXx6ISHC1HYE4zRv0A70z5QQQNc(r10));
        r15 = $$Lambda$bd$Jowx9iifzq505CXKeyC8k0CsNes.INSTANCE;
        goto L47
    L36:
        if (r17.isAfter((ChronoLocalDate) ZeusTransformUtils.preCheckCast(r7, ChronoLocalDate.class, "com.obric.memorydata.plugin")) == false) goto L38;
        goto L38
    }
}
