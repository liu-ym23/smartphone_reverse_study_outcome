package com.bytedance.android.livesdk.feed.drawerfeed;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ew1.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/feed/drawerfeed/DrawerHistoryRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livefeed_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DrawerHistoryRecyclerView extends RecyclerView {
    public int a;
    public int b;
    public boolean c;

    public DrawerHistoryRecyclerView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public DrawerHistoryRecyclerView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchTouchEvent(MotionEvent r9) {
        Intrinsics.checkNotNullParameter(r9, "ev");
        int r0 = r9.getAction();
        if (r0 != 0) goto L5;
        this.a = (int) r9.getX();
        this.b = (int) r9.getY();
        getParent().requestDisallowInterceptTouchEvent(true);
        this.c = false;
    L31:
        return super/*android.view.ViewGroup*/.dispatchTouchEvent(r9);
    L5:
        if (r0 != 2) goto L31;
        int r1 = (int) r9.getX();
        int r3 = (int) r9.getY();
        int r4 = Math.abs(r1 - this.a);
        int r5 = Math.abs(r3 - this.b);
        RecyclerView.LayoutManager r6 = getLayoutManager();
        if ((r6 instanceof LinearLayoutManager) == true) goto L10;
        r6 = null;
    L10:
        LinearLayoutManager r7 = (LinearLayoutManager) r6;
        if (r7 == null) goto L31;
        int r8 = r7.findLastCompletelyVisibleItemPosition();
        int r10 = r7.findFirstCompletelyVisibleItemPosition();
        int r11 = r7.getItemCount();
        if (r4 > r5) goto L15;
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L31
    L15:
        if (r8 == (r11 - 1)) goto L17;
    L21:
        if (r10 == 0) goto L23;
    L27:
        getParent().requestDisallowInterceptTouchEvent(true);
        this.c = true;
        goto L31
    L23:
        if (this.a >= r1) goto L27;
        if (this.c == true) goto L27;
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L31
    L17:
        if (this.a <= r1) goto L21;
        if (this.c == true) goto L21;
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L31
    }

    public final void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        b.a("onMeasure", th);
    }

    public DrawerHistoryRecyclerView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ DrawerHistoryRecyclerView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        b.a("onLayout", th);
    }
}
