package com.larus.voicecall.impl.utils;

import android.graphics.drawable.Animatable;
import android.view.View;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import com.larus.utils.e1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class i extends BaseControllerListener<ImageInfo> {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ View b;

    public i(boolean r1, View r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
        ImageInfo r4 = (ImageInfo) r2;
        Intrinsics.checkNotNullParameter(r1, "id");
        if (this.a == true) goto L5;
        e1.o(this.b);
    L5:
        if (r3 == null) goto L8;
        r3.start();
        return;
    }
}
