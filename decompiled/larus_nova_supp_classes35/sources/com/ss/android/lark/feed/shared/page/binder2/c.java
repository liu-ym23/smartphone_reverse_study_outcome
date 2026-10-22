package com.ss.android.lark.feed.shared.page.binder2;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements View.OnAttachStateChangeListener {
    public final /* synthetic */ FeedCommonViewHolder a;
    public final /* synthetic */ View b;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r3) {
        Intrinsics.checkNotNullParameter(r3, "v");
        com.ss.android.lark.feed.export.feedcard.h r4 = this.a.y;
        if (r4 == null) goto L5;
        r4.onViewAttachedToWindow();
    L5:
        heb.a.a.getFeedDependency().getClass();
        new com.ss.android.lark.feed.shared.data.swipe.a().b.observe(this.a.m.getHost(), this.a.F);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r3) {
        Intrinsics.checkNotNullParameter(r3, "v");
        com.ss.android.lark.feed.export.feedcard.h r4 = this.a.y;
        if (r4 == null) goto L5;
        r4.onViewDetachedFromWindow();
    L5:
        this.b.removeOnAttachStateChangeListener(this);
        Job r5 = this.a.C;
        if (r5 == null) goto L8;
        Job.DefaultImpls.cancel$default(r5, null, 1, null);
    L8:
        this.a.s.setSelected(false);
    }

    public c(FeedCommonViewHolder r1, View r2) {
        this.a = r1;
        this.b = r2;
    }
}
