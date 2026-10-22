package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/mviview/adapter/RecyclerViewScrollInterceptor;", "Landroidx/recyclerview/widget/RecyclerView$OnItemTouchListener;", "Landroid/content/Context;", "b", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RecyclerViewScrollInterceptor implements RecyclerView.OnItemTouchListener {
    public final GestureDetector a;
    public final Context b;
    public final Function2<Float, Float, Boolean> c;

    public static final class a extends GestureDetector.SimpleOnGestureListener {
        public final /* synthetic */ RecyclerViewScrollInterceptor a;

        public a(RecyclerViewScrollInterceptor r1) {
            this.a = r1;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onScroll(MotionEvent r1, MotionEvent r2, float r3, float r4) {
            Intrinsics.checkNotNullParameter(r2, "e2");
            if (((Boolean) this.a.c.invoke(Float.valueOf(r3), Float.valueOf(r4))).booleanValue() == false) goto L6;
            return true;
        L6:
            return false;
        }
    }

    public final void onRequestDisallowInterceptTouchEvent(boolean r1) {
    }

    public final void onTouchEvent(RecyclerView r2, MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r2, "rv");
        Intrinsics.checkNotNullParameter(r3, "e");
    }

    public final Context getContext() {
        return this.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RecyclerViewScrollInterceptor(Context r2, Function2<? super Float, ? super Float, Boolean> r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "onScrolledIntercept");
        this.b = r2;
        this.c = r3;
        this.a = new GestureDetector(r2, new a(this));
    }

    public final boolean onInterceptTouchEvent(RecyclerView r2, MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r2, "rv");
        Intrinsics.checkNotNullParameter(r3, "e");
        return this.a.onTouchEvent(r3);
    }
}
