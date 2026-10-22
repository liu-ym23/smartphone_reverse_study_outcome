package com.larus.camera.impl.utils;

import android.content.Context;
import android.view.OrientationEventListener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d0 extends OrientationEventListener {
    public final /* synthetic */ c0 a;

    @Override // android.view.OrientationEventListener
    public final void onOrientationChanged(int r5) {
        if (r5 != (-1)) goto L5;
        return;
    L5:
        this.a.getClass();
        int r1 = 0;
        if (r5 > 60) goto L8;
    L24:
        c0 r6 = this.a;
        if (r6.b != r1) goto L27;
        return;
    L27:
        r6.b = r1;
        if (((Boolean) r6.a.invoke(Integer.valueOf(r1))).booleanValue() == true) goto L31;
        disable();
        return;
    L31:
        return;
    L8:
        if (r5 > 300) goto L24;
        if (61 > r5) goto L14;
        if (r5 >= 136) goto L14;
        boolean r2 = true;
    L15:
        if (r2 == false) goto L17;
        r1 = 90;
        goto L24
    L17:
        if (136 <= r5) goto L19;
    L21:
        if (r1 == 0) goto L23;
        r1 = 180;
        goto L24
    L23:
        r1 = 270;
        goto L24
    L19:
        if (r5 >= 226) goto L21;
        r1 = 1;
    L14:
        r2 = false;
        goto L15
    }

    public d0(c0 r1, Context r2) {
        this.a = r1;
        super(r2);
    }
}
