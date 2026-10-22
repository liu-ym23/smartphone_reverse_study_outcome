package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class FitWindowsLinearLayout extends LinearLayout implements FitWindowsViewGroup {
    private FitWindowsViewGroup.OnFitSystemWindowsListener mListener;

    public FitWindowsLinearLayout(@NonNull Context r10) {
        super(r10);
    }

    public FitWindowsLinearLayout(@NonNull Context r10, @Nullable AttributeSet r11) {
        super(r10, r11);
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect r10) {
        FitWindowsViewGroup.OnFitSystemWindowsListener r11 = this.mListener;
        if (r11 == null) goto L6;
        r11.onFitSystemWindows(r10);
    L6:
        return super.fitSystemWindows(r10);
    }

    @Override // androidx.appcompat.widget.FitWindowsViewGroup
    public void setOnFitSystemWindowsListener(FitWindowsViewGroup.OnFitSystemWindowsListener r10) {
        this.mListener = r10;
    }
}
