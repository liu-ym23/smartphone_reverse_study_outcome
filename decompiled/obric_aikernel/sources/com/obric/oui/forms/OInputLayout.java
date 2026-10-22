package com.obric.oui.forms;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.os.Build;
import android.text.Editable;
import android.text.SpannableString;
import android.text.method.DigitsKeyListener;
import android.text.style.BackgroundColorSpan;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewGroupKt;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.oui.text.OTextView;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import u8.h;
import u8.l;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u00002\u00020\u0001:\u0002;<B'\b\u0007\u0012\u0006\u00105\u001a\u000204\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u000106\u0012\b\b\u0002\u00108\u001a\u00020\u0002¢\u0006\u0004\b9\u0010:J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0006\u0010\u0006\u001a\u00020\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\u0010\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\b\u0010\u0015\u001a\u0004\u0018\u00010\u0012J\u0010\u0010\u0017\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0012J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u001a\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0012J\b\u0010\u001b\u001a\u0004\u0018\u00010\u0012J\u000e\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0002J\u0006\u0010\u001e\u001a\u00020\u0002J\u000e\u0010\u001f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0002J\b\u0010 \u001a\u0004\u0018\u00010\u0010J\u0010\u0010\"\u001a\u00020\u00042\b\u0010!\u001a\u0004\u0018\u00010\u0012J\b\u0010#\u001a\u0004\u0018\u00010\u0012J\u000e\u0010&\u001a\u00020\u00042\u0006\u0010%\u001a\u00020$J\u0010\u0010(\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u0002H\u0016J\u0006\u0010)\u001a\u00020\u0002J\u000e\u0010+\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u0007J\u000e\u0010-\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u0007R\u0019\u00103\u001a\u00020.8\u0006@\u0006¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102¨\u0006="}, d2 = {"Lcom/obric/oui/forms/OInputLayout;", "Landroid/widget/FrameLayout;", "", WsConstants.KEY_CONNECTION_TYPE, "", "setType", "getType", "", "enabled", "setEnabled", "setInputType", "getInputType", "resId", "setCustomStart", "defaultStart", "setDefaultCustomStart", "Landroid/view/View;", "getCustomStart", "", "label", "setLabel", "getLabel", "text", "setText", "getText", "hint", "setHint", "getHint", "lines", "setMaxLines", "getMaxLines", "setCustomEnd", "getCustomEnd", "tip", "setTip", "getTip", "Lcom/obric/oui/forms/OInputLayout$e;", "limitStateChangeListener", "setLimitStateChangeListener", CommonConsts.COUNT_TYPE, "setLimitCount", "getLimitCount", "auto", "setAutoChangeWithLimit", "isError", "setTextState", "Lcom/obric/oui/forms/OEditText;", "n", "Lcom/obric/oui/forms/OEditText;", "getVInput", "()Lcom/obric/oui/forms/OEditText;", "vInput", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "d", "e", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
@SuppressLint({"ClickableViewAccessibility"})
public class OInputLayout extends FrameLayout {
    private boolean A;
    private boolean B;
    private boolean C;
    private e D;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f6581c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f6582g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f6583h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f6584i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final LinearLayout f6585j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final FrameLayout f6586k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final FrameLayout f6587l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final OTextView f6588m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final OEditText f6589n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private CharSequence f6590o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f6591p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final ImageView f6592q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f6593r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final ImageView f6594s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f6595t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final FrameLayout f6596u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final OTextView f6597v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final OTextView f6598w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final OTextView f6599x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f6600y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f6601z;

    static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OInputLayout f6602c;

        a(OInputLayout r10) {
            this.f6602c = r10;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            this.f6602c.setText("");
            OInputLayout.e(this.f6602c);
        }
    }

    static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OInputLayout f6603c;

        b(OInputLayout r10) {
            this.f6603c = r10;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            int r11 = 0;
            if ((this.f6603c.getVInput().getInputType() & 4080) != 144) goto L5;
            boolean r12 = true;
        L6:
            if (r12 == false) goto L8;
            OInputLayout.a(this.f6603c).setImageResource(u8.e.o_input_view_eyes_close);
            OInputLayout.g(this.f6603c);
        L10:
            if (this.f6603c.getVInput().hasFocus() == false) goto L16;
            OEditText r13 = this.f6603c.getVInput();
            Editable r14 = this.f6603c.getVInput().getText();
            if (r14 == null) goto L14;
            r11 = r14.length();
        L14:
            r13.setSelection(r11);
            return;
        L16:
            return;
        L8:
            OInputLayout.a(this.f6603c).setImageResource(u8.e.o_input_view_eyes_open);
            this.f6603c.getVInput().setInputType((this.f6603c.getVInput().getInputType() & (-4081)) | 144);
            goto L10
        L5:
            r12 = false;
            goto L6
        }
    }

    static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OInputLayout f6604c;

        c(OInputLayout r10) {
            this.f6604c = r10;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            this.f6604c.getVInput().requestFocus();
            if (this.f6604c.getVInput().hasFocus() == true) goto L5;
        L7:
            OInputLayout.d(this.f6604c);
            return;
        L5:
            if (this.f6604c.getVInput().isCursorVisible() == true) goto L7;
            this.f6604c.getVInput().setCursorVisible(true);
            goto L7
        }
    }

    public static final class d {
        private d() {
        }

        public /* synthetic */ d(DefaultConstructorMarker r10) {
            this();
        }
    }

    public interface e {
        void a(boolean r10);
    }

    public static final class f extends ViewOutlineProvider {
        f() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View r10, Outline r11) {
            Intrinsics.checkNotNullParameter(r10, "view");
            Intrinsics.checkNotNullParameter(r11, "outline");
            int r12 = r10.getWidth();
            int r13 = r10.getHeight();
            Resources r14 = Resources.getSystem();
            Intrinsics.checkNotNullExpressionValue(r14, "Resources.getSystem()");
            r11.setRoundRect(0, 0, r12, r13, MathKt.roundToInt(TypedValue.applyDimension(1, 16, r14.getDisplayMetrics())));
        }
    }

    static {
        new d(null);
    }

    @JvmOverloads
    public OInputLayout(Context r10) {
        this(r10, null, 0, 6, null);
    }

    @JvmOverloads
    public OInputLayout(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 4, null);
    }

    @JvmOverloads
    public OInputLayout(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        this.f6582g = -1;
        this.f6583h = -1;
        this.f6584i = -1;
        this.f6600y = -1;
        View r13 = LayoutInflater.from(r10).inflate(h.o_input_view_layout, this, true);
        Objects.requireNonNull(r13, "null cannot be cast to non-null type android.widget.FrameLayout");
        FrameLayout r14 = (FrameLayout) r13;
        View r15 = findViewById(u8.f.input_container);
        Intrinsics.checkNotNullExpressionValue(r15, "findViewById(R.id.input_container)");
        LinearLayout r16 = (LinearLayout) r15;
        this.f6585j = r16;
        View r17 = findViewById(u8.f.helper_container);
        Intrinsics.checkNotNullExpressionValue(r17, "findViewById(R.id.helper_container)");
        this.f6586k = (FrameLayout) r17;
        View r18 = findViewById(u8.f.custom_start_container);
        Intrinsics.checkNotNullExpressionValue(r18, "findViewById(R.id.custom_start_container)");
        this.f6587l = (FrameLayout) r18;
        View r19 = findViewById(u8.f.label);
        Intrinsics.checkNotNullExpressionValue(r19, "findViewById(R.id.label)");
        this.f6588m = (OTextView) r19;
        View r20 = findViewById(u8.f.input);
        Intrinsics.checkNotNullExpressionValue(r20, "findViewById(R.id.input)");
        OEditText r21 = (OEditText) r20;
        this.f6589n = r21;
        View r22 = findViewById(u8.f.custom_end_container);
        Intrinsics.checkNotNullExpressionValue(r22, "findViewById(R.id.custom_end_container)");
        this.f6596u = (FrameLayout) r22;
        Intrinsics.checkNotNullExpressionValue(findViewById(u8.f.input_divider), "findViewById(R.id.input_divider)");
        View r23 = findViewById(u8.f.clear);
        Intrinsics.checkNotNullExpressionValue(r23, "findViewById(R.id.clear)");
        ImageView r24 = (ImageView) r23;
        this.f6592q = r24;
        View r25 = findViewById(u8.f.eyes);
        Intrinsics.checkNotNullExpressionValue(r25, "findViewById(R.id.eyes)");
        ImageView r26 = (ImageView) r25;
        this.f6594s = r26;
        View r27 = findViewById(u8.f.tip);
        Intrinsics.checkNotNullExpressionValue(r27, "findViewById(R.id.tip)");
        this.f6597v = (OTextView) r27;
        View r28 = findViewById(u8.f.limit_single);
        Intrinsics.checkNotNullExpressionValue(r28, "findViewById(R.id.limit_single)");
        this.f6598w = (OTextView) r28;
        View r29 = findViewById(u8.f.limit_multi);
        Intrinsics.checkNotNullExpressionValue(r29, "findViewById(R.id.limit_multi)");
        this.f6599x = (OTextView) r29;
        setFocusableInTouchMode(true);
        setFocusable(true);
        setDescendantFocusability(262144);
        r21.setFocusable(true);
        r21.setFocusableInTouchMode(true);
        if (r11 == null) goto L5;
        o(r11, r12);
    L5:
        l();
        r24.setOnClickListener(new a(this));
        r26.setOnClickListener(new b(this));
        r16.setOnClickListener(new c(this));
        p();
    }

    public /* synthetic */ OInputLayout(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    private final void A() {
        int r10 = getMaxLines();
        boolean r11 = false;
        if (getMaxLines() == 1) goto L5;
        boolean r12 = true;
    L6:
        int r13 = this.f6591p;
        if (r12 == true) goto L9;
        r13 = r13 & (-131073);
    L12:
        this.f6589n.setInputType(r13);
        if (this.f6589n.getMaxLines() == r10) goto L18;
        OEditText r14 = this.f6589n;
        if (r14.getMaxLines() != 1) goto L17;
        r11 = true;
    L17:
        r14.setSingleLine(r11);
        this.f6589n.setMaxLines(r10);
    L18:
        this.f6589n.invalidate();
        return;
    L9:
        if (n(r13) == true) goto L12;
        r13 = r13 | 131072;
        goto L12
    L5:
        r12 = false;
        goto L6
    }

    private final void C(int r10) {
        OEditText r11 = this.f6589n;
        boolean r12 = true;
        if (r11.getMaxLines() == 1) goto L6;
        r12 = false;
    L6:
        r11.setSingleLine(r12);
        this.f6589n.setMaxLines(r10);
        A();
    }

    private final void D() {
        if (this.f6581c == 0) goto L5;
        LinearLayout r10 = this.f6585j;
        float r11 = 12;
        Resources r12 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r12, "Resources.getSystem()");
        int r13 = MathKt.roundToInt(TypedValue.applyDimension(1, r11, r12.getDisplayMetrics()));
        float r14 = 8;
        Resources r15 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r15, "Resources.getSystem()");
        int r16 = MathKt.roundToInt(TypedValue.applyDimension(1, r14, r15.getDisplayMetrics()));
        if (this.f6586k.getVisibility() != 0) goto L15;
        boolean r17 = true;
    L16:
        if (r17 == false) goto L18;
        Resources r18 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r18, "Resources.getSystem()");
        float r19 = TypedValue.applyDimension(1, 0, r18.getDisplayMetrics());
    L19:
        r10.setPadding(r13, r16, 0, MathKt.roundToInt(r19));
        OTextView r20 = this.f6588m;
        Resources r21 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r21, "Resources.getSystem()");
        r20.setPadding(0, 0, MathKt.roundToInt(TypedValue.applyDimension(1, r11, r21.getDisplayMetrics())), 0);
        OEditText r22 = this.f6589n;
        Resources r23 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r23, "Resources.getSystem()");
        r22.setPadding(0, 0, MathKt.roundToInt(TypedValue.applyDimension(1, r11, r23.getDisplayMetrics())), 0);
        this.f6589n.setScrollBarStyle(33554432);
        FrameLayout r110 = this.f6586k;
        Resources r24 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r24, "Resources.getSystem()");
        int r25 = MathKt.roundToInt(TypedValue.applyDimension(1, r11, r24.getDisplayMetrics()));
        Resources r26 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r26, "Resources.getSystem()");
        int r27 = MathKt.roundToInt(TypedValue.applyDimension(1, 6, r26.getDisplayMetrics()));
        Resources r28 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r28, "Resources.getSystem()");
        int r29 = MathKt.roundToInt(TypedValue.applyDimension(1, r11, r28.getDisplayMetrics()));
        Resources r30 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r30, "Resources.getSystem()");
        r110.setPadding(r25, r27, r29, MathKt.roundToInt(TypedValue.applyDimension(1, r14, r30.getDisplayMetrics())));
        return;
    L18:
        Resources r31 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r31, "Resources.getSystem()");
        r19 = TypedValue.applyDimension(1, r14, r31.getDisplayMetrics());
        goto L19
    L15:
        r17 = false;
        goto L16
    L5:
        if (this.f6588m.getVisibility() != 0) goto L7;
        boolean r32 = true;
    L8:
        if (r32 == false) goto L10;
        float r33 = (float) 8.5d;
    L11:
        Resources r34 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r34, "Resources.getSystem()");
        int r35 = MathKt.roundToInt(TypedValue.applyDimension(1, r33, r34.getDisplayMetrics()));
        LinearLayout r36 = this.f6585j;
        float r37 = 12;
        Resources r38 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r38, "Resources.getSystem()");
        int r39 = MathKt.roundToInt(TypedValue.applyDimension(1, r37, r38.getDisplayMetrics()));
        float r40 = 8;
        Resources r41 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r41, "Resources.getSystem()");
        r36.setPadding(r39, r35, MathKt.roundToInt(TypedValue.applyDimension(1, r40, r41.getDisplayMetrics())), r35);
        this.f6588m.setPadding(0, 0, 0, 0);
        this.f6589n.setPadding(0, 0, 0, 0);
        this.f6589n.setScrollBarStyle(0);
        Resources r42 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r42, "Resources.getSystem()");
        int r43 = MathKt.roundToInt(TypedValue.applyDimension(1, 5, r42.getDisplayMetrics()));
        FrameLayout r111 = this.f6586k;
        Resources r44 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r44, "Resources.getSystem()");
        int r45 = MathKt.roundToInt(TypedValue.applyDimension(1, r37, r44.getDisplayMetrics()));
        Resources r46 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r46, "Resources.getSystem()");
        r111.setPadding(r45, r43, MathKt.roundToInt(TypedValue.applyDimension(1, r40, r46.getDisplayMetrics())), r43);
        return;
    L10:
        r33 = 13;
        goto L11
    L7:
        r32 = false;
        goto L8
    }

    private final void E() {
        if (this.C == true) goto L5;
    L7:
        boolean r10 = false;
    L8:
        setTextState(r10);
        return;
    L5:
        if (this.A == false) goto L7;
        r10 = true;
        goto L8
    }

    public static final /* synthetic */ ImageView a(OInputLayout r10) {
        return r10.f6594s;
    }

    public static final /* synthetic */ void b(OInputLayout r10) {
        r10.k();
    }

    public static final /* synthetic */ boolean c(OInputLayout r10) {
        return r10.B;
    }

    public static final /* synthetic */ void d(OInputLayout r10) {
        r10.v();
    }

    public static final /* synthetic */ void e(OInputLayout r10) {
        r10.x();
    }

    public static final /* synthetic */ void f(OInputLayout r10) {
        r10.y();
    }

    public static final /* synthetic */ void g(OInputLayout r10) {
        r10.A();
    }

    private final void k() {
        Object r10 = getContext().getSystemService("input_method");
        if ((r10 instanceof InputMethodManager) == true) goto L5;
        r10 = null;
    L5:
        InputMethodManager r11 = (InputMethodManager) r10;
        if (r11 == null) goto L9;
        r11.hideSoftInputFromWindow(this.f6589n.getWindowToken(), 0);
        return;
    }

    private final void l() {
        i();
        CharSequence r10 = this.f6590o;
        if (r10 == null) goto L9;
        this.f6589n.setKeyListener(DigitsKeyListener.getInstance(String.valueOf(r10)));
        int r11 = this.f6591p;
        if (r11 != 0) goto L8;
        r11 = 1;
    L8:
        this.f6591p = r11;
    L9:
        int r12 = this.f6591p;
        if (r12 == 0) goto L12;
        setInputType(r12);
    L12:
        this.f6589n.onFocusChange$OUI_standardRelease(new OInputLayout$initInput$1(this));
        this.f6589n.onTextChanged$OUI_standardRelease(new OInputLayout$initInput$2(this));
        this.f6589n.afterTextChanged$OUI_standardRelease(new OInputLayout$initInput$3(this));
    }

    private final boolean n(int r10) {
        int r11 = r10 & 4095;
        if (r11 != 129) goto L5;
        boolean r12 = true;
    L7:
        if (r11 != 225) goto L9;
        boolean r13 = true;
    L11:
        if (r11 != 18) goto L13;
        boolean r14 = true;
    L14:
        if (r12 == true) goto L20;
        if (r13 == true) goto L21;
        if (r14 == false) goto L19;
        return true;
    L19:
        return false;
    L21:
        return true;
    L20:
        return true;
    L13:
        r14 = false;
        goto L14
    L9:
        r13 = false;
        goto L11
    L5:
        r12 = false;
        goto L7
    }

    private final void o(AttributeSet r10, int r11) {
        Context r12 = getContext();
        Intrinsics.checkNotNullExpressionValue(r12, "context");
        TypedArray r13 = r12.getTheme().obtainStyledAttributes(r10, l.OInputLayout, r11, 0);
        setType(r13.getInt(l.OInputLayout_oinput_type, 0));
        s(r13.getBoolean(l.OInputLayout_oinput_showInputBackground, false));
        this.f6582g = r13.getDimensionPixelSize(l.OInputLayout_oinput_minHeight, -1);
        this.f6583h = r13.getDimensionPixelSize(l.OInputLayout_oinput_maxHeight, -1);
        setCustomStart(r13.getResourceId(l.OInputLayout_oinput_customStart, 0));
        r(r13.getBoolean(l.OInputLayout_oinput_showCustomStart, false));
        setLabel(r13.getString(l.OInputLayout_oinput_label));
        t(r13.getBoolean(l.OInputLayout_oinput_showLabel, false));
        setText(r13.getString(l.OInputLayout_oinput_text));
        setHint(r13.getString(l.OInputLayout_oinput_hint));
        this.f6590o = r13.getText(l.OInputLayout_android_digits);
        this.f6591p = r13.getInt(l.OInputLayout_android_inputType, 1);
        setMaxLines(r13.getInt(l.OInputLayout_android_maxLines, -1));
        setCustomEnd(r13.getResourceId(l.OInputLayout_oinput_customEnd, 0));
        q(r13.getBoolean(l.OInputLayout_oinput_showCustomEnd, false));
        this.f6593r = r13.getBoolean(l.OInputLayout_oinput_showClear, false);
        this.f6595t = r13.getBoolean(l.OInputLayout_oinput_showEyes, false);
        setTip(r13.getString(l.OInputLayout_oinput_tip));
        w(r13.getBoolean(l.OInputLayout_oinput_showTip, false));
        setLimitCount(r13.getInt(l.OInputLayout_oinput_limitCount, -1));
        u(r13.getBoolean(l.OInputLayout_oinput_showLimit, false));
        setAutoChangeWithLimit(r13.getBoolean(l.OInputLayout_oinput_autoChangeWithLimit, false));
    }

    private final void p() {
        this.f6585j.setClipToOutline(true);
        this.f6585j.setOutlineProvider(new f());
        this.f6585j.invalidateOutline();
    }

    private final void v() {
        Object r10 = getContext().getSystemService("input_method");
        if ((r10 instanceof InputMethodManager) == true) goto L5;
        r10 = null;
    L5:
        InputMethodManager r11 = (InputMethodManager) r10;
        if (r11 == null) goto L9;
        r11.showSoftInput(this.f6589n, 0);
        return;
    }

    private final void x() {
        ImageView r10 = this.f6592q;
        int r11 = 0;
        if (this.f6581c == 0) goto L5;
    L15:
        r11 = 8;
    L16:
        r10.setVisibility(r11);
        return;
    L5:
        if (this.f6593r == false) goto L15;
        Editable r12 = this.f6589n.getText();
        if (r12 != null) goto L9;
    L12:
        boolean r13 = true;
    L13:
        if (r13 == true) goto L15;
    L9:
        if (r12.length() == 0) goto L12;
        r13 = false;
        goto L13
    }

    private final void y() {
        ImageView r10 = this.f6594s;
        int r11 = 0;
        if (this.f6581c == 0) goto L5;
    L17:
        r11 = 8;
    L18:
        r10.setVisibility(r11);
        return;
    L5:
        if (this.f6595t == false) goto L17;
        if (m() == false) goto L17;
        Editable r12 = this.f6589n.getText();
        if (r12 != null) goto L11;
    L14:
        boolean r13 = true;
    L15:
        if (r13 == true) goto L17;
    L11:
        if (r12.length() == 0) goto L14;
        r13 = false;
        goto L15
    }

    private final void z() {
        FrameLayout r10 = this.f6586k;
        boolean r11 = true;
        int r12 = 0;
        if (this.f6597v.getVisibility() != 0) goto L5;
        boolean r13 = true;
    L6:
        if (r13 == false) goto L8;
    L14:
        r10.setVisibility(r12);
        return;
    L8:
        if (this.f6599x.getVisibility() == 0) goto L11;
        r11 = false;
    L11:
        if (r11 == true) goto L14;
        r12 = 8;
        goto L14
    L5:
        r13 = false;
        goto L6
    }

    public final void B() {
        if (this.f6600y <= 0) goto L5;
        OTextView r10 = this.f6598w;
        StringBuilder r11 = new StringBuilder();
        Editable r12 = this.f6589n.getText();
        Intrinsics.checkNotNull(r12);
        r11.append(String.valueOf(j(r12)));
        r11.append("/");
        r11.append(this.f6600y);
        r10.setText(r11.toString());
        OTextView r13 = this.f6599x;
        StringBuilder r14 = new StringBuilder();
        Editable r15 = this.f6589n.getText();
        Intrinsics.checkNotNull(r15);
        r14.append(String.valueOf(j(r15)));
        r14.append("/");
        r14.append(this.f6600y);
        r13.setText(r14.toString());
    L5:
        OTextView r16 = this.f6598w;
        int r17 = 8;
        boolean r18 = false;
        if (this.f6581c == 0) goto L8;
    L10:
        int r19 = 8;
    L11:
        r16.setVisibility(r19);
        OTextView r20 = this.f6599x;
        if (this.f6581c == 1) goto L14;
    L16:
        r20.setVisibility(r17);
        if (this.f6600y <= 0) goto L29;
        Editable r21 = this.f6589n.getText();
        if (r21 != null) goto L21;
    L24:
        boolean r22 = true;
    L25:
        if (r22 == true) goto L29;
        Editable r23 = this.f6589n.getText();
        Intrinsics.checkNotNull(r23);
        if (j(r23) <= this.f6600y) goto L29;
        r18 = true;
        goto L29
    L21:
        if (r21.length() == 0) goto L24;
        r22 = false;
    L29:
        boolean r24 = this.C;
        if (r18 == r24) goto L34;
        this.C = r18;
        e r25 = this.D;
        if (r25 == null) goto L35;
        r25.a(r18);
    L35:
        E();
        return;
    L34:
        if (r24 == true) goto L35;
        return;
    L14:
        if (this.f6601z == false) goto L16;
        r17 = 0;
        goto L16
    L8:
        if (this.f6601z == false) goto L10;
        r19 = 0;
        goto L11
    }

    public final View getCustomEnd() {
        if (this.f6596u.getChildCount() != 0) goto L5;
        return null;
    L5:
        return this.f6596u.getChildAt(0);
    }

    public final View getCustomStart() {
        if (this.f6587l.getChildCount() != 0) goto L5;
        return null;
    L5:
        return this.f6587l.getChildAt(0);
    }

    public final CharSequence getHint() {
        return this.f6589n.getHint();
    }

    public final int getInputType() {
        return this.f6591p;
    }

    public final CharSequence getLabel() {
        return this.f6588m.getText();
    }

    public final int getLimitCount() {
        return this.f6600y;
    }

    public final int getMaxLines() {
        return this.f6589n.getMaxLines();
    }

    public CharSequence getText() {
        return this.f6589n.getText();
    }

    public final CharSequence getTip() {
        return this.f6597v.getText();
    }

    public final int getType() {
        return this.f6581c;
    }

    public final OEditText getVInput() {
        return this.f6589n;
    }

    public void h(Editable r10) {
    }

    public final void i() {
        Method r10 = TextView.class.getDeclaredMethod("enableUpdateCursorDrawable", new Class[0]);     // Catch: Exception -> L4
        Intrinsics.checkNotNullExpressionValue(r10, "TextView::class.java.get…orDrawable\"\n            )");     // Catch: Exception -> L4
        r10.setAccessible(true);     // Catch: Exception -> L4
        r10.invoke(this.f6589n, new Object[0]);     // Catch: Exception -> L4
        return;
    }

    public int j(CharSequence r10) {
        if (r10 != null) goto L6;
        return 0;
    L6:
        return r10.length();
    }

    public final boolean m() {
        return n(this.f6591p);
    }

    public final void q(boolean r10) {
        if (this.f6581c != 1) goto L5;
        return;
    L5:
        int r11 = this.f6596u.getChildCount();
        int r12 = 8;
        FrameLayout r13 = this.f6596u;
        if (r11 == 0) goto L9;
        if (r10 == false) goto L9;
        r12 = 0;
    L9:
        r13.setVisibility(r12);
    }

    public void r(boolean r10) {
        if (this.f6581c != 1) goto L5;
        return;
    L5:
        int r11 = this.f6587l.getChildCount();
        int r12 = 8;
        FrameLayout r13 = this.f6587l;
        if (r11 == 0) goto L9;
        if (r10 == false) goto L9;
        r12 = 0;
    L9:
        r13.setVisibility(r12);
    }

    public final void s(boolean r10) {
        LinearLayout r11 = this.f6585j;
        if (r10 == false) goto L5;
        int r12 = getResources().getColor(u8.c.oui_fill_list_item_card);
    L6:
        r11.setBackgroundColor(r12);
        return;
    L5:
        r12 = 0;
        goto L6
    }

    public final void setAutoChangeWithLimit(boolean r10) {
        this.A = r10;
        E();
    }

    public final void setCustomEnd(int r10) {
        this.f6596u.removeAllViews();
        if (r10 == 0) goto L9;
        FrameLayout.inflate(getContext(), r10, this.f6596u);     // Catch: Exception -> L6
        return;
    L10:
        return;
    }

    public void setCustomStart(int r10) {
        this.f6587l.removeAllViews();
        if (r10 == 0) goto L9;
        FrameLayout.inflate(getContext(), r10, this.f6587l);     // Catch: Exception -> L6
        return;
    L10:
        return;
    }

    public void setDefaultCustomStart(int r10) {
        this.f6587l.removeAllViews();
        if (r10 != 0) goto L5;
        setCustomStart(h.o_input_custom_start_area_code);
        return;
    L5:
        r(false);
    }

    @Override // android.view.View
    public void setEnabled(boolean r10) {
        super.setEnabled(r10);
        Iterator<View> r11 = ViewGroupKt.getChildren(this).iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r11.next().setEnabled(r10);
        goto L4
    L6:
        this.f6589n.setEnabled(r10);
    }

    public final void setHint(CharSequence r10) {
        this.f6589n.setHint(r10);
    }

    public final void setInputType(int r10) {
        if ((r10 & 1) != 0) goto L12;
        if ((r10 & 2) != 0) goto L12;
        if ((r10 & 3) != 0) goto L12;
        if ((r10 & 4) != 0) goto L12;
        r10 = r10 | 1;
    L12:
        if (this.f6591p == r10) goto L14;
        this.f6591p = r10;
    L14:
        A();
        y();
        h(this.f6589n.getText());
    }

    public final void setLabel(CharSequence r10) {
        this.f6588m.setText(r10);
    }

    public void setLimitCount(int r10) {
        if (this.f6600y != r10) goto L5;
        return;
    L5:
        this.f6600y = r10;
        B();
        h(this.f6589n.getText());
    }

    public final void setLimitStateChangeListener(e r10) {
        Intrinsics.checkNotNullParameter(r10, "limitStateChangeListener");
        this.D = r10;
    }

    public final void setMaxLines(int r10) {
        if (r10 > 0) goto L4;
        return;
    L4:
        this.f6584i = r10;
        C(r10);
    }

    public final void setText(CharSequence r10) {
        this.f6589n.setText(r10);
        h(this.f6589n.getText());
    }

    public final void setTextState(boolean r10) {
        if (this.B == false) goto L5;
        return;
    L5:
        this.B = true;
        SpannableString r11 = new SpannableString(this.f6589n.getText());
        if (r10 == false) goto L8;
        int r12 = getResources().getColor(u8.c.oui_functional_red_2);
    L9:
        r11.setSpan(new BackgroundColorSpan(r12), 0, r11.length(), 33);
        this.f6589n.setText(r11);
        this.f6589n.setSelection(r11.length());
        if (Build.VERSION.SDK_INT < 29) goto L16;
        OEditText r13 = this.f6589n;
        if (r10 == false) goto L14;
        int r14 = u8.e.o_input_cursor_red;
    L15:
        r13.setTextCursorDrawable(r14);
        goto L16
    L14:
        r14 = u8.e.o_input_cursor_blue;
    L16:
        OTextView r15 = this.f6597v;
        Resources r16 = getResources();
        if (r10 == false) goto L19;
        int r17 = u8.c.oui_functional_red_6;
    L20:
        r15.setTextColor(r16.getColor(r17));
        OTextView r18 = this.f6598w;
        Resources r19 = getResources();
        if (r10 == false) goto L23;
        int r20 = u8.c.oui_functional_red_6;
    L24:
        r18.setTextColor(r19.getColor(r20));
        OTextView r21 = this.f6599x;
        Resources r22 = getResources();
        if (r10 == false) goto L27;
        int r23 = u8.c.oui_functional_red_6;
    L28:
        r21.setTextColor(r22.getColor(r23));
        this.B = false;
        return;
    L27:
        r23 = u8.c.oui_basic_text_3b;
        goto L28
    L23:
        r20 = u8.c.oui_basic_text_3b;
        goto L24
    L19:
        r17 = u8.c.oui_basic_text_3b;
        goto L20
    L8:
        r12 = 0;
        goto L9
    }

    public final void setTip(CharSequence r10) {
        this.f6597v.setText(r10);
    }

    public void setType(int r10) {
        int r11 = 1;
        if (r10 == 0) goto L6;
        if (r10 == 1) goto L6;
        return;
    L6:
        this.f6581c = r10;
        OEditText r12 = this.f6589n;
        int r13 = this.f6582g;
        if (r13 != (-1)) goto L13;
        if (r10 != 0) goto L11;
        int r14 = 22;
    L12:
        Resources r15 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r15, "Resources.getSystem()");
        r13 = MathKt.roundToInt(TypedValue.applyDimension(1, r14, r15.getDisplayMetrics()));
        goto L13
    L11:
        r14 = 120;
    L13:
        r12.setMinimumHeight(r13);
        OEditText r16 = this.f6589n;
        int r17 = this.f6583h;
        if (r17 != (-1)) goto L20;
        if (r10 != 0) goto L18;
        int r18 = 66;
    L19:
        Resources r19 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r19, "Resources.getSystem()");
        r17 = MathKt.roundToInt(TypedValue.applyDimension(1, r18, r19.getDisplayMetrics()));
        goto L20
    L18:
        r18 = 240;
    L20:
        r16.setMaxHeight(r17);
        int r20 = this.f6584i;
        if (r20 == (-1)) goto L23;
        r11 = r20;
    L26:
        C(r11);
        D();
        B();
        x();
        y();
        return;
    L23:
        if (r10 == 0) goto L26;
        r11 = 12;
        goto L26
    }

    public final void t(boolean r10) {
        CharSequence r11 = getLabel();
        int r12 = 0;
        if (r11 != null) goto L5;
    L8:
        boolean r13 = true;
    L10:
        if (r13 == true) goto L16;
        OTextView r14 = this.f6588m;
        if (r10 == true) goto L15;
        r12 = 8;
    L15:
        r14.setVisibility(r12);
    L17:
        D();
        return;
    L16:
        this.f6588m.setVisibility(8);
        goto L17
    L5:
        if (r11.length() == 0) goto L8;
        r13 = false;
        goto L10
    }

    public final void u(boolean r10) {
        if (this.f6601z != r10) goto L5;
        return;
    L5:
        this.f6601z = r10;
        B();
        z();
    }

    public final void w(boolean r10) {
        CharSequence r11 = getTip();
        int r12 = 0;
        if (r11 != null) goto L5;
    L8:
        boolean r13 = true;
    L10:
        if (r13 == true) goto L16;
        OTextView r14 = this.f6597v;
        if (r10 == true) goto L15;
        r12 = 8;
    L15:
        r14.setVisibility(r12);
    L17:
        z();
        return;
    L16:
        this.f6597v.setVisibility(8);
        goto L17
    L5:
        if (r11.length() == 0) goto L8;
        r13 = false;
        goto L10
    }
}
