package wo1;

import com.bytedance.android.live.browser.jsbridge.base.LoadShortTouchResultModel;
import com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.p;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;
import w20.w3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i extends w3<JsonObject, LoadShortTouchResultModel> {
    public final p a;

    public final void onTerminate() {
    }

    public i(p r2) {
        Intrinsics.checkNotNullParameter(r2, "commonIconModel");
        this.a = r2;
    }

    public final void invoke(Object r2, CallContext r3) {
        Intrinsics.checkNotNullParameter((JsonObject) r2, "params");
        Intrinsics.checkNotNullParameter(r3, "context");
        p r4 = this.a;
        if (r4.t == true) goto L5;
        r4.t = true;
        r4.moveToState(0);
    L5:
        finishWithSuccess();
    }
}
