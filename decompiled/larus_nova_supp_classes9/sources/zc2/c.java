package zc2;

import com.bytedance.android.live.browser.jsbridge.base.LiveOpenStickerListResultModel;
import com.bytedance.android.livesdk.chatroom.viewmodule.v2;
import com.bytedance.android.livesdk.chatroom.viewmodule.w2;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;
import w20.d3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c extends d3<JsonObject, LiveOpenStickerListResultModel> {
    public c() {
    }

    public final void invoke(Object r2, CallContext r3) {
        Intrinsics.checkNotNullParameter((JsonObject) r2, "params");
        Intrinsics.checkNotNullParameter(r3, "context");
        w2 r4 = v2.a();
        if (r4 != null) goto L5;
        finishWithFailure();
        return;
    L5:
        r4.ve();
        finishWithSuccess();
    }
}
