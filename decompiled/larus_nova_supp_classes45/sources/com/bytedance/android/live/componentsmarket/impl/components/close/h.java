package com.bytedance.android.live.componentsmarket.impl.components.close;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.y;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ RoomCloseWidget a;

    public h(RoomCloseWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        y r4 = (y) r3;
        boolean r0 = r4.a;
        int r5 = r4.b;
        if (r0 == false) goto L8;
        RoomCloseWidget r1 = this.a;     // Catch: Exception -> L13
        if (r5 != 8) goto L7;
        UtilityKotlinExtentionsKt.t(r1.Z());     // Catch: Exception -> L13
    L16:
        return;
    L7:
        r1.getClass();     // Catch: Exception -> L13
        goto L16
    L8:
        RoomCloseWidget r2 = this.a;     // Catch: Exception -> L13
        if (r5 != 8) goto L11;
        UtilityKotlinExtentionsKt.w(r2.Z());     // Catch: Exception -> L13
        goto L16
    L11:
        r2.getClass();     // Catch: Exception -> L13
    L13:
        e = move-exception;
        ALogger.e("RoomCloseWidget", "clear error: " + e.getMessage());
    }
}
