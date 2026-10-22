package com.larus.chat.gallery.impl.preview.provider;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class PreviewBottomProvider$onAttach$5 extends FunctionReferenceImpl implements Function0<Unit> {
    public PreviewBottomProvider$onAttach$5(Object r8) {
        super(0, r8, com.larus.chat.gallery.impl.preview.input.d0.class, "cancelPendingResult", "cancelPendingResult()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m124invoke() {
        ((com.larus.chat.gallery.impl.preview.input.d0) ((CallableReference) this).receiver).g();
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m124invoke();
        return Unit.INSTANCE;
    }
}
