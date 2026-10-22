package com.bytedance.android.livesdk.interactivity.publicscreen.preview;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements e {
    public final ZoomableControllerImp a;

    public b(ZoomableControllerImp r2) {
        Intrinsics.checkNotNullParameter(r2, "zc");
        this.a = r2;
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.preview.e
    public final float nextFactor(float r5) {
        ZoomableControllerImp r0 = this.a;
        float r1 = r0.d;
        r0.getClass();
        if (r5 < ((r1 + 1.0f) / 2)) goto L7;
        return 1.0f;
    L7:
        return r1;
    }
}
