package com.larus.bmhome.chat.markdown.code;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\r2\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010#\u001a\u00020\r2\u0006\u0010 \u001a\u00020!H\u0016R(\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/larus/bmhome/chat/markdown/code/CodeRenderGestureLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onLongPressCallback", "Lkotlin/Function1;", "Landroid/view/View;", "", "getOnLongPressCallback", "()Lkotlin/jvm/functions/Function1;", "setOnLongPressCallback", "(Lkotlin/jvm/functions/Function1;)V", "blockParentHorizontalScroll", "getBlockParentHorizontalScroll", "()Z", "setBlockParentHorizontalScroll", "(Z)V", "longPressTriggered", "touchSlop", "initialX", "", "initialY", "scrollDirectionDecided", "gestureDetector", "Landroid/view/GestureDetector;", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "onInterceptTouchEvent", "onTouchEvent", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class CodeRenderGestureLayout extends FrameLayout {
    public Function1<? super View, Boolean> a;
    public boolean b;
    public boolean c;
    public final int d;
    public float e;
    public float f;
    public boolean g;
    public final GestureDetector h;

    public static final class a extends GestureDetector.SimpleOnGestureListener {
        public final /* synthetic */ CodeRenderGestureLayout a;

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onDown(MotionEvent r2) {
            Intrinsics.checkNotNullParameter(r2, "e");
            return true;
        }

        public a(CodeRenderGestureLayout r1) {
            this.a = r1;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final void onLongPress(MotionEvent r3) {
            Intrinsics.checkNotNullParameter(r3, "e");
            CodeRenderGestureLayout r4 = this.a;
            Function1<View, Boolean> r0 = r4.getOnLongPressCallback();
            if (r0 == null) goto L5;
            boolean r1 = ((Boolean) r0.invoke(this.a)).booleanValue();
        L6:
            r4.c = r1;
            return;
        L5:
            r1 = false;
            goto L6
        }
    }

    public CodeRenderGestureLayout(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CodeRenderGestureLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final boolean getBlockParentHorizontalScroll() {
        return this.b;
    }

    public final Function1<View, Boolean> getOnLongPressCallback() {
        return this.a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r7) {
        Intrinsics.checkNotNullParameter(r7, "event");
        int r0 = r7.getActionMasked();
        boolean r1 = true;
        if (r0 != 0) goto L5;
        this.c = false;
        this.e = r7.getX();
        this.f = r7.getY();
        this.g = false;
        if (this.b == false) goto L27;
        ViewParent r2 = getParent();
        if (r2 == null) goto L27;
        r2.requestDisallowInterceptTouchEvent(true);
    L27:
        this.h.onTouchEvent(r7);
        return super.dispatchTouchEvent(r7);
    L5:
        if (r0 != 2) goto L27;
        if (this.b == false) goto L27;
        if (this.g == true) goto L27;
        float r3 = Math.abs(r7.getX() - this.e);
        float r4 = Math.abs(r7.getY() - this.f);
        int r5 = this.d;
        if (r3 <= r5) goto L14;
    L15:
        this.g = true;
        ViewParent r6 = getParent();
        if (r6 == null) goto L27;
        if (r3 >= r4) goto L21;
        r1 = false;
    L21:
        r6.requestDisallowInterceptTouchEvent(r1);
        goto L27
    L14:
        if (r4 <= r5) goto L27;
        goto L15
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        return this.c;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        if (this.c == false) goto L10;
        if (isPressed() == false) goto L11;
        setPressed(false);
        return true;
    L11:
        return true;
    L10:
        return super.onTouchEvent(r2);
    }

    public final void setBlockParentHorizontalScroll(boolean r1) {
        this.b = r1;
    }

    public final void setOnLongPressCallback(Function1<? super View, Boolean> r1) {
        this.a = r1;
    }

    public CodeRenderGestureLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.d = ViewConfiguration.get(r2).getScaledTouchSlop();
        this.h = new GestureDetector(r2, new a(this));
    }

    public /* synthetic */ CodeRenderGestureLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
