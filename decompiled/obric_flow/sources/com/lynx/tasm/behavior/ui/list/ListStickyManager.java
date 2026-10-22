package com.lynx.tasm.behavior.ui.list;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ies.bullet.service.base.c;
import com.lynx.base.log.LynxLog;
import en.g;

/* JADX INFO: loaded from: classes2.dex */
public class ListStickyManager extends RecyclerView.OnScrollListener implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UIList f10506a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f10507b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f10508c;
    public final c d;
    public boolean e;

    public ListStickyManager(UIList r5) {
        this.e = true;
        this.f10506a = r5;
        this.f10507b = new g(this, r5.getLynxContext());
        this.f10508c = new c(10);
        this.d = new c(10);
        r5.g().addOnScrollListener(this);
        r5.g().addOnAttachStateChangeListener(this);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r5) {
        g r10 = this.f10507b;
        if (r10.indexOfChild(r5) < 0) goto L5;
        return;
    L5:
        r10.getClass();
        ViewGroup r11 = (ViewGroup) r5.getParent();
        if (r11 != null) goto L9;
        LynxLog.b(4, "ListStickyManager", "addRecyclerView failed, parent is null.");
        return;
    L9:
        int r12 = r11.indexOfChild(r5);
        r11.removeViewAt(r12);
        r10.addView(r5, new FrameLayout.LayoutParams(-1, -1));
        r11.addView(r10, r12);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r5) {
    }
}
