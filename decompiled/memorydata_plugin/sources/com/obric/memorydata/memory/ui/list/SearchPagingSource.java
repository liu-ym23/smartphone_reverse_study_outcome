package com.obric.memorydata.memory.ui.list;

import androidx.paging.PagingSource;
import androidx.paging.PagingState;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.memory.memoryentity.search.MemorySearchResultCategory;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.da;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bH\u0096@¢\u0006\u0002\u0010\fJ#\u0010\r\u001a\u0004\u0018\u00010\u00022\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000fH\u0016¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/SearchPagingSource;", "Landroidx/paging/PagingSource;", "", "Lcom/obric/memorydata/memory/memoryentity/search/MemorySearchResult;", "cache", "Lcom/obric/memorydata/memory/ui/list/SearchResultCache;", "<init>", "(Lcom/obric/memorydata/memory/ui/list/SearchResultCache;)V", "load", "Landroidx/paging/PagingSource$LoadResult;", TrackerImpl.PARAMS, "Landroidx/paging/PagingSource$LoadParams;", "(Landroidx/paging/PagingSource$LoadParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRefreshKey", "state", "Landroidx/paging/PagingState;", "(Landroidx/paging/PagingState;)Ljava/lang/Integer;", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SearchPagingSource extends PagingSource<Integer, com.obric.memorydata.memory.memoryentity.search.c> {
    public static final a Companion = null;
    private static final String TAG = "SearchPagingSource";
    private static final long TIME_OUT = 15000;
    private final bh cache;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/SearchPagingSource$Companion;", "", "<init>", "()V", "TAG", "", "TIME_OUT", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.SearchPagingSource$load$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.SearchPagingSource", f = "MemorySearchResultCache.kt", i = {0, 0, 0, 0}, l = {253}, m = "load", n = {"this", EventBody.KEY_CATEGORY, "position", "loadSize"}, s = {"L$0", "L$1", "I$0", "I$1"})
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SearchPagingSource this$0;

        AnonymousClass1(SearchPagingSource r3, Continuation<? super AnonymousClass1> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.load(null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        Companion = new a(null);
    }

    public SearchPagingSource(bh r2) {
        Intrinsics.checkNotNullParameter(r2, "cache");
        this.cache = r2;
        r2.a(this);
    }

    public static final /* synthetic */ bh access$getCache$p(SearchPagingSource r0) {
        return r0.cache;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.paging.PagingSource
    public Integer getRefreshKey(PagingState<Integer, com.obric.memorydata.memory.memoryentity.search.c> r5) {
        Intrinsics.checkNotNullParameter(r5, "state");
        Integer r4 = r5.getAnchorPosition();
        if (r4 == null) goto L14;
        PagingSource.LoadResult.Page<Integer, com.obric.memorydata.memory.memoryentity.search.c> r6 = r5.closestPageToPosition(((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).intValue());
        if (r6 == null) goto L10;
        Integer r1 = (Integer) ZeusTransformUtils.preCheckCast(r6.getPrevKey(), Integer.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L10;
        int r7 = r1.intValue() + r5.getConfig().pageSize;
    L15:
        return Integer.valueOf(r7);
    L10:
        if (r6 == null) goto L16;
        Integer r8 = (Integer) ZeusTransformUtils.preCheckCast(r6.getNextKey(), Integer.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L17;
        r7 = r8.intValue() - r5.getConfig().pageSize;
        goto L15
    L17:
        return null;
    L16:
        return null;
    L14:
        return null;
    }

    @Override // androidx.paging.PagingSource
    public /* bridge */ /* synthetic */ Integer getRefreshKey(PagingState<Integer, com.obric.memorydata.memory.memoryentity.search.c> r1) {
        return getRefreshKey(r1);
    }

    @Override // androidx.paging.PagingSource
    public Object load(PagingSource.LoadParams<Integer> r20, Continuation<? super PagingSource.LoadResult<Integer, com.obric.memorydata.memory.memoryentity.search.c>> r21) {
        SearchPagingSource r0 = this;
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r21, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, AnonymousClass1.class) == false) goto L7;
        AnonymousClass1 r4 = (AnonymousClass1) ZeusTransformUtils.preCheckCast(r2, AnonymousClass1.class, "com.obric.memorydata.plugin");
        if ((r4.label & Integer.MIN_VALUE) == 0) goto L7;
        r4.label -= Integer.MIN_VALUE;
    L8:
        Object r3 = r4.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r4.label;
        Integer r8 = null;
        if (r6 == 0) goto L16;
        if (r6 != 1) goto L15;
        int r1 = r4.I$1;
        int r7 = r4.I$0;
        MemorySearchResultCategory r9 = (MemorySearchResultCategory) ZeusTransformUtils.preCheckCast(r4.L$1, MemorySearchResultCategory.class, "com.obric.memorydata.plugin");
        SearchPagingSource r10 = (SearchPagingSource) ZeusTransformUtils.preCheckCast(r4.L$0, SearchPagingSource.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);     // Catch: Exception -> L51
        int r11 = r1;
        r0 = r10;
    L34:
        if (((Unit) ZeusTransformUtils.preCheckCast(r3, Unit.class, "com.obric.memorydata.plugin")) != null) goto L37;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "Search timeout after 15000ms", false, 4, null);     // Catch: Exception -> L51
        return new PagingSource.LoadResult.Error((Throwable) ZeusTransformUtils.preCheckCast(new Exception("Search timeout"), Throwable.class, "com.obric.memorydata.plugin"));
    L37:
        int r12 = r7;
        MemorySearchResultCategory r13 = r9;
    L38:
        List<com.obric.memorydata.memory.memoryentity.search.c> r14 = r0.cache.a(r12, r11, r13);     // Catch: Exception -> L51
        boolean r15 = r0.cache.e();     // Catch: Exception -> L51
        int r16 = r0.cache.b(r13);     // Catch: Exception -> L51
        if (r12 != 0) goto L41;
        Integer r17 = null;
    L43:
        if (r14.isEmpty() == true) goto L55;
        if (r15 == true) goto L46;
    L48:
        r8 = Boxing.boxInt(r12 + r11);     // Catch: Exception -> L51
        goto L55
    L46:
        if ((r12 + r11) < r16) goto L48;
    L55:
        return (PagingSource.LoadResult) ZeusTransformUtils.preCheckCast(new PagingSource.LoadResult.Page(r14, r17, r8), PagingSource.LoadResult.class, "com.obric.memorydata.plugin");
    L41:
        r17 = Boxing.boxInt(Math.max(0, r12 - r11));     // Catch: Exception -> L51
        goto L43
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r3);
        Integer r18 = (Integer) ZeusTransformUtils.preCheckCast(r20.getKey(), Integer.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L51
        if (r18 == null) goto L20;
        r12 = r18.intValue();     // Catch: Exception -> L51
    L21:
        r11 = r20.getLoadSize();     // Catch: Exception -> L51
        r13 = r0.cache.b();     // Catch: Exception -> L51
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "load called with position: " + r12 + ", loadSize: " + r11 + ", category: " + r13, false, 4, null);     // Catch: Exception -> L51
        Pair<Integer, String> r19 = r0.cache.f();     // Catch: Exception -> L51
        if (r19 == null) goto L26;
        int r22 = ((Number) ZeusTransformUtils.preCheckCast(r19.component1(), Number.class, "com.obric.memorydata.plugin")).intValue();     // Catch: Exception -> L51
        String r23 = (String) ZeusTransformUtils.preCheckCast(r19.component2(), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L51
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "Cache has error: " + r22 + " - " + r23, false, 4, null);     // Catch: Exception -> L51
        return new PagingSource.LoadResult.Error((Throwable) ZeusTransformUtils.preCheckCast(new Exception("Search error: " + r22 + " - " + r23), Throwable.class, "com.obric.memorydata.plugin"));
    L26:
        if (r12 < r0.cache.b(r13)) goto L38;
        if (r0.cache.e() == true) goto L38;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "waitForDataAvailable start, position: " + (r12 + 1), false, 4, null);     // Catch: Exception -> L51
        Function2 r24 = (Function2) ZeusTransformUtils.preCheckCast(new SearchPagingSource$load$waitResult$1(r0, r12, r13, null), Function2.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L51
        r4.L$0 = r0;     // Catch: Exception -> L51
        r4.L$1 = r13;     // Catch: Exception -> L51
        r4.I$0 = r12;     // Catch: Exception -> L51
        r4.I$1 = r11;     // Catch: Exception -> L51
        r4.label = 1;     // Catch: Exception -> L51
        Object r25 = da.b(15000, r24, r4);     // Catch: Exception -> L51
        if (r25 != r5) goto L32;
        return r5;
    L32:
        r9 = r13;
        int r110 = r12;
        r3 = r25;
        r7 = r110;
        goto L34
    L20:
        r12 = 0;
    L51:
        e = move-exception;
        RunLog.INSTANCE.error(TAG, "Load error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return (PagingSource.LoadResult) ZeusTransformUtils.preCheckCast(new PagingSource.LoadResult.Error((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")), PagingSource.LoadResult.class, "com.obric.memorydata.plugin");
    L7:
        r4 = new AnonymousClass1(r0, r2);
        goto L8
    }
}
