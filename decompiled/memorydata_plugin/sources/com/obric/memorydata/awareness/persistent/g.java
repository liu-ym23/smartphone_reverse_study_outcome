package com.obric.memorydata.awareness.persistent;

import android.content.Context;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.capabilitykit.common.Ext;
import com.obric.memorydata.awareness.api.AwarenessManager;
import com.obric.memorydata.middleware.api.bdtracker.Tracker;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.sdk.MemoryResponse;
import com.obric.memorydata.sdk.awareness.AwarenessConditionConfig;
import com.obric.memorydata.sdk.awareness.EventNames;
import com.obric.memorydata.sdk.awareness.GeoFenceRequest;
import com.obric.memorydata.utils.threadpool.ThreadPoolContainer;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000{\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0015\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0016\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\tJ\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\tJ\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u000fJ$\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0005J\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u0005J\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010&\u001a\u00020'2\u0006\u0010\"\u001a\u00020\u0005J\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010)\u001a\u00020\u0005J\u0010\u0010*\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\tH\u0002J\b\u0010+\u001a\u00020\u0019H\u0002J\u001e\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000f0-2\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0005H\u0002J\u0016\u0010.\u001a\b\u0012\u0004\u0012\u00020\u000f0-2\u0006\u0010\"\u001a\u00020\u0005H\u0002J \u0010/\u001a\b\u0012\u0004\u0012\u00020\u000f0-2\u0006\u0010\"\u001a\u00020\u00052\b\u0010#\u001a\u0004\u0018\u00010\u0005H\u0002J\u001e\u00100\u001a\b\u0012\u0004\u0012\u00020\u000f0-2\u0006\u00101\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u0005H\u0002J\u0018\u00103\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u0005H\u0002J\u0010\u00104\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u000fH\u0002J.\u00105\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u000f0-2\u0006\u0010\"\u001a\u00020\u00052\b\u0010#\u001a\u0004\u0018\u00010\u0005H\u0002J\u0016\u00107\u001a\u00020\u001c2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u000f0-H\u0002J\u0010\u00108\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u000fH\u0002J\u0018\u00109\u001a\u00020\u001c2\u0006\u0010:\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u000fH\u0002J\u0010\u0010<\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u000fH\u0002J\u0010\u0010=\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u000fH\u0002J<\u0010>\u001a\u00020\u001c2\u0006\u0010?\u001a\u00020\u00052\b\u0010@\u001a\u0004\u0018\u00010\u00012\b\u0010A\u001a\u0004\u0018\u00010\u00012\u0016\u0010B\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010CH\u0002J(\u0010D\u001a\u00020\u001c2\u0006\u0010E\u001a\u00020\u00052\u0016\u0010B\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010CH\u0002J<\u0010F\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u000f2\b\u0010@\u001a\u0004\u0018\u00010\u00012\b\u0010A\u001a\u0004\u0018\u00010\u00012\u0016\u0010B\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010CH\u0002J0\u0010G\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010E\u001a\u00020\u00052\u0016\u0010B\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010CH\u0002J\u0018\u0010H\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020\u000f2\u0006\u0010J\u001a\u00020\u000fH\u0002J0\u0010K\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010E\u001a\u00020\u00052\u0016\u0010B\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010CH\u0002J\u001a\u0010L\u001a\u0004\u0018\u00010M2\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010N\u001a\u00020\u0005H\u0002J\b\u0010O\u001a\u00020\u001cH\u0002J\b\u0010P\u001a\u00020\u001cH\u0002J\u0014\u0010Q\u001a\u00020\u0019*\u00020\u000f2\u0006\u0010R\u001a\u00020\u000fH\u0002J\f\u0010S\u001a\u00020\u0005*\u00020\u000fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R \u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00110\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017¨\u0006T"}, d2 = {"Lcom/obric/memorydata/awareness/persistent/PersistentAwarenessRuntime;", "", "<init>", "()V", "TAG", "", "started", "Ljava/util/concurrent/atomic/AtomicBoolean;", "appContext", "Landroid/content/Context;", "store", "Lcom/obric/memorydata/awareness/persistent/PersistentAwarenessSubscriptionStore;", "subscriptionsByTarget", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/obric/memorydata/awareness/persistent/PersistentAwarenessSubscription;", "awarenessListeners", "Lcom/obric/memorydata/awareness/api/EventListener;", "dailyReportRegistered", "startLock", "runtimeLock", "dailyReportCallback", "com/obric/memorydata/awareness/persistent/PersistentAwarenessRuntime$dailyReportCallback$1", "Lcom/obric/memorydata/awareness/persistent/PersistentAwarenessRuntime$dailyReportCallback$1;", CommonConsts.APM_INNER_EVENT_COST_START, "", "context", "startAsync", "", "register", "Lcom/obric/memorydata/sdk/MemoryResponse;", "Ljava/lang/Void;", "entity", "unregister", "ownerPackage", "subscriptionId", "clearOwner", "addGeoFence", Ext.KEY_REQUEST, "Lcom/obric/memorydata/sdk/awareness/GeoFenceRequest;", "removeGeoFence", "fenceId", "ensureStarted", "restoreFromStore", "listSubscriptionsForDelete", "", "listOwnerSubscriptionsForDelete", "findRuntimeSubscriptions", "subscriptionsForTarget", "targetType", "targetName", "buildTargetKey", "addRuntimeSubscription", "cleanupRuntimeSubscriptionsAfterDbDelete", "entities", "removeRuntimeSubscriptions", "removeRuntimeSubscription", "releaseTargetRuntimeState", "targetKey", "sampleEntity", "ensureAwarenessListener", "releaseAwarenessListenerIfNeeded", "handleFeatureEvent", "feature", "oldValue", "newValue", WsConstants.KEY_EXTRA, "", "handleContextEvent", "eventName", "callbackFeature", "callbackEvent", "replaceRuntimeSubscription", "oldEntity", "newEntity", "reportGeoFenceChangedIfNeeded", "parseConditionOrNull", "Lcom/obric/memorydata/sdk/awareness/AwarenessConditionConfig;", "callbackType", "registerDailyReportCallbackIfNeeded", "reportDailySubscriptions", "hasSameIdentity", "other", "identityKey", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f8772a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicBoolean f8773b = null;
    private static Context c;
    private static i d;
    private static final ConcurrentHashMap<String, CopyOnWriteArrayList<h>> e = null;
    private static final ConcurrentHashMap<String, com.obric.memorydata.awareness.api.a> f = null;
    private static final AtomicBoolean g = null;
    private static final Object h = null;
    private static final Object i = null;
    private static final a j = null;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/obric/memorydata/awareness/persistent/PersistentAwarenessRuntime$dailyReportCallback$1", "Lcom/obric/memorydata/middleware/api/bdtracker/DailyReportCallback;", "onDailyReport", "", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements com.obric.memorydata.middleware.api.bdtracker.a {
        a() {
        }

        @Override // com.obric.memorydata.middleware.api.bdtracker.a
        public void a() {
            g.a(g.f8772a);
        }
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tH\u0016J<\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\n2\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tH\u0016J<\u0010\u000f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\n2\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tH\u0016¨\u0006\u0010"}, d2 = {"com/obric/memorydata/awareness/persistent/PersistentAwarenessRuntime$ensureAwarenessListener$1$listener$1", "Lcom/obric/memorydata/awareness/api/EventListener;", "observable", "", "onEvent", "", "eventName", "", WsConstants.KEY_EXTRA, "", "", "onFeatureChanged", "feature", "oldValue", "newValue", "onFeatureEvent", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements com.obric.memorydata.awareness.api.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ h f8774a;

        b(h r1) {
            this.f8774a = r1;
        }

        @Override // com.obric.memorydata.awareness.api.a
        public void a(String r1, Object r2, Object r3, Map<String, ? extends Object> r4) {
            Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r1, "feature");
        }

        @Override // com.obric.memorydata.awareness.api.a
        public void a(String r3, Map<String, ? extends Object> r4) {
            Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "eventName");
            if (Intrinsics.areEqual(this.f8774a.c(), "event") == false) goto L6;
            g.a(g.f8772a, r3, r5);
            return;
        }

        @Override // com.obric.memorydata.awareness.api.a
        public boolean a() {
            return true;
        }

        @Override // com.obric.memorydata.awareness.api.a
        public void b(String r3, Object r4, Object r5, Map<String, ? extends Object> r6) {
            Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "feature");
            if (Intrinsics.areEqual(this.f8774a.c(), "feature") == false) goto L6;
            g.a(g.f8772a, r3, r4, r5, r7);
            return;
        }
    }

    static {
        f8772a = new g();
        f8773b = new AtomicBoolean(false);
        e = new ConcurrentHashMap();
        f = new ConcurrentHashMap();
        g = new AtomicBoolean(false);
        h = new Object();
        i = new Object();
        j = new a();
    }

    private g() {
    }

    private final MemoryResponse<Void> a(List<h> r7, String r8, String r9) {
        List<h> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        ((g) ZeusTransformUtils.preCheckCast(this, g.class, "com.obric.memorydata.plugin")).a(r10);     // Catch: Throwable -> L5
        Object r6 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L8:
        if (Result.m1427isFailureimpl(r6) == false) goto L15;
        RunLog r11 = RunLog.INSTANCE;
        String r12 = "cleanup runtime subscriptions after db delete failed owner=" + r8 + " subscriptionId=" + r9;
        Throwable r13 = Result.m1424exceptionOrNullimpl(r6);
        if (r13 != null) goto L12;
        r13 = new Throwable("unknown cleanup failure");
    L12:
        r11.error("PersistentAwarenessRuntime", r12, r13);
        return new MemoryResponse(400, "cleanup persistent runtime subscriptions failed", null, 4, null);
    L15:
        return MemoryResponse.CREATOR.a();
    L5:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r6 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    private final AwarenessConditionConfig a(h r8, String r9) {
        AwarenessConditionConfig r7 = f.f8771a.a(r8.e());
        if (r7 != null) goto L5;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PersistentAwarenessRuntime", "ignore persistent " + r9 + " callback invalid condition " + r8.i() + " conditionLength=" + r8.e().length(), null, 4, null);
    L5:
        return r7;
    }

    private final List<h> a(String r7, String r8) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L8
        g r2 = (g) ZeusTransformUtils.preCheckCast(this, g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        i r3 = d;     // Catch: Throwable -> L8
        if (r3 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("store");     // Catch: Throwable -> L8
        r3 = null;
    L6:
        Object r4 = Result.m1421constructorimpl(r3.a(r7, r8));     // Catch: Throwable -> L8
    L10:
        Throwable r5 = Result.m1424exceptionOrNullimpl(r4);
        if (r5 == null) goto L13;
        RunLog.INSTANCE.warn("PersistentAwarenessRuntime", "list persistent subscription before delete failed owner=" + r7 + " subscriptionId=" + r8, r5);
    L13:
        List r6 = CollectionsKt.emptyList();
        if (Result.m1427isFailureimpl(r4) == false) goto L16;
        r4 = r6;
    L16:
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.plus((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(b(r7, r8), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin");
        HashSet r10 = new HashSet();
        ArrayList r11 = new ArrayList();
        Iterator r12 = r9.iterator();
    L18:
        if (r12.hasNext() == false) goto L23;
        Object r13 = r12.next();
        if (r10.add(f8772a.e((h) ZeusTransformUtils.preCheckCast(r13, h.class, "com.obric.memorydata.plugin"))) == false) goto L18;
        r11.add(r13);
        goto L18
    L23:
        return (List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.memorydata.plugin");
    L8:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r4 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    private static final CopyOnWriteArrayList a(Function1 r2, Object r3) {
        return (CopyOnWriteArrayList) ZeusTransformUtils.preCheckCast(((Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin")).invoke(r3), CopyOnWriteArrayList.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ void a(g r0) {
        r0.c();
    }

    private static final void a(g r2, Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Intrinsics.checkNotNull(r4);     // Catch: Throwable -> L5
        Object r5 = Result.m1421constructorimpl(Boolean.valueOf(r2.a(r4)));     // Catch: Throwable -> L5
    L7:
        Throwable r6 = Result.m1424exceptionOrNullimpl(r5);
        if (r6 == null) goto L13;
        RunLog.INSTANCE.warn("PersistentAwarenessRuntime", "async start persistent runtime failed", r6);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static final /* synthetic */ void a(g r2, String r3, Object r4, Object r5, Map r6) {
        r2.a(r3, r4, r5, (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void a(g r2, String r3, Map r4) {
        r2.a(r3, (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin"));
    }

    private final void a(h r8) {
        b(r8);
        ConcurrentHashMap<String, CopyOnWriteArrayList<h>> r0 = e;
        String r1 = r8.g();
        final $$Lambda$g$NhSA0RigKYTQDzfNlIrS7XWTgLs r2 = $$Lambda$g$NhSA0RigKYTQDzfNlIrS7XWTgLs.INSTANCE;
        ((CopyOnWriteArrayList) ZeusTransformUtils.preCheckCast(r0.computeIfAbsent(r1, new $$Lambda$g$2gbPTJeBDG2k5147gPjN4ynX8k(r2)), CopyOnWriteArrayList.class, "com.obric.memorydata.plugin")).add(r8);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PersistentAwarenessRuntime", "add runtime subscription " + r8.i(), false, 4, null);
        c(r8);
    }

    private final void a(h r8, h r9) {
        CopyOnWriteArrayList r7 = (CopyOnWriteArrayList) ZeusTransformUtils.preCheckCast(e.get(r8.g()), CopyOnWriteArrayList.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L26;
        Iterator r0 = ((List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin")).iterator();
        int r3 = 0;
    L6:
        if (r0.hasNext() == false) goto L20;
        h r4 = (h) ZeusTransformUtils.preCheckCast(r0.next(), h.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r4.a(), r8.a()) == true) goto L10;
    L16:
        boolean r5 = false;
    L17:
        if (r5 == true) goto L21;
        r3 = r3 + 1;
    L21:
        if (r3 < 0) goto L27;
        r7.set(r3, r9);
        RunLog.INSTANCE.debug("PersistentAwarenessRuntime", "replace runtime subscription " + r9.i());
        return;
    L27:
        return;
    L10:
        if (Intrinsics.areEqual(r4.b(), r8.b()) == false) goto L16;
        if (Intrinsics.areEqual(r4.c(), r8.c()) == false) goto L16;
        if (Intrinsics.areEqual(r4.d(), r8.d()) == false) goto L16;
        r5 = true;
        goto L17
    L20:
        r3 = -1;
        goto L21
    }

    private final void a(h r7, Object r8, Object r9, Map<String, ? extends Object> r10) {
        Map<String, ? extends Object> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.memorydata.plugin");
        e r0 = e.f8770a;
        Context r11 = c;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("appContext");
        r11 = null;
    L5:
        r0.a(r11, r7, r8, r9, r6);
        com.obric.memorydata.awareness.a.f8503a.a(r7.d(), r9, r6, r7.a());
    }

    private final void a(h r3, String r4, Map<String, ? extends Object> r5) {
        Map<String, ? extends Object> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        e r0 = e.f8770a;
        Context r1 = c;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("appContext");
        r1 = null;
    L5:
        r0.a(r1, r3, r4, r6);
        com.obric.memorydata.awareness.a.f8503a.a(r4, r6, r3.a());
        b(r3, r4, r6);
    }

    private final void a(String r7, h r8) {
        com.obric.memorydata.awareness.api.a r6 = (com.obric.memorydata.awareness.api.a) ZeusTransformUtils.preCheckCast(f.remove(r7), com.obric.memorydata.awareness.api.a.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L18;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L6
        AwarenessManager.INSTANCE.unregisterAwarenessEvent(r8.d(), r6);     // Catch: Throwable -> L6
        Object r9 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L6
    L9:
        if (Result.m1428isSuccessimpl(r9) == false) goto L11;
        Unit r10 = (Unit) ZeusTransformUtils.preCheckCast(r9, Unit.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PersistentAwarenessRuntime", "unregister awareness listener targetKey=" + r7, false, 4, null);
    L11:
        Throwable r11 = Result.m1424exceptionOrNullimpl(r9);
        if (r11 == null) goto L14;
        RunLog.INSTANCE.warn("PersistentAwarenessRuntime", "ignore unregister awareness listener failure targetKey=" + r7, r11);
    L14:
        Result.m1420boximpl(r9);
        return;
    L6:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r9 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L9
    }

    private final void a(String r20, Object r21, Object r22, Map<String, ? extends Object> r23) {
        Map<String, ? extends Object> r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r23, Map.class, "com.obric.memorydata.plugin");
        List<h> r6 = c("feature", r20);
        RunLog.INSTANCE.debug("PersistentAwarenessRuntime", "handleFeatureEvent feature=" + r20 + " subscriptionSize=" + r6.size());
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r7.hasNext() == false) goto L34;
        h r8 = (h) ZeusTransformUtils.preCheckCast(r7.next(), h.class, "com.obric.memorydata.plugin");
        g r0 = f8772a;
        AwarenessConditionConfig r9 = r0.a(r8, "feature");
        if (r9 == null) goto L4;
        if (r9.isAlways() == true) goto L10;
        boolean r15 = com.obric.memorydata.awareness.persistent.a.f8761a.a(r22, r9);
        if (r15 == r8.f()) goto L29;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PersistentAwarenessRuntime", "feature match changed matched=" + r15 + ' ' + r8.i(), false, 4, null);
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L19
        i r2 = d;     // Catch: Throwable -> L19
        if (r2 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("store");     // Catch: Throwable -> L19
        r2 = null;
    L17:
        r2.a(r8, r15);     // Catch: Throwable -> L19
        Object r4 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L19
    L21:
        Throwable r10 = Result.m1424exceptionOrNullimpl(r4);
        if (r10 == null) goto L25;
        RunLog.INSTANCE.warn("PersistentAwarenessRuntime", "update persistent feature matched state failed " + r8.i(), r10);
    L25:
        if (Result.m1428isSuccessimpl(r4) == false) goto L4;
        f8772a.a(r8, h.a(r8, null, null, null, null, null, r15, 31, null));
    L19:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r4 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L29:
        if (r15 == false) goto L4;
        if (r8.f() == true) goto L4;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PersistentAwarenessRuntime", "feature condition first matched callback " + r8.i(), false, 4, null);
        r0 = f8772a;
    L33:
        r0.a(r8, r21, r22, r3);
        goto L4
    L10:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PersistentAwarenessRuntime", "feature always matched callback " + r8.i(), false, 4, null);
        goto L33
    }

    private final void a(String r12, Map<String, ? extends Object> r13) {
        Map<String, ? extends Object> r14 = (Map) ZeusTransformUtils.wrapperContextForParams(r13, Map.class, "com.obric.memorydata.plugin");
        if (EventNames.INSTANCE.isGeoFenceEvent(r12) == false) goto L25;
        String r2 = null;
        if (r14 == null) goto L7;
        Object r15 = r14.get("fence_id");
    L9:
        if (ZeusTransformUtils.instanceOf(r15, String.class) == false) goto L11;
        String r16 = (String) ZeusTransformUtils.preCheckCast(r15, String.class, "com.obric.memorydata.plugin");
    L12:
        if (r16 == null) goto L14;
        r2 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r16, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L14:
        CharSequence r17 = (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin");
        if (r17 != null) goto L17;
    L20:
        boolean r18 = true;
    L21:
        if (r18 == false) goto L24;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PersistentAwarenessRuntime", "ignore geofence context event without fence_id event=" + r12, null, 4, null);
        return;
    L24:
        r14 = MapsKt.mapOf(TuplesKt.to("fence_id", r2));
        goto L25
    L17:
        if (r17.length() == 0) goto L20;
        r18 = false;
        goto L21
    L11:
        r16 = null;
        goto L12
    L7:
        r15 = null;
    L25:
        List<h> r11 = c("event", r12);
        RunLog.INSTANCE.debug("PersistentAwarenessRuntime", "handleContextEvent event=" + r12 + " subscriptionSize=" + r11.size());
        Iterator r19 = ((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L27:
        if (r19.hasNext() == false) goto L35;
        h r3 = (h) ZeusTransformUtils.preCheckCast(r19.next(), h.class, "com.obric.memorydata.plugin");
        g r4 = f8772a;
        AwarenessConditionConfig r5 = r4.a(r3, "event");
        if (r5 == null) goto L27;
        if (com.obric.memorydata.awareness.persistent.a.f8761a.a(r14, r5) == false) goto L33;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PersistentAwarenessRuntime", "event matched callback " + r3.i(), false, 4, null);
        r4.a(r3, r12, r14);
        goto L27
    L33:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PersistentAwarenessRuntime", "ignore persistent event callback unmatched event=" + r12 + ' ' + r3.i(), false, 4, null);
        goto L27
    }

    private final void a(List<h> r3) {
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        h r4 = (h) ZeusTransformUtils.preCheckCast(r2.next(), h.class, "com.obric.memorydata.plugin");
        f8772a.b(r4);
        goto L4
    }

    private final boolean a() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L17
        g r8 = (g) ZeusTransformUtils.preCheckCast(this, g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        Object r1 = i;     // Catch: Throwable -> L17
        monitor-enter(r1);     // Catch: Throwable -> L17
        i r2 = d;     // Catch: Throwable -> L14
        if (r2 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("store");     // Catch: Throwable -> L14
        r2 = null;
    L7:
        List<h> r3 = r2.a();     // Catch: Throwable -> L14
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L14
    L8:
        if (r4.hasNext() == false) goto L12;
        r8.a((h) ZeusTransformUtils.preCheckCast(r4.next(), h.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L14
        goto L8
    L12:
        monitor-exit(r1);     // Catch: Throwable -> L17
        Object r9 = Result.m1421constructorimpl(r3);     // Catch: Throwable -> L17
    L19:
        Throwable r5 = Result.m1424exceptionOrNullimpl(r9);
        if (r5 == null) goto L22;
        boolean r6 = false;
        RunLog.INSTANCE.warn("PersistentAwarenessRuntime", "restore persistent subscriptions failed", r5);
    L23:
        List r7 = CollectionsKt.emptyList();
        if (Result.m1427isFailureimpl(r9) == false) goto L26;
        r9 = r7;
    L26:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PersistentAwarenessRuntime", "restore persistent subscriptions size=" + ((List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin")).size(), false, 4, null);
        return r6;
    L22:
        r6 = true;
        goto L23
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r9 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L19
    }

    private static final com.obric.memorydata.awareness.api.a b(h r8, String r9) {
        Intrinsics.checkNotNullParameter(r9, "it");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PersistentAwarenessRuntime", "register awareness listener targetKey=" + r8.g(), false, 4, null);
        b r10 = new b(r8);
        AwarenessManager.INSTANCE.registerAwarenessEvent(r8.d(), (com.obric.memorydata.awareness.api.a) ZeusTransformUtils.preCheckCast(r10, com.obric.memorydata.awareness.api.a.class, "com.obric.memorydata.plugin"));
        return (com.obric.memorydata.awareness.api.a) ZeusTransformUtils.preCheckCast(r10, com.obric.memorydata.awareness.api.a.class, "com.obric.memorydata.plugin");
    }

    private static final com.obric.memorydata.awareness.api.a b(Function1 r2, Object r3) {
        return (com.obric.memorydata.awareness.api.a) ZeusTransformUtils.preCheckCast(((Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin")).invoke(r3), com.obric.memorydata.awareness.api.a.class, "com.obric.memorydata.plugin");
    }

    private final List<h> b(String r8) {
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L8
        g r3 = (g) ZeusTransformUtils.preCheckCast(this, g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        i r4 = d;     // Catch: Throwable -> L8
        if (r4 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("store");     // Catch: Throwable -> L8
        r4 = null;
    L6:
        Object r5 = Result.m1421constructorimpl(r4.a(r8));     // Catch: Throwable -> L8
    L10:
        Throwable r6 = Result.m1424exceptionOrNullimpl(r5);
        if (r6 == null) goto L13;
        RunLog.INSTANCE.warn("PersistentAwarenessRuntime", "list persistent subscriptions before clear failed owner=" + r8, r6);
    L13:
        List r7 = CollectionsKt.emptyList();
        if (Result.m1427isFailureimpl(r5) == false) goto L16;
        r5 = r7;
    L16:
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.plus((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(b(r8, null), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin");
        HashSet r10 = new HashSet();
        ArrayList r1 = new ArrayList();
        Iterator r11 = r9.iterator();
    L18:
        if (r11.hasNext() == false) goto L23;
        Object r12 = r11.next();
        if (r10.add(f8772a.e((h) ZeusTransformUtils.preCheckCast(r12, h.class, "com.obric.memorydata.plugin"))) == false) goto L18;
        r1.add(r12);
        goto L18
    L23:
        return (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin");
    L8:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r5 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    private final List<h> b(String r6, String r7) {
        Collection<CopyOnWriteArrayList<h>> r5 = e.values();
        Intrinsics.checkNotNullExpressionValue(r5, "<get-values>(...)");
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r9 = r8.iterator();
    L4:
        if (r9.hasNext() == false) goto L6;
        CopyOnWriteArrayList r2 = (CopyOnWriteArrayList) ZeusTransformUtils.preCheckCast(r9.next(), CopyOnWriteArrayList.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r2);
        CollectionsKt.addAll(r0, (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"));
        goto L4
    L6:
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r11 = r10.iterator();
    L8:
        if (r11.hasNext() == false) goto L19;
        Object r3 = r11.next();
        h r4 = (h) ZeusTransformUtils.preCheckCast(r3, h.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r4.a(), r6) == false) goto L15;
        if (r7 != null) goto L13;
    L14:
        boolean r12 = true;
    L16:
        if (r12 == false) goto L8;
        r1.add(r3);
        goto L8
    L13:
        if (Intrinsics.areEqual(r4.b(), r7) == true) goto L14;
    L15:
        r12 = false;
        goto L16
    L19:
        return (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin");
    }

    private final void b() {
        AtomicBoolean r6 = g;
        if (r6.get() == false) goto L5;
        return;
    L5:
        Tracker.INSTANCE.registerDailyReportCallback((com.obric.memorydata.middleware.api.bdtracker.a) ZeusTransformUtils.preCheckCast(j, com.obric.memorydata.middleware.api.bdtracker.a.class, "com.obric.memorydata.plugin"));
        r6.set(true);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PersistentAwarenessRuntime", "register persistent daily report callback", false, 4, null);
    }

    private final void b(h r8) {
        CopyOnWriteArrayList r0 = (CopyOnWriteArrayList) ZeusTransformUtils.preCheckCast(e.get(r8.g()), CopyOnWriteArrayList.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L13;
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r2 = r1.iterator();
    L6:
        if (r2.hasNext() == false) goto L10;
        Object r4 = r2.next();
        h r5 = (h) ZeusTransformUtils.preCheckCast(r4, h.class, "com.obric.memorydata.plugin");
        g r6 = f8772a;
        Intrinsics.checkNotNull(r5);
        if (r6.b(r5, r8) == false) goto L6;
        r3.add(r4);
        goto L6
    L10:
        boolean r7 = r0.removeAll((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin"));
        if (r0.isEmpty() == false) goto L14;
        e.remove(r8.g());
    L14:
        d(r8);
        if (r7 == false) goto L23;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PersistentAwarenessRuntime", "remove runtime subscription " + r8.i(), false, 4, null);
        return;
    L23:
        return;
    L13:
        r7 = false;
        goto L14
    }

    private final void b(h r3, String r4, Map<String, ? extends Object> r5) {
        Map r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r4, EventNames.GEOFENCE_ENTERED) == false) goto L6;
        String r6 = "enter";
    L8:
        String r7 = null;
        if (r2 == null) goto L11;
        Object r8 = r2.get("fence_id");
    L13:
        if (ZeusTransformUtils.instanceOf(r8, String.class) == false) goto L15;
        r7 = (String) ZeusTransformUtils.preCheckCast(r8, String.class, "com.obric.memorydata.plugin");
    L15:
        if (r7 != null) goto L17;
        return;
    L17:
        com.obric.memorydata.awareness.a.f8503a.a(r7, r6, r3.a());
        return;
    L11:
        r8 = null;
        goto L13
    L6:
        if (Intrinsics.areEqual(r4, EventNames.GEOFENCE_EXITED) == false) goto L19;
        r6 = "exit";
        goto L8
    }

    private final boolean b(h r2, h r3) {
        if (Intrinsics.areEqual(r2.a(), r3.a()) == true) goto L5;
    L11:
        return false;
    L5:
        if (Intrinsics.areEqual(r2.b(), r3.b()) == false) goto L11;
        if (Intrinsics.areEqual(r2.c(), r3.c()) == false) goto L11;
        if (Intrinsics.areEqual(r2.d(), r3.d()) == false) goto L11;
        return true;
    }

    private final List<h> c(String r2, String r3) {
        CopyOnWriteArrayList r1 = (CopyOnWriteArrayList) ZeusTransformUtils.preCheckCast(e.get(d(r2, r3)), CopyOnWriteArrayList.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L5;
        List<h> r4 = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin"));
    L6:
        if (r4 == null) goto L8;
        return r4;
    L8:
        return CollectionsKt.emptyList();
    L5:
        r4 = null;
        goto L6
    }

    private static final CopyOnWriteArrayList c(String r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return new CopyOnWriteArrayList();
    }

    private final void c() {
        Collection<CopyOnWriteArrayList<h>> r8 = e.values();
        Intrinsics.checkNotNullExpressionValue(r8, "<get-values>(...)");
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r9.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        CopyOnWriteArrayList r2 = (CopyOnWriteArrayList) ZeusTransformUtils.preCheckCast(r10.next(), CopyOnWriteArrayList.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r2);
        CollectionsKt.addAll(r0, (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"));
        goto L4
    L6:
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        HashSet r1 = new HashSet();
        ArrayList r3 = new ArrayList();
        Iterator r12 = r11.iterator();
    L8:
        if (r12.hasNext() == false) goto L12;
        Object r4 = r12.next();
        h r5 = (h) ZeusTransformUtils.preCheckCast(r4, h.class, "com.obric.memorydata.plugin");
        if (r1.add(r5.a() + '#' + r5.c() + '#' + r5.d()) == false) goto L8;
        r3.add(r4);
        goto L8
    L12:
        List r13 = (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PersistentAwarenessRuntime", "persistent daily report runtime subscriptions size=" + r13.size(), false, 4, null);
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L14:
        if (r14.hasNext() == false) goto L18;
        h r6 = (h) ZeusTransformUtils.preCheckCast(r14.next(), h.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r6.c(), "feature") == false) goto L14;
        com.obric.memorydata.awareness.a.f8503a.a(r6.d(), r6.a());
        goto L14
    }

    private final void c(final h r3) {
        ConcurrentHashMap<String, com.obric.memorydata.awareness.api.a> r2 = f;
        String r0 = r3.g();
        final Function1 r1 = new $$Lambda$g$V_tfZzoDnnEzqCgxk2K4DYO9qqE(r3);
        r2.computeIfAbsent(r0, new $$Lambda$g$83ZObojPGEk08h5R7XNyOeQnKro(r1));
    }

    private final boolean c(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (f8773b.get() == false) goto L5;
        return true;
    L5:
        return a(r4);
    }

    private final String d(String r1, String r2) {
        return r1 + '#' + r2;
    }

    private final void d(h r4) {
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(e.get(r4.g()), Collection.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        a(r4.g(), r4);
        return;
    L12:
        return;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    private final String e(h r3) {
        return r3.a() + '#' + r3.b() + '#' + r3.c() + '#' + r3.d();
    }

    /* JADX INFO: renamed from: lambda$2gbPTJeBDG2-k5147gPjN4ynX8k, reason: not valid java name */
    public static /* synthetic */ CopyOnWriteArrayList m528lambda$2gbPTJeBDG2k5147gPjN4ynX8k(Function1 r0, Object r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ com.obric.memorydata.awareness.api.a lambda$83ZObojPGEk08h5R7XNyOeQnKro(Function1 r0, Object r1) {
        return b(r0, r1);
    }

    public static /* synthetic */ CopyOnWriteArrayList lambda$NhSA0RigKYTQDzfNlIrS7XWTgLs(String r0) {
        return c(r0);
    }

    public static /* synthetic */ com.obric.memorydata.awareness.api.a lambda$V_tfZzoDnnEzqCgxk2K4DYO9qqE(h r0, String r1) {
        return b(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$gZe1u-Vw47kh1OHtoTlMiJISQ2A, reason: not valid java name */
    public static /* synthetic */ void m529lambda$gZe1uVw47kh1OHtoTlMiJISQ2A(g r0, Context r1) {
        a(r0, r1);
    }

    public final MemoryResponse<Void> a(Context r10, h r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r11, "entity");
        if (c(r12) == false) goto L5;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PersistentAwarenessRuntime", "register persistent subscription " + r11.i(), false, 4, null);
        MemoryResponse<Void> r9 = MemoryResponse.CREATOR.a();
        Object r13 = i;
        monitor-enter(r13);
        i r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L14
        i r2 = d;     // Catch: Throwable -> L14
        if (r2 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("store");     // Catch: Throwable -> L14
        r2 = null;
    L12:
        Object r3 = Result.m1421constructorimpl(r2.a(r11.a(), r11.b()));     // Catch: Throwable -> L14
    L16:
        Throwable r4 = Result.m1424exceptionOrNullimpl(r3);     // Catch: Throwable -> L41
        if (r4 != null) goto L37;
        List r5 = (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L41
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L44;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PersistentAwarenessRuntime", "reuse persistent subscription from aiagent replay " + r11.i() + " existing=" + ((h) ZeusTransformUtils.preCheckCast(CollectionsKt.first(r5), h.class, "com.obric.memorydata.plugin")).i(), false, 4, null);     // Catch: Throwable -> L41
    L38:
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L41
        monitor-exit(r13);
        return r9;
    L44:
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L28
        i r7 = d;     // Catch: Throwable -> L28
        if (r7 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("store");     // Catch: Throwable -> L28
    L26:
        r0.insert(r11);     // Catch: Throwable -> L28
        Object r8 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L28
    L31:
        if (Result.m1427isFailureimpl(r8) == false) goto L36;
        RunLog r15 = RunLog.INSTANCE;     // Catch: Throwable -> L41
        String r16 = "insert persistent subscription failed " + r11.i();     // Catch: Throwable -> L41
        Throwable r17 = Result.m1424exceptionOrNullimpl(r8);     // Catch: Throwable -> L41
        if (r17 != null) goto L35;
        r17 = new Throwable("unknown insert failure");     // Catch: Throwable -> L41
    L35:
        r15.error("PersistentAwarenessRuntime", r16, r17);     // Catch: Throwable -> L41
        r9 = new MemoryResponse(400, "insert persistent subscription failed", null, 4, null);     // Catch: Throwable -> L41
        goto L38
    L36:
        f8772a.a(r11);     // Catch: Throwable -> L41
        goto L38
    L25:
        r0 = r7;
    L28:
        th = move-exception;
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L41
        r8 = Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L41
        goto L31
    L37:
        RunLog.INSTANCE.error("PersistentAwarenessRuntime", "query persistent subscription failed " + r11.i(), r4);     // Catch: Throwable -> L41
        r9 = new MemoryResponse(400, "query persistent subscription failed", null, 4, null);     // Catch: Throwable -> L41
        goto L38
    L41:
        th = move-exception;
        throw th;
    L14:
        th = move-exception;
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L41
        r3 = Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L41
        goto L16
    L5:
        return new MemoryResponse(404, "persistent runtime start failed", null, 4, null);
    }

    public final MemoryResponse<Void> a(Context r9, String r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r10, "ownerPackage");
        if (c(r11) == false) goto L5;
        Object r8 = i;
        monitor-enter(r8);
        List<h> r12 = f8772a.b(r10);     // Catch: Throwable -> L32
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L15
        i r2 = d;     // Catch: Throwable -> L15
        if (r2 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("store");     // Catch: Throwable -> L15
        r2 = null;
    L13:
        Object r3 = Result.m1421constructorimpl(Integer.valueOf(r2.b(r10)));     // Catch: Throwable -> L15
    L18:
        if (Result.m1427isFailureimpl(r3) == false) goto L23;
        RunLog r13 = RunLog.INSTANCE;     // Catch: Throwable -> L32
        String r14 = "delete persistent subscriptions db failed owner=" + r10;     // Catch: Throwable -> L32
        Throwable r4 = Result.m1424exceptionOrNullimpl(r3);     // Catch: Throwable -> L32
        if (r4 != null) goto L22;
        r4 = new Throwable("unknown delete failure");     // Catch: Throwable -> L32
    L22:
        r13.error("PersistentAwarenessRuntime", r14, r4);     // Catch: Throwable -> L32
        MemoryResponse<Void> r15 = new MemoryResponse(400, "delete persistent subscriptions db failed", null, 4, null);     // Catch: Throwable -> L32
    L30:
        monitor-exit(r8);
        return r15;
    L23:
        MemoryResponse<Void> r0 = f8772a.a(r12, r10, null);     // Catch: Throwable -> L32
        if (r0.isSuccess() == true) goto L26;
        r15 = r0;
        goto L30
    L26:
        IRunLog r5 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L32
        StringBuilder r16 = new StringBuilder().append("clear persistent subscriptions owner=").append(r10).append(" runtimeCount=").append(r12.size()).append(" dbDeleteCount=");     // Catch: Throwable -> L32
        if (Result.m1427isFailureimpl(r3) == false) goto L29;
        r3 = 0;
    L29:
        IRunLog.a.a(r5, "PersistentAwarenessRuntime", r16.append(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).intValue()).toString(), false, 4, null);     // Catch: Throwable -> L32
        r15 = MemoryResponse.CREATOR.a();     // Catch: Throwable -> L32
    L15:
        th = move-exception;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L32
        r3 = Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        throw th;
    L5:
        return new MemoryResponse(404, "persistent runtime start failed", null, 4, null);
    }

    public final MemoryResponse<Void> a(Context r9, String r10, String r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r10, "ownerPackage");
        Intrinsics.checkNotNullParameter(r11, "subscriptionId");
        if (c(r12) == false) goto L5;
        Object r8 = i;
        monitor-enter(r8);
        List<h> r13 = f8772a.a(r10, r11);     // Catch: Throwable -> L31
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L14
        i r1 = d;     // Catch: Throwable -> L14
        if (r1 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("store");     // Catch: Throwable -> L14
        r1 = null;
    L12:
        Object r2 = Result.m1421constructorimpl(Integer.valueOf(r1.b(r10, r11)));     // Catch: Throwable -> L14
    L17:
        if (Result.m1427isFailureimpl(r2) == false) goto L22;
        RunLog r14 = RunLog.INSTANCE;     // Catch: Throwable -> L31
        String r15 = "delete persistent subscription db failed owner=" + r10 + " subscriptionId=" + r11;     // Catch: Throwable -> L31
        Throwable r16 = Result.m1424exceptionOrNullimpl(r2);     // Catch: Throwable -> L31
        if (r16 != null) goto L21;
        r16 = new Throwable("unknown delete failure");     // Catch: Throwable -> L31
    L21:
        r14.error("PersistentAwarenessRuntime", r15, r16);     // Catch: Throwable -> L31
        MemoryResponse<Void> r17 = new MemoryResponse(400, "delete persistent subscription db failed", null, 4, null);     // Catch: Throwable -> L31
    L29:
        monitor-exit(r8);
        return r17;
    L22:
        MemoryResponse<Void> r3 = f8772a.a(r13, r10, r11);     // Catch: Throwable -> L31
        if (r3.isSuccess() == true) goto L25;
        r17 = r3;
        goto L29
    L25:
        IRunLog r4 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L31
        StringBuilder r18 = new StringBuilder().append("unregister persistent subscription owner=").append(r10).append(" subscriptionId=").append(r11).append(" runtimeCount=").append(r13.size()).append(" dbDeleteCount=");     // Catch: Throwable -> L31
        if (Result.m1427isFailureimpl(r2) == false) goto L28;
        r2 = 0;
    L28:
        IRunLog.a.a(r4, "PersistentAwarenessRuntime", r18.append(((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.memorydata.plugin")).intValue()).toString(), false, 4, null);     // Catch: Throwable -> L31
        r17 = MemoryResponse.CREATOR.a();     // Catch: Throwable -> L31
    L14:
        th = move-exception;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L31
        r2 = Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        throw th;
    L5:
        return new MemoryResponse(404, "persistent runtime start failed", null, 4, null);
    }

    public final MemoryResponse<Void> a(GeoFenceRequest r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, Ext.KEY_REQUEST);
        Intrinsics.checkNotNullParameter(r5, "ownerPackage");
        return (MemoryResponse) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new PersistentAwarenessRuntime$addGeoFence$1(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r4.getFenceId(), CharSequence.class, "com.obric.memorydata.plugin")).toString(), r4, r5, null), Function2.class, "com.obric.memorydata.plugin"), 1, null), MemoryResponse.class, "com.obric.memorydata.plugin");
    }

    public final MemoryResponse<Void> a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "fenceId");
        return (MemoryResponse) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new PersistentAwarenessRuntime$removeGeoFence$1(r3, null), Function2.class, "com.obric.memorydata.plugin"), 1, null), MemoryResponse.class, "com.obric.memorydata.plugin");
    }

    public final boolean a(Context r10) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "context");
        Object r11 = h;
        monitor-enter(r11);
        g r0 = f8772a;     // Catch: Throwable -> L32
        Context r12 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r9.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L32
        Intrinsics.checkNotNullExpressionValue(r12, "getApplicationContext(...)");     // Catch: Throwable -> L32
        c = r12;     // Catch: Throwable -> L32
        if (d != null) goto L10;
        Context r1 = c;     // Catch: Throwable -> L32
        if (r1 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("appContext");     // Catch: Throwable -> L32
        r1 = null;
    L9:
        d = new i(r1);     // Catch: Throwable -> L32
    L10:
        boolean r2 = false;
        if (f8773b.get() == false) goto L14;
        RunLog.INSTANCE.debug("PersistentAwarenessRuntime", "persistent runtime already started");     // Catch: Throwable -> L32
    L13:
        r2 = true;
    L30:
        monitor-exit(r11);
        return r2;
    L14:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PersistentAwarenessRuntime", "start persistent runtime", false, 4, null);     // Catch: Throwable -> L32
        if (r0.a() == true) goto L35;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PersistentAwarenessRuntime", "persistent runtime start failed, wait for next retry", null, 4, null);     // Catch: Throwable -> L32
        goto L30
    L35:
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L20
        r0.b();     // Catch: Throwable -> L20
        Object r14 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L20
    L23:
        if (Result.m1427isFailureimpl(r14) == false) goto L28;
        RunLog r3 = RunLog.INSTANCE;     // Catch: Throwable -> L32
        Throwable r15 = Result.m1424exceptionOrNullimpl(r14);     // Catch: Throwable -> L32
        if (r15 != null) goto L27;
        r15 = new Throwable("unknown callback registration failure");     // Catch: Throwable -> L32
    L27:
        r3.warn("PersistentAwarenessRuntime", "persistent runtime register callback failed", r15);     // Catch: Throwable -> L32
        goto L30
    L28:
        f8773b.set(true);     // Catch: Throwable -> L32
    L20:
        th = move-exception;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L32
        r14 = Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        throw th;
    }

    public final void b(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        final Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        final g r2 = (g) ZeusTransformUtils.preCheckCast(this, g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        ThreadPoolContainer.Companion.getInstance().execute(new $$Lambda$g$gZe1uVw47kh1OHtoTlMiJISQ2A(r2, r5));     // Catch: Throwable -> L5
        Object r6 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r7 = Result.m1424exceptionOrNullimpl(r6);
        if (r7 == null) goto L13;
        RunLog.INSTANCE.warn("PersistentAwarenessRuntime", "schedule async start persistent runtime failed", r7);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r6 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
