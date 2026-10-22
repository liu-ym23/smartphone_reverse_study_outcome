package com.bytedance.android.livesdk.gift.platform.core.sticker;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f implements Runnable {
    public final /* synthetic */ StickerMessageService a;

    public f(StickerMessageService r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.J(StickerMessageService.StickerType.Normal);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
