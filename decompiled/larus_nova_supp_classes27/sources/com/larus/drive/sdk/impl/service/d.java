package com.larus.drive.sdk.impl.service;

import com.larus.drive.biz.impl.view.AbsDriveListFragment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class d implements e89.b {
    public s79.a a;

    public d() {
    }

    @Override // e89.b
    public final s79.a a() {
        return this.a;
    }

    @Override // e89.b
    public final void k(AbsDriveListFragment.d r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.a = r2;
    }
}
