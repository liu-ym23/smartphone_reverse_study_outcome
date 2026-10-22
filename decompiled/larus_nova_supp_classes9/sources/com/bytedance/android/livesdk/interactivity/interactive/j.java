package com.bytedance.android.livesdk.interactivity.interactive;

import android.text.TextUtils;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.web.jsbridge2.CallContext;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j extends com.bytedance.ies.web.jsbridge2.g<JSONObject, JSONObject> {
    public final /* synthetic */ LiveInteractiveAnnieXHelper a;

    public j(LiveInteractiveAnnieXHelper r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3, CallContext r4) {
        Intrinsics.checkNotNullParameter((JSONObject) r3, "params");
        Intrinsics.checkNotNullParameter(r4, "context");
        JSONObject r5 = new JSONObject();
        LiveInteractivePresenter r6 = this.a.f;
        String r0 = BuildConfig.FLAVOR;
        if (r6 == null) goto L10;
        IRoomEventHub r7 = r6.i;
        if (r7 == null) goto L7;
        String r8 = (String) r7.getSeiUpdate().getValue();
    L8:
        if (r8 == null) goto L10;
        r0 = r8;
        goto L10
    L7:
        r8 = BuildConfig.FLAVOR;
    L10:
        r5.put("code", !TextUtils.isEmpty(r0) ? 1 : 0);
        r5.put("data", r0);
        return r5;
    }
}
