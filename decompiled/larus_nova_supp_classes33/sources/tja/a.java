package tja;

import android.view.ViewGroup;
import com.obric.common.oea.style.scene.alpha.alphaplayer.model.ScaleType;
import oja.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public interface a {
    boolean a();

    void b(ViewGroup r1);

    void c(float r1, float r2);

    void d(ViewGroup r1);

    int getMeasuredHeight();

    int getMeasuredWidth();

    ScaleType getScaleType();

    void onCompletion();

    void onFirstFrame();

    void onPause();

    void release();

    void requestRender();

    void setLayoutParams(ViewGroup.LayoutParams r1);

    void setPlayerController(b r1);

    void setVideoRenderer(rja.a r1);
}
