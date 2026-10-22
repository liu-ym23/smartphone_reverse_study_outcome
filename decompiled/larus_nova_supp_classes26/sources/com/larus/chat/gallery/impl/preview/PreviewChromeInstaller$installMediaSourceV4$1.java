package com.larus.chat.gallery.impl.preview;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class PreviewChromeInstaller$installMediaSourceV4$1 extends FunctionReferenceImpl implements Function0<Unit> {
    public PreviewChromeInstaller$installMediaSourceV4$1(Object r8) {
        super(0, r8, com.larus.chat.gallery.api.q.class, "onPreviewClosed", "onPreviewClosed()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m119invoke() {
        ((com.larus.chat.gallery.api.q) ((CallableReference) this).receiver).u();
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m119invoke();
        return Unit.INSTANCE;
    }
}
