package com.bytedance.android.livesdk.chatroom.viewmodule.welfare.right;

import com.bytedance.android.livesdkapi.hybridapi.BaseJsBridgeMethodFactory;
import com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.web.jsbridge2.CallContext;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b extends BaseJsBridgeMethodFactory {
    public final /* synthetic */ WelfareAudienceWelfareServiceWidget a;

    public static final class a extends com.bytedance.ies.web.jsbridge2.g<JSONObject, JSONObject> {
        public final /* synthetic */ b a;

        public a(b r1) {
            this.a = r1;
        }

        public final Object invoke(Object r5, CallContext r6) {
            Intrinsics.checkNotNullParameter((JSONObject) r5, "params");
            Intrinsics.checkNotNullParameter(r6, "context");
            DataCenter r7 = ((Widget) this.a.a).dataCenter;
            long r0 = 0;
            if (r7 == null) goto L7;
            Long r8 = (Long) r7.get("data_live_welfare_donation_click_count", 0L);
            if (r8 == null) goto L7;
            r0 = r8.longValue();
        L7:
            DataCenter r9 = ((Widget) this.a.a).dataCenter;
            if (r9 == null) goto L10;
            r9.put("data_live_welfare_donation_click_count", Long.valueOf(r0 + 1));
        L10:
            this.a.a.getClass();
            JSONObject r10 = new JSONObject();
            r10.put("code", 0);
            return r10;
        }
    }

    public b(WelfareAudienceWelfareServiceWidget r1) {
        this.a = r1;
    }

    public final Map<String, com.bytedance.ies.web.jsbridge2.g<?, ?>> provideStatelessMethods(IJsBridgeManager r3) {
        Intrinsics.checkNotNullParameter(r3, "manager");
        HashMap r4 = new HashMap();
        r4.put("donationButtonClick", new a(this));
        return r4;
    }
}
