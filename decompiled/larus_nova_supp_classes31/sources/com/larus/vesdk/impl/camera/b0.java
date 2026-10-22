package com.larus.vesdk.impl.camera;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.utils.logger.FLogger;
import com.ss.android.vesdk.VERecorder;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b0 implements VERecorder.VECameraZoomListener {
    public final /* synthetic */ VeCameraImpl a;

    public final boolean enableSmooth() {
        return false;
    }

    public b0(VeCameraImpl r1) {
        this.a = r1;
    }

    public final void onChange(int r4, float r5, boolean r6) {
        VeCameraImpl r0 = this.a;
        if (r0.q == true) goto L7;
        pq9.b r1 = r0.n;
        if (r1 == null) goto L7;
        r1.c(r4, r5);
    L7:
        FLogger.a.i("VeCameraImpl", "onChange, cameraType:" + r4 + ",zoomValue:" + r5 + ",stopped:" + r6);
    }

    public final void onZoomSupport(int r1, boolean r2, boolean r3, float r4, List<Integer> r5) {
        VeCameraImpl r6 = this.a;
        if (r6.y() == false) goto L12;
        if (r5 == null) goto L8;
        Integer r7 = (Integer) CollectionsKt.getOrNull(r5, 1);
        if (r7 == null) goto L8;
        float r8 = r7.intValue() / 100.0f;
    L9:
        RangesKt.coerceAtLeast(r8, 0.1f);
        pq9.b r9 = this.a.n;
        if (r9 == null) goto L15;
        Float r10 = Float.valueOf(r9.b(r4));
    L16:
        if (r10 == null) goto L18;
        float r11 = r10.floatValue();
    L19:
        r6.h = r11;
        FLogger.a.i("VeCameraImpl", "onZoomSupport, maxZoom:" + r4 + " maxZoomValue:" + this.a.h + ", ratio=" + GsonProtectorUtils.toJson(new Gson(), r5));
        return;
    L18:
        r11 = r4;
    L15:
        r10 = null;
    L8:
        r8 = 1.0f;
        goto L9
    L12:
        pq9.b r12 = this.a.n;
        if (r12 == null) goto L15;
        r10 = Float.valueOf(r12.a(r4));
        goto L16
    }
}
