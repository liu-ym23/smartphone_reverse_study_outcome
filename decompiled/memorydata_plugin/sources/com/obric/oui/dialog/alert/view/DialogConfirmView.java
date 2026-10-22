package com.obric.oui.dialog.alert.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.checkbox.OCheckBox;
import com.obric.oui.common.util.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated(message = "only for o demo")
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0010\u001a\u00020\bJ\u0006\u0010\u0011\u001a\u00020\u000eJ\u0006\u0010\u0012\u001a\u00020\u000eJ\b\u0010\u0013\u001a\u00020\u0014H\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/oui/dialog/alert/view/DialogConfirmView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "checkBox", "Lcom/obric/oui/checkbox/OCheckBox;", "clickContainer", "Landroid/view/ViewGroup;", "linkContainer", "Landroid/widget/RelativeLayout;", "tvLink", "Landroid/widget/TextView;", "tvNormal", "getCheckBox", "getLinkTextView", "getNormalTextView", "onAttachedToWindow", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DialogConfirmView extends ConstraintLayout {
    private final OCheckBox checkBox;
    private final ViewGroup clickContainer;
    private final RelativeLayout linkContainer;
    private final TextView tvLink;
    private final TextView tvNormal;

    /* JADX WARN: Multi-variable type inference failed */
    public DialogConfirmView(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        this(r4, null, 2, 0 == true ? 1 : 0);
    }

    public DialogConfirmView(Context r4, AttributeSet r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7);
        ConstraintLayout.inflate(r6, ZeusTransformUtils.mapRes(R.layout.o_layout_dialog_options, "layout", "o_layout_dialog_options"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin"));
        int r8 = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 5);
        setPadding(r8, r8, r8, 0);
        View r9 = findViewById(ZeusTransformUtils.mapRes(R.id.radio, OaidModel.KEY_ID, "radio"));
        Intrinsics.checkNotNullExpressionValue(r9, "findViewById(R.id.radio)");
        this.checkBox = (OCheckBox) ZeusTransformUtils.preCheckCast(r9, OCheckBox.class, "com.obric.memorydata.plugin");
        View r10 = findViewById(ZeusTransformUtils.mapRes(R.id.tv_normal, OaidModel.KEY_ID, "tv_normal"));
        Intrinsics.checkNotNullExpressionValue(r10, "findViewById(R.id.tv_normal)");
        this.tvNormal = (TextView) ZeusTransformUtils.preCheckCast(r10, TextView.class, "com.obric.memorydata.plugin");
        View r11 = findViewById(ZeusTransformUtils.mapRes(R.id.tv_link, OaidModel.KEY_ID, "tv_link"));
        Intrinsics.checkNotNullExpressionValue(r11, "findViewById(R.id.tv_link)");
        this.tvLink = (TextView) ZeusTransformUtils.preCheckCast(r11, TextView.class, "com.obric.memorydata.plugin");
        View r12 = findViewById(ZeusTransformUtils.mapRes(R.id.link_text_container, OaidModel.KEY_ID, "link_text_container"));
        Intrinsics.checkNotNullExpressionValue(r12, "findViewById(R.id.link_text_container)");
        this.linkContainer = (RelativeLayout) ZeusTransformUtils.preCheckCast(r12, RelativeLayout.class, "com.obric.memorydata.plugin");
        View r13 = findViewById(ZeusTransformUtils.mapRes(R.id.click_container, OaidModel.KEY_ID, "click_container"));
        Intrinsics.checkNotNullExpressionValue(r13, "findViewById(R.id.click_container)");
        this.clickContainer = (ViewGroup) ZeusTransformUtils.preCheckCast(r13, ViewGroup.class, "com.obric.memorydata.plugin");
    }

    public /* synthetic */ DialogConfirmView(Context r2, AttributeSet r3, int r4, DefaultConstructorMarker r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    /* JADX INFO: renamed from: lambda$BsXn_ZPWI6NkLD3Z4h-ZTakIuCE, reason: not valid java name */
    public static /* synthetic */ void m1280lambda$BsXn_ZPWI6NkLD3Z4hZTakIuCE(DialogConfirmView r0, View r1) {
        m1282onAttachedToWindow$lambda1(r0, r1);
    }

    public static /* synthetic */ void lambda$SGfCbP9WVzDAKBw06y1vY_H4cMs(DialogConfirmView r0, View r1) {
        m1281onAttachedToWindow$lambda0(r0, r1);
    }

    /* JADX INFO: renamed from: onAttachedToWindow$lambda-0, reason: not valid java name */
    private static final void m1281onAttachedToWindow$lambda0(DialogConfirmView r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.tvLink.performClick();
    }

    /* JADX INFO: renamed from: onAttachedToWindow$lambda-1, reason: not valid java name */
    private static final void m1282onAttachedToWindow$lambda1(DialogConfirmView r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.getCheckBox().performClick();
    }

    public final OCheckBox getCheckBox() {
        return this.checkBox;
    }

    public final TextView getLinkTextView() {
        return this.tvLink;
    }

    public final TextView getNormalTextView() {
        return this.tvNormal;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getParent() != null) goto L5;
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(getParent(), ViewGroup.class) == false) goto L9;
        ViewParent r0 = getParent();
        Objects.requireNonNull(r0, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup r1 = (ViewGroup) ZeusTransformUtils.preCheckCast(r0, ViewGroup.class, "com.obric.memorydata.plugin");
        this.linkContainer.setPadding(0, r1.getPaddingTop(), 0, r1.getPaddingBottom());
        this.linkContainer.setOnClickListener(new $$Lambda$DialogConfirmView$SGfCbP9WVzDAKBw06y1vY_H4cMs(this));
        r1.setPadding(r1.getPaddingLeft(), 0, r1.getPaddingRight(), 0);
        this.clickContainer.setOnClickListener(new $$Lambda$DialogConfirmView$BsXn_ZPWI6NkLD3Z4hZTakIuCE(this));
        return;
    }
}
