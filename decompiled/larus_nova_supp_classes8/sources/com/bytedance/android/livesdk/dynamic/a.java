package com.bytedance.android.livesdk.dynamic;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.livehostapi.business.depend.locallife.ILiveLocalLifeService;
import com.bytedance.android.livehostapi.business.depend.locallife.ShortTermState;
import com.bytedance.android.livesdk.gameguess.widget.GameGuessPredictorWidget;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class a implements IDynamicExternalService {
    public a() {
    }

    @Override // com.bytedance.android.livesdk.dynamic.IDynamicExternalService
    public Class<? extends Widget> getGameGuessPredictorWidget() {
        return GameGuessPredictorWidget.class;
    }

    @Override // com.bytedance.android.livesdk.dynamic.IDynamicExternalService
    public void liveLocalLifeSetShortTermState(FragmentActivity r3, ShortTermState r4) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        Intrinsics.checkNotNullParameter(r4, "state");
        ILiveService r0 = TTLiveService.getLiveService();
        if (r0 == null) goto L8;
        ILiveLocalLifeService r1 = (ILiveLocalLifeService) r0.liveLocalLifeService(ILiveLocalLifeService.class);
        if (r1 == null) goto L9;
        r1.setShortTermState(r3, r4);
        return;
    L9:
        return;
    }
}
