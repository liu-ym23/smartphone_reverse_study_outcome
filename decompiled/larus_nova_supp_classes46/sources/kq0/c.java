package kq0;

import android.os.Looper;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.miniappaudience.intention.AudienceHighIntentionContextService;
import com.bytedance.android.livesdk.config.qc1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c extends kq0.a {
    public long e;
    public final d f;

    public static final class a {
    }

    static {
    }

    @Override // kq0.b
    public final String type() {
        return "stay_duration";
    }

    @Override // kq0.a, kq0.b
    public final void onDestroy() {
        this.f.removeMessages(1);
    }

    @Override // kq0.b
    public final boolean a() {
        if ((System.currentTimeMillis() - this.e) < this.b.a()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kq0.b
    public final void init() {
        this.e = System.currentTimeMillis();
        d r0 = this.f;
        r0.sendMessageDelayed(r0.obtainMessage(1), this.b.a());
    }

    public c(OpenPlatformContext r2, qc1 r3, AudienceHighIntentionContextService r4, oq0.a r5) {
        Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
        Intrinsics.checkNotNullParameter(r3, "condition");
        Intrinsics.checkNotNullParameter(r4, "callback");
        Intrinsics.checkNotNullParameter(r5, "prefHelper");
        super(r2, r3, r4, r5);
        this.e = Long.MAX_VALUE;
        this.f = new d(this, r4, Looper.getMainLooper());
    }
}
