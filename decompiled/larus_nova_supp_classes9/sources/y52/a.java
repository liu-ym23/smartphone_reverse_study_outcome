package y52;

import com.bytedance.android.livesdk.interactivity.jsb.ShowCarnivalRedPacketEggResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;
import q82.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@XBridgeMethod(biz = "webcast", name = "showCarnivalRedPacketEgg")
public final class a extends q82.b<e, ShowCarnivalRedPacketEggResultModel> {
    public a() {
    }

    public final void invoke(Object r3, CallContext r4) {
        e r5 = (e) r3;
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r4, "context");
        if (r5.b() == null) goto L5;
        xs2.b.a().post(new o22.e(r5.b(), r5.a()));
        finishWithSuccess();
        return;
    L5:
        finishWithFailure();
    }
}
