package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.ss.android.ugc.effectmanager.effect.model.Effect;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class u8 implements com.bytedance.android.live.effect.api.k.e {
    public final /* synthetic */ OpenLiveEffectPanelMethod.AnonymousClass1 a;

    @Override // com.bytedance.android.live.effect.api.k.e
    public final void onFetchFailed() {
        this.a.invoke(true);
    }

    public u8(OpenLiveEffectPanelMethod.AnonymousClass1 r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.effect.api.k.e
    public final void onFetchSuccess(List<Effect> r2) {
        Intrinsics.checkNotNullParameter(r2, "effectList");
        this.a.invoke(true);
    }
}
