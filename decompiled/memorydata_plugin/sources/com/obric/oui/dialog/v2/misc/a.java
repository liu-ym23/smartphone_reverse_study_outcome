package com.obric.oui.dialog.v2.misc;

import android.text.Layout;
import android.view.View;
import android.widget.FrameLayout;
import com.obric.memorydata.plugin.R;
import com.obric.oui.forms.OEditText;
import com.obric.oui.forms.OInputLayout;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0006\b\u0017\u0018\u0000 B2\u00020\u0001:\u0003BCDB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u00103\u001a\u000204H\u0016J\n\u00105\u001a\u0004\u0018\u000106H\u0014J\b\u00107\u001a\u000208H\u0016J\b\u00109\u001a\u000204H\u0002J\b\u0010:\u001a\u000204H\u0002J\b\u0010;\u001a\u000204H\u0014J\b\u0010<\u001a\u000204H\u0014J\u000e\u0010=\u001a\u0002042\u0006\u0010>\u001a\u00020?J\u000e\u0010@\u001a\u0002042\u0006\u0010A\u001a\u00020?R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\b8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u000e\u0010\nR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0016\u001a\u00020\b8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\f\u001a\u0004\b\u0017\u0010\nR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001b\u0010\u001c\u001a\u00020\b8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\f\u001a\u0004\b\u001d\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001b\u0010!\u001a\u00020\"8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\f\u001a\u0004\b#\u0010$R\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010(\u001a\u00020\"8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\f\u001a\u0004\b)\u0010$R\u001b\u0010+\u001a\u00020,8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\f\u001a\u0004\b-\u0010.R\u001b\u00100\u001a\u00020,8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\f\u001a\u0004\b1\u0010.¨\u0006E"}, d2 = {"Lcom/obric/oui/dialog/v2/misc/OSimpleFormDialog;", "Lcom/obric/oui/dialog/base/OBaseDialog;", "context", "Landroid/content/Context;", "modifier", "Lcom/obric/oui/dialog/v2/misc/OSimpleFormDialog$Modifier;", "(Landroid/content/Context;Lcom/obric/oui/dialog/v2/misc/OSimpleFormDialog$Modifier;)V", "bodyContainer", "Landroid/widget/FrameLayout;", "getBodyContainer", "()Landroid/widget/FrameLayout;", "bodyContainer$delegate", "Lkotlin/Lazy;", "footerContainer", "getFooterContainer", "footerContainer$delegate", "inputView1", "Lcom/obric/oui/forms/OInputLayout;", "getInputView1", "()Lcom/obric/oui/forms/OInputLayout;", "setInputView1", "(Lcom/obric/oui/forms/OInputLayout;)V", "inputView1Container", "getInputView1Container", "inputView1Container$delegate", "inputView2", "getInputView2", "setInputView2", "inputView2Container", "getInputView2Container", "inputView2Container$delegate", "getModifier", "()Lcom/obric/oui/dialog/v2/misc/OSimpleFormDialog$Modifier;", "negativeButton", "Lcom/obric/oui/button/OButton;", "getNegativeButton", "()Lcom/obric/oui/button/OButton;", "negativeButton$delegate", "pendingDismissTask", "Ljava/lang/Runnable;", "positiveButton", "getPositiveButton", "positiveButton$delegate", "subtitleTextView", "Lcom/obric/oui/text/OTextView;", "getSubtitleTextView", "()Lcom/obric/oui/text/OTextView;", "subtitleTextView$delegate", "titleTextView", "getTitleTextView", "titleTextView$delegate", "dismiss", "", "getHeightChangeAnimContainer", "Landroid/view/View;", "getLayout", "", "initButtons", "initInputViews", "onStart", "onStop", "setSubtitleText", "message", "", "setTitleText", "title", "Companion", "InputViewConfig", "Modifier", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class a extends com.obric.oui.dialog.base.b {
    public static final C0749a e = null;
    private final Lazy f;
    private final Lazy g;
    private final Runnable h;
    private OInputLayout i;
    private OInputLayout j;

    /* JADX INFO: renamed from: com.obric.oui.dialog.v2.misc.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/dialog/v2/misc/OSimpleFormDialog$Companion;", "", "()V", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class C0749a {
        private C0749a() {
        }

        public /* synthetic */ C0749a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        e = new C0749a(null);
    }

    private static final void a(a r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Layout r0 = r1.f().getLayout();
        if (r0 == null) goto L6;
        r0.getLineCount();
    L6:
        r1.f().getMaxLines();
    }

    private static final void b(a r2) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        OInputLayout r3 = r2.i;     // Catch: Exception -> L11
        if (r3 == null) goto L16;
        OEditText r4 = r3.getVInput();     // Catch: Exception -> L11
        if (r4 == null) goto L17;
        r4.requestFocus();     // Catch: Exception -> L11
        return;
    L17:
        return;
    L16:
        return;
    L11:
        e = move-exception;
        com.obric.oui.c.a.b.a("OSimpleFormDialog", "onStart, requestFocus failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    private final FrameLayout g() {
        Object r2 = this.g.getValue();
        Intrinsics.checkNotNullExpressionValue(r2, "<get-bodyContainer>(...)");
        return (FrameLayout) ZeusTransformUtils.preCheckCast(r2, FrameLayout.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ void lambda$7HBUVuuRqs6x5pzaK4IoN0ULltk(a r0) {
        b(r0);
    }

    public static /* synthetic */ void lambda$RQRMyCtR1xr8QBHLGMhWTdOHNRk(a r0) {
        a(r0);
    }

    @Override // com.obric.oui.dialog.base.AbstractDialog
    public int a() {
        return ZeusTransformUtils.mapRes(R.layout.o_simple_form_dialog, "layout", "o_simple_form_dialog");
    }

    @Override // com.obric.oui.dialog.base.b, com.obric.oui.dialog.base.AbstractDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (b() == false) goto L7;
        com.obric.oui.c.a.b.b("OSimpleFormDialog", "dismiss() called but dialog is already dismissing, ignore.");
        return;
    L7:
        if (p() <= 0) goto L9;
        boolean r0 = true;
    L10:
        if (r0 == true) goto L13;
        super.dismiss();
        return;
    L13:
        b(true);
        OInputLayout r1 = this.i;
        if (r1 == null) goto L17;
        r1.clearFocus();
    L17:
        OInputLayout r2 = this.j;
        if (r2 == null) goto L21;
        r2.clearFocus();
    L21:
        g().postDelayed(this.h, 100);
        return;
    L9:
        r0 = false;
        goto L10
    }

    public final OTextView f() {
        Object r2 = this.f.getValue();
        Intrinsics.checkNotNullExpressionValue(r2, "<get-subtitleTextView>(...)");
        return (OTextView) ZeusTransformUtils.preCheckCast(r2, OTextView.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.oui.dialog.base.b, android.app.Dialog
    public void onStart() {
        super.onStart();
        f().postDelayed(new $$Lambda$a$RQRMyCtR1xr8QBHLGMhWTdOHNRk(this), 1000);
        OInputLayout r0 = this.i;
        if (r0 == null) goto L7;
        r0.postDelayed(new $$Lambda$a$7HBUVuuRqs6x5pzaK4IoN0ULltk(this), 100);
        return;
    }

    @Override // com.obric.oui.dialog.base.AbstractDialog, android.app.Dialog
    public void onStop() {
        super.onStop();
        g().removeCallbacks(this.h);
    }

    @Override // com.obric.oui.dialog.base.AbstractDialog
    public View q() {
        return (View) ZeusTransformUtils.preCheckCast(g(), View.class, "com.obric.memorydata.plugin");
    }
}
