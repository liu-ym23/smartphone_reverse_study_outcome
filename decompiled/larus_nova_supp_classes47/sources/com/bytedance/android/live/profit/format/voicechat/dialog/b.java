package com.bytedance.android.live.profit.format.voicechat.dialog;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import o60.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements e {
    public final /* synthetic */ Function1 a;

    public b(Function1 r1) {
        this.a = r1;
    }

    public final void onPermissionDenied(String... r2) {
        Intrinsics.checkNotNullParameter(r2, "permissions");
        this.a.invoke(Boolean.FALSE);
    }

    public final void onPermissionGrant(String... r2) {
        Intrinsics.checkNotNullParameter(r2, "permissions");
        this.a.invoke(Boolean.TRUE);
    }
}
