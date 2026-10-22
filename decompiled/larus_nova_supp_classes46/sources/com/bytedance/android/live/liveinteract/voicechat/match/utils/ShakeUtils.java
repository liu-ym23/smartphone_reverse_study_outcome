package com.bytedance.android.live.liveinteract.voicechat.match.utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleObserver;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.u2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.liveinteract.IMultiCommonService;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApis;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdkapi.model.MultiLinkFirstFrameOptConfigV2;
import com.bytedance.bpea.cert.token.TokenCert;
import hd0.c;
import ik0.e;
import ik0.f;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import jc1.k;
import vm2.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class ShakeUtils implements SensorEventListener, LifecycleObserver {
    public static final TokenCert o = null;
    public SensorManager a;
    public a b;
    public boolean c;
    public int d;
    public long e;
    public long f;
    public int g;
    public final int h;
    public int i;
    public float j;
    public float k;
    public float l;
    public final MultiLinkFirstFrameOptConfigV2 m;
    public Disposable n;

    public interface a {
        void a();
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor r1, int r2) {
    }

    static {
        o = TokenCert.with("bpea-shakeutils_getdefaultsensor");
    }

    public final void a(Map<String, Double> r2) {
        this.g = r2.get("speed_shake_millisecond").intValue();
        this.d = r2.get("min_shake_interval").intValue();
        this.i = r2.get("shake_interval_millisecond").intValue();
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent r10) {
        if (this.c == false) goto L5;
        return;
    L5:
        if (r10 == null) goto L32;
        float[] r0 = r10.values;
        if (r0 != null) goto L9;
        return;
    L9:
        if (r0.length < 3) goto L37;
        long r1 = System.currentTimeMillis();
        long r2 = r1 - this.f;
        if (r2 >= this.i) goto L14;
        return;
    L14:
        this.f = r1;
        float[] r11 = r10.values;
        boolean r3 = false;
        float r4 = r11[0];
        float r5 = r11[1];
        float r12 = r11[2];
        float r6 = r4 - this.j;
        float r7 = r5 - this.k;
        float r8 = r12 - this.l;
        this.j = r4;
        this.k = r5;
        this.l = r12;
        double r9 = (Math.sqrt(((r6 * r6) + (r7 * r7)) + (r8 * r8)) * 1000.0d) / r2;
        if (c.f().h() == false) goto L20;
        if (r9 < this.h) goto L22;
    L18:
        r3 = true;
    L22:
        if (r3 == false) goto L34;
        long r13 = System.currentTimeMillis();
        if ((r13 - this.e) < this.d) goto L38;
        this.e = r13;
        a r14 = this.b;
        if (r14 != null) goto L29;
        return;
    L29:
        if (this.c == true) goto L36;
        r14.a();
        return;
    L36:
        return;
    L38:
        return;
    L34:
        return;
    L20:
        if (r9 < this.g) goto L22;
    L37:
        return;
    }

    public ShakeUtils(Context r5, int r6) {
        FragmentActivity r0 = null;
        this.b = null;
        this.c = false;
        this.d = 1024;
        this.e = 0;
        this.f = 0;
        this.g = 400;
        this.h = 400;
        this.i = 55;
        this.j = 0.0f;
        this.k = 0.0f;
        this.l = 0.0f;
        this.m = (MultiLinkFirstFrameOptConfigV2) u2.a.getValue();
        this.n = null;
        if ((r5 instanceof FragmentActivity) == false) goto L5;
        ((FragmentActivity) r5).getLifecycle().addObserver(this);
    L5:
        this.a = (SensorManager) r5.getSystemService("sensor");
        this.g = r6;
        if (((IMultiCommonService) k.f(IMultiCommonService.class)).useGalileoData() == false) goto L8;
        Map<String, Double> r7 = (Map) com.bytedance.android.livesdk.sharedpref.c.b1.getValue();
        a(r7);
        ALogger.d("ShakeUtils", "initGalileoConfig galileoData: " + r7);
    L8:
        this.h = h.b0().b();
        if (this.g >= 200) goto L12;
        this.g = 200;
    L12:
        if (((IMultiCommonService) k.f(IMultiCommonService.class)).useGalileoData() == true) goto L15;
        return;
    L15:
        if ((r5 instanceof FragmentActivity) == false) goto L17;
        r0 = (FragmentActivity) r5;
    L17:
        long r1 = System.currentTimeMillis() - ((Long) com.bytedance.android.livesdk.sharedpref.c.w1.getValue()).longValue();
        if (r0 != null) goto L20;
        return;
    L20:
        if (r1 < 86400000) goto L24;
        ((ObservableSubscribeProxy) ((LinkApis) com.bytedance.android.live.network.c.b().e(LinkApis.class)).galileoParamsRequest().compose(RxUtil.rxSchedulerHelper()).as(AutoDispose.bind(r0))).subscribe(new e(this), new f());
        return;
    }
}
