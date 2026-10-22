package com.bytedance.android.livesdk.focus;

import android.view.MotionEvent;
import com.bytedance.android.livesdk.config.cc;
import com.bytedance.android.livesdkapi.focus.IFocusContext;
import com.bytedance.android.livesdkapi.focus.IFocusWidget;
import com.bytedance.live.datacontext.DataContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b%\u0010&J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0003H\u0016J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J(\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J\u0010\u0010\u0017\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\u0010\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u0019H\u0016R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u001dR\u0016\u0010\b\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u001eR\"\u0010\u001f\u001a\u00020\u00198\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006'"}, d2 = {"Lcom/bytedance/android/livesdk/focus/LiveFocusContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/android/livesdkapi/focus/IFocusContext;", "", "isAvailable", "Landroid/view/MotionEvent;", "event", "isFocusAvailable", "enable", "", "setEnable", "Lcom/bytedance/android/livesdkapi/focus/IFocusWidget;", "focusWidget", "setFocusWidget", "onSingleTap", "e1", "e2", "", "distanceX", "distanceY", "onScroll", "Lnc1/a;", "controller", "setVideoCaptureController", "isFocusWidgetShow", "", "exposure", "setExposure", "getExposure", "Lcom/bytedance/android/livesdkapi/focus/IFocusWidget;", "Z", "currentExposure", "I", "getCurrentExposure", "()I", "setCurrentExposure", "(I)V", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveFocusContext extends DataContext implements IFocusContext {
    private int currentExposure;
    private boolean enable;
    private IFocusWidget focusWidget;

    private final boolean isAvailable() {
        if (this.focusWidget != null) goto L5;
    L9:
        return false;
    L5:
        if (this.enable == false) goto L9;
        if (cc.a.getValue().booleanValue() == false) goto L9;
        return true;
    }

    public boolean isFocusWidgetShow() {
        IFocusWidget r0 = this.focusWidget;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.canAdjustExposure();
    }

    public LiveFocusContext() {
        this.enable = true;
    }

    public int getExposure() {
        return getCurrentExposure();
    }

    public int getCurrentExposure() {
        return this.currentExposure;
    }

    private final boolean isFocusAvailable(MotionEvent r2) {
        if (isAvailable() == false) goto L9;
        IFocusWidget r0 = this.focusWidget;
        if (r0 == null) goto L9;
        if (r0.isTapValid(r2) != true) goto L9;
        return true;
    L9:
        return false;
    }

    public boolean onSingleTap(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        if (isFocusAvailable(r2) == false) goto L8;
        IFocusWidget r0 = this.focusWidget;
        if (r0 == null) goto L7;
        r0.onSingleTap(r2);
    L7:
        return true;
    L8:
        return false;
    }

    public void setCurrentExposure(int r1) {
        this.currentExposure = r1;
    }

    public void setEnable(boolean r1) {
        this.enable = r1;
    }

    public void setExposure(int r1) {
        setCurrentExposure(r1);
    }

    public void setFocusWidget(IFocusWidget r2) {
        Intrinsics.checkNotNullParameter(r2, "focusWidget");
        this.focusWidget = r2;
    }

    public final void setVideoCaptureController(nc1.a r2) {
        IFocusWidget r3 = this.focusWidget;
        if ((r3 instanceof LiveFocusWidget) == false) goto L8;
        if (r3 == null) goto L7;
        LiveFocusWidget r4 = (LiveFocusWidget) r3;
        r4.getClass();
        r4.wq();
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.focus.LiveFocusWidget");
    }

    public boolean onScroll(MotionEvent r3, MotionEvent r4, float r5, float r6) {
        Intrinsics.checkNotNullParameter(r3, "e1");
        Intrinsics.checkNotNullParameter(r4, "e2");
        if (isAvailable() == false) goto L11;
        IFocusWidget r0 = this.focusWidget;
        if (r0 == null) goto L11;
        if (r0.canAdjustExposure() != true) goto L11;
        IFocusWidget r1 = this.focusWidget;
        if (r1 == null) goto L13;
        r1.onScroll(r3, r4, r5, r6);
        return true;
    L13:
        return true;
    L11:
        return false;
    }
}
