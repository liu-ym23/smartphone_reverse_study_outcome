package com.obric.memorydata.memory.ui.list.contextawareness;

import android.database.sqlite.SQLiteException;
import androidx.paging.PagingSource;
import androidx.paging.PagingState;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.ba;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001bB\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001e\u0010\n\u001a\u0004\u0018\u00010\u00022\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\fH\u0016J(\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0011J\"\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\"\u0010\u0018\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J \u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTimelinePagingSource;", "Landroidx/paging/PagingSource;", "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTimelineCursor;", "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTimelineRecord;", "repository", "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTimelinePageRepository;", "dayRange", "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessDayRange;", "<init>", "(Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTimelinePageRepository;Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessDayRange;)V", "getRefreshKey", "state", "Landroidx/paging/PagingState;", "load", "Landroidx/paging/PagingSource$LoadResult;", TrackerImpl.PARAMS, "Landroidx/paging/PagingSource$LoadParams;", "(Landroidx/paging/PagingSource$LoadParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadRefresh", "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTimelinePagingSource$LoadWindow;", "anchor", "loadSize", "", "queryLimit", "loadAfter", "cursor", "loadBefore", "LoadWindow", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ContextAwarenessTimelinePagingSource extends PagingSource<p, t> {
    private final d dayRange;
    private final q repository;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTimelinePagingSource$LoadWindow;", "", "records", "", "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTimelineRecord;", "hasNewer", "", "hasOlder", "<init>", "(Ljava/util/List;ZZ)V", "getRecords", "()Ljava/util/List;", "getHasNewer", "()Z", "getHasOlder", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<t> f11256a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f11257b;
        private final boolean c;

        public a(List<t> r3, boolean r4, boolean r5) {
            List<t> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "records");
            this.f11256a = r6;
            this.f11257b = r4;
            this.c = r5;
        }

        public final List<t> a() {
            return this.f11256a;
        }

        public final boolean b() {
            return this.f11257b;
        }

        public final boolean c() {
            return this.c;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f11256a, r6.f11256a) == true) goto L12;
            return false;
        L12:
            if (this.f11257b == r6.f11257b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f11256a.hashCode() * 31) + Boolean.hashCode(this.f11257b)) * 31) + Boolean.hashCode(this.c);
        }

        public String toString() {
            return "LoadWindow(records=" + this.f11256a + ", hasNewer=" + this.f11257b + ", hasOlder=" + this.c + ')';
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelinePagingSource$load$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Landroidx/paging/PagingSource$LoadResult;", "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTimelineCursor;", "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTimelineRecord;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelinePagingSource$load$2", f = "ContextAwarenessTimelinePagingSource.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<al, Continuation<? super PagingSource.LoadResult<p, t>>, Object> {
        final /* synthetic */ PagingSource.LoadParams<p> $params;
        int label;
        final /* synthetic */ ContextAwarenessTimelinePagingSource this$0;

        AnonymousClass2(PagingSource.LoadParams<p> r3, ContextAwarenessTimelinePagingSource r4, Continuation<? super AnonymousClass2> r5) {
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
        public /* synthetic */ Object invoke(al r3, Continuation<? super PagingSource.LoadResult<p, t>> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super PagingSource.LoadResult<p, t>> r4) {
            return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L38;
            ResultKt.throwOnFailure(r6);
            int r7 = this.$params.getLoadSize() + 1;     // Catch: SQLiteException -> L34
            PagingSource.LoadParams<p> r1 = this.$params;     // Catch: SQLiteException -> L34
            if (ZeusTransformUtils.instanceOf(r1, PagingSource.LoadParams.Prepend.class) == false) goto L9;
            a r5 = ContextAwarenessTimelinePagingSource.access$loadBefore(this.this$0, (p) ZeusTransformUtils.preCheckCast(((PagingSource.LoadParams.Prepend) ZeusTransformUtils.preCheckCast(this.$params, PagingSource.LoadParams.Prepend.class, "com.obric.memorydata.plugin")).getKey(), p.class, "com.obric.memorydata.plugin"), ((PagingSource.LoadParams.Prepend) ZeusTransformUtils.preCheckCast(this.$params, PagingSource.LoadParams.Prepend.class, "com.obric.memorydata.plugin")).getLoadSize(), r7);     // Catch: SQLiteException -> L34
        L14:
            List<t> r8 = r5.a();     // Catch: SQLiteException -> L34
            t r2 = (t) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r5.a()), t.class, "com.obric.memorydata.plugin");     // Catch: SQLiteException -> L34
            p r3 = null;
            if (r2 != null) goto L17;
        L22:
            p r4 = null;
        L23:
            t r9 = (t) ZeusTransformUtils.preCheckCast(CollectionsKt.lastOrNull(r5.a()), t.class, "com.obric.memorydata.plugin");     // Catch: SQLiteException -> L34
            if (r9 == null) goto L40;
            if (r5.c() == true) goto L29;
            r9 = null;
        L29:
            if (r9 == null) goto L40;
            r3 = p.f11283a.a(r9);     // Catch: SQLiteException -> L34
        L40:
            return (PagingSource.LoadResult) ZeusTransformUtils.preCheckCast(new PagingSource.LoadResult.Page(r8, r4, r3), PagingSource.LoadResult.class, "com.obric.memorydata.plugin");
        L17:
            if (r5.b() == true) goto L20;
            r2 = null;
        L20:
            if (r2 == null) goto L22;
            r4 = p.f11283a.a(r2);     // Catch: SQLiteException -> L34
            goto L23
        L9:
            if (ZeusTransformUtils.instanceOf(r1, PagingSource.LoadParams.Append.class) == false) goto L12;
            r5 = ContextAwarenessTimelinePagingSource.access$loadAfter(this.this$0, (p) ZeusTransformUtils.preCheckCast(((PagingSource.LoadParams.Append) ZeusTransformUtils.preCheckCast(this.$params, PagingSource.LoadParams.Append.class, "com.obric.memorydata.plugin")).getKey(), p.class, "com.obric.memorydata.plugin"), ((PagingSource.LoadParams.Append) ZeusTransformUtils.preCheckCast(this.$params, PagingSource.LoadParams.Append.class, "com.obric.memorydata.plugin")).getLoadSize(), r7);     // Catch: SQLiteException -> L34
            goto L14
        L12:
            if (ZeusTransformUtils.instanceOf(r1, PagingSource.LoadParams.Refresh.class) == false) goto L33;
            r5 = ContextAwarenessTimelinePagingSource.access$loadRefresh(this.this$0, (p) ZeusTransformUtils.preCheckCast(((PagingSource.LoadParams.Refresh) ZeusTransformUtils.preCheckCast(this.$params, PagingSource.LoadParams.Refresh.class, "com.obric.memorydata.plugin")).getKey(), p.class, "com.obric.memorydata.plugin"), ((PagingSource.LoadParams.Refresh) ZeusTransformUtils.preCheckCast(this.$params, PagingSource.LoadParams.Refresh.class, "com.obric.memorydata.plugin")).getLoadSize(), r7);     // Catch: SQLiteException -> L34
            goto L14
        L33:
            throw new NoWhenBranchMatchedException();     // Catch: SQLiteException -> L34
        L34:
            e = move-exception;
            return (PagingSource.LoadResult) ZeusTransformUtils.preCheckCast(new PagingSource.LoadResult.Error((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")), PagingSource.LoadResult.class, "com.obric.memorydata.plugin");
        L38:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public ContextAwarenessTimelinePagingSource(q r3, d r4) {
        q r5 = (q) ZeusTransformUtils.wrapperContextForParams(r3, q.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "repository");
        Intrinsics.checkNotNullParameter(r4, "dayRange");
        this.repository = r5;
        this.dayRange = r4;
    }

    public /* synthetic */ ContextAwarenessTimelinePagingSource(q r2, d r3, int r4, DefaultConstructorMarker r5) {
        q r6 = (q) ZeusTransformUtils.wrapperContextForParams(r2, q.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r3 = d.f11265a.a();
    L5:
        this(r6, r3);
    }

    public static final /* synthetic */ a access$loadAfter(ContextAwarenessTimelinePagingSource r0, p r1, int r2, int r3) {
        return r0.loadAfter(r1, r2, r3);
    }

    public static final /* synthetic */ a access$loadBefore(ContextAwarenessTimelinePagingSource r0, p r1, int r2, int r3) {
        return r0.loadBefore(r1, r2, r3);
    }

    public static final /* synthetic */ a access$loadRefresh(ContextAwarenessTimelinePagingSource r0, p r1, int r2, int r3) {
        return r0.loadRefresh(r1, r2, r3);
    }

    private final a loadAfter(p r4, int r5, int r6) {
        List<t> r3 = this.repository.a(this.dayRange, r4, r6);
        List r7 = CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin"), r5);
        boolean r0 = true;
        if (r4 == null) goto L5;
        boolean r8 = true;
    L7:
        if (r3.size() > r7.size()) goto L11;
        r0 = false;
    L11:
        return new a(r7, r8, r0);
    L5:
        r8 = false;
        goto L7
    }

    private final a loadBefore(p r3, int r4, int r5) {
        List<t> r2 = this.repository.b(this.dayRange, r3, r5);
        List r6 = CollectionsKt.takeLast(r2, r4);
        if (r2.size() <= r6.size()) goto L5;
        boolean r7 = true;
    L7:
        return new a(r6, r7, !((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin")).isEmpty());
    L5:
        r7 = false;
        goto L7
    }

    private final a loadRefresh(p r6, int r7, int r8) {
        p r0 = null;
        if (r6 == null) goto L5;
        int r3 = r7 / 2;
        List<t> r9 = this.repository.b(this.dayRange, r6, r3 + 1);
        boolean r2 = false;
        if (r9.size() <= r3) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == true) goto L14;
        r9 = null;
    L14:
        if (r9 == null) goto L18;
        t r10 = (t) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r9), t.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L18;
        r0 = p.f11283a.a(r10);
    L18:
        List<t> r5 = this.repository.a(this.dayRange, r0, r8);
        List r11 = CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin"), r7);
        if (r0 == null) goto L21;
        boolean r12 = true;
    L23:
        if (r5.size() <= r11.size()) goto L26;
        r2 = true;
    L26:
        return new a(r11, r12, r2);
    L21:
        r12 = false;
        goto L23
    L9:
        r1 = false;
        goto L10
    L5:
        return loadAfter(null, r7, r8);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.paging.PagingSource
    public p getRefreshKey(PagingState<p, t> r3) {
        Intrinsics.checkNotNullParameter(r3, "state");
        Integer r2 = r3.getAnchorPosition();
        if (r2 == null) goto L8;
        t r4 = (t) ZeusTransformUtils.preCheckCast(r3.closestItemToPosition(r2.intValue()), t.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L7;
        return null;
    L7:
        return p.f11283a.a(r4);
    L8:
        return null;
    }

    @Override // androidx.paging.PagingSource
    public /* bridge */ /* synthetic */ p getRefreshKey(PagingState<p, t> r1) {
        return getRefreshKey(r1);
    }

    @Override // androidx.paging.PagingSource
    public Object load(PagingSource.LoadParams<p> r5, Continuation<? super PagingSource.LoadResult<p, t>> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        return kotlinx.coroutines.i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r5, this, null), Function2.class, "com.obric.memorydata.plugin"), r7);
    }
}
