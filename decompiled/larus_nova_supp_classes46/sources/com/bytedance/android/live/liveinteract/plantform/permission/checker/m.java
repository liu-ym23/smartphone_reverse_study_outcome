package com.bytedance.android.live.liveinteract.plantform.permission.checker;

import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import com.bytedance.android.live.plugin_api.LivePluginSPIManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class m implements qh0.a<rh0.a>, qh0.d<rh0.a> {
    public qh0.d<rh0.a> a;
    public final qh0.f.d b;
    public final qh0.a<rh0.a> c;

    public static final class a {
    }

    public static final class b implements js0.b {
        public final /* synthetic */ m a;
        public final /* synthetic */ rh0.a b;

        @Override // js0.b
        public final void onSuccess(String r2) {
            Intrinsics.checkNotNullParameter(r2, "track");
            qh0.d<rh0.a> r3 = this.a.a;
            if (r3 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("consumer");
        L5:
            r3.onResult(this.b);
        }

        public b(m r1, rh0.a r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class c implements js0.a {
        public final /* synthetic */ m a;

        public c(m r1) {
            this.a = r1;
        }

        @Override // js0.a
        public final void onFail(String r10) {
            Intrinsics.checkNotNullParameter(r10, "track");
            qh0.d<rh0.a> r11 = this.a.a;
            if (r11 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("consumer");
        L5:
            qh0.f.d r1 = this.a.b;
            r11.b(new BaseCheckException(r1.c, r1.b, BaseCheckException.CheckType.BroadcastPlugin, "check broadcast plugin installed fail.", null, 16, null));
        }
    }

    static {
    }

    @Override // qh0.a
    public final void a(qh0.d<rh0.a> r2) {
        Intrinsics.checkNotNullParameter(r2, "consumer");
        this.a = r2;
        qh0.a<rh0.a> r3 = this.c;
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

    public final void c(rh0.a r11) {
        int r0 = r.d;
        if (r.a.a() == true) goto L5;
        LivePluginSPIManager.e.getClass();
        if (LivePluginSPIManager.b() == true) goto L18;
        qh0.d<rh0.a> r1 = this.a;
        if (r1 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L17:
        r1.onResult(r11);
        return;
    L18:
        LivePluginSPIManager.a().addOnSuccess(new b(this, r11)).addOnFail(new c(this)).callbackOnMainThread().syncCallbackIfReady(true).requireByUser("broadcast_plugin_check");
        return;
    L5:
        if (this.b.d == false) goto L7;
        f2.b(2131916746, 0);
    L7:
        qh0.d<rh0.a> r12 = this.a;
        if (r12 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L10:
        qh0.f.d r2 = this.b;
        r12.b(new BaseCheckException(r2.c, r2.b, BaseCheckException.CheckType.InteractPlugin, "check interact plugin installed be cancel.", null, 16, null));
    }

    @Override // qh0.d
    public final /* bridge */ /* synthetic */ void onResult(rh0.a r1) {
        c(r1);
    }

    public m(qh0.f.d r2, qh0.a<rh0.a> r3) {
        Intrinsics.checkNotNullParameter(r2, "createConfig");
        this.b = r2;
        this.c = r3;
    }
}
