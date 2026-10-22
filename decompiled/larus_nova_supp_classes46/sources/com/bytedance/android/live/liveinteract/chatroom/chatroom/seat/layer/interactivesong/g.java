package com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g implements fd0.b {
    public final /* synthetic */ Function0 a;

    public g(Function0 r1) {
        this.a = r1;
    }

    @Override // fd0.b
    public final void onStop() {
        Function0 r0 = this.a;
        if (r0 == null) goto L6;
        Unit r1 = (Unit) r0.invoke();
        return;
    }
}
