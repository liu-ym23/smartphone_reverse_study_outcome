package com.ss.ugc.effectplatform.listener;

import com.ss.ugc.effectplatform.model.net.InfoStickerEffect;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\"\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/ss/ugc/effectplatform/listener/IDownloadInfoStickerEffectProgressListener;", "Lcom/ss/ugc/effectplatform/listener/IEffectPlatformBaseListener;", "Lcom/ss/ugc/effectplatform/model/net/InfoStickerEffect;", "onProgress", "", "providerEffect", "progress", "", "totalSize", "", "effectplatform_release"}, k = 1, mv = {1, 1, 16})
public interface IDownloadInfoStickerEffectProgressListener extends IEffectPlatformBaseListener<InfoStickerEffect> {
    void onProgress(InfoStickerEffect r1, int r2, long r3);
}
