package com.obric.assistant.window;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class l implements Runnable {
    public final /* synthetic */ ObricMsgComponent a;

    public /* synthetic */ l(ObricMsgComponent r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ObricMsgComponent r0 = this.a;
        int r1 = 0;
        r0.F = false;
        RecyclerView r2 = r0.z3();
        if (r2 == null) goto L8;
        r0.E = r2.getWidth();
        int r3 = r2.getChildCount();
    L6:
        if (r1 >= r3) goto L10;
        r0.G3(r2.getChildAt(r1));
        r1 = r1 + 1;
        goto L6
    L10:
        return;
    }
}
