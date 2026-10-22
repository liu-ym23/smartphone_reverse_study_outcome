package com.obric.miniapp.lynx;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import com.larus.utils.logger.FLogger;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.UIGroup;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.oui.graphic.BlendMode;
import com.obric.oui.material.MaterialToken;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 Y2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001YB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u001dH\u0014J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u000fH\u0007J\u0012\u0010!\u001a\u00020\u001f2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0007J\u0012\u0010$\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010#H\u0007J\u0012\u0010%\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010#H\u0007J\u0012\u0010&\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010#H\u0007J\u0012\u0010'\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010#H\u0007J\u0014\u0010(\u001a\u00020\u001f2\n\u0010)\u001a\u0006\u0012\u0002\b\u00030*H\u0016J\b\u0010+\u001a\u00020\u001fH\u0016J\b\u0010,\u001a\u00020\u001fH\u0002J\b\u0010-\u001a\u00020\u001fH\u0002J\u0018\u0010.\u001a\u00020\u001f2\u0006\u0010/\u001a\u00020\u000f2\u0006\u00100\u001a\u00020\u000fH\u0002J\u0012\u00101\u001a\u00020\u001f2\b\b\u0002\u00102\u001a\u00020\u000fH\u0002J\b\u00103\u001a\u00020\u001fH\u0002J\b\u00104\u001a\u00020\u001fH\u0002J\b\u00105\u001a\u00020\u001fH\u0002J\"\u00106\u001a\u0002072\u0006\u0010\u0003\u001a\u00020\u001d2\u0006\u00108\u001a\u00020\t2\b\u00109\u001a\u0004\u0018\u00010:H\u0002J\u0018\u0010;\u001a\u00020\u001f2\u0006\u0010<\u001a\u00020=2\u0006\u00108\u001a\u00020\tH\u0002J\u001f\u0010>\u001a\u0004\u0018\u00010?2\u0006\u0010\u0003\u001a\u00020\u001d2\u0006\u0010@\u001a\u00020?H\u0002¢\u0006\u0002\u0010AJ\u0010\u0010B\u001a\u00020\u001f2\u0006\u00108\u001a\u00020\tH\u0002J\u0016\u0010C\u001a\b\u0012\u0004\u0012\u00020D0\u00182\u0006\u00108\u001a\u00020EH\u0002J\u0010\u0010F\u001a\u00020\u001f2\u0006\u00108\u001a\u00020\tH\u0002J&\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\f\u0010H\u001a\b\u0012\u0004\u0012\u00020I0\u00182\b\b\u0002\u0010J\u001a\u00020?H\u0002J&\u0010K\u001a\b\u0012\u0004\u0012\u00020D0\u00182\f\u0010H\u001a\b\u0012\u0004\u0012\u00020I0\u00182\b\b\u0002\u0010J\u001a\u00020?H\u0002J\u001c\u0010L\u001a\u00020D*\u00020I2\u0006\u0010J\u001a\u00020?2\u0006\u0010M\u001a\u00020\u000fH\u0002J\u0014\u0010N\u001a\u00020\u0019*\u00020I2\u0006\u0010J\u001a\u00020?H\u0002J\u0012\u0010O\u001a\u00020\u001f2\b\u0010P\u001a\u0004\u0018\u00010#H\u0002J\n\u0010Q\u001a\u0004\u0018\u00010RH\u0002J\n\u0010S\u001a\u0004\u0018\u00010TH\u0002J\u001c\u0010U\u001a\u0004\u0018\u00010:2\b\u0010\"\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0003\u001a\u00020\u001dH\u0002J\u0010\u0010V\u001a\u00020\u001f2\u0006\u0010W\u001a\u00020#H\u0002J\u000f\u0010X\u001a\u0004\u0018\u00010=*\u00020\u001dH\u0082\u0010R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0016R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006Z"}, d2 = {"Lcom/obric/miniapp/lynx/LynxMiniAppMenuUI;", "Lcom/lynx/tasm/behavior/ui/UIGroup;", "Lcom/obric/miniapp/lynx/MiniAppMenuAnchorView;", "context", "Lcom/lynx/tasm/behavior/LynxContext;", "<init>", "(Lcom/lynx/tasm/behavior/LynxContext;)V", "anchorView", "contentHost", "Lcom/obric/miniapp/lynx/MiniAppMenuContentHostView;", "popover", "Lcom/obric/oui/popover/v2/OPopover;", "optionsJson", "Lorg/json/JSONObject;", "visible", "", "pendingShow", "showInProgress", "emitCancelOnNextDismiss", "emitDismissOnNextDismiss", "menuWidthDp", "", "Ljava/lang/Float;", "childLayoutSnapshots", "", "Lcom/obric/miniapp/lynx/MenuChildLayoutSnapshot;", "showRunnable", "Ljava/lang/Runnable;", "createView", "Landroid/content/Context;", "setVisible", "", "value", "setOptions", "options", "", "setPlacement", "setPosition", "setGravity", "setMenuWidth", "insertView", "child", "Lcom/lynx/tasm/behavior/ui/LynxUI;", "destroy", "scheduleShow", "showIfPossible", "dismissMenu", "emitCancel", "emitDismiss", "cleanupAfterDismiss", "emitEvents", "moveContentChildrenToHost", "restoreContentChildrenToAnchor", "refreshVisibleMenu", "createPopoverContentView", "Landroid/view/View;", "host", "backgroundAppearance", "Lcom/obric/miniapp/lynx/MiniAppMenuBackgroundAppearance;", "measurePopupContent", "activity", "Landroid/app/Activity;", "resolveMenuWidthPx", "", "maxWidth", "(Landroid/content/Context;I)Ljava/lang/Integer;", "relayoutChildren", "collectMeasuredViewSnapshots", "Lcom/obric/miniapp/lynx/MenuContentSnapshot;", "Landroid/view/ViewGroup;", "restoreChildLayouts", "snapshotUiLayoutSubtree", "nodes", "Lcom/lynx/tasm/behavior/ui/LynxBaseUI;", "depth", "snapshotUiSubtree", "toMenuContentSnapshot", "isLeaf", "toLayoutSnapshot", "updatePlacement", "rawValue", "resolveMenuTouchDispatcher", "Lcom/lynx/tasm/behavior/TouchEventDispatcher;", "resolveTouchBound", "Landroid/graphics/Rect;", "resolveMenuBackgroundAppearance", "sendSimpleEvent", "type", "findActivity", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LynxMiniAppMenuUI extends UIGroup<w5> {
    public static final /* synthetic */ int m = 0;
    public w5 a;
    public z5 b;
    public com.obric.oui.popover.v2.c c;
    public JSONObject d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public Float j;
    public List<j4> k;
    public final u0 l;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.obric.miniapp.lynx.LynxMiniAppMenuUI$createView$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<com.lynx.tasm.behavior.b1> {
        public AnonymousClass1(Object r8) {
            super(0, r8, LynxMiniAppMenuUI.class, "resolveMenuTouchDispatcher", "resolveMenuTouchDispatcher()Lcom/lynx/tasm/behavior/TouchEventDispatcher;", 0);
        }

        public final com.lynx.tasm.behavior.b1 invoke() {
            LynxMiniAppMenuUI r0 = (LynxMiniAppMenuUI) ((CallableReference) this).receiver;
            int r1 = LynxMiniAppMenuUI.m;
            LynxContext r2 = r0.getLynxContext();
            if (r2 != null) goto L5;
            return null;
        L5:
            r2.EnsureEventDispatcher();
            return r2.getTouchEventDispatcher();
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m235invoke() {
            return invoke();
        }
    }

    /* JADX INFO: renamed from: com.obric.miniapp.lynx.LynxMiniAppMenuUI$createView$3, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function0<Rect> {
        public AnonymousClass3(Object r8) {
            super(0, r8, LynxMiniAppMenuUI.class, "resolveTouchBound", "resolveTouchBound()Landroid/graphics/Rect;", 0);
        }

        public final Rect invoke() {
            LynxMiniAppMenuUI r0 = (LynxMiniAppMenuUI) ((CallableReference) this).receiver;
            int r1 = LynxMiniAppMenuUI.m;
            LynxBaseUI r2 = (LynxBaseUI) CollectionsKt.firstOrNull(r0.getChildren());
            if (r2 == null) goto L7;
            Rect r3 = r2.getBound();
            if (r3 == null) goto L7;
            return r3;
        L7:
            return r0.getBound();
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m236invoke() {
            return invoke();
        }
    }

    static {
    }

    public final void destroy() {
        this.e = false;
        this.f = false;
        com.lynx.tasm.behavior.ui.view.a r1 = this.a;
        if (r1 == null) goto L5;
        r1.removeCallbacks(this.l);
    L5:
        O(false);
        U();
        com.lynx.tasm.behavior.ui.view.a r0 = this.b;
        if (r0 == null) goto L8;
        r0.removeAllViews();
    L8:
        this.b = null;
        this.k = CollectionsKt.emptyList();
        this.a = null;
        super.destroy();
    }

    public final void Q() {
        if (this.e == true) goto L5;
        return;
    L5:
        com.lynx.tasm.behavior.ui.view.a r0 = this.a;
        if (r0 != null) goto L8;
        return;
    L8:
        r0.post(new s0(this));
    }

    public final void U() {
        com.lynx.tasm.behavior.ui.view.a r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        com.lynx.tasm.behavior.ui.view.a r1 = this.b;
        if (r1 != null) goto L9;
        return;
    L9:
        if (r1.getChildCount() <= 0) goto L14;
        View r3 = r1.getChildAt(0);
        if (r3 == null) goto L17;
        r1.removeViewAt(0);
        y0.b(r3);
        r0.addView(r3);
        goto L9
    L17:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.view.View, android.view.ViewGroup, com.obric.miniapp.lynx.z5] */
    /* JADX WARN: Type inference failed for: r13v0, types: [com.obric.miniapp.lynx.LynxMiniAppMenuUI] */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.widget.FrameLayout, com.obric.miniapp.lynx.y5] */
    /* JADX WARN: Type inference failed for: r5v1, types: [android.view.View, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v8 */
    public final void V() {
        com.lynx.tasm.behavior.ui.view.a r0 = this.a;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.isAttachedToWindow() == false) goto L124;
        if (r0.isLaidOut() == false) goto L124;
        if (r0.getWidth() <= 0) goto L124;
        if (r0.getHeight() <= 0) goto L124;
        com.lynx.tasm.behavior.ui.view.a r4 = this.a;
        if (r4 == null) goto L141;
        ?? r1 = this.b;
        if (r1 != 0) goto L21;
        return;
    L21:
        if (this.e == true) goto L23;
        return;
    L23:
        if (this.c == null) goto L25;
        return;
    L25:
        if (this.g == false) goto L28;
        return;
    L28:
        if (r4.isAttachedToWindow() == true) goto L30;
    L121:
        V();
        return;
    L30:
        if (r4.getWidth() <= 0) goto L121;
        if (r4.getHeight() <= 0) goto L121;
        Context r2 = r4.getContext();
    L36:
        if ((r2 instanceof Activity) == true) goto L37;
        if ((r2 instanceof ContextWrapper) == false) goto L43;
        r2 = ((ContextWrapper) r2).getBaseContext();
        if (r2 != null) goto L36;
    L43:
        Activity r3 = null;
    L45:
        if (r3 != null) goto L47;
    L120:
        FLogger.a.w("LynxMiniAppMenuUI", "skip showing menu because activity is unavailable");
        return;
    L47:
        if (r3.isFinishing() == true) goto L120;
        if (r3.isDestroyed() == true) goto L120;
        if (r4.isAttachedToWindow() == true) goto L54;
    L61:
        boolean r5 = false;
    L62:
        if (r5 == true) goto L64;
        FLogger.a.w("LynxMiniAppMenuUI", "skip showing menu because anchor is not visible");
        return;
    L64:
        com.lynx.tasm.behavior.ui.view.a r6 = this.a;
        if (r6 == null) goto L77;
        com.lynx.tasm.behavior.ui.view.a r7 = this.b;
        if (r7 == null) goto L77;
    L71:
        if (r6.getChildCount() <= 0) goto L77;
        View r8 = r6.getChildAt(0);
        if (r8 == null) goto L77;
        r6.removeViewAt(0);
        y0.b(r8);
        r7.addView(r8);
    L77:
        if (r1.getChildCount() != 0) goto L79;
        FLogger.a.w("LynxMiniAppMenuUI", "skip showing menu because content host has no children");
        return;
    L79:
        this.g = true;
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L114
        y0.b(r1);     // Catch: Throwable -> L114
        r1.setVisibility(0);     // Catch: Throwable -> L114
        T(r1);     // Catch: Throwable -> L114
        R(r1);     // Catch: Throwable -> L114
        P(r3, r1);     // Catch: Throwable -> L114
        x5 r10 = S(this.d, r3);     // Catch: Throwable -> L114
        if (r10 != null) goto L83;
        ?? r11 = r1;
    L104:
        int r12 = r1.getMeasuredWidth();     // Catch: Throwable -> L114
        int r13 = r1.getMeasuredHeight();     // Catch: Throwable -> L114
        com.obric.oui.popover.v2.c.a r14 = new com.obric.oui.popover.v2.c.a(r3);     // Catch: Throwable -> L114
        Intrinsics.checkNotNullParameter(r11, "view");     // Catch: Throwable -> L114
        ((com.obric.oui.popover.v2.h) r14).f = r11;     // Catch: Throwable -> L114
        ((com.obric.oui.popover.v2.h) r14).b = true;     // Catch: Throwable -> L114
        ((com.obric.oui.popover.v2.h) r14).i = true;     // Catch: Throwable -> L114
        ((com.obric.oui.popover.v2.h) r14).j = true;     // Catch: Throwable -> L114
        ((com.obric.oui.popover.v2.h) r14).l = false;     // Catch: Throwable -> L114
        if (r10 != null) goto L107;
        boolean r15 = true;
    L108:
        ((com.obric.oui.popover.v2.h) r14).n = r15;     // Catch: Throwable -> L114
        v0 r16 = new v0(this);     // Catch: Throwable -> L114
        Intrinsics.checkNotNullParameter(r16, "listener");     // Catch: Throwable -> L114
        ((com.obric.oui.popover.v2.h) r14).g = r16;     // Catch: Throwable -> L114
        com.obric.oui.popover.v2.c r17 = r14.a();     // Catch: Throwable -> L114
        this.c = r17;     // Catch: Throwable -> L114
        FLogger r18 = FLogger.a;     // Catch: Throwable -> L114
        StringBuilder r19 = new StringBuilder();     // Catch: Throwable -> L114
        r19.append("show menu content=");     // Catch: Throwable -> L114
        r19.append(r12);     // Catch: Throwable -> L114
        r19.append('x');     // Catch: Throwable -> L114
        r19.append(r13);     // Catch: Throwable -> L114
        r19.append(" placement=");     // Catch: Throwable -> L114
        r19.append(y0.g(this.d));     // Catch: Throwable -> L114
        r19.append(" nativeBackground=");     // Catch: Throwable -> L114
        if (r10 == null) goto L111;
        boolean r20 = true;
    L112:
        r19.append(r20);     // Catch: Throwable -> L114
        r18.i("LynxMiniAppMenuUI", r19.toString());     // Catch: Throwable -> L114
        int r21 = com.obric.oui.popover.v2.i.a;     // Catch: Throwable -> L114
        com.obric.oui.popover.v2.i.c(r17, r4, y0.g(this.d), y0.c(r3, 8), false, 224);     // Catch: Throwable -> L114
        this.h = true;     // Catch: Throwable -> L114
        this.i = true;     // Catch: Throwable -> L114
        W("show");     // Catch: Throwable -> L114
        Object r22 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L114
    L116:
        Throwable r23 = Result.exceptionOrNull-impl(r22);
        if (r23 == null) goto L119;
        FLogger.a.e("LynxMiniAppMenuUI", "show menu failed", r23);
        this.c = null;
        M(false);
    L119:
        this.g = false;
        return;
    L111:
        r20 = false;
        goto L112
    L107:
        r15 = false;
        goto L108
    L83:
        y0.b(r1);     // Catch: Throwable -> L114
        ?? r24 = new y5(r3, r10);     // Catch: Throwable -> L114
        Integer r25 = Integer.valueOf(r1.getMeasuredWidth());     // Catch: Throwable -> L114
        if (r25.intValue() <= 0) goto L86;
        boolean r26 = true;
    L87:
        if (r26 == true) goto L90;
        r25 = null;
    L90:
        int r27 = -2;
        if (r25 == null) goto L93;
        int r28 = r25.intValue();     // Catch: Throwable -> L114
    L94:
        Integer r29 = Integer.valueOf(r1.getMeasuredHeight());     // Catch: Throwable -> L114
        if (r29.intValue() <= 0) goto L97;
        boolean r110 = true;
    L98:
        if (r110 == true) goto L101;
        r29 = null;
    L101:
        if (r29 == null) goto L103;
        r27 = r29.intValue();     // Catch: Throwable -> L114
    L103:
        r24.addView(r1, new FrameLayout.LayoutParams(r28, r27));     // Catch: Throwable -> L114
        r11 = r24;
        goto L104
    L97:
        r110 = false;
        goto L98
    L93:
        r28 = -2;
        goto L94
    L86:
        r26 = false;
    L114:
        th = move-exception;
        Result.Companion r30 = Result.Companion;
        r22 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L116
    L54:
        if (r4.isShown() == false) goto L61;
        if (r4.getWidth() <= 0) goto L61;
        if (r4.getHeight() <= 0) goto L61;
        r5 = r4.getGlobalVisibleRect(new Rect());
        goto L62
    L37:
        r3 = (Activity) r2;
        goto L45
    L141:
        return;
    L124:
        if (this.f == true) goto L144;
        this.f = true;
        r0.post(this.l);
        return;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.obric.miniapp.lynx.u0] */
    public LynxMiniAppMenuUI(LynxContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.h = true;
        this.i = true;
        this.k = CollectionsKt.emptyList();
        this.l = new u0(this);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.View, android.view.ViewGroup, com.obric.miniapp.lynx.z5] */
    public final void M(boolean r3) {
        ?? r0 = this.b;
        if (r0 == 0) goto L5;
        r0.d = null;
        r0.e = null;
        r0.f = 0;
        r0.g = 0;
        r0.setVisibility(8);
        y0.b(r0);
    L5:
        U();
        if (r3 == true) goto L8;
    L13:
        this.h = true;
        this.i = true;
        return;
    L8:
        if (this.h == false) goto L11;
        W(WindowEvent.WindowOpenPerfResult.CANCEL);
    L11:
        if (this.i == false) goto L13;
        W("dismiss");
        goto L13
    }

    public final void O(boolean r4) {
        this.f = false;
        com.lynx.tasm.behavior.ui.view.a r1 = this.a;
        if (r1 == null) goto L5;
        r1.removeCallbacks(this.l);
    L5:
        com.obric.oui.popover.v2.c r2 = this.c;
        if (r2 == null) goto L8;
        this.h = false;
        this.i = r4;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L14
        PopupWindowLancet.handleDismissBeforeOrigin(r2);     // Catch: Throwable -> L14
        r2.dismiss();     // Catch: Throwable -> L14
        Object r6 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L16:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L23;
        FLogger.a.e("LynxMiniAppMenuUI", "dismiss menu failed", r7);
        this.c = null;
        M(true);
        return;
    L23:
        return;
    L14:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    L8:
        if (this.e == true) goto L22;
        M(false);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R(z5 r3) {
        Iterator r0 = getChildren().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        LynxBaseUI r1 = (LynxBaseUI) r0.next();
        r1.measure();
        r1.layout();
        goto L4
    L6:
        y0.i(r3);
        r3.invalidate();
    }

    public final void T(z5 r24) {
        if (this.k.isEmpty() == false) goto L5;
        this.k = X(getChildren(), 0);
    L5:
        Iterator r1 = this.k.iterator();
    L7:
        if (r1.hasNext() == false) goto L13;
        j4 r2 = (j4) r1.next();
        LynxBaseUI r3 = r2.a;
        int r4 = r2.c;
        int r5 = r2.d;
        int r6 = r2.e;
        int r7 = r2.f;
        int r8 = r2.g;
        int r9 = r2.h;
        int r10 = r2.i;
        int r11 = r2.j;
        int r12 = r2.k;
        int r13 = r2.l;
        int r14 = r2.m;
        int r15 = r2.n;
        int r0 = r2.o;
        Iterator r21 = r1;
        int r16 = r2.p;
        int r17 = r2.q;
        int r18 = r2.r;
        Rect r19 = r2.s;
        if (r19 == null) goto L11;
        Rect r20 = new Rect(r19);
    L12:
        r3.updateLayout(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r0, r16, r17, r18, r20);
        r1 = r21;
        goto L7
    L11:
        int r22 = r2.c;
        int r110 = r2.d;
        r20 = new Rect(r22, r110, r2.e + r22, r2.f + r110);
        goto L12
    L13:
        R(r24);
    }

    public final void W(String r4) {
        LynxContext r0 = getLynxContext();
        if (r0 == null) goto L9;
        EventEmitter r1 = r0.getEventEmitter();
        if (r1 == null) goto L10;
        r1.sendCustomEvent(new m7a.a(getSign(), r4));
        return;
    L10:
        return;
    }

    public final void Z(String r6) {
        if (r6 == null) goto L4;
        String r7 = StringsKt.trim(r6).toString();
    L5:
        if (r7 != null) goto L7;
        r7 = "";
    L7:
        JSONObject r0 = this.d;
        if (r0 == null) goto L12;
        String r1 = r0.toString();
        if (r1 == null) goto L12;
        JSONObject r2 = new JSONObject(r1);
    L14:
        if (StringsKt.isBlank(r7) == false) goto L16;
        r2.remove("placement");
        r2.remove("position");
        r2.remove("gravity");
    L17:
        this.d = r2;
        Q();
        return;
    L16:
        r2.put("placement", r7);
        r2.put("position", r7);
        r2.put("gravity", r7);
    L12:
        r2 = new JSONObject();
        goto L14
    L4:
        r7 = null;
        goto L5
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [android.view.ViewGroup, com.obric.miniapp.lynx.z5] */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.view.View, android.view.ViewGroup, com.obric.miniapp.lynx.w5] */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.obric.miniapp.lynx.r0] */
    public final View createView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        ?? r0 = new z5(r5, new AnonymousClass1(this), new r0(this), new AnonymousClass3(this));
        r0.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        r0.setClipChildren(false);
        r0.setClipToPadding(false);
        r0.setVisibility(8);
        this.b = r0;
        ?? r1 = new w5(r5);
        r1.setMinimumWidth(y0.c(r5, 2));
        r1.setMinimumHeight(y0.c(r5, 2));
        r1.setClipChildren(false);
        r1.setClipToPadding(false);
        this.a = r1;
        return r1;
    }

    public final void insertView(LynxUI<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "child");
        super.insertView(r2);
        if (this.e == true) goto L5;
        return;
    L5:
        com.lynx.tasm.behavior.ui.view.a r3 = this.a;
        if (r3 == null) goto L9;
        r3.post(new t0(this));
        return;
    }

    @LynxProp(name = "gravity")
    public final void setGravity(String r1) {
        Z(r1);
    }

    @LynxProp(name = "menuWidth")
    public final void setMenuWidth(String r1) {
        this.j = y0.f(r1);
        Q();
    }

    @LynxProp(name = "options")
    public final void setOptions(String r3) {
        JSONObject r0 = null;
        Object r1 = null;
        r0 = null;
        if (r3 != null) goto L5;
    L18:
        this.d = r0;
        Q();
        return;
    L5:
        if ((!StringsKt.isBlank(r3)) == true) goto L8;
        r3 = null;
    L8:
        if (r3 == null) goto L18;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L11
        Object r4 = Result.constructor-impl(new JSONObject(r3));     // Catch: Throwable -> L11
    L14:
        if (Result.isFailure-impl(r4) == true) goto L17;
        r1 = r4;
    L17:
        r0 = (JSONObject) r1;
    L11:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }

    @LynxProp(name = "placement")
    public final void setPlacement(String r1) {
        Z(r1);
    }

    @LynxProp(name = "position")
    public final void setPosition(String r1) {
        Z(r1);
    }

    @LynxProp(name = "visible")
    public final void setVisible(boolean r1) {
        this.e = r1;
        if (r1 == false) goto L5;
        V();
        return;
    L5:
        O(true);
    }

    public static x5 S(JSONObject r23, Context r24) {
        String r2 = y0.j(r23, new String[]{"material", "materialToken", "backgroundMaterial", "backgroundMaterialToken", "nativeBackgroundMaterial"});
        Object r3 = y0.k(r23, (String[]) Arrays.copyOf(new String[]{"nativeBlur", "blurEnabled", "backgroundBlur", "nativeBackground", "frosted", "glass"}, 6));
        Object r6 = null;
        if ((r3 instanceof Boolean) == false) goto L6;
        Boolean r4 = (Boolean) r3;
    L62:
        if (r4 == null) goto L64;
        boolean r5 = r4.booleanValue();
    L65:
        if (r5 == true) goto L68;
        if (r2 != null) goto L68;
        return null;
    L68:
        Integer r7 = y0.e(y0.k(r23, new String[]{"backgroundColor", "bgColor", "tintColor", "backgroundTint", "backgroundTintColor", "overlayColor"}), r24);
        if (r7 == null) goto L71;
        int r9 = r7.intValue();
    L72:
        Integer r8 = y0.e(y0.k(r23, new String[]{"borderColor", "strokeColor", "border_color", "stroke_color"}), r24);
        if (r8 == null) goto L75;
        int r10 = r8.intValue();
    L76:
        Float r11 = y0.f(y0.k(r23, new String[]{"borderWidth", "strokeWidth", "border_width", "stroke_width"}));
        if (r11 == null) goto L79;
        float r12 = r11.floatValue();
    L80:
        Resources r13 = r24.getResources();
        int r14 = RangesKt.coerceAtLeast((int) (r12 * WindowDisplayMetricsOverride.apply(r13, r13.getDisplayMetrics()).density), 0);
        Float r15 = y0.f(y0.k(r23, new String[]{"cornerRadius", "radius", "borderRadius", "radiusDp", "corner_radius", "border_radius"}));
        if (r15 == null) goto L83;
        float r16 = r15.floatValue();
    L84:
        Resources r17 = r24.getResources();
        float r18 = (int) (r16 * WindowDisplayMetricsOverride.apply(r17, r17.getDisplayMetrics()).density);
        Float r0 = y0.f(y0.k(r23, new String[]{"blurRadius", "backgroundBlurRadius", "nativeBlurRadius", "blur_radius", "background_blur_radius"}));
        if (r0 == null) goto L87;
        float r19 = r0.floatValue();
    L88:
        if (r2 != null) goto L112;
        r2 = "regular_2";
    L112:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L100
        if (o1.w(r24) == true) goto L93;
        boolean r20 = true;
    L94:
        com.obric.oui.material.c r21 = MaterialToken.parse(r2, r20);     // Catch: Throwable -> L100
        if (r21 == null) goto L97;
        com.obric.oui.material.c r22 = r21.a();     // Catch: Throwable -> L100
    L98:
        Object r25 = Result.constructor-impl(r22);     // Catch: Throwable -> L100
    L103:
        if (Result.isFailure-impl(r25) == true) goto L106;
        r6 = r25;
    L106:
        com.obric.oui.material.c r26 = (com.obric.oui.material.c) r6;
        if (r26 != null) goto L109;
        com.obric.oui.material.c r110 = new com.obric.oui.material.c(null, null, null, null, null, null, null, null, 1023);
    L110:
        r110.a = ColorStateList.valueOf(r9);
        r110.c = new com.obric.oui.color.a[]{new com.obric.oui.color.a(r9, BlendMode.SRC_OVER)};
        r110.h = Float.valueOf(r19);
        return new x5(r9, r10, r14, r18, r110);
    L109:
        r110 = r26;
        goto L110
    L97:
        r22 = null;
        goto L98
    L93:
        r20 = false;
    L100:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        r25 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L103
    L87:
        r19 = 32.0f;
        goto L88
    L83:
        r16 = 28.0f;
        goto L84
    L79:
        r12 = 1.0f;
        goto L80
    L75:
        r10 = 1728053247;
        goto L76
    L71:
        r9 = -855638017;
        goto L72
    L64:
        r5 = false;
        goto L65
    L6:
        if ((r3 instanceof Number) == false) goto L13;
        if (((Number) r3).intValue() == 0) goto L10;
        boolean r28 = true;
    L11:
        r4 = Boolean.valueOf(r28);
        goto L62
    L10:
        r28 = false;
        goto L11
    L13:
        if ((r3 instanceof String) == false) goto L61;
        String r29 = StringsKt.trim((String) r3).toString().toLowerCase(Locale.ROOT);
        switch(r29.hashCode()) {
            case -1609594047: goto L58;
            case -1298848381: goto L55;
            case 48: goto L51;
            case 49: goto L48;
            case 110: goto L45;
            case 121: goto L42;
            case 3521: goto L39;
            case 3551: goto L36;
            case 109935: goto L33;
            case 119527: goto L30;
            case 3569038: goto L27;
            case 97196323: goto L24;
            case 270940796: goto L21;
            case 1671308008: goto L18;
            default: goto L115;
        };
    L115:
        r4 = null;
        goto L62
    L18:
        if (r29.equals("disable") == false) goto L116;
    L53:
        r4 = Boolean.FALSE;
        goto L62
    L116:
        r4 = null;
        goto L62
    L21:
        if (r29.equals("disabled") == true) goto L53;
        r4 = null;
        goto L62
    L24:
        if (r29.equals("false") == true) goto L53;
        r4 = null;
        goto L62
    L27:
        if (r29.equals("true") == false) goto L119;
    L60:
        r4 = Boolean.TRUE;
        goto L62
    L119:
        r4 = null;
        goto L62
    L30:
        if (r29.equals("yes") == true) goto L60;
        r4 = null;
        goto L62
    L33:
        if (r29.equals("off") == true) goto L53;
        r4 = null;
        goto L62
    L36:
        if (r29.equals("on") == true) goto L60;
        r4 = null;
        goto L62
    L39:
        if (r29.equals("no") == true) goto L53;
        r4 = null;
        goto L62
    L42:
        if (r29.equals("y") == true) goto L60;
        r4 = null;
        goto L62
    L45:
        if (r29.equals("n") == true) goto L53;
        r4 = null;
        goto L62
    L48:
        if (r29.equals("1") == true) goto L60;
        r4 = null;
        goto L62
    L51:
        if (r29.equals("0") == true) goto L53;
        r4 = null;
        goto L62
    L55:
        if (r29.equals("enable") == true) goto L60;
        r4 = null;
        goto L62
    L58:
        if (r29.equals("enabled") == true) goto L60;
        r4 = null;
        goto L62
    L61:
        r4 = null;
        goto L62
    }

    public static List X(List r23, int r24) {
        ArrayList r0 = new ArrayList();
        Iterator r1 = r23.iterator();
    L4:
        if (r1.hasNext() == false) goto L13;
        LynxBaseUI r2 = (LynxBaseUI) r1.next();
        int r6 = r2.getOriginLeft();
        int r7 = r2.getOriginTop();
        int r8 = r2.getWidth();
        int r9 = r2.getHeight();
        int r10 = r2.getPaddingLeft();
        int r11 = r2.getPaddingTop();
        int r12 = r2.getPaddingRight();
        int r13 = r2.getPaddingBottom();
        int r14 = r2.getMarginLeft();
        int r15 = r2.getMarginTop();
        int r16 = r2.getMarginRight();
        int r17 = r2.getMarginBottom();
        int r18 = r2.getBorderLeftWidth();
        int r19 = r2.getBorderTopWidth();
        int r20 = r2.getBorderRightWidth();
        int r21 = r2.getBorderBottomWidth();
        Rect r3 = r2.getBound();
        if (r3 == null) goto L8;
        Rect r22 = new Rect(r3);
    L9:
        Iterator r25 = r1;
        r0.add(new j4(r2, r24, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22));
        List r4 = r2.getChildren();
        Intrinsics.checkNotNull(r4);
        if ((!r4.isEmpty()) == false) goto L12;
        r0.addAll(X(r4, r24 + 1));
    L12:
        r1 = r25;
        goto L4
    L8:
        r22 = null;
        goto L9
    L13:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void P(Activity r19, z5 r20) {
        Window r3 = r19.getWindow();
        if (r3 == null) goto L9;
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L10;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r5 = ThreadMethodProxy.currentThread();
        if (r5 == com.larus.home.impl.utils.c.a) goto L10;
        com.larus.home.impl.utils.c.a(r5, "getDecorView");
    L10:
        if (r4 == null) goto L12;
        int r6 = r4.getWidth();
    L13:
        int r7 = RangesKt.coerceAtLeast(r6 - y0.c(r19, 24), 1);
        if (r4 == null) goto L16;
        int r8 = r4.getHeight();
    L17:
        int r9 = RangesKt.coerceAtLeast(r8 - y0.c(r19, 24), 1);
        Float r10 = this.j;
        if (r10 != null) goto L21;
        r10 = y0.f(y0.k(this.d, new String[]{"menuWidth"}));
    L21:
        if (r10 != null) goto L23;
    L31:
        Integer r1 = null;
    L32:
        int r11 = View.MeasureSpec.makeMeasureSpec(r7, Integer.MIN_VALUE);
        int r12 = View.MeasureSpec.makeMeasureSpec(r9, Integer.MIN_VALUE);
        r20.d = null;
        r20.e = r1;
        y0.i(r20);
        r20.measure(r11, r12);
        r20.layout(0, 0, r20.getMeasuredWidth(), r20.getMeasuredHeight());
        List r13 = CollectionsKt.createListBuilder();
        int r14 = r20.getChildCount();
        int r15 = 0;
    L33:
        if (r15 >= r14) goto L39;
        View r16 = r20.getChildAt(r15);
        if (r16 == null) goto L38;
        N(r20, r13, r16, 0);
    L38:
        r15 = r15 + 1;
        goto L33
    L39:
        List r17 = CollectionsKt.build(r13);
        k4 r18 = MenuPopupLayoutUtilsKt.c(r17, r20.getMeasuredWidth(), r20.getMeasuredHeight());
        List<l4> r21 = Y(getChildren(), 0);
        k4 r22 = y0.a(y0.h(r21, r7, r9), MenuPopupLayoutUtilsKt.c(r21, r20.getMeasuredWidth(), r20.getMeasuredHeight()), r18, r7, r9);
        List<l4> r110 = MenuPopupLayoutUtilsKt.b(r17);
        k4 r111 = MenuPopupLayoutUtilsKt.c(r110, r20.getMeasuredWidth(), r20.getMeasuredHeight());
        List<l4> r112 = MenuPopupLayoutUtilsKt.b(r21);
        k4 r113 = MenuPopupLayoutUtilsKt.c(r112, r20.getMeasuredWidth(), r20.getMeasuredHeight());
        k4 r114 = y0.h(r112, r7, r9);
        k4 r115 = y0.a(r114, r113, r111, r7, r9);
        if (r1 == null) goto L42;
        int r23 = r1.intValue();
    L43:
        int r24 = RangesKt.coerceIn(r23, 1, r7);
        int r25 = RangesKt.coerceIn(r115.d, 1, r9);
        r20.f = r22.a - r115.a;
        r20.g = r22.b - r115.b;
        int r26 = r115.a;
        int r0 = r115.b;
        r20.d = new Rect(r26, r0, r26 + r24, r0 + r25);
        r20.measure(View.MeasureSpec.makeMeasureSpec(r24, 1073741824), View.MeasureSpec.makeMeasureSpec(r25, 1073741824));
        r20.layout(0, 0, r24, r25);
        FLogger.a.i("LynxMiniAppMenuUI", "measurePopupContent host=" + r20.getMeasuredWidth() + 'x' + r20.getMeasuredHeight() + " forcedWidth=" + r1 + " rawChosen=" + r22 + " offset=" + r20.f + ',' + r20.g + " viewMetrics=" + r111 + " uiMetrics=" + r113 + " uiTopLevelMetrics=" + r114 + " chosen=" + r115 + " viewSnapshots=" + r110.size() + '/' + r17.size() + " uiSnapshots=" + r112.size() + '/' + ((ArrayList) r21).size());
        return;
    L42:
        r23 = r115.c;
        goto L43
    L23:
        if (r10.floatValue() <= 0.0f) goto L25;
        boolean r27 = true;
    L26:
        if (r27 == true) goto L29;
        r10 = null;
    L29:
        if (r10 == null) goto L31;
        float r28 = r10.floatValue();
        Resources r2 = r19.getResources();
        r1 = Integer.valueOf(RangesKt.coerceIn((int) (r28 * WindowDisplayMetricsOverride.apply(r2, r2.getDisplayMetrics()).density), 1, r7));
        goto L32
    L25:
        r27 = false;
        goto L26
    L16:
        Resources r29 = r19.getResources();
        r8 = WindowDisplayMetricsOverride.apply(r29, r29.getDisplayMetrics()).heightPixels;
        goto L17
    L12:
        Resources r30 = r19.getResources();
        r6 = WindowDisplayMetricsOverride.apply(r30, r30.getDisplayMetrics()).widthPixels;
        goto L13
    L9:
        r4 = null;
        goto L10
    }

    public final List<l4> Y(List<? extends LynxBaseUI> r17, int r18) {
        ArrayList r0 = new ArrayList();
        Iterator<T> r1 = r17.iterator();
    L4:
        if (r1.hasNext() == false) goto L26;
        LynxBaseUI r2 = (LynxBaseUI) r1.next();
        List<? extends LynxBaseUI> r3 = r2.getChildren();
        boolean r10 = r3.isEmpty();
        int r5 = r2.getOriginLeft();
        int r6 = r2.getOriginTop();
        int r7 = r2.getWidth();
        int r8 = r2.getHeight();
        Rect r4 = r2.getBound();
        if (r4 == null) goto L8;
        Integer r11 = Integer.valueOf(r4.left);
    L9:
        Rect r9 = r2.getBound();
        if (r9 == null) goto L12;
        Integer r12 = Integer.valueOf(r9.top);
    L13:
        Rect r13 = r2.getBound();
        if (r13 == null) goto L16;
        Integer r14 = Integer.valueOf(r13.right);
    L17:
        Rect r15 = r2.getBound();
        if (r15 == null) goto L20;
        Integer r16 = Integer.valueOf(r15.bottom);
    L21:
        r0.add(new l4(r5, r6, r7, r8, r18, r10, r11, r12, r14, r16));
        Intrinsics.checkNotNull(r3);
        if ((!r3.isEmpty()) == false) goto L4;
        r0.addAll(Y(r3, r18 + 1));
        goto L4
    L20:
        r16 = null;
        goto L21
    L16:
        r14 = null;
        goto L17
    L12:
        r12 = null;
        goto L13
    L8:
        r11 = null;
        goto L9
    L26:
        return r0;
    }

    public static final boolean N(ViewGroup r21, List<l4> r22, View r23, int r24) {
        if (r23.getVisibility() != 8) goto L5;
    L26:
        return false;
    L5:
        if (r23.getMeasuredWidth() <= 0) goto L26;
        if (r23.getMeasuredHeight() <= 0) goto L26;
        if ((r23 instanceof ViewGroup) == false) goto L23;
        ViewGroup r3 = (ViewGroup) r23;
        int r6 = r3.getChildCount();
        int r7 = 0;
        boolean r8 = false;
    L12:
        if (r7 >= r6) goto L24;
        View r9 = r3.getChildAt(r7);
        if (r9 == null) goto L22;
        if (N(r21, r22, r9, r24 + 1) == true) goto L21;
        if (r8 == true) goto L21;
        r8 = false;
    L21:
        r8 = true;
    L22:
        r7 = r7 + 1;
    L24:
        Rect r4 = new Rect(0, 0, r23.getMeasuredWidth(), r23.getMeasuredHeight());
        r21.offsetDescendantRectToMyCoords(r23, r4);
        r22.add(new l4(r4.left, r4.top, r4.width(), r4.height(), r24, !r8, Integer.valueOf(r4.left), Integer.valueOf(r4.top), Integer.valueOf(r4.right), Integer.valueOf(r4.bottom)));
        return true;
    L23:
        r8 = false;
        goto L24
    }
}
