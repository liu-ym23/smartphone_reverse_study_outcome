package com.bytedance.android.livesdk.gift.multiplayer;

import com.bytedance.android.livesdk.gift.effect.model.EffectMessage;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.o;
import com.bytedance.android.livesdk.gift.platform.business.effect.utils.VideoGiftLinkMonitor;
import com.bytedance.android.livesdk.gift.platform.business.effect.widget.VideoGiftWidgetV2;
import com.bytedance.android.livesdk.gift.platform.business.tray2.manager.VideoGiftMsgManagerV2;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d extends o {
    public final /* synthetic */ MultiPlayerWidget a;
    public final /* synthetic */ EffectMessage b;

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.o
    public final String d() {
        return "MultiPlayerWidget.getResourceResult";
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.o, com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
    public final void a(long r7) {
        MultiPlayerWidget r0 = this.a;
        String r1 = String.valueOf(this.b.l);
        String r2 = String.valueOf(this.b.a);
        String r3 = String.valueOf(this.b.b);
        String r4 = this.b.n;
        int r5 = MultiPlayerWidget.r;
        r0.getClass();
        MultiPlayerWidget.Cq("特效资源下载任务被取消", r1, r2, r3, r4);
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c("MultiPlayerWidget", "loadResource cancel, try consume next resourceId " + r7);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.o, com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
    public final void onFailed(Throwable r7) {
        Intrinsics.checkNotNullParameter(r7, "t");
        MultiPlayerWidget r0 = this.a;
        String r1 = String.valueOf(this.b.l);
        String r2 = String.valueOf(this.b.a);
        String r3 = String.valueOf(this.b.b);
        String r4 = this.b.n;
        int r5 = MultiPlayerWidget.r;
        r0.getClass();
        MultiPlayerWidget.Cq("获取特效资源本地路径失败", r1, r2, r3, r4);
        VideoGiftMsgManagerV2 r6 = VideoGiftWidgetV2.S;
        VideoGiftWidgetV2.a.a().c();
        EffectMessage r8 = this.b;
        r8.d = BuildConfig.FLAVOR;
        MultiPlayerWidget.wq(this.a, r8);
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c("MultiPlayerWidget", "loadResource failed " + r7.getMessage() + " add to specialmsg list again");
    }

    public d(MultiPlayerWidget r1, EffectMessage r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.o, com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
    public final void c(long r8, String r10) {
        Intrinsics.checkNotNullParameter(r10, "path");
        super.c(r8, r10);
        EffectMessage r9 = this.b;
        r9.d = r10;
        VideoGiftLinkMonitor.a(VideoGiftLinkMonitor.Event.load_resource_success, r9.a, r9.l, r9.b);
        MultiPlayerWidget.wq(this.a, this.b);
    }
}
