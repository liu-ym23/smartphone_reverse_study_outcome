package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.android.livesdk.gift.platform.business.normal.model.NormalGiftMessage;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e3 extends com.bytedance.android.livesdk.gift.platform.business.effect.assets.o {
    public final /* synthetic */ g3 a;
    public final /* synthetic */ NormalGiftMessage b;
    public final /* synthetic */ j3 c;
    public final /* synthetic */ long d;

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.o
    public final String d() {
        return "SendTogetherService.getResourceResult";
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.o, com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
    public final void a(long r3) {
        g3 r0 = this.a;
        NormalGiftMessage r1 = this.b;
        r0.getClass();
        g3.a("特效资源下载任务被取消", r1, r3);
        NormalGiftMessage r4 = this.b;
        int r5 = r4.H;
        g3 r2 = this.a;
        if (r5 >= r2.b) goto L5;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.a(r2.a, "download cancel " + this.b + ", retry");
        NormalGiftMessage r6 = this.b;
        r6.H = r6.H + 1;
        this.a.c(r6, this.c);
        return;
    L5:
        r4.setTimeStampMap(7, com.bytedance.live.kmp.util.e.b());
        this.c.onFailed();
        ConcurrentHashMap<String, Map<String, Long>> r7 = v12.e.a;
        v12.e.d(this.b);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.o, com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
    public final void b(boolean r4) {
        NormalGiftMessage r0 = this.b;
        if (r0.B != (-1)) goto L8;
        if (r4 == false) goto L6;
        r0.B = 1;
        return;
    L6:
        r0.B = 0;
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.o, com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
    public final void onFailed(Throwable r4) {
        Intrinsics.checkNotNullParameter(r4, "t");
        g3 r5 = this.a;
        NormalGiftMessage r0 = this.b;
        long r1 = this.d;
        r5.getClass();
        g3.a("获取特效资源本地路径失败", r0, r1);
        NormalGiftMessage r6 = this.b;
        int r2 = r6.H;
        g3 r3 = this.a;
        if (r2 >= r3.b) goto L5;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.a(r3.a, "download cancel " + this.b + ", retry");
        NormalGiftMessage r7 = this.b;
        r7.H = r7.H + 1;
        this.a.c(r7, this.c);
        return;
    L5:
        r6.setTimeStampMap(7, com.bytedance.live.kmp.util.e.b());
        this.c.onFailed();
        ConcurrentHashMap<String, Map<String, Long>> r8 = v12.e.a;
        v12.e.d(this.b);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.o, com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
    public final void c(long r5, String r7) {
        Intrinsics.checkNotNullParameter(r7, "path");
        super.c(r5, r7);
        this.b.O = r7;
        com.bytedance.android.live.core.resources.e r0 = this.a.c.G1(r5);
        if (r0 == null) goto L5;
        this.b.N = r0.getResourceType();
        this.b.A.put(Long.valueOf(r5), new iy1.a(r7, this.b.N));
    L5:
        this.b.setTimeStampMap(7, com.bytedance.live.kmp.util.e.b());
        this.c.onSuccess();
        com.bytedance.android.livesdk.gift.platform.core.utils.c.a(this.a.a, "前置拦截特效下载成功，资源ID " + r5);
    }

    public e3(g3 r1, NormalGiftMessage r2, j3 r3, long r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
