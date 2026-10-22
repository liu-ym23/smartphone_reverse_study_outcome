package androidx.core.widget;

import android.widget.ListView;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class ListViewAutoScrollHelper extends AutoScrollHelper {
    private final ListView mTarget;

    public ListViewAutoScrollHelper(@NonNull ListView r5) {
        super(r5);
        this.mTarget = r5;
    }

    @Override // androidx.core.widget.AutoScrollHelper
    public boolean canTargetScrollHorizontally(int r5) {
        return false;
    }

    @Override // androidx.core.widget.AutoScrollHelper
    public boolean canTargetScrollVertically(int r10) {
        ListView r11 = this.mTarget;
        int r5 = r11.getCount();
        if (r5 != 0) goto L5;
        return false;
    L5:
        int r12 = r11.getChildCount();
        int r13 = r11.getFirstVisiblePosition();
        int r14 = r13 + r12;
        if (r10 <= 0) goto L11;
        if (r14 >= r5) goto L9;
    L16:
        return true;
    L9:
        if (r11.getChildAt(r12 - 1).getBottom() > r11.getHeight()) goto L16;
        return false;
    L11:
        if (r10 >= 0) goto L17;
        if (r13 > 0) goto L16;
        if (r11.getChildAt(0).getTop() < 0) goto L16;
        return false;
    L17:
        return false;
    }

    @Override // androidx.core.widget.AutoScrollHelper
    public void scrollTargetBy(int r5, int r10) {
        this.mTarget.scrollListBy(r10);
    }
}
