package com.bytedance.android.livesdk.interactivity.like.utils;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livesdk.message.model.d4;
import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f<T> implements Predicate {
    public static final f a = null;

    static {
        a = new f();
    }

    public f() {
    }

    public final boolean test(Object r2) {
        d4 r3 = (d4) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        User r4 = r3.b();
        if (r4 == null) goto L5;
        ImageModel r5 = r4.getAvatarThumb();
    L6:
        if (r5 == null) goto L8;
        return true;
    L8:
        return false;
    L5:
        r5 = null;
        goto L6
    }
}
