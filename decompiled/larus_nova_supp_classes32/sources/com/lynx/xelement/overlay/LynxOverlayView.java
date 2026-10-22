package com.lynx.xelement.overlay;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.utils.logger.FLogger;
import com.lynx.canvas.camera.CameraSize;
import com.lynx.react.bridge.ReadableType;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.b1;
import com.lynx.tasm.behavior.event.EventTarget;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.UIGroup;
import com.lynx.tasm.behavior.ui.k;
import com.lynx.tasm.behavior.ui.list.UIList;
import com.lynx.tasm.behavior.ui.scroll.AndroidScrollView;
import com.lynx.tasm.behavior.ui.scroll.UIScrollView;
import com.lynx.tasm.event.EventsListener;
import com.lynx.tasm.utils.SizeValue;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\r\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001)J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0007J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0007J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\nH\u0007J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\nH\u0007J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0007H\u0007J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\nH\u0007J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0003H\u0007J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0007H\u0007J\u0012\u0010\u001a\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003H\u0007J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\nH\u0007J\u0010\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001dH\u0007J\u0010\u0010!\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0003H\u0007J\u0010\u0010#\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\nH\u0007J\u0010\u0010$\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0003H\u0007J\u0010\u0010&\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\nH\u0007J\u0012\u0010(\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010\u0007H\u0017¨\u0006*"}, d2 = {"Lcom/lynx/xelement/overlay/LynxOverlayView;", "Lcom/lynx/tasm/behavior/ui/UIGroup;", "Lcom/lynx/tasm/behavior/ui/view/a;", NameKeys.UnloadStrategy_No_Strategy, "style", NameKeys.UnloadStrategy_No_Strategy, "setAndroidNavigationBarStyle", "Lf6a/a;", LynxUIOverlay.PROP_VISIBLE, "setVisible", NameKeys.UnloadStrategy_No_Strategy, "fullScreen", "setFullScreen", "hide", "hideNavBar", "lazyInitContext", "setLazyInitContext", "statusBarTranslucent", "setStatusBarTranslucent", "isCutOut", "setCutOutMode", "id", "setNestScroll", "eventsPassThrough", "setEventsPassThrough", "value", "setStatusBarTranslucentStyle", "boolean", "setAlwaysShow", NameKeys.UnloadStrategy_No_Strategy, LynxUIOverlay.PROP_LEVEL, "setLevel", "tag", "setContainerPopupTag", "adapt", "setAdaptEdgeToEdge", "setAndroidSetSoftInputMode", "enable", "setNativeEventPass", "ignoreFocus", "setIgnoreFocus", "a", "Overlay_release"}, k = 1, mv = {1, 6, 0})
public final class LynxOverlayView extends UIGroup<com.lynx.tasm.behavior.ui.view.a> {
    public static final /* synthetic */ int H = 0;
    public final int[] A;
    public final int[] B;
    public final b1 C;
    public ViewTreeObserver D;
    public com.lynx.xelement.overlay.d E;
    public e F;
    public f G;
    public final LynxUIOverlay a;
    public int b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public String h;
    public boolean i;
    public String j;
    public String k;
    public String l;
    public LynxBaseUI m;
    public boolean n;
    public boolean o;
    public final boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public VelocityTracker u;
    public float v;
    public float w;
    public Boolean x;
    public final LynxOverlayDialog y;
    public final c z;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ReadableType.values().length];
            r0[ReadableType.String.ordinal()] = 1;
            r0[ReadableType.Boolean.ordinal()] = 2;
            a = r0;
        }
    }

    public static final class c extends com.lynx.tasm.behavior.ui.view.a {
        public final /* synthetic */ LynxOverlayView a;

        @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
        public /* bridge */ /* synthetic */ int getRendererHostHeight() {
            return x6a.d.e(this);
        }

        @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
        public /* bridge */ /* synthetic */ int getRendererHostScrollX() {
            return x6a.d.f(this);
        }

        @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
        public /* bridge */ /* synthetic */ int getRendererHostScrollY() {
            return x6a.d.g(this);
        }

        @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
        public /* bridge */ /* synthetic */ int getRendererHostWidth() {
            return x6a.d.h(this);
        }

        @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
        public /* bridge */ /* synthetic */ void setClipChildrenForRenderer(boolean r1) {
            x6a.d.k(this, r1);
        }

        @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
        public /* bridge */ /* synthetic */ void setWillNotDrawForRenderer(boolean r1) {
            x6a.d.l(this, r1);
        }

        public c(LynxContext r1, LynxOverlayView r2) {
            this.a = r2;
            new LinkedHashMap();
            super(r1);
        }

        @Override // com.lynx.tasm.behavior.ui.view.a, android.view.View
        public final void onMeasure(int r1, int r2) {
            setMeasuredDimension(View.MeasureSpec.getSize(r1), View.MeasureSpec.getSize(r2));
            this.a.measureChildren();
        }

        @Override // com.lynx.tasm.behavior.ui.view.a, android.view.ViewGroup, android.view.View
        public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
            this.a.layout();
        }
    }

    public static final class d implements LynxOverlayDialog.b {
        public final /* synthetic */ LynxOverlayView a;

        public d(LynxOverlayView r1) {
            this.a = r1;
        }

        @Override // com.lynx.xelement.overlay.LynxOverlayDialog.b
        public final boolean dispatchTouchEvent(MotionEvent r18) {
            Intrinsics.checkNotNullParameter(r18, "ev");
            VelocityTracker r2 = this.a.u;
            if (r2 == null) goto L5;
            r2.addMovement(r18);
        L5:
            int r3 = r18.getAction();
            if (r3 == 0) goto L37;
            boolean r6 = true;
            if (r3 == 1) goto L36;
            if (r3 != 2) goto L40;
            LynxOverlayView r4 = this.a;
            r4.b = 1;
            if (r4.q == false) goto L40;
            if (r4.x != null) goto L40;
            if (Math.abs(r18.getY() - this.a.w) <= 0.0f) goto L18;
        L19:
            LynxOverlayView r5 = this.a;
            if (r5.m == null) goto L29;
            if (r5.n == false) goto L24;
        L26:
            r6 = false;
        L27:
            Boolean r7 = Boolean.valueOf(r6);
        L35:
            r5.x = r7;
            LynxOverlayView r8 = this.a;
            r8.w = r18.getY();
            goto L40
        L24:
            if ((r18.getY() - this.a.w) <= 0.0f) goto L26;
        L29:
            if (r5.n == false) goto L31;
        L33:
            r6 = false;
        L34:
            r7 = Boolean.valueOf(r6);
            goto L35
        L31:
            if (Math.abs(r18.getY() - this.a.w) <= Math.abs(r18.getX() - this.a.v)) goto L33;
        L18:
            if (Math.abs(r18.getX() - this.a.v) > 0.0f) goto L19;
        L40:
            VelocityTracker r9 = this.a.u;
            if (r9 == null) goto L43;
            r9.computeCurrentVelocity(1000);
        L43:
            LynxOverlayView r10 = this.a;
            if (r10.q == true) goto L46;
        L56:
            LynxOverlayView r11 = this.a;
            if (r11.r == false) goto L67;
            float r13 = LynxOverlayView.P(r11, r18.getRawX());
            float r14 = LynxOverlayView.P(this.a, r18.getRawY());
            VelocityTracker r1 = this.a.u;
            if (r1 == null) goto L61;
            float r15 = r1.getXVelocity();
        L62:
            VelocityTracker r12 = this.a.u;
            if (r12 == null) goto L65;
            float r16 = r12.getYVelocity();
        L66:
            int r17 = this.a.b;
            LynxOverlayView.Q(r11, "overlaytouch", r13, r14, r15, r16);
            goto L67
        L65:
            r16 = 0.0f;
            goto L66
        L61:
            r15 = 0.0f;
        L67:
            Boolean r19 = this.a.x;
            if (r19 != null) goto L70;
            return false;
        L70:
            return r19.booleanValue();
        L46:
            if (Intrinsics.areEqual(r10.x, Boolean.FALSE) == true) goto L56;
            LynxOverlayView r20 = this.a;
            float r21 = LynxOverlayView.P(r20, r18.getX());
            float r22 = LynxOverlayView.P(this.a, r18.getY());
            VelocityTracker r23 = this.a.u;
            if (r23 == null) goto L50;
            float r24 = r23.getXVelocity();
        L51:
            VelocityTracker r25 = this.a.u;
            if (r25 == null) goto L54;
            float r110 = r25.getYVelocity();
        L55:
            int r26 = this.a.b;
            LynxOverlayView.Q(r20, "overlaymoved", r21, r22, r24, r110);
            goto L56
        L54:
            r110 = 0.0f;
            goto L55
        L50:
            r24 = 0.0f;
            goto L51
        L36:
            this.a.b = 2;
            goto L40
        L37:
            LynxOverlayView r27 = this.a;
            r27.b = 0;
            if (r27.q == false) goto L40;
            r27.m = null;
            r27.n = r27.S(r27.hitTest(r18.getX(), r18.getY()));
            LynxOverlayView r28 = this.a;
            r28.x = null;
            r28.v = r18.getX();
            LynxOverlayView r29 = this.a;
            r29.w = r18.getY();
            goto L40
        }
    }

    static {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean isOverlay() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public final boolean isUserInteractionEnabled() {
        return false;
    }

    public final void R() {
        Window r0 = this.y.getWindow();
        if (r0 != null) goto L5;
        return;
    L5:
        Activity r1 = com.lynx.tasm.utils.a.getActivity(getLynxContext());
        Boolean r2 = null;
        if (r1 == null) goto L8;
        Window r3 = r1.getWindow();
    L9:
        if (r3 != null) goto L11;
        return;
    L11:
        String r4 = this.j;
        int r5 = r4.hashCode();
        boolean r6 = false;
        if (r5 == (-1726194350)) goto L27;
        if (r5 == 3075958) goto L23;
        if (r5 == 102970646) goto L19;
    L28:
        int r7 = r3.getNavigationBarColor();
    L30:
        r0.setNavigationBarColor(r7);
        if (Build.VERSION.SDK_INT >= 29) goto L33;
    L38:
        String r8 = this.j;
        if (Intrinsics.areEqual(r8, "light") == false) goto L42;
        r2 = Boolean.TRUE;
    L47:
        if (r2 == null) goto L53;
        WindowInsetsControllerCompat r9 = WindowCompat.getInsetsController(r0, M(r0));
        if (r9 == null) goto L54;
        r9.setAppearanceLightNavigationBars(r2.booleanValue());
        return;
    L54:
        return;
    L53:
        return;
    L42:
        if (Intrinsics.areEqual(r8, LynxUIOverlay.PROP_STATUS_BAR_TRANSLUCENT_STYLE_DARK) == false) goto L44;
        r2 = Boolean.FALSE;
        goto L47
    L44:
        WindowInsetsControllerCompat r10 = WindowCompat.getInsetsController(r3, M(r3));
        if (r10 == null) goto L47;
        r2 = Boolean.valueOf(r10.isAppearanceLightNavigationBars());
        goto L47
    L33:
        if (Intrinsics.areEqual(this.j, "transparent") == false) goto L35;
    L37:
        r0.setNavigationBarContrastEnforced(r6);
        goto L38
    L35:
        if (r3.isNavigationBarContrastEnforced() == false) goto L37;
        r6 = true;
        goto L37
    L19:
        if (r4.equals("light") == false) goto L28;
        r7 = -1;
        goto L30
    L23:
        if (r4.equals(LynxUIOverlay.PROP_STATUS_BAR_TRANSLUCENT_STYLE_DARK) == false) goto L28;
        r7 = -16777216;
        goto L30
    L27:
        if (r4.equals("transparent") == false) goto L28;
        r7 = 0;
        goto L30
    L8:
        r3 = null;
        goto L9
    }

    public final void V() {
        if (this.y.isShowing() == true) goto L12;
        return;
    L12:
        U(true);     // Catch: RuntimeException -> L7 WindowManager.BadTokenException -> L9
        N(this.y);     // Catch: RuntimeException -> L7 WindowManager.BadTokenException -> L9
    L16:
        return;
    L9:
        e = move-exception;
        LLog.w("overlay", e.toString());
        return;
    L7:
        e = move-exception;
        LLog.w("overlay", e.toString());
    }

    public final void b0() {
        if (this.p == false) goto L5;
        d0();
    L5:
        int[] r0 = this.A;
        int r2 = r0[0];
        if (r2 != Integer.MIN_VALUE) goto L8;
        r2 = 0;
    L8:
        int r1 = r0[1];
        if (r1 != Integer.MIN_VALUE) goto L11;
        r1 = 0;
    L11:
        int[] r3 = this.B;
        if (r3[0] == r2) goto L14;
    L16:
        r3[0] = r2;
        r3[1] = r1;
        getLynxContext().setPlatformEventRootOffset(getSign(), r2, r1);
        return;
    L14:
        if (r3[1] != r1) goto L16;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void destroy() {
        if (this.y.isShowing() == true) goto L13;
    L11:
        super.destroy();
        return;
    L13:
        U(false);     // Catch: RuntimeException -> L7 WindowManager.BadTokenException -> L9
        N(this.y);     // Catch: RuntimeException -> L7 WindowManager.BadTokenException -> L9
    L9:
        e = move-exception;
        LLog.w("overlay", e.toString());
    L7:
        e = move-exception;
        LLog.w("overlay", e.toString());
        goto L11
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final Rect getBoundingClientRect() {
        if (this.p == false) goto L8;
        if (this.A[0] != Integer.MIN_VALUE) goto L8;
        d0();
    L8:
        return super.getBoundingClientRect();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final Window getWindow() {
        LynxOverlayDialog r0 = this.y;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getWindow();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public final boolean ignoreFocus() {
        if (this.mIgnoreFocus != EventTarget.EnableStatus.Enable) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public final EventTarget.PointerEventsValue pointerEvents() {
        EventTarget.PointerEventsValue r0 = this.mPointerEvents;
        EventTarget.PointerEventsValue r1 = EventTarget.PointerEventsValue.None;
        if (r0 != r1) goto L6;
        return r1;
    L6:
        return EventTarget.PointerEventsValue.Auto;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [android.view.ViewTreeObserver$OnDrawListener, com.lynx.xelement.overlay.f] */
    /* JADX WARN: Type inference failed for: r0v8, types: [android.view.ViewTreeObserver$OnGlobalLayoutListener, com.lynx.xelement.overlay.d] */
    /* JADX WARN: Type inference failed for: r0v9, types: [android.view.ViewTreeObserver$OnScrollChangedListener, com.lynx.xelement.overlay.e] */
    public final void a0() {
        Activity r0 = com.lynx.tasm.utils.a.getActivity(getLynxContext());
        if (this.i == false) goto L9;
        LynxOverlayDialog r1 = this.y;
        Field r5 = Dialog.class.getDeclaredField("mContext");     // Catch: Exception -> L7
        r5.setAccessible(true);     // Catch: Exception -> L7
        r5.set(r1, r0);     // Catch: Exception -> L7
        r5.setAccessible(false);     // Catch: Exception -> L7
    L7:
        e = move-exception;
        LLog.e("overlay", e.toString());
    L9:
        Context r2 = null;
        ViewTreeObserver r3 = 0;
        if (r0 != null) goto L12;
        LynxContext r4 = getLynxContext();
        if (r4 == null) goto L52;
        r2 = r4.getBaseContext();
    L52:
        X(1, r2);
        return;
    L12:
        if (r0.isFinishing() == true) goto L61;
        List<com.lynx.xelement.overlay.a.b> r6 = com.lynx.xelement.overlay.a.a;
        String r7 = this.k;
        if (r7 == null) goto L25;
        Iterator r8 = ((ArrayList) com.lynx.xelement.overlay.a.a).iterator();
    L17:
        if (r8.hasNext() == false) goto L21;
        Object r9 = r8.next();
        if (Intrinsics.areEqual(((com.lynx.xelement.overlay.a.b) r9).a, r7) == false) goto L17;
    L23:
        if (((com.lynx.xelement.overlay.a.b) r9) == null) goto L25;
        boolean r10 = true;
    L26:
        if (r10 == true) goto L62;
        List<com.lynx.xelement.overlay.a.b> r11 = com.lynx.xelement.overlay.a.a;     // Catch: RuntimeException -> L45 WindowManager.BadTokenException -> L47
        this.k = com.lynx.xelement.overlay.a.a(this.y);     // Catch: RuntimeException -> L45 WindowManager.BadTokenException -> L47
        this.y.getClass();     // Catch: RuntimeException -> L45 WindowManager.BadTokenException -> L47
        int r12 = LynxOverlayDialog.a(r0);     // Catch: RuntimeException -> L45 WindowManager.BadTokenException -> L47
        if (r12 < 0) goto L32;
        this.s = false;     // Catch: RuntimeException -> L45 WindowManager.BadTokenException -> L47
        this.y.setOnDismissListener(new com.lynx.xelement.overlay.b(this));     // Catch: RuntimeException -> L45 WindowManager.BadTokenException -> L47
        this.y.setOnCancelListener(new com.lynx.xelement.overlay.c(this));     // Catch: RuntimeException -> L45 WindowManager.BadTokenException -> L47
        O(this.y);     // Catch: RuntimeException -> L45 WindowManager.BadTokenException -> L47
        R();     // Catch: RuntimeException -> L45 WindowManager.BadTokenException -> L47
        if (this.y.isShowing() == false) goto L32;
        Z(true);     // Catch: RuntimeException -> L45 WindowManager.BadTokenException -> L47
    L32:
        X(r12, r0);     // Catch: RuntimeException -> L45 WindowManager.BadTokenException -> L47
        c r13 = this.z;     // Catch: RuntimeException -> L45 WindowManager.BadTokenException -> L47
        if (r13 == null) goto L35;
        r3 = r13.getViewTreeObserver();     // Catch: RuntimeException -> L45 WindowManager.BadTokenException -> L47
    L35:
        this.D = r3;     // Catch: RuntimeException -> L45 WindowManager.BadTokenException -> L47
        ?? r14 = new com.lynx.xelement.overlay.d(this);     // Catch: RuntimeException -> L45 WindowManager.BadTokenException -> L47
        this.E = r14;     // Catch: RuntimeException -> L45 WindowManager.BadTokenException -> L47
        if (r3 == 0) goto L38;
        r3.addOnGlobalLayoutListener(r14);     // Catch: RuntimeException -> L45 WindowManager.BadTokenException -> L47
    L38:
        ?? r15 = new e(this);     // Catch: RuntimeException -> L45 WindowManager.BadTokenException -> L47
        this.F = r15;     // Catch: RuntimeException -> L45 WindowManager.BadTokenException -> L47
        ViewTreeObserver r16 = this.D;     // Catch: RuntimeException -> L45 WindowManager.BadTokenException -> L47
        if (r16 == 0) goto L41;
        r16.addOnScrollChangedListener(r15);     // Catch: RuntimeException -> L45 WindowManager.BadTokenException -> L47
    L41:
        ?? r17 = new f(this);     // Catch: RuntimeException -> L45 WindowManager.BadTokenException -> L47
        this.G = r17;     // Catch: RuntimeException -> L45 WindowManager.BadTokenException -> L47
        ViewTreeObserver r18 = this.D;     // Catch: RuntimeException -> L45 WindowManager.BadTokenException -> L47
        if (r18 == 0) goto L63;
        r18.addOnDrawListener(r17);     // Catch: RuntimeException -> L45 WindowManager.BadTokenException -> L47
    L66:
        return;
    L63:
        return;
    L47:
        e = move-exception;
        LLog.w("overlay", e.toString());
        return;
    L45:
        e = move-exception;
        LLog.w("overlay", e.toString());
        return;
    L62:
        return;
    L21:
        r9 = null;
    L25:
        r10 = false;
        goto L26
    }

    public final void d0() {
        int[] r2 = {0, 0};
        int[] r1 = {0, 0};
        getLynxContext().getUIBody().getBodyView().getLocationOnScreen(r2);
        ((com.lynx.tasm.behavior.ui.view.a) this.mView).getLocationOnScreen(r1);
        int[] r0 = this.A;
        r0[0] = r1[0] - r2[0];
        r0[1] = r1[1] - r2[1];
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void layout() {
        super.layout();
        if (this.p == false) goto L8;
        if (this.y.isShowing() == false) goto L8;
        b0();
        return;
    L8:
        if (this.p == false) goto L12;
        d0();
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onAttach() {
        super.onAttach();
        if (this.q == false) goto L6;
        this.u = VelocityTracker.obtain();
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onDetach() {
        super.onDetach();
        if (this.q == false) goto L12;
        VelocityTracker r0 = this.u;     // Catch: Throwable -> L8
        if (r0 == null) goto L10;
        r0.recycle();     // Catch: Throwable -> L8
    L10:
        this.u = null;
    L8:
        th = move-exception;
        LLog.e("overlay", th.toString());
    L12:
        if (this.o == true) goto L17;
        V();
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.ui.k
    public final void requestLayout() {
        super.requestLayout();
        if (this.a.getTransitionAnimator() == null) goto L5;
    L6:
        this.z.invalidate();
        return;
    L5:
        if (this.a.enableLayoutAnimation() == true) goto L6;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final int[] getOffsetDescendantRectToLynxView() {
        return this.A;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final b1 getTouchEventDispatcher() {
        return this.C;
    }

    public static View M(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static void N(LynxOverlayDialog r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public static void O(LynxOverlayDialog r1) {
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

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean T(LynxBaseUI r4) {
        if ((r4 instanceof UIScrollView) == false) goto L12;
        UIScrollView r0 = (UIScrollView) r4;
        if (((AndroidScrollView) r0.getView()).u == true) goto L12;
        if (((AndroidScrollView) r0.getView()).getRealScrollY() > 0) goto L28;
        return false;
    L28:
        return true;
    L12:
        if ((r4 instanceof UIList) == false) goto L21;
        UIList r1 = (UIList) r4;
        if (r1.x == false) goto L21;
        if (((RecyclerView) r1.getView()).computeVerticalScrollOffset() > 0) goto L29;
        return false;
    L29:
        return true;
    L21:
        if ((r4 instanceof LynxUI) == true) goto L23;
        return false;
    L23:
        if (((LynxUI) r4).getView().getScrollY() > 0) goto L30;
        return false;
    L30:
        return true;
    }

    public final boolean S(EventTarget r3) {
        if (r3 != null) goto L5;
    L31:
        return false;
    L5:
        if ((r3 instanceof LynxBaseUI) == false) goto L31;
        if ((r3 instanceof LynxOverlayView) == true) goto L31;
        String r1 = this.l;
        if (r1 != null) goto L12;
    L15:
        boolean r2 = true;
    L16:
        if (r2 == false) goto L18;
        return false;
    L18:
        LynxBaseUI r0 = this.m;
        if (r0 == null) goto L23;
        return T(r0);
    L23:
        if ((r3 instanceof UIGroup) == true) goto L25;
        S(((LynxBaseUI) r3).parent());
    L25:
        LynxBaseUI r4 = (LynxBaseUI) r3;
        if (Intrinsics.areEqual(this.l, r4.getIdSelector()) == false) goto L30;
        this.m = r4;
        return T(r4);
    L30:
        return S(r4.parent());
    L12:
        if (r1.length() == 0) goto L15;
        r2 = false;
        goto L16
    }

    public final void U(boolean r6) {
        if (this.s == false) goto L5;
        return;
    L5:
        boolean r0 = true;
        this.s = true;
        if (this.t == false) goto L8;
        Z(false);
    L8:
        if (r6 == false) goto L10;
        getLynxContext().getEventEmitter().sendCustomEvent(new m7a.a(getSign(), "dismissoverlay"));
    L10:
        List<com.lynx.xelement.overlay.a.b> r7 = com.lynx.xelement.overlay.a.a;
        String r8 = this.k;
        if (r8 == null) goto L18;
        Iterator r1 = ((ArrayList) com.lynx.xelement.overlay.a.a).iterator();
    L14:
        if (r1.hasNext() == false) goto L18;
        com.lynx.xelement.overlay.a.b r3 = (com.lynx.xelement.overlay.a.b) r1.next();
        if (Intrinsics.areEqual(r3.a, r8) == false) goto L14;
        ((ArrayList) com.lynx.xelement.overlay.a.a).remove(r3);
    L18:
        ViewTreeObserver r9 = this.D;
        if (r9 != null) goto L21;
    L23:
        r0 = false;
    L25:
        if (r0 == false) goto L27;
        ViewTreeObserver r2 = this.D;
    L33:
        if (r2 == null) goto L43;
        com.lynx.xelement.overlay.d r4 = this.E;
        if (r4 == null) goto L37;
        r2.removeOnGlobalLayoutListener(r4);
    L37:
        e r5 = this.F;
        if (r5 == null) goto L40;
        r2.removeOnScrollChangedListener(r5);
    L40:
        f r10 = this.G;
        if (r10 == null) goto L43;
        r2.removeOnDrawListener(r10);
    L43:
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = null;
        return;
    L27:
        r2 = this.z.getViewTreeObserver();
        if (r2 != null) goto L30;
    L32:
        r2 = null;
        goto L33
    L30:
        if (r2.isAlive() == false) goto L32;
    L21:
        if (r9.isAlive() != true) goto L23;
        goto L23
    }

    public final void Y(int r2) {
        Window r0 = this.y.getWindow();
        if (r0 == null) goto L6;
        r0.setType(r2);
        return;
    }

    public final void Z(boolean r4) {
        if (r4 == false) goto L4;
        b0();
    L5:
        getLynxContext().setPlatformEventRootActive(getSign(), r4);
        this.t = r4;
        return;
    L4:
        int[] r0 = this.B;
        r0[0] = Integer.MIN_VALUE;
        r0[1] = Integer.MIN_VALUE;
        goto L5
    }

    public final void c0(boolean r6) {
        int r0 = Build.VERSION.SDK_INT;
        if (r6 == false) goto L14;
        Window r3 = this.y.getWindow();
        if (r3 == null) goto L7;
        r3.addFlags(65792);
    L7:
        Window r4 = this.y.getWindow();
        if (r4 == null) goto L10;
        r4.addFlags(Integer.MIN_VALUE);
    L10:
        Window r2 = this.y.getWindow();
        if (r2 == null) goto L23;
        r2.setStatusBarColor(0);
    L23:
        View r5 = null;
        if (r0 >= 23) goto L26;
    L36:
        LynxOverlayDialog r1 = this.y;
        if (r1 == null) goto L43;
        Window r7 = r1.getWindow();
        if (r7 == null) goto L43;
        View r8 = M(r7);
        if (r8 == null) goto L43;
        Integer r9 = Integer.valueOf(r8.getSystemUiVisibility());
    L44:
        Intrinsics.checkNotNull(r9);
        int r10 = r9.intValue();
        int r11 = CameraSize.highHeight;
    L45:
        int r12 = r10 | r11;
        if (r6 == false) goto L53;
        Window r13 = this.y.getWindow();
        if (r13 == null) goto L50;
        r5 = M(r13);
    L50:
        if (r5 == null) goto L61;
        r5.setSystemUiVisibility(r12);
        return;
    L61:
        return;
    L53:
        Window r14 = this.y.getWindow();
        if (r14 == null) goto L56;
        r5 = M(r14);
    L56:
        if (r5 == null) goto L62;
        r5.setSystemUiVisibility(0);
        return;
    L62:
        return;
    L43:
        r9 = null;
        goto L44
    L26:
        if (Intrinsics.areEqual(this.h, LynxUIOverlay.PROP_STATUS_BAR_TRANSLUCENT_STYLE_LITE) == false) goto L36;
        LynxOverlayDialog r15 = this.y;
        if (r15 == null) goto L34;
        Window r16 = r15.getWindow();
        if (r16 == null) goto L34;
        View r17 = M(r16);
        if (r17 == null) goto L34;
        Integer r18 = Integer.valueOf(r17.getSystemUiVisibility());
    L35:
        Intrinsics.checkNotNull(r18);
        r10 = r18.intValue();
        r11 = 9472;
    L34:
        r18 = null;
        goto L35
    L14:
        Window r19 = this.y.getWindow();
        if (r19 == null) goto L17;
        r19.clearFlags(256);
    L17:
        Window r20 = this.y.getWindow();
        if (r20 == null) goto L20;
        r20.clearFlags(65536);
    L20:
        Window r21 = this.y.getWindow();
        if (r21 == null) goto L23;
        r21.clearFlags(Integer.MIN_VALUE);
        goto L23
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r2) {
        return new com.lynx.tasm.behavior.ui.view.a(r2);
    }

    @LynxProp(name = LynxUIOverlay.PROP_ANDROID_HIDE_NAVIGATION_BAR)
    public final void hideNavBar(boolean r3) {
        View r0 = null;
        if (r3 == false) goto L20;
        LynxOverlayDialog r4 = this.y;
        if (r4 == null) goto L11;
        Window r5 = r4.getWindow();
        if (r5 == null) goto L11;
        View r6 = M(r5);
        if (r6 == null) goto L11;
        Integer r7 = Integer.valueOf(r6.getSystemUiVisibility());
    L12:
        Intrinsics.checkNotNull(r7);
        int r8 = r7.intValue() | 4866;
        LynxOverlayDialog r1 = this.y;
        if (r1 == null) goto L17;
        Window r2 = r1.getWindow();
        if (r2 == null) goto L17;
        r0 = M(r2);
    L17:
        if (r0 == null) goto L30;
        r0.setSystemUiVisibility(r8);
        return;
    L30:
        return;
    L11:
        r7 = null;
        goto L12
    L20:
        LynxOverlayDialog r9 = this.y;
        if (r9 == null) goto L25;
        Window r10 = r9.getWindow();
        if (r10 == null) goto L25;
        r0 = M(r10);
    L25:
        if (r0 == null) goto L31;
        r0.setSystemUiVisibility(256);
        return;
    }

    @LynxProp(name = LynxUIOverlay.PROP_ADAPT_EDGE_TO_EDGE)
    public final void setAdaptEdgeToEdge(boolean r4) {
        Window r0 = getWindow();
        if (r0 != null) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT < 35) goto L9;
        WindowCompat.setDecorFitsSystemWindows(r0, !r4);
        return;
    }

    @LynxProp(name = LynxUIOverlay.PROP_ALWAYS_SHOW)
    public final void setAlwaysShow(boolean r1) {
        this.o = r1;
    }

    @LynxProp(name = LynxUIOverlay.PROP_ANDROID_NAVIGATION_BAR_STYLE)
    public final void setAndroidNavigationBarStyle(String r1) {
        if (r1 != null) goto L4;
        r1 = "auto";
    L4:
        this.j = r1;
        if (this.y.isShowing() == false) goto L8;
        R();
        return;
    }

    @LynxProp(name = "android-set-soft-input-mode")
    public final void setAndroidSetSoftInputMode(String r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        if ("unspecified".equals(r2) == false) goto L8;
        Window r3 = this.y.getWindow();
        if (r3 == null) goto L23;
        r3.setSoftInputMode(0);
        return;
    L23:
        return;
    L8:
        if ("nothing".equals(r2) == false) goto L13;
        Window r4 = this.y.getWindow();
        if (r4 == null) goto L25;
        r4.setSoftInputMode(48);
        return;
    L25:
        return;
    L13:
        if ("pan".equals(r2) == false) goto L18;
        Window r5 = this.y.getWindow();
        if (r5 == null) goto L27;
        r5.setSoftInputMode(32);
        return;
    L27:
        return;
    L18:
        if ("resize".equals(r2) == false) goto L29;
        Window r6 = this.y.getWindow();
        if (r6 == null) goto L30;
        r6.setSoftInputMode(16);
        return;
    L30:
        return;
    }

    @LynxProp(name = LynxUIOverlay.PROP_CONTAINER_POPUP_TAG)
    public final void setContainerPopupTag(String r2) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        this.y.d = r2;
    }

    @LynxProp(name = LynxUIOverlay.CUT_OUT_MODE)
    public final void setCutOutMode(boolean r4) {
        this.e = r4;
        LynxOverlayDialog r0 = this.y;
        if (r0 == null) goto L15;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L16;
        WindowManager.LayoutParams r2 = r1.getAttributes();
        if (r2 != null) goto L9;
        return;
    L9:
        if (Build.VERSION.SDK_INT < 28) goto L18;
        if (r4 == false) goto L12;
        int r5 = 1;
    L13:
        r2.layoutInDisplayCutoutMode = r5;
        return;
    L12:
        r5 = 2;
        goto L13
    L18:
        return;
    L16:
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setEvents(Map<String, EventsListener> r2) {
        super.setEvents(r2);
        if (r2 != null) goto L5;
        return;
    L5:
        this.q = r2.containsKey("overlaymoved");
        boolean r3 = r2.containsKey("overlaytouch");
        this.r = r3;
        if (this.q == true) goto L8;
        if (r3 == true) goto L8;
        return;
    L8:
        this.u = VelocityTracker.obtain();
        LynxOverlayDialog r4 = this.y;
        if (r4 == null) goto L13;
        r4.b = new d(this);
        return;
    }

    @LynxProp(name = LynxUIOverlay.PROP_EVENTS_PASS_THROUGH)
    public final void setEventsPassThrough(f6a.a r4) {
        Intrinsics.checkNotNullParameter(r4, "eventsPassThrough");
        this.g = true;
        ReadableType r1 = r4.getType();
        if (r1 != null) goto L5;
        int r2 = -1;
    L6:
        if (r2 != 1) goto L8;
        String r5 = r4.asString();
        Intrinsics.checkNotNull(r5);
        this.f = Boolean.parseBoolean(r5);
        return;
    L8:
        if (r2 != 2) goto L14;
        this.f = r4.asBoolean();
        return;
    L14:
        return;
    L5:
        r2 = b.a[r1.ordinal()];
        goto L6
    }

    @LynxProp(name = LynxUIOverlay.PROP_FULL_SCREEN)
    public final void setFullScreen(boolean r3) {
        if (r3 == false) goto L20;
        LynxOverlayDialog r4 = this.y;
        View r0 = null;
        if (r4 == null) goto L10;
        Window r5 = r4.getWindow();
        if (r5 == null) goto L10;
        View r6 = M(r5);
        if (r6 == null) goto L10;
        Integer r7 = Integer.valueOf(r6.getSystemUiVisibility());
    L11:
        Intrinsics.checkNotNull(r7);
        int r8 = r7.intValue() | 5894;
        LynxOverlayDialog r1 = this.y;
        if (r1 == null) goto L16;
        Window r2 = r1.getWindow();
        if (r2 == null) goto L16;
        r0 = M(r2);
    L16:
        if (r0 == null) goto L21;
        r0.setSystemUiVisibility(r8);
        return;
    L21:
        return;
    L10:
        r7 = null;
        goto L11
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    @LynxProp(name = "ignore-focus")
    public void setIgnoreFocus(f6a.a r3) {
        super.setIgnoreFocus(r3);
        if (this.mIgnoreFocus != EventTarget.EnableStatus.Enable) goto L5;
        boolean r4 = true;
    L6:
        this.z.setFocusable(!r4);
        this.z.setFocusableInTouchMode(!r4);
        if (r4 == false) goto L14;
        Window r5 = this.y.getWindow();
        if (r5 == null) goto L11;
        r5.clearFlags(131072);
    L11:
        Window r6 = this.y.getWindow();
        if (r6 == null) goto L18;
        r6.setFlags(8, 8);
        return;
    L18:
        return;
    L14:
        Window r7 = this.y.getWindow();
        if (r7 == null) goto L20;
        r7.clearFlags(8);
        return;
    L20:
        return;
    L5:
        r4 = false;
        goto L6
    }

    @LynxProp(name = LynxUIOverlay.PROP_ANDROID_LAZY_INIT_CONTEXT)
    public final void setLazyInitContext(boolean r1) {
        this.i = r1;
    }

    @LynxProp(defaultInt = 1, name = LynxUIOverlay.PROP_LEVEL)
    public final void setLevel(int r6) {
        Number r0 = this.y.e;
        if ((r0 instanceof Integer) == false) goto L9;
        if (r6 != r0.intValue()) goto L9;
        return;
    L9:
        if (this.y.isShowing() == false) goto L13;
        LynxError r7 = new LynxError(229800, "Overlay set Level error!", "The visible attribute needs to default to false. After creation, change visible to true at the appropriate time", "error");
        r7.setLogBoxOnly(true);
        getLynxContext().handleLynxError(r7);
        return;
    L13:
        if (r6 == 1) goto L23;
        if (r6 != 2) goto L16;
        Y(1);
    L24:
        LynxOverlayDialog r1 = this.y;
        Integer r8 = Integer.valueOf(r6);
        r1.getClass();
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        r1.e = r8;
        return;
    L16:
        if (r6 != 3) goto L18;
        Y(1002);
        goto L24
    L18:
        if (r6 == 4) goto L20;
        Y(2);
        goto L24
    L20:
        Y(1000);
        goto L24
    L23:
        Y(2);
        goto L24
    }

    @LynxProp(name = "android-native-event-pass")
    public final void setNativeEventPass(boolean r2) {
        if (r2 == false) goto L7;
        Window r3 = this.y.getWindow();
        if (r3 == null) goto L11;
        r3.addFlags(16);
        return;
    L11:
        return;
    L7:
        Window r4 = this.y.getWindow();
        if (r4 == null) goto L13;
        r4.clearFlags(16);
        return;
    }

    @LynxProp(name = LynxUIOverlay.PROP_NEST_SCROLL)
    public final void setNestScroll(String r2) {
        Intrinsics.checkNotNullParameter(r2, "id");
        this.l = r2;
        this.m = null;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setParent(k r1) {
        super.setParent(r1);
        if (r1 != null) goto L6;
        V();
        return;
    L6:
        if (this.c == false) goto L10;
        a0();
        return;
    }

    @LynxProp(name = LynxUIOverlay.PROP_STATUS_BAR_TRANSLUCENT)
    public final void setStatusBarTranslucent(f6a.a r3) {
        Intrinsics.checkNotNullParameter(r3, "statusBarTranslucent");
        ReadableType r0 = r3.getType();
        if (r0 != null) goto L5;
        int r1 = -1;
    L7:
        if (r1 != 1) goto L9;
        String r4 = r3.asString();
        Intrinsics.checkNotNull(r4);
        this.d = Boolean.parseBoolean(r4);
    L13:
        c0(this.d);
        return;
    L9:
        if (r1 != 2) goto L13;
        this.d = r3.asBoolean();
        goto L13
    L5:
        r1 = b.a[r0.ordinal()];
        goto L7
    }

    @LynxProp(name = LynxUIOverlay.PROP_STATUS_BAR_TRANSLUCENT_STYLE)
    public final void setStatusBarTranslucentStyle(String r1) {
        if (r1 != null) goto L4;
        r1 = LynxUIOverlay.PROP_STATUS_BAR_TRANSLUCENT_STYLE_DARK;
    L4:
        this.h = r1;
        c0(this.d);
    }

    @LynxProp(name = LynxUIOverlay.PROP_VISIBLE)
    public final void setVisible(f6a.a r3) {
        Intrinsics.checkNotNullParameter(r3, LynxUIOverlay.PROP_VISIBLE);
        ReadableType r0 = r3.getType();
        if (r0 != null) goto L5;
        int r1 = -1;
    L7:
        if (r1 != 1) goto L9;
        String r4 = r3.asString();
        Intrinsics.checkNotNull(r4);
        this.c = Boolean.parseBoolean(r4);
    L14:
        if (this.c == false) goto L16;
        a0();
        return;
    L16:
        V();
        return;
    L9:
        if (r1 != 2) goto L14;
        this.c = r3.asBoolean();
        goto L14
    L5:
        r1 = b.a[r0.ordinal()];
        goto L7
    }

    public LynxOverlayView(LynxContext r5, LynxUIOverlay r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "proxy");
        super(r5);
        this.a = r6;
        this.d = true;
        this.e = true;
        this.f = true;
        this.h = LynxUIOverlay.PROP_STATUS_BAR_TRANSLUCENT_STYLE_DARK;
        this.j = "auto";
        this.o = true;
        this.p = true;
        this.s = true;
        LynxOverlayDialog r0 = new LynxOverlayDialog(r5, this);
        this.y = r0;
        c r1 = new c(r5, this);
        this.z = r1;
        this.A = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
        this.B = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
        Window r3 = r0.getWindow();
        if (r3 == null) goto L5;
        r3.clearFlags(2);
    L5:
        Window r2 = r0.getWindow();
        if (r2 == null) goto L8;
        r2.setDimAmount(0.0f);
    L8:
        r1.addView(this.mView, -1, -1);
        r0.setContentView(r1, new ViewGroup.LayoutParams(-1, -1));
        r0.setOnKeyListener(new g(this));
        setAdaptEdgeToEdge(false);
        r1.setClickable(true);
        r1.setFocusable(true);
        r1.setFocusableInTouchMode(true);
        this.C = new b1(r5.getLynxUIOwner());
        c0(this.d);
    }

    public static final float P(LynxOverlayView r1, float r2) {
        Resources r3 = r1.mContext.getResources();
        return (r2 / WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()).density) + 0.5f;
    }

    public final boolean W(float r7, float r8) {
        if (this.c == true) goto L6;
        return false;
    L6:
        if (getLynxContext().isFragmentLayerRenderOn() == true) goto L8;
    L10:
        boolean r0 = eventThrough(r7, r8);
        if (this.g == true) goto L15;
        if (r0 == true) goto L18;
        return true;
    L18:
        Iterator<T> r1 = this.mChildren.iterator();
    L20:
        if (r1.hasNext() == false) goto L30;
        LynxBaseUI r2 = (LynxBaseUI) r1.next();
        if (((getLeft() + r2.getLeft()) + r2.getTranslationX()) >= r7) goto L20;
        if ((((getLeft() + r2.getLeft()) + r2.getTranslationX()) + r2.getWidth()) <= r7) goto L20;
        if (((getTop() + r2.getTop()) + r2.getTranslationY()) >= r8) goto L20;
        if ((((getTop() + r2.getTop()) + r2.getTranslationY()) + r2.getHeight()) <= r8) goto L20;
        return true;
    L30:
        return false;
    L15:
        if (this.f == true) goto L18;
        if (r0 == true) goto L18;
        return true;
    L8:
        if (getLynxContext().isPlatformEventTargetEventThrough(getSign(), r7 - getLeft(), r8 - getTop()) == false) goto L10;
        return false;
    }

    public final void X(int r5, Context r6) {
        if (r5 != (-2)) goto L5;
        String r7 = "context is destroyed, context is " + r6;
    L14:
        EventEmitter r0 = getLynxContext().getEventEmitter();
        m7a.a r1 = new m7a.a(getSign(), "showoverlay");
        r1.a("errorCode", Integer.valueOf(r5));
        r1.a("errorMsg", r7);
        r0.sendCustomEvent(r1);
        return;
    L5:
        if (r5 == (-1)) goto L12;
        if (r5 != 0) goto L8;
        r7 = "show success, context is " + r6;
        goto L14
    L8:
        if (r5 == 1) goto L10;
        r7 = NameKeys.UnloadStrategy_No_Strategy;
        goto L14
    L10:
        r7 = "context is not activity, context is " + r6;
        goto L14
    L12:
        r7 = "context is finishing, context is " + r6;
        goto L14
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public final boolean eventThrough(float r11, float r12) {
        if (this.mEventThrough != EventTarget.EnableStatus.Enable) goto L5;
        boolean r0 = true;
    L6:
        ArrayList<ArrayList<SizeValue>> r1 = this.mEventThroughActiveRegions;
        if (r1 != null) goto L9;
        return r0;
    L9:
        int r2 = r1.size();
        int r4 = 0;
        boolean r5 = false;
    L10:
        if (r4 >= r2) goto L28;
        ArrayList r6 = (ArrayList) ListProtector.get(this.mEventThroughActiveRegions, r4);
        if (r6 == null) goto L27;
        if (r6.size() != 4) goto L27;
        float r7 = ((SizeValue) ListProtector.get(r6, 0)).a(getWidth());
        float r8 = ((SizeValue) ListProtector.get(r6, 1)).a(getHeight());
        float r9 = ((SizeValue) ListProtector.get(r6, 2)).a(getWidth()) + r7;
        float r10 = ((SizeValue) ListProtector.get(r6, 3)).a(getHeight()) + r8;
        if (r11 >= r7) goto L18;
    L24:
        r5 = false;
    L25:
        if (r5 == false) goto L27;
        LLog.i("overlay", "hit the event through active regions!");
        goto L28
    L18:
        if (r11 >= r9) goto L24;
        if (r12 < r8) goto L24;
        if (r12 >= r10) goto L24;
        r5 = true;
    L27:
        r4 = r4 + 1;
    L28:
        if (r5 == true) goto L39;
        if (r0 == false) goto L40;
        return false;
    L40:
        return true;
    L39:
        return r0;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup
    public final void onInsertChild(LynxBaseUI r3, int r4) {
        if (this.p == true) goto L5;
    L7:
        super.onInsertChild(r3, r4);
        return;
    L5:
        if (this.A[0] != Integer.MIN_VALUE) goto L7;
        d0();
        goto L7
    }

    public static final void Q(LynxOverlayView r3, String r4, float r5, float r6, float r7, float r8) {
        EventEmitter r0 = r3.getLynxContext().getEventEmitter();
        m7a.a r1 = new m7a.a(r3.getSign(), r4);
        r1.a("x", Float.valueOf(r5));
        r1.a("y", Float.valueOf(r6));
        r1.a("vx", Float.valueOf(r7));
        r1.a("vy", Float.valueOf(r8));
        r1.a("state", Integer.valueOf(r3.b));
        r0.sendCustomEvent(r1);
    }
}
