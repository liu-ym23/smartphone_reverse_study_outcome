package com.obric.memorydata.recommend.model;

import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingData;
import androidx.paging.PagingSource;
import com.bytedance.obric.memory.model.MemoryData;
import com.obric.memorydata.recommend.ui.list.MemoryTab;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00072\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tH\u0086@¢\u0006\u0002\u0010\u000fJ\u000e\u0010\u0010\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/recommend/model/MemoryGeneralRepository;", "", "<init>", "()V", "TAG", "", "getList", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingData;", "Lcom/bytedance/obric/memory/model/MemoryData;", "memoryTab", "Lcom/obric/memorydata/recommend/ui/list/MemoryTab;", "deleteMemory", "", "memoryData", "(Lcom/bytedance/obric/memory/model/MemoryData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearMemory", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f12534a = null;

    static {
        f12534a = new b();
    }

    private b() {
    }

    private static final PagingSource b(MemoryTab r2) {
        return (PagingSource) ZeusTransformUtils.preCheckCast(new MemoryGeneralPagingSource(r2.getCategory()), PagingSource.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ PagingSource lambda$zexpASRvqDKlSnAczMONUoQOumY(MemoryTab r0) {
        return b(r0);
    }

    public final Object a(MemoryData r4, Continuation<? super Boolean> r5) {
        Continuation r3 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        return i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new MemoryGeneralRepository$deleteMemory$2(r4, null), Function2.class, "com.obric.memorydata.plugin"), r3);
    }

    public final Object a(Continuation<? super Boolean> r4) {
        Continuation r3 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new MemoryGeneralRepository$clearMemory$2(null), Function2.class, "com.obric.memorydata.plugin"), r3);
    }

    public final kotlinx.coroutines.flow.i<PagingData<MemoryData>> a(final MemoryTab r11) {
        Intrinsics.checkNotNullParameter(r11, "memoryTab");
        Object r2 = null;
        return new Pager(new PagingConfig(10, 0, false, 10, 200, 0, 34, null), r2, new $$Lambda$b$zexpASRvqDKlSnAczMONUoQOumY(r11), 2, null).getFlow();
    }
}
