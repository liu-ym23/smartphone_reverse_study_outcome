package p30;

import com.bytedance.android.live.browser.rts.jsbridge.api.RTSLiveJSBResponseCode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class r {
    public final RTSLiveJSBResponseCode a;
    public final Object b;

    public r(RTSLiveJSBResponseCode r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "code");
        Intrinsics.checkNotNullParameter(r3, "data");
        this.a = r2;
        this.b = r3;
    }
}
