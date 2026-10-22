package androidx.paging;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* synthetic */ class AsyncPagedListDiffer$loadStateListener$1 extends FunctionReferenceImpl implements Function2<LoadType, LoadState, Unit> {
    AsyncPagedListDiffer$loadStateListener$1(Object r8) {
        super(2, r8, PagedList.LoadStateManager.class, "setState", "setState(Landroidx/paging/LoadType;Landroidx/paging/LoadState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Unit invoke(LoadType r3, LoadState r4) {
        invoke2((LoadType) ZeusTransformUtils.preCheckCast(r3, LoadType.class, "com.obric.memorydata.plugin"), (LoadState) ZeusTransformUtils.preCheckCast(r4, LoadState.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(LoadType r3, LoadState r4) {
        Intrinsics.checkNotNullParameter(r3, "p0");
        Intrinsics.checkNotNullParameter(r4, "p1");
        ((PagedList.LoadStateManager) ZeusTransformUtils.preCheckCast(this.receiver, PagedList.LoadStateManager.class, "com.obric.memorydata.plugin")).setState(r3, r4);
    }
}
