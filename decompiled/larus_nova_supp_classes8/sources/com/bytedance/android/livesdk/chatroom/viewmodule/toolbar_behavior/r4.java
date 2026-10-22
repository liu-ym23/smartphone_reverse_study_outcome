package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.app.Dialog;
import com.bytedance.android.livesdkapi.business.ILiveRenQiBaoService;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class r4<T> implements Consumer {
    public final /* synthetic */ q4 a;

    public r4(q4 r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        zg1.n2 r4 = (zg1.n2) r3;
        Dialog r0 = this.a.a;
        if (r0 == null) goto L6;
        jc1.k.n(ILiveRenQiBaoService.class).showDialogContent(r0, !r4.a);
        return;
    }
}
