package com.bytedance.android.live.base.model.user;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class m {
    public static final String a(IBaseUser r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$idStringExt");
        return String.valueOf(r1.getUserId());
    }
}
