package a30;

import com.bytedance.android.live.browser.jsbridge.base.SetEffectComposerResultModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h implements com.bytedance.android.livesdk.revenue.service.effect.g {
    public final /* synthetic */ e a;
    public final /* synthetic */ SetEffectComposerResultModel b;

    public final void onResult(int r3) {
        SetEffectComposerResultModel.b r0 = this.b.getData();
        if (r0 == null) goto L5;
        r0.setResult(Integer.valueOf(r3));
    L5:
        jy0.b.d("SetEffectComposerMethod", "removeComposer success, result = " + r3);
        this.a.finishWithResult(this.b);
    }

    public h(e r1, SetEffectComposerResultModel r2) {
        this.a = r1;
        this.b = r2;
    }
}
