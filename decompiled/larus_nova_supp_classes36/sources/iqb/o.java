package iqb;

import androidx.core.widget.NestedScrollView;
import com.ss.android.lark.location_ui.picklocation.LocationView;
import com.ss.android.lark.location_ui.picklocation.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class o implements NestedScrollView.OnScrollChangeListener {
    public final /* synthetic */ LocationView a;

    public o(LocationView r1) {
        this.a = r1;
    }

    public final void onScrollChange(NestedScrollView r1, int r2, int r3, int r4, int r5) {
        if (r3 != (r1.getChildAt(0).getMeasuredHeight() - r1.getMeasuredHeight())) goto L6;
        LocationView r6 = this.a;
        r6.k.w6(r6.b, r6.e, new r(r6), r6.p);
        return;
    }
}
