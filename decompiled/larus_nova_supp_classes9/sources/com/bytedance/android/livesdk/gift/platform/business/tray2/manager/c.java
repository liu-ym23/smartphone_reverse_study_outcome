package com.bytedance.android.livesdk.gift.platform.business.tray2.manager;

import com.bytedance.android.livesdk.gift.effect.model.EffectMessage;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.k;
import com.bytedance.android.livesdk.gift.platform.business.effect.utils.VideoGiftLinkMonitor;
import com.bytedance.bdlocation.BuildConfig;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements k.b {
    public final /* synthetic */ d a;
    public final /* synthetic */ EffectMessage b;
    public final /* synthetic */ com.bytedance.android.live.core.resources.e c;

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.k.b
    public final void a(List<k.a> r4) {
        Intrinsics.checkNotNullParameter(r4, "assetsResult");
        d r5 = this.a;
        EffectMessage r0 = this.b;
        r5.getClass();
        d.m("特效资源下载任务被取消", r0);
        this.b.a(7, com.bytedance.live.kmp.util.e.b());
        d r6 = this.a;
        r6.o(this.b, r6.k);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.k.b
    public final void b(boolean r3) {
        if (r3 == false) goto L7;
        EffectMessage r4 = this.b;
        if (r4.I != (-1)) goto L11;
        r4.I = 1;
        return;
    L11:
        return;
    L7:
        EffectMessage r5 = this.b;
        if (r5.I != (-1)) goto L13;
        r5.I = 0;
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.k.b
    public final void onFailed(Throwable r4) {
        d r5 = this.a;
        EffectMessage r0 = this.b;
        r5.getClass();
        d.m("获取特效资源本地路径失败", r0);
        EffectMessage r6 = this.b;
        r6.d = BuildConfig.FLAVOR;
        r6.a(7, com.bytedance.live.kmp.util.e.b());
        d r7 = this.a;
        r7.o(this.b, r7.j);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.k.b
    public final void onResult(List<k.a> r13) {
        Intrinsics.checkNotNullParameter(r13, "assetsResult");
        EffectMessage r0 = this.b;
        if (r0.e != null) goto L5;
        r0.e = new LinkedHashMap();
    L5:
        Iterator<k.a> r14 = r13.iterator();
    L7:
        if (r14.hasNext() == false) goto L12;
        k.a r1 = r14.next();
        if (r1.a != this.c.getId()) goto L11;
        EffectMessage r2 = this.b;
        r2.d = r1.b;
        r2.f = r1.d;
    L11:
        this.b.e.put(Long.valueOf(r1.a), new iy1.a(r1.b, r1.d));
        goto L7
    L12:
        VideoGiftLinkMonitor.Event r5 = VideoGiftLinkMonitor.Event.load_resource_success;
        EffectMessage r15 = this.b;
        VideoGiftLinkMonitor.a(r5, r15.a, r15.l, r15.b);
        this.b.a(7, com.bytedance.live.kmp.util.e.b());
        d r16 = this.a;
        r16.o(this.b, r16.i);
    }

    public c(d r1, EffectMessage r2, com.bytedance.android.live.core.resources.e r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
