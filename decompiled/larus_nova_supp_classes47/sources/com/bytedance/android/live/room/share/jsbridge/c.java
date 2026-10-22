package com.bytedance.android.live.room.share.jsbridge;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.business.depend.share.LiveWebShareCallback;
import com.bytedance.android.livehostapi.business.depend.share.LiveWebShareParams;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c extends LiveWebShareCallback {
    public final /* synthetic */ b a;
    public final /* synthetic */ LiveWebShareParams b;

    public final void onRefresh() {
    }

    public final void onFail(Throwable r2) {
        Intrinsics.checkNotNullParameter(r2, "throwable");
        ALogger.e("ShareFullParamsMethod", r2);
    }

    public c(b r1, LiveWebShareParams r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onSuccess(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "platform");
        Intrinsics.checkNotNullParameter(r4, "shareType");
        if (this.b.getNeedShareCallback() == true) goto L5;
    L9:
        b r5 = this.a;
        r5.getClass();
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L12
        r0.put("share_platform", r3);     // Catch: Exception -> L12
        Unit r6 = Unit.INSTANCE;     // Catch: Exception -> L12
        r5.finishWithResult(r0);     // Catch: Exception -> L12
        return;
    L12:
        r5.finishWithResult(new JSONObject());
        return;
    L5:
        if (this.b.getUseReturnData() == false) goto L9;
        if (Intrinsics.areEqual(r3, "chat_merge") == false) goto L9;
    }

    public final void onSuccessWithExtra(String r2, String r3, Map<String, List<String>> r4) {
        if (this.b.getNeedShareCallback() == true) goto L5;
    L13:
        b r5 = this.a;
        JSONObject r0 = new JSONObject();
        r0.put("share_platform", r2);
        Unit r6 = Unit.INSTANCE;
        r5.finishWithResult(r0);
        return;
    L5:
        if (this.b.getUseReturnData() == false) goto L13;
        if (Intrinsics.areEqual(r2, "chat_merge") == false) goto L13;
        b r7 = this.a;
        r7.getClass();
        JSONObject r1 = new JSONObject();     // Catch: Exception -> L11
        r1.put("share_platform", r2);     // Catch: Exception -> L11
        Unit r8 = Unit.INSTANCE;     // Catch: Exception -> L11
        r7.finishWithResult(r1);     // Catch: Exception -> L11
        return;
    L11:
        r7.finishWithResult(new JSONObject());
    }
}
