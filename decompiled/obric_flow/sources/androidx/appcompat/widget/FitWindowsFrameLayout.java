package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class FitWindowsFrameLayout extends FrameLayout implements FitWindowsViewGroup {
    private FitWindowsViewGroup.OnFitSystemWindowsListener mListener;

    public FitWindowsFrameLayout(@NonNull Context r5) {
        super(r5);
    }

    @Override // android.view.View
    public boolean fitSystemWindows(Rect r5) {
        FitWindowsViewGroup.OnFitSystemWindowsListener r10 = this.mListener;
        if (r10 == null) goto L6;
        r10.onFitSystemWindows(r5);
    L6:
        return super.fitSystemWindows(r5);
    }

    @Override // androidx.appcompat.widget.FitWindowsViewGroup
    public void setOnFitSystemWindowsListener(FitWindowsViewGroup.OnFitSystemWindowsListener r5) {
        this.mListener = r5;
    }

    public FitWindowsFrameLayout(@NonNull Context r5, @Nullable AttributeSet r10) {
        super(r5, r10);
    }
}
