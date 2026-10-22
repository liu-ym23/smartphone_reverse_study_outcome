package com.bytedance.android.livesdk.interactivity.comment.utils;

import am2.x;
import com.bytedance.android.livesdk.interactivity.comment.x0;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import io.reactivex.functions.Consumer;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ Function0 a;
    public final /* synthetic */ int b;

    public c(x0 r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r5) {
        Long r6 = (Long) r5;
        j0.l().sendLog("livesdk_live_bottom_comment_pannel_show", MapsKt.mapOf(TuplesKt.to("default_text", this.a.invoke())), new Object[]{Room.class, x.class});
        Long r7 = e.a;
        e.b = this.b;
    }
}
