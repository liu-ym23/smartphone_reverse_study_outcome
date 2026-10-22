package com.bytedance.android.live.liveinteract.plantform.commonwindow.wm;

import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.linkbase.api.LoadDurationItemId;
import com.bytedance.android.livesdk.config.zb0;
import com.bytedance.android.livesdk.utils.d5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class u implements tf0.m {
    public boolean a;
    public long b;
    public long c;
    public long d;
    public long e;
    public long f;

    public static final class a {
    }

    static {
    }

    public u() {
    }

    @Override // tf0.m
    public final void a(tf0.f r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        long r0 = System.currentTimeMillis();
        if (d5.c(r6.c()) > r0) goto L8;
        r0 = d5.c(r6.c());
    L8:
        String r7 = r6.a();
        if (Intrinsics.areEqual(r7, LoadDurationItemId.JSB_RECEIVE_LAYOUT_INFO.getValue()) == false) goto L12;
        this.f = r0;
        return;
    L12:
        if (Intrinsics.areEqual(r7, LoadDurationItemId.RENDER_LYNX_SWITCH_LAYOUT_END.getValue()) == false) goto L16;
        b(r0);
        return;
    }

    public final void b(long r14) {
        long r0 = this.d;
        if (r0 > 0) goto L5;
        return;
    L5:
        long r4 = this.b;
        if (r4 <= 0) goto L8;
        long r6 = this.c - r4;
        long r1 = r0 - r4;
        long r8 = this.e - r4;
        long r10 = this.f - r4;
        long r15 = r14 - r4;
    L10:
        if (((Long) zb0.a.getValue()).longValue() <= 0) goto L12;
        f2.c("切换接口回包到达：" + r6 + " \n到达switcher：" + r1 + " \n开始发送LayoutInfo：" + r8 + " \nLynx收到LayoutInfo：" + r10 + " \n 布局切换成功:" + r15, 0);
    L12:
        this.a = true;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        return;
    L8:
        r8 = this.e - r0;
        r10 = this.f - r0;
        r15 = r14 - r0;
        r1 = 0;
        r6 = 0;
        goto L10
    }
}
