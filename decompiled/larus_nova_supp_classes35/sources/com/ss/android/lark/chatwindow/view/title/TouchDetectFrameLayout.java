package com.ss.android.lark.chatwindow.view.title;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000G\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001!\u0018\u0000 &2\u00020\u0001:\u0002&'B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0010\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020%H\u0016R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001a\u0010\u0017\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0010\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\"¨\u0006("}, d2 = {"Lcom/ss/android/lark/chatwindow/view/title/TouchDetectFrameLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", BuildConfig.FLAVOR, "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "gestureDetector", "Landroid/view/GestureDetector;", "enableCheck", BuildConfig.FLAVOR, "getEnableCheck", "()Z", "setEnableCheck", "(Z)V", "enableClick", "getEnableClick", "setEnableClick", "enableTouchMoveCheck", "getEnableTouchMoveCheck", "setEnableTouchMoveCheck", "listener", "Lcom/ss/android/lark/chatwindow/view/title/TouchDetectFrameLayout$OnTouchEventDetectedListener;", "getListener", "()Lcom/ss/android/lark/chatwindow/view/title/TouchDetectFrameLayout$OnTouchEventDetectedListener;", "setListener", "(Lcom/ss/android/lark/chatwindow/view/title/TouchDetectFrameLayout$OnTouchEventDetectedListener;)V", "gestureListener", "com/ss/android/lark/chatwindow/view/title/TouchDetectFrameLayout$gestureListener$1", "Lcom/ss/android/lark/chatwindow/view/title/TouchDetectFrameLayout$gestureListener$1;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "Companion", "OnTouchEventDetectedListener", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TouchDetectFrameLayout extends FrameLayout {
    public GestureDetector a;
    public boolean b;
    public boolean c;
    public boolean d;
    public final c e;

    public static final class a {
    }

    public interface b {
    }

    public static final class c extends GestureDetector.SimpleOnGestureListener {
        public final /* synthetic */ TouchDetectFrameLayout a;

        public c(TouchDetectFrameLayout r1) {
            this.a = r1;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onDown(MotionEvent r2) {
            Intrinsics.checkNotNullParameter(r2, "e");
            return this.a.getEnableCheck();
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onSingleTapUp(MotionEvent r2) {
            Intrinsics.checkNotNullParameter(r2, "e");
            if (this.a.getEnableClick() == false) goto L6;
            Log.d("TouchDetectFrameLayout", "click");
            this.a.getListener();
        L6:
            return this.a.getEnableClick();
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onFling(MotionEvent r5, MotionEvent r6, float r7, float r8) {
            Intrinsics.checkNotNullParameter(r6, "e2");
            if (r5 != null) goto L7;
            return false;
        L7:
            if (this.a.getEnableTouchMoveCheck() == false) goto L19;
            if ((r5.getY() - r6.getY()) <= UIUtils.dp2px(this.a.getContext(), 10.0f)) goto L14;
            if (Math.abs(r8) <= 100.0f) goto L14;
            Log.d("TouchDetectFrameLayout", "fling up");
            this.a.getListener();
        L14:
            if ((r6.getY() - r5.getY()) <= UIUtils.dp2px(this.a.getContext(), 10.0f)) goto L19;
            if (Math.abs(r8) <= 100.0f) goto L19;
            Log.d("TouchDetectFrameLayout", "fling down");
            this.a.getListener();
        L19:
            return this.a.getEnableTouchMoveCheck();
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onScroll(MotionEvent r3, MotionEvent r4, float r5, float r6) {
            Intrinsics.checkNotNullParameter(r4, "e2");
            if (r3 != null) goto L7;
            return false;
        L7:
            if (this.a.getEnableTouchMoveCheck() == false) goto L15;
            if ((r3.getY() - r4.getY()) <= UIUtils.dp2px(this.a.getContext(), 10.0f)) goto L12;
            Log.d("TouchDetectFrameLayout", "scroll up");
            this.a.getListener();
            goto L15
        L12:
            if ((r4.getY() - r3.getY()) <= UIUtils.dp2px(this.a.getContext(), 10.0f)) goto L15;
            Log.d("TouchDetectFrameLayout", "scroll down");
            this.a.getListener();
        L15:
            return this.a.getEnableTouchMoveCheck();
        }
    }

    static {
    }

    public final b getListener() {
        return null;
    }

    public final void setListener(b r1) {
    }

    public final boolean getEnableCheck() {
        return this.b;
    }

    public final boolean getEnableClick() {
        return this.c;
    }

    public final boolean getEnableTouchMoveCheck() {
        return this.d;
    }

    public TouchDetectFrameLayout(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.b = true;
        this.e = new c(this);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        if (this.a != null) goto L5;
        this.a = new GestureDetector(getContext(), this.e);
    L5:
        GestureDetector r0 = this.a;
        if (r0 == null) goto L9;
        return r0.onTouchEvent(r4);
    L9:
        return super.onTouchEvent(r4);
    }

    public final void setEnableCheck(boolean r1) {
        this.b = r1;
    }

    public final void setEnableClick(boolean r1) {
        this.c = r1;
    }

    public final void setEnableTouchMoveCheck(boolean r1) {
        this.d = r1;
    }

    public TouchDetectFrameLayout(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.b = true;
        this.e = new c(this);
    }

    public TouchDetectFrameLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.b = true;
        this.e = new c(this);
    }
}
