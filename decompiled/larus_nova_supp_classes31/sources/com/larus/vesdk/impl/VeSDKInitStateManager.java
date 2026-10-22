package com.larus.vesdk.impl;

import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class VeSDKInitStateManager {
    public static final VeSDKInitStateManager a = null;
    public static final AtomicBoolean b = null;
    public static final AtomicReference<InitState> c = null;
    public static final CountDownLatch d = null;
    public static final CoroutineScope e = null;
    public static final Lazy f = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/vesdk/impl/VeSDKInitStateManager$InitState;", "", "<init>", "(Ljava/lang/String;I)V", "UNINITIALIZED", "INITIALIZING", "INITIALIZED", "TIMEOUT", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final enum InitState extends Enum<InitState> {
        public static final InitState INITIALIZED = null;
        public static final InitState INITIALIZING = null;
        public static final InitState TIMEOUT = null;
        public static final InitState UNINITIALIZED = null;
        public static final /* synthetic */ InitState[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<InitState> getEntries() {
            return b;
        }

        static {
            InitState r0 = new InitState("UNINITIALIZED", 0);
            UNINITIALIZED = r0;
            InitState r1 = new InitState("INITIALIZING", 1);
            INITIALIZING = r1;
            InitState r3 = new InitState("INITIALIZED", 2);
            INITIALIZED = r3;
            InitState r5 = new InitState("TIMEOUT", 3);
            TIMEOUT = r5;
            InitState[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
        }

        public static InitState[] values() {
            return (InitState[]) a.clone();
        }

        public static InitState valueOf(String r1) {
            return (InitState) r27.a.a(InitState.class, r1);
        }

        public InitState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public VeSDKInitStateManager() {
    }

    static {
        a = new VeSDKInitStateManager();
        b = new AtomicBoolean(false);
        c = new AtomicReference(InitState.UNINITIALIZED);
        d = new CountDownLatch(1);
        e = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        f = LazyKt.lazy(new g());
    }

    public static void a() {
        c.set(InitState.INITIALIZED);
        d.countDown();
        FLogger.a.i("VeSDKInitStateManager", "markInitialized: state changed to INITIALIZED");
    }

    public static void b(long r4, boolean r6, String r7, String r8) {
        JSONObject r2 = new JSONObject();     // Catch: Exception -> L12
        r2.put("duration", r4);     // Catch: Exception -> L12
        if (r6 == false) goto L6;
        int r5 = 1;
    L7:
        r2.put("success", r5);     // Catch: Exception -> L12
        r2.put("type", r8);     // Catch: Exception -> L12
        if (r7 == null) goto L10;
        r2.put("error", r7);     // Catch: Exception -> L12
    L10:
        o.a.reportEvent("flow_vesdk_init_result", r2);     // Catch: Exception -> L12
        FLogger.a.i("VeSDKInitStateManager", "reportInitResult: " + r2);     // Catch: Exception -> L12
        return;
    L6:
        r5 = 0;
    L12:
        e = move-exception;
        FLogger.a.e("VeSDKInitStateManager", "reportInitResult failed", e);
    }
}
