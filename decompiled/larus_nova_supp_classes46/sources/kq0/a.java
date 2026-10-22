package kq0;

import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.miniappaudience.intention.AudienceHighIntentionContextService;
import com.bytedance.android.livesdk.config.qc1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class a implements b {
    public final OpenPlatformContext a;
    public final qc1 b;
    public final com.bytedance.android.live.openplatform.impl.miniappaudience.intention.a c;
    public final oq0.a d;

    @Override // kq0.b
    public void onDestroy() {
    }

    public a(OpenPlatformContext r2, qc1 r3, AudienceHighIntentionContextService r4, oq0.a r5) {
        Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
        Intrinsics.checkNotNullParameter(r3, "condition");
        Intrinsics.checkNotNullParameter(r4, "callback");
        Intrinsics.checkNotNullParameter(r5, "prefHelper");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
