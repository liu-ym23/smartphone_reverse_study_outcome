package hlc;

import com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface c<T> extends IEffectPlatformBaseListener<T> {
    void onFinally();

    void onStart();
}
