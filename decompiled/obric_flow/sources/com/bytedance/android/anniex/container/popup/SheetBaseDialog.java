package com.bytedance.android.anniex.container.popup;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.app.AppCompatDialog;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.bytedance.android.anniex.container.m;
import com.bytedance.android.anniex.container.view.LimitedHeightFrameLayout;
import com.lynx.tasm.utils.g;
import com.obric.launcher.widget.R$id;
import com.obric.launcher.widget.R$layout;
import com.obric.launcher.widget.R$style;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import zm.z;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/anniex/container/popup/SheetBaseDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
@SourceDebugExtension({"SMAP\nSheetBaseDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SheetBaseDialog.kt\ncom/bytedance/android/anniex/container/popup/SheetBaseDialog\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,554:1\n1#2:555\n*E\n"})
public final class SheetBaseDialog extends AppCompatDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f3166a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f3167b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3168c;
    public boolean d;
    public boolean e;
    public final ArrayList f;
    public z g;

    public SheetBaseDialog(Context r5, boolean r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Log.d("StyleUtils", "new theme context is AppCompatActivity");
        super(r5, R$style.annie_x_standard_dialog_bottom_theme_appcompat);
        this.f3166a = r10;
        this.f3167b = r11;
        this.f3168c = true;
        this.d = true;
        this.f = new ArrayList();
        g.b(484, r5);
    }

    public final void b(int r5, View r10) {
        if (this.f3166a == false) goto L5;
        View r11 = View.inflate(getContext(), R$layout.annie_x_dialog_right_sheet, null);
    L6:
        CoordinatorLayout r12 = (CoordinatorLayout) r11.findViewById(R$id.annie_x_bottom_sheet_coordinator);
        if (r5 == 0) goto L10;
        if (r10 != null) goto L10;
        getLayoutInflater().inflate(r5, r12, false);
    L10:
        LimitedHeightFrameLayout r13 = (LimitedHeightFrameLayout) r12.findViewById(R$id.annie_x_bottom_sheet);
        Intrinsics.checkNotNull(r13);
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
        if ((r14 instanceof CoordinatorLayout.LayoutParams) == false) goto L15;
        ((CoordinatorLayout.LayoutParams) r14).getBehavior();
        throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
    L15:
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    L5:
        r11 = View.inflate(getContext(), R$layout.annie_x_dialog_bottom_sheet, null);
        goto L6
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void cancel() {
        if (this.f3168c == true) goto L5;
    L10:
        z r5 = this.g;
        if (r5 == null) goto L14;
        Intrinsics.checkNotNull(r5);
        z r10 = this.g;
        Intrinsics.checkNotNull(r10);
        PopupCloseType r11 = PopupCloseType.d;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r11, "popupCloseType");
        com.bytedance.android.anniex.container.c r12 = new com.bytedance.android.anniex.container.c(3);
        m r13 = (m) r10.f23549a;
        r13.sendEvent(r12);
        r13.getClass();
        r13.sendEvent(new com.bytedance.android.anniex.container.g(r11));
        return;
    L14:
        return;
    L5:
        if (isShowing() == false) goto L10;
        if (d() == false) goto L10;
        super.cancel();
    }

    public final boolean d() {
        if (this.e == true) goto L6;
        TypedArray r5 = getContext().obtainStyledAttributes(new int[]{R.attr.windowCloseOnTouchOutside});
        this.d = r5.getBoolean(0, true);
        r5.recycle();
        this.e = true;
    L6:
        return this.d;
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    public final void onBackPressed() {
        PopupCloseType r5 = PopupCloseType.f3163b;
        if (this.f3168c == true) goto L5;
    L10:
        z r10 = this.g;
        if (r10 == null) goto L13;
        Intrinsics.checkNotNull(r10);
    L13:
        z r11 = this.g;
        if (r11 == null) goto L19;
        Intrinsics.checkNotNull(r11);
        boolean r12 = d();
        Intrinsics.checkNotNullParameter(r5, "popupCloseType");
        if (r12 == true) goto L20;
        com.bytedance.android.anniex.container.c r13 = new com.bytedance.android.anniex.container.c(3);
        m r14 = (m) r11.f23549a;
        r14.sendEvent(r13);
        r14.getClass();
        r14.sendEvent(new com.bytedance.android.anniex.container.g(r5));
        return;
    L20:
        return;
    L19:
        return;
    L5:
        if (isShowing() == false) goto L10;
        if (d() == false) goto L10;
        super.cancel();
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public final void onCreate(Bundle r5) {
        super.onCreate(r5);
        if (this.f3167b == false) goto L18;
        Window r10 = getWindow();
        if (r10 == null) goto L7;
        r10.addFlags(Integer.MIN_VALUE);
    L7:
        Window r11 = getWindow();
        if (r11 == null) goto L10;
        r11.clearFlags(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
    L10:
        Window r12 = getWindow();
        if (r12 == null) goto L14;
        r12.setStatusBarColor(0);
    L14:
        Window r13 = getWindow();
        if (r13 == null) goto L19;
        r13.clearFlags(1024);
        return;
    L19:
        return;
    }

    @Override // android.app.Dialog
    public final void onRestoreInstanceState(Bundle r5) {
        Intrinsics.checkNotNullParameter(r5, "savedInstanceState");
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L10
        ConcurrentHashMap r11 = yc.a.f23246a;     // Catch: Throwable -> L10
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");     // Catch: Throwable -> L10
        xc.e r12 = (xc.e) yc.a.a(xc.e.class, "default_bid");     // Catch: Throwable -> L10
        if (r12 == null) goto L12;
        xc.d r13 = (xc.d) r12.a(xc.d.class);     // Catch: Throwable -> L10
        if (r13 == null) goto L12;
        Boolean r14 = r13.L();     // Catch: Throwable -> L10
        if (r14 == null) goto L12;
        boolean r15 = r14.booleanValue();     // Catch: Throwable -> L10
    L13:
        if (r15 == false) goto L15;
        r5.remove("android:dialogShowing");     // Catch: Throwable -> L10
        r5.remove("android:dialogHierarchy");     // Catch: Throwable -> L10
    L15:
        super.onRestoreInstanceState(r5);     // Catch: Throwable -> L10
        Object r16 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L10
    L18:
        Throwable r17 = Result.m127exceptionOrNullimpl(r16);
        if (r17 == null) goto L24;
        int r18 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        String r19 = "onRestoreInstanceState error====" + r17.getMessage();
        Intrinsics.checkNotNullParameter("SheetBaseDialog", "moduleTag");
        Intrinsics.checkNotNullParameter(r19, "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.h(true, "SheetBaseDialog", r19, null, null);
        return;
    L24:
        return;
    L12:
        r15 = false;
    L10:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r16 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L18
    }

    @Override // android.app.Dialog
    public final boolean onTouchEvent(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        if (this.g == null) goto L26;
        if (1 != r10.getAction()) goto L26;
        Context r5 = getContext();
        int r11 = (int) r10.getX();
        int r12 = (int) r10.getY();
        int r13 = ViewConfiguration.get(r5).getScaledWindowTouchSlop();
        if (getWindow() == null) goto L22;
        Window r14 = getWindow();
        if (r14 == null) goto L12;
        View r15 = r14.getDecorView();
    L13:
        if (r15 == null) goto L22;
        int r16 = -r13;
        if (r11 < r16) goto L22;
        if (r12 < r16) goto L22;
        if (r11 > (r15.getWidth() + r13)) goto L22;
        if (r12 <= (r15.getHeight() + r13)) goto L26;
    L12:
        r15 = null;
    L22:
        z r17 = this.g;
        Intrinsics.checkNotNull(r17);
        d();
        r17.getClass();
        z r18 = this.g;
        Intrinsics.checkNotNull(r18);
        boolean r19 = d();
        PopupCloseType r20 = PopupCloseType.f3164c;
        r18.getClass();
        Intrinsics.checkNotNullParameter(r20, "popupCloseType");
        if (r19 == true) goto L26;
        com.bytedance.android.anniex.container.c r21 = new com.bytedance.android.anniex.container.c(3);
        m r22 = (m) r18.f23549a;
        r22.sendEvent(r21);
        r22.getClass();
        r22.sendEvent(new com.bytedance.android.anniex.container.g(r20));
    L26:
        return super.onTouchEvent(r10);
    }

    @Override // android.app.Dialog
    public final void setCancelable(boolean r5) {
        super.setCancelable(r5);
        if (this.f3168c == r5) goto L5;
        this.f3168c = r5;
    L5:
        if (r5 == true) goto L23;
        ConcurrentHashMap r10 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r11 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r11 == null) goto L13;
        xc.d r12 = (xc.d) r11.a(xc.d.class);
        if (r12 == null) goto L13;
        Boolean r13 = r12.x0();
        if (r13 == null) goto L13;
        boolean r14 = r13.booleanValue();
    L14:
        if (r14 == false) goto L24;
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L17
        Object r16 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L17
    L19:
        Result.m127exceptionOrNullimpl(r16);
        return;
    L17:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r16 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L19
    L24:
        return;
    L13:
        r14 = true;
        goto L14
    }

    @Override // android.app.Dialog
    public final void setCanceledOnTouchOutside(boolean r5) {
        super.setCanceledOnTouchOutside(r5);
        if (r5 == true) goto L5;
    L7:
        this.d = r5;
        this.e = true;
        return;
    L5:
        if (this.f3168c == true) goto L7;
        this.f3168c = true;
        goto L7
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public final void setContentView(int r5) {
        b(r5, null);
        throw null;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public final void setContentView(View r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        b(0, r5);
        throw null;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public final void setContentView(View r5, ViewGroup.LayoutParams r10) {
        Intrinsics.checkNotNullParameter(r5, "view");
        b(0, r5);
        throw null;
    }
}
