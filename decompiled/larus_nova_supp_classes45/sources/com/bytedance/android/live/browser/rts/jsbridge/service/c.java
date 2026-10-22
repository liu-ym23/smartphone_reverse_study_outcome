package com.bytedance.android.live.browser.rts.jsbridge.service;

import com.bytedance.android.live.browser.jsbridge.base.CommunityGetEnableLiveHistoryResultModel;
import com.bytedance.android.live.browser.rts.jsbridge.api.RTSLiveJSBResponseCode;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.ies.web.jsbridge2.z;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;
import p30.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c implements z<CommunityGetEnableLiveHistoryResultModel> {
    public final /* synthetic */ CallContext a;
    public final /* synthetic */ Function1 b;

    public static final class a implements z.a {
        public final /* synthetic */ c a;

        public final void a(JSONObject r1) {
        }

        public a(c r1) {
            this.a = r1;
        }

        public final void onFailed(Throwable r4) {
            this.a.b.invoke(new i(RTSLiveJSBResponseCode.FAILED, Boolean.FALSE));
        }

        public final void onSucceed(Object r4) {
            if ((r4 instanceof CommunityGetEnableLiveHistoryResultModel) == false) goto L10;
            Function1 r0 = this.a.b;
            RTSLiveJSBResponseCode r2 = RTSLiveJSBResponseCode.SUCCESS;
            CommunityGetEnableLiveHistoryResultModel.a r5 = ((CommunityGetEnableLiveHistoryResultModel) r4).a();
            if (r5 == null) goto L7;
            Boolean r6 = r5.a();
        L8:
            r0.invoke(new i(r2, r6));
            return;
        L7:
            r6 = null;
            goto L8
        }
    }

    public final z.a getCallBack() {
        return new a(this);
    }

    public final CallContext a() {
        return this.a;
    }

    public c(CallContext r1, Function1 r2) {
        this.a = r1;
        this.b = r2;
    }
}
