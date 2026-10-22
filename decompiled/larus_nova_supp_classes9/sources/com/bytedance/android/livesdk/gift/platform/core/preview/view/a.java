package com.bytedance.android.livesdk.gift.platform.core.preview.view;

import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.RotateAnimation;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ BaseUgcGiftDialog a;

    public a(BaseUgcGiftDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r9) {
        BaseUgcGiftDialog r10 = this.a;
        int r0 = BaseUgcGiftDialog.o;
        r10.getClass();
        RotateAnimation r1 = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
        r1.setFillAfter(true);
        r1.setDuration(300);
        r1.setInterpolator(new AccelerateDecelerateInterpolator());
        View r11 = r10.l;
        if (r11 == null) goto L5;
        r11.startAnimation(r1);
    L5:
        Function0<Unit> r13 = this.a.f;
        if (r13 == null) goto L9;
        Unit r14 = (Unit) r13.invoke();
        return;
    }
}
