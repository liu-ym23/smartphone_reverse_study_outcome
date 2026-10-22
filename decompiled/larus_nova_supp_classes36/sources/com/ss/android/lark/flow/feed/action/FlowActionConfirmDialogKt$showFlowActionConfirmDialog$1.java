package com.ss.android.lark.flow.feed.action;

import com.ss.android.lark.foundation.dialog.FlowAlertDialog;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/ss/android/lark/foundation/dialog/FlowAlertDialog;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final class FlowActionConfirmDialogKt$showFlowActionConfirmDialog$1 extends Lambda implements Function1<FlowAlertDialog, Unit> {
    final /* synthetic */ Function0<Unit> $onConfirm;

    public FlowActionConfirmDialogKt$showFlowActionConfirmDialog$1(Function0<Unit> r1) {
        this.$onConfirm = r1;
        super(1);
    }

    public final void invoke(FlowAlertDialog r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        this.$onConfirm.invoke();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((FlowAlertDialog) r1);
        return Unit.INSTANCE;
    }
}
