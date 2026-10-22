package com.bytedance.android.ec.core.jedi;

import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.deepfeed.ui.DeepFeedProductRecyclerview;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/ec/core/jedi/PullUpLoadMoreHelper;", "Landroidx/recyclerview/widget/RecyclerView$OnItemTouchListener;", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PullUpLoadMoreHelper implements RecyclerView.OnItemTouchListener {
    public boolean a;
    public boolean b;
    public final int c;
    public float d;
    public final RecyclerView e;
    public final Function0<Unit> f;

    public final void onRequestDisallowInterceptTouchEvent(boolean r1) {
    }

    public final void onTouchEvent(RecyclerView r10, MotionEvent r11) {
        Intrinsics.checkNotNullParameter(r10, "recyclerView");
        Intrinsics.checkNotNullParameter(r11, "motionEvent");
    }

    public PullUpLoadMoreHelper(DeepFeedProductRecyclerview r1, Function0 r10) {
        this.e = r1;
        this.f = r10;
        Intrinsics.checkNotNull(r1);
        this.c = ViewConfiguration.get(r1.getContext()).getScaledTouchSlop();
        r1.addOnItemTouchListener(this);
    }

    public final boolean onInterceptTouchEvent(RecyclerView r10, MotionEvent r11) {
        Intrinsics.checkNotNullParameter(r10, "recyclerView");
        Intrinsics.checkNotNullParameter(r11, "event");
        if (r11.getAction() != 0) goto L5;
        this.d = r11.getY();
        this.b = true;
    L5:
        RecyclerView r12 = this.e;
        if (r12 != null) goto L8;
    L19:
        return false;
    L8:
        if (this.a == false) goto L19;
        if (this.b == false) goto L19;
        if (r12.canScrollVertically(1) == true) goto L19;
        if ((this.d - r11.getY()) <= this.c) goto L19;
        Function0<Unit> r13 = this.f;
        if (r13 == null) goto L18;
        Unit r14 = (Unit) r13.invoke();
    L18:
        this.a = false;
        this.b = false;
        goto L19
    }
}
