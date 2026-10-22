package com.larus.project;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class v implements View.OnLayoutChangeListener {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ RecyclerView b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ TaskProjectFragment d;

    public v(boolean r1, RecyclerView r2, boolean r3, TaskProjectFragment r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        r1.removeOnLayoutChangeListener(this);
        if (this.a == false) goto L10;
        RecyclerView.Adapter r10 = this.b.getAdapter();
        if (r10 == null) goto L7;
        int r11 = r10.getItemCount();
    L8:
        if (r11 <= 0) goto L10;
        this.b.scrollToPosition(0);
        goto L10
    L7:
        r11 = 0;
    L10:
        RecyclerView r12 = this.b;
        r12.post(new u(this.c, this.d, r12));
    }
}
