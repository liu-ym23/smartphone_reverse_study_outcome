package com.bytedance.android.live.revlink.impl.multianchor.pk.pklaunch;

import android.content.DialogInterface;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.MultiAnchorPkLaunchDialogNew;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements DialogInterface.OnDismissListener {
    public final /* synthetic */ MultiAnchorPkLaunchControlWidget a;
    public final /* synthetic */ MultiAnchorPkLaunchDialogNew b;

    public b(MultiAnchorPkLaunchControlWidget r1, MultiAnchorPkLaunchDialogNew r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r2) {
        if (Intrinsics.areEqual(this.a.e, this.b) == false) goto L6;
        this.a.e = null;
        return;
    }
}
