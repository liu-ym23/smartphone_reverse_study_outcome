package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes.dex */
public class FitWindowsFrameLayout extends FrameLayout {
    public FitWindowsFrameLayout(Context r8, AttributeSet r10) {
        super(r8, r10);
    }

    @Override // android.view.View
    public final boolean fitSystemWindows(Rect r8) {
        return super.fitSystemWindows(r8);
    }

    public void setOnFitSystemWindowsListener(f0 r8) {
    }
}
