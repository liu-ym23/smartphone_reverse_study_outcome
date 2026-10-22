package com.bytedance.android.livesdk.chatroom.ui.layouthelper.bizhelper;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 4, 3})
final class RowTwoComposeHelper$onHideTitleLayout$1 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ int $visibility;

    public RowTwoComposeHelper$onHideTitleLayout$1(int r1) {
        this.$visibility = r1;
        super(1);
    }

    public final void invoke(View r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        r2.setVisibility(this.$visibility);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((View) r1);
        return Unit.INSTANCE;
    }
}
