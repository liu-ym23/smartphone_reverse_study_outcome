package com.larus.connector;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class e extends BaseControllerListener<ImageInfo> {
    public final /* synthetic */ ConnectorAdapter.ConnectorViewHolder a;
    public final /* synthetic */ String b;

    public e(ConnectorAdapter.ConnectorViewHolder r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onFailure(String r1, Throwable r2) {
        if (Intrinsics.areEqual(this.a.g, this.b) == false) goto L6;
        this.a.T3(false);
        return;
    }

    public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
        if (((ImageInfo) r2) != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(this.a.g, this.b) == false) goto L9;
        this.a.T3(true);
        return;
    }
}
