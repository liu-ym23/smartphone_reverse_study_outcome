package uj0;

import android.graphics.Bitmap;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.live.livelink.kmp.api.core.mixer.RTCWaterMarkRegion;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ti6.e;
import ti6.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements d {
    public final Map<String, RTCWaterMarkRegion> b;
    public final Function0<ei6.a> c;

    @Override // uj0.d
    public final void init() {
        if (((ei6.a) this.c.invoke()) == null) goto L6;
        ALogger.d("MicseatMixer", "BitmapRenderer init");
        return;
    }

    @Override // uj0.d
    public final void release() {
        ei6.a r0 = (ei6.a) this.c.invoke();
        if (r0 == null) goto L11;
        ALogger.d("MicseatMixer", "BitmapRenderer release");
        ti6.d r1 = r0.p();
        if (r1 == null) goto L9;
        e r2 = r1.f();
        if (r2 == null) goto L9;
        r2.n();
    L9:
        ((LinkedHashMap) this.b).clear();
        return;
    }

    public a(Function0<? extends ei6.a> r2) {
        Intrinsics.checkNotNullParameter(r2, "getRtcClient");
        this.c = r2;
        this.b = new LinkedHashMap();
    }

    @Override // uj0.d
    public final void a(com.bytedance.android.live.liveinteract.videotalk.avatarmix.d r3) {
        Intrinsics.checkNotNullParameter(r3, "struct");
        ALogger.d("MicseatMixer", "BitmapRenderer clear " + r3);
        ei6.a r0 = (ei6.a) this.c.invoke();
        if (r0 == null) goto L11;
        d.a.getClass();
        String r4 = d.a.a(r3);
        ti6.d r1 = r0.p();
        if (r1 == null) goto L9;
        e r2 = r1.f();
        if (r2 == null) goto L9;
        r2.k(r4);
    L9:
        this.b.remove(r4);
        return;
    }

    @Override // uj0.d
    public final void b(com.bytedance.android.live.liveinteract.videotalk.avatarmix.d r6, Bitmap r7) {
        Intrinsics.checkNotNullParameter(r6, "struct");
        Intrinsics.checkNotNullParameter(r7, "bitmap");
        if (r7.isRecycled() == false) goto L5;
        return;
    L5:
        if (r7.getWidth() > 0) goto L7;
        return;
    L7:
        if (r7.getHeight() <= 0) goto L35;
        ALogger.d("MicseatMixer", "BitmapRenderer render " + r6 + ", bitmap: " + r7);
        ei6.a r1 = (ei6.a) this.c.invoke();
        if (r1 == null) goto L32;
        d.a.getClass();
        String r2 = d.a.a(r6);
        f r8 = r6.e;
        Intrinsics.checkNotNullParameter(r8, "region");
        Intrinsics.checkNotNullParameter(r7, "bitmap");
        RTCWaterMarkRegion r0 = new RTCWaterMarkRegion();
        r0.a = (float) r8.d;
        r0.c = (float) r8.f;
        r0.b = (float) r8.e;
        r0.d = (float) r8.g;
        r0.e = 0;
        r0.h = r7;
        RTCWaterMarkRegion.TranscoderImageRenderMode r9 = RTCWaterMarkRegion.TranscoderImageRenderMode.RENDER_HIDDEN;
        Intrinsics.checkNotNullParameter(r9, "<set-?>");
        r0.g = r9;
        if (((LinkedHashMap) this.b).get(r2) == null) goto L18;
        ti6.d r10 = r1.p();
        if (r10 == null) goto L24;
        e r11 = r10.f();
        if (r11 == null) goto L24;
        System.currentTimeMillis();
        r11.b(r2, r0);
    L24:
        ti6.d r12 = r1.p();
        if (r12 == null) goto L33;
        e r13 = r12.f();
        if (r13 == null) goto L34;
        r13.o();
        return;
    L34:
        return;
    L33:
        return;
    L18:
        ti6.d r14 = r1.p();
        if (r14 == null) goto L23;
        e r15 = r14.f();
        if (r15 == null) goto L23;
        System.currentTimeMillis();
        r15.a(r2, r0);
    L23:
        this.b.put(r2, r0);
        goto L24
    L32:
        return;
    }
}
