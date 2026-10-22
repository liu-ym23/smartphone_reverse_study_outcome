package com.bytedance.android.live.livepkaudience.rtc;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.config.pd1;
import com.bytedance.live.livelink.kmp.api.core.mixer.RTCWaterMarkRegion;
import dl0.n;
import gy.f;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d {
    public static final float f = 0.0f;
    public static final double g = 0.0d;
    public static final double h = 0.0d;
    public static final double i = 0.0d;
    public final Bitmap a;
    public final Bitmap b;
    public final HashMap<String, Bitmap> c;
    public final CompositeDisposable d;
    public final a e;

    public static final class a {
        public int a;
        public int b;

        public a() {
        }
    }

    public static final class b {
    }

    static {
        f = ((Float) pd1.a.getValue()).floatValue() + 0.17f;
        g = 0.25d;
        h = 0.40625d;
        i = (((double) 360) * 0.25d) / ((double) 640);
    }

    public final void c() {
        CompositeDisposable r0 = this.d;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        gy.c.c2.getClass();
        gy.c r1 = gy.c.a.a();
        if (r1 == null) goto L11;
        f r2 = r1.getRtcManager();
        if (r2 == null) goto L12;
        r2.n();
        return;
    L12:
        return;
    }

    public d() {
        this.a = BitmapFactory.decodeResource(s1.getResources(), 2131252590);
        this.b = BitmapFactory.decodeResource(s1.getResources(), 2131252609);
        this.c = new HashMap();
        this.d = new CompositeDisposable();
        a r0 = new a();
        r0.a = 288;
        r0.b = 288;
        Unit r1 = Unit.INSTANCE;
        this.e = r0;
    }

    public static String a(int r2) {
        return n.d() + "_" + String.valueOf(r2);
    }

    public static void d(int r1) {
        gy.c.c2.getClass();
        gy.c r0 = gy.c.a.a();
        if (r0 == null) goto L7;
        f r2 = r0.getRtcManager();
        if (r2 == null) goto L7;
        r2.k(a(r1));
    L7:
        gy.c r3 = gy.c.a.a();
        if (r3 == null) goto L13;
        f r4 = r3.getRtcManager();
        if (r4 == null) goto L14;
        r4.o();
        return;
    L14:
        return;
    }

    public static void b(Bitmap r10, int r11) {
        RTCWaterMarkRegion r0 = new RTCWaterMarkRegion();
        ti6.f r1 = new ti6.f();
        double r2 = g;
        double r4 = i;
        r1.f = r2;
        r1.g = r4;
        double r6 = ((double) r11) * r2;
        double r3 = (((double) f) + h) - r4;
        r1.d = r6;
        r1.e = r3;
        r1.o = 0;
        r1.a("0");
        r0.a = (float) r1.d;
        r0.c = (float) r1.f;
        r0.b = (float) r1.e;
        r0.d = (float) r1.g;
        r0.e = 0;
        r0.h = r10;
        gy.c.c2.getClass();
        gy.c r12 = gy.c.a.a();
        if (r12 == null) goto L7;
        f r13 = r12.getRtcManager();
        if (r13 == null) goto L7;
        r13.i(a(r11), r0, System.currentTimeMillis() * ((long) 1000));
    L7:
        gy.c r14 = gy.c.a.a();
        if (r14 == null) goto L13;
        f r15 = r14.getRtcManager();
        if (r15 == null) goto L14;
        r15.o();
        return;
    L14:
        return;
    }
}
