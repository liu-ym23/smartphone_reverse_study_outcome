package com.obric.oui.avatar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Space;
import androidx.annotation.ColorInt;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.lynx.tasm.utils.a;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002&'B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\n2\b\b\u0001\u0010\u0011\u001a\u00020\r¢\u0006\u0004\b\u0012\u0010\u0010J\u0015\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0015\u001a\u00020\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0015\u0010\u0019J\u0015\u0010\u0015\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\r¢\u0006\u0004\b\u0015\u0010\u0010J\u0015\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010 \u001a\u00020\u001f¢\u0006\u0004\b \u0010!J\r\u0010#\u001a\u00020\"¢\u0006\u0004\b#\u0010$J\r\u0010%\u001a\u00020\u001f¢\u0006\u0004\b%\u0010!¨\u0006("}, d2 = {"Lcom/obric/oui/avatar/OAvatar;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Lcom/obric/oui/avatar/OAvatar$AvatarSize;", "size", "", "setAvatarSize", "(Lcom/obric/oui/avatar/OAvatar$AvatarSize;)V", "", "inset", "setAvatarInset", "(I)V", "color", "setIconBorderColor", "Landroid/graphics/Bitmap;", "bitmap", "setAvatar", "(Landroid/graphics/Bitmap;)V", "Landroid/graphics/drawable/Drawable;", "drawable", "(Landroid/graphics/drawable/Drawable;)V", "resId", "Lcom/obric/oui/avatar/OAvatar$IconType;", "iconType", "setIconType", "(Lcom/obric/oui/avatar/OAvatar$IconType;)V", "Lcom/obric/oui/avatar/OCircleImageView;", "getContentImageView", "()Lcom/obric/oui/avatar/OCircleImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "getBackgroundImageView", "()Landroidx/appcompat/widget/AppCompatImageView;", "getLogoImageView", "AvatarSize", "IconType", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OAvatar extends ConstraintLayout {
    public final OCircleImageView g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final OCircleImageView f11947h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AppCompatImageView f11948i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Space f11949j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public IconType f11950k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f11951l;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/obric/oui/avatar/OAvatar$AvatarSize;", "", "", "dpValue", "I", "getDpValue", "()I", "DP_16", "DP_20", "DP_24", "DP_32", "DP_40", "DP_48", "DP_56", "DP_64", "DP_72", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum AvatarSize extends Enum<AvatarSize> {
        public static final AvatarSize DP_16 = null;
        public static final AvatarSize DP_20 = null;
        public static final AvatarSize DP_24 = null;
        public static final AvatarSize DP_32 = null;
        public static final AvatarSize DP_40 = null;
        public static final AvatarSize DP_48 = null;
        public static final AvatarSize DP_56 = null;
        public static final AvatarSize DP_64 = null;
        public static final AvatarSize DP_72 = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AvatarSize[] f11952a = null;
        private final int dpValue;

        static {
            AvatarSize r5 = new AvatarSize("DP_16", 0, 16);
            DP_16 = r5;
            AvatarSize r10 = new AvatarSize("DP_20", 1, 20);
            DP_20 = r10;
            AvatarSize r11 = new AvatarSize("DP_24", 2, 24);
            DP_24 = r11;
            AvatarSize r12 = new AvatarSize("DP_32", 3, 32);
            DP_32 = r12;
            AvatarSize r13 = new AvatarSize("DP_40", 4, 40);
            DP_40 = r13;
            AvatarSize r14 = new AvatarSize("DP_48", 5, 48);
            DP_48 = r14;
            AvatarSize r15 = new AvatarSize("DP_56", 6, 56);
            DP_56 = r15;
            AvatarSize r16 = new AvatarSize("DP_64", 7, 64);
            DP_64 = r16;
            AvatarSize r17 = new AvatarSize("DP_72", 8, 72);
            DP_72 = r17;
            f11952a = new AvatarSize[]{r5, r10, r11, r12, r13, r14, r15, r16, r17};
        }

        public AvatarSize(String r5, int r10, int r11) {
            super(r5, r10);
            this.dpValue = r11;
        }

        public static AvatarSize valueOf(String r5) {
            return (AvatarSize) Enum.valueOf(AvatarSize.class, r5);
        }

        public static AvatarSize[] values() {
            return (AvatarSize[]) f11952a.clone();
        }

        public final int getDpValue() {
            return this.dpValue;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/oui/avatar/OAvatar$IconType;", "", "ONLINE", "LOGO", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum IconType extends Enum<IconType> {
        public static final IconType LOGO = null;
        public static final IconType ONLINE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ IconType[] f11953a = null;

        static {
            IconType r5 = new IconType("ONLINE", 0);
            ONLINE = r5;
            IconType r10 = new IconType("LOGO", 1);
            LOGO = r10;
            f11953a = new IconType[]{r5, r10};
        }

        public static IconType valueOf(String r5) {
            return (IconType) Enum.valueOf(IconType.class, r5);
        }

        public static IconType[] values() {
            return (IconType[]) f11953a.clone();
        }
    }

    @JvmOverloads
    public OAvatar(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, null);
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
    public final void e(int r5, int r10, int r11, int r12) {
        Space r13 = this.f11949j;
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
        if (r14 == null) goto L11;
        ConstraintLayout.LayoutParams r15 = (ConstraintLayout.LayoutParams) r14;
        ((ViewGroup.MarginLayoutParams) r15).rightMargin = r5;
        ((ViewGroup.MarginLayoutParams) r15).bottomMargin = r10;
        r13.setLayoutParams(r15);
        setAvatarInset(1);
        OCircleImageView r16 = this.f11947h;
        r16.setContentPadding(0);
        r16.setBorderWidth(r11);
        r16.setBorderColor(this.f11951l);
        ViewGroup.LayoutParams r17 = r16.getLayoutParams();
        if (r17 == null) goto L9;
        ConstraintLayout.LayoutParams r18 = (ConstraintLayout.LayoutParams) r17;
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

    public final AppCompatImageView getBackgroundImageView() {
        return this.f11948i;
    }

    public final OCircleImageView getContentImageView() {
        return this.g;
    }

    public final OCircleImageView getLogoImageView() {
        return this.f11947h;
    }

    public final void setAvatar(Bitmap r5) {
        Intrinsics.checkNotNullParameter(r5, "bitmap");
        this.g.setImageBitmap(r5);
    }

    public final void setAvatarInset(int r5) {
        OCircleImageView r10 = this.g;
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        if (r11 == null) goto L7;
        ConstraintLayout.LayoutParams r12 = (ConstraintLayout.LayoutParams) r11;
        r12.setMargins(r5, r5, r5, r5);
        r10.setLayoutParams(r12);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    public final void setAvatarSize(AvatarSize r13) {
        Intrinsics.checkNotNullParameter(r13, "size");
        ViewGroup.LayoutParams r5 = getLayoutParams();
        if (r5 == null) goto L37;
        r5.width = a.B(r13.getDpValue(), this);
        r5.height = a.B(r13.getDpValue(), this);
        setLayoutParams(r5);
        OCircleImageView r10 = this.f11947h;
        if (r10.isShown() == true) goto L7;
        return;
    L7:
        if (r10.getDrawable() == null) goto L39;
        IconType r11 = this.f11950k;
        float r12 = 0.0f;
        float r14 = 2.0f;
        if (r11 != IconType.ONLINE) goto L23;
        float r15 = 8.0f;
        switch(vq.a.f22649a[r13.ordinal()]) {
            case 1: goto L20;
            case 2: goto L19;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L16;
            case 6: goto L15;
            case 7: goto L13;
            default: goto L12;
        };
    L12:
        r15 = 0.0f;
        r14 = 0.0f;
    L21:
        e(a.A(r12, this), a.A(r12, this), a.A(r14, this), a.A(r15, this));
        return;
    L13:
        r12 = ((2 * 2.0f) + 12.0f) + 2.0f;
    L14:
        r15 = 12.0f;
        goto L21
    L15:
        r12 = ((2 * 2.0f) + 12.0f) + 1.0f;
        goto L14
    L16:
        r12 = ((2 * 2.0f) + 10.0f) + 0.5f;
        r15 = 10.0f;
        goto L21
    L17:
        r12 = ((2 * 1.5f) + 8.0f) + 0.5f;
    L18:
        r14 = 1.5f;
        goto L21
    L19:
        r12 = ((2 * 1.5f) + 8.0f) - 0.5f;
        goto L18
    L20:
        r15 = 6.0f;
        r14 = 1.0f;
        r12 = ((2 * 1.0f) + 6.0f) - 1;
        goto L21
    L23:
        if (r11 != IconType.LOGO) goto L41;
        float r16 = 16.0f;
        switch(vq.a.f22649a[r13.ordinal()]) {
            case 1: goto L33;
            case 2: goto L32;
            case 3: goto L32;
            case 4: goto L30;
            case 5: goto L29;
            case 6: goto L27;
            case 7: goto L27;
            default: goto L26;
        };
    L26:
        float r17 = 0.0f;
        r16 = 0.0f;
        r14 = 0.0f;
    L34:
        e(a.A(r12, this), a.A(r17, this), a.A(r14, this), a.A(r16, this));
        return;
    L27:
        float r18 = (2 * 2.0f) + 20.0f;
        float r19 = r18 - 2.0f;
        float r110 = r18 - 4.0f;
        r16 = 20.0f;
    L28:
        float r111 = r19;
        r12 = r110;
        r17 = r111;
        goto L34
    L29:
        float r112 = (2 * 2.0f) + 16.0f;
        r19 = r112 - 2.0f;
        r110 = r112 - 4.0f;
        goto L28
    L30:
        float r113 = (2 * 1.5f) + 16.0f;
        r19 = r113 - 1.5f;
        r110 = r113 - 3.5f;
    L31:
        r14 = 1.5f;
        goto L28
    L32:
        float r114 = (2 * 1.5f) + 12.0f;
        r19 = r114 - 1.5f;
        r110 = r114 - 3.5f;
        r16 = 12.0f;
        goto L31
    L33:
        float r115 = (2 * 1.0f) + 10.0f;
        r19 = r115 - 1.0f;
        r110 = r115 - 3.0f;
        r14 = 1.0f;
        r16 = 10.0f;
        goto L28
    L41:
        return;
    L39:
        return;
    L37:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public final void setIconBorderColor(@ColorInt int r5) {
        this.f11951l = r5;
    }

    public final void setIconType(IconType r5) {
        Intrinsics.checkNotNullParameter(r5, "iconType");
        this.f11950k = r5;
    }

    @JvmOverloads
    public OAvatar(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10);
        this.f11950k = IconType.LOGO;
        this.f11951l = -1;
        View.inflate(r5, R$layout.o_widget_avatar, this);
        OCircleImageView r11 = (OCircleImageView) findViewById(R$id.iv_avatar);
        this.g = r11;
        this.f11947h = (OCircleImageView) findViewById(R$id.iv_icon);
        this.f11948i = (AppCompatImageView) findViewById(R$id.iv_bg);
        this.f11949j = (Space) findViewById(R$id.spacer);
        setClipChildren(false);
        r11.setBorderWidth(a.B(1, this));
        r11.setBorderColor(ContextCompat.getColor(r5, R$color.LineReverse2));
    }

    public final void setAvatar(Drawable r5) {
        this.g.setImageDrawable(r5);
    }

    public final void setAvatar(int r5) {
        this.g.setImageResource(r5);
    }
}
