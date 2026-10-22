package com.bytedance.android.livesdk.chatroom.viewmodule.shortterm;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c implements om3.e.c {
    public final /* synthetic */ BubbleComponent a;

    public final void bubbleDismiss() {
        BubbleComponent r0 = this.a;
        r0.b = null;
        r0.h.removeObserver(r0);
    }

    public c(BubbleComponent r1) {
        this.a = r1;
    }
}
