package com.bytedance.android.live.revlink.impl.pk.dialog.vm;

import com.bytedance.android.live.revlink.impl.control.dialog.f;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0000¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlin/Pair;", "", "Lcom/bytedance/android/live/revlink/impl/control/dialog/f;", "p1", "", "invoke", "(Lkotlin/Pair;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class RevLinkAnchorSubViewModel$initData$1$4 extends FunctionReferenceImpl implements Function1<Pair<? extends String, ? extends f>, Unit> {
    public RevLinkAnchorSubViewModel$initData$1$4(RevLinkAnchorSubViewModel r8) {
        super(1, r8, RevLinkAnchorSubViewModel.class, "onDataLoadFail", "onDataLoadFail(Lkotlin/Pair;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((Pair) r1);
        return Unit.INSTANCE;
    }

    public final void invoke(Pair<String, f> r2) {
        RevLinkAnchorSubViewModel.access$onDataLoadFail((RevLinkAnchorSubViewModel) ((CallableReference) this).receiver, r2);
    }
}
