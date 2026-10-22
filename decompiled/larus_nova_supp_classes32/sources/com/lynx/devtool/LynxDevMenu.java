package com.lynx.devtool;

import android.app.AlertDialog;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import com.lynx.tasm.LynxView;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxDevMenu {
    private static final long CLICK_RANGE = 15;
    private static final long PRESS_RANGE = 1000;
    private AlertDialog mDevOptionsDialog;
    private Handler mLongPressHandler;
    private WeakReference<LynxView> mLynxView;
    private final WeakReference<LynxInspectorOwner> mOwner;
    private float mPointX;
    private float mPointY;
    private float mStartX;
    private float mStartY;

    public void showDevOptionsDialog() {
        if (this.mDevOptionsDialog == null) goto L5;
        return;
    L5:
        final LynxInspectorOwner r0 = this.mOwner.get();
        if (r0 != null) goto L9;
        return;
    L9:
        if (r0.isDebugging() == false) goto L11;
        String r1 = ("IP: " + r0.getHttpServerIp() + "\nPort: " + r0.getHttpServerPort()) + "\nSession ID: " + r0.getSessionID();
    L12:
        LinkedHashMap r2 = new LinkedHashMap();
        if (r1.isEmpty() == true) goto L15;
        r2.put(r1, new AnonymousClass1(this));
    L15:
        r2.put("Reload", new AnonymousClass2(this, r0));
        final DevOptionHandler[] r3 = (DevOptionHandler[]) r2.values().toArray(new DevOptionHandler[0]);
        AlertDialog.Builder r4 = new AlertDialog.Builder(r0.getLynxView().getContext());
        r4.setTitle("Lynx Debug Menu");
        r4.setItems((CharSequence[]) r2.keySet().toArray(new String[0]), new AnonymousClass3(this, r3));
        r4.setOnCancelListener(new AnonymousClass4(this));
        AlertDialog r5 = r4.create();
        this.mDevOptionsDialog = r5;
        INVOKEVIRTUAL_com_lynx_devtool_LynxDevMenu_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(r5);
        return;
    L11:
        r1 = NameKeys.UnloadStrategy_No_Strategy;
        goto L12
    }

    public static void INVOKEVIRTUAL_com_lynx_devtool_LynxDevMenu_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(AlertDialog r1) {
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r1);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r1);
        r1.show();
        DialogLancet.afterDialogShow(r1);
    }

    private boolean onActionCancel(MotionEvent r2) {
        this.mLongPressHandler.removeCallbacksAndMessages(null);
        return false;
    }

    private boolean onActionDown(MotionEvent r4) {
        this.mStartX = r4.getX();
        float r5 = r4.getY();
        this.mStartY = r5;
        if (isInViewArea(this.mStartX, r5) == false) goto L7;
        this.mLongPressHandler.postDelayed(new AnonymousClass5(this), PRESS_RANGE);
        return false;
    L7:
        return false;
    }

    private boolean onActionMove(MotionEvent r3) {
        this.mPointX = r3.getX();
        float r4 = r3.getY();
        this.mPointY = r4;
        if (isInViewArea(this.mPointX, r4) == true) goto L5;
    L8:
        this.mLongPressHandler.removeCallbacksAndMessages(null);
        return false;
    L5:
        if (Math.abs(this.mPointX - this.mStartX) > 15.0f) goto L8;
        if (Math.abs(this.mPointY - this.mStartY) > 15.0f) goto L8;
        return false;
    }

    private boolean onActionUp(MotionEvent r2) {
        this.mLongPressHandler.removeCallbacksAndMessages(null);
        return false;
    }

    public void attach(LynxView r2) {
        this.mLynxView = new WeakReference(r2);
    }

    public boolean onRootViewTouchEvent(MotionEvent r3) {
        int r0 = r3.getAction();
        if (r0 == 0) goto L15;
        if (r0 == 1) goto L13;
        if (r0 == 2) goto L11;
        return onActionCancel(r3);
    L11:
        return onActionMove(r3);
    L13:
        return onActionUp(r3);
    L15:
        return onActionDown(r3);
    }

    public LynxDevMenu(LynxInspectorOwner r2, LynxView r3) {
        this.mOwner = new WeakReference(r2);
        this.mLynxView = new WeakReference(r3);
        this.mDevOptionsDialog = null;
        this.mLongPressHandler = new Handler(Looper.getMainLooper());
    }

    public static /* synthetic */ AlertDialog access$002(LynxDevMenu r0, AlertDialog r1) {
        r0.mDevOptionsDialog = r1;
        return r1;
    }

    private boolean isInViewArea(float r4, float r5) {
        LynxView r0 = this.mLynxView.get();
        if (r0 != null) goto L20;
        return false;
    L20:
        Rect r2 = new Rect();     // Catch: Throwable -> L17
        r0.getLocalVisibleRect(r2);     // Catch: Throwable -> L17
        if (r4 > r2.left) goto L8;
    L16:
        return false;
    L8:
        if (r4 >= r2.right) goto L16;
        if (r5 <= r2.top) goto L16;
        if (r5 >= r2.bottom) goto L16;
        return true;
    L17:
        th = move-exception;
        th.printStackTrace();
        return false;
    }
}
