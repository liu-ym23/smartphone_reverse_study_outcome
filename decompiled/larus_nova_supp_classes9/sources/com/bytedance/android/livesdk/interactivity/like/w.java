package com.bytedance.android.livesdk.interactivity.like;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class w extends BaseControllerListener<Object> {
    public final /* synthetic */ x a;
    public final /* synthetic */ AbstractDraweeController b;

    public w(x r1, AbstractDraweeController r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
        Intrinsics.checkNotNullParameter(r1, "id");
        SimpleDraweeView r4 = this.a.a.g.e;
        if (r4 == null) goto L6;
        r4.setController(this.b);
        return;
    }
}
