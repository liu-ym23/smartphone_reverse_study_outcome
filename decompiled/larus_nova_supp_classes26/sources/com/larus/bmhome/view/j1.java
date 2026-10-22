package com.larus.bmhome.view;

import android.text.TextPaint;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class j1 implements Runnable {
    public final /* synthetic */ com.larus.platform.api.j a;
    public final /* synthetic */ ChatTitleAlignLeftStyle b;

    public /* synthetic */ j1(com.larus.platform.api.j r1, ChatTitleAlignLeftStyle r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.larus.platform.api.j r0 = this.a;
        ChatTitleAlignLeftStyle r1 = this.b;
        int r2 = ChatTitleAlignLeftStyle.T;
        String r3 = null;
        if (r0 == null) goto L5;
        String r4 = r0.a;
    L6:
        if (r4 != null) goto L8;
    L11:
        boolean r5 = true;
    L12:
        if (r5 == false) goto L14;
        int r6 = r1.b.k.getWidth();
    L21:
        if (r1.g == true) goto L24;
        r1.b.C.setMaxWidth(r6);
        return;
    L24:
        return;
    L14:
        TextPaint r7 = r1.b.B.getPaint();
        if (r0 == null) goto L17;
        r3 = r0.a;
    L17:
        if (r3 != null) goto L19;
        r3 = "";
    L19:
        r6 = (r1.b.k.getWidth() - ((int) ((r7.measureText(r3) + r1.b.B.getPaddingStart()) + r1.b.B.getPaddingEnd()))) - i5.Y();
        goto L21
    L8:
        if (r4.length() == 0) goto L11;
        r5 = false;
        goto L12
    L5:
        r4 = null;
        goto L6
    }
}
