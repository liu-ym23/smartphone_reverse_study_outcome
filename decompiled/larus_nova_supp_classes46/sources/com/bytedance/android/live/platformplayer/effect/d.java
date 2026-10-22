package com.bytedance.android.live.platformplayer.effect;

import com.bytedance.android.livesdkapi.roomplayer.ComposerResult;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d implements ComposerResult {
    public final /* synthetic */ VrEffectDownloader a;
    public final /* synthetic */ ILivePlayerClient b;
    public final /* synthetic */ boolean c;

    public final void onResult(int r7) {
        com.bytedance.android.live.player.utils.b.g("LiveVrEffect_VrEffectDownloader", "setResourceRet=" + r7 + ",player=" + this.b);
        VrEffectDownloader r0 = this.a;
        if (r0.d >= 0) goto L5;
        r0.d = System.currentTimeMillis();
    L5:
        VrEffectDownloader r1 = this.a;
        Set<String> r2 = VrEffectDownloader.g;
        String r3 = VrEffectDownloader.h;
        if (r7 != 0) goto L8;
        boolean r8 = true;
    L9:
        VrEffectDownloader.b(r1, r3, r8, this.c);
        return;
    L8:
        r8 = false;
        goto L9
    }

    public d(VrEffectDownloader r1, ILivePlayerClient r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
