package p30;

import com.bytedance.android.live.browser.rts.jsbridge.api.RTSLiveJSBResponseCode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g {
    public final Object a;
    public final Object b;

    public g(Object r2, RTSLiveJSBResponseCode r3, Object r4) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "code");
        Intrinsics.checkNotNullParameter(r4, "data");
        this.a = r2;
        this.b = r4;
    }
}
