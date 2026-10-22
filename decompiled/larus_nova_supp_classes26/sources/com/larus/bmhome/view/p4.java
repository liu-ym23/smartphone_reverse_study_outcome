package com.larus.bmhome.view;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import com.larus.chat.common.databinding.LarusLayoutTextMessageActionButtonBinding;
import com.larus.platform.api.IFlowThemeConfigProvider;
import com.larus.platform.api.ThemeColorKey;
import com.larus.platform.api.ThemeConfigScene;
import com.larus.platform.model.apptheme.AdaptThemeFeatureKey;
import com.lynx.lottieadapter.LottieAdapterView;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class p4 implements Function0<Unit> {
    public final /* synthetic */ TextAnswerSingleActionButton a;
    public final /* synthetic */ LarusLayoutTextMessageActionButtonBinding b;

    public p4(TextAnswerSingleActionButton r1, LarusLayoutTextMessageActionButtonBinding r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke() {
        IFlowThemeConfigProvider r1 = (IFlowThemeConfigProvider) ServiceManager.get().getService(IFlowThemeConfigProvider.class);
        if (r1 == null) goto L8;
        ThemeColorKey r3 = ThemeColorKey.MESSAGE_ANSWER_ACTION_COLOR;
        ThemeConfigScene r4 = ThemeConfigScene.CHAT;
        AdaptThemeFeatureKey r5 = AdaptThemeFeatureKey.MESSAGE_ANSWER_ACTION_LOTTIE;
        boolean r0 = v19.h.a;
        Integer r2 = r1.f(null, r3, r4, r5, Boolean.valueOf(v19.h.b(this.a.getContext())));
        if (r2 == null) goto L8;
        TextAnswerSingleActionButton r6 = this.a;
        LarusLayoutTextMessageActionButtonBinding r7 = this.b;
        int r8 = r2.intValue();
        LottieAdapterView r9 = r7.c;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r9, "lottieView");
        r9.addValueCallback(new d6a.a(new String[]{"**"}), c6a.d.C, new a(r8));
        r7.c.setColorFilter(new PorterDuffColorFilter(r8, PorterDuff.Mode.SRC_ATOP));
    L8:
        return Unit.INSTANCE;
    }
}
