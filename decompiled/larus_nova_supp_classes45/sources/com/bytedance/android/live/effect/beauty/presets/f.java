package com.bytedance.android.live.effect.beauty.presets;

import android.view.View;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.uikit.recyclerview.LoadingStatusView;
import com.bytedance.common.utility.concurrent.TTExecutors;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f implements View.OnClickListener {
    public final /* synthetic */ LiveBeautyPresetsFragment a;

    public f(LiveBeautyPresetsFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        LoadingStatusView r5 = this.a.k;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("loadingView");
    L5:
        r5.showLoading();
        List<String> r6 = LiveEffectContext.h;
        LiveBeautyPresetsHelper r7 = LiveEffectContext.a.a(this.a.d).b().e();
        LiveBeautyPresetsFragment.b r0 = this.a.B;
        r7.getClass();
        TTExecutors.getNormalExecutor().submit(new p(r7, r0));
    }
}
