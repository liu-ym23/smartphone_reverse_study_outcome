package androidx.paging;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.i;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0002B5\b\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00018\u0000\u0012\u0018\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t0\b¢\u0006\u0002\u0010\nBK\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00018\u0000\u0012\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\f\u0012\u0018\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t0\b¢\u0006\u0002\u0010\rR#\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00100\u000f¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Landroidx/paging/Pager;", "Key", "", "Value", "config", "Landroidx/paging/PagingConfig;", "initialKey", "pagingSourceFactory", "Lkotlin/Function0;", "Landroidx/paging/PagingSource;", "(Landroidx/paging/PagingConfig;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)V", "remoteMediator", "Landroidx/paging/RemoteMediator;", "(Landroidx/paging/PagingConfig;Ljava/lang/Object;Landroidx/paging/RemoteMediator;Lkotlin/jvm/functions/Function0;)V", "flow", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingData;", "getFlow$annotations", "()V", "getFlow", "()Lkotlinx/coroutines/flow/Flow;", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Pager<Key, Value> {
    private final i<PagingData<Value>> flow;

    public Pager(PagingConfig r5, Key r6, RemoteMediator<Key, Value> r7, Function0<? extends PagingSource<Key, Value>> r8) {
        Function0 r9 = (Function0) ZeusTransformUtils.wrapperContextForParams(r8, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "config");
        Intrinsics.checkNotNullParameter(r9, "pagingSourceFactory");
        if (ZeusTransformUtils.instanceOf(r9, SuspendingPagingSourceFactory.class) == false) goto L5;
        Object r2 = new Pager$flow$1(r9);
    L6:
        this.flow = new PageFetcher((Function1) ZeusTransformUtils.preCheckCast(r2, Function1.class, "com.obric.memorydata.plugin"), r6, r5, r7).getFlow();
        return;
    L5:
        r2 = new Pager$flow$2(r9, null);
        goto L6
    }

    public /* synthetic */ Pager(PagingConfig r2, Object r3, RemoteMediator r4, Function0 r5, int r6, DefaultConstructorMarker r7) {
        Function0 r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        if ((r6 & 2) == 0) goto L5;
        r3 = null;
    L5:
        this(r2, r3, r4, r8);
    }

    public Pager(PagingConfig r3, Key r4, Function0<? extends PagingSource<Key, Value>> r5) {
        Function0 r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "config");
        Intrinsics.checkNotNullParameter(r6, "pagingSourceFactory");
        this(r3, r4, null, r6);
    }

    public /* synthetic */ Pager(PagingConfig r2, Object r3, Function0 r4, int r5, DefaultConstructorMarker r6) {
        Function0 r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L5;
        r3 = null;
    L5:
        this(r2, r3, r7);
    }

    public Pager(PagingConfig r7, Function0<? extends PagingSource<Key, Value>> r8) {
        Function0 r3 = (Function0) ZeusTransformUtils.wrapperContextForParams(r8, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "config");
        Intrinsics.checkNotNullParameter(r3, "pagingSourceFactory");
        this(r7, null, r3, 2, null);
    }

    public static /* synthetic */ void getFlow$annotations() {
    }

    public final i<PagingData<Value>> getFlow() {
        return this.flow;
    }
}
