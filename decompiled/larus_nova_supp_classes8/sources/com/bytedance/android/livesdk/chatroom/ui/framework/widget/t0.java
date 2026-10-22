package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class t0<T> implements Consumer {
    public final /* synthetic */ RecordCompositeWidget a;

    public t0(RecordCompositeWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        Long r2 = (Long) r1;
        RecordCompositeWidget.wq(this.a);
    }
}
