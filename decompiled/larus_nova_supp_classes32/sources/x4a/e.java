package x4a;

import com.lynx.animax.composition.AnimaXComposition;
import com.lynx.animax.ui.ObjectFit;
import com.lynx.lottieadapter.LottieAdapterAnimaX$w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface e {
    void a(int r1);

    void b(int[] r1, boolean r2);

    void c(LottieAdapterAnimaX$w r1);

    void cancel();

    double getCurrentFrame();

    double getDurationMs();

    d getPlayer();

    boolean isAnimating();

    void pause();

    void play();

    void resume();

    void setAutoPlay(boolean r1);

    void setAutoReverse(boolean r1);

    void setComposition(AnimaXComposition r1);

    void setEndFrame(int r1);

    void setImageFolder(String r1);

    void setJson(String r1);

    void setLoop(boolean r1);

    void setLoopCount(int r1);

    void setMaxFrameRate(double r1);

    void setObjectFit(ObjectFit r1);

    void setProgress(float r1);

    void setSpeed(float r1);

    void setSrc(String r1);

    void setStartFrame(int r1);
}
