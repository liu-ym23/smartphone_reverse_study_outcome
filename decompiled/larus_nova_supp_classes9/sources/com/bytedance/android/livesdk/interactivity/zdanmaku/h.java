package com.bytedance.android.livesdk.interactivity.zdanmaku;

import com.bytedance.android.livesdk.interactivity.zdanmaku.attributes.DanmakuType;
import com.bytedance.live.zdanmaku.data.Danmaku;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class h extends Danmaku {
    public float d;

    public final tc2.e g() {
        nf6.a r8 = new tc2.e(0, 0, 0, 7);
        nf6.a r0 = b().e(tc2.e.class);
        if (r0 == null) goto L7;
        r8 = r0;
    L7:
        return (tc2.e) r8;
    }

    public final DanmakuType getType() {
        nf6.a r0 = DanmakuType.UnDefined;
        nf6.a r1 = b().e(DanmakuType.class);
        if (r1 == null) goto L7;
        r0 = r1;
    L7:
        return (DanmakuType) r0;
    }

    public final tc2.h h() {
        nf6.a r0 = new tc2.h(0);
        nf6.a r1 = b().e(tc2.h.class);
        if (r1 == null) goto L7;
        r0 = r1;
    L7:
        return (tc2.h) r0;
    }

    public h() {
        this.d = 1.0f;
    }
}
