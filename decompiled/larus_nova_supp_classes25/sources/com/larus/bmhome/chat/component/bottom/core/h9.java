package com.larus.bmhome.chat.component.bottom.core;

import android.view.View;
import android.widget.ImageView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class h9 implements g9 {
    public final Object a;

    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.View, java.lang.Object] */
    @Override // com.larus.bmhome.chat.component.bottom.core.g9
    public final View root() {
        return this.a;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.View, java.lang.Object] */
    public final void a(float r2) {
        ?? r0 = this.a;
        if (r0 == 0) goto L6;
        r0.setAlpha(r2);
        return;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.View, java.lang.Object] */
    public final void b(boolean r2) {
        ?? r0 = this.a;
        if (r0 == 0) goto L6;
        r0.setEnabled(r2);
        return;
    }

    public final void c(int r3) {
        Object r0 = this.a;
        if ((r0 instanceof ImageView) == false) goto L6;
        ((ImageView) r0).setImageResource(r3);
        return;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.View, java.lang.Object] */
    public final void d(int r2) {
        ?? r0 = this.a;
        if (r0 == 0) goto L6;
        r0.setVisibility(r2);
        return;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.View, java.lang.Object] */
    public final void e(boolean r2) {
        ?? r0 = this.a;
        if (r0 == 0) goto L9;
        if (r2 == false) goto L6;
        int r3 = 0;
    L7:
        r0.setVisibility(r3);
        return;
    L6:
        r3 = 8;
        goto L7
    }

    public h9(g9.b r1, int r2) {
        View r3 = r1.a;
        if (r3 == null) goto L5;
        View r4 = r3.findViewById(r2);
    L6:
        this.a = r4;
        return;
    L5:
        r4 = null;
        goto L6
    }
}
