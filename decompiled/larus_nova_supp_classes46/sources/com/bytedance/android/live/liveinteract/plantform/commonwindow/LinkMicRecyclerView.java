package com.bytedance.android.live.liveinteract.plantform.commonwindow;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006H\u0016¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/LinkMicRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "", "noTouch", "", "setNoTouch", "", "translationX", "setTranslationX", "translationY", "setTranslationY", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public class LinkMicRecyclerView extends RecyclerView {
    public static final /* synthetic */ int e = 0;
    public boolean a;
    public Rect b;
    public int c;
    public final List<Function1<Rect, Unit>> d;

    public LinkMicRecyclerView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public LinkMicRecyclerView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final boolean onTouchEvent(MotionEvent r2) {
        if (this.a == false) goto L7;
        return false;
    L7:
        return super.onTouchEvent(r2);
    }

    public final void setNoTouch(boolean r1) {
        this.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setTranslationX(float r5) {
        super/*android.view.ViewGroup*/.setTranslationX(r5);
        int r6 = (int) r5;
        r(getLeft() + r6, getTop() + ((int) getTranslationY()), getRight() + r6, getBottom() + ((int) getTranslationY()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setTranslationY(float r5) {
        super/*android.view.ViewGroup*/.setTranslationY(r5);
        int r6 = (int) r5;
        r(getLeft() + ((int) getTranslationX()), getTop() + r6, getRight() + ((int) getTranslationX()), getBottom() + r6);
    }

    public LinkMicRecyclerView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.b = new Rect(0, 0, 0, 0);
        this.d = new ArrayList();
    }

    public /* synthetic */ LinkMicRecyclerView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void r(int r3, int r4, int r5, int r6) {
        Rect r0 = this.b;
        Intrinsics.checkNotNullParameter(r0, "$this$equals");
        if (r0.left == r3) goto L5;
    L11:
        boolean r1 = false;
    L12:
        if (r1 == true) goto L14;
    L17:
        Rect r2 = this.b;
        int r7 = r2.left;
        int r8 = r2.top;
        int r9 = r2.right;
        int r10 = r2.bottom;
        this.b = new Rect(r3, r4, r5, r6);
        this.c = getChildCount();
        List<Function1<Rect, Unit>> r11 = this.d;
        if (r11 == null) goto L26;
        Iterator<T> r12 = r11.iterator();
    L21:
        if (r12.hasNext() == false) goto L27;
        ((Function1) r12.next()).invoke(this.b);
        goto L21
    L27:
        return;
    L26:
        return;
    L14:
        if (getChildCount() != this.c) goto L16;
        return;
    L16:
        if (getChildCount() != 0) goto L17;
        return;
    L5:
        if (r0.top != r4) goto L11;
        if (r0.right != r5) goto L11;
        if (r0.bottom != r6) goto L11;
        r1 = true;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        r(getLeft() + ((int) getTranslationX()), getTop() + ((int) getTranslationY()), getRight() + ((int) getTranslationX()), getBottom() + ((int) getTranslationY()));
    }
}
