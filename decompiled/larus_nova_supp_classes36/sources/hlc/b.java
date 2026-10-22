package hlc;

import com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener;
import com.ss.ugc.effectplatform.model.ProviderEffect;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface b extends IEffectPlatformBaseListener<ProviderEffect> {
    void onProgress(ProviderEffect r1, int r2, long r3);
}
