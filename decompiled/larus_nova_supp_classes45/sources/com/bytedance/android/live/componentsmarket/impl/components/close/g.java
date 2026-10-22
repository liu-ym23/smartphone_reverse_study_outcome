package com.bytedance.android.live.componentsmarket.impl.components.close;

import com.bytedance.android.live.core.tetris.widgets.y;
import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g<T> implements Predicate {
    public final /* synthetic */ RoomCloseWidget a;

    public g(RoomCloseWidget r1) {
        this.a = r1;
    }

    public final boolean test(Object r2) {
        y r3 = (y) r2;
        Intrinsics.checkNotNullParameter(r3, "<name for destructuring parameter 0>");
        r3.getClass();
        int r4 = r3.b;
        this.a.getClass();
        if ((r4 & 8) != r4) goto L5;
        return true;
    L5:
        return false;
    }
}
