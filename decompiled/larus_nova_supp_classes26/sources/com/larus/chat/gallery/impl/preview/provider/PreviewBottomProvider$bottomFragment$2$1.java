package com.larus.chat.gallery.impl.preview.provider;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class PreviewBottomProvider$bottomFragment$2$1 extends FunctionReferenceImpl implements Function1<com.larus.chat.gallery.api.o, Unit> {
    public PreviewBottomProvider$bottomFragment$2$1(Object r8) {
        super(1, r8, PreviewBottomProvider.class, "onSelectedItemClick", "onSelectedItemClick(Lcom/larus/chat/gallery/api/PreviewMediaItem;)V", 0);
    }

    public final void invoke(com.larus.chat.gallery.api.o r3) {
        Intrinsics.checkNotNullParameter(r3, "p0");
        PreviewBottomProvider r0 = (PreviewBottomProvider) ((CallableReference) this).receiver;
        int r4 = r0.j.i(r3.a);
        if (r4 < 0) goto L13;
        com.larus.gallery.api.w r1 = ((com.larus.gallery.api.t) r0).e;
        if (r1 == null) goto L11;
        com.larus.gallery.api.x r2 = r1.AQ(Reflection.getOrCreateKotlinClass(com.larus.gallery.api.x.class));
        if (r2 == null) goto L12;
        r2.j(r4);
        return;
    L12:
        return;
    L11:
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((com.larus.chat.gallery.api.o) r1);
        return Unit.INSTANCE;
    }
}
