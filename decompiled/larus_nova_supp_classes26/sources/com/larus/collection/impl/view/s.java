package com.larus.collection.impl.view;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class s implements View.OnTouchListener {
    public final /* synthetic */ NormalCollectionItemHolder a;

    public s(NormalCollectionItemHolder r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r3, MotionEvent r4) {
        NormalCollectionItemHolder r5 = this.a;
        if (r4 == null) goto L5;
        int r1 = (int) r4.getX();
    L6:
        r5.j = r1;
        NormalCollectionItemHolder r6 = this.a;
        if (r4 == null) goto L9;
        int r7 = (int) r4.getY();
    L10:
        r6.k = r7;
        return false;
    L9:
        r7 = 0;
        goto L10
    L5:
        r1 = 0;
        goto L6
    }
}
