package com.obric.assistant.interaction.impl.window.behaviors;

import androidx.fragment.app.DialogFragment;
import com.obric.assistant.interaction.api.window.IBehavior;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016¨\u0006\n"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/behaviors/AutoDismissOverlaysBehavior;", "Lcom/obric/assistant/interaction/api/window/IBehavior;", "<init>", "()V", "init", "", "onWindowPreOpenClear", "onWindowHide", "onWindowDismiss", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AutoDismissOverlaysBehavior implements IBehavior {
    public static final Companion Companion = null;
    private static Function2<? super OverlaySource, ? super Boolean, Unit> dialogDismissAction;
    private static Function2<? super OverlaySource, ? super Boolean, Unit> popupWindowDismissAction;

    public AutoDismissOverlaysBehavior() {
    }

    public static /* synthetic */ Unit a(OverlaySource r0, boolean r1) {
        return popupWindowDismissAction$lambda$1(r0, r1);
    }

    public static /* synthetic */ boolean b(DialogFragment r0) {
        return onWindowPreOpenClear$lambda$0(r0);
    }

    public static /* synthetic */ Unit c(OverlaySource r0, boolean r1) {
        return dialogDismissAction$lambda$3(r0, r1);
    }

    public static /* synthetic */ boolean d(DialogFragment r0) {
        return dialogDismissAction$lambda$3$lambda$2(r0);
    }

    public void init() {
    }

    static {
        Companion = new Companion(null);
        popupWindowDismissAction = new k();
        dialogDismissAction = new l();
    }

    public void onWindowDismiss() {
        PopupOrDialogVisibilityTracker.INSTANCE.dismissRetainedWindowDialogs$impl_mainlandRelease("window_dismiss");
        OverlaySource r0 = OverlaySource.WINDOW;
        PopupOrDialogVisibilityTracker.clearTrackedPopupWindows(r0);
        PopupOrDialogVisibilityTracker.clearTrackedDialogs(r0);
    }

    public void onWindowHide() {
        Function2<? super OverlaySource, ? super Boolean, Unit> r0 = popupWindowDismissAction;
        OverlaySource r1 = OverlaySource.WINDOW;
        Boolean r2 = Boolean.FALSE;
        r0.invoke(r1, r2);
        dialogDismissAction.invoke(r1, r2);
    }

    public void onWindowPreOpenClear() {
        PopupOrDialogVisibilityTracker r0 = PopupOrDialogVisibilityTracker.INSTANCE;
        r0.dismissRetainedWindowDialogs$impl_mainlandRelease("window_open");
        r0.dismissAllTrackedDialogs$impl_mainlandRelease(OverlaySource.WINDOW, false, new m());
    }

    public static final /* synthetic */ Function2 access$getDialogDismissAction$cp() {
        return dialogDismissAction;
    }

    public static final /* synthetic */ Function2 access$getPopupWindowDismissAction$cp() {
        return popupWindowDismissAction;
    }

    public void onAppBackground() {
        IBehavior.DefaultImpls.onAppBackground(this);
    }

    public void onAppForeground() {
        IBehavior.DefaultImpls.onAppForeground(this);
    }

    public void onWindowPreDismiss() {
        IBehavior.DefaultImpls.onWindowPreDismiss(this);
    }

    public void onWindowPreHide() {
        IBehavior.DefaultImpls.onWindowPreHide(this);
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

    private static final boolean dialogDismissAction$lambda$3$lambda$2(DialogFragment r0) {
        return !(r0 instanceof qda.a);
    }

    private static final boolean onWindowPreOpenClear$lambda$0(DialogFragment r0) {
        return r0 instanceof qda.a;
    }

    private static final Unit dialogDismissAction$lambda$3(OverlaySource r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "source");
        PopupOrDialogVisibilityTracker.INSTANCE.dismissAllTrackedDialogs$impl_mainlandRelease(r2, r3, new j());
        return Unit.INSTANCE;
    }

    private static final Unit popupWindowDismissAction$lambda$1(OverlaySource r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "source");
        PopupOrDialogVisibilityTracker.dismissAllTrackedPopupWindows(r1, r2);
        return Unit.INSTANCE;
    }

    public void onScreenRotationChanged(int r1, int r2) {
        IBehavior.DefaultImpls.onScreenRotationChanged(this, r1, r2);
    }
}
