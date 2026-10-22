package com.larus.bmhome.taskskill.network;

import android.os.SystemClock;
import com.bytedance.keva.Keva;
import com.google.gson.reflect.TypeToken;
import com.larus.bmhome.taskskill.model.ExposureScopeType;
import com.larus.bmhome.taskskill.model.SkillType;
import com.larus.bmhome.taskskill.model.TaskSkill;
import com.larus.bmhome.taskskill.model.TaskSkillCategory;
import com.larus.dispatcher.api.GetAllDevicesRepo;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.delegate.c0;
import com.larus.im.internal.delegate.y0;
import com.larus.im.internal.jni.bean.DispatchCommand;
import com.larus.im.internal.jni.bean.DispatchCommandBody;
import com.larus.im.internal.jni.bean.DispatchCommandPayload;
import com.larus.im.internal.jni.bean.GetMetaRequestPayload;
import com.larus.im.internal.jni.bean.GetMetaResponsePayload;
import com.larus.im.internal.jni.bean.OmniDispatchCommandRequest;
import com.larus.im.internal.jni.bean.OmniDispatchCommandResponse;
import com.larus.im.internal.jni.bean.SkillCategory;
import com.larus.im.internal.jni.bean.SkillMeta;
import com.larus.im.internal.jni.bean.SuggestionSkill;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class TaskSkillRepository {
    public static final TaskSkillRepository a = null;
    public static final AtomicReference<bs8.m> b = null;
    public static final AtomicReference<List<TaskSkill>> c = null;
    public static final Lazy d = null;
    public static final CoroutineScope e = null;
    public static final Object f = null;
    public static final Object g = null;
    public static final ConcurrentHashMap<String, e> h = null;
    public static final ConcurrentHashMap<String, Deferred<Result<List<TaskSkill>>>> i = null;
    public static Deferred<? extends Result<? extends List<TaskSkill>>> j;
    public static int k;
    public static long l;

    public static final class a<T> implements Comparator {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            Integer r4 = ((com.larus.bmhome.taskskill.model.a) r2).a();
            int r0 = Integer.MAX_VALUE;
            if (r4 == null) goto L5;
            int r5 = r4.intValue();
        L6:
            Integer r6 = Integer.valueOf(r5);
            Integer r7 = ((com.larus.bmhome.taskskill.model.a) r3).a();
            if (r7 == null) goto L10;
            r0 = r7.intValue();
        L10:
            return ComparisonsKt.compareValues(r6, Integer.valueOf(r0));
        L5:
            r5 = Integer.MAX_VALUE;
            goto L6
        }
    }

    public static final class b<T> implements Comparator {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            TaskSkillRepository r0 = TaskSkillRepository.a;
            return ComparisonsKt.compareValues(Integer.valueOf(TaskSkillRepository.b(((TaskSkill) r2).getType())), Integer.valueOf(TaskSkillRepository.b(((TaskSkill) r3).getType())));
        }
    }

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"com/larus/im/internal/core/util/GsonHolder$fromJson$1$1", "Lcom/google/gson/reflect/TypeToken;", "runtime_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class c extends TypeToken<List<? extends TaskSkill>> {
        public c() {
        }
    }

    public static final class d implements IIMCallback<OmniDispatchCommandResponse> {
        public final /* synthetic */ kotlinx.coroutines.i<Result<GetMetaResponsePayload>> a;
        public final /* synthetic */ String b;

        public final boolean mustInMain() {
            return !y0.a();
        }

        public final void onFailure(IIMError r4) {
            Intrinsics.checkNotNullParameter(r4, "error");
            Intrinsics.checkNotNullParameter(r4, "error");
            FLogger.a.e("TaskSkillRepository", "[requestLocalPcMeta] failed, deviceId=" + this.b + ", errorCode=" + r4.getCode() + ", errorMsg=" + r4.getTips());
            if (this.a.isActive() == false) goto L6;
            kotlinx.coroutines.i<Result<GetMetaResponsePayload>> r0 = this.a;
            Result.Companion r1 = Result.Companion;
            r0.resumeWith(Result.constructor-impl(Result.box-impl(Result.constructor-impl(ResultKt.createFailure(new IllegalStateException(r4.getTips()))))));
            return;
        }

        public final void onSuccess(Object r3) {
            OmniDispatchCommandResponse r4 = (OmniDispatchCommandResponse) r3;
            Intrinsics.checkNotNullParameter(r4, "result");
            if (this.a.isActive() == false) goto L12;
            kotlinx.coroutines.i<Result<GetMetaResponsePayload>> r0 = this.a;
            Result.Companion r1 = Result.Companion;
            DispatchCommandPayload r5 = r4.payload;
            if (r5 == null) goto L9;
            DispatchCommandBody r6 = r5.body;
            if (r6 == null) goto L9;
            GetMetaResponsePayload r7 = r6.getMetaResponse;
        L10:
            r0.resumeWith(Result.constructor-impl(Result.box-impl(Result.constructor-impl(r7))));
            return;
        L9:
            r7 = null;
            goto L10
        }

        public d(kotlinx.coroutines.j r1, String r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public TaskSkillRepository() {
    }

    static {
        a = new TaskSkillRepository();
        b = new AtomicReference(new bs8.m(0));
        c = new AtomicReference(null);
        d = LazyKt.lazy(new m());
        e = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        f = new Object();
        g = new Object();
        h = new ConcurrentHashMap();
        i = new ConcurrentHashMap();
        new AtomicBoolean(false);
    }

    public static void d() {
        FLogger.a.d("TaskSkillRepository", "[clearCache]");
        b.set(new bs8.m(0));
        c.set(null);
        h.clear();
        Iterator<T> r0 = i.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Job.DefaultImpls.cancel$default((Deferred) r0.next(), null, 1, null);
        goto L4
    L6:
        i.clear();
        Object r1 = f;
        monitor-enter(r1);
        k++;     // Catch: Throwable -> L14
        l = 0;     // Catch: Throwable -> L14
        Deferred<? extends Result<? extends List<TaskSkill>>> r2 = j;     // Catch: Throwable -> L14
        if (r2 == null) goto L11;
        Job.DefaultImpls.cancel$default(r2, null, 1, null);     // Catch: Throwable -> L14
    L11:
        j = null;     // Catch: Throwable -> L14
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r1);
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public static final int b(int r1) {
        if (r1 != SkillType.LOCAL.getValue()) goto L6;
        return 0;
    L6:
        if (r1 != SkillType.USER.getValue()) goto L9;
        return 1;
    L9:
        if (r1 != SkillType.ENTERPRISE.getValue()) goto L12;
        return 2;
    L12:
        if (r1 != SkillType.SYSTEM.getValue()) goto L15;
        return 3;
    L15:
        if (r1 != SkillType.STORE.getValue()) goto L17;
        return 4;
    L17:
        return 5;
    }

    public static String g(q r9) {
        String[] r0 = new String[3];
        r0[0] = AccountService.a.getUserId();
        String r1 = r9.b;
        String r2 = "";
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        r0[1] = r1;
        String r10 = r9.c;
        if (r10 == null) goto L9;
        r2 = r10;
    L9:
        r0[2] = r2;
        return CollectionsKt.joinToString$default(CollectionsKt.listOf(r0), "#", "local_pc_", null, 0, null, null, 60, null);
    }

    public static List k(String r6) {
        Object r1 = null;
        String r0 = ((Keva) d.getValue()).getString(r6, null);
        if (r0 == null) goto L5;
        zd9.h r2 = zd9.h.a;
        if (StringsKt.isBlank(r0) == false) goto L25;
    L20:
        List r3 = (List) r1;
        if (r3 != null) goto L23;
        r3 = CollectionsKt.emptyList();
    L23:
        FLogger.a.i("TaskSkillRepository", "[readDiskSkills] key=" + r6 + ", size=" + r3.size());
        return r3;
    L25:
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L11
        r2.getClass();     // Catch: Throwable -> L11
        Object r5 = Result.constructor-impl(zd9.h.b.fromJson(r0, new c().getType()));     // Catch: Throwable -> L11
    L13:
        Throwable r7 = Result.exceptionOrNull-impl(r5);
        if (r7 == null) goto L17;
        c0 r8 = c0.b;
        StringBuilder r9 = new StringBuilder("fromJson failed, stack: ");
        Intrinsics.checkNotNullParameter(r7, "<this>");
        r9.append(ExceptionsKt.stackTraceToString(r7));
        r8.e("GsonHolder", r9.toString());
    L17:
        if (Result.isFailure-impl(r5) == true) goto L20;
        r1 = r5;
    L11:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    L5:
        return CollectionsKt.emptyList();
    }

    public static List h(List r9, List r10) {
        if (r10 != null) goto L4;
        r10 = CollectionsKt.emptyList();
    L4:
        List r11 = CollectionsKt.filterNotNull(r10);
        ArrayList r0 = new ArrayList();
        Iterator r1 = r11.iterator();
    L5:
        boolean r3 = true;
        if (r1.hasNext() == false) goto L16;
        Object r2 = r1.next();
        String r5 = ((i) r2).b();
        if (r5 != null) goto L10;
    L12:
        r3 = false;
    L13:
        if (r3 == false) goto L5;
        r0.add(r2);
        goto L5
    L10:
        if ((!StringsKt.isBlank(r5)) != true) goto L12;
    L16:
        if (r0.isEmpty() == false) goto L19;
        return r9;
    L19:
        if ((r11 instanceof Collection) == true) goto L21;
    L23:
        Iterator r12 = r11.iterator();
    L25:
        if (r12.hasNext() == false) goto L29;
        if (Intrinsics.areEqual(((i) r12.next()).d(), Boolean.TRUE) == true) goto L25;
        r3 = false;
    L29:
        Iterable r13 = CollectionsKt.withIndex(r0);
        LinkedHashMap r4 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r13, 10)), 16));
        Iterator r14 = r13.iterator();
    L31:
        if (r14.hasNext() == false) goto L37;
        IndexedValue r6 = (IndexedValue) r14.next();
        int r7 = r6.component1();
        i r8 = (i) r6.component2();
        String r15 = l(r8.getType(), r8.b(), r8.c());
        Long r16 = r8.a();
        if (r16 == null) goto L35;
        long r17 = r16.longValue();
    L36:
        Pair r18 = TuplesKt.to(r15, new j(r17, r3, r7));
        r4.put(r18.getFirst(), r18.getSecond());
        goto L31
    L35:
        r17 = 0;
        goto L36
    L37:
        ArrayList r19 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator r20 = r9.iterator();
    L39:
        if (r20.hasNext() == false) goto L44;
        TaskSkill r21 = (TaskSkill) r20.next();
        j r22 = (j) r4.get(l(r21.getType(), r21.getName(), r21.e()));
        if (r22 == null) goto L43;
        r21 = TaskSkill.a(r21, Long.valueOf(r22.a), r22.b, Integer.valueOf(r22.c), null, 9215);
    L43:
        r19.add(r21);
        goto L39
    L44:
        return r19;
    L21:
        if (r11.isEmpty() == false) goto L23;
        goto L23
    }

    public static Deferred t(int r9, boolean r10) {
        FLogger.a.d("TaskSkillRepository", "[startRefresh] refresh, cacheSize=" + b.get().a.size());
        final Deferred<? extends Result<? extends List<TaskSkill>>> r11 = BuildersKt.async$default(e, null, null, new TaskSkillRepository$startRefresh$1(r9, r10, null), 3, null);
        j = r11;
        r11.invokeOnCompletion(new n(r11));
        return r11;
    }

    public static void v(String r1, List r2) {
        zd9.h.a.getClass();
        String r3 = zd9.h.c(r2);
        if (r3 != null) goto L5;
        return;
    L5:
        ((Keva) d.getValue()).storeString(r1, r3);
    }

    public final Object e(String r8, Continuation<? super Result<bs8.j>> r9) {
        if ((r9 instanceof TaskSkillRepository$getRecentExposedSkills$1) == false) goto L7;
        TaskSkillRepository$getRecentExposedSkills$1 r0 = (TaskSkillRepository$getRecentExposedSkills$1) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        List<com.larus.bmhome.taskskill.model.a> r4 = null;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r8 = (String) r0.L$0;
        ResultKt.throwOnFailure(r10);
    L24:
        dm9.a.b r11 = (dm9.a) r10;
        if ((r11 instanceof dm9.a.b) == false) goto L55;
        dm9.a.b r12 = r11;
        if (r12.a.isSuccess() == false) goto L53;
        bs8.i r13 = (bs8.i) r12.a.getData();
        if (r13 == null) goto L31;
        r4 = r13.b();
    L31:
        if (r4 != null) goto L33;
        r4 = CollectionsKt.emptyList();
    L33:
        List r5 = CollectionsKt.sortedWith(CollectionsKt.filterNotNull(r4), new a());
        ArrayList r6 = new ArrayList();
        Iterator r7 = r5.iterator();
    L35:
        if (r7.hasNext() == false) goto L39;
        TaskSkill r14 = ((com.larus.bmhome.taskskill.model.a) r7.next()).b();
        if (r14 == null) goto L35;
        r6.add(r14);
        goto L35
    L39:
        HashSet r15 = new HashSet();
        ArrayList r16 = new ArrayList();
        Iterator r17 = r6.iterator();
    L41:
        if (r17.hasNext() == false) goto L45;
        Object r18 = r17.next();
        if (r15.add(((TaskSkill) r18).getName()) == false) goto L41;
        r16.add(r18);
        goto L41
    L45:
        if (r13 == null) goto L51;
        bs8.b r19 = r13.a();
        if (r19 == null) goto L51;
        Integer r20 = r19.a();
        if (r20 == null) goto L51;
        int r21 = r20.intValue();
    L52:
        FLogger.a.i("TaskSkillRepository", "[getRecentExposedSkills] success, conversationId=" + r8 + ", size=" + r16.size() + ", maxVisibleSlotCount=" + r21);
        Result.Companion r22 = Result.Companion;
        return Result.constructor-impl(new bs8.j(r16, r21));
    L51:
        r21 = 0;
        goto L52
    L53:
        FLogger.a.w("TaskSkillRepository", "[getRecentExposedSkills] failed code=" + r12.a.getCode() + ", msg=" + r12.a.getMsg());
        Result.Companion r23 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new IllegalStateException(r12.a.getMsg())));
    L55:
        if ((r11 instanceof dm9.a.a) == false) goto L59;
        FLogger r24 = FLogger.a;
        StringBuilder r25 = new StringBuilder("[getRecentExposedSkills] failed code=");
        dm9.a.a r26 = (dm9.a.a) r11;
        r25.append(r26.a);
        r25.append(", msg=");
        r25.append(r26.b);
        r24.w("TaskSkillRepository", r25.toString());
        Result.Companion r27 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new IllegalStateException(r26.b)));
    L59:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        if ((!StringsKt.isBlank(r8)) == false) goto L17;
        String r28 = r8;
    L18:
        if (r28 == null) goto L20;
        bs8.c r29 = new bs8.c(ExposureScopeType.CONVERSATION.getValue(), r28);
    L21:
        bs8.d r30 = new bs8.d(r29);
        TaskSkillApi.a r31 = TaskSkillApi.a;
        TaskSkillRepository$getRecentExposedSkills$result$1 r32 = new TaskSkillRepository$getRecentExposedSkills$result$1(r30, null);
        r0.L$0 = r8;
        r0.label = 1;
        r31.getClass();
        r10 = TaskSkillApi.a.a(r32, r0);
        if (r10 != r2) goto L24;
        return r2;
    L20:
        r29 = null;
        goto L21
    L17:
        r28 = null;
    L7:
        r0 = new TaskSkillRepository$getRecentExposedSkills$1(this, r9);
        goto L8
    }

    public final Object n(boolean r13, Continuation<? super Result<? extends List<TaskSkill>>> r14) {
        if ((r14 instanceof TaskSkillRepository$refreshWithInflight$1) == false) goto L7;
        TaskSkillRepository$refreshWithInflight$1 r1 = (TaskSkillRepository$refreshWithInflight$1) r14;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r15 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        ResultKt.throwOnFailure(r15);
    L43:
        return ((Result) r15).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        long r5 = SystemClock.elapsedRealtime();
        Object r16 = f;
        monitor-enter(r16);
        int r6 = k;     // Catch: Throwable -> L44
        Deferred<? extends Result<? extends List<TaskSkill>>> r7 = j;     // Catch: Throwable -> L44
        if (r7 != null) goto L19;
    L24:
        if (r13 == false) goto L32;
        long r8 = l;     // Catch: Throwable -> L44
        if (r8 <= 0) goto L32;
        if ((r5 - r8) >= 3000) goto L32;
        FLogger.a.d("TaskSkillRepository", "[refreshWithInflight] drop throttled prefetch, interval=" + (r5 - l));     // Catch: Throwable -> L44
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L44
        Object r18 = Result.constructor-impl(ResultKt.createFailure(new TaskSkillPrefetchThrottledException()));     // Catch: Throwable -> L44
        monitor-exit(r16);
        return r18;
    L32:
        if (r13 == false) goto L34;
        l = r5;     // Catch: Throwable -> L44
    L34:
        if (r13 == false) goto L36;
        boolean r19 = true;
    L37:
        r7 = t(r6, r19);     // Catch: Throwable -> L44
    L38:
        monitor-exit(r16);
        r1.label = 1;
        r15 = r7.await(r1);
        if (r15 != r3) goto L43;
        return r3;
    L36:
        r19 = false;
        goto L37
    L19:
        if (r7.isActive() == true) goto L22;
        r7 = null;
    L22:
        if (r7 == null) goto L24;
        FLogger.a.d("TaskSkillRepository", "[refreshWithInflight] join running request");     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        throw th;
    L7:
        r1 = new TaskSkillRepository$refreshWithInflight$1(this, r14);
        goto L8
    }

    public final Object r(q r25, Continuation<? super Result<? extends List<TaskSkill>>> r26) {
        if ((r26 instanceof TaskSkillRepository$requestLocalPcSkills$1) == false) goto L7;
        TaskSkillRepository$requestLocalPcSkills$1 r3 = (TaskSkillRepository$requestLocalPcSkills$1) r26;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        boolean r7 = true;
        if (r6 == 0) goto L14;
        if (r6 != 1) goto L13;
        String r1 = (String) r3.L$1;
        String r8 = (String) r3.L$0;
        ResultKt.throwOnFailure(r2);
        Object r9 = ((Result) r2).unbox-impl();
    L30:
        if (Result.isSuccess-impl(r9) == false) goto L105;
        GetMetaResponsePayload r10 = (GetMetaResponsePayload) r9;
        if (r10 == null) goto L34;
        List r11 = r10.skills;
    L35:
        if (r11 != null) goto L37;
        r11 = CollectionsKt.emptyList();
    L37:
        ArrayList r12 = new ArrayList();
        Iterator r13 = r11.iterator();
    L39:
        if (r13.hasNext() == false) goto L75;
        SkillMeta r14 = (SkillMeta) r13.next();
        String r15 = r14.name;
        if (r15 != null) goto L43;
    L71:
        TaskSkill r0 = null;
    L72:
        if (r0 == null) goto L74;
        r12.add(r0);
    L74:
        r7 = true;
        goto L39
    L43:
        if ((StringsKt.isBlank(r15) ^ r7) == false) goto L45;
        String r17 = r15;
    L46:
        if (r17 == null) goto L71;
        String r16 = r14.skillId;
        if (r16 == null) goto L71;
        if ((StringsKt.isBlank(r16) ^ r7) == false) goto L53;
        String r18 = r16;
    L54:
        if (r18 == null) goto L71;
        String r19 = r14.externalSkillId;
        if (r19 != null) goto L59;
    L61:
        String r110 = null;
    L62:
        String r111 = r14.desc;
        int r112 = r14.type.value;
        String r113 = r14.path;
        List r20 = r14.categories;
        if (r20 == null) goto L69;
        List r21 = r20;
        ArrayList r22 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r21, 10));
        Iterator r23 = r21.iterator();
    L66:
        if (r23.hasNext() == false) goto L68;
        SkillCategory r114 = (SkillCategory) r23.next();
        r22.add(new TaskSkillCategory(r114.categoryId, r114.categoryName));
        goto L66
    L68:
        ArrayList r24 = r22;
    L70:
        r0 = new TaskSkill(r18, r110, r111, r17, false, r112, true, r113, r24, 15376);
        goto L72
    L69:
        r24 = null;
        goto L70
    L59:
        if ((StringsKt.isBlank(r19) ^ r7) == false) goto L61;
        r110 = r19;
        goto L62
    L53:
        r18 = null;
        goto L54
    L45:
        r17 = null;
        goto L46
    L75:
        HashSet r27 = new HashSet();
        ArrayList r28 = new ArrayList();
        Iterator r29 = r12.iterator();
    L77:
        if (r29.hasNext() == false) goto L81;
        Object r30 = r29.next();
        if (r27.add(((TaskSkill) r30).getName()) == false) goto L77;
        r28.add(r30);
        goto L77
    L81:
        if (r10 == null) goto L88;
        List r31 = r10.suggestionSkills;
        if (r31 == null) goto L88;
        List r32 = r31;
        ArrayList r33 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r32, 10));
        Iterator r34 = r32.iterator();
    L86:
        if (r34.hasNext() == false) goto L89;
        SuggestionSkill r35 = (SuggestionSkill) r34.next();
        r33.add(new i(r35.name, r35.type.value, Long.valueOf(r35.lastUsedAtMs), r35.path, Boolean.valueOf(r35.isRecommend)));
    L89:
        List r36 = h(r28, r33);
        FLogger r37 = FLogger.a;
        StringBuilder r38 = new StringBuilder("[requestLocalPcSkills] success, deviceId=");
        r38.append(r8);
        r38.append(", skillSize=");
        r38.append(((ArrayList) r36).size());
        r38.append(", suggestionSize=");
        int r39 = 0;
        if (r36.isEmpty() == true) goto L104;
        Iterator r40 = r36.iterator();
        int r41 = 0;
    L94:
        if (r40.hasNext() == false) goto L103;
        if (((TaskSkill) r40.next()).a == null) goto L98;
        boolean r42 = true;
    L99:
        if (r42 == false) goto L94;
        r41 = r41 + 1;
        if (r41 >= 0) goto L94;
        CollectionsKt.throwCountOverflow();
        goto L94
    L98:
        r42 = false;
        goto L99
    L103:
        r39 = r41;
    L104:
        r38.append(r39);
        r37.i("TaskSkillRepository", r38.toString());
        v(r1, r36);
        Object r43 = Result.constructor-impl(r36);
    L106:
        Throwable r44 = Result.exceptionOrNull-impl(r43);
        if (r44 == null) goto L109;
        FLogger.a.e("TaskSkillRepository", "[requestLocalPcSkills] failed, deviceId=" + r8, r44);
    L109:
        return r43;
    L88:
        r33 = null;
        goto L89
    L34:
        r11 = null;
        goto L35
    L105:
        r43 = Result.constructor-impl(r9);
        goto L106
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r2);
        String r45 = r25.b;
        String r46 = "";
        if (r45 != null) goto L18;
        r45 = "";
    L18:
        if (StringsKt.isBlank(r45) == false) goto L21;
        Result.Companion r47 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new IllegalArgumentException("pcDeviceId is blank")));
    L21:
        String r48 = g(r25);
        String r49 = r25.c;
        if (r49 == null) goto L25;
        r46 = r49;
    L25:
        r3.L$0 = r45;
        r3.L$1 = r48;
        r3.label = 1;
        Object r50 = q(r45, true, r46, r3);
        if (r50 != r5) goto L28;
        return r5;
    L28:
        r8 = r45;
        r9 = r50;
        r1 = r48;
    L7:
        r3 = new TaskSkillRepository$requestLocalPcSkills$1(this, r26);
        goto L8
    }

    public final Object s(String r5, Continuation<? super Result<g>> r6) {
        if ((r6 instanceof TaskSkillRepository$requestRemotePcAuthorizationMeta$1) == false) goto L7;
        TaskSkillRepository$requestRemotePcAuthorizationMeta$1 r0 = (TaskSkillRepository$requestRemotePcAuthorizationMeta$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r5 = (String) r0.L$0;
        ResultKt.throwOnFailure(r7);
        Object r8 = ((Result) r7).unbox-impl();
    L22:
        if (Result.isSuccess-impl(r8) == true) goto L38;
    L33:
        Object r9 = Result.constructor-impl(r8);
    L34:
        Throwable r4 = Result.exceptionOrNull-impl(r9);
        if (r4 == null) goto L37;
        FLogger.a.e("TaskSkillRepository", "[requestRemotePcAuthorizationMeta] failed, deviceId=" + r5, r4);
    L37:
        return r9;
    L38:
        GetMetaResponsePayload r10 = (GetMetaResponsePayload) r8;     // Catch: Throwable -> L31
        if (r10 == null) goto L30;
        List r11 = r10.authorizationModeList;     // Catch: Throwable -> L31
        if (r11 != null) goto L28;
        r11 = CollectionsKt.emptyList();     // Catch: Throwable -> L31
    L28:
        r9 = Result.constructor-impl(new g(r11, r10.authorizationSelectedMode));     // Catch: Throwable -> L31
        goto L34
    L30:
        throw new IllegalStateException("GET_META response is empty");     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r8 = ResultKt.createFailure(th);
        goto L33
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        if (StringsKt.isBlank(r5) == false) goto L18;
        Result.Companion r13 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new IllegalArgumentException("pcDeviceId is blank")));
    L18:
        r0.L$0 = r5;
        r0.label = 1;
        r8 = q(r5, false, null, r0);
        if (r8 != r2) goto L22;
        return r2;
    L7:
        r0 = new TaskSkillRepository$requestRemotePcAuthorizationMeta$1(this, r6);
        goto L8
    }

    public static final Object a(TaskSkillRepository r11, int r12, Continuation r13) {
        r11.getClass();
        if ((r13 instanceof TaskSkillRepository$refreshRecommendSkills$1) == false) goto L7;
        TaskSkillRepository$refreshRecommendSkills$1 r0 = (TaskSkillRepository$refreshRecommendSkills$1) r13;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        Integer r3 = null;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        r12 = r0.I$0;
        ResultKt.throwOnFailure(r14);
    L17:
        dm9.a.b r16 = (dm9.a) r14;
        if ((r16 instanceof dm9.a.b) == false) goto L107;
        dm9.a.b r17 = r16;
        if (r17.a.getCode() != 0) goto L105;
        k r18 = (k) r17.a.getData();
        if (r18 == null) goto L24;
        List<TaskSkill> r19 = r18.b();
    L25:
        if (r19 != null) goto L27;
        r19 = CollectionsKt.emptyList();
    L27:
        List r110 = CollectionsKt.filterNotNull(r19);
        ArrayList r4 = new ArrayList();
        Iterator r111 = r110.iterator();
    L28:
        boolean r5 = false;
        if (r111.hasNext() == false) goto L37;
        Object r6 = r111.next();
        String r7 = ((TaskSkill) r6).getName();
        if (r7 != null) goto L33;
    L35:
        if (r5 == false) goto L28;
        r4.add(r6);
        goto L28
    L33:
        if ((!StringsKt.isBlank(r7)) != true) goto L35;
        r5 = true;
        goto L35
    L37:
        HashSet r112 = new HashSet();
        ArrayList r8 = new ArrayList();
        Iterator r9 = r4.iterator();
    L39:
        if (r9.hasNext() == false) goto L43;
        Object r10 = r9.next();
        if (r112.add(((TaskSkill) r10).getName()) == false) goto L39;
        r8.add(r10);
        goto L39
    L43:
        if (r18 == null) goto L45;
        List<i> r113 = r18.c();
    L46:
        List r114 = h(r8, r113);
        ArrayList r20 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r114, 10));
        Iterator r115 = r114.iterator();
    L48:
        if (r115.hasNext() == false) goto L54;
        TaskSkill r21 = (TaskSkill) r115.next();
        if (r18 == null) goto L52;
        Integer r22 = r18.d();
    L53:
        r20.add(TaskSkill.a(r21, null, false, null, r22, 8191));
        goto L48
    L52:
        r22 = null;
        goto L53
    L54:
        ArrayList r116 = new ArrayList();
        Iterator r23 = r20.iterator();
    L56:
        if (r23.hasNext() == false) goto L60;
        Object r24 = r23.next();
        if (((TaskSkill) r24).g() == false) goto L56;
        r116.add(r24);
        goto L56
    L60:
        List r117 = CollectionsKt.sortedWith(r116, new p());
        Ref.BooleanRef r25 = new Ref.BooleanRef();
        Object r26 = f;
        monitor-enter(r26);
    L102:
        th = move-exception;
        throw th;
    L63:
        if (r12 != k) goto L69;
        c.set(r20);     // Catch: Throwable -> L102
        AtomicReference<bs8.m> r118 = b;     // Catch: Throwable -> L102
        if (r18 == null) goto L67;
        boolean r27 = Intrinsics.areEqual(r18.a(), Boxing.boxBoolean(true));     // Catch: Throwable -> L102
    L68:
        r118.set(new bs8.m(r117, r27, System.currentTimeMillis()));     // Catch: Throwable -> L102
    L70:
        Unit r119 = Unit.INSTANCE;     // Catch: Throwable -> L102
        monitor-exit(r26);
        if (r25.element == false) goto L75;
        Result.Companion r120 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new IllegalStateException("stale task skill response")));
    L75:
        v("cloud_".concat(AccountService.a.getUserId()), r20);
        FLogger r121 = FLogger.a;
        StringBuilder r28 = new StringBuilder("[refreshRecommendSkills] success, rawSize=");
        if (r18 == null) goto L78;
        List<TaskSkill> r29 = r18.b();
    L79:
        if (r29 != null) goto L81;
        r29 = CollectionsKt.emptyList();
    L81:
        r28.append(r29.size());
        r28.append(", recommendSize=");
        r28.append(r117.size());
        r28.append(", suggestionSize=");
        if (r20.isEmpty() == false) goto L84;
        int r30 = 0;
    L95:
        r28.append(r30);
        r28.append(", suggestionLimit=");
        if (r18 == null) goto L98;
        r3 = r18.d();
    L98:
        r28.append(r3);
        r28.append(", hasMore=");
        if (r18 == null) goto L101;
        r5 = Intrinsics.areEqual(r18.a(), Boxing.boxBoolean(true));
    L101:
        r28.append(r5);
        r121.i("TaskSkillRepository", r28.toString());
        Object r122 = Result.constructor-impl(r117);
    L110:
        return r122;
    L84:
        Iterator r31 = r20.iterator();
        r30 = 0;
    L86:
        if (r31.hasNext() == false) goto L95;
        if (((TaskSkill) r31.next()).a == null) goto L90;
        boolean r32 = true;
    L91:
        if (r32 == false) goto L86;
        r30 = r30 + 1;
        if (r30 >= 0) goto L86;
        CollectionsKt.throwCountOverflow();
        goto L86
    L90:
        r32 = false;
        goto L91
    L78:
        r29 = null;
        goto L79
    L67:
        r27 = false;
        goto L68
    L69:
        r25.element = true;     // Catch: Throwable -> L102
        FLogger.a.i("TaskSkillRepository", "[refreshRecommendSkills] drop stale result, generation=" + r12 + ", current=" + k);     // Catch: Throwable -> L102
        goto L70
    L45:
        r113 = null;
        goto L46
    L24:
        r19 = null;
        goto L25
    L105:
        FLogger.a.w("TaskSkillRepository", "request failed code=" + r17.a.getCode() + ", msg=" + r17.a.getMsg());
        Result.Companion r123 = Result.Companion;
        r122 = Result.constructor-impl(ResultKt.createFailure(new IllegalStateException(r17.a.getMsg())));
        goto L110
    L107:
        if ((r16 instanceof dm9.a.a) == false) goto L112;
        FLogger r124 = FLogger.a;
        StringBuilder r33 = new StringBuilder("request failed code=");
        dm9.a.a r125 = (dm9.a.a) r16;
        r33.append(r125.a);
        r33.append(", msg=");
        r33.append(r125.b);
        r124.w("TaskSkillRepository", r33.toString());
        Result.Companion r126 = Result.Companion;
        r122 = Result.constructor-impl(ResultKt.createFailure(new IllegalStateException(r125.b)));
        goto L110
    L112:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        TaskSkillApi.a r127 = TaskSkillApi.a;
        TaskSkillRepository$refreshRecommendSkills$result$1 r34 = new TaskSkillRepository$refreshRecommendSkills$result$1(null);
        r0.I$0 = r12;
        r0.label = 1;
        r127.getClass();
        r14 = TaskSkillApi.a.a(r34, r0);
        if (r14 != r15) goto L17;
        return r15;
    L7:
        r0 = new TaskSkillRepository$refreshRecommendSkills$1(r11, r13);
        goto L8
    }

    public static String l(int r3, String r4, String r5) {
        StringBuilder r0 = new StringBuilder();
        r0.append(r3);
        r0.append('#');
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        r0.append(r4);
        String r6 = r0.toString();
        if (r3 != SkillType.LOCAL.getValue()) goto L12;
        StringBuilder r7 = new StringBuilder();
        r7.append(r6);
        r7.append('#');
        if (r5 != null) goto L10;
        r5 = "";
    L10:
        r7.append(r5);
        return r7.toString();
    L12:
        return r6;
    }

    public final Object f(boolean r7, q r8, Continuation<? super Result<? extends List<TaskSkill>>> r9) {
        if ((r9 instanceof TaskSkillRepository$getRecommendSkills$1) == false) goto L7;
        TaskSkillRepository$getRecommendSkills$1 r0 = (TaskSkillRepository$getRecommendSkills$1) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r10);
        return ((Result) r10).unbox-impl();
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r10);
        Object r11 = ((Result) r10).unbox-impl();
    L22:
        if (Result.isSuccess-impl(r11) == false) goto L25;
        r11 = CollectionsKt.sortedWith((List) r11, new b());
    L25:
        return Result.constructor-impl(r11);
    L16:
        ResultKt.throwOnFailure(r10);
        if (r8.b() == false) goto L26;
        r0.label = 1;
        r11 = r(r8, r0);
        if (r11 != r2) goto L22;
        return r2;
    L26:
        bs8.m r12 = b.get();
        if (r7 == false) goto L29;
    L32:
        FLogger.a.d("TaskSkillRepository", "[getRecommendSkills] refresh, forceRefresh=" + r7 + ", cacheSize=" + r12.a.size());
        r0.label = 2;
        Object r13 = n(false, r0);
        if (r13 != r2) goto L36;
        return r2;
    L36:
        return r13;
    L29:
        if ((!r12.a.isEmpty()) == false) goto L32;
        FLogger.a.d("TaskSkillRepository", "[getRecommendSkills] hit cache, size=" + r12.a.size() + ", hasMore=" + r12.b);
        Result.Companion r14 = Result.Companion;
        return Result.constructor-impl(r12.a);
    L7:
        r0 = new TaskSkillRepository$getRecommendSkills$1(this, r9);
        goto L8
    }

    public final Object i(q r6, boolean r7, Continuation<? super Result<? extends List<TaskSkill>>> r8) {
        if ((r8 instanceof TaskSkillRepository$prefetch$1) == false) goto L7;
        TaskSkillRepository$prefetch$1 r0 = (TaskSkillRepository$prefetch$1) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r9);
        Object r10 = ((Result) r9).unbox-impl();
    L26:
        if (Result.isSuccess-impl(r10) == false) goto L31;
        List r11 = (List) r10;
        r10 = (List) c.get();
        if (r10 != null) goto L31;
        r10 = CollectionsKt.emptyList();
    L31:
        return Result.constructor-impl(r10);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r9);
        return ((Result) r9).unbox-impl();
    L16:
        ResultKt.throwOnFailure(r9);
        if (r6.b() == false) goto L22;
        r0.label = 1;
        Object r12 = j(r6, r7, r0);
        if (r12 != r2) goto L32;
        return r2;
    L32:
        return r12;
    L22:
        r0.label = 2;
        r10 = n(r7, r0);
        if (r10 != r2) goto L26;
        return r2;
    L7:
        r0 = new TaskSkillRepository$prefetch$1(this, r8);
        goto L8
    }

    public final Object j(q r23, boolean r24, Continuation<? super Result<? extends List<TaskSkill>>> r25) {
        if ((r25 instanceof TaskSkillRepository$prefetchLocalPcSkills$1) == false) goto L7;
        TaskSkillRepository$prefetchLocalPcSkills$1 r5 = (TaskSkillRepository$prefetchLocalPcSkills$1) r25;
        int r6 = r5.label;
        if ((r6 & Integer.MIN_VALUE) == 0) goto L7;
        r5.label = r6 - Integer.MIN_VALUE;
    L8:
        Object r2 = r5.result;
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r8 = r5.label;
        if (r8 == 0) goto L16;
        if (r8 == 1) goto L15;
        if (r8 != 2) goto L14;
        ResultKt.throwOnFailure(r2);
    L63:
        return ((Result) r2).unbox-impl();
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r2);
        Object r0 = ((Result) r2).unbox-impl();
    L21:
        Throwable r3 = Result.exceptionOrNull-impl(r0);
        if (r3 == null) goto L24;
        FLogger.a.w("TaskSkillRepository", "local pc prefetch failed, msg=" + r3.getMessage());
    L24:
        return r0;
    L16:
        ResultKt.throwOnFailure(r2);
        final String r4 = r23.a();
        if (StringsKt.isBlank(r4) == false) goto L25;
        r5.label = 1;
        r0 = r(r23, r5);
        if (r0 != r7) goto L21;
        return r7;
    L25:
        long r10 = SystemClock.elapsedRealtime();
        Ref.ObjectRef r9 = new Ref.ObjectRef();
        Ref.BooleanRef r12 = new Ref.BooleanRef();
        Object r13 = g;
        monitor-enter(r13);
        e r14 = h.get(r4);     // Catch: Throwable -> L64
        final Deferred<Result<List<TaskSkill>>> r15 = null;
        if (r14 == null) goto L39;
        if (r24 == true) goto L31;
    L33:
        boolean r11 = false;
    L34:
        if (r11 == true) goto L37;
        r14 = null;
    L37:
        if (r14 == null) goto L39;
        FLogger r1 = FLogger.a;     // Catch: Throwable -> L64
        StringBuilder r16 = new StringBuilder("[prefetchLocalPcSkills] hit cache, key=");     // Catch: Throwable -> L64
        r16.append(r4);     // Catch: Throwable -> L64
        r16.append(", interval=");     // Catch: Throwable -> L64
        TaskSkillRepository$prefetchLocalPcSkills$1 r17 = r5;
        r16.append(r10 - r14.b);     // Catch: Throwable -> L64
        r1.d("TaskSkillRepository", r16.toString());     // Catch: Throwable -> L64
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L64
        r9.element = Result.box-impl(Result.constructor-impl(r14.a));     // Catch: Throwable -> L64
    L48:
        monitor-exit(r13);
        Result r19 = (Result) r9.element;
        if (r19 != null) goto L52;
        if (r15 != null) goto L57;
        Result.Companion r20 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new IllegalStateException("local pc prefetch deferred is null")));
    L57:
        if (r12.element == false) goto L59;
        r15.invokeOnCompletion(new l(r4, r15));
    L59:
        r17.label = 2;
        r2 = r15.await(r17);
        if (r2 != r7) goto L63;
        return r7;
    L52:
        return r19.unbox-impl();
    L31:
        if ((r10 - r14.b) >= 5000) goto L33;
        r11 = true;
    L39:
        r17 = r5;
        ConcurrentHashMap<String, Deferred<Result<List<TaskSkill>>>> r21 = i;     // Catch: Throwable -> L64
        Deferred<Result<List<TaskSkill>>> r22 = r21.get(r4);     // Catch: Throwable -> L64
        if (r22 != null) goto L42;
    L47:
        r15 = BuildersKt.async$default(e, null, null, new TaskSkillRepository$prefetchLocalPcSkills$deferred$1$5(r23, r4, null), 3, null);     // Catch: Throwable -> L64
        r12.element = true;     // Catch: Throwable -> L64
        r21.put(r4, r15);     // Catch: Throwable -> L64
        goto L48
    L42:
        if (r22.isActive() == true) goto L45;
        r22 = null;
    L45:
        if (r22 == null) goto L47;
        FLogger.a.d("TaskSkillRepository", "[prefetchLocalPcSkills] join running request, key=" + r4);     // Catch: Throwable -> L64
        r15 = r22;
    L64:
        th = move-exception;
        throw th;
    L7:
        r5 = new TaskSkillRepository$prefetchLocalPcSkills$1(this, r25);
        goto L8
    }

    public final Object m(q r6, boolean r7, Continuation<? super Result<? extends List<TaskSkill>>> r8) {
        if ((r8 instanceof TaskSkillRepository$refreshAvailableSkills$1) == false) goto L7;
        TaskSkillRepository$refreshAvailableSkills$1 r0 = (TaskSkillRepository$refreshAvailableSkills$1) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        r7 = r0.Z$0;
        ResultKt.throwOnFailure(r9);
        Object r10 = ((Result) r9).unbox-impl();
    L25:
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 != null) goto L31;
        List r12 = (List) r10;
        List<TaskSkill> r13 = c.get();
        if (r13 != null) goto L40;
        r13 = CollectionsKt.emptyList();
    L40:
        return Result.constructor-impl(r13);
    L31:
        List<TaskSkill> r14 = c.get();
        if (r7 == false) goto L38;
        if ((r11 instanceof TaskSkillPrefetchThrottledException) == false) goto L38;
        if (r14 == null) goto L38;
        return Result.constructor-impl(r14);
    L38:
        return Result.constructor-impl(ResultKt.createFailure(r11));
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r9);
        return ((Result) r9).unbox-impl();
    L16:
        ResultKt.throwOnFailure(r9);
        if (r6.b() == false) goto L22;
        r0.label = 1;
        Object r15 = j(r6, r7, r0);
        if (r15 != r2) goto L39;
        return r2;
    L39:
        return r15;
    L22:
        r0.Z$0 = r7;
        r0.label = 2;
        r10 = n(true, r0);
        if (r10 != r2) goto L25;
        return r2;
    L7:
        r0 = new TaskSkillRepository$refreshAvailableSkills$1(this, r8);
        goto L8
    }

    public final Object p(String r20, List<TaskSkill> r21, Continuation<? super Result<Unit>> r22) {
        if ((r22 instanceof TaskSkillRepository$reportExposedSkills$1) == false) goto L7;
        TaskSkillRepository$reportExposedSkills$1 r1 = (TaskSkillRepository$reportExposedSkills$1) r22;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        Boolean r5 = null;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        List r6 = (List) r1.L$1;
        String r7 = (String) r1.L$0;
        ResultKt.throwOnFailure(r0);
    L60:
        dm9.a.b r8 = (dm9.a) r0;
        if ((r8 instanceof dm9.a.b) == false) goto L70;
        dm9.a.b r9 = r8;
        if (r9.a.isSuccess() == false) goto L68;
        FLogger r10 = FLogger.a;
        StringBuilder r11 = new StringBuilder("[reportExposedSkills] success, conversationId=");
        r11.append(r7);
        r11.append(", size=");
        r11.append(r6.size());
        r11.append(", recorded=");
        bs8.k r12 = (bs8.k) r9.a.getData();
        if (r12 == null) goto L67;
        r5 = r12.a();
    L67:
        r11.append(r5);
        r10.i("TaskSkillRepository", r11.toString());
        Result.Companion r13 = Result.Companion;
        return Result.constructor-impl(Unit.INSTANCE);
    L68:
        FLogger.a.w("TaskSkillRepository", "[reportExposedSkills] failed code=" + r9.a.getCode() + ", msg=" + r9.a.getMsg());
        Result.Companion r14 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new IllegalStateException(r9.a.getMsg())));
    L70:
        if ((r8 instanceof dm9.a.a) == false) goto L74;
        FLogger r15 = FLogger.a;
        StringBuilder r16 = new StringBuilder("[reportExposedSkills] failed code=");
        dm9.a.a r17 = (dm9.a.a) r8;
        r16.append(r17.a);
        r16.append(", msg=");
        r16.append(r17.b);
        r15.w("TaskSkillRepository", r16.toString());
        Result.Companion r18 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new IllegalStateException(r17.b)));
    L74:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        if (StringsKt.isBlank(r20) == false) goto L18;
        Result.Companion r19 = Result.Companion;
        return Result.constructor-impl(Unit.INSTANCE);
    L18:
        HashSet r23 = new HashSet();
        ArrayList r24 = new ArrayList();
        Iterator<T> r25 = r21.iterator();
    L20:
        if (r25.hasNext() == false) goto L24;
        Object r26 = r25.next();
        if (r23.add(((TaskSkill) r26).getName()) == false) goto L20;
        r24.add(r26);
        goto L20
    L24:
        ArrayList r27 = new ArrayList();
        Iterator r28 = r24.iterator();
        int r29 = 0;
    L26:
        if (r28.hasNext() == false) goto L47;
        Object r30 = r28.next();
        int r31 = r29 + 1;
        if (r29 >= 0) goto L30;
        CollectionsKt.throwIndexOverflow();
    L30:
        TaskSkill r32 = (TaskSkill) r30;
        int r110 = com.larus.bmhome.taskskill.model.a.a;
        Intrinsics.checkNotNullParameter(r32, "skill");
        String r111 = r32.getName();
        if (r111 != null) goto L33;
    L42:
        com.larus.bmhome.taskskill.model.a r112 = null;
    L43:
        if (r112 == null) goto L45;
        r27.add(r112);
    L45:
        r29 = r31;
        goto L26
    L33:
        if ((!StringsKt.isBlank(r111)) == false) goto L35;
        String r113 = r111;
    L36:
        if (r113 == null) goto L42;
        Integer r114 = Integer.valueOf(r29);
        String r115 = r32.c();
        SkillType.a r33 = SkillType.Companion;
        int r116 = r32.getType();
        r33.getClass();
        Integer r117 = Integer.valueOf(SkillType.a.a(r116).getValue());
        String r34 = r32.d();
        if (r34 != null) goto L41;
        r34 = "";
    L41:
        r112 = new com.larus.bmhome.taskskill.model.a(r114, r113, r115, r117, r34, 32);
        goto L43
    L35:
        r113 = null;
        goto L36
    L47:
        if ((!StringsKt.isBlank(r20)) == false) goto L49;
        String r35 = r20;
    L50:
        if (r35 == null) goto L52;
        bs8.c r36 = new bs8.c(ExposureScopeType.CONVERSATION.getValue(), r35);
    L53:
        if (r36 != null) goto L56;
        Result.Companion r37 = Result.Companion;
        return Result.constructor-impl(Unit.INSTANCE);
    L56:
        bs8.l r38 = new bs8.l(r36, r27);
        TaskSkillApi.a r39 = TaskSkillApi.a;
        TaskSkillRepository$reportExposedSkills$result$1 r40 = new TaskSkillRepository$reportExposedSkills$result$1(r38, null);
        r1.L$0 = r20;
        r1.L$1 = r27;
        r1.label = 1;
        r39.getClass();
        Object r41 = TaskSkillApi.a.a(r40, r1);
        if (r41 != r3) goto L59;
        return r3;
    L59:
        r6 = r27;
        r0 = r41;
        r7 = r20;
        goto L60
    L52:
        r36 = null;
        goto L53
    L49:
        r35 = null;
    L7:
        r1 = new TaskSkillRepository$reportExposedSkills$1(this, r22);
        goto L8
    }

    /* JADX WARN: Type inference failed for: r5v1, types: [com.larus.bmhome.taskskill.network.o] */
    public static void u(int r4, String r5, String r6, final Long r7) {
        final String r8 = l(r4, r5, r6);
        ?? r9 = new o(r8, r7);
        Iterator<T> r10 = h.entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        Map.Entry r11 = (Map.Entry) r10.next();
        e r12 = (e) r11.getValue();
        List r0 = (List) r9.invoke(((e) r11.getValue()).a);
        long r1 = r12.b;
        String r13 = r12.c;
        Intrinsics.checkNotNullParameter(r0, "skills");
        Intrinsics.checkNotNullParameter(r13, "diskKey");
        e r3 = new e(r0, r1, r13);
        r11.setValue(r3);
        v(r3.c, r3.a);
    L6:
        AtomicReference<List<TaskSkill>> r14 = c;
        List<TaskSkill> r15 = r14.get();
        if (r15 == null) goto L8;
        List<TaskSkill> r16 = (List) r9.invoke(r15);
    L11:
        if (r14.compareAndSet(r15, r16) == true) goto L12;
        if (r14.get() == r15) goto L11;
        boolean r17 = false;
    L16:
        if (r17 == false) goto L6;
        v("cloud_".concat(AccountService.a.getUserId()), r16);
        return;
    L12:
        r17 = true;
        goto L16
    }

    public final Object q(String r36, boolean r37, String r38, Continuation<? super Result<GetMetaResponsePayload>> r39) {
        if ((r39 instanceof TaskSkillRepository$requestLocalPcMeta$1) == false) goto L7;
        TaskSkillRepository$requestLocalPcMeta$1 r4 = (TaskSkillRepository$requestLocalPcMeta$1) r39;
        int r5 = r4.label;
        if ((r5 & Integer.MIN_VALUE) == 0) goto L7;
        r4.label = r5 - Integer.MIN_VALUE;
    L8:
        Object r3 = r4.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r4.label;
        if (r7 == 0) goto L14;
        if (r7 != 1) goto L13;
        String r0 = (String) r4.L$1;
        String r1 = (String) r4.L$0;
        ResultKt.throwOnFailure(r3);
    L24:
        return ((Result) r3).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r3);
        GetAllDevicesRepo r8 = GetAllDevicesRepo.a;
        Integer r9 = GetAllDevicesRepo.c(r36);
        if (r9 == null) goto L17;
        int r10 = r9.intValue();
    L18:
        r4.L$0 = r36;
        r4.L$1 = r38;
        r4.Z$0 = r37;
        r4.I$0 = r10;
        r4.label = 1;
        kotlinx.coroutines.j r11 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r4), 1);
        r11.C();
        String r12 = UUID.randomUUID().toString();
        com.larus.im.d.b().sendDispatchCommand(new OmniDispatchCommandRequest(r36, r10, new DispatchCommandPayload(DispatchCommand.GET_META_REQUEST, r12, new DispatchCommandBody(new GetMetaRequestPayload(false, r37, r38), null, null, null, null, null, null, null, null, null, null, null, null, null, 16382, null), null, com.larus.platform.service.o.a.getDeviceId(), null, 0, null, null, 488, null)), new d(r11, r36));
        r3 = r11.B();
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L21;
        DebugProbesKt.probeCoroutineSuspended(r4);
    L21:
        if (r3 != r6) goto L24;
        return r6;
    L17:
        r10 = 0;
    L7:
        r4 = new TaskSkillRepository$requestLocalPcMeta$1(this, r39);
        goto L8
    }

    public final Object c(String r6, int r7, String r8, String r9, Continuation<? super Result<Long>> r10) {
        if ((r10 instanceof TaskSkillRepository$addRecentlyUsedSkill$1) == false) goto L7;
        TaskSkillRepository$addRecentlyUsedSkill$1 r0 = (TaskSkillRepository$addRecentlyUsedSkill$1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r7 = r0.I$0;
        r8 = (String) r0.L$1;
        r6 = (String) r0.L$0;
        ResultKt.throwOnFailure(r11);
    L32:
        dm9.a.b r12 = (dm9.a) r11;
        if ((r12 instanceof dm9.a.b) == false) goto L45;
        dm9.a.b r13 = r12;
        if (r13.a.isSuccess() == false) goto L43;
        com.larus.bmhome.taskskill.network.a r14 = (com.larus.bmhome.taskskill.network.a) r13.a.getData();
        if (r14 == null) goto L41;
        Long r15 = r14.a();
        if (r15 == null) goto L41;
        long r16 = r15.longValue();
    L42:
        u(r7, r6, r8, Boxing.boxLong(r16));
        FLogger.a.i("TaskSkillRepository", "[addRecentlyUsedSkill] success, type=" + r7 + ", updatedAtMs=" + r16);
        Result.Companion r17 = Result.Companion;
        return Result.constructor-impl(Boxing.boxLong(r16));
    L41:
        r16 = System.currentTimeMillis();
        goto L42
    L43:
        FLogger.a.w("TaskSkillRepository", "[addRecentlyUsedSkill] failed code=" + r13.a.getCode() + ", msg=" + r13.a.getMsg());
        Result.Companion r18 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new IllegalStateException(r13.a.getMsg())));
    L45:
        if ((r12 instanceof dm9.a.a) == false) goto L49;
        FLogger r19 = FLogger.a;
        StringBuilder r20 = new StringBuilder("[addRecentlyUsedSkill] failed code=");
        dm9.a.a r110 = (dm9.a.a) r12;
        r20.append(r110.a);
        r20.append(", msg=");
        r20.append(r110.b);
        r19.w("TaskSkillRepository", r20.toString());
        Result.Companion r21 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new IllegalStateException(r110.b)));
    L49:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r11);
        if (StringsKt.isBlank(r6) == false) goto L19;
        Result.Companion r22 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new IllegalArgumentException("skillName is blank")));
    L19:
        if (r7 != SkillType.LOCAL.getValue()) goto L29;
        if (r8 != null) goto L22;
    L25:
        boolean r111 = true;
    L26:
        if (r111 == false) goto L29;
        Result.Companion r23 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new IllegalArgumentException("local skill requires path")));
    L22:
        if (StringsKt.isBlank(r8) == true) goto L25;
        r111 = false;
    L29:
        f r112 = new f(r6, Boxing.boxInt(r7), r8, r9);
        TaskSkillApi.a r24 = TaskSkillApi.a;
        TaskSkillRepository$addRecentlyUsedSkill$result$1 r4 = new TaskSkillRepository$addRecentlyUsedSkill$result$1(r112, null);
        r0.L$0 = r6;
        r0.L$1 = r8;
        r0.I$0 = r7;
        r0.label = 1;
        r24.getClass();
        r11 = TaskSkillApi.a.a(r4, r0);
        if (r11 != r2) goto L32;
        return r2;
    L7:
        r0 = new TaskSkillRepository$addRecentlyUsedSkill$1(this, r10);
        goto L8
    }

    public final Object o(String r6, int r7, String r8, String r9, Continuation<? super Result<Unit>> r10) {
        if ((r10 instanceof TaskSkillRepository$removeRecentlyUsedSkill$1) == false) goto L7;
        TaskSkillRepository$removeRecentlyUsedSkill$1 r0 = (TaskSkillRepository$removeRecentlyUsedSkill$1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r7 = r0.I$0;
        r8 = (String) r0.L$1;
        r6 = (String) r0.L$0;
        ResultKt.throwOnFailure(r11);
    L32:
        dm9.a.b r12 = (dm9.a) r11;
        if ((r12 instanceof dm9.a.b) == false) goto L39;
        dm9.a.b r13 = r12;
        if (r13.a.isSuccess() == false) goto L37;
        u(r7, r6, r8, null);
        FLogger.a.i("TaskSkillRepository", "[removeRecentlyUsedSkill] success, type=" + r7);
        Result.Companion r14 = Result.Companion;
        return Result.constructor-impl(Unit.INSTANCE);
    L37:
        FLogger.a.w("TaskSkillRepository", "[removeRecentlyUsedSkill] failed code=" + r13.a.getCode() + ", msg=" + r13.a.getMsg());
        Result.Companion r15 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new IllegalStateException(r13.a.getMsg())));
    L39:
        if ((r12 instanceof dm9.a.a) == false) goto L43;
        FLogger r16 = FLogger.a;
        StringBuilder r17 = new StringBuilder("[removeRecentlyUsedSkill] failed code=");
        dm9.a.a r18 = (dm9.a.a) r12;
        r17.append(r18.a);
        r17.append(", msg=");
        r17.append(r18.b);
        r16.w("TaskSkillRepository", r17.toString());
        Result.Companion r19 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new IllegalStateException(r18.b)));
    L43:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r11);
        if (StringsKt.isBlank(r6) == false) goto L19;
        Result.Companion r20 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new IllegalArgumentException("skillName is blank")));
    L19:
        if (r7 != SkillType.LOCAL.getValue()) goto L29;
        if (r8 != null) goto L22;
    L25:
        boolean r110 = true;
    L26:
        if (r110 == false) goto L29;
        Result.Companion r21 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new IllegalArgumentException("local skill requires path")));
    L22:
        if (StringsKt.isBlank(r8) == true) goto L25;
        r110 = false;
    L29:
        f r111 = new f(r6, Boxing.boxInt(r7), r8, r9);
        TaskSkillApi.a r22 = TaskSkillApi.a;
        TaskSkillRepository$removeRecentlyUsedSkill$result$1 r4 = new TaskSkillRepository$removeRecentlyUsedSkill$result$1(r111, null);
        r0.L$0 = r6;
        r0.L$1 = r8;
        r0.I$0 = r7;
        r0.label = 1;
        r22.getClass();
        r11 = TaskSkillApi.a.a(r4, r0);
        if (r11 != r2) goto L32;
        return r2;
    L7:
        r0 = new TaskSkillRepository$removeRecentlyUsedSkill$1(this, r10);
        goto L8
    }
}
