package com.bytedance.android.livesdk.chatroom.widget;

import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class m1<T> implements Consumer {
    public final /* synthetic */ PlayerControlWidget a;

    public m1(PlayerControlWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        if (((Boolean) r1).booleanValue() == false) goto L5;
        PlayerControlWidget.zq(this.a);
        return;
    L5:
        ILivePlayerClient r2 = PlayerControlWidget.xq(this.a);
        if (r2 == null) goto L10;
        r2.pause();
        return;
    }
}
