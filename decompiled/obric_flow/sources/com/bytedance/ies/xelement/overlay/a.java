package com.bytedance.ies.xelement.overlay;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import com.lynx.tasm.b0;
import com.lynx.tasm.behavior.a1;
import com.obric.launcher.widget.R$style;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LynxOverlayView f6486a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f6487b;

    public a(b0 r5, LynxOverlayView r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "overlay");
        super(r5, R$style.OverlayTheme);
        this.f6486a = r10;
        this.f6487b = LazyKt.lazy(new LynxOverlayDialog$statusBarHeight$2(this));
    }

    public final boolean a(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "ev");
        float r5 = r10.getX();
        float r11 = r10.getY();
        LynxOverlayView r12 = this.f6486a;
        boolean r13 = r12.c(r5, r11);
        boolean r14 = false;
        if (r13 == false) goto L10;
        float r15 = r12.getLeft();
        float r16 = r12.getTop();
        r10.offsetLocation(-r15, -r16);
        a1 r17 = r12.f6478l;
        if (r17 != null) goto L7;
    L9:
        r10.offsetLocation(r15, r16);
        goto L10
    L7:
        if (r17.p(r10, r12) != true) goto L9;
        r14 = true;
    L10:
        return r14;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        Context r5 = getContext();
        if ((r5 instanceof Activity) == false) goto L10;
        Activity r10 = (Activity) r5;
        if (r10.isFinishing() == false) goto L8;
        return;
    L8:
        if (r10.isDestroyed() == false) goto L10;
        return;
    L10:
        super.dismiss();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "ev");
        if (a(r5) == true) goto L5;
        ArrayList r10 = c.f6490a;
        Intrinsics.checkNotNullParameter(r5, "ev");
        Intrinsics.checkNotNullParameter(this, "overlay");
        Iterator r11 = c.f6490a.iterator();
    L8:
        if (r11.hasNext() == false) goto L15;
        b r12 = (b) r11.next();
        if (r12.f6489b.a(r5) == false) goto L8;
        a r13 = r12.f6489b;
        if (Intrinsics.areEqual(this, r13) == true) goto L8;
        r13.getClass();
        Intrinsics.checkNotNullParameter(r5, "ev");
        return super.dispatchTouchEvent(r5);
    L15:
        ArrayList r14 = c.f6490a;
        if (r14.isEmpty() == false) goto L19;
        r14 = null;
    L19:
        int r15 = 0;
        if (r14 == null) goto L34;
        a r16 = ((b) r14.get(0)).f6489b;
        r16.getClass();
        Intrinsics.checkNotNullParameter(r5, "event");
        LynxOverlayView r17 = r16.f6486a;
        Activity r18 = kk.a.c(r17.getLynxContext());
        if (r18 != null) goto L24;
        return false;
    L24:
        if (r17.f6473c == true) goto L26;
        r15 = -((Number) r16.f6487b.getValue()).intValue();
    L26:
        float r19 = r15;
        r5.offsetLocation(-0.0f, -r19);
        boolean r20 = r18.dispatchTouchEvent(r5);
        r5.offsetLocation(0.0f, r19);
        return r20;
    L34:
        return false;
    L5:
        return super.dispatchTouchEvent(r5);
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r5) {
        super.onCreate(r5);
        Window r10 = getWindow();
        if (r10 == null) goto L6;
        r10.setLayout(-1, -1);
        return;
    }

    @Override // android.app.Dialog
    public final void show() {
        Context r5 = getContext();
        if ((r5 instanceof Activity) == false) goto L10;
        Activity r10 = (Activity) r5;
        if (r10.isFinishing() == false) goto L8;
        return;
    L8:
        if (r10.isDestroyed() == false) goto L10;
        return;
    L10:
        Window r11 = getWindow();
        if (r11 == null) goto L13;
        r11.clearFlags(131072);
    L13:
        Window r12 = getWindow();
        if (r12 == null) goto L16;
        r12.setFlags(8, 8);
    L16:
        super.show();
        Activity r13 = getOwnerActivity();
        if (r13 == null) goto L27;
        Window r14 = r13.getWindow();
        if (r14 == null) goto L27;
        View r15 = r14.getDecorView();
        if (r15 == null) goto L27;
        int r16 = r15.getSystemUiVisibility();
        Window r17 = getWindow();
        if (r17 == null) goto L27;
        View r18 = r17.getDecorView();
        if (r18 == null) goto L27;
        r18.setSystemUiVisibility(r16);
    L27:
        Window r19 = getWindow();
        if (r19 == null) goto L31;
        r19.clearFlags(8);
        return;
    }
}
