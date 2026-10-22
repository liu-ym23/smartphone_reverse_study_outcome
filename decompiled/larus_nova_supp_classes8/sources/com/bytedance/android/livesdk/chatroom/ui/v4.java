package com.bytedance.android.livesdk.chatroom.ui;

import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class v4 extends com.bytedance.android.livesdk.user.h<Object> {
    public final /* synthetic */ AbsInteractionFragment a;

    public v4(AbsInteractionFragment r1) {
        this.a = r1;
    }

    public final void onSubscribe(Disposable r2) {
        this.a.L.add(r2);
    }
}
