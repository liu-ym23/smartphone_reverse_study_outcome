package com.bytedance.android.live.livelink.multilink.media;

import com.bytedance.kmp.live.livelink.api.multilink.monitor.LinkMonitor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import org.json.JSONObject;
import vm2.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class LiveSdkParamsAdjuster {
    public volatile int a;
    public final ec6.b b;
    public final ei6.a c;
    public final boolean d;
    public final fc6.a e;

    public static final class a {
    }

    public static final class b implements kb6.a {
        public final /* synthetic */ Lazy a;

        public b(Lazy r1) {
            this.a = r1;
        }
    }

    public static final class c implements kb6.a {
        public c() {
        }
    }

    static {
    }

    public final void a(final String r20) {
        Intrinsics.checkNotNullParameter(r20, "params");
        ReadOnlyProperty r2 = i.e;
        KProperty[] r3 = i.a;
        final LiveSdkParamsAdjuster r5 = null;
        if (((Boolean) r2.getValue(null, r3[3])).booleanValue() == true) goto L5;
        return;
    L5:
        Lazy r1 = LazyKt.lazy(new LiveSdkParamsAdjuster$adjustLiveSdkParams$updateParams$2(r20));
        final Lazy r4 = LazyKt.lazy(new LiveSdkParamsAdjuster$adjustLiveSdkParams$cachedParams$2(this));
        Lazy r6 = LazyKt.lazy(new LiveSdkParamsAdjuster$adjustLiveSdkParams$cachedSiti$2(r4, r5));
        Lazy r7 = LazyKt.lazy(new LiveSdkParamsAdjuster$adjustLiveSdkParams$cachedFpsFallBack$2(r4, r5));
        boolean r9 = false;
        if (((Boolean) i.f.getValue(null, r3[4])).booleanValue() == false) goto L30;
        if (this.d == false) goto L30;
        JSONObject r8 = (JSONObject) r1.getValue();
        if (r8 == null) goto L12;
        int r10 = r8.optInt("defaultBitrate");
    L13:
        JSONObject r11 = (JSONObject) r1.getValue();
        if (r11 == null) goto L16;
        int r12 = r11.optInt("minBitrate");
    L17:
        JSONObject r13 = (JSONObject) r1.getValue();
        if (r13 == null) goto L20;
        int r14 = r13.optInt("maxBitrate");
    L21:
        if (r10 <= 0) goto L30;
        if (r12 <= 0) goto L30;
        if (r14 <= 0) goto L30;
        ec6.b r15 = this.b;
        if (r15 == null) goto L30;
        sk0.a r16 = r15.c();
        if (r16 == null) goto L30;
        this.e.o().getClass();
        r16.i("", new c());
        goto L30
    L20:
        r14 = 0;
        goto L21
    L16:
        r12 = 0;
        goto L17
    L12:
        r10 = 0;
    L30:
        if (((Boolean) i.h.getValue(null, r3[6])).booleanValue() == false) goto L107;
        JSONObject r17 = (JSONObject) r1.getValue();
        if (r17 == null) goto L34;
        int r18 = r17.optInt("fps");
    L36:
        if (this.d == false) goto L88;
        if (r18 <= 0) goto L58;
        ec6.b r19 = this.b;
        if (r19 == null) goto L43;
        sk0.a r21 = r19.c();
        if (r21 == null) goto L43;
        r21.a(false);
    L43:
        ec6.b r22 = this.b;
        if (r22 == null) goto L48;
        sk0.a r23 = r22.c();
        if (r23 == null) goto L48;
        this.e.o().getClass();
        r23.i("", null);
    L48:
        ei6.a r24 = this.c;
        if (r24 == null) goto L54;
        fi6.a r25 = r24.g();
        if (r25 == null) goto L54;
        r25.j0 = false;
    L54:
        if (r18 == this.a) goto L56;
        LinkMonitor.a("LiveSdkParamsAdj", "adjust_fps", "set fps to " + r18 + " and disable siti ,enableMixStreamDropFrame to false", null, null, false, 120);
    L56:
        this.a = r18;
        return;
    L58:
        if (this.a <= 0) goto L109;
        ec6.b r26 = this.b;
        if (r26 == null) goto L64;
        sk0.a r27 = r26.c();
        if (r27 == null) goto L64;
        r27.a(((Boolean) r7.getValue()).booleanValue());
    L64:
        ec6.b r28 = this.b;
        if (r28 == null) goto L69;
        sk0.a r29 = r28.c();
        if (r29 == null) goto L69;
        vk0.b r30 = this.e.o();
        ((Boolean) r6.getValue()).booleanValue();
        r30.getClass();
        r29.i("", null);
    L69:
        ei6.a r31 = this.c;
        if (r31 == null) goto L74;
        fi6.a r32 = r31.g();
        if (r32 == null) goto L74;
        r32.j0 = true;
    L74:
        JSONObject r33 = (JSONObject) r4.getValue();
        if (r33 == null) goto L77;
        int r34 = r33.optInt("fps");
    L78:
        if (r34 <= 0) goto L80;
        r9 = true;
    L80:
        if (r9 == false) goto L82;
        r5 = this;
    L82:
        if (r5 == null) goto L110;
        ec6.b r35 = this.b;
        if (r35 == null) goto L111;
        sk0.a r36 = r35.c();
        if (r36 == null) goto L112;
        this.e.o().getClass();
        r36.i("", new b(r6));
        return;
    L112:
        return;
    L111:
        return;
    L110:
        return;
    L77:
        r34 = 0;
        goto L78
    L109:
        return;
    L88:
        if (r18 <= 0) goto L99;
        ec6.b r37 = this.b;
        if (r37 == null) goto L95;
        com.bytedance.android.live.livelink.platformapi.avclient.video.a r38 = r37.e();
        if (r38 == null) goto L95;
        r38.a(r18, "multi_link_fps_adjust");
    L95:
        if (r18 == this.a) goto L97;
        LinkMonitor.a("LiveSdkParamsAdj", "adjust_fps", "set fps to " + r18, null, null, false, 120);
    L97:
        this.a = r18;
        return;
    L99:
        if (this.a <= 0) goto L115;
        int r39 = ((Number) i.g.getValue(null, r3[5])).intValue();
        ec6.b r40 = this.b;
        if (r40 == null) goto L105;
        com.bytedance.android.live.livelink.platformapi.avclient.video.a r41 = r40.e();
        if (r41 == null) goto L105;
        r41.a(r39, "multi_link_fps_fall_back");
    L105:
        LinkMonitor.a("LiveSdkParamsAdj", "fallback_fps", "set fps to " + r39, null, null, false, 120);
        this.a = 0;
        return;
    L115:
        return;
    L34:
        r18 = 0;
        goto L36
    }

    public LiveSdkParamsAdjuster(ec6.b r2, ei6.a r3, boolean r4, fc6.a r5) {
        Intrinsics.checkNotNullParameter(r5, "hostService");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
