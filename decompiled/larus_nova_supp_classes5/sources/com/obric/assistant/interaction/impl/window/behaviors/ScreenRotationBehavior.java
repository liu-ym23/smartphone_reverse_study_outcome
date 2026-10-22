package com.obric.assistant.interaction.impl.window.behaviors;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.window.IBehavior;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import e19.t;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\u001e\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u0002¨\u0006\u0010"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/behaviors/ScreenRotationBehavior;", "Lcom/obric/assistant/interaction/api/window/IBehavior;", "<init>", "()V", "init", "", "onScreenRotationChanged", "previousRotation", "", "newRotation", "runRotationAction", "errorMessage", "", "action", "Lkotlin/Function0;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ScreenRotationBehavior implements IBehavior {
    public static final Companion Companion = null;
    private static final String TAG = "ScreenRotationBehavior";
    private static Function2<? super OverlaySource, ? super Boolean, Unit> dialogDismissAction;
    private static Function2<? super OverlaySource, ? super Boolean, Unit> popupWindowDismissAction;
    private static Function0<Unit> toastDismissAction;

    public ScreenRotationBehavior() {
    }

    public static /* synthetic */ Unit a() {
        return onScreenRotationChanged$lambda$1();
    }

    public static /* synthetic */ Unit b(OverlaySource r0, boolean r1) {
        return popupWindowDismissAction$lambda$5(r0, r1);
    }

    public static /* synthetic */ Unit c(OverlaySource r0, boolean r1) {
        return dialogDismissAction$lambda$6(r0, r1);
    }

    public static /* synthetic */ Unit d() {
        return onScreenRotationChanged$lambda$3();
    }

    public static /* synthetic */ Unit e() {
        return onScreenRotationChanged$lambda$2();
    }

    public static /* synthetic */ Unit f() {
        return toastDismissAction$lambda$7();
    }

    public static /* synthetic */ Unit g() {
        return onScreenRotationChanged$lambda$0();
    }

    public void init() {
    }

    static {
        Companion = new Companion(null);
        popupWindowDismissAction = new w();
        dialogDismissAction = new x();
        toastDismissAction = new y();
    }

    private static final Unit onScreenRotationChanged$lambda$0() {
        popupWindowDismissAction.invoke(OverlaySource.WINDOW, Boolean.FALSE);
        return Unit.INSTANCE;
    }

    private static final Unit onScreenRotationChanged$lambda$1() {
        dialogDismissAction.invoke(OverlaySource.WINDOW, Boolean.FALSE);
        return Unit.INSTANCE;
    }

    private static final Unit onScreenRotationChanged$lambda$2() {
        toastDismissAction.invoke();
        return Unit.INSTANCE;
    }

    private static final Unit onScreenRotationChanged$lambda$3() {
        t r0 = t.j;
        t r1 = t.a.a();
        if (r1 == null) goto L6;
        r1.c.c.g();
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit toastDismissAction$lambda$7() {
        s.a.a();
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ Function2 access$getDialogDismissAction$cp() {
        return dialogDismissAction;
    }

    public static final /* synthetic */ Function2 access$getPopupWindowDismissAction$cp() {
        return popupWindowDismissAction;
    }

    public static final /* synthetic */ Function0 access$getToastDismissAction$cp() {
        return toastDismissAction;
    }

    public void onAppBackground() {
        IBehavior.DefaultImpls.onAppBackground(this);
    }

    public void onAppForeground() {
        IBehavior.DefaultImpls.onAppForeground(this);
    }

    public void onWindowDismiss() {
        IBehavior.DefaultImpls.onWindowDismiss(this);
    }

    public void onWindowHide() {
        IBehavior.DefaultImpls.onWindowHide(this);
    }

    public void onWindowPreDismiss() {
        IBehavior.DefaultImpls.onWindowPreDismiss(this);
    }

    public void onWindowPreHide() {
        IBehavior.DefaultImpls.onWindowPreHide(this);
    }

    public void onWindowPreOpenClear() {
        IBehavior.DefaultImpls.onWindowPreOpenClear(this);
    }

    public void onWindowPreShow() {
        IBehavior.DefaultImpls.onWindowPreShow(this);
    }

    public void onWindowPreloaded() {
        IBehavior.DefaultImpls.onWindowPreloaded(this);
    }

    public void onWindowShow() {
        IBehavior.DefaultImpls.onWindowShow(this);
    }

    public static final /* synthetic */ void access$setDialogDismissAction$cp(Function2 r0) {
        dialogDismissAction = r0;
    }

    public static final /* synthetic */ void access$setPopupWindowDismissAction$cp(Function2 r0) {
        popupWindowDismissAction = r0;
    }

    public static final /* synthetic */ void access$setToastDismissAction$cp(Function0 r0) {
        toastDismissAction = r0;
    }

    private static final Unit dialogDismissAction$lambda$6(OverlaySource r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "source");
        PopupOrDialogVisibilityTracker.dismissAllTrackedDialogs(r1, r2);
        return Unit.INSTANCE;
    }

    private static final Unit popupWindowDismissAction$lambda$5(OverlaySource r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "source");
        PopupOrDialogVisibilityTracker.dismissAllTrackedPopupWindows(r1, r2);
        return Unit.INSTANCE;
    }

    private final void runRotationAction(String r3, Function0<Unit> r4) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r5 = Result.constructor-impl(r4.invoke());     // Catch: Throwable -> L4
    L6:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L12;
        FLogger.a.e(TAG, r3, r6);
        return;
    L12:
        return;
    L4:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }

    public void onScreenRotationChanged(int r4, int r5) {
        FLogger.a.i(TAG, "onScreenRotationChanged, previousRotation=" + r4 + ", newRotation=" + r5);
        runRotationAction("dismiss popup window failed", new s());
        runRotationAction("dismiss dialog failed", new t());
        runRotationAction("dismiss toast failed", new u());
        runRotationAction("reset mutex float window position failed", new v());
    }
}
