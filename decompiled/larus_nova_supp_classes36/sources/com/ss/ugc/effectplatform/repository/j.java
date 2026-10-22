package com.ss.ugc.effectplatform.repository;

import com.ss.ugc.effectplatform.listener.IDownloadInfoStickerEffectProgressListener;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import com.ss.ugc.effectplatform.model.ProviderEffect;
import com.ss.ugc.effectplatform.model.net.InfoStickerEffect;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class j implements hlc.b {
    public final /* synthetic */ IDownloadInfoStickerEffectProgressListener a;
    public final /* synthetic */ InfoStickerEffect b;

    public final void onSuccess(Object r2) {
        ProviderEffect r3 = (ProviderEffect) r2;
        IDownloadInfoStickerEffectProgressListener r4 = this.a;
        if (r4 == null) goto L6;
        r4.onSuccess(this.b);
        return;
    }

    public j(IDownloadInfoStickerEffectProgressListener r1, InfoStickerEffect r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onFail(Object r2, ExceptionResult r3) {
        ProviderEffect r4 = (ProviderEffect) r2;
        IDownloadInfoStickerEffectProgressListener r5 = this.a;
        if (r5 == null) goto L6;
        r5.onFail(this.b, r3);
        return;
    }

    @Override // hlc.b
    public final void onProgress(ProviderEffect r2, int r3, long r4) {
        IDownloadInfoStickerEffectProgressListener r5 = this.a;
        if (r5 == null) goto L6;
        r5.onProgress(this.b, r3, r4);
        return;
    }
}
