package com.lynx.clay.embedding.engine.plugins.video;

import com.ss.ttvideoengine.SeekCompletionListener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c implements SeekCompletionListener {
    public final /* synthetic */ b.e a;

    public c(b.e r1) {
        this.a = r1;
    }

    public final void onCompletion(boolean r2) {
        c5a.c.c("VideoEngineTTImpl", "restoreLastPlaybackTime seekCompletion lastPlaying=" + this.a.a);
        b.e r3 = this.a;
        if (r3.a == false) goto L6;
        r3.f.c.play();
        this.a.a = false;
        return;
    }
}
