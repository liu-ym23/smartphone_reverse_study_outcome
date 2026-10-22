package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.google.gson.JsonObject;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c1 extends g<JsonObject, LiveGetRecordingStatusResultModel> {
    public c1() {
    }

    public final void invoke(Object r3, CallContext r4) {
        Intrinsics.checkNotNullParameter((JsonObject) r3, "params");
        Intrinsics.checkNotNullParameter(r4, "context");
        boolean r5 = com.bytedance.android.livesdk.service.l.d().e().isRecording();
        String r6 = com.bytedance.android.livesdk.service.l.d().e().getSource();
        ALogger.i("GetRecordingStatusMethod", "isRecording=" + r5 + " curSource=" + r6);
        LiveGetRecordingStatusResultModel r0 = new LiveGetRecordingStatusResultModel();
        r0.a(LiveGetRecordingStatusResultModel.Code.Success);
        LiveGetRecordingStatusResultModel.a r1 = new LiveGetRecordingStatusResultModel.a();
        r1.a(Boolean.valueOf(r5));
        r1.b(r6);
        Unit r7 = Unit.INSTANCE;
        r0.b(r1);
        finishWithResult(r0);
    }
}
