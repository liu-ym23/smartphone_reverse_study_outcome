package com.bytedance.android.livesdk.chatroom.widget.landscape;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class k<T> implements Consumer {
    public final /* synthetic */ LandscapeQuickShotObserveWidget a;

    public k(LandscapeQuickShotObserveWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        Long r2 = (Long) r1;
        LandscapeQuickShotObserveWidget.wq(this.a);
    }
}
