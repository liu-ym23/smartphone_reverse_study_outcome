package rp0;

import android.os.Bundle;
import com.bytedance.android.live.openplatform.impl.miniappanchor.cast.AnchorCastContextService;
import com.bytedance.android.live.openplatform.impl.miniappcommon.context.MiniAppContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b extends vq0.a {
    public b(MiniAppContext r2) {
        Intrinsics.checkNotNullParameter(r2, "miniAppContext");
        super(r2);
    }

    public final Bundle onEvent(Bundle r3) {
        AnchorCastContextService r4 = (AnchorCastContextService) this.a.getService(AnchorCastContextService.class);
        Bundle r0 = new Bundle();
        r0.putBoolean("is_live_casting", r4.g().a());
        return r0;
    }
}
