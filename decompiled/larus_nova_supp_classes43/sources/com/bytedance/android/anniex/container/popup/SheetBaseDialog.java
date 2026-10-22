package com.bytedance.android.anniex.container.popup;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatDialog;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.android.anniex.container.view.LimitedHeightFrameLayout;
import com.bytedance.android.ec.core.utils.FontWeight;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.service.base.h;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import w26.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/anniex/container/popup/SheetBaseDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "a", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class SheetBaseDialog extends AppCompatDialog {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final int e;
    public SheetBaseBehavior<?> f;
    public boolean g;
    public final boolean h;
    public boolean i;
    public boolean j;
    public SheetBaseBehavior.b k;
    public final ArrayList<SheetBaseBehavior.b> l;
    public com.bytedance.android.anniex.container.popup.e m;
    public com.bytedance.android.anniex.container.popup.d n;
    public com.bytedance.android.anniex.container.popup.c o;
    public boolean p;
    public int q;
    public LimitedHeightFrameLayout r;
    public boolean s;
    public View t;
    public final d u;

    public static final class a {
    }

    public static final class b implements com.bytedance.android.anniex.container.popup.d {
        public final /* synthetic */ SheetBaseDialog a;

        @Override // com.bytedance.android.anniex.container.popup.d
        public final boolean a() {
            return true;
        }

        @Override // com.bytedance.android.anniex.container.popup.d
        public final boolean b() {
            return false;
        }

        @Override // com.bytedance.android.anniex.container.popup.d
        public final boolean c() {
            return true;
        }

        @Override // com.bytedance.android.anniex.container.popup.d
        public final boolean d() {
            return true;
        }

        @Override // com.bytedance.android.anniex.container.popup.d
        public final boolean e() {
            return !this.a.h;
        }

        public b(SheetBaseDialog r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.anniex.container.popup.d
        public final boolean f(MotionEvent r10) {
            Intrinsics.checkNotNullParameter(r10, "event");
            return false;
        }
    }

    public static final class c implements com.bytedance.android.anniex.container.popup.e {
        public final /* synthetic */ SheetBaseDialog a;

        @Override // com.bytedance.android.anniex.container.popup.e
        public final boolean shouldInterceptSlide(int r1) {
            return true;
        }

        @Override // com.bytedance.android.anniex.container.popup.e
        public final boolean disableDragDown() {
            SheetBaseDialog r0 = this.a;
            if (r0.h == true) goto L5;
        L8:
            return true;
        L5:
            if (r0.b == true) goto L8;
            return false;
        }

        public c(SheetBaseDialog r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.anniex.container.popup.e
        public final boolean a(MotionEvent r10) {
            Intrinsics.checkNotNullParameter(r10, "event");
            return false;
        }
    }

    public static final class d implements SheetBaseBehavior.b {
        public final /* synthetic */ SheetBaseDialog a;

        public d(SheetBaseDialog r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.anniex.container.popup.SheetBaseBehavior.b
        public final void a(View r10, int r11) {
            Intrinsics.checkNotNullParameter(r10, "bottomSheet");
            if (r11 != 5) goto L5;
            this.a.J0(PopupCloseType.PULL_DOWN);
        L5:
            SheetBaseBehavior.b r0 = this.a.k;
            if (r0 == null) goto L8;
            Intrinsics.checkNotNull(r0);
            r0.a(r10, r11);
        L8:
            Iterator<SheetBaseBehavior.b> r1 = this.a.l.iterator();
        L10:
            if (r1.hasNext() == false) goto L12;
            r1.next().a(r10, r11);
            goto L10
        }

        @Override // com.bytedance.android.anniex.container.popup.SheetBaseBehavior.b
        public final void b(View r10, float r11) {
            Intrinsics.checkNotNullParameter(r10, "bottomSheet");
            SheetBaseBehavior.b r0 = this.a.k;
            if (r0 == null) goto L5;
            r0.b(r10, r11);
        L5:
            Iterator<SheetBaseBehavior.b> r1 = this.a.l.iterator();
        L7:
            if (r1.hasNext() == false) goto L9;
            r1.next().b(r10, r11);
            goto L7
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ SheetBaseDialog a;

        public e(SheetBaseDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            this.a.J0(PopupCloseType.CLICK_MASK);
        }
    }

    public static final class f implements View.OnTouchListener {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r1, MotionEvent r10) {
            return true;
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void cancel() {
        if (this.g == true) goto L5;
    L9:
        com.bytedance.android.anniex.container.popup.c r0 = this.o;
        if (r0 == null) goto L14;
        Intrinsics.checkNotNull(r0);
        r0.a();
        com.bytedance.android.anniex.container.popup.c r1 = this.o;
        Intrinsics.checkNotNull(r1);
        r1.b(false, PopupCloseType.UNKNOWN);
        return;
    L14:
        return;
    L5:
        if (isShowing() == false) goto L9;
        if (shouldWindowCloseOnTouchOutside() == false) goto L9;
        super/*android.app.Dialog*/.cancel();
    }

    public final void onBackPressed() {
        J0(PopupCloseType.SYSTEM_BACK);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean shouldWindowCloseOnTouchOutside() {
        if (this.j == true) goto L6;
        TypedArray r0 = getContext().obtainStyledAttributes(new int[]{R.attr.windowCloseOnTouchOutside});
        this.i = r0.getBoolean(0, true);
        r0.recycle();
        this.j = true;
    L6:
        return this.i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStart() {
        super/*android.app.Dialog*/.onStart();
        SheetBaseBehavior<?> r0 = this.f;
        if (r0 == null) goto L8;
        Intrinsics.checkNotNull(r0);
        r0.setState(3);
        if (this.p == false) goto L9;
        SheetBaseBehavior<?> r1 = this.f;
        Intrinsics.checkNotNull(r1);
        r1.setState(4);
        return;
    L9:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(this);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(this);
        super/*android.app.Dialog*/.show();
        DialogLancet.afterDialogShow(this);
    }

    public final void dismiss() {
        I0(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void hide() {
        super/*android.app.Dialog*/.hide();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.app.Dialog*/.onDetachedFromWindow();
    }

    public final void onStop() {
        super.onStop();
    }

    public static void I0(AppCompatDialog r10) {
        Handler r0 = DialogLancet.resolveDialogHandler(r10);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r10);
        super.dismiss();     // Catch: Exception -> L11 Throwable -> L17
    L10:
        DialogLancet.afterDialogDismiss(r10);
        return;
    L17:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r10);
        throw th;
    L11:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L17
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L17
        if (r1 == null) goto L10;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L17
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void J0(PopupCloseType r10) {
        if (this.g == true) goto L5;
    L9:
        com.bytedance.android.anniex.container.popup.c r0 = this.o;
        if (r0 == null) goto L12;
        Intrinsics.checkNotNull(r0);
        r0.a();
    L12:
        com.bytedance.android.anniex.container.popup.c r1 = this.o;
        if (r1 == null) goto L18;
        if (r10 == null) goto L19;
        Intrinsics.checkNotNull(r1);
        r1.b(shouldWindowCloseOnTouchOutside(), r10);
        return;
    L19:
        return;
    L18:
        return;
    L5:
        if (isShowing() == false) goto L9;
        if (shouldWindowCloseOnTouchOutside() == false) goto L9;
        super/*android.app.Dialog*/.cancel();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r10) {
        super.onCreate(r10);
        if (this.b == false) goto L5;
    L8:
        boolean r11 = true;
    L9:
        if (r11 == false) goto L24;
        Window r12 = getWindow();
        if (r12 == null) goto L13;
        r12.addFlags(Integer.MIN_VALUE);
    L13:
        Window r13 = getWindow();
        if (r13 == null) goto L16;
        r13.clearFlags(67108864);
    L16:
        Window r14 = getWindow();
        if (r14 == null) goto L20;
        r14.setStatusBarColor(0);
    L20:
        Window r15 = getWindow();
        if (r15 == null) goto L25;
        r15.clearFlags(1024);
        return;
    L25:
        return;
    L24:
        return;
    L5:
        if (this.c == true) goto L8;
        r11 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onRestoreInstanceState(Bundle r10) {
        Intrinsics.checkNotNullParameter(r10, "savedInstanceState");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        if (h.J() == false) goto L6;
        r10.remove("android:dialogShowing");     // Catch: Throwable -> L8
        r10.remove("android:dialogHierarchy");     // Catch: Throwable -> L8
    L6:
        super/*android.app.Dialog*/.onRestoreInstanceState(r10);     // Catch: Throwable -> L8
        Object r11 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r12 = Result.exceptionOrNull-impl(r11);
        if (r12 == null) goto L16;
        HybridLogger r1 = HybridLogger.a;
        HybridLogger.g("SheetBaseDialog", "onRestoreInstanceState error====" + r12.getMessage(), null, null);
        return;
    L16:
        return;
    L8:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onTouchEvent(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        if (this.o == null) goto L31;
        boolean r1 = true;
        if (1 != r10.getAction()) goto L31;
        Context r0 = getContext();
        int r11 = (int) r10.getX();
        int r12 = (int) r10.getY();
        int r13 = ViewConfiguration.get(r0).getScaledWindowTouchSlop();
        if (getWindow() == null) goto L28;
        Window r14 = getWindow();
        if (r14 == null) goto L16;
        View r15 = r14.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L17;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r16 = ThreadMethodProxy.currentThread();
        if (r16 == com.larus.home.impl.utils.c.a) goto L17;
        com.larus.home.impl.utils.c.a(r16, "getDecorView");
    L17:
        if (r15 == null) goto L28;
        int r17 = -r13;
        if (r11 < r17) goto L28;
        if (r12 < r17) goto L28;
        if (r11 > (r15.getWidth() + r13)) goto L28;
        if (r12 > (r15.getHeight() + r13)) goto L28;
        r1 = false;
        goto L28
    L16:
        r15 = null;
    L28:
        if (r1 == false) goto L31;
        com.bytedance.android.anniex.container.popup.c r18 = this.o;
        Intrinsics.checkNotNull(r18);
        shouldWindowCloseOnTouchOutside();
        r18.a();
        com.bytedance.android.anniex.container.popup.c r19 = this.o;
        Intrinsics.checkNotNull(r19);
        r19.b(shouldWindowCloseOnTouchOutside(), PopupCloseType.CLICK_MASK);
    L31:
        return super/*android.app.Dialog*/.onTouchEvent(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setCancelable(boolean r10) {
        super/*android.app.Dialog*/.setCancelable(r10);
        if (this.g == r10) goto L7;
        this.g = r10;
        SheetBaseBehavior<?> r0 = this.f;
        if (r0 == null) goto L7;
        Intrinsics.checkNotNull(r0);
        r0.a = r10;
    L7:
        if (r10 == true) goto L28;
        Map r11 = x26.a.a;
        g r12 = (g) x26.a.a(g.class);
        if (r12 == null) goto L15;
        w26.e r13 = (w26.e) r12.n0(w26.e.class);
        if (r13 == null) goto L15;
        Boolean r14 = r13.M();
        if (r14 == null) goto L15;
        boolean r15 = r14.booleanValue();
    L16:
        if (r15 == false) goto L29;
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L22
        SheetBaseBehavior<?> r17 = this.f;     // Catch: Throwable -> L22
        if (r17 == null) goto L20;
        Intrinsics.checkNotNull(r17);     // Catch: Throwable -> L22
        r17.a = true;     // Catch: Throwable -> L22
    L20:
        Object r18 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L22
    L24:
        Result.exceptionOrNull-impl(r18);
        return;
    L22:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L24
    L29:
        return;
    L15:
        r15 = true;
        goto L16
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setCanceledOnTouchOutside(boolean r10) {
        super/*android.app.Dialog*/.setCanceledOnTouchOutside(r10);
        if (r10 == true) goto L5;
    L7:
        this.i = r10;
        this.j = true;
        View r1 = this.t;
        if (r1 != null) goto L10;
        return;
    L10:
        if (h.g() == false) goto L19;
        if (r10 == true) goto L13;
    L15:
        boolean r11 = false;
    L16:
        if (r11 == false) goto L18;
        r1.setImportantForAccessibility(1);
        r1.setFocusable(true);
        return;
    L18:
        r1.setImportantForAccessibility(2);
        r1.setFocusable(false);
        return;
    L13:
        if (this.s == true) goto L15;
        r11 = true;
        goto L16
    L19:
        if (r10 == false) goto L21;
        r1.setImportantForAccessibility(1);
        r1.setFocusable(true);
        return;
    L21:
        r1.setImportantForAccessibility(2);
        r1.setFocusable(false);
        return;
    L5:
        if (this.g == true) goto L7;
        this.g = true;
        goto L7
    }

    public final void setContentView(View r10) {
        Intrinsics.checkNotNullParameter(r10, "view");
        super.setContentView(wrapInBottomSheet(0, r10, null));
    }

    public final void setContentView(int r10) {
        super.setContentView(wrapInBottomSheet(r10, null, null));
    }

    public final void setContentView(View r10, ViewGroup.LayoutParams r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        super.setContentView(wrapInBottomSheet(0, r10, r11));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View wrapInBottomSheet(int r10, View r11, ViewGroup.LayoutParams r12) {
        Unit r13 = null;
        if (this.d == false) goto L8;
        if (this.e < i16.c.f(480, getContext())) goto L8;
        View r0 = View.inflate(getContext(), 2131558563, null);
    L16:
        CoordinatorLayout r1 = r0.findViewById(2131362993);
        if (r10 == 0) goto L20;
        if (r11 != null) goto L20;
        r11 = getLayoutInflater().inflate(r10, r1, false);
    L20:
        LimitedHeightFrameLayout r14 = (LimitedHeightFrameLayout) r1.findViewById(2131362991);
        this.r = r14;
        if (this.b == true) goto L23;
    L27:
        int r15 = SheetBaseBehavior.f;
        LimitedHeightFrameLayout r16 = this.r;
        Intrinsics.checkNotNull(r16);
        CoordinatorLayout.LayoutParams r17 = r16.getLayoutParams();
        if ((r17 instanceof CoordinatorLayout.LayoutParams) == false) goto L76;
        CoordinatorLayout.Behavior r18 = r17.getBehavior();
        if ((r18 instanceof SheetBaseBehavior) == false) goto L74;
        SheetBaseBehavior<?> r19 = (SheetBaseBehavior) r18;
        this.f = r19;
        Intrinsics.checkNotNull(r19);
        r19.b = this.u;
        SheetBaseBehavior<?> r20 = this.f;
        Intrinsics.checkNotNull(r20);
        r20.a = this.g;
        boolean r21 = true;
        if (this.p == false) goto L34;
        SheetBaseBehavior<?> r22 = this.f;
        Intrinsics.checkNotNull(r22);
        r22.setPeekHeight(this.q);
        SheetBaseBehavior<?> r23 = this.f;
        Intrinsics.checkNotNull(r23);
        r23.c = false;
    L35:
        SheetBaseBehavior<?> r24 = this.f;
        Intrinsics.checkNotNull(r24);
        r24.d = this.m;
        SheetBaseBehavior<?> r25 = this.f;
        Intrinsics.checkNotNull(r25);
        r25.e = this.n;
        if (r12 != null) goto L45;
        Intrinsics.checkNotNull(r11);
        if (r11.getLayoutParams() == null) goto L40;
        FrameLayout.LayoutParams r26 = new FrameLayout.LayoutParams(r11.getLayoutParams());
        r26.gravity = 8388693;
        LimitedHeightFrameLayout r110 = this.r;
        Intrinsics.checkNotNull(r110);
        r110.addView(r11, r26);
    L46:
        LimitedHeightFrameLayout r27 = this.r;
        if (r27 == null) goto L57;
        if (this.b == false) goto L57;
        if (this.d == true) goto L57;
        CoordinatorLayout.LayoutParams r28 = r27.getLayoutParams();
        if ((r28 instanceof CoordinatorLayout.LayoutParams) == false) goto L55;
        CoordinatorLayout.LayoutParams r111 = r28;
        ((ViewGroup.MarginLayoutParams) r111).leftMargin = 0;
        ((ViewGroup.MarginLayoutParams) r111).rightMargin = 0;
        ((ViewGroup.MarginLayoutParams) r111).topMargin = 0;
        ((ViewGroup.MarginLayoutParams) r111).bottomMargin = 0;
    L55:
        r27.setMaxHeight(0);
        ((ViewGroup.LayoutParams) r28).width = -2;
        r27.setLayoutParams(r28);
    L57:
        if (h.g() == false) goto L61;
        this.s = true;
        View r29 = this.t;
        if (r29 == null) goto L61;
        r29.setFocusable(false);
        r29.setImportantForAccessibility(2);
    L61:
        View r30 = r1.findViewById(2131362994);
        r30.setOnClickListener(new e(this));
        this.t = r30;
        LimitedHeightFrameLayout r31 = this.r;
        Intrinsics.checkNotNull(r31);
        ViewCompat.setAccessibilityDelegate(r31, new AnonymousClass4(this));
        LimitedHeightFrameLayout r32 = this.r;
        Intrinsics.checkNotNull(r32);
        r32.setOnTouchListener(f.a);
        if (this.b == false) goto L64;
    L67:
        if (r21 == false) goto L72;
        r0.setFitsSystemWindows(false);
        r1.setFitsSystemWindows(false);
        LimitedHeightFrameLayout r33 = this.r;
        if (r33 == null) goto L72;
        r33.setFitsSystemWindows(false);
    L72:
        return r0;
    L64:
        if (this.c == true) goto L67;
        r21 = false;
        goto L67
    L40:
        Window r34 = getWindow();
        if (r34 == null) goto L43;
        WindowManager.LayoutParams r35 = r34.getAttributes();
        LimitedHeightFrameLayout r112 = this.r;
        Intrinsics.checkNotNull(r112);
        r112.addView(r11, new FrameLayout.LayoutParams(r35.width, r35.height, r35.gravity));
        r13 = Unit.INSTANCE;
    L43:
        if (r13 != null) goto L46;
        LimitedHeightFrameLayout r36 = this.r;
        Intrinsics.checkNotNull(r36);
        r36.addView(r11);
        goto L46
    L45:
        LimitedHeightFrameLayout r37 = this.r;
        Intrinsics.checkNotNull(r37);
        r37.addView(r11, r12);
        goto L46
    L34:
        SheetBaseBehavior<?> r38 = this.f;
        Intrinsics.checkNotNull(r38);
        r38.c = true;
        goto L35
    L74:
        throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
    L76:
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    L23:
        if (this.d == true) goto L27;
        if (r14 == null) goto L27;
        r14.setMaxHeight(i16.c.f(FontWeight.WEIGHT_700, getContext()));
    L8:
        if (this.b == false) goto L13;
        if (this.d == true) goto L13;
        r0 = View.inflate(getContext(), 2131558565, null);
    L13:
        if (this.a == false) goto L15;
        r0 = View.inflate(getContext(), 2131558564, null);
        goto L16
    L15:
        r0 = View.inflate(getContext(), 2131558563, null);
        goto L16
    }

    public SheetBaseDialog(Context r10, boolean r11, boolean r12, boolean r13, boolean r14, int r15) {
        Intrinsics.checkNotNullParameter(r10, "context");
        int r0 = com.bytedance.android.anniex.container.popup.f.a;
        super(r10, 2131954102);
        this.a = r11;
        this.b = r12;
        this.c = r13;
        this.d = r14;
        this.e = r15;
        this.g = true;
        this.h = true;
        this.i = true;
        this.l = new ArrayList();
        this.m = new c(this);
        this.n = new b(this);
        this.q = i16.c.f(484, r10);
        this.u = new d(this);
    }
}
