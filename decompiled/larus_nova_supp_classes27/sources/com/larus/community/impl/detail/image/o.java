package com.larus.community.impl.detail.image;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class o implements CreationZoomableDraweeView.b {
    public final /* synthetic */ CreationDetailImageView a;

    @Override // com.larus.community.impl.detail.image.CreationZoomableDraweeView.b
    public final void c() {
        Function0<Unit> r0 = this.a.getOnImageDoubleTapListener();
        if (r0 == null) goto L6;
        r0.invoke();
        return;
    }

    public o(CreationDetailImageView r1) {
        this.a = r1;
    }
}
