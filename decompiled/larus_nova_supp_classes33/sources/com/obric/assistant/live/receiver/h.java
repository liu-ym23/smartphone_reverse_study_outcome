package com.obric.assistant.live.receiver;

import android.content.Intent;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.audio.service.ObricLiveServiceDelegate;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class h implements oga.a {
    public final /* synthetic */ Intent a;

    @Override // oga.a
    public final void onDismissFailed() {
    }

    @Override // oga.a
    public final void onDismissSucceeded() {
        FLogger.a.i("ObricLiveReceiver", "onDismissSucceeded");
        sea.e.c(true);
        ObricLiveServiceDelegate.b.g(this.a);
    }

    public h(Intent r1) {
        this.a = r1;
    }
}
