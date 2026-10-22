package com.bytedance.android.livesdk.interactivity.chatchannel.widget;

import com.bytedance.android.live.core.tetris.layer.core.element.widget.WidgetElement;
import com.bytedance.android.livesdk.chatroom.model.PadOrientation;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class y<T> implements Consumer {
    public final /* synthetic */ z a;
    public final /* synthetic */ com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.b b;

    public y(z r1, com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.b r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r3) {
        if (((PadOrientation) sh6.c.b((sh6.b) r3)) != PadOrientation.LANDSCAPE) goto L8;
        z r4 = this.a;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.b r0 = this.b;
        WidgetElement r1 = r4.c;
        if (r1 == null) goto L7;
        r0.b().S(r1);
    L7:
        r4.c = null;
        r4.d = null;
        return;
    L8:
        z r5 = this.a;
        if (r5.c != null) goto L13;
        r5.a(this.b);
        return;
    }
}
