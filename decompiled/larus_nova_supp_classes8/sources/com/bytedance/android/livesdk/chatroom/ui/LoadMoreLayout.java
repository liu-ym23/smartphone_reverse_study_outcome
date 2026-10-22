package com.bytedance.android.livesdk.chatroom.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParentHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0017B\u0011\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010B\u001b\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u000f\u0010\u0013B#\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u000f\u0010\u0016J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/LoadMoreLayout;", "Landroid/widget/LinearLayout;", "Landroidx/core/view/NestedScrollingParent2;", "Landroid/view/View;", "footView", "", "setFootView", "Lcom/bytedance/android/livesdk/chatroom/ui/LoadMoreLayout$a;", "loadMoreCallback", "setLoadMoreCallback", "", "enableLoadMore", "setEnableLoadMore", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "liveui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LoadMoreLayout extends LinearLayout implements NestedScrollingParent2 {
    public final NestedScrollingParentHelper a;
    public a b;
    public View c;
    public final int[] d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;

    public interface a {
        void a();

        void b();

        void c();

        void onLoading();
    }

    public LoadMoreLayout(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public final void setEnableLoadMore(boolean r1) {
        this.g = r1;
    }

    public final void setFootView(View r2) {
        Intrinsics.checkNotNullParameter(r2, "footView");
        this.c = r2;
    }

    public final void setLoadMoreCallback(a r2) {
        Intrinsics.checkNotNullParameter(r2, "loadMoreCallback");
        this.b = r2;
    }

    public LoadMoreLayout(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    public final void a(int r5, int r6) {
        if (this.i == true) goto L8;
        a r7 = this.b;
        if (r7 == null) goto L7;
        r7.b();
    L7:
        this.i = true;
    L8:
        View r8 = this.c;
        if (r8 != null) goto L11;
        return;
    L11:
        if (this.e == false) goto L20;
        if ((getScrollY() + r6) < r8.getMeasuredHeight()) goto L16;
        return;
    L16:
        if ((getScrollY() + r6) > 0) goto L18;
        r6 = -getScrollY();
    L18:
        this.f = false;
        scrollBy(0, r6);
        invalidate();
        return;
    L20:
        if ((getScrollY() + r6) < r8.getMeasuredHeight()) goto L28;
        r6 = r8.getMeasuredHeight() - getScrollY();
        if (this.f == true) goto L26;
        a r9 = this.b;
        if (r9 == null) goto L26;
        r9.c();
    L26:
        this.f = true;
    L30:
        scrollBy(0, r6);
        invalidate();
        return;
    L28:
        if ((getScrollY() + r6) >= 0) goto L30;
        r6 = -getScrollY();
        goto L30
    }

    public final void onStopNestedScroll(View r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "target");
        boolean r5 = this.f;
        this.e = r5;
        if (r5 == true) goto L5;
    L13:
        this.e = false;
        if (getScrollY() > 0) goto L16;
    L18:
        a r6 = this.b;
        if (r6 == null) goto L21;
        r6.a();
    L21:
        this.i = false;
        NestedScrollingParentHelper r7 = this.a;
        if (r7 == null) goto L24;
        r7.onStopNestedScroll(r3);
    L24:
        stopNestedScroll();
        return;
    L16:
        if (this.e == true) goto L18;
        a(0, -getScrollY());
        goto L18
    L5:
        if (this.h == true) goto L13;
        int r8 = getScrollY();
        View r1 = this.c;
        if (r1 == null) goto L13;
        if (r8 != r1.getMeasuredHeight()) goto L13;
        this.h = true;
        a r9 = this.b;
        if (r9 == null) goto L21;
        r9.onLoading();
        goto L21
    }

    public LoadMoreLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.d = new int[2];
        this.g = true;
        this.a = new NestedScrollingParentHelper(this);
    }

    public final void onNestedScrollAccepted(View r2, View r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "child");
        Intrinsics.checkNotNullParameter(r3, "target");
        NestedScrollingParentHelper r0 = this.a;
        if (r0 == null) goto L6;
        r0.onNestedScrollAccepted(r2, r3, r4, r5);
        return;
    }

    public final boolean onStartNestedScroll(View r1, View r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "child");
        Intrinsics.checkNotNullParameter(r2, "target");
        if (this.g == false) goto L6;
        if (r4 != 0) goto L6;
        return true;
    L6:
        return false;
    }

    public final void onNestedPreScroll(View r1, int r2, int r3, int[] r4, int r5) {
        Intrinsics.checkNotNullParameter(r1, "target");
        Intrinsics.checkNotNullParameter(r4, "consumed");
        if (r3 < 0) goto L5;
    L7:
        dispatchNestedPreScroll(r2, r3, r4, this.d);
        return;
    L5:
        if (getScrollY() <= 0) goto L7;
        a(r2, r3);
        r4[1] = r3;
    }

    public final void onNestedScroll(View r7, int r8, int r9, int r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r7, "target");
        if (r9 != 0) goto L6;
        if (r11 <= 0) goto L6;
        a(r10, r11);
        return;
    L6:
        dispatchNestedScroll(r8, r9, r10, r11, this.d);
    }
}
