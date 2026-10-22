package com.ss.android.lark.chat.video;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import com.ss.android.lark.chameleon.container.webcontainer.plugin.core.ChameleonWebViewClient;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class l implements View.OnTouchListener {
    public final /* synthetic */ h a;

    public l(h r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r10, MotionEvent r11) {
        Rect r12 = new Rect();
        this.a.o.getHitRect(r12);
        if (r11.getY() >= (r12.top - 500)) goto L5;
        return false;
    L5:
        if (r11.getY() > (r12.bottom + ChameleonWebViewClient.DEFAULT_SAFE_TIME)) goto L17;
        float r7 = r12.top + (r12.height() / 2);
        float r0 = r11.getX() - r12.left;
        if (r0 >= 0.0f) goto L10;
        float r6 = 0.0f;
    L14:
        return this.a.o.onTouchEvent(MotionEvent.obtain(r11.getDownTime(), r11.getEventTime(), r11.getAction(), r6, r7, r11.getMetaState()));
    L10:
        if (r0 <= r12.width()) goto L12;
        r6 = r12.width();
        goto L14
    L12:
        r6 = r0;
        goto L14
    L17:
        return false;
    }
}
