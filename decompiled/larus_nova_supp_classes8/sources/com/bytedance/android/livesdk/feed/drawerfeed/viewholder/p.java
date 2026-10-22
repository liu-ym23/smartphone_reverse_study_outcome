package com.bytedance.android.livesdk.feed.drawerfeed.viewholder;

import com.bytedance.android.live.base.model.user.UserEvent;
import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class p<T> implements Predicate {
    public static final p a = null;

    static {
        a = new p();
    }

    public p() {
    }

    public final boolean test(Object r2) {
        UserEvent r3 = (UserEvent) r2;
        Intrinsics.checkNotNullParameter(r3, "res");
        if (r3.isLogOut() == false) goto L5;
    L8:
        return true;
    L5:
        if (r3.isLogin() == true) goto L8;
        return false;
    }
}
