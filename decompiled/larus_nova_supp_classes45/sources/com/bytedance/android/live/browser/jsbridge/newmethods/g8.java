package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "observeShakeMobile")
public final class g8 extends com.bytedance.ies.web.jsbridge2.f<JSONObject, JSONObject> implements SensorEventListener {
    public SensorManager a;
    public Disposable b;
    public boolean c;
    public final TokenCert d;

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor r1, int r2) {
    }

    public final void onTerminate() {
        SensorManager r0 = this.a;
        if (r0 == null) goto L5;
        j(r0, this);
    L5:
        Disposable r1 = this.b;
        if (r1 != null) goto L8;
        return;
    L8:
        if (r1.isDisposed() == true) goto L14;
        Disposable r2 = this.b;
        if (r2 == null) goto L15;
        r2.dispose();
        return;
    L15:
        return;
    }

    public g8() {
        this.d = TokenCert.Companion.with("bpea-live_observeShakeMobile_jsb_observe_shake_mobile");
    }

    public final void onDestroy() {
        super.onDestroy();
        SensorManager r0 = this.a;
        if (r0 == null) goto L5;
        j(r0, this);
    L5:
        Disposable r1 = this.b;
        if (r1 != null) goto L8;
        return;
    L8:
        if (r1.isDisposed() == true) goto L14;
        Disposable r2 = this.b;
        if (r2 == null) goto L15;
        r2.dispose();
        return;
    L15:
        return;
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent r6) {
        if (r6 == null) goto L19;
        Sensor r0 = r6.sensor;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.getType() != 1) goto L26;
        float[] r7 = r6.values;
        if (r7 == null) goto L27;
        int r1 = r7.length;
        int r2 = 0;
    L10:
        if (r2 >= r1) goto L28;
        if (Math.abs(r7[r2]) <= 25) goto L18;
        if (this.c == true) goto L18;
        this.c = true;
        JSONObject r3 = new JSONObject();
        r3.put("code", 1);
        finishWithResult(r3);
        SensorManager r4 = this.a;
        if (r4 == null) goto L18;
        j(r4, this);
    L18:
        r2 = r2 + 1;
        goto L10
    L28:
        return;
    L27:
        return;
    L26:
        return;
    }

    public static void j(SensorManager r1, SensorEventListener r2) {
        if (fna.g.d() == true) goto L6;
        r1.unregisterListener(r2);
        return;
    L6:
        r1.unregisterListener(r2);
        if (r2 == null) goto L9;
        int r3 = r2.hashCode();
    L10:
        ona.b.c(new ona.a(r3, null));
        return;
    L9:
        r3 = 0;
        goto L10
    }

    public final void invoke(Object r8, CallContext r9) {
        JSONObject r11 = (JSONObject) r8;
        Intrinsics.checkNotNullParameter(r11, "params");
        Intrinsics.checkNotNullParameter(r9, "context");
        long r3 = r11.optLong("time", 0);
        String r12 = r11.optString("token", "");
        if (r12 != null) goto L5;
    L8:
        boolean r6 = true;
    L9:
        if (r6 == false) goto L11;
        TokenCert r13 = this.d;
    L13:
        if (r3 > 0) goto L15;
        finishWithFailure();
        return;
    L15:
        Sensor r2 = null;
        if (this.a != null) goto L22;
        Context r14 = r9.getContext();
        if (r14 == null) goto L20;
        Object r15 = r14.getSystemService("sensor");
    L21:
        this.a = (SensorManager) r15;
        goto L22
    L20:
        r15 = null;
    L22:
        this.c = false;
        SensorManager r16 = this.a;
        if (r16 == null) goto L25;
        j(r16, this);
    L25:
        SensorManager r17 = this.a;
        if (r17 == null) goto L28;
        r2 = g80.f.a(r17, 1, r13);
    L28:
        if (r2 == null) goto L32;
        SensorManager r18 = this.a;
        if (r18 == null) goto L32;
        r18.registerListener(this, r2, 2);
    L32:
        this.b = Observable.timer(r3, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new f8(this));
        return;
    L11:
        r13 = TokenCert.Companion.with(r12);
        goto L13
    L5:
        if (StringsKt.isBlank(r12) == true) goto L8;
        r6 = false;
        goto L9
    }
}
