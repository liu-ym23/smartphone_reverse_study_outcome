package com.ss.android.lark.passport.flow.core.widget;

import android.app.Activity;
import com.ss.android.lark.utils.ViewUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a implements CommonTitleBar.b {
    public final /* synthetic */ CommonTitleBar a;

    @Override // com.ss.android.lark.passport.flow.core.widget.CommonTitleBar.b
    public final void a() {
    }

    @Override // com.ss.android.lark.passport.flow.core.widget.CommonTitleBar.b
    public final void c() {
    }

    @Override // com.ss.android.lark.passport.flow.core.widget.CommonTitleBar.b
    public final void d() {
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.ViewGroup, com.ss.android.lark.passport.flow.core.widget.CommonTitleBar] */
    @Override // com.ss.android.lark.passport.flow.core.widget.CommonTitleBar.b
    public final void b() {
        ?? r0 = this.a;
        if (r0.r != null) goto L6;
        r0.r = ViewUtils.getActivityByContext(r0.getContext());
    L6:
        Activity r1 = this.a.r;
        if (r1 == null) goto L10;
        r1.onBackPressed();
        return;
    }

    public a(CommonTitleBar r1) {
        this.a = r1;
    }
}
