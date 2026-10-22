package qn0;

import com.bytedance.android.live.multilink.layoutconfig.model.LayoutConfigModel;
import com.bytedance.android.live.multilink.layoutconfig.resource.producer.ProducerResStep;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements a.InterfaceC0260a {
    public final /* synthetic */ a a;
    public final /* synthetic */ pn0.d b;
    public final /* synthetic */ pn0.g c;

    @Override // qn0.a.InterfaceC0260a
    public final void a(LayoutConfigModel r5) {
        Intrinsics.checkNotNullParameter(r5, "uiLayoutConfig");
        this.a.d(this.b.e(), "onSuccess, load layoutConfig from geckoOffline success!");
        sn0.a r0 = this.a.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L5:
        r0.b(this.b, this.c, r5, ProducerResStep.GeckoOffline);
    }

    @Override // qn0.a.InterfaceC0260a
    public final void onFailed(Throwable r5) {
        this.a.d(this.b.e(), "GeckoOfflineResProducer#onFailed, throwable = " + r5);
        sn0.a r6 = this.a.a;
        if (r6 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L5:
        r6.c(this.b, this.c);
    }

    public c(a r1, pn0.d r2, pn0.g r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
