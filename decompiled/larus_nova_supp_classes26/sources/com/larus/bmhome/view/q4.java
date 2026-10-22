package com.larus.bmhome.view;

import android.graphics.ColorFilter;
import android.view.View;
import com.larus.chat.common.databinding.LarusLayoutTextMessageActionButtonBinding;
import com.larus.platform.api.IFlowChatThemeConfigProvider;
import com.larus.platform.model.apptheme.AdaptThemeFeatureKey;
import com.larus.utils.logger.FLogger;
import com.lynx.lottieadapter.LottieAdapterView;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import rs8.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class q4 implements View.OnAttachStateChangeListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ LarusLayoutTextMessageActionButtonBinding b;
    public final /* synthetic */ n c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ TextAnswerSingleActionButton e;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r1) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r4) {
        this.a.removeOnAttachStateChangeListener(this);
        FLogger.a.i("TextAnswerSingleActionButton", "play lottie animation");
        this.b.c.setAnimation(this.c.e);
        if (this.d == false) goto L5;
        this.e.setLottieValueCallbackForSubscriber(this.b.c);
    L5:
        ColorFilter r5 = this.e.b(this.d);
        if (r5 == null) goto L8;
        this.b.c.setColorFilter(r5);
    L8:
        IFlowChatThemeConfigProvider r6 = (IFlowChatThemeConfigProvider) ServiceManager.get().getService(IFlowChatThemeConfigProvider.class);
        if (r6 == null) goto L11;
        r6.e(new p4(this.e, this.b), AdaptThemeFeatureKey.MESSAGE_ANSWER_ACTION_LOTTIE);
    L11:
        this.b.c.playAnimation();
    }

    public q4(LottieAdapterView r1, LarusLayoutTextMessageActionButtonBinding r2, n r3, boolean r4, TextAnswerSingleActionButton r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
