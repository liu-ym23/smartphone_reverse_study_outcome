package androidx.appcompat.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.R;
import androidx.core.widget.PopupWindowCompat;

/* JADX INFO: loaded from: classes.dex */
class AppCompatPopupWindow extends PopupWindow {
    private static final boolean COMPAT_OVERLAP_ANCHOR = false;
    private boolean mOverlapAnchor;

    static {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        boolean r10 = true;
    L6:
        COMPAT_OVERLAP_ANCHOR = r10;
        return;
    L5:
        r10 = false;
        goto L6
    }

    public AppCompatPopupWindow(@NonNull Context r10, @Nullable AttributeSet r11, @AttrRes int r12) {
        super(r10, r11, r12);
        init(r10, r11, r12, 0);
    }

    public AppCompatPopupWindow(@NonNull Context r10, @Nullable AttributeSet r11, @AttrRes int r12, @StyleRes int r13) {
        super(r10, r11, r12, r13);
        init(r10, r11, r12, r13);
    }

    private void init(Context r10, AttributeSet r11, int r12, int r13) {
        TintTypedArray r14 = TintTypedArray.obtainStyledAttributes(r10, r11, R.styleable.PopupWindow, r12, r13);
        int r15 = R.styleable.PopupWindow_overlapAnchor;
        if (r14.hasValue(r15) == false) goto L5;
        setSupportOverlapAnchor(r14.getBoolean(r15, false));
    L5:
        setBackgroundDrawable(r14.getDrawable(R.styleable.PopupWindow_android_popupBackground));
        r14.recycle();
    }

    private void setSupportOverlapAnchor(boolean r10) {
        if (COMPAT_OVERLAP_ANCHOR == false) goto L5;
        this.mOverlapAnchor = r10;
        return;
    L5:
        PopupWindowCompat.setOverlapAnchor(this, r10);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View r10, int r11, int r12) {
        if (COMPAT_OVERLAP_ANCHOR == true) goto L5;
    L7:
        super.showAsDropDown(r10, r11, r12);
        return;
    L5:
        if (this.mOverlapAnchor == false) goto L7;
        r12 = r12 - r10.getHeight();
        goto L7
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View r10, int r11, int r12, int r13) {
        if (COMPAT_OVERLAP_ANCHOR == true) goto L5;
    L7:
        super.showAsDropDown(r10, r11, r12, r13);
        return;
    L5:
        if (this.mOverlapAnchor == false) goto L7;
        r12 = r12 - r10.getHeight();
        goto L7
    }

    @Override // android.widget.PopupWindow
    public void update(View r10, int r11, int r12, int r13, int r14) {
        if (COMPAT_OVERLAP_ANCHOR == true) goto L5;
    L7:
        super.update(r10, r11, r12, r13, r14);
        return;
    L5:
        if (this.mOverlapAnchor == false) goto L7;
        r12 = r12 - r10.getHeight();
        goto L7
    }
}
