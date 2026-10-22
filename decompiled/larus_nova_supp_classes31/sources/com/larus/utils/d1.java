package com.larus.utils;

import android.os.SystemClock;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class d1 implements View.OnClickListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ View.OnClickListener b;

    public /* synthetic */ d1(View r1, View.OnClickListener r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r10) {
        View r11 = this.a;
        View.OnClickListener r0 = this.b;
        long r1 = SystemClock.elapsedRealtime();
        Object r4 = r11.getTag(123400002);
        Long r6 = null;
        if ((r4 instanceof Long) == false) goto L5;
        Long r5 = (Long) r4;
    L6:
        if (r5 == null) goto L8;
        long r7 = r5.longValue();
    L9:
        long r8 = r1 - r7;
        Object r9 = r11.getTag(123400001);
        if ((r9 instanceof Long) == false) goto L12;
        r6 = (Long) r9;
    L12:
        if (r6 == null) goto L14;
        long r12 = r6.longValue();
    L16:
        if (r8 >= r12) goto L18;
        boolean r13 = true;
    L19:
        r11.setTag(123400002, Long.valueOf(r1));
        if (r13 == true) goto L23;
        r0.onClick(r11);
        return;
    L23:
        return;
    L18:
        r13 = false;
        goto L19
    L14:
        r12 = 500;
        goto L16
    L8:
        r7 = 0;
        goto L9
    L5:
        r5 = null;
        goto L6
    }
}
