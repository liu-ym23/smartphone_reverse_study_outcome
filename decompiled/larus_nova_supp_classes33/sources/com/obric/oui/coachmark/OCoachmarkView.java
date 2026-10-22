package com.obric.oui.coachmark;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.widget.TextViewCompat;
import com.obric.oui.button.OButton;
import com.obric.oui.button.OIconButton;
import com.obric.oui.color.h0;
import com.obric.oui.color.i0;
import com.obric.oui.common.style.l;
import com.obric.oui.common.style.o;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.material.p;
import com.obric.oui.text.OTextView;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import pla.d;
import pla.j;
import vma.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u0001:\u0004:;<=J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\u0010\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\u000e\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0016\u001a\u00020\u00042\b\b\u0001\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0018\u001a\u00020\u00042\b\b\u0001\u0010\u0017\u001a\u00020\u0014J\u0010\u0010\u0019\u001a\u00020\u00042\b\b\u0001\u0010\u0017\u001a\u00020\u0014J\u000e\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0014J\u000e\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0014J\u0010\u0010\u001e\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u001f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010 \u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\"\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020!J\u0010\u0010%\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010#J\u0010\u0010&\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010#J\u0010\u0010'\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010#J\u000e\u0010*\u001a\u00020\u00042\u0006\u0010)\u001a\u00020(J\u000e\u0010-\u001a\u00020\u00042\u0006\u0010,\u001a\u00020+J\u000e\u0010/\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u0014J\u0010\u00100\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010#J\u000e\u00101\u001a\u00020\u00042\u0006\u0010)\u001a\u00020(J\u000e\u00102\u001a\u00020\u00042\u0006\u0010)\u001a\u00020(R*\u00106\u001a\u00020(2\u0006\u00103\u001a\u00020(8F@FX\u0086\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109¨\u0006>"}, d2 = {"Lcom/obric/oui/coachmark/OCoachmarkView;", "Lcom/obric/oui/layout/OUIFrameLayout;", "", "text", "", "setText", "getText", "setTitle", "Lcom/obric/oui/coachmark/OCoachmarkView$ContentStyle;", "style", "setContentStyle", "Landroid/graphics/drawable/Drawable;", "drawable", "setIcon", "setHeroImage", "Landroid/view/View;", "view", "setCustomContentView$OUI_standardRelease", "(Landroid/view/View;)V", "setCustomContentView", "", "color", "setBackgroundColor", "resId", "setTitleTextAppearance", "setDescTextAppearance", "widthPx", "setMaxWidth", "paddingPx", "setContentPadding", "setActionText", "setPrimaryButtonText", "setSecondaryButtonText", "Lcom/obric/oui/coachmark/OCoachmarkView$ActionStyle;", "setActionStyle", "Landroid/view/View$OnClickListener;", "listener", "setOnActionClickListener", "setOnPrimaryActionClickListener", "setOnSecondaryActionClickListener", "", "visible", "setArrowVisible", "Lcom/obric/oui/coachmark/OCoachmarkView$ArrowPosition;", "position", "setArrowPosition", "offsetPx", "setArrowOffset", "setOnCloseClickListener", "setShowCloseIcon", "setCloseVisible", "value", "h1", "Z", "isPopWindowMode", "()Z", "setPopWindowMode", "(Z)V", "ActionStyle", "ArrowPosition", "a", "ContentStyle", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OCoachmarkView extends OUIFrameLayout {
    public boolean A;
    public int B;
    public CharSequence C;
    public CharSequence D;
    public CharSequence E;
    public CharSequence F;
    public Drawable G;
    public Drawable H;
    public int H0;
    public View I;
    public View.OnClickListener J;
    public View.OnClickListener K;
    public int L;
    public int L0;
    public int M;
    public int N;
    public ColorStateList O;
    public ColorStateList P;
    public int P0;
    public ColorStateList Q;
    public ColorStateList R;
    public ColorStateList S;
    public Integer T;
    public Integer U;
    public Integer V;
    public boolean V0;
    public Integer W;
    public boolean b1;
    public com.obric.oui.material.c[] g1;
    public final OUIFrameLayout h;
    public boolean h1;
    public final ImageView i;
    public final View j;
    public final ImageView k;
    public int k0;
    public final ViewGroup l;
    public final OUIFrameLayout m;
    public final ImageView n;
    public final OTextView o;
    public final OTextView p;
    public int p0;
    public final View q;
    public final View r;
    public final OButton s;
    public final OButton t;
    public final OButton u;
    public final OIconButton v;
    public ActionStyle w;
    public ArrowPosition x;
    public ContentStyle y;
    public boolean z;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/obric/oui/coachmark/OCoachmarkView$ActionStyle;", "", "", "value", "I", "getValue", "()I", "Companion", "a", "NONE", "TEXT_ONLY", "FILLED_BUTTON", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
    public static final enum ActionStyle extends Enum<ActionStyle> {
        public static final a Companion = null;
        public static final ActionStyle FILLED_BUTTON = null;
        public static final ActionStyle NONE = null;
        public static final ActionStyle TEXT_ONLY = null;
        public static final /* synthetic */ ActionStyle[] a = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        public static ActionStyle valueOf(String r1) {
            return (ActionStyle) r27.a.a(ActionStyle.class, r1);
        }

        public static ActionStyle[] values() {
            return (ActionStyle[]) a.clone();
        }

        static {
            ActionStyle r0 = new ActionStyle("NONE", 0, 0);
            NONE = r0;
            ActionStyle r1 = new ActionStyle("TEXT_ONLY", 1, 1);
            TEXT_ONLY = r1;
            ActionStyle r3 = new ActionStyle("FILLED_BUTTON", 2, 2);
            FILLED_BUTTON = r3;
            a = new ActionStyle[]{r0, r1, r3};
            Companion = new a();
        }

        public final int getValue() {
            return this.value;
        }

        public ActionStyle(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/obric/oui/coachmark/OCoachmarkView$ArrowPosition;", "", "", "value", "I", "getValue", "()I", "Companion", "a", "TOP", "BOTTOM", "LEFT", "RIGHT", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
    public static final enum ArrowPosition extends Enum<ArrowPosition> {
        public static final ArrowPosition BOTTOM = null;
        public static final a Companion = null;
        public static final ArrowPosition LEFT = null;
        public static final ArrowPosition RIGHT = null;
        public static final ArrowPosition TOP = null;
        public static final /* synthetic */ ArrowPosition[] a = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        public static ArrowPosition valueOf(String r1) {
            return (ArrowPosition) r27.a.a(ArrowPosition.class, r1);
        }

        public static ArrowPosition[] values() {
            return (ArrowPosition[]) a.clone();
        }

        static {
            ArrowPosition r0 = new ArrowPosition("TOP", 0, 0);
            TOP = r0;
            ArrowPosition r1 = new ArrowPosition("BOTTOM", 1, 1);
            BOTTOM = r1;
            ArrowPosition r3 = new ArrowPosition("LEFT", 2, 2);
            LEFT = r3;
            ArrowPosition r5 = new ArrowPosition("RIGHT", 3, 3);
            RIGHT = r5;
            a = new ArrowPosition[]{r0, r1, r3, r5};
            Companion = new a();
        }

        public final int getValue() {
            return this.value;
        }

        public ArrowPosition(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/obric/oui/coachmark/OCoachmarkView$ContentStyle;", "", "", "value", "I", "getValue", "()I", "Companion", "a", "PILL", "CARD", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
    public static final enum ContentStyle extends Enum<ContentStyle> {
        public static final ContentStyle CARD = null;
        public static final a Companion = null;
        public static final ContentStyle PILL = null;
        public static final /* synthetic */ ContentStyle[] a = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        public static ContentStyle valueOf(String r1) {
            return (ContentStyle) r27.a.a(ContentStyle.class, r1);
        }

        public static ContentStyle[] values() {
            return (ContentStyle[]) a.clone();
        }

        static {
            ContentStyle r0 = new ContentStyle("PILL", 0, 0);
            PILL = r0;
            ContentStyle r1 = new ContentStyle("CARD", 1, 1);
            CARD = r1;
            a = new ContentStyle[]{r0, r1};
            Companion = new a();
        }

        public final int getValue() {
            return this.value;
        }

        public ContentStyle(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;
        public static final /* synthetic */ int[] c = null;

        static {
            int[] r0 = new int[ContentStyle.values().length];
            r0[ContentStyle.PILL.ordinal()] = 1;
            r0[ContentStyle.CARD.ordinal()] = 2;
            a = r0;
            int[] r1 = new int[ActionStyle.values().length];
            r1[ActionStyle.TEXT_ONLY.ordinal()] = 1;
            r1[ActionStyle.FILLED_BUTTON.ordinal()] = 2;
            r1[ActionStyle.NONE.ordinal()] = 3;
            b = r1;
            int[] r2 = new int[ArrowPosition.values().length];
            r2[ArrowPosition.TOP.ordinal()] = 1;
            r2[ArrowPosition.BOTTOM.ordinal()] = 2;
            r2[ArrowPosition.LEFT.ordinal()] = 3;
            r2[ArrowPosition.RIGHT.ordinal()] = 4;
            c = r2;
        }
    }

    public static final class c extends ViewOutlineProvider {
        public final /* synthetic */ OCoachmarkView a;

        public c(OCoachmarkView r1) {
            this.a = r1;
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r13, Outline r14) {
            Intrinsics.checkNotNullParameter(r13, "view");
            Intrinsics.checkNotNullParameter(r14, "outline");
            int r0 = r13.getWidth();
            int r15 = r13.getHeight();
            if (r0 <= 0) goto L22;
            if (r15 <= 0) goto L24;
            Path r8 = new Path();
            ArrowPosition r1 = this.a.x;
            if (r1 != ArrowPosition.TOP) goto L9;
        L12:
            boolean r2 = true;
        L14:
            if (r2 == false) goto L16;
            float r3 = r0 / 20.0f;
            float r16 = r15 / 8.0f;
            float r7 = r16 * 1.41421f;
            r8.moveTo(8.58579f * r3, r7);
            r8.cubicTo(9.36684f * r3, 0.633164f * r16, 10.6332f * r3, 0.633165f * r16, 11.4142f * r3, r7);
            float r17 = r16 * 8.0f;
            r8.lineTo(18.0f * r3, r17);
            r8.lineTo(r3 * 2.0f, r17);
            r8.close();
        L18:
            if (Build.VERSION.SDK_INT < 30) goto L20;
            r14.setPath(r8);
            return;
        L20:
            r14.setConvexPath(r8);
            return;
        L16:
            float r4 = r0 / 10.0f;
            float r18 = r15 / 20.0f;
            float r6 = r4 * 1.95217f;
            float r5 = r4 * 0.951359f;
            r8.moveTo(r6, 8.43826f * r18);
            r8.cubicTo(r5, r18 * 9.23891f, r5, r18 * 10.7611f, r6, r18 * 11.5617f);
            float r9 = r4 * 10.0f;
            r8.lineTo(r9, 18.0f * r18);
            r8.lineTo(r9, r18 * 2.0f);
            r8.close();
            goto L18
        L9:
            if (r1 == ArrowPosition.BOTTOM) goto L12;
            r2 = false;
            goto L14
        L24:
            return;
        }
    }

    static {
    }

    public OCoachmarkView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        this(r4, null, 0, 14);
    }

    public OCoachmarkView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 12);
    }

    public OCoachmarkView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, r4, 8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void d() {
        int r0 = b.a[this.y.ordinal()];
        if (r0 == 1) goto L8;
        if (r0 != 2) goto L7;
        int r1 = d.n(this, 20);
    L9:
        this.h.setShadowCornerRadius(r1);
        OUIFrameLayout r2 = this.h;
        if (r2.b.J == false) goto L13;
        r2.setRadius(r1);
    L13:
        if (this.b1 == false) goto L22;
        com.obric.oui.material.c[] r3 = this.g1;
        if (r3 == null) goto L22;
        if (this.z == false) goto L19;
        OUIFrameLayout r4 = this.h;
        Intrinsics.checkNotNull(r3);
        com.obric.oui.material.c r5 = r3[0];
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "material");
        p.f(r4, r5, false, 2);
        OMaterialHelper.y(this.h, 0.0f, 0);
        this.h.setOuterNormalColor(0);
        this.h.setBorderWidth(0);
    L20:
        OUIFrameLayout r6 = this.h;
        GradientDrawable r7 = new GradientDrawable();
        r7.setShape(0);
        r7.setCornerRadius(r1);
        r7.setColor(0);
        r6.setBackground(r7);
    L24:
        int r8 = this.M;
        if (r8 == 0) goto L27;
        TextViewCompat.setTextAppearance(this.o, r8);
    L27:
        int r9 = this.N;
        if (r9 == 0) goto L30;
        TextViewCompat.setTextAppearance(this.p, r9);
    L30:
        ColorStateList r10 = this.O;
        if (r10 == null) goto L34;
        this.o.setTextColor(r10);
    L34:
        ColorStateList r11 = this.P;
        if (r11 == null) goto L38;
        this.p.setTextColor(r11);
    L38:
        this.n.setImageTintList(this.Q);
        ColorStateList r12 = this.R;
        if (r12 == null) goto L42;
        this.v.setImageTintList(r12);
    L42:
        Integer r13 = this.T;
        if (r13 == null) goto L46;
        this.s.setTextColor(r13.intValue());
    L46:
        Integer r14 = this.U;
        if (r14 == null) goto L50;
        this.t.setTextColor(r14.intValue());
    L50:
        Integer r15 = this.V;
        if (r15 == null) goto L54;
        this.u.setTextColor(r15.intValue());
    L54:
        Integer r16 = this.W;
        if (r16 == null) goto L59;
        int r17 = r16.intValue();
        this.u.setBackgroundTintList(ColorStateList.valueOf(r17));
        this.u.setOuterNormalColor(r17);
        return;
    L59:
        return;
    L19:
        OUIFrameLayout r18 = this.h;
        Intrinsics.checkNotNull(r3);
        p.d(r18, r3, false, 0, 14);
    L22:
        if (this.L == 0) goto L24;
        OUIFrameLayout r19 = this.h;
        GradientDrawable r20 = new GradientDrawable();
        r20.setCornerRadius(r1);
        r20.setColor(this.L);
        r19.setBackground(r20);
        this.h.setOuterNormalColor(this.L);
        goto L24
    L7:
        throw new NoWhenBranchMatchedException();
    L8:
        r1 = d.n(this, 28);
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void f() {
        if (this.V0 == false) goto L5;
        return;
    L5:
        boolean r1 = true;
        if (this.I == null) goto L14;
        ContentStyle r0 = this.y;
        int r2 = b.a[r0.ordinal()];
        if (r2 == 1) goto L12;
        if (r2 != 2) goto L49;
        int r3 = d.n(this, 20);
        int r4 = d.n(this, 16);
        this.p0 = r3;
        this.H0 = r4;
        this.L0 = r3;
        this.P0 = r4;
        return;
    L49:
        return;
    L12:
        int r5 = d.n(this, 20);
        int r6 = d.n(this, 8);
        this.p0 = r5;
        this.H0 = r6;
        this.L0 = r5;
        this.P0 = r6;
        return;
    L14:
        ContentStyle r7 = this.y;
        int r8 = b.a[r7.ordinal()];
        int r9 = 0;
        if (r8 == 1) goto L42;
        if (r8 == 2) goto L19;
        return;
    L19:
        if (this.w != ActionStyle.NONE) goto L21;
    L26:
        boolean r10 = false;
    L28:
        if (this.G != null) goto L30;
    L32:
        r1 = false;
    L33:
        if (r1 == false) goto L36;
        if (r10 == false) goto L36;
        int r11 = d.n(this, 16);
    L37:
        this.p0 = r11;
        this.H0 = d.n(this, 16);
        if (r10 == false) goto L40;
        int r12 = d.n(this, 16);
    L41:
        this.L0 = r12;
        this.P0 = d.n(this, 16);
        return;
    L40:
        r12 = d.n(this, 20);
    L36:
        r11 = d.n(this, 20);
        goto L37
    L30:
        if (this.H != null) goto L32;
    L21:
        if (g() == false) goto L23;
        CharSequence r13 = this.E;
    L24:
        if (r13 == null) goto L26;
        r10 = true;
        goto L28
    L23:
        r13 = null;
        goto L24
    L42:
        this.p0 = d.n(this, 20);
        this.H0 = d.n(this, 8);
        if (this.A == true) goto L46;
        r9 = d.n(this, 20);
    L46:
        this.L0 = r9;
        this.P0 = d.n(this, 8);
    }

    public final boolean g() {
        CharSequence r0 = this.E;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        return !r1;
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L10
    }

    public final CharSequence getText() {
        CharSequence r0 = this.D;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return this.p.getText();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void h() {
        ArrowPosition r1 = this.x;
        if (r1 != ArrowPosition.TOP) goto L5;
    L8:
        boolean r2 = true;
    L10:
        if (this.z == true) goto L12;
        int r3 = 0;
    L16:
        OUIFrameLayout r5 = this.h;
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
        if (r6 == null) goto L98;
        FrameLayout.LayoutParams r7 = (FrameLayout.LayoutParams) r6;
        r7.topMargin = 0;
        r7.bottomMargin = 0;
        r7.setMarginStart(0);
        r7.setMarginEnd(0);
        ArrowPosition r8 = this.x;
        int[] r9 = b.c;
        int r10 = r9[r8.ordinal()];
        int r11 = 81;
        if (r10 == 1) goto L28;
        if (r10 == 2) goto L27;
        if (r10 == 3) goto L26;
        if (r10 != 4) goto L25;
        int r12 = 8388629;
    L29:
        r7.gravity = r12;
        int r13 = r9[this.x.ordinal()];
        if (r13 == 1) goto L38;
        if (r13 == 2) goto L37;
        if (r13 == 3) goto L36;
        if (r13 != 4) goto L39;
        r7.setMarginEnd(r3);
    L39:
        r5.setLayoutParams(r7);
        if (r2 == false) goto L42;
        int r4 = 2131245970;
    L43:
        int r14 = 20;
        if (r2 == false) goto L46;
        int r15 = d.n(this, 20);
    L47:
        if (r2 == false) goto L49;
        r14 = 9;
    L49:
        int r16 = d.n(this, r14);
        ImageView r17 = this.i;
        ViewGroup.LayoutParams r18 = r17.getLayoutParams();
        if (r18 == null) goto L96;
        FrameLayout.LayoutParams r19 = (FrameLayout.LayoutParams) r18;
        r19.width = r15;
        r19.height = r16;
        int r20 = r9[this.x.ordinal()];
        if (r20 == 1) goto L60;
        if (r20 == 2) goto L61;
        if (r20 == 3) goto L59;
        if (r20 != 4) goto L58;
        r11 = 8388629;
        goto L61
    L58:
        throw new NoWhenBranchMatchedException();
    L59:
        r11 = 8388627;
    L61:
        r19.gravity = r11;
        r17.setLayoutParams(r19);
        this.i.setImageResource(r4);
        ColorStateList r21 = this.S;
        if (r21 == null) goto L65;
        this.i.setImageTintList(r21);
    L65:
        ImageView r22 = this.i;
        int r23 = r9[this.x.ordinal()];
        float r24 = 0.0f;
        if (r23 == 1) goto L74;
        if (r23 == 2) goto L73;
        if (r23 == 3) goto L74;
        if (r23 == 4) goto L74;
        throw new NoWhenBranchMatchedException();
    L73:
        float r25 = 180.0f;
    L75:
        r22.setRotation(r25);
        ImageView r26 = this.i;
        if (this.x != ArrowPosition.RIGHT) goto L78;
        float r27 = -1.0f;
    L79:
        r26.setScaleX(r27);
        this.i.setScaleY(1.0f);
        ImageView r28 = this.i;
        if (r2 == false) goto L82;
        r24 = this.B;
    L82:
        r28.setTranslationX(r24);
        this.i.invalidateOutline();
        if (this.b1 == false) goto L99;
        com.obric.oui.material.c[] r29 = this.g1;
        if (r29 == null) goto L101;
        com.obric.oui.material.c r30 = r29[0];
        ImageView r31 = this.i;
        Intrinsics.checkNotNullParameter(r31, "<this>");
        Intrinsics.checkNotNullParameter(r30, "material");
        p.f(r31, r30, false, 2);
        this.i.setBackgroundColor(0);
        this.i.setImageDrawable(null);
        i0 r32 = r30.e;
        if (r32 != null) goto L91;
        return;
    L91:
        if (this.i.getVisibility() != 0) goto L93;
        this.h.setBorderWidth(0);
        return;
    L93:
        this.h.setBorderWidth(d.m(this, r32.a));
        return;
    L101:
        return;
    L99:
        return;
    L78:
        r27 = 1.0f;
    L74:
        r25 = 0.0f;
        goto L75
    L60:
        r11 = 49;
        goto L61
    L96:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L46:
        r15 = d.n(this, 10);
        goto L47
    L42:
        r4 = 2131245971;
        goto L43
    L36:
        r7.setMarginStart(r3);
        goto L39
    L37:
        r7.bottomMargin = r3;
        goto L39
    L38:
        r7.topMargin = r3;
        goto L39
    L25:
        throw new NoWhenBranchMatchedException();
    L26:
        r12 = 8388627;
        goto L29
    L27:
        r12 = 81;
        goto L29
    L28:
        r12 = 49;
        goto L29
    L98:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L12:
        if (r2 == false) goto L14;
        r3 = d.n(this, 8);
        goto L16
    L14:
        r3 = d.n(this, 8);
        goto L16
    L5:
        if (r1 == ArrowPosition.BOTTOM) goto L8;
        r2 = false;
        goto L10
    }

    public final void i() {
        boolean r2 = false;
        if (this.w == ActionStyle.TEXT_ONLY) goto L5;
    L16:
        if (r2 == false) goto L20;
        this.s.setOnClickListener(this.K);
        this.t.setOnClickListener(this.J);
        return;
    L20:
        if (g() == false) goto L22;
        View.OnClickListener r0 = this.J;
    L23:
        this.s.setOnClickListener(r0);
        this.t.setOnClickListener(null);
        this.u.setOnClickListener(r0);
        return;
    L22:
        r0 = null;
        goto L23
    L5:
        if (g() == false) goto L16;
        CharSequence r1 = this.F;
        if (r1 != null) goto L9;
    L12:
        boolean r3 = true;
    L14:
        if ((!r3) == false) goto L16;
        r2 = true;
        goto L16
    L9:
        if (StringsKt.isBlank(r1) == true) goto L12;
        r3 = false;
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void j() {
        OUIFrameLayout r0 = this.h;
        int r1 = this.k0;
        l r2 = r0.d;
        boolean r4 = false;
        if (r2 == null) goto L10;
        Intrinsics.checkNotNull(r2);
        if (r2.b == r1) goto L7;
        r2.b = r1;
        boolean r3 = true;
    L8:
        if (r3 == false) goto L10;
        r0.requestLayout();
        r0.invalidate();
        goto L10
    L7:
        r3 = false;
    L10:
        OUIFrameLayout r5 = this.h;
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
        if (r6 == null) goto L191;
        FrameLayout.LayoutParams r7 = (FrameLayout.LayoutParams) r6;
        int r8 = b.a[this.y.ordinal()];
        if (r8 == 1) goto L20;
        if (r8 != 2) goto L19;
        int r9 = zma.a.c(getContext()).getWidth();
        int r10 = d.n(this, 320);
        if (r10 <= r9) goto L21;
        r10 = -1;
    L21:
        r7.width = r10;
        r5.setLayoutParams(r7);
        View r11 = this.I;
        if (r11 == null) goto L25;
        j.h(r11, true);
    L179:
        if (this.g1 == null) goto L182;
        this.h.setEnableShadowWidthRadius(true);
    L182:
        d();
        f();
        this.l.setPaddingRelative(this.p0, this.H0, this.L0, this.P0);
        h();
        return;
    L25:
        if (this.H == null) goto L27;
        boolean r12 = true;
    L28:
        j.h(this.j, r12);
        if (r12 == false) goto L31;
        this.k.setImageDrawable(this.H);
    L33:
        if (r12 == true) goto L35;
    L40:
        if (r12 == false) goto L42;
    L44:
        boolean r13 = false;
    L45:
        j.h(this.m, r13);
        if (r13 == false) goto L48;
        this.n.setImageDrawable(this.G);
    L49:
        View r14 = this.q;
        ViewGroup.LayoutParams r15 = r14.getLayoutParams();
        if (r15 == null) goto L189;
        ViewGroup.MarginLayoutParams r16 = (ViewGroup.MarginLayoutParams) r15;
        if (r13 == false) goto L54;
        int r17 = d.n(this, 12);
    L55:
        r16.setMarginStart(r17);
        r14.setLayoutParams(r16);
        CharSequence r18 = this.C;
        if (r18 != null) goto L58;
    L61:
        boolean r19 = true;
    L62:
        boolean r20 = !r19;
        j.h(this.o, r20);
        this.o.setText(this.C);
        OTextView r21 = this.p;
        ViewGroup.LayoutParams r110 = r21.getLayoutParams();
        if (r110 == null) goto L187;
        ViewGroup.MarginLayoutParams r111 = (ViewGroup.MarginLayoutParams) r110;
        if (r20 == false) goto L67;
        int r22 = d.n(this, 4);
    L68:
        r111.topMargin = r22;
        r21.setLayoutParams(r111);
        this.p.setText(this.D);
        this.p.setMaxWidth(Math.min(this.k0, zma.a.c(getContext()).getWidth()));
        CharSequence r23 = this.C;
        if (r23 != null) goto L71;
    L74:
        boolean r24 = true;
    L75:
        if (r24 == false) goto L89;
        CharSequence r25 = this.D;
        if (r25 != null) goto L79;
    L82:
        boolean r26 = true;
    L83:
        if (r26 == false) goto L89;
        wma.a r27 = wma.b.a;
        if (wma.b.e(8) == true) goto L89;
        wma.b.a.a("OCoachmarkView", "Coachmark title and description are empty.");
        goto L89
    L79:
        if (StringsKt.isBlank(r25) == true) goto L82;
        r26 = false;
    L89:
        if (g() == false) goto L91;
        CharSequence r28 = this.E;
    L92:
        boolean r29 = g();
        CharSequence r112 = this.F;
        if (r112 != null) goto L95;
    L98:
        boolean r113 = true;
    L99:
        boolean r114 = !r113;
        if (this.w == ActionStyle.TEXT_ONLY) goto L102;
    L113:
        boolean r115 = false;
    L114:
        j.h(this.r, false);
        j.h(this.s, false);
        j.h(this.t, false);
        j.h(this.u, false);
        this.s.setOnClickListener(null);
        this.t.setOnClickListener(null);
        this.u.setOnClickListener(null);
        if (this.J == null) goto L122;
        if (r29 == true) goto L122;
        wma.a r30 = wma.b.a;
        if (wma.b.e(8) == true) goto L122;
        wma.b.a.a("OCoachmarkView", "Primary action listener is set without primary action text.");
    L122:
        if (this.K == null) goto L128;
        if (r114 == true) goto L128;
        wma.a r31 = wma.b.a;
        if (wma.b.e(8) == true) goto L128;
        wma.b.a.a("OCoachmarkView", "Secondary action listener is set without secondary action text.");
    L128:
        if (r114 == false) goto L134;
        if (r29 == true) goto L134;
        wma.a r32 = wma.b.a;
        if (wma.b.e(8) == true) goto L134;
        wma.b.a.a("OCoachmarkView", "Secondary action text is set without primary action text; secondary action will not render by itself.");
    L134:
        if (r114 == true) goto L136;
    L141:
        int r33 = b.b[this.w.ordinal()];
        if (r33 == 1) goto L158;
        if (r33 != 2) goto L145;
        if (r28 != null) goto L157;
        wma.a r34 = wma.b.a;
        if (wma.b.e(8) == true) goto L166;
        wma.b.a.a("OCoachmarkView", "ActionStyle " + this.w + " is set without action text.");
    L166:
        View r35 = this.r;
        ViewGroup.LayoutParams r36 = r35.getLayoutParams();
        if (r36 == null) goto L185;
        ViewGroup.MarginLayoutParams r37 = (ViewGroup.MarginLayoutParams) r36;
        if (r13 == false) goto L171;
        int r38 = d.n(this, 8);
    L172:
        r37.topMargin = r38;
        r35.setLayoutParams(r37);
        if (this.y == ContentStyle.PILL) goto L175;
    L177:
        j.h(this.v, r4);
        goto L179
    L175:
        if (this.A == false) goto L177;
        r4 = true;
        goto L177
    L171:
        r38 = d.n(this, 12);
        goto L172
    L185:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L157:
        j.h(this.u, true);
        this.u.setText(r28);
        i();
        goto L166
    L145:
        if (r33 != 3) goto L166;
        if (r28 == null) goto L166;
        wma.a r39 = wma.b.a;
        if (wma.b.e(8) == true) goto L166;
        wma.b.a.a("OCoachmarkView", "action text is set while ActionStyle.NONE; action will stay hidden.");
        goto L166
    L158:
        if (r115 == false) goto L160;
        j.h(this.r, true);
        j.h(this.s, true);
        j.h(this.t, true);
        this.s.setText(this.F);
        this.t.setText(this.E);
        this.s.setOnClickListener(this.K);
        this.t.setOnClickListener(this.J);
        goto L166
    L160:
        if (r28 != null) goto L165;
        wma.a r40 = wma.b.a;
        if (wma.b.e(8) == true) goto L166;
        wma.b.a.a("OCoachmarkView", "ActionStyle " + this.w + " is set without action text.");
        goto L166
    L165:
        j.h(this.r, true);
        j.h(this.s, true);
        this.s.setText(r28);
        i();
        goto L166
    L136:
        if (this.w != ActionStyle.FILLED_BUTTON) goto L141;
        wma.a r41 = wma.b.a;
        if (wma.b.e(8) == true) goto L141;
        wma.b.a.a("OCoachmarkView", "Secondary action text is set with FILLED_BUTTON; filled coachmark renders only the primary action.");
        goto L141
    L102:
        if (g() == false) goto L113;
        CharSequence r116 = this.F;
        if (r116 != null) goto L106;
    L109:
        boolean r117 = true;
    L111:
        if ((!r117) == false) goto L113;
        r115 = true;
        goto L114
    L106:
        if (StringsKt.isBlank(r116) == true) goto L109;
        r117 = false;
        goto L111
    L95:
        if (StringsKt.isBlank(r112) == true) goto L98;
        r113 = false;
        goto L99
    L91:
        r28 = null;
        goto L92
    L71:
        if (StringsKt.isBlank(r23) == true) goto L74;
        r24 = false;
        goto L75
    L67:
        r22 = 0;
        goto L68
    L187:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L58:
        if (StringsKt.isBlank(r18) == true) goto L61;
        r19 = false;
        goto L62
    L54:
        r17 = 0;
        goto L55
    L189:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L48:
        this.n.setImageDrawable(null);
        goto L49
    L42:
        if (this.G == null) goto L44;
        r13 = true;
        goto L45
    L35:
        if (this.G == null) goto L40;
        wma.a r42 = wma.b.a;
        if (wma.b.e(8) == true) goto L40;
        wma.b.a.a("OCoachmarkView", "Hero image is set; cmIcon will be ignored.");
        goto L40
    L31:
        this.k.setImageDrawable(null);
        goto L33
    L27:
        r12 = false;
        goto L28
    L19:
        throw new NoWhenBranchMatchedException();
    L20:
        r10 = -2;
        goto L21
    L191:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }

    public final void onDetachedFromWindow() {
        View r0 = this.I;
        if (r0 == null) goto L9;
        ViewParent r1 = r0.getParent();
        ViewGroup r2 = this.l;
        if (r1 != r2) goto L8;
        r2.removeView(r0);
    L8:
        this.I = null;
    L9:
        super.onDetachedFromWindow();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e(TypedArray r5) {
        if (r5.hasValue(10) == false) goto L6;
        this.L = r5.getColor(10, this.L);
    L21:
        if (r5.hasValue(32) == false) goto L24;
        this.O = r5.getColorStateList(32);
    L24:
        if (r5.hasValue(19) == false) goto L27;
        this.P = r5.getColorStateList(19);
    L27:
        if (r5.hasValue(24) == false) goto L30;
        this.Q = r5.getColorStateList(24);
    L30:
        if (r5.hasValue(11) == false) goto L33;
        this.R = r5.getColorStateList(11);
    L33:
        if (r5.hasValue(7) == false) goto L36;
        this.S = r5.getColorStateList(7);
    L36:
        if (r5.hasValue(3) == false) goto L39;
        this.T = Integer.valueOf(r5.getColor(3, 0));
    L39:
        if (r5.hasValue(4) == false) goto L42;
        this.U = Integer.valueOf(r5.getColor(4, 0));
    L42:
        if (r5.hasValue(21) == false) goto L45;
        this.V = Integer.valueOf(r5.getColor(21, 0));
    L45:
        if (r5.hasValue(20) == false) goto L48;
        this.W = Integer.valueOf(r5.getColor(20, 0));
    L48:
        if (r5.hasValue(31) == false) goto L51;
        this.M = r5.getResourceId(31, 0);
    L51:
        if (r5.hasValue(18) == false) goto L54;
        this.N = r5.getResourceId(18, 0);
    L54:
        if (this.b1 == false) goto L57;
        this.b1 = r5.getBoolean(33, true);
    L57:
        if (this.b1 == false) goto L67;
        String r0 = r5.getString(34);
        if (r0 != null) goto L61;
        r0 = r5.getResources().getString(2131912847);
    L61:
        int r6 = this.L;
        if (r6 != 0) goto L64;
        boolean r7 = i.a(this);
    L65:
        this.g1 = MaterialToken.parseSet(r0, !r7);
        return;
    L64:
        r7 = h0.b(r6);
        goto L65
    L67:
        return;
    L6:
        if (r5.hasValue(0) == false) goto L21;
        Drawable r1 = r5.getDrawable(0);
        Integer r3 = null;
        if ((r1 instanceof ColorDrawable) == false) goto L10;
        ColorDrawable r2 = (ColorDrawable) r1;
    L11:
        if (r2 == null) goto L14;
        r3 = Integer.valueOf(r2.getColor());
    L14:
        if (r3 == null) goto L16;
        this.L = r3.intValue();
        goto L21
    L16:
        wma.a r4 = wma.b.a;
        if (wma.b.e(8) == true) goto L21;
        wma.b.a.a("OCoachmarkView", "android:background is not a color; ignored. Use cmBackgroundColor for color.");
        goto L21
    L10:
        r2 = null;
        goto L11
    }

    public final void setActionStyle(ActionStyle r2) {
        Intrinsics.checkNotNullParameter(r2, "style");
        if (this.w == r2) goto L6;
        this.w = r2;
        j();
        return;
    }

    public final void setActionText(CharSequence r1) {
        setPrimaryButtonText(r1);
    }

    public final void setArrowOffset(int r2) {
        if (this.B != r2) goto L5;
        return;
    L5:
        this.B = r2;
        h();
    }

    public final void setArrowPosition(ArrowPosition r2) {
        Intrinsics.checkNotNullParameter(r2, "position");
        if (this.x != r2) goto L5;
        return;
    L5:
        this.x = r2;
        h();
    }

    public final void setArrowVisible(boolean r2) {
        if (this.z != r2) goto L5;
        return;
    L5:
        this.z = r2;
        j.h(this.i, r2);
        h();
    }

    public void setBackgroundColor(int r2) {
        if (this.L == r2) goto L6;
        this.L = r2;
        d();
        return;
    }

    public final void setCloseVisible(boolean r1) {
        setShowCloseIcon(r1);
    }

    public final void setContentPadding(int r2) {
        this.V0 = true;
        this.p0 = r2;
        this.H0 = r2;
        this.L0 = r2;
        this.P0 = r2;
        j();
    }

    public final void setContentStyle(ContentStyle r2) {
        Intrinsics.checkNotNullParameter(r2, "style");
        if (this.y == r2) goto L6;
        this.y = r2;
        f();
        j();
        return;
    }

    public final void setCustomContentView$OUI_standardRelease(View r6) {
        Intrinsics.checkNotNullParameter(r6, "view");
        if (this.I != r6) goto L6;
        j();
        return;
    L6:
        ViewParent r0 = r6.getParent();
        if (r0 != null) goto L10;
    L24:
        boolean r1 = true;
    L25:
        if (r1 == true) goto L31;
        wma.a r7 = wma.b.a;
        if (wma.b.e(8) == true) goto L33;
        wma.b.a.a("OCoachmarkView", "custom content view ignored because it cannot be moved into coachmark content container.");
        return;
    L33:
        return;
    L31:
        this.l.removeAllViews();
        this.I = r6;
        this.l.addView(r6);
        j();
        return;
    L10:
        if (r0 == this.l) goto L24;
        if ((r0 instanceof ViewGroup) == true) goto L19;
        wma.a r3 = wma.b.a;
        if (wma.b.e(8) == true) goto L18;
        wma.b.a.a("OCoachmarkView", Intrinsics.stringPlus("custom content view has a non-ViewGroup parent: ", r0.getClass().getSimpleName()));
    L18:
        r1 = false;
        goto L25
    L19:
        wma.a r4 = wma.b.a;
        if (wma.b.e(8) == true) goto L23;
        wma.b.a.a("OCoachmarkView", "custom content view already has a parent; it will be moved into coachmark content container.");
    L23:
        ((ViewGroup) r0).removeView(r6);
        goto L24
    }

    public final void setDescTextAppearance(int r2) {
        if (this.N == r2) goto L6;
        this.N = r2;
        d();
        return;
    }

    public final void setDescription(CharSequence r1) {
        this.D = r1;
        j();
    }

    public final void setHeroImage(Drawable r1) {
        this.H = r1;
        j();
    }

    public final void setIcon(Drawable r1) {
        this.G = r1;
        j();
    }

    public final void setMaxWidth(int r2) {
        if (r2 > 0) goto L4;
        return;
    L4:
        if (this.k0 == r2) goto L8;
        this.k0 = r2;
        j();
        return;
    }

    public final void setOnActionClickListener(View.OnClickListener r1) {
        setOnPrimaryActionClickListener(r1);
    }

    public final void setOnCloseClickListener(View.OnClickListener r2) {
        this.v.setOnClickListener(r2);
    }

    public final void setOnPrimaryActionClickListener(View.OnClickListener r1) {
        this.J = r1;
        i();
    }

    public final void setOnSecondaryActionClickListener(View.OnClickListener r1) {
        this.K = r1;
        i();
    }

    public final void setPopWindowMode(boolean r2) {
        if (this.h1 == r2) goto L12;
        this.h1 = r2;
        if (this.b1 == true) goto L7;
        return;
    L7:
        if (this.g1 == null) goto L14;
        if (r2 == false) goto L10;
        OMaterialHelper.q(this.h, 3);
        OMaterialHelper.q(this.i, 3);
        return;
    L10:
        OMaterialHelper.q(this.h, 2);
        OMaterialHelper.q(this.i, 2);
        return;
    L14:
        return;
    }

    public final void setPrimaryButtonText(CharSequence r1) {
        this.E = r1;
        j();
    }

    public final void setSecondaryButtonText(CharSequence r1) {
        this.F = r1;
        j();
    }

    public final void setShowCloseIcon(boolean r2) {
        if (this.A == r2) goto L6;
        this.A = r2;
        f();
        j();
        return;
    }

    public final void setText(CharSequence r1) {
        this.D = r1;
        j();
    }

    public final void setTitle(CharSequence r1) {
        this.C = r1;
        j();
    }

    public final void setTitleTextAppearance(int r2) {
        if (this.M == r2) goto L6;
        this.M = r2;
        d();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OCoachmarkView(Context r10, AttributeSet r11, int r12, int r13) {
        ArrowPosition r1 = null;
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L9;
        r12 = 2130972955;
    L9:
        if ((r13 & 8) == 0) goto L11;
        int r14 = 2131953013;
    L12:
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, new o(r10, r11, r12, r14));
        c r3 = new c(this);
        this.w = ActionStyle.NONE;
        this.x = ArrowPosition.TOP;
        ContentStyle r4 = ContentStyle.PILL;
        this.y = r4;
        this.z = true;
        this.k0 = d.n(this, 320);
        this.p0 = d.n(this, 20);
        this.H0 = d.n(this, 8);
        this.L0 = d.n(this, 20);
        this.P0 = d.n(this, 8);
        if (p.b(this) == true) goto L15;
    L17:
        boolean r6 = false;
    L18:
        this.b1 = r6;
        LayoutInflater.from(r10).inflate(2131563760, this, true);
        setClipChildren(false);
        setClipToPadding(false);
        setChangeAlphaWhenPress(false);
        OUIFrameLayout r15 = findViewById(2131367062);
        this.h = r15;
        r15.setChangeAlphaWhenPress(false);
        ImageView r7 = (ImageView) findViewById(2131376114);
        this.i = r7;
        r7.setOutlineProvider(r3);
        this.j = findViewById(2131367066);
        this.k = (ImageView) findViewById(2131367068);
        this.l = (ViewGroup) findViewById(2131367064);
        this.m = findViewById(2131367070);
        this.n = (ImageView) findViewById(2131367069);
        OTextView r5 = findViewById(2131390322);
        this.o = r5;
        r5.getPaint().setSubpixelText(true);
        r5.setIncludeFontPadding(true);
        OTextView r8 = findViewById(2131390321);
        this.p = r8;
        r8.getPaint().setSubpixelText(true);
        r8.setIncludeFontPadding(true);
        this.q = findViewById(2131367072);
        this.r = findViewById(2131367061);
        this.s = (OButton) findViewById(2131364685);
        this.t = (OButton) findViewById(2131364686);
        this.u = (OButton) findViewById(2131364684);
        this.v = (OIconButton) findViewById(2131364687);
        this.L = getContext().getColor(2131104379);
        r15.setMinimumHeight(d.n(this, 48));
        r15.setBackgroundColor(this.L);
        r15.setOuterNormalColor(this.L);
        h();
        TypedArray r16 = getContext().obtainStyledAttributes(r11, new int[]{R.attr.background, R.attr.src, R.attr.text, 2130969520, 2130969521, 2130969522, 2130969523, 2130969524, 2130969525, 2130969526, 2130969527, 2130969528, 2130969529, 2130969530, 2130969531, 2130969532, 2130969533, 2130969534, 2130969535, 2130969536, 2130969537, 2130969538, 2130969539, 2130969540, 2130969541, 2130969542, 2130969543, 2130969544, 2130969545, 2130969546, 2130969547, 2130969548, 2130969549, 2130973374, 2130973383}, r12, r14);
        CharSequence r17 = r16.getText(2);     // Catch: Throwable -> L123
        if (r17 == null) goto L24;
        this.D = r17;     // Catch: Throwable -> L123
    L24:
        if (r16.hasValue(30) == false) goto L27;
        this.C = r16.getText(30);     // Catch: Throwable -> L123
    L27:
        if (r16.hasValue(23) == false) goto L30;
        this.G = r16.getDrawable(23);     // Catch: Throwable -> L123
    L30:
        if (r16.hasValue(22) == false) goto L32;
        Drawable r18 = r16.getDrawable(22);     // Catch: Throwable -> L123
    L33:
        if (r18 == null) goto L36;
        this.H = r18;     // Catch: Throwable -> L123
    L36:
        if (r16.hasValue(17) == false) goto L51;
        ContentStyle.a r19 = ContentStyle.Companion;     // Catch: Throwable -> L123
        int r110 = r16.getInt(17, r4.getValue());     // Catch: Throwable -> L123
        r19.getClass();     // Catch: Throwable -> L123
        ContentStyle[] r111 = ContentStyle.values();     // Catch: Throwable -> L123
        int r112 = r111.length;     // Catch: Throwable -> L123
        int r9 = 0;
    L38:
        if (r9 >= r112) goto L46;
        ContentStyle r20 = r111[r9];     // Catch: Throwable -> L123
        if (r20.getValue() != r110) goto L42;
        boolean r21 = true;
    L43:
        if (r21 == true) goto L47;
        r9 = r9 + 1;     // Catch: Throwable -> L123
    L47:
        if (r20 != null) goto L49;
        r20 = ContentStyle.PILL;     // Catch: Throwable -> L123
    L49:
        this.y = r20;     // Catch: Throwable -> L123
        goto L51
    L42:
        r21 = false;
        goto L43
    L46:
        r20 = null;
    L51:
        if (r16.hasValue(29) == false) goto L53;
        this.A = r16.getBoolean(29, false);     // Catch: Throwable -> L123
    L53:
        f();     // Catch: Throwable -> L123
        if (r16.hasValue(6) == false) goto L56;
        this.E = r16.getText(6);     // Catch: Throwable -> L123
        boolean r113 = true;
    L58:
        if (r16.hasValue(26) == false) goto L61;
        this.E = r16.getText(26);     // Catch: Throwable -> L123
        r113 = true;
    L61:
        if (r16.hasValue(27) == false) goto L64;
        this.F = r16.getText(27);     // Catch: Throwable -> L123
        r113 = true;
    L64:
        if (r16.hasValue(5) == false) goto L78;
        int r114 = r16.getInt(5, ActionStyle.NONE.getValue());     // Catch: Throwable -> L123
        ActionStyle.Companion.getClass();     // Catch: Throwable -> L123
        ActionStyle[] r115 = ActionStyle.values();     // Catch: Throwable -> L123
        int r22 = r115.length;     // Catch: Throwable -> L123
        int r23 = 0;
    L66:
        if (r23 >= r22) goto L74;
        ActionStyle r24 = r115[r23];     // Catch: Throwable -> L123
        if (r24.getValue() != r114) goto L70;
        boolean r25 = true;
    L71:
        if (r25 == true) goto L75;
        r23 = r23 + 1;     // Catch: Throwable -> L123
    L75:
        if (r24 != null) goto L77;
        r24 = ActionStyle.NONE;     // Catch: Throwable -> L123
    L77:
        this.w = r24;     // Catch: Throwable -> L123
        boolean r116 = true;
    L79:
        e(r16);     // Catch: Throwable -> L123
        if (r16.hasValue(25) == false) goto L83;
        this.k0 = r16.getDimensionPixelSize(25, this.k0);     // Catch: Throwable -> L123
    L83:
        if (r16.hasValue(12) == false) goto L85;
        int r117 = r16.getDimensionPixelSize(12, this.p0);     // Catch: Throwable -> L123
        this.p0 = r117;     // Catch: Throwable -> L123
        this.H0 = r117;     // Catch: Throwable -> L123
        this.L0 = r117;     // Catch: Throwable -> L123
        this.P0 = r117;     // Catch: Throwable -> L123
        boolean r118 = true;
    L87:
        if (r16.hasValue(15) == false) goto L90;
        this.p0 = r16.getDimensionPixelSize(15, this.p0);     // Catch: Throwable -> L123
        r118 = true;
    L90:
        if (r16.hasValue(16) == false) goto L93;
        this.H0 = r16.getDimensionPixelSize(16, this.H0);     // Catch: Throwable -> L123
        r118 = true;
    L93:
        if (r16.hasValue(14) == false) goto L96;
        this.L0 = r16.getDimensionPixelSize(14, this.L0);     // Catch: Throwable -> L123
        r118 = true;
    L96:
        if (r16.hasValue(13) == false) goto L98;
        this.P0 = r16.getDimensionPixelSize(13, this.P0);     // Catch: Throwable -> L123
        r118 = true;
    L98:
        if (r118 == false) goto L100;
        this.V0 = true;     // Catch: Throwable -> L123
    L100:
        boolean r119 = r16.getBoolean(28, true);     // Catch: Throwable -> L123
        this.z = r119;     // Catch: Throwable -> L123
        j.h(this.i, r119);     // Catch: Throwable -> L123
        ArrowPosition.a r120 = ArrowPosition.Companion;     // Catch: Throwable -> L123
        int r26 = r16.getInt(9, ArrowPosition.TOP.getValue());     // Catch: Throwable -> L123
        r120.getClass();     // Catch: Throwable -> L123
        ArrowPosition[] r121 = ArrowPosition.values();     // Catch: Throwable -> L123
        int r27 = r121.length;     // Catch: Throwable -> L123
        int r28 = 0;
    L101:
        if (r28 >= r27) goto L109;
        ArrowPosition r29 = r121[r28];     // Catch: Throwable -> L123
        if (r29.getValue() != r26) goto L105;
        boolean r30 = true;
    L106:
        if (r30 == true) goto L107;
        r28 = r28 + 1;     // Catch: Throwable -> L123
        goto L101
    L107:
        r1 = r29;
        goto L109
    L105:
        r30 = false;
    L109:
        if (r1 != null) goto L111;
        r1 = ArrowPosition.TOP;     // Catch: Throwable -> L123
    L111:
        this.x = r1;     // Catch: Throwable -> L123
        if (r16.hasValue(8) == false) goto L114;
        this.B = r16.getDimensionPixelSize(8, 0);     // Catch: Throwable -> L123
    L114:
        r16.recycle();
        if (r116 == true) goto L121;
        if (r113 == false) goto L121;
        wma.a r122 = wma.b.a;
        if (wma.b.e(8) == true) goto L121;
        wma.b.a.a("OCoachmarkView", "Action text is set without cmActionStyle; action will stay hidden.");
    L121:
        j();
        return;
    L85:
        r118 = false;
        goto L87
    L70:
        r25 = false;
        goto L71
    L74:
        r24 = null;
        goto L75
    L78:
        r116 = false;
        goto L79
    L56:
        r113 = false;
        goto L58
    L32:
        r18 = r16.getDrawable(1);     // Catch: Throwable -> L123
    L123:
        th = move-exception;
        r16.recycle();
        throw th;
    L15:
        if (OMaterialHelper.l() == false) goto L17;
        r6 = true;
        goto L18
    L11:
        r14 = 0;
        goto L12
    }
}
