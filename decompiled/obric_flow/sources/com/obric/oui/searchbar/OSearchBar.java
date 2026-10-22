package com.obric.oui.searchbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.ai.event.MessageIndication;
import com.google.android.material.snackbar.a;
import com.lynx.tasm.utils.d;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$styleable;
import com.obric.oui.button.OButton;
import com.obric.oui.forms.OInputView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\r¢\u0006\u0004\b\u001a\u0010\u0010J\u0015\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010!\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"J\u000f\u0010$\u001a\u0004\u0018\u00010#¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u0004\u0018\u00010#¢\u0006\u0004\b&\u0010%R\u0017\u0010,\u001a\u00020'8\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+¨\u0006-"}, d2 = {"Lcom/obric/oui/searchbar/OSearchBar;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "originContext", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "enabled", "", "setEnabled", "(Z)V", "", MessageIndication.CONTENT_TYPE_TEXT, "setText", "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "Landroid/text/TextUtils$TruncateAt;", "where", "setEllipsize", "(Landroid/text/TextUtils$TruncateAt;)V", "getEllipsize", "()Landroid/text/TextUtils$TruncateAt;", "searchActionText", "setSearchActionText", "Landroid/view/View$OnClickListener;", "click", "setSearchAction", "(Landroid/view/View$OnClickListener;)V", "Landroid/view/View$OnFocusChangeListener;", "onFocusChangeListener", "setOnInputFocusChange", "(Landroid/view/View$OnFocusChangeListener;)V", "Landroid/view/View;", "getPrefixView", "()Landroid/view/View;", "getPostfixView", "Lcom/obric/oui/forms/OInputView;", "g", "Lcom/obric/oui/forms/OInputView;", "getInputView", "()Lcom/obric/oui/forms/OInputView;", "inputView", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OSearchBar extends ConstraintLayout {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f14267k = 0;
    public final OInputView g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final FrameLayout f14268h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public FrameLayout f14269i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final OButton f14270j;

    @JvmOverloads
    public OSearchBar(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "originContext");
        this(r5, null);
    }

    public final TextUtils.TruncateAt getEllipsize() {
        return this.g.getEllipsize();
    }

    public final OInputView getInputView() {
        return this.g;
    }

    public final View getPostfixView() {
        FrameLayout r5 = this.f14269i;
        if (r5 != null) goto L6;
        return null;
    L6:
        if (r5.getChildCount() > 0) goto L8;
        return null;
    L8:
        return r5.getChildAt(0);
    }

    public final View getPrefixView() {
        FrameLayout r5 = this.f14268h;
        if (r5.getChildCount() > 0) goto L7;
        return null;
    L7:
        return r5.getChildAt(0);
    }

    public final String getText() {
        String r5 = this.g.getText();
        if (r5 != null) goto L6;
        return "";
    L6:
        return r5;
    }

    public final void setEllipsize(TextUtils.TruncateAt r5) {
        this.g.setEllipsize(r5);
    }

    @Override // android.view.View
    public void setEnabled(boolean r5) {
        this.g.setEnabled(r5);
        super.setEnabled(r5);
    }

    public final void setOnInputFocusChange(View.OnFocusChangeListener r5) {
        Intrinsics.checkNotNullParameter(r5, "onFocusChangeListener");
        this.g.setOnFocusChangeListener(r5);
    }

    public final void setSearchAction(View.OnClickListener r5) {
        Intrinsics.checkNotNullParameter(r5, "click");
        a r10 = new a(4, this, r5);
        this.f14270j.setOnClickListener(r10);
    }

    public final void setSearchActionText(String r5) {
        Intrinsics.checkNotNullParameter(r5, "searchActionText");
        int r10 = r5.length();
        OButton r11 = this.f14270j;
        if (r10 != 0) goto L5;
        d.s(r11);
        return;
    L5:
        r11.setText(r5);
        d.t(r11);
    }

    public final void setText(String r5) {
        Intrinsics.checkNotNullParameter(r5, MessageIndication.CONTENT_TYPE_TEXT);
        this.g.setText(r5);
    }

    @JvmOverloads
    public OSearchBar(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "originContext");
        super(r5, r10);
        View.inflate(getContext(), R$layout.o_widget_search_bar, this);
        this.g = (OInputView) findViewById(R$id.input_view);
        FrameLayout r11 = (FrameLayout) findViewById(R$id.o_input_left_view_container);
        this.f14268h = r11;
        this.f14270j = (OButton) findViewById(R$id.search_action);
        TypedArray r12 = getContext().getTheme().obtainStyledAttributes(r10, R$styleable.OSearchBar, 0, 0);
        getInputView().setHint(r12.getString(R$styleable.OSearchBar_android_hint));
        getInputView().setText(r12.getString(R$styleable.OSearchBar_android_text));
        if (r12.hasValue(R$styleable.OSearchBar_android_ellipsize) == false) goto L18;
        int r13 = r12.getInt(R$styleable.OSearchBar_android_ellipsize, 0);
        if (r13 != 1) goto L7;
        TextUtils.TruncateAt r14 = TextUtils.TruncateAt.START;
    L17:
        setEllipsize(r14);
        goto L18
    L7:
        if (r13 != 2) goto L9;
        r14 = TextUtils.TruncateAt.MIDDLE;
        goto L17
    L9:
        if (r13 != 3) goto L11;
        r14 = TextUtils.TruncateAt.END;
        goto L17
    L11:
        if (r13 == 4) goto L13;
        r14 = null;
        goto L17
    L13:
        r14 = TextUtils.TruncateAt.MARQUEE;
    L18:
        final int r15 = r12.getResourceId(R$styleable.OSearchBar_oui_search_postfixView, 0);
        if (r15 == 0) goto L21;
        getInputView().setActionView(new OSearchBar$1$1(this, r15));
    L21:
        if (r15 != 0) goto L25;
        int r16 = r12.getResourceId(R$styleable.OSearchBar_oui_search_prefixView, R$layout.o_widget_search_bar_prefix);
        if (r16 == 0) goto L25;
        View.inflate(getContext(), r16, r11);
        d.t(r11);
    L25:
        String r17 = r12.getString(R$styleable.OSearchBar_oui_search_actionText);
        if (r17 != null) goto L28;
        r17 = "";
    L28:
        setSearchActionText(r17);
    }
}
