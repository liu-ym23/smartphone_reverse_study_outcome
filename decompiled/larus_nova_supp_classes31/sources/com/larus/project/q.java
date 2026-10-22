package com.larus.project;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.flowskill.impl.databinding.LarusFragmentProjectBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class q implements Runnable {
    public final /* synthetic */ TaskProjectFragment a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ boolean c;

    public /* synthetic */ q(TaskProjectFragment r1, boolean r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TaskProjectFragment r0 = this.a;
        boolean r1 = this.b;
        boolean r2 = this.c;
        LarusFragmentProjectBinding r3 = r0.d;
        if (r3 == null) goto L21;
        RecyclerView r4 = r3.i;
        if (r4 != null) goto L8;
        return;
    L8:
        if (r4.isLaidOut() == true) goto L10;
    L19:
        r4.addOnLayoutChangeListener(new v(r1, r4, r2, r0));
        return;
    L10:
        if (r4.isLayoutRequested() == true) goto L19;
        if (r1 == false) goto L18;
        RecyclerView.Adapter r5 = r4.getAdapter();
        if (r5 == null) goto L15;
        int r6 = r5.getItemCount();
    L16:
        if (r6 <= 0) goto L18;
        r4.scrollToPosition(0);
        goto L18
    L15:
        r6 = 0;
    L18:
        r4.post(new u(r2, r0, r4));
        return;
    }
}
