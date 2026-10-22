package com.bytedance.android.live.revlink.impl.pk.dialog.presenter;

import com.bytedance.android.live.revlink.impl.pk.dialog.contract.InteractDialogPKSearchContract$View;
import com.bytedance.android.live.revlink.impl.pk.utils.SearchSourceFlag;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.link.model.i6;
import com.bytedance.android.livesdk.link.model.k6;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ j a;

    public e(j r1) {
        this.a = r1;
    }

    public final void accept(Object r6) {
        h1 r7 = (yh6.c) r6;
        j r0 = this.a;
        if (r7 != null) goto L5;
        r0.getClass();
        return;
    L5:
        if (r0.c != 0) goto L7;
        return;
    L7:
        if (r0.v == SearchSourceFlag.INVITE_LINKING) goto L10;
        return;
    L10:
        if ((r7 instanceof h1) == false) goto L27;
        i6 r8 = r7.castTo(i6.class);
        int r2 = (int) r8.getType2();
        if (r2 != 5) goto L14;
    L19:
        k6 r9 = r8.getReply();
        if (r9 != null) goto L22;
        return;
    L22:
        if (r9.getReplyStatus() != 1) goto L30;
        ((InteractDialogPKSearchContract$View) r0.c).finish();
        return;
    L30:
        return;
    L14:
        if (r2 == 8) goto L19;
        if (r2 != 31) goto L33;
        ((InteractDialogPKSearchContract$View) r0.c).finish();
        return;
    L33:
        return;
    }
}
