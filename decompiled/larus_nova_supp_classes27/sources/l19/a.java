package l19;

import android.graphics.Rect;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public interface a {
    int getDismissAnimationType();

    Rect getEnterTransitionStartRect();

    float getMaxDragTransitionFactor();

    int getPos();

    j19.e getRestoreTransitionProvider();

    long getTransitionAnimationDuration();

    boolean isDragTransitionEnabled();

    boolean isSingleTagDismissEnabled();

    void setDismissAnimationType(int r1);

    void setDragTransitionEnabled(boolean r1);

    void setEnterTransitionStartRect(Rect r1);

    void setMaxDragTransitionFactor(float r1);

    void setPos(int r1);

    void setRestoreTransitionProvider(j19.e r1);

    void setSingleTagDismissEnabled(boolean r1);

    void setTransitionAnimationDuration(long r1);
}
