package com.ss.android.lark.chatwindow.view.preview;

import android.view.View;
import android.view.ViewGroup;
import com.ss.android.lark.chat.base.view.vo.message.BaseTextContentVO;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class j implements View.OnClickListener {
    public final /* synthetic */ UrlPreviewCollapsingHelper<BaseTextContentVO<?>> a;

    public j(UrlPreviewCollapsingHelper<BaseTextContentVO<?>> r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r12) {
        if (this.a.e.getVisibility() != 8) goto L5;
        boolean r13 = true;
    L6:
        if (r13 == false) goto L11;
        final UrlPreviewCollapsingHelper<BaseTextContentVO<?>> r14 = this.a;
        r14.b(false);
        UrlPreviewCollapsingHelper.a r0 = r14.l;
        if (r0 == null) goto L10;
        r0.g.cancel();
        View r2 = r0.e;
        int r1 = r0.h;
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        r3.height = r1;
        r2.setLayoutParams(r3);
    L10:
        UrlPreviewCollapsingHelper.a r4 = new UrlPreviewCollapsingHelper.a(false, r14.d, r14.f, r14.i, r14.e, new UrlPreviewCollapsingHelper$expand$1(r14));
        r4.g.start();
        r14.l = r4;
        r14.d(2131891228, true);
        return;
    L11:
        final UrlPreviewCollapsingHelper<BaseTextContentVO<?>> r15 = this.a;
        r15.b(true);
        UrlPreviewCollapsingHelper.a r5 = r15.l;
        if (r5 == null) goto L14;
        r5.g.cancel();
        View r6 = r5.e;
        int r7 = r5.h;
        ViewGroup.LayoutParams r8 = r6.getLayoutParams();
        r8.height = r7;
        r6.setLayoutParams(r8);
    L14:
        UrlPreviewCollapsingHelper.a r9 = new UrlPreviewCollapsingHelper.a(true, r15.d, r15.f, r15.i, r15.e, new UrlPreviewCollapsingHelper$collapse$1(r15));
        r9.g.start();
        r15.l = r9;
        r15.d(2131891229, true);
        return;
    L5:
        r13 = false;
        goto L6
    }
}
