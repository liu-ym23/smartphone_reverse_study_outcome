package com.obric.oui.searchbar.v2;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import cn.nubia.neopush.commons.Constant;
import com.bytedance.ai.event.MessageIndication;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$string;
import com.obric.common.oui.R$styleable;
import com.obric.oui.common.style.i;
import com.obric.oui.common.style.m;
import com.obric.oui.forms.OEditText;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.c;
import com.obric.oui.material.d;
import com.obric.oui.material.n;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import ym.h;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u001d\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010\"\u001a\u00020\f2\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b&\u0010%J\u0017\u0010'\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b'\u0010\u0012J\u0017\u0010(\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b(\u0010\u0012J\u0015\u0010*\u001a\u00020\f2\u0006\u0010)\u001a\u00020\n¢\u0006\u0004\b*\u0010\u000eR\u0017\u00100\u001a\u00020+8\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\"\u00108\u001a\u0002018\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u00109\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b9\u0010;\"\u0004\b<\u0010\u000e¨\u0006="}, d2 = {"Lcom/obric/oui/searchbar/v2/OSearchBar;", "Lcom/obric/oui/layout/OUIFrameLayout;", "Lcom/obric/oui/material/d;", "", "Landroid/content/Context;", "originContext", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "enabled", "", "setEnabled", "(Z)V", "Landroid/view/View;", "view", "setBackdropTarget", "(Landroid/view/View;)V", "", MessageIndication.CONTENT_TYPE_TEXT, "setText", "(Ljava/lang/String;)V", "", "getText", "()Ljava/lang/CharSequence;", "Landroid/text/TextUtils$TruncateAt;", "where", "setEllipsize", "(Landroid/text/TextUtils$TruncateAt;)V", "getEllipsize", "()Landroid/text/TextUtils$TruncateAt;", "Landroid/view/View$OnFocusChangeListener;", "onFocusChangeListener", "setOnInputFocusChange", "(Landroid/view/View$OnFocusChangeListener;)V", "getPrefixView", "()Landroid/view/View;", "getPostfixView", "setPrefixView", "setPostfixView", Constant.ClientMessageType.SHOW, "setCanShowClear", "Lcom/obric/oui/forms/OEditText;", "i", "Lcom/obric/oui/forms/OEditText;", "getInputView", "()Lcom/obric/oui/forms/OEditText;", "inputView", "", "x", "I", "getCurrentTheme", "()I", "setCurrentTheme", "(I)V", "currentTheme", "isBackdropView", "Z", "()Z", "setBackdropView", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OSearchBar extends OUIFrameLayout implements d {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final /* synthetic */ int f14271y = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final OUILinearLayout f14272h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final OEditText f14273i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final FrameLayout f14274j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final FrameLayout f14275k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ViewGroup f14276l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f14277m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List f14278n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final List f14279o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f14280p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f14281q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f14282r;
    public final String s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final String f14283t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public c[] f14284u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public c[] f14285v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f14286w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f14287x;

    @JvmOverloads
    public OSearchBar(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "originContext");
        this(r5, null);
    }

    public static void p(OSearchBar r5, OSearchBar$Companion$SearchBarState r10) {
        if (r5.f14278n != null) goto L5;
        m r11 = m.f12515h;
        r5.l(r11, r11, false);
        return;
    L5:
        int r12 = com.lynx.tasm.utils.a.B(99, r5);
        r5.setShadowCornerRadius(r12);
        OUILinearLayout r13 = r5.f14272h;
        if (r13 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
        r13 = null;
    L8:
        r13.setRadius(r12);
        if (a.f14289a[r10.ordinal()] != 1) goto L14;
        List r14 = r5.f14279o;
        if (r14 == null) goto L13;
        Intrinsics.checkNotNull(r14);
        m r15 = (m) CollectionsKt.getOrNull(r14, 0);
        List r16 = r5.f14279o;
        Intrinsics.checkNotNull(r16);
        r5.l(r15, (m) CollectionsKt.getOrNull(r16, 1), true);
        return;
    L13:
        m r17 = m.f12515h;
        r5.l(r17, r17, true);
        return;
    L14:
        List r18 = r5.f14278n;
        Intrinsics.checkNotNull(r18);
        m r19 = (m) CollectionsKt.getOrNull(r18, 0);
        List r20 = r5.f14278n;
        Intrinsics.checkNotNull(r20);
        r5.l(r19, (m) CollectionsKt.getOrNull(r20, 1), true);
    }

    @Override // com.obric.oui.material.d
    public final void a(int r5) {
        this.f14286w = r5;
        OUILinearLayout r10 = this.f14272h;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
        r10 = null;
    L5:
        a.a.F(r10, r5);
    }

    public final int getCurrentTheme() {
        return this.f14287x;
    }

    public final TextUtils.TruncateAt getEllipsize() {
        return this.f14273i.getEllipsize();
    }

    public final OEditText getInputView() {
        return this.f14273i;
    }

    public final View getPostfixView() {
        FrameLayout r5 = this.f14275k;
        if (r5.getChildCount() != 0) goto L7;
        return null;
    L7:
        return r5.getChildAt(0);
    }

    public final View getPrefixView() {
        FrameLayout r5 = this.f14274j;
        if (r5.getChildCount() != 0) goto L7;
        return null;
    L7:
        return r5.getChildAt(0);
    }

    public final CharSequence getText() {
        Editable r5 = this.f14273i.getText();
        if (r5 != null) goto L6;
        return "";
    L6:
        return r5;
    }

    public final void n() {
        boolean r5 = this.f14277m;
        int r10 = 8;
        ViewGroup r11 = this.f14276l;
        if (r5 == true) goto L5;
        r11.setVisibility(8);
    L12:
        int r12 = r11.getVisibility();
        FrameLayout r13 = this.f14275k;
        if (r12 != 0) goto L16;
        com.lynx.tasm.utils.d.s(r13);
    L18:
        o();
        return;
    L16:
        if (r13.getChildCount() == 0) goto L18;
        com.lynx.tasm.utils.d.t(r13);
        goto L18
    L5:
        Editable r14 = this.f14273i.getText();
        if (r14 != null) goto L8;
    L11:
        r11.setVisibility(r10);
        goto L12
    L8:
        if (r14.length() == 0) goto L11;
        r10 = 0;
        goto L11
    }

    public final void o() {
        if (this.f14274j.getVisibility() != 0) goto L5;
        int r5 = 0;
    L7:
        if (this.f14276l.getVisibility() != 0) goto L10;
    L11:
        int r10 = com.lynx.tasm.utils.a.B(0, this);
    L13:
        this.f14273i.setPaddingRelative(r5, 0, r10, 0);
        return;
    L10:
        if (this.f14275k.getVisibility() == 0) goto L11;
        r10 = com.lynx.tasm.utils.a.B(8, this);
        goto L13
    L5:
        r5 = com.lynx.tasm.utils.a.B(12, this);
        goto L7
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r5) {
        super.onConfigurationChanged(r5);
        this.f14284u = MaterialToken.parseSet(this.f14283t, !a.a.v(this));
        String r10 = this.s;
        if (r10 == null) goto L5;
        c[] r11 = MaterialToken.parseSet(r10, !a.a.v(this));
    L6:
        this.f14285v = r11;
        q();
        return;
    L5:
        r11 = null;
        goto L6
    }

    public final void q() {
        OEditText r5 = this.f14273i;
        if (r5.hasFocus() == false) goto L5;
        OSearchBar$Companion$SearchBarState r10 = OSearchBar$Companion$SearchBarState.ACTIVE;
    L12:
        int r11 = a.f14289a[r10.ordinal()];
        OUILinearLayout r12 = this.f14272h;
        boolean r13 = this.f14282r;
        FrameLayout r14 = this.f14274j;
        int r15 = 2;
        if (r11 == 1) goto L31;
        int r16 = this.f14280p;
        if (r11 != 2) goto L17;
        if (r13 == true) goto L30;
        if (r12 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
        OUILinearLayout r17 = null;
    L29:
        r17.setBackgroundColor(r16);
        goto L30
    L28:
        r17 = r12;
    L30:
        r14.setSelected(true);
        p(this, r10);
    L37:
        if (r13 == true) goto L40;
        return;
    L40:
        if (r10 != OSearchBar$Companion$SearchBarState.RESTING) goto L44;
        c[] r18 = this.f14285v;
        if (r18 != null) goto L45;
        r18 = this.f14284u;
    L45:
        if (r18 == null) goto L55;
        int r19 = this.f14286w;
        if (r19 == (-1)) goto L50;
        r15 = r19;
    L50:
        if (r12 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
        r12 = null;
    L52:
        a.a.y(r12, r18, false, r15, 10);
        return;
    L55:
        return;
    L44:
        r18 = this.f14284u;
        goto L45
    L17:
        if (r11 != 3) goto L37;
        if (r13 == true) goto L24;
        if (r12 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
        OUILinearLayout r20 = null;
    L23:
        r20.setBackgroundColor(r16);
        goto L24
    L22:
        r20 = r12;
    L24:
        r14.setSelected(true);
        p(this, r10);
        goto L37
    L31:
        if (r13 == true) goto L36;
        if (r12 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
        OUILinearLayout r21 = null;
    L35:
        r21.setBackgroundColor(this.f14281q);
        goto L36
    L34:
        r21 = r12;
    L36:
        r14.setSelected(false);
        p(this, r10);
        goto L37
    L5:
        Editable r22 = r5.getText();
        if (r22 != null) goto L8;
    L11:
        r10 = OSearchBar$Companion$SearchBarState.RESTING;
        goto L12
    L8:
        if (r22.length() == 0) goto L11;
        r10 = OSearchBar$Companion$SearchBarState.VALUE;
        goto L12
    }

    @Override // com.obric.oui.material.d
    public void setBackdropTarget(View r5) {
        Intrinsics.checkNotNullParameter(this, "<this>");
        n.r(r5, this);
    }

    public final void setBackdropView(boolean r5) {
    }

    public final void setCanShowClear(boolean r5) {
        this.f14277m = r5;
        n();
    }

    public final void setCurrentTheme(int r5) {
        this.f14287x = r5;
    }

    public final void setEllipsize(TextUtils.TruncateAt r5) {
        this.f14273i.setEllipsize(r5);
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setEnabled(boolean r5) {
        this.f14273i.setEnabled(r5);
        super.setEnabled(r5);
    }

    public final void setOnInputFocusChange(View.OnFocusChangeListener r5) {
        Intrinsics.checkNotNullParameter(r5, "onFocusChangeListener");
        this.f14273i.setOnFocusChangeListener(r5);
    }

    public final void setPostfixView(View r5) {
        FrameLayout r10 = this.f14275k;
        r10.removeAllViews();
        if (r5 != null) goto L5;
        com.lynx.tasm.utils.d.s(r10);
    L6:
        o();
        return;
    L5:
        r10.addView(r5);
        com.lynx.tasm.utils.d.t(r10);
        goto L6
    }

    public final void setPrefixView(View r5) {
        FrameLayout r10 = this.f14274j;
        r10.removeAllViews();
        if (r5 != null) goto L5;
        com.lynx.tasm.utils.d.s(r10);
    L6:
        o();
        return;
    L5:
        r5.setDuplicateParentStateEnabled(true);
        r10.addView(r5);
        com.lynx.tasm.utils.d.t(r10);
        goto L6
    }

    public final void setText(String r5) {
        Intrinsics.checkNotNullParameter(r5, MessageIndication.CONTENT_TYPE_TEXT);
        this.f14273i.setText(r5);
    }

    /* JADX WARN: Type inference failed for: r1v8, types: [com.obric.oui.searchbar.v2.OSearchBar$4, java.lang.Object, kotlin.jvm.internal.Lambda] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.obric.oui.searchbar.v2.OSearchBar$1, java.lang.Object, kotlin.jvm.internal.Lambda] */
    @JvmOverloads
    public OSearchBar(Context r17, AttributeSet r18) {
        Intrinsics.checkNotNullParameter(r17, "originContext");
        boolean r5 = false;
        super(r17, r18, 0, 12);
        this.f14277m = true;
        this.f14286w = -1;
        View.inflate(getContext(), R$layout.o_widget_search_bar_v2, this);
        setChangeAlphaWhenPress(false);
        if (a.a.w(this) == true) goto L5;
    L7:
        boolean r10 = false;
    L8:
        this.f14282r = r10;
        OUILinearLayout r11 = (OUILinearLayout) findViewById(R$id.searchbar_container);
        this.f14272h = r11;
        OEditText r12 = (OEditText) findViewById(R$id.input_view);
        this.f14273i = r12;
        ?? r13 = new AnonymousClass1(this);
        r12.getClass();
        Intrinsics.checkNotNullParameter(r13, "action");
        r12.f13246b.f13334a = r13;
        FrameLayout r14 = (FrameLayout) findViewById(R$id.left_container);
        this.f14274j = r14;
        FrameLayout r15 = (FrameLayout) findViewById(R$id.right_container);
        this.f14275k = r15;
        ViewGroup r16 = (ViewGroup) findViewById(R$id.clear_action_container);
        this.f14276l = r16;
        ImageView r19 = (ImageView) findViewById(R$id.clear_action);
        TypedArray r20 = getContext().obtainStyledAttributes(r18, R$styleable.OSearchBar, 0, 0);
        this.f14280p = r20.getColor(R$styleable.OSearchBar_oui_widgetBgColor, getContext().getResources().getColor(R$color.oui_searchbar_bg, null));
        this.f14281q = r20.getColor(R$styleable.OSearchBar_oui_widgetBgColorResting, getContext().getResources().getColor(R$color.oui_searchbar_bg_resting, null));
        getInputView().setTextColor(r20.getColorStateList(R$styleable.OSearchBar_oui_widgetTextColor));
        ColorStateList r110 = r20.getColorStateList(R$styleable.OSearchBar_oui_widgetTextColorHint);
        getInputView().setHintTextColor(r110);
        r19.setImageTintList(r110);
        getInputView().setHint(r20.getString(R$styleable.OSearchBar_android_hint));
        getInputView().setText(r20.getString(R$styleable.OSearchBar_android_text));
        if (r20.hasValue(R$styleable.OSearchBar_android_ellipsize) == false) goto L23;
        int r111 = r20.getInt(R$styleable.OSearchBar_android_ellipsize, 0);
        if (r111 == 1) goto L21;
        if (r111 != 2) goto L14;
        TextUtils.TruncateAt r112 = TextUtils.TruncateAt.MIDDLE;
    L22:
        setEllipsize(r112);
        goto L23
    L14:
        if (r111 != 3) goto L16;
        r112 = TextUtils.TruncateAt.END;
        goto L22
    L16:
        if (r111 == 4) goto L18;
        r112 = null;
        goto L22
    L18:
        r112 = TextUtils.TruncateAt.MARQUEE;
        goto L22
    L21:
        r112 = TextUtils.TruncateAt.START;
    L23:
        int r113 = r20.getLayoutDimension(R$styleable.OSearchBar_android_layout_height, 0);
        if (r113 > 0) goto L26;
        ps.a.c("OSearchBar", Intrinsics.stringPlus("searchBarHeight must be greater than 0, ", Integer.valueOf(r113)));
    L26:
        int r21 = r20.getResourceId(R$styleable.OSearchBar_oui_search_postfixView, 0);
        if (r21 == 0) goto L29;
        View.inflate(getContext(), r21, r15);
        com.lynx.tasm.utils.d.t(r15);
    L29:
        int r22 = r20.getResourceId(R$styleable.OSearchBar_oui_search_prefixView, R$layout.o_widget_search_bar_prefix_v2);
        if (r22 == 0) goto L35;
        View.inflate(getContext(), r22, r14);
        com.lynx.tasm.utils.d.t(r14);
        if (r113 > 0) goto L34;
        ps.a.c("OSearchBar", Intrinsics.stringPlus("newWidth must be greater than 0, ", Integer.valueOf(r113)));
        goto L35
    L34:
        ViewGroup.LayoutParams r23 = r14.getLayoutParams();
        r23.width = r113;
        r14.setLayoutParams(r23);
    L35:
        if (r113 > 0) goto L37;
        ps.a.c("OSearchBar", Intrinsics.stringPlus("newWidth must be greater than 0, ", Integer.valueOf(r113)));
    L38:
        r16.setOnClickListener(new ar.a(this, 18));
        Context r24 = getContext();
        int r25 = r20.getResourceId(R$styleable.OSearchBar_oui_widgetShadowNormal, 0);
        if (r25 == 0) goto L41;
        ArrayList r26 = i.o(r25, r24);
        this.f14278n = CollectionsKt.listOf(new m[]{(m) r26.get(0), (m) r26.get(1)});
    L41:
        int r27 = r20.getResourceId(R$styleable.OSearchBar_oui_widgetShadowResting, 0);
        if (r27 == 0) goto L44;
        ArrayList r28 = i.o(r27, r24);
        this.f14279o = CollectionsKt.listOf(new m[]{(m) r28.get(0), (m) r28.get(1)});
    L44:
        if (r10 == false) goto L46;
        this.f14286w = r20.getInt(R$styleable.OSearchBar_oui_widgetMaterialSrcType, -1);
        this.f14282r = r20.getBoolean(R$styleable.OSearchBar_oui_widgetEnableMaterial, false);
    L46:
        int r29 = this.f14280p;
        if (r29 != 0) goto L50;
        boolean r30 = a.a.v(this);
    L57:
        if (this.f14282r == false) goto L84;
        String r31 = r20.getString(R$styleable.OSearchBar_oui_widgetMaterial);
        this.f14283t = r31;
        if (r31 != null) goto L61;
        this.f14283t = r20.getResources().getString(R$string.oui_material_bg_floating);
    L61:
        String r32 = r20.getString(R$styleable.OSearchBar_oui_widgetMaterialResting);
        this.s = r32;
        boolean r33 = !r30;
        this.f14284u = MaterialToken.parseSet(this.f14283t, r33);
        if (r32 == null) goto L64;
        c[] r34 = MaterialToken.parseSet(r32, r33);
    L65:
        this.f14285v = r34;
        if (r34 != null) goto L68;
        r34 = this.f14284u;
    L68:
        if (r34 != null) goto L70;
        Unit r35 = null;
        OUILinearLayout r36 = null;
    L82:
        if (r35 != null) goto L85;
        this.f14282r = false;
    L85:
        r20.recycle();
        int r37 = this.f14280p;
        if (r37 != 0) goto L89;
        boolean r38 = a.a.v(this);
    L94:
        if (r38 == true) goto L99;
        if (r11 != null) goto L97;
        Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
        OUILinearLayout r39 = r36;
    L98:
        r39.setOverridePressColor(getResources().getColor(R$color.oui_basic_fill_element_2_light));
    L103:
        if (r11 != null) goto L105;
        Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
        r11 = r36;
    L105:
        r11.i("OSearchBar");
        Function4<CharSequence, Integer, Integer, Integer, Unit> r40 = new AnonymousClass3(this);
        Intrinsics.checkNotNullParameter(r40, "action");
        r12.f13247c.f13330b = r40;
        ?? r41 = new AnonymousClass4(this);
        Intrinsics.checkNotNullParameter(r41, "action");
        r12.f13245a.f13332a = r41;
        q();
        o();
        return;
    L97:
        r39 = r11;
        goto L98
    L99:
        if (r11 != null) goto L101;
        Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
        OUILinearLayout r42 = r36;
    L102:
        r42.setOverridePressColor(getResources().getColor(R$color.oui_basic_fill_element_2_dark));
        goto L103
    L101:
        r42 = r11;
        goto L102
    L89:
        if (this.f14287x != 2) goto L91;
    L92:
        r5 = true;
    L93:
        r38 = r5;
        goto L94
    L91:
        if (h.j(r37) == false) goto L93;
    L70:
        r36 = null;
        setBackground(null);
        int r114 = this.f14286w;
        if (r114 != (-1)) goto L74;
        r114 = 2;
    L74:
        if (r11 != null) goto L76;
        Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
        View r115 = null;
    L77:
        GradientDrawable r116 = new GradientDrawable();
        r116.setShape(0);
        r116.setCornerRadius(com.lynx.tasm.utils.a.E(99, this));
        r116.setColor(0);
        r115.setBackground(r116);
        if (r11 != null) goto L80;
        Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
        OUILinearLayout r117 = null;
    L81:
        a.a.y(r117, r34, false, r114, 10);
        r35 = Unit.INSTANCE;
        goto L82
    L80:
        r117 = r11;
        goto L81
    L76:
        r115 = r11;
        goto L77
    L64:
        r34 = null;
        goto L65
    L84:
        r36 = null;
        goto L85
    L50:
        if (this.f14287x != 2) goto L52;
    L55:
        r30 = true;
        goto L57
    L52:
        if (h.j(r29) == true) goto L55;
        r30 = false;
        goto L57
    L37:
        ViewGroup.LayoutParams r43 = r16.getLayoutParams();
        r43.width = r113;
        r16.setLayoutParams(r43);
        goto L38
    L5:
        if (n.k() == false) goto L7;
        r10 = true;
        goto L8
    }
}
