package com.bytedance.android.live.liveinteract.videotalk.dialog;

import android.content.DialogInterface;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k implements DialogInterface.OnClickListener {
    public final /* synthetic */ n a;

    public k(n r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
        r2.dismiss();
        ILinkPlayerInfoBridge r4 = this.a.d;
        if (r4 == null) goto L15;
        IBaseUser r5 = r4.getUser();
        if (r5 == null) goto L16;
        Intrinsics.checkNotNullParameter(r5, "$this$secUidExt");
        String r6 = r5.getCastSecUid();
        if (r6 == null) goto L17;
        com.bytedance.android.live.liveinteract.plantform.base.k.n0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.k r0 = com.bytedance.android.live.liveinteract.plantform.base.k.a.a();
        if (r0 == null) goto L18;
        String r7 = r5.getIdString();
        if (r7 != null) goto L13;
        r7 = "";
    L13:
        r0.ge(r7, r6);
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    }
}
