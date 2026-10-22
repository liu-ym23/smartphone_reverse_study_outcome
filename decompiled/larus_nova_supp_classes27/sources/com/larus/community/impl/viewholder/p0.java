package com.larus.community.impl.viewholder;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.larus.utils.e1;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class p0 extends BaseControllerListener<Object> {
    public final /* synthetic */ CreationVideoViewHolder a;
    public final /* synthetic */ Ref.ObjectRef<Integer> b;

    public p0(CreationVideoViewHolder r1, Ref.ObjectRef<Integer> r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
        super.onFinalImageSet(r1, r2, r3);
        boolean r4 = r0.a;
        if (r0.a == false) goto L10;
        CreationVideoViewHolder r5 = this.a;
        if (r5.p == false) goto L7;
        return;
    L7:
        if (this.b.element == null) goto L12;
        e1.x(r5.b);
        return;
    L12:
        return;
    }
}
