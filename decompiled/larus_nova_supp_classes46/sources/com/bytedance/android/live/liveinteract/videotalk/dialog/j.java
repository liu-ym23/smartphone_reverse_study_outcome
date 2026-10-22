package com.bytedance.android.live.liveinteract.videotalk.dialog;

import android.content.DialogInterface;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j implements DialogInterface.OnClickListener {
    public final /* synthetic */ n a;

    public j(n r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
        r2.dismiss();
        ILinkPlayerInfoBridge r4 = this.a.d;
        if (r4 == null) goto L12;
        IBaseUser r5 = r4.getUser();
        if (r5 == null) goto L13;
        Intrinsics.checkNotNullParameter(r5, "$this$secUidExt");
        String r6 = r5.getCastSecUid();
        if (r6 == null) goto L14;
        rj0.k.m2.getClass();
        rj0.k r0 = rj0.k.a.a();
        if (r0 == null) goto L15;
        r0.Kh(r5.getIdString(), r6);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }
}
