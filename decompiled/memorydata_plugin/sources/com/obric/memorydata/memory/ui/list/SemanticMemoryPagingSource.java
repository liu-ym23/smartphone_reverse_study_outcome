package com.obric.memorydata.memory.ui.list;

import android.os.Process;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.paging.PagingSource;
import androidx.paging.PagingState;
import androidx.room.InvalidationTracker;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.obric.memorydata.database.dao.SemanticMemoryDao;
import com.obric.memorydata.database.entity.ih;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000m\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006*\u0001\u0019\u0018\u0000 42\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00014BM\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u0007J\u000e\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u0007J\u000e\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u0007J\u0006\u0010\u001f\u001a\u00020\u0014J\u0010\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u0007H\u0002J#\u0010%\u001a\u0004\u0018\u00010\u00022\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030'H\u0016¢\u0006\u0002\u0010(J(\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030*2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00020,H\u0096@¢\u0006\u0002\u0010-J\u001e\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00030/2\u0006\u00100\u001a\u00020\u00022\u0006\u00101\u001a\u00020\u0002H\u0002J\b\u00102\u001a\u00020\u0002H\u0002J\u001c\u00103\u001a\u00020\u00072\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030'H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001aR\u0014\u0010\"\u001a\u00020\fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u00065"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/SemanticMemoryPagingSource;", "Landroidx/paging/PagingSource;", "", "Lcom/obric/memorydata/database/entity/SemanticMemoryWithRelevantPojo;", "dao", "Lcom/obric/memorydata/database/dao/SemanticMemoryDao;", "semanticType", "", "invalidationTracker", "Landroidx/room/InvalidationTracker;", "pageSize", "autoInvalidateOnDbChange", "", "tagForLog", "onDbChanged", "Lkotlin/Function0;", "", "<init>", "(Lcom/obric/memorydata/database/dao/SemanticMemoryDao;Ljava/lang/String;Landroidx/room/InvalidationTracker;IZLjava/lang/String;Lkotlin/jvm/functions/Function0;)V", "sourceId", "", "observerRemoved", "Ljava/util/concurrent/atomic/AtomicBoolean;", "dbChanged", "tableObserver", "com/obric/memorydata/memory/ui/list/SemanticMemoryPagingSource$tableObserver$1", "Lcom/obric/memorydata/memory/ui/list/SemanticMemoryPagingSource$tableObserver$1;", "externalInvalidate", InfoRequestQPSOptTraceLogger.REASON, "invalidateIfDbChanged", "dispose", "debugId", "removeObserverIfNeeded", "from", "jumpingSupported", "getJumpingSupported", "()Z", "getRefreshKey", "state", "Landroidx/paging/PagingState;", "(Landroidx/paging/PagingState;)Ljava/lang/Integer;", "load", "Landroidx/paging/PagingSource$LoadResult;", TrackerImpl.PARAMS, "Landroidx/paging/PagingSource$LoadParams;", "(Landroidx/paging/PagingSource$LoadParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryItems", "", "limit", TypedValues.CycleType.S_WAVE_OFFSET, "queryTotal", "buildPageSnapshot", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SemanticMemoryPagingSource extends PagingSource<Integer, ih> {
    public static final a Companion = null;
    private static final AtomicLong NEXT_ID = null;
    private static final String TAG = "SemMemPagingSource";
    private final boolean autoInvalidateOnDbChange;
    private final SemanticMemoryDao dao;
    private final AtomicBoolean dbChanged;
    private final InvalidationTracker invalidationTracker;
    private final boolean jumpingSupported;
    private final AtomicBoolean observerRemoved;
    private final Function0<Unit> onDbChanged;
    private final int pageSize;
    private final String semanticType;
    private final long sourceId;
    private final SemanticMemoryPagingSource$tableObserver$1 tableObserver;
    private final String tagForLog;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/SemanticMemoryPagingSource$Companion;", "", "<init>", "()V", "TAG", "", "NEXT_ID", "Ljava/util/concurrent/atomic/AtomicLong;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.SemanticMemoryPagingSource$load$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Landroidx/paging/PagingSource$LoadResult;", "", "Lcom/obric/memorydata/database/entity/SemanticMemoryWithRelevantPojo;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.SemanticMemoryPagingSource$load$2", f = "SemanticMemoryPagingSource.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super PagingSource.LoadResult<Integer, ih>>, Object> {
        final /* synthetic */ PagingSource.LoadParams<Integer> $params;
        int label;
        final /* synthetic */ SemanticMemoryPagingSource this$0;

        AnonymousClass2(PagingSource.LoadParams<Integer> r3, SemanticMemoryPagingSource r4, Continuation<? super AnonymousClass2> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.$params = r3;
            this.this$0 = r4;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.$params, this.this$0, r5), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super PagingSource.LoadResult<Integer, ih>> r4) {
            return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super PagingSource.LoadResult<Integer, ih>> r4) {
            return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r36) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L100;
            ResultKt.throwOnFailure(r36);
            Integer r0 = (Integer) ZeusTransformUtils.preCheckCast(this.$params.getKey(), Integer.class, "com.obric.memorydata.plugin");
            if (r0 == null) goto L7;
            int r1 = r0.intValue();
        L8:
            int r4 = RangesKt.coerceAtLeast(r1, 0);
            int r5 = this.$params.getLoadSize();
            String r9 = " invalid=";
            String r11 = " sid=";
            String r12 = "[MEM] ";
            if (AppContext.INSTANCE.isDebug() == false) goto L105;
            RunLog.INSTANCE.debug(SemanticMemoryPagingSource.TAG, "[MEM] " + SemanticMemoryPagingSource.access$getTagForLog$p(this.this$0) + " LOAD_START pid=" + Process.myPid() + " sid=" + SemanticMemoryPagingSource.access$getSourceId$p(this.this$0) + " type=" + this.$params.getClass().getSimpleName() + " offset=" + r4 + " limit=" + r5 + " invalid=" + this.this$0.getInvalid());
        L105:
            List r2 = SemanticMemoryPagingSource.access$queryItems(this.this$0, r5, r4);     // Catch: Exception -> L93
            int r13 = SemanticMemoryPagingSource.access$queryTotal(this.this$0);     // Catch: Exception -> L93
            String r16 = " offset=";
            if (ZeusTransformUtils.instanceOf(this.$params, PagingSource.LoadParams.Refresh.class) == true) goto L113;
        L43:
            String r14 = " type=";
            String r18 = " invalid=";
            String r19 = " limit=";
            String r10 = SemanticMemoryPagingSource.TAG;
            String r8 = " effectiveOffset=";
            List r21 = r2;
            int r3 = r4;
        L44:
            Integer r7 = null;
            if (r3 != 0) goto L47;
            Integer r15 = null;
        L49:
            if ((r21.size() + r3) < r13) goto L51;
        L54:
            if (r3 != 0) goto L56;
        L59:
            StringBuilder r17 = new StringBuilder();     // Catch: Exception -> L91
            r12 = "[MEM] ";
            String r28 = r10;
            r11 = " sid=";
            r14 = r14;
            StringBuilder r6 = r17.append("[MEM] ").append(SemanticMemoryPagingSource.access$getTagForLog$p(this.this$0)).append(" LOAD_DONE pid=").append(Process.myPid()).append(" sid=").append(SemanticMemoryPagingSource.access$getSourceId$p(this.this$0)).append(r14).append(this.$params.getClass().getSimpleName()).append(" requestedOffset=").append(r4).append(r8).append(r3);     // Catch: Exception -> L83
            String r20 = r19;
            StringBuilder r22 = r6.append(r20).append(r5).append(" got=").append(r21.size()).append('/').append(r13).append(" prev=").append(r15).append(" next=").append(r7);     // Catch: Exception -> L81
            r9 = r18;
            r22.append(r9);     // Catch: Exception -> L79
            r17.append(this.this$0.getInvalid());     // Catch: Exception -> L79
            String r23 = r17.toString();     // Catch: Exception -> L79
            if (r3 != 0) goto L73;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), SemanticMemoryPagingSource.TAG, r23, false, 4, null);     // Catch: Exception -> L79
            String r110 = r28;
        L119:
        L75:
            return (PagingSource.LoadResult) ZeusTransformUtils.preCheckCast(new PagingSource.LoadResult.Page(r21, r15, r7, r3, RangesKt.coerceAtLeast((r13 - r3) - r21.size(), 0)), PagingSource.LoadResult.class, "com.obric.memorydata.plugin");
        L77:
            e = e;
        L97:
            RunLog.INSTANCE.error(r110, r12 + SemanticMemoryPagingSource.access$getTagForLog$p(this.this$0) + " LOAD_FAIL pid=" + Process.myPid() + r11 + SemanticMemoryPagingSource.access$getSourceId$p(this.this$0) + r14 + this.$params.getClass().getSimpleName() + r16 + r4 + r20 + r5 + r9 + this.this$0.getInvalid(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
            return (PagingSource.LoadResult) ZeusTransformUtils.preCheckCast(new PagingSource.LoadResult.Error((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")), PagingSource.LoadResult.class, "com.obric.memorydata.plugin");
        L73:
            r110 = r28;
            RunLog.INSTANCE.debug(r110, r23);     // Catch: Exception -> L77
        L79:
            e = e;
        L88:
            r110 = r28;
        L81:
            e = e;
            r9 = r18;
        L83:
            e = e;
        L87:
            r9 = r18;
            r20 = r19;
        L85:
            e = e;
            r14 = r14;
        L89:
            e = e;
            r110 = r10;
            r11 = " sid=";
            r14 = r14;
            r9 = r18;
            r20 = r19;
        L91:
            e = e;
            r11 = " sid=";
            r12 = "[MEM] ";
            r14 = r14;
            r9 = r18;
            r20 = r19;
            r110 = r10;
            goto L97
        L56:
            if (AppContext.INSTANCE.isDebug() == true) goto L59;
            r11 = " sid=";
            r12 = "[MEM] ";
            r14 = r14;
            r9 = r18;
            r20 = r19;
            r110 = r10;
            goto L75
        L51:
            if (r21.isEmpty() == true) goto L54;
            r7 = Boxing.boxInt(r21.size() + r3);     // Catch: Exception -> L91
            goto L54
        L47:
            r15 = Boxing.boxInt(RangesKt.coerceAtLeast(r3 - SemanticMemoryPagingSource.access$getPageSize$p(this.this$0), 0));     // Catch: Exception -> L91
            goto L49
        L113:
        L41:
            e = e;
        L95:
            r14 = " type=";
        L96:
            r110 = SemanticMemoryPagingSource.TAG;
            r20 = " limit=";
            goto L97
        L15:
            if (r2.isEmpty() == false) goto L43;
            if (r13 <= 0) goto L43;
            r3 = bk.f11245a.a(r4, r13, SemanticMemoryPagingSource.access$getPageSize$p(this.this$0));     // Catch: Exception -> L41
            r14 = " type=";
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), SemanticMemoryPagingSource.TAG, "[MEM] " + SemanticMemoryPagingSource.access$getTagForLog$p(this.this$0) + " REFRESH_EMPTY_FALLBACK pid=" + Process.myPid() + " sid=" + SemanticMemoryPagingSource.access$getSourceId$p(this.this$0) + " requestedOffset=" + r4 + " fallbackOffset=" + r3 + " limit=" + r5 + " totalBeforeRetry=" + r13 + " invalid=" + this.this$0.getInvalid(), null, 4, null);     // Catch: Exception -> L39
            List r24 = SemanticMemoryPagingSource.access$queryItems(this.this$0, r5, r3);     // Catch: Exception -> L39
            r13 = SemanticMemoryPagingSource.access$queryTotal(this.this$0);     // Catch: Exception -> L39
            if (r24.isEmpty() == false) goto L25;
            if (r13 <= 0) goto L25;
            IRunLog r111 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L39
            StringBuilder r112 = new StringBuilder().append("[MEM] ").append(SemanticMemoryPagingSource.access$getTagForLog$p(this.this$0)).append(" REFRESH_EMPTY_AFTER_FALLBACK pid=").append(Process.myPid()).append(" sid=");     // Catch: Exception -> L39
            SemanticMemoryPagingSource r113 = this.this$0;     // Catch: Exception -> L39
            List r26 = r24;
            String r25 = SemanticMemoryPagingSource.TAG;
            r8 = " effectiveOffset=";
            IRunLog.a.a(r111, SemanticMemoryPagingSource.TAG, r112.append(SemanticMemoryPagingSource.access$getSourceId$p(r113)).append(" requestedOffset=").append(r4).append(r8).append(r3).append(" limit=").append(r5).append(" totalAfterRetry=").append(r13).append(" invalid=").append(this.this$0.getInvalid()).toString(), null, 4, null);     // Catch: Exception -> L36
        L34:
            r18 = " invalid=";
            r19 = " limit=";
            r10 = r25;
        L35:
            r21 = r26;
        L25:
            r26 = r24;
            r25 = SemanticMemoryPagingSource.TAG;
            r8 = " effectiveOffset=";
            if (AppContext.INSTANCE.isDebug() == false) goto L34;
            r18 = " invalid=";
            r19 = " limit=";
            r10 = r25;
            RunLog.INSTANCE.debug(r10, new StringBuilder().append("[MEM] ").append(SemanticMemoryPagingSource.access$getTagForLog$p(this.this$0)).append(" REFRESH_FALLBACK_DONE sid=").append(SemanticMemoryPagingSource.access$getSourceId$p(this.this$0)).append(" requestedOffset=").append(r4).append(r8).append(r3).append(" got=").append(r26.size()).append('/').append(r13).toString());     // Catch: Exception -> L91
        L32:
            e = e;
            r9 = r18;
            r20 = r19;
        L38:
            r110 = r25;
        L36:
            e = e;
            r9 = " invalid=";
            r20 = " limit=";
        L39:
            e = e;
            r14 = r14;
        L93:
            e = e;
            r16 = " offset=";
            goto L95
        L7:
            r1 = 0;
            goto L8
        L100:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new a(null);
        NEXT_ID = new AtomicLong(0);
    }

    /* JADX WARN: Type inference failed for: r13v4, types: [com.obric.memorydata.memory.ui.list.SemanticMemoryPagingSource$tableObserver$1, java.lang.Object] */
    public SemanticMemoryPagingSource(SemanticMemoryDao r7, String r8, InvalidationTracker r9, int r10, boolean r11, String r12, Function0<Unit> r13) {
        SemanticMemoryDao r14 = (SemanticMemoryDao) ZeusTransformUtils.wrapperContextForParams(r7, SemanticMemoryDao.class, "com.obric.memorydata.plugin");
        Function0<Unit> r15 = (Function0) ZeusTransformUtils.wrapperContextForParams(r13, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r14, "dao");
        Intrinsics.checkNotNullParameter(r9, "invalidationTracker");
        Intrinsics.checkNotNullParameter(r12, "tagForLog");
        Intrinsics.checkNotNullParameter(r15, "onDbChanged");
        this.dao = r14;
        this.semanticType = r8;
        this.invalidationTracker = r9;
        this.pageSize = r10;
        this.autoInvalidateOnDbChange = r11;
        this.tagForLog = r12;
        this.onDbChanged = r15;
        long r16 = NEXT_ID.incrementAndGet();
        this.sourceId = r16;
        this.observerRemoved = new AtomicBoolean(false);
        this.dbChanged = new AtomicBoolean(false);
        final String[] r17 = {"UnionSemanticMemory"};
        ?? r18 = new SemanticMemoryPagingSource$tableObserver$1(this, r17);
        this.tableObserver = r18;
        r9.addObserver((InvalidationTracker.Observer) ZeusTransformUtils.preCheckCast(r18, InvalidationTracker.Observer.class, "com.obric.memorydata.plugin"));
        registerInvalidatedCallback(new $$Lambda$SemanticMemoryPagingSource$rbwyh9ylTOVoxNmt_RhKeXD7g(this));
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[MEM] " + r12 + " SOURCE_CREATED pid=" + Process.myPid() + " sid=" + r16 + " auto=" + r11, false, 4, null);
        this.jumpingSupported = true;
    }

    public /* synthetic */ SemanticMemoryPagingSource(SemanticMemoryDao r11, String r12, InvalidationTracker r13, int r14, boolean r15, String r16, Function0 r17, int r18, DefaultConstructorMarker r19) {
        SemanticMemoryDao r3 = (SemanticMemoryDao) ZeusTransformUtils.wrapperContextForParams(r11, SemanticMemoryDao.class, "com.obric.memorydata.plugin");
        Function0 r0 = (Function0) ZeusTransformUtils.wrapperContextForParams(r17, Function0.class, "com.obric.memorydata.plugin");
        if ((r18 & 16) == 0) goto L5;
        boolean r7 = false;
    L7:
        if ((r18 & 32) == 0) goto L12;
        if (r12 != null) goto L10;
        String r1 = LocationAnnotation.LightLocationType.LIGHT_LOCATION_ALL;
    L11:
        String r8 = r1;
    L14:
        if ((r18 & 64) == 0) goto L16;
        r0 = $$Lambda$SemanticMemoryPagingSource$L2eK878t6ih58DcKW5i4Bqaco2M.INSTANCE;
    L16:
        this(r3, r12, r13, r14, r7, r8, r0);
        return;
    L10:
        r1 = r12;
        goto L11
    L12:
        r8 = r16;
        goto L14
    L5:
        r7 = r15;
        goto L7
    }

    private static final Unit _init_$lambda$0() {
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$1(SemanticMemoryPagingSource r1) {
        r1.removeObserverIfNeeded("invalidated");
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ boolean access$getAutoInvalidateOnDbChange$p(SemanticMemoryPagingSource r0) {
        return r0.autoInvalidateOnDbChange;
    }

    public static final /* synthetic */ AtomicBoolean access$getDbChanged$p(SemanticMemoryPagingSource r0) {
        return r0.dbChanged;
    }

    public static final /* synthetic */ Function0 access$getOnDbChanged$p(SemanticMemoryPagingSource r0) {
        return r0.onDbChanged;
    }

    public static final /* synthetic */ int access$getPageSize$p(SemanticMemoryPagingSource r0) {
        return r0.pageSize;
    }

    public static final /* synthetic */ long access$getSourceId$p(SemanticMemoryPagingSource r2) {
        return r2.sourceId;
    }

    public static final /* synthetic */ String access$getTagForLog$p(SemanticMemoryPagingSource r0) {
        return r0.tagForLog;
    }

    public static final /* synthetic */ List access$queryItems(SemanticMemoryPagingSource r0, int r1, int r2) {
        return r0.queryItems(r1, r2);
    }

    public static final /* synthetic */ int access$queryTotal(SemanticMemoryPagingSource r0) {
        return r0.queryTotal();
    }

    private final String buildPageSnapshot(PagingState<Integer, ih> r11) {
        return CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r11.getPages(), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(";", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("pageSnapshot=[", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("]", CharSequence.class, "com.obric.memorydata.plugin"), 0, null, $$Lambda$SemanticMemoryPagingSource$QqnDVcPgj6vLsDv2kHzXedFm7EI.INSTANCE, 24, null);
    }

    private static final CharSequence buildPageSnapshot$lambda$3(PagingSource.LoadResult.Page r2) {
        Intrinsics.checkNotNullParameter(r2, "page");
        return (CharSequence) ZeusTransformUtils.preCheckCast("prev=" + r2.getPrevKey() + ",next=" + r2.getNextKey() + ",data=" + r2.getData().size() + ",before=" + r2.getItemsBefore() + ",after=" + r2.getItemsAfter(), CharSequence.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ Unit lambda$L2eK878t6ih58DcKW5i4Bqaco2M() {
        return _init_$lambda$0();
    }

    public static /* synthetic */ CharSequence lambda$QqnDVcPgj6vLsDv2kHzXedFm7EI(PagingSource.LoadResult.Page r0) {
        return buildPageSnapshot$lambda$3(r0);
    }

    /* JADX INFO: renamed from: lambda$rbwyh9yl-TOVoxNmt_RhKe-XD7g, reason: not valid java name */
    public static /* synthetic */ Unit m926lambda$rbwyh9ylTOVoxNmt_RhKeXD7g(SemanticMemoryPagingSource r0) {
        return _init_$lambda$1(r0);
    }

    private final List<ih> queryItems(int r2, int r3) {
        String r0 = this.semanticType;
        SemanticMemoryDao r1 = this.dao;
        if (r0 != null) goto L6;
        return r1.queryAllRangeWithRelevant(r2, r3);
    L6:
        return r1.queryRangeBySemanticTypeWithRelevant(r0, r2, r3);
    }

    private final int queryTotal() {
        String r0 = this.semanticType;
        SemanticMemoryDao r1 = this.dao;
        if (r0 != null) goto L6;
        return r1.countAllInfoSync();
    L6:
        return r1.countBySemanticTypeSync(r0);
    }

    private final void removeObserverIfNeeded(String r8) {
        if (this.observerRemoved.compareAndSet(false, true) == false) goto L5;
        this.invalidationTracker.removeObserver((InvalidationTracker.Observer) ZeusTransformUtils.preCheckCast(this.tableObserver, InvalidationTracker.Observer.class, "com.obric.memorydata.plugin"));
        RunLog r0 = RunLog.INSTANCE;
        StringBuilder r2 = new StringBuilder().append("[MEM] ").append(this.tagForLog);
        String r4 = " OBSERVER_REMOVED sid=";
    L6:
        r0.debug(TAG, r2.append(r4).append(this.sourceId).append(" from=").append(r8).toString());
        return;
    L5:
        r0 = RunLog.INSTANCE;
        r2 = new StringBuilder().append("[MEM] ").append(this.tagForLog);
        r4 = " OBSERVER_ALREADY_REMOVED sid=";
        goto L6
    }

    public final long debugId() {
        return this.sourceId;
    }

    public final void dispose(String r8) {
        Intrinsics.checkNotNullParameter(r8, InfoRequestQPSOptTraceLogger.REASON);
        if (this.observerRemoved.get() == true) goto L5;
    L7:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[MEM] " + this.tagForLog + " DISPOSE sid=" + this.sourceId + " reason=" + r8 + " invalid=" + getInvalid(), false, 4, null);
        removeObserverIfNeeded("dispose");
        if (getInvalid() == true) goto L11;
        invalidate();
        return;
    L11:
        return;
    L5:
        if (getInvalid() == false) goto L7;
    }

    public final void externalInvalidate(String r8) {
        Intrinsics.checkNotNullParameter(r8, InfoRequestQPSOptTraceLogger.REASON);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[MEM] " + this.tagForLog + " EXTERNAL_INVALIDATE sid=" + this.sourceId + " reason=" + r8 + " invalid=" + getInvalid(), false, 4, null);
        invalidate();
    }

    @Override // androidx.paging.PagingSource
    public boolean getJumpingSupported() {
        return this.jumpingSupported;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.paging.PagingSource
    public Integer getRefreshKey(PagingState<Integer, ih> r15) {
        Intrinsics.checkNotNullParameter(r15, "state");
        Integer r0 = r15.getAnchorPosition();
        if (r0 == null) goto L16;
        int r1 = r0.intValue();
        int r6 = this.pageSize;
        int r7 = (r1 / r6) * r6;
        if (AppContext.INSTANCE.isDebug() == false) goto L7;
        StringBuilder r14 = new StringBuilder().append("[MEM] ").append(this.tagForLog).append(" REFRESH_KEY sid=").append(this.sourceId).append(" anchor=").append(r1).append(" key=").append(r7).append(" pages=").append(r15.getPages().size()).append(' ').append(buildPageSnapshot(r15));
    L8:
        String r16 = r14.toString();
        if (r7 <= 0) goto L12;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, r16, false, 4, null);
    L15:
        return Integer.valueOf(r7);
    L12:
        if (AppContext.INSTANCE.isDebug() == false) goto L15;
        RunLog.INSTANCE.debug(TAG, r16);
        goto L15
    L7:
        r14 = new StringBuilder().append("[MEM] ").append(this.tagForLog).append(" REFRESH_KEY sid=").append(this.sourceId).append(" anchor=").append(r1).append(" key=").append(r7).append(" pages=").append(r15.getPages().size());
        goto L8
    L16:
        SemanticMemoryPagingSource r17 = (SemanticMemoryPagingSource) ZeusTransformUtils.preCheckCast(this, SemanticMemoryPagingSource.class, "com.obric.memorydata.plugin");
        if (AppContext.INSTANCE.isDebug() == false) goto L20;
        RunLog.INSTANCE.debug(TAG, "[MEM] " + r17.tagForLog + " REFRESH_KEY sid=" + r17.sourceId + " anchor=null key=0 pages=" + r15.getPages().size() + ' ' + r17.buildPageSnapshot(r15));
    L20:
        return 0;
    }

    @Override // androidx.paging.PagingSource
    public /* bridge */ /* synthetic */ Integer getRefreshKey(PagingState<Integer, ih> r1) {
        return getRefreshKey(r1);
    }

    public final boolean invalidateIfDbChanged(String r10) {
        Intrinsics.checkNotNullParameter(r10, InfoRequestQPSOptTraceLogger.REASON);
        if (this.dbChanged.get() == false) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[MEM] " + this.tagForLog + " INVALIDATE_IF_DB_CHANGED sid=" + this.sourceId + " reason=" + r10 + " invalid=" + getInvalid(), false, 4, null);
        invalidate();
        return true;
    L6:
        RunLog.INSTANCE.debug(TAG, "[MEM] " + this.tagForLog + " SKIP_INVALIDATE_IF_DB_CHANGED sid=" + this.sourceId + " reason=" + r10);
        return false;
    }

    @Override // androidx.paging.PagingSource
    public Object load(PagingSource.LoadParams<Integer> r5, Continuation<? super PagingSource.LoadResult<Integer, ih>> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        return kotlinx.coroutines.i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r5, this, null), Function2.class, "com.obric.memorydata.plugin"), r7);
    }
}
