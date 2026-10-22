package com.bytedance.android.live.profile.profilecontext;

import com.bytedance.android.live.profile.ui.base.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d {
    public static final void a(Object r1, h r2) {
        Intrinsics.checkNotNullParameter(r2, "profileContext");
        Intrinsics.checkNotNullParameter(r2, "$this$injectTo");
        if ((r1 instanceof c) == false) goto L6;
        ((c) r1).setProfileContext(r2);
        return;
    }
}
