package com.obric.miniapp.lynx;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import com.larus.utils.logger.FLogger;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.UIGroup;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.oui.sheet.v2.OSheet;
import com.obric.oui.sheet.v2.OSheetBase;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 Q2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001QB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020 H\u0014J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\rH\u0007J\u0012\u0010$\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u000bH\u0007J\u0012\u0010%\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u000bH\u0007J\u0010\u0010&\u001a\u00020\"2\u0006\u0010#\u001a\u00020\rH\u0007J\u0010\u0010'\u001a\u00020\"2\u0006\u0010#\u001a\u00020\rH\u0007J\u0012\u0010(\u001a\u00020\"2\b\u0010)\u001a\u0004\u0018\u00010\u000bH\u0007J\u0014\u0010*\u001a\u00020\"2\n\u0010+\u001a\u0006\u0012\u0002\b\u00030,H\u0016J\b\u0010-\u001a\u00020\"H\u0016J\b\u0010.\u001a\u00020\"H\u0002J\u0018\u0010/\u001a\u00020\"2\u0006\u00100\u001a\u00020\r2\u0006\u00101\u001a\u00020\rH\u0002J\u0010\u00102\u001a\u00020\"2\u0006\u00103\u001a\u00020\u000bH\u0002J\n\u00104\u001a\u0004\u0018\u000105H\u0002J\n\u00106\u001a\u0004\u0018\u000107H\u0002J\u0010\u00108\u001a\u00020\"2\u0006\u00109\u001a\u00020\u0002H\u0002J\b\u0010:\u001a\u00020\"H\u0002J\b\u0010;\u001a\u00020\"H\u0002J\u0010\u0010<\u001a\u00020\"2\u0006\u0010=\u001a\u00020\u000bH\u0002J\u001e\u0010>\u001a\u00020\u00152\u0006\u00109\u001a\u00020\u00022\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002J\u0016\u0010@\u001a\u00020\u000b2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002J\u0018\u0010A\u001a\u00020\"2\u0006\u0010B\u001a\u00020\u00152\u0006\u00109\u001a\u00020\u0002H\u0002J\u0010\u0010C\u001a\u00020\"2\u0006\u00109\u001a\u00020\u0002H\u0002J\u0010\u0010D\u001a\u00020\"2\u0006\u00109\u001a\u00020\u0002H\u0002J \u0010E\u001a\u00020\"2\u0006\u0010=\u001a\u00020\u000b2\u0006\u00109\u001a\u00020\u00022\u0006\u0010F\u001a\u00020\u0019H\u0002J\u0010\u0010G\u001a\u00020\u00152\u0006\u0010H\u001a\u00020IH\u0002J\u000f\u0010J\u001a\u0004\u0018\u00010K*\u00020 H\u0082\u0010J&\u0010L\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020N0\u001c2\b\b\u0002\u0010O\u001a\u00020\u0015H\u0002J\u0014\u0010P\u001a\u00020\u001d*\u00020N2\u0006\u0010O\u001a\u00020\u0015H\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006R"}, d2 = {"Lcom/obric/miniapp/lynx/LynxMiniAppSheetUI;", "Lcom/lynx/tasm/behavior/ui/UIGroup;", "Lcom/obric/miniapp/lynx/MiniAppSheetContentHostView;", "context", "Lcom/lynx/tasm/behavior/LynxContext;", "<init>", "(Lcom/lynx/tasm/behavior/LynxContext;)V", "contentHost", "sheet", "Lcom/obric/oui/sheet/v2/OSheet;", "title", "", "closeOnMask", "", "closeOnBack", "visible", "emitCancelOnNextDismiss", "emitDismissOnNextDismiss", "originalParent", "Landroid/view/ViewGroup;", "originalIndex", "", "originalLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "sheetBodyContainer", "Lcom/obric/miniapp/lynx/SheetBodyContainerView;", "dialogMaxBodyHeightPx", "childLayoutSnapshots", "", "Lcom/obric/miniapp/lynx/SheetChildLayoutSnapshot;", "emitShowOnAnimEnd", "createView", "Landroid/content/Context;", "setVisible", "", "value", "setTitle", "setWidth", "setCloseOnMask", "setCloseOnBack", "setOptions", "options", "insertView", "child", "Lcom/lynx/tasm/behavior/ui/LynxUI;", "destroy", "showIfPossible", "dismissSheet", "emitCancel", "emitDismiss", "sendSimpleEvent", "type", "resolveSheetTouchDispatcher", "Lcom/lynx/tasm/behavior/TouchEventDispatcher;", "resolveTouchBound", "Landroid/graphics/Rect;", "detachHostFromOriginalParent", "host", "restoreHostToOriginalParent", "clearOriginalParentSnapshot", "refreshSheetContentLayout", "stage", "resolveUiContentHeight", "snapshots", "buildSnapshotSummary", "adaptChildLayoutsToSheetWidth", "targetWidth", "restoreChildLayouts", "relayoutChildren", "logHostLayoutState", "bodyContainer", "resolveMaxBodyHeight", "dialog", "Landroid/app/Dialog;", "findActivity", "Landroid/app/Activity;", "snapshotUiSubtree", "nodes", "Lcom/lynx/tasm/behavior/ui/LynxBaseUI;", "depth", "toSnapshot", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LynxMiniAppSheetUI extends UIGroup<a6> {
    public static final /* synthetic */ int p = 0;
    public a6 a;
    public com.obric.miniapp.utils.b1 b;
    public String c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public ViewGroup i;
    public int j;
    public ViewGroup.LayoutParams k;
    public f6 l;
    public int m;
    public final List<g6> n;
    public boolean o;

    public static final class a {
    }

    public static final class b<T> implements Comparator {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r4, T r5) {
            g6 r6 = (g6) r5;
            int r0 = r6.d + r6.f;
            Rect r7 = r6.s;
            int r1 = 0;
            if (r7 == null) goto L5;
            int r8 = r7.bottom;
        L6:
            Integer r9 = Integer.valueOf(Math.max(r0, r8));
            g6 r10 = (g6) r4;
            int r2 = r10.d + r10.f;
            Rect r11 = r10.s;
            if (r11 == null) goto L10;
            r1 = r11.bottom;
        L10:
            return ComparisonsKt.compareValues(r9, Integer.valueOf(Math.max(r2, r1)));
        L5:
            r8 = 0;
            goto L6
        }
    }

    /* JADX INFO: renamed from: com.obric.miniapp.lynx.LynxMiniAppSheetUI$createView$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<com.lynx.tasm.behavior.b1> {
        public AnonymousClass1(Object r8) {
            super(0, r8, LynxMiniAppSheetUI.class, "resolveSheetTouchDispatcher", "resolveSheetTouchDispatcher()Lcom/lynx/tasm/behavior/TouchEventDispatcher;", 0);
        }

        public final com.lynx.tasm.behavior.b1 invoke() {
            LynxMiniAppSheetUI r0 = (LynxMiniAppSheetUI) ((CallableReference) this).receiver;
            int r1 = LynxMiniAppSheetUI.p;
            LynxContext r2 = r0.getLynxContext();
            if (r2 != null) goto L5;
            return null;
        L5:
            r2.EnsureEventDispatcher();
            return r2.getTouchEventDispatcher();
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m237invoke() {
            return invoke();
        }
    }

    /* JADX INFO: renamed from: com.obric.miniapp.lynx.LynxMiniAppSheetUI$createView$3, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function0<Rect> {
        public AnonymousClass3(Object r8) {
            super(0, r8, LynxMiniAppSheetUI.class, "resolveTouchBound", "resolveTouchBound()Landroid/graphics/Rect;", 0);
        }

        public final Rect invoke() {
            LynxMiniAppSheetUI r0 = (LynxMiniAppSheetUI) ((CallableReference) this).receiver;
            int r1 = LynxMiniAppSheetUI.p;
            LynxBaseUI r2 = (LynxBaseUI) CollectionsKt.firstOrNull(r0.getChildren());
            if (r2 == null) goto L7;
            Rect r3 = r2.getBound();
            if (r3 == null) goto L7;
            return r3;
        L7:
            return r0.getBound();
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m238invoke() {
            return invoke();
        }
    }

    static {
    }

    public final void destroy() {
        O(false);
        com.lynx.tasm.behavior.ui.view.a r0 = this.a;
        if (r0 == null) goto L5;
        r0.removeAllViews();
    L5:
        this.a = null;
        super.destroy();
    }

    public LynxMiniAppSheetUI(LynxContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.d = true;
        this.e = true;
        this.g = true;
        this.h = true;
        this.j = -1;
        this.n = CollectionsKt.emptyList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void M(com.obric.miniapp.utils.b1 r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L17;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public final String N(List<g6> r10) {
        return CollectionsKt.joinToString$default(CollectionsKt.take(CollectionsKt.sortedWith(r10, new b()), 6), " | ", null, null, 0, null, new d1(), 30, null);
    }

    public final void O(boolean r4) {
        com.obric.miniapp.utils.b1 r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        this.g = false;
        this.h = r4;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L8
        M(r0);     // Catch: Throwable -> L8
        Object r6 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L16;
        FLogger.a.e("LynxMiniAppSheetUI", "dismiss sheet failed", r7);
        return;
    L16:
        return;
    L8:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.View, android.view.ViewGroup, com.obric.miniapp.lynx.a6] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void P(String r10) {
        ?? r0 = this.a;
        if (r0 != 0) goto L5;
        return;
    L5:
        f6 r1 = this.l;
        if (r1 != null) goto L8;
        return;
    L8:
        Iterator r2 = getChildren().iterator();
    L10:
        if (r2.hasNext() == false) goto L12;
        LynxBaseUI r3 = (LynxBaseUI) r2.next();
        r3.measure();
        r3.layout();
        goto L10
    L12:
        i1.a(r0);
        r0.invalidate();
        int r4 = 0;
        List<g6> r5 = R(getChildren(), 0);
        Iterator r6 = ((ArrayList) r5).iterator();
        if (r6.hasNext() == true) goto L15;
        Integer r7 = null;
    L30:
        if (r7 == null) goto L32;
        r4 = RangesKt.coerceAtLeast((r7.intValue() + r0.getPaddingTop()) + r0.getPaddingBottom(), 0);
    L32:
        r0.setContentHeightOverridePx(r4);
        if (r4 <= 0) goto L39;
        int r8 = this.m;
        if (r8 <= 0) goto L37;
        int r9 = RangesKt.coerceAtMost(r4, r8);
    L38:
        r0.setBodyMaxHeightPx(r9);
        goto L39
    L37:
        r9 = r4;
    L39:
        int r11 = this.m;
        if (r1.a == r11) goto L43;
        r1.a = r11;
        r1.requestLayout();
    L43:
        i1.a(r0);
        r1.requestLayout();
        r0.requestLayout();
        FLogger.a.i("LynxMiniAppSheetUI", r10 + " refreshSheetContentLayout contentHeight=" + r4 + ", dialogMaxBodyHeightPx=" + this.m + ", hostChildren=" + r0.getChildCount() + ", uiChildren=" + getChildren().size() + ", snapshotSummary=" + N(r5));
        r0.getChildCount();
        getChildren().size();
        N(r5);
        return;
    L15:
        g6 r12 = (g6) r6.next();
        int r13 = r12.d + r12.f;
        Rect r14 = r12.s;
        if (r14 == null) goto L18;
        int r15 = r14.bottom;
    L19:
        Integer r16 = Integer.valueOf(Math.max(r13, r15));
    L21:
        if (r6.hasNext() == false) goto L29;
        g6 r17 = (g6) r6.next();
        int r18 = r17.d + r17.f;
        Rect r19 = r17.s;
        if (r19 == null) goto L25;
        int r20 = r19.bottom;
    L26:
        Integer r21 = Integer.valueOf(Math.max(r18, r20));
        if (r16.compareTo(r21) >= 0) goto L21;
        r16 = r21;
        goto L21
    L25:
        r20 = 0;
        goto L26
    L29:
        r7 = r16;
        goto L30
    L18:
        r15 = 0;
        goto L19
    }

    public final void Q(String r4) {
        LynxContext r0 = getLynxContext();
        if (r0 == null) goto L9;
        EventEmitter r1 = r0.getEventEmitter();
        if (r1 == null) goto L10;
        r1.sendCustomEvent(new m7a.a(getSign(), r4));
        return;
    L10:
        return;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [android.view.View, android.view.ViewGroup, com.obric.miniapp.lynx.a6] */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.obric.miniapp.lynx.c1] */
    public final View createView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        ?? r0 = new a6(r5, new AnonymousClass1(this), new c1(this), new AnonymousClass3(this));
        r0.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        r0.setClipChildren(false);
        r0.setClipToPadding(false);
        r0.setClickable(false);
        r0.setFocusable(false);
        r0.setFocusableInTouchMode(false);
        r0.setImportantForAccessibility(2);
        r0.setMinimumWidth(0);
        r0.setMinimumHeight(0);
        r0.setVisibility(8);
        this.a = r0;
        return r0;
    }

    public final void insertView(LynxUI<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "child");
        super.insertView(r5);
        com.lynx.tasm.behavior.ui.view.a r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        FLogger r1 = FLogger.a;
        StringBuilder r2 = new StringBuilder("insertView child=");
        r2.append(r5.getClass().getSimpleName());
        r2.append(", hostChildren=");
        r2.append(r0.getChildCount());
        r2.append(", hostLp=");
        ViewGroup.LayoutParams r6 = r0.getLayoutParams();
        Integer r3 = null;
        if (r6 == null) goto L8;
        Integer r7 = Integer.valueOf(r6.width);
    L9:
        r2.append(r7);
        r2.append('x');
        ViewGroup.LayoutParams r8 = r0.getLayoutParams();
        if (r8 == null) goto L12;
        r3 = Integer.valueOf(r8.height);
    L12:
        r2.append(r3);
        r1.i("LynxMiniAppSheetUI", r2.toString());
        r0.getChildCount();
        r0.getLayoutParams();
        r0.getLayoutParams();
        if (this.f == true) goto L15;
        return;
    L15:
        if (this.b == null) goto L19;
        r0.post(new z0(this));
        return;
    L19:
        return;
    L8:
        r7 = null;
        goto L9
    }

    @LynxProp(name = "closeOnBack")
    public final void setCloseOnBack(boolean r1) {
        this.e = r1;
    }

    @LynxProp(name = "closeOnMask")
    public final void setCloseOnMask(boolean r1) {
        this.d = r1;
    }

    @LynxProp(name = "options")
    public final void setOptions(String r5) {
        if (r5 == null) goto L39;
        boolean r1 = true;
        String r2 = null;
        if ((!StringsKt.isBlank(r5)) == true) goto L7;
        r5 = null;
    L7:
        if (r5 == null) goto L40;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L10
        Object r6 = Result.constructor-impl(new JSONObject(r5));     // Catch: Throwable -> L10
    L13:
        if (Result.isFailure-impl(r6) == false) goto L15;
        r6 = null;
    L15:
        JSONObject r7 = (JSONObject) r6;
        if (r7 != null) goto L19;
        return;
    L19:
        if (r7.has("title") == false) goto L28;
        String r3 = StringsKt.trim(r7.optString("title")).toString();
        if (r3.length() > 0) goto L24;
        r1 = false;
    L24:
        if (r1 == false) goto L26;
        r2 = r3;
    L26:
        this.c = r2;
    L28:
        if (r7.has("width") == false) goto L31;
        setWidth(r7.optString("width"));
    L31:
        if (r7.has("closeOnMask") == false) goto L34;
        this.d = r7.optBoolean("closeOnMask", this.d);
    L34:
        if (r7.has("closeOnBack") == false) goto L41;
        this.e = r7.optBoolean("closeOnBack", this.e);
        return;
    L41:
        return;
    L10:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    L40:
        return;
    }

    @LynxProp(name = "title")
    public final void setTitle(String r3) {
        String r0 = null;
        if (r3 == null) goto L12;
        String r4 = StringsKt.trim(r3).toString();
        if (r4 == null) goto L12;
        if (r4.length() <= 0) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == false) goto L12;
        r0 = r4;
        goto L12
    L9:
        r1 = false;
    L12:
        this.c = r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [android.app.Dialog, com.obric.miniapp.utils.b1, com.obric.oui.sheet.v2.OSheet, com.obric.oui.sheet.v2.OSheetBase, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v0, types: [android.view.View, android.view.ViewGroup, com.obric.miniapp.lynx.a6, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4, types: [android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r8v1, types: [android.view.View, android.widget.FrameLayout, com.obric.miniapp.lynx.f6] */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9, types: [android.view.ViewGroup] */
    @LynxProp(name = "visible")
    public final void setVisible(boolean r19) {
        this.f = r19;
        if (r19 == true) goto L5;
        O(true);
        return;
    L5:
        if (this.b != null) goto L98;
        com.lynx.tasm.behavior.ui.view.a r0 = this.a;
        if (r0 == null) goto L94;
        Context r1 = r0.getContext();
        if (r1 == null) goto L99;
        final ?? r3 = this.a;
        if (r3 == 0) goto L100;
        Context r4 = r1;
    L17:
        if ((r4 instanceof Activity) == true) goto L18;
        if ((r4 instanceof ContextWrapper) == false) goto L24;
        r4 = ((ContextWrapper) r4).getBaseContext();
        if (r4 != null) goto L17;
    L24:
        Activity r5 = null;
    L26:
        if (r5 != null) goto L28;
    L82:
        FLogger.a.w("LynxMiniAppSheetUI", "skip showing sheet because activity is unavailable");
        return;
    L28:
        if (r5.isFinishing() == true) goto L82;
        if (r5.isDestroyed() == true) goto L82;
        ViewParent r7 = r3.getParent();
        if ((r7 instanceof ViewGroup) == false) goto L35;
        ?? r8 = (ViewGroup) r7;
    L36:
        if (r8 == 0) goto L39;
        this.i = r8;
        this.j = r8.indexOfChild(r3);
        this.k = r3.getLayoutParams();
        r8.removeView(r3);
    L39:
        i1.a(r3);
        r3.setBodyMaxHeightPx(0);
        r3.setContentHeightOverridePx(0);
        r3.setVisibility(0);
        ?? r9 = new f6(r1);
        r9.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        Intrinsics.checkNotNullParameter(r3, "host");
        if (r3.getParent() == r9) goto L48;
        ViewParent r10 = r3.getParent();
        if ((r10 instanceof ViewGroup) == false) goto L44;
        ?? r11 = (ViewGroup) r10;
    L45:
        if (r11 == 0) goto L47;
        r11.removeView(r3);
    L47:
        r9.addView(r3, new FrameLayout.LayoutParams(-1, -2));
        goto L48
    L44:
        r11 = 0;
    L48:
        i1.a(r3);
        this.l = r9;
        Window r6 = r5.getWindow();
        if (r6 == null) goto L57;
        View r12 = r6.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L55;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r13 = ThreadMethodProxy.currentThread();
        if (r13 == com.larus.home.impl.utils.c.a) goto L55;
        com.larus.home.impl.utils.c.a(r13, "getDecorView");
    L55:
        if (r12 == null) goto L57;
        int r14 = r12.getHeight();
    L58:
        ?? r2 = com.obric.miniapp.utils.c1.a(r1, r14);
        OSheetBase.DefaultImpls.q(r2, OSheet.HeightMode.WRAP_HEIGHT);
        String r15 = this.c;
        if (r15 != null) goto L61;
    L64:
        boolean r16 = true;
    L66:
        if ((!r16) == false) goto L68;
        OSheetBase.DefaultImpls.o(r2, OSheet.Header.ONLY_TITLE, null, this.c, null, true, null, null, 16134);
    L68:
        OSheetBase.DefaultImpls.j(r2, r9);
        r2.setCancelable(this.e);
        r2.setCanceledOnTouchOutside(this.d);
        ((OSheet) r2).t = new h1(this, r9, r3);
        r2.setOnCancelListener(new a1(this));
        r2.setOnDismissListener(new b1(this, r3));
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L77
        this.o = true;     // Catch: Throwable -> L77
        if (DialogLancet.shouldBlockDialogShow(r2) == false) goto L88;
        DialogLancet.handleBlockedDialogShow(r2);     // Catch: Throwable -> L77
    L75:
        this.b = r2;     // Catch: Throwable -> L77
        this.g = true;     // Catch: Throwable -> L77
        this.h = true;     // Catch: Throwable -> L77
        Object r18 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L77
    L79:
        Throwable r20 = Result.exceptionOrNull-impl(r18);
        if (r20 == null) goto L95;
        FLogger.a.e("LynxMiniAppSheetUI", "show sheet failed", r20);
        this.o = false;
        this.b = null;
        return;
    L95:
        return;
    L88:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L85 Throwable -> L77
    L74:
        DialogLancet.beforeDialogShow(r2);     // Catch: Throwable -> L77
        r2.show();     // Catch: Throwable -> L77
        DialogLancet.afterDialogShow(r2);     // Catch: Throwable -> L77
    L77:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L79
    L61:
        if (StringsKt.isBlank(r15) == true) goto L64;
        r16 = false;
    L57:
        r14 = 0;
        goto L58
    L35:
        r8 = 0;
        goto L36
    L18:
        r5 = (Activity) r4;
        goto L26
    L100:
        return;
    L99:
        return;
    L94:
        return;
    }

    @LynxProp(name = "width")
    public final void setWidth(String r4) {
        if (r4 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        if (StringsKt.equals(r4, "board", true) == true) goto L15;
        FLogger.a.i("LynxMiniAppSheetUI", "OSheet ignores width=" + r4 + " and always uses drawer layout");
        return;
    L15:
        return;
    L5:
        if (StringsKt.isBlank(r4) == true) goto L8;
        r1 = false;
        goto L9
    }

    public final List<g6> R(List<? extends LynxBaseUI> r24, int r25) {
        ArrayList r0 = new ArrayList();
        Iterator r1 = r24.iterator();
    L4:
        if (r1.hasNext() == false) goto L15;
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
        Iterator r26 = r1;
        r0.add(new g6(r2, r25, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22));
        List<? extends LynxBaseUI> r4 = r2.getChildren();
        Intrinsics.checkNotNull(r4);
        if ((!r4.isEmpty()) == false) goto L13;
        r0.addAll(R(r4, r25 + 1));
    L13:
        r1 = r26;
        goto L4
    L8:
        r22 = null;
        goto L9
    L15:
        return r0;
    }
}
