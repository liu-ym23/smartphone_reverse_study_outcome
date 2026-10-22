package com.larus.chat.gallery.impl.preview.provider;

import android.graphics.drawable.Animatable;
import android.widget.ImageView;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.image.loader.ImageLoaderKt;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class y extends BaseControllerListener<Object> {
    public final /* synthetic */ PreviewBottomContainerFragment.c a;
    public final /* synthetic */ com.larus.chat.gallery.api.o b;
    public final /* synthetic */ Pair<String, Boolean> c;
    public final /* synthetic */ SimpleDraweeView d;

    public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
        Intrinsics.checkNotNullParameter(r1, "id");
        com.larus.chat.gallery.api.o r4 = this.a.k;
        ImageView r5 = null;
        if (r4 == null) goto L5;
        String r6 = r4.a;
    L7:
        if (Intrinsics.areEqual(r6, this.b.a) == true) goto L9;
        return;
    L9:
        if (Intrinsics.areEqual(this.a.l, this.c) == false) goto L24;
        ImageView r7 = this.a.e;
        if (r7 != null) goto L14;
    L21:
        this.d.setAlpha(1.0f);
        this.a.e = this.d;
        return;
    L14:
        if (r7 == this.d) goto L16;
        boolean r8 = true;
    L17:
        if (r8 == false) goto L19;
        r5 = r7;
    L19:
        if (r5 == null) goto L21;
        r5.setAlpha(0.0f);
        ImageLoaderKt.d(r5);
        goto L21
    L16:
        r8 = false;
        goto L17
    L24:
        return;
    L5:
        r6 = null;
        goto L7
    }

    public y(PreviewBottomContainerFragment.c r1, com.larus.chat.gallery.api.o r2, Pair<String, Boolean> r3, SimpleDraweeView r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
