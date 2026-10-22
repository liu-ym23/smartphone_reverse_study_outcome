package com.bytedance.android.live.liveinteract.voicechat.radio;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l extends b7.a {
    public final /* synthetic */ String a;

    public l(String r1) {
        this.a = r1;
    }

    public final void onLoadSuccess(View r2) {
        super.onLoadSuccess(r2);
        ALogger.i("RadioStageContainerWidget", "HybridCard load success:" + this.a);
    }

    public final void onInnerFallback(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "errorMessage");
        super.onInnerFallback(r2, r3);
        ALogger.e("RadioStageContainerWidget", "HybridCard onInnerFallback errorMessage=" + r3 + ", url:" + this.a);
    }

    public final void onLoadFail(View r1, String r2, String r3) {
        super.onLoadFail(r1, r2, r3);
        ALogger.e("RadioStageContainerWidget", "HybridCard load fail reason=" + r3 + ", url:" + this.a);
    }
}
