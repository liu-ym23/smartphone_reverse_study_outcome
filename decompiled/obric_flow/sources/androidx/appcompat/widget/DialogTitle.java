package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Layout;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class DialogTitle extends AppCompatTextView {
    public DialogTitle(@NonNull Context r5, @Nullable AttributeSet r10, int r11) {
        super(r5, r10, r11);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        Layout r5 = getLayout();
        if (r5 == null) goto L13;
        int r12 = r5.getLineCount();
        if (r12 > 0) goto L7;
        return;
    L7:
        if (r5.getEllipsisCount(r12 - 1) <= 0) goto L15;
        setSingleLine(false);
        setMaxLines(2);
        TypedArray r13 = getContext().obtainStyledAttributes(null, R.styleable.TextAppearance, android.R.attr.textAppearanceMedium, android.R.style.TextAppearance.Medium);
        int r14 = r13.getDimensionPixelSize(R.styleable.TextAppearance_android_textSize, 0);
        if (r14 == 0) goto L11;
        setTextSize(0, r14);
    L11:
        r13.recycle();
        super.onMeasure(r10, r11);
        return;
    L15:
        return;
    }

    public DialogTitle(@NonNull Context r5, @Nullable AttributeSet r10) {
        super(r5, r10);
    }

    public DialogTitle(@NonNull Context r5) {
        super(r5);
    }
}
