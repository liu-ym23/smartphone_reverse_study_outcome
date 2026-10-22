package com.ss.ugc.effectplatform.repository;

import com.ss.ugc.effectplatform.listener.IDownloadInfoStickerEffectProgressListener;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import com.ss.ugc.effectplatform.model.net.InfoStickerEffect;
import hlc.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class i implements d {
    public final /* synthetic */ IDownloadInfoStickerEffectProgressListener a;
    public final /* synthetic */ InfoStickerEffect b;

    public final void onStart(Effect r1) {
    }

    public final void onSuccess(Object r2) {
        Effect r3 = (Effect) r2;
        IDownloadInfoStickerEffectProgressListener r4 = this.a;
        if (r4 == null) goto L6;
        r4.onSuccess(this.b);
        return;
    }

    public i(IDownloadInfoStickerEffectProgressListener r1, InfoStickerEffect r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onFail(Object r2, ExceptionResult r3) {
        Effect r4 = (Effect) r2;
        IDownloadInfoStickerEffectProgressListener r5 = this.a;
        if (r5 == null) goto L6;
        r5.onFail(this.b, r3);
        return;
    }

    public final void onProgress(Effect r2, int r3, long r4) {
        IDownloadInfoStickerEffectProgressListener r5 = this.a;
        if (r5 == null) goto L6;
        r5.onProgress(this.b, r3, r4);
        return;
    }
}
