package com.suite.lark.platform.component.widget_biz_fileview;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ FileView a;

    public a(FileView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        this.a.j.setVisibility(8);
        FileView r6 = this.a;
        FileView.c r1 = r6.r;
        if (r1 == null) goto L5;
        r1.b(r6.q);
    L5:
        FileView r7 = this.a;
        FileView.FileState r2 = r7.q.h;
        if (r2.a != 2) goto L11;
        r2.a = 1;
        r7.j.setVisibility(8);
        FileView r8 = this.a;
        FileView.c r0 = r8.r;
        if (r0 == null) goto L12;
        r0.d(r8.q);
        return;
    L12:
        return;
    }
}
