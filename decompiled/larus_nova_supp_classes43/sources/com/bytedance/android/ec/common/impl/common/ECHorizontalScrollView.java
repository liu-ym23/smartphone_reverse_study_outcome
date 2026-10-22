package com.bytedance.android.ec.common.impl.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewTreeObserver;
import android.widget.HorizontalScrollView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0014\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/ec/common/impl/common/ECHorizontalScrollView;", "Landroid/widget/HorizontalScrollView;", "Lkotlin/Function0;", "", "listener", "setOnScrollBeginListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECHorizontalScrollView extends HorizontalScrollView {
    public boolean a;
    public Function0<Unit> b;
    public int c;

    public static final class a implements ViewTreeObserver.OnScrollChangedListener {
        public final /* synthetic */ ECHorizontalScrollView a;

        public a(ECHorizontalScrollView r1) {
            this.a = r1;
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public final void onScrollChanged() {
            int r0 = this.a.getScrollX();
            ECHorizontalScrollView r1 = this.a;
            if (r0 != r1.c) goto L5;
            return;
        L5:
            if (r1.a == false) goto L11;
            r1.c = r1.getScrollX();
            ECHorizontalScrollView r10 = this.a;
            r10.a = false;
            Function0<Unit> r11 = r10.b;
            if (r11 == null) goto L12;
            Unit r12 = (Unit) r11.invoke();
            return;
        L12:
            return;
        }
    }

    public ECHorizontalScrollView(Context r10) {
        AttributeSet r11 = null;
        this(r10, r11, 6, 0);
    }

    public ECHorizontalScrollView(Context r10, AttributeSet r11) {
        this(r10, r11, 4, 0);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public final boolean onTouchEvent(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "ev");
        if (r10.getAction() != 0) goto L6;
        this.a = true;
    L6:
        return super.onTouchEvent(r10);
    }

    public final void setOnScrollBeginListener(Function0<Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "listener");
        this.b = r10;
    }

    public ECHorizontalScrollView(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        this.c = -1;
        getViewTreeObserver().addOnScrollChangedListener(new a(this));
    }

    public /* synthetic */ ECHorizontalScrollView(Context r1, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r1, r10, 0);
    }
}
