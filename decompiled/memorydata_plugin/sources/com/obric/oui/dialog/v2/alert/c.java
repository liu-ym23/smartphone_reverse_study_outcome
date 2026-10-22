package com.obric.oui.dialog.v2.alert;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.obric.memorydata.plugin.R;
import com.obric.oui.common.util.h;
import com.obric.oui.dialog.base.AbstractDialogModal;
import com.obric.oui.dialog.v2.alert.style.ButtonStyleController;
import com.obric.oui.dialog.v2.alert.style.d;
import com.obric.oui.dialog.v2.alert.style.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\u0019\u001a\u00020\u001aJ\b\u0010\u001b\u001a\u00020\tH\u0016J\b\u0010\u001c\u001a\u00020\tH\u0016J\b\u0010\u001d\u001a\u00020\tH\u0016J\b\u0010\u001e\u001a\u00020\tH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u0004\u0018\u00010\"J\b\u0010#\u001a\u0004\u0018\u00010\u0014J\b\u0010$\u001a\u0004\u0018\u00010%J\b\u0010&\u001a\u0004\u0018\u00010%J\b\u0010'\u001a\u0004\u0018\u00010%J\b\u0010(\u001a\u0004\u0018\u00010\"J\b\u0010)\u001a\u0004\u0018\u00010\u0014J\u000e\u0010*\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\fJ\u000e\u0010,\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\u000fJ\u000e\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\"J\u0010\u0010/\u001a\u00020\u001a2\b\u00100\u001a\u0004\u0018\u00010\"J\u0010\u00101\u001a\u00020\u001a2\b\u00100\u001a\u0004\u0018\u00010\"J\u000e\u00102\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\fJ\u0012\u00103\u001a\u00020\u001a2\b\u00104\u001a\u0004\u0018\u00010\u0011H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/obric/oui/dialog/v2/alert/OAlertDialogModal;", "Lcom/obric/oui/dialog/base/AbstractDialogModal;", "Lcom/obric/oui/dialog/v2/alert/style/DialogContainer;", "context", "Landroid/content/Context;", "withHeightMatchParent", "", "(Landroid/content/Context;Z)V", "bannderPanel", "Landroid/widget/FrameLayout;", "bodyPanel", "bodyStyleController", "Lcom/obric/oui/dialog/v2/alert/style/StyleController;", "buttonPanel", "buttonStyleController", "Lcom/obric/oui/dialog/v2/alert/style/ButtonStyleController;", "headerPanel", "Landroid/view/ViewGroup;", "iconPanel", "messageTextView", "Landroid/widget/TextView;", "tagName", "", "titleTextView", "topImageStyleController", "allowMoreThanTwoLinesMessage", "", "getBannerSlot", "getBodySlot", "getButtonSlot", "getIconSlot", "getLayout", "", "getMessageStr", "", "getMessageView", "getNegativeButton", "Landroid/view/View;", "getNeutralButton", "getPositiveButton", "getTitleStr", "getTitleView", "setBodyStyleController", "controller", "setButtonStyleController", "setMessage", "message", "setOnlyTitleText", "title", "setTitleText", "setTopImageStyleController", "show", "parent", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class c extends AbstractDialogModal implements d {
    private final FrameLayout e;
    private final FrameLayout f;
    private g g;
    private TextView h;
    private TextView i;
    private final FrameLayout j;
    private ButtonStyleController k;
    private final FrameLayout l;
    private g m;

    public final void f() {
        TextView r1 = this.i;
        if (r1 == null) goto L7;
        r1.setMaxLines(Integer.MAX_VALUE);
        return;
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

    @Override // com.obric.oui.dialog.base.AbstractDialogModal
    public int getLayout() {
        return ZeusTransformUtils.mapRes(R.layout.o_alert_dialog_v2, "layout", "o_alert_dialog_v2");
    }

    public final CharSequence getMessageStr() {
        TextView r0 = this.i;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.getText();
    }

    public final TextView getMessageView() {
        return this.i;
    }

    public final View getNegativeButton() {
        com.obric.oui.c.c r0 = com.obric.oui.c.c.f13403a;
        ButtonStyleController r1 = this.k;
        if (r1 != null) goto L5;
        r1 = null;
    L5:
        if (r1 != null) goto L8;
        return null;
    L8:
        return r1.b();
    }

    public final View getNeutralButton() {
        com.obric.oui.c.c r0 = com.obric.oui.c.c.f13403a;
        ButtonStyleController r1 = this.k;
        if (r1 != null) goto L5;
        r1 = null;
    L5:
        if (r1 != null) goto L8;
        return null;
    L8:
        return r1.c();
    }

    public final View getPositiveButton() {
        com.obric.oui.c.c r0 = com.obric.oui.c.c.f13403a;
        ButtonStyleController r1 = this.k;
        if (r1 != null) goto L5;
        r1 = null;
    L5:
        if (r1 != null) goto L8;
        return null;
    L8:
        return r1.a();
    }

    public final CharSequence getTitleStr() {
        TextView r0 = this.h;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.getText();
    }

    public final TextView getTitleView() {
        return this.h;
    }

    public final void setBodyStyleController(g r5) {
        g r6 = (g) ZeusTransformUtils.wrapperContextForParams(r5, g.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "controller");
        this.m = r6;
        FrameLayout r0 = this.l;
        if (getMatchParentHeight() == false) goto L5;
        ViewGroup.LayoutParams r2 = r0.getLayoutParams();
        r2.height = 0;
        r0.setLayoutParams(r2);
    L5:
        r0.setVisibility(0);
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r1, "context");
        r6.a(r1, (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.memorydata.plugin"));
    }

    public final void setButtonStyleController(ButtonStyleController r4) {
        Intrinsics.checkNotNullParameter(r4, "controller");
        this.k = r4;
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r0, "context");
        r4.a(r0, (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.memorydata.plugin"));
        r4.a((com.obric.oui.dialog.v2.alert.style.b) ZeusTransformUtils.preCheckCast(this, com.obric.oui.dialog.v2.alert.style.b.class, "com.obric.memorydata.plugin"));
    }

    public final void setMessage(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "message");
        TextView r0 = this.i;
        if (r0 == null) goto L6;
        r0.setVisibility(0);
        r0.setText(r4);
        com.obric.oui.dialog.b.a(r0, r4);
    L6:
        TextView r2 = this.i;
        if (r2 == null) goto L11;
        r2.setMaxLines(Integer.MAX_VALUE);
        return;
    }

    public final void setOnlyTitleText(CharSequence r7) {
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L10;
        TextView r6 = this.h;
        if (r6 == null) goto L11;
        r6.setVisibility(0);
        r6.setText(r8);
        Context r9 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r9, "tv.context");
        int r10 = h.a(r9, 19);
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r1, "tv.context");
        r6.setPadding(0, r10, 0, h.a(r1, 19));
        return;
    L11:
        return;
    }

    public final void setTitleText(CharSequence r7) {
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
        Context r11 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r11, "it.context");
        r4 = h.a(r11, 8);
    L16:
        r10.topMargin = r4;
        return;
    }

    public final void setTopImageStyleController(g r4) {
        g r5 = (g) ZeusTransformUtils.wrapperContextForParams(r4, g.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "controller");
        this.g = r5;
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r0, "context");
        r5.a(r0, (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.memorydata.plugin"));
    }
}
