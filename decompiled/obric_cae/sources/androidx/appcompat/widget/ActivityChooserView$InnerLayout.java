package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: classes.dex */
public class ActivityChooserView$InnerLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f963a = null;

    static {
        f963a = new int[]{R.attr.background};
    }

    public ActivityChooserView$InnerLayout(Context r8, AttributeSet r10) {
        super(r8, r10);
        v0 r11 = new v0(r8, r8.obtainStyledAttributes(r10, f963a));
        setBackgroundDrawable(r11.e(0));
        r11.n();
    }
}
