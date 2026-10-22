package mv0;

import android.app.Activity;
import com.bytedance.android.livesdkapi.model.InnerContextEntity;
import com.bytedance.android.livesdkapi.service.ILiveVideoFloatWindowService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class s extends qs0.a<ILiveVideoFloatWindowService> implements qs0.q {
    public s() {
        super(jc1.k.n(ILiveVideoFloatWindowService.class));
    }

    @Override // qs0.q
    public final void b(Activity r3, qs0.p r4) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        Intrinsics.checkNotNullParameter(r4, "extra");
        ILiveVideoFloatWindowService r0 = (ILiveVideoFloatWindowService) this.a;
        InnerContextEntity.InnerFloatExtra r1 = new InnerContextEntity.InnerFloatExtra();
        r1.setRequestPage(r4.a);
        r0.startShowFloatInNextLifecycle(r3, r1);
    }
}
