package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import kotlin.Deprecated;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Deprecated(message = "using for ppx")
@XBridgeMethod(biz = "webcast", name = "openZmCert")
public final class ge extends com.bytedance.ies.web.jsbridge2.f<b30.g0, Unit> {
    public Disposable a;

    public final void onTerminate() {
        Disposable r0 = this.a;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    public ge() {
    }

    public final void invoke(Object r3, CallContext r4) {
        b30.g0 r5 = (b30.g0) r3;
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r4, "context");
        String r6 = r5.b();
        boolean r0 = true;
        if (r6 != null) goto L5;
    L8:
        boolean r7 = true;
    L9:
        if (r7 == true) goto L27;
        String r8 = r5.a();
        if (r8 != null) goto L13;
    L16:
        boolean r9 = true;
    L17:
        if (r9 == true) goto L27;
        String r11 = r5.c();
        if (r11 != null) goto L21;
    L24:
        if (r0 == true) goto L27;
        this.a = xs2.b.a().b(b30.h0.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new ee(this), new fe(this));
        xs2.b.a().post(r5);
        return;
    L21:
        if (r11.length() == 0) goto L24;
        r0 = false;
        goto L24
    L13:
        if (r8.length() == 0) goto L16;
        r9 = false;
    L27:
        finishWithFailure();
        return;
    L5:
        if (r6.length() == 0) goto L8;
        r7 = false;
        goto L9
    }
}
