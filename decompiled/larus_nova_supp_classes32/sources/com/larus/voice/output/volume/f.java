package com.larus.voice.output.volume;

import android.media.AudioManager;
import com.larus.common.apphost.AppHost;
import m58.y;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class f implements Runnable {
    public final /* synthetic */ i a;

    public /* synthetic */ f(i r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i r0 = this.a;
        s.a.g(AppHost.a.getApplication(), 2131900029, false);
        AudioManager r1 = (AudioManager) r0.b.getValue();
        if (r1 == null) goto L6;
        y r2 = y.a;
        r1.adjustStreamVolume(y.c(), 1, 1);
        return;
    }
}
