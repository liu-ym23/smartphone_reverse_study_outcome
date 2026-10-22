package com.ss.android.lark.chat.cot.detail.blueprint;

import android.widget.ImageView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class CotDetailItemLayout$Companion$bindItemChrome$2 extends FunctionReferenceImpl implements Function1<ImageView, Unit> {
    public CotDetailItemLayout$Companion$bindItemChrome$2(Object r8) {
        super(1, r8, com.ss.android.lark.chat.cot.detail.widget.a.class, "clear", "clear(Landroid/widget/ImageView;)V", 0);
    }

    public final void invoke(ImageView r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        ((com.ss.android.lark.chat.cot.detail.widget.a) ((CallableReference) this).receiver).getClass();
        com.ss.android.lark.chat.cot.detail.widget.a.g(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((ImageView) r1);
        return Unit.INSTANCE;
    }
}
