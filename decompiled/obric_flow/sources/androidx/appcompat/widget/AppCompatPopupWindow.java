package androidx.appcompat.widget;

import android.content.Context;
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
        COMPAT_OVERLAP_ANCHOR = false;
    }

    public AppCompatPopupWindow(@NonNull Context r5, @Nullable AttributeSet r10, @AttrRes int r11) {
        super(r5, r10, r11);
        init(r5, r10, r11, 0);
    }

    private void init(Context r5, AttributeSet r10, int r11, int r12) {
        TintTypedArray r13 = TintTypedArray.obtainStyledAttributes(r5, r10, R.styleable.PopupWindow, r11, r12);
        if (r13.hasValue(R.styleable.PopupWindow_overlapAnchor) == false) goto L5;
        setSupportOverlapAnchor(r13.getBoolean(R.styleable.PopupWindow_overlapAnchor, false));
    L5:
        setBackgroundDrawable(r13.getDrawable(R.styleable.PopupWindow_android_popupBackground));
        r13.recycle();
    }

    private void setSupportOverlapAnchor(boolean r5) {
        if (COMPAT_OVERLAP_ANCHOR == false) goto L5;
        this.mOverlapAnchor = r5;
        return;
    L5:
        PopupWindowCompat.setOverlapAnchor(this, r5);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View r5, int r10, int r11) {
        if (COMPAT_OVERLAP_ANCHOR == true) goto L5;
    L7:
        super.showAsDropDown(r5, r10, r11);
        return;
    L5:
        if (this.mOverlapAnchor == false) goto L7;
        r11 = r11 - r5.getHeight();
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

    public AppCompatPopupWindow(@NonNull Context r5, @Nullable AttributeSet r10, @AttrRes int r11, @StyleRes int r12) {
        super(r5, r10, r11, r12);
        init(r5, r10, r11, r12);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View r5, int r10, int r11, int r12) {
        if (COMPAT_OVERLAP_ANCHOR == true) goto L5;
    L7:
        super.showAsDropDown(r5, r10, r11, r12);
        return;
    L5:
        if (this.mOverlapAnchor == false) goto L7;
        r11 = r11 - r5.getHeight();
        goto L7
    }
}
