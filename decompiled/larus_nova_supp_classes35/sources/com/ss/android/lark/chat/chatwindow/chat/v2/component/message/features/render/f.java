package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render;

import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f implements rcc.d {
    public final /* synthetic */ MessageListRendererFeature a;

    public f(MessageListRendererFeature r1) {
        this.a = r1;
    }

    public final void a(int r1, int r2, int r3) {
        if (r2 != 0) goto L5;
        if (r3 != 0) goto L5;
        return;
    L5:
        if (r1 != r2) goto L8;
        return;
    L8:
        if (FeatureGatingModule.getFeatureGatingService().isEnable("im.messenger.fold.support") == false) goto L15;
        Log.i("MessageListRendererFeature", "onSizeChanged refillData");
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a r4 = this.a.G();
        if (r4 == null) goto L14;
        r4.b7();
        return;
    L14:
        return;
    }
}
