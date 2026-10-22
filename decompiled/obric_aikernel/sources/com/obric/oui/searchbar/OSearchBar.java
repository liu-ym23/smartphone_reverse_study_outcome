package com.obric.oui.searchbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.obric.oui.button.OButton;
import com.obric.oui.common.util.k;
import com.obric.oui.forms.OInputView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import u8.f;
import u8.h;
import u8.l;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010,\u001a\u00020+\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-¢\u0006\u0004\b/\u00100J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fJ\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\b\u0010\u0014\u001a\u0004\u0018\u00010\u0012J\u0018\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0014J0\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0015H\u0014R\u0016\u0010 \u001a\u00020\u001f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010!R\u0016\u0010$\u001a\u00020#8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0019\u0010'\u001a\u00020&8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*¨\u00061"}, d2 = {"Lcom/obric/oui/searchbar/OSearchBar;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "enabled", "", "setEnabled", "", "text", "setText", "getText", "searchActionText", "setSearchActionText", "Landroid/view/View$OnClickListener;", "click", "setSearchAction", "Landroid/view/View$OnFocusChangeListener;", "onFocusChangeListener", "setOnInputFocusChange", "Landroid/view/View;", "getPrefixView", "getPostfixView", "", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "changed", "left", "top", "right", "bottom", "onLayout", "Landroid/widget/FrameLayout;", "leftContainer", "Landroid/widget/FrameLayout;", "rightContainer", "Lcom/obric/oui/button/OButton;", "searchAction", "Lcom/obric/oui/button/OButton;", "Lcom/obric/oui/forms/OInputView;", "inputView", "Lcom/obric/oui/forms/OInputView;", "getInputView", "()Lcom/obric/oui/forms/OInputView;", "Landroid/content/Context;", "originContext", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public class OSearchBar extends ConstraintLayout {
    private final OInputView inputView;
    private final FrameLayout leftContainer;
    private FrameLayout rightContainer;
    private final OButton searchAction;

    static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OSearchBar f7222c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ View.OnClickListener f7223g;

        a(OSearchBar r10, View.OnClickListener r11) {
            this.f7222c = r10;
            this.f7223g = r11;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            q9.a.b(this.f7222c.getContext(), 1);
            this.f7223g.onClick(r10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public OSearchBar(Context r10) {
        this(r10, null, 2, 0 == true ? 1 : 0);
    }

    @JvmOverloads
    public OSearchBar(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "originContext");
        super(r10, r11);
        ViewGroup.inflate(getContext(), h.o_widget_search_bar, this);
        View r12 = findViewById(f.input_view);
        Intrinsics.checkNotNullExpressionValue(r12, "findViewById(R.id.input_view)");
        OInputView r13 = (OInputView) r12;
        this.inputView = r13;
        View r14 = findViewById(f.o_input_left_view_container);
        Intrinsics.checkNotNullExpressionValue(r14, "findViewById(R.id.o_input_left_view_container)");
        FrameLayout r15 = (FrameLayout) r14;
        this.leftContainer = r15;
        View r16 = findViewById(f.search_action);
        Intrinsics.checkNotNullExpressionValue(r16, "findViewById(R.id.search_action)");
        this.searchAction = (OButton) r16;
        Context r17 = getContext();
        Intrinsics.checkNotNullExpressionValue(r17, "context");
        TypedArray r18 = r17.getTheme().obtainStyledAttributes(r11, l.OSearchBar, 0, 0);
        r13.setHint(r18.getString(l.OSearchBar_android_hint));
        r13.setText(r18.getString(l.OSearchBar_android_text));
        final int r19 = r18.getResourceId(l.OSearchBar_oui_search_postfixView, 0);
        if (r19 == 0) goto L5;
        r13.setActionView(new OSearchBar$$special$$inlined$apply$lambda$1(r19, this));
    L5:
        if (r19 != 0) goto L9;
        int r20 = r18.getResourceId(l.OSearchBar_oui_search_prefixView, h.o_widget_search_bar_prefix);
        if (r20 == 0) goto L9;
        ViewGroup.inflate(getContext(), r20, r15);
        k.h(r15);
    L9:
        String r21 = r18.getString(l.OSearchBar_oui_search_actionText);
        if (r21 != null) goto L13;
        r21 = "";
    L13:
        Intrinsics.checkNotNullExpressionValue(r21, "getString(R.styleable.OS…_search_actionText) ?: \"\"");
        setSearchActionText(r21);
    }

    public /* synthetic */ OSearchBar(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    public static final /* synthetic */ FrameLayout access$getRightContainer$p(OSearchBar r10) {
        return r10.rightContainer;
    }

    public static final /* synthetic */ void access$setRightContainer$p(OSearchBar r10, FrameLayout r11) {
        r10.rightContainer = r11;
    }

    public final OInputView getInputView() {
        return this.inputView;
    }

    public final View getPostfixView() {
        FrameLayout r10 = this.rightContainer;
        if (r10 != null) goto L5;
        return null;
    L5:
        if (r10.getChildCount() > 0) goto L7;
        return null;
    L7:
        return r10.getChildAt(0);
    }

    public final View getPrefixView() {
        if (this.leftContainer.getChildCount() > 0) goto L7;
        return null;
    L7:
        return this.leftContainer.getChildAt(0);
    }

    public final String getText() {
        String r10 = this.inputView.getText();
        if (r10 != null) goto L7;
        return "";
    L7:
        return r10;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    protected void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
    }

    @Override // android.view.View
    public void setEnabled(boolean r10) {
        this.inputView.setEnabled(r10);
        super.setEnabled(r10);
    }

    public final void setOnInputFocusChange(View.OnFocusChangeListener r10) {
        Intrinsics.checkNotNullParameter(r10, "onFocusChangeListener");
        this.inputView.setOnFocusChangeListener(r10);
    }

    public final void setSearchAction(View.OnClickListener r10) {
        Intrinsics.checkNotNullParameter(r10, "click");
        this.searchAction.setOnClickListener(new a(this, r10));
    }

    public final void setSearchActionText(String r10) {
        Intrinsics.checkNotNullParameter(r10, "searchActionText");
        if (r10.length() != 0) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == false) goto L8;
        k.f(this.searchAction);
        return;
    L8:
        this.searchAction.setText(r10);
        k.h(this.searchAction);
        return;
    L5:
        r11 = false;
        goto L6
    }

    public final void setText(String r10) {
        Intrinsics.checkNotNullParameter(r10, "text");
        this.inputView.setText(r10);
    }
}
