package com.bytedance.android.live.liveinteract.digitavatar.videoavatar;

import android.graphics.Bitmap;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import com.bytedance.android.livesdk.utils.e0;
import com.bytedance.android.livesdk.utils.u1;
import kotlin.jvm.internal.Intrinsics;
import uf2.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g implements IHostFrescoHelper.GetBitmapCallBack {
    public final /* synthetic */ VideoDigitAvatarRecognitionDialog a;

    public g(VideoDigitAvatarRecognitionDialog r1) {
        this.a = r1;
    }

    public final void fail(IHostFrescoHelper.BitmapDataSource r3) {
        if (r3 == null) goto L4;
        Throwable r0 = r3.error;
    L5:
        if (r0 == null) goto L8;
        ALogger.e("KtvDigitAvatar", "生成头像高斯模糊失败", r3.error);
        return;
    L8:
        return;
    L4:
        r0 = null;
        goto L5
    }

    public final void onNewResultImpl(Bitmap r9) {
        if (r9 != null) goto L4;
        return;
    L4:
        com.bytedance.android.live.pushstream.d r0 = this.a.N;
        if (r0 == null) goto L28;
        d0 r1 = r0.getLiveCore();
        if (r1 == null) goto L29;
        int r2 = u1.a;
        Intrinsics.checkNotNullParameter(r9, "bitmap");
        int r3 = r9.getWidth();
        int r4 = r9.getHeight();
        if (r3 < 100) goto L18;
        if (r4 < 100) goto L18;
        if (r3 < 200) goto L17;
        if (r4 < 200) goto L17;
        float r5 = 0.1f;
    L19:
        int r6 = Math.round(r3 * r5);
        int r7 = Math.round(r4 * r5);
        Bitmap r10 = Bitmap.createScaledBitmap(r9, r6, r7, false);
        float r8 = r6;
        float r11 = r7;
        if (Math.abs((r8 / r11) - 5) <= 0.2f) goto L26;
        int r12 = (int) (r8 / 3.0f);
        if (r12 <= r7) goto L24;
        int r13 = (int) (r11 * 3.0f);
        int r14 = r7;
    L25:
        Bitmap r15 = Bitmap.createBitmap(r10, (r6 - r13) >> 1, (r7 - r14) >> 1, r13, r14);
        r10.recycle();
        r10 = r15;
        r6 = r13;
        r7 = r14;
        goto L26
    L24:
        r14 = r12;
        r13 = r6;
    L26:
        e0.a(r10, Bitmap.createBitmap(r6, r7, Bitmap.Config.ARGB_8888), 5);
        r10.recycle();
        r1.M();
        return;
    L17:
        r5 = 0.3f;
    L18:
        r5 = 0.6f;
        goto L19
    L29:
        return;
    }
}
