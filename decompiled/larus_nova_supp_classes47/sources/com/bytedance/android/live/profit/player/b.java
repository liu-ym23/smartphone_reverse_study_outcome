package com.bytedance.android.live.profit.player;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener;
import com.bytedance.android.livesdkapi.depend.live.player.ITextureViewPlayerController;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements IPlayerActionListener {
    public final /* synthetic */ ITextureViewPlayerController a;

    public final /* synthetic */ void onFirstFrame() {
        IPlayerActionListener.-CC.$default$onFirstFrame(this);
    }

    public final /* synthetic */ void onReportPlayMetrics(Map r1) {
        IPlayerActionListener.-CC.$default$onReportPlayMetrics(this, r1);
    }

    public final void onEnd() {
        ALogger.i("EnterEffectProfilePreview", "onEnd");
    }

    public final void onStart() {
        ALogger.i("EnterEffectProfilePreview", "onStart");
    }

    public final void onStop() {
        ALogger.i("EnterEffectProfilePreview", "onStop");
    }

    public b(ITextureViewPlayerController r1) {
        this.a = r1;
    }

    public final void onFileLoaded(int r1, int r2) {
        ALogger.i("EnterEffectProfilePreview", "file loaded");
    }

    public final void updateTextEffectPosition(float r1, float r2, float r3, float r4) {
        ALogger.i("EnterEffectProfilePreview", "update text effect position");
        View r5 = this.a.getAlphaView();
        if (r5 == null) goto L8;
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
        if (r6 == null) goto L9;
        r6.width = (int) r1;
        r6.height = (int) r2;
        r5.setLayoutParams(r6);
        return;
    L9:
        return;
    }
}
