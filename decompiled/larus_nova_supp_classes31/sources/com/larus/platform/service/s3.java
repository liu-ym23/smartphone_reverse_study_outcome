package com.larus.platform.service;

import android.graphics.Bitmap;
import android.os.Build;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.larus.platform.api.d4;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class s3 implements d4 {
    public static final s3 a = null;
    public static final Lazy b = null;

    public s3() {
    }

    static {
        a = new s3();
        b = LazyKt.lazy(new r3());
    }

    @Override // com.larus.platform.api.d4
    public final boolean a(Bitmap r2, int r3, PolarisFileOutputStreamWrapper r4, Integer r5) {
        Intrinsics.checkNotNullParameter(r2, "bitmap");
        Intrinsics.checkNotNullParameter(r4, "outputStream");
        d4 r0 = (d4) b.getValue();
        if (r0 == null) goto L7;
        return r0.a(r2, r3, r4, r5);
    L7:
        if (Build.VERSION.SDK_INT < 30) goto L9;
        Bitmap.CompressFormat r6 = Bitmap.CompressFormat.WEBP_LOSSY;
    L11:
        return r2.compress(r6, r3, r4);
    L9:
        r6 = Bitmap.CompressFormat.WEBP;
        goto L11
    }
}
