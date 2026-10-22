package com.bytedance.android.livesdk.chatroom.ui;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d5<T> implements Consumer {
    public final /* synthetic */ g5 a;

    public d5(g5 r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        sh6.b r3 = (sh6.b) r2;
        ((AbsInteractionFragment) this.a).nd0("IKtvService subscribe");
    }
}
