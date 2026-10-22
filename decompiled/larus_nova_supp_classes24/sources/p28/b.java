package p28;

import android.R;
import android.content.Context;
import android.view.View;
import android.widget.Checkable;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
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
    public final int[] onCreateDrawableState(int r2) {
        int[] r3 = super.onCreateDrawableState(r2 + 1);
        if (this.a == false) goto L5;
        FrameLayout.mergeDrawableStates(r3, b);
    L5:
        return r3;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r2) {
        if (this.a == r2) goto L6;
        this.a = r2;
        refreshDrawableState();
        return;
    }
}
