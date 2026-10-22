package com.obric.memorydata.recommend.screenshotupload.sampling.aimedia;

import android.aimedia.IAIMediaEventCallback;
import android.aimedia.IAIMediaEvents;
import android.aimedia.MediaEventEnvelope;
import android.aimedia.MediaEventField;
import android.aimedia.MediaEventFilter;
import android.aimedia.MediaEventQueryResult;
import android.aimedia.MediaEventSubscribeOptions;
import android.os.IBinder;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 '2\u00020\u0001:\u0001'B\u0019\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0016JG\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u000e2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00140\u00132!\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00140\u0013H\u0016J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\tH\u0016J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\u0011\u001a\u00020\u000eH\u0002J\f\u0010!\u001a\u00020\f*\u00020\"H\u0002J\f\u0010!\u001a\u00020#*\u00020$H\u0002J\f\u0010!\u001a\u00020%*\u00020&H\u0002R\u0016\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/obric/memorydata/recommend/screenshotupload/sampling/aimedia/BinderAIMediaEventsGateway;", "Lcom/obric/memorydata/recommend/screenshotupload/sampling/aimedia/AIMediaEventsGateway;", "serviceResolver", "Lkotlin/Function0;", "Landroid/os/IBinder;", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "callbacks", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Landroid/aimedia/IAIMediaEventCallback;", "queryEventsSince", "Lcom/obric/memorydata/recommend/screenshotupload/sampling/aimedia/AIMediaEventQueryResultDto;", "lastSequence", "", "maxResults", "subscribeEvents", "startSequenceNumber", "onEvents", "Lkotlin/Function1;", "", "onClosed", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "reasonCode", "unsubscribeEvents", "subscriptionId", "resolveService", "Landroid/aimedia/IAIMediaEvents;", "buildFilter", "Landroid/aimedia/MediaEventFilter;", "buildSubscribeOptions", "Landroid/aimedia/MediaEventSubscribeOptions;", "toDto", "Landroid/aimedia/MediaEventQueryResult;", "Lcom/obric/memorydata/recommend/screenshotupload/sampling/aimedia/AIMediaEventEnvelopeDto;", "Landroid/aimedia/MediaEventEnvelope;", "Lcom/obric/memorydata/recommend/screenshotupload/sampling/aimedia/AIMediaEventFieldDto;", "Landroid/aimedia/MediaEventField;", "Companion", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class j implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12575a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function0<IBinder> f12576b;
    private final ConcurrentHashMap<Integer, IAIMediaEventCallback> c;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000b\u001a\u0004\u0018\u00010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/recommend/screenshotupload/sampling/aimedia/BinderAIMediaEventsGateway$Companion;", "", "<init>", "()V", "TAG", "", "AIMEDIA_EVENTS_SERVICE", "STATUS_OK", "", "SUBSCRIBE_MAX_BATCH_SIZE", "SUBSCRIBE_MAX_PENDING_EVENTS", "resolveAIMediaEventsServiceBinder", "Landroid/os/IBinder;", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final IBinder a() {
            Object r1 = null;
            Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L9
            a r7 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
            Object r8 = ZeusTransformUtils.forName("android.os.ServiceManager", "com.obric.memorydata.plugin").getMethod("getService", new Class[]{String.class}).invoke(null, new Object[]{"aimedia.events"});     // Catch: Throwable -> L9
            if (ZeusTransformUtils.instanceOf(r8, IBinder.class) == false) goto L6;
            IBinder r9 = (IBinder) ZeusTransformUtils.preCheckCast(r8, IBinder.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        L7:
            Object r10 = Result.m1421constructorimpl(r9);     // Catch: Throwable -> L9
        L12:
            if (Result.m1427isFailureimpl(r10) == true) goto L16;
            r1 = r10;
        L16:
            return (IBinder) ZeusTransformUtils.preCheckCast(r1, IBinder.class, "com.obric.memorydata.plugin");
        L6:
            r9 = null;
        L9:
            th = move-exception;
            Result.Companion r3 = Result.Companion;
            r10 = Result.m1421constructorimpl(ResultKt.createFailure(th));
            goto L12
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\n"}, d2 = {"com/obric/memorydata/recommend/screenshotupload/sampling/aimedia/BinderAIMediaEventsGateway$subscribeEvents$callback$1", "Landroid/aimedia/IAIMediaEventCallback$Stub;", "onEvents", "", "subscriptionId", "", "result", "Landroid/aimedia/MediaEventQueryResult;", "onSubscriptionClosed", "reasonCode", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends IAIMediaEventCallback.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<f, Unit> f12577a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ j f12578b;
        final /* synthetic */ Function1<Integer, Unit> c;

        b(Function1<? super f, Unit> r3, j r4, Function1<? super Integer, Unit> r5) {
            Function1<f, Unit> r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
            Function1<Integer, Unit> r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
            this.f12577a = r6;
            this.f12578b = r4;
            this.c = r7;
        }

        @Override // android.aimedia.IAIMediaEventCallback
        public void onEvents(int r7, MediaEventQueryResult r8) {
            Intrinsics.checkNotNullParameter(r8, "result");
            Function1<f, Unit> r1 = this.f12577a;
            j r2 = this.f12578b;
            Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L8
            b r6 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
            RunLog r9 = RunLog.INSTANCE;     // Catch: Throwable -> L8
            StringBuilder r4 = new StringBuilder().append("callback onEvents id=").append(r7).append(" status=").append(r8.statusCode).append(" events=");     // Catch: Throwable -> L8
            List<MediaEventEnvelope> r5 = r8.events;     // Catch: Throwable -> L8
            if (r5 != null) goto L6;
            r5 = CollectionsKt.emptyList();     // Catch: Throwable -> L8
        L6:
            r9.debug("AIMediaEventsGateway", r4.append(r5.size()).append(" next=").append(r8.nextSequenceNumber).append(" hasMore=").append(r8.hasMore).toString());     // Catch: Throwable -> L8
            r1.invoke(j.a(r2, r8));     // Catch: Throwable -> L8
            Object r10 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
        L10:
            Throwable r11 = Result.m1424exceptionOrNullimpl(r10);
            if (r11 == null) goto L16;
            RunLog.INSTANCE.warn("AIMediaEventsGateway", "callback onEvents failed id=" + r7, r11);
            return;
        L16:
            return;
        L8:
            th = move-exception;
            Result.Companion r12 = Result.Companion;
            r10 = Result.m1421constructorimpl(ResultKt.createFailure(th));
            goto L10
        }

        @Override // android.aimedia.IAIMediaEventCallback
        public void onSubscriptionClosed(int r10, int r11) {
            j r1 = this.f12578b;
            Function1<Integer, Unit> r2 = this.c;
            Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L5
            b r9 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AIMediaEventsGateway", "callback closed id=" + r10 + " reason=" + r11, null, 4, null);     // Catch: Throwable -> L5
            j.a(r1).remove(Integer.valueOf(r10));     // Catch: Throwable -> L5
            r2.invoke(Integer.valueOf(r11));     // Catch: Throwable -> L5
            Object r12 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
        L7:
            Throwable r13 = Result.m1424exceptionOrNullimpl(r12);
            if (r13 == null) goto L13;
            RunLog.INSTANCE.warn("AIMediaEventsGateway", "callback onSubscriptionClosed failed id=" + r10, r13);
            return;
        L13:
            return;
        L5:
            th = move-exception;
            Result.Companion r14 = Result.Companion;
            r12 = Result.m1421constructorimpl(ResultKt.createFailure(th));
            goto L7
        }
    }

    static {
        f12575a = new a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public j() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public j(Function0<? extends IBinder> r3) {
        Function0<IBinder> r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "serviceResolver");
        this.f12576b = r4;
        this.c = new ConcurrentHashMap();
    }

    public /* synthetic */ j(Function0 r2, int r3, DefaultConstructorMarker r4) {
        Function0 r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin");
        if ((r3 & 1) == 0) goto L5;
        r5 = $$Lambda$j$ecxVnxIWkxovXAB2t4tuf7uyUA.INSTANCE;
    L5:
        this(r5);
    }

    private final IAIMediaEvents a() {
        IBinder r2 = (IBinder) ZeusTransformUtils.preCheckCast(this.f12576b.invoke(), IBinder.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L7;
        return null;
    L7:
        return IAIMediaEvents.Stub.asInterface(r2);
    }

    private final MediaEventSubscribeOptions a(long r1) {
        MediaEventSubscribeOptions r0 = new MediaEventSubscribeOptions();
        r0.startSequenceNumber = r1;
        r0.minIntervalMs = 0;
        r0.maxBatchSize = 16;
        r0.maxPendingEvents = 128;
        r0.deliverCurrentSnapshot = false;
        return r0;
    }

    private final d a(MediaEventEnvelope r10) {
        String r0 = r10.eventName;
        if (r0 != null) goto L5;
        String r3 = "";
    L6:
        long r4 = r10.sequenceNumber;
        String r1 = r10.sessionId;
        if (r1 != null) goto L9;
        String r6 = "";
    L10:
        String r2 = r10.reportedPackage;
        if (r2 != null) goto L13;
        String r7 = "";
    L14:
        List<MediaEventField> r11 = r10.fields;
        if (r11 != null) goto L17;
        r11 = CollectionsKt.emptyList();
    L17:
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r13 = r12.iterator();
    L19:
        if (r13.hasNext() == false) goto L22;
        MediaEventField r8 = (MediaEventField) ZeusTransformUtils.preCheckCast(r13.next(), MediaEventField.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r8);
        r5.add(a(r8));
        goto L19
    L22:
        return new d(r3, r4, r6, r7, (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin"));
    L13:
        r7 = r2;
        goto L14
    L9:
        r6 = r1;
        goto L10
    L5:
        r3 = r0;
        goto L6
    }

    private final e a(MediaEventField r7) {
        String r0 = r7.key;
        if (r0 != null) goto L6;
        r0 = "";
    L6:
        return new e(r0, r7.valueType, r7.stringValue, r7.longValue);
    }

    private final f a(MediaEventQueryResult r7) {
        int r1 = r7.statusCode;
        List<MediaEventEnvelope> r0 = r7.events;
        if (r0 != null) goto L5;
        r0 = CollectionsKt.emptyList();
    L5:
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r4 = r2.iterator();
    L7:
        if (r4.hasNext() == false) goto L10;
        MediaEventEnvelope r5 = (MediaEventEnvelope) ZeusTransformUtils.preCheckCast(r4.next(), MediaEventEnvelope.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r5);
        r3.add(a(r5));
        goto L7
    L10:
        return new f(r1, (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin"), r7.nextSequenceNumber, r7.hasMore);
    }

    public static final /* synthetic */ f a(j r0, MediaEventQueryResult r1) {
        return r0.a(r1);
    }

    public static final /* synthetic */ ConcurrentHashMap a(j r0) {
        return r0.c;
    }

    private final MediaEventFilter b() {
        MediaEventFilter r2 = new MediaEventFilter();
        r2.origins = CollectionsKt.emptyList();
        r2.sources = CollectionsKt.emptyList();
        r2.mediaTypes = CollectionsKt.emptyList();
        r2.eventTypes = CollectionsKt.emptyList();
        r2.eventNames = CollectionsKt.listOf("codec");
        r2.sessionIds = CollectionsKt.emptyList();
        r2.startTimeMs = 0;
        r2.endTimeMs = 0;
        r2.minSequenceNumber = 0;
        r2.includeMirroredEvents = false;
        return r2;
    }

    private static final IBinder c() {
        return f12575a.a();
    }

    /* JADX INFO: renamed from: lambda$ecxVnxIWkxovXAB2t4tu-f7uyUA, reason: not valid java name */
    public static /* synthetic */ IBinder m1123lambda$ecxVnxIWkxovXAB2t4tuf7uyUA() {
        return c();
    }

    @Override // com.obric.memorydata.recommend.screenshotupload.sampling.aimedia.g
    public int a(long r10, Function1<? super f, Unit> r12, Function1<? super Integer, Unit> r13) {
        Function1 r14 = (Function1) ZeusTransformUtils.wrapperContextForParams(r12, Function1.class, "com.obric.memorydata.plugin");
        Function1 r15 = (Function1) ZeusTransformUtils.wrapperContextForParams(r13, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r14, "onEvents");
        Intrinsics.checkNotNullParameter(r15, "onClosed");
        IAIMediaEvents r0 = a();
        if (r0 != null) goto L6;
        j r9 = (j) ZeusTransformUtils.preCheckCast(this, j.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AIMediaEventsGateway", "subscribe skip: service unavailable startSequence=" + r10, null, 4, null);
        return 0;
    L6:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AIMediaEventsGateway", "subscribe request startSequence=" + r10, false, 4, null);
        b r2 = new b(r14, this, r15);
        int r11 = r0.subscribeEvents(b(), a(r10), (IAIMediaEventCallback) ZeusTransformUtils.preCheckCast(r2, IAIMediaEventCallback.class, "com.obric.memorydata.plugin"));
        if (r11 <= 0) goto L9;
        ((Map) ZeusTransformUtils.preCheckCast(this.c, Map.class, "com.obric.memorydata.plugin")).put(Integer.valueOf(r11), r2);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AIMediaEventsGateway", "subscribe success id=" + r11, false, 4, null);
    L10:
        return r11;
    L9:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AIMediaEventsGateway", "subscribe failed id=" + r11, null, 4, null);
        goto L10
    }

    @Override // com.obric.memorydata.recommend.screenshotupload.sampling.aimedia.g
    public f a(long r10, int r12) {
        IAIMediaEvents r0 = a();
        if (r0 != null) goto L6;
        j r9 = (j) ZeusTransformUtils.preCheckCast(this, j.class, "com.obric.memorydata.plugin");
        RunLog.INSTANCE.debug("AIMediaEventsGateway", "query skip: service unavailable lastSequence=" + r10);
        return null;
    L6:
        MediaEventQueryResult r8 = new MediaEventQueryResult();
        int r11 = r0.queryEventsSince(b(), r10, r12, r8);
        RunLog r13 = RunLog.INSTANCE;
        StringBuilder r14 = new StringBuilder().append("query result rc=").append(r11).append(" status=").append(r8.statusCode).append(" events=");
        List<MediaEventEnvelope> r1 = r8.events;
        if (r1 != null) goto L9;
        r1 = CollectionsKt.emptyList();
    L9:
        r13.debug("AIMediaEventsGateway", r14.append(r1.size()).append(" next=").append(r8.nextSequenceNumber).append(" hasMore=").append(r8.hasMore).toString());
        if (r11 == 0) goto L12;
        return null;
    L12:
        if (r8.statusCode == 0) goto L14;
        return null;
    L14:
        return a(r8);
    }

    @Override // com.obric.memorydata.recommend.screenshotupload.sampling.aimedia.g
    public void a(int r6) {
        if (r6 > 0) goto L18;
        return;
    L18:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L11
        IAIMediaEvents r2 = ((j) ZeusTransformUtils.preCheckCast(this, j.class, "com.obric.memorydata.plugin")).a();     // Catch: Throwable -> L11
        if (r2 == null) goto L8;
        Integer r3 = Integer.valueOf(r2.unsubscribeEvents(r6));     // Catch: Throwable -> L11
    L9:
        RunLog.INSTANCE.debug("AIMediaEventsGateway", "unsubscribe id=" + r6 + " rc=" + r3);     // Catch: Throwable -> L11
        Object r4 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Throwable r5 = Result.m1424exceptionOrNullimpl(r4);
        if (r5 == null) goto L16;
        RunLog.INSTANCE.warn("AIMediaEventsGateway", "unsubscribe failed id=" + r6, r5);
    L16:
        this.c.remove(Integer.valueOf(r6));
        return;
    L8:
        r3 = null;
    L11:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r4 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L13
    }
}
