package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: classes.dex */
public class FitWindowsLinearLayout extends LinearLayout {
    public FitWindowsLinearLayout(Context r8, AttributeSet r10) {
        super(r8, r10);
    }

    @Override // android.view.View
    public final boolean fitSystemWindows(Rect r8) {
        return super.fitSystemWindows(r8);
    }

    public void setOnFitSystemWindowsListener(f0 r8) {
    }
}
