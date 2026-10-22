package com.bytedance.android.live.liveinteract.channel.widget;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 5, 1})
final class ChannelLinkInvitedDialog$initView$2 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ ChannelLinkInvitedDialog this$0;

    public ChannelLinkInvitedDialog$initView$2(ChannelLinkInvitedDialog r1) {
        this.this$0 = r1;
        super(1);
    }

    public final void invoke(View r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        ChannelLinkInvitedDialog r3 = this.this$0;
        int r0 = ChannelLinkInvitedDialog.D;
        r3.getClass();
        Intrinsics.throwUninitializedPropertyAccessException("callback");
        Intrinsics.throwUninitializedPropertyAccessException("inviterUser");
        throw null;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((View) r1);
        return Unit.INSTANCE;
    }
}
