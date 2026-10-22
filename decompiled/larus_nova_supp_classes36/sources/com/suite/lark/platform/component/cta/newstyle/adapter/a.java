package com.suite.lark.platform.component.cta.newstyle.adapter;

import android.view.ViewGroup;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements Runnable {
    public final /* synthetic */ VersionInfoAdapter.VersionViewHolder a;
    public final /* synthetic */ VersionInfoAdapter b;
    public final /* synthetic */ int c;

    public a(VersionInfoAdapter.VersionViewHolder r1, VersionInfoAdapter r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        float r0 = (this.a.e.getMeasuredHeight() - this.a.c.getMeasuredHeight()) / 2.0f;
        float r1 = UIUtils.dp2px(this.b.getContext(), 18.0f) - r0;
        float r3 = UIUtils.dp2px(this.b.getContext(), 24.0f) - (2 * r0);
        int r2 = UIUtils.dp2px(this.b.getContext(), 18.0f);
        ViewGroup.LayoutParams r4 = this.a.g.getLayoutParams();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r5 = (ViewGroup.MarginLayoutParams) r4;
        int r6 = this.c;
        if (r6 != 0) goto L6;
        r5.setMargins(r2, (int) r1, r2, (int) r3);
    L9:
        this.a.g.setLayoutParams(r5);
        return;
    L6:
        if (r6 != (this.b.getItemCount() - 1)) goto L8;
        r5.setMargins(r2, 0, r2, (int) r1);
        goto L9
    L8:
        r5.setMargins(r2, 0, r2, (int) r3);
        goto L9
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
