package com.bytedance.android.livesdk.gift.platform.core.utils.recorder;

import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends BaseRecorder {
    public final int f;

    public a() {
        super("BGiftRecorder");
        this.f = ((Number) com.bytedance.android.livesdk.gift.platform.core.h.z.getValue(null, com.bytedance.android.livesdk.gift.platform.core.h.a[24])).intValue() * IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.utils.recorder.BaseRecorder
    public final boolean j(h r5, long r6) {
        Intrinsics.checkNotNullParameter(r5, "record");
        if (this.b == false) goto L6;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c(this.a, "flushTimeMs - record.startConsumeTms = " + (r6 - r5.g));
    L6:
        if (super.j(r5, r6) == true) goto L8;
    L10:
        return false;
    L8:
        if ((r6 - r5.g) <= this.f) goto L10;
        return true;
    }
}
