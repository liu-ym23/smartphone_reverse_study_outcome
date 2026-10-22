package com.bytedance.android.live.revlink.impl.multianchor.transfer;

import com.bytedance.android.live.link.player.DeviceType;
import com.bytedance.android.livesdkapi.depend.model.live.ILiveMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f {
    public final q31.b a;
    public final q31.a b;
    public final q31.d c;
    public final q31.c d;

    public f() {
        this.a = new q31.b();
        this.b = new q31.a();
        this.c = new q31.d();
        this.d = new q31.c();
    }

    public final e a(ILiveMode r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "liveMode");
        DeviceType r4 = rc0.b.a();
        int r0 = m31.a.a;
        if (m31.a.a(m31.d.a(r2), r4) == true) goto L6;
        return null;
    L6:
        if (r4 != DeviceType.NORMAL_MOBILE) goto L9;
        return this.a;
    L9:
        if (r4 != DeviceType.FOLD_FULL) goto L12;
        return this.b;
    L12:
        if (r4 != DeviceType.PAD_V) goto L15;
        return this.c;
    L15:
        if (r4 == DeviceType.PAD_H) goto L17;
        return null;
    L17:
        return this.d;
    }
}
