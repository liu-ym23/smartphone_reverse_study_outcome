package com.bytedance.android.live.revlink.impl.multianchor.vm;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ LinkingInvitePreloadUtils a;

    public e(LinkingInvitePreloadUtils r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Long r4 = (Long) r3;
        LinkingInvitePreloadUtils r5 = this.a;
        if (r5.i == false) goto L6;
        return;
    L6:
        if (r5.h().length() <= 0) goto L8;
        boolean r6 = true;
    L9:
        if (r6 == false) goto L15;
        LinkingInvitePreloadUtils r7 = this.a;
        Disposable r1 = r7.h;
        if (r1 == null) goto L13;
        r1.dispose();
    L13:
        r7.i = true;
        return;
    L15:
        return;
    L8:
        r6 = false;
        goto L9
    }
}
