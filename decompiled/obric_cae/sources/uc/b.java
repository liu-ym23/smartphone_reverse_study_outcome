package uc;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.obric.cae.R;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f12586a;

    public b(Context r8, AttributeSet r10) {
        super(r8, r10);
    }

    public TextView getTitleView() {
        return this.f12586a;
    }

    public abstract void setDividerLineBackground(int r8);

    public void setTitle(int r8) {
        TextView r10 = this.f12586a;
        if (r10 != null) goto L5;
        return;
    L5:
        r10.setText(r8);
    }

    public void setTitleColor(int r8) {
        TextView r10 = this.f12586a;
        if (r10 != null) goto L5;
        return;
    L5:
        r10.setTextColor(r8);
    }

    public void setTitleSize(float r8) {
        TextView r10 = this.f12586a;
        if (r10 != null) goto L5;
        return;
    L5:
        r10.setTextSize(r8);
    }

    public void setTitleSizePixel(float r8) {
        TextView r10 = this.f12586a;
        if (r10 != null) goto L5;
        return;
    L5:
        r10.setTextSize(0, r8);
    }

    public b(Context r8, AttributeSet r10, int r11) {
        super(r8, r10, 0);
        if (getBackground() != null) goto L6;
        Object r12 = androidx.core.content.a.f1674a;
        setBackgroundColor(androidx.core.content.a.c.a(r8, R.color.BGPrimary));
        return;
    }

    public void setTitle(CharSequence r8) {
        TextView r10 = this.f12586a;
        if (r10 != null) goto L5;
        return;
    L5:
        r10.setText(r8);
    }
}
