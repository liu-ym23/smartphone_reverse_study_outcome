package com.ss.android.lark.chat.chatwindow.biz.component.keyboard.coordinate;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.ss.android.lark.widget.recyclerview.CommonRecyclerView;
import com.ss.android.lark.widget.recyclerview.PointRecoderRecyclerView;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001(B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000bJ\u0012\u0010\u001d\u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001f\u001a\u00020\u001bH\u0014J\b\u0010 \u001a\u00020\u001bH\u0014J\u000e\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u0007J\u0018\u0010#\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0007H\u0014J\u0006\u0010&\u001a\u00020'R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/biz/component/keyboard/coordinate/SceneCoordinateRecyclerView;", "Lcom/ss/android/lark/widget/recyclerview/PointRecoderRecyclerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", BuildConfig.FLAVOR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isInAnimation", BuildConfig.FLAVOR, "()Z", "setInAnimation", "(Z)V", "interceptAllTouch", "viewLifecycleInterface", "Lcom/ss/android/lark/chat/chatwindow/biz/component/keyboard/coordinate/SceneCoordinateRecyclerView$ViewLifecycleInterface;", "getViewLifecycleInterface", "()Lcom/ss/android/lark/chat/chatwindow/biz/component/keyboard/coordinate/SceneCoordinateRecyclerView$ViewLifecycleInterface;", "setViewLifecycleInterface", "(Lcom/ss/android/lark/chat/chatwindow/biz/component/keyboard/coordinate/SceneCoordinateRecyclerView$ViewLifecycleInterface;)V", "extraHeight", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "setInterceptAllTouchEvent", BuildConfig.FLAVOR, "intercept", "onInterceptTouchEvent", "e", "onAttachedToWindow", "onDetachedFromWindow", "setExtraHeight", "height", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "computeBlankRegionOfRv", BuildConfig.FLAVOR, "ViewLifecycleInterface", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SceneCoordinateRecyclerView extends PointRecoderRecyclerView {
    public boolean l;
    public boolean m;
    public a n;
    public int o;

    public interface a {
        void onAttachedToWindow();

        void onDetachedFromWindow();
    }

    public SceneCoordinateRecyclerView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public SceneCoordinateRecyclerView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void onAttachedToWindow() {
        super/*com.ss.android.lark.widget.recyclerview.CommonRecyclerView*/.onAttachedToWindow();
        a r0 = this.n;
        if (r0 == null) goto L6;
        r0.onAttachedToWindow();
        return;
    }

    public final void onDetachedFromWindow() {
        super/*com.ss.android.lark.widget.recyclerview.CommonRecyclerView*/.onDetachedFromWindow();
        a r0 = this.n;
        if (r0 == null) goto L6;
        r0.onDetachedFromWindow();
        return;
    }

    public final a getViewLifecycleInterface() {
        return this.n;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchTouchEvent(MotionEvent r3) {
        if (this.l == false) goto L9;
        if (Math.abs(getTranslationY()) <= 0.0f) goto L9;
        if (r3 == null) goto L9;
        r3.offsetLocation(0.0f, getTranslationY());
    L9:
        return super/*android.view.ViewGroup*/.dispatchTouchEvent(r3);
    }

    public final boolean onInterceptTouchEvent(MotionEvent r2) {
        boolean r3 = super.onInterceptTouchEvent(r2);
        if (this.m == false) goto L6;
        return true;
    L6:
        return r3;
    }

    public final void setExtraHeight(int r1) {
        this.o = r1;
        requestLayout();
    }

    public final void setInAnimation(boolean r1) {
        this.l = r1;
    }

    public final void setInterceptAllTouchEvent(boolean r1) {
        this.m = r1;
    }

    public final void setViewLifecycleInterface(a r1) {
        this.n = r1;
    }

    public final void onMeasure(int r3, int r4) {
        int r0 = View.MeasureSpec.getSize(r4);
        if (this.o <= 0) goto L6;
        if (r0 <= 0) goto L6;
        int r5 = View.MeasureSpec.getMode(r4);
        r4 = View.MeasureSpec.makeMeasureSpec(r0 + this.o, r5);
    L6:
        super.onMeasure(r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SceneCoordinateRecyclerView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        ((CommonRecyclerView) this).h = false;
        setTag(SceneCoordinateRecyclerView.class);
    }

    public /* synthetic */ SceneCoordinateRecyclerView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
