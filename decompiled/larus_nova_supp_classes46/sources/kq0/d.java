package kq0;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.android.live.openplatform.impl.miniappaudience.intention.AudienceHighIntentionContextService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d extends Handler {
    public final /* synthetic */ c a;
    public final /* synthetic */ com.bytedance.android.live.openplatform.impl.miniappaudience.intention.a b;

    @Override // android.os.Handler
    public final void handleMessage(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        if (r2.what != 1) goto L7;
        com.bytedance.android.live.openplatform.impl.miniappaudience.intention.a r3 = this.b;
        this.a.getClass();
        r3.a("stay_duration");
        return;
    }

    public d(c r1, AudienceHighIntentionContextService r2, Looper r3) {
        this.a = r1;
        this.b = r2;
        super(r3);
    }
}
