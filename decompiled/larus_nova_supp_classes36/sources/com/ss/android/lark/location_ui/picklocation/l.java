package com.ss.android.lark.location_ui.picklocation;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.location.service.IPickLocationMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class l implements IPickLocationMap.a {
    public final /* synthetic */ LocationView a;

    public l(LocationView r1) {
        this.a = r1;
    }

    public final void a(double r3, double r5) {
        this.a.k.E2(r3, r5);
        LocationView r4 = this.a;
        if (r4.c == true) goto L5;
        return;
    L5:
        if (r4.q == false) goto L8;
        r4.L();
    L8:
        if (kqb.d.a() == false) goto L15;
        LocationView r6 = this.a;
        ValueAnimator r7 = r6.x;
        if (r7 != null) goto L12;
    L14:
        ObjectAnimator r8 = ObjectAnimator.ofFloat(r6.mIvLocationIcon, "translationY", new float[]{0.0f, -UIUtils.dp2px(r6.b, 16.0f), 0.0f});
        r6.x = r8;
        r8.setDuration(500);
        r6.x.setInterpolator(new AccelerateDecelerateInterpolator());
        r6.x.addUpdateListener(new n(r6));
        r6.x.start();
        return;
    L12:
        if (r7.isRunning() == false) goto L14;
        return;
    L15:
        this.a.n.c();
    }
}
