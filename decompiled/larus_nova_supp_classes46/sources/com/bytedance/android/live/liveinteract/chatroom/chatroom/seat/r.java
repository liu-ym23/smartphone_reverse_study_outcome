package com.bytedance.android.live.liveinteract.chatroom.chatroom.seat;

import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.facebook.drawee.backends.pipeline.Fresco;
import io.reactivex.functions.Consumer;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class r<T> implements Consumer {
    public final /* synthetic */ HSImageView a;
    public final /* synthetic */ a b;

    public r(HSImageView r1, a r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r4) {
        Unit r5 = (Unit) r4;
        this.a.setController(Fresco.newDraweeControllerBuilder().setFirstAvailableImageRequests(a1.b(this.b.a.c, -1)).build());
    }
}
