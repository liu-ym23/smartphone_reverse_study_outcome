package mf;

import android.view.MotionEvent;
import com.lynx.tasm.behavior.ui.LynxBaseUI;

/* JADX INFO: loaded from: classes2.dex */
public interface b {
    LynxBaseUI getMapUI();

    int getMarkerHeight();

    int getMarkerLeft();

    int getMarkerTop();

    int getMarkerWidth();

    void onTouchUp(MotionEvent r5);

    void recognizeGesturere();

    void setMarkerLayoutParams(int r5, int r10, int r11, int r12);
}
