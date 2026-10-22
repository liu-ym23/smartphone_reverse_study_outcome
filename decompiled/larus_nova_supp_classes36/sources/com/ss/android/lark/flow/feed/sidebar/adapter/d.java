package com.ss.android.lark.flow.feed.sidebar.adapter;

import com.ss.android.lark.feed.shared.page.r;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements zeb.a {
    public final /* synthetic */ b a;

    public final boolean a() {
        r r0 = this.a.c;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("feedItemsListener");
        r0 = null;
    L6:
        return r0.a();
    }

    public final void b() {
        r r0 = this.a.c;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("feedItemsListener");
        r0 = null;
    L5:
        r0.b();
    }

    public final void pauseDataChange() {
        r r0 = this.a.c;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("feedItemsListener");
        r0 = null;
    L5:
        r0.pauseDataChange();
    }

    public d(b r1) {
        this.a = r1;
    }
}
