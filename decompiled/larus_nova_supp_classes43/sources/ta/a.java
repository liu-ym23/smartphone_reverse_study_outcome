package ta;

import com.bytedance.android.anniex.optimize.JSBPreHandleManager;
import com.bytedance.sdk.xbridge.cn.protocol.f;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import me7.d;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements f<JSONObject, JSONObject> {
    public a() {
    }

    public final void a(d r10) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Lazy r0 = JSBPreHandleManager.a;
        le7.a r11 = r10.b;
        String r1 = r11.a;
        String r12 = r11.d();
        Intrinsics.checkNotNullParameter(r1, "method");
        Intrinsics.checkNotNullParameter(r12, com.bytedance.android.ec.core.event.a.KEY_URL);
    }
}
