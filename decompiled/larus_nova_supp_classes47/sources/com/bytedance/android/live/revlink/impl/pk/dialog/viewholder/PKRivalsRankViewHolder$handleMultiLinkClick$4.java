package com.bytedance.android.live.revlink.impl.pk.dialog.viewholder;

import android.content.DialogInterface;
import com.bytedance.android.livesdk.link.model.m2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class PKRivalsRankViewHolder$handleMultiLinkClick$4 implements DialogInterface.OnClickListener {
    public final /* synthetic */ PKRivalsRankViewHolder a;
    public final /* synthetic */ m2 b;

    public PKRivalsRankViewHolder$handleMultiLinkClick$4(PKRivalsRankViewHolder r1, m2 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "dialog");
        Function0<Unit> r2 = new PKRivalsRankViewHolder$handleMultiLinkClick$4$applyRunnable$1(this);
        this.a.p.finishMultiAnchor(7, r2, false, "leave_for_apply", true);
        r7.dismiss();
    }
}
