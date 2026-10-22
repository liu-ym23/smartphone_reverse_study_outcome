package com.larus.voicecall.impl.subtitle;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.view.FastScrollButton;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class w implements View.OnLayoutChangeListener {
    public final /* synthetic */ RealtimeCallSubtitleLayout a;
    public final /* synthetic */ FastScrollButton b;

    public w(RealtimeCallSubtitleLayout r1, FastScrollButton r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        r1.removeOnLayoutChangeListener(this);
        LinearLayoutManager r10 = this.a.a.c.getLayoutManager();
        if ((r10 instanceof LinearLayoutManager) == false) goto L5;
        LinearLayoutManager r11 = r10;
    L6:
        if (r11 == null) goto L20;
        RecyclerView.Adapter r12 = this.a.a.c.getAdapter();
        boolean r13 = false;
        if (r12 == null) goto L11;
        int r14 = r12.getItemCount();
    L12:
        if (r14 > 0) goto L14;
        this.b.setShow(false);
        return;
    L14:
        int r15 = r11.findLastCompletelyVisibleItemPosition();
        FastScrollButton r16 = this.b;
        if ((r15 + 1) == r14) goto L17;
        r13 = true;
    L17:
        r16.setShow(r13);
        return;
    L11:
        r14 = 0;
        goto L12
    L20:
        return;
    L5:
        r11 = null;
        goto L6
    }
}
