package p30;

import com.bytedance.android.live.browser.rts.jsbridge.api.RTSLiveJSBResponseCode;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class n {
    public final Map<String, Object> a;

    public n(Map r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        RTSLiveJSBResponseCode r0 = RTSLiveJSBResponseCode.FAILED;
        this.a = r2;
    }
}
