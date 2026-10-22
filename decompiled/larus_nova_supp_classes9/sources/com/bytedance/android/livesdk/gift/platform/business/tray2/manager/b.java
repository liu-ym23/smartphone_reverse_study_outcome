package com.bytedance.android.livesdk.gift.platform.business.tray2.manager;

import com.bytedance.android.livesdk.gift.effect.model.EffectMessage;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.o;
import com.bytedance.android.livesdk.gift.platform.business.effect.utils.VideoGiftLinkMonitor;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b extends o {
    public final /* synthetic */ d a;
    public final /* synthetic */ EffectMessage b;

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.o
    public final String d() {
        return "EffectMsgManager.getResourceResult";
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.o, com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
    public final void a(long r3) {
        d r4 = this.a;
        EffectMessage r5 = this.b;
        r4.getClass();
        d.m("特效资源下载任务被取消", r5);
        EffectMessage r6 = this.b;
        if (r6.Q >= 3) goto L5;
        boolean r7 = true;
    L6:
        if (r7 == false) goto L8;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.a(this.a.a, "download cancel " + this.b + ", retry");
        EffectMessage r8 = this.b;
        r8.Q = r8.Q + 1;
        this.a.n(r8);
    L9:
        ConcurrentHashMap<String, Map<String, Long>> r9 = v12.e.a;
        v12.e.c(this.b);
        return;
    L8:
        r6.a(7, com.bytedance.live.kmp.util.e.b());
        goto L9
    L5:
        r7 = false;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.o, com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
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

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.o, com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
    public final void onFailed(Throwable r4) {
        Intrinsics.checkNotNullParameter(r4, "t");
        d r5 = this.a;
        EffectMessage r0 = this.b;
        r5.getClass();
        d.m("获取特效资源本地路径失败", r0);
        EffectMessage r6 = this.b;
        if (r6.Q >= 3) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.a(this.a.a, "download fail " + this.b + ", retry");
        EffectMessage r7 = this.b;
        r7.Q = r7.Q + 1;
        this.a.n(r7);
    L9:
        ConcurrentHashMap<String, Map<String, Long>> r8 = v12.e.a;
        v12.e.c(this.b);
        return;
    L8:
        r6.a(7, com.bytedance.live.kmp.util.e.b());
        goto L9
    L5:
        r1 = false;
        goto L6
    }

    public b(d r1, EffectMessage r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.o, com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
    public final void c(long r10, String r13) {
        Intrinsics.checkNotNullParameter(r13, "path");
        super.c(r10, r13);
        this.b.d = r13;
        com.bytedance.android.live.core.resources.e r0 = this.a.n.G1(r10);
        if (r0 == null) goto L5;
        EffectMessage r1 = this.b;
        r1.f = r0.getResourceType();
        this.b.e.put(Long.valueOf(r10), new iy1.a(r13, this.b.f));
    L5:
        VideoGiftLinkMonitor.Event r2 = VideoGiftLinkMonitor.Event.load_resource_success;
        EffectMessage r11 = this.b;
        VideoGiftLinkMonitor.a(r2, r11.a, r11.l, r11.b);
        this.b.a(7, com.bytedance.live.kmp.util.e.b());
        d r14 = this.a;
        r14.o(this.b, r14.i);
    }
}
