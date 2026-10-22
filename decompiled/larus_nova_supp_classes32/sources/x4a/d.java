package x4a;

import com.lynx.animax.composition.AnimaXComposition;
import com.lynx.animax.property.AnimaXKeyPath;
import com.lynx.animax.property.LayerPropertyType;
import com.lynx.animax.ui.ObjectFit;
import com.lynx.animax.ui.ObjectPosition;
import com.lynx.animax.util.AnimaXMetricsCallback;
import com.lynx.lottieadapter.LottieAdapterAnimaX$a;
import com.lynx.lottieadapter.LottieAdapterAnimaX$b;
import com.lynx.lottieadapter.LottieAdapterAnimaX$w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface d {
    void a(int r1);

    void b(int[] r1, boolean r2);

    void c(LottieAdapterAnimaX$w r1);

    void cancel();

    void d(ObjectPosition r1);

    void e(boolean r1);

    void f(AnimaXMetricsCallback r1);

    void g(AnimaXKeyPath r1, LottieAdapterAnimaX$a r2);

    AnimaXComposition getComposition();

    double getCurrentFrame();

    double getDurationMs();

    void h(float r1, float r2);

    void i(LayerPropertyType r1, AnimaXKeyPath r2, LottieAdapterAnimaX$b.a r3, LottieAdapterAnimaX$b.b r4);

    boolean isAnimating();

    void j(long r1);

    void k(boolean r1);

    void l(boolean r1);

    void pause();

    void play();

    void resume();

    void setAutoPlay(boolean r1);

    void setAutoReverse(boolean r1);

    void setComposition(AnimaXComposition r1);

    void setEnableAudio(boolean r1);

    void setEndFrame(int r1);

    void setImageFolder(String r1);

    void setJson(String r1);

    void setLoop(boolean r1);

    void setLoopCount(int r1);

    void setMaxFrameRate(double r1);

    void setMuted(boolean r1);

    void setObjectFit(ObjectFit r1);

    void setProgress(float r1);

    void setSpeed(float r1);

    void setSrc(String r1);

    void setStartFrame(int r1);
}
