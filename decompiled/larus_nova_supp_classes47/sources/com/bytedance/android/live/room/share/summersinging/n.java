package com.bytedance.android.live.room.share.summersinging;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class n implements o60.e {
    public final /* synthetic */ l a;
    public final /* synthetic */ GroupPhotoShareLayoutViewHolder$trySaveImg$1 b;
    public final /* synthetic */ Function0 c;

    public final void onPermissionDenied(String... r3) {
        Intrinsics.checkNotNullParameter(r3, "permissions");
        f2.b(2131917214, 0);
        ALogger.e("GroupPhotoShareLayoutViewHolder", "request permissoin denied");
        Function0 r4 = this.c;
        if (r4 == null) goto L5;
        Unit r5 = (Unit) r4.invoke();
    L5:
        this.a.b = false;
    }

    public final void onPermissionGrant(String... r2) {
        Intrinsics.checkNotNullParameter(r2, "permissions");
        this.b.m1112invoke();
    }

    public n(l r1, GroupPhotoShareLayoutViewHolder$trySaveImg$1 r2, Function0 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
