package com.larus.chat.gallery.impl.preview.toolbar;

import com.larus.chat.gallery.api.l;
import com.larus.chat.gallery.api.q;
import com.larus.chat.gallery.impl.preview.data.SourceType;
import com.larus.gallery.api.GalleryType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import sq9.a0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class PreviewToolbarCoordinator$createMarkAction$1 extends FunctionReferenceImpl implements Function1<xy8.d, Boolean> {
    public PreviewToolbarCoordinator$createMarkAction$1(Object r8) {
        super(1, r8, PreviewToolbarCoordinator.class, "supportsCrop", "supportsCrop(Lcom/larus/chat/gallery/impl/preview/data/PreviewGalleryData;)Z", 0);
    }

    public final Boolean invoke(xy8.d r6) {
        Intrinsics.checkNotNullParameter(r6, "p0");
        PreviewToolbarCoordinator r0 = (PreviewToolbarCoordinator) ((CallableReference) this).receiver;
        int r1 = PreviewToolbarCoordinator.v;
        r0.getClass();
        boolean r3 = false;
        if (r6.e == GalleryType.Video) goto L25;
        q r2 = r0.k;
        if (r2 == null) goto L11;
        l r4 = r2.getCapability();
        if (r4 == null) goto L11;
        if (r4.c == true) goto L11;
        boolean r5 = true;
    L12:
        if (r5 == true) goto L25;
        Function1<SourceType, a0> r7 = r0.l;
        if (r7 == null) goto L18;
        a0 r8 = (a0) r7.invoke(r6.a);
        if (r8 == null) goto L18;
    L19:
        int r9 = f.a;
        e r10 = f.a(r6, r8, r0.m);
        String r11 = ToolbarButtonType.CROP.getKey();
        if (r10.a.contains(r11) == false) goto L22;
    L23:
        r3 = true;
        goto L25
    L22:
        if (r10.b.contains(r11) == false) goto L25;
    L18:
        r8 = r0.d(r6.a);
    L11:
        r5 = false;
    L25:
        return Boolean.valueOf(r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((xy8.d) r1);
    }
}
