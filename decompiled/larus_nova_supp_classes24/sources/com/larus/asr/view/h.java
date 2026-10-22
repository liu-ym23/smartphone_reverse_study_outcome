package com.larus.asr.view;

import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import com.larus.asr.api.databinding.LarusWidgetSpeakerBinding;
import com.larus.utils.CubicBezierInterpolator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class h implements Runnable {
    public final /* synthetic */ ChatSpeaker a;

    public /* synthetic */ h(ChatSpeaker r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ChatSpeaker r0 = this.a;
        int r1 = ChatSpeaker.T;
        LarusWidgetSpeakerBinding r2 = r0.getBinding();
        if (r2 == null) goto L10;
        FrameLayout r3 = r2.b;
        if (r3 == null) goto L11;
        ViewPropertyAnimator r4 = r3.animate();
        if (r4 == null) goto L12;
        r4.setDuration(120);
        r4.alpha(1.0f);
        r4.setInterpolator(new CubicBezierInterpolator(0.0f, 0.0f, 0.58f));
        r4.start();
        return;
    L12:
        return;
    L11:
        return;
    }
}
