package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.view.View;
import android.webkit.WebView;
import com.bytedance.android.live.base.model.exception.NetworkErrorException;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.activity.ActivityMonitor;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.u00;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import io.reactivex.functions.Consumer;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class k3<T> implements Consumer {
    public final /* synthetic */ FetchV3Method a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ Ref.ObjectRef d;
    public final /* synthetic */ CallContext e;

    public k3(FetchV3Method r1, String r2, String r3, Ref.ObjectRef r4, CallContext r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final void accept(Object r13) {
        Throwable r14 = (Throwable) r13;
        Throwable r3 = null;
        HybridLogger.m("BDXBridge", "fetch failed", null, null, 12);
        if (((Boolean) u00.a.getValue()).booleanValue() == false) goto L27;
        JSONObject r0 = new JSONObject();
        r0.putOpt("code", 0);
        FetchV3Method r4 = this.a;
        String r11 = r14.getMessage();
        r4.getClass();
        Object r2 = 0;
        if (r11 != null) goto L54;
    L15:
        r0.putOpt("request_error_code", r2);
        if ((r14 instanceof NetworkErrorException) == true) goto L18;
        Throwable r5 = null;
    L19:
        NetworkErrorException r6 = (NetworkErrorException) r5;
        if (r6 == null) goto L22;
        int r7 = r6.statusCode;
    L23:
        r0.putOpt("status_code", Integer.valueOf(r7));
        if ((r14 instanceof RawNotJsonException) == false) goto L26;
        RawNotJsonException r8 = (RawNotJsonException) r14;
        r0.putOpt("raw", r8.getRaw());
        JSONObject r9 = new JSONObject();
        r9.putOpt("x-tt-logid", r8.getXTTLogId());
        Unit r12 = Unit.INSTANCE;
        r0.putOpt("header", r9);
    L26:
        this.a.finishWithRawResult(r0);
    L28:
        int r15 = ActivityMonitor.ActivityStatusCode.UNKNOWN_CODE.getCode();
        String r16 = this.b;
        String r17 = this.c;
        JSONObject r18 = (JSONObject) this.d.element;
        if (r14 == null) goto L31;
        String r19 = r14.getMessage();
    L32:
        x40.c.b(r15, r16, r17, r18, r19, "");
        FetchV3Method r1 = this.a;
        View r21 = this.e.d;
        String r22 = this.b;
        String r23 = this.c;
        r1.getClass();
        if ((r14 instanceof NetworkErrorException) == false) goto L36;
        r3 = r14;
    L36:
        NetworkErrorException r24 = (NetworkErrorException) r3;
        if (r24 == null) goto L39;
        int r110 = r24.statusCode;
    L40:
        ALogger.i("fetch", "reportJsbError reportJsbError: errorCode = " + r110 + ", message: " + r14.getMessage());
        if (r21 != null) goto L44;
        return;
    L44:
        if ((r21 instanceof WebView) == false) goto L50;
        IBrowserService r25 = (IBrowserService) jc1.k.f(IBrowserService.class);
        if (r25 == null) goto L56;
        v30.a r26 = r25.webViewMonitorHelper();
        if (r26 == null) goto L57;
        r26.a((WebView) r21, r22, r23, r110, r14.getMessage());
        return;
    L57:
        return;
    L56:
        return;
    L50:
        IBrowserService r27 = (IBrowserService) jc1.k.f(IBrowserService.class);
        if (r27 == null) goto L59;
        r27.reportLynxFetchJsbError(r21, r22, r23, r110, r14.getMessage());
        return;
    L59:
        return;
    L39:
        r110 = -1;
        goto L40
    L31:
        r19 = null;
        goto L32
    L22:
        int r28 = FetchV3Method.e;
        r7 = -1;
        goto L23
    L18:
        r5 = r14;
        goto L19
    L54:
        Result.Companion r29 = Result.Companion;     // Catch: Throwable -> L9
        int r31 = StringsKt.lastIndexOf$default(r11, "InternalErrorCode=", 0, false, 6, null);     // Catch: Throwable -> L9
        r2 = Integer.valueOf(CastIntegerProtector.parseInt(r11.substring(r31 + 18, StringsKt.indexOf$default(r11, ',', r31, false, 4, null))));     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Result.Companion r32 = Result.Companion;
        Object r33 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r33) == true) goto L14;
        r2 = r33;
    L14:
        r2 = (Number) r2;
        goto L15
    L27:
        this.a.finishWithFailure();
        goto L28
    }
}
