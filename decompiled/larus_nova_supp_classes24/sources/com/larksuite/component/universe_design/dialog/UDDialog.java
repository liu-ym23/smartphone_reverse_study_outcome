package com.larksuite.component.universe_design.dialog;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Window;
import androidx.appcompat.app.AppCompatDialog;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u0000 \u00162\u00020\u0001:\u0003\u0016\u0017\u0018B\u0011\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u000f\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\fH\u0016J\u0015\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\nH\u0000¢\u0006\u0002\b\u0013J\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/larksuite/component/universe_design/dialog/UDDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "theme", "", "(Landroid/content/Context;I)V", "mCallback", "Lcom/larksuite/component/universe_design/dialog/UDDialog$DialogCallback;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "show", "dismiss", "setCallback", "callback", "setCallback$universe_ui_dialog_release", "getActivity", "Landroid/app/Activity;", "Companion", "Config", "DialogCallback", "universe-ui-dialog_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public class UDDialog extends AppCompatDialog {
    public static final int $stable = 0;
    public static final a Companion = null;
    private static final b config = null;
    private DialogCallback mCallback;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u001a\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH'J\b\u0010\t\u001a\u00020\u0003H'J\b\u0010\n\u001a\u00020\u0003H'¨\u0006\u000b"}, d2 = {"Lcom/larksuite/component/universe_design/dialog/UDDialog$DialogCallback;", "", "beforeCreate", "", "dialog", "Lcom/larksuite/component/universe_design/dialog/UDDialog;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onShow", "onDismiss", "universe-ui-dialog_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public interface DialogCallback {
        void beforeCreate(UDDialog r1);

        void onCreate(UDDialog r1, Bundle r2);

        void onDismiss();

        void onShow();
    }

    public static final class a {
        public a() {
        }
    }

    public static final class b {
        public b() {
        }
    }

    public static /* synthetic */ void access$000(AppCompatDialog r0) {
        super/*android.app.Dialog*/.show();
    }

    public static /* synthetic */ void access$001(AppCompatDialog r0) {
        super.dismiss();
    }

    static {
        Companion = new a();
        $stable = 8;
        config = new b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void dismiss() {
        if (isShowing() == true) goto L5;
        return;
    L5:
        Activity r0 = getActivity(getContext());
        if (r0 != null) goto L9;
        return;
    L9:
        if (r0.isDestroyed() == true) goto L15;
        DialogCallback r1 = this.mCallback;
        if (r1 == null) goto L13;
        r1.onDismiss();
    L13:
        INVOKESPECIAL_com_larksuite_component_universe_design_dialog_UDDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(this);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void show() {
        Activity r0 = getActivity(getContext());
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isFinishing() == true) goto L11;
        INVOKESPECIAL_com_larksuite_component_universe_design_dialog_UDDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(this);
        DialogCallback r1 = this.mCallback;
        if (r1 == null) goto L12;
        r1.onShow();
        return;
    L12:
        return;
    }

    public static final /* synthetic */ b access$getConfig$cp() {
        return config;
    }

    public UDDialog(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, 2131953838);
    }

    public static void INVOKESPECIAL_com_larksuite_component_universe_design_dialog_UDDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(AppCompatDialog r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        access$001(r3);     // Catch: Throwable -> L11 Exception -> L13
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

    public static void INVOKESPECIAL_com_larksuite_component_universe_design_dialog_UDDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(AppCompatDialog r1) {
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r1);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r1);
        access$000(r1);
        DialogLancet.afterDialogShow(r1);
    }

    private final Activity getActivity(Context r2) {
        if (r2 == null) goto L13;
        if ((r2 instanceof Activity) == true) goto L13;
        if ((r2 instanceof ContextWrapper) == true) goto L11;
        return null;
    L11:
        return getActivity(((ContextWrapper) r2).getBaseContext());
    L13:
        return (Activity) r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate(Bundle r3) {
        Window r0 = getWindow();
        if (r0 == null) goto L5;
        r0.clearFlags(131080);
    L5:
        DialogCallback r1 = this.mCallback;
        if (r1 == null) goto L8;
        r1.beforeCreate(this);
    L8:
        super.onCreate(r3);
        DialogCallback r2 = this.mCallback;
        if (r2 == null) goto L12;
        r2.onCreate(this, r3);
        return;
    }

    public final void setCallback$universe_ui_dialog_release(DialogCallback r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.mCallback = r2;
    }

    public UDDialog(Context r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
    }
}
