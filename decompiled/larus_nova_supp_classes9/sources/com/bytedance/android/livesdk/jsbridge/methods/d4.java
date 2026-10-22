package com.bytedance.android.livesdk.jsbridge.methods;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.business.IHostLiveLocalLife;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@XBridgeMethod(biz = "webcast", name = "set_session_info")
public final class d4 extends s<e4, f4> {
    public d4() {
    }

    public final void invoke(Object r5, CallContext r6) {
        e4 r7 = (e4) r5;
        Intrinsics.checkNotNullParameter(r7, "params");
        Intrinsics.checkNotNullParameter(r6, "context");
        if ((r6.getContext() instanceof FragmentActivity) == false) goto L28;
        String r8 = r7.getIdentifier();
        if (r8 != null) goto L7;
    L10:
        boolean r2 = true;
    L11:
        if (r2 == false) goto L13;
        finishWithFailure(new Throwable("no input key"));
        return;
    L13:
        HashMap r9 = (HashMap) GsonProtectorUtils.fromJson(GsonHelper.get(), r7.a(), new c4().getType());
        if (r9 != null) goto L16;
        r9 = new HashMap();
    L16:
        IHostLiveLocalLife r3 = TTLiveSDK.hostService().hostLiveLocalLife();
        if (r3 != null) goto L19;
    L21:
        boolean r10 = false;
    L22:
        f4 r11 = new f4();
        r11.a(1);
        f4.a r4 = new f4.a();
        if (r10 == false) goto L25;
        int r13 = 1;
    L26:
        r4.a(r13);
        Unit r14 = Unit.INSTANCE;
        r11.b(r4);
        finishWithResult(r11);
        return;
    L25:
        r13 = 0;
        goto L26
    L19:
        if (r3.updateSessionInfo(r8, r9) != true) goto L21;
        r10 = true;
        goto L22
    L7:
        if (r8.length() == 0) goto L10;
        r2 = false;
        goto L11
    }
}
