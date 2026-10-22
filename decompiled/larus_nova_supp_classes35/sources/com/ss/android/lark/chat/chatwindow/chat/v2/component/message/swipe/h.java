package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.swipe;

import android.view.animation.Interpolator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class h implements Interpolator {
    public h() {
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float r9) {
        boolean r0 = false;
        if (r9 != 0.0f) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L9;
        return 0.0f;
    L9:
        if (r9 != 1.0f) goto L11;
        r0 = true;
    L11:
        if (r0 == false) goto L14;
        return 1.0f;
    L14:
        return (float) ((((double) ((float) Math.pow(2.0f, (-10) * r9))) * Math.sin((((double) (r9 * 10)) - 0.75d) * 2.0943951023931953d)) + ((double) 1));
    L5:
        r3 = false;
        goto L6
    }
}
