package com.bytedance.android.live.room.navi.landtoptool;

import android.view.View;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ LandscapeTopToolbarWidget a;

    public a(LandscapeTopToolbarWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        c0.d r4 = (c0.d) r3;
        Intrinsics.checkNotNullParameter(r4, "event");
        View r0 = this.a.f.get(r4.a);
        if (r0 != null) goto L5;
        return;
    L5:
        if (r4.b == false) goto L7;
        r0.setAlpha(0.4f);
        return;
    L7:
        r0.setAlpha(1.0f);
    }
}
