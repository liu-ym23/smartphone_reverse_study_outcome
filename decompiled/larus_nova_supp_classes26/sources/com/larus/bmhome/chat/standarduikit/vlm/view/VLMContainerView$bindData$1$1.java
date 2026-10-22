package com.larus.bmhome.chat.standarduikit.vlm.view;

import android.view.View;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class VLMContainerView$bindData$1$1 extends FunctionReferenceImpl implements Function1<Integer, List<? extends Pair<? extends Integer, ? extends View>>> {
    public VLMContainerView$bindData$1$1(Object r8) {
        super(1, r8, VLMContainerView.class, "dynamicGetRestoreView", "dynamicGetRestoreView(I)Ljava/util/List;", 0);
    }

    public final List<Pair<Integer, View>> invoke(int r3) {
        VLMContainerView r0 = (VLMContainerView) ((CallableReference) this).receiver;
        int r1 = VLMContainerView.k;
        return r0.x(r3, true);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke(((Number) r1).intValue());
    }
}
