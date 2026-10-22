package com.larus.canvas.service;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ny8.c;
import ny8.d;
import ny8.f;
import ny8.i;
import ny8.j;
import ny8.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \r2\u00020\u0001:\u0001\rJ\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\fH&¨\u0006\u000e"}, d2 = {"Lcom/larus/canvas/service/ICanvasRepoService;", "", "getCanvasBlockInfo", "", "request", "Lcom/larus/canvas/service/bean/GetCanvasBlockInfoRequest;", "callback", "Lcom/larus/canvas/service/bean/CommonCallback;", "Lcom/larus/canvas/service/bean/GetCanvasBlockInfoResp;", "pullCanvasBlockInfo", "Lcom/larus/canvas/service/bean/ICanvasSSEPullController;", "Lcom/larus/canvas/service/bean/SsePullCanvasBlockInfoRequest;", "Lcom/larus/canvas/service/bean/CanvasUpdateCallback;", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ICanvasRepoService {
    public static final Companion a = null;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0096\u0001J\u0019\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u000eH\u0096\u0001¨\u0006\u000f"}, d2 = {"Lcom/larus/canvas/service/ICanvasRepoService$Companion;", "Lcom/larus/canvas/service/ICanvasRepoService;", "<init>", "()V", "getCanvasBlockInfo", "", "request", "Lcom/larus/canvas/service/bean/GetCanvasBlockInfoRequest;", "callback", "Lcom/larus/canvas/service/bean/CommonCallback;", "Lcom/larus/canvas/service/bean/GetCanvasBlockInfoResp;", "pullCanvasBlockInfo", "Lcom/larus/canvas/service/bean/ICanvasSSEPullController;", "Lcom/larus/canvas/service/bean/SsePullCanvasBlockInfoRequest;", "Lcom/larus/canvas/service/bean/CanvasUpdateCallback;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements ICanvasRepoService {
        public static final /* synthetic */ Companion c = null;
        public final /* synthetic */ ICanvasRepoService b;

        static {
            c = new Companion();
        }

        @Override // com.larus.canvas.service.ICanvasRepoService
        public final j a(k r2, c r3) {
            Intrinsics.checkNotNullParameter(r2, "request");
            Intrinsics.checkNotNullParameter(r3, "callback");
            return this.b.a(r2, r3);
        }

        @Override // com.larus.canvas.service.ICanvasRepoService
        public final void b(f r2, d<i> r3) {
            Intrinsics.checkNotNullParameter(r2, "request");
            Intrinsics.checkNotNullParameter(r3, "callback");
            this.b.b(r2, r3);
        }

        private Companion() {
            ICanvasRepoService r0 = (ICanvasRepoService) ServiceManager.get().getService(ICanvasRepoService.class);
            if (r0 != null) goto L5;
            r0 = new CanvasRepoServiceNoop();
        L5:
            this.b = r0;
        }
    }

    static {
        a = Companion.c;
    }

    j a(k r1, c r2);

    void b(f r1, d<i> r2);
}
