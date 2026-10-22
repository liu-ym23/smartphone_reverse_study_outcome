package com.bytedance.android.livesdk.interactivity.like.view;

import android.view.View;
import io.reactivex.functions.Action;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class o implements Action {
    public final /* synthetic */ DiggCountFlipperLayout a;

    public o(DiggCountFlipperLayout r1) {
        this.a = r1;
    }

    public final void run() {
        Iterator<ArrayList<View>> r0 = this.a.v.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        Iterator<T> r1 = r0.next().iterator();
    L7:
        if (r1.hasNext() == false) goto L4;
        ((View) r1.next()).clearAnimation();
        goto L7
    }
}
