package com.larus.chat.gallery.impl.preview.provider;

import com.larus.chat.gallery.impl.preview.input.PreviewInputCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class PreviewBottomProvider$onAttach$10 extends FunctionReferenceImpl implements Function0<Unit> {
    public PreviewBottomProvider$onAttach$10(Object r8) {
        super(0, r8, PreviewInputCallback.class, "onCameraEntranceClick", "onCameraEntranceClick()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m122invoke() {
        ((PreviewInputCallback) ((CallableReference) this).receiver).c();
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m122invoke();
        return Unit.INSTANCE;
    }
}
