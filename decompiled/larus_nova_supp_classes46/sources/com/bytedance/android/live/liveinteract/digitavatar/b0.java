package com.bytedance.android.live.liveinteract.digitavatar;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b0 implements y.a {
    public final /* synthetic */ a0 a;

    public b0(a0 r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.digitavatar.y.a
    public final void a(Sticker r6) {
        Intrinsics.checkNotNullParameter(r6, "sticker");
        ALogger.i("KtvDigitAvatar", "预下载recognition识别道具success，耗时 " + (System.currentTimeMillis() - this.a.a) + "ms");
        a0.b r0 = this.a.d;
        if (r0 == null) goto L6;
        r0.c(r6);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.digitavatar.y.a
    public final void onError(Exception r6) {
        Intrinsics.checkNotNullParameter(r6, "e");
        ALogger.w("KtvDigitAvatar", "预下载recognition识别道具fail，耗时 " + (System.currentTimeMillis() - this.a.a) + "ms", r6);
        a0.b r0 = this.a.d;
        if (r0 == null) goto L6;
        r0.b(r6);
        return;
    }
}
