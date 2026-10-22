package com.bytedance.android.livesdk.chatroom.widget.landscape;

import android.view.View;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.model.PadOrientation;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class q<T> implements Consumer {
    public final /* synthetic */ LandscapeQuickShotWidget a;

    public q(LandscapeQuickShotWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        View r0 = ((Widget) this.a).contentView;
        if (((PadOrientation) sh6.c.b((sh6.b) r3)) != PadOrientation.LANDSCAPE) goto L5;
        boolean r4 = true;
    L6:
        UtilityKotlinExtentionsKt.z(r0, r4);
        return;
    L5:
        r4 = false;
        goto L6
    }
}
