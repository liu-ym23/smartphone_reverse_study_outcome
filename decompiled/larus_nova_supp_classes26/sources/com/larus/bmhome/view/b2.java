package com.larus.bmhome.view;

import android.widget.ImageView;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class b2 implements Function1 {
    public final /* synthetic */ FastScrollButton a;
    public final /* synthetic */ Function1 b;

    public /* synthetic */ b2(FastScrollButton r1, ld8.f r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r8) {
        FastScrollButton r0 = this.a;
        Function1 r1 = this.b;
        ImageView r9 = (ImageView) r8;
        int r2 = FastScrollButton.f;
        Intrinsics.checkNotNullParameter(r9, "it");
        FLogger r3 = FLogger.a;
        StringBuilder r4 = new StringBuilder("fast_button_click_accepted parentVisible=");
        boolean r5 = true;
        if (r0.getVisibility() != 0) goto L5;
        boolean r6 = true;
    L6:
        r4.append(r6);
        r4.append(" parentAlpha=");
        r4.append(r0.getAlpha());
        r4.append(" parentTranslationY=");
        r4.append(r0.getTranslationY());
        r4.append(" isShow=");
        r4.append(r0.e);
        r4.append(" iconVisible=");
        if (r0.d.getVisibility() == 0) goto L10;
        r5 = false;
    L10:
        r4.append(r5);
        r4.append(" iconAlpha=");
        r4.append(r0.d.getAlpha());
        r4.append(" iconEnabled=");
        r4.append(r0.d.isEnabled());
        r4.append(" iconClickable=");
        r4.append(r0.d.isClickable());
        r3.i("fast-scroll-click-chain", r4.toString());
        r1.invoke(r9);
        return Unit.INSTANCE;
    L5:
        r6 = false;
        goto L6
    }
}
