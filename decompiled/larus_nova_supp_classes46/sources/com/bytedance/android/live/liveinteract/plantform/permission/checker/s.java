package com.bytedance.android.live.liveinteract.plantform.permission.checker;

import com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService;
import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import com.bytedance.android.live.plugin_api.LivePluginSPIManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class s implements qh0.a<rh0.a>, qh0.d<rh0.a> {
    public qh0.d<rh0.a> a;
    public final qh0.a<rh0.a> b;

    public static final class a implements js0.b {
        public a() {
        }

        @Override // js0.b
        public final void onSuccess(String r4) {
            Intrinsics.checkNotNullParameter(r4, "track");
            com.bytedance.android.scope.m r5 = com.bytedance.android.scope.m.e;
            f00.a.a r0 = f00.a.b;
            nz.t r1 = (nz.t) r5.d(r0, nz.t.class);
            if (r1 != null) goto L5;
        L9:
            ((IMiddlewareBroadcastService) va1.b.a.a.a(IMiddlewareBroadcastService.class)).init();
            return;
        L5:
            if (r1.isOpen() != true) goto L9;
            nz.t r6 = (nz.t) r5.d(r0, nz.t.class);
            if (r6 == null) goto L11;
            r6.init();
            return;
        }
    }

    public s(qh0.a<rh0.a> r1) {
        this.b = r1;
    }

    @Override // qh0.a
    public final void a(qh0.d<rh0.a> r2) {
        Intrinsics.checkNotNullParameter(r2, "consumer");
        this.a = r2;
        qh0.a<rh0.a> r3 = this.b;
        if (r3 == null) goto L5;
        r3.a(this);
        return;
    L5:
        c(null);
    }

    @Override // qh0.d
    public final void b(BaseCheckException r3) {
        Intrinsics.checkNotNullParameter(r3, "exception");
        qh0.d<rh0.a> r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L5:
        r0.b(r3);
    }

    public final void c(rh0.a r3) {
        LivePluginSPIManager.e.getClass();
        LivePluginSPIManager.a().addOnSuccess(new a()).callbackOnMainThread().syncCallbackIfReady(true).justPrepare();
        qh0.d<rh0.a> r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L5:
        r0.onResult(r3);
    }

    @Override // qh0.d
    public final /* bridge */ /* synthetic */ void onResult(rh0.a r1) {
        c(r1);
    }
}
