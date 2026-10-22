package hlc;

import com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener;
import com.ss.ugc.effectplatform.model.Effect;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface d extends IEffectPlatformBaseListener<Effect> {
    void onProgress(Effect r1, int r2, long r3);

    void onStart(Effect r1);
}
