package com.bytedance.android.live.profile.ui.util;

import com.bytedance.android.live.base.model.user.NewProfileUser;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class q implements Function0<Boolean> {
    public final NewProfileUser a;

    public final Object invoke() {
        return Boolean.valueOf(!this.a.isFromOtherIntercomRoom());
    }

    public q(NewProfileUser r2) {
        Intrinsics.checkNotNullParameter(r2, "user");
        this.a = r2;
    }
}
