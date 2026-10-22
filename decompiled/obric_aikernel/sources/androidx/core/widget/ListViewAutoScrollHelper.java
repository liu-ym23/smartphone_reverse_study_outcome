package androidx.core.widget;

import android.widget.ListView;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class ListViewAutoScrollHelper extends AutoScrollHelper {
    private final ListView mTarget;

    public ListViewAutoScrollHelper(@NonNull ListView r10) {
        super(r10);
        this.mTarget = r10;
    }

    @Override // androidx.core.widget.AutoScrollHelper
    public boolean canTargetScrollHorizontally(int r10) {
        return false;
    }

    @Override // androidx.core.widget.AutoScrollHelper
    public boolean canTargetScrollVertically(int r10) {
        ListView r11 = this.mTarget;
        int r12 = r11.getCount();
        if (r12 != 0) goto L5;
        return false;
    L5:
        int r13 = r11.getChildCount();
        int r14 = r11.getFirstVisiblePosition();
        int r15 = r14 + r13;
        if (r10 <= 0) goto L11;
        if (r15 >= r12) goto L9;
    L16:
        return true;
    L9:
        if (r11.getChildAt(r13 - 1).getBottom() > r11.getHeight()) goto L16;
        return false;
    L11:
        if (r10 >= 0) goto L17;
        if (r14 > 0) goto L16;
        if (r11.getChildAt(0).getTop() < 0) goto L16;
        return false;
    L17:
        return false;
    }

    @Override // androidx.core.widget.AutoScrollHelper
    public void scrollTargetBy(int r10, int r11) {
        ListViewCompat.scrollListBy(this.mTarget, r11);
    }
}
