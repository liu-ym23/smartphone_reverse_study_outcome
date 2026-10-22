package com.obric.oui.scrollbar;

import android.util.Log;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f7221a = null;

    static {
        f7221a = new a();
    }

    private a() {
    }

    public static final /* synthetic */ void a(a r10, RecyclerView r11, float r12, String r13) {
        r10.c(r11, r12, r13);
    }

    public static final /* synthetic */ void b(a r10, RecyclerView r11, float r12, int r13) {
        r10.d(r11, r12, r13);
    }

    private final void c(RecyclerView r10, float r11, String r12) {
        RecyclerView.LayoutManager r13 = r10.getLayoutManager();
        if ((r13 instanceof LinearLayoutManager) == true) goto L5;
        r13 = null;
    L5:
        LinearLayoutManager r14 = (LinearLayoutManager) r13;
        if (r14 == null) goto L22;
        int r15 = r14.findFirstVisibleItemPosition();
        int r16 = r14.findLastVisibleItemPosition();
        boolean r17 = true;
        int r18 = (r16 - r15) + 1;
        RecyclerView.Adapter r19 = r10.getAdapter();
        if (r19 == null) goto L10;
        int r20 = r19.getItemCount();
    L12:
        if (r18 <= 0) goto L15;
        if (r20 <= 0) goto L15;
        float r21 = r20 / r18;
    L17:
        if (r21 >= r11) goto L20;
        r17 = false;
    L20:
        r10.setVerticalScrollBarEnabled(r17);
        Log.d("RecyclerViewScrollBarHelper", "updateScrollBarVisibilityByItemCount, scene: " + r12 + ", isVerticalScrollBarEnabled: " + r10.isVerticalScrollBarEnabled() + ", estimatedScreens: " + r21 + ", totalItemCount: " + r20 + ", visibleItemCount: " + r18 + ", firstVisibleItemPosition: " + r15 + ", lastVisibleItemPosition: " + r16);
        return;
    L15:
        Log.e("RecyclerViewScrollBarHelper", "updateScrollBarVisibilityByItemCount, error! totalItemCount: " + r20 + ", visibleItemCount: " + r18);
        r21 = 0.0f;
        goto L17
    L10:
        r20 = 0;
        goto L12
    }

    private final void d(RecyclerView r10, float r11, int r12) {
        int r13 = r10.computeVerticalScrollExtent();
        if (r13 <= 0) goto L6;
        if (r12 <= 0) goto L6;
        float r14 = r12 / r13;
    L8:
        if (r14 < r11) goto L10;
        boolean r15 = true;
    L12:
        if (r10.isVerticalScrollBarEnabled() == r15) goto L14;
        r10.setVerticalScrollBarEnabled(r15);
    L14:
        Log.d("RecyclerViewScrollBarHelper", "updateScrollBarWithStableHeight, isVerticalScrollBarEnabled: " + r10.isVerticalScrollBarEnabled() + ", contentScreens: " + r14 + ", contentHeight: " + r12 + ", visibleHeight: " + r13);
        return;
    L10:
        r15 = false;
    L6:
        r14 = 0.0f;
        goto L8
    }
}
