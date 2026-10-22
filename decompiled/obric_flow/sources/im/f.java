package im;

import com.lynx.animax.base.bridge.JavaOnlyMap;
import com.lynx.animax.composition.AnimaXComposition;
import com.lynx.animax.ui.ObjectFit;
import com.lynx.animax.ui.ObjectPosition;
import com.lynx.animax.util.AnimaXMetricsCallback;

/* JADX INFO: loaded from: classes2.dex */
public interface f {
    void a(AnimaXMetricsCallback r5);

    void b(float r5, float r10);

    b getAnimaXContext();

    AnimaXComposition getComposition();

    double getCurrentFrame();

    double getDurationMs();

    void setAntiAliasing(boolean r5);

    void setAutoPlay(boolean r5);

    void setAutoReverse(boolean r5);

    void setComposition(AnimaXComposition r5);

    void setDynamicResource(boolean r5);

    void setEndFrame(int r5);

    void setFpsEventInterval(long r5);

    void setImageFolder(String r5);

    void setJson(String r5);

    void setKeepLastFrame(boolean r5);

    void setLoop(boolean r5);

    void setLoopCount(int r5);

    void setMaxFrameRate(double r5);

    void setObjectFit(ObjectFit r5);

    void setObjectPosition(ObjectPosition r5);

    void setProgress(float r5);

    void setSpeed(float r5);

    void setSrc(String r5);

    void setSrcPolyfill(JavaOnlyMap r5);

    void setStartFrame(int r5);
}
