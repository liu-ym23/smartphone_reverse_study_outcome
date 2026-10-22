package com.obric.oui.avatar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Space;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.obric.cae.BWDL.BwdlDrop.BwdlDropConstant;
import com.obric.cae.R;
import he.i;
import xd.h;

/* JADX INFO: loaded from: classes2.dex */
public final class OAvatar extends ConstraintLayout {
    public final OCircleImageView A;
    public final OCircleImageView B;
    public final AppCompatImageView C;
    public final Space D;
    public b E;
    public int F;

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ a[] f6163b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f6164a;

        static {
            f6163b = new a[]{new a("DP_16", 0, 16), new a("DP_20", 1, 20), new a("DP_24", 2, 24), new a("DP_32", 3, 32), new a("DP_40", 4, 40), new a("DP_48", 5, 48), new a("DP_56", 6, 56), new a("DP_64", 7, 64), new a("DP_72", 8, 72)};
        }

        public a(String r8, int r10, int r11) {
            super(r8, r10);
            this.f6164a = r11;
        }

        public static a valueOf(String r8) {
            return (a) Enum.valueOf(a.class, r8);
        }

        public static a[] values() {
            return (a[]) f6163b.clone();
        }
    }

    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f6165a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f6166b = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final /* synthetic */ b[] f6167m = null;

        static {
            b r8 = new b("ONLINE", 0);
            f6165a = r8;
            b r10 = new b("LOGO", 1);
            f6166b = r10;
            f6167m = new b[]{r8, r10};
        }

        public b(String r8, int r10) {
            super(r8, r10);
        }

        public static b valueOf(String r8) {
            return (b) Enum.valueOf(b.class, r8);
        }

        public static b[] values() {
            return (b[]) f6167m.clone();
        }
    }

    public OAvatar(Context r8, AttributeSet r10) {
        i.f(r8, "context");
        super(r8, r10);
        a[] r11 = a.f6163b;
        this.E = b.f6166b;
        this.F = -1;
        ViewGroup.inflate(r8, R.layout.o_widget_avatar, this);
        View r12 = findViewById(R.id.iv_avatar);
        i.e(r12, "findViewById(R.id.iv_avatar)");
        OCircleImageView r13 = (OCircleImageView) r12;
        this.A = r13;
        View r14 = findViewById(R.id.iv_icon);
        i.e(r14, "findViewById(R.id.iv_icon)");
        this.B = (OCircleImageView) r14;
        View r15 = findViewById(R.id.iv_bg);
        i.e(r15, "findViewById(R.id.iv_bg)");
        this.C = (AppCompatImageView) r15;
        View r16 = findViewById(R.id.spacer);
        i.e(r16, "findViewById(R.id.spacer)");
        this.D = (Space) r16;
        setClipChildren(false);
        Resources r17 = Resources.getSystem();
        i.e(r17, "Resources.getSystem()");
        r13.setBorderWidth(l6.a.I0(TypedValue.applyDimension(1, 1, r17.getDisplayMetrics())));
        Object r18 = androidx.core.content.a.f1674a;
        r13.setBorderColor(androidx.core.content.a.c.a(r8, R.color.LineReverse2));
    }

    public final AppCompatImageView getBackgroundImageView() {
        return this.C;
    }

    public final OCircleImageView getContentImageView() {
        return this.A;
    }

    public final OCircleImageView getLogoImageView() {
        return this.B;
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
    public final void s(int r8, int r10, int r11, int r12) {
        Space r13 = this.D;
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
        if (r14 == null) goto L11;
        ConstraintLayout.a r15 = (ConstraintLayout.a) r14;
        ((ViewGroup.MarginLayoutParams) r15).rightMargin = r8;
        ((ViewGroup.MarginLayoutParams) r15).bottomMargin = r10;
        r13.setLayoutParams(r15);
        setAvatarInset(1);
        OCircleImageView r16 = this.B;
        r16.setContentPadding(0);
        r16.setBorderWidth(r11);
        r16.setBorderColor(this.F);
        ViewGroup.LayoutParams r17 = r16.getLayoutParams();
        if (r17 == null) goto L9;
        ConstraintLayout.a r18 = (ConstraintLayout.a) r17;
        int r19 = (r11 * 2) + r12;
        ((ViewGroup.MarginLayoutParams) r18).width = r19;
        ((ViewGroup.MarginLayoutParams) r18).height = r19;
        r16.setLayoutParams(r18);
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L11:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    public final void setAvatar(int r8) {
        this.A.setImageResource(r8);
    }

    public final void setAvatarInset(int r8) {
        OCircleImageView r10 = this.A;
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        if (r11 == null) goto L7;
        ConstraintLayout.a r12 = (ConstraintLayout.a) r11;
        r12.setMargins(r8, r8, r8, r8);
        r10.setLayoutParams(r12);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    public final void setAvatarSize(a r13) {
        i.f(r13, BwdlDropConstant.FILE_SIZE);
        ViewGroup.LayoutParams r8 = getLayoutParams();
        if (r8 == null) goto L38;
        int r10 = r13.f6164a;
        r8.width = android.aimedia.a.a("Resources.getSystem()", 1, r10);
        r8.height = android.aimedia.a.a("Resources.getSystem()", 1, r10);
        setLayoutParams(r8);
        OCircleImageView r11 = this.B;
        if (r11.isShown() == true) goto L7;
        return;
    L7:
        if (r11.getDrawable() == null) goto L40;
        b r12 = this.E;
        float r14 = 0.0f;
        float r15 = 2.0f;
        float r16 = 10.0f;
        if (r12 != b.f6165a) goto L24;
        float r17 = 8.0f;
        switch(r13.ordinal()) {
            case 2: goto L21;
            case 3: goto L19;
            case 4: goto L18;
            case 5: goto L16;
            case 6: goto L16;
            case 7: goto L14;
            case 8: goto L13;
            default: goto L12;
        };
    L12:
        r17 = 0.0f;
        r15 = 0.0f;
    L22:
        int r18 = android.aimedia.a.a("Resources.getSystem()", 1, r14);
        int r19 = android.aimedia.a.a("Resources.getSystem()", 1, r14);
        int r20 = android.aimedia.a.a("Resources.getSystem()", 1, r15);
        Resources r21 = Resources.getSystem();
        i.e(r21, "Resources.getSystem()");
        s(r18, r19, r20, l6.a.I0(TypedValue.applyDimension(1, r17, r21.getDisplayMetrics())));
        return;
    L13:
        float r110 = ((2 * 2.0f) + 12.0f) + 2.0f;
    L15:
        r16 = 12.0f;
    L17:
        r14 = r110;
        r17 = r16;
        goto L22
    L14:
        r110 = ((2 * 2.0f) + 12.0f) + 1.0f;
        goto L15
    L16:
        r110 = ((2 * 2.0f) + 10.0f) + 0.5f;
        goto L17
    L18:
        float r111 = ((2 * 1.5f) + 8.0f) + 0.5f;
    L20:
        r14 = r111;
        r15 = 1.5f;
        goto L22
    L19:
        r111 = ((2 * 1.5f) + 8.0f) - 0.5f;
        goto L20
    L21:
        r17 = 6.0f;
        r14 = ((2 * 1.0f) + 6.0f) - 1;
        r15 = 1.0f;
        goto L22
    L24:
        if (r12 != b.f6166b) goto L42;
        float r22 = 16.0f;
        switch(r13.ordinal()) {
            case 2: goto L34;
            case 3: goto L33;
            case 4: goto L33;
            case 5: goto L32;
            case 6: goto L31;
            case 7: goto L28;
            case 8: goto L28;
            default: goto L27;
        };
    L27:
        float r23 = 0.0f;
        r15 = 0.0f;
        r16 = 0.0f;
    L35:
        int r112 = android.aimedia.a.a("Resources.getSystem()", 1, r14);
        int r24 = android.aimedia.a.a("Resources.getSystem()", 1, r23);
        int r25 = android.aimedia.a.a("Resources.getSystem()", 1, r15);
        Resources r26 = Resources.getSystem();
        i.e(r26, "Resources.getSystem()");
        s(r112, r24, r25, l6.a.I0(TypedValue.applyDimension(1, r16, r26.getDisplayMetrics())));
        return;
    L28:
        float r113 = 2 * 2.0f;
        r22 = 20.0f;
    L29:
        float r114 = r113 + r22;
        float r27 = r114 - 2.0f;
        float r115 = r114 - 4.0f;
    L30:
        r16 = r22;
        r23 = r27;
        r14 = r115;
        goto L35
    L31:
        r113 = 2 * 2.0f;
        goto L29
    L32:
        float r116 = (2 * 1.5f) + 16.0f;
        r27 = r116 - 1.5f;
        r115 = r116 - 3.5f;
        r15 = 1.5f;
        goto L30
    L33:
        float r117 = (2 * 1.5f) + 12.0f;
        r23 = r117 - 1.5f;
        r14 = r117 - 3.5f;
        r15 = 1.5f;
        r16 = 12.0f;
        goto L35
    L34:
        float r118 = (2 * 1.0f) + 10.0f;
        r23 = r118 - 1.0f;
        r14 = r118 - 3.0f;
        r15 = 1.0f;
        goto L35
    L42:
        return;
    L40:
        return;
    L38:
        throw new h("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public final void setIconBorderColor(int r8) {
        this.F = r8;
    }

    public final void setIconType(b r8) {
        i.f(r8, "iconType");
        this.E = r8;
    }

    public final void setAvatar(Bitmap r8) {
        i.f(r8, "bitmap");
        this.A.setImageBitmap(r8);
    }

    public final void setAvatar(Drawable r8) {
        this.A.setImageDrawable(r8);
    }
}
