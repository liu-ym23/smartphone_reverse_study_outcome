package com.suite.lark.platform.feature.forward.doubao;

import com.ss.android.lark.forwardv3.ForwardModuleV3;
import com.ss.android.lark.forwardv3.data.ForwardTargetBaseInfoNew;
import com.ss.android.lark.forwardv3.data.ForwardTargetGroupChatInfo;
import com.ss.android.lark.forwardv3.data.ForwardTargetThreadInfo;
import com.ss.android.lark.forwardv3.viewmodel.ForwardV3ViewModel;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
public /* synthetic */ class DoubaoForwardConfirmFragment$doSuccess$2$shown$1 extends FunctionReferenceImpl implements Function1<String, Unit> {
    public DoubaoForwardConfirmFragment$doSuccess$2$shown$1(Object r8) {
        super(1, r8, DoubaoForwardConfirmFragment.class, "openChat", "openChat(Ljava/lang/String;)V", 0);
    }

    public final void invoke(String r6) {
        Intrinsics.checkNotNullParameter(r6, "p0");
        DoubaoForwardConfirmFragment r0 = (DoubaoForwardConfirmFragment) ((CallableReference) this).receiver;
        int r1 = DoubaoForwardConfirmFragment.v;
        r0.getClass();
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L15
        tib.g r3 = ForwardModuleV3.a();     // Catch: Throwable -> L15
        ForwardV3ViewModel r4 = r0.d;     // Catch: Throwable -> L15
        if (r4 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");     // Catch: Throwable -> L15
        r4 = null;
    L6:
        ForwardTargetBaseInfoNew r5 = (ForwardTargetBaseInfoNew) CollectionsKt.firstOrNull(r4.getForwardTargets());     // Catch: Throwable -> L15
        if ((r5 instanceof ForwardTargetThreadInfo) == false) goto L10;
        r3.go2Thread(r0.requireContext(), r6);     // Catch: Throwable -> L15
    L13:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L15
        return;
    L10:
        if ((r5 instanceof ForwardTargetGroupChatInfo) == false) goto L12;
        r3.go2Chat(r0.requireContext(), r6, ((ForwardTargetGroupChatInfo) r5).g, null);     // Catch: Throwable -> L15
        goto L13
    L12:
        r3.go2Chat(r0.requireContext(), r6, null);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((String) r1);
        return Unit.INSTANCE;
    }
}
