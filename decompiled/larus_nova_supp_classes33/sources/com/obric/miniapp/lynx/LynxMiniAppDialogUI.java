package com.obric.miniapp.lynx;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.utils.logger.FLogger;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.UIGroup;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.oui.dialog.v2.selection.OSelectionDialog;
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
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001cB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010&\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020'H\u0014J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0013H\u0007J\u0012\u0010+\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\rH\u0007J\u0012\u0010,\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\rH\u0007J\u0012\u0010-\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\rH\u0007J\u0012\u0010.\u001a\u00020)2\b\u0010/\u001a\u0004\u0018\u00010\rH\u0007J\u0019\u00100\u001a\u0004\u0018\u00010\u00102\b\u00101\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0002\u00102J\u0010\u00103\u001a\u00020\u00102\u0006\u00104\u001a\u00020\rH\u0002J\u0010\u00105\u001a\u00020)2\u0006\u0010\b\u001a\u00020\tH\u0002J\u0014\u00106\u001a\u00020)2\n\u00107\u001a\u0006\u0012\u0002\b\u000308H\u0016J\b\u00109\u001a\u00020)H\u0016J\b\u0010:\u001a\u00020)H\u0002J\b\u0010;\u001a\u00020)H\u0002J0\u0010<\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020'2\u0006\u0010=\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010>\u001a\u00020?H\u0002J0\u0010@\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020'2\u0006\u0010=\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010A\u001a\u00020\u000bH\u0002J4\u0010B\u001a\u00020C2\u0006\u0010\u0003\u001a\u00020'2\u0006\u0010>\u001a\u00020?2\u001a\u0010D\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020)0EH\u0002J\u001a\u0010F\u001a\u00020)2\u0006\u0010G\u001a\u00020\u00102\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\u0018\u0010H\u001a\u00020)2\u0006\u0010I\u001a\u00020\u00132\u0006\u0010J\u001a\u00020\u0013H\u0002J\u0010\u0010K\u001a\u00020)2\u0006\u0010L\u001a\u00020\rH\u0002J\n\u0010M\u001a\u0004\u0018\u00010NH\u0002J\n\u0010O\u001a\u0004\u0018\u00010PH\u0002J\u0010\u0010Q\u001a\u00020)2\u0006\u0010=\u001a\u00020\u0002H\u0002J\b\u0010R\u001a\u00020)H\u0002J\b\u0010S\u001a\u00020)H\u0002J\u0010\u0010T\u001a\u00020)2\u0006\u0010U\u001a\u00020\rH\u0002J\u001e\u0010V\u001a\u00020\u00102\u0006\u0010=\u001a\u00020\u00022\f\u0010W\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0002J\u0016\u0010X\u001a\u00020\r2\f\u0010W\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0002J\u0010\u0010Y\u001a\u00020)2\u0006\u0010=\u001a\u00020\u0002H\u0002J \u0010Z\u001a\u00020)2\u0006\u0010U\u001a\u00020\r2\u0006\u0010=\u001a\u00020\u00022\u0006\u0010[\u001a\u00020\u001cH\u0002J\u0010\u0010\\\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020]H\u0002J&\u0010^\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\f\u0010_\u001a\b\u0012\u0004\u0012\u00020`0\u001f2\b\b\u0002\u0010a\u001a\u00020\u0010H\u0002J\u0014\u0010b\u001a\u00020 *\u00020`2\u0006\u0010a\u001a\u00020\u0010H\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006d"}, d2 = {"Lcom/obric/miniapp/lynx/LynxMiniAppDialogUI;", "Lcom/lynx/tasm/behavior/ui/UIGroup;", "Lcom/obric/miniapp/lynx/DialogContentHostView;", "context", "Lcom/lynx/tasm/behavior/LynxContext;", "<init>", "(Lcom/lynx/tasm/behavior/LynxContext;)V", "contentHost", "dialog", "Lcom/obric/oui/dialog/v2/selection/OSelectionDialog;", "optionsJson", "Lorg/json/JSONObject;", "title", "", "message", "maskColor", "", "Ljava/lang/Integer;", "visible", "", "emitCancelOnNextDismiss", "emitDismissOnNextDismiss", "originalParent", "Landroid/view/ViewGroup;", "originalIndex", "originalLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "dialogBodyContainer", "Lcom/obric/miniapp/lynx/DialogBodyContainerView;", "dialogMaxBodyHeightPx", "childLayoutSnapshots", "", "Lcom/obric/miniapp/lynx/DialogChildLayoutSnapshot;", "emitShowOnAnimEnd", "hasSelected", "showPosted", "showRunnable", "Ljava/lang/Runnable;", "createView", "Landroid/content/Context;", "setVisible", "", "value", "setTitle", "setMessage", "setMaskColor", "setOptions", "options", "parseMaskColor", "colorValue", "(Ljava/lang/String;)Ljava/lang/Integer;", "parseRgbaColor", "rgba", "applyMaskColor", "insertView", "child", "Lcom/lynx/tasm/behavior/ui/LynxUI;", "destroy", "scheduleShow", "showIfPossible", "createSelectionDialog", "host", "items", "Lorg/json/JSONArray;", "createConfirmDialog", "json", "buildSelectionBody", "Landroid/view/View;", "onClick", "Lkotlin/Function2;", "sendSelectEvent", "index", "dismissDialog", "emitCancel", "emitDismiss", "sendSimpleEvent", "type", "resolveDialogTouchDispatcher", "Lcom/lynx/tasm/behavior/TouchEventDispatcher;", "resolveTouchBound", "Landroid/graphics/Rect;", "detachHostFromOriginalParent", "restoreHostToOriginalParent", "clearOriginalParentSnapshot", "refreshDialogContentLayout", "stage", "resolveUiContentHeight", "snapshots", "buildSnapshotSummary", "relayoutChildren", "logHostLayoutState", "bodyContainer", "resolveMaxBodyHeight", "Landroid/app/Dialog;", "snapshotUiSubtree", "nodes", "Lcom/lynx/tasm/behavior/ui/LynxBaseUI;", "depth", "toSnapshot", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LynxMiniAppDialogUI extends UIGroup<h> {
    public static final /* synthetic */ int r = 0;
    public h a;
    public OSelectionDialog b;
    public JSONObject c;
    public String d;
    public String e;
    public Integer f;
    public boolean g;
    public boolean h;
    public boolean i;
    public ViewGroup j;
    public int k;
    public ViewGroup.LayoutParams l;
    public f m;
    public final List<g> n;
    public boolean o;
    public boolean p;
    public final j0 q;

    public static final class a {
    }

    public static final class b<T> implements Comparator {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r4, T r5) {
            g r6 = (g) r5;
            int r0 = r6.d + r6.f;
            Rect r7 = r6.s;
            int r1 = 0;
            if (r7 == null) goto L5;
            int r8 = r7.bottom;
        L6:
            Integer r9 = Integer.valueOf(Math.max(r0, r8));
            g r10 = (g) r4;
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

    /* JADX INFO: renamed from: com.obric.miniapp.lynx.LynxMiniAppDialogUI$createView$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<com.lynx.tasm.behavior.b1> {
        public AnonymousClass1(Object r8) {
            super(0, r8, LynxMiniAppDialogUI.class, "resolveDialogTouchDispatcher", "resolveDialogTouchDispatcher()Lcom/lynx/tasm/behavior/TouchEventDispatcher;", 0);
        }

        public final com.lynx.tasm.behavior.b1 invoke() {
            LynxMiniAppDialogUI r0 = (LynxMiniAppDialogUI) ((CallableReference) this).receiver;
            int r1 = LynxMiniAppDialogUI.r;
            LynxContext r2 = r0.getLynxContext();
            if (r2 != null) goto L5;
            return null;
        L5:
            r2.EnsureEventDispatcher();
            return r2.getTouchEventDispatcher();
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m233invoke() {
            return invoke();
        }
    }

    /* JADX INFO: renamed from: com.obric.miniapp.lynx.LynxMiniAppDialogUI$createView$3, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function0<Rect> {
        public AnonymousClass3(Object r8) {
            super(0, r8, LynxMiniAppDialogUI.class, "resolveTouchBound", "resolveTouchBound()Landroid/graphics/Rect;", 0);
        }

        public final Rect invoke() {
            LynxMiniAppDialogUI r0 = (LynxMiniAppDialogUI) ((CallableReference) this).receiver;
            int r1 = LynxMiniAppDialogUI.r;
            LynxBaseUI r2 = (LynxBaseUI) CollectionsKt.firstOrNull(r0.getChildren());
            if (r2 == null) goto L7;
            Rect r3 = r2.getBound();
            if (r3 == null) goto L7;
            return r3;
        L7:
            return r0.getBound();
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m234invoke() {
            return invoke();
        }
    }

    static {
    }

    public final void destroy() {
        P(false);
        com.lynx.tasm.behavior.ui.view.a r0 = this.a;
        if (r0 == null) goto L5;
        r0.removeAllViews();
    L5:
        this.a = null;
        super.destroy();
    }

    public final void S() {
        com.lynx.tasm.behavior.ui.view.a r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        ViewGroup r1 = this.j;
        if (r1 != null) goto L9;
        return;
    L9:
        if (r0.getParent() != r1) goto L12;
        this.j = null;
        this.k = -1;
        this.l = null;
        return;
    L12:
        ViewParent r2 = r0.getParent();
        if ((r2 instanceof ViewGroup) == false) goto L15;
        ViewGroup r3 = (ViewGroup) r2;
    L16:
        if (r3 == null) goto L18;
        r3.removeView(r0);
    L18:
        ViewGroup.LayoutParams r4 = this.l;
        int r5 = RangesKt.coerceIn(this.k, 0, r1.getChildCount());
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L25
        if (r4 == null) goto L22;
        r1.addView(r0, r5, r4);     // Catch: Throwable -> L25
    L23:
        Object r7 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L25
    L27:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L30;
        FLogger.a.w("LynxOUIDialogUI", "restore content host failed: " + r8.getMessage());
    L30:
        this.j = null;
        this.k = -1;
        this.l = null;
        return;
    L22:
        r1.addView(r0, r5);     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L27
    L15:
        r3 = null;
        goto L16
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [com.obric.miniapp.lynx.j0] */
    public LynxMiniAppDialogUI(LynxContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.h = true;
        this.i = true;
        this.k = -1;
        this.n = CollectionsKt.emptyList();
        this.q = new j0(this);
    }

    public static void M(OSelectionDialog r3) {
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

    public static Integer Q(String r4) {
        Object r0 = null;
        if (r4 != null) goto L5;
        return null;
    L5:
        if ((!StringsKt.isBlank(r4)) == true) goto L8;
        r4 = null;
    L8:
        if (r4 == null) goto L29;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L18
        if (StringsKt.startsWith$default(r4, "#", false, 2, null) == false) goto L13;
        int r5 = Color.parseColor(r4);     // Catch: Throwable -> L18
    L16:
        Object r6 = Result.constructor-impl(Integer.valueOf(r5));     // Catch: Throwable -> L18
    L21:
        if (Result.isFailure-impl(r6) == true) goto L25;
        r0 = r6;
    L25:
        return (Integer) r0;
    L13:
        if (StringsKt.startsWith$default(r4, "rgba(", false, 2, null) == false) goto L15;
        r5 = R(r4);     // Catch: Throwable -> L18
        goto L16
    L15:
        r5 = Color.parseColor(r4);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L21
    L29:
        return null;
    }

    public static int R(String r4) {
        MatchResult r5 = Regex.find$default(new Regex("rgba\\((\\d+),\\s*(\\d+),\\s*(\\d+),\\s*([\\d.]+)\\)"), r4, 0, 2, null);
        if (r5 == null) goto L5;
        MatchResult.Destructured r6 = r5.getDestructured();
        return Color.argb((int) (CastFloatProtector.parseFloat((String) ListProtector.get(r6.getMatch().getGroupValues(), 4)) * 255), CastIntegerProtector.parseInt((String) ListProtector.get(r6.getMatch().getGroupValues(), 1)), CastIntegerProtector.parseInt((String) ListProtector.get(r6.getMatch().getGroupValues(), 2)), CastIntegerProtector.parseInt((String) ListProtector.get(r6.getMatch().getGroupValues(), 3)));
    L5:
        return 1375731712;
    }

    public final void N(OSelectionDialog r6) {
        Integer r0 = this.f;
        if (r0 == null) goto L5;
        int r1 = r0.intValue();
    L7:
        if (r1 != 0) goto L18;
        Window r7 = r6.getWindow();
        if (r7 == null) goto L33;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L12
        r7.setDimAmount(0.0f);     // Catch: Throwable -> L12
        r7.clearFlags(2);     // Catch: Throwable -> L12
        Object r8 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L14:
        Throwable r3 = Result.exceptionOrNull-impl(r8);
        if (r3 == null) goto L17;
        FLogger.a.w("LynxOUIDialogUI", "clear dialog dim failed: " + r3.getMessage());
    L17:
        Result.box-impl(r8);
        return;
    L12:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    L33:
        return;
    L18:
        float r5 = Color.alpha(r1) / 255.0f;
        Window r9 = r6.getWindow();
        if (r9 == null) goto L35;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L22
        r9.setDimAmount(r5);     // Catch: Throwable -> L22
        r9.addFlags(2);     // Catch: Throwable -> L22
        Object r11 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L22
    L24:
        Throwable r12 = Result.exceptionOrNull-impl(r11);
        if (r12 == null) goto L27;
        FLogger.a.w("LynxOUIDialogUI", "set dialog dim failed: " + r12.getMessage());
    L27:
        Result.box-impl(r11);
        return;
    L22:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L24
    L35:
        return;
    L5:
        r1 = 1375731712;
        goto L7
    }

    public final String O(List<g> r10) {
        return CollectionsKt.joinToString$default(CollectionsKt.take(CollectionsKt.sortedWith(r10, new b()), 6), " | ", null, null, 0, null, new i0(), 30, null);
    }

    public final void P(boolean r4) {
        OSelectionDialog r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        this.h = false;
        this.i = r4;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L8
        M(r0);     // Catch: Throwable -> L8
        Object r6 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L16;
        FLogger.a.e("LynxOUIDialogUI", "dismiss dialog failed", r7);
        return;
    L16:
        return;
    L8:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    public final void T(String r4) {
        LynxContext r0 = getLynxContext();
        if (r0 == null) goto L9;
        EventEmitter r1 = r0.getEventEmitter();
        if (r1 == null) goto L10;
        r1.sendCustomEvent(new m7a.a(getSign(), r4));
        return;
    L10:
        return;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [android.view.View, android.view.ViewGroup, com.obric.miniapp.lynx.h] */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.obric.miniapp.lynx.y] */
    public final View createView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        ?? r0 = new h(r5, new AnonymousClass1(this), new y(this), new AnonymousClass3(this));
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
        r1.i("LynxOUIDialogUI", r2.toString());
        r0.getChildCount();
        r0.getLayoutParams();
        r0.getLayoutParams();
        if (this.g == true) goto L15;
        return;
    L15:
        if (this.b == null) goto L19;
        r0.post(new h0(this));
        return;
    L19:
        return;
    L8:
        r7 = null;
        goto L9
    }

    @LynxProp(name = "maskColor")
    public final void setMaskColor(String r1) {
        this.f = Q(r1);
    }

    @LynxProp(name = "message")
    public final void setMessage(String r3) {
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
        this.e = r0;
    }

    @LynxProp(name = "options")
    public final void setOptions(String r6) {
        if (r6 == null) goto L44;
        boolean r1 = true;
        String r2 = null;
        if ((!StringsKt.isBlank(r6)) == true) goto L7;
        r6 = null;
    L7:
        if (r6 == null) goto L45;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L10
        Object r7 = Result.constructor-impl(new JSONObject(r6));     // Catch: Throwable -> L10
    L13:
        if (Result.isFailure-impl(r7) == false) goto L15;
        r7 = null;
    L15:
        JSONObject r8 = (JSONObject) r7;
        if (r8 != null) goto L19;
        return;
    L19:
        if (r8.has("title") == false) goto L29;
        String r3 = StringsKt.trim(r8.optString("title")).toString();
        if (r3.length() <= 0) goto L23;
        boolean r4 = true;
    L24:
        if (r4 == true) goto L27;
        r3 = null;
    L27:
        this.d = r3;
        goto L29
    L23:
        r4 = false;
    L29:
        if (r8.has("message") == false) goto L38;
        String r5 = StringsKt.trim(r8.optString("message")).toString();
        if (r5.length() > 0) goto L34;
        r1 = false;
    L34:
        if (r1 == false) goto L36;
        r2 = r5;
    L36:
        this.e = r2;
    L38:
        if (r8.has("maskColor") == false) goto L40;
        this.f = Q(r8.optString("maskColor"));
    L40:
        this.c = r8;
        return;
    L10:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    L45:
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
        this.d = r0;
    }

    @LynxProp(name = "visible")
    public final void setVisible(boolean r3) {
        this.g = r3;
        if (r3 == false) goto L11;
        com.lynx.tasm.behavior.ui.view.a r4 = this.a;
        if (r4 != null) goto L8;
        return;
    L8:
        if (this.p == true) goto L15;
        this.p = true;
        r4.post(this.q);
        return;
    L15:
        return;
    L11:
        P(true);
    }

    public final List<g> U(List<? extends LynxBaseUI> r24, int r25) {
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
        r0.add(new g(r2, r25, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22));
        List<? extends LynxBaseUI> r4 = r2.getChildren();
        Intrinsics.checkNotNull(r4);
        if ((!r4.isEmpty()) == false) goto L13;
        r0.addAll(U(r4, r25 + 1));
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
