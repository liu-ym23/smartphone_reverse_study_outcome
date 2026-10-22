package com.bytedance.android.livesdk.interactivity.like;

import android.net.Uri;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import io.reactivex.functions.Consumer;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class x<T> implements Consumer {
    public final /* synthetic */ DiggWidget.c a;

    public x(DiggWidget.c r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Pair r5 = (Pair) r4;
        Uri r0 = (Uri) r5.getFirst();
        if (r0 == null) goto L13;
        Uri r6 = (Uri) r5.getSecond();
        if (r6 == null) goto L14;
        int r1 = com.bytedance.android.livesdk.interactivity.like.utils.j.a;
        Intrinsics.checkNotNullParameter(r0, "uri");
        AbstractDraweeController r2 = Fresco.newDraweeControllerBuilder().setUri(r0).setAutoPlayAnimations(true).build();
        Intrinsics.checkNotNullParameter(r6, "uri");
        r2.addControllerListener(new w(this, Fresco.newDraweeControllerBuilder().setUri(r6).setAutoPlayAnimations(true).build()));
        SimpleDraweeView r7 = this.a.g.e;
        if (r7 == null) goto L12;
        r7.setController(r2);
        return;
    L12:
        return;
    L14:
        return;
    }
}
