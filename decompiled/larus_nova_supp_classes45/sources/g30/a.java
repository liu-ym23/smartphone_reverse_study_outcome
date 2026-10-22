package g30;

import com.bytedance.android.livesdkapi.hybridapi.ILiveHybridContainer;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.ies.web.jsbridge2.f;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a extends f<JSONObject, Object> {
    public final ILiveHybridContainer a;

    public final void onTerminate() {
    }

    public a(ILiveHybridContainer r1) {
        this.a = r1;
    }

    public final void invoke(Object r2, CallContext r3) {
        JSONObject r4 = (JSONObject) r2;
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r3, "context");
        String r5 = r4.optString("title");
        ILiveHybridContainer r6 = this.a;
        if (r6 == null) goto L5;
        r6.setHybridTitle(r5);
    L5:
        finishWithResult(null);
    }
}
