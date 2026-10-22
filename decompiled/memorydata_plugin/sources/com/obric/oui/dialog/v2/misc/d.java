package com.obric.oui.dialog.v2.misc;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.obric.memorydata.plugin.R;
import com.obric.oui.button.OButton;
import com.obric.oui.common.util.h;
import com.obric.oui.progress.ODownloadProgressView;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001+B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020%H\u0002J\u000e\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020(J\u000e\u0010)\u001a\u00020%2\u0006\u0010*\u001a\u00020(R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0012\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0013\u0010\u0010R\u001b\u0010\u0015\u001a\u00020\u00168FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\f\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\f\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001f\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\f\u001a\u0004\b \u0010\u001d¨\u0006,"}, d2 = {"Lcom/obric/oui/dialog/v2/misc/StatusDialogModal;", "Lcom/obric/oui/dialog/base/OBaseDialogModal;", "context", "Landroid/content/Context;", "modifier", "Lcom/obric/oui/dialog/v2/misc/StatusDialogModal$Modifier;", "(Landroid/content/Context;Lcom/obric/oui/dialog/v2/misc/StatusDialogModal$Modifier;)V", "buttonContainerView", "Landroid/view/View;", "getButtonContainerView", "()Landroid/view/View;", "buttonContainerView$delegate", "Lkotlin/Lazy;", "negativeButton", "Lcom/obric/oui/button/OButton;", "getNegativeButton", "()Lcom/obric/oui/button/OButton;", "negativeButton$delegate", "positiveButton", "getPositiveButton", "positiveButton$delegate", "processView", "Lcom/obric/oui/progress/ODownloadProgressView;", "getProcessView", "()Lcom/obric/oui/progress/ODownloadProgressView;", "processView$delegate", "subtitleTextView", "Lcom/obric/oui/text/OTextView;", "getSubtitleTextView", "()Lcom/obric/oui/text/OTextView;", "subtitleTextView$delegate", "titleTextView", "getTitleTextView", "titleTextView$delegate", "getLayout", "", "initButtons", "", "setSubtitleText", "message", "", "setTitleText", "title", "Modifier", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class d extends com.obric.oui.dialog.base.c {
    private final Lazy e;
    private final Lazy f;
    private final Lazy g;
    private final Lazy h;
    private final Lazy i;
    private final Lazy j;

    private final View getButtonContainerView() {
        Object r2 = this.h.getValue();
        Intrinsics.checkNotNullExpressionValue(r2, "<get-buttonContainerView>(...)");
        return (View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.memorydata.plugin");
    }

    private final OButton getNegativeButton() {
        Object r2 = this.i.getValue();
        Intrinsics.checkNotNullExpressionValue(r2, "<get-negativeButton>(...)");
        return (OButton) ZeusTransformUtils.preCheckCast(r2, OButton.class, "com.obric.memorydata.plugin");
    }

    private final OButton getPositiveButton() {
        Object r2 = this.j.getValue();
        Intrinsics.checkNotNullExpressionValue(r2, "<get-positiveButton>(...)");
        return (OButton) ZeusTransformUtils.preCheckCast(r2, OButton.class, "com.obric.memorydata.plugin");
    }

    private final OTextView getSubtitleTextView() {
        Object r2 = this.g.getValue();
        Intrinsics.checkNotNullExpressionValue(r2, "<get-subtitleTextView>(...)");
        return (OTextView) ZeusTransformUtils.preCheckCast(r2, OTextView.class, "com.obric.memorydata.plugin");
    }

    private final OTextView getTitleTextView() {
        Object r2 = this.f.getValue();
        Intrinsics.checkNotNullExpressionValue(r2, "<get-titleTextView>(...)");
        return (OTextView) ZeusTransformUtils.preCheckCast(r2, OTextView.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.oui.dialog.base.AbstractDialogModal
    public int getLayout() {
        return ZeusTransformUtils.mapRes(R.layout.o_status_dialog, "layout", "o_status_dialog");
    }

    public final ODownloadProgressView getProcessView() {
        Object r2 = this.e.getValue();
        Intrinsics.checkNotNullExpressionValue(r2, "<get-processView>(...)");
        return (ODownloadProgressView) ZeusTransformUtils.preCheckCast(r2, ODownloadProgressView.class, "com.obric.memorydata.plugin");
    }

    public final void setSubtitleText(String r4) {
        Intrinsics.checkNotNullParameter(r4, "message");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        OTextView r3 = getSubtitleTextView();
        if (r0 == false) goto L9;
        r3.setVisibility(8);
        return;
    L9:
        r3.setVisibility(0);
        r3.setText((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"));
        com.obric.oui.dialog.b.a((TextView) ZeusTransformUtils.preCheckCast(r3, TextView.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"));
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void setTitleText(String r6) {
        Intrinsics.checkNotNullParameter(r6, "title");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
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
        r1.setText((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin"));
        OTextView r7 = getSubtitleTextView();
        ViewGroup.LayoutParams r8 = r7.getLayoutParams();
        Objects.requireNonNull(r8, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r8, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin")).topMargin = h.a((View) ZeusTransformUtils.preCheckCast(r7, View.class, "com.obric.memorydata.plugin"), 8);
        return;
    L5:
        r0 = false;
        goto L7
    }
}
