package com.bytedance.android.livesdk.jsbridge.methods.draft;

import com.bytedance.android.live.user.IUserService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class l {
    public final h a;
    public final k b;
    public final IUserService c;

    public l() {
        h r0 = new h();
        k r1 = new k();
        IUserService r2 = jc1.k.n(IUserService.class);
        Intrinsics.checkNotNullParameter(r0, "rxDownloadApi");
        Intrinsics.checkNotNullParameter(r1, "rxSaveDraftApi");
        Intrinsics.checkNotNullParameter(r2, "userService");
        this.a = r0;
        this.b = r1;
        this.c = r2;
    }
}
