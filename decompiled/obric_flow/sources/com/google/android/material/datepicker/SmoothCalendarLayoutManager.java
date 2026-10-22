package com.google.android.material.datepicker;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes2.dex */
class SmoothCalendarLayoutManager extends LinearLayoutManager {
    private static final float MILLISECONDS_PER_INCH = 100.0f;

    public SmoothCalendarLayoutManager(Context r5, int r10, boolean r11) {
        super(r5, r10, r11);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView r5, RecyclerView.State r10, int r11) {
        final Context r12 = r5.getContext();
        LinearSmoothScroller r13 = new AnonymousClass1(this, r12);
        r13.setTargetPosition(r11);
        startSmoothScroll(r13);
    }
}
