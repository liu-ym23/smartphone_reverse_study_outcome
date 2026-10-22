package com.obric.oui.coachmark;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.obric.oui.button.OButton;
import com.obric.oui.button.OIconButton;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.text.OTextView;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import pla.d;
import pla.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002'(B'\b\u0007\u0012\u0006\u0010!\u001a\u00020 \u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"\u0012\b\b\u0002\u0010$\u001a\u00020\u001a¢\u0006\u0004\b%\u0010&J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u0010\u0010\r\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u000eJ\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000eJ\u000e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015J\u0010\u0010\u0018\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0019\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u000e\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001d¨\u0006)"}, d2 = {"Lcom/obric/oui/coachmark/OCoachmarkTipView;", "Lcom/obric/oui/layout/OUILinearLayout;", "", "text", "", "setActionText", "setDismissText", "Landroid/graphics/drawable/Drawable;", "drawable", "setIcon", "Landroid/view/View$OnClickListener;", "listener", "setOnActionClickListener", "setOnDismissClickListener", "", "show", "setShowIcon", "closable", "setClosable", "singleLine", "setSingleLine", "Lcom/obric/oui/coachmark/OCoachmarkTipView$ActionType;", "type", "setActionType", "setPrimaryButtonText", "setSecondaryButtonText", "", "color", "setBackgroundColor", "", "radius", "setCornerRadius", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ActionType", "a", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OCoachmarkTipView extends OUILinearLayout {
    public Float A;
    public final View h;
    public final ImageView i;
    public final OTextView j;
    public final OButton k;
    public final OIconButton l;
    public final View m;
    public final LinearLayout n;
    public final ImageView o;
    public final View p;
    public final OTextView q;
    public final View r;
    public final OButton s;
    public final OButton t;
    public boolean u;
    public boolean v;
    public ActionType w;
    public boolean x;
    public Integer y;
    public boolean z;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/obric/oui/coachmark/OCoachmarkTipView$ActionType;", "", "", "value", "I", "getValue", "()I", "Companion", "a", "PRIMARY", "NEUTRAL", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
    public static final enum ActionType extends Enum<ActionType> {
        public static final a Companion = null;
        public static final ActionType NEUTRAL = null;
        public static final ActionType PRIMARY = null;
        public static final /* synthetic */ ActionType[] a = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        public static ActionType valueOf(String r1) {
            return (ActionType) r27.a.a(ActionType.class, r1);
        }

        public static ActionType[] values() {
            return (ActionType[]) a.clone();
        }

        static {
            ActionType r0 = new ActionType("PRIMARY", 0, 0);
            PRIMARY = r0;
            ActionType r1 = new ActionType("NEUTRAL", 1, 1);
            NEUTRAL = r1;
            a = new ActionType[]{r0, r1};
            Companion = new a();
        }

        public final int getValue() {
            return this.value;
        }

        public ActionType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ActionType.values().length];
            r0[ActionType.PRIMARY.ordinal()] = 1;
            r0[ActionType.NEUTRAL.ordinal()] = 2;
            a = r0;
        }
    }

    static {
    }

    public OCoachmarkTipView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public OCoachmarkTipView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public /* bridge */ /* synthetic */ void setChangeAlphaWhenEnabledChanged(boolean r1) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c() {
        ActionType r0 = this.w;
        int r1 = b.a[r0.ordinal()];
        if (r1 != 1) goto L5;
        int r2 = 2131104006;
    L10:
        int r3 = getContext().getColor(r2);
        this.k.setTextColor(r3);
        this.t.setTextColor(r3);
        return;
    L5:
        if (r1 != 2) goto L8;
        r2 = 2131104350;
        goto L10
    L8:
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void d() {
        Integer r0 = this.y;
        if (r0 != null) goto L5;
        int r1 = getContext().getColor(2131104781);
    L7:
        if (this.y == null) goto L9;
    L11:
        Float r2 = this.A;
        if (r2 == null) goto L14;
        float r3 = r2.floatValue();
    L18:
        GradientDrawable r4 = new GradientDrawable();
        r4.setShape(0);
        r4.setColor(r1);
        r4.setCornerRadius(r3);
        setBackground(r4);
        return;
    L14:
        if ((!this.x) == false) goto L16;
        r3 = d.q(this, 20);
        goto L18
    L16:
        r3 = d.q(this, 28);
        goto L18
    L9:
        if (this.z == false) goto L11;
        return;
    L5:
        r1 = r0.intValue();
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e() {
        boolean r0 = !this.x;
        j.h(this.h, !r0);
        j.h(this.m, r0);
        Pair r2 = TuplesKt.to(Boolean.valueOf(this.u), Boolean.valueOf(r0));
        Boolean r3 = Boolean.TRUE;
        int r6 = 16;
        if (Intrinsics.areEqual(r2, TuplesKt.to(r3, r3)) == false) goto L6;
        int r4 = d.n(this, 16);
    L9:
        int r7 = 0;
        if (r0 == false) goto L12;
        setPaddingRelative(r4, d.n(this, 16), d.n(this, 16), d.n(this, 16));
        setMinimumHeight(0);
    L13:
        if (r0 == false) goto L15;
        int r1 = 48;
    L16:
        setGravity(r1);
        boolean r5 = !this.x;
        ImageView r8 = this.i;
        if (this.u == false) goto L20;
        if (r5 == true) goto L20;
        boolean r9 = true;
    L21:
        j.h(r8, r9);
        OTextView r10 = this.j;
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        if (r11 == null) goto L105;
        ViewGroup.MarginLayoutParams r12 = (ViewGroup.MarginLayoutParams) r11;
        if (this.u == false) goto L27;
        if (r5 == true) goto L27;
        int r13 = d.n(this, 8);
    L28:
        r12.setMarginStart(r13);
        r10.setLayoutParams(r12);
        if ((!this.x) == true) goto L46;
        CharSequence r14 = this.k.getText();
        if (r14 != null) goto L34;
    L37:
        boolean r15 = true;
    L38:
        boolean r16 = !r15;
        OButton r17 = this.k;
        if (r16 == true) goto L41;
    L43:
        boolean r18 = false;
    L44:
        j.h(r17, r18);
        j.h(this.l, this.v);
        goto L46
    L41:
        if (this.v == true) goto L43;
        r18 = true;
        goto L44
    L34:
        if (StringsKt.isBlank(r14) == true) goto L37;
        r15 = false;
    L46:
        if ((!this.x) == false) goto L88;
        CharSequence r19 = this.s.getText();
        if (r19 != null) goto L51;
    L54:
        boolean r20 = true;
    L55:
        boolean r21 = !r20;
        CharSequence r22 = this.t.getText();
        if (r22 != null) goto L58;
    L61:
        boolean r23 = true;
    L62:
        boolean r24 = !r23;
        if (r21 == true) goto L67;
        if (r24 == true) goto L67;
        boolean r25 = false;
    L68:
        j.h(this.r, r25);
        View r110 = this.r;
        ViewGroup.LayoutParams r111 = r110.getLayoutParams();
        if (r111 == null) goto L103;
        ViewGroup.MarginLayoutParams r112 = (ViewGroup.MarginLayoutParams) r111;
        if (r25 == false) goto L73;
        int r113 = d.n(this, 8);
    L74:
        r112.topMargin = r113;
        r110.setLayoutParams(r112);
        if (r25 == false) goto L78;
        r6 = 48;
    L78:
        if (this.n.getGravity() == r6) goto L80;
        this.n.setGravity(r6);
    L80:
        j.h(this.s, r21);
        j.h(this.t, r24);
        OButton r26 = this.t;
        ViewGroup.LayoutParams r27 = r26.getLayoutParams();
        if (r27 == null) goto L101;
        ViewGroup.MarginLayoutParams r28 = (ViewGroup.MarginLayoutParams) r27;
        if (this.s.getVisibility() != 0) goto L85;
        int r29 = d.n(this, 12);
    L86:
        r28.setMarginStart(r29);
        r26.setLayoutParams(r28);
        goto L88
    L85:
        r29 = 0;
        goto L86
    L101:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L73:
        r113 = 0;
        goto L74
    L103:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L67:
        r25 = true;
        goto L68
    L58:
        if (StringsKt.isBlank(r22) == true) goto L61;
        r23 = false;
        goto L62
    L51:
        if (StringsKt.isBlank(r19) == true) goto L54;
        r20 = false;
    L88:
        if ((!this.x) == false) goto L96;
        j.h(this.o, this.u);
        View r30 = this.p;
        ViewGroup.LayoutParams r31 = r30.getLayoutParams();
        if (r31 == null) goto L99;
        ViewGroup.MarginLayoutParams r32 = (ViewGroup.MarginLayoutParams) r31;
        if (this.u == false) goto L95;
        r7 = d.n(this, 8);
    L95:
        r32.setMarginStart(r7);
        r30.setLayoutParams(r32);
        goto L96
    L99:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L96:
        c();
        return;
    L27:
        r13 = 0;
        goto L28
    L105:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L20:
        r9 = false;
        goto L21
    L15:
        r1 = 16;
        goto L16
    L12:
        setPaddingRelative(r4, d.n(this, 8), d.n(this, 8), d.n(this, 8));
        setMinimumHeight(d.n(this, 48));
        goto L13
    L6:
        if (Intrinsics.areEqual(r2, TuplesKt.to(r3, Boolean.FALSE)) == false) goto L8;
        r4 = d.n(this, 12);
        goto L9
    L8:
        r4 = d.n(this, 20);
        goto L9
    }

    public final void setActionText(CharSequence r2) {
        this.k.setText(r2);
        this.t.setText(r2);
        e();
    }

    public final void setActionType(ActionType r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        if (this.w == r2) goto L6;
        this.w = r2;
        c();
        return;
    }

    public void setBackgroundColor(int r1) {
        this.y = Integer.valueOf(r1);
        d();
    }

    public final void setClosable(boolean r2) {
        if (this.v == r2) goto L6;
        this.v = r2;
        e();
        return;
    }

    public final void setCornerRadius(float r1) {
        this.A = Float.valueOf(r1);
        d();
    }

    public final void setDescription(CharSequence r3) {
        this.j.setText(r3);
        this.q.setText(r3);
        if (r3 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == false) goto L14;
        wma.a r5 = wma.b.a;
        if (wma.b.e(8) == true) goto L14;
        wma.b.a.a("OCoachmarkTipView", "Description is empty.");
    L14:
        e();
        return;
    L5:
        if (StringsKt.isBlank(r3) == true) goto L8;
        r4 = false;
        goto L9
    }

    public final void setDismissText(CharSequence r2) {
        this.s.setText(r2);
        e();
    }

    public final void setIcon(Drawable r2) {
        this.i.setImageDrawable(r2);
        this.o.setImageDrawable(r2);
        e();
    }

    public final void setOnActionClickListener(View.OnClickListener r2) {
        this.k.setOnClickListener(r2);
        this.t.setOnClickListener(r2);
    }

    public final void setOnDismissClickListener(View.OnClickListener r2) {
        this.l.setOnClickListener(r2);
        this.s.setOnClickListener(r2);
    }

    public final void setPrimaryButtonText(CharSequence r2) {
        this.k.setText(r2);
        this.t.setText(r2);
        e();
    }

    public final void setSecondaryButtonText(CharSequence r2) {
        this.s.setText(r2);
        e();
    }

    public final void setShowIcon(boolean r2) {
        if (this.u == r2) goto L6;
        this.u = r2;
        e();
        return;
    }

    public final void setSingleLine(boolean r2) {
        if (this.x == r2) goto L6;
        this.x = r2;
        d();
        e();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OCoachmarkTipView(Context r8, AttributeSet r9, int r10) {
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8, r9, r10, 8);
        this.u = true;
        ActionType r2 = ActionType.PRIMARY;
        this.w = r2;
        setOrientation(1);
        LayoutInflater.from(r8).inflate(2131563761, this, true);
        this.h = findViewById(2131375303);
        this.i = (ImageView) findViewById(2131376317);
        this.j = findViewById(2131390782);
        this.k = (OButton) findViewById(2131364743);
        this.l = (OIconButton) findViewById(2131364744);
        this.m = findViewById(2131380431);
        this.n = (LinearLayout) findViewById(2131380432);
        this.o = (ImageView) findViewById(2131376420);
        this.p = findViewById(2131380456);
        this.q = findViewById(2131390479);
        this.r = findViewById(2131380418);
        this.s = (OButton) findViewById(2131364770);
        this.t = (OButton) findViewById(2131364769);
        if (r9 != null) goto L5;
        d();
        e();
        return;
    L5:
        TypedArray r11 = getContext().obtainStyledAttributes(r9, new int[]{R.attr.background, R.attr.src, R.attr.text, 2130973093, 2130973094, 2130973095, 2130973096, 2130973097, 2130973098, 2130973099, 2130973100, 2130973101, 2130973102}, r10, 0);
        this.u = r11.getBoolean(11, true);
        this.v = r11.getBoolean(6, false);
        this.x = r11.getBoolean(12, false);
        ActionType.a r12 = ActionType.Companion;
        int r13 = r11.getInt(4, r2.getValue());
        r12.getClass();
        ActionType[] r14 = ActionType.values();
        int r3 = r14.length;
        int r4 = 0;
    L6:
        if (r4 >= r3) goto L14;
        ActionType r5 = r14[r4];
        if (r5.getValue() != r13) goto L10;
        boolean r6 = true;
    L11:
        if (r6 == true) goto L15;
        r4 = r4 + 1;
    L15:
        if (r5 != null) goto L17;
        r5 = ActionType.PRIMARY;
    L17:
        this.w = r5;
        this.z = r11.hasValue(0);
        CharSequence r15 = r11.getText(2);
        if (r15 == null) goto L21;
        this.j.setText(r15);
        this.q.setText(r15);
    L21:
        String r16 = r11.getString(3);
        this.k.setText(r16);
        this.t.setText(r16);
        String r17 = r11.getString(8);
        this.s.setText(r17);
        Drawable r18 = r11.getDrawable(1);
        if (r18 == null) goto L25;
        this.i.setImageDrawable(r18);
        this.o.setImageDrawable(r18);
    L25:
        String r19 = r11.getString(9);
        if (r19 == null) goto L29;
        this.k.setText(r19);
        this.t.setText(r19);
    L29:
        String r20 = r11.getString(10);
        if (r20 == null) goto L34;
        this.s.setText(r20);
    L34:
        if (r11.hasValue(5) == false) goto L37;
        this.y = Integer.valueOf(r11.getColor(5, 0));
    L37:
        if (r11.hasValue(7) == false) goto L39;
        this.A = Float.valueOf(r11.getDimension(7, 0.0f));
    L39:
        r11.recycle();
        d();
        e();
        return;
    L10:
        r6 = false;
        goto L11
    L14:
        r5 = null;
        goto L15
    }

    public /* synthetic */ OCoachmarkTipView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
