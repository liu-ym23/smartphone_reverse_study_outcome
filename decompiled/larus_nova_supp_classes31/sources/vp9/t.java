package vp9;

import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.photopicker.v2.impl.viewmodel.MediaSelectorViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class t extends GestureDetector.SimpleOnGestureListener {
    public final RecyclerView a;
    public final MediaSelectorViewModel b;

    public t(RecyclerView r2, MediaSelectorViewModel r3) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        Intrinsics.checkNotNullParameter(r3, "mediaSelectorViewModel");
        this.a = r2;
        this.b = r3;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent r6, MotionEvent r7, float r8, float r9) {
        Intrinsics.checkNotNullParameter(r7, "e2");
        if (r9 >= 0.0f) goto L5;
        boolean r0 = true;
    L7:
        if ((!this.a.canScrollVertically(-1)) == false) goto L11;
        if (r0 == false) goto L11;
        this.b.notifyRecyclerViewCanScroll(false);
        return true;
    L11:
        this.b.notifyRecyclerViewCanScroll(true);
        return super.onScroll(r6, r7, r8, r9);
    L5:
        r0 = false;
        goto L7
    }
}
