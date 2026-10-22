package com.obric.oui.searchbar.v2;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.Editable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.obric.oui.common.util.k;
import com.obric.oui.forms.OEditText;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.layout.OUILinearLayout;
import ea.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import o9.p;
import u8.c;
import u8.f;
import u8.h;
import u8.l;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\"B\u001d\b\u0007\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b \u0010!J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bJ\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\b\u0010\u0010\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u0013\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u000eJ\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0002R\u0019\u0010\u001b\u001a\u00020\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006#"}, d2 = {"Lcom/obric/oui/searchbar/v2/OSearchBar;", "Lcom/obric/oui/layout/OUIFrameLayout;", "", "enabled", "", "setEnabled", "", "text", "setText", "", "getText", "Landroid/view/View$OnFocusChangeListener;", "onFocusChangeListener", "setOnInputFocusChange", "Landroid/view/View;", "getPrefixView", "getPostfixView", "view", "setPrefixView", "setPostfixView", "show", "setCanShowClear", "Lcom/obric/oui/forms/OEditText;", "m", "Lcom/obric/oui/forms/OEditText;", "getInputView", "()Lcom/obric/oui/forms/OEditText;", "inputView", "Landroid/content/Context;", "originContext", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class OSearchBar extends OUIFrameLayout {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private OUILinearLayout f7224l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final OEditText f7225m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final FrameLayout f7226n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final FrameLayout f7227o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final ViewGroup f7228p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f7229q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private List<p> f7230r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private List<p> f7231s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f7232t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f7233u;

    public static final class Companion {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/searchbar/v2/OSearchBar$Companion$SearchBarState;", "", "<init>", "(Ljava/lang/String;I)V", "RESTING", "ACTIVE", "VALUE", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
        public static final enum SearchBarState extends Enum<SearchBarState> {
            private static final /* synthetic */ SearchBarState[] $VALUES = null;
            public static final SearchBarState ACTIVE = null;
            public static final SearchBarState RESTING = null;
            public static final SearchBarState VALUE = null;

            static {
                SearchBarState r10 = new SearchBarState("RESTING", 0);
                RESTING = r10;
                SearchBarState r11 = new SearchBarState("ACTIVE", 1);
                ACTIVE = r11;
                SearchBarState r12 = new SearchBarState("VALUE", 2);
                VALUE = r12;
                $VALUES = new SearchBarState[]{r10, r11, r12};
            }

            private SearchBarState(String r10, int r11) {
                super(r10, r11);
            }

            public static SearchBarState valueOf(String r10) {
                return (SearchBarState) Enum.valueOf(SearchBarState.class, r10);
            }

            public static SearchBarState[] values() {
                return (SearchBarState[]) $VALUES.clone();
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }
    }

    static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OSearchBar f7234c;

        a(OSearchBar r10) {
            this.f7234c = r10;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            this.f7234c.getInputView().setText("");
        }
    }

    static {
        new Companion(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public OSearchBar(Context r10) {
        this(r10, null, 2, 0 == true ? 1 : 0);
    }

    @JvmOverloads
    public OSearchBar(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "originContext");
        super(r10, r11, 0, null, 12, null);
        this.f7229q = true;
        FrameLayout.inflate(getContext(), h.o_widget_search_bar_v2, this);
        View r12 = findViewById(f.searchbar_container);
        Intrinsics.checkNotNullExpressionValue(r12, "findViewById(R.id.searchbar_container)");
        this.f7224l = (OUILinearLayout) r12;
        View r13 = findViewById(f.input_view);
        Intrinsics.checkNotNullExpressionValue(r13, "findViewById(R.id.input_view)");
        OEditText r14 = (OEditText) r13;
        this.f7225m = r14;
        View r15 = findViewById(f.left_container);
        Intrinsics.checkNotNullExpressionValue(r15, "findViewById(R.id.left_container)");
        FrameLayout r16 = (FrameLayout) r15;
        this.f7226n = r16;
        View r17 = findViewById(f.right_container);
        Intrinsics.checkNotNullExpressionValue(r17, "findViewById(R.id.right_container)");
        FrameLayout r18 = (FrameLayout) r17;
        this.f7227o = r18;
        View r19 = findViewById(f.clear_action_container);
        Intrinsics.checkNotNullExpressionValue(r19, "findViewById(R.id.clear_action_container)");
        ViewGroup r20 = (ViewGroup) r19;
        this.f7228p = r20;
        Context r21 = getContext();
        Intrinsics.checkNotNullExpressionValue(r21, "context");
        TypedArray r110 = r21.getTheme().obtainStyledAttributes(r11, l.OSearchBar, 0, 0);
        int r22 = l.OSearchBar_oui_widgetBgColor;
        Context r23 = getContext();
        Intrinsics.checkNotNullExpressionValue(r23, "context");
        this.f7232t = r110.getColor(r22, r23.getResources().getColor(c.oui_searchbar_bg, null));
        int r24 = l.OSearchBar_oui_widgetBgColorResting;
        Context r25 = getContext();
        Intrinsics.checkNotNullExpressionValue(r25, "context");
        this.f7233u = r110.getColor(r24, r25.getResources().getColor(c.oui_searchbar_bg_resting, null));
        r14.setHint(r110.getString(l.OSearchBar_android_hint));
        r14.setText(r110.getString(l.OSearchBar_android_text));
        int r26 = r110.getLayoutDimension(l.OSearchBar_android_layout_height, 0);
        if (r26 > 0) goto L5;
        b.b("OSearchBar", "searchBarHeight must be greater than 0, " + r26);
    L5:
        int r27 = r110.getResourceId(l.OSearchBar_oui_search_postfixView, 0);
        if (r27 == 0) goto L8;
        FrameLayout.inflate(getContext(), r27, r18);
        k.h(r18);
    L8:
        int r28 = r110.getResourceId(l.OSearchBar_oui_search_prefixView, h.o_widget_search_bar_prefix_v2);
        if (r28 == 0) goto L11;
        FrameLayout.inflate(getContext(), r28, r16);
        k.h(r16);
        j(r16, r26);
    L11:
        j(r20, r26);
        r20.setOnClickListener(new a(this));
        Context r29 = getContext();
        Intrinsics.checkNotNullExpressionValue(r29, "context");
        Intrinsics.checkNotNullExpressionValue(r110, "this");
        e(r29, r110);
        r14.onTextChanged$OUI_standardRelease(new AnonymousClass2(this));
        r14.onFocusChange$OUI_standardRelease(new AnonymousClass3(this));
        i();
    }

    public /* synthetic */ OSearchBar(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    public static final /* synthetic */ void c(OSearchBar r10) {
        r10.f();
    }

    public static final /* synthetic */ void d(OSearchBar r10) {
        r10.i();
    }

    private final void e(Context r10, TypedArray r11) {
        int r12 = r11.getResourceId(l.OSearchBar_oui_widgetShadowNormal, 0);
        if (r12 == 0) goto L5;
        List<p> r13 = o9.k.v(r10, r12);
        this.f7230r = CollectionsKt.listOf(new p[]{r13.get(0), r13.get(1)});
    L5:
        int r14 = r11.getResourceId(l.OSearchBar_oui_widgetShadowResting, 0);
        if (r14 == 0) goto L9;
        List<p> r15 = o9.k.v(r10, r14);
        this.f7231s = CollectionsKt.listOf(new p[]{r15.get(0), r15.get(1)});
        return;
    }

    private final void f() {
        int r10 = 8;
        boolean r11 = true;
        if (this.f7229q == true) goto L6;
        ViewGroup r12 = this.f7228p;
    L5:
        r12.setVisibility(r10);
        if (this.f7228p.getVisibility() != 0) goto L18;
        boolean r13 = true;
    L19:
        if (r13 == false) goto L22;
        k.f(this.f7227o);
        return;
    L22:
        if (this.f7227o.getChildCount() != 0) goto L25;
        r11 = false;
    L25:
        if (r11 == false) goto L29;
        k.h(this.f7227o);
        return;
    L29:
        return;
    L18:
        r13 = false;
        goto L19
    L6:
        r12 = this.f7228p;
        Editable r14 = this.f7225m.getText();
        if (r14 != null) goto L9;
    L12:
        boolean r15 = true;
    L13:
        if (r15 == true) goto L5;
        r10 = 0;
        goto L5
    L9:
        if (r14.length() == 0) goto L12;
        r15 = false;
        goto L13
    }

    private final void g(Companion.SearchBarState r10, boolean r11) {
        if (this.f7230r != null) goto L6;
        setShadow(null, null);
        return;
    L6:
        Resources r12 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r12, "Resources.getSystem()");
        int r13 = MathKt.roundToInt(TypedValue.applyDimension(1, 99, r12.getDisplayMetrics()));
        setShadowCornerRadius(r13);
        OUILinearLayout r14 = this.f7224l;
        if (r14 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
    L9:
        r14.setRadius(r13);
        if (r11 == true) goto L12;
    L18:
        setShadow(null, null);
        return;
    L12:
        if (com.obric.oui.searchbar.v2.a.f7235a[r10.ordinal()] == 1) goto L15;
        List<p> r15 = this.f7230r;
        Intrinsics.checkNotNull(r15);
        p r16 = (p) CollectionsKt.getOrNull(r15, 0);
        List<p> r17 = this.f7230r;
    L14:
        Intrinsics.checkNotNull(r17);
        setShadow(r16, (p) CollectionsKt.getOrNull(r17, 1));
        return;
    L15:
        List<p> r18 = this.f7231s;
        if (r18 == null) goto L18;
        Intrinsics.checkNotNull(r18);
        r16 = (p) CollectionsKt.getOrNull(r18, 0);
        r17 = this.f7231s;
        goto L14
    }

    static /* synthetic */ void h(OSearchBar r10, Companion.SearchBarState r11, boolean r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L5;
        r12 = true;
    L5:
        r10.g(r11, r12);
    }

    private final void i() {
        if (this.f7225m.hasFocus() == false) goto L5;
        Companion.SearchBarState r10 = Companion.SearchBarState.ACTIVE;
    L15:
        int r11 = com.obric.oui.searchbar.v2.a.f7236b[r10.ordinal()];
        if (r11 == 1) goto L28;
        if (r11 != 2) goto L19;
        OUILinearLayout r12 = this.f7224l;
        if (r12 != null) goto L27;
    L26:
        Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
    L27:
        int r13 = this.f7232t;
    L32:
        r12.setBackgroundColor(r13);
        h(this, r10, false, 2, null);
        return;
    L19:
        if (r11 != 3) goto L34;
        r12 = this.f7224l;
        if (r12 != null) goto L27;
    L34:
        return;
    L28:
        r12 = this.f7224l;
        if (r12 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
    L31:
        r13 = this.f7233u;
        goto L32
    L5:
        Editable r14 = this.f7225m.getText();
        if (r14 != null) goto L8;
    L11:
        boolean r15 = true;
    L12:
        if (r15 == false) goto L14;
        r10 = Companion.SearchBarState.RESTING;
        goto L15
    L14:
        r10 = Companion.SearchBarState.VALUE;
        goto L15
    L8:
        if (r14.length() == 0) goto L11;
        r15 = false;
        goto L12
    }

    private final void j(View r10, int r11) {
        if (r11 > 0) goto L5;
        b.b("OSearchBar", "newWidth must be greater than 0, " + r11);
        return;
    L5:
        ViewGroup.LayoutParams r12 = r10.getLayoutParams();
        r12.width = r11;
        Unit r13 = Unit.INSTANCE;
        r10.setLayoutParams(r12);
    }

    public final OEditText getInputView() {
        return this.f7225m;
    }

    public final View getPostfixView() {
        if (this.f7227o.getChildCount() == 0) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == true) goto L10;
        return null;
    L10:
        return this.f7227o.getChildAt(0);
    L5:
        r10 = false;
        goto L6
    }

    public final View getPrefixView() {
        if (this.f7226n.getChildCount() == 0) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == true) goto L10;
        return null;
    L10:
        return this.f7226n.getChildAt(0);
    L5:
        r10 = false;
        goto L6
    }

    public final CharSequence getText() {
        Editable r10 = this.f7225m.getText();
        if (r10 != null) goto L7;
        return "";
    L7:
        return r10;
    }

    public final void setCanShowClear(boolean r10) {
        this.f7229q = r10;
        f();
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setEnabled(boolean r10) {
        this.f7225m.setEnabled(r10);
        super.setEnabled(r10);
    }

    public final void setOnInputFocusChange(View.OnFocusChangeListener r10) {
        Intrinsics.checkNotNullParameter(r10, "onFocusChangeListener");
        this.f7225m.setOnFocusChangeListener(r10);
    }

    public final void setPostfixView(View r10) {
        this.f7227o.removeAllViews();
        if (r10 != null) goto L5;
        k.f(this.f7227o);
        return;
    L5:
        this.f7227o.addView(r10);
        k.h(this.f7227o);
    }

    public final void setPrefixView(View r10) {
        this.f7226n.removeAllViews();
        if (r10 != null) goto L5;
        k.f(this.f7226n);
        return;
    L5:
        this.f7226n.addView(r10);
        k.h(this.f7226n);
    }

    public final void setText(String r10) {
        Intrinsics.checkNotNullParameter(r10, "text");
        this.f7225m.setText(r10);
    }
}
