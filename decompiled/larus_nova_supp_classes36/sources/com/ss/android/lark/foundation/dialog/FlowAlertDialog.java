package com.ss.android.lark.foundation.dialog;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentDialog;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.ViewCompositionStrategy;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\tJ\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\tJ&\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\t2\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011J&\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\t2\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011J\u0010\u0010\u001f\u001a\u00020\u00002\b\b\u0001\u0010 \u001a\u00020\u0005J\u0010\u0010!\u001a\u00020\u00002\b\b\u0001\u0010 \u001a\u00020\u0005J\u0010\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\u0015H\u0016J\u0010\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u0015H\u0016J\u0012\u0010&\u001a\u00020\u00122\b\u0010'\u001a\u0004\u0018\u00010(H\u0014J\f\u0010)\u001a\u00020\u0003*\u00020\u0003H\u0002J\b\u0010*\u001a\u00020\u0012H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u001c\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/ss/android/lark/foundation/dialog/FlowAlertDialog;", "Landroidx/activity/ComponentDialog;", "context", "Landroid/content/Context;", "themeResId", "", "<init>", "(Landroid/content/Context;I)V", "titleText", "", "contentText", "positiveText", "negativeText", "positiveColorInt", "Ljava/lang/Integer;", "negativeColorInt", "positiveListener", "Lkotlin/Function1;", "", "negativeListener", "isCancelable", "", "dismissOnOutside", "composeView", "Landroidx/compose/ui/platform/ComposeView;", "setTitleText", "text", "setMessageText", "setPositiveButton", "listener", "setNegativeButton", "setPositiveButtonColor", "color", "setNegativeButtonColor", "setCanceledOnTouchOutside", "cancel", "setCancelable", "flag", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "findContextImpl", "render", "flow-ud_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FlowAlertDialog extends ComponentDialog {
    public String a;
    public String b;
    public String c;
    public String d;
    public Integer e;
    public Integer f;
    public Function1<? super FlowAlertDialog, Unit> g;
    public Function1<? super FlowAlertDialog, Unit> h;
    public boolean i;
    public boolean j;
    public ComposeView k;

    public /* synthetic */ FlowAlertDialog() {
        throw null;
    }

    public static Context b(Context r1) {
        if ((r1 instanceof Activity) == false) goto L6;
        return r1;
    L6:
        if ((r1 instanceof ContextWrapper) == true) goto L8;
        return r1;
    L8:
        return b(((ContextWrapper) r1).getBaseContext());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r9) {
        super.onCreate(r9);
        Window r10 = getWindow();
        if (r10 == null) goto L20;
        r10.setBackgroundDrawable(new ColorDrawable(0));
        ComposeView r11 = new ComposeView(getContext(), null, 0, 6, null);
        r11.setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnDetachedFromWindow.INSTANCE);
        this.k = r11;
        SavedStateRegistryOwner r12 = b(getContext());
        View r0 = this.k;
        ComposeView r2 = null;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("composeView");
        r0 = null;
    L8:
        if ((r12 instanceof SavedStateRegistryOwner) == false) goto L10;
        SavedStateRegistryOwner r13 = r12;
    L11:
        ViewTreeSavedStateRegistryOwner.set(r0, r13);
        View r14 = this.k;
        if (r14 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("composeView");
        r14 = null;
    L14:
        setContentView(r14);
        ComposeView r15 = this.k;
        if (r15 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("composeView");
    L18:
        r2.setContent(ComposableLambdaKt.composableLambdaInstance(1424654349, true, new FlowAlertDialog$render$1(this)));
        return;
    L17:
        r2 = r15;
        goto L18
    L10:
        r13 = null;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setCancelable(boolean r1) {
        super/*android.app.Dialog*/.setCancelable(r1);
        this.i = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setCanceledOnTouchOutside(boolean r1) {
        super/*android.app.Dialog*/.setCanceledOnTouchOutside(r1);
        this.j = r1;
    }

    public FlowAlertDialog(Context r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.a = "";
        this.b = "";
        this.c = "";
        this.d = "";
        this.i = true;
        this.j = true;
    }
}
