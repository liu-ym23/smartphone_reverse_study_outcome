package com.larus.photopicker.v2.impl.ui;

import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.larus.common_ui.view.BottomOverlayView;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000bJ\u0010\u0010\u0013\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0015\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0019H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/larus/photopicker/v2/impl/ui/MotionEventPassBottomSheetDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "myContext", "Landroid/content/Context;", "theme", "", "<init>", "(Landroid/content/Context;I)V", "bottomSheet", "Landroid/view/View;", "isTouchEventPassedEnable", "", "bottomOverlayView", "Lcom/larus/common_ui/view/BottomOverlayView;", "hostDialogWindow", "Landroid/view/Window;", "setTouchEventPassedEnable", "", "enable", "setBottomOverlayView", "overlayView", "setHostDialogWindow", "window", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "isTouchOnBottomOverlay", "passTouchEventToUnderlyingView", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class MotionEventPassBottomSheetDialog extends BottomSheetDialog {
    public final Context a;
    public View b;
    public boolean c;
    public BottomOverlayView d;
    public Window e;

    public static final class a {
    }

    static {
    }

    public MotionEventPassBottomSheetDialog(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "myContext");
        super(r2, 2131954338);
        this.a = r2;
        this.c = true;
    }

    public static View I0(Window r3) {
        View r4 = r3.getDecorView();
        if (c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == c.a) goto L7;
        c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchTouchEvent(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        if (this.c == true) goto L7;
        return super/*android.app.Dialog*/.dispatchTouchEvent(r10);
    L61:
        return false;
    L7:
        if (this.b != null) goto L9;
        this.b = findViewById(2131368870);
    L9:
        View r0 = this.b;
        if (r0 == null) goto L58;
        Rect r2 = new Rect();
        r0.getGlobalVisibleRect(r2);
        boolean r1 = r2.contains((int) r10.getX(), (int) r10.getY());
        BottomOverlayView r3 = this.d;
        boolean r4 = true;
        if (r3 != null) goto L14;
    L16:
        boolean r5 = false;
    L17:
        if (r5 == false) goto L29;
        Rect r6 = new Rect();
        BottomOverlayView r7 = this.d;
        if (r7 != null) goto L22;
    L24:
        boolean r8 = false;
    L25:
        if (r8 == false) goto L29;
        if (r6.contains((int) r10.getX(), (int) r10.getY()) == false) goto L29;
    L30:
        if (r1 == true) goto L58;
        if (r4 == true) goto L58;
        MotionEvent r9 = MotionEvent.obtain(r10);     // Catch: Exception -> L53
        FLogger r11 = FLogger.a;     // Catch: Exception -> L53
        r11.i("MotionEventPassBottomSheetDialog", "attachdialog passTouchEventToUnderlyingView hostDialogWindow=" + this.e + " event.y=" + r10.getY());     // Catch: Exception -> L53
        Window r12 = this.e;     // Catch: Exception -> L53
        if (r12 == null) goto L36;
        View r13 = I0(r12).getRootView();     // Catch: Exception -> L53
        Rect r14 = new Rect();     // Catch: Exception -> L53
        r13.getGlobalVisibleRect(r14);     // Catch: Exception -> L53
        r9.offsetLocation(-r14.left, -r14.top);     // Catch: Exception -> L53
        r13.dispatchTouchEvent(r9);     // Catch: Exception -> L53
        r9.recycle();     // Catch: Exception -> L53
        r11.i("MotionEventPassBottomSheetDialog", "attachdialog passTouchEventToUnderlyingView hostDialogWindow=" + this.e + " event.y=" + r10.getY() + " pass to hostDialogWindow");     // Catch: Exception -> L53
        goto L50
    L36:
        FragmentActivity r15 = this.a;     // Catch: Exception -> L53
        if ((r15 instanceof FragmentActivity) == false) goto L39;
        FragmentActivity r16 = r15;     // Catch: Exception -> L53
    L40:
        if (r16 == null) goto L50;
        Window r17 = r16.getWindow();     // Catch: Exception -> L53
        if (r17 == null) goto L50;
        View r18 = I0(r17);     // Catch: Exception -> L53
        if (r18 == null) goto L50;
        View r19 = r18.getRootView();     // Catch: Exception -> L53
        if (r19 == null) goto L50;
        Rect r20 = new Rect();     // Catch: Exception -> L53
        r19.getGlobalVisibleRect(r20);     // Catch: Exception -> L53
        r9.offsetLocation(-r20.left, -r20.top);     // Catch: Exception -> L53
        r19.dispatchTouchEvent(r9);     // Catch: Exception -> L53
        r9.recycle();     // Catch: Exception -> L53
        goto L50
    L39:
        r16 = null;
    L50:
        return false;
    L22:
        if (r7.getGlobalVisibleRect(r6) != true) goto L24;
        r8 = true;
    L29:
        r4 = false;
        goto L30
    L14:
        if (r3.isShown() != true) goto L16;
        r5 = true;
    L58:
        return super/*android.app.Dialog*/.dispatchTouchEvent(r10);
    L62:
        return false;
    }
}
