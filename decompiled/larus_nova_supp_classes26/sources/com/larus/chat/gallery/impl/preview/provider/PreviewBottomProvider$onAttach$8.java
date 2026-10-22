package com.larus.chat.gallery.impl.preview.provider;

import com.larus.chat.gallery.impl.preview.input.PreviewInputCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class PreviewBottomProvider$onAttach$8 extends FunctionReferenceImpl implements Function1<String, Unit> {
    public PreviewBottomProvider$onAttach$8(Object r8) {
        super(1, r8, PreviewInputCallback.class, "onInputTextChanged", "onInputTextChanged(Ljava/lang/String;)V", 0);
    }

    public final void invoke(String r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        ((PreviewInputCallback) ((CallableReference) this).receiver).a(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((String) r1);
        return Unit.INSTANCE;
    }
}
