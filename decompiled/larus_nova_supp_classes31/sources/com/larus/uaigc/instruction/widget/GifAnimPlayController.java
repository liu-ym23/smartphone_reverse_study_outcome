package com.larus.uaigc.instruction.widget;

import android.graphics.drawable.Animatable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class GifAnimPlayController {
    public RecyclerView a;
    public boolean b;
    public final GifAnimPlayController$scrollListener$1 c;

    /* JADX WARN: Type inference failed for: r0v0, types: [com.larus.uaigc.instruction.widget.GifAnimPlayController$scrollListener$1] */
    public GifAnimPlayController() {
        this.c = new GifAnimPlayController$scrollListener$1(this);
    }

    public static final void a(GifAnimPlayController r6) {
        RecyclerView r0 = r6.a;
        if (r0 == null) goto L31;
        RecyclerView.LayoutManager r1 = r0.getLayoutManager();
        if (r1 == null) goto L39;
        int r2 = r1.getChildCount();
        int r3 = 0;
    L8:
        if (r3 >= r2) goto L40;
        View r4 = r1.getChildAt(r3);
        if (r4 == null) goto L30;
        RecyclerView r5 = r6.a;
        ImageSelectorHolder r7 = null;
        if (r5 == null) goto L15;
        RecyclerView.ViewHolder r8 = r5.getChildViewHolder(r4);
    L17:
        if ((r8 instanceof ImageSelectorHolder) == false) goto L19;
        r7 = (ImageSelectorHolder) r8;
    L19:
        if (r7 == null) goto L30;
        if (r7.U3() == true) goto L24;
        r7.V3();
        goto L30
    L24:
        if (r7.c == true) goto L30;
        Animatable r9 = r7.g;
        if (r9 == null) goto L30;
        r9.start();
        goto L30
    L15:
        r8 = null;
    L30:
        r3 = r3 + 1;
        goto L8
    L40:
        return;
    L39:
        return;
    }
}
