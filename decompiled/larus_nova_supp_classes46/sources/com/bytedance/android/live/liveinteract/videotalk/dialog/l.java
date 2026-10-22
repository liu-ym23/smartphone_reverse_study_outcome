package com.bytedance.android.live.liveinteract.videotalk.dialog;

import android.content.DialogInterface;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l implements DialogInterface.OnClickListener {
    public final /* synthetic */ n a;

    public l(n r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "dialog");
        r4.dismiss();
        rj0.l.n2.getClass();
        rj0.l r6 = rj0.l.a.a();
        if (r6 == null) goto L17;
        String r7 = this.a.n;
        int r0 = r7.hashCode();
        if (r0 == (-1383228885)) goto L13;
        if (r0 == 3526149) goto L10;
    L15:
        int r8 = 200;
    L16:
        rj0.l.b.d(r6, r8, true, false, 12);
        goto L17
    L10:
        if (r7.equals("seat") == false) goto L15;
        r8 = 201;
        goto L16
    L13:
        if (r7.equals("bottom") == false) goto L15;
        r8 = com.bytedance.android.live.liveinteract.multianchor.model.b.TYPE_BATTLE_DATA;
    L17:
        TalkRoomLogUtils.B(this.a.n, null);
    }
}
