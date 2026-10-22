package com.obric.oui.dialog.v2.alert;

import android.content.Context;
import android.os.Bundle;
import android.text.Layout;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.common.util.h;
import com.obric.oui.dialog.anim.DialogAnimStyle;
import com.obric.oui.dialog.base.AbstractDialog;
import com.obric.oui.dialog.v2.alert.style.ButtonStyleController;
import com.obric.oui.dialog.v2.alert.style.d;
import com.obric.oui.dialog.v2.alert.style.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\u0019\u001a\u00020\u001aJ\b\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001c\u001a\u00020\u000bH\u0016J\b\u0010\u001d\u001a\u00020\u000bH\u0016J\b\u0010\u001e\u001a\u00020\u000bH\u0016J\n\u0010\u001f\u001a\u0004\u0018\u00010 H\u0014J\b\u0010!\u001a\u00020\u000bH\u0016J\b\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u0004\u0018\u00010%J\b\u0010&\u001a\u0004\u0018\u00010\u0016J\b\u0010'\u001a\u0004\u0018\u00010 J\b\u0010(\u001a\u0004\u0018\u00010 J\b\u0010)\u001a\u0004\u0018\u00010 J\b\u0010*\u001a\u0004\u0018\u00010%J\b\u0010+\u001a\u0004\u0018\u00010\u0016J\u0012\u0010,\u001a\u00020\u001a2\b\u0010-\u001a\u0004\u0018\u00010.H\u0014J\b\u0010/\u001a\u00020\u001aH\u0014J\u0006\u00100\u001a\u00020\u001aJ\b\u00101\u001a\u00020\u001aH\u0016J\b\u00102\u001a\u00020\u001aH\u0016J\u000e\u00103\u001a\u00020\u001a2\u0006\u00104\u001a\u00020\u000eJ\u000e\u00105\u001a\u00020\u001a2\u0006\u00104\u001a\u00020\u000eJ\u0018\u00106\u001a\u00020\u001a2\u0006\u00107\u001a\u00020%2\b\b\u0002\u00108\u001a\u00020\u0006J\u0010\u00109\u001a\u00020\u001a2\b\u0010:\u001a\u0004\u0018\u00010%J\u0010\u0010;\u001a\u00020\u001a2\b\u0010:\u001a\u0004\u0018\u00010%J\u000e\u0010<\u001a\u00020\u001a2\u0006\u00104\u001a\u00020\u000eJ\b\u0010=\u001a\u00020\u001aH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/obric/oui/dialog/v2/alert/OAlertDialog;", "Lcom/obric/oui/dialog/base/AbstractDialog;", "Lcom/obric/oui/dialog/v2/alert/style/DialogContainer;", "context", "Landroid/content/Context;", "withHeightMatchParent", "", "(Landroid/content/Context;Z)V", "TAG", "", "bannderPanel", "Landroid/widget/FrameLayout;", "bodyPanel", "bodyStyleController", "Lcom/obric/oui/dialog/v2/alert/style/StyleController;", "buttonPanel", "buttonStyleController", "headerPanel", "Landroid/view/ViewGroup;", "iconPanel", "messageMoreThanTwoLines", "messageTextView", "Landroid/widget/TextView;", "titleTextView", "topImageStyleController", "allowMoreThanTwoLinesMessage", "", "dismiss", "getBannerSlot", "getBodySlot", "getButtonSlot", "getHeightChangeAnimContainer", "Landroid/view/View;", "getIconSlot", "getLayout", "", "getMessageStr", "", "getMessageView", "getNegativeButton", "getNeutralButton", "getPositiveButton", "getTitleStr", "getTitleView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "originDismiss", "performEnterAnimation", "performExitAnimation", "setBodyStyleController", "controller", "setButtonStyleController", "setMessage", "message", "moreThanTwoLines", "setOnlyTitleText", "title", "setTitleText", "setTopImageStyleController", "show", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class a extends AbstractDialog implements d {
    private final String d;
    private final FrameLayout e;
    private final FrameLayout f;
    private g g;
    private TextView h;
    private TextView i;
    private final FrameLayout j;
    private g k;
    private final FrameLayout l;
    private final ViewGroup m;
    private g n;

    public a(Context r4, boolean r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, false, r5);
        this.d = "OAlertDialog";
        View r7 = findViewById(ZeusTransformUtils.mapRes(R.id.bannerPanel, OaidModel.KEY_ID, "bannerPanel"));
        Intrinsics.checkNotNullExpressionValue(r7, "findViewById(R.id.bannerPanel)");
        this.e = (FrameLayout) ZeusTransformUtils.preCheckCast(r7, FrameLayout.class, "com.obric.memorydata.plugin");
        View r8 = findViewById(ZeusTransformUtils.mapRes(R.id.iconPanel, OaidModel.KEY_ID, "iconPanel"));
        Intrinsics.checkNotNullExpressionValue(r8, "findViewById(R.id.iconPanel)");
        this.f = (FrameLayout) ZeusTransformUtils.preCheckCast(r8, FrameLayout.class, "com.obric.memorydata.plugin");
        View r9 = findViewById(ZeusTransformUtils.mapRes(R.id.header_container, OaidModel.KEY_ID, "header_container"));
        Intrinsics.checkNotNullExpressionValue(r9, "findViewById(R.id.header_container)");
        this.m = (ViewGroup) ZeusTransformUtils.preCheckCast(r9, ViewGroup.class, "com.obric.memorydata.plugin");
        TextView r10 = (TextView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.textTitle, OaidModel.KEY_ID, "textTitle")), TextView.class, "com.obric.memorydata.plugin");
        this.h = r10;
        if (r10 == null) goto L6;
        r10.setIncludeFontPadding(true);
    L6:
        TextView r11 = (TextView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.textSubTitle, OaidModel.KEY_ID, "textSubTitle")), TextView.class, "com.obric.memorydata.plugin");
        this.i = r11;
        if (r11 == null) goto L10;
        r11.setIncludeFontPadding(true);
    L10:
        View r12 = findViewById(ZeusTransformUtils.mapRes(R.id.button_container, OaidModel.KEY_ID, "button_container"));
        Intrinsics.checkNotNullExpressionValue(r12, "findViewById(R.id.button_container)");
        this.j = (FrameLayout) ZeusTransformUtils.preCheckCast(r12, FrameLayout.class, "com.obric.memorydata.plugin");
        View r13 = findViewById(ZeusTransformUtils.mapRes(R.id.body_container, OaidModel.KEY_ID, "body_container"));
        Intrinsics.checkNotNullExpressionValue(r13, "findViewById(R.id.body_container)");
        this.l = (FrameLayout) ZeusTransformUtils.preCheckCast(r13, FrameLayout.class, "com.obric.memorydata.plugin");
    }

    private static final void a(a r2) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        TextView r0 = r2.i;
        if (r0 == null) goto L9;
        Layout r1 = r0.getLayout();
        if (r1 == null) goto L9;
        r1.getLineCount();
    L9:
        TextView r3 = r2.i;
        if (r3 == null) goto L14;
        r3.getMaxLines();
        return;
    }

    public static /* synthetic */ void a(a r2, CharSequence r3, boolean r4, int r5, Object r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L10;
        if ((r5 & 2) == 0) goto L7;
        r4 = false;
    L7:
        r2.a(r7, r4);
        return;
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setMessage");
    }

    private static final void b(final a r10) {
        Intrinsics.checkNotNullParameter(r10, "this$0");
        DialogAnimStyle r1 = DialogAnimStyle.f13797a;
        View r2 = r10.j();
        Window r3 = r10.getWindow();
        boolean r4 = !r10.l();
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r0, "context");
        com.obric.oui.animation.easy.b r5 = DialogAnimStyle.a(r1, r2, r3, r4, r10.a(r0), false, 8, null).b();
        if (r10.k() == false) goto L5;
        r5.a((Function1) ZeusTransformUtils.preCheckCast(new OAlertDialog$performEnterAnimation$1$1(r10), Function1.class, "com.obric.memorydata.plugin"), (Function1) ZeusTransformUtils.preCheckCast(new OAlertDialog$performEnterAnimation$1$2(r10), Function1.class, "com.obric.memorydata.plugin"), (Function1) ZeusTransformUtils.preCheckCast(new OAlertDialog$performEnterAnimation$1$3(r10), Function1.class, "com.obric.memorydata.plugin"));
        return;
    L5:
        com.obric.oui.animation.easy.b.a(r5, null, (Function1) ZeusTransformUtils.preCheckCast(new OAlertDialog$performEnterAnimation$1$4(r10), Function1.class, "com.obric.memorydata.plugin"), (Function1) ZeusTransformUtils.preCheckCast(new OAlertDialog$performEnterAnimation$1$5(r10), Function1.class, "com.obric.memorydata.plugin"), 1, null);
    }

    public static /* synthetic */ void lambda$9wZUq2YpT_9_uqbBcdsoGvxfQZk(a r0) {
        b(r0);
    }

    public static /* synthetic */ void lambda$tbkQeUuQ4e8HY7Hs8KhLyjwSN3M(a r0) {
        a(r0);
    }

    @Override // com.obric.oui.dialog.base.AbstractDialog
    public int a() {
        return ZeusTransformUtils.mapRes(R.layout.o_alert_dialog_v2, "layout", "o_alert_dialog_v2");
    }

    public final void a(g r4) {
        g r5 = (g) ZeusTransformUtils.wrapperContextForParams(r4, g.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "controller");
        this.g = r5;
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r0, "context");
        r5.a(r0, (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.memorydata.plugin"));
    }

    public final void a(CharSequence r7) {
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.memorydata.plugin");
        boolean r0 = TextUtils.isEmpty(r8);
        TextView r2 = this.h;
        int r4 = 0;
        if (r2 == null) goto L9;
        if (r0 == false) goto L7;
        int r5 = 8;
    L8:
        r2.setVisibility(r5);
        r2.setText(r8);
        r2.setPadding(0, 0, 0, 0);
        goto L9
    L7:
        r5 = 0;
    L9:
        TextView r6 = this.i;
        if (r6 == null) goto L18;
        ViewGroup.LayoutParams r9 = r6.getLayoutParams();
        Objects.requireNonNull(r9, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r10 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r9, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        if (r0 == true) goto L16;
        r4 = h.a((View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.memorydata.plugin"), 8);
    L16:
        r10.topMargin = r4;
        return;
    }

    public final void a(CharSequence r2, boolean r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "message");
        TextView r5 = this.i;
        if (r5 == null) goto L6;
        r5.setVisibility(0);
        r5.setText(r4);
        com.obric.oui.dialog.b.a(r5, r4);
    L6:
        TextView r1 = this.i;
        if (r1 == null) goto L11;
        r1.setMaxLines(Integer.MAX_VALUE);
        return;
    }

    public final void b() {
        TextView r1 = this.i;
        if (r1 == null) goto L7;
        r1.setMaxLines(Integer.MAX_VALUE);
        return;
    }

    public final void b(g r4) {
        g r5 = (g) ZeusTransformUtils.wrapperContextForParams(r4, g.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "controller");
        this.k = r5;
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r0, "context");
        r5.a(r0, (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.memorydata.plugin"));
    }

    public final void b(CharSequence r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L10;
        TextView r4 = this.h;
        if (r4 == null) goto L11;
        r4.setVisibility(0);
        r4.setText(r6);
        r4.setPadding(0, h.a((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.memorydata.plugin"), 19), 0, h.a((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.memorydata.plugin"), 19));
        return;
    L11:
        return;
    }

    public void c() {
        com.obric.oui.animation.easy.b r0 = DialogAnimStyle.a(DialogAnimStyle.f13797a, j(), getWindow(), !l(), false, 4, null);
        com.obric.oui.animation.easy.b.a(r0, null, (Function1) ZeusTransformUtils.preCheckCast(new OAlertDialog$performExitAnimation$1$1(this), Function1.class, "com.obric.memorydata.plugin"), (Function1) ZeusTransformUtils.preCheckCast(new OAlertDialog$performExitAnimation$1$2(this), Function1.class, "com.obric.memorydata.plugin"), 1, null);
        r0.b();
    }

    public final void c(g r5) {
        g r6 = (g) ZeusTransformUtils.wrapperContextForParams(r5, g.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "controller");
        this.n = r6;
        FrameLayout r0 = this.l;
        if (i() == false) goto L5;
        ViewGroup.LayoutParams r2 = r0.getLayoutParams();
        r2.height = 0;
        r0.setLayoutParams(r2);
    L5:
        r0.setVisibility(0);
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r1, "context");
        r6.a(r1, (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.memorydata.plugin"));
    }

    public void d() {
        j().post(new $$Lambda$a$9wZUq2YpT_9_uqbBcdsoGvxfQZk(this));
    }

    @Override // com.obric.oui.dialog.base.AbstractDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        c();
    }

    public final void e() {
        super.dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Log.e("OAlertDialog", "origin Dismiss exception!", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public final TextView f() {
        return this.i;
    }

    public final View g() {
        com.obric.oui.c.c r0 = com.obric.oui.c.c.f13403a;
        g r3 = this.k;
        if (r3 != null) goto L6;
    L4:
        r3 = null;
    L7:
        ButtonStyleController r4 = (ButtonStyleController) ZeusTransformUtils.preCheckCast(r3, ButtonStyleController.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L11;
        return null;
    L11:
        return r4.a();
    L6:
        if (ZeusTransformUtils.instanceOf(r3, ButtonStyleController.class) == false) goto L4;
        goto L4
    }

    @Override // com.obric.oui.dialog.v2.alert.style.d
    public FrameLayout getBannerSlot() {
        return this.e;
    }

    @Override // com.obric.oui.dialog.v2.alert.style.d
    public FrameLayout getBodySlot() {
        return this.l;
    }

    @Override // com.obric.oui.dialog.v2.alert.style.d
    public FrameLayout getButtonSlot() {
        return this.j;
    }

    @Override // com.obric.oui.dialog.v2.alert.style.d
    public FrameLayout getIconSlot() {
        return this.f;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle r3) {
        if (k() == false) goto L5;
        j().setAlpha(0.0f);
    L5:
        super.onCreate(r3);
        g r4 = this.g;
        if (r4 == null) goto L9;
        r4.a((com.obric.oui.dialog.v2.alert.style.b) ZeusTransformUtils.preCheckCast(this, com.obric.oui.dialog.v2.alert.style.b.class, "com.obric.memorydata.plugin"));
    L9:
        g r5 = this.k;
        if (r5 == null) goto L13;
        r5.a((com.obric.oui.dialog.v2.alert.style.b) ZeusTransformUtils.preCheckCast(this, com.obric.oui.dialog.v2.alert.style.b.class, "com.obric.memorydata.plugin"));
    L13:
        g r6 = this.n;
        if (r6 == null) goto L18;
        r6.a((com.obric.oui.dialog.v2.alert.style.b) ZeusTransformUtils.preCheckCast(this, com.obric.oui.dialog.v2.alert.style.b.class, "com.obric.memorydata.plugin"));
        return;
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        d();
        TextView r0 = this.i;
        if (r0 == null) goto L7;
        r0.postDelayed(new $$Lambda$a$tbkQeUuQ4e8HY7Hs8KhLyjwSN3M(this), 1000);
        return;
    }

    @Override // com.obric.oui.dialog.base.AbstractDialog
    public View q() {
        return (View) ZeusTransformUtils.preCheckCast(this.m, View.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.oui.dialog.base.AbstractDialog, android.app.Dialog
    public void show() {
        super.show();
    }
}
