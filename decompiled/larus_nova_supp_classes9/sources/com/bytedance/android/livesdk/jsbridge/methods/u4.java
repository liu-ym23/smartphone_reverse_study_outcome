package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.live.browser.UtilsKt;
import com.bytedance.android.live.browser.jsbridge.base.UploadTraceMonitorResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import w20.c7;
import w20.nf;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@XBridgeMethod(biz = "webcast", name = "uploadTraceMonitor")
public final class u4 extends c7<nf, UploadTraceMonitorResultModel> {

    public static final class a {
    }

    static {
    }

    public u4() {
    }

    public final void invoke(Object r13, CallContext r14) {
        nf r15 = (nf) r13;
        Intrinsics.checkNotNullParameter(r15, "params");
        Intrinsics.checkNotNullParameter(r14, "context");
        LocalTestManager.a(new Class[]{wy.a.class});
        UploadTraceMonitorResultModel r0 = new UploadTraceMonitorResultModel();
        String r3 = r15.a();
        if (r3 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L12;
        r0.a(UploadTraceMonitorResultModel.Code.Failed);
        r0.b("business type is null or blank");
        Unit r16 = Unit.INSTANCE;
        finishWithResult(r0);
        ALogger.e("UploadTraceMethod", "business type name is null or blank");
        return;
    L12:
        String r2 = r15.g();
        if (r2 != null) goto L15;
    L18:
        boolean r5 = true;
    L19:
        if (r5 == false) goto L21;
        r0.a(UploadTraceMonitorResultModel.Code.Failed);
        r0.b("trace name is null or blank");
        Unit r17 = Unit.INSTANCE;
        finishWithResult(r0);
        ALogger.e("UploadTraceMethod", "trace name is null or blank");
        return;
    L21:
        String r6 = r15.f();
        if (r6 != null) goto L24;
    L27:
        boolean r7 = true;
    L28:
        if (r7 == false) goto L30;
        r0.a(UploadTraceMonitorResultModel.Code.Failed);
        r0.b("step is null or blank");
        Unit r18 = Unit.INSTANCE;
        finishWithResult(r0);
        ALogger.e("UploadTraceMethod", "step is null or blank");
        return;
    L30:
        LinkedHashMap r9 = new LinkedHashMap();
        JsonObject r4 = r15.e();
        if (r4 == null) goto L38;
        Iterator r8 = UtilsKt.i(r4).entrySet().iterator();
    L34:
        if (r8.hasNext() == false) goto L38;
        Map.Entry r10 = (Map.Entry) r8.next();
        String r11 = (String) r10.getKey();
        Object r19 = r10.getValue();
        if ((!StringsKt.isBlank(r11)) == false) goto L34;
        r9.put(r11, r19);
    L38:
        JSONObject r20 = new JSONObject();
        JsonObject r21 = r15.d();
        if (r21 == null) goto L46;
        Iterator r23 = UtilsKt.i(r21).entrySet().iterator();
    L42:
        if (r23.hasNext() == false) goto L46;
        Map.Entry r24 = (Map.Entry) r23.next();
        String r25 = (String) r24.getKey();
        Object r26 = r24.getValue();
        if ((!StringsKt.isBlank(r25)) == false) goto L42;
        r20.put(r25, r26);
    L46:
        Integer r110 = r15.b();
        if (r110 == null) goto L49;
        int r27 = r110.intValue();
    L50:
        String r111 = r15.c();
        if (r111 != null) goto L53;
        r111 = BuildConfig.FLAVOR;
    L53:
        String r28 = r111;
        int r112 = rd0.a.a;
        rd0.a.a(r3, r2, r6, r27, r28, r20, r9);
        r0.a(UploadTraceMonitorResultModel.Code.Success);
        Unit r113 = Unit.INSTANCE;
        finishWithResult(r0);
        return;
    L49:
        r27 = 0;
        goto L50
    L24:
        if (StringsKt.isBlank(r6) == true) goto L27;
        r7 = false;
        goto L28
    L15:
        if (StringsKt.isBlank(r2) == true) goto L18;
        r5 = false;
        goto L19
    L5:
        if (StringsKt.isBlank(r3) == true) goto L8;
        r1 = false;
        goto L10
    }
}
