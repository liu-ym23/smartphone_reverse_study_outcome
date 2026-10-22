package com.larus.audio.call.aec;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class e implements Runnable {
    public final /* synthetic */ f a;

    public /* synthetic */ e(f r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        f r0 = this.a;
        r0.c = true;
        r0.a.SAMICoreDestroyHandle();
    }
}
