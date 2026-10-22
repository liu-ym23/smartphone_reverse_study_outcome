package com.bytedance.ies.xelement.overlay;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.RequiresApi;
import androidx.core.view.ViewCompat;
import com.bytedance.ai.ex.widget.WidgetView;
import com.bytedance.ies.xelement.input.n;
import com.lynx.base.log.LynxLog;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableType;
import com.lynx.tasm.b0;
import com.lynx.tasm.behavior.a1;
import com.lynx.tasm.behavior.c0;
import com.lynx.tasm.behavior.event.EventTarget$EnableStatus;
import com.lynx.tasm.behavior.event.EventTarget$PointerEventsValue;
import com.lynx.tasm.behavior.n0;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.UIGroup;
import com.lynx.tasm.behavior.ui.a0;
import com.lynx.tasm.behavior.ui.accessibility.LynxAccessibilityDelegate;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0010\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\t\u0010\u0007J\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\nH\u0007¢\u0006\u0004\b\u000f\u0010\rJ\u0017\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0015\u0010\u0007J\u0019\u0010\u0017\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0010H\u0007¢\u0006\u0004\b\u0017\u0010\u0013J\u0017\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\nH\u0007¢\u0006\u0004\b\u0019\u0010\rJ\u0019\u0010\u001a\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\nH\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\nH\u0007¢\u0006\u0004\b\u001d\u0010\rJ\u0017\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\nH\u0007¢\u0006\u0004\b\u001e\u0010\rJ\u0017\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u001f\u0010\u0013¨\u0006 "}, d2 = {"Lcom/bytedance/ies/xelement/overlay/LynxOverlayView;", "Lcom/lynx/tasm/behavior/ui/UIGroup;", "Lcom/lynx/tasm/behavior/ui/view/b;", "Lpm/a;", "visible", "", "setVisible", "(Lpm/a;)V", "statusBarTranslucent", "setStatusBarTranslucent", "", "fullScreen", "setFullScreen", "(Z)V", "isCutOut", "setCutOutMode", "", "id", "setOverlayId", "(Ljava/lang/String;)V", "eventsPassThrough", "setEventsPassThrough", "value", "setStatusBarTranslucentStyle", "boolean", "setAlwaysShow", "setShouldOffsetBoundingRect", "(Ljava/lang/Boolean;)V", "enable", "setNativeEventPass", "setEnableAccessibility", "setAndroidSetSoftInputMode", "x-element-overlay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LynxOverlayView extends UIGroup<com.lynx.tasm.behavior.ui.view.b> {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ int f6470t = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LynxOverlayViewProxy f6471a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f6472b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f6473c;
    public boolean d;
    public String e;
    public String f;
    public boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f6474h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a f6475i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final h f6476j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int[] f6477k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final a1 f6478l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f6479m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public LynxAccessibilityDelegate f6480n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public com.lynx.tasm.behavior.ui.f f6481o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ViewTreeObserver f6482p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public n f6483q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public d f6484r;
    public e s;

    public LynxOverlayView(b0 r5, LynxOverlayViewProxy r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "proxy");
        super(r5, null);
        this.f6471a = r10;
        this.d = true;
        this.e = WidgetView.UI_MODE_DARK;
        a r11 = new a(r5, this);
        this.f6475i = r11;
        h r12 = new h(r5, this);
        this.f6476j = r12;
        this.f6477k = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
        Window r13 = r11.getWindow();
        if (r13 == null) goto L5;
        r13.clearFlags(2);
    L5:
        Window r14 = r11.getWindow();
        if (r14 == null) goto L8;
        r14.setDimAmount(0.0f);
    L8:
        r12.addView(this.mView, -1, -1);
        r11.setContentView(r12, new ViewGroup.LayoutParams(-1, -1));
        r11.setOnKeyListener(new f(this, 0));
        r12.setClickable(true);
        r12.setFocusable(true);
        r12.setFocusableInTouchMode(true);
        this.f6478l = new a1((n0) r5.f10147o.get());
    }

    public final void b(String r10) {
        JavaOnlyArray r5 = new JavaOnlyArray();
        JavaOnlyMap r11 = new JavaOnlyMap();
        r11.put("currentOverlayId", this.f);
        ArrayList r12 = c.f6490a;
        JavaOnlyArray r13 = new JavaOnlyArray();
        Iterator r14 = c.f6490a.iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        r13.pushString(((b) r14.next()).f6488a);
        goto L4
    L6:
        r11.put("overlays", r13);
        r5.pushMap(r11);
        this.mContext.e(r10, r5);
    }

    public final boolean c(float r10, float r11) {
        if (this.f6472b == true) goto L6;
        return false;
    L6:
        if (this.d == false) goto L8;
    L10:
        Iterator<T> r5 = this.mChildren.iterator();
    L12:
        if (r5.hasNext() == false) goto L22;
        LynxBaseUI r12 = (LynxBaseUI) r5.next();
        if ((r12.getTranslationX() + (r12.getLeft() + getLeft())) >= r10) goto L12;
        if (((r12.getTranslationX() + (getLeft() + r12.getLeft())) + r12.getWidth()) <= r10) goto L12;
        if ((r12.getTranslationY() + (r12.getTop() + getTop())) >= r11) goto L12;
        if (((r12.getTranslationY() + (getTop() + r12.getTop())) + r12.getHeight()) <= r11) goto L12;
        return true;
    L22:
        return false;
    L8:
        if (eventThrough(r10, r11) == true) goto L10;
        return true;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r5) {
        return new h(r5, this);
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void destroy() {
        a r5 = this.f6475i;
        if (r5.isShowing() == true) goto L31;
    L29:
        super.destroy();
        return;
    L31:
        r5.dismiss();     // Catch: RuntimeException -> L13 WindowManager.BadTokenException -> L15
        ArrayList r10 = c.f6490a;     // Catch: RuntimeException -> L13 WindowManager.BadTokenException -> L15
        String r11 = this.f;     // Catch: RuntimeException -> L13 WindowManager.BadTokenException -> L15
        if (r11 == null) goto L17;
        Iterator r12 = c.f6490a.iterator();     // Catch: RuntimeException -> L13 WindowManager.BadTokenException -> L15
    L9:
        if (r12.hasNext() == false) goto L17;
        b r13 = (b) r12.next();     // Catch: RuntimeException -> L13 WindowManager.BadTokenException -> L15
        if (Intrinsics.areEqual(r13.f6488a, r11) == false) goto L9;
        c.f6490a.remove(r13);     // Catch: RuntimeException -> L13 WindowManager.BadTokenException -> L15
    L17:
        ViewTreeObserver r14 = this.f6482p;     // Catch: RuntimeException -> L13 WindowManager.BadTokenException -> L15
        if (r14 == null) goto L20;
        r14.removeOnGlobalLayoutListener(this.f6483q);     // Catch: RuntimeException -> L13 WindowManager.BadTokenException -> L15
    L20:
        ViewTreeObserver r15 = this.f6482p;     // Catch: RuntimeException -> L13 WindowManager.BadTokenException -> L15
        if (r15 == null) goto L23;
        r15.removeOnScrollChangedListener(this.f6484r);     // Catch: RuntimeException -> L13 WindowManager.BadTokenException -> L15
    L23:
        ViewTreeObserver r16 = this.f6482p;     // Catch: RuntimeException -> L13 WindowManager.BadTokenException -> L15
        if (r16 == null) goto L29;
        r16.removeOnDrawListener(this.s);     // Catch: RuntimeException -> L13 WindowManager.BadTokenException -> L15
    L15:
        e = move-exception;
        LynxLog.b(3, "x-overlay", e.toString());
    L13:
        e = move-exception;
        LynxLog.b(3, "x-overlay", e.toString());
        goto L29
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, wm.a
    public final boolean eventThrough(float r12, float r13) {
        if (this.mEventThrough != EventTarget$EnableStatus.f10244a) goto L5;
        boolean r5 = true;
    L6:
        ArrayList<ArrayList<com.lynx.tasm.utils.i>> r10 = this.mEventThroughActiveRegions;
        if (r10 == null) goto L29;
        int r11 = r10.size();
        int r14 = 0;
        boolean r15 = false;
    L10:
        if (r14 >= r11) goto L28;
        ArrayList<com.lynx.tasm.utils.i> r16 = this.mEventThroughActiveRegions.get(r14);
        if (r16 == null) goto L27;
        if (r16.size() != 4) goto L27;
        float r17 = r16.get(0).a(getWidth());
        float r18 = r16.get(1).a(getHeight());
        float r19 = r16.get(2).a(getWidth()) + r17;
        float r20 = r16.get(3).a(getHeight()) + r18;
        if (r12 >= r17) goto L18;
    L24:
        r15 = false;
    L25:
        if (r15 == false) goto L27;
        LynxLog.b(2, "x-overlay", "hit the event through active regions!");
        goto L28
    L18:
        if (r12 >= r19) goto L24;
        if (r13 < r18) goto L24;
        if (r13 >= r20) goto L24;
        r15 = true;
    L27:
        r14 = r14 + 1;
    L28:
        if (r15 == true) goto L29;
        if (r5 == true) goto L32;
        return true;
    L32:
        return false;
    L29:
        return r5;
    L5:
        r5 = false;
        goto L6
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final Rect getBoundingClientRect() {
        if (this.f6474h == false) goto L8;
        if (this.f6477k[0] != Integer.MIN_VALUE) goto L8;
        l();
    L8:
        return super.getBoundingClientRect();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final int[] getOffsetDescendantRectToLynxView() {
        return this.f6477k;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final a1 getTouchEventDispatcher() {
        return this.f6478l;
    }

    public final void i() {
        a r5 = this.f6475i;
        if (r5.isShowing() == true) goto L30;
        return;
    L30:
        r5.dismiss();     // Catch: RuntimeException -> L13 WindowManager.BadTokenException -> L15
        b("onDismissOverlay");     // Catch: RuntimeException -> L13 WindowManager.BadTokenException -> L15
        ArrayList r10 = c.f6490a;     // Catch: RuntimeException -> L13 WindowManager.BadTokenException -> L15
        String r11 = this.f;     // Catch: RuntimeException -> L13 WindowManager.BadTokenException -> L15
        if (r11 == null) goto L17;
        Iterator r12 = c.f6490a.iterator();     // Catch: RuntimeException -> L13 WindowManager.BadTokenException -> L15
    L9:
        if (r12.hasNext() == false) goto L17;
        b r13 = (b) r12.next();     // Catch: RuntimeException -> L13 WindowManager.BadTokenException -> L15
        if (Intrinsics.areEqual(r13.f6488a, r11) == false) goto L9;
        c.f6490a.remove(r13);     // Catch: RuntimeException -> L13 WindowManager.BadTokenException -> L15
    L17:
        ViewTreeObserver r14 = this.f6482p;     // Catch: RuntimeException -> L13 WindowManager.BadTokenException -> L15
        if (r14 == null) goto L20;
        r14.removeOnGlobalLayoutListener(this.f6483q);     // Catch: RuntimeException -> L13 WindowManager.BadTokenException -> L15
    L20:
        ViewTreeObserver r15 = this.f6482p;     // Catch: RuntimeException -> L13 WindowManager.BadTokenException -> L15
        if (r15 == null) goto L23;
        r15.removeOnScrollChangedListener(this.f6484r);     // Catch: RuntimeException -> L13 WindowManager.BadTokenException -> L15
    L23:
        ViewTreeObserver r16 = this.f6482p;     // Catch: RuntimeException -> L13 WindowManager.BadTokenException -> L15
        if (r16 == null) goto L36;
        r16.removeOnDrawListener(this.s);     // Catch: RuntimeException -> L13 WindowManager.BadTokenException -> L15
        return;
    L36:
        return;
    L15:
        e = move-exception;
        LynxLog.b(3, "x-overlay", e.toString());
        return;
    L13:
        e = move-exception;
        LynxLog.b(3, "x-overlay", e.toString());
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, wm.a
    public final boolean ignoreFocus() {
        if (this.mIgnoreFocus != EventTarget$EnableStatus.f10244a) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean isUserInteractionEnabled() {
        return false;
    }

    public final void j() {
        int r5 = 0;
        a r10 = this.f6475i;
        Activity r11 = kk.a.c(getLynxContext());
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.isFinishing() == true) goto L45;
        ArrayList r12 = c.f6490a;
        String r13 = this.f;
        ViewTreeObserver r14 = null;
        if (r13 == null) goto L39;
        Iterator r15 = c.f6490a.iterator();
    L10:
        if (r15.hasNext() == false) goto L14;
        Object r16 = r15.next();
        if (Intrinsics.areEqual(((b) r16).f6488a, r13) == false) goto L10;
    L16:
        if (((b) r16) == null) goto L39;
        return;
    L14:
        r16 = null;
    L39:
        ArrayList r17 = c.f6490a;     // Catch: RuntimeException -> L22 WindowManager.BadTokenException -> L24
        this.f = c.a(this.f, r10);     // Catch: RuntimeException -> L22 WindowManager.BadTokenException -> L24
        r10.show();     // Catch: RuntimeException -> L22 WindowManager.BadTokenException -> L24
        b("onShowOverlay");     // Catch: RuntimeException -> L22 WindowManager.BadTokenException -> L24
        h r18 = this.f6476j;     // Catch: RuntimeException -> L22 WindowManager.BadTokenException -> L24
        if (r18 == null) goto L26;
        r14 = r18.getViewTreeObserver();     // Catch: RuntimeException -> L22 WindowManager.BadTokenException -> L24
    L26:
        this.f6482p = r14;     // Catch: RuntimeException -> L22 WindowManager.BadTokenException -> L24
        n r19 = new n(this, 1);     // Catch: RuntimeException -> L22 WindowManager.BadTokenException -> L24
        this.f6483q = r19;     // Catch: RuntimeException -> L22 WindowManager.BadTokenException -> L24
        if (r14 == null) goto L29;
        r14.addOnGlobalLayoutListener(r19);     // Catch: RuntimeException -> L22 WindowManager.BadTokenException -> L24
    L29:
        d r20 = new d(this, r5);     // Catch: RuntimeException -> L22 WindowManager.BadTokenException -> L24
        this.f6484r = r20;     // Catch: RuntimeException -> L22 WindowManager.BadTokenException -> L24
        ViewTreeObserver r21 = this.f6482p;     // Catch: RuntimeException -> L22 WindowManager.BadTokenException -> L24
        if (r21 == null) goto L32;
        r21.addOnScrollChangedListener(r20);     // Catch: RuntimeException -> L22 WindowManager.BadTokenException -> L24
    L32:
        e r22 = new e(this, r5);     // Catch: RuntimeException -> L22 WindowManager.BadTokenException -> L24
        this.s = r22;     // Catch: RuntimeException -> L22 WindowManager.BadTokenException -> L24
        ViewTreeObserver r23 = this.f6482p;     // Catch: RuntimeException -> L22 WindowManager.BadTokenException -> L24
        if (r23 == null) goto L46;
        r23.addOnDrawListener(r22);     // Catch: RuntimeException -> L22 WindowManager.BadTokenException -> L24
        return;
    L46:
        return;
    L24:
        e = move-exception;
        LynxLog.b(3, "x-overlay", e.toString());
        return;
    L22:
        e = move-exception;
        LynxLog.b(3, "x-overlay", e.toString());
        return;
    }

    public final void k() {
        a r5 = this.f6475i;
        if (r5 == null) goto L7;
        Window r10 = r5.getWindow();
        if (r10 == null) goto L7;
        r10.addFlags(65792);
    L7:
        Window r11 = null;
        if (Intrinsics.areEqual(this.e, "lite") == false) goto L18;
        if (r5 == null) goto L15;
        Window r12 = r5.getWindow();
        if (r12 == null) goto L15;
        View r13 = r12.getDecorView();
        if (r13 == null) goto L15;
        Integer r14 = Integer.valueOf(r13.getSystemUiVisibility());
    L16:
        Intrinsics.checkNotNull(r14);
        int r15 = r14.intValue();
        int r16 = 9472;
    L17:
        int r17 = r15 | r16;
        if (r5 == null) goto L30;
        Window r18 = r5.getWindow();
        if (r18 == null) goto L30;
        View r19 = r18.getDecorView();
    L31:
        if (r19 == null) goto L34;
        r19.setSystemUiVisibility(r17);
    L34:
        if (r5 == null) goto L38;
        Window r20 = r5.getWindow();
        if (r20 == null) goto L38;
        r20.addFlags(Integer.MIN_VALUE);
    L38:
        if (r5 == null) goto L40;
        r11 = r5.getWindow();
    L40:
        if (r11 != null) goto L42;
        return;
    L42:
        r11.setStatusBarColor(0);
        return;
    L30:
        r19 = null;
    L15:
        r14 = null;
        goto L16
    L18:
        if (r5 == null) goto L24;
        Window r21 = r5.getWindow();
        if (r21 == null) goto L24;
        View r22 = r21.getDecorView();
        if (r22 == null) goto L24;
        Integer r23 = Integer.valueOf(r22.getSystemUiVisibility());
    L25:
        Intrinsics.checkNotNull(r23);
        r15 = r23.intValue();
        r16 = 1280;
    L24:
        r23 = null;
        goto L25
    }

    public final void l() {
        int[] r5 = {0, 0};
        int[] r10 = {0, 0};
        getLynxContext().f10145m.f10385a.getLocationOnScreen(r5);
        ((com.lynx.tasm.behavior.ui.view.b) this.mView).getLocationOnScreen(r10);
        int r11 = r10[0] - r5[0];
        int[] r12 = this.f6477k;
        r12[0] = r11;
        r12[1] = r10[1] - r5[1];
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void layout() {
        super.layout();
        if (this.f6474h == false) goto L6;
        l();
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onDetach() {
        super.onDetach();
        if (this.g == true) goto L6;
        i();
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup
    public final void onInsertChild(LynxBaseUI r5, int r10) {
        if (this.f6474h == true) goto L5;
    L7:
        super.onInsertChild(r5, r10);
        return;
    L5:
        if (this.f6477k[0] != Integer.MIN_VALUE) goto L7;
        l();
        goto L7
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onPropsUpdated() {
        super.onPropsUpdated();
        if (this.f6479m == true) goto L5;
        return;
    L5:
        com.lynx.tasm.behavior.ui.accessibility.d r5 = getLynxContext().f10145m.d;
        if (r5 != null) goto L8;
    L10:
        boolean r10 = false;
    L11:
        if (r10 == true) goto L13;
    L15:
        if (r10 == false) goto L17;
    L23:
        ViewCompat.setImportantForAccessibility(this.f6476j, 1);
        return;
    L17:
        if (this.f6481o != null) goto L23;
        com.lynx.tasm.behavior.ui.f r11 = new com.lynx.tasm.behavior.ui.f(this);
        com.lynx.tasm.behavior.ui.view.b r12 = (com.lynx.tasm.behavior.ui.view.b) this.mView;
        if (r12 == null) goto L22;
        r12.setAccessibilityDelegate(new i(r11, 0));
    L22:
        this.f6481o = r11;
        goto L23
    L13:
        if (this.f6480n != null) goto L15;
        LynxAccessibilityDelegate r13 = new LynxAccessibilityDelegate(this);
        this.f6480n = r13;
        ViewCompat.setAccessibilityDelegate(this.mView, r13);
        goto L23
    L8:
        if (r5.f() == false) goto L10;
        r10 = true;
        goto L11
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, wm.a
    public final EventTarget$PointerEventsValue pointerEvents() {
        EventTarget$PointerEventsValue r5 = this.mPointerEvents;
        EventTarget$PointerEventsValue r10 = EventTarget$PointerEventsValue.f10248b;
        if (r5 != r10) goto L6;
        return r10;
    L6:
        return EventTarget$PointerEventsValue.f10247a;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.ui.a0
    public final void requestLayout() {
        super.requestLayout();
        LynxOverlayViewProxy r5 = this.f6471a;
        if (r5.getTransitionAnimator() == null) goto L5;
    L8:
        this.f6476j.invalidate();
        return;
    L5:
        if (r5.enableLayoutAnimation() == true) goto L8;
    }

    @c0(name = "always-show")
    public final void setAlwaysShow(boolean r5) {
        this.g = r5;
    }

    @c0(name = "android-set-soft-input-mode")
    public final void setAndroidSetSoftInputMode(String r5) {
        Intrinsics.checkNotNullParameter(r5, "value");
        boolean r10 = "unspecified".equals(r5);
        a r11 = this.f6475i;
        if (r10 == false) goto L9;
        Window r12 = r11.getWindow();
        if (r12 == null) goto L26;
        r12.setSoftInputMode(0);
        return;
    L26:
        return;
    L9:
        if ("nothing".equals(r5) == false) goto L15;
        Window r13 = r11.getWindow();
        if (r13 == null) goto L27;
        r13.setSoftInputMode(48);
        return;
    L27:
        return;
    L15:
        if ("pan".equals(r5) == false) goto L21;
        Window r14 = r11.getWindow();
        if (r14 == null) goto L28;
        r14.setSoftInputMode(32);
        return;
    L28:
        return;
    L21:
        if ("resize".equals(r5) == false) goto L29;
        Window r15 = r11.getWindow();
        if (r15 == null) goto L30;
        r15.setSoftInputMode(16);
        return;
    L30:
        return;
    }

    @c0(name = "cut-out-mode")
    public final void setCutOutMode(boolean r5) {
        if (r5 == false) goto L11;
        a r10 = this.f6475i;
        if (r10 == null) goto L12;
        Window r11 = r10.getWindow();
        if (r11 == null) goto L13;
        WindowManager.LayoutParams r12 = r11.getAttributes();
        if (r12 == null) goto L14;
        r12.layoutInDisplayCutoutMode = 1;
        return;
    L14:
        return;
    L13:
        return;
    L12:
        return;
    }

    @c0(name = "android-enable-accessibility")
    public final void setEnableAccessibility(boolean r5) {
        this.f6479m = r5;
        if (r5 == false) goto L6;
        ((com.lynx.tasm.behavior.ui.view.b) this.mView).setFocusableInTouchMode(true);
        return;
    }

    @c0(name = "events-pass-through")
    public final void setEventsPassThrough(pm.a r5) {
        Intrinsics.checkNotNullParameter(r5, "eventsPassThrough");
        ReadableType r10 = r5.getType();
        if (r10 != null) goto L5;
        int r11 = -1;
    L7:
        if (r11 != 1) goto L9;
        String r12 = r5.asString();
        Intrinsics.checkNotNull(r12);
        this.d = Boolean.parseBoolean(r12);
        return;
    L9:
        if (r11 == 2) goto L11;
        return;
    L11:
        this.d = r5.asBoolean();
        return;
    L5:
        r11 = g.f6498a[r10.ordinal()];
        goto L7
    }

    @c0(name = "full-screen")
    public final void setFullScreen(boolean r5) {
        if (r5 == false) goto L20;
        View r10 = null;
        a r11 = this.f6475i;
        if (r11 == null) goto L10;
        Window r12 = r11.getWindow();
        if (r12 == null) goto L10;
        View r13 = r12.getDecorView();
        if (r13 == null) goto L10;
        Integer r14 = Integer.valueOf(r13.getSystemUiVisibility());
    L11:
        Intrinsics.checkNotNull(r14);
        int r15 = r14.intValue() | 5894;
        if (r11 == null) goto L16;
        Window r16 = r11.getWindow();
        if (r16 == null) goto L16;
        r10 = r16.getDecorView();
    L16:
        if (r10 == null) goto L21;
        r10.setSystemUiVisibility(r15);
        return;
    L21:
        return;
    L10:
        r14 = null;
        goto L11
    }

    @c0(name = "android-native-event-pass")
    public final void setNativeEventPass(boolean r5) {
        a r10 = this.f6475i;
        if (r5 == false) goto L8;
        Window r11 = r10.getWindow();
        if (r11 == null) goto L12;
        r11.addFlags(16);
        return;
    L12:
        return;
    L8:
        Window r12 = r10.getWindow();
        if (r12 == null) goto L13;
        r12.clearFlags(16);
        return;
    }

    @c0(name = "overlay-id")
    public final void setOverlayId(String r5) {
        Intrinsics.checkNotNullParameter(r5, "id");
        this.f = r5;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setParent(a0 r5) {
        super.setParent(r5);
        if (r5 != null) goto L7;
        i();
        return;
    L7:
        if (this.f6472b == false) goto L10;
        j();
        return;
    }

    @c0(name = "compat-bounding-rect")
    public final void setShouldOffsetBoundingRect(Boolean r5) {
        if (r5 == null) goto L4;
        boolean r10 = r5.booleanValue();
    L5:
        this.f6474h = r10;
        if (r10 == false) goto L9;
        l();
        return;
    L9:
        return;
    L4:
        r10 = false;
        goto L5
    }

    @c0(name = "status-bar-translucent")
    public final void setStatusBarTranslucent(pm.a r5) {
        Intrinsics.checkNotNullParameter(r5, "statusBarTranslucent");
        ReadableType r10 = r5.getType();
        if (r10 != null) goto L5;
        int r11 = -1;
    L7:
        if (r11 != 1) goto L9;
        String r12 = r5.asString();
        Intrinsics.checkNotNull(r12);
        this.f6473c = Boolean.parseBoolean(r12);
    L14:
        if (this.f6473c == false) goto L17;
        k();
        return;
    L17:
        return;
    L9:
        if (r11 != 2) goto L14;
        this.f6473c = r5.asBoolean();
        goto L14
    L5:
        r11 = g.f6498a[r10.ordinal()];
        goto L7
    }

    @RequiresApi(19)
    @c0(name = "status-bar-translucent-style")
    public final void setStatusBarTranslucentStyle(String r5) {
        if (r5 != null) goto L4;
        r5 = WidgetView.UI_MODE_DARK;
    L4:
        this.e = r5;
        if (this.f6473c == false) goto L8;
        k();
        return;
    }

    @c0(name = "visible")
    public final void setVisible(pm.a r5) {
        Intrinsics.checkNotNullParameter(r5, "visible");
        ReadableType r10 = r5.getType();
        if (r10 != null) goto L5;
        int r11 = -1;
    L7:
        if (r11 != 1) goto L9;
        String r12 = r5.asString();
        Intrinsics.checkNotNull(r12);
        this.f6472b = Boolean.parseBoolean(r12);
    L14:
        if (this.f6472b == false) goto L17;
        j();
        return;
    L17:
        i();
        return;
    L9:
        if (r11 != 2) goto L14;
        this.f6472b = r5.asBoolean();
        goto L14
    L5:
        r11 = g.f6498a[r10.ordinal()];
        goto L7
    }
}
