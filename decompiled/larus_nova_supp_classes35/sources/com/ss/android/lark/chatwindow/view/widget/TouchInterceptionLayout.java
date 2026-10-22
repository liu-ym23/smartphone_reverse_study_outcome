package com.ss.android.lark.chatwindow.view.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 02\u00020\u0001:\u000201B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\rJ\u000e\u0010\"\u001a\u00020 2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0012\u0010#\u001a\u00020\r2\b\u0010$\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010%\u001a\u00020\r2\b\u0010&\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010'\u001a\u00020 2\b\u0010(\u001a\u0004\u0018\u00010)H\u0002J\b\u0010*\u001a\u00020 H\u0002J \u0010+\u001a\u00020\r2\u0006\u0010,\u001a\u00020\u00122\u0006\u0010-\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\u0012H\u0002J\u0010\u0010/\u001a\u00020 2\u0006\u0010&\u001a\u00020\u0012H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u000e\u0010\u001e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/ss/android/lark/chatwindow/view/widget/TouchInterceptionLayout;", "Lcom/ss/android/lark/chatwindow/view/widget/MeasureDetectFrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "handler", "Landroid/os/Handler;", "mDoubleTapSlopSquare", BuildConfig.FLAVOR, "doubleClickEnable", BuildConfig.FLAVOR, "doubleClickListener", "Lcom/ss/android/lark/chatwindow/view/widget/TouchInterceptionLayout$DoubleClickListener;", "mStillDown", "mCurrentDownEvent", "Landroid/view/MotionEvent;", "mPreviousUpEvent", "mIsDoubleTapping", "doubleTapTimeout", BuildConfig.FLAVOR, "getDoubleTapTimeout", "()J", "setDoubleTapTimeout", "(J)V", "doubleTapMinTime", "getDoubleTapMinTime", "setDoubleTapMinTime", "isConsumed", "setIsEnableDoubleClick", BuildConfig.FLAVOR, "enable", "setDoubleClickListener", "dispatchTouchEvent", "ev", "onTouchEvent", "event", "cancelChildrenLongPress", "viewGroup", "Landroid/view/ViewGroup;", ChameleonOpenTracker.OpenResult.CANCEL, "isConsideredDoubleTap", "firstDown", "firstUp", "secondDown", "dispatchTouchEventToChildren", "Companion", "DoubleClickListener", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class TouchInterceptionLayout extends MeasureDetectFrameLayout {
    public final a b;
    public final int c;
    public boolean d;
    public c e;
    public boolean f;
    public MotionEvent g;
    public MotionEvent h;
    public boolean i;
    public long j;
    public long k;
    public boolean l;

    public static final class a extends Handler {
        public final /* synthetic */ TouchInterceptionLayout a;

        @Override // android.os.Handler
        public final void handleMessage(Message r13) {
            Intrinsics.checkNotNullParameter(r13, "msg");
            super.handleMessage(r13);
            Log.d("TouchInterceptionLayout", "handleMessage");
            if (r13.what != 65537) goto L24;
            TouchInterceptionLayout r0 = this.a;
            int r3 = 0;
            if (r0.l == false) goto L13;
            if (r0.f == false) goto L9;
            r0.performLongClick();
        L10:
            this.a.l = false;
            return;
        L9:
            r0.performClick();
            goto L10
        L13:
            if (r0.f == false) goto L15;
            return;
        L15:
            Log.d("TouchInterceptionLayout", "performClick");
            Object r14 = r13.obj;
            if ((r14 instanceof MotionEvent) == false) goto L18;
            MotionEvent r15 = (MotionEvent) r14;
        L19:
            if (r15 == null) goto L27;
            TouchInterceptionLayout r1 = this.a;
            r1.getClass();
            MotionEvent r16 = MotionEvent.obtain(r15.getDownTime(), 1 + r15.getEventTime(), 1, r15.getX() - r1.getPaddingLeft(), r15.getY() - r1.getPaddingTop(), r15.getMetaState());
            int r2 = r1.getChildCount();
        L21:
            if (r3 >= r2) goto L23;
            View r4 = r1.getChildAt(r3);
            MotionEvent r5 = MotionEvent.obtain(r16);
            r4.dispatchTouchEvent(r5);
            r5.recycle();
            r3 = r3 + 1;
            goto L21
        L23:
            r16.recycle();
            return;
        L27:
            return;
        L18:
            r15 = null;
            goto L19
        L24:
            Log.d("TouchInterceptionLayout", "unknown msg");
        }

        public a(TouchInterceptionLayout r1, Looper r2) {
            this.a = r1;
            super(r2);
        }
    }

    public static final class b {
    }

    public interface c {
        void a();
    }

    static {
    }

    public final long getDoubleTapMinTime() {
        return this.k;
    }

    public final long getDoubleTapTimeout() {
        return this.j;
    }

    public TouchInterceptionLayout(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public static void a(ViewGroup r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        int r0 = r4.getChildCount();
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L14;
        View r2 = r4.getChildAt(r1);
        r2.cancelLongPress();
        if ((r2 instanceof ViewGroup) == false) goto L9;
        ViewGroup r3 = (ViewGroup) r2;
    L10:
        if (r3 == null) goto L13;
        a((ViewGroup) r2);
    L13:
        r1 = r1 + 1;
        goto L5
    L9:
        r3 = null;
        goto L10
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r11) {
        if (this.d == false) goto L63;
        if (this.e == null) goto L63;
        if (r11 == null) goto L9;
        Integer r0 = Integer.valueOf(r11.getActionMasked());
    L10:
        boolean r2 = false;
        if (r0 != null) goto L14;
    L40:
        if (r0 != null) goto L43;
    L55:
        if (r0 != null) goto L58;
    L61:
        return super.dispatchTouchEvent(r11);
    L58:
        if (r0.intValue() != 3) goto L61;
        this.i = false;
        this.f = false;
        this.l = false;
        this.b.removeMessages(65537);
        goto L61
    L43:
        if (r0.intValue() != 1) goto L55;
        cancelLongPress();
        this.f = false;
        MotionEvent r1 = this.h;
        if (r1 == null) goto L47;
        r1.recycle();
    L47:
        this.h = MotionEvent.obtain(r11);
        if (this.b.hasMessages(65537) == false) goto L50;
    L53:
        this.i = false;
        return true;
    L50:
        if (this.i == true) goto L53;
        return super.dispatchTouchEvent(r11);
    L14:
        if (r0.intValue() != 0) goto L40;
        boolean r3 = this.b.hasMessages(65537);
        if (r3 == false) goto L18;
        this.b.removeMessages(65537);
    L18:
        MotionEvent r4 = this.g;
        if (r4 == null) goto L36;
        MotionEvent r5 = this.h;
        if (r5 == null) goto L36;
        if (r3 == false) goto L36;
        long r6 = r11.getEventTime() - r5.getEventTime();
        if (r6 <= this.j) goto L26;
    L31:
        if (r2 == false) goto L36;
        this.i = true;
        this.b.removeMessages(65537);
        cancelLongPress();
        a(this);
        c r12 = this.e;
        if (r12 == null) goto L35;
        r12.a();
    L35:
        return true;
    L26:
        if (r6 < this.k) goto L31;
        int r7 = ((int) r4.getX()) - ((int) r11.getX());
        int r8 = ((int) r4.getY()) - ((int) r11.getY());
        if (((r7 * r7) + (r8 * r8)) >= this.c) goto L31;
        r2 = true;
    L36:
        MotionEvent r9 = this.g;
        if (r9 == null) goto L39;
        r9.recycle();
    L39:
        this.g = MotionEvent.obtain(r11);
        Message r10 = this.b.obtainMessage();
        r10.what = 65537;
        r10.obj = this.g;
        this.b.sendMessageDelayed(r10, this.j);
        this.f = true;
        goto L61
    L9:
        r0 = null;
    L63:
        return super.dispatchTouchEvent(r11);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r2) {
        if (this.d == false) goto L19;
        if (this.e == null) goto L19;
        if (r2 == null) goto L9;
        Integer r0 = Integer.valueOf(r2.getActionMasked());
    L10:
        if (r0 == null) goto L17;
        if (r0.intValue() != 0) goto L17;
        this.l = true;
        return true;
    L17:
        return super.onTouchEvent(r2);
    L9:
        r0 = null;
    L19:
        return super.onTouchEvent(r2);
    }

    public final void setDoubleClickListener(c r2) {
        Intrinsics.checkNotNullParameter(r2, "doubleClickListener");
        this.e = r2;
    }

    public final void setDoubleTapMinTime(long r1) {
        this.k = r1;
    }

    public final void setDoubleTapTimeout(long r1) {
        this.j = r1;
    }

    public final void setIsEnableDoubleClick(boolean r1) {
        this.d = r1;
    }

    public TouchInterceptionLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4);
        this.j = 199;
        this.k = 40;
        this.b = new a(this, Looper.getMainLooper());
        ViewConfiguration r5 = ViewConfiguration.get(r3);
        this.c = r5.getScaledDoubleTapSlop() * r5.getScaledDoubleTapSlop();
    }
}
