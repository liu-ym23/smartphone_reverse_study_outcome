package c12;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g implements Runnable {
    public final /* synthetic */ Map a;

    @Override // java.lang.Runnable
    public final void run() {
        com.bytedance.android.livesdk.gift.platform.core.utils.h.d0("livesdk_live_asset_download_md5", this.a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public g(Map r1) {
        this.a = r1;
    }
}
