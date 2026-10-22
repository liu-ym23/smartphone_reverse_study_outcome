package com.bytedance.android.annie.bridge.method.audio;

import android.os.Handler;
import android.view.View;
import com.byted.cast.sink.api.CastInfo;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.live.browser.jsbridge.base.StopSpeechRecognitionResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import java.util.WeakHashMap;
import kotlin.jvm.internal.Intrinsics;
import w20.ef;
import w20.u6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "stopSpeechRecognition")
public final class f extends u6<ef, StopSpeechRecognitionResultModel> {
    public f() {
    }

    public final void invoke(Object r10, CallContext r11) {
        ef r12 = (ef) r10;
        Intrinsics.checkNotNullParameter(r12, "params");
        Intrinsics.checkNotNullParameter(r11, "context");
        a r1 = null;
        if (Intrinsics.areEqual(r12.a(), Boolean.TRUE) == true) goto L13;
        WeakHashMap<View, a> r13 = a.k;
        Intrinsics.checkNotNullParameter(r11, "context");
        View r14 = r11.d;
        if (r14 == null) goto L7;
        r1 = a.k.get(r14);
    L7:
        if (r1 == null) goto L12;
        Handler r15 = r1.g;
        if (r15 == null) goto L11;
        r15.sendMessage(r15.obtainMessage(CastInfo.TYPE_CAST_RESUME));
    L11:
        a.a("stopAsrAudio");
    L12:
        StopSpeechRecognitionResultModel r16 = new StopSpeechRecognitionResultModel();
        r16.a(StopSpeechRecognitionResultModel.Code.Success);
        finishWithResult(r16);
        return;
    L13:
        AsrState r17 = f7.c.a;
        if (f7.c.a == AsrState.STARTED) goto L16;
        int r18 = 1;
    L20:
        if (r18 != 0) goto L22;
        StopSpeechRecognitionResultModel r19 = new StopSpeechRecognitionResultModel();
        r19.a(StopSpeechRecognitionResultModel.Code.Success);
        finishWithResult(r19);
        return;
    L22:
        StopSpeechRecognitionResultModel r20 = new StopSpeechRecognitionResultModel();
        r20.a(StopSpeechRecognitionResultModel.Code.Failed);
        r20.b("failed with code: " + r18);
        finishWithResult(r20);
        return;
    L16:
        a9.e r21 = (a9.e) Annie.getService$default(a9.e.class, null, 2, null);
        if (r21 != null) goto L19;
        r18 = 2;
        goto L20
    L19:
        r21.stop();
        r18 = 3;
        goto L20
    }
}
