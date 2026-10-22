package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "requestOrientationPermission")
public final class bb extends r<cb, RequestOrientationPermissionResultModel> {
    public com.bytedance.ies.web.jsbridge2.d0 a;
    public IHybridComponent b;
    public final TokenCert c;

    public static final class a {
    }

    static {
    }

    public final void onTerminate() {
        l30.d.h.c();
        this.a = null;
        this.b = null;
    }

    public bb(com.bytedance.ies.web.jsbridge2.d0 r2) {
        this.a = r2;
        this.c = TokenCert.Companion.with("bpea-requestOrientationPermission_jsb_request_gyroscope_orientation");
    }

    public final void invoke(Object r8, CallContext r9) {
        cb r11 = (cb) r8;
        Intrinsics.checkNotNullParameter(r11, "params");
        Intrinsics.checkNotNullParameter(r9, "context");
        Boolean r1 = r11.a();
        Integer r2 = r11.b();
        if (r2 == null) goto L5;
        long r3 = r2.intValue();
    L7:
        if (r3 >= 10) goto L9;
        r3 = 10;
    L9:
        String r12 = r11.c();
        if (r12 == null) goto L13;
        TokenCert r13 = TokenCert.Companion.with(r12);
        if (r13 == null) goto L13;
    L15:
        if (Intrinsics.areEqual(r1, Boolean.TRUE) == true) goto L17;
    L43:
        l30.d.h.c();
    L44:
        finishWithSuccess();
        return;
    L17:
        if (r3 < 0) goto L43;
        l30.d r4 = l30.d.h;
        Context r14 = r9.getContext();
        int r5 = (int) r3;
        Intrinsics.checkNotNullParameter(r14, "context");
        Intrinsics.checkNotNullParameter(r13, "tokenCert");
        r4.c();
        if (l30.d.a != null) goto L26;
        Object r15 = r14.getSystemService("sensor");
        if (r15 == null) goto L24;
        l30.d.a = (SensorManager) r15;
        goto L26
    L24:
        throw new NullPointerException("null cannot be cast to non-null type android.hardware.SensorManager");
    L26:
        if (l30.d.b != null) goto L32;
        SensorManager r16 = l30.d.a;
        if (r16 == null) goto L30;
        Sensor r17 = g80.f.a(r16, 15, r13);
    L31:
        l30.d.b = r17;
        goto L32
    L30:
        r17 = null;
    L32:
        SensorManager r18 = l30.d.a;
        if (r18 == null) goto L35;
        r18.registerListener(r4, l30.d.b, r5 * 1000);
    L35:
        com.bytedance.ies.web.jsbridge2.d0 r19 = this.a;
        IHybridComponent r21 = this.b;
        Disposable r0 = l30.d.g;
        if (r0 != null) goto L38;
    L42:
        com.bytedance.android.live.core.utils.rxutils.j.a r6 = com.bytedance.android.live.core.utils.rxutils.j.a;
        l30.d.g = com.bytedance.android.live.core.utils.rxutils.j.c(r3, TimeUnit.MILLISECONDS).subscribe(new l30.b(r19, r21), l30.c.a);
        goto L44
    L38:
        if (r0.isDisposed() == true) goto L42;
        Disposable r7 = l30.d.g;
        if (r7 == null) goto L42;
        r7.dispose();
    L13:
        r13 = this.c;
        goto L15
    L5:
        r3 = 100;
        goto L7
    }
}
