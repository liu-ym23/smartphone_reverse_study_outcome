package com.obric.oui.searchbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.plugin.R;
import com.obric.oui.a.a;
import com.obric.oui.button.OButton;
import com.obric.oui.common.util.o;
import com.obric.oui.forms.OInputView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013J\u0006\u0010\u0015\u001a\u00020\u0016J0\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001cH\u0014J\u0018\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\u001cH\u0014J\u0012\u0010#\u001a\u0004\u0018\u00010\u00112\u0006\u0010$\u001a\u00020\u001cH\u0002J\u0010\u0010%\u001a\u00020\u00182\b\u0010&\u001a\u0004\u0018\u00010\u0011J\u0010\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\u001aH\u0016J\u000e\u0010)\u001a\u00020\u00182\u0006\u0010*\u001a\u00020+J\u000e\u0010,\u001a\u00020\u00182\u0006\u0010-\u001a\u00020.J\u000e\u0010/\u001a\u00020\u00182\u0006\u00100\u001a\u00020\u0016J\u000e\u00101\u001a\u00020\u00182\u0006\u00102\u001a\u00020\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/obric/oui/searchbar/OSearchBar;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "originContext", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "inputView", "Lcom/obric/oui/forms/OInputView;", "getInputView", "()Lcom/obric/oui/forms/OInputView;", "leftContainer", "Landroid/widget/FrameLayout;", "rightContainer", "searchAction", "Lcom/obric/oui/button/OButton;", "getEllipsize", "Landroid/text/TextUtils$TruncateAt;", "getPostfixView", "Landroid/view/View;", "getPrefixView", "getText", "", "onLayout", "", "changed", "", "left", "", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "parseEllipsize", EventBody.KEY_VALUE, "setEllipsize", "where", "setEnabled", "enabled", "setOnInputFocusChange", "onFocusChangeListener", "Landroid/view/View$OnFocusChangeListener;", "setSearchAction", "click", "Landroid/view/View$OnClickListener;", "setSearchActionText", "searchActionText", "setText", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OSearchBar extends ConstraintLayout {
    private final OInputView inputView;
    private final FrameLayout leftContainer;
    private FrameLayout rightContainer;
    private final OButton searchAction;

    /* JADX WARN: Multi-variable type inference failed */
    public OSearchBar(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "originContext");
        this(r4, null, 2, 0 == true ? 1 : 0);
    }

    public OSearchBar(Context r8, AttributeSet r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r11 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r9, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "originContext");
        super(r10, r11);
        ConstraintLayout.inflate((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.layout.o_widget_search_bar, "layout", "o_widget_search_bar"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin"));
        View r12 = findViewById(ZeusTransformUtils.mapRes(R.id.input_view, OaidModel.KEY_ID, "input_view"));
        Intrinsics.checkNotNullExpressionValue(r12, "findViewById(R.id.input_view)");
        this.inputView = (OInputView) ZeusTransformUtils.preCheckCast(r12, OInputView.class, "com.obric.memorydata.plugin");
        View r13 = findViewById(ZeusTransformUtils.mapRes(R.id.o_input_left_view_container, OaidModel.KEY_ID, "o_input_left_view_container"));
        Intrinsics.checkNotNullExpressionValue(r13, "findViewById(R.id.o_input_left_view_container)");
        FrameLayout r14 = (FrameLayout) ZeusTransformUtils.preCheckCast(r13, FrameLayout.class, "com.obric.memorydata.plugin");
        this.leftContainer = r14;
        View r0 = findViewById(ZeusTransformUtils.mapRes(R.id.search_action, OaidModel.KEY_ID, "search_action"));
        Intrinsics.checkNotNullExpressionValue(r0, "findViewById(R.id.search_action)");
        this.searchAction = (OButton) ZeusTransformUtils.preCheckCast(r0, OButton.class, "com.obric.memorydata.plugin");
        TypedArray r15 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getTheme().obtainStyledAttributes(r11, R.styleable.OSearchBar, 0, 0);
        getInputView().setHint(r15.getString(ZeusTransformUtils.mapRes(R.styleable.OSearchBar_android_hint, "styleable", "OSearchBar_android_hint")));
        getInputView().setText(r15.getString(ZeusTransformUtils.mapRes(R.styleable.OSearchBar_android_text, "styleable", "OSearchBar_android_text")));
        if (r15.hasValue(ZeusTransformUtils.mapRes(R.styleable.OSearchBar_android_ellipsize, "styleable", "OSearchBar_android_ellipsize")) == false) goto L5;
        setEllipsize(parseEllipsize(r15.getInt(ZeusTransformUtils.mapRes(R.styleable.OSearchBar_android_ellipsize, "styleable", "OSearchBar_android_ellipsize"), 0)));
    L5:
        final int r1 = r15.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OSearchBar_oui_search_postfixView, "styleable", "OSearchBar_oui_search_postfixView"), 0);
        if (r1 == 0) goto L8;
        getInputView().setActionView((Function1) ZeusTransformUtils.preCheckCast(new OSearchBar$1$1(this, r1), Function1.class, "com.obric.memorydata.plugin"));
    L8:
        if (r1 != 0) goto L12;
        int r2 = r15.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OSearchBar_oui_search_prefixView, "styleable", "OSearchBar_oui_search_prefixView"), ZeusTransformUtils.mapRes(R.layout.o_widget_search_bar_prefix, "layout", "o_widget_search_bar_prefix"));
        if (r2 == 0) goto L12;
        ConstraintLayout.inflate((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r2, (ViewGroup) ZeusTransformUtils.preCheckCast(r14, ViewGroup.class, "com.obric.memorydata.plugin"));
        o.a((View) ZeusTransformUtils.preCheckCast(r14, View.class, "com.obric.memorydata.plugin"));
    L12:
        String r16 = r15.getString(ZeusTransformUtils.mapRes(R.styleable.OSearchBar_oui_search_actionText, "styleable", "OSearchBar_oui_search_actionText"));
        if (r16 != null) goto L15;
        r16 = "";
    L15:
        setSearchActionText(r16);
    }

    public /* synthetic */ OSearchBar(Context r2, AttributeSet r3, int r4, DefaultConstructorMarker r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    public static final /* synthetic */ void access$setRightContainer$p(OSearchBar r0, FrameLayout r1) {
        r0.rightContainer = r1;
    }

    public static /* synthetic */ void lambda$QwWqvxD7L570O7PgR1eeIz7Xeic(OSearchBar r0, View.OnClickListener r1, View r2) {
        m1355setSearchAction$lambda1(r0, r1, r2);
    }

    private final TextUtils.TruncateAt parseEllipsize(int r1) {
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L19;
        if (r1 == 3) goto L18;
        if (r1 == 4) goto L17;
        return null;
    L17:
        return TextUtils.TruncateAt.MARQUEE;
    L18:
        return TextUtils.TruncateAt.END;
    L19:
        return TextUtils.TruncateAt.MIDDLE;
    L15:
        return TextUtils.TruncateAt.START;
    }

    /* JADX INFO: renamed from: setSearchAction$lambda-1, reason: not valid java name */
    private static final void m1355setSearchAction$lambda1(OSearchBar r2, View.OnClickListener r3, View r4) {
        View.OnClickListener r5 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intrinsics.checkNotNullParameter(r5, "$click");
        a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), 1);
        r5.onClick(r4);
    }

    public final TextUtils.TruncateAt getEllipsize() {
        return this.inputView.getEllipsize();
    }

    public final OInputView getInputView() {
        return this.inputView;
    }

    public final View getPostfixView() {
        FrameLayout r2 = this.rightContainer;
        if (r2 != null) goto L6;
        return null;
    L6:
        if (r2.getChildCount() > 0) goto L8;
        return null;
    L8:
        return r2.getChildAt(0);
    }

    public final View getPrefixView() {
        if (this.leftContainer.getChildCount() > 0) goto L7;
        return null;
    L7:
        return this.leftContainer.getChildAt(0);
    }

    public final String getText() {
        String r0 = this.inputView.getText();
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    public final void setEllipsize(TextUtils.TruncateAt r1) {
        this.inputView.setEllipsize(r1);
    }

    @Override // android.view.View
    public void setEnabled(boolean r2) {
        this.inputView.setEnabled(r2);
        super.setEnabled(r2);
    }

    public final void setOnInputFocusChange(View.OnFocusChangeListener r3) {
        View.OnFocusChangeListener r4 = (View.OnFocusChangeListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnFocusChangeListener.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "onFocusChangeListener");
        this.inputView.setOnFocusChangeListener(r4);
    }

    public final void setSearchAction(View.OnClickListener r3) {
        final View.OnClickListener r4 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "click");
        this.searchAction.setOnClickListener(new $$Lambda$OSearchBar$QwWqvxD7L570O7PgR1eeIz7Xeic(this, r4));
    }

    public final void setSearchActionText(String r4) {
        Intrinsics.checkNotNullParameter(r4, "searchActionText");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        o.b((View) ZeusTransformUtils.preCheckCast(this.searchAction, View.class, "com.obric.memorydata.plugin"));
        return;
    L8:
        this.searchAction.setText((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"));
        o.a((View) ZeusTransformUtils.preCheckCast(this.searchAction, View.class, "com.obric.memorydata.plugin"));
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void setText(String r2) {
        Intrinsics.checkNotNullParameter(r2, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        this.inputView.setText(r2);
    }
}
