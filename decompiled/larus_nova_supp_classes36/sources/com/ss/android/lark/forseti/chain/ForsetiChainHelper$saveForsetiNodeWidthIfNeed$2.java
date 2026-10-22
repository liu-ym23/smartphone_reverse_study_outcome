package com.ss.android.lark.forseti.chain;

import com.ss.android.lark.api.bean.ForsetiWidth;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final /* synthetic */ class ForsetiChainHelper$saveForsetiNodeWidthIfNeed$2 extends FunctionReferenceImpl implements Function1<ForsetiWidth, Unit> {
    public ForsetiChainHelper$saveForsetiNodeWidthIfNeed$2(Object r8) {
        super(1, r8, com.ss.android.lark.forseti.util.dragging.d.class, "setRightForsetiWidth", "setRightForsetiWidth(Lcom/ss/android/lark/api/bean/ForsetiWidth;)V", 0);
    }

    public final void invoke(ForsetiWidth r2) {
        ((com.ss.android.lark.forseti.util.dragging.d) ((CallableReference) this).receiver).getClass();
        if (r2 != null) goto L5;
        r2 = ForsetiWidth.AVERAGE_LEVEL;
    L5:
        com.ss.android.lark.forseti.util.dragging.d.c = r2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((ForsetiWidth) r1);
        return Unit.INSTANCE;
    }
}
