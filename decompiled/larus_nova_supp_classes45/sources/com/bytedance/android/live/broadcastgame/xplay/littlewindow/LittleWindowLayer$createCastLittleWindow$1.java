package com.bytedance.android.live.broadcastgame.xplay.littlewindow;

import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Landroid/view/ViewGroup;", "invoke"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class LittleWindowLayer$createCastLittleWindow$1 extends FunctionReferenceImpl implements Function1<ViewGroup, Unit> {
    public LittleWindowLayer$createCastLittleWindow$1(com.bytedance.android.live.broadcastgame.api.xplay.h r8) {
        super(1, r8, com.bytedance.android.live.broadcastgame.api.xplay.h.class, "onCreateView", "onCreateView(Landroid/view/ViewGroup;)V", 0);
    }

    public final void invoke(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "p1");
        ((com.bytedance.android.live.broadcastgame.api.xplay.h) ((CallableReference) this).receiver).b(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((ViewGroup) r1);
        return Unit.INSTANCE;
    }
}
