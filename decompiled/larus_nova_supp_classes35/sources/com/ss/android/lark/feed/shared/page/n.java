package com.ss.android.lark.feed.shared.page;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class n implements zeb.a {
    public final /* synthetic */ k a;

    @Override // zeb.a
    public final boolean a() {
        r r0 = this.a.g;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("feedItemsListener");
        r0 = null;
    L6:
        return r0.a();
    }

    @Override // zeb.a
    public final void b() {
        r r0 = this.a.g;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("feedItemsListener");
        r0 = null;
    L5:
        r0.b();
    }

    @Override // zeb.a
    public final void pauseDataChange() {
        r r0 = this.a.g;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("feedItemsListener");
        r0 = null;
    L5:
        r0.pauseDataChange();
    }

    public n(k r1) {
        this.a = r1;
    }
}
