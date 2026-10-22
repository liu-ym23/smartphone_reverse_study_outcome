package com.obric.oui.dialog.v2.misc;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.obric.memorydata.plugin.R;
import com.obric.oui.button.OButton;
import com.obric.oui.common.util.h;
import com.obric.oui.forms.OInputLayout;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u0000 >2\u00020\u0001:\u0003>?@B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u00101\u001a\u000202H\u0016J\b\u00103\u001a\u000204H\u0002J\b\u00105\u001a\u000204H\u0002J\u000e\u00106\u001a\u0002042\u0006\u00107\u001a\u000208J\u000e\u00109\u001a\u0002042\u0006\u0010:\u001a\u000208J\u0012\u0010;\u001a\u0002042\b\u0010<\u001a\u0004\u0018\u00010=H\u0016R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\b8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u000e\u0010\nR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0016\u001a\u00020\b8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\f\u001a\u0004\b\u0017\u0010\nR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001b\u0010\u001c\u001a\u00020\b8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\f\u001a\u0004\b\u001d\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001b\u0010!\u001a\u00020\"8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\f\u001a\u0004\b#\u0010$R\u001b\u0010&\u001a\u00020\"8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\f\u001a\u0004\b'\u0010$R\u001b\u0010)\u001a\u00020*8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\f\u001a\u0004\b+\u0010,R\u001b\u0010.\u001a\u00020*8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\f\u001a\u0004\b/\u0010,¨\u0006A"}, d2 = {"Lcom/obric/oui/dialog/v2/misc/OSimpleFormDialogModal;", "Lcom/obric/oui/dialog/base/OBaseDialogModal;", "context", "Landroid/content/Context;", "modifier", "Lcom/obric/oui/dialog/v2/misc/OSimpleFormDialogModal$Modifier;", "(Landroid/content/Context;Lcom/obric/oui/dialog/v2/misc/OSimpleFormDialogModal$Modifier;)V", "bodyContainer", "Landroid/widget/FrameLayout;", "getBodyContainer", "()Landroid/widget/FrameLayout;", "bodyContainer$delegate", "Lkotlin/Lazy;", "footerContainer", "getFooterContainer", "footerContainer$delegate", "inputView1", "Lcom/obric/oui/forms/OInputLayout;", "getInputView1", "()Lcom/obric/oui/forms/OInputLayout;", "setInputView1", "(Lcom/obric/oui/forms/OInputLayout;)V", "inputView1Container", "getInputView1Container", "inputView1Container$delegate", "inputView2", "getInputView2", "setInputView2", "inputView2Container", "getInputView2Container", "inputView2Container$delegate", "getModifier", "()Lcom/obric/oui/dialog/v2/misc/OSimpleFormDialogModal$Modifier;", "negativeButton", "Lcom/obric/oui/button/OButton;", "getNegativeButton", "()Lcom/obric/oui/button/OButton;", "negativeButton$delegate", "positiveButton", "getPositiveButton", "positiveButton$delegate", "subtitleTextView", "Lcom/obric/oui/text/OTextView;", "getSubtitleTextView", "()Lcom/obric/oui/text/OTextView;", "subtitleTextView$delegate", "titleTextView", "getTitleTextView", "titleTextView$delegate", "getLayout", "", "initButtons", "", "initInputViews", "setSubtitleText", "message", "", "setTitleText", "title", "show", "parent", "Landroid/view/ViewGroup;", "Companion", "InputViewConfig", "Modifier", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class b extends com.obric.oui.dialog.base.c {
    public static final a e = null;
    private final C0750b f;
    private final Lazy g;
    private final Lazy h;
    private final Lazy i;
    private final Lazy j;
    private final Lazy k;
    private final Lazy l;
    private final Lazy m;
    private final Lazy n;
    private OInputLayout o;
    private OInputLayout p;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/dialog/v2/misc/OSimpleFormDialogModal$Companion;", "", "()V", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.dialog.v2.misc.b$b, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/obric/oui/dialog/v2/misc/OSimpleFormDialogModal$Modifier;", "", "title", "", "subtitle", "inputView1", "Lcom/obric/oui/dialog/v2/misc/OSimpleFormDialogModal$InputViewConfig;", "inputView2", "positiveButton", "Lcom/obric/oui/dialog/base/OBaseDialogModal$ButtonConfig;", "negativeButton", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Lcom/obric/oui/dialog/v2/misc/OSimpleFormDialogModal$InputViewConfig;Lcom/obric/oui/dialog/v2/misc/OSimpleFormDialogModal$InputViewConfig;Lcom/obric/oui/dialog/base/OBaseDialogModal$ButtonConfig;Lcom/obric/oui/dialog/base/OBaseDialogModal$ButtonConfig;)V", "getInputView1", "()Lcom/obric/oui/dialog/v2/misc/OSimpleFormDialogModal$InputViewConfig;", "getInputView2", "getNegativeButton", "()Lcom/obric/oui/dialog/base/OBaseDialogModal$ButtonConfig;", "getPositiveButton", "getSubtitle", "()Ljava/lang/CharSequence;", "getTitle", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class C0750b {
    }

    static {
        e = new a(null);
    }

    private final FrameLayout getBodyContainer() {
        Object r2 = this.k.getValue();
        Intrinsics.checkNotNullExpressionValue(r2, "<get-bodyContainer>(...)");
        return (FrameLayout) ZeusTransformUtils.preCheckCast(r2, FrameLayout.class, "com.obric.memorydata.plugin");
    }

    public final FrameLayout getFooterContainer() {
        Object r2 = this.l.getValue();
        Intrinsics.checkNotNullExpressionValue(r2, "<get-footerContainer>(...)");
        return (FrameLayout) ZeusTransformUtils.preCheckCast(r2, FrameLayout.class, "com.obric.memorydata.plugin");
    }

    public final OInputLayout getInputView1() {
        return this.o;
    }

    public final FrameLayout getInputView1Container() {
        Object r2 = this.m.getValue();
        Intrinsics.checkNotNullExpressionValue(r2, "<get-inputView1Container>(...)");
        return (FrameLayout) ZeusTransformUtils.preCheckCast(r2, FrameLayout.class, "com.obric.memorydata.plugin");
    }

    public final OInputLayout getInputView2() {
        return this.p;
    }

    public final FrameLayout getInputView2Container() {
        Object r2 = this.n.getValue();
        Intrinsics.checkNotNullExpressionValue(r2, "<get-inputView2Container>(...)");
        return (FrameLayout) ZeusTransformUtils.preCheckCast(r2, FrameLayout.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.oui.dialog.base.AbstractDialogModal
    public int getLayout() {
        return ZeusTransformUtils.mapRes(R.layout.o_simple_form_dialog, "layout", "o_simple_form_dialog");
    }

    public final C0750b getModifier() {
        return this.f;
    }

    public final OButton getNegativeButton() {
        Object r2 = this.i.getValue();
        Intrinsics.checkNotNullExpressionValue(r2, "<get-negativeButton>(...)");
        return (OButton) ZeusTransformUtils.preCheckCast(r2, OButton.class, "com.obric.memorydata.plugin");
    }

    public final OButton getPositiveButton() {
        Object r2 = this.j.getValue();
        Intrinsics.checkNotNullExpressionValue(r2, "<get-positiveButton>(...)");
        return (OButton) ZeusTransformUtils.preCheckCast(r2, OButton.class, "com.obric.memorydata.plugin");
    }

    public final OTextView getSubtitleTextView() {
        Object r2 = this.h.getValue();
        Intrinsics.checkNotNullExpressionValue(r2, "<get-subtitleTextView>(...)");
        return (OTextView) ZeusTransformUtils.preCheckCast(r2, OTextView.class, "com.obric.memorydata.plugin");
    }

    public final OTextView getTitleTextView() {
        Object r2 = this.g.getValue();
        Intrinsics.checkNotNullExpressionValue(r2, "<get-titleTextView>(...)");
        return (OTextView) ZeusTransformUtils.preCheckCast(r2, OTextView.class, "com.obric.memorydata.plugin");
    }

    public final void setInputView1(OInputLayout r1) {
        this.o = r1;
    }

    public final void setInputView2(OInputLayout r1) {
        this.p = r1;
    }

    public final void setSubtitleText(CharSequence r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "message");
        if (r5.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        OTextView r3 = getSubtitleTextView();
        if (r0 == false) goto L9;
        r3.setVisibility(8);
        return;
    L9:
        r3.setVisibility(0);
        r3.setText(r5);
        com.obric.oui.dialog.b.a((TextView) ZeusTransformUtils.preCheckCast(r3, TextView.class, "com.obric.memorydata.plugin"), r5);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void setTitleText(CharSequence r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r6, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "title");
        if (r7.length() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L9;
        getTitleTextView().setVisibility(8);
        ViewGroup.LayoutParams r5 = getSubtitleTextView().getLayoutParams();
        Objects.requireNonNull(r5, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r5, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin")).topMargin = 0;
        return;
    L9:
        OTextView r1 = getTitleTextView();
        r1.setVisibility(0);
        r1.setText(r7);
        OTextView r8 = getSubtitleTextView();
        ViewGroup.LayoutParams r9 = r8.getLayoutParams();
        Objects.requireNonNull(r9, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r9, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin")).topMargin = h.a((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.memorydata.plugin"), 8);
        return;
    L5:
        r0 = false;
        goto L7
    }
}
