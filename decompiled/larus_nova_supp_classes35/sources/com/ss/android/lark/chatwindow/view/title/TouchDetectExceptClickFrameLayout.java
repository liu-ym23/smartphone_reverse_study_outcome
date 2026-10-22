package com.ss.android.lark.chatwindow.view.title;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001 \u0018\u0000 &2\u00020\u0001:\u0001&B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020$H\u0016R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0004\n\u0002\u0010!¨\u0006'"}, d2 = {"Lcom/ss/android/lark/chatwindow/view/title/TouchDetectExceptClickFrameLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "def", BuildConfig.FLAVOR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "flingOrScroll", BuildConfig.FLAVOR, "getFlingOrScroll", "()Z", "setFlingOrScroll", "(Z)V", "enableTouchMoveCheck", "getEnableTouchMoveCheck", "setEnableTouchMoveCheck", "listener", "Lcom/ss/android/lark/chatwindow/view/title/TouchDetectFrameLayout$OnTouchEventDetectedListener;", "getListener", "()Lcom/ss/android/lark/chatwindow/view/title/TouchDetectFrameLayout$OnTouchEventDetectedListener;", "setListener", "(Lcom/ss/android/lark/chatwindow/view/title/TouchDetectFrameLayout$OnTouchEventDetectedListener;)V", "gestureDetector", "Landroid/view/GestureDetector;", "getGestureDetector", "()Landroid/view/GestureDetector;", "gestureDetector$delegate", "Lkotlin/Lazy;", "gestureListener", "com/ss/android/lark/chatwindow/view/title/TouchDetectExceptClickFrameLayout$gestureListener$1", "Lcom/ss/android/lark/chatwindow/view/title/TouchDetectExceptClickFrameLayout$gestureListener$1;", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "dispatchTouchEvent", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TouchDetectExceptClickFrameLayout extends FrameLayout {
    public boolean a;
    public boolean b;
    public final Lazy c;
    public final b d;

    public static final class a {
    }

    public static final class b extends GestureDetector.SimpleOnGestureListener {
        public final /* synthetic */ TouchDetectExceptClickFrameLayout a;
        public final /* synthetic */ Context b;

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onSingleTapUp(MotionEvent r2) {
            Intrinsics.checkNotNullParameter(r2, "e");
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onDown(MotionEvent r2) {
            Intrinsics.checkNotNullParameter(r2, "e");
            this.a.setFlingOrScroll(false);
            return false;
        }

        public b(TouchDetectExceptClickFrameLayout r1, Context r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onFling(MotionEvent r7, MotionEvent r8, float r9, float r10) {
            Intrinsics.checkNotNullParameter(r8, "e2");
            if (r7 != null) goto L5;
            return false;
        L5:
            this.a.setFlingOrScroll(true);
            if (this.a.getEnableTouchMoveCheck() == true) goto L9;
            return false;
        L9:
            if ((r7.getY() - r8.getY()) <= UIUtils.dp2px(this.b, 10.0f)) goto L15;
            if (Math.abs(r10) <= 100.0f) goto L15;
            Log.d("TouchDetectFrameLayout", "fling up");
            this.a.getListener();
            return true;
        L15:
            if ((r8.getY() - r7.getY()) > UIUtils.dp2px(this.b, 10.0f)) goto L17;
        L20:
            return false;
        L17:
            if (Math.abs(r10) <= 100.0f) goto L20;
            Log.d("TouchDetectFrameLayout", "fling down");
            this.a.getListener();
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onScroll(MotionEvent r5, MotionEvent r6, float r7, float r8) {
            Intrinsics.checkNotNullParameter(r6, "e2");
            if (r5 != null) goto L5;
            return false;
        L5:
            this.a.setFlingOrScroll(true);
            if (this.a.getEnableTouchMoveCheck() == true) goto L9;
            return false;
        L9:
            if ((r5.getY() - r6.getY()) <= UIUtils.dp2px(this.b, 10.0f)) goto L13;
            Log.d("TouchDetectFrameLayout", "scroll up");
            this.a.getListener();
            return true;
        L13:
            if ((r6.getY() - r5.getY()) <= UIUtils.dp2px(this.b, 10.0f)) goto L16;
            Log.d("TouchDetectFrameLayout", "scroll down");
            this.a.getListener();
            return true;
        L16:
            return false;
        }
    }

    static {
    }

    public TouchDetectExceptClickFrameLayout(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public TouchDetectExceptClickFrameLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final TouchDetectFrameLayout.b getListener() {
        return null;
    }

    public final void setListener(TouchDetectFrameLayout.b r1) {
    }

    private final GestureDetector getGestureDetector() {
        return (GestureDetector) this.c.getValue();
    }

    public final boolean getEnableTouchMoveCheck() {
        return this.b;
    }

    public final boolean getFlingOrScroll() {
        return this.a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "ev");
        getGestureDetector().onTouchEvent(r2);
        return super.dispatchTouchEvent(r2);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "ev");
        if (r3.getAction() != 0) goto L6;
        this.a = false;
    L11:
        return super.onInterceptTouchEvent(r3);
    L6:
        if (r3.getAction() != 1) goto L11;
        if (this.a == false) goto L11;
        return true;
    }

    public final void setEnableTouchMoveCheck(boolean r1) {
        this.b = r1;
    }

    public final void setFlingOrScroll(boolean r1) {
        this.a = r1;
    }

    public TouchDetectExceptClickFrameLayout(final Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.c = LazyKt.lazy(new TouchDetectExceptClickFrameLayout$gestureDetector$2(r2, this));
        this.d = new b(this, r2);
    }

    public /* synthetic */ TouchDetectExceptClickFrameLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
