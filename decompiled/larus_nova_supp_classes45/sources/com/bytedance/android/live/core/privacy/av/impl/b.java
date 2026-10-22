package com.bytedance.android.live.core.privacy.av.impl;

import android.hardware.camera2.CameraManager;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b extends CameraManager.AvailabilityCallback {
    public final /* synthetic */ c a;

    public b(c r1) {
        this.a = r1;
    }

    @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
    public final void onCameraAvailable(String r15) {
        Intrinsics.checkNotNullParameter(r15, "cameraId");
        c.f(this.a, r15, false);
        this.a.i.a("onCameraStatusChanged; isPermissionOnUse=" + this.a.b + ", cameraId=" + r15);
        super.onCameraAvailable(r15);
        if (this.a.h.h() == false) goto L10;
        List<String> r1 = this.a.h.d();
        if (r1 != null) goto L7;
        return;
    L7:
        if (r1.contains("av_status_change") != true) goto L12;
        this.a.i.c(new com.bytedance.android.live.core.privacy.av.api.i("av_status_change", "onCameraAvailable", 0, "", "", "", "", MapsKt.mapOf(new Pair[]{new Pair("cameraId", String.valueOf(r15)), new Pair("isCapturePermissionOnUse", String.valueOf(this.a.b))})));
        return;
    L12:
        return;
    }

    @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
    public final void onCameraUnavailable(String r14) {
        Intrinsics.checkNotNullParameter(r14, "cameraId");
        c r1 = this.a;
        if (r1.c == false) goto L6;
        r1.i.a("onCameraStatusChanged; onCameraUnavailable cant change when releasing");
        return;
    L6:
        c.f(r1, r14, true);
        this.a.i.a("onCameraStatusChanged; isPermissionOnUse=" + this.a.b + ", cameraId=" + r14);
        super.onCameraUnavailable(r14);
        if (this.a.h.h() == false) goto L14;
        List<String> r2 = this.a.h.d();
        if (r2 != null) goto L11;
        return;
    L11:
        if (r2.contains("av_status_change") != true) goto L16;
        this.a.i.c(new com.bytedance.android.live.core.privacy.av.api.i("av_status_change", "onCameraUnavailable", 0, "", "", "", "", MapsKt.mapOf(new Pair[]{new Pair("cameraId", String.valueOf(r14)), new Pair("isCapturePermissionOnUse", String.valueOf(this.a.b))})));
        return;
    L16:
        return;
    }
}
