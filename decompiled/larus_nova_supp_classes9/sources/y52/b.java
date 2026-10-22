package y52;

import com.bytedance.android.livesdk.interactivity.jsb.ShowCarnivalTrayContentResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;
import q82.c;
import q82.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@XBridgeMethod(biz = "webcast", name = "showCarnivalTrayContent")
public final class b extends c<f, ShowCarnivalTrayContentResultModel> {
    public b() {
    }

    public final void invoke(Object r3, CallContext r4) {
        f r5 = (f) r3;
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r4, "context");
        xs2.b.a().post(new o22.f(Intrinsics.areEqual(r5.a(), Boolean.TRUE)));
        finishWithSuccess();
    }
}
