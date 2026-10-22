package com.bytedance.android.live.revlink.impl.multianchor.dialog.viewholder;

import android.content.DialogInterface;
import com.bytedance.android.livesdk.link.model.IRivalExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class AnchorLinkUserViewHolder$onInviteOrApply$4 implements DialogInterface.OnClickListener {
    public final /* synthetic */ AnchorLinkUserViewHolder a;
    public final /* synthetic */ IRoom b;
    public final /* synthetic */ IRivalExtraInfo c;
    public final /* synthetic */ String d;

    public AnchorLinkUserViewHolder$onInviteOrApply$4(AnchorLinkUserViewHolder r1, IRoom r2, IRivalExtraInfo r3, int r4, String r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r5;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "dialog");
        Function0<Unit> r2 = new AnchorLinkUserViewHolder$onInviteOrApply$4$applyRunnable$1(this);
        this.a.e.finishMultiAnchor(7, r2, false, "leave_for_apply", true);
        r7.dismiss();
    }
}
