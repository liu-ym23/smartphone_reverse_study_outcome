package com.obric.oui.dialog.base;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import com.obric.oui.dialog.base.AbstractDialog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u0002\n\u0002\b\u0005\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010>\u001a\u00028\u0000¢\u0006\u0002\u0010?J\u0018\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0016J\r\u0010@\u001a\u00028\u0000H&¢\u0006\u0002\u0010?J\u0014\u0010A\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010B\u001a\u00020\bJ\u0014\u0010C\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010D\u001a\u00020!J\u0014\u0010E\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010F\u001a\u00020'J\u0014\u0010G\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010H\u001a\u00020!J3\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010J\u001a\u00020\u001b2\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010L\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0002\u0010MJ\u0006\u0010N\u001a\u00020OJ\"\u00102\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010P\u001a\u00020\u000e2\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010-H\u0016J\u0016\u0010R\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010S\u001a\u00020\u0015H\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R*\u0010\u0013\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0014X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010&\u001a\u0004\u0018\u00010'X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010,\u001a\u0004\u0018\u00010-X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u00102\u001a\u00020\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0010\"\u0004\b4\u0010\u0012R\u001c\u00105\u001a\u0004\u0018\u00010!X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010#\"\u0004\b7\u0010%R\u001e\u00108\u001a\u0004\u0018\u00010\u0015X\u0080\u000e¢\u0006\u0010\n\u0002\u0010=\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<¨\u0006T"}, d2 = {"Lcom/obric/oui/dialog/base/AbstractDialogBuilder;", com.tom_roush.pdfbox.pdmodel.a.c.a.f16161b, "Lcom/obric/oui/dialog/base/AbstractDialog;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "cancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "getCancelListener$OUI_standardRelease", "()Landroid/content/DialogInterface$OnCancelListener;", "setCancelListener$OUI_standardRelease", "(Landroid/content/DialogInterface$OnCancelListener;)V", "cancelable", "", "getCancelable$OUI_standardRelease", "()Z", "setCancelable$OUI_standardRelease", "(Z)V", "closeIconColor", "Lkotlin/Pair;", "", "getCloseIconColor$OUI_standardRelease", "()Lkotlin/Pair;", "setCloseIconColor$OUI_standardRelease", "(Lkotlin/Pair;)V", "closeIconStyle", "Lcom/obric/oui/dialog/base/AbstractDialog$CloseIconStyle;", "getCloseIconStyle$OUI_standardRelease", "()Lcom/obric/oui/dialog/base/AbstractDialog$CloseIconStyle;", "setCloseIconStyle$OUI_standardRelease", "(Lcom/obric/oui/dialog/base/AbstractDialog$CloseIconStyle;)V", "completeShowListener", "Landroid/content/DialogInterface$OnShowListener;", "getCompleteShowListener$OUI_standardRelease", "()Landroid/content/DialogInterface$OnShowListener;", "setCompleteShowListener$OUI_standardRelease", "(Landroid/content/DialogInterface$OnShowListener;)V", "dismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "getDismissListener$OUI_standardRelease", "()Landroid/content/DialogInterface$OnDismissListener;", "setDismissListener$OUI_standardRelease", "(Landroid/content/DialogInterface$OnDismissListener;)V", "onCloseClickListener", "Landroid/view/View$OnClickListener;", "getOnCloseClickListener$OUI_standardRelease", "()Landroid/view/View$OnClickListener;", "setOnCloseClickListener$OUI_standardRelease", "(Landroid/view/View$OnClickListener;)V", "showCloseIcon", "getShowCloseIcon$OUI_standardRelease", "setShowCloseIcon$OUI_standardRelease", "showListener", "getShowListener$OUI_standardRelease", "setShowListener$OUI_standardRelease", "windowFixedHeightPx", "getWindowFixedHeightPx$OUI_standardRelease", "()Ljava/lang/Integer;", "setWindowFixedHeightPx$OUI_standardRelease", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "build", "()Lcom/obric/oui/dialog/base/AbstractDialog;", "createDialog", "onCancel", "onCancelListener", "onCompleteShow", "onCompleteShowListener", "onDismiss", "onDismissListener", "onShow", "onShowListener", "setCloseIconStyle", "style", "iconColor", "iconBgColor", "(Lcom/obric/oui/dialog/base/AbstractDialog$CloseIconStyle;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/obric/oui/dialog/base/AbstractDialogBuilder;", "show", "", "enabled", "listener", "windowFixedHeight", "heightPx", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class a<D extends AbstractDialog> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f13814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private DialogInterface.OnDismissListener f13815b;
    private DialogInterface.OnCancelListener c;
    private DialogInterface.OnShowListener d;
    private DialogInterface.OnShowListener e;
    private View.OnClickListener f;
    private boolean g;
    private boolean h;
    private AbstractDialog.CloseIconStyle i;
    private Pair<Integer, Integer> j;
    private Integer k;

    public a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        this.f13814a = ZeusTransformUtils.wrapperContext(r4, "com.obric.memorydata.plugin");
        this.g = true;
        this.i = AbstractDialog.CloseIconStyle.DARK;
        this.j = TuplesKt.to(null, null);
    }

    public static /* synthetic */ a a(a r2, boolean r3, View.OnClickListener r4, int r5, Object r6) {
        View.OnClickListener r7 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, View.OnClickListener.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L10;
        if ((r5 & 2) == 0) goto L8;
        r7 = null;
    L8:
        return r2.a(r3, r7);
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showCloseIcon");
    }

    public final a<D> a(DialogInterface.OnDismissListener r3) {
        DialogInterface.OnDismissListener r4 = (DialogInterface.OnDismissListener) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.OnDismissListener.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "onDismissListener");
        this.f13815b = r4;
        return this;
    }

    public a<D> a(boolean r3, View.OnClickListener r4) {
        View.OnClickListener r5 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, View.OnClickListener.class, "com.obric.memorydata.plugin");
        this.h = r3;
        this.f = r5;
        return this;
    }

    public abstract D b();

    public final DialogInterface.OnDismissListener c() {
        return this.f13815b;
    }

    public a<D> c(boolean r1) {
        this.g = r1;
        return this;
    }

    public final DialogInterface.OnCancelListener d() {
        return this.c;
    }

    public final DialogInterface.OnShowListener e() {
        return this.d;
    }

    public final boolean f() {
        return this.h;
    }

    public final D g() {
        D r0 = (D) b();
        r0.a(this.e);
        Integer r1 = this.k;
        if (r1 == null) goto L6;
        r0.a(((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.memorydata.plugin")).intValue());
    L6:
        r0.a(this.h, this.f);
        r0.setCancelable(this.g);
        r0.a(this.i, (Integer) ZeusTransformUtils.preCheckCast(this.j.getFirst(), Integer.class, "com.obric.memorydata.plugin"), (Integer) ZeusTransformUtils.preCheckCast(this.j.getSecond(), Integer.class, "com.obric.memorydata.plugin"));
        return r0;
    }

    public final void h() {
        g().show();
    }
}
