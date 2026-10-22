package com.larus.chat.gallery.impl.preview.provider;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class PreviewBottomProvider$bottomFragment$2$2 extends FunctionReferenceImpl implements Function1<com.larus.chat.gallery.api.o, Unit> {
    public PreviewBottomProvider$bottomFragment$2$2(Object r8) {
        super(1, r8, PreviewBottomProvider.class, "onSelectedItemRemove", "onSelectedItemRemove(Lcom/larus/chat/gallery/api/PreviewMediaItem;)V", 0);
    }

    public final void invoke(com.larus.chat.gallery.api.o r4) {
        Intrinsics.checkNotNullParameter(r4, "p0");
        PreviewBottomProvider r0 = (PreviewBottomProvider) ((CallableReference) this).receiver;
        int r1 = r0.j.i(r4.a);
        if (r1 >= 0) goto L5;
        return;
    L5:
        if (r0.j.k(r4.a) == false) goto L11;
        com.larus.gallery.api.w r5 = ((com.larus.gallery.api.t) r0).e;
        if (r5 == null) goto L12;
        r5.Rf(new com.larus.gallery.api.p.h(r1));
        return;
    L12:
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((com.larus.chat.gallery.api.o) r1);
        return Unit.INSTANCE;
    }
}
