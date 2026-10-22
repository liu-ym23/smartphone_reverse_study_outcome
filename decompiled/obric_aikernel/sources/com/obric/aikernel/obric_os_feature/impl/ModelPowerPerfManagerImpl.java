package com.obric.aikernel.obric_os_feature.impl;

import android.app.AppRecordManager;
import android.app.InfoData;
import android.database.ContentObserver;
import android.os.Bundle;
import android.os.SystemClock;
import android.provider.Settings;
import com.bytedance.apm6.consumer.slardar.send.downgrade.DowngradeInfo;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.core.log.AIKLog;
import com.obric.aikernel.middleware.api.appcontext.AppContext;
import com.obric.aikernel.middleware.api.settings.AppSettingsManager;
import com.obric.aikernel.middleware.api.traker.ITrackerApi;
import com.obric.aikernel.obric_os_feature.api.IModelPowerPerfManager;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.utils.OScDSPUsageUtils;
import com.obric.aikernel.utils.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.h;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.m1;
import org.json.JSONException;
import org.json.JSONObject;
import s7.j;

/* JADX INFO: loaded from: classes2.dex */
public final class ModelPowerPerfManagerImpl implements IModelPowerPerfManager {
    private static final String AIK_APP_SERVICE_NAME = "aik_app";
    public static final String AI_SCENE_NAME = "scenes";
    public static final String APP_CPU_STATE = "state";
    public static final String CTX_ACTIVE_SCENE_KEY = "_EnterCpuPerScene";
    public static final int EVENT_AIKERNEL_EXCLUSIVE = 13010;
    public static final long EVENT_AI_SCENE_ENTER = 1;
    public static final long EVENT_AI_SCENE_EXIT = 0;
    public static final String EVENT_MODEL_POWER_USAGE = "power_teardown_status";
    public static final ModelPowerPerfManagerImpl INSTANCE = null;
    private static final String JOB_QUEUE_THREAD_NAME = "Aee-JobQueue";
    private static final int LARGE_CORE_THREAD_SNAPSHOT_CACHE_SIZE_THRESHOLD = 512;
    private static final long LARGE_CORE_THREAD_SNAPSHOT_EXPIRE_THRESHOLD = 600000;
    private static final int LARGE_CORE_THREAD_SNAPSHOT_PARTIAL_CLEAN_LIMIT = 64;
    private static final long MODEL_STAT_EXPIRE_THRESHOLD = 1800000;
    public static final String PID_NAME = "pid";
    public static final String TAG = "ModelPowerPerfManagerImpl";
    public static final String THREAD_NAMES = "threadNames";
    public static final String TIDS_NAME = "tids";
    private static final long TRIGGER_CLEAN_THRESHOLD = 3600000;
    private static final AtomicInteger aiSceneCounter = null;
    private static final AtomicInteger aiStateCounter = null;
    private static final ConcurrentHashMap<String, a> largeCoreThreadSnapshotCache = null;
    private static long lastQueryTime;
    private static final Regex loadQueueThreadRegex = null;
    private static final ReentrantLock lock = null;
    private static final Regex payloadThreadRegex = null;
    private static final ContentObserver powerLevelObserver = null;
    private static final l0 recordScope = null;
    private static final Regex serviceThreadRegex = null;
    private static final CoroutineDispatcher singleThreadDispatcher = null;
    private static final ConcurrentHashMap<String, ConcurrentHashMap<String, b>> statsMap = null;

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f4725a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f4726b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f4727c;

        public a(String r10, String r11, long r12) {
            this.f4725a = r10;
            this.f4726b = r11;
            this.f4727c = r12;
        }

        public final long a() {
            return this.f4727c;
        }

        public final String b() {
            return this.f4725a;
        }

        public final String c() {
            return this.f4726b;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof a) == true) goto L8;
            return false;
        L8:
            a r11 = (a) r10;
            if (Intrinsics.areEqual(this.f4725a, r11.f4725a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f4726b, r11.f4726b) == true) goto L15;
            return false;
        L15:
            if (this.f4727c == r11.f4727c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            String r10 = this.f4725a;
            int r11 = 0;
            if (r10 != null) goto L5;
            int r12 = 0;
        L6:
            int r13 = r12 * 31;
            String r14 = this.f4726b;
            if (r14 == null) goto L11;
            r11 = r14.hashCode();
        L11:
            return ((r13 + r11) * 31) + Long.hashCode(this.f4727c);
        L5:
            r12 = r10.hashCode();
            goto L6
        }

        public String toString() {
            return "CachedThreadSnapshot(threadNames=" + this.f4725a + ", tids=" + this.f4726b + ", createdAtMs=" + this.f4727c + ')';
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.obric_os_feature.impl.ModelPowerPerfManagerImpl$adjustLargeCores$1, reason: invalid class name */
    @DebugMetadata(c = "com.obric.aikernel.obric_os_feature.impl.ModelPowerPerfManagerImpl$adjustLargeCores$1", f = "ModelPowerPerfManagerImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $enter;
        final /* synthetic */ RequestParams $params;
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(RequestParams r10, boolean r11, Continuation<? super AnonymousClass1> r12) {
            this.$params = r10;
            this.$enter = r11;
            super(2, r12);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            AnonymousClass1 r12 = new AnonymousClass1(this.$params, this.$enter, r11);
            r12.L$0 = r10;
            return r12;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
            return invoke2(r10, r11);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
            return ((AnonymousClass1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r20) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L31;
            ResultKt.throwOnFailure(r20);
            l0 r10 = (l0) this.L$0;
            Bundle r11 = this.$params.getBackend();
            String r12 = r11.getString(IdlKeys.Args_TraceId);
            if (r12 == null) goto L7;
            String r13 = r11.getString(IdlKeys.Args_BizName);
            if (ArraysKt.contains(AppSettingsManager.INSTANCE.getModelQuotaConfigs().c(), r13) == false) goto L11;
            boolean r14 = true;
            if (r11.getInt(IdlKeys.Args_Priority) == 1) goto L16;
            r14 = false;
        L16:
            if (r14 == false) goto L18;
            ModelPowerPerfManagerImpl r15 = ModelPowerPerfManagerImpl.INSTANCE;
            String r16 = ModelPowerPerfManagerImpl.access$buildLargeCoreSnapshotCacheKey(r15, r12, r13);
            ModelPowerPerfManagerImpl.access$cleanExpiredLargeCoreThreadSnapshots(r15);
            if (this.$enter == false) goto L23;
            c r17 = ModelPowerPerfManagerImpl.access$buildThreadReportParams(r15, r13);
            ModelPowerPerfManagerImpl.access$getLargeCoreThreadSnapshotCache$p().put(r16, new a(r17.a(), r17.b(), SystemClock.elapsedRealtime()));
            List r18 = CollectionsKt.listOf(new g("state", Boxing.boxInt(State.FOREGROUND_USER.ordinal()), 0, r17.a(), r17.b(), 4, null));
        L22:
            ModelPowerPerfManagerImpl.access$notifyAppRecord(r15, r18);
            return Unit.INSTANCE;
        L23:
            a r19 = (a) ModelPowerPerfManagerImpl.access$getLargeCoreThreadSnapshotCache$p().remove(r16);
            if (r19 == null) goto L26;
            g r110 = new g("state", Boxing.boxInt(State.BACKGROUND_NORMAL.ordinal()), 0, r19.b(), r19.c(), 4, null);
        L27:
            r18 = CollectionsKt.listOf(r110);
            goto L22
        L26:
            r110 = new g("state", Boxing.boxInt(State.BACKGROUND_NORMAL.ordinal()), 0, null, null, 28, null);
            goto L27
        L18:
            return Unit.INSTANCE;
        L11:
            return Unit.INSTANCE;
        L7:
            return Unit.INSTANCE;
        L31:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f4728a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f4729b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f4730c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f4731d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f4732e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f4733f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final long f4734g;

        public b(long r10, String r11, String r12, int r13, String r14, long r15, long r16) {
            Intrinsics.checkNotNullParameter(r11, "callerPkg");
            Intrinsics.checkNotNullParameter(r12, "perfMode");
            Intrinsics.checkNotNullParameter(r14, "modelName");
            this.f4728a = r10;
            this.f4729b = r11;
            this.f4730c = r12;
            this.f4731d = r13;
            this.f4732e = r14;
            this.f4733f = r15;
            this.f4734g = r16;
        }

        public /* synthetic */ b(long r14, String r16, String r17, int r18, String r19, long r20, long r22, int r24, DefaultConstructorMarker r25) {
            if ((r24 & 1) == 0) goto L5;
            long r10 = 0;
        L7:
            if ((r24 & 32) == 0) goto L9;
            long r11 = SystemClock.elapsedRealtime();
        L11:
            if ((r24 & 64) == 0) goto L13;
            long r12 = SystemClock.elapsedRealtime();
        L14:
            this(r10, r16, r17, r18, r19, r11, r12);
            return;
        L13:
            r12 = r22;
            goto L14
        L9:
            r11 = r20;
            goto L11
        L5:
            r10 = r14;
            goto L7
        }

        public final String a() {
            return this.f4729b;
        }

        public final String b() {
            return this.f4732e;
        }

        public final String c() {
            return this.f4730c;
        }

        public final long d() {
            return this.f4734g;
        }

        public final int e() {
            return this.f4731d;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof b) == true) goto L8;
            return false;
        L8:
            b r11 = (b) r10;
            if (this.f4728a == r11.f4728a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f4729b, r11.f4729b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f4730c, r11.f4730c) == true) goto L18;
            return false;
        L18:
            if (this.f4731d == r11.f4731d) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f4732e, r11.f4732e) == true) goto L24;
            return false;
        L24:
            if (this.f4733f == r11.f4733f) goto L27;
            return false;
        L27:
            if (this.f4734g == r11.f4734g) goto L29;
            return false;
        L29:
            return true;
        }

        public final long f() {
            return this.f4728a;
        }

        public final long g() {
            return this.f4733f;
        }

        public final void h(long r10) {
            this.f4728a = r10;
        }

        public int hashCode() {
            return (((((((((((Long.hashCode(this.f4728a) * 31) + this.f4729b.hashCode()) * 31) + this.f4730c.hashCode()) * 31) + Integer.hashCode(this.f4731d)) * 31) + this.f4732e.hashCode()) * 31) + Long.hashCode(this.f4733f)) * 31) + Long.hashCode(this.f4734g);
        }

        public final void i(long r10) {
            this.f4733f = r10;
        }

        public String toString() {
            return "ModelStat(totalDuration=" + this.f4728a + ", callerPkg=" + this.f4729b + ", perfMode=" + this.f4730c + ", thermal=" + this.f4731d + ", modelName=" + this.f4732e + ", updateTime=" + this.f4733f + ", startTime=" + this.f4734g + ')';
        }
    }

    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f4735a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f4736b;

        public c(String r10, String r11) {
            this.f4735a = r10;
            this.f4736b = r11;
        }

        public final String a() {
            return this.f4735a;
        }

        public final String b() {
            return this.f4736b;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof c) == true) goto L8;
            return false;
        L8:
            c r11 = (c) r10;
            if (Intrinsics.areEqual(this.f4735a, r11.f4735a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f4736b, r11.f4736b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            String r10 = this.f4735a;
            int r11 = 0;
            if (r10 != null) goto L5;
            int r12 = 0;
        L6:
            int r13 = r12 * 31;
            String r14 = this.f4736b;
            if (r14 == null) goto L11;
            r11 = r14.hashCode();
        L11:
            return r13 + r11;
        L5:
            r12 = r10.hashCode();
            goto L6
        }

        public String toString() {
            return "ThreadReportParams(threadNames=" + this.f4735a + ", tids=" + this.f4736b + ')';
        }
    }

    private static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map<String, Long> f4737a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Map<String, Long> f4738b;

        public d(Map<String, Long> r10, Map<String, Long> r11) {
            Intrinsics.checkNotNullParameter(r10, "frameworkThreadTidMap");
            Intrinsics.checkNotNullParameter(r11, "algoServiceThreadTidMap");
            this.f4737a = r10;
            this.f4738b = r11;
        }

        public final Map<String, Long> a() {
            return this.f4737a;
        }

        public final Map<String, Long> b() {
            return this.f4738b;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof d) == true) goto L8;
            return false;
        L8:
            d r11 = (d) r10;
            if (Intrinsics.areEqual(this.f4737a, r11.f4737a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f4738b, r11.f4738b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f4737a.hashCode() * 31) + this.f4738b.hashCode();
        }

        public String toString() {
            return "ThreadTidGroups(frameworkThreadTidMap=" + this.f4737a + ", algoServiceThreadTidMap=" + this.f4738b + ')';
        }
    }

    @SourceDebugExtension({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2\n*L\n1#1,328:1\n*E\n"})
    public static final class e<T> implements Comparator {
        public e() {
        }

        @Override // java.util.Comparator
        public final int compare(T r10, T r11) {
            return ComparisonsKt.compareValues((Long) ((Map.Entry) r10).getKey(), (Long) ((Map.Entry) r11).getKey());
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.obric_os_feature.impl.ModelPowerPerfManagerImpl$notifyModelUsage$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "com.obric.aikernel.obric_os_feature.impl.ModelPowerPerfManagerImpl$notifyModelUsage$1", f = "ModelPowerPerfManagerImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C03731 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
        final /* synthetic */ JSONObject $args;
        int label;

        C03731(JSONObject r10, Continuation<? super C03731> r11) {
            this.$args = r10;
            super(2, r11);
        }

        public static /* synthetic */ ConcurrentHashMap e(Function1 r10, Object r11) {
            return invokeSuspend$lambda$0(r10, r11);
        }

        public static /* synthetic */ b f(Function2 r10, Object r11, Object r12) {
            return invokeSuspend$lambda$1(r10, r11, r12);
        }

        private static final ConcurrentHashMap invokeSuspend$lambda$0(Function1 r10, Object r11) {
            return (ConcurrentHashMap) r10.invoke(r11);
        }

        private static final b invokeSuspend$lambda$1(Function2 r10, Object r11, Object r12) {
            return (b) r10.invoke(r11, r12);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new C03731(this.$args, r11);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
            return invoke2(r10, r11);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
            return ((C03731) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r11) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L20;
            ResultKt.throwOnFailure(r11);
            ModelPowerPerfManagerImpl.access$checkAndCleanExpiredData(ModelPowerPerfManagerImpl.INSTANCE);     // Catch: Exception -> L15
            String r12 = this.$args.optString("bizName", "unknown");     // Catch: Exception -> L15
            final String r10 = this.$args.optString("modelName", "unknown");     // Catch: Exception -> L15
            final long r13 = this.$args.optLong("duration", 0);     // Catch: Exception -> L15
            final String r14 = this.$args.optString(IdlKeys.Args_PackageName, "unknown");     // Catch: Exception -> L15
            final String r15 = this.$args.optString("perfMode", DowngradeInfo.SubInfo.FIELD_DEFAULT_RATE);     // Catch: Exception -> L15
            final int r16 = this.$args.optInt("thermal", n7.a.f11264a.b());     // Catch: Exception -> L15
            if (r13 <= 0) goto L14;
            if (Intrinsics.areEqual(r14, "unknown") == true) goto L14;
            if (Intrinsics.areEqual(r10, "unknown") == true) goto L14;
            String r17 = r12 + '#' + r14;     // Catch: Exception -> L15
            ConcurrentHashMap r18 = ModelPowerPerfManagerImpl.access$getStatsMap$p();     // Catch: Exception -> L15
            final C01091 r19 = C01091.INSTANCE;     // Catch: Exception -> L15
            ConcurrentHashMap r110 = (ConcurrentHashMap) r18.computeIfAbsent(r17, new com.obric.aikernel.obric_os_feature.impl.e(r19));     // Catch: Exception -> L15
            final Function2<String, b, b> r20 = new AnonymousClass2(r13, r14, r15, r16, r10);     // Catch: Exception -> L15
            r110.compute(r10 + '#' + r15 + '#' + r16, new com.obric.aikernel.obric_os_feature.impl.d(r20));     // Catch: Exception -> L15
        L18:
            return Unit.INSTANCE;
        L14:
            return Unit.INSTANCE;
        L15:
            e = move-exception;
            AIKLog.INSTANCE.e(ModelPowerPerfManagerImpl.TAG, "Failed to process model usage: " + e.getMessage());
            goto L18
        L20:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.obric_os_feature.impl.ModelPowerPerfManagerImpl$printAllStats$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "com.obric.aikernel.obric_os_feature.impl.ModelPowerPerfManagerImpl$printAllStats$1", f = "ModelPowerPerfManagerImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C03741 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
        int label;

        C03741(Continuation<? super C03741> r10) {
            super(2, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new C03741(r11);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
            return invoke2(r10, r11);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
            return ((C03741) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L18;
            ResultKt.throwOnFailure(r10);
            if (ModelPowerPerfManagerImpl.access$getStatsMap$p().isEmpty() == false) goto L9;
            AIKLog r11 = AIKLog.INSTANCE;
            String r12 = "statsMap is empty";
        L7:
            r11.d(ModelPowerPerfManagerImpl.TAG, r12);
            return Unit.INSTANCE;
        L9:
            AIKLog.INSTANCE.d(ModelPowerPerfManagerImpl.TAG, "===== statsMap 全部数据开始 =====");
            Iterator r13 = ModelPowerPerfManagerImpl.access$getStatsMap$p().entrySet().iterator();
        L11:
            if (r13.hasNext() == false) goto L16;
            Map.Entry r14 = (Map.Entry) r13.next();
            String r15 = (String) r14.getKey();
            ConcurrentHashMap r16 = (ConcurrentHashMap) r14.getValue();
            AIKLog.INSTANCE.d(ModelPowerPerfManagerImpl.TAG, "tier1Key: " + r15);
            Iterator r17 = r16.entrySet().iterator();
        L14:
            if (r17.hasNext() == false) goto L11;
            Map.Entry r18 = (Map.Entry) r17.next();
            String r19 = (String) r18.getKey();
            b r20 = (b) r18.getValue();
            AIKLog r21 = AIKLog.INSTANCE;
            r21.d(ModelPowerPerfManagerImpl.TAG, "  compositeKey: " + r19);
            r21.d(ModelPowerPerfManagerImpl.TAG, "    ModelStat: {");
            r21.d(ModelPowerPerfManagerImpl.TAG, "      callerPkg: " + r20.a());
            r21.d(ModelPowerPerfManagerImpl.TAG, "      perfMode: " + r20.c());
            r21.d(ModelPowerPerfManagerImpl.TAG, "      thermal: " + r20.e());
            r21.d(ModelPowerPerfManagerImpl.TAG, "      modelName: " + r20.b());
            r21.d(ModelPowerPerfManagerImpl.TAG, "      totalDuration: " + r20.f() + " ms");
            r21.d(ModelPowerPerfManagerImpl.TAG, "    }");
            goto L14
        L16:
            r11 = AIKLog.INSTANCE;
            r12 = "===== statsMap 全部数据结束 =====";
            goto L7
        L18:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.obric_os_feature.impl.ModelPowerPerfManagerImpl$queryAndClearStats$2, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "com.obric.aikernel.obric_os_feature.impl.ModelPowerPerfManagerImpl$queryAndClearStats$2", f = "ModelPowerPerfManagerImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C03752 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
        int label;

        C03752(Continuation<? super C03752> r10) {
            super(2, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new C03752(r11);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
            return invoke2(r10, r11);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
            return ((C03752) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r14) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L44;
            ResultKt.throwOnFailure(r14);
            ReentrantLock r13 = ModelPowerPerfManagerImpl.access$getLock$p();
            r13.lock();
            LinkedHashMap r15 = new LinkedHashMap();     // Catch: Throwable -> L40
            Iterator r10 = ModelPowerPerfManagerImpl.access$getStatsMap$p().entrySet().iterator();     // Catch: Throwable -> L40
        L7:
            boolean r11 = true;
            boolean r12 = false;
            if (r10.hasNext() == false) goto L26;
            Map.Entry r16 = (Map.Entry) r10.next();     // Catch: Throwable -> L40
            String r17 = (String) r16.getKey();     // Catch: Throwable -> L40
            Collection r18 = ((ConcurrentHashMap) r16.getValue()).values();     // Catch: Throwable -> L40
            Intrinsics.checkNotNullExpressionValue(r18, "statMap.values");     // Catch: Throwable -> L40
            ArrayList r19 = new ArrayList();     // Catch: Throwable -> L40
            Iterator r20 = r18.iterator();     // Catch: Throwable -> L40
        L11:
            if (r20.hasNext() == false) goto L19;
            b r21 = (b) r20.next();     // Catch: Throwable -> L40
            JSONObject r22 = new JSONObject();     // Catch: JSONException -> L15 Throwable -> L40
            r22.put(ITrackerApi.CALLER_PKG, r21.a());     // Catch: JSONException -> L15 Throwable -> L40
            r22.put("thermal", r21.e());     // Catch: JSONException -> L15 Throwable -> L40
            r22.put("modelName", r21.b());     // Catch: JSONException -> L15 Throwable -> L40
            r22.put("totalduration", r21.f());     // Catch: JSONException -> L15 Throwable -> L40
            r22.put("perf_mode", r21.c());     // Catch: JSONException -> L15 Throwable -> L40
            r22.put("start_time", r21.d());     // Catch: JSONException -> L15 Throwable -> L40
            String r23 = r22.toString();     // Catch: JSONException -> L15 Throwable -> L40
        L17:
            if (r23 == null) goto L11;
            r19.add(r23);     // Catch: Throwable -> L40
            goto L11
        L15:
            e = move-exception;
            AIKLog.INSTANCE.e("queryAndClearStats", "Failed to convert stat to JSON (model: " + r21.b() + ')', e);     // Catch: Throwable -> L40
            r23 = null;
            goto L17
        L19:
            String[] r24 = (String[]) r19.toArray(new String[0]);     // Catch: Throwable -> L40
            if (r24.length != 0) goto L23;
            r12 = true;
        L23:
            if ((!r12) == false) goto L7;
            r15.put(r17, r24);     // Catch: Throwable -> L40
            goto L7
        L26:
            if (r15.isEmpty() == false) goto L47;
            ModelPowerPerfManagerImpl r110 = ModelPowerPerfManagerImpl.INSTANCE;     // Catch: Throwable -> L40
            long r25 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L40
        L28:
            ModelPowerPerfManagerImpl.access$setLastQueryTime$p(r25);     // Catch: Throwable -> L40
        L37:
            Unit r111 = Unit.INSTANCE;     // Catch: Throwable -> L40
            r13.unlock();
            return r111;
        L47:
            f.f4744a.c(r15);     // Catch: Exception -> L32 Throwable -> L40
            AIKLog.INSTANCE.d(ModelPowerPerfManagerImpl.TAG, "Upload stats success, size: " + r15.size());     // Catch: Exception -> L32 Throwable -> L40
        L34:
            if (r11 == false) goto L36;
            ModelPowerPerfManagerImpl.access$getStatsMap$p().clear();     // Catch: Throwable -> L40
            ModelPowerPerfManagerImpl r112 = ModelPowerPerfManagerImpl.INSTANCE;     // Catch: Throwable -> L40
            r25 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L40
            goto L28
        L36:
            AIKLog.INSTANCE.w("queryAndClearStats", "Keep stats for retry next time");     // Catch: Throwable -> L40
            goto L37
        L32:
            e = move-exception;
            AIKLog.INSTANCE.e(ModelPowerPerfManagerImpl.TAG, "Upload stats failed", e);     // Catch: Throwable -> L40
            r11 = false;
        L40:
            th = move-exception;
            r13.unlock();
            throw th;
        L44:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        ModelPowerPerfManagerImpl r10 = new ModelPowerPerfManagerImpl();
        INSTANCE = r10;
        aiSceneCounter = new AtomicInteger(0);
        aiStateCounter = new AtomicInteger(0);
        lastQueryTime = SystemClock.elapsedRealtime();
        RegexOption r11 = RegexOption.IGNORE_CASE;
        loadQueueThreadRegex = new Regex("^Aee-LoadQueue-\\d+$", r11);
        payloadThreadRegex = new Regex("^Aee-Payload-\\d+$", r11);
        serviceThreadRegex = new Regex("^Aee-service-([^@]+)@\\d+$", r11);
        ExecutorService r12 = Executors.newSingleThreadExecutor(com.obric.aikernel.obric_os_feature.impl.a.f4739c);
        Intrinsics.checkNotNullExpressionValue(r12, "newSingleThreadExecutor …AIInfer-Record-Thread\") }");
        ExecutorCoroutineDispatcher r13 = m1.b(r12);
        singleThreadDispatcher = r13;
        recordScope = m0.a(r13);
        statsMap = new ConcurrentHashMap();
        largeCoreThreadSnapshotCache = new ConcurrentHashMap();
        lock = new ReentrantLock();
        ContentObserver r14 = new ModelPowerPerfManagerImpl$powerLevelObserver$1();
        powerLevelObserver = r14;
        r10.notifyAppRecord(CollectionsKt.listOf(new g[]{new g("state", Integer.valueOf(State.BACKGROUND_NORMAL.ordinal()), 0, null, null, 28, null), new g(AI_SCENE_NAME, 0L, 0, null, null, 28, null)}));
        if (r10.shouldRegisterPowerLevelObserver() == false) goto L5;
        AppContext.INSTANCE.getContext().getContentResolver().registerContentObserver(Settings.Global.getUriFor(EVENT_MODEL_POWER_USAGE), false, r14);
        return;
    L5:
        AIKLog.INSTANCE.d(TAG, "skip power level observer registration in main process");
    }

    private ModelPowerPerfManagerImpl() {
    }

    public static /* synthetic */ Thread a(Runnable r10) {
        return singleThreadDispatcher$lambda$0(r10);
    }

    public static final /* synthetic */ String access$buildLargeCoreSnapshotCacheKey(ModelPowerPerfManagerImpl r10, String r11, String r12) {
        return r10.buildLargeCoreSnapshotCacheKey(r11, r12);
    }

    public static final /* synthetic */ c access$buildThreadReportParams(ModelPowerPerfManagerImpl r10, String r11) {
        return r10.buildThreadReportParams(r11);
    }

    public static final /* synthetic */ void access$checkAndCleanExpiredData(ModelPowerPerfManagerImpl r10) {
        r10.checkAndCleanExpiredData();
    }

    public static final /* synthetic */ void access$cleanExpiredLargeCoreThreadSnapshots(ModelPowerPerfManagerImpl r10) {
        r10.cleanExpiredLargeCoreThreadSnapshots();
    }

    public static final /* synthetic */ ConcurrentHashMap access$getLargeCoreThreadSnapshotCache$p() {
        return largeCoreThreadSnapshotCache;
    }

    public static final /* synthetic */ ReentrantLock access$getLock$p() {
        return lock;
    }

    public static final /* synthetic */ l0 access$getRecordScope$p() {
        return recordScope;
    }

    public static final /* synthetic */ ConcurrentHashMap access$getStatsMap$p() {
        return statsMap;
    }

    public static final /* synthetic */ void access$notifyAppRecord(ModelPowerPerfManagerImpl r10, List r11) {
        r10.notifyAppRecord(r11);
    }

    public static final /* synthetic */ void access$setLastQueryTime$p(long r10) {
        lastQueryTime = r10;
    }

    private final void adjustLargeCores(boolean r10, RequestParams r11) {
        h.d(recordScope, null, null, new AnonymousClass1(r11, r10, null), 3, null);
    }

    public static /* synthetic */ boolean b(Function1 r10, Object r11) {
        return cleanExpiredLargeCoreThreadSnapshots$lambda$1(r10, r11);
    }

    private final String buildLargeCoreSnapshotCacheKey(String r10, String r11) {
        StringBuilder r12 = new StringBuilder();
        r12.append(r10);
        r12.append('#');
        if (r11 != null) goto L5;
        r11 = "";
    L5:
        r12.append(r11);
        return r12.toString();
    }

    private final String buildPowerAdvisorUploadItem(String r10, int r11, String r12, long r13, String r14, long r15) {
        JSONObject r16 = new JSONObject();
        r16.put(ITrackerApi.CALLER_PKG, r10);
        r16.put("thermal", r11);
        r16.put("modelName", r12);
        r16.put("totalduration", r13);
        r16.put("perf_mode", r14);
        r16.put("start_time", r15);
        String r17 = r16.toString();
        Intrinsics.checkNotNullExpressionValue(r17, "JSONObject().apply {\n   …ime)\n        }.toString()");
        return r17;
    }

    private final Map<String, String[]> buildTemporaryUploadResult() {
        long r10 = SystemClock.elapsedRealtime();
        return MapsKt.linkedMapOf(new Pair[]{TuplesKt.to("bert_all_in_one#com.obric.aikernel.sdk.ci", new String[]{buildPowerAdvisorUploadItem("com.obric.aikernel.sdk.ci", 0, "bert_all_in_one@6", 152, "balanced", r10)}), TuplesKt.to("re_name#com.obric.aikernel.sdk.ci", new String[]{buildPowerAdvisorUploadItem("com.obric.aikernel.sdk.ci", 0, "re_name@22", 18, "balanced", r10)})});
    }

    private final c buildThreadReportParams(String r10) {
        if (r10 != null) goto L5;
    L8:
        boolean r11 = true;
    L10:
        if (r11 == true) goto L12;
        Map<String, Long> r12 = AppContext.INSTANCE.getDispatchThreadTidSnapshot();
        if (r12.isEmpty() == true) goto L16;
        d r13 = splitThreadTidMap(r12);
        Map<String, Long> r14 = r13.a();
        Map<String, Long> r15 = r13.b();
        LinkedHashMap r16 = new LinkedHashMap();
        Iterator<Map.Entry<String, Long>> r17 = r15.entrySet().iterator();
    L19:
        if (r17.hasNext() == false) goto L28;
        Map.Entry<String, Long> r18 = r17.next();
        String r19 = INSTANCE.extractServiceThreadName(r18.getKey());
        if (r19 != null) goto L23;
    L25:
        boolean r20 = false;
    L26:
        if (r20 == false) goto L19;
        r16.put(r18.getKey(), r18.getValue());
        goto L19
    L23:
        if (StringsKt.equals(r19, r10, true) != true) goto L25;
        r20 = true;
        goto L26
    L28:
        List r21 = CollectionsKt.plus(CollectionsKt.toList(r14.entrySet()), CollectionsKt.toList(r16.entrySet()));
        LinkedHashMap r110 = new LinkedHashMap();
        Iterator r22 = r21.iterator();
    L30:
        if (r22.hasNext() == false) goto L37;
        Map.Entry r23 = (Map.Entry) r22.next();
        String r24 = (String) r23.getKey();
        long r25 = ((Number) r23.getValue()).longValue();
        if (r25 <= 0) goto L30;
        if (r110.containsKey(Long.valueOf(r25)) == true) goto L30;
        r110.put(Long.valueOf(r25), r24);
        goto L30
    L37:
        if (r110.isEmpty() == true) goto L39;
        Set r26 = r110.entrySet();
        Intrinsics.checkNotNullExpressionValue(r26, "tidThreadNameMap.entries");
        List r27 = CollectionsKt.sortedWith(r26, new e());
        return new c(CollectionsKt.joinToString$default(r27, ",", null, null, 0, null, ModelPowerPerfManagerImpl$buildThreadReportParams$threadNames$1.INSTANCE, 30, null), CollectionsKt.joinToString$default(r27, " ", null, null, 0, null, ModelPowerPerfManagerImpl$buildThreadReportParams$tids$1.INSTANCE, 30, null));
    L39:
        return new c(null, null);
    L16:
        return new c(null, null);
    L12:
        return new c(null, null);
    L5:
        if (StringsKt.isBlank(r10) == true) goto L8;
        r11 = false;
        goto L10
    }

    public static /* synthetic */ boolean c(Function1 r10, Object r11) {
        return checkAndCleanExpiredData$lambda$9(r10, r11);
    }

    private final void checkAndCleanExpiredData() {
        long r10 = SystemClock.elapsedRealtime();
        if ((r10 - lastQueryTime) > TRIGGER_CLEAN_THRESHOLD) goto L5;
        return;
    L5:
        Collection<ConcurrentHashMap<String, b>> r11 = statsMap.values();
        Intrinsics.checkNotNullExpressionValue(r11, "statsMap.values");
        Iterator<T> r12 = r11.iterator();
    L7:
        if (r12.hasNext() == false) goto L14;
        Iterator r13 = ((ConcurrentHashMap) r12.next()).entrySet().iterator();
    L10:
        if (r13.hasNext() == false) goto L7;
        Object r14 = r13.next();
        Intrinsics.checkNotNullExpressionValue(r14, "iterator.next()");
        Object r15 = ((Map.Entry) r14).getValue();
        Intrinsics.checkNotNullExpressionValue(r15, "entry.value");
        if ((r10 - ((b) r15).g()) <= MODEL_STAT_EXPIRE_THRESHOLD) goto L10;
        r13.remove();
        goto L10
    L14:
        Set<Map.Entry<String, ConcurrentHashMap<String, b>>> r16 = statsMap.entrySet();
        final AnonymousClass2 r17 = AnonymousClass2.INSTANCE;
        r16.removeIf(new com.obric.aikernel.obric_os_feature.impl.c(r17));
    }

    private static final boolean checkAndCleanExpiredData$lambda$9(Function1 r10, Object r11) {
        Intrinsics.checkNotNullParameter(r10, "$tmp0");
        return ((Boolean) r10.invoke(r11)).booleanValue();
    }

    private final void cleanExpiredLargeCoreThreadSnapshots() {
        ConcurrentHashMap<String, a> r10 = largeCoreThreadSnapshotCache;
        if (r10.isEmpty() == false) goto L5;
        return;
    L5:
        final long r11 = SystemClock.elapsedRealtime();
        int r12 = 0;
        if (r10.size() <= 512) goto L8;
        boolean r13 = true;
    L9:
        Set<Map.Entry<String, a>> r14 = r10.entrySet();
        if (r13 == false) goto L13;
        final Function1<Map.Entry<String, a>, Boolean> r15 = new C03721(r11);
        r14.removeIf(new com.obric.aikernel.obric_os_feature.impl.b(r15));
        return;
    L13:
        Iterator<Map.Entry<String, a>> r16 = r14.iterator();
    L15:
        if (r16.hasNext() == false) goto L28;
        if (r12 >= 64) goto L21;
        Map.Entry<String, a> r17 = r16.next();
        Intrinsics.checkNotNullExpressionValue(r17, "iterator.next()");
        Map.Entry<String, a> r18 = r17;
        r12 = r12 + 1;
        if ((r11 - r18.getValue().a()) <= LARGE_CORE_THREAD_SNAPSHOT_EXPIRE_THRESHOLD) goto L15;
        largeCoreThreadSnapshotCache.remove(r18.getKey(), r18.getValue());
        goto L15
    L21:
        return;
    L28:
        return;
    L8:
        r13 = false;
        goto L9
    }

    private static final boolean cleanExpiredLargeCoreThreadSnapshots$lambda$1(Function1 r10, Object r11) {
        Intrinsics.checkNotNullParameter(r10, "$tmp0");
        return ((Boolean) r10.invoke(r11)).booleanValue();
    }

    private final String extractServiceThreadName(String r10) {
        MatchResult r11 = serviceThreadRegex.matchEntire(r10);
        if (r11 == null) goto L7;
        List<String> r12 = r11.getGroupValues();
        if (r12 == null) goto L7;
        return (String) CollectionsKt.getOrNull(r12, 1);
    L7:
        return null;
    }

    @JvmStatic
    public static final ModelPowerPerfManagerImpl getInst() {
        return INSTANCE;
    }

    private final boolean isFrameworkThread(String r10) {
        if (StringsKt.equals(r10, JOB_QUEUE_THREAD_NAME, true) == false) goto L6;
        return true;
    L6:
        if (loadQueueThreadRegex.matches(r10) == false) goto L8;
    L16:
        return true;
    L8:
        if (payloadThreadRegex.matches(r10) == true) goto L16;
        String r11 = extractServiceThreadName(r10);
        if (r11 != null) goto L15;
        return false;
    L15:
        return StringsKt.equals(r11, AIK_APP_SERVICE_NAME, true);
    }

    private final void notifyAIScene(boolean r19, RequestParams r20, Bundle r21) {
        Bundle r10 = r20.getBackend();
        String r11 = r10.getString(IdlKeys.Args_BizName);
        String r12 = com.obric.aikernel.utils.b.a(r10);
        j[] r13 = AppSettingsManager.INSTANCE.getModelQuotaConfigs().a();
        int r14 = r13.length;
        boolean r15 = false;
        int r16 = 0;
    L4:
        if (r16 >= r14) goto L14;
        j r17 = r13[r16];
        if (Intrinsics.areEqual(r17.c(), r11) == true) goto L8;
    L10:
        boolean r18 = false;
    L11:
        if (r18 == true) goto L12;
        r16 = r16 + 1;
        goto L4
    L12:
        r15 = true;
        goto L14
    L8:
        if (Intrinsics.areEqual(r17.e(), r12) == false) goto L10;
        r18 = true;
    L14:
        if (r15 == true) goto L16;
        return;
    L16:
        AIKLog r22 = AIKLog.INSTANCE;
        StringBuilder r23 = new StringBuilder();
        r23.append("notifyAIScene: bizName=");
        r23.append(r11);
        r23.append(", loraType=");
        r23.append(r12);
        r23.append(", enter=");
        r23.append(r19);
        r23.append("， aiSceneCounter=");
        AtomicInteger r24 = aiSceneCounter;
        r23.append(r24);
        r23.append(", ismatch=");
        r23.append(r15);
        r22.i(TAG, r23.toString());
        if (r19 == false) goto L24;
        if (r24.incrementAndGet() != 1) goto L29;
        notifyAppRecord(CollectionsKt.listOf(new g(AI_SCENE_NAME, 1L, 0, null, null, 28, null)));
        if (r21 == null) goto L30;
        r21.putInt(CTX_ACTIVE_SCENE_KEY, 1);
        return;
    L30:
        return;
    L29:
        return;
    L24:
        if (r24.decrementAndGet() != 0) goto L32;
        notifyAppRecord(CollectionsKt.listOf(new g(AI_SCENE_NAME, 0L, 0, null, null, 28, null)));
        return;
    }

    private final void notifyAppRecord(List<g> r10) {
        InfoData r11 = new InfoData();
        Iterator<T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L26;
        g r13 = (g) r12.next();
        String r14 = r13.a();
        Object r15 = r13.e();
        if ((r15 instanceof Boolean) == false) goto L9;
        r11.putExtra(r14, ((Boolean) r15).booleanValue());
    L20:
        r11.putExtra("pid", r13.b());
        String r16 = r13.c();
        if (r16 == null) goto L23;
        r11.putExtra(THREAD_NAMES, r16);
    L23:
        String r17 = r13.d();
        if (r17 == null) goto L4;
        r11.putExtra(TIDS_NAME, r17);
        goto L4
    L9:
        if ((r15 instanceof Float) == false) goto L12;
        r11.putExtra(r14, ((Number) r15).floatValue());
        goto L20
    L12:
        if ((r15 instanceof Integer) == false) goto L15;
        r11.putExtra(r14, ((Number) r15).intValue());
        goto L20
    L15:
        if ((r15 instanceof Long) == false) goto L18;
        r11.putExtra(r14, ((Number) r15).longValue());
        goto L20
    L18:
        if ((r15 instanceof String) == false) goto L20;
        r11.putExtra(r14, (String) r15);
        goto L20
    L26:
        r11.putExtra(OaidModel.KEY_TIME, System.currentTimeMillis());
        AppRecordManager.reportDataInfo(13010, r11);     // Catch: Throwable -> L29
    L31:
        AIKLog.INSTANCE.i(TAG, "notify datainfo " + r11);
        return;
    L29:
        th = move-exception;
        th.printStackTrace();
        goto L31
    }

    private final void printAllStats() {
        h.d(recordScope, null, null, new C03741(null), 3, null);
    }

    private final boolean shouldRegisterPowerLevelObserver() {
        return !m.f5603a.a(AppContext.INSTANCE.getContext());
    }

    private static final Thread singleThreadDispatcher$lambda$0(Runnable r10) {
        return new Thread(r10, "AIInfer-Record-Thread");
    }

    private final d splitThreadTidMap(Map<String, Long> r10) {
        LinkedHashMap r11 = new LinkedHashMap();
        LinkedHashMap r12 = new LinkedHashMap();
        Iterator<Map.Entry<String, Long>> r13 = r10.entrySet().iterator();
    L4:
        if (r13.hasNext() == false) goto L18;
        Map.Entry<String, Long> r14 = r13.next();
        String r15 = r14.getKey();
        long r16 = r14.getValue().longValue();
        if (r16 <= 0) goto L4;
        ModelPowerPerfManagerImpl r17 = INSTANCE;
        if (r17.isFrameworkThread(r15) == true) goto L10;
        String r18 = r17.extractServiceThreadName(r15);
        if (r18 == null) goto L4;
        if (StringsKt.equals(r18, AIK_APP_SERVICE_NAME, true) == true) goto L4;
        r12.put(r15, Long.valueOf(r16));
        goto L4
    L10:
        r11.put(r15, Long.valueOf(r16));
        goto L4
    L18:
        return new d(r11, r12);
    }

    @Override // com.obric.aikernel.obric_os_feature.api.IModelPowerPerfManager
    public void notifyModelUsage(JSONObject r10) {
        Intrinsics.checkNotNullParameter(r10, "args");
        h.d(recordScope, null, null, new C03731(r10, null), 3, null);
    }

    @Override // com.obric.aikernel.obric_os_feature.api.IModelPowerPerfManager, com.obric.aikernel.middleware.interfaces.a
    public void notifyVMExecuteBegin(RequestParams r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "vmContext");
        if (StringsKt.equals$default(r10.getBackend().getString(IdlKeys.MethodName), IdlKeys.Method_RunBiz, false, 2, null) == true) goto L5;
        return;
    L5:
        adjustLargeCores(true, r10);
        notifyAIScene(true, r10, r11);
    }

    @Override // com.obric.aikernel.obric_os_feature.api.IModelPowerPerfManager, com.obric.aikernel.middleware.interfaces.a
    public void notifyVMExecuteEnd(RequestParams r10) {
        Intrinsics.checkNotNullParameter(r10, "params");
        if (StringsKt.equals$default(r10.getBackend().getString(IdlKeys.MethodName), IdlKeys.Method_RunBiz, false, 2, null) == true) goto L5;
        return;
    L5:
        adjustLargeCores(false, r10);
        notifyAIScene(false, r10, null);
        OScDSPUsageUtils.f5582a.g(SystemClock.elapsedRealtime());
    }

    public final Object queryAndClearStats(Continuation<? super Unit> r10) {
        Object r11 = h.g(singleThreadDispatcher, new C03752(null), r10);
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r11;
    L6:
        return Unit.INSTANCE;
    }
}
