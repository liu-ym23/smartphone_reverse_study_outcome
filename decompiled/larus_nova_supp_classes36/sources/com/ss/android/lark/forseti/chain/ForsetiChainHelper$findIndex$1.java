package com.ss.android.lark.forseti.chain;

import androidx.fragment.app.Fragment;
import com.ss.android.lark.forseti.node.ForsetiNode;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/ss/android/lark/forseti/node/ForsetiNode;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final class ForsetiChainHelper$findIndex$1 extends Lambda implements Function1<ForsetiNode, Unit> {
    final /* synthetic */ Fragment $f;
    final /* synthetic */ Ref.IntRef $index;
    final /* synthetic */ Ref.IntRef $result;

    public ForsetiChainHelper$findIndex$1(Ref.IntRef r1, Fragment r2, Ref.IntRef r3) {
        this.$index = r1;
        this.$f = r2;
        this.$result = r3;
        super(1);
    }

    public final void invoke(ForsetiNode r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        this.$index.element++;
        if (r3.c(this.$f) == false) goto L6;
        this.$result.element = this.$index.element;
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((ForsetiNode) r1);
        return Unit.INSTANCE;
    }
}
