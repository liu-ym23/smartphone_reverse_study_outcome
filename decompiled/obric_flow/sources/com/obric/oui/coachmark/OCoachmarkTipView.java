package com.obric.oui.coachmark;

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
import cn.nubia.neopush.commons.Constant;
import com.bytedance.ai.event.MessageIndication;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$styleable;
import com.obric.oui.button.OButton;
import com.obric.oui.button.OIconButton;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.text.OTextView;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ym.g;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001.B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000f\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0018\u0010\u0017J\u0015\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u0019¢\u0006\u0004\b\u001e\u0010\u001cJ\u0015\u0010 \u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u0019¢\u0006\u0004\b \u0010\u001cJ\u0015\u0010#\u001a\u00020\f2\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b%\u0010\u000eJ\u0017\u0010&\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b&\u0010\u000eJ\u0017\u0010(\u001a\u00020\f2\u0006\u0010'\u001a\u00020\u0006H\u0016¢\u0006\u0004\b(\u0010)J\u0015\u0010,\u001a\u00020\f2\u0006\u0010+\u001a\u00020*¢\u0006\u0004\b,\u0010-¨\u0006/"}, d2 = {"Lcom/obric/oui/coachmark/OCoachmarkTipView;", "Lcom/obric/oui/layout/OUILinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", MessageIndication.CONTENT_TYPE_TEXT, "", "setActionText", "(Ljava/lang/CharSequence;)V", "setDismissText", "Landroid/graphics/drawable/Drawable;", "drawable", "setIcon", "(Landroid/graphics/drawable/Drawable;)V", "Landroid/view/View$OnClickListener;", "listener", "setOnActionClickListener", "(Landroid/view/View$OnClickListener;)V", "setOnDismissClickListener", "", Constant.ClientMessageType.SHOW, "setShowIcon", "(Z)V", "closable", "setClosable", "singleLine", "setSingleLine", "Lcom/obric/oui/coachmark/OCoachmarkTipView$ActionType;", "type", "setActionType", "(Lcom/obric/oui/coachmark/OCoachmarkTipView$ActionType;)V", "setPrimaryButtonText", "setSecondaryButtonText", "color", "setBackgroundColor", "(I)V", "", "radius", "setCornerRadius", "(F)V", "ActionType", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OCoachmarkTipView extends OUILinearLayout {
    public Float A;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final View f12350h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ImageView f12351i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final OTextView f12352j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final OButton f12353k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final OIconButton f12354l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final View f12355m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final LinearLayout f12356n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ImageView f12357o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final View f12358p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final OTextView f12359q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final View f12360r;
    public final OButton s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final OButton f12361t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f12362u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f12363v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ActionType f12364w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f12365x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Integer f12366y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final boolean f12367z;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/obric/oui/coachmark/OCoachmarkTipView$ActionType;", "", "", "value", "I", "getValue", "()I", "Companion", "com/obric/oui/coachmark/a", "PRIMARY", "NEUTRAL", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum ActionType extends Enum<ActionType> {
        public static final a Companion = null;
        public static final ActionType NEUTRAL = null;
        public static final ActionType PRIMARY = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ActionType[] f12368a = null;
        private final int value;

        static {
            ActionType r5 = new ActionType("PRIMARY", 0, 0);
            PRIMARY = r5;
            ActionType r10 = new ActionType("NEUTRAL", 1, 1);
            NEUTRAL = r10;
            f12368a = new ActionType[]{r5, r10};
            Companion = new a();
        }

        public ActionType(String r5, int r10, int r11) {
            super(r5, r10);
            this.value = r11;
        }

        public static ActionType valueOf(String r5) {
            return (ActionType) Enum.valueOf(ActionType.class, r5);
        }

        public static ActionType[] values() {
            return (ActionType[]) f12368a.clone();
        }

        public final int getValue() {
            return this.value;
        }
    }

    @JvmOverloads
    public OCoachmarkTipView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    public final void e() {
        ActionType r5 = this.f12364w;
        int r10 = br.a.f977a[r5.ordinal()];
        if (r10 != 1) goto L5;
        int r11 = R$color.oui_accent_6_bg;
    L10:
        int r12 = getContext().getColor(r11);
        this.f12353k.setTextColor(r12);
        this.f12361t.setTextColor(r12);
        return;
    L5:
        if (r10 != 2) goto L8;
        r11 = R$color.oui_basic_text_1;
        goto L10
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public final void n() {
        Integer r5 = this.f12366y;
        if (r5 != null) goto L5;
        int r10 = getContext().getColor(R$color.oui_fill_element_2);
    L7:
        if (this.f12366y == null) goto L9;
    L11:
        Float r11 = this.A;
        if (r11 == null) goto L14;
        float r12 = r11.floatValue();
    L18:
        GradientDrawable r13 = new GradientDrawable();
        r13.setShape(0);
        r13.setColor(r10);
        r13.setCornerRadius(r12);
        setBackground(r13);
        return;
    L14:
        if (this.f12365x == true) goto L16;
        r12 = com.lynx.tasm.utils.a.E(20, this);
        goto L18
    L16:
        r12 = com.lynx.tasm.utils.a.E(28, this);
        goto L18
    L9:
        if (this.f12367z == false) goto L11;
        return;
    L5:
        r10 = r5.intValue();
        goto L7
    }

    public final void o() {
        boolean r5 = this.f12365x;
        boolean r10 = !r5;
        com.lynx.tasm.utils.d.x(this.f12350h, r5);
        com.lynx.tasm.utils.d.x(this.f12355m, r10);
        Pair r11 = TuplesKt.to(Boolean.valueOf(this.f12362u), Boolean.valueOf(r10));
        Boolean r12 = Boolean.TRUE;
        int r13 = 16;
        if (Intrinsics.areEqual(r11, TuplesKt.to(r12, r12)) == false) goto L6;
        int r14 = com.lynx.tasm.utils.a.B(16, this);
    L9:
        int r15 = 0;
        if (r5 == true) goto L12;
        setPaddingRelative(r14, com.lynx.tasm.utils.a.B(16, this), com.lynx.tasm.utils.a.B(16, this), com.lynx.tasm.utils.a.B(16, this));
        setMinimumHeight(0);
    L13:
        if (r5 == true) goto L15;
        int r16 = 48;
    L16:
        setGravity(r16);
        boolean r17 = this.f12365x;
        boolean r18 = true;
        if (this.f12362u == false) goto L20;
        if (r17 == false) goto L20;
        boolean r19 = true;
    L21:
        com.lynx.tasm.utils.d.x(this.f12351i, r19);
        OTextView r20 = this.f12352j;
        ViewGroup.LayoutParams r21 = r20.getLayoutParams();
        if (r21 == null) goto L100;
        ViewGroup.MarginLayoutParams r22 = (ViewGroup.MarginLayoutParams) r21;
        if (this.f12362u == false) goto L27;
        if (r17 == false) goto L27;
        int r23 = com.lynx.tasm.utils.a.B(8, this);
    L28:
        r22.setMarginStart(r23);
        r20.setLayoutParams(r22);
        if (this.f12365x == false) goto L42;
        OButton r24 = this.f12353k;
        CharSequence r25 = r24.getText();
        if (r25 != null) goto L34;
    L39:
        boolean r26 = false;
    L40:
        com.lynx.tasm.utils.d.x(r24, r26);
        com.lynx.tasm.utils.d.x(this.f12354l, this.f12363v);
        goto L42
    L34:
        if (StringsKt.isBlank(r25) == true) goto L39;
        if (this.f12363v == true) goto L39;
        r26 = true;
    L42:
        if (this.f12365x == true) goto L83;
        OButton r27 = this.s;
        CharSequence r28 = r27.getText();
        if (r28 != null) goto L47;
    L50:
        boolean r29 = true;
    L51:
        boolean r30 = !r29;
        OButton r110 = this.f12361t;
        CharSequence r111 = r110.getText();
        if (r111 != null) goto L54;
    L57:
        boolean r112 = true;
    L58:
        boolean r113 = !r112;
        if (r29 == false) goto L63;
        if (r112 == false) goto L63;
        r18 = false;
    L63:
        View r31 = this.f12360r;
        com.lynx.tasm.utils.d.x(r31, r18);
        ViewGroup.LayoutParams r114 = r31.getLayoutParams();
        if (r114 == null) goto L98;
        ViewGroup.MarginLayoutParams r115 = (ViewGroup.MarginLayoutParams) r114;
        if (r18 == false) goto L68;
        int r116 = com.lynx.tasm.utils.a.B(8, this);
    L69:
        r115.topMargin = r116;
        r31.setLayoutParams(r115);
        if (r18 == false) goto L72;
        r13 = 48;
    L72:
        LinearLayout r32 = this.f12356n;
        if (r32.getGravity() == r13) goto L75;
        r32.setGravity(r13);
    L75:
        com.lynx.tasm.utils.d.x(r27, r30);
        com.lynx.tasm.utils.d.x(r110, r113);
        ViewGroup.LayoutParams r33 = r110.getLayoutParams();
        if (r33 == null) goto L96;
        ViewGroup.MarginLayoutParams r34 = (ViewGroup.MarginLayoutParams) r33;
        if (r27.getVisibility() != 0) goto L80;
        int r35 = com.lynx.tasm.utils.a.B(12, this);
    L81:
        r34.setMarginStart(r35);
        r110.setLayoutParams(r34);
        goto L83
    L80:
        r35 = 0;
        goto L81
    L96:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L68:
        r116 = 0;
        goto L69
    L98:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L54:
        if (StringsKt.isBlank(r111) == true) goto L57;
        r112 = false;
        goto L58
    L47:
        if (StringsKt.isBlank(r28) == true) goto L50;
        r29 = false;
    L83:
        if (this.f12365x == true) goto L91;
        com.lynx.tasm.utils.d.x(this.f12357o, this.f12362u);
        View r36 = this.f12358p;
        ViewGroup.LayoutParams r37 = r36.getLayoutParams();
        if (r37 == null) goto L94;
        ViewGroup.MarginLayoutParams r38 = (ViewGroup.MarginLayoutParams) r37;
        if (this.f12362u == false) goto L90;
        r15 = com.lynx.tasm.utils.a.B(8, this);
    L90:
        r38.setMarginStart(r15);
        r36.setLayoutParams(r38);
        goto L91
    L94:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L91:
        e();
        return;
    L27:
        r23 = 0;
        goto L28
    L100:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L20:
        r19 = false;
        goto L21
    L15:
        r16 = 16;
        goto L16
    L12:
        setPaddingRelative(r14, com.lynx.tasm.utils.a.B(8, this), com.lynx.tasm.utils.a.B(8, this), com.lynx.tasm.utils.a.B(8, this));
        setMinimumHeight(com.lynx.tasm.utils.a.B(48, this));
        goto L13
    L6:
        if (Intrinsics.areEqual(r11, TuplesKt.to(r12, Boolean.FALSE)) == false) goto L8;
        r14 = com.lynx.tasm.utils.a.B(12, this);
        goto L9
    L8:
        r14 = com.lynx.tasm.utils.a.B(20, this);
        goto L9
    }

    public final void setActionText(CharSequence r5) {
        this.f12353k.setText(r5);
        this.f12361t.setText(r5);
        o();
    }

    public final void setActionType(ActionType r5) {
        Intrinsics.checkNotNullParameter(r5, "type");
        if (this.f12364w == r5) goto L6;
        this.f12364w = r5;
        e();
        return;
    }

    @Override // android.view.View
    public void setBackgroundColor(int r5) {
        this.f12366y = Integer.valueOf(r5);
        n();
    }

    public final void setClosable(boolean r5) {
        if (this.f12363v == r5) goto L6;
        this.f12363v = r5;
        o();
        return;
    }

    public final void setCornerRadius(float r5) {
        this.A = Float.valueOf(r5);
        n();
    }

    @JvmOverloads
    public final void setDescription(CharSequence r5) {
        this.f12352j.setText(r5);
        this.f12359q.setText(r5);
        if (r5 != null) goto L5;
    L6:
        g r10 = ps.a.f21388a;
        if (ps.a.d(8) == true) goto L10;
        ps.a.f21388a.i(8, "OCoachmarkTipView", "Description is empty.", null);
    L10:
        o();
        return;
    L5:
        if (StringsKt.isBlank(r5) == false) goto L10;
        goto L6
    }

    public final void setDismissText(CharSequence r5) {
        this.s.setText(r5);
        o();
    }

    public final void setIcon(Drawable r5) {
        this.f12351i.setImageDrawable(r5);
        this.f12357o.setImageDrawable(r5);
        o();
    }

    public final void setOnActionClickListener(View.OnClickListener r5) {
        this.f12353k.setOnClickListener(r5);
        this.f12361t.setOnClickListener(r5);
    }

    public final void setOnDismissClickListener(View.OnClickListener r5) {
        this.f12354l.setOnClickListener(r5);
        this.s.setOnClickListener(r5);
    }

    public final void setPrimaryButtonText(CharSequence r5) {
        this.f12353k.setText(r5);
        this.f12361t.setText(r5);
        o();
    }

    public final void setSecondaryButtonText(CharSequence r5) {
        this.s.setText(r5);
        o();
    }

    public final void setShowIcon(boolean r5) {
        if (this.f12362u == r5) goto L6;
        this.f12362u = r5;
        o();
        return;
    }

    public final void setSingleLine(boolean r5) {
        if (this.f12365x == r5) goto L6;
        this.f12365x = r5;
        n();
        o();
        return;
    }

    @JvmOverloads
    public OCoachmarkTipView(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ OCoachmarkTipView(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    @JvmOverloads
    public OCoachmarkTipView(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12, 8);
        this.f12362u = true;
        ActionType r5 = ActionType.PRIMARY;
        this.f12364w = r5;
        setOrientation(1);
        LayoutInflater.from(r10).inflate(R$layout.o_coachmark_tip, this, true);
        this.f12350h = findViewById(R$id.inline_container);
        this.f12351i = (ImageView) findViewById(R$id.iv_inline_icon);
        this.f12352j = (OTextView) findViewById(R$id.tv_inline_text);
        this.f12353k = (OButton) findViewById(R$id.btn_inline_action);
        this.f12354l = (OIconButton) findViewById(R$id.btn_inline_dismiss);
        this.f12355m = findViewById(R$id.multi_container);
        this.f12356n = (LinearLayout) findViewById(R$id.multi_leading_row);
        this.f12357o = (ImageView) findViewById(R$id.iv_multi_icon);
        this.f12358p = findViewById(R$id.multi_text_group);
        this.f12359q = (OTextView) findViewById(R$id.tv_desc);
        this.f12360r = findViewById(R$id.multi_actions);
        this.s = (OButton) findViewById(R$id.btn_multi_dismiss);
        this.f12361t = (OButton) findViewById(R$id.btn_multi_action);
        if (r11 != null) goto L5;
        n();
        o();
        return;
    L5:
        TypedArray r13 = getContext().obtainStyledAttributes(r11, R$styleable.OCoachmarkTip, r12, 0);
        this.f12362u = r13.getBoolean(R$styleable.OCoachmarkTip_oui_cmTipShowIcon, true);
        this.f12363v = r13.getBoolean(R$styleable.OCoachmarkTip_oui_cmTipClosable, false);
        this.f12365x = r13.getBoolean(R$styleable.OCoachmarkTip_oui_cmTipSingleLine, false);
        a r14 = ActionType.Companion;
        int r15 = r13.getInt(R$styleable.OCoachmarkTip_oui_cmTipActionType, r5.getValue());
        r14.getClass();
        ActionType[] r16 = ActionType.values();
        int r17 = r16.length;
        int r18 = 0;
    L6:
        if (r18 >= r17) goto L11;
        ActionType r19 = r16[r18];
        if (r19.getValue() == r15) goto L12;
        r18 = r18 + 1;
    L12:
        if (r19 != null) goto L14;
        r19 = ActionType.PRIMARY;
    L14:
        this.f12364w = r19;
        this.f12367z = r13.hasValue(R$styleable.OCoachmarkTip_android_background);
        CharSequence r20 = r13.getText(R$styleable.OCoachmarkTip_android_text);
        if (r20 == null) goto L18;
        this.f12352j.setText(r20);
        this.f12359q.setText(r20);
    L18:
        String r21 = r13.getString(R$styleable.OCoachmarkTip_oui_cmTipActionText);
        OButton r22 = this.f12353k;
        r22.setText(r21);
        OButton r23 = this.f12361t;
        r23.setText(r21);
        String r24 = r13.getString(R$styleable.OCoachmarkTip_oui_cmTipDismissText);
        OButton r25 = this.s;
        r25.setText(r24);
        Drawable r26 = r13.getDrawable(R$styleable.OCoachmarkTip_android_src);
        if (r26 == null) goto L22;
        this.f12351i.setImageDrawable(r26);
        this.f12357o.setImageDrawable(r26);
    L22:
        String r27 = r13.getString(R$styleable.OCoachmarkTip_oui_cmTipPrimaryButtonText);
        if (r27 == null) goto L26;
        r22.setText(r27);
        r23.setText(r27);
    L26:
        String r28 = r13.getString(R$styleable.OCoachmarkTip_oui_cmTipSecondaryButtonText);
        if (r28 == null) goto L31;
        r25.setText(r28);
    L31:
        if (r13.hasValue(R$styleable.OCoachmarkTip_oui_cmTipBackgroundColor) == false) goto L34;
        this.f12366y = Integer.valueOf(r13.getColor(R$styleable.OCoachmarkTip_oui_cmTipBackgroundColor, 0));
    L34:
        if (r13.hasValue(R$styleable.OCoachmarkTip_oui_cmTipCornerRadius) == false) goto L36;
        this.A = Float.valueOf(r13.getDimension(R$styleable.OCoachmarkTip_oui_cmTipCornerRadius, 0.0f));
    L36:
        r13.recycle();
        n();
        o();
        return;
    L11:
        r19 = null;
        goto L12
    }
}
