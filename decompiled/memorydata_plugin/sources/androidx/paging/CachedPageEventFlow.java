package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import com.obric.memorydata.memory.island.gr.IslandSession;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.collections.IndexedValue;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.al;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.ad;
import kotlinx.coroutines.flow.ai;
import kotlinx.coroutines.flow.ak;
import kotlinx.coroutines.flow.i;
import kotlinx.coroutines.flow.k;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B!\u0012\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u0015\u001a\u00020\u0016J\u0015\u0010\u0017\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0018H\u0000¢\u0006\u0002\b\u0019R\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u000e\u001a\u0016\u0012\u0012\u0012\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0018\u00010\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0013\u001a\u0016\u0012\u0012\u0012\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0018\u00010\u00100\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Landroidx/paging/CachedPageEventFlow;", ExifInterface.GPS_DIRECTION_TRUE, "", "src", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PageEvent;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/CoroutineScope;)V", "downstreamFlow", "getDownstreamFlow", "()Lkotlinx/coroutines/flow/Flow;", "job", "Lkotlinx/coroutines/Job;", "mutableSharedSrc", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lkotlin/collections/IndexedValue;", "pageController", "Landroidx/paging/FlattenedPageController;", "sharedForDownstream", "Lkotlinx/coroutines/flow/SharedFlow;", IslandSession.REOPEN_VALUE_CLOSE, "", "getCachedEvent", "Landroidx/paging/PageEvent$Insert;", "getCachedEvent$paging_common", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CachedPageEventFlow<T> {
    private final i<PageEvent<T>> downstreamFlow;
    private final bx job;
    private final ad<IndexedValue<PageEvent<T>>> mutableSharedSrc;
    private final FlattenedPageController<T> pageController;
    private final ai<IndexedValue<PageEvent<T>>> sharedForDownstream;

    public CachedPageEventFlow(i<? extends PageEvent<T>> r10, al r11) {
        i r12 = (i) ZeusTransformUtils.wrapperContextForParams(r10, i.class, "com.obric.memorydata.plugin");
        al r2 = (al) ZeusTransformUtils.wrapperContextForParams(r11, al.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "src");
        Intrinsics.checkNotNullParameter(r2, "scope");
        this.pageController = new FlattenedPageController();
        ad<IndexedValue<PageEvent<T>>> r13 = ak.a(1, Integer.MAX_VALUE, BufferOverflow.SUSPEND);
        this.mutableSharedSrc = r13;
        this.sharedForDownstream = k.a((ai) ZeusTransformUtils.preCheckCast(r13, ai.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new CachedPageEventFlow$sharedForDownstream$1(this, null), Function2.class, "com.obric.memorydata.plugin"));
        bx r14 = kotlinx.coroutines.i.a(r2, null, CoroutineStart.LAZY, (Function2) ZeusTransformUtils.preCheckCast(new CachedPageEventFlow$job$1(r12, this, null), Function2.class, "com.obric.memorydata.plugin"), 1, null);
        r14.a((Function1) ZeusTransformUtils.preCheckCast(new CachedPageEventFlow$job$2$1(this), Function1.class, "com.obric.memorydata.plugin"));
        this.job = r14;
        this.downstreamFlow = k.a((Function2) ZeusTransformUtils.preCheckCast(new CachedPageEventFlow$downstreamFlow$1(this, null), Function2.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ bx access$getJob$p(CachedPageEventFlow r0) {
        return r0.job;
    }

    public static final /* synthetic */ ad access$getMutableSharedSrc$p(CachedPageEventFlow r0) {
        return r0.mutableSharedSrc;
    }

    public static final /* synthetic */ FlattenedPageController access$getPageController$p(CachedPageEventFlow r0) {
        return r0.pageController;
    }

    public static final /* synthetic */ ai access$getSharedForDownstream$p(CachedPageEventFlow r0) {
        return r0.sharedForDownstream;
    }

    public final void close() {
        bx.a.a(this.job, null, 1, null);
    }

    public final PageEvent.Insert<T> getCachedEvent$paging_common() {
        return this.pageController.getCachedEvent();
    }

    public final i<PageEvent<T>> getDownstreamFlow() {
        return this.downstreamFlow;
    }
}
