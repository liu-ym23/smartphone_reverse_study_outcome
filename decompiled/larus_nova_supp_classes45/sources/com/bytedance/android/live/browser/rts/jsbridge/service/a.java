package com.bytedance.android.live.browser.rts.jsbridge.service;

import com.bytedance.android.live.browser.rts.jsbridge.api.RTSLiveJSBResponseCode;
import com.bytedance.android.livesdk.jsbridge.methods.CloseLiveRoomResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.ies.web.jsbridge2.z;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements z<CloseLiveRoomResultModel> {
    public final /* synthetic */ CallContext a;
    public final /* synthetic */ Function1 b;

    /* JADX INFO: renamed from: com.bytedance.android.live.browser.rts.jsbridge.service.a$a, reason: collision with other inner class name */
    public static final class C0129a implements z.a {
        public final /* synthetic */ a a;

        public final void a(JSONObject r1) {
        }

        public C0129a(a r1) {
            this.a = r1;
        }

        public final void onFailed(Throwable r3) {
            this.a.b.invoke(new p30.b(RTSLiveJSBResponseCode.FAILED));
        }

        public final void onSucceed(Object r4) {
            if ((r4 instanceof CloseLiveRoomResultModel) == false) goto L6;
            Function1 r0 = this.a.b;
            RTSLiveJSBResponseCode r2 = RTSLiveJSBResponseCode.SUCCESS;
            ((CloseLiveRoomResultModel) r4).getClass();
            r0.invoke(new p30.b(r2));
            return;
        }
    }

    public final z.a getCallBack() {
        return new C0129a(this);
    }

    public final CallContext a() {
        return this.a;
    }

    public a(CallContext r1, Function1 r2) {
        this.a = r1;
        this.b = r2;
    }
}
