package com.obric.memorydata.recommend.model;

import androidx.paging.PagingSource;
import androidx.paging.PagingState;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.obric.memory.model.GetUserProfileMemoryListRequest;
import com.bytedance.obric.memory.model.GetUserProfileMemoryListResponse;
import com.bytedance.obric.memory.model.MemoryData;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\b\u001a\u00020\u00022\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\nH\u0016¢\u0006\u0002\u0010\u000bJ(\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u000fH\u0096@¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/recommend/model/MemoryGeneralPagingSource;", "Landroidx/paging/PagingSource;", "", "Lcom/bytedance/obric/memory/model/MemoryData;", EventBody.KEY_CATEGORY, "", "<init>", "(I)V", "getRefreshKey", "state", "Landroidx/paging/PagingState;", "(Landroidx/paging/PagingState;)Ljava/lang/Long;", "load", "Landroidx/paging/PagingSource$LoadResult;", TrackerImpl.PARAMS, "Landroidx/paging/PagingSource$LoadParams;", "(Landroidx/paging/PagingSource$LoadParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemoryGeneralPagingSource extends PagingSource<Long, MemoryData> {
    public static final a Companion = null;
    private static final String TAG = "MemoryGeneralPagingSource";
    private final int category;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/recommend/model/MemoryGeneralPagingSource$Companion;", "", "<init>", "()V", "TAG", "", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.recommend.model.MemoryGeneralPagingSource$load$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Landroidx/paging/PagingSource$LoadResult;", "", "Lcom/bytedance/obric/memory/model/MemoryData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.recommend.model.MemoryGeneralPagingSource$load$2", f = "MemoryGeneralPagingSource.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<al, Continuation<? super PagingSource.LoadResult<Long, MemoryData>>, Object> {
        final /* synthetic */ PagingSource.LoadParams<Long> $params;
        int label;
        final /* synthetic */ MemoryGeneralPagingSource this$0;

        AnonymousClass2(MemoryGeneralPagingSource r3, PagingSource.LoadParams<Long> r4, Continuation<? super AnonymousClass2> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$params = r4;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.this$0, this.$params, r5), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super PagingSource.LoadResult<Long, MemoryData>> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super PagingSource.LoadResult<Long, MemoryData>> r4) {
            return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r14) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L33;
            ResultKt.throwOnFailure(r14);
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), MemoryGeneralPagingSource.TAG, '[' + MemoryGeneralPagingSource.access$getCategory$p(this.this$0) + "] load: nextKey=" + this.$params.getKey() + ", num=" + this.$params.getLoadSize(), false, 4, null);
            Long r15 = (Long) ZeusTransformUtils.preCheckCast(this.$params.getKey(), Long.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L29
            if (r15 == null) goto L8;
            long r4 = r15.longValue();     // Catch: Exception -> L29
        L9:
            GetUserProfileMemoryListRequest r16 = new GetUserProfileMemoryListRequest();     // Catch: Exception -> L29
            MemoryGeneralPagingSource r6 = this.this$0;     // Catch: Exception -> L29
            PagingSource.LoadParams<Long> r7 = this.$params;     // Catch: Exception -> L29
            r16.category = MemoryGeneralPagingSource.access$getCategory$p(r6);     // Catch: Exception -> L29
            r16.nextId = r4;     // Catch: Exception -> L29
            r16.num = r7.getLoadSize();     // Catch: Exception -> L29
            GetUserProfileMemoryListResponse r17 = com.bytedance.obric.memory.a.a.a(r16);     // Catch: Exception -> L29
            if (r17.code == 0) goto L12;
        L27:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), MemoryGeneralPagingSource.TAG, '[' + MemoryGeneralPagingSource.access$getCategory$p(this.this$0) + "] load result: code=" + r17.code + ", msg=" + r17.msg, null, 4, null);     // Catch: Exception -> L29
            Object r18 = ZeusTransformUtils.preCheckCast(new PagingSource.LoadResult.Error((Throwable) ZeusTransformUtils.preCheckCast(new Exception(r17.msg), Throwable.class, "com.obric.memorydata.plugin")), PagingSource.LoadResult.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L29
        L26:
            return (PagingSource.LoadResult) r18;
        L12:
            if (r17.data == null) goto L27;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), MemoryGeneralPagingSource.TAG, '[' + MemoryGeneralPagingSource.access$getCategory$p(this.this$0) + "] load result: data.size=" + r17.data.data.size() + ", nextId=" + r17.data.nextId, false, 4, null);     // Catch: Exception -> L29
            if (r17.data.nextId != 0) goto L16;
        L19:
            Long r2 = null;
        L20:
            if (r2 != null) goto L23;
        L25:
            List<MemoryData> r19 = r17.data.data;     // Catch: Exception -> L29
            Intrinsics.checkNotNullExpressionValue(r19, "data");     // Catch: Exception -> L29
            r18 = ZeusTransformUtils.preCheckCast(new PagingSource.LoadResult.Page(r19, null, r2), PagingSource.LoadResult.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L29
            goto L26
        L23:
            if (r2.longValue() != r4) goto L25;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), MemoryGeneralPagingSource.TAG, '[' + MemoryGeneralPagingSource.access$getCategory$p(this.this$0) + "] nextId is same as lastId", null, 4, null);     // Catch: Exception -> L29
            r2 = null;
            goto L25
        L16:
            if (r17.data.data.size() == 0) goto L19;
            r2 = Boxing.boxLong(r17.data.nextId);     // Catch: Exception -> L29
            goto L20
        L8:
            r4 = 0;
        L29:
            e = move-exception;
            RunLog.INSTANCE.error(MemoryGeneralPagingSource.TAG, '[' + MemoryGeneralPagingSource.access$getCategory$p(this.this$0) + "] load error: ", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
            return (PagingSource.LoadResult) ZeusTransformUtils.preCheckCast(new PagingSource.LoadResult.Error((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")), PagingSource.LoadResult.class, "com.obric.memorydata.plugin");
        L33:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new a(null);
    }

    public MemoryGeneralPagingSource(int r1) {
        this.category = r1;
    }

    public static final /* synthetic */ int access$getCategory$p(MemoryGeneralPagingSource r0) {
        return r0.category;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.paging.PagingSource
    public Long getRefreshKey(PagingState<Long, MemoryData> r1) {
        Intrinsics.checkNotNullParameter(r1, "state");
        return 0L;
    }

    @Override // androidx.paging.PagingSource
    public /* bridge */ /* synthetic */ Long getRefreshKey(PagingState<Long, MemoryData> r1) {
        return getRefreshKey(r1);
    }

    @Override // androidx.paging.PagingSource
    public Object load(PagingSource.LoadParams<Long> r5, Continuation<? super PagingSource.LoadResult<Long, MemoryData>> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        return i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this, r5, null), Function2.class, "com.obric.memorydata.plugin"), r7);
    }
}
