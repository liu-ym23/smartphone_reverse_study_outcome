package com.obric.miniapp.lynx;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import com.larus.utils.logger.FLogger;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.oui.dialog.v2.selection.OSelectionDialog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0007\u0018\u0000 62\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00016B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0014H\u0014J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0012\u0010\u0019\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0007J\u0010\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\rH\u0007J\b\u0010\u001e\u001a\u00020\u0016H\u0016J\b\u0010\u001f\u001a\u00020\u0016H\u0002J\b\u0010 \u001a\u00020\u0016H\u0002J(\u0010!\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020%H\u0002J(\u0010&\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020\tH\u0002J4\u0010(\u001a\u00020)2\u0006\u0010\u0003\u001a\u00020\u00142\u0006\u0010$\u001a\u00020%2\u001a\u0010*\u001a\u0016\u0012\u0004\u0012\u00020,\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0012\u0004\u0012\u00020\u00160+H\u0002J\b\u0010-\u001a\u00020\u0016H\u0002J\b\u0010.\u001a\u00020\u0016H\u0002J\u0012\u0010/\u001a\u00020\u00162\b\u00100\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u00101\u001a\u00020\u00162\b\u00100\u001a\u0004\u0018\u00010\u000bH\u0002J\u001a\u00102\u001a\u00020\u00162\u0006\u00103\u001a\u00020,2\b\u0010\"\u001a\u0004\u0018\u00010\u001bH\u0002J\u0010\u00104\u001a\u00020\u00162\u0006\u00105\u001a\u00020\u001bH\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/obric/miniapp/lynx/LynxOUIDialogUI;", "Lcom/lynx/tasm/behavior/ui/LynxUI;", "Landroid/widget/FrameLayout;", "context", "Lcom/lynx/tasm/behavior/LynxContext;", "<init>", "(Lcom/lynx/tasm/behavior/LynxContext;)V", "root", "optionsJson", "Lorg/json/JSONObject;", "dialog", "Lcom/obric/oui/dialog/v2/selection/OSelectionDialog;", "dialogDismissPosted", "", "hasSelected", "visibleProp", "showPosted", "showRunnable", "Ljava/lang/Runnable;", "createView", "Landroid/content/Context;", "updatePropertiesInterval", "", "props", "Lcom/lynx/tasm/behavior/StylesDiffMap;", "setOptions", "options", "", "setVisible", "visible", "destroy", "scheduleShow", "showIfPossible", "createSelectionDialog", "title", "message", "items", "Lorg/json/JSONArray;", "createConfirmDialog", "json", "buildSelectionBody", "Landroid/view/View;", "onClick", "Lkotlin/Function2;", "", "dismiss", "dismissAsyncFromProp", "scheduleDismissFallback", "target", "dismissDialogImmediately", "sendSelectEvent", "index", "sendSimpleEvent", "type", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LynxOUIDialogUI extends LynxUI<FrameLayout> {
    public static final /* synthetic */ int i = 0;
    public FrameLayout a;
    public JSONObject b;
    public OSelectionDialog c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public final v2 h;

    public static final class a {
    }

    static {
    }

    public final void destroy() {
        this.f = false;
        FrameLayout r0 = this.a;
        if (r0 == null) goto L5;
        r0.removeCallbacks(this.h);
    L5:
        O(this.c);
        this.a = null;
        super.destroy();
    }

    public final void Q() {
        FrameLayout r0 = this.a;
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.g == false) goto L8;
        return;
    L8:
        this.g = true;
        r0.post(this.h);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.obric.miniapp.lynx.v2] */
    public LynxOUIDialogUI(LynxContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.h = new v2(this);
        if (r2.getDefaultOverflowVisible() == false) goto L6;
        ((LynxBaseUI) this).mOverflow = 3;
        return;
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

    public static void N(OSelectionDialog r3) {
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

    /* JADX WARN: Type inference failed for: r2v7, types: [com.obric.miniapp.lynx.t2] */
    public final void O(final OSelectionDialog r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        OSelectionDialog r0 = this.c;
        if (r8 == r0) goto L7;
    L9:
        if (r8 != r0) goto L11;
        this.d = true;
    L11:
        Window r1 = r8.getWindow();
        View r2 = null;
        if (r1 == null) goto L14;
        View r3 = M(r1);
    L15:
        Window r4 = r8.getWindow();
        if (r4 != null) goto L40;
    L25:
        if (r3 == null) goto L27;
        r2 = r3.findFocus();
    L27:
        if (r2 == null) goto L29;
        r2.clearFocus();
    L29:
        if (r3 == null) goto L31;
        r3.clearFocus();
    L31:
        final ?? r5 = new t2(this, r8);
        if (r2 != null) goto L35;
        if (r3 != null) goto L36;
        r3 = this.a;
    L36:
        if (r3 == null) goto L38;
        r3.post(new u2(r5));
        return;
    L38:
        r5.invoke();
        return;
    L35:
        r3 = r2;
        goto L36
    L40:
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L19
        r4.setDimAmount(0.0f);     // Catch: Throwable -> L19
        r4.clearFlags(2);     // Catch: Throwable -> L19
        Object r7 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L19
    L21:
        Throwable r9 = Result.exceptionOrNull-impl(r7);
        if (r9 == null) goto L24;
        FLogger.a.w("LynxOUIDialogUI", "clear dialog dim failed: " + r9.getMessage());
    L24:
        Result.box-impl(r7);
    L19:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L21
    L14:
        r3 = null;
        goto L15
    L7:
        if (this.d == false) goto L9;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.obric.miniapp.lynx.p2] */
    public final void P(final OSelectionDialog r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        final ?? r0 = new p2(this, r5);
        Window r6 = r5.getWindow();
        if (r6 == null) goto L8;
        View r7 = M(r6);
        if (r7 == null) goto L8;
    L9:
        if (r7 == null) goto L11;
        r7.postDelayed(new q2(r0), 160);
        return;
    L11:
        r0.invoke();
        return;
    L8:
        r7 = this.a;
        goto L9
    }

    public final void R(String r4) {
        LynxContext r0 = getLynxContext();
        if (r0 == null) goto L9;
        EventEmitter r1 = r0.getEventEmitter();
        if (r1 == null) goto L10;
        r1.sendCustomEvent(new m7a.a(getSign(), r4));
        return;
    L10:
        return;
    }

    public final View createView(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        FrameLayout r0 = new FrameLayout(r3);
        r0.setClickable(false);
        r0.setFocusable(false);
        r0.setFocusableInTouchMode(false);
        r0.setEnabled(false);
        r0.setImportantForAccessibility(2);
        r0.setMinimumWidth(0);
        r0.setMinimumHeight(0);
        r0.setVisibility(8);
        this.a = r0;
        return r0;
    }

    @LynxProp(name = "options")
    public final void setOptions(String r1) {
        this.b = o1.G(r1);
        if (this.f == false) goto L6;
        Q();
        return;
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [com.obric.miniapp.lynx.l2] */
    @LynxProp(name = "visible")
    public final void setVisible(boolean r3) {
        this.f = r3;
        if (r3 == false) goto L5;
        Q();
        return;
    L5:
        final ?? r4 = new l2(this);
        OSelectionDialog r0 = this.c;
        if (r0 == null) goto L11;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L11;
        View r2 = M(r1);
        if (r2 == null) goto L11;
    L12:
        if (r2 == null) goto L14;
        r2.post(new s2(r4));
        return;
    L14:
        r4.invoke();
        return;
    L11:
        r2 = this.a;
        goto L12
    }

    public final void updatePropertiesInterval(com.lynx.tasm.behavior.x0 r9) {
        Intrinsics.checkNotNullParameter(r9, "props");
        super/*com.lynx.tasm.behavior.ui.LynxBaseUI*/.updatePropertiesInterval(o1.S(r9, this.b, new String[]{"title", "message", "items", "positiveText", "negativeText", "confirmText", "cancelText"}, new String[]{"items"}, 2));
    }
}
