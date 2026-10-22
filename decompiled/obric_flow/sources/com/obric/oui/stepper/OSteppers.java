package com.obric.oui.stepper;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.inputmethod.a;
import com.bytedance.ies.xelement.input.f;
import com.lynx.tasm.utils.g;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$dimen;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$styleable;
import com.obric.oui.button.OButton;
import com.obric.oui.layout.OUIConstraintLayout;
import fs.b;
import fs.c;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001!B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\nJ\u0015\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u0010\u0010\u000eJ\r\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\nJ\u0015\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u0012\u0010\u000eJ\u0015\u0010\u0013\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u0013\u0010\u000eR$\u0010\u0017\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b8\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u000eR$\u0010\u001a\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b8\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u000eR$\u0010\u001d\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b8\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b\u001b\u0010\u0015\"\u0004\b\u001c\u0010\u000eR$\u0010 \u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b8\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b\u001e\u0010\u0015\"\u0004\b\u001f\u0010\u000eR$\u0010\"\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006("}, d2 = {"Lcom/obric/oui/stepper/OSteppers;", "Lcom/obric/oui/layout/OUIConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "getValue", "()I", "value", "", "setValue", "(I)V", "getMinValue", "setMinValue", "getMaxValue", "setMaxValue", "setStepValue", "s", "I", "setMValue", "mValue", "t", "setMMinValue", "mMinValue", "u", "setMMaxValue", "mMaxValue", "v", "setMStepValue", "mStepValue", "Lfs/c;", "onValueChangeListener", "Lfs/c;", "getOnValueChangeListener", "()Lfs/c;", "setOnValueChangeListener", "(Lfs/c;)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OSteppers extends OUIConstraintLayout {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ int f14557w = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final OButton f14558n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final OButton f14559o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final EditText f14560p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ViewGroup f14561q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final ViewGroup f14562r;
    public int s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f14563t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f14564u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f14565v;

    @JvmOverloads
    public OSteppers(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, null);
    }

    public static void e(OSteppers r5) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        int r10 = r5.s + r5.f14565v;
        if (r10 >= r5.f14563t) goto L5;
        return;
    L5:
        if (r10 > r5.f14564u) goto L10;
        r5.setMValue(r10);
        r5.f14560p.clearFocus();
        g.p(3, r5.getContext());
        return;
    }

    public static void n(OSteppers r5) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        int r10 = r5.s - r5.f14565v;
        if (r10 >= r5.f14563t) goto L5;
        return;
    L5:
        if (r10 > r5.f14564u) goto L10;
        r5.setMValue(r10);
        r5.f14560p.clearFocus();
        g.p(3, r5.getContext());
        return;
    }

    public static final /* synthetic */ void o(OSteppers r5, int r10) {
        r5.setMValue(r10);
    }

    private final void setMMaxValue(int r5) {
        this.f14564u = r5;
        r();
        q();
    }

    private final void setMMinValue(int r5) {
        this.f14563t = r5;
        r();
        q();
    }

    private final void setMStepValue(int r5) {
        this.f14565v = r5;
        q();
    }

    private final void setMValue(int r5) {
        if (this.s != r5) goto L5;
        return;
    L5:
        this.s = r5;
        q();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void clearFocus() {
        super.clearFocus();
        this.f14560p.clearFocus();
    }

    public final int getMaxValue() {
        return this.f14564u;
    }

    public final int getMinValue() {
        return this.f14563t;
    }

    public final c getOnValueChangeListener() {
        return null;
    }

    public final int getValue() {
        return this.s;
    }

    public final void p() {
        boolean r5 = false;
        if (getValue() >= this.f14564u) goto L5;
        boolean r10 = true;
    L6:
        OButton r11 = this.f14558n;
        r11.setEnabled(r10);
        if (getValue() >= this.f14564u) goto L9;
        boolean r12 = true;
    L10:
        r11.setClickable(r12);
        if (getValue() <= this.f14563t) goto L13;
        boolean r13 = true;
    L14:
        OButton r14 = this.f14559o;
        r14.setEnabled(r13);
        if (getValue() <= this.f14563t) goto L17;
        r5 = true;
    L17:
        r14.setClickable(r5);
        return;
    L13:
        r13 = false;
        goto L14
    L9:
        r12 = false;
        goto L10
    L5:
        r10 = false;
        goto L6
    }

    public final void q() {
        String r5 = String.valueOf(this.s);
        TextView.BufferType r10 = TextView.BufferType.EDITABLE;
        this.f14560p.setText(r5, r10);
        p();
    }

    public final void r() {
        int r5 = this.f14563t;
        int r10 = this.f14564u;
        a r11 = new a(this, 11);
        fs.a r12 = new fs.a();
        r12.f17007a = r5;
        r12.f17008b = r10;
        r12.f17009c = r11;
        EditText r13 = this.f14560p;
        r13.setFilters(new fs.a[]{r12});
    }

    public final void setMaxValue(int r5) {
        setMMaxValue(r5);
        setMValue(Math.min(r5, this.s));
    }

    public final void setMinValue(int r5) {
        setMMinValue(r5);
        setMValue(Math.max(r5, this.s));
    }

    public final void setOnValueChangeListener(c r5) {
    }

    public final void setStepValue(int r5) {
        if (this.f14565v <= 0) goto L7;
        setMStepValue(r5);
        return;
    L7:
        throw new IllegalArgumentException("step value should be a positive integer");
    }

    public final void setValue(int r5) {
        if (r5 >= this.f14563t) goto L5;
    L8:
        StringBuilder r10 = new StringBuilder();
        r10.append(r5);
        r10.append(" is not in [");
        r10.append(this.f14563t);
        r10.append(", ");
        throw new IllegalArgumentException(androidx.constraintlayout.motion.widget.a.s(r10, this.f14564u, "]."));
    L5:
        if (r5 > this.f14564u) goto L8;
        setMValue(r5);
    }

    @JvmOverloads
    public OSteppers(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, 0, 12);
        this.f14564u = 100;
        this.f14565v = 1;
        setFocusable(true);
        setFocusableInTouchMode(true);
        setLayoutParams(new ConstraintLayout.LayoutParams(-1, -1));
        LayoutInflater.from(r10).inflate(R$layout.o_widget_steppers, this);
        OButton r5 = (OButton) findViewById(R$id.tv_add);
        this.f14558n = r5;
        OButton r12 = (OButton) findViewById(R$id.tv_dec);
        this.f14559o = r12;
        EditText r13 = (EditText) findViewById(R$id.et_counter);
        this.f14560p = r13;
        ViewGroup r14 = (ViewGroup) findViewById(R$id.increase_container);
        this.f14561q = r14;
        ViewGroup r15 = (ViewGroup) findViewById(R$id.decrease_container);
        this.f14562r = r15;
        TypedArray r16 = r10.obtainStyledAttributes(r11, R$styleable.OSteppers, 0, 0);
        setMValue(r16.getInt(R$styleable.OSteppers_oui_stepper_value, 0));
        setMMinValue(r16.getInt(R$styleable.OSteppers_oui_min_value, Integer.MIN_VALUE));
        setMMaxValue(r16.getInt(R$styleable.OSteppers_oui_max_value, Integer.MAX_VALUE));
        setMStepValue(r16.getInt(R$styleable.OSteppers_oui_step, 1));
        r16.recycle();
        int r17 = com.lynx.tasm.utils.a.B(4, this);
        setPadding(r17, r17, r17, r17);
        setRadius(r10.getResources().getDimensionPixelSize(R$dimen.oui_r_m2_rect));
        setBackgroundResource(R$color.oui_fill_sunken_variable);
        final int r18 = 0;
        r5.setOnClickListener(new b(this, r18));
        final int r19 = 1;
        r12.setOnClickListener(new b(this, r19));
        final int r110 = 2;
        r14.setOnClickListener(new b(this, r110));
        final int r111 = 3;
        r15.setOnClickListener(new b(this, r111));
        r13.addTextChangedListener(new f(this, 4));
        q();
    }
}
