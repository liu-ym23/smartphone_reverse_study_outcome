package com.bytedance.android.livesdk.chatroom.viewmodule.welfare.right;

import com.bytedance.android.livesdk.chatroom.viewmodule.welfare.w;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ WelfareProjectBottomRightCardWidget a;

    public i(WelfareProjectBottomRightCardWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r6) {
        Long r7 = (Long) r6;
        WelfareProjectBottomRightCardWidget r8 = this.a;
        int r0 = WelfareProjectBottomRightCardWidget.i;
        r8.getClass();
        xs2.b.a().post(new w(false, true, new int[2], 0));
        e r9 = r8.h;
        if (r9 == null) goto L6;
        r9.a();
        return;
    }
}
