package yg0;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f implements com.bytedance.android.live.liveinteract.plantform.commonwindow.g {
    public f() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.g
    public final void b(com.bytedance.android.live.liveinteract.plantform.commonwindow.h r2) {
        Intrinsics.checkNotNullParameter(r2, "request");
        ln0.a r3 = h.a;
        ALogger.d("LayoutConfigGeckoRes", "refreshLayoutConfig onFailed");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.g
    public final void a(com.bytedance.android.live.liveinteract.plantform.commonwindow.h r2, com.bytedance.android.live.liveinteract.plantform.commonwindow.i r3) {
        Intrinsics.checkNotNullParameter(r2, "request");
        Intrinsics.checkNotNullParameter(r3, "response");
        ln0.a r4 = h.a;
        ALogger.d("LayoutConfigGeckoRes", "refreshLayoutConfig onSuccess");
    }
}
