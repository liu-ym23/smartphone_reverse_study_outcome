package kq;

import android.os.SystemClock;
import android.view.MotionEvent;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.obric.flow.cardlistpage.ui.drag.DragInsertRecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DragInsertRecyclerView f19460a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ItemTouchHelper f19461b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f19462c;
    public boolean d;

    public b(DragInsertRecyclerView r5, ItemTouchHelper r10) {
        Intrinsics.checkNotNullParameter(r5, "rv");
        Intrinsics.checkNotNullParameter(r10, "helper");
        this.f19460a = r5;
        this.f19461b = r10;
    }

    public static void a(b r11, float r12, float r13) {
        if (r11.d == false) goto L7;
        r11.d = false;
        int[] r5 = new int[2];
        DragInsertRecyclerView r10 = r11.f19460a;
        r10.getLocationOnScreen(r5);
        float r14 = r12 - r5[0];
        float r15 = r13 - r5[1];
        MotionEvent r16 = MotionEvent.obtain(r11.f19462c, SystemClock.uptimeMillis(), 1, r14, r15, 0);
        Intrinsics.checkNotNull(r16);
        r10.a(r16);
        r16.recycle();
        return;
    }
}
