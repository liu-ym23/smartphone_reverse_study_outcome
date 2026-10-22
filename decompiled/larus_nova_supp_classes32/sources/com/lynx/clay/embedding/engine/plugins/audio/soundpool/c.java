package com.lynx.clay.embedding.engine.plugins.audio.soundpool;

import android.media.SoundPool;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c implements SoundPool.OnLoadCompleteListener {
    public final /* synthetic */ d a;

    public c(d r1) {
        this.a = r1;
    }

    @Override // android.media.SoundPool.OnLoadCompleteListener
    public final void onLoadComplete(SoundPool r1, int r2, int r3) {
        GenericSoundPool.b r4 = this.a.b;
        if (r4 == null) goto L9;
        if (r3 != 0) goto L6;
        boolean r5 = true;
    L7:
        ((com.lynx.clay.embedding.engine.plugins.audio.a.C0036a) r4).a(r2, r5);
        return;
    L6:
        r5 = false;
        goto L7
    }
}
