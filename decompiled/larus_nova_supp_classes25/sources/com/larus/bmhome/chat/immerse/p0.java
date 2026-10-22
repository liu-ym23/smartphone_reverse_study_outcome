package com.larus.bmhome.chat.immerse;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class p0 implements Runnable {
    public final /* synthetic */ MessageListMaskWrapper a;

    public /* synthetic */ p0(MessageListMaskWrapper r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MessageListMaskWrapper r0 = this.a;
        r0.i();
        r0.i = r0.b.n.getHeight();
        r0.o((int) (((double) r0.h) * 0.45d));
        r0.f();
    }
}
