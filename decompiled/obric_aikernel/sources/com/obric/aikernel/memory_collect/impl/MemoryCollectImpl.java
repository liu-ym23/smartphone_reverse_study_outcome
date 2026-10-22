package com.obric.aikernel.memory_collect.impl;

import android.os.Debug;
import android.os.SystemClock;
import com.obric.aikernel.memory_collect.api.MemoryCollectApi;
import com.obric.aikernel.middleware.api.appcontext.AppContext;
import com.obric.aikernel.middleware.api.log.AIKLog;
import com.obric.aikernel.middleware.api.settings.AppSettingsManager;
import com.obric.aikernel.middleware.api.traker.TrackerApi;
import com.obric.aikernel.utils.AppUtils;
import com.obric.aikernel.utils.DmaBufUtils;
import com.obric.aikernel.utils.c;
import com.obric.aikernel.utils.k;
import java.util.Iterator;
import java.util.Set;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.h;
import kotlinx.coroutines.l0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class MemoryCollectImpl implements MemoryCollectApi {
    public static final MemoryCollectImpl INSTANCE = null;
    private static final String TAG = "MemoryCollectImpl";
    private static volatile l7.a externalParamProvider;
    private static Pair<Boolean, Long> lastReportTime;

    /* JADX INFO: renamed from: com.obric.aikernel.memory_collect.impl.MemoryCollectImpl$collectAndReport$1, reason: invalid class name */
    @DebugMetadata(c = "com.obric.aikernel.memory_collect.impl.MemoryCollectImpl$collectAndReport$1", f = "MemoryCollectImpl.kt", i = {}, l = {57, 61}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> r10) {
            super(2, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass1(r11);
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
        public final Object invokeSuspend(Object r10) {
            Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r12 = this.label;
            if (r12 == 0) goto L10;
            if (r12 == 1) goto L9;
            if (r12 == 2) goto L9;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r10);
        L13:
            MemoryCollectImpl r13 = MemoryCollectImpl.INSTANCE;
            a r14 = MemoryCollectImpl.access$collectMemoryInfo(r13);
            l7.a r15 = MemoryCollectImpl.access$getExternalParamProvider$p();
            Set<String> r16 = null;
            if (r15 == null) goto L16;
            Boolean r17 = Boxing.boxBoolean(r15.a());
        L17:
            l7.a r18 = MemoryCollectImpl.access$getExternalParamProvider$p();
            if (r18 == null) goto L20;
            r16 = r18.b();
        L20:
            MemoryCollectImpl.access$reportMemoryInfo(r13, r14, r17, r16);
            long r19 = ((long) RangesKt.coerceAtLeast(AppSettingsManager.INSTANCE.getMemoryCollectSetting().b(), 1)) * 1000;
            this.label = 2;
            if (DelayKt.b(r19, this) != r11) goto L13;
            return r11;
        L16:
            r17 = null;
            goto L17
        L10:
            ResultKt.throwOnFailure(r10);
            long r20 = ((long) RangesKt.coerceAtLeast(AppSettingsManager.INSTANCE.getMemoryCollectSetting().a(), 1)) * 1000;
            this.label = 1;
            if (DelayKt.b(r20, this) != r11) goto L13;
            return r11;
        }
    }

    static {
        INSTANCE = new MemoryCollectImpl();
        lastReportTime = new Pair(Boolean.FALSE, 0L);
    }

    private MemoryCollectImpl() {
    }

    public static final /* synthetic */ a access$collectMemoryInfo(MemoryCollectImpl r10) {
        return r10.collectMemoryInfo();
    }

    public static final /* synthetic */ l7.a access$getExternalParamProvider$p() {
        return externalParamProvider;
    }

    public static final /* synthetic */ void access$reportMemoryInfo(MemoryCollectImpl r10, a r11, Boolean r12, Set r13) {
        r10.reportMemoryInfo(r11, r12, r13);
    }

    private final void collectAndReport() {
        h.d(c.f5588a.a(), null, null, new AnonymousClass1(null), 3, null);
    }

    private final a collectMemoryInfo() {
        Debug.MemoryInfo r10 = new Debug.MemoryInfo();
        Debug.getMemoryInfo(r10);
        int r11 = DmaBufUtils.f5578a.getDmaBufRssSize();
        return new a(true, r10.getTotalPss() / 1024, r10.nativePss / 1024, r10.dalvikPss / 1024, r10.otherPss / 1024, r10.getTotalSwappablePss() / 1024, r11 / 1024);
    }

    @JvmStatic
    public static final MemoryCollectImpl getInst() {
        return INSTANCE;
    }

    private final void reportMemoryInfo(a r15, Boolean r16, Set<String> r17) {
        TrackerApi r10 = TrackerApi.INSTANCE;
        JSONObject r11 = new JSONObject();
        r11.put("background", r15.a());
        AppContext r12 = AppContext.INSTANCE;
        r11.put("isAdminMode", r12.isAdminMode());
        r11.put("isDebug", r12.isDebug());
        r11.put("socModel", k.f5601a.a());
        String r13 = "yes";
        if (r17 != null) goto L5;
        Object r14 = "unknown";
    L9:
        r11.put("hasLoadModel", r14);
        if (r16 != null) goto L13;
        r13 = "unknown";
    L16:
        r11.put("hasLLM", r13);
        if (r17 == null) goto L22;
        Iterator<T> r18 = r17.iterator();
    L20:
        if (r18.hasNext() == false) goto L22;
        r11.put((String) r18.next(), 1);
    L22:
        Unit r19 = Unit.INSTANCE;
        JSONObject r110 = new JSONObject();
        r110.put("dalvikPss", r15.b());
        r110.put("nativePss", r15.d());
        r110.put("otherPss", r15.e());
        r110.put("totalPss", r15.f());
        r110.put("totalSwappablePss", r15.g());
        r110.put("dmaBufRss", r15.c());
        r110.put("totalPss_with_dmaBufRss", r15.f() + r15.c());
        if (r17 == null) goto L25;
        r110.put("loadModelCount", r17.size());
    L25:
        JSONObject r111 = new JSONObject();
        if (r17 == null) goto L28;
        r111.put("loadModelNames", CollectionsKt.joinToString$default(r17, ",", null, null, 0, null, null, 62, null));
    L29:
        r10.monitorEvent("memory_collect", r11, r110, r111);
        return;
    L28:
        r111.put("loadModelNames", "unknown");
        goto L29
    L13:
        if (r16.booleanValue() == true) goto L16;
        r13 = "no";
        goto L16
    L5:
        if ((!r17.isEmpty()) == false) goto L7;
        r14 = "yes";
        goto L9
    L7:
        r14 = "no";
        goto L9
    }

    @Override // com.obric.aikernel.memory_collect.api.MemoryCollectApi
    public int getCollectorInterval() {
        return RangesKt.coerceAtLeast(AppSettingsManager.INSTANCE.getMemoryCollectSetting().b(), 1);
    }

    @Override // com.obric.aikernel.memory_collect.api.MemoryCollectApi
    public int getStartDelaySeconds() {
        return RangesKt.coerceAtLeast(AppSettingsManager.INSTANCE.getMemoryCollectSetting().a(), 1);
    }

    @Override // com.obric.aikernel.memory_collect.api.MemoryCollectApi
    public void reportMemoryInfo(Boolean r10, Set<String> r11) {
        monitor-enter(this);
        long r12 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L25
        long r13 = r12 - lastReportTime.getSecond().longValue();     // Catch: Throwable -> L25
        int r14 = AppSettingsManager.INSTANCE.getMemoryCollectSetting().b() * 1000;     // Catch: Throwable -> L25
        boolean r15 = true;
        if (r13 <= r14) goto L13;
        if (lastReportTime.getFirst().booleanValue() == true) goto L8;
    L18:
        if (r15 == false) goto L20;
        lastReportTime = new Pair(Boolean.valueOf(Intrinsics.areEqual(r10, Boolean.TRUE)), Long.valueOf(r12));     // Catch: Throwable -> L25
    L20:
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L25
        monitor-exit(this);
        if (r15 == false) goto L30;
        reportMemoryInfo(collectMemoryInfo(), r10, r11);
        return;
    L30:
        return;
    L8:
        if (Intrinsics.areEqual(r10, Boolean.TRUE) == true) goto L18;
        if (r13 > (((double) r14) * 1.5d)) goto L18;
    L17:
        r15 = false;
        goto L18
    L13:
        if (Intrinsics.areEqual(r10, Boolean.TRUE) == false) goto L17;
        if (lastReportTime.getFirst().booleanValue() == true) goto L17;
    L25:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.aikernel.memory_collect.api.MemoryCollectApi
    public void setExternalParamProvider(l7.a r10) {
        externalParamProvider = r10;
    }

    @Override // com.obric.aikernel.memory_collect.api.MemoryCollectApi
    public void start() {
        if (AppUtils.f5573a.e() == false) goto L5;
        collectAndReport();
        return;
    L5:
        AIKLog.INSTANCE.d(TAG, "only collect aikernel memory, cur pkg is " + AppContext.INSTANCE.getContext().getPackageName());
    }
}
