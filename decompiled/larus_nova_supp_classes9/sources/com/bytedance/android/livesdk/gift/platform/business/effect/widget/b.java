package com.bytedance.android.livesdk.gift.platform.business.effect.widget;

import com.bytedance.android.livesdk.gift.effect.model.EffectMessage;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.o;
import com.bytedance.android.livesdk.gift.platform.business.effect.utils.VideoGiftLinkMonitor;
import com.bytedance.android.livesdk.gift.platform.core.utils.h;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b extends o {
    public final /* synthetic */ BaseVideoGiftWidgetOrigin a;
    public final /* synthetic */ EffectMessage b;

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.o
    public final String d() {
        return "BaseVideoGiftWidgetOrigin.downloadAssets";
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.o, com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
    public final void a(long r6) {
        h.x("特效资源下载任务被取消", String.valueOf(this.b.l), String.valueOf(this.b.a), String.valueOf(this.b.b), this.b.n);
        this.a.Nq();
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c(this.a.b, "loadResource cancel, try consume next resourceId " + r6);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.o, com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
    public final void onFailed(Throwable r6) {
        Intrinsics.checkNotNullParameter(r6, "t");
        this.a.Pq(r6);
        h.x("获取特效资源本地路径失败", String.valueOf(this.b.l), String.valueOf(this.b.a), String.valueOf(this.b.b), this.b.n);
        EffectMessage r0 = this.b;
        r0.d = BuildConfig.FLAVOR;
        BaseVideoGiftWidgetOrigin.hr(this.a, r0);
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c(this.a.b, "loadResource failed " + r6.getMessage() + " add to specialmsg list again");
    }

    public b(BaseVideoGiftWidgetOrigin r1, EffectMessage r2) {
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
        BaseVideoGiftWidgetOrigin.hr(this.a, this.b);
    }
}
