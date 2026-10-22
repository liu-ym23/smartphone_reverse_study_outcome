package com.bytedance.android.livesdk.interactivity.like.view;

import android.view.View;
import io.reactivex.functions.Action;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class q implements Action {
    public final /* synthetic */ DiggCountFlipperLayout a;

    public q(DiggCountFlipperLayout r1) {
        this.a = r1;
    }

    public final void run() {
        Iterator<T> r0 = this.a.s.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((View) r0.next()).clearAnimation();
        goto L4
    L6:
        Iterator<T> r1 = this.a.t.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        ((View) r1.next()).clearAnimation();
        goto L8
    }
}
