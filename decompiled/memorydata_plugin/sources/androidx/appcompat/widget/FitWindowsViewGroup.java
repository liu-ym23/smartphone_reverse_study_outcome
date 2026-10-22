package androidx.appcompat.widget;

import android.graphics.Rect;

/* JADX INFO: loaded from: classes.dex */
public interface FitWindowsViewGroup {

    public interface OnFitSystemWindowsListener {
        void onFitSystemWindows(Rect r1);
    }

    void setOnFitSystemWindowsListener(OnFitSystemWindowsListener r1);
}
