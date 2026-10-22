package com.obric.oui.stepper;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.crash.entity.EventBody;
import com.obric.oui.button.OButton;
import com.obric.oui.common.util.k;
import com.obric.oui.layout.OUIConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import u8.l;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 ?2\u00020\u0001:\u0002@AB\u001d\b\u0007\u0012\u0006\u0010:\u001a\u000209\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010;¢\u0006\u0004\b=\u0010>J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0007J\u0006\u0010\r\u001a\u00020\u0007J\u000e\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0007J\u0006\u0010\u000f\u001a\u00020\u0007J\u000e\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0007J\u000e\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0007J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0007H\u0014J0\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0014R$\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010$\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00078\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0016\u0010)\u001a\u00020(8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010*R\u0016\u0010-\u001a\u00020,8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R$\u0010/\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00078\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b/\u0010%\"\u0004\b0\u0010'R$\u00101\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00078\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b1\u0010%\"\u0004\b2\u0010'R\u0016\u00104\u001a\u0002038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00106\u001a\u00020,8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u0010.R$\u00107\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00078\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b7\u0010%\"\u0004\b8\u0010'¨\u0006B"}, d2 = {"Lcom/obric/oui/stepper/OSteppers;", "Lcom/obric/oui/layout/OUIConstraintLayout;", "", "registerEvent", "registerInputFilter", "checkCounter", "refreshCounter", "", "touchableHeight", "expandTouchHeight", "getValue", EventBody.KEY_VALUE, "setValue", "getMinValue", "setMinValue", "getMaxValue", "setMaxValue", "setStepValue", "clearFocus", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "", "changed", "left", "top", "right", "bottom", "onLayout", "Lcom/obric/oui/stepper/OSteppers$b;", "onValueChangeListener", "Lcom/obric/oui/stepper/OSteppers$b;", "getOnValueChangeListener", "()Lcom/obric/oui/stepper/OSteppers$b;", "setOnValueChangeListener", "(Lcom/obric/oui/stepper/OSteppers$b;)V", "mMaxValue", "I", "setMMaxValue", "(I)V", "Landroid/view/ViewGroup;", "addContainerView", "Landroid/view/ViewGroup;", "decContainerView", "Lcom/obric/oui/button/OButton;", "tvAdd", "Lcom/obric/oui/button/OButton;", "mValue", "setMValue", "mMinValue", "setMMinValue", "Landroid/widget/EditText;", "etCounter", "Landroid/widget/EditText;", "tvDec", "mStepValue", "setMStepValue", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Companion", "a", "b", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class OSteppers extends OUIConstraintLayout {
    public static final a Companion = null;
    public static final int NUMBER_SIZE = 13;
    public static final int STEP = 1;
    public static final double TEXT_STROKE_WIDTH = 1.5d;
    private final ViewGroup addContainerView;
    private final ViewGroup decContainerView;
    private final EditText etCounter;
    private int mMaxValue;
    private int mMinValue;
    private int mStepValue;
    private int mValue;
    private b onValueChangeListener;
    private final OButton tvAdd;
    private final OButton tvDec;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    public interface b {
        void a(int r10);

        void b();

        void c();

        void d(int r10, int r11);

        void e();
    }

    static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OSteppers f7449c;

        c(OSteppers r10) {
            this.f7449c = r10;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            int r11 = OSteppers.access$getMValue$p(this.f7449c) + OSteppers.access$getMStepValue$p(this.f7449c);
            if (r11 >= OSteppers.access$getMMinValue$p(this.f7449c)) goto L5;
            return;
        L5:
            if (r11 > OSteppers.access$getMMaxValue$p(this.f7449c)) goto L10;
            OSteppers.access$setMValue$p(this.f7449c, r11);
            OSteppers.access$getEtCounter$p(this.f7449c).clearFocus();
            q9.a.b(this.f7449c.getContext(), 3);
            return;
        }
    }

    static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OSteppers f7450c;

        d(OSteppers r10) {
            this.f7450c = r10;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            int r11 = OSteppers.access$getMValue$p(this.f7450c) - OSteppers.access$getMStepValue$p(this.f7450c);
            if (r11 >= OSteppers.access$getMMinValue$p(this.f7450c)) goto L5;
            return;
        L5:
            if (r11 > OSteppers.access$getMMaxValue$p(this.f7450c)) goto L10;
            OSteppers.access$setMValue$p(this.f7450c, r11);
            OSteppers.access$getEtCounter$p(this.f7450c).clearFocus();
            q9.a.b(this.f7450c.getContext(), 3);
            return;
        }
    }

    static final class e implements View.OnClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OSteppers f7451c;

        e(OSteppers r10) {
            this.f7451c = r10;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            b r11 = this.f7451c.getOnValueChangeListener();
            if (r11 == null) goto L6;
            r11.c();
            return;
        }
    }

    static final class f implements View.OnClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OSteppers f7452c;

        f(OSteppers r10) {
            this.f7452c = r10;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            b r11 = this.f7452c.getOnValueChangeListener();
            if (r11 == null) goto L6;
            r11.e();
            return;
        }
    }

    public static final class g implements TextWatcher {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OSteppers f7453c;

        g(OSteppers r10) {
            this.f7453c = r10;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable r10) {
            if (r10 == null) goto L4;
            String r11 = r10.toString();
        L5:
            int r12 = 0;
            if (r11 != null) goto L8;
        L11:
            boolean r13 = true;
        L12:
            if (r13 == false) goto L16;
            b r14 = this.f7453c.getOnValueChangeListener();
            if (r14 == null) goto L16;
            r14.b();
        L16:
            if (r10 != null) goto L27;
        L22:
            OSteppers.access$setMValue$p(this.f7453c, r12);     // Catch: Exception -> L24
        L25:
            OSteppers.access$checkCounter(this.f7453c);
            return;
        L24:
            com.obric.oui.common.util.d.c(com.obric.oui.common.util.d.f6398b, "OSteppers", "input type error", null, 4, null);
            goto L25
        L27:
            String r15 = r10.toString();     // Catch: Exception -> L24
            if (r15 == null) goto L22;
            Integer r16 = StringsKt.toIntOrNull(r15);     // Catch: Exception -> L24
            if (r16 == null) goto L22;
            r12 = r16.intValue();     // Catch: Exception -> L24
            goto L22
        L8:
            if (StringsKt.isBlank(r11) == true) goto L11;
            r13 = false;
            goto L12
        L4:
            r11 = null;
            goto L5
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence r10, int r11, int r12, int r13) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence r10, int r11, int r12, int r13) {
        }
    }

    static final class h implements com.obric.oui.stepper.a.InterfaceC0135a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OSteppers f7454a;

        h(OSteppers r10) {
            this.f7454a = r10;
        }

        @Override // com.obric.oui.stepper.a.InterfaceC0135a
        public final void a(int r10) {
            b r11 = this.f7454a.getOnValueChangeListener();
            if (r11 == null) goto L6;
            r11.a(r10);
            return;
        }
    }

    static {
        Companion = new a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public OSteppers(Context r10) {
        this(r10, null, 2, 0 == true ? 1 : 0);
    }

    @JvmOverloads
    public OSteppers(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, 0, null, 12, null);
        this.mMaxValue = 100;
        this.mStepValue = 1;
        setFocusable(true);
        setFocusableInTouchMode(true);
        setLayoutParams(new ConstraintLayout.LayoutParams(-1, -1));
        LayoutInflater.from(r10).inflate(u8.h.o_widget_steppers, this);
        View r12 = findViewById(u8.f.tv_add);
        Intrinsics.checkNotNullExpressionValue(r12, "findViewById(R.id.tv_add)");
        this.tvAdd = (OButton) r12;
        View r13 = findViewById(u8.f.tv_dec);
        Intrinsics.checkNotNullExpressionValue(r13, "findViewById(R.id.tv_dec)");
        this.tvDec = (OButton) r13;
        View r14 = findViewById(u8.f.et_counter);
        Intrinsics.checkNotNullExpressionValue(r14, "findViewById(R.id.et_counter)");
        this.etCounter = (EditText) r14;
        View r15 = findViewById(u8.f.increase_container);
        Intrinsics.checkNotNullExpressionValue(r15, "findViewById(R.id.increase_container)");
        this.addContainerView = (ViewGroup) r15;
        View r16 = findViewById(u8.f.decrease_container);
        Intrinsics.checkNotNullExpressionValue(r16, "findViewById(R.id.decrease_container)");
        this.decContainerView = (ViewGroup) r16;
        TypedArray r17 = r10.obtainStyledAttributes(r11, l.OSteppers, 0, 0);
        setMValue(r17.getInt(l.OSteppers_oui_stepper_value, 0));
        setMMinValue(r17.getInt(l.OSteppers_oui_min_value, Integer.MIN_VALUE));
        setMMaxValue(r17.getInt(l.OSteppers_oui_max_value, Integer.MAX_VALUE));
        setMStepValue(r17.getInt(l.OSteppers_oui_step, 1));
        r17.recycle();
        Resources r18 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r18, "Resources.getSystem()");
        int r19 = MathKt.roundToInt(TypedValue.applyDimension(1, 4, r18.getDisplayMetrics()));
        setPadding(r19, r19, r19, r19);
        setRadius(r10.getResources().getDimensionPixelSize(u8.d.oui_r_m2_rect));
        setBackgroundResource(u8.c.oui_fill_sunken_variable);
        registerEvent();
        refreshCounter();
    }

    public /* synthetic */ OSteppers(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    public static final /* synthetic */ void access$checkCounter(OSteppers r10) {
        r10.checkCounter();
    }

    public static final /* synthetic */ EditText access$getEtCounter$p(OSteppers r10) {
        return r10.etCounter;
    }

    public static final /* synthetic */ int access$getMMaxValue$p(OSteppers r10) {
        return r10.mMaxValue;
    }

    public static final /* synthetic */ int access$getMMinValue$p(OSteppers r10) {
        return r10.mMinValue;
    }

    public static final /* synthetic */ int access$getMStepValue$p(OSteppers r10) {
        return r10.mStepValue;
    }

    public static final /* synthetic */ int access$getMValue$p(OSteppers r10) {
        return r10.mValue;
    }

    public static final /* synthetic */ void access$setMMaxValue$p(OSteppers r10, int r11) {
        r10.setMMaxValue(r11);
    }

    public static final /* synthetic */ void access$setMMinValue$p(OSteppers r10, int r11) {
        r10.setMMinValue(r11);
    }

    public static final /* synthetic */ void access$setMStepValue$p(OSteppers r10, int r11) {
        r10.setMStepValue(r11);
    }

    public static final /* synthetic */ void access$setMValue$p(OSteppers r10, int r11) {
        r10.setMValue(r11);
    }

    private final void checkCounter() {
        OButton r10 = this.tvAdd;
        boolean r11 = true;
        if (getValue() >= this.mMaxValue) goto L5;
        boolean r12 = true;
    L6:
        r10.setEnabled(r12);
        OButton r13 = this.tvAdd;
        if (getValue() >= this.mMaxValue) goto L9;
        boolean r14 = true;
    L10:
        r13.setClickable(r14);
        OButton r15 = this.tvDec;
        if (getValue() <= this.mMinValue) goto L13;
        boolean r16 = true;
    L14:
        r15.setEnabled(r16);
        OButton r17 = this.tvDec;
        if (getValue() > this.mMinValue) goto L18;
        r11 = false;
    L18:
        r17.setClickable(r11);
        return;
    L13:
        r16 = false;
        goto L14
    L9:
        r14 = false;
        goto L10
    L5:
        r12 = false;
        goto L6
    }

    public static /* synthetic */ void expandTouchHeight$default(OSteppers r10, int r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        Resources r14 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r14, "Resources.getSystem()");
        r11 = MathKt.roundToInt(TypedValue.applyDimension(1, 44, r14.getDisplayMetrics()));
    L5:
        r10.expandTouchHeight(r11);
    }

    private final void refreshCounter() {
        this.etCounter.setText(String.valueOf(this.mValue), TextView.BufferType.EDITABLE);
        checkCounter();
    }

    private final void registerEvent() {
        this.tvAdd.setOnClickListener(new c(this));
        this.tvDec.setOnClickListener(new d(this));
        this.addContainerView.setOnClickListener(new e(this));
        this.decContainerView.setOnClickListener(new f(this));
        this.etCounter.addTextChangedListener(new g(this));
    }

    private final void registerInputFilter() {
        this.etCounter.setFilters(new com.obric.oui.stepper.a[]{new com.obric.oui.stepper.a(this.mMinValue, this.mMaxValue, new h(this))});
    }

    private final void setMMaxValue(int r10) {
        this.mMaxValue = r10;
        registerInputFilter();
        refreshCounter();
    }

    private final void setMMinValue(int r10) {
        this.mMinValue = r10;
        registerInputFilter();
        refreshCounter();
    }

    private final void setMStepValue(int r10) {
        this.mStepValue = r10;
        refreshCounter();
    }

    private final void setMValue(int r10) {
        if (this.mValue != r10) goto L5;
        return;
    L5:
        this.mValue = r10;
        b r11 = this.onValueChangeListener;
        if (r11 == null) goto L8;
        r11.d(r10, r10);
    L8:
        refreshCounter();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        super.clearFocus();
        this.etCounter.clearFocus();
    }

    public final void expandTouchHeight(int r10) {
        Resources r11 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r11, "Resources.getSystem()");
        k.d(this, MathKt.roundToInt(TypedValue.applyDimension(1, 32, r11.getDisplayMetrics())), r10, new View[]{this.addContainerView, this.etCounter, this.decContainerView});
        k.a(this.tvAdd, r10);
        k.a(this.tvDec, r10);
    }

    public final int getMaxValue() {
        return this.mMaxValue;
    }

    public final int getMinValue() {
        return this.mMinValue;
    }

    public final b getOnValueChangeListener() {
        return this.onValueChangeListener;
    }

    public final int getValue() {
        return this.mValue;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
    }

    @Override // com.obric.oui.layout.OUIConstraintLayout, androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    protected void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
    }

    public final void setMaxValue(int r10) {
        setMMaxValue(r10);
        setMValue(Math.min(r10, this.mValue));
    }

    public final void setMinValue(int r10) {
        setMMinValue(r10);
        setMValue(Math.max(r10, this.mValue));
    }

    public final void setOnValueChangeListener(b r10) {
        this.onValueChangeListener = r10;
    }

    public final void setStepValue(int r10) {
        if (this.mStepValue <= 0) goto L7;
        setMStepValue(r10);
        return;
    L7:
        throw new IllegalArgumentException("step value should be a positive integer");
    }

    public final void setValue(int r10) {
        if (r10 < this.mMinValue) goto L9;
        if (r10 > this.mMaxValue) goto L9;
        setMValue(r10);
        return;
    L9:
        throw new IllegalArgumentException(r10 + " is not in [" + this.mMinValue + ", " + this.mMaxValue + "].");
    }
}
