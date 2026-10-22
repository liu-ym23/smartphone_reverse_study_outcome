package androidx.room.paging;

import android.database.Cursor;
import androidx.paging.PagingSource;
import androidx.paging.PagingState;
import androidx.room.CoroutinesRoomKt;
import androidx.room.RoomDatabase;
import androidx.room.RoomDatabaseKt;
import androidx.room.RoomSQLiteQuery;
import androidx.room.paging.util.RoomPagingUtilKt;
import androidx.room.paging.util.ThreadSafeInvalidationObserver;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b'\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002H\u00010\u0003B+\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n\"\u00020\u000b¢\u0006\u0002\u0010\fB)\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n\"\u00020\u000b¢\u0006\u0002\u0010\u000fJ\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH%J#\u0010\u001e\u001a\u0004\u0018\u00010\u00042\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000 H\u0016¢\u0006\u0002\u0010!J+\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000#2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040%H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010&J+\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000#2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040%H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010&J3\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000#2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040%2\u0006\u0010)\u001a\u00020\u0004H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010*R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u0011X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006+"}, d2 = {"Landroidx/room/paging/LimitOffsetPagingSource;", "Value", "", "Landroidx/paging/PagingSource;", "", "supportSQLiteQuery", "Landroidx/sqlite/db/SupportSQLiteQuery;", "db", "Landroidx/room/RoomDatabase;", "tables", "", "", "(Landroidx/sqlite/db/SupportSQLiteQuery;Landroidx/room/RoomDatabase;[Ljava/lang/String;)V", "sourceQuery", "Landroidx/room/RoomSQLiteQuery;", "(Landroidx/room/RoomSQLiteQuery;Landroidx/room/RoomDatabase;[Ljava/lang/String;)V", "itemCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "getItemCount$room_paging_release", "()Ljava/util/concurrent/atomic/AtomicInteger;", "jumpingSupported", "", "getJumpingSupported", "()Z", "observer", "Landroidx/room/paging/util/ThreadSafeInvalidationObserver;", "convertRows", "", "cursor", "Landroid/database/Cursor;", "getRefreshKey", "state", "Landroidx/paging/PagingState;", "(Landroidx/paging/PagingState;)Ljava/lang/Integer;", "initialLoad", "Landroidx/paging/PagingSource$LoadResult;", TrackerImpl.PARAMS, "Landroidx/paging/PagingSource$LoadParams;", "(Landroidx/paging/PagingSource$LoadParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "nonInitialLoad", "tempCount", "(Landroidx/paging/PagingSource$LoadParams;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "room-paging_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class LimitOffsetPagingSource<Value> extends PagingSource<Integer, Value> {
    private final RoomDatabase db;
    private final AtomicInteger itemCount;
    private final ThreadSafeInvalidationObserver observer;
    private final RoomSQLiteQuery sourceQuery;

    /* JADX INFO: renamed from: androidx.room.paging.LimitOffsetPagingSource$initialLoad$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "Landroidx/paging/PagingSource$LoadResult;", "", "Value", ""}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "androidx.room.paging.LimitOffsetPagingSource$initialLoad$2", f = "LimitOffsetPagingSource.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super PagingSource.LoadResult<Integer, Value>>, Object> {
        final /* synthetic */ PagingSource.LoadParams<Integer> $params;
        int label;
        final /* synthetic */ LimitOffsetPagingSource<Value> this$0;

        /* JADX INFO: renamed from: androidx.room.paging.LimitOffsetPagingSource$initialLoad$2$1, reason: invalid class name */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Cursor, List<? extends Value>> {
            AnonymousClass1(Object r8) {
                super(1, r8, LimitOffsetPagingSource.class, "convertRows", "convertRows(Landroid/database/Cursor;)Ljava/util/List;", 0);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ Object invoke(Cursor r3) {
                return invoke2((Cursor) ZeusTransformUtils.preCheckCast(r3, Cursor.class, "com.obric.memorydata.plugin"));
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final List<Value> invoke2(Cursor r3) {
                Cursor r4 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r3, Cursor.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r4, "p0");
                return ((LimitOffsetPagingSource) ZeusTransformUtils.preCheckCast(this.receiver, LimitOffsetPagingSource.class, "com.obric.memorydata.plugin")).convertRows(r4);
            }
        }

        AnonymousClass2(LimitOffsetPagingSource<Value> r3, PagingSource.LoadParams<Integer> r4, Continuation<? super AnonymousClass2> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$params = r4;
            super(1, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.this$0, this.$params, r5), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Object invoke(Object r3) {
            return invoke((Continuation) ZeusTransformUtils.preCheckCast(r3, Continuation.class, "com.obric.memorydata.plugin"));
        }

        public final Object invoke(Continuation<? super PagingSource.LoadResult<Integer, Value>> r3) {
            return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r10);
            int r4 = RoomPagingUtilKt.queryItemCount(LimitOffsetPagingSource.access$getSourceQuery$p(this.this$0), LimitOffsetPagingSource.access$getDb$p(this.this$0));
            this.this$0.getItemCount$room_paging_release().set(r4);
            return RoomPagingUtilKt.queryDatabase$default(this.$params, LimitOffsetPagingSource.access$getSourceQuery$p(this.this$0), LimitOffsetPagingSource.access$getDb$p(this.this$0), r4, null, (Function1) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0), Function1.class, "com.obric.memorydata.plugin"), 16, null);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: androidx.room.paging.LimitOffsetPagingSource$load$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004*\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "Landroidx/paging/PagingSource$LoadResult;", "", "Value", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "androidx.room.paging.LimitOffsetPagingSource$load$2", f = "LimitOffsetPagingSource.kt", i = {}, l = {75, 77}, m = "invokeSuspend", n = {}, s = {})
    static final class C09762 extends SuspendLambda implements Function2<al, Continuation<? super PagingSource.LoadResult<Integer, Value>>, Object> {
        final /* synthetic */ PagingSource.LoadParams<Integer> $params;
        int label;
        final /* synthetic */ LimitOffsetPagingSource<Value> this$0;

        C09762(LimitOffsetPagingSource<Value> r3, PagingSource.LoadParams<Integer> r4, Continuation<? super C09762> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$params = r4;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C09762(this.this$0, this.$params, r5), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Object r4) {
            return invoke((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        public final Object invoke(al r3, Continuation<? super PagingSource.LoadResult<Integer, Value>> r4) {
            return ((C09762) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C09762.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 == 2) goto L9;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r7);
        L19:
            return (PagingSource.LoadResult) ZeusTransformUtils.preCheckCast(r7, PagingSource.LoadResult.class, "com.obric.memorydata.plugin");
        L10:
            ResultKt.throwOnFailure(r7);
            LimitOffsetPagingSource.access$getObserver$p(this.this$0).registerIfNecessary(LimitOffsetPagingSource.access$getDb$p(this.this$0));
            int r8 = this.this$0.getItemCount$room_paging_release().get();
            if (r8 != (-1)) goto L16;
            LimitOffsetPagingSource<Value> r9 = this.this$0;
            PagingSource.LoadParams<Integer> r2 = this.$params;
            Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r7 = LimitOffsetPagingSource.access$initialLoad(r9, r2, r3);
            if (r7 != r0) goto L19;
            return r0;
        L16:
            LimitOffsetPagingSource<Value> r4 = this.this$0;
            PagingSource.LoadParams<Integer> r5 = this.$params;
            Continuation r6 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 2;
            r7 = LimitOffsetPagingSource.access$nonInitialLoad(r4, r5, r8, r6);
            if (r7 != r0) goto L19;
            return r0;
        }
    }

    public LimitOffsetPagingSource(RoomSQLiteQuery r3, RoomDatabase r4, String... r5) {
        Intrinsics.checkNotNullParameter(r3, "sourceQuery");
        Intrinsics.checkNotNullParameter(r4, "db");
        Intrinsics.checkNotNullParameter(r5, "tables");
        this.sourceQuery = r3;
        this.db = r4;
        this.itemCount = new AtomicInteger(-1);
        this.observer = new ThreadSafeInvalidationObserver(r5, (Function0) ZeusTransformUtils.preCheckCast(new LimitOffsetPagingSource$observer$1(this), Function0.class, "com.obric.memorydata.plugin"));
    }

    public LimitOffsetPagingSource(SupportSQLiteQuery r3, RoomDatabase r4, String... r5) {
        SupportSQLiteQuery r6 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "supportSQLiteQuery");
        Intrinsics.checkNotNullParameter(r4, "db");
        Intrinsics.checkNotNullParameter(r5, "tables");
        this(RoomSQLiteQuery.Companion.copyFrom(r6), r4, (String[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r5, r5.length), String[].class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ RoomDatabase access$getDb$p(LimitOffsetPagingSource r0) {
        return r0.db;
    }

    public static final /* synthetic */ ThreadSafeInvalidationObserver access$getObserver$p(LimitOffsetPagingSource r0) {
        return r0.observer;
    }

    public static final /* synthetic */ RoomSQLiteQuery access$getSourceQuery$p(LimitOffsetPagingSource r0) {
        return r0.sourceQuery;
    }

    public static final /* synthetic */ Object access$initialLoad(LimitOffsetPagingSource r2, PagingSource.LoadParams r3, Continuation r4) {
        return r2.initialLoad(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ Object access$nonInitialLoad(LimitOffsetPagingSource r2, PagingSource.LoadParams r3, int r4, Continuation r5) {
        return r2.nonInitialLoad(r3, r4, (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    private final Object initialLoad(PagingSource.LoadParams<Integer> r5, Continuation<? super PagingSource.LoadResult<Integer, Value>> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        return RoomDatabaseKt.withTransaction(this.db, (Function1) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this, r5, null), Function1.class, "com.obric.memorydata.plugin"), r7);
    }

    static /* synthetic */ Object load$suspendImpl(LimitOffsetPagingSource<Value> r4, PagingSource.LoadParams<Integer> r5, Continuation<? super PagingSource.LoadResult<Integer, Value>> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        return i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(CoroutinesRoomKt.getQueryDispatcher(((LimitOffsetPagingSource) r4).db), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new C09762(r4, r5, null), Function2.class, "com.obric.memorydata.plugin"), r7);
    }

    private final Object nonInitialLoad(PagingSource.LoadParams<Integer> r11, int r12, Continuation<? super PagingSource.LoadResult<Integer, Value>> r13) {
        Continuation r14 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin");
        PagingSource.LoadResult r15 = RoomPagingUtilKt.queryDatabase$default(r11, this.sourceQuery, this.db, r12, null, (Function1) ZeusTransformUtils.preCheckCast(new LimitOffsetPagingSource$nonInitialLoad$loadResult$1(this), Function1.class, "com.obric.memorydata.plugin"), 16, null);
        this.db.getInvalidationTracker().refreshVersionsSync();
        if (getInvalid() == false) goto L6;
        PagingSource.LoadResult.Invalid<Object, Object> r10 = RoomPagingUtilKt.getINVALID();
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type androidx.paging.PagingSource.LoadResult.Invalid<kotlin.Int, Value of androidx.room.paging.LimitOffsetPagingSource>");
        return (PagingSource.LoadResult) ZeusTransformUtils.preCheckCast(r10, PagingSource.LoadResult.class, "com.obric.memorydata.plugin");
    L6:
        return r15;
    }

    public abstract List<Value> convertRows(Cursor r1);

    public final AtomicInteger getItemCount$room_paging_release() {
        return this.itemCount;
    }

    @Override // androidx.paging.PagingSource
    public boolean getJumpingSupported() {
        return true;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.paging.PagingSource
    public Integer getRefreshKey(PagingState<Integer, Value> r1) {
        Intrinsics.checkNotNullParameter(r1, "state");
        return RoomPagingUtilKt.getClippedRefreshKey(r1);
    }

    @Override // androidx.paging.PagingSource
    public /* bridge */ /* synthetic */ Integer getRefreshKey(PagingState r1) {
        return getRefreshKey(r1);
    }

    @Override // androidx.paging.PagingSource
    public Object load(PagingSource.LoadParams<Integer> r3, Continuation<? super PagingSource.LoadResult<Integer, Value>> r4) {
        return load$suspendImpl(this, r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }
}
