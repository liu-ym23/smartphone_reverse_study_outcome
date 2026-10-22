package com.larus.canvas.service;

import com.larus.canvas.service.internal.GetCanvasBlockInfoProcessor;
import com.larus.canvas.service.internal.d;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ny8.c;
import ny8.f;
import ny8.i;
import ny8.j;
import ny8.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, d2 = {"Lcom/larus/canvas/service/CanvasRepoServiceImpl;", "Lcom/larus/canvas/service/ICanvasRepoService;", "<init>", "()V", "getCanvasBlockInfo", "", "request", "Lcom/larus/canvas/service/bean/GetCanvasBlockInfoRequest;", "callback", "Lcom/larus/canvas/service/bean/CommonCallback;", "Lcom/larus/canvas/service/bean/GetCanvasBlockInfoResp;", "pullCanvasBlockInfo", "Lcom/larus/canvas/service/bean/ICanvasSSEPullController;", "Lcom/larus/canvas/service/bean/SsePullCanvasBlockInfoRequest;", "Lcom/larus/canvas/service/bean/CanvasUpdateCallback;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CanvasRepoServiceImpl implements ICanvasRepoService {
    public CanvasRepoServiceImpl() {
    }

    @Override // com.larus.canvas.service.ICanvasRepoService
    public final j a(k r4, c r5) {
        Intrinsics.checkNotNullParameter(r4, "request");
        Intrinsics.checkNotNullParameter(r5, "callback");
        d r0 = new d(r4, r5);
        FLogger.a.i(r0.e, "trigger, req = " + r0.d);
        r0.f.a();
        return r0.g;
    }

    @Override // com.larus.canvas.service.ICanvasRepoService
    public final void b(f r2, ny8.d<i> r3) {
        Intrinsics.checkNotNullParameter(r2, "request");
        Intrinsics.checkNotNullParameter(r3, "callback");
        new GetCanvasBlockInfoProcessor(r2, r3).a();
    }
}
