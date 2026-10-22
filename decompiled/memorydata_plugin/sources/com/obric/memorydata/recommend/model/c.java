package com.obric.memorydata.recommend.model;

import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingData;
import androidx.paging.PagingSource;
import com.bytedance.obric.memory.model.MemoryData;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.i;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\rJ\u000e\u0010\u000e\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/recommend/model/MemoryPortraitRepository;", "", "<init>", "()V", "getList", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingData;", "Lcom/bytedance/obric/memory/model/MemoryData;", "tagType", "", "deleteMemory", "", "memoryData", "(Lcom/bytedance/obric/memory/model/MemoryData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearMemory", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f12535a = null;

    static {
        f12535a = new c();
    }

    private c() {
    }

    private static final PagingSource b(String r2) {
        return (PagingSource) ZeusTransformUtils.preCheckCast(new MemoryPortraitPagingSource(r2), PagingSource.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ PagingSource lambda$QefgN7efcecuN3lQyKGR3WxV5bQ(String r0) {
        return b(r0);
    }

    public final Object a(MemoryData r2, Continuation<? super Boolean> r3) {
        Continuation<? super Boolean> r1 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        return b.f12534a.a(r2, r1);
    }

    public final i<PagingData<MemoryData>> a(final String r11) {
        Intrinsics.checkNotNullParameter(r11, "tagType");
        Object r2 = null;
        return new Pager(new PagingConfig(10, 0, false, 10, Integer.MAX_VALUE, 0, 34, null), r2, new $$Lambda$c$QefgN7efcecuN3lQyKGR3WxV5bQ(r11), 2, null).getFlow();
    }
}
