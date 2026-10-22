package com.obric.memorydata.memory;

import android.os.Bundle;
import android.os.SystemClock;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.device.DeviceInfoState;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.settings.AppSettingsManager;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0083\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u001c\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001LB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010#\u001a\u00020$J\u0014\u0010%\u001a\u00020$2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00050'J\u0010\u0010(\u001a\u00020$2\u0006\u0010)\u001a\u00020\u0005H\u0002J\u000e\u0010*\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u0007J9\u0010,\u001a\u00020\n2\u0006\u0010-\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u00072\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020$00H\u0000¢\u0006\u0002\b2J\u0010\u00103\u001a\u00020$2\u0006\u00104\u001a\u000205H\u0002J\u0018\u00106\u001a\u00020$2\u0006\u00107\u001a\u00020\u00132\u0006\u00108\u001a\u000201H\u0002J\u0018\u00109\u001a\u00020$2\u0006\u0010:\u001a\u00020\n2\u0006\u0010)\u001a\u00020\u0005H\u0002J!\u0010;\u001a\u00020\n2\u0006\u0010)\u001a\u00020\u00052\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0002\u0010=J\b\u0010>\u001a\u00020\nH\u0002J\u0006\u0010?\u001a\u00020\nJ\u000e\u0010@\u001a\u00020\n2\u0006\u0010A\u001a\u00020\nJ\u0006\u0010B\u001a\u00020$J2\u0010C\u001a\u00020$2\u0006\u0010D\u001a\u00020E2\u0006\u00104\u001a\u0002052\b\u0010F\u001a\u0004\u0018\u00010\u00052\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020HH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001dR\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0010\u001a\u0004\b \u0010!R\u000e\u0010J\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006M"}, d2 = {"Lcom/obric/memorydata/memory/InAppSignalManager;", "", "<init>", "()V", "TAG", "", "FLUSH_TIMEOUT_MS", "", "SETTINGS_REFRESH_MIN_INTERVAL_MS", "initialized", "", "packageAllowlist", "", "isSupportedDevice", "()Z", "isSupportedDevice$delegate", "Lkotlin/Lazy;", "pendingFlushes", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/obric/memorydata/memory/InAppSignalManager$PendingFlush;", "flushScheduler", "Ljava/util/concurrent/ScheduledThreadPoolExecutor;", "settingsRefreshController", "Lcom/obric/memorydata/memory/InAppSignalSettingsRefreshController;", "getSettingsRefreshController", "()Lcom/obric/memorydata/memory/InAppSignalSettingsRefreshController;", "settingsRefreshController$delegate", "callback", "com/obric/memorydata/memory/InAppSignalManager$callback$1", "Lcom/obric/memorydata/memory/InAppSignalManager$callback$1;", "registrationController", "Lcom/obric/memorydata/memory/InAppSignalRegistrationController;", "getRegistrationController", "()Lcom/obric/memorydata/memory/InAppSignalRegistrationController;", "registrationController$delegate", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "updatePackageAllowlist", "packageNames", "", "requestSettingsRefresh", InfoRequestQPSOptTraceLogger.REASON, "requestFlush", "screenshotTimestamp", "bindFlushToObservation", "requestId", "observationId", "onComplete", "Lkotlin/Function1;", "Lcom/obric/memorydata/memory/InAppSignalFlushCompletion;", "bindFlushToObservation$memory_obricRelease", "completeFlush", "extras", "Landroid/os/Bundle;", "resolveFlush", "pending", "completion", "refreshRegistration", "reviewEnabled", "sendCollectionPolicy", "enabledOverride", "(Ljava/lang/String;Ljava/lang/Boolean;)Z", "shouldPersist", "isDebugTraceCollectionEnabled", "setDebugTraceCollectionEnabled", "enabled", "flushTraceForDebug", "logBatch", "processed", "Lcom/obric/memorydata/memory/InAppSignalProcessedBatch;", "encoding", "compressedBytes", "", "originalBytes", "FLUSH_CONTEXT_TTL_MS", "KEY_DEBUG_TRACE_COLLECTION_ENABLED", "PendingFlush", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f10230a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f10231b;
    private static volatile List<String> c;
    private static final Lazy d = null;
    private static final ConcurrentHashMap<String, a> e = null;
    private static final ScheduledThreadPoolExecutor f = null;
    private static final Lazy g = null;
    private static final InAppSignalManager$callback$1 h = null;
    private static final Lazy i = null;

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b$\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\t\u0010+\u001a\u00020\u0005HÆ\u0003J\u000f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00030\bHÆ\u0003J\t\u0010-\u001a\u00020\u0005HÆ\u0003J\u0017\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bHÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u00100\u001a\u00020\u0010HÆ\u0003Jo\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\b\b\u0002\u0010\t\u001a\u00020\u00052\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u000f\u001a\u00020\u0010HÆ\u0001J\u0013\u00102\u001a\u00020\u00102\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u000205HÖ\u0001J\t\u00106\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u001cR(\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u00067"}, d2 = {"Lcom/obric/memorydata/memory/InAppSignalManager$PendingFlush;", "", "requestId", "", "screenshotTimestamp", "", "startedElapsedMs", "allowlist", "", "observationId", "onComplete", "Lkotlin/Function1;", "Lcom/obric/memorydata/memory/InAppSignalFlushCompletion;", "", "completion", "delivered", "", "<init>", "(Ljava/lang/String;JJLjava/util/List;JLkotlin/jvm/functions/Function1;Lcom/obric/memorydata/memory/InAppSignalFlushCompletion;Z)V", "getRequestId", "()Ljava/lang/String;", "getScreenshotTimestamp", "()J", "getStartedElapsedMs", "getAllowlist", "()Ljava/util/List;", "getObservationId", "setObservationId", "(J)V", "getOnComplete", "()Lkotlin/jvm/functions/Function1;", "setOnComplete", "(Lkotlin/jvm/functions/Function1;)V", "getCompletion", "()Lcom/obric/memorydata/memory/InAppSignalFlushCompletion;", "setCompletion", "(Lcom/obric/memorydata/memory/InAppSignalFlushCompletion;)V", "getDelivered", "()Z", "setDelivered", "(Z)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f10232a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f10233b;
        private final long c;
        private final List<String> d;
        private long e;
        private Function1<? super j, Unit> f;
        private j g;
        private boolean h;

        public a(String r3, long r4, long r6, List<String> r8, long r9, Function1<? super j, Unit> r11, j r12, boolean r13) {
            List<String> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
            Function1<? super j, Unit> r14 = (Function1) ZeusTransformUtils.wrapperContextForParams(r11, Function1.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "requestId");
            Intrinsics.checkNotNullParameter(r10, "allowlist");
            this.f10232a = r3;
            this.f10233b = r4;
            this.c = r6;
            this.d = r10;
            this.e = r9;
            this.f = r14;
            this.g = r12;
            this.h = r13;
        }

        public /* synthetic */ a(String r16, long r17, long r19, List r21, long r22, Function1 r24, j r25, boolean r26, int r27, DefaultConstructorMarker r28) {
            List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r21, List.class, "com.obric.memorydata.plugin");
            Function1 r1 = (Function1) ZeusTransformUtils.wrapperContextForParams(r24, Function1.class, "com.obric.memorydata.plugin");
            if ((r27 & 16) == 0) goto L5;
            long r10 = 0;
        L7:
            if ((r27 & 32) == 0) goto L9;
            Function1 r12 = null;
        L11:
            if ((r27 & 64) == 0) goto L13;
            j r13 = null;
        L15:
            if ((r27 & 128) == 0) goto L17;
            boolean r14 = false;
        L18:
            this(r16, r17, r19, r9, r10, r12, r13, r14);
            return;
        L17:
            r14 = r26;
            goto L18
        L13:
            r13 = r25;
            goto L15
        L9:
            r12 = r1;
            goto L11
        L5:
            r10 = r22;
            goto L7
        }

        public final String a() {
            return this.f10232a;
        }

        public final void a(long r1) {
            this.e = r1;
        }

        public final void a(j r1) {
            this.g = r1;
        }

        public final void a(Function1<? super j, Unit> r3) {
            this.f = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        }

        public final void a(boolean r1) {
            this.h = r1;
        }

        public final long b() {
            return this.f10233b;
        }

        public final long c() {
            return this.c;
        }

        public final List<String> d() {
            return this.d;
        }

        public final long e() {
            return this.e;
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, a.class) == true) goto L8;
            return false;
        L8:
            a r10 = (a) ZeusTransformUtils.preCheckCast(r9, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f10232a, r10.f10232a) == true) goto L12;
            return false;
        L12:
            if (this.f10233b == r10.f10233b) goto L15;
            return false;
        L15:
            if (this.c == r10.c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r10.d) == true) goto L21;
            return false;
        L21:
            if (this.e == r10.e) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r10.f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r10.g) == true) goto L30;
            return false;
        L30:
            if (this.h == r10.h) goto L32;
            return false;
        L32:
            return true;
        }

        public final Function1<j, Unit> f() {
            return this.f;
        }

        public final j g() {
            return this.g;
        }

        public final boolean h() {
            return this.h;
        }

        public int hashCode() {
            int r0 = ((((((((this.f10232a.hashCode() * 31) + Long.hashCode(this.f10233b)) * 31) + Long.hashCode(this.c)) * 31) + this.d.hashCode()) * 31) + Long.hashCode(this.e)) * 31;
            Function1<? super j, Unit> r1 = this.f;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            j r5 = this.g;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return ((r4 + r2) * 31) + Boolean.hashCode(this.h);
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "PendingFlush(requestId=" + this.f10232a + ", screenshotTimestamp=" + this.f10233b + ", startedElapsedMs=" + this.c + ", allowlist=" + this.d + ", observationId=" + this.e + ", onComplete=" + this.f + ", completion=" + this.g + ", delivered=" + this.h + ')';
        }
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [com.obric.memorydata.memory.InAppSignalManager$callback$1] */
    static {
        f10230a = new k();
        c = CollectionsKt.emptyList();
        d = LazyKt.lazy($$Lambda$k$sfBvrmrCxcc9IljdA5stSlVYsIw.INSTANCE);
        e = new ConcurrentHashMap();
        ScheduledThreadPoolExecutor r0 = new ScheduledThreadPoolExecutor(1, $$Lambda$k$gZHqeBbL6XcveGGVGLyHF_LJlms.INSTANCE);
        r0.setRemoveOnCancelPolicy(true);
        f = r0;
        g = LazyKt.lazy($$Lambda$k$qmrsn5IFaJfXmCeJep5lPXLLSc.INSTANCE);
        h = new InAppSignalManager$callback$1();
        i = LazyKt.lazy($$Lambda$k$5yNiqQ6jfuhG8wyj5NfQe0vwk.INSTANCE);
    }

    private k() {
    }

    private static final Thread a(Runnable r2) {
        return new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin"), "in_app_signal_flush_timeout");
    }

    private static final Unit a(boolean r7, boolean r8) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "InAppSignalManager", "trace collect gate changed: " + r7 + " -> " + r8, false, 4, null);
        f10230a.a(com.obric.memorydata.database.c.b.f8850a.a(), "trace_collect_setting_changed");
        return Unit.INSTANCE;
    }

    private final void a(Bundle r13) {
        String r0 = r13.getString(ObricMemoryConstants.KEY_IN_APP_SIGNAL_REQUEST_ID);
        String r1 = "";
        if (r0 != null) goto L5;
        String r3 = "";
    L7:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L10;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "InAppSignalManager", "ignore flush completion without requestId", null, 4, null);
        return;
    L10:
        a r2 = (a) ZeusTransformUtils.preCheckCast(e.get(r3), a.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L14;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "InAppSignalManager", "ignore stale or duplicate flush completion, requestId=" + r3, null, 4, null);
        return;
    L14:
        String r4 = r13.getString(ObricMemoryConstants.KEY_IN_APP_SIGNAL_FLUSH_RESULT);
        if (r4 == null) goto L18;
        r1 = r4;
    L18:
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r5) == false) goto L21;
        r5 = "failed";
    L21:
        String r8 = (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.memorydata.plugin");
        long r9 = r13.getLong(ObricMemoryConstants.KEY_IN_APP_SIGNAL_WATERMARK_EVENT_TIME_MS, 0);
        RunLog.INSTANCE.info("InAppSignalManager", "flush completed, requestId=" + r3 + " observationId=" + r2.e() + " result=" + r8 + " watermark=" + r9 + " elapsedMs=" + (SystemClock.elapsedRealtime() - r2.c()), Intrinsics.areEqual(r8, "ok"));
        a(r2, new j(r3, r2.e(), r2.b(), r8, r9, true));
        return;
    L5:
        r3 = r0;
        goto L7
    }

    private final void a(a r17, j r18) {
        monitor-enter(r17);
    L33:
        th = move-exception;
        throw th;
    L5:
        if (r17.h() == false) goto L8;
        monitor-exit(r17);
        return;
    L8:
        j r0 = r17.g();     // Catch: Throwable -> L33
        if (r0 != null) goto L11;
    L14:
        r17.a(r18);     // Catch: Throwable -> L33
    L15:
        Function1<j, Unit> r2 = null;
        j r3 = null;
        if (r17.e() > 0) goto L18;
    L23:
        j r1 = null;
    L24:
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L33
        monitor-exit(r17);
        if (r2 == null) goto L30;
        if (r1 == null) goto L30;
        e.remove(r17.a(), r17);
        r2.invoke(r1);
        return;
    L30:
        if (Intrinsics.areEqual(r18.d(), LocationMonitorConst.TIMEOUT) == false) goto L39;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "InAppSignalManager", "flush timeout pending observation bind, requestId=" + r17.a() + " elapsedMs=" + (SystemClock.elapsedRealtime() - r17.c()) + " allowlist=" + r17.d(), null, 4, null);
        return;
    L39:
        return;
    L18:
        if (r17.f() == null) goto L23;
        r17.a(true);     // Catch: Throwable -> L33
        Function1<j, Unit> r5 = r17.f();     // Catch: Throwable -> L33
        j r6 = r17.g();     // Catch: Throwable -> L33
        if (r6 == null) goto L22;
        r3 = j.a(r6, null, r17.e(), 0, null, 0, false, 61, null);     // Catch: Throwable -> L33
    L22:
        j r15 = r3;
        r2 = r5;
        r1 = r15;
        goto L24
    L11:
        if (Intrinsics.areEqual(r0.d(), LocationMonitorConst.TIMEOUT) == false) goto L15;
        if (Intrinsics.areEqual(r18.d(), LocationMonitorConst.TIMEOUT) == true) goto L15;
        goto L14
    }

    private static final void a(a r12, String r13, long r14) {
        f10230a.a(r12, new j(r13, 0, r14, LocationMonitorConst.TIMEOUT, 0, false));
    }

    public static final /* synthetic */ void a(k r0, Bundle r1) {
        r0.a(r1);
    }

    public static final /* synthetic */ void a(k r0, n r1, Bundle r2, String r3, int r4, int r5) {
        r0.a(r1, r2, r3, r4, r5);
    }

    private final void a(n r10, Bundle r11, String r12, int r13, int r14) {
        long r0 = r11.getLong(ObricMemoryConstants.KEY_IN_APP_SIGNALS_NEWEST_SIGNAL_UPTIME_MS, 0);
        IRunLog r3 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r9 = new StringBuilder().append("receive in-app signals, source=").append(r10.b()).append(", kept=").append(r10.c()).append(", filtered=").append(r10.d()).append(", duplicate=").append(r10.e()).append(", chars=").append(r10.a().length()).append(", encoding=");
        if (r12 != null) goto L5;
        r12 = "";
    L5:
        IRunLog.a.a(r3, "InAppSignalManager", r9.append(r12).append(", compressedBytes=").append(r13).append(", originalBytes=").append(r14).append(", newestSignalUptimeMs=").append(r0).append(", eventTypes=").append(r10.f()).toString(), false, 4, null);
        if (AppContext.INSTANCE.isDebug() == true) goto L8;
        return;
    L8:
        if (r10.c() <= 0) goto L12;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "InAppSignalManager", "in-app signals json: " + r10.a(), false, 4, null);
        return;
    }

    private final void a(String r8) {
        if (c.isEmpty() == false) goto L5;
        return;
    L5:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "InAppSignalManager", "settings refresh reason=" + r8 + " requested=" + d().a(r8), false, 4, null);
    }

    private static final void a(String r6, a r7) {
        if (e.remove(r6, r7) == false) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "InAppSignalManager", "discard unbound flush context, requestId=" + r6, null, 4, null);
        return;
    }

    private final void a(boolean r11, String r12) {
        if (c() == true) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "InAppSignalManager", "skip callback registration, reason=" + r12 + " deviceModel=" + DeviceInfoState.INSTANCE.getDeviceModel(), false, 4, null);
        return;
    L6:
        boolean r0 = q.f10368a.a();
        boolean r2 = b();
        if (r0 == false) goto L13;
        if (r11 == false) goto L10;
    L12:
        boolean r4 = true;
    L14:
        if (r4 == true) goto L16;
        a("callback_disabled:" + r12, false);
    L16:
        boolean r3 = e().a(r11, r0);
        if (r3 == false) goto L19;
        a(this, "callback_registered:" + r12, null, 2, null);
    L20:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "InAppSignalManager", "refresh callback, reason=" + r12 + " debug=" + AppContext.INSTANCE.isDebug() + " reviewEnabled=" + r11 + " traceCollectEnabled=" + r0 + " debugCollectionEnabled=" + r2 + " registered=" + r3, false, 4, null);
        return;
    L19:
        com.obric.memorydata.memory.inapptrace.d.f10164a.a();
        goto L20
    L10:
        if (AppContext.INSTANCE.isDebug() == false) goto L13;
        if (r2 == true) goto L12;
    L13:
        r4 = false;
        goto L14
    }

    public static final /* synthetic */ boolean a(k r0) {
        return r0.f();
    }

    static /* synthetic */ boolean a(k r0, String r1, Boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return r0.a(r1, r2);
    }

    private final boolean a(String r7, Boolean r8) {
        List<String> r6 = c;
        if (r8 == null) goto L6;
        boolean r9 = r8.booleanValue();
    L9:
        com.obric.memorydata.utils.c.c r1 = com.obric.memorydata.utils.c.c.f13202a;
        Bundle r3 = new Bundle();
        r3.putBoolean(ObricMemoryConstants.KEY_IN_APP_SIGNAL_ENABLED, r9);
        r3.putStringArrayList(ObricMemoryConstants.KEY_IN_APP_SIGNAL_PACKAGE_ALLOWLIST, new ArrayList((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin")));
        Unit r0 = Unit.INSTANCE;
        boolean r2 = r1.a(2, r3);
        RunLog.INSTANCE.info("InAppSignalManager", "send in-app signal policy, reason=" + r7 + " enabled=" + r9 + " allowlist=" + r6 + " accepted=" + r2, r2);
        return r2;
    L6:
        if (((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == true) goto L8;
        r9 = true;
        goto L9
    L8:
        r9 = false;
        goto L9
    }

    private static final Unit b(boolean r7, boolean r8) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "InAppSignalManager", "review gate changed: " + r7 + " -> " + r8, false, 4, null);
        f10230a.a(r8, "review_gate_changed");
        return Unit.INSTANCE;
    }

    private final boolean c() {
        return ((Boolean) ZeusTransformUtils.preCheckCast(d.getValue(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    private final r d() {
        return (r) ZeusTransformUtils.preCheckCast(g.getValue(), r.class, "com.obric.memorydata.plugin");
    }

    private final o e() {
        return (o) ZeusTransformUtils.preCheckCast(i.getValue(), o.class, "com.obric.memorydata.plugin");
    }

    private final boolean f() {
        return h.f10145a.a(AppContext.INSTANCE.isDebug(), com.obric.memorydata.database.c.b.f8850a.a(), b());
    }

    private static final boolean g() {
        return com.obric.memorydata.utils.b.a(DeviceInfoState.INSTANCE.getDeviceModel());
    }

    private static final Unit h() {
        if (AppSettingsManager.INSTANCE.requestUpdate() == false) goto L7;
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("settings update was not requested".toString());
    }

    private static final r i() {
        return new r(60000, (Function0) ZeusTransformUtils.preCheckCast(InAppSignalManager$settingsRefreshController$2$1.INSTANCE, Function0.class, "com.obric.memorydata.plugin"), $$Lambda$k$94lPLk4q9Ix6wX7T5BOOcgeWXMI.INSTANCE);
    }

    private static final boolean j() {
        return com.obric.memorydata.utils.c.c.f13202a.a(2, (com.obric.memorydata.utils.c.c.a) ZeusTransformUtils.preCheckCast(h, com.obric.memorydata.utils.c.c.a.class, "com.obric.memorydata.plugin"));
    }

    private static final boolean k() {
        return com.obric.memorydata.utils.c.c.f13202a.a(2);
    }

    private static final o l() {
        boolean r0 = AppContext.INSTANCE.isDebug();
        KFunction r1 = (KFunction) ZeusTransformUtils.preCheckCast(new InAppSignalManager$registrationController$2$1(f10230a), KFunction.class, "com.obric.memorydata.plugin");
        return new o(r0, $$Lambda$k$EhElCtW9qfQut9ZA6FgEnoFfmlw.INSTANCE, $$Lambda$k$8Ttc3o9XWN17qVaoD6cxSgUuvMk.INSTANCE, (Function0) ZeusTransformUtils.preCheckCast(r1, Function0.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: lambda$1DZhysPapcnkbg-2PtRYIEbSBBc, reason: not valid java name */
    public static /* synthetic */ void m722lambda$1DZhysPapcnkbg2PtRYIEbSBBc(a r0, String r1, long r2) {
        a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$5yN-iqQ6j-fuhG8wyj5NfQe0vwk, reason: not valid java name */
    public static /* synthetic */ o m723lambda$5yNiqQ6jfuhG8wyj5NfQe0vwk() {
        return l();
    }

    public static /* synthetic */ boolean lambda$8Ttc3o9XWN17qVaoD6cxSgUuvMk() {
        return k();
    }

    public static /* synthetic */ Unit lambda$94lPLk4q9Ix6wX7T5BOOcgeWXMI() {
        return h();
    }

    public static /* synthetic */ boolean lambda$EhElCtW9qfQut9ZA6FgEnoFfmlw() {
        return j();
    }

    /* JADX INFO: renamed from: lambda$GjJQDstJ_5CWRVBp4Zk--uFw8cY, reason: not valid java name */
    public static /* synthetic */ Unit m724lambda$GjJQDstJ_5CWRVBp4ZkuFw8cY(boolean r0, boolean r1) {
        return b(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$N-mXVFCeYUu6Sx_D5QQXWX_QaFk, reason: not valid java name */
    public static /* synthetic */ void m725lambda$NmXVFCeYUu6Sx_D5QQXWX_QaFk(String r0, a r1) {
        a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$ba-xQ9nP8a3qGTmLxlzbZS6ZRMk, reason: not valid java name */
    public static /* synthetic */ Unit m726lambda$baxQ9nP8a3qGTmLxlzbZS6ZRMk(boolean r0, boolean r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ Thread lambda$gZHqeBbL6XcveGGVGLyHF_LJlms(Runnable r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$qmrsn5IFaJfXmCe-Jep5lPXLLSc, reason: not valid java name */
    public static /* synthetic */ r m727lambda$qmrsn5IFaJfXmCeJep5lPXLLSc() {
        return i();
    }

    public static /* synthetic */ boolean lambda$sfBvrmrCxcc9IljdA5stSlVYsIw() {
        return g();
    }

    public final String a(final long r23) {
        if (r23 > 0) goto L6;
        return "";
    L6:
        if (c() == true) goto L10;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "InAppSignalManager", "skip flush, in-app signal collection is unsupported on this device", null, 4, null);
        return "";
    L10:
        if (e().a() == true) goto L13;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "InAppSignalManager", "skip flush, callback is not registered", null, 4, null);
        return "";
    L13:
        final String r12 = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(r12, "toString(...)");
        final a r11 = new a(r12, r23, SystemClock.elapsedRealtime(), c, 0, null, null, false, 240, null);
        ConcurrentHashMap<String, a> r0 = e;
        ((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.memorydata.plugin")).put(r12, r11);
        com.obric.memorydata.utils.c.c r1 = com.obric.memorydata.utils.c.c.f13202a;
        Bundle r5 = new Bundle();
        r5.putString(ObricMemoryConstants.KEY_IN_APP_SIGNAL_ACTION, ObricMemoryConstants.VALUE_IN_APP_SIGNAL_ACTION_FLUSH);
        r5.putString(ObricMemoryConstants.KEY_IN_APP_SIGNAL_REQUEST_ID, r12);
        Unit r6 = Unit.INSTANCE;
        if (r1.a(2, r5) == true) goto L17;
        r0.remove(r12);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "InAppSignalManager", "flush request rejected, requestId=" + r12, null, 4, null);
        return "";
    L17:
        ScheduledThreadPoolExecutor r2 = f;
        r2.schedule(new $$Lambda$k$1DZhysPapcnkbg2PtRYIEbSBBc(r11, r12, r23), 3000, TimeUnit.MILLISECONDS);
        r2.schedule(new $$Lambda$k$NmXVFCeYUu6Sx_D5QQXWX_QaFk(r12, r11), 30000, TimeUnit.MILLISECONDS);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "InAppSignalManager", "flush requested, requestId=" + r12 + " screenshotTimestamp=" + r23 + " allowlist=" + r11.d(), false, 4, null);
        return r12;
    }

    public final synchronized void a() {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (f10231b == false) goto L9;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "InAppSignalManager", "init ignored, already initialized", false, 4, null);     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L9:
        f10231b = true;     // Catch: Throwable -> L17
        if (c() == true) goto L14;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "InAppSignalManager", "skip init, in-app signal collection only supports Pacific, deviceModel=" + DeviceInfoState.INSTANCE.getDeviceModel(), false, 4, null);     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L14:
        q.f10368a.a($$Lambda$k$baxQ9nP8a3qGTmLxlzbZS6ZRMk.INSTANCE);     // Catch: Throwable -> L17
        com.obric.memorydata.database.c.b.f8850a.a($$Lambda$k$GjJQDstJ_5CWRVBp4ZkuFw8cY.INSTANCE);     // Catch: Throwable -> L17
        a(com.obric.memorydata.database.c.b.f8850a.a(), CommonConsts.APM_INNER_EVENT_COST_INIT);     // Catch: Throwable -> L17
        monitor-exit(this);
    }

    public final void a(Collection<String> r9) {
        Collection r10 = (Collection) ZeusTransformUtils.wrapperContextForParams(r9, Collection.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "packageNames");
        if (c() == true) goto L5;
        return;
    L5:
        List<String> r11 = SequencesKt.toList(SequencesKt.sorted(SequencesKt.distinct(SequencesKt.filter(SequencesKt.map(CollectionsKt.asSequence((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin")), (Function1) ZeusTransformUtils.preCheckCast(InAppSignalManager$updatePackageAllowlist$normalized$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin")), (Function1) ZeusTransformUtils.preCheckCast(InAppSignalManager$updatePackageAllowlist$normalized$2.INSTANCE, Function1.class, "com.obric.memorydata.plugin")))));
        if (Intrinsics.areEqual(r11, c) == false) goto L8;
        return;
    L8:
        c = r11;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "InAppSignalManager", "in-app signal allowlist changed, count=" + r11.size() + ", packages=" + r11, false, 4, null);
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r11, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L12;
        a("allowlist_update");
    L12:
        if (e().a() == false) goto L15;
        a(this, "allowlist_changed", null, 2, null);
        return;
    }

    public final boolean a(String r23, long r24, long r26, Function1<? super j, Unit> r28) {
        Function1<? super j, Unit> r15 = (Function1) ZeusTransformUtils.wrapperContextForParams(r28, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r23, "requestId");
        Intrinsics.checkNotNullParameter(r15, "onComplete");
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r23, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L5;
    L38:
        return false;
    L5:
        if (r24 <= 0) goto L38;
        ConcurrentHashMap<String, a> r12 = e;
        a r11 = (a) ZeusTransformUtils.preCheckCast(r12.get(r23), a.class, "com.obric.memorydata.plugin");
        if (r11 != null) goto L10;
        return false;
    L10:
        j r1 = null;
        monitor-enter(r11);
    L34:
        th = th;
        a r2 = r11;
    L36:
        monitor-exit(r2);
        throw th;
    L13:
        if (r11.h() == false) goto L16;
        monitor-exit(r11);
        return false;
    L16:
        r11.a(r24);     // Catch: Throwable -> L34
        r11.a(r15);     // Catch: Throwable -> L34
        j r3 = r11.g();     // Catch: Throwable -> L34
        if (r3 == null) goto L24;
        r11.a(true);     // Catch: Throwable -> L34
        r1 = j.a(r3, null, r24, r26, null, 0, false, 57, null);     // Catch: Throwable -> L22
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L22
        a r5 = r11;
    L25:
        monitor-exit(r5);
        if (r1 == null) goto L28;
        r12.remove(r23, r5);
        r15.invoke(r1);
    L28:
        IRunLog r6 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = new StringBuilder().append("bind flush to observation, requestId=").append(r23).append(" observationId=").append(r24).append(" completionReady=");
        if (r1 == null) goto L31;
        boolean r7 = true;
    L32:
        IRunLog.a.a(r6, "InAppSignalManager", r0.append(r7).toString(), false, 4, null);
        return r10;
    L31:
        r7 = false;
    L22:
        th = th;
        r2 = r11;
        goto L36
    L24:
        r5 = r11;
        goto L25
    }

    public final boolean b() {
        if (AppContext.INSTANCE.isDebug() == true) goto L5;
        return false;
    L5:
        if (IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getBoolean("in_app_signal_debug_trace_collection_enabled", false) == false) goto L9;
        return true;
    L9:
        return false;
    }
}
