package com.ss.android.lark.reaction.widget.detailwindow.scroller;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class e implements b {
    public e() {
    }

    @Override // com.ss.android.lark.reaction.widget.detailwindow.scroller.b
    public int a(boolean r1, int r2, int r3) {
        if (r1 == false) goto L5;
        return 0;
    L5:
        return r3;
    }

    @Override // com.ss.android.lark.reaction.widget.detailwindow.scroller.b
    public int b(int r3, int r4) {
        if (r3 >= (r4 / 2)) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L9;
        return 0;
    L9:
        return r4;
    L5:
        r5 = false;
        goto L6
    }
}
