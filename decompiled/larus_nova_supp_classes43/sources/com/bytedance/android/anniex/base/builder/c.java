package com.bytedance.android.anniex.base.builder;

import androidx.fragment.app.FragmentActivity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c extends UIComponentBuilder {
    public FragmentActivity j;
    public ka.a k;

    public final FragmentActivity e() {
        FragmentActivity r0 = this.j;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("fragmentActivity");
        return null;
    }

    public c() {
    }

    public final void d(FragmentActivity r10) {
        Intrinsics.checkNotNullParameter(r10, "fragmentActivity");
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.j = r10;
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.a = r10;
    }
}
