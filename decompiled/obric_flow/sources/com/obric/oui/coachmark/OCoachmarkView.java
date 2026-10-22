package com.obric.oui.coachmark;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.annotation.StyleRes;
import androidx.core.widget.TextViewCompat;
import com.bytedance.ai.event.MessageIndication;
import com.lynx.tasm.utils.j;
import com.obric.common.oui.R$attr;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$drawable;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$string;
import com.obric.common.oui.R$style;
import com.obric.common.oui.R$styleable;
import com.obric.oui.button.OButton;
import com.obric.oui.button.OIconButton;
import com.obric.oui.common.style.i;
import com.obric.oui.common.style.k;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.n;
import com.obric.oui.text.OTextView;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ym.g;
import ym.h;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001:\u0003BCDJ\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\u0006J\u0015\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0012\u0010\u0011J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u001a\u001a\u00020\u00042\b\b\u0001\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u00042\b\b\u0001\u0010\u001c\u001a\u00020\u0018¢\u0006\u0004\b\u001d\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u00042\b\b\u0001\u0010\u001c\u001a\u00020\u0018¢\u0006\u0004\b\u001e\u0010\u001bJ\u0015\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u0018¢\u0006\u0004\b \u0010\u001bJ\u0015\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0018¢\u0006\u0004\b\"\u0010\u001bJ\u0017\u0010#\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b#\u0010\u0006J\u0017\u0010$\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b$\u0010\u0006J\u0017\u0010%\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b%\u0010\u0006J\u0015\u0010'\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020&¢\u0006\u0004\b'\u0010(J\u0017\u0010+\u001a\u00020\u00042\b\u0010*\u001a\u0004\u0018\u00010)¢\u0006\u0004\b+\u0010,J\u0017\u0010-\u001a\u00020\u00042\b\u0010*\u001a\u0004\u0018\u00010)¢\u0006\u0004\b-\u0010,J\u0017\u0010.\u001a\u00020\u00042\b\u0010*\u001a\u0004\u0018\u00010)¢\u0006\u0004\b.\u0010,J\u0015\u00101\u001a\u00020\u00042\u0006\u00100\u001a\u00020/¢\u0006\u0004\b1\u00102J\u0015\u00105\u001a\u00020\u00042\u0006\u00104\u001a\u000203¢\u0006\u0004\b5\u00106J\u0015\u00108\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u0018¢\u0006\u0004\b8\u0010\u001bJ\u0017\u00109\u001a\u00020\u00042\b\u0010*\u001a\u0004\u0018\u00010)¢\u0006\u0004\b9\u0010,J\u0015\u0010:\u001a\u00020\u00042\u0006\u00100\u001a\u00020/¢\u0006\u0004\b:\u00102J\u0015\u0010;\u001a\u00020\u00042\u0006\u00100\u001a\u00020/¢\u0006\u0004\b;\u00102R*\u0010?\u001a\u00020/2\u0006\u0010<\u001a\u00020/8F@FX\u0086\u000e¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u00102¨\u0006E"}, d2 = {"Lcom/obric/oui/coachmark/OCoachmarkView;", "Lcom/obric/oui/layout/OUIFrameLayout;", "", MessageIndication.CONTENT_TYPE_TEXT, "", "setText", "(Ljava/lang/CharSequence;)V", "getText", "()Ljava/lang/CharSequence;", "setTitle", "Lcom/obric/oui/coachmark/OCoachmarkView$ContentStyle;", "style", "setContentStyle", "(Lcom/obric/oui/coachmark/OCoachmarkView$ContentStyle;)V", "Landroid/graphics/drawable/Drawable;", "drawable", "setIcon", "(Landroid/graphics/drawable/Drawable;)V", "setHeroImage", "Landroid/view/View;", "view", "setCustomContentView$OUI_standardRelease", "(Landroid/view/View;)V", "setCustomContentView", "", "color", "setBackgroundColor", "(I)V", "resId", "setTitleTextAppearance", "setDescTextAppearance", "widthPx", "setMaxWidth", "paddingPx", "setContentPadding", "setActionText", "setPrimaryButtonText", "setSecondaryButtonText", "Lcom/obric/oui/coachmark/OCoachmarkView$ActionStyle;", "setActionStyle", "(Lcom/obric/oui/coachmark/OCoachmarkView$ActionStyle;)V", "Landroid/view/View$OnClickListener;", "listener", "setOnActionClickListener", "(Landroid/view/View$OnClickListener;)V", "setOnPrimaryActionClickListener", "setOnSecondaryActionClickListener", "", "visible", "setArrowVisible", "(Z)V", "Lcom/obric/oui/coachmark/OCoachmarkView$ArrowPosition;", "position", "setArrowPosition", "(Lcom/obric/oui/coachmark/OCoachmarkView$ArrowPosition;)V", "offsetPx", "setArrowOffset", "setOnCloseClickListener", "setShowCloseIcon", "setCloseVisible", "value", "i0", "Z", "isPopWindowMode", "()Z", "setPopWindowMode", "ActionStyle", "ArrowPosition", "ContentStyle", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OCoachmarkView extends OUIFrameLayout {
    public boolean A;
    public int B;
    public CharSequence C;
    public CharSequence D;
    public CharSequence E;
    public CharSequence F;
    public Drawable G;
    public Drawable H;
    public View I;
    public View.OnClickListener J;
    public View.OnClickListener K;
    public int L;
    public int M;
    public int N;
    public ColorStateList O;
    public ColorStateList P;
    public ColorStateList Q;
    public ColorStateList R;
    public ColorStateList S;
    public Integer T;
    public Integer U;
    public Integer V;
    public Integer W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public int f12369a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public int f12370b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public int f12371c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public int f12372d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public int f12373e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public boolean f12374f0;
    public boolean g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final OUIFrameLayout f12375h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public com.obric.oui.material.c[] f12376h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ImageView f12377i;
    public boolean i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final View f12378j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ImageView f12379k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ViewGroup f12380l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final OUIFrameLayout f12381m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ImageView f12382n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final OTextView f12383o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final OTextView f12384p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final View f12385q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final View f12386r;
    public final OButton s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final OButton f12387t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final OButton f12388u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final OIconButton f12389v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ActionStyle f12390w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ArrowPosition f12391x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ContentStyle f12392y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f12393z;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/obric/oui/coachmark/OCoachmarkView$ActionStyle;", "", "", "value", "I", "getValue", "()I", "Companion", "com/obric/oui/coachmark/b", "NONE", "TEXT_ONLY", "FILLED_BUTTON", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum ActionStyle extends Enum<ActionStyle> {
        public static final b Companion = null;
        public static final ActionStyle FILLED_BUTTON = null;
        public static final ActionStyle NONE = null;
        public static final ActionStyle TEXT_ONLY = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ActionStyle[] f12394a = null;
        private final int value;

        static {
            ActionStyle r5 = new ActionStyle("NONE", 0, 0);
            NONE = r5;
            ActionStyle r10 = new ActionStyle("TEXT_ONLY", 1, 1);
            TEXT_ONLY = r10;
            ActionStyle r11 = new ActionStyle("FILLED_BUTTON", 2, 2);
            FILLED_BUTTON = r11;
            f12394a = new ActionStyle[]{r5, r10, r11};
            Companion = new b();
        }

        public ActionStyle(String r5, int r10, int r11) {
            super(r5, r10);
            this.value = r11;
        }

        public static ActionStyle valueOf(String r5) {
            return (ActionStyle) Enum.valueOf(ActionStyle.class, r5);
        }

        public static ActionStyle[] values() {
            return (ActionStyle[]) f12394a.clone();
        }

        public final int getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/obric/oui/coachmark/OCoachmarkView$ArrowPosition;", "", "", "value", "I", "getValue", "()I", "Companion", "com/obric/oui/coachmark/c", "TOP", "BOTTOM", "LEFT", "RIGHT", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum ArrowPosition extends Enum<ArrowPosition> {
        public static final ArrowPosition BOTTOM = null;
        public static final c Companion = null;
        public static final ArrowPosition LEFT = null;
        public static final ArrowPosition RIGHT = null;
        public static final ArrowPosition TOP = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ArrowPosition[] f12395a = null;
        private final int value;

        static {
            ArrowPosition r5 = new ArrowPosition("TOP", 0, 0);
            TOP = r5;
            ArrowPosition r10 = new ArrowPosition("BOTTOM", 1, 1);
            BOTTOM = r10;
            ArrowPosition r11 = new ArrowPosition("LEFT", 2, 2);
            LEFT = r11;
            ArrowPosition r12 = new ArrowPosition("RIGHT", 3, 3);
            RIGHT = r12;
            f12395a = new ArrowPosition[]{r5, r10, r11, r12};
            Companion = new c();
        }

        public ArrowPosition(String r5, int r10, int r11) {
            super(r5, r10);
            this.value = r11;
        }

        public static ArrowPosition valueOf(String r5) {
            return (ArrowPosition) Enum.valueOf(ArrowPosition.class, r5);
        }

        public static ArrowPosition[] values() {
            return (ArrowPosition[]) f12395a.clone();
        }

        public final int getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/obric/oui/coachmark/OCoachmarkView$ContentStyle;", "", "", "value", "I", "getValue", "()I", "Companion", "com/obric/oui/coachmark/d", "PILL", "CARD", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum ContentStyle extends Enum<ContentStyle> {
        public static final ContentStyle CARD = null;
        public static final d Companion = null;
        public static final ContentStyle PILL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ContentStyle[] f12396a = null;
        private final int value;

        static {
            ContentStyle r5 = new ContentStyle("PILL", 0, 0);
            PILL = r5;
            ContentStyle r10 = new ContentStyle("CARD", 1, 1);
            CARD = r10;
            f12396a = new ContentStyle[]{r5, r10};
            Companion = new d();
        }

        public ContentStyle(String r5, int r10, int r11) {
            super(r5, r10);
            this.value = r11;
        }

        public static ContentStyle valueOf(String r5) {
            return (ContentStyle) Enum.valueOf(ContentStyle.class, r5);
        }

        public static ContentStyle[] values() {
            return (ContentStyle[]) f12396a.clone();
        }

        public final int getValue() {
            return this.value;
        }
    }

    @JvmOverloads
    public OCoachmarkView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, null, 0, 14);
    }

    public final CharSequence getText() {
        CharSequence r5 = this.D;
        if (r5 == null) goto L5;
        return r5;
    L5:
        return this.f12384p.getText();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void n() {
        int r5 = br.b.f978a[this.f12392y.ordinal()];
        if (r5 == 1) goto L8;
        if (r5 != 2) goto L7;
        int r10 = com.lynx.tasm.utils.a.B(20, this);
    L9:
        OUIFrameLayout r11 = this.f12375h;
        r11.setShadowCornerRadius(r10);
        if (r11.f13532b.J == false) goto L13;
        r11.setRadius(r10);
    L13:
        if (this.g0 == false) goto L22;
        com.obric.oui.material.c[] r12 = this.f12376h0;
        if (r12 == null) goto L22;
        if (this.f12393z == false) goto L19;
        Intrinsics.checkNotNull(r12);
        com.obric.oui.material.c r13 = r12[0];
        Intrinsics.checkNotNullParameter(r11, "<this>");
        Intrinsics.checkNotNullParameter(r13, "material");
        a.a.C(r11, r13, false, 2);
        n.u(r11, 0.0f, 0);
        r11.setOuterNormalColor(0);
        r11.setBorderWidth(0);
    L20:
        GradientDrawable r14 = new GradientDrawable();
        r14.setShape(0);
        r14.setCornerRadius(r10);
        r14.setColor(0);
        r11.setBackground(r14);
    L24:
        int r15 = this.M;
        OTextView r16 = this.f12383o;
        if (r15 == 0) goto L27;
        TextViewCompat.setTextAppearance(r16, r15);
    L27:
        int r17 = this.N;
        OTextView r18 = this.f12384p;
        if (r17 == 0) goto L30;
        TextViewCompat.setTextAppearance(r18, r17);
    L30:
        ColorStateList r19 = this.O;
        if (r19 == null) goto L34;
        r16.setTextColor(r19);
    L34:
        ColorStateList r20 = this.P;
        if (r20 == null) goto L38;
        r18.setTextColor(r20);
    L38:
        this.f12382n.setImageTintList(this.Q);
        ColorStateList r21 = this.R;
        if (r21 == null) goto L42;
        this.f12389v.setImageTintList(r21);
    L42:
        Integer r22 = this.T;
        if (r22 == null) goto L46;
        this.s.setTextColor(r22.intValue());
    L46:
        Integer r23 = this.U;
        if (r23 == null) goto L50;
        this.f12387t.setTextColor(r23.intValue());
    L50:
        Integer r24 = this.V;
        OButton r25 = this.f12388u;
        if (r24 == null) goto L54;
        r25.setTextColor(r24.intValue());
    L54:
        Integer r26 = this.W;
        if (r26 == null) goto L59;
        int r27 = r26.intValue();
        r25.setBackgroundTintList(ColorStateList.valueOf(r27));
        r25.setOuterNormalColor(r27);
        return;
    L59:
        return;
    L19:
        Intrinsics.checkNotNull(r12);
        a.a.y(r11, r12, false, 0, 14);
    L22:
        if (this.L == 0) goto L24;
        GradientDrawable r28 = new GradientDrawable();
        r28.setCornerRadius(r10);
        r28.setColor(this.L);
        r11.setBackground(r28);
        r11.setOuterNormalColor(this.L);
        goto L24
    L7:
        throw new NoWhenBranchMatchedException();
    L8:
        r10 = com.lynx.tasm.utils.a.B(28, this);
        goto L9
    }

    public final void o(TypedArray r10) {
        if (r10.hasValue(R$styleable.OCoachmarkView_cmBackgroundColor) == false) goto L6;
        this.L = r10.getColor(R$styleable.OCoachmarkView_cmBackgroundColor, this.L);
    L21:
        if (r10.hasValue(R$styleable.OCoachmarkView_cmTitleTextColor) == false) goto L24;
        this.O = r10.getColorStateList(R$styleable.OCoachmarkView_cmTitleTextColor);
    L24:
        if (r10.hasValue(R$styleable.OCoachmarkView_cmDescTextColor) == false) goto L27;
        this.P = r10.getColorStateList(R$styleable.OCoachmarkView_cmDescTextColor);
    L27:
        if (r10.hasValue(R$styleable.OCoachmarkView_cmIconTint) == false) goto L30;
        this.Q = r10.getColorStateList(R$styleable.OCoachmarkView_cmIconTint);
    L30:
        if (r10.hasValue(R$styleable.OCoachmarkView_cmCloseIconTint) == false) goto L33;
        this.R = r10.getColorStateList(R$styleable.OCoachmarkView_cmCloseIconTint);
    L33:
        if (r10.hasValue(R$styleable.OCoachmarkView_cmArrowColor) == false) goto L36;
        this.S = r10.getColorStateList(R$styleable.OCoachmarkView_cmArrowColor);
    L36:
        if (r10.hasValue(R$styleable.OCoachmarkView_cmActionNeutralTextColor) == false) goto L39;
        this.T = Integer.valueOf(r10.getColor(R$styleable.OCoachmarkView_cmActionNeutralTextColor, 0));
    L39:
        if (r10.hasValue(R$styleable.OCoachmarkView_cmActionPrimaryTextColor) == false) goto L42;
        this.U = Integer.valueOf(r10.getColor(R$styleable.OCoachmarkView_cmActionPrimaryTextColor, 0));
    L42:
        if (r10.hasValue(R$styleable.OCoachmarkView_cmFilledActionTextColor) == false) goto L45;
        this.V = Integer.valueOf(r10.getColor(R$styleable.OCoachmarkView_cmFilledActionTextColor, 0));
    L45:
        if (r10.hasValue(R$styleable.OCoachmarkView_cmFilledActionBackgroundColor) == false) goto L48;
        this.W = Integer.valueOf(r10.getColor(R$styleable.OCoachmarkView_cmFilledActionBackgroundColor, 0));
    L48:
        if (r10.hasValue(R$styleable.OCoachmarkView_cmTitleTextAppearance) == false) goto L51;
        this.M = r10.getResourceId(R$styleable.OCoachmarkView_cmTitleTextAppearance, 0);
    L51:
        if (r10.hasValue(R$styleable.OCoachmarkView_cmDescTextAppearance) == false) goto L54;
        this.N = r10.getResourceId(R$styleable.OCoachmarkView_cmDescTextAppearance, 0);
    L54:
        if (this.g0 == false) goto L57;
        this.g0 = r10.getBoolean(R$styleable.OCoachmarkView_oui_widgetEnableMaterial, true);
    L57:
        if (this.g0 == false) goto L67;
        String r5 = r10.getString(R$styleable.OCoachmarkView_oui_widgetMaterial);
        if (r5 != null) goto L61;
        r5 = r10.getResources().getString(R$string.oui_material_bg_popup);
    L61:
        int r11 = this.L;
        if (r11 != 0) goto L64;
        boolean r12 = a.a.v(this);
    L65:
        this.f12376h0 = MaterialToken.parseSet(r5, !r12);
        return;
    L64:
        r12 = h.j(r11);
        goto L65
    L67:
        return;
    L6:
        if (r10.hasValue(R$styleable.OCoachmarkView_android_background) == false) goto L21;
        Drawable r13 = r10.getDrawable(R$styleable.OCoachmarkView_android_background);
        if ((r13 instanceof ColorDrawable) == false) goto L10;
        ColorDrawable r14 = (ColorDrawable) r13;
    L11:
        if (r14 != null) goto L13;
        Integer r15 = null;
    L14:
        if (r15 == null) goto L16;
        this.L = r15.intValue();
        goto L21
    L16:
        g r16 = ps.a.f21388a;
        if (ps.a.d(8) == true) goto L21;
        ps.a.f21388a.i(8, "OCoachmarkView", "android:background is not a color; ignored. Use cmBackgroundColor for color.", null);
        goto L21
    L13:
        r15 = Integer.valueOf(r14.getColor());
        goto L14
    L10:
        r14 = null;
        goto L11
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        View r5 = this.I;
        if (r5 == null) goto L9;
        ViewParent r10 = r5.getParent();
        ViewGroup r11 = this.f12380l;
        if (r10 != r11) goto L8;
        r11.removeView(r5);
    L8:
        this.I = null;
    L9:
        super.onDetachedFromWindow();
    }

    public final void p() {
        if (this.f12374f0 == false) goto L5;
        return;
    L5:
        boolean r5 = true;
        if (this.I == null) goto L14;
        int r10 = br.b.f978a[this.f12392y.ordinal()];
        if (r10 == 1) goto L12;
        if (r10 != 2) goto L46;
        int r11 = com.lynx.tasm.utils.a.B(20, this);
        int r12 = com.lynx.tasm.utils.a.B(16, this);
        this.f12370b0 = r11;
        this.f12371c0 = r12;
        this.f12372d0 = r11;
        this.f12373e0 = r12;
        return;
    L46:
        return;
    L12:
        int r13 = com.lynx.tasm.utils.a.B(20, this);
        int r14 = com.lynx.tasm.utils.a.B(8, this);
        this.f12370b0 = r13;
        this.f12371c0 = r14;
        this.f12372d0 = r13;
        this.f12373e0 = r14;
        return;
    L14:
        int r15 = br.b.f978a[this.f12392y.ordinal()];
        int r16 = 0;
        if (r15 == 1) goto L39;
        if (r15 == 2) goto L19;
        return;
    L19:
        if (this.f12390w != ActionStyle.NONE) goto L21;
    L26:
        r5 = false;
    L28:
        if (this.G != null) goto L30;
    L33:
        int r17 = com.lynx.tasm.utils.a.B(20, this);
    L34:
        this.f12370b0 = r17;
        this.f12371c0 = com.lynx.tasm.utils.a.B(16, this);
        if (r5 == false) goto L37;
        int r18 = com.lynx.tasm.utils.a.B(16, this);
    L38:
        this.f12372d0 = r18;
        this.f12373e0 = com.lynx.tasm.utils.a.B(16, this);
        return;
    L37:
        r18 = com.lynx.tasm.utils.a.B(20, this);
        goto L38
    L30:
        if (this.H != null) goto L33;
        if (r5 == false) goto L33;
        r17 = com.lynx.tasm.utils.a.B(16, this);
        goto L34
    L21:
        if (q() == false) goto L23;
        CharSequence r19 = this.E;
    L24:
        if (r19 == null) goto L26;
    L23:
        r19 = null;
        goto L24
    L39:
        this.f12370b0 = com.lynx.tasm.utils.a.B(20, this);
        this.f12371c0 = com.lynx.tasm.utils.a.B(8, this);
        if (this.A == true) goto L43;
        r16 = com.lynx.tasm.utils.a.B(20, this);
    L43:
        this.f12372d0 = r16;
        this.f12373e0 = com.lynx.tasm.utils.a.B(8, this);
    }

    public final boolean q() {
        CharSequence r5 = this.E;
        if (r5 != null) goto L5;
    L8:
        boolean r10 = true;
    L10:
        return !r10;
    L5:
        if (StringsKt.isBlank(r5) == true) goto L8;
        r10 = false;
        goto L10
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void r() {
        ArrowPosition r5 = this.f12391x;
        if (r5 != ArrowPosition.TOP) goto L5;
    L8:
        boolean r10 = true;
    L10:
        if (this.f12393z == true) goto L12;
        int r11 = 0;
    L16:
        OUIFrameLayout r12 = this.f12375h;
        ViewGroup.LayoutParams r13 = r12.getLayoutParams();
        if (r13 == null) goto L97;
        FrameLayout.LayoutParams r14 = (FrameLayout.LayoutParams) r13;
        r14.topMargin = 0;
        r14.bottomMargin = 0;
        r14.setMarginStart(0);
        r14.setMarginEnd(0);
        ArrowPosition r15 = this.f12391x;
        int[] r16 = br.b.f980c;
        int r17 = r16[r15.ordinal()];
        int r18 = 8388627;
        if (r17 == 1) goto L28;
        if (r17 == 2) goto L27;
        if (r17 == 3) goto L26;
        if (r17 != 4) goto L25;
        int r19 = 8388629;
    L29:
        r14.gravity = r19;
        int r20 = r16[this.f12391x.ordinal()];
        if (r20 == 1) goto L38;
        if (r20 == 2) goto L37;
        if (r20 == 3) goto L36;
        if (r20 != 4) goto L39;
        r14.setMarginEnd(r11);
    L39:
        r12.setLayoutParams(r14);
        if (r10 == false) goto L42;
        int r21 = R$drawable.oui_coachmark_arrow;
    L43:
        int r22 = 20;
        if (r10 == false) goto L46;
        int r23 = com.lynx.tasm.utils.a.B(20, this);
    L47:
        if (r10 == false) goto L49;
        r22 = 9;
    L49:
        int r24 = com.lynx.tasm.utils.a.B(r22, this);
        ImageView r110 = this.f12377i;
        ViewGroup.LayoutParams r111 = r110.getLayoutParams();
        if (r111 == null) goto L95;
        FrameLayout.LayoutParams r25 = (FrameLayout.LayoutParams) r111;
        r25.width = r23;
        r25.height = r24;
        int r26 = r16[this.f12391x.ordinal()];
        if (r26 == 1) goto L60;
        if (r26 == 2) goto L59;
        if (r26 == 3) goto L61;
        if (r26 != 4) goto L58;
        r18 = 8388629;
        goto L61
    L58:
        throw new NoWhenBranchMatchedException();
    L61:
        r25.gravity = r18;
        r110.setLayoutParams(r25);
        r110.setImageResource(r21);
        ColorStateList r27 = this.S;
        if (r27 == null) goto L65;
        r110.setImageTintList(r27);
    L65:
        int r28 = r16[this.f12391x.ordinal()];
        float r29 = 0.0f;
        if (r28 == 1) goto L70;
        if (r28 == 2) goto L73;
        if (r28 == 3) goto L70;
        if (r28 == 4) goto L70;
        throw new NoWhenBranchMatchedException();
    L73:
        float r30 = 180.0f;
    L74:
        r110.setRotation(r30);
        if (this.f12391x != ArrowPosition.RIGHT) goto L77;
        float r31 = -1.0f;
    L78:
        r110.setScaleX(r31);
        r110.setScaleY(1.0f);
        if (r10 == false) goto L81;
        r29 = this.B;
    L81:
        r110.setTranslationX(r29);
        r110.invalidateOutline();
        if (this.g0 == false) goto L98;
        com.obric.oui.material.c[] r32 = this.f12376h0;
        if (r32 == null) goto L100;
        com.obric.oui.material.c r33 = r32[0];
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Intrinsics.checkNotNullParameter(r33, "material");
        a.a.C(r110, r33, false, 2);
        r110.setBackgroundColor(0);
        r110.setImageDrawable(null);
        com.obric.oui.color.d r34 = r33.e;
        if (r34 != null) goto L90;
        return;
    L90:
        if (r110.getVisibility() != 0) goto L92;
        r12.setBorderWidth(0);
        return;
    L92:
        r12.setBorderWidth(com.lynx.tasm.utils.a.A(r34.f12423a, this));
        return;
    L100:
        return;
    L98:
        return;
    L77:
        r31 = 1.0f;
    L70:
        r30 = 0.0f;
        goto L74
    L59:
        r18 = 81;
        goto L61
    L60:
        r18 = 49;
        goto L61
    L95:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L46:
        r23 = com.lynx.tasm.utils.a.B(10, this);
        goto L47
    L42:
        r21 = R$drawable.oui_coachmark_arrow_left;
        goto L43
    L36:
        r14.setMarginStart(r11);
        goto L39
    L37:
        r14.bottomMargin = r11;
        goto L39
    L38:
        r14.topMargin = r11;
        goto L39
    L25:
        throw new NoWhenBranchMatchedException();
    L26:
        r19 = 8388627;
        goto L29
    L27:
        r19 = 81;
        goto L29
    L28:
        r19 = 49;
        goto L29
    L97:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L12:
        if (r10 == false) goto L14;
        r11 = com.lynx.tasm.utils.a.B(8, this);
        goto L16
    L14:
        r11 = com.lynx.tasm.utils.a.B(8, this);
        goto L16
    L5:
        if (r5 == ArrowPosition.BOTTOM) goto L8;
        r10 = false;
        goto L10
    }

    public final void s() {
        if (this.f12390w == ActionStyle.TEXT_ONLY) goto L5;
    L12:
        boolean r5 = false;
    L13:
        OButton r10 = this.f12387t;
        OButton r11 = this.s;
        if (r5 == false) goto L18;
        r11.setOnClickListener(this.K);
        r10.setOnClickListener(this.J);
        return;
    L18:
        if (q() == false) goto L20;
        View.OnClickListener r12 = this.J;
    L21:
        r11.setOnClickListener(r12);
        r10.setOnClickListener(null);
        this.f12388u.setOnClickListener(r12);
        return;
    L20:
        r12 = null;
        goto L21
    L5:
        if (q() == false) goto L12;
        CharSequence r13 = this.F;
        if (r13 == null) goto L12;
        if (StringsKt.isBlank(r13) == true) goto L12;
        r5 = true;
        goto L13
    }

    public final void setActionStyle(ActionStyle r5) {
        Intrinsics.checkNotNullParameter(r5, "style");
        if (this.f12390w == r5) goto L6;
        this.f12390w = r5;
        t();
        return;
    }

    public final void setActionText(CharSequence r5) {
        setPrimaryButtonText(r5);
    }

    public final void setArrowOffset(int r5) {
        if (this.B != r5) goto L5;
        return;
    L5:
        this.B = r5;
        r();
    }

    public final void setArrowPosition(ArrowPosition r5) {
        Intrinsics.checkNotNullParameter(r5, "position");
        if (this.f12391x != r5) goto L5;
        return;
    L5:
        this.f12391x = r5;
        r();
    }

    public final void setArrowVisible(boolean r5) {
        if (this.f12393z != r5) goto L5;
        return;
    L5:
        this.f12393z = r5;
        com.lynx.tasm.utils.d.x(this.f12377i, r5);
        r();
    }

    @Override // android.view.View
    public void setBackgroundColor(@ColorInt int r5) {
        if (this.L == r5) goto L6;
        this.L = r5;
        n();
        return;
    }

    public final void setCloseVisible(boolean r5) {
        setShowCloseIcon(r5);
    }

    public final void setContentPadding(int r5) {
        this.f12374f0 = true;
        this.f12370b0 = r5;
        this.f12371c0 = r5;
        this.f12372d0 = r5;
        this.f12373e0 = r5;
        t();
    }

    public final void setContentStyle(ContentStyle r5) {
        Intrinsics.checkNotNullParameter(r5, "style");
        if (this.f12392y == r5) goto L6;
        this.f12392y = r5;
        p();
        t();
        return;
    }

    public final void setCustomContentView$OUI_standardRelease(View r10) {
        Intrinsics.checkNotNullParameter(r10, "view");
        if (this.I != r10) goto L6;
        t();
        return;
    L6:
        ViewParent r5 = r10.getParent();
        ViewGroup r11 = this.f12380l;
        if (r5 == null) goto L27;
        if (r5 == r11) goto L27;
        if ((r5 instanceof ViewGroup) == true) goto L22;
        g r12 = ps.a.f21388a;
        if (ps.a.d(8) == true) goto L18;
        ps.a.f21388a.i(8, "OCoachmarkView", Intrinsics.stringPlus("custom content view has a non-ViewGroup parent: ", r5.getClass().getSimpleName()), null);
    L18:
        if (ps.a.d(8) == true) goto L29;
        ps.a.f21388a.i(8, "OCoachmarkView", "custom content view ignored because it cannot be moved into coachmark content container.", null);
        return;
    L29:
        return;
    L22:
        g r13 = ps.a.f21388a;
        if (ps.a.d(8) == true) goto L26;
        ps.a.f21388a.i(8, "OCoachmarkView", "custom content view already has a parent; it will be moved into coachmark content container.", null);
    L26:
        ((ViewGroup) r5).removeView(r10);
    L27:
        r11.removeAllViews();
        this.I = r10;
        r11.addView(r10);
        t();
    }

    public final void setDescTextAppearance(@StyleRes int r5) {
        if (this.N == r5) goto L6;
        this.N = r5;
        n();
        return;
    }

    @JvmOverloads
    public final void setDescription(CharSequence r5) {
        this.D = r5;
        t();
    }

    public final void setHeroImage(Drawable r5) {
        this.H = r5;
        t();
    }

    public final void setIcon(Drawable r5) {
        this.G = r5;
        t();
    }

    public final void setMaxWidth(int r5) {
        if (r5 > 0) goto L4;
        return;
    L4:
        if (this.f12369a0 == r5) goto L8;
        this.f12369a0 = r5;
        t();
        return;
    }

    public final void setOnActionClickListener(View.OnClickListener r5) {
        setOnPrimaryActionClickListener(r5);
    }

    public final void setOnCloseClickListener(View.OnClickListener r5) {
        this.f12389v.setOnClickListener(r5);
    }

    public final void setOnPrimaryActionClickListener(View.OnClickListener r5) {
        this.J = r5;
        s();
    }

    public final void setOnSecondaryActionClickListener(View.OnClickListener r5) {
        this.K = r5;
        s();
    }

    public final void setPopWindowMode(boolean r5) {
        if (this.i0 == r5) goto L13;
        this.i0 = r5;
        if (this.g0 == true) goto L7;
        return;
    L7:
        if (this.f12376h0 == null) goto L15;
        ImageView r10 = this.f12377i;
        OUIFrameLayout r11 = this.f12375h;
        if (r5 == false) goto L11;
        n.p(3, r11);
        n.p(3, r10);
        return;
    L11:
        n.p(2, r11);
        n.p(2, r10);
        return;
    L15:
        return;
    }

    public final void setPrimaryButtonText(CharSequence r5) {
        this.E = r5;
        t();
    }

    public final void setSecondaryButtonText(CharSequence r5) {
        this.F = r5;
        t();
    }

    public final void setShowCloseIcon(boolean r5) {
        if (this.A == r5) goto L6;
        this.A = r5;
        p();
        t();
        return;
    }

    public final void setText(CharSequence r5) {
        this.D = r5;
        t();
    }

    public final void setTitle(CharSequence r5) {
        this.C = r5;
        t();
    }

    public final void setTitleTextAppearance(@StyleRes int r5) {
        if (this.M == r5) goto L6;
        this.M = r5;
        n();
        return;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void t() {
        int r5 = this.f12369a0;
        OUIFrameLayout r10 = this.f12375h;
        i r11 = r10.d;
        if (r11 == null) goto L7;
        Intrinsics.checkNotNull(r11);
        if (r11.f12481b == r5) goto L7;
        r11.f12481b = r5;
        r10.requestLayout();
        r10.invalidate();
    L7:
        ViewGroup.LayoutParams r12 = r10.getLayoutParams();
        if (r12 == null) goto L180;
        FrameLayout.LayoutParams r13 = (FrameLayout.LayoutParams) r12;
        int r14 = br.b.f978a[this.f12392y.ordinal()];
        if (r14 == 1) goto L17;
        if (r14 != 2) goto L16;
        int r15 = j.n(getContext()).getWidth();
        int r16 = com.lynx.tasm.utils.a.B(320, this);
        if (r16 <= r15) goto L18;
        r16 = -1;
    L18:
        r13.width = r16;
        r10.setLayoutParams(r13);
        View r17 = this.I;
        if (r17 == null) goto L22;
        com.lynx.tasm.utils.d.x(r17, true);
    L168:
        if (this.f12376h0 == null) goto L171;
        r10.setEnableShadowWidthRadius(true);
    L171:
        n();
        p();
        this.f12380l.setPaddingRelative(this.f12370b0, this.f12371c0, this.f12372d0, this.f12373e0);
        r();
        return;
    L22:
        if (this.H == null) goto L24;
        boolean r18 = true;
    L25:
        com.lynx.tasm.utils.d.x(this.f12378j, r18);
        ImageView r19 = this.f12379k;
        if (r18 == false) goto L28;
        r19.setImageDrawable(this.H);
    L30:
        if (r18 == true) goto L32;
    L37:
        if (r18 == false) goto L39;
    L41:
        boolean r20 = false;
    L42:
        com.lynx.tasm.utils.d.x(this.f12381m, r20);
        ImageView r21 = this.f12382n;
        if (r20 == false) goto L45;
        r21.setImageDrawable(this.G);
    L46:
        View r22 = this.f12385q;
        ViewGroup.LayoutParams r110 = r22.getLayoutParams();
        if (r110 == null) goto L178;
        ViewGroup.MarginLayoutParams r111 = (ViewGroup.MarginLayoutParams) r110;
        if (r20 == false) goto L51;
        int r112 = com.lynx.tasm.utils.a.B(12, this);
    L52:
        r111.setMarginStart(r112);
        r22.setLayoutParams(r111);
        CharSequence r23 = this.C;
        if (r23 != null) goto L55;
    L58:
        boolean r24 = true;
    L59:
        OTextView r113 = this.f12383o;
        com.lynx.tasm.utils.d.x(r113, !r24);
        r113.setText(this.C);
        OTextView r114 = this.f12384p;
        ViewGroup.LayoutParams r115 = r114.getLayoutParams();
        if (r115 == null) goto L176;
        ViewGroup.MarginLayoutParams r116 = (ViewGroup.MarginLayoutParams) r115;
        if (r24 == true) goto L64;
        int r25 = com.lynx.tasm.utils.a.B(4, this);
    L65:
        r116.topMargin = r25;
        r114.setLayoutParams(r116);
        r114.setText(this.D);
        r114.setMaxWidth(Math.min(this.f12369a0, j.n(getContext()).getWidth()));
        CharSequence r26 = this.C;
        if (r26 != null) goto L68;
    L69:
        CharSequence r27 = this.D;
        if (r27 != null) goto L72;
    L73:
        g r28 = ps.a.f21388a;
        if (ps.a.d(8) == true) goto L78;
        ps.a.f21388a.i(8, "OCoachmarkView", "Coachmark title and description are empty.", null);
    L78:
        if (q() == false) goto L80;
        CharSequence r29 = this.E;
    L81:
        boolean r117 = q();
        CharSequence r118 = this.F;
        if (r118 != null) goto L84;
    L87:
        boolean r119 = true;
    L89:
        if (this.f12390w == ActionStyle.TEXT_ONLY) goto L91;
    L98:
        boolean r120 = false;
    L99:
        View r121 = this.f12386r;
        com.lynx.tasm.utils.d.x(r121, false);
        OButton r122 = this.s;
        com.lynx.tasm.utils.d.x(r122, false);
        OButton r30 = this.f12387t;
        com.lynx.tasm.utils.d.x(r30, false);
        OButton r31 = this.f12388u;
        com.lynx.tasm.utils.d.x(r31, false);
        r122.setOnClickListener(null);
        r30.setOnClickListener(null);
        r31.setOnClickListener(null);
        if (this.J == null) goto L108;
        if (r117 == true) goto L108;
        g r32 = ps.a.f21388a;
        if (ps.a.d(8) == true) goto L108;
        ps.a.f21388a.i(8, "OCoachmarkView", "Primary action listener is set without primary action text.", null);
    L108:
        if (this.K == null) goto L114;
        if (r119 == false) goto L114;
        g r33 = ps.a.f21388a;
        if (ps.a.d(8) == true) goto L114;
        ps.a.f21388a.i(8, "OCoachmarkView", "Secondary action listener is set without secondary action text.", null);
    L114:
        if (r119 == true) goto L120;
        if (r117 == true) goto L120;
        g r34 = ps.a.f21388a;
        if (ps.a.d(8) == true) goto L120;
        ps.a.f21388a.i(8, "OCoachmarkView", "Secondary action text is set without primary action text; secondary action will not render by itself.", null);
    L120:
        if (r119 == false) goto L122;
    L127:
        int r35 = br.b.f979b[this.f12390w.ordinal()];
        if (r35 == 1) goto L146;
        if (r35 != 2) goto L132;
        if (r29 != null) goto L144;
        g r36 = ps.a.f21388a;
        if (ps.a.d(8) == true) goto L154;
        ps.a.f21388a.i(8, "OCoachmarkView", "ActionStyle " + this.f12390w + " is set without action text.", null);
    L154:
        ViewGroup.LayoutParams r37 = r121.getLayoutParams();
        if (r37 == null) goto L174;
        ViewGroup.MarginLayoutParams r38 = (ViewGroup.MarginLayoutParams) r37;
        if (r20 == false) goto L159;
        int r39 = com.lynx.tasm.utils.a.B(8, this);
    L160:
        r38.topMargin = r39;
        r121.setLayoutParams(r38);
        if (this.f12392y == ContentStyle.PILL) goto L163;
    L165:
        boolean r40 = false;
    L166:
        com.lynx.tasm.utils.d.x(this.f12389v, r40);
        goto L168
    L163:
        if (this.A == false) goto L165;
        r40 = true;
        goto L166
    L159:
        r39 = com.lynx.tasm.utils.a.B(12, this);
        goto L160
    L174:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L144:
        com.lynx.tasm.utils.d.x(r31, true);
        r31.setText(r29);
        s();
        goto L154
    L132:
        if (r35 != 3) goto L154;
        if (r29 == null) goto L154;
        g r41 = ps.a.f21388a;
        if (ps.a.d(8) == true) goto L154;
        ps.a.f21388a.i(8, "OCoachmarkView", "action text is set while ActionStyle.NONE; action will stay hidden.", null);
        goto L154
    L146:
        if (r120 == false) goto L148;
        com.lynx.tasm.utils.d.x(r121, true);
        com.lynx.tasm.utils.d.x(r122, true);
        com.lynx.tasm.utils.d.x(r30, true);
        r122.setText(this.F);
        r30.setText(this.E);
        r122.setOnClickListener(this.K);
        r30.setOnClickListener(this.J);
        goto L154
    L148:
        if (r29 != null) goto L153;
        g r42 = ps.a.f21388a;
        if (ps.a.d(8) == true) goto L154;
        ps.a.f21388a.i(8, "OCoachmarkView", "ActionStyle " + this.f12390w + " is set without action text.", null);
        goto L154
    L153:
        com.lynx.tasm.utils.d.x(r121, true);
        com.lynx.tasm.utils.d.x(r122, true);
        r122.setText(r29);
        s();
        goto L154
    L122:
        if (this.f12390w != ActionStyle.FILLED_BUTTON) goto L127;
        g r43 = ps.a.f21388a;
        if (ps.a.d(8) == true) goto L127;
        ps.a.f21388a.i(8, "OCoachmarkView", "Secondary action text is set with FILLED_BUTTON; filled coachmark renders only the primary action.", null);
        goto L127
    L91:
        if (q() == false) goto L98;
        CharSequence r123 = this.F;
        if (r123 == null) goto L98;
        if (StringsKt.isBlank(r123) == true) goto L98;
        r120 = true;
        goto L99
    L84:
        if (StringsKt.isBlank(r118) == true) goto L87;
        r119 = false;
        goto L89
    L80:
        r29 = null;
        goto L81
    L72:
        if (StringsKt.isBlank(r27) == false) goto L78;
    L68:
        if (StringsKt.isBlank(r26) == false) goto L78;
    L64:
        r25 = 0;
        goto L65
    L176:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L55:
        if (StringsKt.isBlank(r23) == true) goto L58;
        r24 = false;
        goto L59
    L51:
        r112 = 0;
        goto L52
    L178:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L45:
        r21.setImageDrawable(null);
        goto L46
    L39:
        if (this.G == null) goto L41;
        r20 = true;
        goto L42
    L32:
        if (this.G == null) goto L37;
        g r44 = ps.a.f21388a;
        if (ps.a.d(8) == true) goto L37;
        ps.a.f21388a.i(8, "OCoachmarkView", "Hero image is set; cmIcon will be ignored.", null);
        goto L37
    L28:
        r19.setImageDrawable(null);
        goto L30
    L24:
        r18 = false;
        goto L25
    L16:
        throw new NoWhenBranchMatchedException();
    L17:
        r16 = -2;
        goto L18
    L180:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }

    @JvmOverloads
    public OCoachmarkView(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 0, 12);
    }

    @JvmOverloads
    public OCoachmarkView(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, r11, 8);
    }

    public OCoachmarkView(Context r10, AttributeSet r11, int r12, int r13) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = R$attr.ocoachmarkViewStyle;
    L8:
        int r14 = R$style.OStyleV2_OCoachmarkView_DayNight;
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, new k(r10, r11, r12, r14));
        br.c r5 = new br.c(this, 0);
        this.f12390w = ActionStyle.NONE;
        this.f12391x = ArrowPosition.TOP;
        ContentStyle r15 = ContentStyle.PILL;
        this.f12392y = r15;
        this.f12393z = true;
        this.f12369a0 = com.lynx.tasm.utils.a.B(320, this);
        this.f12370b0 = com.lynx.tasm.utils.a.B(20, this);
        this.f12371c0 = com.lynx.tasm.utils.a.B(8, this);
        this.f12372d0 = com.lynx.tasm.utils.a.B(20, this);
        this.f12373e0 = com.lynx.tasm.utils.a.B(8, this);
        if (a.a.w(this) == true) goto L11;
    L13:
        boolean r16 = false;
    L14:
        this.g0 = r16;
        LayoutInflater.from(r10).inflate(R$layout.o_coachmark, this, true);
        setClipChildren(false);
        setClipToPadding(false);
        setChangeAlphaWhenPress(false);
        OUIFrameLayout r17 = (OUIFrameLayout) findViewById(R$id.coachmark_container);
        this.f12375h = r17;
        r17.setChangeAlphaWhenPress(false);
        ImageView r18 = (ImageView) findViewById(R$id.iv_coachmark_arrow);
        this.f12377i = r18;
        r18.setOutlineProvider(r5);
        this.f12378j = findViewById(R$id.coachmark_hero_container);
        this.f12379k = (ImageView) findViewById(R$id.coachmark_hero_image);
        this.f12380l = (ViewGroup) findViewById(R$id.coachmark_content_container);
        this.f12381m = (OUIFrameLayout) findViewById(R$id.coachmark_icon_container);
        this.f12382n = (ImageView) findViewById(R$id.coachmark_icon);
        OTextView r19 = (OTextView) findViewById(R$id.tv_coachmark_title);
        this.f12383o = r19;
        r19.getPaint().setSubpixelText(true);
        r19.setIncludeFontPadding(true);
        OTextView r20 = (OTextView) findViewById(R$id.tv_coachmark_description);
        this.f12384p = r20;
        r20.getPaint().setSubpixelText(true);
        r20.setIncludeFontPadding(true);
        this.f12385q = findViewById(R$id.coachmark_text_group);
        this.f12386r = findViewById(R$id.coachmark_action_text_container);
        this.s = (OButton) findViewById(R$id.btn_coachmark_action_text);
        this.f12387t = (OButton) findViewById(R$id.btn_coachmark_action_text_primary);
        this.f12388u = (OButton) findViewById(R$id.btn_coachmark_action_filled);
        this.f12389v = (OIconButton) findViewById(R$id.btn_coachmark_close);
        this.L = getContext().getColor(R$color.oui_bg_base_3_high_elevation);
        r17.setMinimumHeight(com.lynx.tasm.utils.a.B(48, this));
        r17.setBackgroundColor(this.L);
        r17.setOuterNormalColor(this.L);
        r();
        TypedArray r110 = getContext().obtainStyledAttributes(r11, R$styleable.OCoachmarkView, r12, r14);
        CharSequence r111 = r110.getText(R$styleable.OCoachmarkView_android_text);     // Catch: Throwable -> L22
        if (r111 == null) goto L20;
        this.D = r111;     // Catch: Throwable -> L22
    L20:
        if (r110.hasValue(R$styleable.OCoachmarkView_cmTitle) == false) goto L25;
        this.C = r110.getText(R$styleable.OCoachmarkView_cmTitle);     // Catch: Throwable -> L22
    L25:
        if (r110.hasValue(R$styleable.OCoachmarkView_cmIcon) == false) goto L28;
        this.G = r110.getDrawable(R$styleable.OCoachmarkView_cmIcon);     // Catch: Throwable -> L22
    L28:
        if (r110.hasValue(R$styleable.OCoachmarkView_cmHeroImage) == false) goto L30;
        Drawable r112 = r110.getDrawable(R$styleable.OCoachmarkView_cmHeroImage);     // Catch: Throwable -> L22
    L31:
        if (r112 == null) goto L34;
        this.H = r112;     // Catch: Throwable -> L22
    L34:
        if (r110.hasValue(R$styleable.OCoachmarkView_cmContentStyle) == false) goto L46;
        d r113 = ContentStyle.Companion;     // Catch: Throwable -> L22
        int r114 = r110.getInt(R$styleable.OCoachmarkView_cmContentStyle, r15.getValue());     // Catch: Throwable -> L22
        r113.getClass();     // Catch: Throwable -> L22
        ContentStyle[] r115 = ContentStyle.values();     // Catch: Throwable -> L22
        int r116 = r115.length;     // Catch: Throwable -> L22
        int r21 = 0;
    L36:
        if (r21 >= r116) goto L41;
        ContentStyle r22 = r115[r21];     // Catch: Throwable -> L22
        if (r22.getValue() == r114) goto L42;
        r21 = r21 + 1;     // Catch: Throwable -> L22
    L42:
        if (r22 != null) goto L44;
        r22 = ContentStyle.PILL;     // Catch: Throwable -> L22
    L44:
        this.f12392y = r22;     // Catch: Throwable -> L22
        goto L46
    L41:
        r22 = null;
    L46:
        if (r110.hasValue(R$styleable.OCoachmarkView_cmShowCloseIcon) == false) goto L48;
        this.A = r110.getBoolean(R$styleable.OCoachmarkView_cmShowCloseIcon, false);     // Catch: Throwable -> L22
    L48:
        p();     // Catch: Throwable -> L22
        if (r110.hasValue(R$styleable.OCoachmarkView_cmActionText) == false) goto L51;
        this.E = r110.getText(R$styleable.OCoachmarkView_cmActionText);     // Catch: Throwable -> L22
        boolean r117 = true;
    L53:
        if (r110.hasValue(R$styleable.OCoachmarkView_cmPrimaryButtonText) == false) goto L56;
        this.E = r110.getText(R$styleable.OCoachmarkView_cmPrimaryButtonText);     // Catch: Throwable -> L22
        r117 = true;
    L56:
        if (r110.hasValue(R$styleable.OCoachmarkView_cmSecondaryButtonText) == false) goto L59;
        this.F = r110.getText(R$styleable.OCoachmarkView_cmSecondaryButtonText);     // Catch: Throwable -> L22
        r117 = true;
    L59:
        if (r110.hasValue(R$styleable.OCoachmarkView_cmActionStyle) == false) goto L70;
        int r118 = r110.getInt(R$styleable.OCoachmarkView_cmActionStyle, ActionStyle.NONE.getValue());     // Catch: Throwable -> L22
        ActionStyle.Companion.getClass();     // Catch: Throwable -> L22
        ActionStyle[] r119 = ActionStyle.values();     // Catch: Throwable -> L22
        int r23 = r119.length;     // Catch: Throwable -> L22
        int r24 = 0;
    L61:
        if (r24 >= r23) goto L66;
        ActionStyle r25 = r119[r24];     // Catch: Throwable -> L22
        if (r25.getValue() == r118) goto L67;
        r24 = r24 + 1;     // Catch: Throwable -> L22
    L67:
        if (r25 != null) goto L69;
        r25 = ActionStyle.NONE;     // Catch: Throwable -> L22
    L69:
        this.f12390w = r25;     // Catch: Throwable -> L22
        boolean r120 = true;
    L71:
        o(r110);     // Catch: Throwable -> L22
        if (r110.hasValue(R$styleable.OCoachmarkView_cmMaxWidth) == false) goto L75;
        this.f12369a0 = r110.getDimensionPixelSize(R$styleable.OCoachmarkView_cmMaxWidth, this.f12369a0);     // Catch: Throwable -> L22
    L75:
        if (r110.hasValue(R$styleable.OCoachmarkView_cmContentPadding) == false) goto L77;
        int r121 = r110.getDimensionPixelSize(R$styleable.OCoachmarkView_cmContentPadding, this.f12370b0);     // Catch: Throwable -> L22
        this.f12370b0 = r121;     // Catch: Throwable -> L22
        this.f12371c0 = r121;     // Catch: Throwable -> L22
        this.f12372d0 = r121;     // Catch: Throwable -> L22
        this.f12373e0 = r121;     // Catch: Throwable -> L22
        boolean r122 = true;
    L79:
        if (r110.hasValue(R$styleable.OCoachmarkView_cmContentPaddingStart) == false) goto L82;
        this.f12370b0 = r110.getDimensionPixelSize(R$styleable.OCoachmarkView_cmContentPaddingStart, this.f12370b0);     // Catch: Throwable -> L22
        r122 = true;
    L82:
        if (r110.hasValue(R$styleable.OCoachmarkView_cmContentPaddingTop) == false) goto L85;
        this.f12371c0 = r110.getDimensionPixelSize(R$styleable.OCoachmarkView_cmContentPaddingTop, this.f12371c0);     // Catch: Throwable -> L22
        r122 = true;
    L85:
        if (r110.hasValue(R$styleable.OCoachmarkView_cmContentPaddingEnd) == false) goto L88;
        this.f12372d0 = r110.getDimensionPixelSize(R$styleable.OCoachmarkView_cmContentPaddingEnd, this.f12372d0);     // Catch: Throwable -> L22
        r122 = true;
    L88:
        if (r110.hasValue(R$styleable.OCoachmarkView_cmContentPaddingBottom) == false) goto L90;
        this.f12373e0 = r110.getDimensionPixelSize(R$styleable.OCoachmarkView_cmContentPaddingBottom, this.f12373e0);     // Catch: Throwable -> L22
        r122 = true;
    L90:
        if (r122 == false) goto L92;
        this.f12374f0 = true;     // Catch: Throwable -> L22
    L92:
        boolean r123 = r110.getBoolean(R$styleable.OCoachmarkView_cmShowArrow, true);     // Catch: Throwable -> L22
        this.f12393z = r123;     // Catch: Throwable -> L22
        com.lynx.tasm.utils.d.x(this.f12377i, r123);     // Catch: Throwable -> L22
        c r124 = ArrowPosition.Companion;     // Catch: Throwable -> L22
        int r26 = r110.getInt(R$styleable.OCoachmarkView_cmArrowPosition, ArrowPosition.TOP.getValue());     // Catch: Throwable -> L22
        r124.getClass();     // Catch: Throwable -> L22
        ArrowPosition[] r125 = ArrowPosition.values();     // Catch: Throwable -> L22
        int r27 = r125.length;     // Catch: Throwable -> L22
        int r28 = 0;
    L93:
        if (r28 >= r27) goto L98;
        ArrowPosition r29 = r125[r28];     // Catch: Throwable -> L22
        if (r29.getValue() == r26) goto L99;
        r28 = r28 + 1;     // Catch: Throwable -> L22
    L99:
        if (r29 != null) goto L101;
        r29 = ArrowPosition.TOP;     // Catch: Throwable -> L22
    L101:
        this.f12391x = r29;     // Catch: Throwable -> L22
        if (r110.hasValue(R$styleable.OCoachmarkView_cmArrowOffset) == false) goto L104;
        this.B = r110.getDimensionPixelSize(R$styleable.OCoachmarkView_cmArrowOffset, 0);     // Catch: Throwable -> L22
    L104:
        r110.recycle();
        if (r120 == true) goto L111;
        if (r117 == false) goto L111;
        g r126 = ps.a.f21388a;
        if (ps.a.d(8) == true) goto L111;
        ps.a.f21388a.i(8, "OCoachmarkView", "Action text is set without cmActionStyle; action will stay hidden.", null);
    L111:
        t();
        return;
    L98:
        r29 = null;
        goto L99
    L77:
        r122 = false;
        goto L79
    L66:
        r25 = null;
        goto L67
    L70:
        r120 = false;
        goto L71
    L51:
        r117 = false;
        goto L53
    L30:
        r112 = r110.getDrawable(R$styleable.OCoachmarkView_android_src);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        r110.recycle();
        throw th;
    L11:
        if (n.k() == false) goto L13;
        r16 = true;
        goto L14
    }
}
