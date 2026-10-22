package com.obric.oui.stepper;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.plugin.R;
import com.obric.oui.button.OButton;
import com.obric.oui.common.util.f;
import com.obric.oui.common.util.h;
import com.obric.oui.common.util.o;
import com.obric.oui.layout.OUIConstraintLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0011\u0018\u0000 92\u00020\u0001:\u00029:B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020!H\u0016J\u0010\u0010#\u001a\u00020!2\b\b\u0002\u0010$\u001a\u00020\rJ\u0006\u0010%\u001a\u00020\rJ\u0006\u0010&\u001a\u00020\rJ\u0006\u0010'\u001a\u00020\rJ0\u0010(\u001a\u00020!2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\r2\u0006\u0010,\u001a\u00020\r2\u0006\u0010-\u001a\u00020\r2\u0006\u0010.\u001a\u00020\rH\u0014J\u0018\u0010/\u001a\u00020!2\u0006\u00100\u001a\u00020\r2\u0006\u00101\u001a\u00020\rH\u0014J\b\u00102\u001a\u00020!H\u0002J\b\u00103\u001a\u00020!H\u0002J\b\u00104\u001a\u00020!H\u0002J\u000e\u00105\u001a\u00020!2\u0006\u0010\f\u001a\u00020\rJ\u000e\u00106\u001a\u00020!2\u0006\u0010\f\u001a\u00020\rJ\u000e\u00107\u001a\u00020!2\u0006\u0010\f\u001a\u00020\rJ\u000e\u00108\u001a\u00020!2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0012\u0010\u0010R\u001e\u0010\u0013\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0014\u0010\u0010R\u001e\u0010\u0015\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0016\u0010\u0010R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/obric/oui/stepper/OSteppers;", "Lcom/obric/oui/layout/OUIConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "addContainerView", "Landroid/view/ViewGroup;", "decContainerView", "etCounter", "Landroid/widget/EditText;", EventBody.KEY_VALUE, "", "mMaxValue", "setMMaxValue", "(I)V", "mMinValue", "setMMinValue", "mStepValue", "setMStepValue", "mValue", "setMValue", "onValueChangeListener", "Lcom/obric/oui/stepper/OSteppers$OnValueChangeListener;", "getOnValueChangeListener", "()Lcom/obric/oui/stepper/OSteppers$OnValueChangeListener;", "setOnValueChangeListener", "(Lcom/obric/oui/stepper/OSteppers$OnValueChangeListener;)V", "tvAdd", "Lcom/obric/oui/button/OButton;", "tvDec", "checkCounter", "", "clearFocus", "expandTouchHeight", "touchableHeight", "getMaxValue", "getMinValue", "getValue", "onLayout", "changed", "", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "refreshCounter", "registerEvent", "registerInputFilter", "setMaxValue", "setMinValue", "setStepValue", "setValue", "Companion", "OnValueChangeListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
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

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/oui/stepper/OSteppers$Companion;", "", "()V", "NUMBER_SIZE", "", "STEP", "TEXT_STROKE_WIDTH", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H&J\b\u0010\u000b\u001a\u00020\u0003H\u0016¨\u0006\f"}, d2 = {"Lcom/obric/oui/stepper/OSteppers$OnValueChangeListener;", "", "onInputBeyondLimit", "", "input", "", "onTryToExceedMaximum", "onTryToExceedMinimum", "onValueChange", "oldValue", "newValue", "onValueEmpty", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface b {
        void a();

        void a(int r1);

        void a(int r1, int r2);

        void b();

        void c();
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, d2 = {"com/obric/oui/stepper/OSteppers$registerEvent$5", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", CommonConsts.APM_INNER_EVENT_COST_START, "", CommonConsts.COUNT_TYPE, "after", "onTextChanged", "before", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class c implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OSteppers f14498a;

        c(OSteppers r1) {
            this.f14498a = r1;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable r9) {
            Editable r10 = (Editable) ZeusTransformUtils.wrapperContextForParams(r9, Editable.class, "com.obric.memorydata.plugin");
            if (r10 != null) goto L5;
            String r0 = null;
        L6:
            CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin");
            int r2 = 0;
            if (r1 != null) goto L9;
        L12:
            boolean r3 = true;
        L13:
            if (r3 == false) goto L18;
            b r4 = this.f14498a.getOnValueChangeListener();
            if (r4 == null) goto L18;
            r4.a();
        L18:
            if (r10 != null) goto L32;
        L27:
            OSteppers.access$setMValue(this.f14498a, r2);     // Catch: Exception -> L29
        L30:
            OSteppers.access$checkCounter(this.f14498a);
            return;
        L29:
            f.a(f.f13501a, "OSteppers", "input type error", null, 4, null);
            goto L30
        L32:
            String r11 = r10.toString();     // Catch: Exception -> L29
            if (r11 == null) goto L27;
            Integer r12 = StringsKt.toIntOrNull(r11);     // Catch: Exception -> L29
            if (r12 == null) goto L27;
            r2 = r12.intValue();     // Catch: Exception -> L29
            goto L27
        L9:
            if (StringsKt.isBlank(r1) == true) goto L12;
            r3 = false;
            goto L13
        L5:
            r0 = r10.toString();
            goto L6
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
            CharSequence r0 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.memorydata.plugin");
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
            CharSequence r0 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.memorydata.plugin");
        }
    }

    static {
        Companion = new a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OSteppers(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        this(r4, null, 2, 0 == true ? 1 : 0);
    }

    public OSteppers(Context r10, AttributeSet r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r13 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "context");
        super(r12, r13, 0, null, 12, null);
        this.mMaxValue = 100;
        this.mStepValue = 1;
        setFocusable(true);
        setFocusableInTouchMode(true);
        setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new ConstraintLayout.LayoutParams(-1, -1), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        ZeusTransformUtils.inflate(LayoutInflater.from(r12), ZeusTransformUtils.mapRes(R.layout.o_widget_steppers, "layout", "o_widget_steppers"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        View r2 = findViewById(ZeusTransformUtils.mapRes(R.id.tv_add, OaidModel.KEY_ID, "tv_add"));
        Intrinsics.checkNotNullExpressionValue(r2, "findViewById(R.id.tv_add)");
        this.tvAdd = (OButton) ZeusTransformUtils.preCheckCast(r2, OButton.class, "com.obric.memorydata.plugin");
        View r3 = findViewById(ZeusTransformUtils.mapRes(R.id.tv_dec, OaidModel.KEY_ID, "tv_dec"));
        Intrinsics.checkNotNullExpressionValue(r3, "findViewById(R.id.tv_dec)");
        this.tvDec = (OButton) ZeusTransformUtils.preCheckCast(r3, OButton.class, "com.obric.memorydata.plugin");
        View r4 = findViewById(ZeusTransformUtils.mapRes(R.id.et_counter, OaidModel.KEY_ID, "et_counter"));
        Intrinsics.checkNotNullExpressionValue(r4, "findViewById(R.id.et_counter)");
        this.etCounter = (EditText) ZeusTransformUtils.preCheckCast(r4, EditText.class, "com.obric.memorydata.plugin");
        View r5 = findViewById(ZeusTransformUtils.mapRes(R.id.increase_container, OaidModel.KEY_ID, "increase_container"));
        Intrinsics.checkNotNullExpressionValue(r5, "findViewById(R.id.increase_container)");
        this.addContainerView = (ViewGroup) ZeusTransformUtils.preCheckCast(r5, ViewGroup.class, "com.obric.memorydata.plugin");
        View r6 = findViewById(ZeusTransformUtils.mapRes(R.id.decrease_container, OaidModel.KEY_ID, "decrease_container"));
        Intrinsics.checkNotNullExpressionValue(r6, "findViewById(R.id.decrease_container)");
        this.decContainerView = (ViewGroup) ZeusTransformUtils.preCheckCast(r6, ViewGroup.class, "com.obric.memorydata.plugin");
        TypedArray r14 = r12.obtainStyledAttributes(r13, R.styleable.OSteppers, 0, 0);
        setMValue(r14.getInt(ZeusTransformUtils.mapRes(R.styleable.OSteppers_oui_stepper_value, "styleable", "OSteppers_oui_stepper_value"), 0));
        setMMinValue(r14.getInt(ZeusTransformUtils.mapRes(R.styleable.OSteppers_oui_min_value, "styleable", "OSteppers_oui_min_value"), Integer.MIN_VALUE));
        setMMaxValue(r14.getInt(ZeusTransformUtils.mapRes(R.styleable.OSteppers_oui_max_value, "styleable", "OSteppers_oui_max_value"), Integer.MAX_VALUE));
        setMStepValue(r14.getInt(ZeusTransformUtils.mapRes(R.styleable.OSteppers_oui_step, "styleable", "OSteppers_oui_step"), 1));
        r14.recycle();
        View r15 = (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin");
        int r0 = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 4);
        r15.setPadding(r0, r0, r0, r0);
        setRadius(ZeusTransformUtils.getResources(r12, "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.oui_r_m2_rect, "dimen", "oui_r_m2_rect")));
        setBackgroundResource(ZeusTransformUtils.mapRes(R.color.oui_fill_sunken_variable, TypedValues.Custom.S_COLOR, "oui_fill_sunken_variable"));
        registerEvent();
        refreshCounter();
    }

    public /* synthetic */ OSteppers(Context r2, AttributeSet r3, int r4, DefaultConstructorMarker r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    public static final /* synthetic */ void access$checkCounter(OSteppers r0) {
        r0.checkCounter();
    }

    public static final /* synthetic */ void access$setMValue(OSteppers r0, int r1) {
        r0.setMValue(r1);
    }

    private final void checkCounter() {
        OButton r0 = this.tvAdd;
        boolean r3 = true;
        if (getValue() >= this.mMaxValue) goto L5;
        boolean r1 = true;
    L6:
        r0.setEnabled(r1);
        OButton r2 = this.tvAdd;
        if (getValue() >= this.mMaxValue) goto L9;
        boolean r4 = true;
    L10:
        r2.setClickable(r4);
        OButton r5 = this.tvDec;
        if (getValue() <= this.mMinValue) goto L13;
        boolean r6 = true;
    L14:
        r5.setEnabled(r6);
        OButton r7 = this.tvDec;
        if (getValue() > this.mMinValue) goto L18;
        r3 = false;
    L18:
        r7.setClickable(r3);
        return;
    L13:
        r6 = false;
        goto L14
    L9:
        r4 = false;
        goto L10
    L5:
        r1 = false;
        goto L6
    }

    public static /* synthetic */ void expandTouchHeight$default(OSteppers r0, int r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = h.a((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.memorydata.plugin"), 44);
    L5:
        r0.expandTouchHeight(r1);
    }

    public static /* synthetic */ void lambda$FEXxyf6GhKLyMIUXnSW6PuJorPU(OSteppers r0, View r1) {
        m1369registerEvent$lambda3(r0, r1);
    }

    public static /* synthetic */ void lambda$FZLArISMxlA3RPflFS1f3RjaPCc(OSteppers r0, View r1) {
        m1370registerEvent$lambda4(r0, r1);
    }

    public static /* synthetic */ void lambda$K73YMD5GyDx5Fpa6c5sCLw4_hcY(OSteppers r0, View r1) {
        m1367registerEvent$lambda1(r0, r1);
    }

    public static /* synthetic */ void lambda$M7JAdRJJbfomeono3J_gidzj3No(OSteppers r0, int r1) {
        m1371registerInputFilter$lambda5(r0, r1);
    }

    public static /* synthetic */ void lambda$XexZo2eSlDcJfGqQZfF2Xb1EWho(OSteppers r0, View r1) {
        m1368registerEvent$lambda2(r0, r1);
    }

    private final void refreshCounter() {
        this.etCounter.setText((CharSequence) ZeusTransformUtils.preCheckCast(String.valueOf(this.mValue), CharSequence.class, "com.obric.memorydata.plugin"), TextView.BufferType.EDITABLE);
        checkCounter();
    }

    private final void registerEvent() {
        this.tvAdd.setOnClickListener(new $$Lambda$OSteppers$K73YMD5GyDx5Fpa6c5sCLw4_hcY(this));
        this.tvDec.setOnClickListener(new $$Lambda$OSteppers$XexZo2eSlDcJfGqQZfF2Xb1EWho(this));
        this.addContainerView.setOnClickListener(new $$Lambda$OSteppers$FEXxyf6GhKLyMIUXnSW6PuJorPU(this));
        this.decContainerView.setOnClickListener(new $$Lambda$OSteppers$FZLArISMxlA3RPflFS1f3RjaPCc(this));
        this.etCounter.addTextChangedListener((TextWatcher) ZeusTransformUtils.preCheckCast(new c(this), TextWatcher.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: registerEvent$lambda-1, reason: not valid java name */
    private static final void m1367registerEvent$lambda1(OSteppers r1, View r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        int r3 = r1.mValue + r1.mStepValue;
        if (r3 >= r1.mMinValue) goto L5;
        return;
    L5:
        if (r3 > r1.mMaxValue) goto L10;
        r1.setMValue(r3);
        r1.etCounter.clearFocus();
        com.obric.oui.a.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r1.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), 3);
        return;
    }

    /* JADX INFO: renamed from: registerEvent$lambda-2, reason: not valid java name */
    private static final void m1368registerEvent$lambda2(OSteppers r1, View r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        int r3 = r1.mValue - r1.mStepValue;
        if (r3 >= r1.mMinValue) goto L5;
        return;
    L5:
        if (r3 > r1.mMaxValue) goto L10;
        r1.setMValue(r3);
        r1.etCounter.clearFocus();
        com.obric.oui.a.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r1.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), 3);
        return;
    }

    /* JADX INFO: renamed from: registerEvent$lambda-3, reason: not valid java name */
    private static final void m1369registerEvent$lambda3(OSteppers r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        b r2 = r0.onValueChangeListener;
        if (r2 == null) goto L7;
        r2.c();
        return;
    }

    /* JADX INFO: renamed from: registerEvent$lambda-4, reason: not valid java name */
    private static final void m1370registerEvent$lambda4(OSteppers r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        b r2 = r0.onValueChangeListener;
        if (r2 == null) goto L7;
        r2.b();
        return;
    }

    private final void registerInputFilter() {
        this.etCounter.setFilters((InputFilter[]) ZeusTransformUtils.preCheckCast(new com.obric.oui.stepper.a[]{new com.obric.oui.stepper.a(this.mMinValue, this.mMaxValue, new $$Lambda$OSteppers$M7JAdRJJbfomeono3J_gidzj3No(this))}, InputFilter[].class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: registerInputFilter$lambda-5, reason: not valid java name */
    private static final void m1371registerInputFilter$lambda5(OSteppers r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        b r3 = r1.onValueChangeListener;
        if (r3 == null) goto L7;
        r3.a(r2);
        return;
    }

    private final void setMMaxValue(int r1) {
        this.mMaxValue = r1;
        registerInputFilter();
        refreshCounter();
    }

    private final void setMMinValue(int r1) {
        this.mMinValue = r1;
        registerInputFilter();
        refreshCounter();
    }

    private final void setMStepValue(int r1) {
        this.mStepValue = r1;
        refreshCounter();
    }

    private final void setMValue(int r2) {
        if (this.mValue != r2) goto L5;
        return;
    L5:
        this.mValue = r2;
        b r0 = this.onValueChangeListener;
        if (r0 == null) goto L9;
        r0.a(r2, r2);
    L9:
        refreshCounter();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        super.clearFocus();
        this.etCounter.clearFocus();
    }

    public final void expandTouchHeight(int r7) {
        o.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 32), r7, new View[]{(View) ZeusTransformUtils.preCheckCast(this.addContainerView, View.class, "com.obric.memorydata.plugin"), (View) ZeusTransformUtils.preCheckCast(this.etCounter, View.class, "com.obric.memorydata.plugin"), (View) ZeusTransformUtils.preCheckCast(this.decContainerView, View.class, "com.obric.memorydata.plugin")});
        o.a((View) ZeusTransformUtils.preCheckCast(this.tvAdd, View.class, "com.obric.memorydata.plugin"), r7);
        o.a((View) ZeusTransformUtils.preCheckCast(this.tvDec, View.class, "com.obric.memorydata.plugin"), r7);
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
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    @Override // com.obric.oui.layout.OUIConstraintLayout, androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    public final void setMaxValue(int r2) {
        setMMaxValue(r2);
        setMValue(Math.min(r2, this.mValue));
    }

    public final void setMinValue(int r2) {
        setMMinValue(r2);
        setMValue(Math.max(r2, this.mValue));
    }

    public final void setOnValueChangeListener(b r3) {
        this.onValueChangeListener = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
    }

    public final void setStepValue(int r2) {
        if (this.mStepValue <= 0) goto L7;
        setMStepValue(r2);
        return;
    L7:
        throw new IllegalArgumentException("step value should be a positive integer");
    }

    public final void setValue(int r3) {
        if (r3 < this.mMinValue) goto L9;
        if (r3 > this.mMaxValue) goto L9;
        setMValue(r3);
        return;
    L9:
        throw new IllegalArgumentException(r3 + " is not in [" + this.mMinValue + ", " + this.mMaxValue + "].");
    }
}
