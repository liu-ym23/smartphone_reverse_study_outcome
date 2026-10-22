package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.android.livesdk.gift.platform.business.normal.model.NormalGiftMessage;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f3 implements com.bytedance.android.livesdk.gift.platform.business.effect.assets.k.b {
    public final /* synthetic */ g3 a;
    public final /* synthetic */ NormalGiftMessage b;
    public final /* synthetic */ com.bytedance.android.live.core.resources.e c;
    public final /* synthetic */ j3 d;
    public final /* synthetic */ List e;

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.k.b
    public final void a(List<com.bytedance.android.livesdk.gift.platform.business.effect.assets.k.a> r4) {
        Intrinsics.checkNotNullParameter(r4, "assetsResult");
        g3 r5 = this.a;
        NormalGiftMessage r0 = this.b;
        long r1 = this.c.getId();
        r5.getClass();
        g3.a("特效资源下载任务被取消", r0, r1);
        int r6 = this.b.H;
        g3 r2 = this.a;
        if (r6 >= r2.b) goto L5;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.a(r2.a, "download cancel " + this.b + ", retry");
        NormalGiftMessage r7 = this.b;
        r7.H = r7.H + 1;
        this.a.c(r7, this.d);
        return;
    L5:
        this.d.onFailed();
        ConcurrentHashMap<String, Map<String, Long>> r8 = v12.e.a;
        v12.e.d(this.b);
        this.b.setTimeStampMap(7, com.bytedance.live.kmp.util.e.b());
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.k.b
    public final void b(boolean r4) {
        NormalGiftMessage r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.B != (-1)) goto L11;
        if (r4 == false) goto L8;
        r0.B = 1;
        return;
    L8:
        r0.B = 0;
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.k.b
    public final void onFailed(Throwable r4) {
        g3 r5 = this.a;
        NormalGiftMessage r0 = this.b;
        long r1 = this.c.getId();
        r5.getClass();
        g3.a("获取特效资源本地路径失败", r0, r1);
        NormalGiftMessage r6 = this.b;
        int r2 = r6.H;
        g3 r3 = this.a;
        if (r2 >= r3.b) goto L5;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.a(r3.a, "download cancel " + this.b + ", retry");
        NormalGiftMessage r7 = this.b;
        r7.H = r7.H + 1;
        this.a.c(r7, this.d);
        return;
    L5:
        r6.setTimeStampMap(7, com.bytedance.live.kmp.util.e.b());
        this.d.onFailed();
        ConcurrentHashMap<String, Map<String, Long>> r8 = v12.e.a;
        v12.e.d(this.b);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.k.b
    public final void onResult(List<com.bytedance.android.livesdk.gift.platform.business.effect.assets.k.a> r7) {
        Intrinsics.checkNotNullParameter(r7, "assetsResult");
        NormalGiftMessage r0 = this.b;
        if (r0.A != null) goto L5;
        r0.A = new LinkedHashMap();
    L5:
        Iterator<com.bytedance.android.livesdk.gift.platform.business.effect.assets.k.a> r8 = r7.iterator();
    L7:
        if (r8.hasNext() == false) goto L12;
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.k.a r1 = r8.next();
        if (r1.a != this.c.getId()) goto L11;
        NormalGiftMessage r2 = this.b;
        r2.O = r1.b;
        r2.N = r1.d;
    L11:
        this.b.A.put(Long.valueOf(r1.a), new iy1.a(r1.b, r1.d));
        goto L7
    L12:
        this.b.setTimeStampMap(7, com.bytedance.live.kmp.util.e.b());
        this.d.onSuccess();
        com.bytedance.android.livesdk.gift.platform.core.utils.c.a(this.a.a, "资源下载完成，" + this.e);
    }

    public f3(g3 r1, NormalGiftMessage r2, com.bytedance.android.live.core.resources.e r3, j3 r4, List r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
