package o9;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public interface a {
    void disablePressReleaseAnim(boolean r10);

    void handleTouchEvent(MotionEvent r10);

    void onPressedChanged(View r10, boolean r11);

    void onSelectedChanged(View r10, boolean r11);

    void refreshColors(String r10);

    void resetAlphaAnim();

    void setChangeAlphaWhenDisable(boolean r10);

    void setChangeAlphaWhenPress(boolean r10);

    void setChangeAlphaWhenSelected(boolean r10);

    void setKeepPressAlpha(boolean r10);

    void setOverridePressColor(int r10);
}
