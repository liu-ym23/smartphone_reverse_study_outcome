package com.bytedance.android.debug;

import com.bytedance.android.livesdkapi.depend.live.player.ITextureViewPlayerController;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class m implements Runnable {
    public final /* synthetic */ l a;
    public final /* synthetic */ String b;
    public final /* synthetic */ boolean c;

    public m(l r1, String r10) {
        this.a = r1;
        this.b = r10;
        this.c = false;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ITextureViewPlayerController r1 = this.a.b;     // Catch: Throwable -> L6
        if (r1 == null) goto L9;
        ITextureViewPlayerController.DefaultImpls.start$default(r1, this.b, this.c, false, false, null, 28, null);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
