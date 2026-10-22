package com.larus.bmhome.chat.cotdetail.component;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.view.ChatConstraintLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e0 implements ChatConstraintLayout.b {
    public boolean a;
    public final /* synthetic */ CotDetailMessageListComponent b;

    public final void b() {
        this.a = false;
    }

    public final void a() {
        CotDetailMessageListComponent r0 = this.b;
        int r1 = CotDetailMessageListComponent.A;
        RecyclerView r2 = r0.Y2();
        boolean r3 = false;
        if (r2 != null) goto L5;
    L7:
        this.a = r3;
        return;
    L5:
        if (r2.canScrollVertically(1) == true) goto L7;
        r3 = true;
        goto L7
    }

    public e0(CotDetailMessageListComponent r1) {
        this.b = r1;
    }

    public final void onUpdate(int r3) {
        if (this.a == false) goto L14;
        CotDetailMessageListComponent r4 = this.b;
        int r0 = CotDetailMessageListComponent.A;
        RecyclerView r5 = r4.Y2();
        LinearLayoutManager r1 = null;
        if (r5 == null) goto L7;
        RecyclerView.LayoutManager r6 = r5.getLayoutManager();
    L9:
        if ((r6 instanceof LinearLayoutManager) == false) goto L11;
        r1 = (LinearLayoutManager) r6;
    L11:
        if (r1 == null) goto L15;
        r1.scrollToPositionWithOffset(0, 0);
        return;
    L15:
        return;
    L7:
        r6 = null;
        goto L9
    }
}
