package ei;

import android.R;
import android.content.Context;
import android.view.View;
import android.widget.Checkable;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b extends FrameLayout implements Checkable {
    public static final int[] b = null;
    public boolean a;

    static {
        b = new int[]{R.attr.state_checked};
    }

    public View getTagView() {
        return getChildAt(0);
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!this.a);
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.a;
    }

    public b(Context r1) {
        super(r1);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int r10) {
        int[] r11 = super.onCreateDrawableState(r10 + 1);
        if (this.a == false) goto L5;
        FrameLayout.mergeDrawableStates(r11, b);
    L5:
        return r11;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r10) {
        if (this.a == r10) goto L6;
        this.a = r10;
        refreshDrawableState();
        return;
    }
}
